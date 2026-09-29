/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.service;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.service.AbstractDrivingSchoolComponent;
import de.audi.app.car.core.service.IDrivingSchoolDisplay;
import de.audi.app.car.evo.service.DrivingSchoolComponentEvo$DrivingSchoolSDSHandler;
import org.dsi.ifc.global.CarViewOption;

public class DrivingSchoolComponentEvo
extends AbstractDrivingSchoolComponent
implements IDrivingSchoolDisplay {
    private final DrivingSchoolComponentEvo$DrivingSchoolSDSHandler sdsHandler = new DrivingSchoolComponentEvo$DrivingSchoolSDSHandler(this);
    public static final short CODING_ID;
    private volatile boolean sdsDialogeActive;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDSService;

    public DrivingSchoolComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    @Override
    public void init() {
        super.init();
        this.sdsHandler.init();
    }

    @Override
    public void deinit() {
        this.sdsHandler.deinit();
        super.deinit();
    }

    @Override
    protected void initVisibility() {
        this.currViewOptionSystem = new CarViewOption(1, 1);
        this.currViewOptionBlinker = new CarViewOption(1, 1);
        this.currViewOptionSpeed = new CarViewOption(1, 1);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1255667456, (short)34);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1255667456);
    }

    @Override
    public int getID() {
        return 38;
    }

    @Override
    public synchronized void activateDisplay() {
        this.getLogChannel().log(1078071040, "[DrivingSchoolComponentEvo#activateDisplay]", this.drvSchoolMode, this.sdsDialogeActive);
        if (this.drvSchoolMode && !this.sdsDialogeActive) {
            this.getApplication().getFrameworkAccess().getHmiServiceApp().showPopup(-920188672);
        }
    }

    @Override
    public synchronized void deactivateDisplay() {
        this.getLogChannel().log(1078071040, "[DrivingSchoolComponentEvo#deactivateDisplay]", this.drvSchoolMode, this.sdsDialogeActive);
        if (this.drvSchoolMode) {
            this.getApplication().getFrameworkAccess().getHmiServiceApp().removePopup(-920188672);
        }
    }

    private synchronized void sdsActivated() {
        this.getLogChannel().log(1078071040, "[DrivingSchoolComponentEvo#sdsActivated]", this.drvSchoolMode, this.sdsDialogeActive);
        if (this.drvSchoolMode) {
            this.getApplication().getFrameworkAccess().getHmiServiceApp().removePopup(-920188672);
        }
    }

    private synchronized void sdsDeactivated() {
        this.getLogChannel().log(1078071040, "[DrivingSchoolComponentEvo#sdsDeactivated]", this.drvSchoolMode, this.sdsDialogeActive);
        if (this.drvSchoolMode) {
            this.timer.restart();
        }
    }

    @Override
    protected void updateMenuEntryVisibilitySystem(CarViewOption carViewOption) {
        this.currViewOptionSystem = carViewOption;
        this.updateViewOptionState();
    }

    @Override
    protected void updateMenuEntryVisibilityBlinker(CarViewOption carViewOption) {
        this.currViewOptionBlinker = carViewOption;
        this.updateViewOptionState();
    }

    @Override
    protected void updateMenuEntryVisibilitySpeed(CarViewOption carViewOption) {
        this.currViewOptionSpeed = carViewOption;
        this.updateViewOptionState();
    }

    private void updateViewOptionState() {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1255667456, this.getMenuEntryVisibilityState(new CarViewOption[]{this.currViewOptionSystem, this.currViewOptionBlinker, this.currViewOptionSpeed}));
    }

    static /* synthetic */ ICarApplication access$000(DrivingSchoolComponentEvo drivingSchoolComponentEvo) {
        return drivingSchoolComponentEvo.getApplication();
    }

    static /* synthetic */ void access$100(DrivingSchoolComponentEvo drivingSchoolComponentEvo) {
        drivingSchoolComponentEvo.sdsActivated();
    }

    static /* synthetic */ void access$200(DrivingSchoolComponentEvo drivingSchoolComponentEvo) {
        drivingSchoolComponentEvo.sdsDeactivated();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

