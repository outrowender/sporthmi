/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.PickHelpPersistanceHelper$PickHelpState;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.Util;

public class PickHelpPersistanceHelper {
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private final int key;
    private static final String LOGCLASS;

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
            this.logChannel.log(14808325, "%1#loadPickHelpState()", (Object)"PickHelpPersistanceHelper");
        }
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        int n = PickHelpPersistanceHelper.getPickHelpStateDefault(this.env.getFramework());
        if (iStorageAccess == null) {
            return n;
        }
        PickHelpPersistanceHelper$PickHelpState pickHelpPersistanceHelper$PickHelpState = new PickHelpPersistanceHelper$PickHelpState(iStorageAccess, this.env, this.logChannel, this.key);
        pickHelpPersistanceHelper$PickHelpState.readAndDeserialize();
        if (pickHelpPersistanceHelper$PickHelpState.getPickHelpState() != -1) {
            return pickHelpPersistanceHelper$PickHelpState.getPickHelpState();
        }
        return n;
    }

    public void persistPickHelpState(int n) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "%1#savePickHelpState()", (Object)"PickHelpPersistanceHelper");
        }
        IStorageAccess iStorageAccess = this.env.getFramework().getStorageMgr();
        PickHelpPersistanceHelper$PickHelpState pickHelpPersistanceHelper$PickHelpState = new PickHelpPersistanceHelper$PickHelpState(iStorageAccess, this.env, this.logChannel, this.key);
        pickHelpPersistanceHelper$PickHelpState.setPickHelpState(n);
        pickHelpPersistanceHelper$PickHelpState.serializeAndWrite();
    }
}

