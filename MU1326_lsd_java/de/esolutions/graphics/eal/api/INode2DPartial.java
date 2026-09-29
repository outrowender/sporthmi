/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.INode2D;
import de.esolutions.graphics.eal.api.IProject;
import de.esolutions.graphics.ealswigJNI;

public class INode2DPartial
extends INode2D {
    private long swigCPtr;

    public INode2DPartial(long l, boolean bl) {
        super(ealswigJNI.eal_api_INode2DPartial_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(INode2DPartial iNode2DPartial) {
        return iNode2DPartial == null ? 0L : iNode2DPartial.swigCPtr;
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
                ealswigJNI.delete_eal_api_INode2DPartial(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public INode2DPartial(IProject iProject, String string) {
        this(ealswigJNI.new_eal_api_INode2DPartial(IProject.getCPtr(iProject), iProject, string), true);
    }

    @Override
    public void dispose() {
        ealswigJNI.eal_api_INode2DPartial_dispose(this.swigCPtr, this);
    }
}

