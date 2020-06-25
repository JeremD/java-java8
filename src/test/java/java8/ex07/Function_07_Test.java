package java8.ex07;

import org.junit.Test;

import java.util.function.IntBinaryOperator;

/**
 * Exercice 07 - java.util.function.IntBinaryOperator
 */
public class Function_07_Test {

    // tag::format[]
    /**
     * Effectuer une opération et renvoyer une chaine de caractères de la forme "(<nb1><symbol><nb2>)=<resultat>"
     * 
     * @param nb1
     * @param nb2
     * @param symbol
     * @param operator
     * @return String
     */
    String format(int nb1, int nb2, String symbol, IntBinaryOperator operator) {
        return "("+ nb1 + symbol + nb2 + ")="+operator.applyAsInt(nb1, nb2);
    }
    // end::format[]

    // Définition de sum pour une addition
    IntBinaryOperator sum = (nb1, nb2) -> nb1 + nb2;

    @Test
    public void test_format_sum() throws Exception {

        String result = format(12, 13, "+", sum);
        // résultat somme attendu
        assert result.equals("(12+13)=25");
    }

    // Définition de substract pour une soustraction
    IntBinaryOperator substract = (nb1, nb2) -> nb1 - nb2;

    @Test
    public void test_format_subtract() throws Exception {

        String result = format(2, 3, "-", substract);
        	// résultat soustraction attendu
        assert result.equals("(2-3)=-1");
    }
}



