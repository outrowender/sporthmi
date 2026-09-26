/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.ButtonModelGUI;

public interface ChoiceModelGUI
extends ButtonModelGUI {
    default public int getValue() {
    }

    default public void itemSelected(int n, int n2) {
    }

    default public void itemFocused(int n, int n2) {
    }
}

