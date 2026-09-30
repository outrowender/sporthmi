/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tvtuner;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.tvtuner.EWSInfo;
import org.dsi.ifc.tvtuner.LogoInfo;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;
import org.dsi.ifc.tvtuner.StartUpConfig;

public interface DSITVTunerListener
extends DSIListener {
    public void updateTunerState(int var1, int var2);

    public void updateServiceList(ServiceInfo[] var1, int var2);

    public void updateSelectedService(ProgramInfo var1, int var2);

    public void updateSelectedSource(int var1, int var2);

    public void updateTVNormArea(int var1, int var2);

    public void updateAudioChannel(int var1, int var2);

    public void updateMuteState(int var1, int var2);

    public void updateInfoTextState(String var1, int var2);

    public void updateTerminalMode(int var1, int var2, int var3);

    public void updateServiceLinking(boolean var1, int var2);

    public void updateTVNormList(int[] var1, int var2);

    public void updateTVNormAreaSubList(int[] var1, int var2);

    public void updateAVNorm(int var1, int var2);

    public void updateEWSInfoList(EWSInfo[] var1, int var2);

    public void selectService(int var1);

    public void selectNextService(int var1);

    public void abortSeek(int var1);

    public void switchSource(int var1);

    public void updateSubtitle(boolean var1, int var2);

    public void updateLogoList(LogoInfo[] var1, int var2);

    public void updateCASInfo(boolean var1, String var2, int var3);

    public void updateTuneStatus(boolean var1, boolean var2, boolean var3, int var4);

    public void updateMessageService(int var1, int var2);

    public void updateStartUpMUConfig(StartUpConfig var1, int var2);

    public void updateTMTVKeyPanel(short var1, short var2, int var3);

    public void updateBrowserListSort(int var1, int var2);
}

