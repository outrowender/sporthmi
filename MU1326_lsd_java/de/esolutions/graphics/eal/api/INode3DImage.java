/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.IINodeImage;
import de.esolutions.graphics.eal.api.IMaterial;
import de.esolutions.graphics.eal.api.INode3D;
import de.esolutions.graphics.eal.api.IProject;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.graphics.eal.colorRGBAf;
import de.esolutions.graphics.ealswigJNI;

public class INode3DImage
extends INode3D {
    private long swigCPtr;

    public INode3DImage(long l, boolean bl) {
        super(ealswigJNI.eal_api_INode3DImage_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(INode3DImage iNode3DImage) {
        return iNode3DImage == null ? 0L : iNode3DImage.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_api_INode3DImage(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public INode3DImage(INode3D iNode3D) {
        this(ealswigJNI.new_eal_api_INode3DImage__SWIG_0(INode3D.getCPtr(iNode3D), iNode3D), true);
    }

    public INode3DImage(IProject iProject, String string) {
        this(ealswigJNI.new_eal_api_INode3DImage__SWIG_1(IProject.getCPtr(iProject), iProject, string), true);
    }

    public INode3DImage(IProject iProject, String string, ITexture iTexture) {
        this(ealswigJNI.new_eal_api_INode3DImage__SWIG_2(IProject.getCPtr(iProject), iProject, string, ITexture.getCPtr(iTexture), iTexture), true);
    }

    public boolean setTexture(ITexture iTexture) {
        return ealswigJNI.eal_api_INode3DImage_setTexture(this.swigCPtr, this, ITexture.getCPtr(iTexture), iTexture);
    }

    public long getWidth() {
        return ealswigJNI.eal_api_INode3DImage_getWidth(this.swigCPtr, this);
    }

    public long getHeight() {
        return ealswigJNI.eal_api_INode3DImage_getHeight(this.swigCPtr, this);
    }

    public IINodeImage getInterfaceImage() {
        long l = ealswigJNI.eal_api_INode3DImage_getInterfaceImage(this.swigCPtr, this);
        return l == 0L ? null : new IINodeImage(l, true);
    }

    public void dispose() {
        ealswigJNI.eal_api_INode3DImage_dispose(this.swigCPtr, this);
    }

    public boolean setModulateColor(colorRGBAf colorRGBAf2) {
        return ealswigJNI.eal_api_INode3DImage_setModulateColor__SWIG_0(this.swigCPtr, this, colorRGBAf.getCPtr(colorRGBAf2), colorRGBAf2);
    }

    public boolean setModulateColor(long l) {
        return ealswigJNI.eal_api_INode3DImage_setModulateColor__SWIG_1(this.swigCPtr, this, l);
    }

    public boolean setMaterial(IMaterial iMaterial) {
        return ealswigJNI.eal_api_INode3DImage_setMaterial(this.swigCPtr, this, IMaterial.getCPtr(iMaterial), iMaterial);
    }

    public boolean flipX() {
        return ealswigJNI.eal_api_INode3DImage_flipX(this.swigCPtr, this);
    }

    public boolean flipY() {
        return ealswigJNI.eal_api_INode3DImage_flipY(this.swigCPtr, this);
    }

    public boolean flipXY() {
        return ealswigJNI.eal_api_INode3DImage_flipXY(this.swigCPtr, this);
    }

    public boolean clipImage(float f2, float f3, float f4, float f5) {
        return ealswigJNI.eal_api_INode3DImage_clipImage(this.swigCPtr, this, f2, f3, f4, f5);
    }
}

