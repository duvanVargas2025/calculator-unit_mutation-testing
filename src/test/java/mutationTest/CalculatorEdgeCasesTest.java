package mutationTest;

import org.junit.Test;
import static org.junit.Assert.*;
import com.seidoropentrends.classes.Calculator;

public class CalculatorEdgeCasesTest {

    // --- MAXIM: igualdad y cuando b > a
    @Test public void maxim_igualdad_devuelvePrimero() {
        Calculator c = new Calculator();
        assertEquals(5, c.maxim(5, 5)); // mata mutadores de >= -> >
    }

    @Test public void maxim_bMayor_devuelveB() {
        Calculator c = new Calculator();
        assertEquals(9, c.maxim(3, 9)); // mata mutadores de >= -> <=
    }

    // --- ARREL QUADRADA: caso x=0 (debe NO lanzar y devolver 0.0)
    @Test public void arrelQuadrada_cero() {
        Calculator c = new Calculator();
        assertEquals(0.0, c.arrelQuadrada(0.0), 1e-12); // mata < -> <=
    }

    // --- POTENCIA: exponente 1 (mata i<exp -> i<=exp)
    @Test public void potencia_exponenteUno_devuelveBase() {
        Calculator c = new Calculator();
        assertEquals(7, c.potencia(7, 1)); // si el mutante multiplica una vez de más, aquí fallaría
    }


}
