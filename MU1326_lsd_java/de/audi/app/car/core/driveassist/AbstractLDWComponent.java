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
    public static final short CODING_ID;
    private static final String LOGCHANNEL_NAME;
    private volatile LDWHCAViewOptions currViewOptions;

    public AbstractLDWComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.LDW");
    }

    @Override
    protected void initModels() {
        this.getChoiceModel(-1523906304).setChoiceListener(this);
        this.getChoiceModel(-1490351872).setChoiceListener(this);
    }

    @Override
    protected void deinitModels() {
        this.getChoiceModel(-1523906304).resetListener();
        this.getChoiceModel(-1490351872).resetListener();
    }

    private void setHCAInterventionStyle(int n) {
        int n2 = n > 0 ? 1 : 0;
        this.getLogChannel().log(1078071040, "[AbstractLDWComponent#setHCAInterventionStyle] call DSI - setHCAInterventionStyle(%1)", (long)n2);
        this.getDSI().setHCAInterventionStyle(n2);
    }

    private void setHCAToleranceLevel(int n) {
        int n2 = n > 0 ? 2 : 0;
        this.getLogChannel().log(1078071040, "[AbstractLDWComponent#setHCAToleranceLevel] call DSI - setHCAToleranceLevel(%1)", (long)n2);
        this.getDSI().setHCAToleranceLevel(n2);
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

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{19}, new int[]{22, 23})};
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currViewOptions == null) {
            return "no view options received yet";
        }
        return this.currViewOptions.toString();
    }

    @Override
    public void updateLDWHCAViewOptions(LDWHCAViewOptions lDWHCAViewOptions, int n) {
        this.getLogChannel().log(1078071040, "updateACCViewOptions(%1), valid:%2", (Object)lDWHCAViewOptions, (long)n);
        if (n == 1) {
            this.currViewOptions = lDWHCAViewOptions;
            this.updateMenuEntryVisibility(this.currViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    @Override
    public void updateHCAInterventionStyle(int n, int n2) {
        this.getLogChannel().log(1078071040, "updateHCAInterventionsStyle style:%1 valid:%2", (long)n, (long)n2);
        if (n2 == 1) {
            this.getChoiceModel(-1523906304).setValue(n == 0 ? 0 : 1);
        }
    }

    @Override
    public void updateHCAToleranceLevel(int n, int n2) {
        int n3;
        this.getLogChannel().log(1078071040, "updateHCAInterventionsStyle level:%1 valid:%2", (long)n, (long)n2);
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
        this.getChoiceModel(-1490351872).setValue(n3);
    }

    protected abstract void updateMenuEntryVisibility(LDWHCAViewOptions lDWHCAViewOptions) {
    }

    @Override
    public String getName() {
        return "LDW / Audi Lane Assist";
    }
}

