/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.core.comfort.AbstractDSICarComfortAdapter;
import de.audi.atip.hmi.model.ChoiceListener;
import org.dsi.ifc.carcomfort.RGSBeltPretensionData;
import org.dsi.ifc.carcomfort.RGSConfiguration;
import org.dsi.ifc.carcomfort.RGSViewOptions;

public abstract class AbstractPreSenseRgsComponent
extends AbstractDSICarComfortAdapter
implements ChoiceListener {
    public static final short CODING_ID = 28;
    public static final String LOGCHANNEL_NAME = "App.Car.PreSense.RGS";
    private volatile RGSViewOptions currViewOptions;
    private static final int[] RGS_WARNING_DSI_MAPPING = new int[]{0, 1, 2, 3};
    private volatile boolean leftHandDriveCar = true;
    private volatile boolean rgsBeltPretensionDriverOn = false;
    private volatile boolean rgsBeltPretensionCoDriverOn = false;

    public AbstractPreSenseRgsComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void initModels() {
        this.getButtonModel(600618).setButtonListener(this);
        this.getButtonModel(600617).setButtonListener(this);
        this.getChoiceModel(600614).setChoiceListener(this);
        this.getChoiceModel(600612).setChoiceListener(this);
        this.getChoiceModel(600380).setChoiceListener(this);
        this.getChoiceModel(600371).setChoiceListener(this);
    }

    protected void deinitModels() {
        this.getButtonModel(600618).resetListener();
        this.getButtonModel(600617).resetListener();
        this.getChoiceModel(600614).resetListener();
        this.getChoiceModel(600612).resetListener();
        this.getChoiceModel(600380).resetListener();
        this.getChoiceModel(600371).resetListener();
    }

    public void setRGSSystem(boolean bl) {
        this.getLogChannel().log(1000000, "dsi.setRGSPreSenseSystem(%1)", bl);
        this.getDSI().setRGSPreSenseSystem(bl);
    }

    public void setRGSWarning(int n) {
        this.getLogChannel().log(1000000, "dsi.setRGSPreSenseWarning(%1)", (long)n);
        this.getDSI().setRGSPreSenseWarning(n);
    }

    private void setRGSBeltPretensionerFront(boolean bl, boolean bl2) {
        RGSBeltPretensionData rGSBeltPretensionData = this.leftHandDriveCar ? new RGSBeltPretensionData(bl, bl2) : new RGSBeltPretensionData(bl2, bl);
        this.getLogChannel().log(1000000, "dsi.setRGSBeltPretensionerDataFront(%1)", (Object)rGSBeltPretensionData);
        this.getDSI().setRGSBeltPretensionerDataFront(rGSBeltPretensionData);
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logModelData("itemSelected:", n, n2, true);
        switch (n) {
            case 600614: {
                this.itemSelectedPreWarning(n2);
                break;
            }
            case 600612: {
                this.setRGSSystem(n2 == 1);
                break;
            }
            case 600380: {
                this.setRGSBeltPretensionerFront(n2 == 1, this.rgsBeltPretensionCoDriverOn);
                break;
            }
            case 600371: {
                this.setRGSBeltPretensionerFront(this.rgsBeltPretensionDriverOn, n2 == 1);
                break;
            }
            default: {
                this.logModelData("itemSelected:", n, n2, false);
            }
        }
    }

    protected void itemSelectedPreWarning(int n) {
        int n2 = 0;
        if (n < RGS_WARNING_DSI_MAPPING.length) {
            n2 = RGS_WARNING_DSI_MAPPING[n];
        } else {
            this.getLogChannel().log(1000, "[AbstractPreSenseRgsComponent#itemSelectedPreWarning] hmi value %1 not supported", (long)n);
        }
        this.setRGSWarning(n2);
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void keyPressed(int n, int n2, int n3) {
        this.getLogChannel().log(1000000, "keyPressed: %1", (long)n);
        switch (n) {
            case 600618: {
                this.setRGSSystem(true);
                break;
            }
            case 600617: {
                this.setRGSSystem(false);
                break;
            }
            default: {
                this.logModelData("keyPressed:", n, n2, false);
            }
        }
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1}, new int[]{53, 54, 2})};
    }

    public String getCurrentViewOptions() {
        if (this.currViewOptions == null) {
            return "no view options received yet";
        }
        return this.currViewOptions.toString();
    }

    public void updateRGSViewOptions(RGSViewOptions rGSViewOptions, int n) {
        this.getLogChannel().log(1000000, "updateRGSViewOptions(%1), valid:%2", (Object)rGSViewOptions, (long)n);
        if (n == 1 && rGSViewOptions != null) {
            this.currViewOptions = rGSViewOptions;
            RGSConfiguration rGSConfiguration = rGSViewOptions.getConfiguration();
            if (rGSConfiguration != null) {
                this.leftHandDriveCar = rGSConfiguration.getDriverSide() == 0;
            }
            this.updateMenuEntryVisibility(this.currViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    public void updateRGSPreSenseSystem(boolean bl, int n) {
        this.getLogChannel().log(1000000, "updateRGSPreSenseSystem(%1), valid:%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(600612).setValue(bl ? 1 : 0);
            if (!bl) {
                this.getButtonModel(600617).fireEvent(0);
            }
        }
    }

    public void updateRGSPreSenseWarning(int n, int n2) {
        this.getLogChannel().log(1000000, "updateRGSPreSenseWarning(%1), valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            int n3 = 0;
            boolean bl = false;
            for (int i2 = 0; i2 < RGS_WARNING_DSI_MAPPING.length; ++i2) {
                if (n != RGS_WARNING_DSI_MAPPING[i2]) continue;
                n3 = i2;
                bl = true;
                break;
            }
            if (!bl) {
                this.getLogChannel().log(1000, "[AbstractPreSenseComponent#updateRGSPreSenseWarning] dsi state '%1' received via updateRGSPreSenseWarning() not supported", (long)n);
            }
            this.getChoiceModel(600614).setValue(n3);
        }
    }

    public void updateRGSBeltPretensionDataFront(RGSBeltPretensionData rGSBeltPretensionData, int n) {
        this.getLogChannel().log(1000000, "updateRGSBeltPretensionDataFront(%1), valid:%2", (Object)rGSBeltPretensionData, (long)n);
        if (n == 1) {
            if (this.leftHandDriveCar) {
                this.rgsBeltPretensionDriverOn = rGSBeltPretensionData.isLeft();
                this.rgsBeltPretensionCoDriverOn = rGSBeltPretensionData.isRight();
            } else {
                this.rgsBeltPretensionDriverOn = rGSBeltPretensionData.isRight();
                this.rgsBeltPretensionCoDriverOn = rGSBeltPretensionData.isLeft();
            }
            this.getChoiceModel(600380).setValue(this.rgsBeltPretensionDriverOn ? 1 : 0);
            this.getChoiceModel(600371).setValue(this.rgsBeltPretensionCoDriverOn ? 1 : 0);
        }
    }

    public boolean isLeftHandDriveCar() {
        return this.leftHandDriveCar;
    }

    protected abstract void updateMenuEntryVisibility(RGSViewOptions var1);

    public String getName() {
        return "Audi PreSense (RGS)";
    }
}

