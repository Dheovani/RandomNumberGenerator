import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

class RandomNumberGenerator {
    public static void main(String[] args) {
        RandomNumberGenerator rng = new RandomNumberGenerator();
        System.out.println(rng.randomNumber());
        System.out.println(rng.randomNumber(1, 2));
    }

    private long getTime() {
        return LocalDateTime.now().getLong(ChronoField.NANO_OF_SECOND);
        // We'll use LocalDateTime as a form of getting a random long
    }

    private int randomNumber() {
        // This is just an equation to decrease the number
        int number = 0;
        long a = 151351548L;
        long b = 841564416L;
        // a and b are only used to multiply and divide
        number = (int) ((this.getTime() * a) / b);
        return number;
    }

    private int randomNumber(int min, int max) {
        // Adding a range limiter
        // The following code will only work if the selected range sets numbers that are LOWER than our original number
        double number = randomNumber();
        double c = 999;
        // c will be our divider
        while(number < min || number > max) {
            // Loop will keep going until number is in the selected range
            if(c > 1) {
                // If c > 1, we need to divide number by c
                if(number / c > min) {
                    number /= c;
                } else {
                    c /= 2;
                }
            } else {
                // Once c < 1, dividing number by c would make it bigger, so we'll have to multiply them
                if(number * c > min) {
                    number *= c;
                } else {
                    c *= 2;
                }
            }
        }
        return (int) number;
    }
}
