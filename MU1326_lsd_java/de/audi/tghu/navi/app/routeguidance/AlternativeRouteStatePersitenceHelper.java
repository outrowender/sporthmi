/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.routeguidance.AlternativeRouteStatePersitenceHelper$AlternativeRouteState;

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
            this.logChannel.log(14808325, "AlternativeRouteStatePersitenceHelper#loadAlternativeRouteState()");
        }
        if ((iStorageAccess = this.env.getFramework().getStorageMgr()) == null) {
            return 0;
        }
        AlternativeRouteStatePersitenceHelper$AlternativeRouteState alternativeRouteStatePersitenceHelper$AlternativeRouteState = new AlternativeRouteStatePersitenceHelper$AlternativeRouteState(iStorageAccess, this.logChannel, this.key);
        alternativeRouteStatePersitenceHelper$AlternativeRouteState.readAndDeserialize();
        if (alternativeRouteStatePersitenceHelper$AlternativeRouteState.getAlternativeRouteState() != -1) {
            return alternativeRouteStatePersitenceHelper$AlternativeRouteState.getAlternativeRouteState();
        }
        return 0;
    }

    public void persistAlternativeRouteState(int n) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "AlternativeRouteStatePersitenceHelper#persistAlternativeRouteState()");
        }
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        AlternativeRouteStatePersitenceHelper$AlternativeRouteState alternativeRouteStatePersitenceHelper$AlternativeRouteState = new AlternativeRouteStatePersitenceHelper$AlternativeRouteState(iStorageAccess, this.logChannel, this.key);
        alternativeRouteStatePersitenceHelper$AlternativeRouteState.setAlternativeRouteState(n);
        alternativeRouteStatePersitenceHelper$AlternativeRouteState.serializeAndWrite();
    }
}

