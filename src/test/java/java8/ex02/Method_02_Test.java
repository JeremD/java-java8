package java8.ex02;

import java.util.List;

import org.junit.Test;

import java8.data.Data;
import java8.data.Person;

/**
 * Exercice 02 - Redéfinition
 */
public class Method_02_Test {

	// tag::IDao[]
	interface IDao {
		List<Person> findAll();

		/**
		 * Retourner le nombre de personnes de la liste de personne
		 * 
		 * @return le nombre de personnes
		 */
		default String format() {
			return "[" + findAll().size() + " persons]";
		}
	}
	// end::IDao[]

	// tag::DaoA[]
	class DaoA implements IDao {

		List<Person> people = Data.buildPersonList(20);

		@Override
		public List<Person> findAll() {
			return people;
		}

		/**
		 * Redefinition de la méthode format() pour DaoA
		 * 
		 * @return le nombre de personnes de DaoA
		 */
		@Override
		public String format() {
			return "DaoA" + people.size();
		}
	}
	// end::DaoA[]

	@Test
	public void test_daoA_format() throws Exception {
		Person Danny = new Person();
		Person Charlotte = new Person();
		Danny.setAge(20);
		DaoA daoA = new DaoA();
		daoA.format();
		String result = null;
		// chaine de caractère attendue
		"DaoA[2 persons]".equals(result);
	}
}
