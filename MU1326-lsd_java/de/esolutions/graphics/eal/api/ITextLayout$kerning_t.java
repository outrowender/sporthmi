/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.ITextLayout;

public final class ITextLayout$kerning_t {
    public static final ITextLayout$kerning_t KERNING_OFF = new ITextLayout$kerning_t("KERNING_OFF");
    public static final ITextLayout$kerning_t KERNING_AUTO = new ITextLayout$kerning_t("KERNING_AUTO");
    public static final ITextLayout$kerning_t KERNING_GPOS = new ITextLayout$kerning_t("KERNING_GPOS");
    public static final ITextLayout$kerning_t KERNING_FULL = new ITextLayout$kerning_t("KERNING_FULL");
    private static ITextLayout$kerning_t[] swigValues = new ITextLayout$kerning_t[]{KERNING_OFF, KERNING_AUTO, KERNING_GPOS, KERNING_FULL};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static ITextLayout$kerning_t swigToEnum(int n) {
        if (n < swigValues.length && n >= 0 && ITextLayout$kerning_t.swigValues[n].swigValue == n) {
            return swigValues[n];
        }
        for (int i2 = 0; i2 < swigValues.length; ++i2) {
            if (ITextLayout$kerning_t.swigValues[i2].swigValue != n) continue;
            return swigValues[i2];
        }
        throw new IllegalArgumentException(new StringBuffer().append("No enum ").append(ITextLayout.class$de$esolutions$graphics$eal$api$ITextLayout$kerning_t == null ? (ITextLayout.class$de$esolutions$graphics$eal$api$ITextLayout$kerning_t = ITextLayout.class$("de.esolutions.graphics.eal.api.ITextLayout$kerning_t")) : ITextLayout.class$de$esolutions$graphics$eal$api$ITextLayout$kerning_t).append(" with value ").append(n).toString());
    }

    private ITextLayout$kerning_t(String string) {
        this.swigName = string;
        this.swigValue = swigNext++;
    }

    private ITextLayout$kerning_t(String string, int n) {
        this.swigName = string;
        this.swigValue = n;
        swigNext = n + 1;
    }

    private ITextLayout$kerning_t(String string, ITextLayout$kerning_t iTextLayout$kerning_t) {
        this.swigName = string;
        this.swigValue = iTextLayout$kerning_t.swigValue;
        swigNext = this.swigValue + 1;
    }
}

