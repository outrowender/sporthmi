/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.ooc.app;

import de.esolutions.fw.comm.asi.ooc.app.IOocApplicationReply;
import de.esolutions.fw.comm.core.method.MethodException;

public interface IOocApplicationS {
    public void setCarWakeup(boolean var1, IOocApplicationReply var2) throws MethodException;

    public void setCallActive(boolean var1, IOocApplicationReply var2) throws MethodException;

    public void setPhonePowerDelay(boolean var1, IOocApplicationReply var2) throws MethodException;

    public void setNavigationPowerDelay(boolean var1, IOocApplicationReply var2) throws MethodException;

    public void setApplicationState(int var1, int var2, IOocApplicationReply var3) throws MethodException;

    public void setZrActive(boolean var1, IOocApplicationReply var2) throws MethodException;

    public void registerPowerEventListener(IOocApplicationReply var1) throws MethodException;

    public void shutdownResponseFinal(int var1, IOocApplicationReply var2) throws MethodException;
}

