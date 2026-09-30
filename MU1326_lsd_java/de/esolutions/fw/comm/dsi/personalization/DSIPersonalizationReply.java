/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.personalization;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIPersonalizationReply {
    public static final String IPL_COMM_UUID = "7d391dea-7dea-58b1-b8be-fea9d4a1e349";
    public static final String IPL_COMM_INTERFACE_KEY = "f913ad4b-0134-5e84-b2e4-69d9bc951858";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.0";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.0";

    public void copyProfile(int var1, int var2) throws MethodException;

    public void resetProfile(int var1) throws MethodException;

    public void resetAllProfiles() throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

