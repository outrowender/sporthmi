/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.networking;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.networking.ApplicationErrorStruct;
import org.dsi.ifc.networking.ConnectionStateInformationStruct;
import org.dsi.ifc.networking.DataConnectionStateStruct;

public interface DSIDataConnectionReply {
    public static final String IPL_COMM_UUID = "f6749804-3a69-5465-9822-1d5ccfd38720";
    public static final String IPL_COMM_INTERFACE_KEY = "ac66c0fa-deb7-50a6-834e-d94bf9a5b7ea";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.14";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.14";

    public void updateStateDataConnection(DataConnectionStateStruct var1, int var2) throws MethodException;

    public void updateConnectionStateInformation(ConnectionStateInformationStruct var1, int var2) throws MethodException;

    public void updateRoamingState(int var1, int var2) throws MethodException;

    public void updateErrorState(ApplicationErrorStruct var1, int var2) throws MethodException;

    public void forceDisconnectResponse(int var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

