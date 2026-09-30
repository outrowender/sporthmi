/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombisync2;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.kombisync2.DisplayIdentification;
import org.dsi.ifc.kombisync2.DisplayRequestResponse;
import org.dsi.ifc.kombisync2.DisplayStatus;
import org.dsi.ifc.kombisync2.PopupActionRequestResponse;
import org.dsi.ifc.kombisync2.PopupRegisterRequestResponse;
import org.dsi.ifc.kombisync2.PopupStatus;

public interface DSIKombiSyncListener
extends DSIListener {
    public void updateKombiCommunicationState(boolean var1, int var2);

    public void updateKombiMessageStateDisplayIdentification(int var1, int var2);

    public void updateKombiMessageStateDisplayRequestResponse(int var1, int var2);

    public void updateKombiMessageStateDisplayStatus(int var1, int var2);

    public void updateKombiMessageStatePopupActionRequest(int var1, int var2);

    public void updateKombiMessageStatePopupRegisterResponse(int var1, int var2);

    public void updateKombiMessageStatePopupStatus(int var1, int var2);

    public void responseKombiDisplayRequestResponse(DisplayRequestResponse var1);

    public void responseKombiDisplayStatus(DisplayStatus var1);

    public void responseKombiDisplayIdentification(DisplayIdentification var1);

    public void responseKombiPopupRegisterResponse(PopupRegisterRequestResponse var1);

    public void responseKombiPopupActionRequest(PopupActionRequestResponse var1);

    public void responseKombiPopupStatus(PopupStatus var1);
}

