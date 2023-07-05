package BankCaixaEletronico.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import BankCaixaEletronico.Implementations.CaixaEletronico;

public class CaixaEletronicoTest {
    private CaixaEletronico caixaEletronico;

    @Before
    public void SetUp(){
        this.caixaEletronico = new CaixaEletronico();
    }

    @Test
    public void logar_QUANDO_o_usuario_nao_informar_dados_validos_ENTAO_retornar_null() {

        //Arrange
        String expectedString = null;
        
        //Act
        String actualString = caixaEletronico.logar();

        //Assert
        assertEquals(actualString, expectedString);
    }

    @Test
    public void sacar_QUANDO_o_usuario_nao_informar_dados_validos_ENTAO_retornar_null() {

        //Arrange
        String expectedString = null;
        
        //Act
        String actualString = caixaEletronico.logar();

        //Assert
        assertEquals(actualString, expectedString);
    }

    @Test
    public void depositar_QUANDO_o_usuario_nao_informar_dados_validos_ENTAO_retornar_null() {

        //Arrange
        String expectedString = null;
        
        //Act
        String actualString = caixaEletronico.logar();

        //Assert
        assertEquals(actualString, expectedString);
    }
    @Test
    public void saldo_QUANDO_o_usuario_nao_informar_dados_validos_ENTAO_retornar_null() {

        //Arrange
        String expectedString = null;
        
        //Act
        String actualString = caixaEletronico.logar();

        //Assert
        assertEquals(actualString, expectedString);
    }
}