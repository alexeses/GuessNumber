package es.uem.guessnumber;

public class RandomNumber {

    // General variables
    public int intentos = 5;
    public int randomNumber = getNumero();

    // Method to get a random number
    public int getNumero() {
        int numero = (int) (Math.random() * 100);
        System.out.println("[DEBUG] Random number: " + numero);
        return numero;
    }

    // Method to check if the number is correct
    public boolean isCorrect(int numero) {
        if (numero == randomNumber) {
            return true;
        } else {
            intentos--;
            return false;
        }
    }

    // Method to check if the number of attempts is valid
    public boolean validAttempts() {
        if (intentos > 0) {
            return true;
        } else {
            return false;
        }
    }
}
