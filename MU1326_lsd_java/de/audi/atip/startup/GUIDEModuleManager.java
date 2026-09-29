/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.startup.AppStateManager;
import de.audi.atip.startup.GUIDEModuleState;
import de.audi.atip.statemachine.SMListener;

public class GUIDEModuleManager
implements SMListener {
    private static final int MAX_MODULE_ID;
    private AppStateManager appStateManager;
    private GUIDEModuleState[] moduleStates;

    GUIDEModuleManager(AppStateManager appStateManager) {
        this.appStateManager = appStateManager;
        this.moduleStates = new GUIDEModuleState[35];
    }

    private GUIDEModuleState getStateByModuleId(int n, int n2) {
        if (n == 6) {
            return this.appStateManager.getComponentByName("SDSManager").getGUIDEModuleState();
        }
        return this.moduleStates[n2];
    }

    void setGUIDEModuleState(GUIDEModuleState gUIDEModuleState) {
        if (gUIDEModuleState != null && gUIDEModuleState.getModuleId() > -1) {
            this.moduleStates[gUIDEModuleState.getModuleId()] = gUIDEModuleState;
        }
    }

    @Override
    public void smModuleRegistered(int n, int n2, int n3) {
        if (n >= 0 && n < 8 && n3 >= 0 && n3 < 35) {
            this.appStateManager.getLog().log(-2137614336, "GUIDEModuleManager.smModuleRegistered( %1, %2 )", (long)n, (long)n3);
            GUIDEModuleState gUIDEModuleState = this.getStateByModuleId(n, n3);
            if (null != gUIDEModuleState) {
                gUIDEModuleState.setSMState(2);
            }
        }
    }

    @Override
    public void smModuleUnregistered(int n, int n2, int n3) {
        if (n == 0 && n3 >= 0 && n3 < 35) {
            this.appStateManager.getLog().log(-2137614336, "GUIDEModuleManager.smModuleUnregistered( %1, %2 )", (long)n, (long)n3);
            GUIDEModuleState gUIDEModuleState = this.getStateByModuleId(n, n3);
            if (null != gUIDEModuleState) {
                gUIDEModuleState.setSMState(0);
            }
        }
    }
}

