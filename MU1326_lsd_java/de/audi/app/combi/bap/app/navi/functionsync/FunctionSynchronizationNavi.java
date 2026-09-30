/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.navi.functionsync;

import de.audi.app.combi.bap.app.navi.functionsync.CommandCloseFunctionSyncNavi;
import de.audi.app.combi.bap.app.navi.functionsync.CommandOpenFunctionSyncNavi;
import de.audi.app.combi.bap.app.navi.functionsync.EpilogueActionRGActDeactResult;
import de.audi.app.combi.bap.app.navi.functionsync.FunctionSynchronizationHandlerNavi;
import de.audi.app.combi.bap.functionsync.AbstractCommandCloseFunctionSync;
import de.audi.app.combi.bap.functionsync.AbstractCommandOpenFunctionSync;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSynchronization;
import de.audi.app.combi.bap.fw.AbstractCombiModule;

public class FunctionSynchronizationNavi
extends AbstractFunctionSynchronization {
    public static final int SYNC_TYPE_START_STOP_ROUTE_GUIDANCE = 0;
    public static final int SYNC_TYPE_CHANGE_OF_MANEUVER = 1;
    private static final int SYNC_TYPE_MAX = 2;
    private static final int[][] FUNCTIONS_TO_BE_SYNCHRONIZED = new int[2][];

    public FunctionSynchronizationNavi(AbstractCombiModule abstractCombiModule, FunctionSynchronizationHandlerNavi functionSynchronizationHandlerNavi, int n) {
        super(abstractCombiModule, functionSynchronizationHandlerNavi, 37, n);
    }

    public String getSyncTypeDescription() {
        switch (this.syncType) {
            case 0: {
                return "START_STOP_ROUTE_GUIDANCE";
            }
            case 1: {
                return "CHANGE_OF_MANEUVER";
            }
            case -1: {
                return "NO SYNC ACTIVE";
            }
        }
        return "UNKNOWN";
    }

    protected void addAdditionalCommands() {
        switch (this.syncType) {
            case 0: {
                this.addEpilogueAction(new EpilogueActionRGActDeactResult(this.moduleFsg, this.logChannel));
                break;
            }
            case 1: {
                break;
            }
            default: {
                this.logChannel.log(100000, "[FunctionSynchronizationNavi#init] invalid sync type (%1)", (long)this.syncType);
            }
        }
    }

    protected int[] getFunctionsToBeSynchronized() {
        if (this.syncType > -1 && this.syncType < 2) {
            return FUNCTIONS_TO_BE_SYNCHRONIZED[this.syncType];
        }
        this.logChannel.log(10000, "[FunctionSynchronizationNavi#getFunctionsToBeSynchronized] invalid sync type (%1)", (long)this.syncType);
        return new int[0];
    }

    protected AbstractCommandOpenFunctionSync createOpenFunctionSyncCommand() {
        return new CommandOpenFunctionSyncNavi((AbstractCombiModule)this.moduleFsg, (AbstractFunctionSynchronization)this);
    }

    protected AbstractCommandCloseFunctionSync createCloseFunctionSyncCommand() {
        return new CommandCloseFunctionSyncNavi((AbstractCombiModule)this.moduleFsg, (AbstractFunctionSynchronization)this);
    }

    static {
        FunctionSynchronizationNavi.FUNCTIONS_TO_BE_SYNCHRONIZED[0] = new int[]{17, 39, 23, 18, 49};
        FunctionSynchronizationNavi.FUNCTIONS_TO_BE_SYNCHRONIZED[1] = new int[]{23, 18, 49};
    }
}

