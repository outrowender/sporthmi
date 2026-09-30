/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.esoposproviderfull;

import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.sConfig;
import de.esolutions.fw.comm.core.method.MethodException;

public interface EsoPosProviderFullC {
    public void setActive(boolean var1) throws MethodException;

    public void setConfig(sConfig var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void setNotification(long var1) throws MethodException;

    public void setNotification(long[] var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void clearNotification(long var1) throws MethodException;

    public void clearNotification(long[] var1) throws MethodException;
}

