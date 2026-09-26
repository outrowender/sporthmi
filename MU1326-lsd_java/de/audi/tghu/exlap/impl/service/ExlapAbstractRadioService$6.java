/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapRadioListener;
import de.audi.tghu.exlap.impl.container.RadioStationsContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractRadioService;

class ExlapAbstractRadioService$6
implements ListenerIterator {
    private final /* synthetic */ RadioStationsContainer val$availableDABServiceComponentsProperty;
    private final /* synthetic */ ExlapAbstractRadioService this$0;

    ExlapAbstractRadioService$6(ExlapAbstractRadioService exlapAbstractRadioService, RadioStationsContainer radioStationsContainer) {
        this.this$0 = exlapAbstractRadioService;
        this.val$availableDABServiceComponentsProperty = radioStationsContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapRadioListener)exlapListener).updateAvailableDABServiceComponents(this.val$availableDABServiceComponentsProperty);
    }
}

