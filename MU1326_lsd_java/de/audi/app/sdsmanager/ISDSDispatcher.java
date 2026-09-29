/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager;

import de.audi.app.sdsmanager.apps.ISDSApplication;
import de.audi.app.sdsmanager.syscall.ISystemCall;

public interface ISDSDispatcher {
    default public void registerApplication(ISDSApplication iSDSApplication, byte by) {
    }

    default public ISDSApplication getActiveApplication() {
    }

    default public int[] getSDSCallIDs() {
    }

    default public String[] getSDSCallNames() {
    }

    default public ISDSApplication[] getRegisteredApplications() {
    }

    default public ISDSApplication[] getRegisteredApplications(int n) {
    }

    default public ISDSApplication determineSyscallHandler(ISystemCall iSystemCall) {
    }

    default public void checkAbortCurrentCommand(ISystemCall iSystemCall) {
    }
}

