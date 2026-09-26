/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.online.traffic;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.online.traffic.OnlineTrafficPersistanceHelper$OnlineTrafficState;

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
            this.logChannel.log(14808325, "OnlineTrafficPersistanceHelper#loadState()");
        }
        if ((iStorageAccess = this.env.getFramework().getStorageMgr()) == null) {
            return true;
        }
        OnlineTrafficPersistanceHelper$OnlineTrafficState onlineTrafficPersistanceHelper$OnlineTrafficState = new OnlineTrafficPersistanceHelper$OnlineTrafficState(iStorageAccess, this.logChannel, this.key);
        onlineTrafficPersistanceHelper$OnlineTrafficState.readAndDeserialize();
        return onlineTrafficPersistanceHelper$OnlineTrafficState.getOnlineTrafficState();
    }

    public void persistState(boolean bl) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "OnlineTrafficPersistanceHelper#persistState()");
        }
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        OnlineTrafficPersistanceHelper$OnlineTrafficState onlineTrafficPersistanceHelper$OnlineTrafficState = new OnlineTrafficPersistanceHelper$OnlineTrafficState(iStorageAccess, this.logChannel, this.key);
        onlineTrafficPersistanceHelper$OnlineTrafficState.setOnlineTrafficState(bl);
        onlineTrafficPersistanceHelper$OnlineTrafficState.serializeAndWrite();
    }
}

