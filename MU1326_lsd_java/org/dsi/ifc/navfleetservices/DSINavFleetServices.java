/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navfleetservices;

import org.dsi.ifc.base.DSIBase;

public interface DSINavFleetServices
extends DSIBase {
    public static final String VERSION = "2.11.1";
    public static final int RP_SETVZOTRACKERSTATERESULT = 2000;
    public static final int RP_SETVZODOWNLOADSTATERESULT = 2001;
    public static final int RP_SETLGITRACKERSTATERESULT = 2002;
    public static final int RP_SETLGIDOWNLOADSTATERESULT = 2003;
    public static final int RT_SETVZOTRACKERSTATE = 1000;
    public static final int RT_SETVZODOWNLOADSTATE = 1001;
    public static final int RT_SETLGITRACKERSTATE = 1002;
    public static final int RT_SETLGIDOWNLOADSTATE = 1003;
    public static final int APPSTATE_ACTIVE = 0;
    public static final int APPSTATE_FORBIDDENROAMING = 1;
    public static final int APPSTATE_DEACTIVATE = 2;
    public static final int NCFSRESULTCODE_OK = 0;
    public static final int NCFSRESULTCODE_ERROR = 1;

    public void setVZOTrackerState(int var1);

    public void setVZODownloadState(int var1);

    public void setLGITrackerState(int var1);

    public void setLGIDownloadState(int var1);
}

