package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class ConvertTemperatureTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(36.50, 309.65000, 97.70000),
                Arguments.of(122.11, 395.26000, 251.79800)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(double celsius, double expectedKelvin, double expectedFahrenheit) {
        // Given

        // When
        double[] temps = convertTemperature(celsius);

        // Then
        System.out.println("convertTemperature(" + celsius + ") = " + Arrays.toString(temps));
        Assertions.assertThat(temps.length).isEqualTo(2);
        Assertions.assertThat(temps[0]).isEqualTo(expectedKelvin);
        Assertions.assertThat(temps[1]).isEqualTo(expectedFahrenheit);
    }

    public double[] convertTemperature(double celsius) {
        double kelvin = celsius + 273.15;
        double fahrenheit = celsius * 1.80 + 32.00;
        return new double[]{kelvin, fahrenheit};
    }
}
