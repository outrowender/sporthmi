/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.ITextLayoutSection;
import de.esolutions.graphics.ealswigJNI;

public final class ITextLayoutSection$hinting_t {
    public static final ITextLayoutSection$hinting_t HINTING_OFF = new ITextLayoutSection$hinting_t("HINTING_OFF", ealswigJNI.eal_api_ITextLayoutSection_HINTING_OFF_get());
    public static final ITextLayoutSection$hinting_t HINTING_AUTO = new ITextLayoutSection$hinting_t("HINTING_AUTO");
    public static final ITextLayoutSection$hinting_t HINTING_BYTECODE = new ITextLayoutSection$hinting_t("HINTING_BYTECODE");
    private static ITextLayoutSection$hinting_t[] swigValues = new ITextLayoutSection$hinting_t[]{HINTING_OFF, HINTING_AUTO, HINTING_BYTECODE};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static ITextLayoutSection$hinting_t swigToEnum(int n) {
        if (n < swigValues.length && n >= 0 && ITextLayoutSection$hinting_t.swigValues[n].swigValue == n) {
            return swigValues[n];
        }
        for (int i2 = 0; i2 < swigValues.length; ++i2) {
            if (ITextLayoutSection$hinting_t.swigValues[i2].swigValue != n) continue;
            return swigValues[i2];
        }
        throw new IllegalArgumentException(new StringBuffer().append("No enum ").append(ITextLayoutSection.class$de$esolutions$graphics$eal$api$ITextLayoutSection$hinting_t == null ? (ITextLayoutSection.class$de$esolutions$graphics$eal$api$ITextLayoutSection$hinting_t = ITextLayoutSection.class$("de.esolutions.graphics.eal.api.ITextLayoutSection$hinting_t")) : ITextLayoutSection.class$de$esolutions$graphics$eal$api$ITextLayoutSection$hinting_t).append(" with value ").append(n).toString());
    }

    private ITextLayoutSection$hinting_t(String string) {
        this.swigName = string;
        this.swigValue = swigNext++;
    }

    private ITextLayoutSection$hinting_t(String string, int n) {
        this.swigName = string;
        this.swigValue = n;
        swigNext = n + 1;
    }

    private ITextLayoutSection$hinting_t(String string, ITextLayoutSection$hinting_t iTextLayoutSection$hinting_t) {
        this.swigName = string;
        this.swigValue = iTextLayoutSection$hinting_t.swigValue;
        swigNext = this.swigValue + 1;
    }
}

