/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.online.traffic;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.PersistentState;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class OnlineTrafficPersistanceHelper {
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private final int key;

    public OnlineTrafficPersistanceHelper(NavigationEnv navigationEnv, int n, LogChannel logChannel) {
        this.env = navigationEnv;
        this.key = n;
        this.logChannel = logChannel;
    }

    public boolean loadState() {
        IStorageAccess iStorageAccess;
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "OnlineTrafficPersistanceHelper#loadState()");
        }
        if ((iStorageAccess = this.env.getFramework().getStorageMgr()) == null) {
            return true;
        }
        OnlineTrafficState onlineTrafficState = new OnlineTrafficState(iStorageAccess, this.logChannel, this.key);
        onlineTrafficState.readAndDeserialize();
        return onlineTrafficState.getOnlineTrafficState();
    }

    public void persistState(boolean bl) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "OnlineTrafficPersistanceHelper#persistState()");
        }
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        OnlineTrafficState onlineTrafficState = new OnlineTrafficState(iStorageAccess, this.logChannel, this.key);
        onlineTrafficState.setOnlineTrafficState(bl);
        onlineTrafficState.serializeAndWrite();
    }

    public static class OnlineTrafficState
    extends PersistentState {
        public static final int VERSION = 1;
        public static final boolean DEFAULT_ONLINE_TRAFFIC_STATE = true;
        private boolean serializedState;

        public OnlineTrafficState(IStorageAccess iStorageAccess, LogChannel logChannel, int n) {
            super(iStorageAccess, 1, 1004, n, logChannel);
        }

        public void setOnlineTrafficState(boolean bl) {
            this.serializedState = bl;
        }

        public boolean getOnlineTrafficState() {
            return this.serializedState;
        }

        protected void initWithDefaultValues() {
            this.serializedState = true;
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
                this.getLogChannel().log(10000, "OnlineTrafficPersistanceHelper#OnlineTrafficState#convertContainer - error on converting the persistent state format", (Throwable)iOException);
            }
        }

        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeBoolean(this.serializedState);
        }

        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            boolean bl;
            this.serializedState = bl = dataInputStream.readBoolean();
        }
    }
}

