/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.handler;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.interapp.phone.ITelCallControl;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractOperatorCall;
import de.audi.tghu.online.app.operatorcall.handler.TestHandler;
import de.audi.tghu.online.app.operatorcall.listener.TelephoneListener;

public class TelephoneHandler {
    private final LogChannel logChannel = Online.getInstance().getOperatorCallLogChannel();
    private HMIService hmiService;
    private ITelService telService;
    private TelephoneListener callSession;
    private AbstractOperatorCall listener;
    private boolean isCallerHangUpTriggered;
    private boolean isDialNumberTriggered;

    public void setTelService(ITelService iTelService) {
        if (iTelService == null || this.telService == null) {
            if (iTelService == null) {
                this.logChannel.log(1000000, "TelephoneHandler#setTelService: TelService is null. Removing TelService");
            } else {
                this.logChannel.log(1000000, "TelephoneHandler#setTelService: New TelService is available");
            }
            this.telService = iTelService;
            return;
        }
        this.logChannel.log(100000, "TelephoneHandler#setTelService: TelService already exists. Ignoring new TelService!");
    }

    public boolean isTelServiceAvailable() {
        boolean bl = this.telService != null;
        boolean bl2 = TestHandler.isTelSimulation();
        this.logChannel.log(10000000, "TelephoneHandler#isTelServiceAvailable: real = %1, simulation = %2", bl, bl2);
        return this.telService != null || TestHandler.isTelSimulation();
    }

    public void dialNumber(AbstractOperatorCall abstractOperatorCall) {
        this.logChannel.log(1000000, "TelephoneHandler#dialNumber: entered");
        this.listener = abstractOperatorCall;
        this.isCallerHangUpTriggered = false;
        String string = abstractOperatorCall.getFirstPhoneNumber();
        if (TestHandler.isTelSimulation()) {
            this.logChannel.log(100000, "TelephoneHandler#dialNumber: TelSimulation is running!");
            this.callSession = new TelephoneListener(string, this);
            abstractOperatorCall.resetCallInformation();
            this.logChannel.log(10000000, "TelephoneHandler#dialNumber: phoneNumber = %1", (Object)this.callSession.getTelephoneNumber());
            this.logChannel.log(100000, "TelephoneHandler#dialNumber: TelSimulation is running!");
            ITelCallControl iTelCallControl = this.createDummyTelControl();
            this.callSession.onActive(iTelCallControl);
        } else {
            this.callSession = new TelephoneListener(string, this);
            abstractOperatorCall.resetCallInformation();
            this.logChannel.log(10000000, "TelephoneHandler#dialNumber: phoneNumber = %1", (Object)this.callSession.getTelephoneNumber());
            if (this.telService != null) {
                this.callSession.setCallType(abstractOperatorCall.getServiceType());
                this.setDialNumberTriggered(true);
                this.telService.dialNumber(this.callSession, false);
            } else {
                this.logChannel.log(100000, "TelephoneHandler#dialNumber: not possible. TelService is null!");
                abstractOperatorCall.replyToSDS(8);
                abstractOperatorCall.getCommandListManager().getCommandList().commandAborted("TelephoneHandler#dialNumber: not possible. TelService is null!", "TelephoneHandler#dialNumber: not possible. TelService is null!");
                return;
            }
        }
    }

    private void setDialNumberTriggered(boolean bl) {
        this.logChannel.log(10000000, "TelephoneHandler#setDialNumberTriggered: %1 -> %2", this.isDialNumberTriggered, bl);
        this.isDialNumberTriggered = bl;
    }

    public boolean isDialNumberTriggered() {
        return this.isDialNumberTriggered;
    }

    public void deleteTelListener() {
        this.callSession = null;
    }

    private ITelCallControl createDummyTelControl() {
        return new ITelCallControl(){

            public void hangupCall() {
                TelephoneHandler.this.logChannel.log(100000, "TelephoneHandler#createDummyTelControl#hangupCall: TelSimulation is running!");
            }

            public void muteMicrophone(boolean bl) {
                TelephoneHandler.this.logChannel.log(100000, "TelephoneHandler#createDummyTelControl#muteMicrophone: TelSimulation is running!");
            }
        };
    }

    public void setCallActive() {
        this.listener.callConnected();
    }

    public void updateCallInformation(int n) {
        this.listener.updateCallInformation(n);
    }

    public boolean isCallerHangUpTriggeredAlready() {
        return this.isCallerHangUpTriggered;
    }

    public void hangUp() {
        this.logChannel.log(1000000, "TelephoneHandler#hangup: called -> finishing callSession");
        if (this.isCallerHangUpTriggeredAlready()) {
            this.logChannel.log(100000, "TelephoneHandler#hangup: Hang-up has already been triggered! Waiting for the disconnection of telephone");
            return;
        }
        this.setCallerHangUpTriggered(true);
        this.callSession.finishSession();
    }

    private void setCallerHangUpTriggered(boolean bl) {
        this.logChannel.log(10000000, "TelephoneHandler#setCallerTriggeredHangUp: %1 -> &2", this.isCallerHangUpTriggered, bl);
        this.isCallerHangUpTriggered = bl;
    }

    public void disconnected() {
        this.logChannel.log(1000000, "TelephoneHandler#disconnected: called");
        this.setCallerHangUpTriggered(false);
        this.setDialNumberTriggered(false);
        this.listener.callDisconnected();
    }

    public void muteMicrophone(boolean bl) {
        this.callSession.muteMicrophone(bl);
    }

    public ITelService getTelService() {
        return this.telService;
    }

    public void setHmiService(HMIService hMIService) {
        this.hmiService = hMIService;
    }

    public HMIService getHmiService() {
        return this.hmiService;
    }
}

