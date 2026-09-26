/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.IObject;
import de.esolutions.graphics.eal.glyph_t;
import de.esolutions.graphics.ealswigJNI;

public class ITextLayoutResult
extends IObject {
    private long swigCPtr;

    public ITextLayoutResult(long l, boolean bl) {
        super(ealswigJNI.eal_api_ITextLayoutResult_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(ITextLayoutResult iTextLayoutResult) {
        return iTextLayoutResult == null ? 0L : iTextLayoutResult.swigCPtr;
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
                ealswigJNI.delete_eal_api_ITextLayoutResult(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    @Override
    public boolean isValid() {
        return ealswigJNI.eal_api_ITextLayoutResult_isValid(this.swigCPtr, this);
    }

    public long getWidth() {
        return ealswigJNI.eal_api_ITextLayoutResult_getWidth(this.swigCPtr, this);
    }

    public long getHeight() {
        return ealswigJNI.eal_api_ITextLayoutResult_getHeight(this.swigCPtr, this);
    }

    public long getLineWidth(long l) {
        return ealswigJNI.eal_api_ITextLayoutResult_getLineWidth(this.swigCPtr, this, l);
    }

    public long getLineHeight(long l) {
        return ealswigJNI.eal_api_ITextLayoutResult_getLineHeight(this.swigCPtr, this, l);
    }

    public long getAscent(long l) {
        return ealswigJNI.eal_api_ITextLayoutResult_getAscent(this.swigCPtr, this, l);
    }

    public long getDescent(long l) {
        return ealswigJNI.eal_api_ITextLayoutResult_getDescent(this.swigCPtr, this, l);
    }

    public long getLineLeft(long l) {
        return ealswigJNI.eal_api_ITextLayoutResult_getLineLeft(this.swigCPtr, this, l);
    }

    public boolean destroy() {
        return ealswigJNI.eal_api_ITextLayoutResult_destroy(this.swigCPtr, this);
    }

    public long getLineCount() {
        return ealswigJNI.eal_api_ITextLayoutResult_getLineCount(this.swigCPtr, this);
    }

    @Override
    public void dispose() {
        ealswigJNI.eal_api_ITextLayoutResult_dispose(this.swigCPtr, this);
    }

    public long getGlyphCount() {
        return ealswigJNI.eal_api_ITextLayoutResult_getGlyphCount__SWIG_0(this.swigCPtr, this);
    }

    public long getGlyphCount(long l) {
        return ealswigJNI.eal_api_ITextLayoutResult_getGlyphCount__SWIG_1(this.swigCPtr, this, l);
    }

    public glyph_t getLastGlyphOfLine(long l) {
        return new glyph_t(ealswigJNI.eal_api_ITextLayoutResult_getLastGlyphOfLine(this.swigCPtr, this, l), true);
    }

    public glyph_t getGlyphOfLine(long l, long l2) {
        return new glyph_t(ealswigJNI.eal_api_ITextLayoutResult_getGlyphOfLine(this.swigCPtr, this, l, l2), true);
    }

    public boolean isTruncated() {
        return ealswigJNI.eal_api_ITextLayoutResult_isTruncated(this.swigCPtr, this);
    }

    public int getCursorPosition(long l, long l2) {
        return ealswigJNI.eal_api_ITextLayoutResult_getCursorPosition(this.swigCPtr, this, l, l2);
    }
}

