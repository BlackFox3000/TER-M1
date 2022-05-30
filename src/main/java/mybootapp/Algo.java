package mybootapp;

import lombok.Data;
import mybootapp.model.Assignment;
import mybootapp.model.Repository;
import mybootapp.model.Subject;
import mybootapp.model.Work;
import mybootapp.model.status.StatusA;
import mybootapp.model.status.StatusR;
import mybootapp.model.status.StatusW;
import mybootapp.model.user.Teacher;

import java.util.ArrayList;
import java.util.Objects;

@Data
public class Algo {

    /*
    Fonction assignant à chaque travail dans le dépôt 2 professeurs dont 1 ayant au moins un sujet de compétence
    similaire au sujet et un aucune sachant que les deux professeurs n'ont pas créé le dépôt eux-mêmes
    Chaque professeur pourra avoir seulement 3 travaux à corriger simultanément
    */

    public void assignementFromRepository(Repository repo, ArrayList<Teacher> teachers){
        if(repo.getStatusR() == StatusR.CLOSED){ //si le dépôt n'a pas encore été clotûré sinon la fonction ne fait rien

            for(Work work : repo.getWorks()){ //on parcours tous les travaux du dépôt

                if(work.getStatusW() != StatusW.ASSIGNED){//on vérifie si le travail n'est pas déjà attribué

                    ArrayList<Teacher> teachersOnSubject = new ArrayList<>(); //profs ayant au moins un sujet similaire
                    ArrayList<Teacher> teachersOffSubject = new ArrayList<>(); //profs n'ayant aucun sujet similaire

                    for(Teacher teacher : teachers){ //on parcours tous les profs...
                        boolean accepted = true;

                        for(Teacher refusedWork : work.getCanceledTeachers()){//on parcourt les professeurs ayant refusé le travail pour ne pas assigner à nouveau un ayant refusé

                            if (Objects.equals(refusedWork.getId(), teacher.getId())) {
                                accepted = false;
                                break;
                            }
                        }

                        if(accepted && !Objects.equals(repo.getTeacherOwner().getId(), teacher.getId()) && teacher.getSupportedWorks().size() < 3){ //... sans prendre celui qui a créé le dépôt et ceux qui ont déjà 3 trvaux en cours
                            boolean match = false;

                            for(Subject subjectWork : work.getSubjects()){ //on cherche si le sujet correspond à celui d'un prof

                                for(Subject subjectTeacher : teacher.getSubjects()){

                                    if(subjectWork.getName().equals(subjectTeacher.getName())){ //alors on ajoute le prof dans la liste correspondante
                                        match = true;
                                        teachersOnSubject.add(teacher);
                                        break; //on sort de la boucle pour ne pas ajouter un même prof deux fois
                                    }
                                }
                            }
                            if(!match) //sinon on l'ajoute dans l'autre liste
                                teachersOffSubject.add(teacher);
                        }
                    }

                    Teacher choosedOn; //le prof qui sera affecté ayant un sujet en commun
                    Teacher choosedOff; //le prof qui sera affecté n'ayant pas de sujet en commun

                    if(teachersOnSubject.size() > 0){ //seulement si on a au moins 1 prof
                        int randOn = (int) (Math.random() * teachersOnSubject.size()); //nbre aléatoire parmis la liste de profs
                        choosedOn = teachersOnSubject.get(randOn); //prof aléatoire parmis les profs répondants aux critères
                    }
                    else{
                        System.out.println("Pas de professeur ayant au moins un domaine de compétence lié au travail");
                        return;
                    }

                    if(teachersOffSubject.size() > 0){ //seulement si on a au moins 1 prof
                        int randOff = (int) (Math.random() * teachersOffSubject.size()); //nbre aléatoire parmis la liste de profs
                        choosedOff = teachersOffSubject.get(randOff); //prof aléatoire parmis les profs répondants aux critères
                    }
                    else{
                        System.out.println("Pas de professeur ayant un domaine de compétence différent de celui du travail");
                        return;
                    }

                    for(Teacher teacher : teachers){ //on parcourt de nouveau les profs pour affecter le trvail à ceux selectionné

                        if(Objects.equals(teacher.getId(), choosedOn.getId()) || Objects.equals(teacher.getId(), choosedOff.getId())){
                            teacher.getSupportedWorks().add(work); //ajout du travail à corriger au bon professeur
                            work.setStatusW(StatusW.ASSIGNED); //le travail est considéré comme pris en charge
                        }
                    }

                }

            }

        }
        else{
            System.out.println("Le dépôt a déjà été clôturé");
        }
    }

}
