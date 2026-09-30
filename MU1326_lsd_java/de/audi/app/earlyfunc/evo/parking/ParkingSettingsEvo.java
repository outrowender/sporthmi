/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.evo.parking;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.earlyfunc.core.parking.settings.AbstractParkingSettings;
import org.dsi.ifc.carparkingsystem.ParkingSystemViewOptions;

public class ParkingSettingsEvo
extends AbstractParkingSettings {
    public ParkingSettingsEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1001, (short)2);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1002, (short)2);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1003, (short)2);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1004, (short)2);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1007, (short)2);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1008, (short)2);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1001);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1002);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1003);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1004);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1007);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1008);
    }

    public int getID() {
        return 7;
    }

    protected void updateMenuEntryVisibility(ParkingSystemViewOptions parkingSystemViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1001, this.getMenuEntryVisibilityState(parkingSystemViewOptions.getVpsDefaultView()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1002, this.getMenuEntryVisibilityState(parkingSystemViewOptions.getPdcSoundFront()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1003, this.getMenuEntryVisibilityState(parkingSystemViewOptions.getPdcSoundRear()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1004, this.getMenuEntryVisibilityState(parkingSystemViewOptions.getPdcSoundReproduction()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1007, this.getMenuEntryVisibilityState(parkingSystemViewOptions.getPdcAutoActivation()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1008, this.getMenuEntryVisibilityState(parkingSystemViewOptions.getVpsCameraCleaning()));
    }
}

