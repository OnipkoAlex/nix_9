package ua.com.alevel;

public class DateDifference {

    public static void runDateDiff() {
        Date dateOne;
        Date dateTwo;
        Date difference;

        dateOne = EnterDateMenu.enterDate();
        dateTwo = EnterDateMenu.enterDate();
        if (dateOne == null || dateTwo == null) return;

        if (isAfter(dateOne, dateTwo) == dateOne) {
            difference = millisecondsToDate(dateToMilliseconds(dateOne) - dateToMilliseconds(dateTwo));
            System.out.print("Difference: ");
            System.out.println(difference.getYear() + " years, " + difference.getMonth() + " months, " + difference.getDay() + " days, " + difference.getHour() + " hours, " + difference.getMinute() + " minutes, " + difference.getSecond() + " seconds, " + difference.getMillisecond() + " milliseconds.");
            System.out.println();
        } else if (isAfter(dateOne, dateTwo) == dateTwo) {
            difference = millisecondsToDate(dateToMilliseconds(dateTwo) - dateToMilliseconds(dateOne));
            System.out.print("Difference: ");
            System.out.println(difference.getYear() + " years, " + difference.getMonth() + " months, " + difference.getDay() + " days, " + difference.getHour() + " hours, " + difference.getMinute() + " minutes, " + difference.getSecond() + " seconds, " + difference.getMillisecond() + " milliseconds.");
            System.out.println();
        } else {
            System.out.println("Dates are equal.");
        }
    }

    public static Date isAfter(Date dateOne, Date dateTwo) {
        if (dateToMilliseconds(dateTwo) > dateToMilliseconds(dateOne)) return dateTwo;
        else return dateOne;
    }

    public static Long dateToMilliseconds(Date date) {
        return (31557600000L * date.getYear() + 2629800000L * date.getMonth() + 86400000L * date.getDay() + 3600000L * date.getHour() + 60000L * date.getMinute() + 1000L * date.getSecond() + date.getMillisecond());
    }

    public static Date millisecondsToDate(Long milli) {
        Date date = new Date();
        date.setYear(Integer.parseInt(String.valueOf(milli / 31557600000L)));
        milli -= milli / 31557600000L * 31557600000L;
        date.setMonth(Integer.parseInt(String.valueOf(milli / 2629800000L)));
        milli -= milli / 2629800000L * 2629800000L;
        date.setDay(Integer.parseInt(String.valueOf(milli / 86400000L)));
        milli -= milli / 86400000L * 86400000L;
        date.setHour(Integer.parseInt(String.valueOf(milli / 3600000L)));
        milli -= milli / 3600000L * 3600000L;
        date.setMinute(Integer.parseInt(String.valueOf(milli / 60000L)));
        milli -= milli / 60000L * 60000L;
        date.setSecond(Integer.parseInt(String.valueOf(milli / 1000L)));
        milli -= milli / 1000L * 1000L;
        date.setMillisecond(milli.intValue());
        return date;
    }
}
