package java8.ex01;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import java8.data.Data;
import java8.data.Person;

/**
 * Exercice 01 - Méthode par défaut
 */
public class Method_01_Test {

	// tag::IDao[]
	interface IDao {
		List<Person> findAll();

		/**
		 * Additionner les ages de toutes les personnes
		 * 
		 * @return totalAge L'âge total
		 */
		default int sumAge() {
			int totalAge = 0;
			for (Person age : findAll()) {
				totalAge += age.getAge();
			}
			return totalAge;
		}
	
	}
	// end::IDao[]

	class DaoA implements IDao {

		List<Person> people = Data.buildPersonList(20);

		@Override
		public List<Person> findAll() {
			return people;
		}
	}

	class DaoB implements IDao {

		List<Person> people = Data.buildPersonList(100);

		@Override
		public List<Person> findAll() {
			return people;
		}
	}

	@Test
	public void test_daoA_sumAge() throws Exception {
		DaoA daoA = new DaoA();
		Person personOne = new Person();
		Person personTwo = new Person();
		personOne.setAge(100);
		personTwo.setAge(110);
		int result = daoA.sumAge();
		// résultat 210 attendu
		assertEquals(210, result);
	}

	@Test
	public void test_daoB_sumAge() throws Exception {
		DaoB daoB = new DaoB();
		Person Danny = new Person();
		Person Charlotte = new Person();
		Person Donovan = new Person();
		Danny.setAge(25);
		Charlotte.setAge(18);
		Donovan.setAge(8);
		int result = daoB.sumAge();
		// résultat 51 attendu
		assertEquals(51, result);
	}
}
