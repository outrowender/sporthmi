/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.Vec2f;
import de.esolutions.graphics.eal.api.IFont;
import de.esolutions.graphics.eal.api.IINodeText;
import de.esolutions.graphics.eal.api.INode3D;
import de.esolutions.graphics.eal.api.IProject;
import de.esolutions.graphics.eal.api.ITextLayout;
import de.esolutions.graphics.eal.api.ITextLayoutResult;
import de.esolutions.graphics.eal.colorRGBAf;
import de.esolutions.graphics.ealswigJNI;

public class INode3DText
extends INode3D {
    private long swigCPtr;

    public INode3DText(long l, boolean bl) {
        super(ealswigJNI.eal_api_INode3DText_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(INode3DText iNode3DText) {
        return iNode3DText == null ? 0L : iNode3DText.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_api_INode3DText(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public INode3DText(INode3D iNode3D) {
        this(ealswigJNI.new_eal_api_INode3DText__SWIG_0(INode3D.getCPtr(iNode3D), iNode3D), true);
    }

    public INode3DText(IProject iProject, String string, IFont iFont, int n, String string2) {
        this(ealswigJNI.new_eal_api_INode3DText__SWIG_1(IProject.getCPtr(iProject), iProject, string, IFont.getCPtr(iFont), iFont, n, string2), true);
    }

    public INode3DText(IProject iProject, String string, int n, String string2) {
        this(ealswigJNI.new_eal_api_INode3DText__SWIG_2(IProject.getCPtr(iProject), iProject, string, n, string2), true);
    }

    public INode3DText(IProject iProject, String string, ITextLayout iTextLayout, String string2) {
        this(ealswigJNI.new_eal_api_INode3DText__SWIG_3(IProject.getCPtr(iProject), iProject, string, ITextLayout.getCPtr(iTextLayout), iTextLayout, string2), true);
    }

    public INode3DText(IProject iProject, String string, ITextLayoutResult iTextLayoutResult) {
        this(ealswigJNI.new_eal_api_INode3DText__SWIG_4(IProject.getCPtr(iProject), iProject, string, ITextLayoutResult.getCPtr(iTextLayoutResult), iTextLayoutResult), true);
    }

    public INode3DText(IProject iProject, String string) {
        this(ealswigJNI.new_eal_api_INode3DText__SWIG_5(IProject.getCPtr(iProject), iProject, string), true);
    }

    public long getColor() {
        return ealswigJNI.eal_api_INode3DText_getColor(this.swigCPtr, this);
    }

    public long getHeight() {
        return ealswigJNI.eal_api_INode3DText_getHeight(this.swigCPtr, this);
    }

    public long getWidth() {
        return ealswigJNI.eal_api_INode3DText_getWidth(this.swigCPtr, this);
    }

    public boolean setColor(long l) {
        return ealswigJNI.eal_api_INode3DText_setColor__SWIG_0(this.swigCPtr, this, l);
    }

    public boolean setColor(colorRGBAf colorRGBAf2) {
        return ealswigJNI.eal_api_INode3DText_setColor__SWIG_1(this.swigCPtr, this, colorRGBAf.getCPtr(colorRGBAf2), colorRGBAf2);
    }

    public boolean setText(IFont iFont, int n, String string) {
        return ealswigJNI.eal_api_INode3DText_setText__SWIG_0(this.swigCPtr, this, IFont.getCPtr(iFont), iFont, n, string);
    }

    public boolean setText(int n, String string) {
        return ealswigJNI.eal_api_INode3DText_setText__SWIG_1(this.swigCPtr, this, n, string);
    }

    public boolean setText(ITextLayout iTextLayout, String string) {
        return ealswigJNI.eal_api_INode3DText_setText__SWIG_2(this.swigCPtr, this, ITextLayout.getCPtr(iTextLayout), iTextLayout, string);
    }

    public boolean setText(ITextLayoutResult iTextLayoutResult) {
        return ealswigJNI.eal_api_INode3DText_setText__SWIG_3(this.swigCPtr, this, ITextLayoutResult.getCPtr(iTextLayoutResult), iTextLayoutResult);
    }

    public IINodeText getInterfaceText() {
        long l = ealswigJNI.eal_api_INode3DText_getInterfaceText(this.swigCPtr, this);
        return l == 0L ? null : new IINodeText(l, true);
    }

    public void dispose() {
        ealswigJNI.eal_api_INode3DText_dispose(this.swigCPtr, this);
    }

    public long getAscent() {
        return ealswigJNI.eal_api_INode3DText_getAscent(this.swigCPtr, this);
    }

    public long getDescent() {
        return ealswigJNI.eal_api_INode3DText_getDescent(this.swigCPtr, this);
    }

    public boolean setModulateColor(colorRGBAf colorRGBAf2) {
        return ealswigJNI.eal_api_INode3DText_setModulateColor(this.swigCPtr, this, colorRGBAf.getCPtr(colorRGBAf2), colorRGBAf2);
    }

    public boolean setFading(float f2, float f3) {
        return ealswigJNI.eal_api_INode3DText_setFading__SWIG_0(this.swigCPtr, this, f2, f3);
    }

    public boolean setFading(float f2, float f3, boolean bl) {
        return ealswigJNI.eal_api_INode3DText_setFading__SWIG_1(this.swigCPtr, this, f2, f3, bl);
    }

    public boolean setCurvature(Vec2f vec2f, float f2, boolean bl) {
        return ealswigJNI.eal_api_INode3DText_setCurvature(this.swigCPtr, this, Vec2f.getCPtr(vec2f), vec2f, f2, bl);
    }
}

