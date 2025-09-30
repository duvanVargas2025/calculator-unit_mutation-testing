package mutationTest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.seidoropentrends.classes.Calculator;

/**
 * Tests de Calculator (JUnit 4) siguiendo AAA, límites y excepciones.
 * Ajusta los asserts si tu contrato/métodos difieren (int/double).
 */
public class CalculatorOperationTest {

    private Calculator calc;

    @Before
    public void setUp() {
        calc = new Calculator();
    }

    // -------- SUMA --------
    @Test
    public void suma_basico() {
        int r = calc.suma(2, 3);
        assertEquals(5, r);
    }

    @Test
    public void suma_conNegativos() {
        assertEquals(3, calc.suma(-2, 5));
        assertEquals(-1, calc.suma(-3, 2));
        assertEquals(0, calc.suma(0, 0));
    }

    // -------- RESTA --------
    @Test
    public void resta_basico() {
        assertEquals(6, calc.resta(10, 4));
    }

    @Test
    public void resta_conNegativos() {
        assertEquals(3, calc.resta(-2, -5)); // -2 - (-5) = 3
        assertEquals(-7, calc.resta(-3, 4));
        assertEquals(0, calc.resta(0, 0));
    }

    // -------- MULTIPLICA --------
    @Test
    public void multiplica_casos() {
        assertEquals(0, calc.multiplica(7, 0));
        assertEquals(-12, calc.multiplica(-3, 4));
        assertEquals(21, calc.multiplica(7, 3));
    }

    // -------- DIVIDEIX --------
    @Test
    public void divideix_truncada_siEsEntera() {
        // Si divideix devuelve int, se espera truncado: 7/2 = 3
        // Si devuelve double, cambia a assertEquals(3.5, calc.divideix(7,2), 1e-9)
        assertEquals(3, calc.divideix(7, 2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void divideix_porCero_lanzaExcepcion() {
        calc.divideix(10, 0);
    }

    // -------- POTENCIA --------
    @Test
    public void potencia_casosBasicos() {
        assertEquals(8, calc.potencia(2, 3));   // 2^3
        assertEquals(1, calc.potencia(5, 0));   // cualquier base ^0 = 1
        assertEquals(1, calc.potencia(0, 0));   // según especificación de la práctica
    }

    @Test(expected = IllegalArgumentException.class)
    public void potencia_exponenteNegativo_lanzaExcepcion() {
        calc.potencia(2, -1);
    }

    // -------- ARREL QUADRADA --------
    @Test
    public void arrelQuadrada_basico() {
        // Si devuelve double, usa delta
        assertEquals(3.0, calc.arrelQuadrada(9.0), 1e-3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void arrelQuadrada_negativo_lanzaExcepcion() {
        calc.arrelQuadrada(-4.0);
    }

    // -------- ES POSITIU --------
    @Test
    public void esPositiu_casos() {
        assertTrue(calc.esPositiu(4));
        assertFalse(calc.esPositiu(-2));
        // Contrato para 0: en este proyecto consideramos que 0 NO es positivo.
        // Si tu implementación devuelve true para 0, cambia el assert siguiente.
        assertFalse(calc.esPositiu(0));
    }
}
