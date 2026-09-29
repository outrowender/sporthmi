/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util;

import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.LocalPersistNavLocationHelper$NavLocationState;

public class LocalPersistNavLocationHelper {
    private final NavigationEnv navEnv;
    private final int key;

    public LocalPersistNavLocationHelper(NavigationEnv navigationEnv, int n) {
        this.key = n;
        this.navEnv = navigationEnv;
    }

    public void savePersistentState(byte[] byArray) {
        if (byArray.length > 6000) {
            this.navEnv.getLogChannel().log(10000, "LocalPersistNavLocationHelper#savePersistentState() --> NavLocation is too big for the persistence. DONT STORE IT because it would effect the whole HMI (Not only NAVI)");
            return;
        }
        this.navEnv.getLogChannel().log(-2137614336, "LocalPersistNavLocationHelper#savePersistentState()");
        IStorageAccess iStorageAccess = this.navEnv.getFramework().getStorageMgr();
        LocalPersistNavLocationHelper$NavLocationState localPersistNavLocationHelper$NavLocationState = new LocalPersistNavLocationHelper$NavLocationState(iStorageAccess, this.navEnv.getLogChannel(), this.key);
        localPersistNavLocationHelper$NavLocationState.setNavLocation(byArray);
        localPersistNavLocationHelper$NavLocationState.serializeAndWrite();
    }

    public byte[] loadPersistentState() {
        this.navEnv.getLogChannel().log(-2137614336, "LocalPersistNavLocationHelper#loadPersistentState()");
        IStorageAccess iStorageAccess = this.navEnv.getFramework().getStorageMgr();
        if (iStorageAccess == null) {
            return new byte[]{0};
        }
        LocalPersistNavLocationHelper$NavLocationState localPersistNavLocationHelper$NavLocationState = new LocalPersistNavLocationHelper$NavLocationState(iStorageAccess, this.navEnv.getLogChannel(), this.key);
        localPersistNavLocationHelper$NavLocationState.readAndDeserialize();
        if (localPersistNavLocationHelper$NavLocationState.getNavLocation() != null) {
            return localPersistNavLocationHelper$NavLocationState.getNavLocation();
        }
        return new byte[]{0};
    }
}

