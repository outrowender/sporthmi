/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.testsupport;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.AbstractCarComponent;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.atip.sysapp.carcoding.CarFuncAdap;
import de.audi.atip.testsupport.TestSupportDataReceiverEntry;
import de.audi.atip.testsupport.handler.ITestSupportHandler;
import de.audi.atip.testsupport.handler.ITestSupportHandlerNotification;
import de.audi.atip.testsupport.handler.TestSupportHandler;
import de.esolutions.fw.util.commons.Buffer;

public class TestSupportComponentEvo
extends AbstractCarComponent
implements ITestSupportHandlerNotification {
    private static final String LOGCHANNEL_NAME;
    private final ITestSupportHandler testSupportHandler;
    private static String[] carMenuTxt;
    private TestSupportDataReceiverEntry[] entries;

    public TestSupportComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.TestSupport");
        this.testSupportHandler = new TestSupportHandler("AppCar - Coding", true, true, this, iCarApplication.getBundleContext(), iCarApplication.getFrameworkAccess().getLogChannel("App.Car.TestSupport"));
    }

    @Override
    public void init() {
        super.init();
        this.entries = new TestSupportDataReceiverEntry[]{new TestSupportDataReceiverEntry(0, "Test Checkbox (unchecked)", true, false), new TestSupportDataReceiverEntry(1, "Test Checkbox (checked)", true, true), new TestSupportDataReceiverEntry(2, "Test Action", false, false)};
        this.testSupportHandler.init();
    }

    @Override
    public void deinit() {
        this.testSupportHandler.deinit();
        super.deinit();
    }

    @Override
    public void debugDataVisible(boolean bl) {
        this.getLogChannel().log(1078071040, "[TestSupportComponentEvo#debugDataVisible] visible='%1'", bl);
        if (bl) {
            this.testSupportHandler.updateData(this.getCarFuncAdapStatus());
        } else {
            this.testSupportHandler.updateData(new String[0]);
        }
    }

    @Override
    public void commandEntrySelected(int n) {
        this.getLogChannel().log(1078071040, "[TestSupportComponentEvo#entrySelected] entryID='%1'", (long)n);
        switch (n) {
            case 0: {
                this.entries[0].setChecked(!this.entries[0].isChecked());
                this.testSupportHandler.updateCommandList();
                break;
            }
            case 1: {
                this.entries[1].setChecked(!this.entries[1].isChecked());
                this.testSupportHandler.updateCommandList();
                break;
            }
        }
    }

    @Override
    public TestSupportDataReceiverEntry[] getCommandEntries() {
        return this.entries;
    }

    private String[] getCarFuncAdapStatus() {
        CarFuncAdap carFuncAdap = this.getApplication().getCarMenuCoding();
        String[] stringArray = new String[58];
        stringArray[0] = "Received Car-Coding:";
        stringArray[1] = "---";
        for (int i2 = 0; i2 < 56; ++i2) {
            Buffer buffer = new Buffer(40);
            if (i2 <= carMenuTxt.length - 1) {
                buffer.append(carMenuTxt[i2]).append(" (").append(i2).append("):");
            } else {
                buffer.append("unknown").append(" (").append(i2).append("):");
            }
            if (carFuncAdap.isMenuDisplayActivated((short)i2)) {
                if (!carFuncAdap.isMenuDisClamp15OffActivated((short)i2)) {
                    buffer.append(" (clamp15)");
                }
                if (!carFuncAdap.isMenuDisOverThresholdHighActivated((short)i2)) {
                    buffer.append(" (v<vThr)");
                }
                if (carFuncAdap.isMenuDisStandstillActivated((short)i2)) {
                    buffer.append(" (standstill)");
                }
            } else {
                buffer.append(" not coded");
            }
            stringArray[i2 + 2] = buffer.toString();
        }
        return stringArray;
    }

    @Override
    protected void initModels() {
    }

    @Override
    protected void deinitModels() {
    }

    @Override
    protected void initVisibility() {
    }

    @Override
    protected void deinitVisibility() {
    }

    @Override
    public String getName() {
        return "AppCar - TestSupport";
    }

    @Override
    public int getID() {
        return 21;
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[0];
    }

    @Override
    public String getCurrentViewOptions() {
        return "no DSIs/ViewOptions are used";
    }

    @Override
    public String getDSIListenerClassName() {
        return null;
    }

    @Override
    public String getDSIClassName() {
        return null;
    }

    @Override
    public boolean isUsingDSI() {
        return false;
    }

    static {
        carMenuTxt = new String[]{"ACC", "INT_LIGHT", "PARKING", "AWV", "LDW", "SWA", "EXT_LIGHT", "WINDOW", "AIRCONDITION", "AUXHEATER", "BC_CLUSTER", "RDK", "WIPER", "SIA", "SEAT", "CENTRAL_LOCKING", "COMPASS", "CHARISMA", "OILLEVEL", "VIN", "CLOCK", "AIRSUSPENSION", "HUD", "UNITMASTER", "HYBRID", "UGDO", "NIGHTVISION", "SIDEVIEW", "RGS", "MFL_JOKER", "TSD", "ATTENTION_IDENT", "APTIVE_KEY_CLAMP", "MIRROR", "DRV_SCHOOL", "MKE", "BCME", "BATTERY_STATE", "BRAKE", "START_STOP_REASONS", "ANGLE_OF_SLOPE", "BATTERY_MGMNT", "REAR_SEAT_ENTERTAINMENT", "SPECIAL_FUNCTIONS", "TRAILER_ASSIST", "TV_TUNER", "AUX_COOLING", "PEDESTRIAN_ASSIST", "SEAT_PNEUMATIC", "CURVE_ASSIST", "E_CALL", "ENI", "SPORT_HMI", "AD_BLUE", "THING_BLUE", "PEA"};
    }
}

