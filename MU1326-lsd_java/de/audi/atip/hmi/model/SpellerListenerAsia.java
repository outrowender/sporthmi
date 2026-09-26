/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.SpellerListener;

public interface SpellerListenerAsia
extends SpellerListener {
    default public void textChanged(int n, String string, String string2, int n2) {
    }

    default public void textChanged(int n, String string, String string2, char c2, int n2) {
    }
}

