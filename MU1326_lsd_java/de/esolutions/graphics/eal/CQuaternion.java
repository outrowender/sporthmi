/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.eal.CMatrix4x4f;
import de.esolutions.graphics.eal.Mat4f;
import de.esolutions.graphics.eal.Vec3f;
import de.esolutions.graphics.ealswigJNI;

public class CQuaternion {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public CQuaternion(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(CQuaternion cQuaternion) {
        return cQuaternion == null ? 0L : cQuaternion.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_CQuaternion(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public CQuaternion() {
        this(ealswigJNI.new_eal_CQuaternion__SWIG_0(), true);
    }

    public CQuaternion(Vec3f vec3f, float f2) {
        this(ealswigJNI.new_eal_CQuaternion__SWIG_1(Vec3f.getCPtr(vec3f), vec3f, f2), true);
    }

    public CQuaternion(Mat4f mat4f) {
        this(ealswigJNI.new_eal_CQuaternion__SWIG_2(Mat4f.getCPtr(mat4f), mat4f), true);
    }

    public static CQuaternion createIdentity() {
        return new CQuaternion(ealswigJNI.eal_CQuaternion_createIdentity(), true);
    }

    public void normalize() {
        ealswigJNI.eal_CQuaternion_normalize(this.swigCPtr, this);
    }

    public void inverse() {
        ealswigJNI.eal_CQuaternion_inverse(this.swigCPtr, this);
    }

    public CQuaternion slerp(CQuaternion cQuaternion, float f2) {
        return new CQuaternion(ealswigJNI.eal_CQuaternion_slerp(this.swigCPtr, this, CQuaternion.getCPtr(cQuaternion), cQuaternion, f2), true);
    }

    public CMatrix4x4f toMatrix4x4() {
        return new CMatrix4x4f(ealswigJNI.eal_CQuaternion_toMatrix4x4(this.swigCPtr, this), true);
    }

    public Mat4f toMatrix() {
        return new Mat4f(ealswigJNI.eal_CQuaternion_toMatrix(this.swigCPtr, this), true);
    }
}

