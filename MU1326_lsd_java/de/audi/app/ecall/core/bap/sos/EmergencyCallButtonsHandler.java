/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.bap.sos;

import de.audi.app.ecall.core.AbstractEcallComponent;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.state.IEcallStateStruct;
import de.audi.app.ecall.core.state.IGlobalEcallStateListener;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.interapp.bap.ecall.data.PhoneCall;

public class EmergencyCallButtonsHandler
extends AbstractEcallComponent
implements IGlobalEcallStateListener,
ButtonListener {
    private volatile PhoneCall phoneCall;

    public EmergencyCallButtonsHandler(IEcallApplication iEcallApplication) {
        super(iEcallApplication, "App.Ecall.Main");
    }

    public void init() {
        this.getButtonModel(3300002).setButtonListener(this);
        this.getButtonModel(3300001).setButtonListener(this);
        this.getButtonModel(3300000).setButtonListener(this);
        this.getButtonModel(3300003).setButtonListener(this);
        this.getButtonModel(3300009).setButtonListener(this);
        this.getButtonModel(3300011).setButtonListener(this);
        this.getButtonModel(3300007).setButtonListener(this);
        this.getButtonModel(3300024).setButtonListener(this);
        this.getApplication().getEcallStateManager().registerListener(this);
    }

    public void deinit() {
        this.getButtonModel(3300002).resetListener();
        this.getButtonModel(3300001).resetListener();
        this.getButtonModel(3300000).resetListener();
        this.getButtonModel(3300003).resetListener();
        this.getButtonModel(3300009).resetListener();
        this.getButtonModel(3300011).resetListener();
        this.getButtonModel(3300007).resetListener();
        this.getButtonModel(3300024).resetListener();
        this.getApplication().getEcallStateManager().removeListener(this);
    }

    public void keyTyped(int n, int n2, int n3) {
        this.log.log(10000000, "BreakDownButtonsHandler#keyTyped(): called modelID=%1", (long)n);
        switch (n) {
            case 3300001: 
            case 3300002: 
            case 3300003: {
                this.getEcallBapServiceAdapter().terminateBreakdownService();
                break;
            }
            case 3300000: {
                this.onTerminateCustomCall();
                break;
            }
            case 3300009: {
                this.onEndBreakdownCall();
                break;
            }
            case 3300024: {
                this.onEndEmergencyCall();
                break;
            }
            case 3300011: {
                this.getEcallBapServiceAdapter().acceptBreakdownCall();
                break;
            }
            case 3300007: {
                this.getEcallBapServiceAdapter().acceptEmergencyServiceCall();
                break;
            }
            default: {
                this.log.log(10000000, "BreakdownCallServiceHandler.ButtonListener#keyTyped(): unhandled click for modelID = %1", (long)n);
            }
        }
    }

    public void updateGlobalEcallStateProperty(int n, IEcallStateStruct iEcallStateStruct) {
        if (n == 1) {
            this.phoneCall = iEcallStateStruct.getCurrentHighPriorityPhoneCall();
        } else if (n == 7 && this.phoneCall != null) {
            this.getEcallBapServiceAdapter().endEmergencyCall(this.phoneCall);
        }
    }

    private void onEndEmergencyCall() {
        this.getEcallBapServiceAdapter().endEmergencyCall(this.phoneCall);
    }

    private void onEndBreakdownCall() {
        this.getEcallBapServiceAdapter().endBreakdownCall(this.phoneCall);
    }

    private void onTerminateCustomCall() {
        this.log.log(10000000, "BreakDownCallButtonsHandler#onTerminateCustomCall(): called");
        this.getApplication().getAudioConnectionHandler().scheduleMutePinConnectionRequest();
        this.getApplication().getTelServiceEcallHandler().hangupAllCalls();
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }
}

