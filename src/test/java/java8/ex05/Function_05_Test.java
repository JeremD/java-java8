package java8.ex05;

import java8.data.Data;
import java8.data.Person;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.function.Consumer;

/**
 * Exercice 5 - java.util.function.Consumer
 */
public class Function_05_Test {

	// tag::functions[]
	// modifification du mot de passe en "secret"
	Consumer<Person> changePasswordToSecret = pwd -> pwd.setPassword("secret");

	// vérification de l'âge > 4 avec une assertion JUnit
	Consumer<Person> verifyAge = age -> assertTrue(age.getAge() > 4);

	// vérification du mot de passe en "secret" avec une assertion JUnit
	Consumer<Person> verifyPassword = pwd -> assertTrue(pwd.getPassword() == "secret");
	// end::functions[]

	@Test
	public void test_consumer() throws Exception {
		List<Person> personList = Data.buildPersonList();

		// Invocation de personList.forEach pour modifier tous les mots de passe
		personList.forEach(changePasswordToSecret);

		// Vérification de l'âge puis du mot de passe
		personList.forEach(verifyAge.andThen(verifyPassword));
	}
}
