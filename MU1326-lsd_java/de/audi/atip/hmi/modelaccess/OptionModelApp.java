/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.atip.hmi.modelaccess.HMIModelApp;

public interface OptionModelApp
extends HMIModelApp {
    default public void setListener(OptionModelListener optionModelListener) {
    }

    default public void setListener(OptionModelListener optionModelListener, int n) {
    }

    default public void removeListener(int n) {
    }

    default public void setCustomIDListener(OptionModelListener optionModelListener, int n) {
    }

    default public void removeCustomIDListener(int n) {
    }
}

