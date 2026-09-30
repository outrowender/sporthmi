/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIAdbInitC {
    public void setDefaultPublicProfileVisibility(boolean var1) throws MethodException;

    public void setMaxLocalEntries(int var1) throws MethodException;

    public void setMaxPhoneEntries(int var1) throws MethodException;

    public void setMaxTopDestEntries(int var1) throws MethodException;

    public void setMaxSpeedDialEntries(int var1) throws MethodException;

    public void setNumericalSpellerEnabled(boolean var1) throws MethodException;

    public void setAutoProfileAllocation(boolean var1) throws MethodException;

    public void finalizeConfiguration() throws MethodException;

    public void setSpeedDialType(int var1) throws MethodException;

    public void setProfileHandlingType(int var1) throws MethodException;

    public void setDefaultSortOrder(int var1) throws MethodException;

    public void setOnlineDestinationEnabled(boolean var1) throws MethodException;

    public void setDefaultSOSButton(boolean var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

