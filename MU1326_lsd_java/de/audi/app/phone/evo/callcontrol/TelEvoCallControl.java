/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.callcontrol;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.callcontrol.TelCallControlBase;
import de.audi.app.phone.evo.ITelEvoApplication;
import de.audi.app.phone.evo.callcontrol.TelEvoCallControl$AcceptIncomingCallOnNonCallLeadingDeviceButtonHandler;
import de.audi.app.phone.evo.callcontrol.TelEvoCallControl$RejectIncomingCallOnNonCallLeadingDeviceButtonHandler;
import de.audi.app.phone.evo.entertainmentdrawer.IEntertainmentDrawerControllerNew;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;

public class TelEvoCallControl
extends TelCallControlBase {
    public TelEvoCallControl(ITelApplication iTelApplication) {
        super(iTelApplication);
        this.addSubPhoneComponent(new TelEvoCallControl$AcceptIncomingCallOnNonCallLeadingDeviceButtonHandler(this, iTelApplication));
        this.addSubPhoneComponent(new TelEvoCallControl$RejectIncomingCallOnNonCallLeadingDeviceButtonHandler(this, iTelApplication));
    }

    @Override
    public void init() {
        super.init();
        this.getButtonModel(-1852439552).setButtonListener(this);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getButtonModel(-1852439552).resetListener();
    }

    @Override
    protected ButtonModelApp getAcceptButton() {
        return this.getButtonModel(-2104097792);
    }

    @Override
    protected ButtonModelApp getRejectButton() {
        return this.getButtonModel(1788150784);
    }

    @Override
    protected ButtonModelApp getReplaceButton() {
        return this.getButtonModel(-1533737984);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        super.keyTyped(n, n2, n3);
        if (n == -1852439552) {
            this.joinCallsToConference(n3);
        }
    }

    @Override
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
                this.log.log(-1601830656, "[TelEvoCallControl#acceptIncomingCall] unexpected Terminal on hanging up call: %1", (long)n);
            }
        }
    }

    @Override
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
                this.log.log(-1601830656, "[TelEvoCallControl#acceptIncomingCall] unexpected Terminal on accepting incoming call: %1", (long)n);
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

    @Override
    public void acceptOnNCLDOngoing(boolean bl) {
        this.getEntertainmentController().acceptOnNCLDOngoing(bl);
    }

    static /* synthetic */ void access$000(TelEvoCallControl telEvoCallControl) {
        telEvoCallControl.acceptIncomingCallOnMU();
    }

    static /* synthetic */ IEntertainmentDrawerControllerNew access$200(TelEvoCallControl telEvoCallControl) {
        return telEvoCallControl.getEntertainmentController();
    }
}

