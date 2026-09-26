/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.common.adapter.AbstractDSICarHybridAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.atip.hmi.model.ChoiceListener;
import org.dsi.ifc.carhybrid.HybridViewOptions;

public abstract class AbstractPEAHybridSubComponent
extends AbstractDSICarHybridAdapter
implements ChoiceListener {
    public static final short CODING_ID;
    private volatile HybridViewOptions currentViewOptions;

    public AbstractPEAHybridSubComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.PEA");
    }

    @Override
    protected void initModels() {
        this.getChoiceModel(-1876031232).setChoiceListener(this);
    }

    @Override
    protected void deinitModels() {
        this.getChoiceModel(-1876031232).resetListener();
    }

    @Override
    public void updateHybridViewOptions(HybridViewOptions hybridViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractPEAHybridSubComponent#updateHybridViewOptions] viewOptions='%1', valid='%2'", (Object)(hybridViewOptions != null ? this.formatViewOptionsLog(hybridViewOptions.toString()) : "null"), (long)n);
        }
        if (n == 1 && hybridViewOptions != null) {
            this.currentViewOptions = hybridViewOptions;
            this.updateMenuEntryVisibility(this.currentViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    @Override
    public void updateHybridActivePedal(boolean bl, int n) {
        this.getLogChannel().log(1078071040, "updateHybridActivePedal(%1, %2)", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(-1876031232).setValue(bl ? 1 : 0);
        }
    }

    public abstract void updateMenuEntryVisibility(HybridViewOptions hybridViewOptions) {
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1}, new int[]{27})};
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currentViewOptions != null) {
            return this.currentViewOptions.toString();
        }
        return "not yet received";
    }

    @Override
    public String getName() {
        return "P. Efficiency Assistant - Hybrid SubComponent";
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
        this.getLogChannel().log(1078071040, "itemSelected: %1, %2", (long)n, (long)n2);
        boolean bl = n2 == 1;
        switch (n) {
            case 601744: {
                this.getLogChannel().log(1078071040, "dsi.setHybridActivePedal(%1)", bl);
                this.getDSI().setHybridActivePedal(bl);
                break;
            }
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }
}

