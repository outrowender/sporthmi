/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.core.comfort.AbstractDSICarComfortAdapter;
import de.audi.atip.hmi.model.ChoiceListener;
import org.dsi.ifc.carcomfort.WiperViewOptions;

public abstract class AbstractEasyEntryComponent
extends AbstractDSICarComfortAdapter
implements ChoiceListener {
    public static final short CODING_ID = 12;
    private static final String LOGCHANNEL_NAME = "App.Car.Seat";
    private volatile WiperViewOptions currentViewOptions;
    public static final int ENABLED = 1;
    public static final int DISABLED = 0;

    public AbstractEasyEntryComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void initModels() {
        this.getChoiceModel(600375).setChoiceListener(this);
    }

    protected void deinitModels() {
        this.getChoiceModel(600375).resetListener();
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
        this.logModelData("[AbstractEasyEntryComponent#itemSelected]", n, n2, true);
        switch (n) {
            case 600375: {
                this.itemSelectedEasyEntryDriver(n2 == 1);
                break;
            }
            default: {
                this.logModelData("[AbstractEasyEntryComponent#itemSelected]", n, n2, false);
            }
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    private void itemSelectedEasyEntryDriver(boolean bl) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractEasyEntryComponent#itemSelectedEasyEntryDriver] dsi.setEasyEntrySteeringColumn: state=%1", bl);
        }
        this.getDSI().setEasyEntrySteeringColumn(bl);
    }

    public void updateWiperViewOptions(WiperViewOptions wiperViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractEasyEntryComponent#updateWiperViewOptions] viewOptions='%1', valid='%2'", (Object)(wiperViewOptions != null ? this.formatViewOptionsLog(wiperViewOptions.toString()) : "null"), (long)n);
        }
        if (n == 1 && wiperViewOptions != null) {
            this.currentViewOptions = wiperViewOptions;
            this.updateMenuEntryVisibility(this.currentViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    public void updateEasyEntrySteeringColumn(boolean bl, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractEasyEntryComponent#updateEasyEntrySteeringColumn] enable='%1', valid='%2'", bl, (long)n);
        }
        if (n == 1) {
            this.getChoiceModel(600375).setValue(bl ? 1 : 0);
        }
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{21}, new int[]{28})};
    }

    protected abstract void updateMenuEntryVisibility(WiperViewOptions var1);

    public String getCurrentViewOptions() {
        if (this.currentViewOptions == null) {
            return "no view options received yet";
        }
        return this.currentViewOptions.toString();
    }

    public String getName() {
        return "Car Seat Driver Easy Entry";
    }
}

