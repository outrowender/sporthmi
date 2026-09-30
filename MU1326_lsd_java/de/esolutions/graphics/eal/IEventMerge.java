/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.eal.IEvent;
import de.esolutions.graphics.ealswigJNI;

public class IEventMerge
extends IEvent {
    private long swigCPtr;

    public IEventMerge(long l, boolean bl) {
        super(ealswigJNI.eal_IEventMerge_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(IEventMerge iEventMerge) {
        return iEventMerge == null ? 0L : iEventMerge.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_IEventMerge(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public boolean isValid() {
        return this.swigCPtr != 0L;
    }

    public String getFile() {
        return ealswigJNI.eal_IEventMerge_getFile(this.swigCPtr, this);
    }

    public String getScreenMainPath() {
        return ealswigJNI.eal_IEventMerge_getScreenMainPath(this.swigCPtr, this);
    }

    public void setIndex(long l) {
        ealswigJNI.eal_IEventMerge_setIndex(this.swigCPtr, this, l);
    }

    public long getIndex() {
        return ealswigJNI.eal_IEventMerge_getIndex(this.swigCPtr, this);
    }

    public boolean isIndex() {
        return ealswigJNI.eal_IEventMerge_isIndex(this.swigCPtr, this);
    }
}

