/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.base.DSIBase;

public interface DSIMediaRecorder
extends DSIBase {
    public static final String VERSION = "2.11.52";
    public static final int ATTR_ACTIVEMEDIA = 1;
    public static final int ATTR_IMPORTSUMMARY = 2;
    public static final int ATTR_IMPORTPROGRESS = 3;
    public static final int ATTR_DELETIONPROGRESS = 4;
    public static final int ATTR_DATABASESPACE = 5;
    public static final int ATTR_IMPORTSTATUS = 6;
    public static final int ATTR_DELETIONSTATUS = 7;
    public static final int ATTR_TARGETMEDIA = 8;
    public static final int RT_SETACTIVEMEDIA = 1000;
    public static final int RT_SETSELECTION = 1001;
    public static final int RT_SETTARGETMEDIA = 1002;
    public static final int RT_STARTIMPORT = 1003;
    public static final int RT_ABORTIMPORT = 1004;
    public static final int RT_STARTDELETE = 1005;
    public static final int RT_ABORTDELETE = 1006;
    public static final int RT_SETENCODINGQUALITY = 1007;
    public static final int RP_RESPONSESETSELECTION = 2000;
    public static final int RP_RESPONSESETENCODINGQUALITY = 2001;
    public static final int IMPORTSTATUS_IDLE = 0;
    public static final int IMPORTSTATUS_IMPORTING = 1;
    public static final int IMPORTSTATUS_PRE_PROCESSING = 2;
    public static final int IMPORTSTATUS_POST_PROCESSING = 3;
    public static final int IMPORTSTATUS_SUCCESS = 4;
    public static final int IMPORTSTATUS_ABORTED = 5;
    public static final int IMPORTSTATUS_SUSPEND = 6;
    public static final int IMPORTSTATUS_READY_FOR_SELECTION = 7;
    public static final int IMPORTSTATUS_READY_FOR_RESUME = 8;
    public static final int DELETIONSTATUS_IDLE = 0;
    public static final int DELETIONSTATUS_DELETING = 1;
    public static final int DELETIONSTATUS_PRE_PROCESSING = 2;
    public static final int DELETIONSTATUS_POST_PROCESSING = 3;
    public static final int DELETIONSTATUS_SUCCESS = 4;
    public static final int DELETIONSTATUS_ABORTED = 5;
    public static final int DELETIONSTATUS_FINISHED_WITH_ERRORS = 6;
    public static final int DELETIONSTATUS_READY_FOR_SELECTION = 7;
    public static final int ENCODINGQUALITY_MAX = 0;
    public static final int ENCODINGQUALITY_HIGH = 1;
    public static final int ENCODINGQUALITY_MEDIUM = 2;
    public static final int ENCODINGQUALITY_LOW = 3;

    public void setActiveMedia(long var1, long var3);

    public void setSelection(int var1);

    public void startImport(boolean var1);

    public void abortImport();

    public void startDelete();

    public void abortDelete();

    public void setTargetMedia(long var1, long var3);

    public void setEncodingQuality(int var1);
}

