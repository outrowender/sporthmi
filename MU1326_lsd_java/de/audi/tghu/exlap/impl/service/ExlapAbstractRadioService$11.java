/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapRadioListener;
import de.audi.tghu.exlap.impl.container.RadioFrequencyRangesContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractRadioService;

class ExlapAbstractRadioService$11
implements ListenerIterator {
    private final /* synthetic */ RadioFrequencyRangesContainer val$radioFrequencyRangesProperty;
    private final /* synthetic */ ExlapAbstractRadioService this$0;

    ExlapAbstractRadioService$11(ExlapAbstractRadioService exlapAbstractRadioService, RadioFrequencyRangesContainer radioFrequencyRangesContainer) {
        this.this$0 = exlapAbstractRadioService;
        this.val$radioFrequencyRangesProperty = radioFrequencyRangesContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapRadioListener)exlapListener).updateRadioFrequencyRanges(this.val$radioFrequencyRangesProperty);
    }
}

