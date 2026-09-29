/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapRadioListener;
import de.audi.tghu.exlap.impl.container.RadioStationInfoContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractRadioService;

class ExlapAbstractRadioService$10
implements ListenerIterator {
    private final /* synthetic */ RadioStationInfoContainer val$radioTunerProperty;
    private final /* synthetic */ ExlapAbstractRadioService this$0;

    ExlapAbstractRadioService$10(ExlapAbstractRadioService exlapAbstractRadioService, RadioStationInfoContainer radioStationInfoContainer) {
        this.this$0 = exlapAbstractRadioService;
        this.val$radioTunerProperty = radioStationInfoContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapRadioListener)exlapListener).updateRadioTuner(this.val$radioTunerProperty);
    }
}

