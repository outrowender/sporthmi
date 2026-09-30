/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.ddp20;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.ddp20.DisplayStatus;
import org.dsi.ifc.ddp20.VersionInfo;

public interface DSIDDP20Reply {
    public static final String IPL_COMM_UUID = "2c995119-3a7d-5d8d-844d-975971b37be6";
    public static final String IPL_COMM_INTERFACE_KEY = "0f83905d-671b-59bb-bbce-64775a0d8abf";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.2";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.2";

    public void updateVersionInfo(VersionInfo var1, int var2) throws MethodException;

    public void updatePowerStatus(int var1, int var2) throws MethodException;

    public void updateDisplayStatus(DisplayStatus var1, int var2) throws MethodException;

    public void updateBufferStatus(int var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

