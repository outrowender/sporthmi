/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.carplay;

import de.audi.app.terminalmode.util.Enum;

public abstract class AbstractDSICarplayEnum
extends Enum {
    private final int dsiConstant;

    public AbstractDSICarplayEnum(int n, String string) {
        super(string);
        this.dsiConstant = n;
    }

    final int getDSIConstantValue() {
        return this.dsiConstant;
    }
}

