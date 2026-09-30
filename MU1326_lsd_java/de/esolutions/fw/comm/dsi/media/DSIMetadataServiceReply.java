/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIMetadataServiceReply {
    public static final String IPL_COMM_UUID = "f6b540c6-1df4-506e-b46d-38dea7ff77d9";
    public static final String IPL_COMM_INTERFACE_KEY = "167d2975-e7a8-5eb9-b571-06f8ba0a537d";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.52";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.52";

    public void updateOnlineLookupStatus(int var1, int var2) throws MethodException;

    public void responseCoverArt(int var1, ResourceLocator var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

