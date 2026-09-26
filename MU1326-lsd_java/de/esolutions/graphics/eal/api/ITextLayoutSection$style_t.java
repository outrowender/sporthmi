/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.ITextLayoutSection;
import de.esolutions.graphics.ealswigJNI;

public final class ITextLayoutSection$style_t {
    public static final ITextLayoutSection$style_t STYLE_REGULAR = new ITextLayoutSection$style_t("STYLE_REGULAR", ealswigJNI.eal_api_ITextLayoutSection_STYLE_REGULAR_get());
    public static final ITextLayoutSection$style_t STYLE_BOLD = new ITextLayoutSection$style_t("STYLE_BOLD", ealswigJNI.eal_api_ITextLayoutSection_STYLE_BOLD_get());
    public static final ITextLayoutSection$style_t STYLE_ITALIC = new ITextLayoutSection$style_t("STYLE_ITALIC", ealswigJNI.eal_api_ITextLayoutSection_STYLE_ITALIC_get());
    public static final ITextLayoutSection$style_t STYLE_BOLD_ITALIC = new ITextLayoutSection$style_t("STYLE_BOLD_ITALIC", ealswigJNI.eal_api_ITextLayoutSection_STYLE_BOLD_ITALIC_get());
    public static final ITextLayoutSection$style_t STYLE_UNDERLINE = new ITextLayoutSection$style_t("STYLE_UNDERLINE", ealswigJNI.eal_api_ITextLayoutSection_STYLE_UNDERLINE_get());
    public static final ITextLayoutSection$style_t STYLE_OVERLINE = new ITextLayoutSection$style_t("STYLE_OVERLINE", ealswigJNI.eal_api_ITextLayoutSection_STYLE_OVERLINE_get());
    public static final ITextLayoutSection$style_t STYLE_STRIKEOUT = new ITextLayoutSection$style_t("STYLE_STRIKEOUT", ealswigJNI.eal_api_ITextLayoutSection_STYLE_STRIKEOUT_get());
    private static ITextLayoutSection$style_t[] swigValues = new ITextLayoutSection$style_t[]{STYLE_REGULAR, STYLE_BOLD, STYLE_ITALIC, STYLE_BOLD_ITALIC, STYLE_UNDERLINE, STYLE_OVERLINE, STYLE_STRIKEOUT};
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static ITextLayoutSection$style_t swigToEnum(int n) {
        if (n < swigValues.length && n >= 0 && ITextLayoutSection$style_t.swigValues[n].swigValue == n) {
            return swigValues[n];
        }
        for (int i2 = 0; i2 < swigValues.length; ++i2) {
            if (ITextLayoutSection$style_t.swigValues[i2].swigValue != n) continue;
            return swigValues[i2];
        }
        throw new IllegalArgumentException(new StringBuffer().append("No enum ").append(ITextLayoutSection.class$de$esolutions$graphics$eal$api$ITextLayoutSection$style_t == null ? (ITextLayoutSection.class$de$esolutions$graphics$eal$api$ITextLayoutSection$style_t = ITextLayoutSection.class$("de.esolutions.graphics.eal.api.ITextLayoutSection$style_t")) : ITextLayoutSection.class$de$esolutions$graphics$eal$api$ITextLayoutSection$style_t).append(" with value ").append(n).toString());
    }

    private ITextLayoutSection$style_t(String string) {
        this.swigName = string;
        this.swigValue = swigNext++;
    }

    private ITextLayoutSection$style_t(String string, int n) {
        this.swigName = string;
        this.swigValue = n;
        swigNext = n + 1;
    }

    private ITextLayoutSection$style_t(String string, ITextLayoutSection$style_t iTextLayoutSection$style_t) {
        this.swigName = string;
        this.swigValue = iTextLayoutSection$style_t.swigValue;
        swigNext = this.swigValue + 1;
    }
}

