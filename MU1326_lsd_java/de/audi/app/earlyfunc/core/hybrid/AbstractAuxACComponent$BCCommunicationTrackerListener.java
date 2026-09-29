/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import de.audi.app.car.common.service.CarServiceTrackerListener;
import de.audi.app.earlyfunc.core.hybrid.AbstractAuxACComponent;
import de.audi.atip.interapp.IBattCtrlCommunicationService;

class AbstractAuxACComponent$BCCommunicationTrackerListener
implements CarServiceTrackerListener {
    private AbstractAuxACComponent component;
    private final /* synthetic */ AbstractAuxACComponent this$0;

    public AbstractAuxACComponent$BCCommunicationTrackerListener(AbstractAuxACComponent abstractAuxACComponent, AbstractAuxACComponent abstractAuxACComponent2) {
        this.this$0 = abstractAuxACComponent;
        this.component = abstractAuxACComponent2;
    }

    @Override
    public void serviceAvailable(Object object) {
        AbstractAuxACComponent.access$1402(this.this$0, (IBattCtrlCommunicationService)object);
    }

    @Override
    public void serviceRemoved() {
        AbstractAuxACComponent.access$1402(this.this$0, null);
    }

    @Override
    public String[] getTrackedServiceClazzName() {
        return new String[]{(AbstractAuxACComponent.class$de$audi$atip$interapp$IBattCtrlCommunicationService == null ? (AbstractAuxACComponent.class$de$audi$atip$interapp$IBattCtrlCommunicationService = AbstractAuxACComponent.class$("de.audi.atip.interapp.IBattCtrlCommunicationService")) : AbstractAuxACComponent.class$de$audi$atip$interapp$IBattCtrlCommunicationService).getName()};
    }
}

