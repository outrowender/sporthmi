/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.dsi;

import de.audi.atip.interapp.displaymanager.Cropping;
import org.dsi.ifc.tvtuner.ServiceInfo;

public interface DSITV {
    public void setNormAreaSubList(int[] var1);

    public void setNormArea(int var1);

    public void setAudioChannel(int var1);

    public void enableServiceLinking(boolean var1);

    public void enableSubtitle(boolean var1);

    public void selectService(ServiceInfo var1, boolean var2);

    public void changeService(ServiceInfo var1, boolean var2);

    public void selectNextService(int var1);

    public void abortSeek();

    public void switchSource(int var1, boolean var2);

    public void setTerminalMode(int var1, int var2);

    public void setTMTVKeyPanel(short var1, short var2);

    public void incMoved(int var1);

    public void setAVNorm(int var1);

    public void setBrowserListSort(int var1);

    public void setCropping(Cropping var1, int var2, int var3, int var4, int var5, int var6, int var7);

    public void setBrightness(int var1, int var2);

    public void setContrast(int var1, int var2);

    public void setColor(int var1, int var2);

    public void setTint(int var1, int var2);

    public void startComponent(int var1);

    public void startComponent(int var1, int var2, int var3);

    public void stopComponent(int var1);

    public void stopComponent(int var1, int var2, int var3);
}

