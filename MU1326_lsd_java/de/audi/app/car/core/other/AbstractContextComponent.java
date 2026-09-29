/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.other;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.AbstractCarComponent;
import de.audi.app.car.common.comp.CarDSIAttributesSet;

public abstract class AbstractContextComponent
extends AbstractCarComponent {
    private static final String LOGCHANNEL_NAME;

    public AbstractContextComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.Context");
    }

    protected void setCarContext(int n) {
        this.getChoiceModel(-1960048384).setValue(n);
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[0];
    }

    @Override
    public String getCurrentViewOptions() {
        return "component does not use view options";
    }

    @Override
    public String getName() {
        return "ContextComponent";
    }

    @Override
    protected void initModels() {
    }

    @Override
    protected void deinitModels() {
    }

    @Override
    public String getDSIListenerClassName() {
        return null;
    }

    @Override
    public String getDSIClassName() {
        return null;
    }

    @Override
    public boolean isUsingDSI() {
        return false;
    }
}

