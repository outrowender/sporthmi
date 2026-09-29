/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.FlagTexture;
import de.esolutions.graphics.eal.Mat3f;
import de.esolutions.graphics.eal.Vec2f;
import de.esolutions.graphics.eal.api.INode;
import de.esolutions.graphics.eal.api.IProject;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.graphics.eal.ealLayerPixelFormat_t;
import de.esolutions.graphics.ealswigJNI;

public class INode2D
extends INode {
    private long swigCPtr;

    public INode2D(long l, boolean bl) {
        super(ealswigJNI.eal_api_INode2D_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(INode2D iNode2D) {
        return iNode2D == null ? 0L : iNode2D.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    @Override
    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_api_INode2D(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public INode2D(INode iNode) {
        this(ealswigJNI.new_eal_api_INode2D__SWIG_0(INode.getCPtr(iNode), iNode), true);
    }

    public INode2D(IProject iProject, String string) {
        this(ealswigJNI.new_eal_api_INode2D__SWIG_1(IProject.getCPtr(iProject), iProject, string), true);
    }

    public boolean scale(float f2) {
        return ealswigJNI.eal_api_INode2D_scale__SWIG_0(this.swigCPtr, this, f2);
    }

    public boolean scale(float f2, float f3) {
        return ealswigJNI.eal_api_INode2D_scale__SWIG_1(this.swigCPtr, this, f2, f3);
    }

    public boolean setScale(float f2) {
        return ealswigJNI.eal_api_INode2D_setScale__SWIG_0(this.swigCPtr, this, f2);
    }

    public boolean setScale(float f2, float f3) {
        return ealswigJNI.eal_api_INode2D_setScale__SWIG_1(this.swigCPtr, this, f2, f3);
    }

    public boolean translate(float f2, float f3) {
        return ealswigJNI.eal_api_INode2D_translate(this.swigCPtr, this, f2, f3);
    }

    public boolean setTranslation(float f2, float f3) {
        return ealswigJNI.eal_api_INode2D_setTranslation(this.swigCPtr, this, f2, f3);
    }

    public Vec2f getTranslation() {
        return new Vec2f(ealswigJNI.eal_api_INode2D_getTranslation(this.swigCPtr, this), true);
    }

    public boolean rotate(float f2) {
        return ealswigJNI.eal_api_INode2D_rotate(this.swigCPtr, this, f2);
    }

    public boolean setRotation(float f2) {
        return ealswigJNI.eal_api_INode2D_setRotation(this.swigCPtr, this, f2);
    }

    public float getRotation() {
        return ealswigJNI.eal_api_INode2D_getRotation(this.swigCPtr, this);
    }

    public INode2D getParent() {
        long l = ealswigJNI.eal_api_INode2D_getParent(this.swigCPtr, this);
        return l == 0L ? null : new INode2D(l, true);
    }

    public INode2D getChildAtIndex(long l) {
        long l2 = ealswigJNI.eal_api_INode2D_getChildAtIndex(this.swigCPtr, this, l);
        return l2 == 0L ? null : new INode2D(l2, true);
    }

    public INode2D getChildByIndex(int n) {
        long l = ealswigJNI.eal_api_INode2D_getChildByIndex(this.swigCPtr, this, n);
        return l == 0L ? null : new INode2D(l, true);
    }

    public INode2D getChildByName(String string) {
        long l = ealswigJNI.eal_api_INode2D_getChildByName(this.swigCPtr, this, string);
        return l == 0L ? null : new INode2D(l, true);
    }

    public boolean add(INode2D iNode2D) {
        return ealswigJNI.eal_api_INode2D_add__SWIG_0(this.swigCPtr, this, INode2D.getCPtr(iNode2D), iNode2D);
    }

    public boolean add(INode2D iNode2D, long l) {
        return ealswigJNI.eal_api_INode2D_add__SWIG_1(this.swigCPtr, this, INode2D.getCPtr(iNode2D), iNode2D, l);
    }

    public boolean addByIndex(INode2D iNode2D, int n) {
        return ealswigJNI.eal_api_INode2D_addByIndex(this.swigCPtr, this, INode2D.getCPtr(iNode2D), iNode2D, n);
    }

    public boolean resetTransformations() {
        return ealswigJNI.eal_api_INode2D_resetTransformations(this.swigCPtr, this);
    }

    public boolean setTransformOrigin(float f2, float f3) {
        return ealswigJNI.eal_api_INode2D_setTransformOrigin(this.swigCPtr, this, f2, f3);
    }

    public long getWidth() {
        return ealswigJNI.eal_api_INode2D_getWidth(this.swigCPtr, this);
    }

    public long getHeight() {
        return ealswigJNI.eal_api_INode2D_getHeight(this.swigCPtr, this);
    }

    @Override
    public void dispose() {
        ealswigJNI.eal_api_INode2D_dispose(this.swigCPtr, this);
    }

    public ITexture enableOffscreen(long l, long l2, FlagTexture flagTexture) {
        long l3 = ealswigJNI.eal_api_INode2D_enableOffscreen__SWIG_0(this.swigCPtr, this, l, l2, FlagTexture.getCPtr(flagTexture), flagTexture);
        return l3 == 0L ? null : new ITexture(l3, true);
    }

    public boolean enableOffscreen(ITexture iTexture) {
        return ealswigJNI.eal_api_INode2D_enableOffscreen__SWIG_1(this.swigCPtr, this, ITexture.getCPtr(iTexture), iTexture);
    }

    public boolean disableOffscreen() {
        return ealswigJNI.eal_api_INode2D_disableOffscreen(this.swigCPtr, this);
    }

    public boolean setPixelFormat(ealLayerPixelFormat_t ealLayerPixelFormat_t2) {
        return ealswigJNI.eal_api_INode2D_setPixelFormat(this.swigCPtr, this, ealLayerPixelFormat_t2.swigValue());
    }

    public boolean setPartialRenderingDebug(boolean bl) {
        return ealswigJNI.eal_api_INode2D_setPartialRenderingDebug(this.swigCPtr, this, bl);
    }

    public boolean move(INode2D iNode2D) {
        return ealswigJNI.eal_api_INode2D_move(this.swigCPtr, this, INode2D.getCPtr(iNode2D), iNode2D);
    }

    public Mat3f getTransformation() {
        return new Mat3f(ealswigJNI.eal_api_INode2D_getTransformation(this.swigCPtr, this), true);
    }

    public boolean setTransformation(Mat3f mat3f) {
        return ealswigJNI.eal_api_INode2D_setTransformation(this.swigCPtr, this, Mat3f.getCPtr(mat3f), mat3f);
    }
}

