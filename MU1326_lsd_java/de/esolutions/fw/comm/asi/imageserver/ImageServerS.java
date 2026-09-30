/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.imageserver;

import de.esolutions.fw.comm.asi.imageserver.ImageServerReply;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ImageServerS {
    public void requestImage(String[] var1, byte var2, boolean var3, ImageServerReply var4) throws MethodException;

    public void requestImageInformation(String[] var1, ImageServerReply var2) throws MethodException;

    public void setNotification(ImageServerReply var1) throws MethodException;

    public void setNotification(long var1, ImageServerReply var3) throws MethodException;

    public void setNotification(long[] var1, ImageServerReply var2) throws MethodException;

    public void clearNotification(ImageServerReply var1) throws MethodException;

    public void clearNotification(long var1, ImageServerReply var3) throws MethodException;

    public void clearNotification(long[] var1, ImageServerReply var2) throws MethodException;
}

