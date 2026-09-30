/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.calendar;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.calendar.CalendarConfig;
import org.dsi.ifc.calendar.CalendarEntry;
import org.dsi.ifc.calendar.CalendarSummary;

public interface DSICalendarReply {
    public static final String IPL_COMM_UUID = "b0c956ce-2978-5f05-a1c0-1c800024a427";
    public static final String IPL_COMM_INTERFACE_KEY = "6a609309-2671-5e07-ae85-f93f7f5634b3";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.2";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.2";

    public void getCalendarSummariesResult(int var1, CalendarSummary[] var2) throws MethodException;

    public void getCalendarEntryResult(int var1, CalendarEntry var2) throws MethodException;

    public void indicateAlarm(long var1) throws MethodException;

    public void setCalendarConfigResult(int var1) throws MethodException;

    public void getCalendarConfigResult(int var1, CalendarConfig var2) throws MethodException;

    public void setAlarmRepeatResult(int var1) throws MethodException;

    public void getAlarmRepeatResult(int var1, long var2) throws MethodException;

    public void getEmailAddressesResult(int var1, String[] var2) throws MethodException;

    public void getTelephoneNumbersResult(int var1, String[] var2) throws MethodException;

    public void insertProfileResult(int var1) throws MethodException;

    public void deleteProfileResult(int var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

