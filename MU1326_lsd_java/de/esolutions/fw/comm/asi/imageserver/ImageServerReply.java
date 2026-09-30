/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.imageserver;

import de.esolutions.fw.comm.asi.imageserver.Image;
import de.esolutions.fw.comm.asi.imageserver.ImageInfo;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ImageServerReply {
    public static final String IPL_COMM_UUID = "4859e928-623e-4248-8210-d55453bef3a4";
    public static final String IPL_COMM_INTERFACE_KEY = "b9a016f3-d0ec-5bf0-bc90-42549185f0a0";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.0.1";
    public static final String IPL_COMM_MODULE_VERSION = "2.0.1";

    public void responseImage(String var1, Image var2, int var3) throws MethodException;

    public void responseImageInformation(String var1, ImageInfo var2, int var3) throws MethodException;

    public void updateASIVersion(String var1, boolean var2) throws MethodException;
}

