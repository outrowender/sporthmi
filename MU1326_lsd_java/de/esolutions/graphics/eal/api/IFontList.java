/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.ealswigJNI;

public class IFontList {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public IFontList(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(IFontList iFontList) {
        return iFontList == null ? 0L : iFontList.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_api_IFontList(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public IFontList() {
        this(ealswigJNI.new_eal_api_IFontList(), true);
    }

    public void add(String string) {
        ealswigJNI.eal_api_IFontList_add(this.swigCPtr, this, string);
    }
}

