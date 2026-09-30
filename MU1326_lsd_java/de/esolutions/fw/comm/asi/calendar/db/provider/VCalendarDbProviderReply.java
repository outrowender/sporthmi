/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.calendar.db.provider;

import de.esolutions.fw.comm.asi.calendar.db.provider.VersionInfo;
import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.calendar.CalendarConfig;
import org.dsi.ifc.calendar.VEvent;

public interface VCalendarDbProviderReply {
    public static final String IPL_COMM_UUID = "958eeab9-87d2-470a-b62e-bd9bdd6070f6";
    public static final String IPL_COMM_INTERFACE_KEY = "c499e56b-0fd0-59f4-9181-c70e221b3299";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.0.0";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.6";

    public void beginTransactionResult(int var1) throws MethodException;

    public void commitTransactionResult(int var1) throws MethodException;

    public void addEntriesResult(int var1) throws MethodException;

    public void removeEntriesResult(int var1) throws MethodException;

    public void removeProfileResult(int var1) throws MethodException;

    public void removeAllResult(int var1) throws MethodException;

    public void getVersionResult(VersionInfo[] var1) throws MethodException;

    public void setActiveProfilesResult(int var1) throws MethodException;

    public void forceGetData() throws MethodException;

    public void setCalendarConfigResult(int var1) throws MethodException;

    public void getCalendarConfigResult(int var1, CalendarConfig var2) throws MethodException;

    public void insertProfileResult(int var1) throws MethodException;

    public void getCalendarEntryResult(int var1, VEvent var2) throws MethodException;

    public void getCalendarSummariesResult(int var1, VEvent[] var2) throws MethodException;

    public void deleteProfileResult(int var1) throws MethodException;
}

