/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.picturehandling;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIPictureHandlingReply {
    public static final String IPL_COMM_UUID = "e7c2f9f0-c6df-58d5-8f32-a9625e4c6cd8";
    public static final String IPL_COMM_INTERFACE_KEY = "1cd88207-dc63-5080-847c-7abf796ccece";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.1";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.1";

    public void indicatePicture(int var1, int var2, ResourceLocator var3, ResourceLocator var4) throws MethodException;

    public void finishPictureRequest(int var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

