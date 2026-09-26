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
    private static final String LOGCHANNEL_NAME;
    public static final short CODING_ID;
    public volatile WiperViewOptions currentViewOptions;

    public AbstractWiperComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.Wiper");
    }

    @Override
    protected void initModels() {
        this.getChoiceModel(2099841280).setChoiceListener(this);
        this.getChoiceModel(2066286848).setChoiceListener(this);
    }

    @Override
    protected void deinitModels() {
        this.getChoiceModel(2099841280).resetListener();
        this.getChoiceModel(2066286848).resetListener();
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
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

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    private void setServicePosition(boolean bl) {
        this.getLogChannel().log(1078071040, "setWiperServicePosition(%1)", bl);
        this.getDSI().setWiperServicePosition(bl);
    }

    private void setRainSensorOnOff(boolean bl) {
        this.getLogChannel().log(1078071040, "setRainSensorOnOff(%1)", bl);
        this.getDSI().setWiperRainSensorOnOff(bl);
    }

    @Override
    public void updateWiperViewOptions(WiperViewOptions wiperViewOptions, int n) {
        this.getLogChannel().log(1078071040, "updateWiperViewOptions(%1), valid:%2", (Object)wiperViewOptions, (long)n);
        if (n == 1) {
            this.currentViewOptions = wiperViewOptions;
            this.updateMenuEntryVisibility(wiperViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    @Override
    public void updateWiperServicePosition(boolean bl, int n) {
        this.getLogChannel().log(1078071040, "updateWiperServicePosition(%1), valid:%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(2099841280).setValue(bl ? 1 : 0);
        }
    }

    @Override
    public void updateWiperRainSensorOnOff(boolean bl, int n) {
        this.getLogChannel().log(1078071040, "updateWiperRainSensorOnOff(%1), valid:%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(2066286848).setValue(bl ? 1 : 0);
        }
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{21}, new int[]{22, 23})};
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currentViewOptions == null) {
            return "no view options received yet";
        }
        return this.currentViewOptions.toString();
    }

    protected abstract void updateMenuEntryVisibility(WiperViewOptions wiperViewOptions) {
    }

    @Override
    public String getName() {
        return "Wiper";
    }
}

