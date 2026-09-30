/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.Mat4f;
import de.esolutions.graphics.eal.Vec3f;
import de.esolutions.graphics.eal.api.IManager;
import de.esolutions.graphics.eal.api.INode;
import de.esolutions.graphics.ealswigJNI;

public class INode3D
extends INode {
    private long swigCPtr;

    public INode3D(long l, boolean bl) {
        super(ealswigJNI.eal_api_INode3D_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(INode3D iNode3D) {
        return iNode3D == null ? 0L : iNode3D.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_api_INode3D(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public INode3D(INode iNode) {
        this(ealswigJNI.new_eal_api_INode3D__SWIG_0(INode.getCPtr(iNode), iNode), true);
    }

    public INode3D(IManager iManager, String string) {
        this(ealswigJNI.new_eal_api_INode3D__SWIG_1(IManager.getCPtr(iManager), iManager, string), true);
    }

    public boolean scale(float f2) {
        return ealswigJNI.eal_api_INode3D_scale__SWIG_0(this.swigCPtr, this, f2);
    }

    public boolean scale(float f2, float f3, float f4) {
        return ealswigJNI.eal_api_INode3D_scale__SWIG_1(this.swigCPtr, this, f2, f3, f4);
    }

    public boolean setScale(float f2) {
        return ealswigJNI.eal_api_INode3D_setScale__SWIG_0(this.swigCPtr, this, f2);
    }

    public boolean setScale(float f2, float f3, float f4) {
        return ealswigJNI.eal_api_INode3D_setScale__SWIG_1(this.swigCPtr, this, f2, f3, f4);
    }

    public boolean translate(float f2, float f3, float f4) {
        return ealswigJNI.eal_api_INode3D_translate(this.swigCPtr, this, f2, f3, f4);
    }

    public boolean setTranslation(float f2, float f3, float f4) {
        return ealswigJNI.eal_api_INode3D_setTranslation(this.swigCPtr, this, f2, f3, f4);
    }

    public Vec3f getTranslation() {
        return new Vec3f(ealswigJNI.eal_api_INode3D_getTranslation(this.swigCPtr, this), true);
    }

    public float getTranslationX() {
        return ealswigJNI.eal_api_INode3D_getTranslationX(this.swigCPtr, this);
    }

    public float getTranslationY() {
        return ealswigJNI.eal_api_INode3D_getTranslationY(this.swigCPtr, this);
    }

    public float getTranslationZ() {
        return ealswigJNI.eal_api_INode3D_getTranslationZ(this.swigCPtr, this);
    }

    public boolean rotate(float f2, float f3, float f4, float f5) {
        return ealswigJNI.eal_api_INode3D_rotate(this.swigCPtr, this, f2, f3, f4, f5);
    }

    public boolean rotateX(float f2) {
        return ealswigJNI.eal_api_INode3D_rotateX(this.swigCPtr, this, f2);
    }

    public boolean rotateY(float f2) {
        return ealswigJNI.eal_api_INode3D_rotateY(this.swigCPtr, this, f2);
    }

    public boolean rotateZ(float f2) {
        return ealswigJNI.eal_api_INode3D_rotateZ(this.swigCPtr, this, f2);
    }

    public boolean setRotation(float f2, float f3, float f4, float f5) {
        return ealswigJNI.eal_api_INode3D_setRotation(this.swigCPtr, this, f2, f3, f4, f5);
    }

    public boolean setRotationXYZ(float f2, float f3, float f4) {
        return ealswigJNI.eal_api_INode3D_setRotationXYZ(this.swigCPtr, this, f2, f3, f4);
    }

    public boolean add(INode3D iNode3D) {
        return ealswigJNI.eal_api_INode3D_add__SWIG_0(this.swigCPtr, this, INode3D.getCPtr(iNode3D), iNode3D);
    }

    public boolean add(INode3D iNode3D, long l) {
        return ealswigJNI.eal_api_INode3D_add__SWIG_1(this.swigCPtr, this, INode3D.getCPtr(iNode3D), iNode3D, l);
    }

    public boolean addByIndex(INode3D iNode3D, int n) {
        return ealswigJNI.eal_api_INode3D_addByIndex(this.swigCPtr, this, INode3D.getCPtr(iNode3D), iNode3D, n);
    }

    public INode3D getChildByIndex(int n) {
        long l = ealswigJNI.eal_api_INode3D_getChildByIndex(this.swigCPtr, this, n);
        return l == 0L ? null : new INode3D(l, true);
    }

    public Vec3f getScale() {
        return new Vec3f(ealswigJNI.eal_api_INode3D_getScale(this.swigCPtr, this), true);
    }

    public float getScaleX() {
        return ealswigJNI.eal_api_INode3D_getScaleX(this.swigCPtr, this);
    }

    public float getScaleY() {
        return ealswigJNI.eal_api_INode3D_getScaleY(this.swigCPtr, this);
    }

    public float getScaleZ() {
        return ealswigJNI.eal_api_INode3D_getScaleZ(this.swigCPtr, this);
    }

    public Mat4f getTransformation() {
        return new Mat4f(ealswigJNI.eal_api_INode3D_getTransformation(this.swigCPtr, this), true);
    }

    public boolean setTransformation(Mat4f mat4f) {
        return ealswigJNI.eal_api_INode3D_setTransformation(this.swigCPtr, this, Mat4f.getCPtr(mat4f), mat4f);
    }

    public INode3D getParent() {
        long l = ealswigJNI.eal_api_INode3D_getParent(this.swigCPtr, this);
        return l == 0L ? null : new INode3D(l, true);
    }

    public INode3D getChildAtIndex(long l) {
        long l2 = ealswigJNI.eal_api_INode3D_getChildAtIndex(this.swigCPtr, this, l);
        return l2 == 0L ? null : new INode3D(l2, true);
    }

    public INode3D getChildByName(String string) {
        long l = ealswigJNI.eal_api_INode3D_getChildByName(this.swigCPtr, this, string);
        return l == 0L ? null : new INode3D(l, true);
    }

    public boolean clip(float f2, float f3, float f4, float f5) {
        return ealswigJNI.eal_api_INode3D_clip(this.swigCPtr, this, f2, f3, f4, f5);
    }

    public boolean disableClip() {
        return ealswigJNI.eal_api_INode3D_disableClip(this.swigCPtr, this);
    }

    public boolean setDepthTest(boolean bl) {
        return ealswigJNI.eal_api_INode3D_setDepthTest(this.swigCPtr, this, bl);
    }

    public boolean resetTransformations() {
        return ealswigJNI.eal_api_INode3D_resetTransformations(this.swigCPtr, this);
    }

    public void dispose() {
        ealswigJNI.eal_api_INode3D_dispose(this.swigCPtr, this);
    }

    public boolean move(INode3D iNode3D) {
        return ealswigJNI.eal_api_INode3D_move(this.swigCPtr, this, INode3D.getCPtr(iNode3D), iNode3D);
    }
}

