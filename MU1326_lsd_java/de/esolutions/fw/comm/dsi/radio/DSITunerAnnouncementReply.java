/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSITunerAnnouncementReply {
    public static final String IPL_COMM_UUID = "f2e4c623-f478-5fd5-8be4-378eb42ad970";
    public static final String IPL_COMM_INTERFACE_KEY = "374db20a-d48b-5b4c-b320-ecdb9ee9f9a4";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.36";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.36";

    public void updateFilter(int var1, int var2) throws MethodException;

    public void updateAvailability(int var1, int var2) throws MethodException;

    public void updateStatus(int var1, int var2) throws MethodException;

    public void updateStationName(String var1, int var2, long var3, int var5) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

