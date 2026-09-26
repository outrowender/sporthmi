/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapSystemListener;
import de.audi.tghu.exlap.impl.container.EncodedVehicleTypeContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractSystemService;

class ExlapAbstractSystemService$4
implements ListenerIterator {
    private final /* synthetic */ EncodedVehicleTypeContainer val$encodedVehicleTypeProperty;
    private final /* synthetic */ ExlapAbstractSystemService this$0;

    ExlapAbstractSystemService$4(ExlapAbstractSystemService exlapAbstractSystemService, EncodedVehicleTypeContainer encodedVehicleTypeContainer) {
        this.this$0 = exlapAbstractSystemService;
        this.val$encodedVehicleTypeProperty = encodedVehicleTypeContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapSystemListener)exlapListener).updateEncodedVehicleType(this.val$encodedVehicleTypeProperty);
    }
}

