/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.utility;

import de.esolutions.graphics.eal.api.IRenderer;
import de.esolutions.graphics.ealswigJNI;

public class CFrameInformation {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public CFrameInformation(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(CFrameInformation cFrameInformation) {
        return cFrameInformation == null ? 0L : cFrameInformation.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_utility_CFrameInformation(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public CFrameInformation(IRenderer iRenderer) {
        this(ealswigJNI.new_eal_utility_CFrameInformation(IRenderer.getCPtr(iRenderer), iRenderer), true);
    }

    public void dispose() {
        ealswigJNI.eal_utility_CFrameInformation_dispose(this.swigCPtr, this);
    }

    public long getFPS() {
        return ealswigJNI.eal_utility_CFrameInformation_getFPS(this.swigCPtr, this);
    }
}

