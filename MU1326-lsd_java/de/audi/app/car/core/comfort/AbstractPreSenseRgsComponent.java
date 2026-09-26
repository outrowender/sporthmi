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
    public static final short CODING_ID;
    public static final String LOGCHANNEL_NAME;
    private volatile RGSViewOptions currViewOptions;
    private static final int[] RGS_WARNING_DSI_MAPPING;
    private volatile boolean leftHandDriveCar = true;
    private volatile boolean rgsBeltPretensionDriverOn = false;
    private volatile boolean rgsBeltPretensionCoDriverOn = false;

    public AbstractPreSenseRgsComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.PreSense.RGS");
    }

    @Override
    protected void initModels() {
        this.getButtonModel(707397888).setButtonListener(this);
        this.getButtonModel(690620672).setButtonListener(this);
        this.getChoiceModel(640289024).setChoiceListener(this);
        this.getChoiceModel(606734592).setChoiceListener(this);
        this.getChoiceModel(1009322240).setChoiceListener(this);
        this.getChoiceModel(858327296).setChoiceListener(this);
    }

    @Override
    protected void deinitModels() {
        this.getButtonModel(707397888).resetListener();
        this.getButtonModel(690620672).resetListener();
        this.getChoiceModel(640289024).resetListener();
        this.getChoiceModel(606734592).resetListener();
        this.getChoiceModel(1009322240).resetListener();
        this.getChoiceModel(858327296).resetListener();
    }

    public void setRGSSystem(boolean bl) {
        this.getLogChannel().log(1078071040, "dsi.setRGSPreSenseSystem(%1)", bl);
        this.getDSI().setRGSPreSenseSystem(bl);
    }

    public void setRGSWarning(int n) {
        this.getLogChannel().log(1078071040, "dsi.setRGSPreSenseWarning(%1)", (long)n);
        this.getDSI().setRGSPreSenseWarning(n);
    }

    private void setRGSBeltPretensionerFront(boolean bl, boolean bl2) {
        RGSBeltPretensionData rGSBeltPretensionData = this.leftHandDriveCar ? new RGSBeltPretensionData(bl, bl2) : new RGSBeltPretensionData(bl2, bl);
        this.getLogChannel().log(1078071040, "dsi.setRGSBeltPretensionerDataFront(%1)", (Object)rGSBeltPretensionData);
        this.getDSI().setRGSBeltPretensionerDataFront(rGSBeltPretensionData);
    }

    @Override
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

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.getLogChannel().log(1078071040, "keyPressed: %1", (long)n);
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

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1}, new int[]{53, 54, 2})};
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currViewOptions == null) {
            return "no view options received yet";
        }
        return this.currViewOptions.toString();
    }

    @Override
    public void updateRGSViewOptions(RGSViewOptions rGSViewOptions, int n) {
        this.getLogChannel().log(1078071040, "updateRGSViewOptions(%1), valid:%2", (Object)rGSViewOptions, (long)n);
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

    @Override
    public void updateRGSPreSenseSystem(boolean bl, int n) {
        this.getLogChannel().log(1078071040, "updateRGSPreSenseSystem(%1), valid:%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(606734592).setValue(bl ? 1 : 0);
            if (!bl) {
                this.getButtonModel(690620672).fireEvent(0);
            }
        }
    }

    @Override
    public void updateRGSPreSenseWarning(int n, int n2) {
        this.getLogChannel().log(1078071040, "updateRGSPreSenseWarning(%1), valid:%2", (long)n, (long)n2);
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
            this.getChoiceModel(640289024).setValue(n3);
        }
    }

    @Override
    public void updateRGSBeltPretensionDataFront(RGSBeltPretensionData rGSBeltPretensionData, int n) {
        this.getLogChannel().log(1078071040, "updateRGSBeltPretensionDataFront(%1), valid:%2", (Object)rGSBeltPretensionData, (long)n);
        if (n == 1) {
            if (this.leftHandDriveCar) {
                this.rgsBeltPretensionDriverOn = rGSBeltPretensionData.isLeft();
                this.rgsBeltPretensionCoDriverOn = rGSBeltPretensionData.isRight();
            } else {
                this.rgsBeltPretensionDriverOn = rGSBeltPretensionData.isRight();
                this.rgsBeltPretensionCoDriverOn = rGSBeltPretensionData.isLeft();
            }
            this.getChoiceModel(1009322240).setValue(this.rgsBeltPretensionDriverOn ? 1 : 0);
            this.getChoiceModel(858327296).setValue(this.rgsBeltPretensionCoDriverOn ? 1 : 0);
        }
    }

    public boolean isLeftHandDriveCar() {
        return this.leftHandDriveCar;
    }

    protected abstract void updateMenuEntryVisibility(RGSViewOptions rGSViewOptions) {
    }

    @Override
    public String getName() {
        return "Audi PreSense (RGS)";
    }

    static {
        RGS_WARNING_DSI_MAPPING = new int[]{0, 1, 2, 3};
    }
}

