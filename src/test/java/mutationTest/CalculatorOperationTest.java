package mutationTest;

import org.junit.*;
import static org.junit.Assert.*;
import com.seidoropentrends.classes.Calculator;

public class CalculatorOperationTest {

    // --- ciclo de vida a nivel de clase (una sola vez) ---
    private static long t0;

    @BeforeClass
    public static void initOnce() {
        t0 = System.currentTimeMillis();
        // Aquí iniciarías recursos “caros” si existieran
    }

    @AfterClass
    public static void cleanupOnce() {
        long ms = System.currentTimeMillis() - t0;
        System.out.println("Duración CalculatorOperationTest = " + ms + " ms");
    }

    // --- ciclo de vida a nivel de test (cada test) ---
    private Calculator calc;

    @Before
    public void setUp() { calc = new Calculator(); }

    @After
    public void tearDown() { calc = null; }

    // -------- SUMA --------
    @Test public void suma_basicos() {
        assertEquals(5,  calc.suma(2, 3));
        assertEquals(0,  calc.suma(-2, 2));
        assertEquals(-1, calc.suma(-3, 2));
    }

    // -------- RESTA --------
    @Test public void resta_casos() {
        assertEquals(6,  calc.resta(10, 4));
        assertEquals(3,  calc.resta(-2, -5));
        assertEquals(-7, calc.resta(-3, 4));
    }

    // -------- MULTIPLICA --------
    @Test public void multiplica_casos() {
        assertEquals(0,   calc.multiplica(7, 0));
        assertEquals(-12, calc.multiplica(-3, 4));
        assertEquals(21,  calc.multiplica(7, 3));
    }

    // -------- DIVIDEIX --------
    @Test public void divideix_truncada_y_signos() {
        // Si divideix devuelve double, cambia a: assertEquals(3.5, calc.divideix(7,2), 1e-9);
        assertEquals(3,  calc.divideix(7, 2));
        assertEquals(-3, calc.divideix(-7, 2));
        assertEquals(-3, calc.divideix(7, -2));
        assertEquals(3,  calc.divideix(-7, -2));
        assertEquals(0,  calc.divideix(0, 5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void divideix_porCero_lanzaExcepcion() {
        calc.divideix(10, 0);
    }

    // -------- POTENCIA --------
    @Test(timeout = 100)
    public void potencia_casos() {
        assertEquals(8, calc.potencia(2, 3));
        assertEquals(1, calc.potencia(5, 0));
        assertEquals(1, calc.potencia(0, 0));  // según la práctica
    }

    @Test(expected = IllegalArgumentException.class)
    public void potencia_exponenteNegativo_excepcion() {
        calc.potencia(2, -1);
    }

    // -------- ARREL QUADRADA --------
    @Test public void arrelQuadrada_ok() {
        assertEquals(3.0, calc.arrelQuadrada(9.0), 1e-3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void arrelQuadrada_negativo_excepcion() {
        calc.arrelQuadrada(-4.0);
    }

    // -------- ES POSITIU --------
    @Test public void esPositiu_bordes() {
        assertTrue(calc.esPositiu(1));
        assertFalse(calc.esPositiu(-1));
        assertFalse(calc.esPositiu(0)); // ajusta si tu contrato dice lo contrario
    }

    // (Opcional) ejemplo de test desactivado
    @Ignore("Ejemplo: pendiente de decidir contrato para esPositiu(0)")
    @Test public void test_temporalmente_desactivado() {
        // no se ejecuta
    }
}
