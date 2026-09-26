/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.eal.IEvent;
import de.esolutions.graphics.ealswigJNI;

public class IEventImageSave
extends IEvent {
    private long swigCPtr;

    public IEventImageSave(long l, boolean bl) {
        super(ealswigJNI.eal_IEventImageSave_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(IEventImageSave iEventImageSave) {
        return iEventImageSave == null ? 0L : iEventImageSave.swigCPtr;
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
                ealswigJNI.delete_eal_IEventImageSave(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }
}

