/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.ITextLayoutSection;

public final class ITextLayoutSection$lineExtender_t {
    public static final ITextLayoutSection$lineExtender_t NOEXTENDER = new ITextLayoutSection$lineExtender_t("NOEXTENDER");
    public static final ITextLayoutSection$lineExtender_t HYPHENEXTENDER = new ITextLayoutSection$lineExtender_t("HYPHENEXTENDER");
    public static final ITextLayoutSection$lineExtender_t USEREXTENDER = new ITextLayoutSection$lineExtender_t("USEREXTENDER");
    public static final ITextLayoutSection$lineExtender_t WORDEXTENDER = new ITextLayoutSection$lineExtender_t("WORDEXTENDER");
    public static final ITextLayoutSection$lineExtender_t UNICODELINEBREAK = new ITextLayoutSection$lineExtender_t("UNICODELINEBREAK");
    private static ITextLayoutSection$lineExtender_t[] swigValues = new ITextLayoutSection$lineExtender_t[]{NOEXTENDER, HYPHENEXTENDER, USEREXTENDER, WORDEXTENDER, UNICODELINEBREAK};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static ITextLayoutSection$lineExtender_t swigToEnum(int n) {
        if (n < swigValues.length && n >= 0 && ITextLayoutSection$lineExtender_t.swigValues[n].swigValue == n) {
            return swigValues[n];
        }
        for (int i2 = 0; i2 < swigValues.length; ++i2) {
            if (ITextLayoutSection$lineExtender_t.swigValues[i2].swigValue != n) continue;
            return swigValues[i2];
        }
        throw new IllegalArgumentException(new StringBuffer().append("No enum ").append(ITextLayoutSection.class$de$esolutions$graphics$eal$api$ITextLayoutSection$lineExtender_t == null ? (ITextLayoutSection.class$de$esolutions$graphics$eal$api$ITextLayoutSection$lineExtender_t = ITextLayoutSection.class$("de.esolutions.graphics.eal.api.ITextLayoutSection$lineExtender_t")) : ITextLayoutSection.class$de$esolutions$graphics$eal$api$ITextLayoutSection$lineExtender_t).append(" with value ").append(n).toString());
    }

    private ITextLayoutSection$lineExtender_t(String string) {
        this.swigName = string;
        this.swigValue = swigNext++;
    }

    private ITextLayoutSection$lineExtender_t(String string, int n) {
        this.swigName = string;
        this.swigValue = n;
        swigNext = n + 1;
    }

    private ITextLayoutSection$lineExtender_t(String string, ITextLayoutSection$lineExtender_t iTextLayoutSection$lineExtender_t) {
        this.swigName = string;
        this.swigValue = iTextLayoutSection$lineExtender_t.swigValue;
        swigNext = this.swigValue + 1;
    }
}

