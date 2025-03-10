# HealthCalc - Calculadora de Salud 🏥

##  Descripción General

HealthCalc es una calculadora de salud que permite estimar dos métricas clave para una persona:

1. **Peso Ideal**: Estima el peso corporal óptimo según la altura y el género.
2. **Tasa Metabólica Basal (TMB)**: Calcula las calorías que el cuerpo necesita en reposo para mantener funciones vitales.

Esta calculadora pretende ser utilizada como una herramienta auxiliar en la estimación de parámetros de salud de las personas
.

## Fórmulas utilizadas

### 1. Cálculo del Peso Ideal
El peso ideal se calcula utilizando la **fórmula de Devine**:

- **Para hombres**:  
  $$ \text{Peso Ideal} = 50 + 2.3 \times \frac{(\text{altura en cm} - 152)}{2.54} $$

- **Para mujeres**:  
  $$ \text{Peso Ideal} = 45.5 + 2.3 \times \frac{(\text{altura en cm} - 152)}{2.54} $$



---

###  2. Cálculo de la Tasa Metabólica Basal (TMB)
Usamos la **ecuación de Mifflin-St Jeor**para estimar el metabolismo basal:

- **Para hombres**:  
  $$ TMB = (10 \times \text{peso en kg}) + (6.25 \times \text{altura en cm}) - (5 \times \text{edad}) + 5 $$

- **Para mujeres**:  
  $$ TMB = (10 \times \text{peso en kg}) + (6.25 \times \text{altura en cm}) - (5 \times \text{edad}) - 161 $$


---

## Casos de prueba

A continuación, describo los casos de prueba diseñados para verificar el correcto funcionamiento de la clase `HealthCalcImpl`.


### **1. Cálculo del Peso Ideal (`idealBodyWeight`)**
| Caso de prueba | Entrada | Salida esperada |
|---------------|---------|----------------|
| Hombre de 170 cm | `height = 170`, `gender = 'M'` | Peso ideal ≈ 66 kg |
| Mujer de 160 cm | `height = 160`, `gender = 'F'` | Peso ideal ≈ 54 kg |
| Altura mínima permitida | `height = 140`, `gender = 'M'` | Valor válido |
| Altura máxima permitida | `height = 220`, `gender = 'F'` | Valor válido |
| Altura inferior a la mínima permitida | `height = 100`, `gender = 'M'` | Excepción o mensaje de error |
| Altura superior a la máxima permitida | `height = 250`, `gender = 'F'` | Excepción o mensaje de error |
| Género no válido | `height = 180`, `gender = 'X'` | Excepción o mensaje de error |
| Formato incorrecto (altura no numérica) | `height = "abc"`, `gender = 'M'` | Excepción o mensaje de error |

---

### **2. Cálculo de la Tasa Metabólica Basal (`basalMetabolicRate`)**
| Caso de prueba | Entrada | Salida esperada |
|---------------|---------|----------------|
| Hombre de 70kg, 175cm, 25 años | `weight = 70`, `height = 175`, `age = 25`, `gender = 'M'` | TMB ≈ 1700 kcal |
| Mujer de 60kg, 165cm, 30 años | `weight = 60`, `height = 165`, `age = 30`, `gender = 'F'` | TMB ≈ 1400 kcal |
| Peso límite inferior | `weight = 30`, `height = 160`, `age = 20`, `gender = 'M'` | Valor válido |
| Peso límite superior | `weight = 200`, `height = 190`, `age = 40`, `gender = 'F'` | Valor válido |
| Peso inferior al mínimo permitido | `weight = 10`, `height = 160`, `age = 20`, `gender = 'M'` | Excepción o mensaje de error |
| Peso superior al máximo permitido | `weight = 300`, `height = 190`, `age = 40`, `gender = 'F'` | Excepción o mensaje de error |
| Edad mínima permitida | `weight = 70`, `height = 175`, `age = 18`, `gender = 'M'` | Valor válido |
| Edad máxima permitida | `weight = 70`, `height = 175`, `age = 100`, `gender = 'M'` | Valor válido |
| Edad inferior a la mínima permitida | `weight = 70`, `height = 175`, `age = 10`, `gender = 'M'` | Excepción o mensaje de error |
| Edad superior a la máxima permitida | `weight = 70`, `height = 175`, `age = 120`, `gender = 'M'` | Excepción o mensaje de error |
| Género no válido | `weight = 70`, `height = 175`, `age = 25`, `gender = 'X'` | Excepción o mensaje de error |
| Formato incorrecto (peso no numérico) | `weight = "abc"`, `height = 175`, `age = 25`, `gender = 'M'` | Excepción o mensaje de error |
| Formato incorrecto (edad no numérica)** | `weight = 70`, `height = 175`, `age = "xyz"`, `gender = 'M'` | Excepción o mensaje de error |



