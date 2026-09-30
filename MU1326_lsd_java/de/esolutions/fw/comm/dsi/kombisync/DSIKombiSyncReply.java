/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.kombisync.KombiDisplayRequest;
import org.dsi.ifc.kombisync.KombiDisplayStatus;
import org.dsi.ifc.kombisync.KombiPopupStatus;

public interface DSIKombiSyncReply {
    public static final String IPL_COMM_UUID = "40d02636-2ab7-567a-9154-88be065dffaf";
    public static final String IPL_COMM_INTERFACE_KEY = "537ae951-1aea-55dd-a1d3-eb95ccc3ecd3";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.9";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.9";

    public void updateKombiCommunicationState(boolean var1, int var2) throws MethodException;

    public void updateKombiMessageStateDisplayStatus(int var1, int var2) throws MethodException;

    public void updateKombiMessageStateDisplayRequest(int var1, int var2) throws MethodException;

    public void updateKombiMessageStatePopupStatus(int var1, int var2) throws MethodException;

    public void responseKombiDisplayStatus(KombiDisplayStatus var1, int var2) throws MethodException;

    public void responseKombiDisplayRequest(KombiDisplayRequest var1) throws MethodException;

    public void responseKombiPopupStatus(KombiPopupStatus var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

