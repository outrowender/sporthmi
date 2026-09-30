/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.sdis.version;

import de.esolutions.fw.comm.core.method.MethodException;

public interface SDISVersionReply {
    public static final String IPL_COMM_UUID = "af682e42-9d3b-11e3-8d05-425861b86ab6";
    public static final String IPL_COMM_INTERFACE_KEY = "d416a5aa-8b20-525c-a84a-e810898c7325";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.0.0";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.0";

    public void updateASIVersion(String var1, boolean var2) throws MethodException;

    public void updateSDISInterfaceVersion(String var1, boolean var2) throws MethodException;

    public void updateMMXSWVersion(String var1, boolean var2) throws MethodException;

    public void updateMMXSKUVersion(String var1, boolean var2) throws MethodException;

    public void updateMUDetailedVersion(String var1, boolean var2) throws MethodException;
}

