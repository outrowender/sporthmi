/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapSoundListener;
import de.audi.tghu.exlap.impl.container.BalanceFaderContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractSoundService;

class ExlapAbstractSoundService$3
implements ListenerIterator {
    private final /* synthetic */ BalanceFaderContainer val$balanceFaderProperty;
    private final /* synthetic */ ExlapAbstractSoundService this$0;

    ExlapAbstractSoundService$3(ExlapAbstractSoundService exlapAbstractSoundService, BalanceFaderContainer balanceFaderContainer) {
        this.this$0 = exlapAbstractSoundService;
        this.val$balanceFaderProperty = balanceFaderContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapSoundListener)exlapListener).updateBalanceFader(this.val$balanceFaderProperty);
    }
}

