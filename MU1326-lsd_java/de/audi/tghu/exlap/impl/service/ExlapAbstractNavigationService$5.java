/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapNavigationListener;
import de.audi.tghu.exlap.impl.container.LastDestinationsContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractNavigationService;

class ExlapAbstractNavigationService$5
implements ListenerIterator {
    private final /* synthetic */ LastDestinationsContainer val$lastDestinationsProperty;
    private final /* synthetic */ ExlapAbstractNavigationService this$0;

    ExlapAbstractNavigationService$5(ExlapAbstractNavigationService exlapAbstractNavigationService, LastDestinationsContainer lastDestinationsContainer) {
        this.this$0 = exlapAbstractNavigationService;
        this.val$lastDestinationsProperty = lastDestinationsContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapNavigationListener)exlapListener).updateLastDestinations(this.val$lastDestinationsProperty);
    }
}

