/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapNavigationListener;
import de.audi.tghu.exlap.impl.container.GuidanceRemainingContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractNavigationService;

class ExlapAbstractNavigationService$4
implements ListenerIterator {
    private final /* synthetic */ GuidanceRemainingContainer val$guidanceRemainingProperty;
    private final /* synthetic */ ExlapAbstractNavigationService this$0;

    ExlapAbstractNavigationService$4(ExlapAbstractNavigationService exlapAbstractNavigationService, GuidanceRemainingContainer guidanceRemainingContainer) {
        this.this$0 = exlapAbstractNavigationService;
        this.val$guidanceRemainingProperty = guidanceRemainingContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapNavigationListener)exlapListener).updateGuidanceRemaining(this.val$guidanceRemainingProperty);
    }
}

