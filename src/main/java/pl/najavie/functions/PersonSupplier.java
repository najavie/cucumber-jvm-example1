package pl.najavie.functions;

import org.apache.commons.lang.RandomStringUtils;
import pl.najavie.models.Person;

import java.util.function.Supplier;

/**
 * Created by krzysztof on 1/4/15.
 */
public class PersonSupplier implements Supplier<Person> {

    public static final PersonSupplier INSTANCE = new PersonSupplier();

    private PersonSupplier() {

    }

    @Override
    public Person get() {
        return new Person(RandomStringUtils.randomAlphabetic(10),RandomStringUtils.randomAlphabetic(10));
    }
}
