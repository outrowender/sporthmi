/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.online.PortalADBEntry;

public interface DSIDestinationImportReply {
    public static final String IPL_COMM_UUID = "741c9acc-0404-5fb8-99c7-9cf87244aac9";
    public static final String IPL_COMM_INTERFACE_KEY = "4036fefc-0c4b-5c0e-afac-0d429dbc8f82";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.42";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.42";

    public void downloadAddressListResult(PortalADBEntry[] var1, int var2, int var3) throws MethodException;

    public void stopActionResult(int var1) throws MethodException;

    public void updateEntries(int var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

