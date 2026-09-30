/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking;

import de.esolutions.fw.comm.core.method.MethodException;

public interface SdisAuthentication {
    public static final String IPL_COMM_UUID = "4403e802-2d1f-11e4-8e5e-9b52416440fb";
    public static final String IPL_COMM_INTERFACE_KEY = "a7fca16c-045c-5224-a8af-1013489e690d";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.0.0";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.0";

    public void sdisAuthenticationSuccessful(String var1) throws MethodException;

    public static interface Consts {
    }
}

