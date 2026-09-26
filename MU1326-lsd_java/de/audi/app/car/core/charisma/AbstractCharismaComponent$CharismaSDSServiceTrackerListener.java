/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma;

import de.audi.app.car.common.service.CarServiceTrackerListener;
import de.audi.app.car.core.charisma.AbstractCharismaComponent;
import de.audi.app.car.core.charisma.AbstractCharismaComponent$1;
import de.audi.atip.interapp.SDSService;

class AbstractCharismaComponent$CharismaSDSServiceTrackerListener
implements CarServiceTrackerListener {
    private volatile SDSService sdsService;
    private volatile boolean sdsDisabled = false;
    private final /* synthetic */ AbstractCharismaComponent this$0;

    private AbstractCharismaComponent$CharismaSDSServiceTrackerListener(AbstractCharismaComponent abstractCharismaComponent) {
        this.this$0 = abstractCharismaComponent;
    }

    @Override
    public void serviceAvailable(Object object) {
        this.this$0.getLogChannel().log(1078071040, "[CharismaSDSServiceTrackerListener#serviceAvailable] SDS service received");
        try {
            this.sdsService = (SDSService)object;
            this.setSDSDisabled(this.sdsDisabled);
        }
        catch (ClassCastException classCastException) {
            this.this$0.getLogChannel().log(1000, "[CharismaSDSServiceTrackerListener#serviceAvailable] sdsServiceTracker: cannot cast service");
        }
    }

    @Override
    public void serviceRemoved() {
        this.this$0.getLogChannel().log(-2137614336, "[CharismaSDSServiceTrackerListener#serviceRemoved] SDS Service has been removed");
        this.sdsService = null;
    }

    @Override
    public String[] getTrackedServiceClazzName() {
        return new String[]{(AbstractCharismaComponent.class$de$audi$atip$interapp$SDSService == null ? (AbstractCharismaComponent.class$de$audi$atip$interapp$SDSService = AbstractCharismaComponent.class$("de.audi.atip.interapp.SDSService")) : AbstractCharismaComponent.class$de$audi$atip$interapp$SDSService).getName()};
    }

    public synchronized void setSDSDisabled(boolean bl) {
        this.sdsDisabled = bl;
        if (this.sdsService != null) {
            this.this$0.getLogChannel().log(-2137614336, "[CharismaSDSServiceTrackerListener#setSDSDisabled] call sdsService.disablePTT(%1)", bl);
            try {
                this.sdsService.disablePTT(bl, false, (byte)8);
            }
            catch (Exception exception) {
                this.this$0.getLogChannel().log(1000, "[CharismaSDSServiceTrackerListener#setSDSDisabled] Caught exception while calling sdsService.disablePTT(): disabler=SDSService.PTT_DISABLER_DRIVE_SELECT", (Throwable)exception);
            }
        } else {
            this.this$0.getLogChannel().log(-1601830656, "[CharismaSDSServiceTrackerListener#setSDSDisabled] SDS service not available");
        }
    }

    /* synthetic */ AbstractCharismaComponent$CharismaSDSServiceTrackerListener(AbstractCharismaComponent abstractCharismaComponent, AbstractCharismaComponent$1 abstractCharismaComponent$1) {
        this(abstractCharismaComponent);
    }

    static /* synthetic */ boolean access$1200(AbstractCharismaComponent$CharismaSDSServiceTrackerListener abstractCharismaComponent$CharismaSDSServiceTrackerListener) {
        return abstractCharismaComponent$CharismaSDSServiceTrackerListener.sdsDisabled;
    }
}

