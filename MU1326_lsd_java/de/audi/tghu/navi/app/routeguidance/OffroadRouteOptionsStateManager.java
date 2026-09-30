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

public class OffroadRouteOptionsStateManager {
    private NavigationEnv env;
    private LogChannel logChannel;

    public OffroadRouteOptionsStateManager(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getLogChannel();
    }

    public void saveDsiRouteOptionOffRoad(int n) {
        if (this.env.getFramework().getStorageMgr() != null) {
            this.logChannel.log(10000000, "OffroadRouteOptionsStatemanager#saveDsiRouteOptionOffRoad() %1", (long)n);
            OffroadRouteOptionsState offroadRouteOptionsState = new OffroadRouteOptionsState(this.env.getFramework().getStorageMgr(), this.logChannel);
            offroadRouteOptionsState.setDsiRouteOptionOffRoad(n);
            offroadRouteOptionsState.serializeAndWrite();
        }
    }

    public int loadLastPersistetDsiRouteOptionOffRoad() {
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        if (iStorageAccess != null) {
            OffroadRouteOptionsState offroadRouteOptionsState = new OffroadRouteOptionsState(iStorageAccess, this.logChannel);
            offroadRouteOptionsState.readAndDeserialize();
            int n = offroadRouteOptionsState.getDsiRouteOptionOffRoad();
            this.logChannel.log(10000000, "OffroadRouteOptionsStatemanager#loadLastPersistetDsiRouteOptionOffRoad() %1", (long)n);
            return n;
        }
        this.logChannel.log(10000, "OffroadRouteOptionsStatemanager#loadLastPersistetDsiRouteOptionOffRoad() - no storage manager available!!! ");
        return 1;
    }

    private class OffroadRouteOptionsState
    extends PersistentState {
        public static final int OFFORAD_ROUTE_OPTIONS_DEFAULT = 1;
        private static final int VERSION = 1;
        private static final int KEY = 1044;
        private int offroadRouteOptions;

        public OffroadRouteOptionsState(IStorageAccess iStorageAccess, LogChannel logChannel) {
            super(iStorageAccess, 1, 1004, 1044, logChannel);
        }

        protected void initWithDefaultValues() {
            this.offroadRouteOptions = 1;
        }

        protected void initFromOldKeys(IStorageAccess iStorageAccess) {
        }

        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeInt(this.offroadRouteOptions);
        }

        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            this.offroadRouteOptions = dataInputStream.readInt();
        }

        protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
            this.logChannel.log(10000000, "OffroadRouteOptionsState#convertContainer( %1, %2 )", (long)n, (long)n2);
            this.initWithDefaultValues();
            try {
                if (n > 0) {
                    this.offroadRouteOptions = dataInputStream.readInt();
                }
            }
            catch (IOException iOException) {
                this.logChannel.log(10000, "OffroadRouteOptionsState#convertContainer - error on converting the persistent state format", (Throwable)iOException);
            }
        }

        public int getDsiRouteOptionOffRoad() {
            return this.offroadRouteOptions;
        }

        public void setDsiRouteOptionOffRoad(int n) {
            this.offroadRouteOptions = n;
        }
    }
}

