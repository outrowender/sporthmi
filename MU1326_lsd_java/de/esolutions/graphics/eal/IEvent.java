/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.eal.IEventImage;
import de.esolutions.graphics.eal.IEventMerge;
import de.esolutions.graphics.eal.event_t;
import de.esolutions.graphics.ealswigJNI;

public class IEvent {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public IEvent(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(IEvent iEvent) {
        return iEvent == null ? 0L : iEvent.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_IEvent(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public event_t getType() {
        return event_t.swigToEnum(ealswigJNI.eal_IEvent_getType(this.swigCPtr, this));
    }

    public boolean notifyListener() {
        return ealswigJNI.eal_IEvent_notifyListener(this.swigCPtr, this);
    }

    public boolean isDeleteable() {
        return ealswigJNI.eal_IEvent_isDeleteable(this.swigCPtr, this);
    }

    public boolean isError() {
        return ealswigJNI.eal_IEvent_isError(this.swigCPtr, this);
    }

    public long getId() {
        return ealswigJNI.eal_IEvent_getId(this.swigCPtr, this);
    }

    public boolean isMergeEvent() {
        return ealswigJNI.eal_IEvent_isMergeEvent(this.swigCPtr, this);
    }

    public IEventMerge toEventMerge() {
        long l = ealswigJNI.eal_IEvent_toEventMerge(this.swigCPtr, this);
        return l == 0L ? null : new IEventMerge(l, false);
    }

    public boolean isEventImage() {
        return ealswigJNI.eal_IEvent_isEventImage(this.swigCPtr, this);
    }

    public IEventImage toEventImage() {
        long l = ealswigJNI.eal_IEvent_toEventImage(this.swigCPtr, this);
        return l == 0L ? null : new IEventImage(l, false);
    }
}

