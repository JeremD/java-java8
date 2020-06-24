package java8.ex01;

import java8.data.Account;
import java8.data.Person;
import org.junit.Test;

import java.util.function.Function;

/**
 * Exercice 01 - java.util.function.Function
 */
public class Function_01_Test {

	/******** PART 1 - Integer -> Person *******/

	// tag::intToPerson[]

	/**
	 * Convertion d'un entier en objet Person
	 * 
	 * @param integer
	 * @return objet Person
	 */
	private Function<Integer, Person> intToPerson = (Integer entier) -> {
		Person toPerson = new Person();
		toPerson.setFirstname("first_" + entier);
		toPerson.setLastname("last_" + entier);
		toPerson.setAge(entier);
		toPerson.setPassword("pass_" + entier);
		return toPerson;
	};
	// end::intToPerson[]

	@Test
	public void test_intToPerson() throws Exception {

		// On invoque la fonction intToPerson avec en paramètre l'entier 10.
		Person result = intToPerson.apply(10);
		assert result.getFirstname().equals("first_10");
		assert result.getLastname().equals("last_10");
		assert result.getAge().equals(10);
		assert result.getPassword().equals("pass_10");
	}

	/******** PART 2 - Person -> Account *******/

	// tag::personToAccount[]
	/**
	 * Convertion d'une personne en objet Account
	 * 
	 * @param integer
	 * @return objet Person
	 */
	private Function<Person, Account> personToAccount = (Person person) -> {
		Account toAccount = new Account();
		toAccount.setOwner(person);
		toAccount.setBalance(1000);
		return toAccount;
	};
	// end::personToAccount[]

	@Test
	public void test_personToAccount() throws Exception {

		Person person = new Person("Jules", "France", 10, "pass");

		// On invoque la fonction personToAccount avec en paramètre la personne
		Account result = personToAccount.apply(person);
		assert result.getOwner().equals(person);
		assert result.getBalance().equals(1000);
	}

	/******** PART 3 - Integer -> Account avec compose *******/

	// tag::intToAccountWithCompose[]
	// intToPerson et personToAccount avec compose
	private Function<Integer, Account> intToAccountWithCompose = personToAccount.compose(intToPerson);
		
	// end::intToAccountWithCompose[]

	@Test
	public void test_intToAccount_with_Compose() throws Exception {

		// intToAccountWithCompose avec l'entier 10
		Account result = intToAccountWithCompose.apply(10);
		// résultat prénom account à 10 attendu
		assert result.getOwner().getFirstname().equals("first_10");
		assert result.getBalance().equals(1000);
	}

	/******** PART 4 - Integer -> Account avec andThen *******/

	// tag::intToAccountWithAndThen[]
	// intToPerson et personToAccount avec andThen
	private Function<Integer, Account> intToAccountWithAndThen = intToPerson.andThen(personToAccount);
	// end::intToAccountWithAndThen[]

	@Test
	public void test_intToAccount_with_AndThen() throws Exception {

		// TODO invoquer la fonction intToAccountWithAndThen avec l'entier 11
		Account result = intToAccountWithAndThen.apply(11);

		assert result.getOwner().getFirstname().equals("first_11");
		assert result.getBalance().equals(1000);
	}
}
