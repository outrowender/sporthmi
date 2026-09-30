/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.view.HMIView;

public interface ITouchInputManager {
    public void setDesiredRecognizerMode(HMIView var1, int var2);

    public void deregister(HMIView var1);

    public void presetPopupActive(boolean var1);

    public boolean isPresetPopupActive();

    public void clear();

    public void updateRecognizerMode(boolean var1);
}

