/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapSoundListener;
import de.audi.tghu.exlap.impl.container.EntertainmentContextContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractSoundService;

class ExlapAbstractSoundService$5
implements ListenerIterator {
    private final /* synthetic */ EntertainmentContextContainer val$entertainmentContextProperty;
    private final /* synthetic */ ExlapAbstractSoundService this$0;

    ExlapAbstractSoundService$5(ExlapAbstractSoundService exlapAbstractSoundService, EntertainmentContextContainer entertainmentContextContainer) {
        this.this$0 = exlapAbstractSoundService;
        this.val$entertainmentContextProperty = entertainmentContextContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapSoundListener)exlapListener).updateEntertainmentContext(this.val$entertainmentContextProperty);
    }
}

