/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.connectedradio;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.connectedradio.RadioStation;

public interface DSIHybridRadioC {
    public void getOnlineRadioAvailability(int var1, RadioStation[] var2) throws MethodException;

    public void getRadioStationLogo(int var1, RadioStation[] var2, int var3) throws MethodException;

    public void cancelGetRadioStationLogo(int var1) throws MethodException;

    public void getStream(int var1, RadioStation var2) throws MethodException;

    public void startSlideshow(int var1, RadioStation var2, int var3, int var4) throws MethodException;

    public void stopSlideshow(int var1, RadioStation var2) throws MethodException;

    public void profileChange(int var1) throws MethodException;

    public void profileCopy(int var1, int var2) throws MethodException;

    public void profileReset(int var1) throws MethodException;

    public void profileResetAll() throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

