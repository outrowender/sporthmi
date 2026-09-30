/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.dtmf;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.calllist.AbstractPhoneCall;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.dtmf.TelDTMFHandlerBase;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.app.phone.evo.ITelEvoApplication;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.OptionModelListener;

public class TelEvoDTMFHandler
extends TelDTMFHandlerBase
implements ButtonListener,
OptionModelListener {
    private volatile int mpCallState = -1;
    private volatile IGlobalTelephoneStateStruct telState;

    public TelEvoDTMFHandler(ITelApplication iTelApplication) {
        super(iTelApplication);
        this.addSubPhoneComponent(new SendDtmfButtonListener(iTelApplication));
        this.addSubPhoneComponent(new SendDtmfButtonIntellicallReducedButtonListener(iTelApplication));
    }

    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getDTMFSpellerModel().setMinLength(0);
        this.getOptionModel(300435).setListener(this, 300958);
        this.getOptionModel(300436).setListener(this, 300958);
        this.getOptionModel(300439).setListener(this, 300958);
        this.getOptionModel(300440).setListener(this, 300958);
        this.getOptionModel(300438).setListener(this, 300958);
        this.getOptionModel(300437).setListener(this, 300958);
        this.getOptionModel(300430).setListener(this, 300958);
        this.getOptionModel(300433).setListener(this, 300958);
        int n = this.getDTMFSpellerModel().getID();
        this.getOptionModel(300435).setListener(this, n);
        this.getOptionModel(300436).setListener(this, n);
        this.getOptionModel(300439).setListener(this, n);
        this.getOptionModel(300440).setListener(this, n);
        this.getOptionModel(300438).setListener(this, n);
        this.getOptionModel(300437).setListener(this, n);
        this.getOptionModel(300430).setListener(this, n);
        this.getOptionModel(300433).setListener(this, n);
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.getOptionModel(300435).removeListener(300958);
        this.getOptionModel(300436).removeListener(300958);
        this.getOptionModel(300439).removeListener(300958);
        this.getOptionModel(300440).removeListener(300958);
        this.getOptionModel(300438).removeListener(300958);
        this.getOptionModel(300437).removeListener(300958);
        this.getOptionModel(300430).removeListener(300958);
        this.getOptionModel(300433).removeListener(300958);
        int n = this.getDTMFSpellerModel().getID();
        this.getOptionModel(300435).removeListener(n);
        this.getOptionModel(300436).removeListener(n);
        this.getOptionModel(300439).removeListener(n);
        this.getOptionModel(300440).removeListener(n);
        this.getOptionModel(300438).removeListener(n);
        this.getOptionModel(300437).removeListener(n);
        this.getOptionModel(300430).removeListener(n);
        this.getOptionModel(300433).removeListener(n);
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.telState = iGlobalTelephoneStateStruct;
        if (iGlobalTelephoneStateStruct != null && (n == 65544 || n == 131080 || n == 196616)) {
            int n2;
            ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getCallLeadingDevice();
            int n3 = n2 = iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null ? iTelDSIMobileEquipmentDeviceState.getCallState().getMpCallState() : 0;
            if (this.mpCallState != n2) {
                this.mpCallState = n2;
                this.getChoiceModel(300731).setValue(0);
                this.getDTMFSpellerModel().clear();
            }
        }
    }

    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1000000, "[TelEvoDTMFHandler#keyTyped] model=%1, key=%2, terminal=%3", (long)n, (long)n2, (long)n3);
        if (n == this.getDTMFSpellerModel().getID()) {
            CallStateStruct callStateStruct;
            IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.telState;
            CallStateStruct callStateStruct2 = iGlobalTelephoneStateStruct != null ? (iGlobalTelephoneStateStruct.getCallLeadingDevice() != null ? iGlobalTelephoneStateStruct.getCallLeadingDevice().getCallState() : null) : (callStateStruct = null);
            if (iGlobalTelephoneStateStruct != null && callStateStruct != null) {
                AbstractPhoneCall abstractPhoneCall;
                AbstractPhoneCall abstractPhoneCall2 = callStateStruct.isHasOutgoingCall() ? callStateStruct.getOutgoingCall() : (abstractPhoneCall = callStateStruct.isHasActiveCall() ? callStateStruct.getActiveCall() : null);
                if (abstractPhoneCall != null) {
                    short s = abstractPhoneCall.getTelCallID();
                    this.log.log(1000000, "[TelEvoDTMFHandler#keyTyped] hanging up call with id=%1", (long)s);
                    this.getApplication().getTelephoneDSIAccess().hangupCall(s, n3);
                } else {
                    this.log.log(100000, "[TelEvoDTMFHandler#keyTyped] call is null --> NOP!");
                }
            } else {
                this.log.log(100000, "[TelEvoDTMFHandler#keyTyped] state or callState is null --> NOP!");
            }
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
    }

    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        if (this.log.isInfo()) {
            this.log.log(1000000, "[PhoneCallListHandler#keyTyped(OptionModel)] %1", (Object)TelLoggingUtils.keyTypedOption(n, n2, n3, n4, n5));
        }
        switch (n) {
            case 300436: {
                this.log.log(1000000, "[TelEvoDTMFHandler#keyTyped(OptionModel)] join calls via RSL.");
                this.getApplication().getTelephoneDSIAccess().joinCallsToConference(n5);
                break;
            }
            case 300435: {
                this.log.log(1000000, "[TelEvoDTMFHandler#keyTyped(OptionModel)] hold call via RSL.");
                this.getApplication().getTelephoneDSIAccess().swapCalls(n5);
                break;
            }
            case 300439: {
                this.log.log(1000000, "[TelEvoDTMFHandler#keyTyped(OptionModel)] resume call via RSL.");
                this.getApplication().getTelephoneDSIAccess().swapCalls(n5);
                break;
            }
            case 300440: {
                this.log.log(1000000, "[TelEvoDTMFHandler#keyTyped(OptionModel)] swap calls via RSL.");
                this.getApplication().getTelephoneDSIAccess().swapCalls(n5);
                break;
            }
            case 300430: {
                this.log.log(1000000, "[TelEvoDTMFHandler#keyTyped(OptionModel] setting handsfree mode to HANSFREEMODE_HANDSFREE via RSL");
                this.getApplication().getTelephoneDSIAccess().requestSetHandsFreeMode(0, n5);
                break;
            }
            case 300433: {
                this.log.log(1000000, "[TelEvoDTMFHandler#keyTyped(OptionModel] setting handsfree mode to HANDSFREEMODE_PRIVATE_HFP");
                this.getApplication().getTelephoneDSIAccess().requestSetHandsFreeMode(4, n5);
                break;
            }
            case 300437: {
                this.log.log(1000000, "[TelEvoDTMFHandler#keyTyped(OptionModel] demuting the microphone");
                this.getApplication().getAudio().switchMicMuteOff(n5);
                break;
            }
            case 300438: {
                this.log.log(1000000, "[TelEvoDTMFHandler#keyTyped(OptionModel)] muting the microphone");
                this.getApplication().getAudio().switchMicMuteOn(n5);
                break;
            }
            default: {
                this.log.log(10000000, "[TelEvoDTMFHandler#keyTyped(OptionModel)] no handling for model %1", (long)n);
            }
        }
    }

    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }

    private class SendDtmfButtonListener
    extends TelDefaultButtonListener {
        public SendDtmfButtonListener(ITelApplication iTelApplication) {
            super(iTelApplication, 300732);
        }

        public void keyTyped(int n, int n2, int n3) {
            super.keyTyped(n, n2, n3);
            try {
                ITelEvoApplication iTelEvoApplication = (ITelEvoApplication)this.getApplication();
                iTelEvoApplication.getIntellicallHandler().dtmfEntrySelected();
            }
            catch (ClassCastException classCastException) {
                this.log.log(10000, "[TelEvoDTMFHandler#keyTyped]", (Throwable)classCastException);
            }
            this.getChoiceModel(300731).setValue(1);
        }
    }

    private class SendDtmfButtonIntellicallReducedButtonListener
    extends TelDefaultButtonListener {
        public SendDtmfButtonIntellicallReducedButtonListener(ITelApplication iTelApplication) {
            super(iTelApplication, 300958);
        }

        public void keyTyped(int n, int n2, int n3) {
            super.keyTyped(n, n2, n3);
            this.getChoiceModel(300731).setValue(1);
        }
    }
}

