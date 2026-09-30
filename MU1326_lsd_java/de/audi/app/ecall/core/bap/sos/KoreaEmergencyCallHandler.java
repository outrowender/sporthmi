/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.bap.sos;

import de.audi.app.ecall.core.AbstractEcallComponent;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.IEcallComponent;
import de.audi.app.ecall.core.bap.sos.EcallBluetoothHandler;
import de.audi.app.ecall.core.state.IEcallStateStruct;
import de.audi.app.ecall.core.state.IGlobalEcallStateListener;
import de.audi.atip.interapp.bap.ecall.data.PendingServiceRequests;
import de.audi.atip.interapp.bap.ecall.data.PhoneCall;

public class KoreaEmergencyCallHandler
extends AbstractEcallComponent
implements IGlobalEcallStateListener {
    private final EcallBluetoothHandler ecallBluetoothHandler;

    public KoreaEmergencyCallHandler(IEcallApplication iEcallApplication) {
        super(iEcallApplication, "App.Ecall.SOS");
        this.ecallBluetoothHandler = new EcallBluetoothHandler(iEcallApplication);
    }

    public void init() {
        super.init();
        this.getApplication().getEcallStateManager().registerListener(this);
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getEcallStateManager().removeListener(this);
    }

    protected IEcallComponent[] getSubComponents() {
        return new IEcallComponent[]{this.ecallBluetoothHandler};
    }

    public void updateGlobalEcallStateProperty(int n, IEcallStateStruct iEcallStateStruct) {
        PhoneCall phoneCall;
        PendingServiceRequests pendingServiceRequests;
        if (n == 1) {
            PhoneCall phoneCall2 = iEcallStateStruct.getCurrentPhoneCallByKind(1);
            if (phoneCall2 != null) {
                int n2 = phoneCall2.getState();
                if (n2 == 3) {
                    this.activateEcall();
                } else if (n2 == 0) {
                    this.deactivateEcall();
                }
            }
        } else if (n == 9) {
            String string = iEcallStateStruct.getEmergencyNumberToBeDialed();
            this.dialEmergencyNumber(string);
        } else if (n == 8) {
            PhoneCall phoneCall3 = iEcallStateStruct.getCurrentPhoneCallByKind(1);
            if (phoneCall3 != null) {
                this.hangupEmergencyCall(phoneCall3);
            }
        } else if (n == 4 && ((pendingServiceRequests = iEcallStateStruct.getPendingServiceCalls()).isManualEmergencyCallPending() || pendingServiceRequests.isAutomaticCrashNotificationPending() || pendingServiceRequests.isBreakdownServicePending()) && (phoneCall = iEcallStateStruct.getCurrentPhoneCallByKind(1)) != null) {
            this.hangupEmergencyCall(phoneCall);
        }
    }

    private void dialEmergencyNumber(String string) {
        this.getEcallBapServiceAdapter().dialEmergencyNumber(string);
    }

    private void hangupEmergencyCall(PhoneCall phoneCall) {
        this.getEcallBapServiceAdapter().endEmergencyCall(phoneCall);
    }

    private void activateEcall() {
        this.log.log(1000000, "KoreaEmergencyCallHandler#activateEcall(): called");
        this.getApplication().getTelServiceEcallHandler().hangupAllCalls();
        this.ecallBluetoothHandler.switchOffBluetooth();
    }

    private void deactivateEcall() {
        this.log.log(1000000, "KoreaEmergencyCallHandler#deactivateEcall(): called");
        this.ecallBluetoothHandler.switchOnBluetooth();
    }
}

