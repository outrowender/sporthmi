/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.eco;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.core.eco.AbstractDSICarEcoAdapter;
import de.audi.atip.hmi.model.ChoiceListener;
import org.dsi.ifc.careco.EAViewOptions;

public abstract class AbstractPEAComponent
extends AbstractDSICarEcoAdapter
implements ChoiceListener {
    public static final short CODING_ID = 55;
    public static final String LOGCHANNEL_NAME = "App.Car.PEA";
    private volatile EAViewOptions currentViewOptions;

    public AbstractPEAComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void initModels() {
        this.getChoiceModel(601112).setChoiceListener(this);
        this.getChoiceModel(601114).setChoiceListener(this);
        this.getChoiceModel(601606).setChoiceListener(this);
    }

    protected void deinitModels() {
        this.getChoiceModel(601112).resetListener();
        this.getChoiceModel(601114).resetListener();
        this.getChoiceModel(601606).resetListener();
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{42}, new int[]{43, 44, 47})};
    }

    public String getCurrentViewOptions() {
        if (this.currentViewOptions == null) {
            return "no view options received yet";
        }
        return this.currentViewOptions.toString();
    }

    public EAViewOptions getCurrentViewOptionsObject() {
        return this.currentViewOptions;
    }

    public String getName() {
        return "P. Efficiency Assistant";
    }

    protected abstract void updateMenuEntryVisibility();

    public void updateEAViewOptions(EAViewOptions eAViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractPEAComponent#updateViewOptions] viewOptions='%1', valid='%2'", (Object)(eAViewOptions != null ? this.formatViewOptionsLog(eAViewOptions.toString()) : "null"), (long)n);
        }
        if (n == 1 && eAViewOptions != null) {
            this.currentViewOptions = eAViewOptions;
            this.updateMenuEntryVisibility();
            this.primaryAttributeFirstSetReceived();
        }
    }

    public void updateEASystem(boolean bl, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractPEAComponent#updateEASystem] state='%1', valid='%2'", bl, (long)n);
        }
        if (n == 1) {
            this.getChoiceModel(601112).setValue(bl ? 1 : 0);
        }
    }

    public void updateEAPedalJerk(boolean bl, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractPEAComponent#updateEAPedalJerk] state='%1', valid='%2'", bl, (long)n);
        }
        if (n == 1) {
            this.getChoiceModel(601114).setValue(bl ? 1 : 0);
        }
    }

    public void updateEAFreeWheeling(boolean bl, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractPEAComponent#updateEAFreeWheeling] state='%1', valid='%2'", bl, (long)n);
        }
        if (n == 1) {
            this.getChoiceModel(601606).setValue(bl ? 1 : 0);
        }
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.getLogChannel().log(1000000, "[AbstractPEAComponent#itemSelected] model='%1', itemID='%2'", (long)n, (long)n2);
        boolean bl = n2 == 1;
        switch (n) {
            case 601112: {
                this.getLogChannel().log(1000000, "[AbstractPEAComponent#itemSelected] dsi.setEASystem(%1)", bl);
                this.getDSI().setEASystem(bl);
                break;
            }
            case 601114: {
                this.getLogChannel().log(1000000, "[AbstractPEAComponent#itemSelected] dsi.setEAPedalJerk(%1)", bl);
                this.getDSI().setEAPedalJerk(bl);
                break;
            }
            case 601606: {
                this.getLogChannel().log(1000000, "[AbstractPEAComponent#itemSelected] dsi.setEAFreeWheeling(%1)", bl);
                this.getDSI().setEAFreeWheeling(bl);
                break;
            }
        }
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }
}

