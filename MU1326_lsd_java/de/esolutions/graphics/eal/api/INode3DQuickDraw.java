/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.Vec2f;
import de.esolutions.graphics.eal.api.INode3D;
import de.esolutions.graphics.eal.api.IProject;
import de.esolutions.graphics.eal.colorRGBAf;
import de.esolutions.graphics.eal.ealMultisample_t;
import de.esolutions.graphics.ealswigJNI;

public class INode3DQuickDraw
extends INode3D {
    private long swigCPtr;

    public INode3DQuickDraw(long l, boolean bl) {
        super(ealswigJNI.eal_api_INode3DQuickDraw_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(INode3DQuickDraw iNode3DQuickDraw) {
        return iNode3DQuickDraw == null ? 0L : iNode3DQuickDraw.swigCPtr;
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
                ealswigJNI.delete_eal_api_INode3DQuickDraw(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public INode3DQuickDraw(IProject iProject, String string, long l, long l2) {
        this(ealswigJNI.new_eal_api_INode3DQuickDraw__SWIG_0(IProject.getCPtr(iProject), iProject, string, l, l2), true);
    }

    public INode3DQuickDraw(IProject iProject, String string, long l, long l2, boolean bl) {
        this(ealswigJNI.new_eal_api_INode3DQuickDraw__SWIG_1(IProject.getCPtr(iProject), iProject, string, l, l2, bl), true);
    }

    public INode3DQuickDraw(IProject iProject, String string, long l, long l2, boolean bl, boolean bl2) {
        this(ealswigJNI.new_eal_api_INode3DQuickDraw__SWIG_2(IProject.getCPtr(iProject), iProject, string, l, l2, bl, bl2), true);
    }

    public INode3DQuickDraw(IProject iProject, String string, long l, long l2, boolean bl, boolean bl2, ealMultisample_t ealMultisample_t2) {
        this(ealswigJNI.new_eal_api_INode3DQuickDraw__SWIG_3(IProject.getCPtr(iProject), iProject, string, l, l2, bl, bl2, ealMultisample_t2.swigValue()), true);
    }

    public INode3DQuickDraw(IProject iProject, String string, long l, long l2, boolean bl, boolean bl2, ealMultisample_t ealMultisample_t2, boolean bl3) {
        this(ealswigJNI.new_eal_api_INode3DQuickDraw__SWIG_4(IProject.getCPtr(iProject), iProject, string, l, l2, bl, bl2, ealMultisample_t2.swigValue(), bl3), true);
    }

    @Override
    public void dispose() {
        ealswigJNI.eal_api_INode3DQuickDraw_dispose(this.swigCPtr, this);
    }

    public boolean add(Vec2f vec2f) {
        return ealswigJNI.eal_api_INode3DQuickDraw_add(this.swigCPtr, this, Vec2f.getCPtr(vec2f), vec2f);
    }

    public boolean addSeparator() {
        return ealswigJNI.eal_api_INode3DQuickDraw_addSeparator(this.swigCPtr, this);
    }

    public boolean clearArea() {
        return ealswigJNI.eal_api_INode3DQuickDraw_clearArea(this.swigCPtr, this);
    }

    public boolean setLineWidth(float f2) {
        return ealswigJNI.eal_api_INode3DQuickDraw_setLineWidth(this.swigCPtr, this, f2);
    }

    public boolean setColor(long l) {
        return ealswigJNI.eal_api_INode3DQuickDraw_setColor__SWIG_0(this.swigCPtr, this, l);
    }

    public boolean setColor(colorRGBAf colorRGBAf2) {
        return ealswigJNI.eal_api_INode3DQuickDraw_setColor__SWIG_1(this.swigCPtr, this, colorRGBAf.getCPtr(colorRGBAf2), colorRGBAf2);
    }

    public boolean setPathTranslation(float f2, float f3) {
        return ealswigJNI.eal_api_INode3DQuickDraw_setPathTranslation(this.swigCPtr, this, f2, f3);
    }

    public boolean setPathScaling(float f2, float f3) {
        return ealswigJNI.eal_api_INode3DQuickDraw_setPathScaling__SWIG_0(this.swigCPtr, this, f2, f3);
    }

    public boolean setPathScaling(float f2, float f3, boolean bl) {
        return ealswigJNI.eal_api_INode3DQuickDraw_setPathScaling__SWIG_1(this.swigCPtr, this, f2, f3, bl);
    }

    public boolean setPathRotation(float f2) {
        return ealswigJNI.eal_api_INode3DQuickDraw_setPathRotation(this.swigCPtr, this, f2);
    }

    public boolean setDebugBoundingVolume(boolean bl) {
        return ealswigJNI.eal_api_INode3DQuickDraw_setDebugBoundingVolume(this.swigCPtr, this, bl);
    }

    public boolean setPathPivot(float f2, float f3) {
        return ealswigJNI.eal_api_INode3DQuickDraw_setPathPivot(this.swigCPtr, this, f2, f3);
    }
}

