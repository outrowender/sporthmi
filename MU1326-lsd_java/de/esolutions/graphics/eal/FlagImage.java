/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.eal.imageOptions_t;
import de.esolutions.graphics.ealswigJNI;

public class FlagImage {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public FlagImage(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(FlagImage flagImage) {
        return flagImage == null ? 0L : flagImage.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_FlagImage(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public FlagImage() {
        this(ealswigJNI.new_eal_FlagImage__SWIG_0(), true);
    }

    public FlagImage(imageOptions_t imageOptions_t2) {
        this(ealswigJNI.new_eal_FlagImage__SWIG_1(imageOptions_t2.swigValue()), true);
    }

    public FlagImage(long l) {
        this(ealswigJNI.new_eal_FlagImage__SWIG_2(l), true);
    }

    public long getFlagValue() {
        return ealswigJNI.eal_FlagImage_getFlagValue(this.swigCPtr, this);
    }

    public void setFlag(imageOptions_t imageOptions_t2) {
        ealswigJNI.eal_FlagImage_setFlag(this.swigCPtr, this, imageOptions_t2.swigValue());
    }

    public boolean isFlag(imageOptions_t imageOptions_t2) {
        return ealswigJNI.eal_FlagImage_isFlag(this.swigCPtr, this, imageOptions_t2.swigValue());
    }

    public void reset() {
        ealswigJNI.eal_FlagImage_reset(this.swigCPtr, this);
    }

    public void resetPos(long l) {
        ealswigJNI.eal_FlagImage_resetPos(this.swigCPtr, this, l);
    }

    public void unsetFlag(imageOptions_t imageOptions_t2) {
        ealswigJNI.eal_FlagImage_unsetFlag(this.swigCPtr, this, imageOptions_t2.swigValue());
    }

    public void setFlagValue(long l) {
        ealswigJNI.eal_FlagImage_setFlagValue(this.swigCPtr, this, l);
    }

    public long getHexValueAtPos(long l) {
        return ealswigJNI.eal_FlagImage_getHexValueAtPos(this.swigCPtr, this, l);
    }

    public long extractPosition(long l) {
        return ealswigJNI.eal_FlagImage_extractPosition(this.swigCPtr, this, l);
    }

    public long getByMask(long l) {
        return ealswigJNI.eal_FlagImage_getByMask(this.swigCPtr, this, l);
    }

    public boolean equal(long l) {
        return ealswigJNI.eal_FlagImage_equal__SWIG_0(this.swigCPtr, this, l);
    }

    public boolean equal(imageOptions_t imageOptions_t2) {
        return ealswigJNI.eal_FlagImage_equal__SWIG_1(this.swigCPtr, this, imageOptions_t2.swigValue());
    }

    public boolean unequal(long l) {
        return ealswigJNI.eal_FlagImage_unequal__SWIG_0(this.swigCPtr, this, l);
    }

    public boolean unequal(imageOptions_t imageOptions_t2) {
        return ealswigJNI.eal_FlagImage_unequal__SWIG_1(this.swigCPtr, this, imageOptions_t2.swigValue());
    }

    public boolean contains(imageOptions_t imageOptions_t2) {
        return ealswigJNI.eal_FlagImage_contains__SWIG_0(this.swigCPtr, this, imageOptions_t2.swigValue());
    }

    public boolean contains(FlagImage flagImage) {
        return ealswigJNI.eal_FlagImage_contains__SWIG_1(this.swigCPtr, this, FlagImage.getCPtr(flagImage), flagImage);
    }
}

