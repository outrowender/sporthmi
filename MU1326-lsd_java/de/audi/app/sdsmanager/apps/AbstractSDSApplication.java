/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps;

import de.audi.app.sdsmanager.apps.ISDSApplication;
import de.audi.app.sdsmanager.apps.SDSHandlerService;
import de.audi.app.sdsmanager.nbest.NBestStorageAccess;
import de.audi.app.sdsmanager.syscall.ISystemCallParameter;

public abstract class AbstractSDSApplication
implements ISDSApplication {
    protected final SDSHandlerService sdsHandlerService;
    protected final NBestStorageAccess nBestStorage;

    public AbstractSDSApplication(SDSHandlerService sDSHandlerService, NBestStorageAccess nBestStorageAccess) {
        this.sdsHandlerService = sDSHandlerService;
        this.nBestStorage = nBestStorageAccess;
    }

    @Override
    public abstract int[] getCommands() {
    }

    @Override
    public abstract void processCommand(int n, ISystemCallParameter[] iSystemCallParameterArray) {
    }

    @Override
    public void sessionEnded() {
    }

    @Override
    public void sessionStarted() {
    }

    @Override
    public boolean ignoreJoystick() {
        return false;
    }

    @Override
    public void recognizerOpen(boolean bl) {
    }

    @Override
    public boolean freezeLists() {
        return true;
    }

    @Override
    public boolean unfreezeLists() {
        return true;
    }

    @Override
    public boolean isListLineDataGetActive() {
        return false;
    }

    @Override
    public void sdsListLineDataGet(int n, int n2) {
    }

    @Override
    public void entrySelected(int n) {
        this.nBestStorage.setLastRecogLine(true, n);
        this.sdsHandlerService.sendEvent(1000);
    }
}

