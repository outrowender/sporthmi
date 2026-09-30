/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface TVActionProxy
extends ActionProxy {
    public void tvSeekModeLeft(int var1);

    public void tvParentalRatingLeft(int var1);

    public void leaveOptionScreen(int var1);

    public void tvTxtEntered(int var1);

    public void hmiActivatedTV(int var1);

    public void hmiDeactivatedTV(int var1);

    public void terminalModeLeft(int var1);

    public void tvDataBroadcastEntered(int var1);

    public void tvEPGEntered(int var1);

    public void tvTeletextEntered(int var1);

    public void tvVisualAudioEntered(int var1);

    public void tvEngineeringEntered(int var1);

    public void tvCasDisclaimerEntered(int var1);

    public void tvFullscreenEntered(int var1);

    public void tvFullscreenLeft(int var1);

    public void tvParentalRatingDisclaimerEntered(int var1);

    public void enterOptionScreen(int var1);

    public void tvShowOsd(int var1);

    public void tvEwsPopupClosed(int var1);

    public void avFullscreenEntered(int var1);

    public void avFullscreenLeft(int var1);
}

