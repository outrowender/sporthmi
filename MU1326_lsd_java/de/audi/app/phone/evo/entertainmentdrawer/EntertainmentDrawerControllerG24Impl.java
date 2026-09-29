/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.entertainmentdrawer;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.evo.entertainmentdrawer.IEntertainmentDrawerControllerNew;
import de.audi.atip.hmi.model.ModelGroup;

public class EntertainmentDrawerControllerG24Impl
extends AbstractPhoneComponent
implements IEntertainmentDrawerControllerNew {
    public EntertainmentDrawerControllerG24Impl(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.EntertainmentDrawer");
    }

    public void onAcceptIncomingCall() {
        this.log.log(-1601830656, "EntertainmentDrawerControllerG24Impl#onAcceptIncomingCall(): called. G24 hasn't entertainmentDrawer.");
    }

    public void onOutgoingCall(int n) {
        this.log.log(-1601830656, "EntertainmentDrawerControllerG24Impl#onOutgoingCall(): called. G24 hasn't entertainmentDrawer.");
    }

    @Override
    public void onIncomingCallMute() {
        this.log.log(-1601830656, "EntertainmentDrawerControllerG24Impl#onIncomingCallMute(): called. G24 hasn't entertainmentDrawer.");
    }

    @Override
    public void showEntertainmentDrawer() {
        this.log.log(-1601830656, "EntertainmentDrawerControllerG24Impl#showEntertainmentDrawer(): called. G24 hasn't entertainmentDrawer.");
    }

    @Override
    public void onTelAppEntered(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.log.log(-1601830656, "EntertainmentDrawerControllerG24Impl#onTelAppEntered(): called. G24 hasn't entertainmentDrawer.");
    }

    @Override
    public void onTelAppLeft(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.log.log(-1601830656, "EntertainmentDrawerControllerG24Impl#onTelAppLeft(): called. G24 hasn't entertainmentDrawer.");
    }

    @Override
    public void callAcceptedOnCluster() {
        this.log.log(-1601830656, "EntertainmentDrawerControllerG24Impl#callAcceptedFromCluster(): called. G24 hasn't entertainmentDrawer.");
    }

    @Override
    public void callAcceptedOnMU() {
        this.log.log(-1601830656, "EntertainmentDrawerControllerG24Impl#callAcceptedOnMU(): called. G24 hasn't entertainmentDrawer.");
    }

    @Override
    public void closeEntertainmentDrawer() {
        this.log.log(-1601830656, "EntertainmentDrawerControllerG24Impl#closeEntertainmentDrawer(): called. G24 hasn't entertainmentDrawer.");
    }

    @Override
    public void computeNewDrawerState(ModelGroup[] modelGroupArray, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.log.log(-1601830656, "EntertainmentDrawerControllerG24Impl#computeNewDrawerState(): called. G24 hasn't entertainmentDrawer.");
        for (int i2 = 0; i2 < modelGroupArray.length; ++i2) {
            modelGroupArray[i2].flush();
            modelGroupArray[i2].removeAll();
        }
    }

    @Override
    public void acceptOnNCLDOngoing(boolean bl) {
        this.log.log(-1601830656, "EntertainmentDrawerControllerG24Impl#acceptOnNCLDOngoing(): called. G24 hasn't entertainmentDrawer.");
    }

    @Override
    public void deactivateTerminalModeDrawer() {
        this.log.log(-1601830656, "EntertainmentDrawerControllerG24Impl#deactivateTerminalModeDrawer(): called. G24 hasn't entertainmentDrawer.");
    }

    @Override
    public void dialingNumberJumpToPhoneWillOccur() {
        this.log.log(14808325, "EntertainmentDrawerControllerG24Impl#dialingNumberJumpToPhoneWillOccur(): called. G24 hasn't entertainmentDrawer.");
    }

    @Override
    public void resetdialingNumberJumpToPhoneFlag() {
        this.log.log(14808325, "EntertainmentDrawerControllerG24Impl#resetdialingNumberJumpToPhoneFlag(): called. G24 hasn't entertainmentDrawer.");
    }
}

