package pl.najavie.person;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pl.najavie.functions.PersonSupplier;
import pl.najavie.models.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by krzysztof on 1/4/15.
 */
public class PersonTest {

    private static Stream<Person> personStream = Stream.generate(PersonSupplier.INSTANCE);
    private static List<Person> persons = new ArrayList<Person>();
    private static Person person;

    @Given("^I have a Stream with person supplier initialized$")
    public void i_have_a_Stream_with_person_supplier_initialized() throws Throwable {
        assertTrue(personStream!=null);
    }

    @When("^I call stream to create a list of (\\d+) persons$")
    public void i_call_stream_to_create_a_list_of_persons(int arg1) throws Throwable {
        persons = personStream.limit(arg1).collect(Collectors.toList());
    }

    @Then("^I have list with (\\d+) persons$")
    public void i_have_list_with_persons(int arg1) throws Throwable {
        assertEquals(persons.size(), arg1);
    }

    @Given("^I have a list of users:$")
    public void i_have_a_list_of_users(List<Person> arg1) throws Throwable {
        persons = new ArrayList<Person>();
        persons.addAll(arg1);
    }

    @When("^I get first user$")
    public void i_get_first_user() throws Throwable {
        person = persons.get(0);
    }

    @Then("^I get:$")
    public void i_get(List<Person> arg1) throws Throwable {
        assertTrue(person.equals(arg1.get(0)));
    }

    @When("^I add new user with name \"(.*?)\" and lastName \"(.*?)\"$")
    public void i_add_new_user_with_name_and_lastName(String name, String lastName) throws Throwable {
        person = new Person(name,lastName);
        persons.add(person);
    }
}
