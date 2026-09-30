/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.functionsync;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.combi.bap.app.audio.CombiModuleAudio;
import de.audi.app.combi.bap.app.audio.functionsync.CommandCloseFunctionSyncAudio;
import de.audi.app.combi.bap.app.audio.functionsync.CommandMediaBrowserChangedArray;
import de.audi.app.combi.bap.app.audio.functionsync.CommandOpenFunctionSyncAudio;
import de.audi.app.combi.bap.app.audio.functionsync.CommandPresetListChangedArray;
import de.audi.app.combi.bap.app.audio.functionsync.CommandReceptionListChangedArray;
import de.audi.app.combi.bap.app.audio.functionsync.EpilogueActionDedicatedAudioControlResult;
import de.audi.app.combi.bap.app.audio.functionsync.EpilogueActionMediaBrowserFullRangeUpdate;
import de.audi.app.combi.bap.app.audio.functionsync.EpilogueActionSwitchRadioMediaResult;
import de.audi.app.combi.bap.app.audio.functionsync.EpilogueActionSwitchSourceResult;
import de.audi.app.combi.bap.app.audio.functionsync.EpilogueActionUpdateInfoStates;
import de.audi.app.combi.bap.app.audio.functionsync.FunctionSynchronizationHandlerAudio;
import de.audi.app.combi.bap.functionsync.AbstractCommandCloseFunctionSync;
import de.audi.app.combi.bap.functionsync.AbstractCommandOpenFunctionSync;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSynchronization;

public final class FunctionSynchronizationAudio
extends AbstractFunctionSynchronization {
    public static final int SYNC_TYPE_SOURCE_CHANGE_GENERAL = 0;
    public static final int SYNC_TYPE_SOURCE_CHANGE_TPMEMO = 1;
    public static final int SYNC_TYPE_SOURCE_CHANGE_TV = 2;
    public static final int SYNC_TYPE_SOURCE_CHANGE_TO_MEDIA = 3;
    public static final int SYNC_TYPE_SOURCE_CHANGE_TO_ONLINE_MEDIA = 4;
    public static final int SYNC_TYPE_STATION_CHANGE = 5;
    public static final int SYNC_TYPE_TRACK_CHANGE = 6;
    public static final int SYNC_TYPE_SOURCE_CHANGE_TERMINALMODE = 7;
    public static final int SYNC_TYPE_SOURCE_CHANGE_USB_DEACTIVATE = 8;
    private static final int SYNC_TYPE_MAX = 9;
    private static final int[][] FUNCTIONS_TO_BE_SYNCHRONIZED = new int[9][];

    public FunctionSynchronizationAudio(AbstractBAPModuleFSG abstractBAPModuleFSG, FunctionSynchronizationHandlerAudio functionSynchronizationHandlerAudio, int n) {
        super(abstractBAPModuleFSG, functionSynchronizationHandlerAudio, 42, n);
    }

    public String getSyncTypeDescription() {
        switch (this.syncType) {
            case 0: {
                return "SOURCE_CHANGE_GENERAL";
            }
            case 1: {
                return "SOURCE_CHANGE_TPMEMO";
            }
            case 2: {
                return "SOURCE_CHANGE_TV";
            }
            case 3: {
                return "SOURCE_CHANGE_TO_MEDIA";
            }
            case 4: {
                return "SOURCE_CHANGE_TO_ONLINE_MEDIA";
            }
            case 5: {
                return "STATION_CHANGE";
            }
            case 6: {
                return "TRACK_CHANGE";
            }
            case -1: {
                return "NO SYNC ACTIVE";
            }
            case 7: {
                return "SOURCE_CHANGE_TERMINALMODE";
            }
            case 8: {
                return "SOURCE_CHANGE_USB_DEACTIVATE";
            }
        }
        return "UNKNOWN";
    }

    protected void addAdditionalCommands() {
        switch (this.syncType) {
            case 0: {
                if (this.moduleFsg.getFunctionList().isFunctionSupported(23)) {
                    this.add(new CommandReceptionListChangedArray(this.moduleFsg, (AbstractFunctionSynchronization)this, true));
                }
                this.addEpilogueAction(new EpilogueActionDedicatedAudioControlResult(this.moduleFsg, this.logChannel));
                this.addEpilogueAction(new EpilogueActionSwitchSourceResult(this.moduleFsg, this.logChannel));
                this.addEpilogueAction(new EpilogueActionSwitchRadioMediaResult(this.moduleFsg, this.logChannel));
                break;
            }
            case 1: {
                this.addEpilogueAction(new EpilogueActionSwitchSourceResult(this.moduleFsg, this.logChannel));
                break;
            }
            case 2: {
                if (this.moduleFsg.getFunctionList().isFunctionSupported(23)) {
                    this.add(new CommandReceptionListChangedArray(this.moduleFsg, (AbstractFunctionSynchronization)this, true));
                }
                this.addEpilogueAction(new EpilogueActionSwitchSourceResult(this.moduleFsg, this.logChannel));
                this.addEpilogueAction(new EpilogueActionSwitchRadioMediaResult(this.moduleFsg, this.logChannel));
                break;
            }
            case 3: 
            case 4: {
                if (this.moduleFsg.getFunctionList().isFunctionSupported(36)) {
                    this.add(new CommandMediaBrowserChangedArray(this.moduleFsg, this));
                }
                this.addEpilogueAction(new EpilogueActionSwitchSourceResult(this.moduleFsg, this.logChannel));
                this.addEpilogueAction(new EpilogueActionSwitchRadioMediaResult(this.moduleFsg, this.logChannel));
                break;
            }
            case 5: {
                if (this.moduleFsg.getFunctionList().isFunctionSupported(23)) {
                    this.add(new CommandReceptionListChangedArray(this.moduleFsg, (AbstractFunctionSynchronization)this, false));
                }
                if (this.moduleFsg.getFunctionList().isFunctionSupported(33)) {
                    this.add(new CommandPresetListChangedArray(this.moduleFsg, (AbstractFunctionSynchronization)this, false));
                }
                this.addEpilogueAction(new EpilogueActionDedicatedAudioControlResult(this.moduleFsg, this.logChannel));
                this.addEpilogueAction(new EpilogueActionUpdateInfoStates((CombiModuleAudio)this.moduleFsg, this.logChannel));
                break;
            }
            case 6: {
                this.addEpilogueAction(new EpilogueActionDedicatedAudioControlResult(this.moduleFsg, this.logChannel));
                this.addEpilogueAction(new EpilogueActionUpdateInfoStates((CombiModuleAudio)this.moduleFsg, this.logChannel));
                if (!this.moduleFsg.getFunctionList().isFunctionSupported(36)) break;
                this.addEpilogueAction(new EpilogueActionMediaBrowserFullRangeUpdate(this.moduleFsg, this.logChannel));
                break;
            }
            case 7: 
            case 8: {
                this.addEpilogueAction(new EpilogueActionSwitchSourceResult(this.moduleFsg, this.logChannel));
                this.addEpilogueAction(new EpilogueActionSwitchRadioMediaResult(this.moduleFsg, this.logChannel));
                break;
            }
            default: {
                this.logChannel.log(100000, "[FunctionSynchronizationAudio#init] invalid sync type (%1)", (long)this.syncType);
            }
        }
    }

    protected int[] getFunctionsToBeSynchronized() {
        if (this.syncType > -1 && this.syncType < 9) {
            return FUNCTIONS_TO_BE_SYNCHRONIZED[this.syncType];
        }
        this.logChannel.log(10000, "[FunctionSynchronizationAudio#getFunctionsToBeSynchronized] invalid sync type (%1)", (long)this.syncType);
        return new int[0];
    }

    protected AbstractCommandOpenFunctionSync createOpenFunctionSyncCommand() {
        return new CommandOpenFunctionSyncAudio(this.moduleFsg, this);
    }

    protected AbstractCommandCloseFunctionSync createCloseFunctionSyncCommand() {
        return new CommandCloseFunctionSyncAudio(this.moduleFsg, this);
    }

    static {
        FunctionSynchronizationAudio.FUNCTIONS_TO_BE_SYNCHRONIZED[0] = new int[]{16, 17, 21, 22, 30, 31, 40};
        FunctionSynchronizationAudio.FUNCTIONS_TO_BE_SYNCHRONIZED[1] = new int[]{16, 17, 21, 22, 30, 26};
        FunctionSynchronizationAudio.FUNCTIONS_TO_BE_SYNCHRONIZED[2] = new int[]{16, 17, 21, 22, 30, 40};
        FunctionSynchronizationAudio.FUNCTIONS_TO_BE_SYNCHRONIZED[3] = new int[]{16, 17, 21, 22, 30, 52, 40};
        FunctionSynchronizationAudio.FUNCTIONS_TO_BE_SYNCHRONIZED[4] = new int[]{16, 17, 21, 22, 30, 49, 52, 40};
        FunctionSynchronizationAudio.FUNCTIONS_TO_BE_SYNCHRONIZED[5] = new int[]{21, 22};
        FunctionSynchronizationAudio.FUNCTIONS_TO_BE_SYNCHRONIZED[6] = new int[]{21, 22};
        FunctionSynchronizationAudio.FUNCTIONS_TO_BE_SYNCHRONIZED[7] = new int[]{16, 17, 21, 22, 30, 40};
        FunctionSynchronizationAudio.FUNCTIONS_TO_BE_SYNCHRONIZED[8] = new int[]{16, 17, 21, 22, 30, 40};
    }
}

