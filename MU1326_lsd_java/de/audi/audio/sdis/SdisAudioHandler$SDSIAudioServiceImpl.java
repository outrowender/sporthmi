/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis;

import de.audi.atip.audio.IAudioFocusClient;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.IBluetoothA2LSService;
import de.audi.atip.interapp.audio.AtipAudioSdisService;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import de.audi.atip.interapp.def.NullBluetoothA2LSService;
import de.audi.audio.sdis.AudioContextListener;
import de.audi.audio.sdis.SdisAudioHandler;
import de.audi.audio.sdis.SdisLabels;
import de.audi.audio.sdis.ifc.SdisAudioService;
import de.audi.tghu.command.CommandList;
import de.esolutions.fw.comm.asi.hmisync.audio.A2LSState;
import de.esolutions.fw.comm.asi.hmisync.audio.ASIHMISyncAudioReply;
import de.esolutions.fw.comm.asi.hmisync.audio.AudioState;
import de.esolutions.fw.comm.core.method.MethodException;

class SdisAudioHandler$SDSIAudioServiceImpl
implements SdisAudioService,
AtipAudioSdisService,
IAudioFocusClient,
ButtonListener,
AudioContextListener {
    private static final int NO_MODEL_ID;
    volatile boolean a2lsActive;
    private volatile int frontAudioFocus;
    private ASIHMISyncAudioReply reply;
    private IBluetoothA2LSService bluetoothA2lsService;
    private final int RESULTCODE_A2LS_DUPLICATE_REQUEST;
    private static final int SETTING_A2LS_BLOCKED;
    private static final int SETTING_A2LS_ALLOWED;
    private static final int ACTIVE_HMI_APP_TUNER;
    private static final int ACTIVE_HMI_APP_MEDIA;
    private static final int A2LS_ACTIVE;
    private static final int A2LS_INACTIVE;
    private ChoiceModelApp a2lsPopupTriggerModel;
    private ChoiceModelApp tunerMediaActiveModel;
    private ChoiceModelApp a2lsActiveModel;
    private static final int HIDE_A2LS_ACTIVE_POPUP;
    private static final int SHOW_A2LS_ACTIVE_POPUP;
    private volatile boolean mediaTunerAreaEntered;
    private volatile boolean mediaTunerAreaLeftAfterStartup;
    private final /* synthetic */ SdisAudioHandler this$0;

    public SdisAudioHandler$SDSIAudioServiceImpl(SdisAudioHandler sdisAudioHandler) {
        this.this$0 = sdisAudioHandler;
        this.RESULTCODE_A2LS_DUPLICATE_REQUEST = 6;
        this.a2lsPopupTriggerModel = SdisAudioHandler.access$200(sdisAudioHandler).getChoiceModel(0, 4242);
        this.tunerMediaActiveModel = SdisAudioHandler.access$200(sdisAudioHandler).getChoiceModel(0, 138);
        SdisAudioHandler.access$200(sdisAudioHandler).getButtonModel(4243).setButtonListener(this);
        this.a2lsActiveModel = SdisAudioHandler.access$200(sdisAudioHandler).getChoiceModel(0, 4515);
        this.bluetoothA2lsService = new NullBluetoothA2LSService(SdisAudioHandler.access$200((SdisAudioHandler)sdisAudioHandler).lcSDIS);
    }

    @Override
    public void setAudioContext(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        SdisAudioHandler.access$300(this.this$0).setAudioContext(n, aSIHMISyncAudioReply);
        if (this.this$0.mediaService != null && n == 4) {
            this.this$0.mediaService.activateSource(7, 0);
        }
    }

    @Override
    public void setBluetoothService(IBluetoothA2LSService iBluetoothA2LSService) {
        this.bluetoothA2lsService = iBluetoothA2LSService;
    }

    @Override
    public void setAudioContext(int n) {
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "<- [SdisAudioHandler.setAudioContext] %1", (Object)SdisLabels.getContext(n));
        CommandList commandList = new CommandList(SdisAudioHandler.access$400(this.this$0));
        commandList.add(SdisAudioHandler.access$500(this.this$0).cmdReleaseSdisAudioConnections());
        if (n != 1) {
            commandList.add(SdisAudioHandler.access$500(this.this$0).cmdReleaseA2LS());
        }
        commandList.add(SdisAudioHandler.access$500(this.this$0).cmdSendInChange(n));
        switch (n) {
            case 3: {
                this.disableA2LS();
                SdisAudioHandler.access$600(this.this$0).setContext(AudioDrawerContext.SOURCE_SDIS, AudioDrawerContext.SOURCE_AUDIO_STATE_INACTIVE);
                this.a2lsActiveModel.setValue(0);
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdAudioFocus(n));
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdAudioRouteMedia(SdisAudioHandler.access$700(this.this$0)));
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdStopStreaming(false));
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdRequestConf(n, SdisAudioHandler.access$800(this.this$0)));
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdStartStreaming());
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdSendReady(n));
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdSendLockState(SdisAudioHandler.access$900(this.this$0)));
                break;
            }
            case 2: {
                this.disableA2LS();
                SdisAudioHandler.access$600(this.this$0).setContext(AudioDrawerContext.SOURCE_SDIS, AudioDrawerContext.SOURCE_AUDIO_STATE_INACTIVE);
                this.a2lsActiveModel.setValue(0);
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdAudioFocus(n));
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdAudioRouteMedia(SdisAudioHandler.access$700(this.this$0)));
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdWaitUntilRadioAudible());
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdStopStreaming(false));
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdRequestConf(n));
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdStartStreaming());
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdSendReady(n));
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdSendLockState(SdisAudioHandler.access$1000(this.this$0)));
                break;
            }
            case 4: {
                this.disableA2LS();
                SdisAudioHandler.access$600(this.this$0).setContext(AudioDrawerContext.SOURCE_SDIS, AudioDrawerContext.SOURCE_AUDIO_STATE_INACTIVE);
                this.a2lsActiveModel.setValue(0);
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdAudioFocus(n));
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdAudioRouteMedia(SdisAudioHandler.access$700(this.this$0)));
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdWaitUntilTVAudible());
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdStopStreaming(false));
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdRequestConf(n));
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdStartStreaming());
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdSendReady(n));
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdSendLockState(SdisAudioHandler.access$1100(this.this$0)));
                break;
            }
            case 1: {
                SdisAudioHandler.access$600(this.this$0).setContext(AudioDrawerContext.SOURCE_SDIS, AudioDrawerContext.SOURCE_AUDIO_STATE_ACTIVE);
                this.a2lsActiveModel.setValue(1);
                this.bluetoothA2lsService.updateA2LSActive(true);
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdAudioFocus(0));
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdStopStreaming(false));
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdRequestConf(n));
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdAudioRouteA2LS());
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdStartStreaming());
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdRequestA2LS());
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdDemute());
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdWaitUntilA2LSAudible());
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdResponseEnableA2LS(this.reply));
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdSendA2LSReady(n));
                break;
            }
            case 0: {
                this.disableA2LS();
                SdisAudioHandler.access$600(this.this$0).setContext(AudioDrawerContext.SOURCE_SDIS, AudioDrawerContext.SOURCE_AUDIO_STATE_INACTIVE);
                this.a2lsActiveModel.setValue(0);
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdAudioFocus(n));
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdStopStreaming(true));
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdReleaseA2LS());
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdAudioRouteMedia(SdisAudioHandler.access$700(this.this$0)));
                commandList.add(SdisAudioHandler.access$500(this.this$0).cmdSendReady(n));
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Unknown audio context ").append(n).toString());
            }
        }
        SdisAudioHandler.access$1202(this.this$0, n);
        commandList.execute("SdisAudioHandler.setAudioContext");
    }

    @Override
    public void triggerA2LSStealing(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(1078071040, "[SdisAudioHandler.triggerA2LSStealing]");
        CommandList commandList = new CommandList(SdisAudioHandler.access$400(this.this$0));
        int n = 1;
        commandList.add(SdisAudioHandler.access$500(this.this$0).cmdSendInChange(n));
        commandList.add(SdisAudioHandler.access$500(this.this$0).cmdStopStreaming(true));
        commandList.add(SdisAudioHandler.access$500(this.this$0).cmdRequestConf(n));
        commandList.add(SdisAudioHandler.access$500(this.this$0).cmdAudioRouteA2LS());
        commandList.add(SdisAudioHandler.access$500(this.this$0).cmdStartStreaming());
        commandList.add(SdisAudioHandler.access$500(this.this$0).cmdDemute());
        commandList.add(SdisAudioHandler.access$500(this.this$0).cmdWaitUntilA2LSAudible());
        commandList.add(SdisAudioHandler.access$500(this.this$0).cmdResponseEnableA2LS(aSIHMISyncAudioReply));
        commandList.add(SdisAudioHandler.access$500(this.this$0).cmdSendA2LSReady(n));
        SdisAudioHandler.access$1202(this.this$0, n);
        commandList.execute("SdisAudioHandler.triggerA2LSStealing");
    }

    @Override
    public void unjoinActiveAudioContext(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.unjoinActiveAudioContext] reply:%1 ", (Object)aSIHMISyncAudioReply);
        SdisAudioHandler.access$300(this.this$0).unjoinActiveAudioContext(aSIHMISyncAudioReply);
    }

    @Override
    public void joinActiveAudioContext(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.joinActiveAudioContext] reply:%1 ", (Object)aSIHMISyncAudioReply);
        SdisAudioHandler.access$300(this.this$0).joinActiveAudioContext(aSIHMISyncAudioReply);
    }

    @Override
    public void updateAudioContext(int n) {
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.updateAudioContext] audioContext: %1", (long)n);
        this.setAudioContext(n);
    }

    @Override
    public void updateA2LSStateDeclined(A2LSState a2LSState) {
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.updateA2LSStateDeclined] requesting: %1, current: %2", (Object)a2LSState.getRequestingDevice(), (Object)a2LSState.getCurrentDevice());
        this.this$0.sdisAudioListener.updateA2LSState(a2LSState);
        this.this$0.a2lsRequestPending = false;
    }

    @Override
    public void updateA2LSStateAccepted(A2LSState a2LSState) {
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.updateA2LSStateAccepted] requesting: %1, current: %2", (Object)a2LSState.getRequestingDevice(), (Object)a2LSState.getCurrentDevice());
        this.this$0.a2lsRequestPending = false;
        this.this$0.sdisAudioListener.updateA2LSState(a2LSState);
    }

    @Override
    public void updateA2LSStatePending(A2LSState a2LSState) {
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.updateA2LSStatePending] requesting: %1, current: %2 send updateAudioContext to sdis", (Object)a2LSState.getRequestingDevice(), (Object)a2LSState.getCurrentDevice());
        this.this$0.a2lsRequestPending = true;
        this.this$0.sdisAudioListener.updateAudioContext(new AudioState(SdisAudioHandler.access$300(this.this$0).getAudioContext(), 2));
        this.this$0.sdisAudioListener.updateA2LSState(a2LSState);
    }

    @Override
    public void updateA2LSStateDisabled(A2LSState a2LSState) {
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.updateA2LSStateDisabled] requesting: %1, current: %2", (Object)a2LSState.getRequestingDevice(), (Object)a2LSState.getCurrentDevice());
        this.this$0.sdisAudioListener.updateA2LSState(a2LSState);
        this.disableA2LS();
    }

    @Override
    public void updateAudioFocus(int n, int n2) {
        this.this$0.a2lsRequestPending = false;
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.updateAudioFocus] HT:%1, appId:%2", (long)n, (long)n2);
        if (n == 0) {
            this.frontAudioFocus = n2;
            switch (this.frontAudioFocus) {
                case 2: {
                    this.this$0.sdisAudioListener.updateFrontAudioContext(new AudioState(3, 1));
                    break;
                }
                case 1: {
                    this.this$0.sdisAudioListener.updateFrontAudioContext(new AudioState(2, 1));
                    break;
                }
                case 38: {
                    this.this$0.sdisAudioListener.updateFrontAudioContext(new AudioState(4, 1));
                    break;
                }
                case 43: 
                case 48: {
                    this.this$0.sdisAudioListener.updateFrontAudioContext(new AudioState(0, 1));
                    break;
                }
                default: {
                    SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.updateAudioFocus] nothing to do!");
                }
            }
        }
    }

    @Override
    public void mediaTunerAreaEntered() {
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.SDSIAudioServiceImpl.mediaTunerAreaEntered]");
        this.mediaTunerAreaEntered = true;
        this.updateA2LSPopup();
    }

    @Override
    public void mediaTunerAreaLeft() {
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.SDSIAudioServiceImpl.mediaTunerAreaLeft]");
        this.mediaTunerAreaEntered = false;
        this.mediaTunerAreaLeftAfterStartup = true;
        this.updateA2LSPopup();
    }

    @Override
    public synchronized void enableA2LS(String string, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "<- [SdisAudioHandler.enableA2LS] %1", (Object)string);
        try {
            if (this.isA2LSRequestPending() && !SdisAudioHandler.access$1300(this.this$0)) {
                SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "<- [SdisAudioHandler.enableA2LS] a2ls request already running from differen sdis, drop this request");
                SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "<- [SdisAudioHandler.enableA2LS] responseEnableA2LS reply: %1, resultcode: %2", (Object)aSIHMISyncAudioReply, (long)0);
                aSIHMISyncAudioReply.responseEnableA2LS(6);
                return;
            }
            int n = SdisAudioHandler.access$200(this.this$0).getChoiceModel(0, 4385).getValue();
            if (this.isA2LSReconnect(string)) {
                n = 0;
                string = string.substring(0, string.lastIndexOf(95));
            }
            switch (n) {
                case 1: {
                    SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.enableA2LS] a2ls settings: %1", (long)n);
                    break;
                }
                case 0: {
                    this.this$0.a2lsRequestPending = true;
                    this.a2lsActive = true;
                    this.reply = aSIHMISyncAudioReply;
                    this.updateA2LSPopup();
                    SdisAudioHandler.access$300(this.this$0).enableA2LS(string, aSIHMISyncAudioReply);
                    break;
                }
                default: {
                    SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "<- [SdisAudioHandler.enableA2LS] responseEnableA2LS reply: %1, resultcode: %2", (Object)aSIHMISyncAudioReply, 1L);
                    aSIHMISyncAudioReply.responseEnableA2LS(1);
                    break;
                }
            }
        }
        catch (MethodException methodException) {
            methodException.printStackTrace();
        }
    }

    private boolean isA2LSReconnect(String string) {
        if (string == null) {
            return false;
        }
        return string.endsWith("RECONNECT");
    }

    private boolean isA2LSRequestPending() {
        return this.this$0.a2lsRequestPending;
    }

    @Override
    public void disableA2LSFromSDIS(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        SdisAudioHandler.access$300(this.this$0).disableA2LS(aSIHMISyncAudioReply);
    }

    @Override
    public void disableA2LSFromHU() {
        SdisAudioHandler.access$300(this.this$0).disableA2LS();
    }

    private void disableA2LS() {
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.disableA2LS]");
        this.a2lsActive = false;
        this.this$0.a2lsRequestPending = false;
        this.bluetoothA2lsService.updateA2LSActive(false);
        this.updateA2LSPopup();
    }

    private void updateA2LSPopup() {
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "<- [SdisAudioHandler.SDSIAudioServiceImpl.updateA2LSPopup] mediaTunerAreaEntered:%1, a2lsActive:%2", this.mediaTunerAreaEntered, this.a2lsActive);
        if (this.checkMediaTunerArea() && this.a2lsActive) {
            SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "<- [SdisAudioHandler.SDSIAudioServiceImpl.updateA2LSPopup] show popup");
            this.a2lsPopupTriggerModel.setValue(1);
        } else {
            SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "<- [SdisAudioHandler.SDSIAudioServiceImpl.updateA2LSPopup] hide popup");
            this.a2lsPopupTriggerModel.setValue(0);
        }
    }

    private boolean checkMediaTunerArea() {
        int n = this.tunerMediaActiveModel.getValue();
        boolean bl = this.mediaTunerAreaEntered || !this.mediaTunerAreaLeftAfterStartup && (n == 1 || n == 2);
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "<- [SdisAudioHandler.SDSIAudioServiceImpl.checkMediaTunerArea] mediaTunerAreaActive: %1 activeApplication:%2", bl, (long)n);
        return bl;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == 4243) {
            SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SdisAudioHandler.keyTyped] disableA2LS");
            this.disableA2LSFromHU();
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void setVolume(int n) {
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SDISAudioHandler.setVolume] volume:%1", (long)n);
        if (this.this$0.isAudible()) {
            SdisAudioHandler.access$1400(this.this$0).changeVolume(n);
        } else {
            SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SDISAudioHandler.setVolume] sdis is not audible discard setVolume");
        }
    }

    @Override
    public void increaseVolume(int n) {
        if (this.this$0.isAudible()) {
            SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SDISAudioHandler.increaseVolume] steps:%1", (long)n);
            SdisAudioHandler.access$1400(this.this$0).increment(-1, n, 1);
        } else {
            SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SDISAudioHandler.increaseVolume] sdis is not audible discard increaseVolume reason: %1", (long)SdisAudioHandler.access$1500(this.this$0));
        }
    }

    @Override
    public void decreaseVolume(int n) {
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SDISAudioHandler.decreaseVolume] steps:%1", (long)n);
        SdisAudioHandler.access$1400(this.this$0).decrement(-1, n, 1);
    }

    @Override
    public void forceFrontAudioContext(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        boolean bl = true;
        if (n == 2) {
            bl = this.frontAudioFocus != 1;
        } else if (n == 3) {
            bl = this.frontAudioFocus != 2;
        } else if (n == 4) {
            bl = this.frontAudioFocus != 38;
        } else {
            SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-1601830656, "[SDISAudioHandler.forceFrontAudioContext] unhandled context:%1", (long)n);
        }
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SDISAudioHandler.forceFrontAudioContext] context:%1 frontAudioFocus:%2 demute:%3", (long)n, (long)this.frontAudioFocus, bl);
        CommandList commandList = new CommandList(SdisAudioHandler.access$400(this.this$0));
        commandList.add(SdisAudioHandler.access$500(this.this$0).cmdFrontAudioFocus(n));
        commandList.add(SdisAudioHandler.access$500(this.this$0).cmdFrontLastMode(n));
        if (bl) {
            commandList.add(SdisAudioHandler.access$500(this.this$0).cmdDemute());
        }
        commandList.execute("SDISAudioHandler.forceFrontAudioContext");
    }

    @Override
    public void registerReplyProxy(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        SdisAudioHandler.access$300(this.this$0).setAudioContext(0, aSIHMISyncAudioReply);
    }

    @Override
    public void removeReplyProxy(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        SdisAudioHandler.access$300(this.this$0).setAudioContext(0, aSIHMISyncAudioReply);
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[SDISAudioHandler.removeReplyProxy] proxy:%1", (Object)aSIHMISyncAudioReply);
        SdisAudioHandler.access$300(this.this$0).removeReplyProxy(aSIHMISyncAudioReply);
    }
}

