/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.PersistentState;
import de.audi.tghu.navi.app.map.handler.GoogleMapLicenseHandler;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

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
        this.logChannel.log(100000000, "GoogleMapLicensePersistenceHelper#loadState()");
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        if (iStorageAccess == null) {
            return -1;
        }
        GoogleMapLicenseState googleMapLicenseState = new GoogleMapLicenseState(iStorageAccess, this.logChannel, this.key);
        googleMapLicenseState.readAndDeserialize();
        int n = googleMapLicenseState.getGoogleMapLicenseState();
        if (GoogleMapLicenseHandler.isValidGoogleMapLicenseState(n)) {
            return n;
        }
        this.logChannel.log(10000, "GoogleMapLicensePersistenceHelper#persistState() - read invalid state: %1, return default ", (long)n);
        return -1;
    }

    public void persistState(int n) {
        this.logChannel.log(100000000, "GoogleMapLicensePersistenceHelper#persistState( %1 ) ", (long)n);
        if (!GoogleMapLicenseHandler.isValidGoogleMapLicenseState(n)) {
            this.logChannel.log(10000, "GoogleMapLicensePersistenceHelper#persistState() - not persisting invalid state: %1 ", (long)n);
            return;
        }
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        GoogleMapLicenseState googleMapLicenseState = new GoogleMapLicenseState(iStorageAccess, this.logChannel, this.key);
        googleMapLicenseState.setGoogleMapLicenseState(n);
        googleMapLicenseState.serializeAndWrite();
    }

    public static class GoogleMapLicenseState
    extends PersistentState {
        public static final int VERSION = 1;
        public static final int DEFAULT_GE_LICENSE_STATE = -1;
        private int serializedState;

        public GoogleMapLicenseState(IStorageAccess iStorageAccess, LogChannel logChannel, int n) {
            super(iStorageAccess, 1, 1004, n, logChannel);
        }

        public void setGoogleMapLicenseState(int n) {
            this.serializedState = n;
        }

        public int getGoogleMapLicenseState() {
            return this.serializedState;
        }

        protected void initWithDefaultValues() {
            this.serializedState = -1;
        }

        protected void initFromOldKeys(IStorageAccess iStorageAccess) {
            this.initWithDefaultValues();
        }

        protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
            this.initWithDefaultValues();
            try {
                if (n > 0) {
                    this.deserialize(dataInputStream);
                }
            }
            catch (IOException iOException) {
                this.getLogChannel().log(10000, "GoogleMapLicensePersistenceHelper#GoogleMapLicenseState#convertContainer() - error on converting the persistent state format", (Throwable)iOException);
            }
        }

        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeInt(this.serializedState);
        }

        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            int n;
            this.serializedState = n = dataInputStream.readInt();
        }
    }
}

