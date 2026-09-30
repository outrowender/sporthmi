/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.callcontrol;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.callcontrol.TelCallControlBase;
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.evo.ITelEvoApplication;
import de.audi.app.phone.evo.entertainmentdrawer.IEntertainmentDrawerControllerNew;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;

public class TelEvoCallControl
extends TelCallControlBase {
    public TelEvoCallControl(ITelApplication iTelApplication) {
        super(iTelApplication);
        this.addSubPhoneComponent(new AcceptIncomingCallOnNonCallLeadingDeviceButtonHandler(iTelApplication));
        this.addSubPhoneComponent(new RejectIncomingCallOnNonCallLeadingDeviceButtonHandler(iTelApplication));
    }

    public void init() {
        super.init();
        this.getButtonModel(300689).setButtonListener(this);
    }

    public void deinit() {
        super.deinit();
        this.getButtonModel(300689).resetListener();
    }

    protected ButtonModelApp getAcceptButton() {
        return this.getButtonModel(300674);
    }

    protected ButtonModelApp getRejectButton() {
        return this.getButtonModel(300394);
    }

    protected ButtonModelApp getReplaceButton() {
        return this.getButtonModel(300452);
    }

    public void keyTyped(int n, int n2, int n3) {
        super.keyTyped(n, n2, n3);
        if (n == 300689) {
            this.joinCallsToConference(n3);
        }
    }

    public void hangupCall(int n) {
        switch (n) {
            case 1: {
                break;
            }
            case 0: {
                super.hangupCall(0);
                break;
            }
            default: {
                this.log.log(100000, "[TelEvoCallControl#acceptIncomingCall] unexpected Terminal on hanging up call: %1", (long)n);
            }
        }
    }

    public void acceptIncomingCall(int n) {
        switch (n) {
            case 1: {
                this.acceptIncomingCallOnCluster();
                break;
            }
            case 0: {
                this.acceptIncomingCallOnMU();
                super.acceptIncomingCall(0);
                break;
            }
            default: {
                this.log.log(100000, "[TelEvoCallControl#acceptIncomingCall] unexpected Terminal on accepting incoming call: %1", (long)n);
            }
        }
    }

    private void acceptIncomingCallOnCluster() {
        this.getEntertainmentController().callAcceptedOnCluster();
    }

    private void acceptIncomingCallOnMU() {
        this.getEntertainmentController().callAcceptedOnMU();
    }

    private IEntertainmentDrawerControllerNew getEntertainmentController() {
        return ((ITelEvoApplication)this.getApplication()).getNewEntertainmentDrawerController();
    }

    public void acceptOnNCLDOngoing(boolean bl) {
        this.getEntertainmentController().acceptOnNCLDOngoing(bl);
    }

    private class AcceptIncomingCallOnNonCallLeadingDeviceButtonHandler
    extends TelDefaultButtonListener {
        public AcceptIncomingCallOnNonCallLeadingDeviceButtonHandler(ITelApplication iTelApplication) {
            super(iTelApplication, 301032);
        }

        public void keyTyped(int n, int n2, int n3) {
            this.log.log(1000000, "[TelEvoCallControl.AcceptIncomingCallOnNonCallLeadingDeviceButtonHandler#keyTyped]");
            TelEvoCallControl.this.acceptIncomingCallOnMU();
            this.getApplication().getTelephoneDSIAccess().acceptIncomingCallOnNonCallLeadingDevice(n3, true, new TelDefaultDSIResponseListener(){

                public void responseHangupCall(int n, int n2) {
                    if (n == 0) {
                        TelEvoCallControl.this.acceptOnNCLDOngoing(true);
                    }
                }

                public void responseAcceptCall(int n, int n2) {
                    TelEvoCallControl.this.acceptOnNCLDOngoing(false);
                }
            });
        }
    }

    private class RejectIncomingCallOnNonCallLeadingDeviceButtonHandler
    extends TelDefaultButtonListener {
        public RejectIncomingCallOnNonCallLeadingDeviceButtonHandler(ITelApplication iTelApplication) {
            super(iTelApplication, 301034);
        }

        public void keyTyped(int n, int n2, int n3) {
            this.log.log(1000000, "[TelEvoCallControl.RejectIncomingCallOnNonCallLeadingDeviceButtonHandler#keyTyped]");
            TelEvoCallControl.this.getEntertainmentController().closeEntertainmentDrawer();
            this.getApplication().getTelephoneDSIAccess().rejectIncomingCallOnNonCallLeadingDevice(n3);
        }
    }
}

