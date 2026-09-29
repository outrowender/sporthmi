/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapRadioListener;
import de.audi.tghu.exlap.impl.container.RadioStationsContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractRadioService;

class ExlapAbstractRadioService$5
implements ListenerIterator {
    private final /* synthetic */ RadioStationsContainer val$availableDABServicesProperty;
    private final /* synthetic */ ExlapAbstractRadioService this$0;

    ExlapAbstractRadioService$5(ExlapAbstractRadioService exlapAbstractRadioService, RadioStationsContainer radioStationsContainer) {
        this.this$0 = exlapAbstractRadioService;
        this.val$availableDABServicesProperty = radioStationsContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapRadioListener)exlapListener).updateAvailableDABServices(this.val$availableDABServicesProperty);
    }
}

