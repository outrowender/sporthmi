/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.core.comfort.AbstractDSICarComfortAdapter;
import de.audi.atip.hmi.model.ChoiceListener;
import org.dsi.ifc.carcomfort.WiperViewOptions;

public abstract class AbstractWiperComponent
extends AbstractDSICarComfortAdapter
implements ChoiceListener {
    private static final String LOGCHANNEL_NAME = "App.Car.Wiper";
    public static final short CODING_ID = 12;
    public volatile WiperViewOptions currentViewOptions;

    public AbstractWiperComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void initModels() {
        this.getChoiceModel(600445).setChoiceListener(this);
        this.getChoiceModel(600443).setChoiceListener(this);
    }

    protected void deinitModels() {
        this.getChoiceModel(600445).resetListener();
        this.getChoiceModel(600443).resetListener();
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logModelData("itemSelected:", n, n2, true);
        boolean bl = n2 == 1;
        switch (n) {
            case 600445: {
                this.setServicePosition(bl);
                break;
            }
            case 600443: {
                this.setRainSensorOnOff(bl);
                break;
            }
            default: {
                this.logModelData("itemSelected:", n, n2, false);
            }
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    private void setServicePosition(boolean bl) {
        this.getLogChannel().log(1000000, "setWiperServicePosition(%1)", bl);
        this.getDSI().setWiperServicePosition(bl);
    }

    private void setRainSensorOnOff(boolean bl) {
        this.getLogChannel().log(1000000, "setRainSensorOnOff(%1)", bl);
        this.getDSI().setWiperRainSensorOnOff(bl);
    }

    public void updateWiperViewOptions(WiperViewOptions wiperViewOptions, int n) {
        this.getLogChannel().log(1000000, "updateWiperViewOptions(%1), valid:%2", (Object)wiperViewOptions, (long)n);
        if (n == 1) {
            this.currentViewOptions = wiperViewOptions;
            this.updateMenuEntryVisibility(wiperViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    public void updateWiperServicePosition(boolean bl, int n) {
        this.getLogChannel().log(1000000, "updateWiperServicePosition(%1), valid:%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(600445).setValue(bl ? 1 : 0);
        }
    }

    public void updateWiperRainSensorOnOff(boolean bl, int n) {
        this.getLogChannel().log(1000000, "updateWiperRainSensorOnOff(%1), valid:%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(600443).setValue(bl ? 1 : 0);
        }
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{21}, new int[]{22, 23})};
    }

    public String getCurrentViewOptions() {
        if (this.currentViewOptions == null) {
            return "no view options received yet";
        }
        return this.currentViewOptions.toString();
    }

    protected abstract void updateMenuEntryVisibility(WiperViewOptions var1);

    public String getName() {
        return "Wiper";
    }
}

