/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.IManager;
import de.esolutions.graphics.eal.api.INode3D;
import de.esolutions.graphics.eal.api.INode3DCamera;
import de.esolutions.graphics.eal.colorRGBAf;
import de.esolutions.graphics.ealswigJNI;

public class INode3DScene
extends INode3D {
    private long swigCPtr;

    public INode3DScene(long l, boolean bl) {
        super(ealswigJNI.eal_api_INode3DScene_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(INode3DScene iNode3DScene) {
        return iNode3DScene == null ? 0L : iNode3DScene.swigCPtr;
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
                ealswigJNI.delete_eal_api_INode3DScene(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public INode3DScene(IManager iManager, String string) {
        this(ealswigJNI.new_eal_api_INode3DScene(IManager.getCPtr(iManager), iManager, string), true);
    }

    @Override
    public boolean add(INode3D iNode3D) {
        return ealswigJNI.eal_api_INode3DScene_add__SWIG_0(this.swigCPtr, this, INode3D.getCPtr(iNode3D), iNode3D);
    }

    public boolean add(INode3DCamera iNode3DCamera) {
        return ealswigJNI.eal_api_INode3DScene_add__SWIG_1(this.swigCPtr, this, INode3DCamera.getCPtr(iNode3DCamera), iNode3DCamera);
    }

    @Override
    public boolean add(INode3D iNode3D, long l) {
        return ealswigJNI.eal_api_INode3DScene_add__SWIG_2(this.swigCPtr, this, INode3D.getCPtr(iNode3D), iNode3D, l);
    }

    public boolean add(INode3DCamera iNode3DCamera, long l) {
        return ealswigJNI.eal_api_INode3DScene_add__SWIG_3(this.swigCPtr, this, INode3DCamera.getCPtr(iNode3DCamera), iNode3DCamera, l);
    }

    @Override
    public boolean addByIndex(INode3D iNode3D, int n) {
        return ealswigJNI.eal_api_INode3DScene_addByIndex__SWIG_0(this.swigCPtr, this, INode3D.getCPtr(iNode3D), iNode3D, n);
    }

    public boolean addByIndex(INode3DCamera iNode3DCamera, int n) {
        return ealswigJNI.eal_api_INode3DScene_addByIndex__SWIG_1(this.swigCPtr, this, INode3DCamera.getCPtr(iNode3DCamera), iNode3DCamera, n);
    }

    @Override
    public void dispose() {
        ealswigJNI.eal_api_INode3DScene_dispose(this.swigCPtr, this);
    }

    public boolean setDefaultCamera(INode3DCamera iNode3DCamera) {
        return ealswigJNI.eal_api_INode3DScene_setDefaultCamera(this.swigCPtr, this, INode3DCamera.getCPtr(iNode3DCamera), iNode3DCamera);
    }

    public boolean setColorClear(boolean bl) {
        return ealswigJNI.eal_api_INode3DScene_setColorClear(this.swigCPtr, this, bl);
    }

    public boolean setClearColor(colorRGBAf colorRGBAf2) {
        return ealswigJNI.eal_api_INode3DScene_setClearColor(this.swigCPtr, this, colorRGBAf.getCPtr(colorRGBAf2), colorRGBAf2);
    }

    @Override
    public boolean setDepthTest(boolean bl) {
        return ealswigJNI.eal_api_INode3DScene_setDepthTest(this.swigCPtr, this, bl);
    }

    public boolean setAnimationPlayer(boolean bl) {
        return ealswigJNI.eal_api_INode3DScene_setAnimationPlayer(this.swigCPtr, this, bl);
    }
}

