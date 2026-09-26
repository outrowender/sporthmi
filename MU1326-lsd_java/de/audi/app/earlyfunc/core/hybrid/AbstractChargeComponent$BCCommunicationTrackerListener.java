/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import de.audi.app.car.common.service.CarServiceTrackerListener;
import de.audi.app.earlyfunc.core.hybrid.AbstractChargeComponent;
import de.audi.atip.interapp.IBattCtrlCommunicationService;

class AbstractChargeComponent$BCCommunicationTrackerListener
implements CarServiceTrackerListener {
    private AbstractChargeComponent component;
    private final /* synthetic */ AbstractChargeComponent this$0;

    public AbstractChargeComponent$BCCommunicationTrackerListener(AbstractChargeComponent abstractChargeComponent, AbstractChargeComponent abstractChargeComponent2) {
        this.this$0 = abstractChargeComponent;
        this.component = abstractChargeComponent2;
    }

    @Override
    public void serviceAvailable(Object object) {
        AbstractChargeComponent.access$002(this.this$0, (IBattCtrlCommunicationService)object);
    }

    @Override
    public void serviceRemoved() {
        AbstractChargeComponent.access$002(this.this$0, null);
    }

    @Override
    public String[] getTrackedServiceClazzName() {
        return new String[]{(AbstractChargeComponent.class$de$audi$atip$interapp$IBattCtrlCommunicationService == null ? (AbstractChargeComponent.class$de$audi$atip$interapp$IBattCtrlCommunicationService = AbstractChargeComponent.class$("de.audi.atip.interapp.IBattCtrlCommunicationService")) : AbstractChargeComponent.class$de$audi$atip$interapp$IBattCtrlCommunicationService).getName()};
    }
}

