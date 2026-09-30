/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.sdisConfigProvider;

import de.esolutions.fw.comm.asi.sdisConfigProvider.SdisConfigProviderReply;
import de.esolutions.fw.comm.core.method.MethodException;

public interface SdisConfigProviderS {
    public void setNotification(SdisConfigProviderReply var1) throws MethodException;

    public void setNotification(long var1, SdisConfigProviderReply var3) throws MethodException;

    public void setNotification(long[] var1, SdisConfigProviderReply var2) throws MethodException;

    public void clearNotification(SdisConfigProviderReply var1) throws MethodException;

    public void clearNotification(long var1, SdisConfigProviderReply var3) throws MethodException;

    public void clearNotification(long[] var1, SdisConfigProviderReply var2) throws MethodException;
}

