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

    public abstract int[] getCommands();

    public abstract void processCommand(int var1, ISystemCallParameter[] var2);

    public void sessionEnded() {
    }

    public void sessionStarted() {
    }

    public boolean ignoreJoystick() {
        return false;
    }

    public void recognizerOpen(boolean bl) {
    }

    public boolean freezeLists() {
        return true;
    }

    public boolean unfreezeLists() {
        return true;
    }

    public boolean isListLineDataGetActive() {
        return false;
    }

    public void sdsListLineDataGet(int n, int n2) {
    }

    public void entrySelected(int n) {
        this.nBestStorage.setLastRecogLine(true, n);
        this.sdsHandlerService.sendEvent(1000);
    }
}

