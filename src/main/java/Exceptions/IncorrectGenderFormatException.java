package Exceptions;

public class IncorrectGenderFormatException extends WrongDataFormatException{
    public IncorrectGenderFormatException(Character incorrectChar) {
        System.out.println(String.format("Приемлемые значения пола: m или f. Было введено: %s.", incorrectChar));
    }
}
