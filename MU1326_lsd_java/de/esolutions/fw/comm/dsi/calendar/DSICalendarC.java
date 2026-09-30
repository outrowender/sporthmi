/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.calendar;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.calendar.CalendarConfig;
import org.dsi.ifc.calendar.ProfileInfo;
import org.dsi.ifc.global.DateTime;

public interface DSICalendarC {
    public void getCalendarSummaries(DateTime var1, DateTime var2) throws MethodException;

    public void getCalendarEntry(long var1) throws MethodException;

    public void setCalendarConfig(CalendarConfig var1) throws MethodException;

    public void getCalendarConfig(long var1) throws MethodException;

    public void setAlarm(long var1, long var3) throws MethodException;

    public void getAlarm(long var1) throws MethodException;

    public void getEmailAddresses(long var1) throws MethodException;

    public void getTelephoneNumbers(long var1) throws MethodException;

    public void insertProfile(ProfileInfo var1) throws MethodException;

    public void deleteProfile(long var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

