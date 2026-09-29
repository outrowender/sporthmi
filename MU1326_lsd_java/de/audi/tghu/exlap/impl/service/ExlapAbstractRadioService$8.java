/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapRadioListener;
import de.audi.tghu.exlap.impl.container.RadioPresetsContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractRadioService;

class ExlapAbstractRadioService$8
implements ListenerIterator {
    private final /* synthetic */ RadioPresetsContainer val$radioFMPresetsProperty;
    private final /* synthetic */ ExlapAbstractRadioService this$0;

    ExlapAbstractRadioService$8(ExlapAbstractRadioService exlapAbstractRadioService, RadioPresetsContainer radioPresetsContainer) {
        this.this$0 = exlapAbstractRadioService;
        this.val$radioFMPresetsProperty = radioPresetsContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapRadioListener)exlapListener).updateRadioFMPresets(this.val$radioFMPresetsProperty);
    }
}

