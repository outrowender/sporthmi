/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.INode3D;
import de.esolutions.graphics.eal.api.IObject;
import de.esolutions.graphics.eal.api.IProject;
import de.esolutions.graphics.ealswigJNI;

public class ITemplateNode3D
extends IObject {
    private long swigCPtr;

    public ITemplateNode3D(long l, boolean bl) {
        super(ealswigJNI.eal_api_ITemplateNode3D_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(ITemplateNode3D iTemplateNode3D) {
        return iTemplateNode3D == null ? 0L : iTemplateNode3D.swigCPtr;
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
                ealswigJNI.delete_eal_api_ITemplateNode3D(this.swigCPtr);
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
        return ealswigJNI.eal_api_ITemplateNode3D_isValid(this.swigCPtr, this);
    }

    @Override
    public void dispose() {
        ealswigJNI.eal_api_ITemplateNode3D_dispose(this.swigCPtr, this);
    }

    public INode3D getRoot() {
        long l = ealswigJNI.eal_api_ITemplateNode3D_getRoot(this.swigCPtr, this);
        return l == 0L ? null : new INode3D(l, true);
    }

    public INode3D instantiate(IProject iProject, String string) {
        long l = ealswigJNI.eal_api_ITemplateNode3D_instantiate(this.swigCPtr, this, IProject.getCPtr(iProject), iProject, string);
        return l == 0L ? null : new INode3D(l, true);
    }
}

