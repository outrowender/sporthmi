/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.bcme;

import de.audi.app.car.common.adapter.AbstractDSICarDrivingCharacteristicsAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import org.dsi.ifc.cardrivingcharacteristics.TADConfiguration;
import org.dsi.ifc.cardrivingcharacteristics.TADVehicleInfo;
import org.dsi.ifc.cardrivingcharacteristics.TADViewOptions;

public abstract class AbstractTADComponent
extends AbstractDSICarDrivingCharacteristicsAdapter {
    private static final String LOGCHANNEL_NAME = "App.Car.Charisma.TAD";
    public static final short CODING_ID = 40;
    protected volatile TADViewOptions currentViewOptions;
    private static final float ANGLE_VALUE_MIN = -90.0f;
    private static final float ANGLE_VALUE_MAX = 90.0f;
    private static final String DISPLAY_STRING_INVALID_VALUE = "--";
    private static final char DEGREE_SYMBOL = '\u00b0';

    public AbstractTADComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void initModels() {
    }

    protected void deinitModels() {
    }

    public void updateTADViewOptions(TADViewOptions tADViewOptions, int n) {
        this.getLogChannel().log(1000000, "updateTADViewOptions: active='%1', valid='%2'", (Object)tADViewOptions, (long)n);
        if (n == 1) {
            this.currentViewOptions = tADViewOptions;
            this.updateMenuEntryVisibility(tADViewOptions);
            TADConfiguration tADConfiguration = tADViewOptions.getConfiguration();
            if (tADConfiguration != null) {
                this.getChoiceModel(601179).setValue(this.clipInvalidAngleToMax(tADConfiguration.getRollAngleStartHardWarning(), 0, 255));
                this.getChoiceModel(601184).setValue(this.clipInvalidAngleToMax(tADConfiguration.getRollAngleStartSoftWarning(), 0, 255));
                this.getChoiceModel(602045).setValue(this.clipInvalidAngleToMax(tADViewOptions.getConfiguration().getRollAngleMaxScale(), 0, 255));
                this.getChoiceModel(601186).setValue(this.clipInvalidAngleToMax(tADConfiguration.getRollAngleMaxScale(), 0, 90));
                this.getChoiceModel(601185).setValue(this.clipInvalidAngleToMax(tADConfiguration.getPitchAngleMaxScale(), 0, 90));
                this.getChoiceModel(601188).setValue(this.clipInvalidAngleToMax(tADConfiguration.getRollAngleStartHardWarning(), 0, this.getChoiceModel(601186).getValue()));
                this.getChoiceModel(601187).setValue(this.clipInvalidAngleToMax(tADConfiguration.getPitchAngleStartHardWarning(), 0, this.getChoiceModel(601185).getValue()));
                this.getChoiceModel(601190).setValue(this.clipInvalidAngleToMax(tADConfiguration.getRollAngleStartSoftWarning(), 0, this.getChoiceModel(601188).getValue()));
                this.getChoiceModel(601189).setValue(this.clipInvalidAngleToMax(tADConfiguration.getPitchAngleStartSoftWarning(), 0, this.getChoiceModel(601187).getValue()));
            }
            this.primaryAttributeFirstSetReceived();
        }
    }

    public void updateTADVehicleInfo(TADVehicleInfo tADVehicleInfo, int n) {
        this.getLogChannel().log(1000000, "updateTADVehicleInfo: TADVehicleInfo='%1', valid='%2'", (Object)tADVehicleInfo, (long)n);
        if (n == 1) {
            if (tADVehicleInfo.isRoofLoad()) {
                this.getLogChannel().log(1000000, "Display Model with Roof Load");
            } else {
                this.getLogChannel().log(1000000, "Display Model without Roof Load");
            }
            this.updateRoofLoad(tADVehicleInfo.isRoofLoad());
        }
    }

    public void updateTADCurrentRollAngle(float f2, int n) {
        this.getLogChannel().log(1000000, "updateTADCurrentRollAngle: angle='%1', valid='%2'", (Object)Float.toString(f2), (long)n);
        if (n == 1) {
            if (this.isInsideSupportedCurrentAngleRange(f2)) {
                this.getLogChannel().log(1000000, "Rollangel is now %1", (Object)Float.toString(f2));
                this.setCurrentAngleLabel(601214, f2);
                this.getChoiceModel(601178).setValue(new Float(f2 * 10.0f).intValue());
            } else {
                this.getLabelModel(601214).setText(DISPLAY_STRING_INVALID_VALUE);
                this.getChoiceModel(601178).setValue(0);
            }
        }
    }

    public void updateTADPosMaxRollAngle(float f2, int n) {
        this.getLogChannel().log(1000000, "updateTADPosMaxRollAngle: angle='%1', valid='%2'", (Object)Float.toString(f2), (long)n);
        if (n == 1) {
            this.setMaxAngleLabel(600592, f2);
            this.setMaxAngle(601181, f2);
        }
    }

    public void updateTADNegMaxRollAngle(float f2, int n) {
        this.getLogChannel().log(1000000, "updateTADPosNegRollAngle: angle='%1', valid='%2'", (Object)Float.toString(f2), (long)n);
        if (n == 1) {
            this.setMaxAngleLabel(600593, f2);
            this.setMaxAngle(601183, f2);
        }
    }

    public void updateTADCurrentPitchAngle(float f2, int n) {
        this.getLogChannel().log(1000000, "updateTADCurrentPitchAngle: angle='%1', valid='%2'", (Object)Float.toString(f2), (long)n);
        if (n == 1) {
            if (this.isInsideSupportedCurrentAngleRange(f2)) {
                this.getLogChannel().log(1000000, "Pitchangle is now %1", (Object)Float.toString(f2));
                this.setCurrentAngleLabel(601213, f2);
                this.getChoiceModel(601177).setValue(new Float(f2 * 10.0f).intValue());
            } else {
                this.getLabelModel(601213).setText(DISPLAY_STRING_INVALID_VALUE);
                this.getChoiceModel(601177).setValue(0);
            }
        }
    }

    public void updateTADPosMaxPitchAngle(float f2, int n) {
        this.getLogChannel().log(1000000, "updateTADPosMaxPitchAngle: angle='%1', valid='%2'", (Object)Float.toString(f2), (long)n);
        if (n == 1) {
            this.setMaxAngleLabel(600591, f2);
            this.setMaxAngle(601180, f2);
        }
    }

    public void updateTADNegMaxPitchAngle(float f2, int n) {
        this.getLogChannel().log(1000000, "updateTADNegMaxPitchAngle: angle='%1', valid='%2'", (Object)Float.toString(f2), (long)n);
        if (n == 1) {
            this.setMaxAngleLabel(600594, f2);
            this.setMaxAngle(601182, f2);
        }
    }

    private boolean isInsideSupportedAngleRange(float f2, float f3, float f4) {
        if (f2 > f4 || f2 < f3) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "[AbstractAirSuspensionIndicatorComponent#isInsideSupportedAngleRange] angle value is not inside range: minAngle='%1' , maxAngle='%2' , angle='%3'", (double)f3, (double)f4, (double)f2);
            }
            return false;
        }
        return true;
    }

    private boolean isInsideSupportedMaxAngleRange(float f2) {
        return this.isInsideSupportedAngleRange(f2, 0.0f, 90.0f);
    }

    private boolean isInsideSupportedCurrentAngleRange(float f2) {
        return this.isInsideSupportedAngleRange(f2, -90.0f, 90.0f);
    }

    private void setMaxAngle(int n, float f2) {
        int n2 = new Float(this.isInsideSupportedMaxAngleRange(f2) ? f2 : 90.0f).intValue();
        this.getLogChannel().log(1000000, "[AbstractTADComponent#setMaxAngle] set model value: choiceModelID='%1', maxAngle='%2'", (long)n, (long)n2);
        this.getChoiceModel(n).setValue(n2);
    }

    private void setMaxAngleLabel(int n, float f2) {
        String string = DISPLAY_STRING_INVALID_VALUE;
        if (this.isInsideSupportedMaxAngleRange(f2)) {
            StringBuffer stringBuffer = new StringBuffer(3);
            stringBuffer.append(new Float(f2).intValue());
            stringBuffer.append('\u00b0');
            string = stringBuffer.toString();
        }
        this.getLogChannel().log(1000000, "[AbstractTADComponent#setMaxAngleLabel] set label model: modelID='%1', text='%2'", (Object)new Integer(n), (Object)string);
        this.getLabelModel(n).setText(string);
    }

    private void setCurrentAngleLabel(int n, float f2) {
        StringBuffer stringBuffer = new StringBuffer(3);
        stringBuffer.append(Math.abs(new Float(f2).intValue()));
        stringBuffer.append('\u00b0');
        this.getLabelModel(n).setText(stringBuffer.toString());
    }

    private int clipInvalidAngleToMax(int n, int n2, int n3) {
        if (n < n2 || n > n3) {
            return n3;
        }
        return n;
    }

    protected abstract void updateMenuEntryVisibility(TADViewOptions var1);

    protected abstract void updateRoofLoad(boolean var1);

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{19}, new int[]{21, 22, 23, 24, 25, 26, 27})};
    }

    public String getCurrentViewOptions() {
        if (this.currentViewOptions == null) {
            return "no view options received yet";
        }
        return this.currentViewOptions.toString();
    }

    public String getName() {
        return "Car Tilt Angle Display";
    }
}

