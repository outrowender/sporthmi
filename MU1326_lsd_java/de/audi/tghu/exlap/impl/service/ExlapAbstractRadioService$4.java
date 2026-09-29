/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapRadioListener;
import de.audi.tghu.exlap.impl.container.RadioStationsContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractRadioService;

class ExlapAbstractRadioService$4
implements ListenerIterator {
    private final /* synthetic */ RadioStationsContainer val$availableDABEnsemblesProperty;
    private final /* synthetic */ ExlapAbstractRadioService this$0;

    ExlapAbstractRadioService$4(ExlapAbstractRadioService exlapAbstractRadioService, RadioStationsContainer radioStationsContainer) {
        this.this$0 = exlapAbstractRadioService;
        this.val$availableDABEnsemblesProperty = radioStationsContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapRadioListener)exlapListener).updateAvailableDABEnsembles(this.val$availableDABEnsemblesProperty);
    }
}

