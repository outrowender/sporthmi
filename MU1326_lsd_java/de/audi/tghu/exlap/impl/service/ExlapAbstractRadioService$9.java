/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapRadioListener;
import de.audi.tghu.exlap.impl.container.RadioPresetsContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractRadioService;

class ExlapAbstractRadioService$9
implements ListenerIterator {
    private final /* synthetic */ RadioPresetsContainer val$radioDABPresetsProperty;
    private final /* synthetic */ ExlapAbstractRadioService this$0;

    ExlapAbstractRadioService$9(ExlapAbstractRadioService exlapAbstractRadioService, RadioPresetsContainer radioPresetsContainer) {
        this.this$0 = exlapAbstractRadioService;
        this.val$radioDABPresetsProperty = radioPresetsContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapRadioListener)exlapListener).updateRadioDABPresets(this.val$radioDABPresetsProperty);
    }
}

