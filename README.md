Calculator — Unit & Mutation Testing

Repositorio de pruebas sobre la clase Calculator con JUnit 4, JaCoCo (cobertura) y PIT (mutation testing, opcional).

Objetivos

Asegurar correctitud con tests unitarios siguiendo AAA.

Medir cobertura (líneas y ramas) con JaCoCo.

Validar robustez con mutation testing (PIT).

Requisitos

Java JDK 8+

Maven 3.6+

Sistema probado en Windows/PowerShell

Uso rápido

Ejecutar tests: mvn clean test

Informe JaCoCo: target/site/jacoco/index.html

Informe PIT (opcional): target/pit-reports/.../index.html

Si el entorno no resuelve el plugin de JaCoCo automáticamente, usar:
mvn org.jacoco:jacoco-maven-plugin:0.8.12:prepare-agent test org.jacoco:jacoco-maven-plugin:0.8.12:report
(Versiones alternativas: 0.8.11 / 0.8.10).

Alcance de las pruebas

Se cubren casos normales, límites y errores (excepciones) para:

suma, resta, multiplica

divideix: división truncada (p.ej., 7/2=3 si devuelve int), división por 0 → excepción

potencia: 2^3=8, 5^0=1, 0^0=1 (según especificación), exponente negativo → excepción

arrelQuadrada: resultados con tolerancia (delta), input negativo → excepción

esPositiu: positivos/negativos y decisión documentada para 0 (en este proyecto: false)

Criterios aplicados:

Patrón AAA (Arrange–Act–Assert)

Particiones de equivalencia y valores límite

Nombrado descriptivo de tests

Evidencias

docs/jacoco-cobertura.png — captura del índice de JaCoCo

docs/pit-mutation-score.png — captura de PIT (si se ejecuta)

Los informes HTML completos quedan en target/site/jacoco/ y target/pit-reports/.

Entrega

Incluye en el repo (o ZIP):

Código + tests

Carpeta docs/ con capturas

Este README.md

Notas de calidad

Tests deterministas y aislados

Cobertura de líneas y ramas

Excepciones verificadas con asserts específicos

Sin lógica innecesaria dentro de los tests
