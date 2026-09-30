/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIBase;

public interface DSIDestinationImport
extends DSIBase {
    public static final String VERSION = "2.11.42";
    public static final int STATUS_OK = 0;
    public static final int ERROR_SERVER_NOT_AVAILABLE = 1000;
    public static final int ERROR_SERVER_DATA_FORMAT_INVALID = 1003;
    public static final int IMPORTSTATUS_OK_IN_PROGRESS = 3001;
    public static final int IMPORTSTATUS_OK_COMPLETED = 3002;
    public static final int IMPORTSTATUS_ERROR_OUT_OF_MEM = 3003;
    public static final int IMPORTSTATUS_ERROR_GENERIC = 3004;
    public static final int RT_DOWNLOADADDRESSLIST = 1003;
    public static final int RT_STOPACTION = 1004;
    public static final int RT_SETADBIMPORTSTATUS = 1005;
    public static final int RP_DOWNLOADADDRESSLISTRESULT = 2000;
    public static final int RP_STOPACTIONRESULT = 2001;
    public static final int ATTR_ENTRIES = 1;

    public void downloadAddressList(int var1, boolean var2);

    public void stopAction();

    public void setADBImportStatus(long[] var1, int var2);
}

