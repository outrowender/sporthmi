/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.fuelwarning;

import de.audi.tghu.navi.app.popup.IPopupHandler;

public interface IFuelWarningModelAccess
extends IPopupHandler {
    default public void cleanup() {
    }

    default public void showPopUp(int n) {
    }

    default public void hidePopUp() {
    }

    default public void setFuelWarningActive(boolean bl) {
    }

    default public void onStartSequence(boolean bl) {
    }

    default public void setFuelWarningChoiceModel(boolean bl) {
    }

    default public boolean isFuelWarningActive() {
    }
}

