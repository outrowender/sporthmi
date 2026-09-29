/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.utility;

import de.esolutions.graphics.ealswigJNI;

public class CLerpD {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public CLerpD(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(CLerpD cLerpD) {
        return cLerpD == null ? 0L : cLerpD.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_utility_CLerpD(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public CLerpD() {
        this(ealswigJNI.new_eal_utility_CLerpD__SWIG_0(), true);
    }

    public CLerpD(double d2, double d3, long l) {
        this(ealswigJNI.new_eal_utility_CLerpD__SWIG_1(d2, d3, l), true);
    }

    public void start() {
        ealswigJNI.eal_utility_CLerpD_start(this.swigCPtr, this);
    }

    public double evaluate() {
        return ealswigJNI.eal_utility_CLerpD_evaluate(this.swigCPtr, this);
    }

    public boolean isFinished() {
        return ealswigJNI.eal_utility_CLerpD_isFinished(this.swigCPtr, this);
    }

    public void setStart(double d2) {
        ealswigJNI.eal_utility_CLerpD_setStart(this.swigCPtr, this, d2);
    }

    public void setEnd(double d2) {
        ealswigJNI.eal_utility_CLerpD_setEnd(this.swigCPtr, this, d2);
    }

    public void setStartEnd(double d2, double d3) {
        ealswigJNI.eal_utility_CLerpD_setStartEnd(this.swigCPtr, this, d2, d3);
    }

    public void setDuration(long l) {
        ealswigJNI.eal_utility_CLerpD_setDuration(this.swigCPtr, this, l);
    }

    public double getStart() {
        return ealswigJNI.eal_utility_CLerpD_getStart(this.swigCPtr, this);
    }

    public double getEnd() {
        return ealswigJNI.eal_utility_CLerpD_getEnd(this.swigCPtr, this);
    }

    public long getDuration() {
        return ealswigJNI.eal_utility_CLerpD_getDuration(this.swigCPtr, this);
    }

    public void invert() {
        ealswigJNI.eal_utility_CLerpD_invert(this.swigCPtr, this);
    }
}

