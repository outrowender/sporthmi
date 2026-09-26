/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.utility;

import de.esolutions.graphics.ealswigJNI;

public class CInterpolatorAccelerated {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public CInterpolatorAccelerated(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(CInterpolatorAccelerated cInterpolatorAccelerated) {
        return cInterpolatorAccelerated == null ? 0L : cInterpolatorAccelerated.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_utility_CInterpolatorAccelerated(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public CInterpolatorAccelerated() {
        this(ealswigJNI.new_eal_utility_CInterpolatorAccelerated__SWIG_0(), true);
    }

    public CInterpolatorAccelerated(float f2, float f3, float f4, float f5, float f6, float f7) {
        this(ealswigJNI.new_eal_utility_CInterpolatorAccelerated__SWIG_1(f2, f3, f4, f5, f6, f7), true);
    }

    public float evaluate() {
        return ealswigJNI.eal_utility_CInterpolatorAccelerated_evaluate(this.swigCPtr, this);
    }

    public boolean isFinished() {
        return ealswigJNI.eal_utility_CInterpolatorAccelerated_isFinished(this.swigCPtr, this);
    }

    public void start() {
        ealswigJNI.eal_utility_CInterpolatorAccelerated_start(this.swigCPtr, this);
    }

    public void setStart(float f2) {
        ealswigJNI.eal_utility_CInterpolatorAccelerated_setStart(this.swigCPtr, this, f2);
    }

    public void setEnd(float f2) {
        ealswigJNI.eal_utility_CInterpolatorAccelerated_setEnd(this.swigCPtr, this, f2);
    }

    public float getStart() {
        return ealswigJNI.eal_utility_CInterpolatorAccelerated_getStart(this.swigCPtr, this);
    }

    public float getEnd() {
        return ealswigJNI.eal_utility_CInterpolatorAccelerated_getEnd(this.swigCPtr, this);
    }

    public float getLowerBound() {
        return ealswigJNI.eal_utility_CInterpolatorAccelerated_getLowerBound(this.swigCPtr, this);
    }

    public float getUpperBound() {
        return ealswigJNI.eal_utility_CInterpolatorAccelerated_getUpperBound(this.swigCPtr, this);
    }

    public void setLowerBound(float f2) {
        ealswigJNI.eal_utility_CInterpolatorAccelerated_setLowerBound(this.swigCPtr, this, f2);
    }

    public void setUpperBound(float f2) {
        ealswigJNI.eal_utility_CInterpolatorAccelerated_setUpperBound(this.swigCPtr, this, f2);
    }

    public void setAccelerationMax(float f2) {
        ealswigJNI.eal_utility_CInterpolatorAccelerated_setAccelerationMax(this.swigCPtr, this, f2);
    }

    public void setSpeedMax(float f2) {
        ealswigJNI.eal_utility_CInterpolatorAccelerated_setSpeedMax(this.swigCPtr, this, f2);
    }

    public float getAccelerationMax() {
        return ealswigJNI.eal_utility_CInterpolatorAccelerated_getAccelerationMax(this.swigCPtr, this);
    }

    public float getSpeedMax() {
        return ealswigJNI.eal_utility_CInterpolatorAccelerated_getSpeedMax(this.swigCPtr, this);
    }
}

