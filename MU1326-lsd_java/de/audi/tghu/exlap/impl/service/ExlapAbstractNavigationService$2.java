/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapNavigationListener;
import de.audi.tghu.exlap.impl.container.GuidanceStateContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractNavigationService;

class ExlapAbstractNavigationService$2
implements ListenerIterator {
    private final /* synthetic */ GuidanceStateContainer val$guidanceStateProperty;
    private final /* synthetic */ ExlapAbstractNavigationService this$0;

    ExlapAbstractNavigationService$2(ExlapAbstractNavigationService exlapAbstractNavigationService, GuidanceStateContainer guidanceStateContainer) {
        this.this$0 = exlapAbstractNavigationService;
        this.val$guidanceStateProperty = guidanceStateContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapNavigationListener)exlapListener).updateGuidanceState(this.val$guidanceStateProperty);
    }
}

