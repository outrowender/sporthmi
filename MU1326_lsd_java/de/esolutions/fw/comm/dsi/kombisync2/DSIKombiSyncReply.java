/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync2;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.kombisync2.DisplayIdentification;
import org.dsi.ifc.kombisync2.DisplayRequestResponse;
import org.dsi.ifc.kombisync2.DisplayStatus;
import org.dsi.ifc.kombisync2.PopupActionRequestResponse;
import org.dsi.ifc.kombisync2.PopupRegisterRequestResponse;
import org.dsi.ifc.kombisync2.PopupStatus;

public interface DSIKombiSyncReply {
    public static final String IPL_COMM_UUID = "30d4067c-4595-5e28-a2f6-cb8f9a05d616";
    public static final String IPL_COMM_INTERFACE_KEY = "286587af-7c4b-5082-b0e2-a5927520759a";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.0";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.0";

    public void updateKombiCommunicationState(boolean var1, int var2) throws MethodException;

    public void updateKombiMessageStateDisplayIdentification(int var1, int var2) throws MethodException;

    public void updateKombiMessageStateDisplayRequestResponse(int var1, int var2) throws MethodException;

    public void updateKombiMessageStateDisplayStatus(int var1, int var2) throws MethodException;

    public void updateKombiMessageStatePopupActionRequest(int var1, int var2) throws MethodException;

    public void updateKombiMessageStatePopupRegisterResponse(int var1, int var2) throws MethodException;

    public void updateKombiMessageStatePopupStatus(int var1, int var2) throws MethodException;

    public void responseKombiDisplayRequestResponse(DisplayRequestResponse var1) throws MethodException;

    public void responseKombiDisplayStatus(DisplayStatus var1) throws MethodException;

    public void responseKombiDisplayIdentification(DisplayIdentification var1) throws MethodException;

    public void responseKombiPopupRegisterResponse(PopupRegisterRequestResponse var1) throws MethodException;

    public void responseKombiPopupActionRequest(PopupActionRequestResponse var1) throws MethodException;

    public void responseKombiPopupStatus(PopupStatus var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

