/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.ddp20;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.ddp20.DisplayRequest;
import org.dsi.ifc.ddp20.UpdateRequest;

public interface DSIDDP20C {
    public void getDisplayStatus() throws MethodException;

    public void setHMIState(int var1, int var2, int var3) throws MethodException;

    public void setNaviState(int var1, int var2) throws MethodException;

    public void setMediaState(int var1) throws MethodException;

    public void setPhoneState(int var1, int var2, int var3) throws MethodException;

    public void setFrameStatus(DisplayRequest var1) throws MethodException;

    public void setFrameUpdate(UpdateRequest var1) throws MethodException;

    public void setManeuver(int var1, short[] var2, boolean var3) throws MethodException;

    public void setCompass(int var1, short[] var2, boolean var3) throws MethodException;

    public void setDistanceBar(int var1, int var2, boolean var3, boolean var4) throws MethodException;

    public void setDeviationBar(int var1, int var2, boolean var3, boolean var4) throws MethodException;

    public void setText(int var1, int var2, String var3, int var4, boolean var5) throws MethodException;

    public void setTextStyle(int var1, int var2, int var3, int var4, boolean var5) throws MethodException;

    public void setColor(int var1, int var2, int[] var3, boolean var4) throws MethodException;

    public void setCursor(int var1, int var2, int var3, int var4, int var5, boolean var6) throws MethodException;

    public void setTrafficSign(int var1, int var2, int var3, int var4, boolean var5) throws MethodException;

    public void setLaneGuidanceHeader(int var1, int var2, int var3, int var4, int var5, boolean var6) throws MethodException;

    public void setLaneGuidanceData(int var1, int var2, int var3, int var4, short[] var5, boolean var6) throws MethodException;

    public void setCodePage(int var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

