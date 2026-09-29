/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.eal.Vec2f;
import de.esolutions.graphics.eal.Vec3f;
import de.esolutions.graphics.ealswigJNI;

public class Mat3f {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public Mat3f(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(Mat3f mat3f) {
        return mat3f == null ? 0L : mat3f.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_Mat3f(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public Mat3f() {
        this(ealswigJNI.new_eal_Mat3f__SWIG_0(), true);
    }

    public Mat3f(Vec3f vec3f, Vec3f vec3f2, Vec3f vec3f3) {
        this(ealswigJNI.new_eal_Mat3f__SWIG_1(Vec3f.getCPtr(vec3f), vec3f, Vec3f.getCPtr(vec3f2), vec3f2, Vec3f.getCPtr(vec3f3), vec3f3), true);
    }

    public Mat3f(float f2) {
        this(ealswigJNI.new_eal_Mat3f__SWIG_2(f2), true);
    }

    public Mat3f(Mat3f mat3f) {
        this(ealswigJNI.new_eal_Mat3f__SWIG_3(Mat3f.getCPtr(mat3f), mat3f), true);
    }

    public Mat3f Transpose() {
        return new Mat3f(ealswigJNI.eal_Mat3f_Transpose(this.swigCPtr, this), true);
    }

    public Mat3f Inverse() {
        return new Mat3f(ealswigJNI.eal_Mat3f_Inverse(this.swigCPtr, this), true);
    }

    public Vec3f GetColumn(int n) {
        return new Vec3f(ealswigJNI.eal_Mat3f_GetColumn(this.swigCPtr, this, n), true);
    }

    public Mat3f Mult(Mat3f mat3f) {
        return new Mat3f(ealswigJNI.eal_Mat3f_Mult(this.swigCPtr, this, Mat3f.getCPtr(mat3f), mat3f), false);
    }

    public static Mat3f GetIdentity() {
        return new Mat3f(ealswigJNI.eal_Mat3f_GetIdentity(), true);
    }

    public static Mat3f GetTransMat(Vec2f vec2f) {
        return new Mat3f(ealswigJNI.eal_Mat3f_GetTransMat(Vec2f.getCPtr(vec2f), vec2f), true);
    }

    public static Mat3f GetRotMat(Vec2f vec2f, float f2) {
        return new Mat3f(ealswigJNI.eal_Mat3f_GetRotMat(Vec2f.getCPtr(vec2f), vec2f, f2), true);
    }

    public static Mat3f GetScaleMat(Vec2f vec2f) {
        return new Mat3f(ealswigJNI.eal_Mat3f_GetScaleMat(Vec2f.getCPtr(vec2f), vec2f), true);
    }

    public Vec3f GetEigenvector(float f2) {
        return new Vec3f(ealswigJNI.eal_Mat3f_GetEigenvector(this.swigCPtr, this, f2), true);
    }
}

