/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.utility;

import de.esolutions.graphics.ealswigJNI;
import de.esolutions.graphics.ipl.VectorD;

public class CLinearInterpolatorD {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public CLinearInterpolatorD(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(CLinearInterpolatorD cLinearInterpolatorD) {
        return cLinearInterpolatorD == null ? 0L : cLinearInterpolatorD.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_utility_CLinearInterpolatorD(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public CLinearInterpolatorD() {
        this(ealswigJNI.new_eal_utility_CLinearInterpolatorD__SWIG_0(), true);
    }

    public CLinearInterpolatorD(VectorD vectorD, long l) {
        this(ealswigJNI.new_eal_utility_CLinearInterpolatorD__SWIG_1(VectorD.getCPtr(vectorD), vectorD, l), true);
    }

    public double evaluate() {
        return ealswigJNI.eal_utility_CLinearInterpolatorD_evaluate(this.swigCPtr, this);
    }

    public boolean isFinished() {
        return ealswigJNI.eal_utility_CLinearInterpolatorD_isFinished(this.swigCPtr, this);
    }

    public void setKnots(VectorD vectorD) {
        ealswigJNI.eal_utility_CLinearInterpolatorD_setKnots(this.swigCPtr, this, VectorD.getCPtr(vectorD), vectorD);
    }

    public void setAnimationTime(long l) {
        ealswigJNI.eal_utility_CLinearInterpolatorD_setAnimationTime(this.swigCPtr, this, l);
    }
}

