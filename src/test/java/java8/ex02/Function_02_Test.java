package java8.ex02;

import java8.data.Account;
import java8.data.Person;
import org.junit.Test;

import java.util.function.BiFunction;

/**
 * Exercice 02 - java.util.function.BiFunction
 */
public class Function_02_Test {

	// tag::buildAccount[]

	/**
	 * Créer le compte d'une personne
	 * 
	 * @param person
	 * @param integer
	 * @return objet Account
	 */
	BiFunction<Person, Integer, Account> buildAccount = (person, integer) -> {
		Account toAccount = new Account();
		toAccount.setOwner(person);
		toAccount.setBalance(integer);
		return toAccount;
	};
	// end::buildAccount[]

	@Test
	public void test_build_account() throws Exception {

		// Création d'une personne
		Person person = new Person("John", "France", 80, "pass");
		// Invocation de buildAccount
		Account account = buildAccount.apply(person, 500);

		assert account.getBalance().equals(500);
		assert account.getOwner().getFirstname().equals("John");
		assert account.getOwner().getLastname().equals("France");
		assert account.getOwner().getAge().equals(80);
		assert account.getOwner().getPassword().equals("pass");
	}

}
