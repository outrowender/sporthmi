/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.PersistentState;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

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
        this.navEnv.getLogChannel().log(10000000, "LocalPersistNavLocationHelper#savePersistentState()");
        IStorageAccess iStorageAccess = this.navEnv.getFramework().getStorageMgr();
        NavLocationState navLocationState = new NavLocationState(iStorageAccess, this.navEnv.getLogChannel(), this.key);
        navLocationState.setNavLocation(byArray);
        navLocationState.serializeAndWrite();
    }

    public byte[] loadPersistentState() {
        this.navEnv.getLogChannel().log(10000000, "LocalPersistNavLocationHelper#loadPersistentState()");
        IStorageAccess iStorageAccess = this.navEnv.getFramework().getStorageMgr();
        if (iStorageAccess == null) {
            return new byte[]{0};
        }
        NavLocationState navLocationState = new NavLocationState(iStorageAccess, this.navEnv.getLogChannel(), this.key);
        navLocationState.readAndDeserialize();
        if (navLocationState.getNavLocation() != null) {
            return navLocationState.getNavLocation();
        }
        return new byte[]{0};
    }

    public static class NavLocationState
    extends PersistentState {
        public static final int VERSION = 1;
        private byte[] serializedNavLocation = new byte[]{0};

        public NavLocationState(IStorageAccess iStorageAccess, LogChannel logChannel, int n) {
            super(iStorageAccess, 1, 1004, n, logChannel);
        }

        protected void initWithDefaultValues() {
            this.serializedNavLocation = new byte[1];
            this.serializedNavLocation[0] = 0;
        }

        protected void initFromOldKeys(IStorageAccess iStorageAccess) {
            this.logChannel.log(10000000, "NavLocationState#initFromOldKeys");
        }

        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            NavLocationState.serializeByteArray(this.serializedNavLocation, dataOutputStream);
        }

        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            this.serializedNavLocation = NavLocationState.deserializeByteArray(dataInputStream);
        }

        protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
            this.initWithDefaultValues();
            try {
                if (n > 0) {
                    this.serializedNavLocation = NavLocationState.deserializeByteArray(dataInputStream);
                }
            }
            catch (IOException iOException) {
                this.getLogChannel().log(10000, "LocalPersistNavLocationHelper.NavLocationState#convertContainer - error on converting the persistent state format", (Throwable)iOException);
            }
        }

        public byte[] getNavLocation() {
            return this.serializedNavLocation;
        }

        public void setNavLocation(byte[] byArray) {
            this.serializedNavLocation = byArray;
        }
    }
}

