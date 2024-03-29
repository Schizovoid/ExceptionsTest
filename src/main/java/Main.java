import Exceptions.IncorrectDOBFormatException;
import Exceptions.IncorrectGenderFormatException;
import Exceptions.IncorrectPhoneNumberException;
import Exceptions.WrongDataFormatException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws WrongDataFormatException {
        PersonalData personalData = null;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Пожалуйста, введите ваши ФИО, дату рождения (в формате dd.mm.yyyy), номер телефона и пол (m/f), разделяя их пробелами: ");
            String pd = scanner.nextLine();
            String delims = "[ ]+";
            String[] tokens = pd.split(delims);
            personalData = new PersonalData(tokens[0], tokens[1], tokens[2], tokens[3], Long.parseLong(tokens[4]), tokens[5].toLowerCase().charAt(0));
            if (tokens.length > 6) {
                throw new WrongDataFormatException("Было введено больше данных, чем ожидалось. Попробуйте ещё раз.");
            }
            // Исключения, связанные с полом
            if (personalData.getGender() != 'f' & personalData.getGender() != 'm') {
                throw new IncorrectGenderFormatException(personalData.getGender());
            }
            // Исключения, связанные с номером телефона
            if (personalData.getPhoneNumberLength() < 7 || personalData.getPhoneNumberLength() > 15){
                throw new IncorrectPhoneNumberException(personalData.getPhoneNumberLength());
            }
            // Исключения, связанные с датами
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            Date userDOB = format.parse(personalData.getDOB());
            Date currentDate = new Date();
            if (userDOB.after(currentDate)){
                throw new IncorrectDOBFormatException("Указанная дата рождения позже сегодняшней даты.");
            }
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            throw new WrongDataFormatException("Было введено меньше данных, чем ожидалось. Попробуйте ещё раз.");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        CreatePersonalFile(personalData);
    }
    private static void CreatePersonalFile(PersonalData pd) {
        try {
            File file = new File(String.format("src/main/resources/FilesForPersonalData/%s.txt", pd.getSurname()));
            if (!file.exists()){
                file.createNewFile();
            }
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(pd.toString());
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
