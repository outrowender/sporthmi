/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.IFontGroup;

public final class IFontGroup$loadingStrategy_t {
    public static final IFontGroup$loadingStrategy_t LOADING_STRATEGY_IMMEDIATELY = new IFontGroup$loadingStrategy_t("LOADING_STRATEGY_IMMEDIATELY");
    public static final IFontGroup$loadingStrategy_t LOADING_STRATEGY_LAZY = new IFontGroup$loadingStrategy_t("LOADING_STRATEGY_LAZY");
    private static IFontGroup$loadingStrategy_t[] swigValues = new IFontGroup$loadingStrategy_t[]{LOADING_STRATEGY_IMMEDIATELY, LOADING_STRATEGY_LAZY};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static IFontGroup$loadingStrategy_t swigToEnum(int n) {
        if (n < swigValues.length && n >= 0 && IFontGroup$loadingStrategy_t.swigValues[n].swigValue == n) {
            return swigValues[n];
        }
        for (int i2 = 0; i2 < swigValues.length; ++i2) {
            if (IFontGroup$loadingStrategy_t.swigValues[i2].swigValue != n) continue;
            return swigValues[i2];
        }
        throw new IllegalArgumentException(new StringBuffer().append("No enum ").append(IFontGroup.class$de$esolutions$graphics$eal$api$IFontGroup$loadingStrategy_t == null ? (IFontGroup.class$de$esolutions$graphics$eal$api$IFontGroup$loadingStrategy_t = IFontGroup.class$("de.esolutions.graphics.eal.api.IFontGroup$loadingStrategy_t")) : IFontGroup.class$de$esolutions$graphics$eal$api$IFontGroup$loadingStrategy_t).append(" with value ").append(n).toString());
    }

    private IFontGroup$loadingStrategy_t(String string) {
        this.swigName = string;
        this.swigValue = swigNext++;
    }

    private IFontGroup$loadingStrategy_t(String string, int n) {
        this.swigName = string;
        this.swigValue = n;
        swigNext = n + 1;
    }

    private IFontGroup$loadingStrategy_t(String string, IFontGroup$loadingStrategy_t iFontGroup$loadingStrategy_t) {
        this.swigName = string;
        this.swigValue = iFontGroup$loadingStrategy_t.swigValue;
        swigNext = this.swigValue + 1;
    }
}

