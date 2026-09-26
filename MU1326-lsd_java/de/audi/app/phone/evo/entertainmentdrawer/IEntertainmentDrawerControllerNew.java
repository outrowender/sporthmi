/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.entertainmentdrawer;

import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.hmi.model.ModelGroup;

public interface IEntertainmentDrawerControllerNew {
    default public void onIncomingCallMute() {
    }

    default public void showEntertainmentDrawer() {
    }

    default public void closeEntertainmentDrawer() {
    }

    default public void onTelAppEntered(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
    }

    default public void onTelAppLeft(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
    }

    default public void callAcceptedOnCluster() {
    }

    default public void callAcceptedOnMU() {
    }

    default public void computeNewDrawerState(ModelGroup[] modelGroupArray, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
    }

    default public void acceptOnNCLDOngoing(boolean bl) {
    }

    default public void deactivateTerminalModeDrawer() {
    }

    default public void dialingNumberJumpToPhoneWillOccur() {
    }

    default public void resetdialingNumberJumpToPhoneFlag() {
    }
}

