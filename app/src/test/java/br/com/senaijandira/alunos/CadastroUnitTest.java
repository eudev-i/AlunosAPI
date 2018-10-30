package br.com.senaijandira.alunos;

import org.junit.Test;

import br.com.senaijandira.alunos.util.DateUtil;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CadastroUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void conversao_data_esta_correta(){

        String input = "14/05/2001";
        int outputEsperado = 20010514;

        /*INSTANCIANDO A CLASSE*/
        DateUtil util = new DateUtil();

        int resposta = util.convertToInt(input);

        assertEquals(outputEsperado, resposta);
    }
}