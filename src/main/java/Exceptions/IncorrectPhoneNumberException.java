package Exceptions;

public class IncorrectPhoneNumberException extends WrongDataFormatException{
    public IncorrectPhoneNumberException(int wrongLength) {
        System.out.println(String.format("Приемлемая длина номера телефона - от 7 до 15 символов. Было введено: %d.", wrongLength));
    }
}
