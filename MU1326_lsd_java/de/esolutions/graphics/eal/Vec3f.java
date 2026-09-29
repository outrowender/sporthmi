/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.eal.Vec2f;
import de.esolutions.graphics.eal.Vec4f;
import de.esolutions.graphics.ealswigJNI;

public class Vec3f {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public Vec3f(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(Vec3f vec3f) {
        return vec3f == null ? 0L : vec3f.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_Vec3f(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public Vec3f() {
        this(ealswigJNI.new_eal_Vec3f__SWIG_0(), true);
    }

    public Vec3f(float f2, float f3, float f4) {
        this(ealswigJNI.new_eal_Vec3f__SWIG_1(f2, f3, f4), true);
    }

    public Vec3f(float f2) {
        this(ealswigJNI.new_eal_Vec3f__SWIG_2(f2), true);
    }

    public Vec3f(Vec3f vec3f) {
        this(ealswigJNI.new_eal_Vec3f__SWIG_3(Vec3f.getCPtr(vec3f), vec3f), true);
    }

    public Vec3f(Vec2f vec2f) {
        this(ealswigJNI.new_eal_Vec3f__SWIG_4(Vec2f.getCPtr(vec2f), vec2f), true);
    }

    public Vec3f(Vec2f vec2f, float f2) {
        this(ealswigJNI.new_eal_Vec3f__SWIG_5(Vec2f.getCPtr(vec2f), vec2f, f2), true);
    }

    public Vec3f(Vec4f vec4f) {
        this(ealswigJNI.new_eal_Vec3f__SWIG_6(Vec4f.getCPtr(vec4f), vec4f), true);
    }

    public Vec3f(Vec4f vec4f, int n) {
        this(ealswigJNI.new_eal_Vec3f__SWIG_7(Vec4f.getCPtr(vec4f), vec4f, n), true);
    }

    public float X() {
        return ealswigJNI.eal_Vec3f_X__SWIG_0(this.swigCPtr, this);
    }

    public float Y() {
        return ealswigJNI.eal_Vec3f_Y__SWIG_0(this.swigCPtr, this);
    }

    public float Z() {
        return ealswigJNI.eal_Vec3f_Z__SWIG_0(this.swigCPtr, this);
    }

    public float Length() {
        return ealswigJNI.eal_Vec3f_Length(this.swigCPtr, this);
    }

    public float Length2() {
        return ealswigJNI.eal_Vec3f_Length2(this.swigCPtr, this);
    }

    public Vec3f Normalize() {
        return new Vec3f(ealswigJNI.eal_Vec3f_Normalize(this.swigCPtr, this), false);
    }

    public void Cross(Vec3f vec3f, Vec3f vec3f2) {
        ealswigJNI.eal_Vec3f_Cross(this.swigCPtr, this, Vec3f.getCPtr(vec3f), vec3f, Vec3f.getCPtr(vec3f2), vec3f2);
    }

    public void Sub(Vec3f vec3f, Vec3f vec3f2) {
        ealswigJNI.eal_Vec3f_Sub(this.swigCPtr, this, Vec3f.getCPtr(vec3f), vec3f, Vec3f.getCPtr(vec3f2), vec3f2);
    }

    public void Add(Vec3f vec3f, Vec3f vec3f2) {
        ealswigJNI.eal_Vec3f_Add(this.swigCPtr, this, Vec3f.getCPtr(vec3f), vec3f, Vec3f.getCPtr(vec3f2), vec3f2);
    }

    public float Dot(Vec3f vec3f) {
        return ealswigJNI.eal_Vec3f_Dot(this.swigCPtr, this, Vec3f.getCPtr(vec3f), vec3f);
    }

    public static float GetEpsilon() {
        return ealswigJNI.eal_Vec3f_GetEpsilon();
    }

    public static void SetEpsilon(float f2) {
        ealswigJNI.eal_Vec3f_SetEpsilon(f2);
    }
}

