/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.eal.Vec3f;
import de.esolutions.graphics.ealswigJNI;

public class Vec2f {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public Vec2f(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(Vec2f vec2f) {
        return vec2f == null ? 0L : vec2f.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_Vec2f(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public Vec2f() {
        this(ealswigJNI.new_eal_Vec2f__SWIG_0(), true);
    }

    public Vec2f(float f2, float f3) {
        this(ealswigJNI.new_eal_Vec2f__SWIG_1(f2, f3), true);
    }

    public Vec2f(float f2) {
        this(ealswigJNI.new_eal_Vec2f__SWIG_2(f2), true);
    }

    public Vec2f(Vec2f vec2f) {
        this(ealswigJNI.new_eal_Vec2f__SWIG_3(Vec2f.getCPtr(vec2f), vec2f), true);
    }

    public Vec2f(Vec3f vec3f) {
        this(ealswigJNI.new_eal_Vec2f__SWIG_4(Vec3f.getCPtr(vec3f), vec3f), true);
    }

    public Vec2f(Vec3f vec3f, int n) {
        this(ealswigJNI.new_eal_Vec2f__SWIG_5(Vec3f.getCPtr(vec3f), vec3f, n), true);
    }

    public float X() {
        return ealswigJNI.eal_Vec2f_X__SWIG_0(this.swigCPtr, this);
    }

    public float Y() {
        return ealswigJNI.eal_Vec2f_Y__SWIG_0(this.swigCPtr, this);
    }

    public float Length() {
        return ealswigJNI.eal_Vec2f_Length(this.swigCPtr, this);
    }

    public float Length2() {
        return ealswigJNI.eal_Vec2f_Length2(this.swigCPtr, this);
    }

    public Vec2f Normalize() {
        return new Vec2f(ealswigJNI.eal_Vec2f_Normalize(this.swigCPtr, this), false);
    }

    public static float GetEpsilon() {
        return ealswigJNI.eal_Vec2f_GetEpsilon();
    }

    public static void SetEpsilon(float f2) {
        ealswigJNI.eal_Vec2f_SetEpsilon(f2);
    }
}

