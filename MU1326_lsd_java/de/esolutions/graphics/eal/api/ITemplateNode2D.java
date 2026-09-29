/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.INode2D;
import de.esolutions.graphics.eal.api.IObject;
import de.esolutions.graphics.eal.api.IProject;
import de.esolutions.graphics.ealswigJNI;

public class ITemplateNode2D
extends IObject {
    private long swigCPtr;

    public ITemplateNode2D(long l, boolean bl) {
        super(ealswigJNI.eal_api_ITemplateNode2D_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(ITemplateNode2D iTemplateNode2D) {
        return iTemplateNode2D == null ? 0L : iTemplateNode2D.swigCPtr;
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
                ealswigJNI.delete_eal_api_ITemplateNode2D(this.swigCPtr);
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
        return ealswigJNI.eal_api_ITemplateNode2D_isValid(this.swigCPtr, this);
    }

    @Override
    public void dispose() {
        ealswigJNI.eal_api_ITemplateNode2D_dispose(this.swigCPtr, this);
    }

    public INode2D getRoot() {
        long l = ealswigJNI.eal_api_ITemplateNode2D_getRoot(this.swigCPtr, this);
        return l == 0L ? null : new INode2D(l, true);
    }

    public INode2D instantiate(IProject iProject, String string) {
        long l = ealswigJNI.eal_api_ITemplateNode2D_instantiate(this.swigCPtr, this, IProject.getCPtr(iProject), iProject, string);
        return l == 0L ? null : new INode2D(l, true);
    }
}

