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
    public static final short CODING_ID;
    private static final String LOGCHANNEL_NAME;
    private volatile MKEViewOptions currViewOptions;

    public AbstractMKEComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.MKE");
    }

    @Override
    protected void initModels() {
        this.getChoiceModel(-836040448).setChoiceListener(this);
    }

    @Override
    protected void deinitModels() {
        this.getChoiceModel(-836040448).resetListener();
    }

    private void setPauseRecommendation(boolean bl) {
        this.getLogChannel().log(1078071040, "setPauseRecommendation dsi.setMKESystemOnOff(%1)", bl);
        this.getDSI().setMKESystemOnOff(bl);
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
            case 601038: {
                this.setPauseRecommendation(bl);
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
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{44}, new int[]{45})};
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currViewOptions == null) {
            return "no view options received yet";
        }
        return this.currViewOptions.toString();
    }

    @Override
    public void updateMKEViewOptions(MKEViewOptions mKEViewOptions, int n) {
        this.getLogChannel().log(1078071040, "updateMKEViewOptions: mkeViewOptions=%1, validFlag=%2", (Object)mKEViewOptions, (long)n);
        if (n == 1) {
            this.currViewOptions = mKEViewOptions;
            this.updateMenuEntryVisibility(this.currViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    @Override
    public void updateMKESystemOnOff(boolean bl, int n) {
        this.getLogChannel().log(1078071040, "updateMKESystemOnOff: mKESystemOn=%1, validFlag=%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(-836040448).setValue(bl ? 1 : 0);
        }
    }

    protected abstract void updateMenuEntryVisibility(MKEViewOptions mKEViewOptions) {
    }

    @Override
    public String getName() {
        return "MKE / Break";
    }
}

