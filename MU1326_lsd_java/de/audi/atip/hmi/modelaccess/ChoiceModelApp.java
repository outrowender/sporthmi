/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;

public interface ChoiceModelApp
extends ButtonModelApp {
    default public void setChoiceListener(ChoiceListener choiceListener) {
    }

    default public void setValue(int n) {
    }

    default public int getValue() {
    }

    default public void forceUpdate(boolean bl) {
    }
}

