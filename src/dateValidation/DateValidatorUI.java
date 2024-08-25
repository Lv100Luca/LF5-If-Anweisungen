package dateValidation;

public class DateValidatorUI {
    public static void main(String[] args) {
        DateValidator validator = new DateValidator();

        System.out.print("Tag: ");
        int day = Integer.parseInt(System.console().readLine());

        System.out.print("Monat: ");
        int month = Integer.parseInt(System.console().readLine());

        System.out.print("Jahr: ");
        int year = Integer.parseInt(System.console().readLine());

        if (validator.validateDate(day, month, year))
            System.out.println("Das Datum ist richtig!");
        else
            System.out.println("Das Datum ist falsch!");
    }

}
