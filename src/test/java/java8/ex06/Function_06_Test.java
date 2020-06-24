package java8.ex06;

import java.util.function.Supplier;

import org.junit.Test;

import java8.data.Person;

/**
 * Exercice 06 - java.util.function.Supplier
 */
public class Function_06_Test {

	// tag::formatAge[]
	/**
	 * Retourner l'âge d'une personne depuis un Supplier
	 * 
	 * @param supplier
	 * @return String
	 */
	String formatAge(Supplier<Person> supplier) {
		Person person = supplier.get();
		return "[age=" + person.getAge() + "]";
	}
	// end::formatAge[]

	@Test
	public void test_supplier_formatAge() throws Exception {

		// Création d'une personne
		Supplier<Person> supplierPerson = () -> new Person("Jules", "France", 35, "pass");
		String result = formatAge(supplierPerson);
		// âge de 35 ans attendu
		assert result.equals("[age=35]");
	}

}
