/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.RadioPresetHandler;
import de.audi.tuner.app.RadioPresetHandler$1;
import de.audi.tuner.app.RadioPresetHandler$INARMemoryListIndexChangeListener;
import de.audi.tuner.app.TunerObjectContainer;

class RadioPresetHandler$NARMemoryListPresetIndexChangeListener
implements RadioPresetHandler$INARMemoryListIndexChangeListener {
    private final /* synthetic */ RadioPresetHandler this$0;

    private RadioPresetHandler$NARMemoryListPresetIndexChangeListener(RadioPresetHandler radioPresetHandler) {
        this.this$0 = radioPresetHandler;
    }

    @Override
    public void memoryListPresetIndexChanged(int n, TunerObjectContainer tunerObjectContainer) {
        RadioPresetHandler.access$100(this.this$0, n, tunerObjectContainer);
    }

    /* synthetic */ RadioPresetHandler$NARMemoryListPresetIndexChangeListener(RadioPresetHandler radioPresetHandler, RadioPresetHandler$1 radioPresetHandler$1) {
        this(radioPresetHandler);
    }
}

