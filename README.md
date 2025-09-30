Calculator — Unit & Mutation Testing

Práctica de tests unitarios sobre la clase Calculator con JUnit 4, JaCoCo (cobertura) y PIT (mutation testing).

Objetivos

Validar la corrección con tests unitarios siguiendo AAA (Arrange–Act–Assert).

Medir cobertura (líneas y ramas) con JaCoCo.

Medir la fortaleza real de los tests con mutation testing (PIT).

Cubrir casos normales, límites y excepciones.

Requisitos

Java JDK 8+

Maven 3.6+

Entorno probado en Windows/PowerShell (terminal equivalente sirve).

Estructura
calculator-unit_mutation-testing/
├─ src/
│  ├─ main/java/com/seidoropentrends/classes/Calculator.java
│  └─ test/java/mutationTest/CalculatorOperationTest.java
│            (tests adicionales: CalculatorEdgeCasesTest.java, etc.)
├─ docs/
│  ├─ jacoco_cobertura.png
│  └─ pit_mutation_score.png
├─ pom.xml
└─ README.md

Cómo ejecutar

Tests unitarios

mvn clean test


Informe de cobertura (JaCoCo)

mvn org.jacoco:jacoco-maven-plugin:0.8.12:prepare-agent test org.jacoco:jacoco-maven-plugin:0.8.12:report


Abrir: target/site/jacoco/index.html
Evidencia incluida: docs/jacoco_cobertura.png

Mutation testing (PIT)

mvn org.pitest:pitest-maven:mutationCoverage


Abrir: target/pit-reports/<timestamp>/index.html
Evidencia incluida: docs/pit_mutation_score.png

Si tu entorno no resuelve la 0.8.12 de JaCoCo, usa 0.8.11 o 0.8.10 en el comando.

Alcance de los tests

Se prueban todos los métodos de Calculator con casos normales, bordes y errores esperados:

suma, resta, multiplica

divideix: división truncada (entera), división por 0 → IllegalArgumentException

maxim: a>b, a==b, a<b

arrelQuadrada: positivos (con delta), 0.0, negativo → IllegalArgumentException

esPositiu: positivos/negativos y 0 (contrato documentado)

potencia: 2^3=8, base^0=1, 0^0=1 (según enunciado), exponente negativo → IllegalArgumentException, exponente=1, bases especiales (1, -1, 0)

Criterios aplicados:

Patrón AAA.

Particiones de equivalencia y valores límite.

Verificación de excepciones y, cuando corresponde, mensaje.

Timeout razonable en operaciones de potencia (rendimiento básico).

Ciclo de vida de tests en JUnit 4: @BeforeClass/@AfterClass, @Before/@After, @Ignore.

Resultados (ejemplo orientativo)

Cobertura (JaCoCo): ver docs/jacoco_cobertura.png

Mutation testing (PIT): ver docs/pit_mutation_score.png

Los informes HTML completos están en target/site/jacoco/ y target/pit-reports/.

Nota sobre el único mutante “Survived”

PIT reporta 1 mutación superviviente en Calculator.maxim(int a, int b) (mutador changed conditional boundary sobre a >= b).
Esta mutación es equivalente: al cambiar >= por >, cuando a == b el resultado observable es el mismo entero (tanto a como b valen lo mismo). Se han probado igualdad y casos donde b es mayor, pero no es posible distinguir ambas versiones sin cambiar el contrato/API (p. ej., exponer qué operando fue elegido).
Mutation Coverage final: 96% (25/26).

Cómo reproducir la evidencia

mvn clean test

JaCoCo: comando superior y abrir target/site/jacoco/index.html → capturar pantalla → guardar en docs/jacoco_cobertura.png.

PIT: mvn org.pitest:pitest-maven:mutationCoverage → abrir último target/pit-reports/.../index.html → capturar pantalla → docs/pit_mutation_score.png.

Notas de calidad

Tests deterministas y aislados (sin IO ni dependencias externas).

Cobertura de líneas y ramas significativa (no “assert vacíos”).

Batería de bordes (0, negativos, igualdad, signos) para matar mutantes típicos.

Código de tests legible y con nombres descriptivos.
