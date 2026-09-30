/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio;

import de.audi.app.bap.IPowerState;
import de.audi.app.bap.dsi.bap.IDSIBAPController;
import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.AbstractBAPModuleInitializationManagerFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionDataListener;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.utils.FunctionIDs;
import de.audi.app.combi.bap.app.audio.AppConnectorMedia;
import de.audi.app.combi.bap.app.audio.AppConnectorTV;
import de.audi.app.combi.bap.app.audio.AppConnectorTerminalMode;
import de.audi.app.combi.bap.app.audio.AppConnectorTuner;
import de.audi.app.combi.bap.app.audio.CombiModuleAudio;
import de.audi.app.combi.bap.app.audio.IAudioApplicationInFocusObserver;
import de.audi.app.combi.bap.app.audio.sds.AppConnectorSDS;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTunerListener;
import de.esolutions.fw.util.commons.Buffer;
import de.vw.mib.bap.generated.audiosd.serializer.FSG_OperationState_Status;

public class InitializationManagerAudio
extends AbstractBAPModuleInitializationManagerFSG
implements IAudioApplicationInFocusObserver,
BAPFunctionDataListener {
    private int appStateMedia = 0;
    private int appStateTuner = 0;
    private int appStateTV = 0;
    private int appStateTerminalMode = 0;
    private int appStateTone = 0;
    private int appStateSDS = 0;

    public InitializationManagerAudio(AbstractCombiModule abstractCombiModule, BAPFunctionPropertyFSG bAPFunctionPropertyFSG, IDSIBAPController iDSIBAPController, IPowerState iPowerState) {
        super(abstractCombiModule, bAPFunctionPropertyFSG, iDSIBAPController, iPowerState);
    }

    public void appStateChanged(String string, int n) {
        this.logChannel.log(100000000, "[InitializationManagerAudio#appStateChanged] appName=%1, value=%2", (Object)string, (long)n);
        if ("Media".equals(string)) {
            if (this.appStateMedia != n) {
                this.appStateMedia = n;
                this.appStateTunerOrMediaChanged(n);
            }
        } else if ("Tuner".equals(string)) {
            if (this.appStateTuner != n) {
                this.appStateTuner = n;
                this.appStateTunerOrMediaChanged(n);
                if (this.appStateTuner == 1) {
                    this.logChannel.log(10000000, "[InitializationManagerAudio#appStateChanged] tuner was initialized; resend info for active band");
                    CombiBAPServiceTunerListener combiBAPServiceTunerListener = (CombiBAPServiceTunerListener)this.module.getAppServiceListener("Tuner");
                    if (combiBAPServiceTunerListener != null) {
                        combiBAPServiceTunerListener.resendAllInfoForActiveBand();
                    } else {
                        this.logChannel.log(10000, "[InitializationManagerAudio#appStateChanged] tuner service not registered!");
                    }
                }
            }
        } else if ("Tone".equals(string)) {
            if (this.appStateTone != n) {
                this.appStateTone = n;
            }
        } else if ("SDSManager".equals(string)) {
            if (this.appStateSDS != n) {
                this.appStateSDS = n;
                AppConnectorSDS appConnectorSDS = (AppConnectorSDS)this.module.getAppConnectors().get("SDSManager");
                if (!this.isSDSAvailable() && appConnectorSDS != null) {
                    appConnectorSDS.updateSDSState(0);
                }
            }
        } else if ("TV".equals(string)) {
            if (this.appStateTV != n) {
                this.appStateTV = n;
            }
        } else if ("TerminalMode".equals(string) && this.appStateTerminalMode != n) {
            this.appStateTerminalMode = n;
        }
    }

    private void appStateTunerOrMediaChanged(int n) {
        int n2 = this.appStateMedia == 1 || this.appStateTuner == 1 ? 1 : (this.appStateMedia == 0 || this.appStateTuner == 0 ? 0 : n);
        super.processAppStateChanged(n2);
    }

    public String appStatesToString() {
        Buffer buffer = new Buffer();
        buffer.append("appStateTuner = ");
        buffer.append(this.appStateTuner);
        buffer.append("\nappStateMedia = ");
        buffer.append(this.appStateMedia);
        buffer.append("\nappStateTV = ");
        buffer.append(this.appStateTV);
        buffer.append("\nappStateTone = ");
        buffer.append(this.appStateTerminalMode);
        buffer.append("\nappStateTerminalMode = ");
        buffer.append(this.appStateTone);
        buffer.append("\nappStateSDS = ");
        buffer.append(this.appStateSDS);
        buffer.append('\n');
        return buffer.toString();
    }

    public boolean isSDSAvailable() {
        return this.appStateSDS != 1024 && this.appStateSDS != 512 && this.appStateSDS != 256;
    }

    public boolean isSDSInitalizing() {
        return this.appStateSDS == 0;
    }

    public void notifyAudioApplicationInFocusChanged(int n) {
        if (this.isOpStateNormalOperation()) {
            if (n == 0) {
                if (this.appStateTuner != 1) {
                    this.logChannel.log(10000000, "[InitializationManagerAudio#notifyActiveAudioApplicationChanged] tuner not initialized yet -> please wait");
                    ((AppConnectorTuner)this.module.getAppConnectors().get("Tuner")).updateActiveInfoState(19);
                }
            } else if (n == 1) {
                if (this.appStateMedia != 1) {
                    this.logChannel.log(10000000, "[InitializationManagerAudio#notifyActiveAudioApplicationChanged] media not initialized yet -> please wait");
                    ((AppConnectorMedia)this.module.getAppConnectors().get("Media")).updateActiveInfoState(19);
                }
            } else if (n == 2) {
                if (this.appStateTV != 1) {
                    this.logChannel.log(10000000, "[InitializationManagerAudio#notifyActiveAudioApplicationChanged] TV not initialized yet -> please wait");
                    ((AppConnectorTV)this.module.getAppConnectors().get("TV")).updateActiveInfoState(19);
                }
            } else if (n == 3 && this.appStateTerminalMode != 1) {
                this.logChannel.log(10000000, "[InitializationManagerAudio#notifyActiveAudioApplicationChanged] TV not initialized yet -> please wait");
                ((AppConnectorTerminalMode)this.module.getAppConnectors().get("TerminalMode")).updateActiveInfoState(19);
            }
        }
    }

    public boolean setFSGOperationStateValue(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 3;
                break;
            }
            case 3: {
                n2 = 15;
                break;
            }
            default: {
                this.logChannel.log(10000, "[InitializationManagerAudio#setFSGOperationStateValue] invalid opState: %1", (long)n);
                return false;
            }
        }
        int n3 = ((CombiModuleAudio)this.module).isFirstScreenShown() ? 0 : 1;
        FSG_OperationState_Status fSG_OperationState_Status = (FSG_OperationState_Status)this.fsgOperationStateFunction.getLastStatus();
        boolean bl = false;
        if (fSG_OperationState_Status.hmi_State != n3) {
            fSG_OperationState_Status.hmi_State = n3;
            bl = true;
        }
        if (fSG_OperationState_Status.op_State != n2) {
            fSG_OperationState_Status.op_State = n2;
            bl = true;
        }
        return bl;
    }

    protected boolean isRequiredDataForOpStateNormalAvailable() {
        boolean bl = false;
        if (((AbstractBAPModuleFSG)this.module).getBAPFunctionArrayFSG(32).isDataValid()) {
            bl = true;
            ((AbstractBAPModuleFSG)this.module).getBAPFunctionArrayFSG(32).removeDataListener(this);
        } else {
            this.logChannel.log(10000000, "[InitializationManagerAudio#isRequiredDataForOpStateNormalAvailable] source list not available yet");
        }
        return bl;
    }

    public boolean isOpStateNormalOperation() {
        FSG_OperationState_Status fSG_OperationState_Status = (FSG_OperationState_Status)this.fsgOperationStateFunction.getLastStatus();
        return fSG_OperationState_Status.op_State == 0;
    }

    public void notifyDataValidChanged(int n, boolean bl) {
        this.logChannel.log(10000000, "[InitializationManagerAudio#notifyDataValidChanged] data valid status changed for fctID=%1 -> update operation state", (Object)FunctionIDs.getDescription(this.module.getLSGID(), n));
        this.updateOperationState();
    }

    public void notifyDataChanged(int n) {
    }

    public void notifyDataUpdatedNoChange(int n) {
    }
}

