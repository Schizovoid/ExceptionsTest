package Exceptions;

public class WrongDataFormatException extends  RuntimeException{
    public WrongDataFormatException(){

    }
    public WrongDataFormatException(String message){
        System.out.println(message);
    }
}
