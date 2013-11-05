package com.deloitte.google.medassist.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import android.text.Html;
import android.text.TextUtils;

public class StringUtils {

    public static final String EMPTY_STRING = "";

    private static final String NULL_STRING = "null";

    public static String extractContentFromHtml(String value) {
        if (value == null) {
            return null;
        }
        return (Html.fromHtml(value)).toString();
    }

    public static boolean isNull(String value) {
        return value == null;
    }

    public static boolean isNotNull(String value) {
        return !isNull(value);
    }

    public static boolean isEmpty(String value) {
        return value == null || value.length() == 0;
    }

    public static boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }

    public static boolean isBlank(String value) {
        return value == null || value.trim().length() == 0;
    }

    public static boolean isNotBlank(String value) {
        return !isBlank(value);
    }

    public static boolean isValid(String value) {
        // we check for the "null" string because it's possible that value can
        // be returned by services
        return !TextUtils.isEmpty(value) && !value.equalsIgnoreCase(NULL_STRING);
    }

    // "sample phrase" --> "Sample Phrase",
    // "target giftCards" --> "Target Giftcards"
    public static String titleCase(String value) {
        return titleCaseInternal(value, true);
    }

    // "sample phrase" --> "Sample Phrase",
    // "target giftCards" --> "Target GiftCards"
    public static String capitalizeFirstCharInWord(String value) {
        return titleCaseInternal(value, false);
    }

    /**
     * Trims the value and capitalizes the first character using {@link Character.toUpperCase}
     * <p/>
     * <code>
     * "sample phrase" --> "Sample phrase"<br/>
     * "aAbB" --> "AAbB"<br/>
     * "  leading and trailing whitespace is trimmed " --> "Leading and trailing whitespace is trimmed"<br/>
     * "  " --> ""
     * </code>
     */
    public static String capitalizeFirstChar(String value) {
        if (isBlank(value)) {
            return value.trim();
        }

        StringBuilder builder = new StringBuilder(value.trim());
        char first = builder.charAt(0);
        builder.setCharAt(0, Character.toUpperCase(first));

        return builder.toString();
    }

    private static String titleCaseInternal(String value, boolean lowerCaseOthers) {
        if (value == null || value.length() == 0) {
            return value;
        }

        int strLen = value.length();
        StringBuffer buffer = new StringBuffer(strLen);
        boolean capitalizeNext = true;
        for (int i = 0; i < strLen; i++) {
            char ch = value.charAt(i);

            if (Character.isWhitespace(ch)) {
                buffer.append(ch);
                capitalizeNext = true;
            } else if (capitalizeNext) {
                buffer.append(Character.toTitleCase(ch));
                capitalizeNext = false;
            } else {
                if (lowerCaseOthers) {
                    buffer.append(Character.toLowerCase(ch));
                } else {
                    buffer.append(ch);
                }
            }
        }
        return buffer.toString();
    }

    public static String format(List<String> strings) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < strings.size(); i++) {
            builder.append(strings.get(i));
            if (i < strings.size() - 1) {
                builder.append(", ");
            }
        }

        return builder.toString();
    }

    public static String createSeparateString(List<String> stringList, String separator) {
        if (stringList == null) {
            return StringUtils.EMPTY_STRING;
        }
        return createSeparatedString(stringList.toArray(new String[stringList.size()]), separator);
    }

    public static String createSeparatedString(String[] strings, String separator) {
        StringBuilder builder = new StringBuilder();
        int size = strings.length;
        int last = size - 1;
        for (int i = 0; i < size; i++) {
            builder.append(strings[i]);
            if (i != last) {
                builder.append(separator);
            }
        }
        return builder.toString();
    }

    public static String formateDateString(String inputDate, String formatIn, String formatOut) {
        // Sample input date Thu Jan 19 16:49:38 UTC 2012
        SimpleDateFormat mDateParser = new SimpleDateFormat(formatIn, Locale.ENGLISH);
        SimpleDateFormat mDateFormatter = new SimpleDateFormat(formatOut, Locale.US);
        Date start = null;
        try {
            String cleandate = inputDate.replaceAll("UTC", "");
            start = mDateParser.parse(cleandate);
        } catch (ParseException e) {
            // Note: this exception can happen if jibberish is passed in. If so,
            // just return inputDate "as is".
            return inputDate;
        }
        return mDateFormatter.format(start);
    }

    public static boolean containsIgnoreCase(List<String> l, String s) {
        Iterator<String> it = l.iterator();
        while (it.hasNext()) {
            if (it.next().equalsIgnoreCase(s)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns either the passed in String, or if the String is null, {@link #EMPTY_STRING}.
     * 
     * @param str
     *            the String to check, may be null
     * @return the passed in String, or {@link #EMPTY_STRING} if it was null
     */
    public static String defaultString(String str) {
        return defaultString(str, EMPTY_STRING);
    }

    /**
     * Returns either the passed in String, or if the String is null, the value of defaultStr.
     * 
     * @param str
     *            the String to check, may be null
     * @param defaultStr
     *            the default String to return if the input is null, may be null
     * @return the passed in String, or the default if it was null
     */
    public static String defaultString(String str, String defaultStr) {
        return str != null ? str : defaultStr;
    }

}
