/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.organizer.AdbEntry;

public interface DSIAdbEdit
extends DSIBase {
    public static final String VERSION = "2.11.31";
    public static final int RT_INSERTENTRY = 1000;
    public static final int RT_GETENTRIES = 1001;
    public static final int RT_CHANGEENTRY = 1002;
    public static final int RT_COPYENTRY = 1003;
    public static final int RT_DELETEENTRIES = 1004;
    public static final int RT_GETENTRYDATASETS = 1007;
    public static final int RT_SETSPEEDDIAL = 1008;
    public static final int RT_DELETESPEEDDIAL = 1009;
    public static final int RT_GETENTRYBYREFERENCEID = 1010;
    public static final int ATTR_NEWENTRYAVAILABLE = 1;
    public static final int ATTR_NEWPUBLICPROFILEENTRYAVAILABLE = 2;
    public static final int ATTR_NEWTOPDESTINATIONENTRYAVAILABLE = 3;
    public static final int ATTR_NEWPUBLICPROFILETOPDESTENTRYAVAILABLE = 4;
    public static final int ATTR_NEWONLINEDESTINATIONENTRYAVAILABLE = 5;
    public static final int RP_INSERTENTRYRESULT = 2000;
    public static final int RP_GETENTRIESRESULT = 2001;
    public static final int RP_COPYENTRYRESULT = 2002;
    public static final int RP_DELETEENTRIESRESULT = 2003;
    public static final int RP_CHANGEENTRYRESULT = 2006;
    public static final int RP_GETENTRYDATASETSRESULT = 2007;
    public static final int RP_SETSPEEDDIALRESULT = 2008;
    public static final int RP_DELETESPEEDDIALRESULT = 2009;
    public static final int RP_GETENTRYBYREFERENCEIDRESULT = 2010;

    public void insertEntry(AdbEntry var1, int var2);

    public void getEntries(long[] var1, int var2, int var3);

    public void getEntryDataSets(long[] var1, int var2, int var3);

    public void changeEntry(AdbEntry var1, int var2);

    public void copyEntry(long var1);

    public void deleteEntries(long[] var1, int var2, int var3);

    public void setSpeedDial(AdbEntry var1);

    public void deleteSpeedDial(int var1);

    public void getEntryByReferenceId(String var1);
}

