/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.TunerModels;

public class WeatherRow
extends EvoListRow {
    private static final int INDEX_TXW_NAME = 0;
    private static final int INDEX_TXW_CHECKBOX_ID = 1;
    private static final int INDEX_TXW_ID = 2;
    private static final int INDEX_TXW_INITIAL_CHECKBOX_VALUE = 3;
    private static final int TXW_COLUMNS = 4;

    public WeatherRow(int n, String string, int n2, int n3) {
        super(n, 4);
        this.setInteger(2, n);
        this.setText(0, string);
        this.setInteger(1, n2);
        this.setInteger(3, n3);
    }

    public WeatherRow(EvoListRow evoListRow) {
        super(evoListRow);
    }

    public boolean isActivationCheckboxSelected() {
        return TunerModels.checkboxConstantToBoolean(this.getInteger(1));
    }

    public void setCheckboxSelected(boolean bl) {
        int n = TunerModels.booleanToCheckboxConstant(bl);
        this.setInteger(1, n);
    }

    public void toggleCheckbox() {
        this.setCheckboxSelected(!this.isActivationCheckboxSelected());
    }

    public int getSeekId() {
        return this.getInteger(2);
    }

    public EvoListRow copy() {
        return new WeatherRow(this);
    }

    public int getInitialCheckbox() {
        return this.getInteger(3);
    }
}

