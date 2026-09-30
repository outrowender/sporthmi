/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.carplay;

import de.audi.app.terminalmode.util.Enum;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class AbstractDSICarplayEnum<T>
extends Enum<T> {
    private final int dsiConstant;

    public AbstractDSICarplayEnum(int n, String string) {
        super(string);
        this.dsiConstant = n;
    }

    final int getDSIConstantValue() {
        return this.dsiConstant;
    }
}

