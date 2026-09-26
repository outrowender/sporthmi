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
    private static final String COMPONENT_NAME;
    public static final short CODING_ID;
    private volatile ParkingSystemViewOptions currViewOptions;

    public ParkingSettingsCarEvo(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.Parking.Settings");
    }

    @Override
    public void updateParkingSystemViewOptions(ParkingSystemViewOptions parkingSystemViewOptions, int n) {
        this.getLogChannel().log(1078071040, "[ParkingSettingsCarEvo#updateParkingSystemViewOptions] parkingSystemViewOptions=%1, valid=%2", (Object)parkingSystemViewOptions, (long)n);
        if (n == 1) {
            this.currViewOptions = parkingSystemViewOptions;
            this.updateMenuEntryVisibility(parkingSystemViewOptions);
        }
    }

    private void updateMenuEntryVisibility(ParkingSystemViewOptions parkingSystemViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1758983936, this.getMenuEntryVisibilityState(parkingSystemViewOptions.getVpsDefaultView()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1742206720, this.getMenuEntryVisibilityState(parkingSystemViewOptions.getPdcSoundFront()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1725429504, this.getMenuEntryVisibilityState(parkingSystemViewOptions.getPdcSoundRear()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1708652288, this.getMenuEntryVisibilityState(parkingSystemViewOptions.getPdcSoundReproduction()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600, this.getMenuEntryVisibilityState(parkingSystemViewOptions.getPdcAutoActivation()));
    }

    @Override
    public String getName() {
        return "ParkingSettings";
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1}, new int[0])};
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currViewOptions == null) {
            return "no view options received yet";
        }
        return this.currViewOptions.toString();
    }

    @Override
    protected void initModels() {
    }

    @Override
    protected void deinitModels() {
    }

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1758983936, (short)2);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1742206720, (short)2);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1725429504, (short)2);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1708652288, (short)2);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600, (short)2);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1758983936);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1742206720);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1725429504);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1708652288);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600);
    }

    @Override
    public int getID() {
        return 29;
    }
}

