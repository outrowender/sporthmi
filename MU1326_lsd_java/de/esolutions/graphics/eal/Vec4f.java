/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.eal.Vec3f;
import de.esolutions.graphics.ealswigJNI;

public class Vec4f {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public Vec4f(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(Vec4f vec4f) {
        return vec4f == null ? 0L : vec4f.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_Vec4f(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public Vec4f() {
        this(ealswigJNI.new_eal_Vec4f__SWIG_0(), true);
    }

    public Vec4f(float f2, float f3, float f4, float f5) {
        this(ealswigJNI.new_eal_Vec4f__SWIG_1(f2, f3, f4, f5), true);
    }

    public Vec4f(float f2) {
        this(ealswigJNI.new_eal_Vec4f__SWIG_2(f2), true);
    }

    public Vec4f(Vec4f vec4f) {
        this(ealswigJNI.new_eal_Vec4f__SWIG_3(Vec4f.getCPtr(vec4f), vec4f), true);
    }

    public Vec4f(Vec3f vec3f) {
        this(ealswigJNI.new_eal_Vec4f__SWIG_4(Vec3f.getCPtr(vec3f), vec3f), true);
    }

    public Vec4f(Vec3f vec3f, float f2) {
        this(ealswigJNI.new_eal_Vec4f__SWIG_5(Vec3f.getCPtr(vec3f), vec3f, f2), true);
    }

    public float X() {
        return ealswigJNI.eal_Vec4f_X__SWIG_0(this.swigCPtr, this);
    }

    public float Y() {
        return ealswigJNI.eal_Vec4f_Y__SWIG_0(this.swigCPtr, this);
    }

    public float Z() {
        return ealswigJNI.eal_Vec4f_Z__SWIG_0(this.swigCPtr, this);
    }

    public float W() {
        return ealswigJNI.eal_Vec4f_W__SWIG_0(this.swigCPtr, this);
    }

    public float Length() {
        return ealswigJNI.eal_Vec4f_Length(this.swigCPtr, this);
    }

    public float Length2() {
        return ealswigJNI.eal_Vec4f_Length2(this.swigCPtr, this);
    }

    public Vec4f Normalize() {
        return new Vec4f(ealswigJNI.eal_Vec4f_Normalize(this.swigCPtr, this), false);
    }

    public float GetEpsilon() {
        return ealswigJNI.eal_Vec4f_GetEpsilon(this.swigCPtr, this);
    }

    public void SetEpsilon(float f2) {
        ealswigJNI.eal_Vec4f_SetEpsilon(this.swigCPtr, this, f2);
    }
}

