package java8.ex01;

import java8.data.Data;
import java8.data.Person;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercice 01 - Filter
 */
public class Lambda_01_Test {

    // tag::PersonPredicate[]
    interface PersonPredicate {
        boolean test(Person p);
    }
    // end::PersonPredicate[]

    // tag::filter[]
    private List<Person> filter(List<Person> persons, PersonPredicate predicate) {
        List<Person> filteredPersons = new ArrayList<Person>();
    	for (Person p: persons){
        	if (predicate.test(p)){
        		filteredPersons.add(p);
        	}
        }
        return filteredPersons;
    }
    // end::filter[]


    // tag::test_filter_by_age[]
    @Test
    public void test_filter_by_age() throws Exception {
      
        // Génération d'une liste de 100 personnes
        List<Person> personList = Data.buildPersonList(100);
        
        // Filtre pour sélectionner les personnes adultes
        List<Person> result = filter(personList, a -> a.getAge() >= 18);
        
        // Test sur 83 personnes
        assert result.size() == 83;
        
        for (Person person : result) {
            assert person.getAge() > 17;
        }
        
        // résultat personnes adultes attendu
        assert result.get(0).getAge() >= 18;
    }
    // end::test_filter_by_age[]

    // tag::test_filter_by_firstname[]
    @Test
    public void test_filter_by_firstname() throws Exception {

        List<Person> personList = Data.buildPersonList(100);

        // Filtre pour récuperer le prénom "first_10"
        List<Person> result = filter(personList, p -> p.getFirstname().equals("first_10"));

        assert result.size() == 1;
        
        // prénom first_10 attendu
        assert result.get(0).getFirstname().equals("first_10");

    }
    // end::test_filter_by_firstname[]

    // tag::test_filter_by_password[]
    @Test
    public void test_filter_by_password() throws Exception {

        List<Person> personList = Data.buildPersonList(100);

        String passwordSha512Hex = "ee26b0dd4af7e749aa1a8ee3c10ae9923f618980772e473f8819a5d4940e0db27ac185f8a0e1d5f84f88bc887fd67b143732c304cc5fa9ad8e6f57f50028a8ff";
        
        // Deux filtres en même temps : age > 49 et bon hash du mot de passe
        List<Person> result = filter(personList, a -> a.getAge() > 49 && passwordSha512Hex.equals(DigestUtils.sha512Hex(a.getPassword())));
        
        assert result.size() == 6;
        for (Person person : result) {
            assert person.getPassword().equals("test");
        }
    }
    // end::test_filter_by_password[]
}
