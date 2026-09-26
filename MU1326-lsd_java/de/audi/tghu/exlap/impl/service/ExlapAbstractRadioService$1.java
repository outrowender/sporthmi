/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapRadioListener;
import de.audi.tghu.exlap.impl.container.RadioBandsContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractRadioService;

class ExlapAbstractRadioService$1
implements ListenerIterator {
    private final /* synthetic */ RadioBandsContainer val$availableRadioBandsProperty;
    private final /* synthetic */ ExlapAbstractRadioService this$0;

    ExlapAbstractRadioService$1(ExlapAbstractRadioService exlapAbstractRadioService, RadioBandsContainer radioBandsContainer) {
        this.this$0 = exlapAbstractRadioService;
        this.val$availableRadioBandsProperty = radioBandsContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapRadioListener)exlapListener).updateAvailableRadioBands(this.val$availableRadioBandsProperty);
    }
}

