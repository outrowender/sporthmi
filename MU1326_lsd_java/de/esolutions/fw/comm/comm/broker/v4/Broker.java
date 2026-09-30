/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.comm.broker.v4;

import de.esolutions.fw.comm.comm.broker.v4.InstanceID;
import de.esolutions.fw.comm.core.method.MethodException;

public interface Broker {
    public static final String IPL_COMM_UUID = "8d4f7cec-be0c-49b7-b1b6-1e3e4c26b847";
    public static final String IPL_COMM_INTERFACE_KEY = "8935d19b-313a-5d23-bf1f-64bc869ad5a7";
    public static final String IPL_COMM_INTERFACE_VERSION = "3.0.0";
    public static final String IPL_COMM_MODULE_VERSION = "4.0.1";

    public void announce(InstanceID var1) throws MethodException;

    public void registerService(InstanceID var1, int var2) throws MethodException;

    public void unregisterService(InstanceID var1, int var2) throws MethodException;

    public void lookupService(InstanceID var1, int var2) throws MethodException;

    public static interface Consts {
    }
}

