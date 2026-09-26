/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.service;

import de.audi.app.car.common.service.CarServiceTracker;
import de.audi.app.car.common.service.CarServiceTrackerListener;
import de.audi.app.car.evo.service.DrivingSchoolComponentEvo;
import de.audi.atip.interapp.ISDSServiceStatusListener;
import de.audi.atip.interapp.SDSService;

public class DrivingSchoolComponentEvo$DrivingSchoolSDSHandler
implements CarServiceTrackerListener,
ISDSServiceStatusListener {
    private final CarServiceTracker sdsServiceTracker;
    private final /* synthetic */ DrivingSchoolComponentEvo this$0;

    protected DrivingSchoolComponentEvo$DrivingSchoolSDSHandler(DrivingSchoolComponentEvo drivingSchoolComponentEvo) {
        this.this$0 = drivingSchoolComponentEvo;
        this.sdsServiceTracker = new CarServiceTracker(this, DrivingSchoolComponentEvo.access$000(drivingSchoolComponentEvo).getBundleContext(), drivingSchoolComponentEvo.getLogChannel());
    }

    protected void init() {
        this.sdsServiceTracker.startTracking();
    }

    protected void deinit() {
        this.sdsServiceTracker.stopTracking();
    }

    @Override
    public void notifySDSDialogStarted() {
        DrivingSchoolComponentEvo.access$100(this.this$0);
    }

    @Override
    public void notifySDSDialogEnded() {
        DrivingSchoolComponentEvo.access$200(this.this$0);
    }

    @Override
    public void notifySDSDialogAborting() {
    }

    @Override
    public void serviceAvailable(Object object) {
        this.this$0.getLogChannel().log(1078071040, "[DrivingSchoolSDSHandler#serviceAvailable] service received");
        try {
            ((SDSService)object).registerStatusListener(this);
        }
        catch (ClassCastException classCastException) {
            this.this$0.getLogChannel().log(1000, "[DrivingSchoolSDSHandler#serviceAvailable] sdsServiceTracker: cannot cast service");
        }
    }

    @Override
    public void serviceRemoved() {
        this.this$0.getLogChannel().log(1078071040, "[DrivingSchoolSDSHandler#serviceRemoved] SDS Service has been removed");
        DrivingSchoolComponentEvo.access$200(this.this$0);
    }

    @Override
    public String[] getTrackedServiceClazzName() {
        return new String[]{(DrivingSchoolComponentEvo.class$de$audi$atip$interapp$SDSService == null ? (DrivingSchoolComponentEvo.class$de$audi$atip$interapp$SDSService = DrivingSchoolComponentEvo.class$("de.audi.atip.interapp.SDSService")) : DrivingSchoolComponentEvo.class$de$audi$atip$interapp$SDSService).getName()};
    }
}

