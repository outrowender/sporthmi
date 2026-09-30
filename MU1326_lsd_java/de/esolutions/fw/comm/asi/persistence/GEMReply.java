/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.persistence;

import de.esolutions.fw.comm.core.method.MethodException;

public interface GEMReply {
    public static final String IPL_COMM_UUID = "116d951a-df12-5d02-93b4-69573b9d69b5";
    public static final String IPL_COMM_INTERFACE_KEY = "eddb9230-0b3c-558e-b321-dbb0a049fbfb";
    public static final String IPL_COMM_INTERFACE_VERSION = "0.0.1";
    public static final String IPL_COMM_MODULE_VERSION = "0.0.3";

    public void gemActive(boolean var1) throws MethodException;
}

