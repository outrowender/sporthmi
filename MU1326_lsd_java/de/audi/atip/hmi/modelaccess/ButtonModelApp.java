/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.HMIModelApp;

public interface ButtonModelApp
extends HMIModelApp {
    public void setButtonListener(ButtonListener var1);

    public void setPressed(boolean var1);

    public boolean getPressed();
}

