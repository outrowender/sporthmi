/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.IFont;
import de.esolutions.graphics.eal.api.IObject;
import de.esolutions.graphics.eal.api.ITextLayoutSection;
import de.esolutions.graphics.ealswigJNI;

public class ITextLayout
extends IObject {
    private long swigCPtr;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$api$ITextLayout$kerning_t;

    public ITextLayout(long l, boolean bl) {
        super(ealswigJNI.eal_api_ITextLayout_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(ITextLayout iTextLayout) {
        return iTextLayout == null ? 0L : iTextLayout.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_api_ITextLayout(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public ITextLayout() {
        this(ealswigJNI.new_eal_api_ITextLayout__SWIG_0(), true);
    }

    public ITextLayout(IFont iFont, int n) {
        this(ealswigJNI.new_eal_api_ITextLayout__SWIG_1(IFont.getCPtr(iFont), iFont, n), true);
    }

    public ITextLayout(int n) {
        this(ealswigJNI.new_eal_api_ITextLayout__SWIG_2(n), true);
    }

    public boolean isValid() {
        return ealswigJNI.eal_api_ITextLayout_isValid(this.swigCPtr, this);
    }

    public void setTruncation(boolean bl) {
        ealswigJNI.eal_api_ITextLayout_setTruncation(this.swigCPtr, this, bl);
    }

    public void setMaximumSize(long l, long l2) {
        ealswigJNI.eal_api_ITextLayout_setMaximumSize(this.swigCPtr, this, l, l2);
    }

    public void setMaximumLineCount(long l) {
        ealswigJNI.eal_api_ITextLayout_setMaximumLineCount(this.swigCPtr, this, l);
    }

    public boolean setTextLayoutSectionNum(long l) {
        return ealswigJNI.eal_api_ITextLayout_setTextLayoutSectionNum(this.swigCPtr, this, l);
    }

    public ITextLayoutSection getLayoutSection(long l) {
        long l2 = ealswigJNI.eal_api_ITextLayout_getLayoutSection(this.swigCPtr, this, l);
        return l2 == 0L ? null : new ITextLayoutSection(l2, true);
    }

    public void print() {
        ealswigJNI.eal_api_ITextLayout_print(this.swigCPtr, this);
    }

    public boolean destroy() {
        return ealswigJNI.eal_api_ITextLayout_destroy(this.swigCPtr, this);
    }

    public void dispose() {
        ealswigJNI.eal_api_ITextLayout_dispose(this.swigCPtr, this);
    }

    public boolean setPreformattedText(boolean bl) {
        return ealswigJNI.eal_api_ITextLayout_setPreformattedText(this.swigCPtr, this, bl);
    }

    public boolean setKerning(kerning_t kerning_t2) {
        return ealswigJNI.eal_api_ITextLayout_setKerning(this.swigCPtr, this, kerning_t2.swigValue());
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    public static final class kerning_t {
        public static final kerning_t KERNING_OFF = new kerning_t("KERNING_OFF");
        public static final kerning_t KERNING_AUTO = new kerning_t("KERNING_AUTO");
        public static final kerning_t KERNING_GPOS = new kerning_t("KERNING_GPOS");
        public static final kerning_t KERNING_FULL = new kerning_t("KERNING_FULL");
        private static kerning_t[] swigValues = new kerning_t[]{KERNING_OFF, KERNING_AUTO, KERNING_GPOS, KERNING_FULL};
        private static int swigNext = 0;
        private final int swigValue;
        private final String swigName;

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static kerning_t swigToEnum(int n) {
            if (n < swigValues.length && n >= 0 && kerning_t.swigValues[n].swigValue == n) {
                return swigValues[n];
            }
            for (int i2 = 0; i2 < swigValues.length; ++i2) {
                if (kerning_t.swigValues[i2].swigValue != n) continue;
                return swigValues[i2];
            }
            throw new IllegalArgumentException("No enum " + (class$de$esolutions$graphics$eal$api$ITextLayout$kerning_t == null ? (class$de$esolutions$graphics$eal$api$ITextLayout$kerning_t = ITextLayout.class$("de.esolutions.graphics.eal.api.ITextLayout$kerning_t")) : class$de$esolutions$graphics$eal$api$ITextLayout$kerning_t) + " with value " + n);
        }

        private kerning_t(String string) {
            this.swigName = string;
            this.swigValue = swigNext++;
        }

        private kerning_t(String string, int n) {
            this.swigName = string;
            this.swigValue = n;
            swigNext = n + 1;
        }

        private kerning_t(String string, kerning_t kerning_t2) {
            this.swigName = string;
            this.swigValue = kerning_t2.swigValue;
            swigNext = this.swigValue + 1;
        }
    }
}

