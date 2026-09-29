/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.eal.Vec3f;
import de.esolutions.graphics.eal.Vec4f;
import de.esolutions.graphics.ealswigJNI;

public class Mat4f {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public Mat4f(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(Mat4f mat4f) {
        return mat4f == null ? 0L : mat4f.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_Mat4f(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public Mat4f() {
        this(ealswigJNI.new_eal_Mat4f__SWIG_0(), true);
    }

    public Mat4f(Vec4f vec4f, Vec4f vec4f2, Vec4f vec4f3, Vec4f vec4f4) {
        this(ealswigJNI.new_eal_Mat4f__SWIG_1(Vec4f.getCPtr(vec4f), vec4f, Vec4f.getCPtr(vec4f2), vec4f2, Vec4f.getCPtr(vec4f3), vec4f3, Vec4f.getCPtr(vec4f4), vec4f4), true);
    }

    public Mat4f(float f2) {
        this(ealswigJNI.new_eal_Mat4f__SWIG_2(f2), true);
    }

    public Mat4f(Mat4f mat4f) {
        this(ealswigJNI.new_eal_Mat4f__SWIG_3(Mat4f.getCPtr(mat4f), mat4f), true);
    }

    public Mat4f Transpose() {
        return new Mat4f(ealswigJNI.eal_Mat4f_Transpose(this.swigCPtr, this), true);
    }

    public Mat4f Inverse() {
        return new Mat4f(ealswigJNI.eal_Mat4f_Inverse(this.swigCPtr, this), true);
    }

    public static Mat4f GetIdentity() {
        return new Mat4f(ealswigJNI.eal_Mat4f_GetIdentity(), true);
    }

    public static Mat4f GetTransMat(Vec3f vec3f) {
        return new Mat4f(ealswigJNI.eal_Mat4f_GetTransMat(Vec3f.getCPtr(vec3f), vec3f), true);
    }

    public static Mat4f GetRotMat(Vec3f vec3f, float f2) {
        return new Mat4f(ealswigJNI.eal_Mat4f_GetRotMat(Vec3f.getCPtr(vec3f), vec3f, f2), true);
    }

    public static Mat4f GetScaleMat(Vec3f vec3f) {
        return new Mat4f(ealswigJNI.eal_Mat4f_GetScaleMat(Vec3f.getCPtr(vec3f), vec3f), true);
    }

    public static Mat4f GetPerspMat(float f2) {
        return new Mat4f(ealswigJNI.eal_Mat4f_GetPerspMat(f2), true);
    }

    public static Mat4f GetRotationVecFromIntoTo(Vec3f vec3f, Vec3f vec3f2) {
        return new Mat4f(ealswigJNI.eal_Mat4f_GetRotationVecFromIntoTo(Vec3f.getCPtr(vec3f), vec3f, Vec3f.getCPtr(vec3f2), vec3f2), true);
    }
}

