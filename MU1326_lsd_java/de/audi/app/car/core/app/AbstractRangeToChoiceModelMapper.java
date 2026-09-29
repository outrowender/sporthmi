/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.app;

import de.audi.app.car.common.comp.AbstractCarComponent;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

public abstract class AbstractRangeToChoiceModelMapper {
    protected ChoiceModelApp choiceModel = null;
    private int minValue;
    private int maxValue;
    private int stepSize;

    public AbstractRangeToChoiceModelMapper(ChoiceModelApp choiceModelApp, int n, int n2, int n3) {
        this.choiceModel = choiceModelApp;
        this.minValue = n;
        this.maxValue = n2;
        this.stepSize = n3;
    }

    public void setValue(int n) {
        this.choiceModel.setValue(this.getMapping(n));
    }

    public int getMapping(int n) {
        int n2 = Math.abs(this.maxValue - this.minValue);
        n = (n - this.minValue) / this.stepSize;
        return AbstractCarComponent.clip(n, 0, n2);
    }
}

