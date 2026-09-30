/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager;

import de.audi.app.sdsmanager.apps.ISDSApplication;
import de.audi.app.sdsmanager.syscall.ISystemCall;

public interface ISDSDispatcher {
    public void registerApplication(ISDSApplication var1, byte var2);

    public ISDSApplication getActiveApplication();

    public int[] getSDSCallIDs();

    public String[] getSDSCallNames();

    public ISDSApplication[] getRegisteredApplications();

    public ISDSApplication[] getRegisteredApplications(int var1);

    public ISDSApplication determineSyscallHandler(ISystemCall var1);

    public void checkAbortCurrentCommand(ISystemCall var1);
}

