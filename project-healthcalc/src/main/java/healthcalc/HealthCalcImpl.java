package healthcalc;

public class HealthCalcImpl implements HealthCalc {

    // Rango de altura permitido
    private static final int MIN_HEIGHT = 140;
    private static final int MAX_HEIGHT = 220;

    // Rango de peso permitido
    private static final float MIN_WEIGHT = 30.0f;
    private static final float MAX_WEIGHT = 200.0f;

    // Rango de edad permitido
    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 100;

    @Override
    public float idealWeight(int height, char gender) {
        // Validaciones de altura
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException("Altura fuera del rango permitido (" + MIN_HEIGHT + "-" + MAX_HEIGHT + " cm)");
        }
        // Validación de género
        if (gender != 'M' && gender != 'F') {
            throw new IllegalArgumentException("Género no válido. Debe ser 'M' o 'F'");
        }

        // Fórmula de Devine
        if (gender == 'M') {
            return 50 + 2.3f * ((height - 152) / 2.54f);
        } else {
            return 45.5f + 2.3f * ((height - 152) / 2.54f);
        }
    }

    @Override
    public float basalMetabolicRate(float weight, int height, int age, char gender) {
        // Validaciones de peso
        if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
            throw new IllegalArgumentException("Peso fuera del rango permitido (" + MIN_WEIGHT + "-" + MAX_WEIGHT + " kg)");
        }
        // Validaciones de altura
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException("Altura fuera del rango permitido (" + MIN_HEIGHT + "-" + MAX_HEIGHT + " cm)");
        }
        // Validaciones de edad
        if (age < MIN_AGE || age > MAX_AGE) {
            throw new IllegalArgumentException("Edad fuera del rango permitido (" + MIN_AGE + "-" + MAX_AGE + " años)");
        }
        // Validación de género
        if (gender != 'M' && gender != 'F') {
            throw new IllegalArgumentException("Género no válido. Debe ser 'M' o 'F'");
        }

        // Fórmula de Mifflin-St Jeor
        if (gender == 'M') {
            return (10 * weight) + (6.25f * height) - (5 * age) + 5;
        } else {
            return (10 * weight) + (6.25f * height) - (5 * age) - 161;
        }
    }
}

