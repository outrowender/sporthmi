/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.kombisync.MMIDisplayRequest;
import org.dsi.ifc.kombisync.MMIDisplayStatus;
import org.dsi.ifc.kombisync.MMIPopupRequest;
import org.dsi.ifc.kombisync.MenuState;

public interface DSIKombiSyncC {
    public void setMMIDisplayStatus(MMIDisplayStatus var1) throws MethodException;

    public void setMMIDisplayRequest(MMIDisplayRequest var1) throws MethodException;

    public void setMenuState(MenuState var1) throws MethodException;

    public void setMMIPopupRequest(MMIPopupRequest var1) throws MethodException;

    public void setHMIIsReady(boolean var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

