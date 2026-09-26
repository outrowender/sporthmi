/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.TunerObjectContainer;

public interface ITunePlugin {
    public static final int MODE_VIEW;
    public static final int MODE_EDIT;

    default public void doTune(TunerObjectContainer tunerObjectContainer, int n) {
    }

    default public boolean doTune(TunerObjectContainer tunerObjectContainer, int n, int n2) {
    }
}

