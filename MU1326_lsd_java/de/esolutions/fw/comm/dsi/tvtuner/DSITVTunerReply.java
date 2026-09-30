/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tvtuner;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.tvtuner.EWSInfo;
import org.dsi.ifc.tvtuner.LogoInfo;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;
import org.dsi.ifc.tvtuner.StartUpConfig;

public interface DSITVTunerReply {
    public static final String IPL_COMM_UUID = "55ca38d6-fce7-5ad2-96b8-4c9782919cbd";
    public static final String IPL_COMM_INTERFACE_KEY = "39bf8fe7-5332-5d83-8e46-56d7b46ebd67";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.9";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.9";

    public void updateTunerState(int var1, int var2) throws MethodException;

    public void updateServiceList(ServiceInfo[] var1, int var2) throws MethodException;

    public void updateSelectedService(ProgramInfo var1, int var2) throws MethodException;

    public void updateSelectedSource(int var1, int var2) throws MethodException;

    public void updateTVNormArea(int var1, int var2) throws MethodException;

    public void updateAudioChannel(int var1, int var2) throws MethodException;

    public void updateMuteState(int var1, int var2) throws MethodException;

    public void updateInfoTextState(String var1, int var2) throws MethodException;

    public void updateTerminalMode(int var1, int var2, int var3) throws MethodException;

    public void updateServiceLinking(boolean var1, int var2) throws MethodException;

    public void updateTVNormList(int[] var1, int var2) throws MethodException;

    public void updateTVNormAreaSubList(int[] var1, int var2) throws MethodException;

    public void updateAVNorm(int var1, int var2) throws MethodException;

    public void updateEWSInfoList(EWSInfo[] var1, int var2) throws MethodException;

    public void selectService(int var1) throws MethodException;

    public void selectNextService(int var1) throws MethodException;

    public void abortSeek(int var1) throws MethodException;

    public void switchSource(int var1) throws MethodException;

    public void updateSubtitle(boolean var1, int var2) throws MethodException;

    public void updateLogoList(LogoInfo[] var1, int var2) throws MethodException;

    public void updateCASInfo(boolean var1, String var2, int var3) throws MethodException;

    public void updateTuneStatus(boolean var1, boolean var2, boolean var3, int var4) throws MethodException;

    public void updateMessageService(int var1, int var2) throws MethodException;

    public void updateStartUpMUConfig(StartUpConfig var1, int var2) throws MethodException;

    public void updateTMTVKeyPanel(short var1, short var2, int var3) throws MethodException;

    public void updateBrowserListSort(int var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

