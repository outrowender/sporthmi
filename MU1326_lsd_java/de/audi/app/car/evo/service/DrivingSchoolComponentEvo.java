/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.service;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.service.CarServiceTracker;
import de.audi.app.car.common.service.CarServiceTrackerListener;
import de.audi.app.car.core.service.AbstractDrivingSchoolComponent;
import de.audi.app.car.core.service.IDrivingSchoolDisplay;
import de.audi.atip.interapp.ISDSServiceStatusListener;
import de.audi.atip.interapp.SDSService;
import org.dsi.ifc.global.CarViewOption;

public class DrivingSchoolComponentEvo
extends AbstractDrivingSchoolComponent
implements IDrivingSchoolDisplay {
    private final DrivingSchoolSDSHandler sdsHandler = new DrivingSchoolSDSHandler();
    public static final short CODING_ID = 34;
    private volatile boolean sdsDialogeActive;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDSService;

    public DrivingSchoolComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    public void init() {
        super.init();
        this.sdsHandler.init();
    }

    public void deinit() {
        this.sdsHandler.deinit();
        super.deinit();
    }

    protected void initVisibility() {
        this.currViewOptionSystem = new CarViewOption(1, 1);
        this.currViewOptionBlinker = new CarViewOption(1, 1);
        this.currViewOptionSpeed = new CarViewOption(1, 1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600245, (short)34);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600245);
    }

    public int getID() {
        return 38;
    }

    public synchronized void activateDisplay() {
        this.getLogChannel().log(1000000, "[DrivingSchoolComponentEvo#activateDisplay]", this.drvSchoolMode, this.sdsDialogeActive);
        if (this.drvSchoolMode && !this.sdsDialogeActive) {
            this.getApplication().getFrameworkAccess().getHmiServiceApp().showPopup(600009);
        }
    }

    public synchronized void deactivateDisplay() {
        this.getLogChannel().log(1000000, "[DrivingSchoolComponentEvo#deactivateDisplay]", this.drvSchoolMode, this.sdsDialogeActive);
        if (this.drvSchoolMode) {
            this.getApplication().getFrameworkAccess().getHmiServiceApp().removePopup(600009);
        }
    }

    private synchronized void sdsActivated() {
        this.getLogChannel().log(1000000, "[DrivingSchoolComponentEvo#sdsActivated]", this.drvSchoolMode, this.sdsDialogeActive);
        if (this.drvSchoolMode) {
            this.getApplication().getFrameworkAccess().getHmiServiceApp().removePopup(600009);
        }
    }

    private synchronized void sdsDeactivated() {
        this.getLogChannel().log(1000000, "[DrivingSchoolComponentEvo#sdsDeactivated]", this.drvSchoolMode, this.sdsDialogeActive);
        if (this.drvSchoolMode) {
            this.timer.restart();
        }
    }

    protected void updateMenuEntryVisibilitySystem(CarViewOption carViewOption) {
        this.currViewOptionSystem = carViewOption;
        this.updateViewOptionState();
    }

    protected void updateMenuEntryVisibilityBlinker(CarViewOption carViewOption) {
        this.currViewOptionBlinker = carViewOption;
        this.updateViewOptionState();
    }

    protected void updateMenuEntryVisibilitySpeed(CarViewOption carViewOption) {
        this.currViewOptionSpeed = carViewOption;
        this.updateViewOptionState();
    }

    private void updateViewOptionState() {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600245, this.getMenuEntryVisibilityState(new CarViewOption[]{this.currViewOptionSystem, this.currViewOptionBlinker, this.currViewOptionSpeed}));
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    protected class DrivingSchoolSDSHandler
    implements CarServiceTrackerListener,
    ISDSServiceStatusListener {
        private final CarServiceTracker sdsServiceTracker;

        protected DrivingSchoolSDSHandler() {
            this.sdsServiceTracker = new CarServiceTracker(this, DrivingSchoolComponentEvo.this.getApplication().getBundleContext(), DrivingSchoolComponentEvo.this.getLogChannel());
        }

        protected void init() {
            this.sdsServiceTracker.startTracking();
        }

        protected void deinit() {
            this.sdsServiceTracker.stopTracking();
        }

        public void notifySDSDialogStarted() {
            DrivingSchoolComponentEvo.this.sdsActivated();
        }

        public void notifySDSDialogEnded() {
            DrivingSchoolComponentEvo.this.sdsDeactivated();
        }

        public void notifySDSDialogAborting() {
        }

        public void serviceAvailable(Object object) {
            DrivingSchoolComponentEvo.this.getLogChannel().log(1000000, "[DrivingSchoolSDSHandler#serviceAvailable] service received");
            try {
                ((SDSService)object).registerStatusListener(this);
            }
            catch (ClassCastException classCastException) {
                DrivingSchoolComponentEvo.this.getLogChannel().log(1000, "[DrivingSchoolSDSHandler#serviceAvailable] sdsServiceTracker: cannot cast service");
            }
        }

        public void serviceRemoved() {
            DrivingSchoolComponentEvo.this.getLogChannel().log(1000000, "[DrivingSchoolSDSHandler#serviceRemoved] SDS Service has been removed");
            DrivingSchoolComponentEvo.this.sdsDeactivated();
        }

        public String[] getTrackedServiceClazzName() {
            return new String[]{(class$de$audi$atip$interapp$SDSService == null ? (class$de$audi$atip$interapp$SDSService = DrivingSchoolComponentEvo.class$("de.audi.atip.interapp.SDSService")) : class$de$audi$atip$interapp$SDSService).getName()};
        }
    }
}

