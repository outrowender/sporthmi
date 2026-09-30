/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.esoposproviderfull;

import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.sConfig;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.sMapPosition;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.sPosition;
import de.esolutions.fw.comm.core.method.MethodException;

public interface EsoPosProviderFullReply {
    public static final String IPL_COMM_UUID = "4325a74a-4251-11e3-9bb9-000c29e68a4a";
    public static final String IPL_COMM_INTERFACE_KEY = "995a4140-c7f3-5205-8335-d13059867b08";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.2.5";
    public static final String IPL_COMM_MODULE_VERSION = "1.2.5";

    public void updateState(boolean var1, sConfig var2, int var3) throws MethodException;

    public void updatePosition(String[] var1, sMapPosition var2, sPosition[] var3) throws MethodException;

    public void updateASIVersion(String var1, boolean var2) throws MethodException;
}

