/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.FlagFontStyle;
import de.esolutions.graphics.eal.api.IFont;
import de.esolutions.graphics.eal.api.IObject;
import de.esolutions.graphics.eal.colorRGBAf;
import de.esolutions.graphics.ealswigJNI;

public class ITextLayoutSection
extends IObject {
    private long swigCPtr;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$api$ITextLayoutSection$alignment_t;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$api$ITextLayoutSection$style_t;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$api$ITextLayoutSection$lineExtender_t;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$api$ITextLayoutSection$hinting_t;

    public ITextLayoutSection(long l, boolean bl) {
        super(ealswigJNI.eal_api_ITextLayoutSection_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(ITextLayoutSection iTextLayoutSection) {
        return iTextLayoutSection == null ? 0L : iTextLayoutSection.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_api_ITextLayoutSection(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public boolean isValid() {
        return ealswigJNI.eal_api_ITextLayoutSection_isValid(this.swigCPtr, this);
    }

    public boolean setBasic(IFont iFont, int n) {
        return ealswigJNI.eal_api_ITextLayoutSection_setBasic__SWIG_0(this.swigCPtr, this, IFont.getCPtr(iFont), iFont, n);
    }

    public boolean setBasic(IFont iFont, int n, long l) {
        return ealswigJNI.eal_api_ITextLayoutSection_setBasic__SWIG_1(this.swigCPtr, this, IFont.getCPtr(iFont), iFont, n, l);
    }

    public boolean setBasicFontGroup(int n, long l) {
        return ealswigJNI.eal_api_ITextLayoutSection_setBasicFontGroup(this.swigCPtr, this, n, l);
    }

    public boolean setAlignment(alignment_t alignment_t2) {
        return ealswigJNI.eal_api_ITextLayoutSection_setAlignment(this.swigCPtr, this, alignment_t2.swigValue());
    }

    public boolean setStartEndIndex(long l, long l2) {
        return ealswigJNI.eal_api_ITextLayoutSection_setStartEndIndex(this.swigCPtr, this, l, l2);
    }

    public boolean setLineGap(int n) {
        return ealswigJNI.eal_api_ITextLayoutSection_setLineGap(this.swigCPtr, this, n);
    }

    public boolean setFont(IFont iFont, int n, FlagFontStyle flagFontStyle) {
        return ealswigJNI.eal_api_ITextLayoutSection_setFont__SWIG_0(this.swigCPtr, this, IFont.getCPtr(iFont), iFont, n, FlagFontStyle.getCPtr(flagFontStyle), flagFontStyle);
    }

    public boolean setFont(IFont iFont, int n) {
        return ealswigJNI.eal_api_ITextLayoutSection_setFont__SWIG_1(this.swigCPtr, this, IFont.getCPtr(iFont), iFont, n);
    }

    public boolean setLineExtender(lineExtender_t lineExtender_t2) {
        return ealswigJNI.eal_api_ITextLayoutSection_setLineExtender(this.swigCPtr, this, lineExtender_t2.swigValue());
    }

    public void dispose() {
        ealswigJNI.eal_api_ITextLayoutSection_dispose(this.swigCPtr, this);
    }

    public boolean setColor(colorRGBAf colorRGBAf2) {
        return ealswigJNI.eal_api_ITextLayoutSection_setColor__SWIG_0(this.swigCPtr, this, colorRGBAf.getCPtr(colorRGBAf2), colorRGBAf2);
    }

    public boolean setColor(int n) {
        return ealswigJNI.eal_api_ITextLayoutSection_setColor__SWIG_1(this.swigCPtr, this, n);
    }

    public boolean setStyle(FlagFontStyle flagFontStyle) {
        return ealswigJNI.eal_api_ITextLayoutSection_setStyle(this.swigCPtr, this, FlagFontStyle.getCPtr(flagFontStyle), flagFontStyle);
    }

    public boolean setHinting(hinting_t hinting_t2) {
        return ealswigJNI.eal_api_ITextLayoutSection_setHinting(this.swigCPtr, this, hinting_t2.swigValue());
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    public static final class style_t {
        public static final style_t STYLE_REGULAR = new style_t("STYLE_REGULAR", ealswigJNI.eal_api_ITextLayoutSection_STYLE_REGULAR_get());
        public static final style_t STYLE_BOLD = new style_t("STYLE_BOLD", ealswigJNI.eal_api_ITextLayoutSection_STYLE_BOLD_get());
        public static final style_t STYLE_ITALIC = new style_t("STYLE_ITALIC", ealswigJNI.eal_api_ITextLayoutSection_STYLE_ITALIC_get());
        public static final style_t STYLE_BOLD_ITALIC = new style_t("STYLE_BOLD_ITALIC", ealswigJNI.eal_api_ITextLayoutSection_STYLE_BOLD_ITALIC_get());
        public static final style_t STYLE_UNDERLINE = new style_t("STYLE_UNDERLINE", ealswigJNI.eal_api_ITextLayoutSection_STYLE_UNDERLINE_get());
        public static final style_t STYLE_OVERLINE = new style_t("STYLE_OVERLINE", ealswigJNI.eal_api_ITextLayoutSection_STYLE_OVERLINE_get());
        public static final style_t STYLE_STRIKEOUT = new style_t("STYLE_STRIKEOUT", ealswigJNI.eal_api_ITextLayoutSection_STYLE_STRIKEOUT_get());
        private static style_t[] swigValues = new style_t[]{STYLE_REGULAR, STYLE_BOLD, STYLE_ITALIC, STYLE_BOLD_ITALIC, STYLE_UNDERLINE, STYLE_OVERLINE, STYLE_STRIKEOUT};
        private static int swigNext = 0;
        private final int swigValue;
        private final String swigName;

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static style_t swigToEnum(int n) {
            if (n < swigValues.length && n >= 0 && style_t.swigValues[n].swigValue == n) {
                return swigValues[n];
            }
            for (int i2 = 0; i2 < swigValues.length; ++i2) {
                if (style_t.swigValues[i2].swigValue != n) continue;
                return swigValues[i2];
            }
            throw new IllegalArgumentException("No enum " + (class$de$esolutions$graphics$eal$api$ITextLayoutSection$style_t == null ? (class$de$esolutions$graphics$eal$api$ITextLayoutSection$style_t = ITextLayoutSection.class$("de.esolutions.graphics.eal.api.ITextLayoutSection$style_t")) : class$de$esolutions$graphics$eal$api$ITextLayoutSection$style_t) + " with value " + n);
        }

        private style_t(String string) {
            this.swigName = string;
            this.swigValue = swigNext++;
        }

        private style_t(String string, int n) {
            this.swigName = string;
            this.swigValue = n;
            swigNext = n + 1;
        }

        private style_t(String string, style_t style_t2) {
            this.swigName = string;
            this.swigValue = style_t2.swigValue;
            swigNext = this.swigValue + 1;
        }
    }

    public static final class hinting_t {
        public static final hinting_t HINTING_OFF = new hinting_t("HINTING_OFF", ealswigJNI.eal_api_ITextLayoutSection_HINTING_OFF_get());
        public static final hinting_t HINTING_AUTO = new hinting_t("HINTING_AUTO");
        public static final hinting_t HINTING_BYTECODE = new hinting_t("HINTING_BYTECODE");
        private static hinting_t[] swigValues = new hinting_t[]{HINTING_OFF, HINTING_AUTO, HINTING_BYTECODE};
        private static int swigNext = 0;
        private final int swigValue;
        private final String swigName;

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static hinting_t swigToEnum(int n) {
            if (n < swigValues.length && n >= 0 && hinting_t.swigValues[n].swigValue == n) {
                return swigValues[n];
            }
            for (int i2 = 0; i2 < swigValues.length; ++i2) {
                if (hinting_t.swigValues[i2].swigValue != n) continue;
                return swigValues[i2];
            }
            throw new IllegalArgumentException("No enum " + (class$de$esolutions$graphics$eal$api$ITextLayoutSection$hinting_t == null ? (class$de$esolutions$graphics$eal$api$ITextLayoutSection$hinting_t = ITextLayoutSection.class$("de.esolutions.graphics.eal.api.ITextLayoutSection$hinting_t")) : class$de$esolutions$graphics$eal$api$ITextLayoutSection$hinting_t) + " with value " + n);
        }

        private hinting_t(String string) {
            this.swigName = string;
            this.swigValue = swigNext++;
        }

        private hinting_t(String string, int n) {
            this.swigName = string;
            this.swigValue = n;
            swigNext = n + 1;
        }

        private hinting_t(String string, hinting_t hinting_t2) {
            this.swigName = string;
            this.swigValue = hinting_t2.swigValue;
            swigNext = this.swigValue + 1;
        }
    }

    public static final class alignment_t {
        public static final alignment_t LEFTALIGNED = new alignment_t("LEFTALIGNED");
        public static final alignment_t RIGHTALIGNED = new alignment_t("RIGHTALIGNED");
        public static final alignment_t CENTERALIGNED = new alignment_t("CENTERALIGNED");
        public static final alignment_t JUSTIFIED = new alignment_t("JUSTIFIED");
        private static alignment_t[] swigValues = new alignment_t[]{LEFTALIGNED, RIGHTALIGNED, CENTERALIGNED, JUSTIFIED};
        private static int swigNext = 0;
        private final int swigValue;
        private final String swigName;

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static alignment_t swigToEnum(int n) {
            if (n < swigValues.length && n >= 0 && alignment_t.swigValues[n].swigValue == n) {
                return swigValues[n];
            }
            for (int i2 = 0; i2 < swigValues.length; ++i2) {
                if (alignment_t.swigValues[i2].swigValue != n) continue;
                return swigValues[i2];
            }
            throw new IllegalArgumentException("No enum " + (class$de$esolutions$graphics$eal$api$ITextLayoutSection$alignment_t == null ? (class$de$esolutions$graphics$eal$api$ITextLayoutSection$alignment_t = ITextLayoutSection.class$("de.esolutions.graphics.eal.api.ITextLayoutSection$alignment_t")) : class$de$esolutions$graphics$eal$api$ITextLayoutSection$alignment_t) + " with value " + n);
        }

        private alignment_t(String string) {
            this.swigName = string;
            this.swigValue = swigNext++;
        }

        private alignment_t(String string, int n) {
            this.swigName = string;
            this.swigValue = n;
            swigNext = n + 1;
        }

        private alignment_t(String string, alignment_t alignment_t2) {
            this.swigName = string;
            this.swigValue = alignment_t2.swigValue;
            swigNext = this.swigValue + 1;
        }
    }

    public static final class lineExtender_t {
        public static final lineExtender_t NOEXTENDER = new lineExtender_t("NOEXTENDER");
        public static final lineExtender_t HYPHENEXTENDER = new lineExtender_t("HYPHENEXTENDER");
        public static final lineExtender_t USEREXTENDER = new lineExtender_t("USEREXTENDER");
        public static final lineExtender_t WORDEXTENDER = new lineExtender_t("WORDEXTENDER");
        public static final lineExtender_t UNICODELINEBREAK = new lineExtender_t("UNICODELINEBREAK");
        private static lineExtender_t[] swigValues = new lineExtender_t[]{NOEXTENDER, HYPHENEXTENDER, USEREXTENDER, WORDEXTENDER, UNICODELINEBREAK};
        private static int swigNext = 0;
        private final int swigValue;
        private final String swigName;

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static lineExtender_t swigToEnum(int n) {
            if (n < swigValues.length && n >= 0 && lineExtender_t.swigValues[n].swigValue == n) {
                return swigValues[n];
            }
            for (int i2 = 0; i2 < swigValues.length; ++i2) {
                if (lineExtender_t.swigValues[i2].swigValue != n) continue;
                return swigValues[i2];
            }
            throw new IllegalArgumentException("No enum " + (class$de$esolutions$graphics$eal$api$ITextLayoutSection$lineExtender_t == null ? (class$de$esolutions$graphics$eal$api$ITextLayoutSection$lineExtender_t = ITextLayoutSection.class$("de.esolutions.graphics.eal.api.ITextLayoutSection$lineExtender_t")) : class$de$esolutions$graphics$eal$api$ITextLayoutSection$lineExtender_t) + " with value " + n);
        }

        private lineExtender_t(String string) {
            this.swigName = string;
            this.swigValue = swigNext++;
        }

        private lineExtender_t(String string, int n) {
            this.swigName = string;
            this.swigValue = n;
            swigNext = n + 1;
        }

        private lineExtender_t(String string, lineExtender_t lineExtender_t2) {
            this.swigName = string;
            this.swigValue = lineExtender_t2.swigValue;
            swigNext = this.swigValue + 1;
        }
    }
}

