/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.calendar;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.calendar.CalendarConfig;
import org.dsi.ifc.calendar.ProfileInfo;
import org.dsi.ifc.global.DateTime;

public interface DSICalendar
extends DSIBase {
    public static final String VERSION = "2.11.2";
    public static final int RT_GETCALENDARSUMMARIES = 1000;
    public static final int RT_GETCALENDARENTRY = 1001;
    public static final int RT_SETCALENDARCONFIG = 1002;
    public static final int RT_GETCALENDARCONFIG = 1003;
    public static final int RT_SETALARM = 1004;
    public static final int RT_GETALARM = 1005;
    public static final int RT_GETEMAILADDRESSES = 1006;
    public static final int RT_GETTELEPHONENUMBERS = 1007;
    public static final int RT_INSERTPROFILE = 1008;
    public static final int RT_DELETEPROFILE = 1009;
    public static final int RP_GETCALENDARSUMMARIESRESULT = 2000;
    public static final int RP_GETCALENDARENTRYRESULT = 2001;
    public static final int RP_SETCALENDARCONFIGRESULT = 2002;
    public static final int RP_GETCALENDARCONFIGRESULT = 2003;
    public static final int RP_SETALARMREPEATRESULT = 2004;
    public static final int RP_GETALARMREPEATRESULT = 2005;
    public static final int RP_GETEMAILADDRESSESRESULT = 2006;
    public static final int RP_GETTELEPHONENUMBERSRESULT = 2007;
    public static final int RP_INSERTPROFILERESULT = 2008;
    public static final int RP_DELETEPROFILERESULT = 2009;
    public static final int IN_INDICATEALARM = 3000;
    public static final int RESULTTYPE_OK = 0;
    public static final int RESULTTYPE_ERROR = 1;
    public static final int WEEKVIEW_5DAYS = 5;
    public static final int WEEKVIEW_7DAYS = 7;

    public void getCalendarSummaries(DateTime var1, DateTime var2);

    public void getCalendarEntry(long var1);

    public void setCalendarConfig(CalendarConfig var1);

    public void getCalendarConfig(long var1);

    public void setAlarm(long var1, long var3);

    public void getAlarm(long var1);

    public void getEmailAddresses(long var1);

    public void getTelephoneNumbers(long var1);

    public void insertProfile(ProfileInfo var1);

    public void deleteProfile(long var1);
}

