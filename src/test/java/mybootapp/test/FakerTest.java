package mybootapp.test;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import mybootapp.Starter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ContextConfiguration(classes = Starter.class)
public class FakerTest {

    @Test
    public void whenBothifyCalled_checkPatternMatches() {

        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

        String email = fakeValuesService.bothify("????##@gmail.com");
        Matcher emailMatcher = Pattern.compile("\\w{4}\\d{2}@gmail.com").matcher(email);

        assertTrue(emailMatcher.find());
    }

    @Test
    public void givenValidService_whenRegexifyCalled_checkPattern() {

        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

        String alphaNumericString = fakeValuesService.regexify("[a-z1-9]{10}");
        Matcher alphaNumericMatcher = Pattern.compile("[a-z1-9]{10}").matcher(alphaNumericString);

        assertTrue(alphaNumericMatcher.find());
    }

    @Test
    public void givenJavaFakersWithDifferentLocals_thenHeckZipCodesMatchRegex() {

        Faker ukFaker = new Faker(new Locale("en-GB"));
        Faker usFaker = new Faker(new Locale("en-US"));

        System.out.printf("American zipcode: %s%n", usFaker.address().zipCode());
        System.out.printf("British postcode: %s%n", ukFaker.address().zipCode());

        Pattern ukPattern = Pattern.compile(
                "([Gg][Ii][Rr] 0[Aa]{2})|((([A-Za-z][0-9]{1,2})|"
                        + "(([A-Za-z][A-Ha-hJ-Yj-y][0-9]{1,2})|(([A-Za-z][0-9][A-Za-z])|([A-Za-z][A-Ha-hJ-Yj-y]"
                        + "[0-9]?[A-Za-z]))))\\s?[0-9][A-Za-z]{2})");
        Matcher ukMatcher = ukPattern.matcher(ukFaker.address().zipCode());

        assertTrue(ukMatcher.find());

        Matcher usMatcher = Pattern.compile("^\\d{5}(?:[-\\s]\\d{4})?$")
                .matcher(usFaker.address().zipCode());

        assertTrue(usMatcher.find());
    }

    @Test
    public void givenJavaFakersWithSameSeed_whenNameCalled_CheckSameName() {

        Faker faker1 = new Faker(new Random(24));
        Faker faker2 = new Faker(new Random(24));

        assertEquals(faker1.name().firstName(), faker2.name().firstName());
    }

}
