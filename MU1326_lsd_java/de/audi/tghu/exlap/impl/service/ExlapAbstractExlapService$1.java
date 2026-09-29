/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapExlapListener;
import de.audi.tghu.exlap.impl.container.ContextStatesContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractExlapService;

class ExlapAbstractExlapService$1
implements ListenerIterator {
    private final /* synthetic */ ContextStatesContainer val$contextStatesProperty;
    private final /* synthetic */ ExlapAbstractExlapService this$0;

    ExlapAbstractExlapService$1(ExlapAbstractExlapService exlapAbstractExlapService, ContextStatesContainer contextStatesContainer) {
        this.this$0 = exlapAbstractExlapService;
        this.val$contextStatesProperty = contextStatesContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapExlapListener)exlapListener).updateContextStates(this.val$contextStatesProperty);
    }
}

