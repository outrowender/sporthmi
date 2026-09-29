/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.util.change;

import de.audi.tuner.util.change.ChangeEvent;

public interface ChangeListener {
    default public void stateChanged(ChangeEvent changeEvent) {
    }
}

