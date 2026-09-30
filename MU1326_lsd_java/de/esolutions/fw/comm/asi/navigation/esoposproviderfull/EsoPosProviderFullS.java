/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.esoposproviderfull;

import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.EsoPosProviderFullReply;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.sConfig;
import de.esolutions.fw.comm.core.method.MethodException;

public interface EsoPosProviderFullS {
    public void setActive(boolean var1, EsoPosProviderFullReply var2) throws MethodException;

    public void setConfig(sConfig var1, EsoPosProviderFullReply var2) throws MethodException;

    public void setNotification(EsoPosProviderFullReply var1) throws MethodException;

    public void setNotification(long var1, EsoPosProviderFullReply var3) throws MethodException;

    public void setNotification(long[] var1, EsoPosProviderFullReply var2) throws MethodException;

    public void clearNotification(EsoPosProviderFullReply var1) throws MethodException;

    public void clearNotification(long var1, EsoPosProviderFullReply var3) throws MethodException;

    public void clearNotification(long[] var1, EsoPosProviderFullReply var2) throws MethodException;
}

