/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.generalvehiclestates;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.generalvehiclestates.TLOInfoElement;

public interface DSIGeneralVehicleStatesC {
    public void setDSSSKombiWarning(int var1) throws MethodException;

    public void setTLOData(int var1, int var2, TLOInfoElement[] var3) throws MethodException;

    public void setAppConnectState(boolean var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

