/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.dtmf;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.calllist.AbstractPhoneCall;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.dtmf.TelDTMFHandlerBase;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.app.phone.evo.dtmf.TelEvoDTMFHandler$SendDtmfButtonIntellicallReducedButtonListener;
import de.audi.app.phone.evo.dtmf.TelEvoDTMFHandler$SendDtmfButtonListener;
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
        this.addSubPhoneComponent(new TelEvoDTMFHandler$SendDtmfButtonListener(this, iTelApplication));
        this.addSubPhoneComponent(new TelEvoDTMFHandler$SendDtmfButtonIntellicallReducedButtonListener(this, iTelApplication));
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getDTMFSpellerModel().setMinLength(0);
        this.getOptionModel(-1818950656).setListener(this, -1634270208);
        this.getOptionModel(-1802173440).setListener(this, -1634270208);
        this.getOptionModel(-1751841792).setListener(this, -1634270208);
        this.getOptionModel(-1735064576).setListener(this, -1634270208);
        this.getOptionModel(-1768619008).setListener(this, -1634270208);
        this.getOptionModel(-1785396224).setListener(this, -1634270208);
        this.getOptionModel(-1902836736).setListener(this, -1634270208);
        this.getOptionModel(-1852505088).setListener(this, -1634270208);
        int n = this.getDTMFSpellerModel().getID();
        this.getOptionModel(-1818950656).setListener(this, n);
        this.getOptionModel(-1802173440).setListener(this, n);
        this.getOptionModel(-1751841792).setListener(this, n);
        this.getOptionModel(-1735064576).setListener(this, n);
        this.getOptionModel(-1768619008).setListener(this, n);
        this.getOptionModel(-1785396224).setListener(this, n);
        this.getOptionModel(-1902836736).setListener(this, n);
        this.getOptionModel(-1852505088).setListener(this, n);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.getOptionModel(-1818950656).removeListener(-1634270208);
        this.getOptionModel(-1802173440).removeListener(-1634270208);
        this.getOptionModel(-1751841792).removeListener(-1634270208);
        this.getOptionModel(-1735064576).removeListener(-1634270208);
        this.getOptionModel(-1768619008).removeListener(-1634270208);
        this.getOptionModel(-1785396224).removeListener(-1634270208);
        this.getOptionModel(-1902836736).removeListener(-1634270208);
        this.getOptionModel(-1852505088).removeListener(-1634270208);
        int n = this.getDTMFSpellerModel().getID();
        this.getOptionModel(-1818950656).removeListener(n);
        this.getOptionModel(-1802173440).removeListener(n);
        this.getOptionModel(-1751841792).removeListener(n);
        this.getOptionModel(-1735064576).removeListener(n);
        this.getOptionModel(-1768619008).removeListener(n);
        this.getOptionModel(-1785396224).removeListener(n);
        this.getOptionModel(-1902836736).removeListener(n);
        this.getOptionModel(-1852505088).removeListener(n);
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.telState = iGlobalTelephoneStateStruct;
        if (iGlobalTelephoneStateStruct != null && (n == 0x8000100 || n == 0x8000200 || n == 0x8000300)) {
            int n2;
            ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getCallLeadingDevice();
            int n3 = n2 = iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null ? iTelDSIMobileEquipmentDeviceState.getCallState().getMpCallState() : 0;
            if (this.mpCallState != n2) {
                this.mpCallState = n2;
                this.getChoiceModel(-1147796480).setValue(0);
                this.getDTMFSpellerModel().clear();
            }
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "[TelEvoDTMFHandler#keyTyped] model=%1, key=%2, terminal=%3", (long)n, (long)n2, (long)n3);
        if (n == this.getDTMFSpellerModel().getID()) {
            CallStateStruct callStateStruct;
            IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.telState;
            CallStateStruct callStateStruct2 = iGlobalTelephoneStateStruct != null ? (iGlobalTelephoneStateStruct.getCallLeadingDevice() != null ? iGlobalTelephoneStateStruct.getCallLeadingDevice().getCallState() : null) : (callStateStruct = null);
            if (iGlobalTelephoneStateStruct != null && callStateStruct != null) {
                AbstractPhoneCall abstractPhoneCall;
                AbstractPhoneCall abstractPhoneCall2 = callStateStruct.isHasOutgoingCall() ? callStateStruct.getOutgoingCall() : (abstractPhoneCall = callStateStruct.isHasActiveCall() ? callStateStruct.getActiveCall() : null);
                if (abstractPhoneCall != null) {
                    short s = abstractPhoneCall.getTelCallID();
                    this.log.log(1078071040, "[TelEvoDTMFHandler#keyTyped] hanging up call with id=%1", (long)s);
                    this.getApplication().getTelephoneDSIAccess().hangupCall(s, n3);
                } else {
                    this.log.log(-1601830656, "[TelEvoDTMFHandler#keyTyped] call is null --> NOP!");
                }
            } else {
                this.log.log(-1601830656, "[TelEvoDTMFHandler#keyTyped] state or callState is null --> NOP!");
            }
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        if (this.log.isInfo()) {
            this.log.log(1078071040, "[PhoneCallListHandler#keyTyped(OptionModel)] %1", (Object)TelLoggingUtils.keyTypedOption(n, n2, n3, n4, n5));
        }
        switch (n) {
            case 300436: {
                this.log.log(1078071040, "[TelEvoDTMFHandler#keyTyped(OptionModel)] join calls via RSL.");
                this.getApplication().getTelephoneDSIAccess().joinCallsToConference(n5);
                break;
            }
            case 300435: {
                this.log.log(1078071040, "[TelEvoDTMFHandler#keyTyped(OptionModel)] hold call via RSL.");
                this.getApplication().getTelephoneDSIAccess().swapCalls(n5);
                break;
            }
            case 300439: {
                this.log.log(1078071040, "[TelEvoDTMFHandler#keyTyped(OptionModel)] resume call via RSL.");
                this.getApplication().getTelephoneDSIAccess().swapCalls(n5);
                break;
            }
            case 300440: {
                this.log.log(1078071040, "[TelEvoDTMFHandler#keyTyped(OptionModel)] swap calls via RSL.");
                this.getApplication().getTelephoneDSIAccess().swapCalls(n5);
                break;
            }
            case 300430: {
                this.log.log(1078071040, "[TelEvoDTMFHandler#keyTyped(OptionModel] setting handsfree mode to HANSFREEMODE_HANDSFREE via RSL");
                this.getApplication().getTelephoneDSIAccess().requestSetHandsFreeMode(0, n5);
                break;
            }
            case 300433: {
                this.log.log(1078071040, "[TelEvoDTMFHandler#keyTyped(OptionModel] setting handsfree mode to HANDSFREEMODE_PRIVATE_HFP");
                this.getApplication().getTelephoneDSIAccess().requestSetHandsFreeMode(4, n5);
                break;
            }
            case 300437: {
                this.log.log(1078071040, "[TelEvoDTMFHandler#keyTyped(OptionModel] demuting the microphone");
                this.getApplication().getAudio().switchMicMuteOff(n5);
                break;
            }
            case 300438: {
                this.log.log(1078071040, "[TelEvoDTMFHandler#keyTyped(OptionModel)] muting the microphone");
                this.getApplication().getAudio().switchMicMuteOn(n5);
                break;
            }
            default: {
                this.log.log(-2137614336, "[TelEvoDTMFHandler#keyTyped(OptionModel)] no handling for model %1", (long)n);
            }
        }
    }

    @Override
    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }
}

