/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.driveassist;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.driveassist.AbstractDSICarDriverAssistanceAdapter;
import de.audi.atip.hmi.model.ChoiceListener;
import org.dsi.ifc.cardriverassistance.MKEViewOptions;

public abstract class AbstractMKEComponent
extends AbstractDSICarDriverAssistanceAdapter
implements ChoiceListener {
    public static final short CODING_ID = 35;
    private static final String LOGCHANNEL_NAME = "App.Car.MKE";
    private volatile MKEViewOptions currViewOptions;

    public AbstractMKEComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void initModels() {
        this.getChoiceModel(601038).setChoiceListener(this);
    }

    protected void deinitModels() {
        this.getChoiceModel(601038).resetListener();
    }

    private void setPauseRecommendation(boolean bl) {
        this.getLogChannel().log(1000000, "setPauseRecommendation dsi.setMKESystemOnOff(%1)", bl);
        this.getDSI().setMKESystemOnOff(bl);
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
            case 601038: {
                this.setPauseRecommendation(bl);
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
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{44}, new int[]{45})};
    }

    public String getCurrentViewOptions() {
        if (this.currViewOptions == null) {
            return "no view options received yet";
        }
        return this.currViewOptions.toString();
    }

    public void updateMKEViewOptions(MKEViewOptions mKEViewOptions, int n) {
        this.getLogChannel().log(1000000, "updateMKEViewOptions: mkeViewOptions=%1, validFlag=%2", (Object)mKEViewOptions, (long)n);
        if (n == 1) {
            this.currViewOptions = mKEViewOptions;
            this.updateMenuEntryVisibility(this.currViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    public void updateMKESystemOnOff(boolean bl, int n) {
        this.getLogChannel().log(1000000, "updateMKESystemOnOff: mKESystemOn=%1, validFlag=%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(601038).setValue(bl ? 1 : 0);
        }
    }

    protected abstract void updateMenuEntryVisibility(MKEViewOptions var1);

    public String getName() {
        return "MKE / Break";
    }
}

