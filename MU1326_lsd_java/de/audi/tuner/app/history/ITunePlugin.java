/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.history;

import de.audi.tuner.app.TunerObjectContainer;

public interface ITunePlugin {
    public static final int MODE_VIEW = 0;
    public static final int MODE_EDIT = 1;

    public void doTune(TunerObjectContainer var1, int var2);

    public boolean doTune(TunerObjectContainer var1, int var2, int var3);
}

