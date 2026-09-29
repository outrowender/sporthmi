/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.ealswigJNI;

public class glyph_t {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public glyph_t(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(glyph_t glyph_t2) {
        return glyph_t2 == null ? 0L : glyph_t2.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_glyph_t(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public void setWidth(long l) {
        ealswigJNI.eal_glyph_t_width_set(this.swigCPtr, this, l);
    }

    public long getWidth() {
        return ealswigJNI.eal_glyph_t_width_get(this.swigCPtr, this);
    }

    public void setHeight(long l) {
        ealswigJNI.eal_glyph_t_height_set(this.swigCPtr, this, l);
    }

    public long getHeight() {
        return ealswigJNI.eal_glyph_t_height_get(this.swigCPtr, this);
    }

    public void setX(float f2) {
        ealswigJNI.eal_glyph_t_x_set(this.swigCPtr, this, f2);
    }

    public float getX() {
        return ealswigJNI.eal_glyph_t_x_get(this.swigCPtr, this);
    }

    public void setY(float f2) {
        ealswigJNI.eal_glyph_t_y_set(this.swigCPtr, this, f2);
    }

    public float getY() {
        return ealswigJNI.eal_glyph_t_y_get(this.swigCPtr, this);
    }

    public void setCaretX(float f2) {
        ealswigJNI.eal_glyph_t_caretX_set(this.swigCPtr, this, f2);
    }

    public float getCaretX() {
        return ealswigJNI.eal_glyph_t_caretX_get(this.swigCPtr, this);
    }

    public void setIsRightToLeft(boolean bl) {
        ealswigJNI.eal_glyph_t_isRightToLeft_set(this.swigCPtr, this, bl);
    }

    public boolean getIsRightToLeft() {
        return ealswigJNI.eal_glyph_t_isRightToLeft_get(this.swigCPtr, this);
    }

    public glyph_t() {
        this(ealswigJNI.new_eal_glyph_t(), true);
    }
}

