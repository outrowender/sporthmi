/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync2;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.kombisync2.DisplayIdentification;
import org.dsi.ifc.kombisync2.DisplayRequestResponse;
import org.dsi.ifc.kombisync2.DisplayStatus;
import org.dsi.ifc.kombisync2.MenuState;
import org.dsi.ifc.kombisync2.PopupActionRequestResponse;
import org.dsi.ifc.kombisync2.PopupRegisterRequestResponse;
import org.dsi.ifc.kombisync2.PopupStatus;

public interface DSIKombiSyncC {
    public void setMMIDisplayRequestResponse(DisplayRequestResponse var1) throws MethodException;

    public void setMMIDisplayStatus(DisplayStatus var1) throws MethodException;

    public void setMenuState(MenuState var1) throws MethodException;

    public void setMMIPopupRegisterRequest(PopupRegisterRequestResponse var1) throws MethodException;

    public void setMMIPopupActionResponse(PopupActionRequestResponse var1) throws MethodException;

    public void setMMIPopupStatus(PopupStatus var1) throws MethodException;

    public void setMMIDisplayIdentification(DisplayIdentification var1) throws MethodException;

    public void setHMIIsReady(boolean var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

