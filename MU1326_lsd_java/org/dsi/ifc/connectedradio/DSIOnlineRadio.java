/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.connectedradio;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.connectedradio.RadioStation;

public interface DSIOnlineRadio
extends DSIBase {
    public static final String VERSION = "2.11.2";
    public static final int ATTR_PROFILESTATE = 1;
    public static final int RP_GETSTREAMURLRESULT = 2002;
    public static final int RP_GETRADIOSTATIONLOGORESULT = 2003;
    public static final int RP_GETMETAINFORMATIONRESULT = 2004;
    public static final int RP_CANCELDOWNLOADDATABASERESULT = 2005;
    public static final int RP_DOWNLOADDATABASERESULT = 2007;
    public static final int RP_PROFILECHANGED = 2008;
    public static final int RP_PROFILECOPIED = 2009;
    public static final int RP_PROFILERESET = 2010;
    public static final int RP_PROFILERESETALL = 2011;
    public static final int RT_GETRADIOSTATIONLOGO = 1000;
    public static final int RT_GETSTREAMURL = 1001;
    public static final int RT_GETMETAINFORMATION = 1002;
    public static final int RT_DOWNLOADDATABASE = 1003;
    public static final int RT_CANCELDOWNLOADDATABASE = 1004;
    public static final int RT_PROFILECHANGE = 1005;
    public static final int RT_PROFILECOPY = 1006;
    public static final int RT_PROFILERESET = 1007;
    public static final int RT_PROFILERESETALL = 1008;

    public void getRadioStationLogo(int var1, RadioStation var2, int var3);

    public void getStreamUrl(int var1, RadioStation var2);

    public void getMetaInformation(int var1, RadioStation var2);

    public void downloadDatabase(int var1);

    public void cancelDownloadDatabase(int var1);

    public void profileChange(int var1);

    public void profileCopy(int var1, int var2);

    public void profileReset(int var1);

    public void profileResetAll();
}

