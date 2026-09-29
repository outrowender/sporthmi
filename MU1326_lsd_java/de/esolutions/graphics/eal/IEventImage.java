/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.eal.IEvent;
import de.esolutions.graphics.eal.api.IImage;
import de.esolutions.graphics.ealswigJNI;

public class IEventImage
extends IEvent {
    private long swigCPtr;

    public IEventImage(long l, boolean bl) {
        super(ealswigJNI.eal_IEventImage_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(IEventImage iEventImage) {
        return iEventImage == null ? 0L : iEventImage.swigCPtr;
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
                ealswigJNI.delete_eal_IEventImage(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public String getFile() {
        return ealswigJNI.eal_IEventImage_getFile(this.swigCPtr, this);
    }

    public IImage getImage() {
        long l = ealswigJNI.eal_IEventImage_getImage(this.swigCPtr, this);
        return l == 0L ? null : new IImage(l, false);
    }
}

