/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.parking;

import de.audi.app.car.common.adapter.AbstractDSICarParkingSystemAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import org.dsi.ifc.carparkingsystem.ParkingSystemViewOptions;

public class ParkingSettingsCarEvo
extends AbstractDSICarParkingSystemAdapter {
    private static final String COMPONENT_NAME = "ParkingSettings";
    public static final short CODING_ID = 2;
    private volatile ParkingSystemViewOptions currViewOptions;

    public ParkingSettingsCarEvo(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.Parking.Settings");
    }

    public void updateParkingSystemViewOptions(ParkingSystemViewOptions parkingSystemViewOptions, int n) {
        this.getLogChannel().log(1000000, "[ParkingSettingsCarEvo#updateParkingSystemViewOptions] parkingSystemViewOptions=%1, valid=%2", (Object)parkingSystemViewOptions, (long)n);
        if (n == 1) {
            this.currViewOptions = parkingSystemViewOptions;
            this.updateMenuEntryVisibility(parkingSystemViewOptions);
        }
    }

    private void updateMenuEntryVisibility(ParkingSystemViewOptions parkingSystemViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600215, this.getMenuEntryVisibilityState(parkingSystemViewOptions.getVpsDefaultView()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600216, this.getMenuEntryVisibilityState(parkingSystemViewOptions.getPdcSoundFront()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600217, this.getMenuEntryVisibilityState(parkingSystemViewOptions.getPdcSoundRear()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600218, this.getMenuEntryVisibilityState(parkingSystemViewOptions.getPdcSoundReproduction()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600, this.getMenuEntryVisibilityState(parkingSystemViewOptions.getPdcAutoActivation()));
    }

    public String getName() {
        return COMPONENT_NAME;
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1}, new int[0])};
    }

    public String getCurrentViewOptions() {
        if (this.currViewOptions == null) {
            return "no view options received yet";
        }
        return this.currViewOptions.toString();
    }

    protected void initModels() {
    }

    protected void deinitModels() {
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600215, (short)2);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600216, (short)2);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600217, (short)2);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600218, (short)2);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600, (short)2);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600215);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600216);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600217);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600218);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600);
    }

    public int getID() {
        return 29;
    }
}

