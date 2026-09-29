/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapSystemListener;
import de.audi.tghu.exlap.impl.container.UnitDistanceContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractSystemService;

class ExlapAbstractSystemService$3
implements ListenerIterator {
    private final /* synthetic */ UnitDistanceContainer val$unitDistanceProperty;
    private final /* synthetic */ ExlapAbstractSystemService this$0;

    ExlapAbstractSystemService$3(ExlapAbstractSystemService exlapAbstractSystemService, UnitDistanceContainer unitDistanceContainer) {
        this.this$0 = exlapAbstractSystemService;
        this.val$unitDistanceProperty = unitDistanceContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapSystemListener)exlapListener).updateUnitDistance(this.val$unitDistanceProperty);
    }
}

