/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.calendar;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.calendar.CalendarConfig;
import org.dsi.ifc.calendar.CalendarEntry;
import org.dsi.ifc.calendar.CalendarSummary;

public interface DSICalendarListener
extends DSIListener {
    public void getCalendarSummariesResult(int var1, CalendarSummary[] var2);

    public void getCalendarEntryResult(int var1, CalendarEntry var2);

    public void indicateAlarm(long var1);

    public void setCalendarConfigResult(int var1);

    public void getCalendarConfigResult(int var1, CalendarConfig var2);

    public void setAlarmRepeatResult(int var1);

    public void getAlarmRepeatResult(int var1, long var2);

    public void getEmailAddressesResult(int var1, String[] var2);

    public void getTelephoneNumbersResult(int var1, String[] var2);

    public void insertProfileResult(int var1);

    public void deleteProfileResult(int var1);
}

