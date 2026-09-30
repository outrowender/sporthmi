/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.PersistentState;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class AlternativeRouteStatePersitenceHelper {
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private final int key;

    public AlternativeRouteStatePersitenceHelper(NavigationEnv navigationEnv, int n) {
        this.env = navigationEnv;
        this.key = n;
        this.logChannel = navigationEnv.getLogChannel();
    }

    public int loadAlternativeRouteState() {
        IStorageAccess iStorageAccess;
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "AlternativeRouteStatePersitenceHelper#loadAlternativeRouteState()");
        }
        if ((iStorageAccess = this.env.getFramework().getStorageMgr()) == null) {
            return 0;
        }
        AlternativeRouteState alternativeRouteState = new AlternativeRouteState(iStorageAccess, this.logChannel, this.key);
        alternativeRouteState.readAndDeserialize();
        if (alternativeRouteState.getAlternativeRouteState() != -1) {
            return alternativeRouteState.getAlternativeRouteState();
        }
        return 0;
    }

    public void persistAlternativeRouteState(int n) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "AlternativeRouteStatePersitenceHelper#persistAlternativeRouteState()");
        }
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        AlternativeRouteState alternativeRouteState = new AlternativeRouteState(iStorageAccess, this.logChannel, this.key);
        alternativeRouteState.setAlternativeRouteState(n);
        alternativeRouteState.serializeAndWrite();
    }

    public static class AlternativeRouteState
    extends PersistentState {
        public static final int VERSION = 1;
        private int serializedAlternativeRouteState;

        public AlternativeRouteState(IStorageAccess iStorageAccess, LogChannel logChannel, int n) {
            super(iStorageAccess, 1, 1004, n, logChannel);
        }

        public void setAlternativeRouteState(int n) {
            this.serializedAlternativeRouteState = n;
        }

        public int getAlternativeRouteState() {
            return this.serializedAlternativeRouteState;
        }

        protected void initWithDefaultValues() {
            this.serializedAlternativeRouteState = 1;
        }

        protected void initFromOldKeys(IStorageAccess iStorageAccess) {
        }

        protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
            this.initWithDefaultValues();
            try {
                if (n > 0) {
                    this.deserialize(dataInputStream);
                }
            }
            catch (IOException iOException) {
                this.getLogChannel().log(10000, "AlternativeRouteStatePersitenceHelper.AlternativeRouteState#convertContainer - error on converting the persistent state format", (Throwable)iOException);
            }
        }

        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            if (this.serializedAlternativeRouteState > 1 || this.serializedAlternativeRouteState < 0) {
                dataOutputStream.writeInt(-1);
            } else {
                dataOutputStream.writeInt(this.serializedAlternativeRouteState);
            }
        }

        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            int n = dataInputStream.readInt();
            this.serializedAlternativeRouteState = n == -1 ? 0 : n;
        }
    }
}

