/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIAdbInitReply {
    public static final String IPL_COMM_UUID = "1269d6bb-274e-5f62-b76b-1600ed2924e4";
    public static final String IPL_COMM_INTERFACE_KEY = "eb4873c9-aba1-5d89-b79b-04f665f38fb6";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.31";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.31";

    public void updateDefaultPublicProfileVisibility(boolean var1, int var2) throws MethodException;

    public void updateMaxLocalEntries(int var1, int var2) throws MethodException;

    public void updateMaxPhoneEntries(int var1, int var2) throws MethodException;

    public void updateMaxTopDestEntries(int var1, int var2) throws MethodException;

    public void updateMaxSpeedDialEntries(int var1, int var2) throws MethodException;

    public void updateAutoProfileAllocation(boolean var1, int var2) throws MethodException;

    public void setDefaultPublicProfileVisibilityResult(int var1) throws MethodException;

    public void setMaxLocalEntriesResult(int var1) throws MethodException;

    public void setMaxPhoneEntriesResult(int var1) throws MethodException;

    public void setMaxTopDestEntriesResult(int var1) throws MethodException;

    public void setMaxSpeedDialEntriesResult(int var1) throws MethodException;

    public void setNumericalSpellerEnabledResult(int var1) throws MethodException;

    public void setAutoProfileAllocationResult(int var1) throws MethodException;

    public void setSpeedDialTypeResult(int var1) throws MethodException;

    public void setProfileHandlingType(int var1) throws MethodException;

    public void setDefaultSortOrderResult(int var1) throws MethodException;

    public void setOnlineDestinationEnabledResult(int var1) throws MethodException;

    public void setDefaultSOSButtonResult(int var1) throws MethodException;

    public void updateDefaultSOSButton(boolean var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

