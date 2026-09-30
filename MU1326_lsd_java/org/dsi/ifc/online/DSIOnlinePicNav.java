/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIBase;

public interface DSIOnlinePicNav
extends DSIBase {
    public static final String VERSION = "2.11.42";
    public static final int ATTR_SYNCSTATUS = 1;
    public static final int RT_SYNCHRONIZE = 1000;
    public static final int RT_ABORTSYNC = 1001;
    public static final int RT_GETPENDINGTRANSACTIONS = 1003;
    public static final int RT_SETACTIVEPROFILE = 1004;
    public static final int RP_SYNCHRONIZERESULT = 2000;
    public static final int RP_GETPENDINGTRANSACTIONSRESULT = 2001;
    public static final int RP_SETACTIVEPROFILERESULT = 2002;
    public static final int RESULT_ERROR = 0;
    public static final int RESULT_OK = 1;
    public static final int RESULT_ABORT = 2;

    public void synchronize();

    public void abortSync();

    public void getPendingTransactions();

    public void setActiveProfile(int var1);
}

