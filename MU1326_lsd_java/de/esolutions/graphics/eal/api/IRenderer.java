/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.INode2D;
import de.esolutions.graphics.eal.api.IObject;
import de.esolutions.graphics.eal.api.IProject;
import de.esolutions.graphics.ealswigJNI;

public class IRenderer
extends IObject {
    private long swigCPtr;

    public IRenderer(long l, boolean bl) {
        super(ealswigJNI.eal_api_IRenderer_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(IRenderer iRenderer) {
        return iRenderer == null ? 0L : iRenderer.swigCPtr;
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
                ealswigJNI.delete_eal_api_IRenderer(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public boolean render(INode2D iNode2D) {
        return ealswigJNI.eal_api_IRenderer_render__SWIG_0(this.swigCPtr, this, INode2D.getCPtr(iNode2D), iNode2D);
    }

    public boolean render(IProject iProject) {
        return ealswigJNI.eal_api_IRenderer_render__SWIG_1(this.swigCPtr, this, IProject.getCPtr(iProject), iProject);
    }

    @Override
    public boolean isValid() {
        return ealswigJNI.eal_api_IRenderer_isValid(this.swigCPtr, this);
    }

    public boolean setHud(boolean bl) {
        return ealswigJNI.eal_api_IRenderer_setHud(this.swigCPtr, this, bl);
    }

    public boolean setSleepMode(boolean bl) {
        return ealswigJNI.eal_api_IRenderer_setSleepMode(this.swigCPtr, this, bl);
    }

    @Override
    public void dispose() {
        ealswigJNI.eal_api_IRenderer_dispose(this.swigCPtr, this);
    }

    public boolean render() {
        return ealswigJNI.eal_api_IRenderer_render__SWIG_2(this.swigCPtr, this);
    }

    public boolean record(boolean bl, String string, float f2, long l) {
        return ealswigJNI.eal_api_IRenderer_record(this.swigCPtr, this, bl, string, f2, l);
    }

    public boolean isRecording() {
        return ealswigJNI.eal_api_IRenderer_isRecording(this.swigCPtr, this);
    }
}

