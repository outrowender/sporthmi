/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec;

import de.esolutions.fw.comm.core.method.MethodException;

public interface ComponentProtectionReply {
    public static final String IPL_COMM_UUID = "9e66ab21-39b4-11e0-9e42-0800200c9a66";
    public static final String IPL_COMM_INTERFACE_KEY = "73f457d8-4826-5389-912d-2ec567427974";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.0.1";
    public static final String IPL_COMM_MODULE_VERSION = "1.1.5";

    public void authStringResult(String var1, String var2, byte var3) throws MethodException;
}

