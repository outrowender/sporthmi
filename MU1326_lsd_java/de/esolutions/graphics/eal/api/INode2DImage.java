/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.IINodeImage;
import de.esolutions.graphics.eal.api.INode2D;
import de.esolutions.graphics.eal.api.IProject;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.graphics.eal.colorRGBAf;
import de.esolutions.graphics.ealswigJNI;

public class INode2DImage
extends INode2D {
    private long swigCPtr;

    public INode2DImage(long l, boolean bl) {
        super(ealswigJNI.eal_api_INode2DImage_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(INode2DImage iNode2DImage) {
        return iNode2DImage == null ? 0L : iNode2DImage.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_api_INode2DImage(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public INode2DImage(INode2D iNode2D) {
        this(ealswigJNI.new_eal_api_INode2DImage__SWIG_0(INode2D.getCPtr(iNode2D), iNode2D), true);
    }

    public INode2DImage(IProject iProject, String string, boolean bl) {
        this(ealswigJNI.new_eal_api_INode2DImage__SWIG_1(IProject.getCPtr(iProject), iProject, string, bl), true);
    }

    public INode2DImage(IProject iProject, String string, ITexture iTexture) {
        this(ealswigJNI.new_eal_api_INode2DImage__SWIG_2(IProject.getCPtr(iProject), iProject, string, ITexture.getCPtr(iTexture), iTexture), true);
    }

    public INode2DImage(IProject iProject, String string, ITexture iTexture, boolean bl) {
        this(ealswigJNI.new_eal_api_INode2DImage__SWIG_3(IProject.getCPtr(iProject), iProject, string, ITexture.getCPtr(iTexture), iTexture, bl), true);
    }

    public boolean setModulateColor(colorRGBAf colorRGBAf2) {
        return ealswigJNI.eal_api_INode2DImage_setModulateColor__SWIG_0(this.swigCPtr, this, colorRGBAf.getCPtr(colorRGBAf2), colorRGBAf2);
    }

    public boolean setModulateColor(long l) {
        return ealswigJNI.eal_api_INode2DImage_setModulateColor__SWIG_1(this.swigCPtr, this, l);
    }

    public boolean setTexture(ITexture iTexture) {
        return ealswigJNI.eal_api_INode2DImage_setTexture(this.swigCPtr, this, ITexture.getCPtr(iTexture), iTexture);
    }

    public IINodeImage getInterfaceImage() {
        long l = ealswigJNI.eal_api_INode2DImage_getInterfaceImage(this.swigCPtr, this);
        return l == 0L ? null : new IINodeImage(l, true);
    }

    public long getWidth() {
        return ealswigJNI.eal_api_INode2DImage_getWidth(this.swigCPtr, this);
    }

    public long getHeight() {
        return ealswigJNI.eal_api_INode2DImage_getHeight(this.swigCPtr, this);
    }

    public void dispose() {
        ealswigJNI.eal_api_INode2DImage_dispose(this.swigCPtr, this);
    }

    public boolean clipImage(float f2, float f3, float f4, float f5) {
        return ealswigJNI.eal_api_INode2DImage_clipImage(this.swigCPtr, this, f2, f3, f4, f5);
    }
}

