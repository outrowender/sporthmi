/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.ealswigJNI;

public class CMergeInfo {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public CMergeInfo(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(CMergeInfo cMergeInfo) {
        return cMergeInfo == null ? 0L : cMergeInfo.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_CMergeInfo(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public CMergeInfo() {
        this(ealswigJNI.new_eal_CMergeInfo(), true);
    }

    public long getId() {
        return ealswigJNI.eal_CMergeInfo_getId(this.swigCPtr, this);
    }

    public String getPath() {
        return ealswigJNI.eal_CMergeInfo_getPath(this.swigCPtr, this);
    }

    public void dispose() {
        ealswigJNI.eal_CMergeInfo_dispose(this.swigCPtr, this);
    }
}

