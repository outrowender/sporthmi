/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.connectedradio;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.connectedradio.RadioStation;

public interface DSIHybridRadio
extends DSIBase {
    public static final String VERSION = "2.11.2";
    public static final int IN_INDICATERADIOSTATIONLOGORESULT = 3000;
    public static final int ATTR_SLIDESHOW = 1;
    public static final int ATTR_RADIOTEXT = 2;
    public static final int ATTR_PROFILESTATE = 3;
    public static final int RP_GETONLINERADIOAVAILABILITYRESULT = 2001;
    public static final int RP_GETRADIOSTATIONLOGORESULT = 2003;
    public static final int RP_GETSTREAMRESULT = 2004;
    public static final int RP_STARTSLIDESHOWRESULT = 2000;
    public static final int RP_STOPSLIDESHOWRESULT = 2006;
    public static final int RP_CANCELGETRADIOSTATIONLOGORESULT = 2007;
    public static final int RP_PROFILECHANGED = 2008;
    public static final int RP_PROFILECOPIED = 2009;
    public static final int RP_PROFILERESET = 2010;
    public static final int RP_PROFILERESETALL = 2011;
    public static final int RT_GETONLINERADIOAVAILABILITY = 1001;
    public static final int RT_GETRADIOSTATIONLOGO = 1002;
    public static final int RT_GETSTREAM = 1003;
    public static final int RT_STOPSLIDESHOW = 1005;
    public static final int RT_CANCELGETRADIOSTATIONLOGO = 1008;
    public static final int RT_STARTSLIDESHOW = 1009;
    public static final int RT_PROFILECHANGE = 1010;
    public static final int RT_PROFILECOPY = 1011;
    public static final int RT_PROFILERESET = 1012;
    public static final int RT_PROFILERESETALL = 1013;

    public void getOnlineRadioAvailability(int var1, RadioStation[] var2);

    public void getRadioStationLogo(int var1, RadioStation[] var2, int var3);

    public void cancelGetRadioStationLogo(int var1);

    public void getStream(int var1, RadioStation var2);

    public void startSlideshow(int var1, RadioStation var2, int var3, int var4);

    public void stopSlideshow(int var1, RadioStation var2);

    public void profileChange(int var1);

    public void profileCopy(int var1, int var2);

    public void profileReset(int var1);

    public void profileResetAll();
}

