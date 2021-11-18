package ua.com.alevel;

import java.util.Arrays;

public class StringToDate {
    private static final String[] monthStrings = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    public static Date runStringToDate(String stringInput) {
        Boolean notFound = true;
        Date date = new Date();

        String[] splitString = stringInput.split("\s");
        String[] splitDate;


        if (splitString.length < 2 && splitString[0].split(":").length == 1) {
            date.setHour(0);
            date.setMinute(0);
            date.setSecond(0);
            date.setMillisecond(0);
            switch (InputFormat.getInputFormat()) {
                case 1: {
                    if (repeats(splitString[0], '/') == 1) splitString[0] = "/" + splitString[0];
                        splitDate = splitString[0].split("/");
                    try {
                        if (splitDate[0] != "") date.setDay(Integer.parseInt(splitDate[0]));
                        else date.setDay(1);
                        if (splitDate[1] != "") date.setMonth(Integer.parseInt(splitDate[1]));
                        else date.setMonth(1);
                        if (splitDate[2] != "") date.setYear(Integer.parseInt(splitDate[2]));
                        else date.setYear(0);
                    } catch (RuntimeException e) {
                    }
                    break;
                }
                case 2: {
                    if (repeats(splitString[0], '/') == 1) splitString[0] = "/" + splitString[0];
                    splitDate = splitString[0].split("/");
                    try {
                        if (splitDate[0] != "") date.setMonth(Integer.parseInt(splitDate[0]));
                        else date.setMonth(1);
                        if (splitDate[1] != "") date.setDay(Integer.parseInt(splitDate[1]));
                        else date.setDay(1);
                        if (splitDate[2] != "") date.setYear(Integer.parseInt(splitDate[2]));
                        else date.setYear(0);
                    } catch (RuntimeException e) {
                    }
                    break;
                }
                case 3: {
                    if (repeats(splitString[0], '-') == 1) splitString[0] = "-" + splitString[0];
                    splitDate = splitString[0].split("-");
                    try {
                        if (splitDate[0] != "") {
                            for (int i = 0; i < monthStrings.length; i++) {
                                if (splitDate[0].equals(monthStrings[i])) {
                                    date.setMonth(i + 1);
                                    notFound = false;
                                    break;
                                }
                            }
                            if (notFound) return null;
                        } else date.setMonth(1);
                        if (splitDate[1] != "") date.setDay(Integer.parseInt(splitDate[1]));
                        else date.setDay(1);
                        if (splitDate[2] != "") date.setYear(Integer.parseInt(splitDate[2]));
                        else date.setYear(0);
                    } catch (RuntimeException e) {
                    }
                    break;
                }
                case 4: {
                    if (repeats(splitString[0], '-') == 1) splitString[0] = "-" + splitString[0];
                    splitDate = splitString[0].split("-");
                    try {
                        if (splitDate[0] != "") date.setDay(Integer.parseInt(splitDate[0]));
                        else date.setDay(1);
                        if (splitDate[1] != "") {
                            date.setMonth(1);
                            for (int i = 0; i < monthStrings.length; i++) {
                                if (splitDate[1].equals(monthStrings[i])) {
                                    date.setMonth(i + 1);
                                    notFound = false;
                                    break;
                                }
                            }
                            if (notFound) return null;
                        } else date.setMonth(1);
                        if (splitDate[2] != "") date.setYear(Integer.parseInt(splitDate[2]));
                        else date.setYear(0);
                    } catch (RuntimeException e) {
                    }
                    break;
                }
            }
        } else {
            try {
                String[] splitTime = splitString[1].split(":");
                if (splitTime[0] != "") date.setHour(Integer.parseInt(splitTime[0]));
                else date.setHour(0);
                if (splitTime[1] != "") date.setMinute(Integer.parseInt(splitTime[1]));
                else date.setMinute(0);
                if (splitTime[2] != "") date.setSecond(Integer.parseInt(splitTime[2]));
                else date.setSecond(0);
                if (splitTime[3] != "") date.setMillisecond(Integer.parseInt(splitTime[3]));
                else date.setMillisecond(0);
            } catch (RuntimeException e) {
            }
            switch (InputFormat.getInputFormat()) {
                case 1: {
                    if (repeats(splitString[0], '/') == 1) splitString[0] = "/" + splitString[0];
                    splitDate = splitString[0].split("/");
                    try {
                        if (splitDate[0] != "") date.setDay(Integer.parseInt(splitDate[0]));
                        else date.setDay(1);
                        if (splitDate[1] != "") date.setMonth(Integer.parseInt(splitDate[1]));
                        else date.setMonth(1);
                        if (splitDate[2] != "") date.setYear(Integer.parseInt(splitDate[2]));
                        else date.setYear(0);
                    } catch (RuntimeException e) {
                    }
                    break;
                }
                case 2: {
                    if (repeats(splitString[0], '/') == 1) splitString[0] = "/" + splitString[0];
                    splitDate = splitString[0].split("/");
                    try {
                        if (splitDate[0] != "") date.setMonth(Integer.parseInt(splitDate[0]));
                        else date.setMonth(1);
                        if (splitDate[1] != "") date.setDay(Integer.parseInt(splitDate[1]));
                        else date.setDay(1);
                        if (splitDate[2] != "") date.setYear(Integer.parseInt(splitDate[2]));
                        else date.setYear(0);
                    } catch (RuntimeException e) {
                    }
                    break;
                }
                case 3: {
                    if (repeats(splitString[0], '-') == 1) splitString[0] = "-" + splitString[0];
                    splitDate = splitString[0].split("-");
                    try {
                        if (splitDate[0] != "") {
                            date.setMonth(1);
                            for (int i = 0; i < monthStrings.length; i++) {
                                if (splitDate[0].equals(monthStrings[i])) {
                                    date.setMonth(i + 1);
                                    notFound = false;
                                    break;
                                }
                            }
                            if (notFound) return null;
                        } else date.setMonth(1);
                        if (splitDate[1] != "") date.setDay(Integer.parseInt(splitDate[1]));
                        else date.setDay(1);
                        if (splitDate[2] != "") date.setYear(Integer.parseInt(splitDate[2]));
                        else date.setYear(0);
                    } catch (RuntimeException e) {
                    }
                    break;
                }
                case 4: {
                    if (repeats(splitString[0], '-') == 1) splitString[0] = "-" + splitString[0];
                    splitDate = splitString[0].split("-");
                    try {
                        if (splitDate[0] != "") date.setDay(Integer.parseInt(splitDate[0]));
                        else date.setDay(1);
                        if (splitDate[1] != "") {
                            date.setMonth(1);
                            for (int i = 0; i < monthStrings.length; i++) {
                                if (splitDate[1].equals(monthStrings[i])) {
                                    date.setMonth(i + 1);
                                    notFound = false;
                                    break;
                                }
                            }
                            if (notFound) return null;
                        } else date.setMonth(1);
                        if (splitDate[2] != "") date.setYear(Integer.parseInt(splitDate[2]));
                        else date.setYear(0);
                    } catch (RuntimeException e) {
                    }
                    break;
                }
            }
        }

        return date;
    }

    public static int repeats(String str, char sign) {
        int repeats = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == sign) repeats++;
        }
        return repeats;
    }
}
