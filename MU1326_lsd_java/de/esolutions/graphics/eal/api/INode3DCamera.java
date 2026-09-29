/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.Vec3f;
import de.esolutions.graphics.eal.api.IManager;
import de.esolutions.graphics.eal.api.INode3D;
import de.esolutions.graphics.eal.ealFovType_t;
import de.esolutions.graphics.ealswigJNI;

public class INode3DCamera
extends INode3D {
    private long swigCPtr;

    public INode3DCamera(long l, boolean bl) {
        super(ealswigJNI.eal_api_INode3DCamera_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(INode3DCamera iNode3DCamera) {
        return iNode3DCamera == null ? 0L : iNode3DCamera.swigCPtr;
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
                ealswigJNI.delete_eal_api_INode3DCamera(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public INode3DCamera(IManager iManager, String string) {
        this(ealswigJNI.new_eal_api_INode3DCamera__SWIG_0(IManager.getCPtr(iManager), iManager, string), true);
    }

    public INode3DCamera(INode3D iNode3D) {
        this(ealswigJNI.new_eal_api_INode3DCamera__SWIG_1(INode3D.getCPtr(iNode3D), iNode3D), true);
    }

    public float getFar() {
        return ealswigJNI.eal_api_INode3DCamera_getFar(this.swigCPtr, this);
    }

    public float getNear() {
        return ealswigJNI.eal_api_INode3DCamera_getNear(this.swigCPtr, this);
    }

    public float getFov() {
        return ealswigJNI.eal_api_INode3DCamera_getFov(this.swigCPtr, this);
    }

    public float getPlaneHeight() {
        return ealswigJNI.eal_api_INode3DCamera_getPlaneHeight(this.swigCPtr, this);
    }

    public boolean lookAt(Vec3f vec3f, Vec3f vec3f2, Vec3f vec3f3) {
        return ealswigJNI.eal_api_INode3DCamera_lookAt(this.swigCPtr, this, Vec3f.getCPtr(vec3f), vec3f, Vec3f.getCPtr(vec3f2), vec3f2, Vec3f.getCPtr(vec3f3), vec3f3);
    }

    public boolean setAspectRatio(float f2) {
        return ealswigJNI.eal_api_INode3DCamera_setAspectRatio(this.swigCPtr, this, f2);
    }

    public boolean setPerspective(float f2, float f3, float f4) {
        return ealswigJNI.eal_api_INode3DCamera_setPerspective__SWIG_0(this.swigCPtr, this, f2, f3, f4);
    }

    public boolean setPerspective(float f2, float f3, float f4, ealFovType_t ealFovType_t2) {
        return ealswigJNI.eal_api_INode3DCamera_setPerspective__SWIG_1(this.swigCPtr, this, f2, f3, f4, ealFovType_t2.swigValue());
    }

    public boolean setOrthogonal(float f2, float f3, float f4) {
        return ealswigJNI.eal_api_INode3DCamera_setOrthogonal(this.swigCPtr, this, f2, f3, f4);
    }

    public ealFovType_t getFovType() {
        return ealFovType_t.swigToEnum(ealswigJNI.eal_api_INode3DCamera_getFovType(this.swigCPtr, this));
    }

    @Override
    public void dispose() {
        ealswigJNI.eal_api_INode3DCamera_dispose(this.swigCPtr, this);
    }

    public boolean interpolate(INode3DCamera iNode3DCamera, INode3DCamera iNode3DCamera2, float f2) {
        return ealswigJNI.eal_api_INode3DCamera_interpolate(this.swigCPtr, this, INode3DCamera.getCPtr(iNode3DCamera), iNode3DCamera, INode3DCamera.getCPtr(iNode3DCamera2), iNode3DCamera2, f2);
    }
}

