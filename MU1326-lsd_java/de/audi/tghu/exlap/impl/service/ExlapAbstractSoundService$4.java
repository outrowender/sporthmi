/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapSoundListener;
import de.audi.tghu.exlap.impl.container.BalanceFaderRangesContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractSoundService;

class ExlapAbstractSoundService$4
implements ListenerIterator {
    private final /* synthetic */ BalanceFaderRangesContainer val$balanceFaderRangesProperty;
    private final /* synthetic */ ExlapAbstractSoundService this$0;

    ExlapAbstractSoundService$4(ExlapAbstractSoundService exlapAbstractSoundService, BalanceFaderRangesContainer balanceFaderRangesContainer) {
        this.this$0 = exlapAbstractSoundService;
        this.val$balanceFaderRangesProperty = balanceFaderRangesContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapSoundListener)exlapListener).updateBalanceFaderRanges(this.val$balanceFaderRangesProperty);
    }
}

