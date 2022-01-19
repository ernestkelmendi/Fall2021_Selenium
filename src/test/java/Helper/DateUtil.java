package Helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static Date getTomorrowDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    public static String[] getTomorrowDateFields() {
        Date dateTomorrow = getTomorrowDate();
        SimpleDateFormat df = new SimpleDateFormat("d MMMM yyyy");
        return df.format(dateTomorrow).split(" ");
        // [8, January, 2022]
    }

    public static String[] addDaysToTomorrow(int addDays) {
        Date dateTomorrow = getTomorrowDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateTomorrow);
        cal.add(Calendar.DAY_OF_MONTH, addDays);
        Date tomorrowPlusDays = cal.getTime();
        SimpleDateFormat df = new SimpleDateFormat("d MMMM yyyy");
        return df.format(tomorrowPlusDays).split(" ");
        // [15, January, 2022]
    }

    public static boolean isDateInCorrectFormat(String dateText, String expDateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(expDateFormat);
        boolean isDateFormatCorrect = true;

        try {
            sdf.parse(dateText);
        } catch (ParseException e) {
            isDateFormatCorrect = false;
        }

        return isDateFormatCorrect;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(getTomorrowDateFields()));

        System.out.println(Arrays.toString(addDaysToTomorrow(7)));

    }


}
