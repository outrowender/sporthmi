/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIBase;

public interface DSIOnlineTourImport
extends DSIBase {
    public static final String VERSION = "2.11.42";
    public static final int RT_STARTTOURDOWNLOAD = 1000;
    public static final int RT_DISMISSTOURDOWNLOAD = 1001;
    public static final int RT_ACKNOWLEDGETOURIMPORT = 1002;
    public static final int RP_RESPONSETOURDOWNLOAD = 2000;
    public static final int IN_INDICATETOURSAVAILABLE = 3000;
    public static final int IN_INDICATETOURDOWNLOADFINISHED = 3001;
    public static final int DOWNLOADSTATUS_SUCCESS = 0;
    public static final int DOWNLOADSTATUS_STARTED = 1;
    public static final int DOWNLOADSTATUS_DISMISSED = 2;
    public static final int DOWNLOADSTATUS_ERROR = 3;
    public static final int DOWNLOADSTATUS_ERROR_CONNECTIVITY = 4;
    public static final int IMPORTSTATUS_SUCCESS = 0;
    public static final int IMPORTSTATUS_FAILURE = 1;
    public static final int IMPORTSTATUS_ABORTED = 2;
    public static final int IMPORTSTATUS_ABORTED_POWERDOWN = 3;

    public void startTourDownload(int var1);

    public void dismissTourDownload();

    public void acknowledgeTourImport(int var1);
}

