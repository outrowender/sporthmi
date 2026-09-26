/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.ealswigJNI;

public class colorRGBAf {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public colorRGBAf(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(colorRGBAf colorRGBAf2) {
        return colorRGBAf2 == null ? 0L : colorRGBAf2.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_colorRGBAf(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public void setFRed(float f2) {
        ealswigJNI.eal_colorRGBAf_fRed_set(this.swigCPtr, this, f2);
    }

    public float getFRed() {
        return ealswigJNI.eal_colorRGBAf_fRed_get(this.swigCPtr, this);
    }

    public void setFGreen(float f2) {
        ealswigJNI.eal_colorRGBAf_fGreen_set(this.swigCPtr, this, f2);
    }

    public float getFGreen() {
        return ealswigJNI.eal_colorRGBAf_fGreen_get(this.swigCPtr, this);
    }

    public void setFBlue(float f2) {
        ealswigJNI.eal_colorRGBAf_fBlue_set(this.swigCPtr, this, f2);
    }

    public float getFBlue() {
        return ealswigJNI.eal_colorRGBAf_fBlue_get(this.swigCPtr, this);
    }

    public void setFAlpha(float f2) {
        ealswigJNI.eal_colorRGBAf_fAlpha_set(this.swigCPtr, this, f2);
    }

    public float getFAlpha() {
        return ealswigJNI.eal_colorRGBAf_fAlpha_get(this.swigCPtr, this);
    }

    public colorRGBAf() {
        this(ealswigJNI.new_eal_colorRGBAf__SWIG_0(), true);
    }

    public colorRGBAf(float f2, float f3, float f4, float f5) {
        this(ealswigJNI.new_eal_colorRGBAf__SWIG_1(f2, f3, f4, f5), true);
    }
}

