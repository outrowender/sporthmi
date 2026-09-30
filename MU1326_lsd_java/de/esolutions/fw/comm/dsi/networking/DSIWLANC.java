/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.networking;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.networking.Profile;

public interface DSIWLANC {
    public void factoryReset() throws MethodException;

    public void setRole(int var1) throws MethodException;

    public void setRFActive(boolean var1) throws MethodException;

    public void setProfile(Profile var1) throws MethodException;

    public void requestNetworkSearch(int var1, int var2) throws MethodException;

    public void requestAbortSearch() throws MethodException;

    public void requestConnectNetwork(String var1, String var2, String var3, int var4) throws MethodException;

    public void requestDisconnectNetwork(String var1, String var2) throws MethodException;

    public void requestDeleteTrustedNetwork(String var1, String var2) throws MethodException;

    public void requestActivateWps(int var1, int var2, int var3) throws MethodException;

    public void requestCancelWPS() throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

