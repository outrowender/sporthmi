/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.auxheater;

import de.audi.app.car.common.service.CarServiceTrackerListener;
import de.audi.app.car.evo.auxheater.AuxheaterComponentEvo;
import de.audi.atip.interapp.JokerKeyService;

class AuxheaterComponentEvo$1
implements CarServiceTrackerListener {
    private final /* synthetic */ AuxheaterComponentEvo this$0;

    AuxheaterComponentEvo$1(AuxheaterComponentEvo auxheaterComponentEvo) {
        this.this$0 = auxheaterComponentEvo;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void serviceRemoved() {
        Object object = AuxheaterComponentEvo.access$000(this.this$0);
        synchronized (object) {
            AuxheaterComponentEvo.access$102(this.this$0, null);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void serviceAvailable(Object object) {
        Object object2 = AuxheaterComponentEvo.access$000(this.this$0);
        synchronized (object2) {
            AuxheaterComponentEvo.access$102(this.this$0, (JokerKeyService)object);
        }
        AuxheaterComponentEvo.access$300(this.this$0, AuxheaterComponentEvo.access$200(this.this$0));
    }

    @Override
    public String[] getTrackedServiceClazzName() {
        return new String[]{(AuxheaterComponentEvo.class$de$audi$atip$interapp$JokerKeyService == null ? (AuxheaterComponentEvo.class$de$audi$atip$interapp$JokerKeyService = AuxheaterComponentEvo.class$("de.audi.atip.interapp.JokerKeyService")) : AuxheaterComponentEvo.class$de$audi$atip$interapp$JokerKeyService).getName()};
    }
}

