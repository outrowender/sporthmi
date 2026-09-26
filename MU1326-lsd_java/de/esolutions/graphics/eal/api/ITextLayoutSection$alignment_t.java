/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.ITextLayoutSection;

public final class ITextLayoutSection$alignment_t {
    public static final ITextLayoutSection$alignment_t LEFTALIGNED = new ITextLayoutSection$alignment_t("LEFTALIGNED");
    public static final ITextLayoutSection$alignment_t RIGHTALIGNED = new ITextLayoutSection$alignment_t("RIGHTALIGNED");
    public static final ITextLayoutSection$alignment_t CENTERALIGNED = new ITextLayoutSection$alignment_t("CENTERALIGNED");
    public static final ITextLayoutSection$alignment_t JUSTIFIED = new ITextLayoutSection$alignment_t("JUSTIFIED");
    private static ITextLayoutSection$alignment_t[] swigValues = new ITextLayoutSection$alignment_t[]{LEFTALIGNED, RIGHTALIGNED, CENTERALIGNED, JUSTIFIED};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static ITextLayoutSection$alignment_t swigToEnum(int n) {
        if (n < swigValues.length && n >= 0 && ITextLayoutSection$alignment_t.swigValues[n].swigValue == n) {
            return swigValues[n];
        }
        for (int i2 = 0; i2 < swigValues.length; ++i2) {
            if (ITextLayoutSection$alignment_t.swigValues[i2].swigValue != n) continue;
            return swigValues[i2];
        }
        throw new IllegalArgumentException(new StringBuffer().append("No enum ").append(ITextLayoutSection.class$de$esolutions$graphics$eal$api$ITextLayoutSection$alignment_t == null ? (ITextLayoutSection.class$de$esolutions$graphics$eal$api$ITextLayoutSection$alignment_t = ITextLayoutSection.class$("de.esolutions.graphics.eal.api.ITextLayoutSection$alignment_t")) : ITextLayoutSection.class$de$esolutions$graphics$eal$api$ITextLayoutSection$alignment_t).append(" with value ").append(n).toString());
    }

    private ITextLayoutSection$alignment_t(String string) {
        this.swigName = string;
        this.swigValue = swigNext++;
    }

    private ITextLayoutSection$alignment_t(String string, int n) {
        this.swigName = string;
        this.swigValue = n;
        swigNext = n + 1;
    }

    private ITextLayoutSection$alignment_t(String string, ITextLayoutSection$alignment_t iTextLayoutSection$alignment_t) {
        this.swigName = string;
        this.swigValue = iTextLayoutSection$alignment_t.swigValue;
        swigNext = this.swigValue + 1;
    }
}

