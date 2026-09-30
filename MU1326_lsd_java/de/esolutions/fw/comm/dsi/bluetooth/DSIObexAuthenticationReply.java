/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.bluetooth;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIObexAuthenticationReply {
    public static final String IPL_COMM_UUID = "d9c776d8-fb7d-57c9-b9c2-b1889d5cc65a";
    public static final String IPL_COMM_INTERFACE_KEY = "5ca256d6-dd8e-51a6-a099-6e1956ccceeb";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.13";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.13";

    public void authenticationRequired(int var1, boolean var2, String var3) throws MethodException;

    public void indAuthentication(boolean var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

