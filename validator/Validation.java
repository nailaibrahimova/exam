package exam.validator;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static boolean validateAge(LocalDate birthdate) {
        Period period = Period.between(birthdate, LocalDate.now());
        if (period.getYears() >= 18) return true;
        else return false;
    }

    public static boolean validateTelephone(String telephone) {
        Pattern p = Pattern.compile("^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\\\s\\\\./0-9]*$");
        Matcher m = p.matcher(telephone);
        return m.matches();
    }
}
