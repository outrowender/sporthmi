/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombipictureserver;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIKombiPictureServerReply {
    public static final String IPL_COMM_UUID = "ea6b5949-422e-560a-a7d3-c20920d9da4d";
    public static final String IPL_COMM_INTERFACE_KEY = "ce643631-ba2b-51a2-9c51-5163c3e28c2a";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.4";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.4";

    public void indicationCoverArt(long var1, int var3, int var4) throws MethodException;

    public void indicationStationArt(long var1, int var3, int var4) throws MethodException;

    public void indicationActiveCallPicture(int var1) throws MethodException;

    public void indicationActiveCallPictureInstance(int var1, int var2) throws MethodException;

    public void indicationDynamicIcon(int var1, int var2) throws MethodException;

    public void indicationInternalAddressID(long var1, int var3) throws MethodException;

    public void indicationAdbContactPicture(long var1, int var3) throws MethodException;

    public void indicationPictureStreamAbilities() throws MethodException;

    public void indicationPictureStream(int var1, short var2, short var3, int var4, int var5, int var6, int var7, byte[] var8) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

