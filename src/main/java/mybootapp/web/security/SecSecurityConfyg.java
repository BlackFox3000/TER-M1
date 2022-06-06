//package mybootapp.web.security;
//
//import mybootapp.model.XUser;
//import mybootapp.repo.XUserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import javax.annotation.PostConstruct;
//import java.util.Set;
//
//@Configuration
//@EnableWebSecurity
//public class SecSecurityConfyg extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    UserDetailsService myUserDetailsService;
//
//    @Bean
//    public DaoAuthenticationProvider authProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(myUserDetailsService);
//        authProvider.setPasswordEncoder(passwordEncoder());
//        return authProvider;
//    }
//
//    @Override
//    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//        System.out.println("secSecurity configurer 1");
//        auth.authenticationProvider(authProvider());
////        auth.inMemoryAuthentication()
////                .withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("USER")
////                .and()
////                .withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
////                .and()
////                .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
//    }
//
//    @Override
//    protected void configure(final HttpSecurity http) throws Exception {
//        System.out.println("secSecurityeConfig configure 2");
//        // http builder configurations for authorize requests and form login (see below)
//        http
//                // -- ne pas activer la protection CSRF
//                .csrf().disable()
//                //limitation des accès en fonction du ROLE
//                .authorizeRequests()
//                    .antMatchers("/admin/**").hasRole("ADMIN")
//                    .antMatchers("/teacher/**").hasRole("TEACHER")
//                    .antMatchers("/student/**").hasRole("STUDENT")
//                    .antMatchers("/","/login*","/connect").permitAll()
//                    .anyRequest().authenticated()
//                .and()
//
//                .formLogin()
//                    .loginPage("/") // la page de connexion personnalisée
//                    .loginProcessingUrl("/connect") // l'URL à laquelle soumettre le nom d'utilisateur et le mot de passe
//                    .defaultSuccessUrl("/succeslogin", true) // la page de destination après une connexion réussie
//                    .failureUrl("/?error=true") // la page de destination après une connexion infructueuse
//                    //.failureHandler(authenticationFailureHandler())
//                .and()
//
//                .logout() //
//                .logoutUrl("/perform_logout") // la déconnexion personnalisée
//                .deleteCookies("JSESSIONID");
//              //  .logoutSuccessHandler(logoutSuccessHandler());
//    }
//
//    @Autowired
//    XUserRepository userRepo;
//
//    @PostConstruct
//    public void init() {
//        var encoder = passwordEncoder();
//        var aa = new XUser("aaa", encoder.encode("aaa"), Set.of("ADMIN", "USER"));
//        var bb = new XUser("bbb", encoder.encode("bbb"), Set.of("USER"));
//        userRepo.save(aa);
//        userRepo.save(bb);
//        System.out.println("--- INIT SPRING SECURITY");
//    }
//
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
