/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.driveassist;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.driveassist.AbstractDSICarDriverAssistanceAdapter;
import de.audi.atip.hmi.model.ChoiceListener;
import org.dsi.ifc.cardriverassistance.LDWHCAViewOptions;

public abstract class AbstractLDWComponent
extends AbstractDSICarDriverAssistanceAdapter
implements ChoiceListener {
    public static final short CODING_ID = 4;
    private static final String LOGCHANNEL_NAME = "App.Car.LDW";
    private volatile LDWHCAViewOptions currViewOptions;

    public AbstractLDWComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void initModels() {
        this.getChoiceModel(600997).setChoiceListener(this);
        this.getChoiceModel(600999).setChoiceListener(this);
    }

    protected void deinitModels() {
        this.getChoiceModel(600997).resetListener();
        this.getChoiceModel(600999).resetListener();
    }

    private void setHCAInterventionStyle(int n) {
        int n2 = n > 0 ? 1 : 0;
        this.getLogChannel().log(1000000, "[AbstractLDWComponent#setHCAInterventionStyle] call DSI - setHCAInterventionStyle(%1)", (long)n2);
        this.getDSI().setHCAInterventionStyle(n2);
    }

    private void setHCAToleranceLevel(int n) {
        int n2 = n > 0 ? 2 : 0;
        this.getLogChannel().log(1000000, "[AbstractLDWComponent#setHCAToleranceLevel] call DSI - setHCAToleranceLevel(%1)", (long)n2);
        this.getDSI().setHCAToleranceLevel(n2);
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
        switch (n) {
            case 600997: {
                this.setHCAInterventionStyle(n2);
                break;
            }
            case 600999: {
                this.setHCAToleranceLevel(n2);
                break;
            }
            default: {
                this.logModelData("itemSelected:", n, n2, false);
            }
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{19}, new int[]{22, 23})};
    }

    public String getCurrentViewOptions() {
        if (this.currViewOptions == null) {
            return "no view options received yet";
        }
        return this.currViewOptions.toString();
    }

    public void updateLDWHCAViewOptions(LDWHCAViewOptions lDWHCAViewOptions, int n) {
        this.getLogChannel().log(1000000, "updateACCViewOptions(%1), valid:%2", (Object)lDWHCAViewOptions, (long)n);
        if (n == 1) {
            this.currViewOptions = lDWHCAViewOptions;
            this.updateMenuEntryVisibility(this.currViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    public void updateHCAInterventionStyle(int n, int n2) {
        this.getLogChannel().log(1000000, "updateHCAInterventionsStyle style:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            this.getChoiceModel(600997).setValue(n == 0 ? 0 : 1);
        }
    }

    public void updateHCAToleranceLevel(int n, int n2) {
        int n3;
        this.getLogChannel().log(1000000, "updateHCAInterventionsStyle level:%1 valid:%2", (long)n, (long)n2);
        switch (n) {
            case 0: {
                n3 = 0;
                break;
            }
            case 2: {
                n3 = 1;
                break;
            }
            default: {
                n3 = 1;
            }
        }
        this.getChoiceModel(600999).setValue(n3);
    }

    protected abstract void updateMenuEntryVisibility(LDWHCAViewOptions var1);

    public String getName() {
        return "LDW / Audi Lane Assist";
    }
}

