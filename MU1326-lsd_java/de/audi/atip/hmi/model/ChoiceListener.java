/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.ButtonListener;

public interface ChoiceListener
extends ButtonListener {
    default public void itemSelected(int n, int n2, int n3, int n4) {
    }

    default public void itemFocused(int n, int n2, int n3, int n4) {
    }
}

