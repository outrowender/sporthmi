/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.IFont;
import de.esolutions.graphics.eal.api.INode2D;
import de.esolutions.graphics.eal.api.IProject;
import de.esolutions.graphics.ealswigJNI;

public class INode2DManaged
extends INode2D {
    private long swigCPtr;

    public INode2DManaged(long l, boolean bl) {
        super(ealswigJNI.eal_api_INode2DManaged_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(INode2DManaged iNode2DManaged) {
        return iNode2DManaged == null ? 0L : iNode2DManaged.swigCPtr;
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
                ealswigJNI.delete_eal_api_INode2DManaged(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public INode2DManaged(IProject iProject, String string) {
        this(ealswigJNI.new_eal_api_INode2DManaged(IProject.getCPtr(iProject), iProject, string), true);
    }

    @Override
    public void dispose() {
        ealswigJNI.eal_api_INode2DManaged_dispose(this.swigCPtr, this);
    }

    public boolean addToScreen(INode2D iNode2D) {
        return ealswigJNI.eal_api_INode2DManaged_addToScreen__SWIG_0(this.swigCPtr, this, INode2D.getCPtr(iNode2D), iNode2D);
    }

    public boolean addToScreen(INode2D iNode2D, int n) {
        return ealswigJNI.eal_api_INode2DManaged_addToScreen__SWIG_1(this.swigCPtr, this, INode2D.getCPtr(iNode2D), iNode2D, n);
    }

    public boolean addOffscreen(INode2D iNode2D) {
        return ealswigJNI.eal_api_INode2DManaged_addOffscreen__SWIG_0(this.swigCPtr, this, INode2D.getCPtr(iNode2D), iNode2D);
    }

    public boolean addOffscreen(INode2D iNode2D, int n) {
        return ealswigJNI.eal_api_INode2DManaged_addOffscreen__SWIG_1(this.swigCPtr, this, INode2D.getCPtr(iNode2D), iNode2D, n);
    }

    public boolean addAuto(INode2D iNode2D) {
        return ealswigJNI.eal_api_INode2DManaged_addAuto__SWIG_0(this.swigCPtr, this, INode2D.getCPtr(iNode2D), iNode2D);
    }

    public boolean addAuto(INode2D iNode2D, int n) {
        return ealswigJNI.eal_api_INode2DManaged_addAuto__SWIG_1(this.swigCPtr, this, INode2D.getCPtr(iNode2D), iNode2D, n);
    }

    public INode2D getFromScreenByName(String string) {
        long l = ealswigJNI.eal_api_INode2DManaged_getFromScreenByName(this.swigCPtr, this, string);
        return l == 0L ? null : new INode2D(l, true);
    }

    public INode2D getFromOffscreenByName(String string) {
        long l = ealswigJNI.eal_api_INode2DManaged_getFromOffscreenByName(this.swigCPtr, this, string);
        return l == 0L ? null : new INode2D(l, true);
    }

    public boolean removeFromScreen(INode2D iNode2D) {
        return ealswigJNI.eal_api_INode2DManaged_removeFromScreen(this.swigCPtr, this, INode2D.getCPtr(iNode2D), iNode2D);
    }

    public boolean setPartialRendering(boolean bl) {
        return ealswigJNI.eal_api_INode2DManaged_setPartialRendering(this.swigCPtr, this, bl);
    }

    public boolean setHud(boolean bl, IFont iFont, int n, float f2, float f3) {
        return ealswigJNI.eal_api_INode2DManaged_setHud(this.swigCPtr, this, bl, IFont.getCPtr(iFont), iFont, n, f2, f3);
    }

    public boolean refreshPartialRendering() {
        return ealswigJNI.eal_api_INode2DManaged_refreshPartialRendering(this.swigCPtr, this);
    }

    public boolean setPartialRenderingColorBuffer(boolean bl) {
        return ealswigJNI.eal_api_INode2DManaged_setPartialRenderingColorBuffer(this.swigCPtr, this, bl);
    }
}

