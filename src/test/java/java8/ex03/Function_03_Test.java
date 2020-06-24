package java8.ex03;

import java8.data.Person;
import org.junit.Test;

import java.util.function.BinaryOperator;

/**
 * Exercice 03 - java.util.function.BinaryOperator
 */
public class Function_03_Test {

    //  tag::makeAChild[]

	/**
	 * Créer un enfant
	 * 
	 * @param objet Person le père
	 * @param objet Person la mère
	 * @return objet Person l'enfant
	 */
    BinaryOperator<Person> makeAChild = (father, mother) -> {
     	Person child = new Person();
    	child.setFirstname(father.getFirstname() + " " + mother.getFirstname());
    	child.setLastname(father.getLastname());
    	child.setAge(0);
    	child.setPassword(null);
    	return child;
    };
    //  end::makeAChild[]

    @Test
    public void test_makeAChild() throws Exception {

        Person father = new Person("John", "France", 25, "johndoe");
        Person mother = new Person("Aline", "Lebreton", 22, "alino");
        Person child = makeAChild.apply(father, mother);
        // résultat création de l'enfant attendu
        assert child.getFirstname().equals("John Aline");
        assert child.getLastname().equals("France");
        assert child.getAge().equals(0);
        assert child.getPassword() == null;
    }

}
