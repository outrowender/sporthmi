/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.other;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.AbstractCarComponent;
import de.audi.app.car.common.comp.CarDSIAttributesSet;

public abstract class AbstractContextComponent
extends AbstractCarComponent {
    private static final String LOGCHANNEL_NAME = "App.Car.Context";

    public AbstractContextComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void setCarContext(int n) {
        this.getChoiceModel(601227).setValue(n);
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[0];
    }

    public String getCurrentViewOptions() {
        return "component does not use view options";
    }

    public String getName() {
        return "ContextComponent";
    }

    protected void initModels() {
    }

    protected void deinitModels() {
    }

    public String getDSIListenerClassName() {
        return null;
    }

    public String getDSIClassName() {
        return null;
    }

    public boolean isUsingDSI() {
        return false;
    }
}

