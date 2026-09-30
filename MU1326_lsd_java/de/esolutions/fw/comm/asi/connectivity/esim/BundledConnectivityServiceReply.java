/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.esim;

import de.esolutions.fw.comm.core.method.MethodException;

public interface BundledConnectivityServiceReply {
    public static final String IPL_COMM_UUID = "f7eca295-e271-472f-bce3-6b7c569ceae6";
    public static final String IPL_COMM_INTERFACE_KEY = "1ae1aea9-f1d3-5c1f-8af6-5b7c05cd405d";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.0.0";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.0";

    public void updateSmsTriggerReceived(int var1) throws MethodException;
}

