	package healthcalc;

	import static org.junit.jupiter.api.Assertions.*;

	import org.junit.jupiter.api.DisplayName;
	import org.junit.jupiter.api.Test;

	@DisplayName("Tests para la calculadora de salud.")
	public class HealthCalcTest {

	    private final HealthCalc calc = new HealthCalcImpl(); 

	 // Pruebas para idealWeight

	    @Test
	    @DisplayName("Peso ideal para un hombre de 170 cm")
	    public void testIdealBodyWeight_Man() throws Exception {
	        
	        int height = 170;
	        char gender = 'M';
	        float expectedWeight = 65.0f;
	        float result = calc.idealWeight(height, gender);
	        assertEquals(expectedWeight, result, 0.1);
	    }

	    @Test
	    @DisplayName("Peso ideal para una mujer de 160 cm")
	    public void testIdealBodyWeight_Woman() throws Exception {
	   
	        int height = 160;
	        char gender = 'W';
	        float expectedWeight = 56.0f;

	        float result = calc.idealWeight(height, gender);

	        assertEquals(expectedWeight, result, 0.1);
	    }

	    @Test
	    @DisplayName("Altura mínima permitida")
	    public void testIdealBodyWeight_MinHeight() {
	        
	        int height = 140;
	        char gender = 'M';

	        assertDoesNotThrow(() -> calc.idealWeight(height, gender));
	    }

	    @Test
	    @DisplayName("Altura máxima permitida")
	    public void testIdealBodyWeight_MaxHeight() {
	        
	        int height = 220;
	        char gender = 'W';

	         assertDoesNotThrow(() -> calc.idealWeight(height, gender));
	    }

	    @Test
	    @DisplayName("Altura inferior a la mínima permitida")
	    public void testIdealBodyWeight_TooShortHeight() {
	        
	        int invalidHeight = 100;
	        char gender = 'M';

	        assertThrows(IllegalArgumentException.class, () -> calc.idealWeight(invalidHeight, gender));
	    }

	    @Test
	    @DisplayName("Altura superior a la máxima permitida")
	    public void testIdealBodyWeight_TooTallHeight() {
	        
	        int invalidHeight = 250;
	        char gender = 'F';

	        
	        assertThrows(IllegalArgumentException.class, () -> calc.idealWeight(invalidHeight, gender));
	    }

	    @Test
	    @DisplayName("Género no válido en idealWeight")
	    public void testIdealBodyWeight_InvalidGender() {
	        
	        int height = 180;
	        char invalidGender = 'X';

	        
	        assertThrows(IllegalArgumentException.class, () -> calc.idealWeight(height, invalidGender));
	    }

	    @Test
	    @DisplayName("Formato incorrecto (altura no numérica)")
	    public void testIdealBodyWeight_InvalidFormat() {
	        
	        String invalidHeight = "abc";
	        char gender = 'M';

	        
	        assertThrows(NumberFormatException.class, () -> calc.idealWeight(Integer.parseInt(invalidHeight), gender));
	    }


	    
	    
	 // Pruebas para basalMetabolicRate con AAA

	    @Test
	    @DisplayName("TMB para un hombre de 70kg, 175cm y 25 años")
	    public void testBasalMetabolicRate_Man() throws Exception {
	        float weight = 70;
	        int height = 175;
	        int age = 25;
	        char gender = 'M';
	        float expectedBMR = 1700.0f;

	        float result = calc.basalMetabolicRate(weight, height, age, gender);

	        assertEquals(expectedBMR, result, 50.0);
	    }

	    @Test
	    @DisplayName("TMB para una mujer de 60kg, 165cm y 30 años")
	    public void testBasalMetabolicRate_Woman() throws Exception {
	        float weight = 60;
	        int height = 165;
	        int age = 30;
	        char gender = 'W';
	        float expectedBMR = 1400.0f;

	        float result = calc.basalMetabolicRate(weight, height, age, gender);

	        assertEquals(expectedBMR, result, 50.0);
	    }

	    @Test
	    @DisplayName("Peso mínimo permitido")
	    public void testBasalMetabolicRate_MinWeight() {
	        float weight = 30;
	        int height = 160;
	        int age = 20;
	        char gender = 'M';

	        assertDoesNotThrow(() -> calc.basalMetabolicRate(weight, height, age, gender));
	    }

	    @Test
	    @DisplayName("Peso máximo permitido")
	    public void testBasalMetabolicRate_MaxWeight() {
	        float weight = 200;
	        int height = 190;
	        int age = 40;
	        char gender = 'W';

	        assertDoesNotThrow(() -> calc.basalMetabolicRate(weight, height, age, gender));
	    }

	    @Test
	    @DisplayName("Peso inferior al mínimo permitido")
	    public void testBasalMetabolicRate_TooLowWeight() {
	        float invalidWeight = 10;
	        int height = 160;
	        int age = 20;
	        char gender = 'M';

	        assertThrows(IllegalArgumentException.class, () -> calc.basalMetabolicRate(invalidWeight, height, age, gender));
	    }

	    @Test
	    @DisplayName("Peso superior al máximo permitido")
	    public void testBasalMetabolicRate_TooHighWeight() {
	        float invalidWeight = 300;
	        int height = 190;
	        int age = 40;
	        char gender = 'F';

	        assertThrows(IllegalArgumentException.class, () -> calc.basalMetabolicRate(invalidWeight, height, age, gender));
	    }

	    @Test
	    @DisplayName("Edad mínima permitida")
	    public void testBasalMetabolicRate_MinAge() {
	        float weight = 70;
	        int height = 175;
	        int age = 18;
	        char gender = 'M';

	        assertDoesNotThrow(() -> calc.basalMetabolicRate(weight, height, age, gender));
	    }

	    @Test
	    @DisplayName("Edad máxima permitida")
	    public void testBasalMetabolicRate_MaxAge() {
	        float weight = 70;
	        int height = 175;
	        int age = 100;
	        char gender = 'M';

	        assertDoesNotThrow(() -> calc.basalMetabolicRate(weight, height, age, gender));
	    }

	    @Test
	    @DisplayName("Edad inferior a la mínima permitida")
	    public void testBasalMetabolicRate_TooYoung() {
	        float weight = 70;
	        int height = 175;
	        int invalidAge = 10;
	        char gender = 'M';

	        assertThrows(IllegalArgumentException.class, () -> calc.basalMetabolicRate(weight, height, invalidAge, gender));
	    }

	    @Test
	    @DisplayName("Edad superior a la máxima permitida")
	    public void testBasalMetabolicRate_TooOld() {
	        float weight = 70;
	        int height = 175;
	        int invalidAge = 120;
	        char gender = 'M';

	        assertThrows(IllegalArgumentException.class, () -> calc.basalMetabolicRate(weight, height, invalidAge, gender));
	    }

	    @Test
	    @DisplayName("Género no válido en basalMetabolicRate")
	    public void testBasalMetabolicRate_InvalidGender() {
	        float weight = 70;
	        int height = 175;
	        int age = 25;
	        char invalidGender = 'X';

	        assertThrows(IllegalArgumentException.class, () -> calc.basalMetabolicRate(weight, height, age, invalidGender));
	    }

	    @Test
	    @DisplayName("Formato incorrecto (peso no numérico)")
	    public void testBasalMetabolicRate_InvalidWeightFormat() {
	        String invalidWeight = "abcde";
	        int height = 175;
	        int age = 25;
	        char gender = 'M';

	        assertThrows(NumberFormatException.class, () -> calc.basalMetabolicRate(Float.parseFloat(invalidWeight), height, age, gender));
	    }

	    @Test
	    @DisplayName("Formato incorrecto (edad no numérica)")
	    public void testBasalMetabolicRate_InvalidAgeFormat() {
	        float weight = 70;
	        int height = 175;
	        String invalidAge = "xxxx";
	        char gender = 'M';

	        assertThrows(NumberFormatException.class, () -> calc.basalMetabolicRate(weight, height, Integer.parseInt(invalidAge), gender));
	    }

	    
	    
	}


