/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.radio.TIMMemoUsage;
import org.dsi.ifc.radio.TIMMessage;
import org.dsi.ifc.radio.TIMStatus;

public interface DSITIMTunerReply {
    public static final String IPL_COMM_UUID = "ab0b1ccd-1313-5f02-b980-547d67d84062";
    public static final String IPL_COMM_INTERFACE_KEY = "0a22f7d7-07bf-5008-901e-a11aaff4d3a8";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.36";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.36";

    public void updateTIMMessageList(TIMMessage[] var1, int var2) throws MethodException;

    public void updateTIMStatus(TIMStatus var1, int var2) throws MethodException;

    public void updateTIMMemoUsage(TIMMemoUsage var1, int var2) throws MethodException;

    public void updateTIMAvailable(int var1, int var2) throws MethodException;

    public void playback(int var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

