/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.IFont;
import de.esolutions.graphics.eal.api.INode2D;
import de.esolutions.graphics.eal.api.IProject;
import de.esolutions.graphics.ealswigJNI;

public class INode2DHud
extends INode2D {
    private long swigCPtr;

    public INode2DHud(long l, boolean bl) {
        super(ealswigJNI.eal_api_INode2DHud_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(INode2DHud iNode2DHud) {
        return iNode2DHud == null ? 0L : iNode2DHud.swigCPtr;
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
                ealswigJNI.delete_eal_api_INode2DHud(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public INode2DHud(IProject iProject, IFont iFont, int n, float f2, float f3) {
        this(ealswigJNI.new_eal_api_INode2DHud(IProject.getCPtr(iProject), iProject, IFont.getCPtr(iFont), iFont, n, f2, f3), true);
    }

    @Override
    public void dispose() {
        ealswigJNI.eal_api_INode2DHud_dispose(this.swigCPtr, this);
    }
}

