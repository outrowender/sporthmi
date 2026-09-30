/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.komoview;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIKOMOViewReply {
    public static final String IPL_COMM_UUID = "413ce613-0a9a-54f6-93e9-bcc0513a92b5";
    public static final String IPL_COMM_INTERFACE_KEY = "7df44811-d014-5086-868d-506d5ebff276";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.15";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.15";

    public void updateKomoViewEnabled(boolean var1, int var2) throws MethodException;

    public void updateVisibility(boolean var1, int var2) throws MethodException;

    public void komoViewResult(int var1) throws MethodException;

    public void updateCurrentKomoViewType(int var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

