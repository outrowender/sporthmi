/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.listener;

import de.audi.atip.interapp.phone.ITelCallControl;
import de.audi.atip.interapp.phone.ITelCallInformation;
import de.audi.atip.interapp.phone.ITelCallSession;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.operatorcall.handler.TelephoneHandler;
import de.audi.tghu.online.app.operatorcall.handler.TestHandler;
import de.audi.tghu.online.app.operatorcall.listener.TelephoneListener$1;

public class TelephoneListener
implements ITelCallSession {
    private String phoneNumber;
    private TelephoneHandler listener;
    private final LogChannel logChannel = Online.getInstance().getOperatorCallLogChannel();
    private ITelCallControl control;
    private boolean hungup;
    private int callType;

    public TelephoneListener(String string, TelephoneHandler telephoneHandler) {
        this.phoneNumber = string;
        this.listener = telephoneHandler;
    }

    @Override
    public int getCallType() {
        return this.callType;
    }

    @Override
    public String getTelephoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public void onActive(ITelCallControl iTelCallControl) {
        this.logChannel.log(1078071040, "TelephoneListener#onActive called");
        this.control = iTelCallControl;
        if (TestHandler.isTelSimulation()) {
            this.updateCallInfo(this.createDummyCallInfo());
        }
        if (this.listener.isCallerHangUpTriggeredAlready()) {
            this.control.hangupCall();
        }
    }

    private void updateCallInfo(ITelCallInformation iTelCallInformation) {
        this.logChannel.log(1078071040, "TelephoneListener#updateCallInfo: called");
        int n = iTelCallInformation.getTelCallState();
        if (n == 4 || n == 6) {
            this.hungup = false;
            if (this.listener.isCallerHangUpTriggeredAlready()) {
                this.logChannel.log(1078071040, "TelephonenListener#updateCallInfo: Caller aborted call already. Triggering hangup at telephone.");
                this.finishSession();
            } else {
                this.listener.setCallActive();
                this.listener.updateCallInformation(iTelCallInformation.getCallDuration());
            }
        }
    }

    private ITelCallInformation createDummyCallInfo() {
        return new TelephoneListener$1(this);
    }

    @Override
    public void onClose() {
        this.logChannel.log(1078071040, "TelephoneListener#onClose called");
        if (this.hungup) {
            this.logChannel.log(-1601830656, "TelephoneListener#onClose: telephone is already hung up!");
            if (TestHandler.isTelSimulation()) {
                this.logChannel.log(-2137614336, "TelephoneListener#onClose: TelSimulation = true -> This is ok!");
            }
            return;
        }
        this.hungup = true;
        this.listener.disconnected();
    }

    @Override
    public void updateCallInformation(ITelCallInformation iTelCallInformation, int n) {
        this.logChannel.log(1078071040, "TelephoneListener#updateCallInformation: %1", (Object)iTelCallInformation.toString());
        this.updateCallInfo(iTelCallInformation);
        if (n == 0) {
            this.logChannel.log(1078071040, "TelephoneListener#updateCallInformation: set unmute button visible");
            this.listener.getHmiService().getChoiceModel(1092559616).setValue(1);
        } else if (n == 1) {
            this.logChannel.log(1078071040, "TelephoneListener#updateCallInformation: set mute button visible");
            this.listener.getHmiService().getChoiceModel(1092559616).setValue(0);
        }
    }

    public void finishSession() {
        this.logChannel.log(1078071040, "TelephoneListener#finishSession");
        if (TestHandler.isTelSimulation()) {
            this.onClose();
            return;
        }
        if (this.control != null) {
            this.control.hangupCall();
        } else {
            this.logChannel.log(-1601830656, "TelephoneListener#finishSession: Control is null. Waiting for telephone calling onActive-method");
        }
    }

    public void muteMicrophone(boolean bl) {
        if (this.control != null) {
            this.logChannel.log(1078071040, "TelephoneListener#muteMicrophone(): called at control with mute = %1", bl);
            this.control.muteMicrophone(bl);
        } else {
            this.logChannel.log(-1601830656, "TelephoneListener#muteMicrophone(): control is null! Muting/unmuting is not possible");
        }
    }

    public void setCallType(int n) {
        switch (n) {
            case 2: {
                this.callType = 256;
                break;
            }
            case 1: {
                this.callType = 512;
                break;
            }
            default: {
                this.callType = 768;
            }
        }
    }
}

