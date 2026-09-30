/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.CarBCSpeed;

public interface DSIOnlineTrafficLightInfoReply {
    public static final String IPL_COMM_UUID = "76677848-df67-51c7-98b1-d171f27e1ac0";
    public static final String IPL_COMM_INTERFACE_KEY = "64db6ab0-bf8b-5a8f-bb09-913331a079bb";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.42";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.42";

    public void updateTrafficLightInfo(int var1, int var2, int[] var3, int var4, int var5, int var6) throws MethodException;

    public void updateTrafficLightSpeed(CarBCSpeed var1, int var2) throws MethodException;

    public void updateTrafficLightTime(int var1, int var2, int var3) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

