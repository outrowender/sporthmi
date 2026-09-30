/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DataSet;

public interface DSIAdbEditReply {
    public static final String IPL_COMM_UUID = "f0118e22-e5d7-5253-aeb9-0a19a9bcd4a4";
    public static final String IPL_COMM_INTERFACE_KEY = "1fed00ad-7bf5-5ffc-850d-591deb7037aa";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.31";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.31";

    public void updateNewEntryAvailable(boolean var1, int var2) throws MethodException;

    public void updateNewPublicProfileEntryAvailable(boolean var1, int var2) throws MethodException;

    public void updateNewTopDestinationEntryAvailable(boolean var1, int var2) throws MethodException;

    public void updateNewPublicProfileTopDestEntryAvailable(boolean var1, int var2) throws MethodException;

    public void insertEntryResult(int var1, AdbEntry var2) throws MethodException;

    public void getEntriesResult(int var1, AdbEntry[] var2) throws MethodException;

    public void getEntryDataSetsResult(int var1, DataSet[] var2) throws MethodException;

    public void changeEntryResult(int var1, AdbEntry var2) throws MethodException;

    public void copyEntryResult(int var1, AdbEntry var2) throws MethodException;

    public void deleteEntriesResult(int var1) throws MethodException;

    public void setSpeedDialResult(int var1) throws MethodException;

    public void deleteSpeedDialResult(int var1) throws MethodException;

    public void getEntryByReferenceIdResult(int var1, AdbEntry var2) throws MethodException;

    public void updateNewOnlineDestinationEntryAvailable(boolean var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

