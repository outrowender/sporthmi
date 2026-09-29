/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.HMIModelApp;

public interface ButtonModelApp
extends HMIModelApp {
    default public void setButtonListener(ButtonListener buttonListener) {
    }

    default public void setPressed(boolean bl) {
    }

    default public boolean getPressed() {
    }
}

