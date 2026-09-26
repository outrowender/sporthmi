/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.routeguidance.OffroadRouteOptionsStateManager$OffroadRouteOptionsState;

public class OffroadRouteOptionsStateManager {
    private NavigationEnv env;
    private LogChannel logChannel;

    public OffroadRouteOptionsStateManager(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getLogChannel();
    }

    public void saveDsiRouteOptionOffRoad(int n) {
        if (this.env.getFramework().getStorageMgr() != null) {
            this.logChannel.log(-2137614336, "OffroadRouteOptionsStatemanager#saveDsiRouteOptionOffRoad() %1", (long)n);
            OffroadRouteOptionsStateManager$OffroadRouteOptionsState offroadRouteOptionsStateManager$OffroadRouteOptionsState = new OffroadRouteOptionsStateManager$OffroadRouteOptionsState(this, this.env.getFramework().getStorageMgr(), this.logChannel);
            offroadRouteOptionsStateManager$OffroadRouteOptionsState.setDsiRouteOptionOffRoad(n);
            offroadRouteOptionsStateManager$OffroadRouteOptionsState.serializeAndWrite();
        }
    }

    public int loadLastPersistetDsiRouteOptionOffRoad() {
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        if (iStorageAccess != null) {
            OffroadRouteOptionsStateManager$OffroadRouteOptionsState offroadRouteOptionsStateManager$OffroadRouteOptionsState = new OffroadRouteOptionsStateManager$OffroadRouteOptionsState(this, iStorageAccess, this.logChannel);
            offroadRouteOptionsStateManager$OffroadRouteOptionsState.readAndDeserialize();
            int n = offroadRouteOptionsStateManager$OffroadRouteOptionsState.getDsiRouteOptionOffRoad();
            this.logChannel.log(-2137614336, "OffroadRouteOptionsStatemanager#loadLastPersistetDsiRouteOptionOffRoad() %1", (long)n);
            return n;
        }
        this.logChannel.log(10000, "OffroadRouteOptionsStatemanager#loadLastPersistetDsiRouteOptionOffRoad() - no storage manager available!!! ");
        return 1;
    }
}

