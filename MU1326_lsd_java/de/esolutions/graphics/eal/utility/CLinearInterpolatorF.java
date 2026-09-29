/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.utility;

import de.esolutions.graphics.ealswigJNI;
import de.esolutions.graphics.ipl.VectorF;

public class CLinearInterpolatorF {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public CLinearInterpolatorF(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(CLinearInterpolatorF cLinearInterpolatorF) {
        return cLinearInterpolatorF == null ? 0L : cLinearInterpolatorF.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_utility_CLinearInterpolatorF(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public CLinearInterpolatorF() {
        this(ealswigJNI.new_eal_utility_CLinearInterpolatorF__SWIG_0(), true);
    }

    public CLinearInterpolatorF(VectorF vectorF, long l) {
        this(ealswigJNI.new_eal_utility_CLinearInterpolatorF__SWIG_1(VectorF.getCPtr(vectorF), vectorF, l), true);
    }

    public float evaluate() {
        return ealswigJNI.eal_utility_CLinearInterpolatorF_evaluate(this.swigCPtr, this);
    }

    public boolean isFinished() {
        return ealswigJNI.eal_utility_CLinearInterpolatorF_isFinished(this.swigCPtr, this);
    }

    public void setKnots(VectorF vectorF) {
        ealswigJNI.eal_utility_CLinearInterpolatorF_setKnots(this.swigCPtr, this, VectorF.getCPtr(vectorF), vectorF);
    }

    public void setAnimationTime(long l) {
        ealswigJNI.eal_utility_CLinearInterpolatorF_setAnimationTime(this.swigCPtr, this, l);
    }
}

