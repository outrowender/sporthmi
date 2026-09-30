/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.picturehandling;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIPictureHandlingC {
    public void setPictureConfig(int var1, int var2, int var3) throws MethodException;

    public void requestPictures(int var1, ResourceLocator[] var2, int var3) throws MethodException;

    public void cancelPicture(int var1) throws MethodException;

    public void freePicture(ResourceLocator var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

