/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.PersistentState;
import de.audi.tghu.navi.app.util.Util;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PickHelpPersistanceHelper {
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private final int key;
    private static final String LOGCLASS = "PickHelpPersistanceHelper";

    public PickHelpPersistanceHelper(NavigationEnv navigationEnv, int n) {
        this.env = navigationEnv;
        this.key = n;
        this.logChannel = navigationEnv.getLogChannel();
    }

    public static final int getPickHelpStateDefault(IFrameworkAccess iFrameworkAccess) {
        return Util.isIntellidestPickHelpAvailable(iFrameworkAccess) ? 1 : 0;
    }

    public int loadPickHelpState() {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "%1#loadPickHelpState()", (Object)LOGCLASS);
        }
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        int n = PickHelpPersistanceHelper.getPickHelpStateDefault(this.env.getFramework());
        if (iStorageAccess == null) {
            return n;
        }
        PickHelpState pickHelpState = new PickHelpState(iStorageAccess, this.env, this.logChannel, this.key);
        pickHelpState.readAndDeserialize();
        if (pickHelpState.getPickHelpState() != -1) {
            return pickHelpState.getPickHelpState();
        }
        return n;
    }

    public void persistPickHelpState(int n) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "%1#savePickHelpState()", (Object)LOGCLASS);
        }
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        PickHelpState pickHelpState = new PickHelpState(iStorageAccess, this.env, this.logChannel, this.key);
        pickHelpState.setPickHelpState(n);
        pickHelpState.serializeAndWrite();
    }

    public static class PickHelpState
    extends PersistentState {
        public static final int VERSION = 2;
        private int serializedPickHelpState;
        private NavigationEnv navEnv;

        public PickHelpState(IStorageAccess iStorageAccess, NavigationEnv navigationEnv, LogChannel logChannel, int n) {
            super(iStorageAccess, 2, 1004, n, logChannel);
            this.navEnv = navigationEnv;
        }

        public void setPickHelpState(int n) {
            this.serializedPickHelpState = n;
        }

        public int getPickHelpState() {
            return PickHelpPersistanceHelper.getPickHelpStateDefault(this.navEnv.getFramework());
        }

        protected void initWithDefaultValues() {
            this.serializedPickHelpState = PickHelpPersistanceHelper.getPickHelpStateDefault(this.navEnv.getFramework());
        }

        protected void initFromOldKeys(IStorageAccess iStorageAccess) {
            this.serializedPickHelpState = PickHelpPersistanceHelper.getPickHelpStateDefault(this.navEnv.getFramework());
        }

        protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
            this.initWithDefaultValues();
            try {
                if (n > 0) {
                    this.deserialize(dataInputStream);
                }
            }
            catch (IOException iOException) {
                this.getLogChannel().log(10000, "%1.PickHelpState#convertContainer - error on converting the persistent state format", (Object)PickHelpPersistanceHelper.LOGCLASS, (Throwable)iOException);
            }
        }

        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            if (this.serializedPickHelpState > 1 || this.serializedPickHelpState < 0) {
                dataOutputStream.writeInt(-1);
            } else {
                dataOutputStream.writeInt(this.serializedPickHelpState);
            }
        }

        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            this.serializedPickHelpState = PickHelpPersistanceHelper.getPickHelpStateDefault(this.navEnv.getFramework());
        }
    }
}

