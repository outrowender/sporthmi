/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.connectedradio;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.connectedradio.RadioStation;

public interface DSIHybridRadioReply {
    public static final String IPL_COMM_UUID = "32a0f709-ed6a-52b0-b853-40bb0b5c16b4";
    public static final String IPL_COMM_INTERFACE_KEY = "07a916a0-d145-57ef-879b-c9c74eefd6f2";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.2";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.2";

    public void getOnlineRadioAvailabilityResult(int var1, int var2, RadioStation[] var3) throws MethodException;

    public void getRadioStationLogoResult(int var1, int var2, RadioStation[] var3, int var4) throws MethodException;

    public void indicateRadioStationLogoResult(int var1, int var2, RadioStation[] var3, int var4) throws MethodException;

    public void getStreamResult(int var1, int var2, RadioStation var3) throws MethodException;

    public void startSlideshowResult(int var1, int var2, RadioStation var3) throws MethodException;

    public void stopSlideshowResult(int var1, int var2, RadioStation var3) throws MethodException;

    public void updateSlideshow(int var1, RadioStation var2, int var3) throws MethodException;

    public void updateRadioText(int var1, RadioStation var2, int var3) throws MethodException;

    public void cancelGetRadioStationLogoResult(int var1, int var2) throws MethodException;

    public void updateProfileState(int var1, int var2, int var3) throws MethodException;

    public void profileChanged(int var1, int var2) throws MethodException;

    public void profileCopied(int var1, int var2, int var3) throws MethodException;

    public void profileReset(int var1, int var2) throws MethodException;

    public void profileResetAll(int var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

