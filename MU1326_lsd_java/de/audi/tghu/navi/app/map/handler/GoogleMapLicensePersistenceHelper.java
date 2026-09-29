/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.handler.GoogleMapLicenseHandler;
import de.audi.tghu.navi.app.map.handler.GoogleMapLicensePersistenceHelper$GoogleMapLicenseState;

public class GoogleMapLicensePersistenceHelper {
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private final int key;

    public GoogleMapLicensePersistenceHelper(NavigationEnv navigationEnv, int n, LogChannel logChannel) {
        this.env = navigationEnv;
        this.key = n;
        this.logChannel = logChannel;
    }

    public int loadState() {
        this.logChannel.log(14808325, "GoogleMapLicensePersistenceHelper#loadState()");
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        if (iStorageAccess == null) {
            return -1;
        }
        GoogleMapLicensePersistenceHelper$GoogleMapLicenseState googleMapLicensePersistenceHelper$GoogleMapLicenseState = new GoogleMapLicensePersistenceHelper$GoogleMapLicenseState(iStorageAccess, this.logChannel, this.key);
        googleMapLicensePersistenceHelper$GoogleMapLicenseState.readAndDeserialize();
        int n = googleMapLicensePersistenceHelper$GoogleMapLicenseState.getGoogleMapLicenseState();
        if (GoogleMapLicenseHandler.isValidGoogleMapLicenseState(n)) {
            return n;
        }
        this.logChannel.log(10000, "GoogleMapLicensePersistenceHelper#persistState() - read invalid state: %1, return default ", (long)n);
        return -1;
    }

    public void persistState(int n) {
        this.logChannel.log(14808325, "GoogleMapLicensePersistenceHelper#persistState( %1 ) ", (long)n);
        if (!GoogleMapLicenseHandler.isValidGoogleMapLicenseState(n)) {
            this.logChannel.log(10000, "GoogleMapLicensePersistenceHelper#persistState() - not persisting invalid state: %1 ", (long)n);
            return;
        }
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        GoogleMapLicensePersistenceHelper$GoogleMapLicenseState googleMapLicensePersistenceHelper$GoogleMapLicenseState = new GoogleMapLicensePersistenceHelper$GoogleMapLicenseState(iStorageAccess, this.logChannel, this.key);
        googleMapLicensePersistenceHelper$GoogleMapLicenseState.setGoogleMapLicenseState(n);
        googleMapLicensePersistenceHelper$GoogleMapLicenseState.serializeAndWrite();
    }
}

