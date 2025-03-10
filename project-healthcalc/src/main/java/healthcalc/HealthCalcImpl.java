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
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException("Altura fuera del rango permitido (" + MIN_HEIGHT + "-" + MAX_HEIGHT + " cm)");
        }
        if (gender != 'M' && gender != 'W') {
            throw new IllegalArgumentException("Género no válido. Debe ser 'M' o 'W'");
        }

        if (gender == 'M') {
            return height - 100 - ((height - 150) / 4.0f);
        } else {
            return height - 100 - ((height - 150) / 2.5f);
        }
    }

    @Override
    public float basalMetabolicRate(float weight, int height, int age, char gender) {
        if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
            throw new IllegalArgumentException("Peso fuera del rango permitido (" + MIN_WEIGHT + "-" + MAX_WEIGHT + " kg)");
        }
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException("Altura fuera del rango permitido (" + MIN_HEIGHT + "-" + MAX_HEIGHT + " cm)");
        }
        if (age < MIN_AGE || age > MAX_AGE) {
            throw new IllegalArgumentException("Edad fuera del rango permitido (" + MIN_AGE + "-" + MAX_AGE + " años)");
        }
        if (gender != 'M' && gender != 'W') {
            throw new IllegalArgumentException("Género no válido. Debe ser 'M' o 'W'");
        }

        if (gender == 'M') {
            return 88.362f + (13.397f * weight) + (4.799f * height) - (5.677f * age);
        } else {
            return 447.593f + (9.247f * weight) + (3.098f * height) - (4.330f * age);
        }
    }
}


