/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.entertainmentdrawer;

import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.hmi.model.ModelGroup;

public interface IEntertainmentDrawerControllerNew {
    public void onIncomingCallMute();

    public void showEntertainmentDrawer();

    public void closeEntertainmentDrawer();

    public void onTelAppEntered(IGlobalTelephoneStateStruct var1);

    public void onTelAppLeft(IGlobalTelephoneStateStruct var1);

    public void callAcceptedOnCluster();

    public void callAcceptedOnMU();

    public void computeNewDrawerState(ModelGroup[] var1, IGlobalTelephoneStateStruct var2);

    public void acceptOnNCLDOngoing(boolean var1);

    public void deactivateTerminalModeDrawer();

    public void dialingNumberJumpToPhoneWillOccur();

    public void resetdialingNumberJumpToPhoneFlag();
}

