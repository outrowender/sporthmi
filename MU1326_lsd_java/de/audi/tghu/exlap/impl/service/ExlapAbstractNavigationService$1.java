/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapNavigationListener;
import de.audi.tghu.exlap.impl.container.AddressContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractNavigationService;

class ExlapAbstractNavigationService$1
implements ListenerIterator {
    private final /* synthetic */ AddressContainer val$locationProperty;
    private final /* synthetic */ ExlapAbstractNavigationService this$0;

    ExlapAbstractNavigationService$1(ExlapAbstractNavigationService exlapAbstractNavigationService, AddressContainer addressContainer) {
        this.this$0 = exlapAbstractNavigationService;
        this.val$locationProperty = addressContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapNavigationListener)exlapListener).updateLocation(this.val$locationProperty);
    }
}

