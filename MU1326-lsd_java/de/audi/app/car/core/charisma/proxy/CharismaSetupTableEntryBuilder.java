/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma.proxy;

import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;

public class CharismaSetupTableEntryBuilder {
    private int listPosition;
    private int functionID;
    private int setupValue;

    public CharismaSetupTableEntryBuilder setListPosition(int n) {
        this.listPosition = n;
        return this;
    }

    public CharismaSetupTableEntryBuilder setFunctionID(int n) {
        this.functionID = n;
        return this;
    }

    public CharismaSetupTableEntryBuilder setSetupValue(int n) {
        this.setupValue = n;
        return this;
    }

    public CharismaSetupTableWithoutOptionMask build() {
        return new CharismaSetupTableWithoutOptionMask(this.listPosition, this.functionID, this.setupValue);
    }
}

