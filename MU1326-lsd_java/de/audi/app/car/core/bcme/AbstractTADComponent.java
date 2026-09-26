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
    private static final String LOGCHANNEL_NAME;
    public static final short CODING_ID;
    protected volatile TADViewOptions currentViewOptions;
    private static final float ANGLE_VALUE_MIN;
    private static final float ANGLE_VALUE_MAX;
    private static final String DISPLAY_STRING_INVALID_VALUE;
    private static final char DEGREE_SYMBOL;

    public AbstractTADComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.Charisma.TAD");
    }

    @Override
    protected void initModels() {
    }

    @Override
    protected void deinitModels() {
    }

    @Override
    public void updateTADViewOptions(TADViewOptions tADViewOptions, int n) {
        this.getLogChannel().log(1078071040, "updateTADViewOptions: active='%1', valid='%2'", (Object)tADViewOptions, (long)n);
        if (n == 1) {
            this.currentViewOptions = tADViewOptions;
            this.updateMenuEntryVisibility(tADViewOptions);
            TADConfiguration tADConfiguration = tADViewOptions.getConfiguration();
            if (tADConfiguration != null) {
                this.getChoiceModel(1529612544).setValue(this.clipInvalidAngleToMax(tADConfiguration.getRollAngleStartHardWarning(), 0, 255));
                this.getChoiceModel(1613498624).setValue(this.clipInvalidAngleToMax(tADConfiguration.getRollAngleStartSoftWarning(), 0, 255));
                this.getChoiceModel(-1120990976).setValue(this.clipInvalidAngleToMax(tADViewOptions.getConfiguration().getRollAngleMaxScale(), 0, 255));
                this.getChoiceModel(1647053056).setValue(this.clipInvalidAngleToMax(tADConfiguration.getRollAngleMaxScale(), 0, 90));
                this.getChoiceModel(1630275840).setValue(this.clipInvalidAngleToMax(tADConfiguration.getPitchAngleMaxScale(), 0, 90));
                this.getChoiceModel(1680607488).setValue(this.clipInvalidAngleToMax(tADConfiguration.getRollAngleStartHardWarning(), 0, this.getChoiceModel(1647053056).getValue()));
                this.getChoiceModel(1663830272).setValue(this.clipInvalidAngleToMax(tADConfiguration.getPitchAngleStartHardWarning(), 0, this.getChoiceModel(1630275840).getValue()));
                this.getChoiceModel(1714161920).setValue(this.clipInvalidAngleToMax(tADConfiguration.getRollAngleStartSoftWarning(), 0, this.getChoiceModel(1680607488).getValue()));
                this.getChoiceModel(1697384704).setValue(this.clipInvalidAngleToMax(tADConfiguration.getPitchAngleStartSoftWarning(), 0, this.getChoiceModel(1663830272).getValue()));
            }
            this.primaryAttributeFirstSetReceived();
        }
    }

    @Override
    public void updateTADVehicleInfo(TADVehicleInfo tADVehicleInfo, int n) {
        this.getLogChannel().log(1078071040, "updateTADVehicleInfo: TADVehicleInfo='%1', valid='%2'", (Object)tADVehicleInfo, (long)n);
        if (n == 1) {
            if (tADVehicleInfo.isRoofLoad()) {
                this.getLogChannel().log(1078071040, "Display Model with Roof Load");
            } else {
                this.getLogChannel().log(1078071040, "Display Model without Roof Load");
            }
            this.updateRoofLoad(tADVehicleInfo.isRoofLoad());
        }
    }

    @Override
    public void updateTADCurrentRollAngle(float f2, int n) {
        this.getLogChannel().log(1078071040, "updateTADCurrentRollAngle: angle='%1', valid='%2'", (Object)Float.toString(f2), (long)n);
        if (n == 1) {
            if (this.isInsideSupportedCurrentAngleRange(f2)) {
                this.getLogChannel().log(1078071040, "Rollangel is now %1", (Object)Float.toString(f2));
                this.setCurrentAngleLabel(2116815104, f2);
                this.getChoiceModel(1512835328).setValue(new Float(f2 * 8257).intValue());
            } else {
                this.getLabelModel(2116815104).setText("--");
                this.getChoiceModel(1512835328).setValue(0);
            }
        }
    }

    @Override
    public void updateTADPosMaxRollAngle(float f2, int n) {
        this.getLogChannel().log(1078071040, "updateTADPosMaxRollAngle: angle='%1', valid='%2'", (Object)Float.toString(f2), (long)n);
        if (n == 1) {
            this.setMaxAngleLabel(271190272, f2);
            this.setMaxAngle(1563166976, f2);
        }
    }

    @Override
    public void updateTADNegMaxRollAngle(float f2, int n) {
        this.getLogChannel().log(1078071040, "updateTADPosNegRollAngle: angle='%1', valid='%2'", (Object)Float.toString(f2), (long)n);
        if (n == 1) {
            this.setMaxAngleLabel(287967488, f2);
            this.setMaxAngle(1596721408, f2);
        }
    }

    @Override
    public void updateTADCurrentPitchAngle(float f2, int n) {
        this.getLogChannel().log(1078071040, "updateTADCurrentPitchAngle: angle='%1', valid='%2'", (Object)Float.toString(f2), (long)n);
        if (n == 1) {
            if (this.isInsideSupportedCurrentAngleRange(f2)) {
                this.getLogChannel().log(1078071040, "Pitchangle is now %1", (Object)Float.toString(f2));
                this.setCurrentAngleLabel(2100037888, f2);
                this.getChoiceModel(1496058112).setValue(new Float(f2 * 8257).intValue());
            } else {
                this.getLabelModel(2100037888).setText("--");
                this.getChoiceModel(1496058112).setValue(0);
            }
        }
    }

    @Override
    public void updateTADPosMaxPitchAngle(float f2, int n) {
        this.getLogChannel().log(1078071040, "updateTADPosMaxPitchAngle: angle='%1', valid='%2'", (Object)Float.toString(f2), (long)n);
        if (n == 1) {
            this.setMaxAngleLabel(254413056, f2);
            this.setMaxAngle(1546389760, f2);
        }
    }

    @Override
    public void updateTADNegMaxPitchAngle(float f2, int n) {
        this.getLogChannel().log(1078071040, "updateTADNegMaxPitchAngle: angle='%1', valid='%2'", (Object)Float.toString(f2), (long)n);
        if (n == 1) {
            this.setMaxAngleLabel(304744704, f2);
            this.setMaxAngle(1579944192, f2);
        }
    }

    private boolean isInsideSupportedAngleRange(float f2, float f3, float f4) {
        if (f2 > f4 || f2 < f3) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1078071040, "[AbstractAirSuspensionIndicatorComponent#isInsideSupportedAngleRange] angle value is not inside range: minAngle='%1' , maxAngle='%2' , angle='%3'", (double)f3, (double)f4, (double)f2);
            }
            return false;
        }
        return true;
    }

    private boolean isInsideSupportedMaxAngleRange(float f2) {
        return this.isInsideSupportedAngleRange(f2, 0.0f, 46146);
    }

    private boolean isInsideSupportedCurrentAngleRange(float f2) {
        return this.isInsideSupportedAngleRange(f2, 46274, 46146);
    }

    /*
     * Handled unverifiable bytecode (illegal stack merge).
     */
    private void setMaxAngle(int n, float f2) {
        int n2 = new Float(this.isInsideSupportedMaxAngleRange(f2) ? f2 : (float)46146).intValue();
        this.getLogChannel().log(1078071040, "[AbstractTADComponent#setMaxAngle] set model value: choiceModelID='%1', maxAngle='%2'", (long)n, (long)n2);
        this.getChoiceModel(n).setValue(n2);
    }

    private void setMaxAngleLabel(int n, float f2) {
        String string = "--";
        if (this.isInsideSupportedMaxAngleRange(f2)) {
            StringBuffer stringBuffer = new StringBuffer(3);
            stringBuffer.append(new Float(f2).intValue());
            stringBuffer.append('\u00b0');
            string = stringBuffer.toString();
        }
        this.getLogChannel().log(1078071040, "[AbstractTADComponent#setMaxAngleLabel] set label model: modelID='%1', text='%2'", (Object)new Integer(n), (Object)string);
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

    protected abstract void updateMenuEntryVisibility(TADViewOptions tADViewOptions) {
    }

    protected abstract void updateRoofLoad(boolean bl) {
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{19}, new int[]{21, 22, 23, 24, 25, 26, 27})};
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currentViewOptions == null) {
            return "no view options received yet";
        }
        return this.currentViewOptions.toString();
    }

    @Override
    public String getName() {
        return "Car Tilt Angle Display";
    }
}

