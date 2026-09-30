/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.networking;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.networking.CDataProfile;

public interface DSIDataConfigurationC {
    public void setDataProfile(CDataProfile var1) throws MethodException;

    public void automaticProfile(int var1) throws MethodException;

    public void setRoamingState(int var1) throws MethodException;

    public void setConnectionMode(int var1) throws MethodException;

    public void setRequestSetting(int var1, int var2) throws MethodException;

    public void acceptDataRequest(int var1, boolean var2) throws MethodException;

    public void resetPacketCounter() throws MethodException;

    public void restoreFactorySettings() throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

