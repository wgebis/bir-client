package com.bir.utils;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;

import java.time.format.DateTimeParseException;

@Slf4j
public class DateConverter {

    public static DateTime unmarshalDateTime(String xmlGregorianCalendar) {
        try {
            DateTime result = DateTime.parse(xmlGregorianCalendar, ISODateTimeFormat.dateTime());
            return result;
        } catch (DateTimeParseException ex) {
            log.error("Could not parse date" + xmlGregorianCalendar, ex);
            return null;
        }
    }

    public static String marshalDateTime(DateTime dateTime) {
        return ISODateTimeFormat.dateTime().print(dateTime);
    }

    public static DateTime unmarshalDate(String xmlGregorianCalendar) {
        try {
            DateTime result = DateTime.parse(xmlGregorianCalendar, ISODateTimeFormat.date());
            return result;
        } catch (DateTimeParseException ex) {
            log.error("Could not parse date" + xmlGregorianCalendar, ex);
            return null;
        }
    }

    public static String marshalDate(DateTime dateTime) {
        return ISODateTimeFormat.date().print(dateTime);
    }
}
