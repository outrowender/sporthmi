/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.fuelwarning;

import de.audi.tghu.navi.app.popup.IPopupHandler;

public interface IFuelWarningModelAccess
extends IPopupHandler {
    public void cleanup();

    public void showPopUp(int var1);

    public void hidePopUp();

    public void setFuelWarningActive(boolean var1);

    public void onStartSequence(boolean var1);

    public void setFuelWarningChoiceModel(boolean var1);

    public boolean isFuelWarningActive();
}

