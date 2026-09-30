/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombipictureserver;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIKombiPictureServerC {
    public void setKombiHmiReady() throws MethodException;

    public void responseCoverArt(long var1, int var3, int var4, int var5, ResourceLocator var6) throws MethodException;

    public void responseStationArt(long var1, int var3, int var4, int var5, ResourceLocator var6) throws MethodException;

    public void responseActiveCallPicture(int var1, int var2, ResourceLocator var3) throws MethodException;

    public void responseActiveCallPictureInstance(int var1, int var2, int var3, ResourceLocator var4) throws MethodException;

    public void responseDynamicIcon(int var1, int var2, boolean var3, ResourceLocator var4) throws MethodException;

    public void responseAdbContactPicture(long var1, int var3, int var4, ResourceLocator var5) throws MethodException;

    public void responseInternalAddressID(long var1, int var3, int var4) throws MethodException;

    public void responsePictureServerAbilities(int var1) throws MethodException;

    public void responsePictureStream(int var1, short var2, short var3, int var4, int var5, byte[] var6) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

