/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.eal.api.ITextLayoutSection;
import de.esolutions.graphics.ealswigJNI;

public class FlagFontStyle {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public FlagFontStyle(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(FlagFontStyle flagFontStyle) {
        return flagFontStyle == null ? 0L : flagFontStyle.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_FlagFontStyle(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public FlagFontStyle() {
        this(ealswigJNI.new_eal_FlagFontStyle__SWIG_0(), true);
    }

    public FlagFontStyle(ITextLayoutSection.style_t style_t2) {
        this(ealswigJNI.new_eal_FlagFontStyle__SWIG_1(style_t2.swigValue()), true);
    }

    public FlagFontStyle(long l) {
        this(ealswigJNI.new_eal_FlagFontStyle__SWIG_2(l), true);
    }

    public long getFlagValue() {
        return ealswigJNI.eal_FlagFontStyle_getFlagValue(this.swigCPtr, this);
    }

    public void setFlag(ITextLayoutSection.style_t style_t2) {
        ealswigJNI.eal_FlagFontStyle_setFlag(this.swigCPtr, this, style_t2.swigValue());
    }

    public boolean isFlag(ITextLayoutSection.style_t style_t2) {
        return ealswigJNI.eal_FlagFontStyle_isFlag(this.swigCPtr, this, style_t2.swigValue());
    }

    public void reset() {
        ealswigJNI.eal_FlagFontStyle_reset(this.swigCPtr, this);
    }

    public void resetPos(long l) {
        ealswigJNI.eal_FlagFontStyle_resetPos(this.swigCPtr, this, l);
    }

    public void unsetFlag(ITextLayoutSection.style_t style_t2) {
        ealswigJNI.eal_FlagFontStyle_unsetFlag(this.swigCPtr, this, style_t2.swigValue());
    }

    public void setFlagValue(long l) {
        ealswigJNI.eal_FlagFontStyle_setFlagValue(this.swigCPtr, this, l);
    }

    public long getHexValueAtPos(long l) {
        return ealswigJNI.eal_FlagFontStyle_getHexValueAtPos(this.swigCPtr, this, l);
    }

    public long extractPosition(long l) {
        return ealswigJNI.eal_FlagFontStyle_extractPosition(this.swigCPtr, this, l);
    }

    public long getByMask(long l) {
        return ealswigJNI.eal_FlagFontStyle_getByMask(this.swigCPtr, this, l);
    }

    public boolean equal(long l) {
        return ealswigJNI.eal_FlagFontStyle_equal__SWIG_0(this.swigCPtr, this, l);
    }

    public boolean equal(ITextLayoutSection.style_t style_t2) {
        return ealswigJNI.eal_FlagFontStyle_equal__SWIG_1(this.swigCPtr, this, style_t2.swigValue());
    }

    public boolean unequal(long l) {
        return ealswigJNI.eal_FlagFontStyle_unequal__SWIG_0(this.swigCPtr, this, l);
    }

    public boolean unequal(ITextLayoutSection.style_t style_t2) {
        return ealswigJNI.eal_FlagFontStyle_unequal__SWIG_1(this.swigCPtr, this, style_t2.swigValue());
    }

    public boolean contains(ITextLayoutSection.style_t style_t2) {
        return ealswigJNI.eal_FlagFontStyle_contains__SWIG_0(this.swigCPtr, this, style_t2.swigValue());
    }

    public boolean contains(FlagFontStyle flagFontStyle) {
        return ealswigJNI.eal_FlagFontStyle_contains__SWIG_1(this.swigCPtr, this, FlagFontStyle.getCPtr(flagFontStyle), flagFontStyle);
    }
}

