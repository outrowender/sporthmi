/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.audio;

import org.dsi.ifc.base.DSIBase;

public interface DSIAudioManagement
extends DSIBase {
    public static final String VERSION = "2.11.45";
    public static final int RT_FADETOCONNECTION = 1000;
    public static final int RT_RELEASECONNECTION = 1001;
    public static final int RT_GETACTIVECONNECTION = 1002;
    public static final int RT_GETACTIVEENTERTAINMENTCONNECTION = 1003;
    public static final int RT_REQUESTCONNECTION = 1004;
    public static final int RT_SETVOLUMELOCK = 1005;
    public static final int RT_GETVOLUMELOCK = 1006;
    public static final int ATTR_AMAVAILABLE = 1;
    public static final int ATTR_ACTIVECONNECTION = 2;
    public static final int ATTR_ACTIVEENTERTAINMENTCONNECTION = 3;
    public static final int RP_ERRORCONNECTION = 2000;
    public static final int RP_FADEDIN = 2001;
    public static final int RP_PAUSECONNECTION = 2002;
    public static final int RP_STARTCONNECTION = 2003;
    public static final int RP_STOPCONNECTION = 2004;
    public static final int RP_RESPONSEVOLUMELOCK = 2006;

    public void fadeToConnection(int var1, int var2);

    public void releaseConnection(int var1, int var2);

    public void getActiveConnection(int var1);

    public void getActiveEntertainmentConnection(int var1);

    public void requestConnection(int var1, int var2, int var3);

    public void setVolumelock(int var1, int var2, boolean var3);

    public void getVolumelock(int var1, int var2);
}

