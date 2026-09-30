/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.calendar.db.provider;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.calendar.CalendarConfig;
import org.dsi.ifc.calendar.ProfileInfo;
import org.dsi.ifc.calendar.VCalendar;
import org.dsi.ifc.global.DateTime;

public interface VCalendarDbProviderC {
    public void beginTransaction() throws MethodException;

    public void commitTransaction() throws MethodException;

    public void addEntries(int var1, int var2, VCalendar[] var3) throws MethodException;

    public void removeEntries(int var1, int var2, long[] var3) throws MethodException;

    public void removeProfile(int var1) throws MethodException;

    public void removeAll() throws MethodException;

    public void getVersion() throws MethodException;

    public void setActiveProfiles(int[] var1) throws MethodException;

    public void forceGetDataResult(int var1) throws MethodException;

    public void setCalendarConfig(CalendarConfig var1) throws MethodException;

    public void getCalendarConfig(long var1) throws MethodException;

    public void insertProfile(ProfileInfo var1) throws MethodException;

    public void getCalendarEntry(long var1) throws MethodException;

    public void getCalendarSummaries(DateTime var1, DateTime var2) throws MethodException;

    public void deleteProfile(long var1) throws MethodException;
}

