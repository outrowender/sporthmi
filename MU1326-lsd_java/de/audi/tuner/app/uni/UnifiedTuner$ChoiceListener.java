/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.uni.UnifiedTuner;
import de.audi.tuner.app.uni.UnifiedTuner$1;

class UnifiedTuner$ChoiceListener
extends DefaultChoiceListener {
    private final /* synthetic */ UnifiedTuner this$0;

    private UnifiedTuner$ChoiceListener(UnifiedTuner unifiedTuner) {
        this.this$0 = unifiedTuner;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        UnifiedTuner.access$1100(this.this$0).setSoftLinkSwitch(n2 == 1);
        TunerProxyManager.getInstance().getDABTuner().setSoftlinking(n2);
    }

    /* synthetic */ UnifiedTuner$ChoiceListener(UnifiedTuner unifiedTuner, UnifiedTuner$1 unifiedTuner$1) {
        this(unifiedTuner);
    }
}

