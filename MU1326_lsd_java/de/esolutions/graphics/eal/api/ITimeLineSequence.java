/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.IAnimationClip;
import de.esolutions.graphics.eal.api.INode;
import de.esolutions.graphics.eal.api.IObject;
import de.esolutions.graphics.eal.api.IProperty;
import de.esolutions.graphics.ealswigJNI;

public class ITimeLineSequence
extends IObject {
    private long swigCPtr;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$api$ITimeLineSequence$return_t;

    public ITimeLineSequence(long l, boolean bl) {
        super(ealswigJNI.eal_api_ITimeLineSequence_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(ITimeLineSequence iTimeLineSequence) {
        return iTimeLineSequence == null ? 0L : iTimeLineSequence.swigCPtr;
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
                ealswigJNI.delete_eal_api_ITimeLineSequence(this.swigCPtr);
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
        return ealswigJNI.eal_api_ITimeLineSequence_isValid(this.swigCPtr, this);
    }

    public boolean setContext(long l, INode iNode) {
        return ealswigJNI.eal_api_ITimeLineSequence_setContext(this.swigCPtr, this, l, INode.getCPtr(iNode), iNode);
    }

    public boolean setTarget(long l, ITimeLineSequence iTimeLineSequence) {
        return ealswigJNI.eal_api_ITimeLineSequence_setTarget__SWIG_0(this.swigCPtr, this, l, ITimeLineSequence.getCPtr(iTimeLineSequence), iTimeLineSequence);
    }

    public boolean setTarget(long l, IAnimationClip iAnimationClip) {
        return ealswigJNI.eal_api_ITimeLineSequence_setTarget__SWIG_1(this.swigCPtr, this, l, IAnimationClip.getCPtr(iAnimationClip), iAnimationClip);
    }

    public IAnimationClip getTarget(long l) {
        long l2 = ealswigJNI.eal_api_ITimeLineSequence_getTarget(this.swigCPtr, this, l);
        return l2 == 0L ? null : new IAnimationClip(l2, true);
    }

    public int cloneEntry(long l) {
        return ealswigJNI.eal_api_ITimeLineSequence_cloneEntry(this.swigCPtr, this, l);
    }

    public boolean setInputProperty(long l, INode iNode, IProperty iProperty) {
        return ealswigJNI.eal_api_ITimeLineSequence_setInputProperty(this.swigCPtr, this, l, INode.getCPtr(iNode), iNode, IProperty.getCPtr(iProperty), iProperty);
    }

    public void print() {
        ealswigJNI.eal_api_ITimeLineSequence_print(this.swigCPtr, this);
    }

    @Override
    public void dispose() {
        ealswigJNI.eal_api_ITimeLineSequence_dispose(this.swigCPtr, this);
    }

    public boolean makeEntryDirty(long l) {
        return ealswigJNI.eal_api_ITimeLineSequence_makeEntryDirty(this.swigCPtr, this, l);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

