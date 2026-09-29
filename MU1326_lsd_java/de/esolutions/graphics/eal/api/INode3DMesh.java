/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.IMeshData;
import de.esolutions.graphics.eal.api.INode3D;
import de.esolutions.graphics.ealswigJNI;

public class INode3DMesh
extends INode3D {
    private long swigCPtr;

    public INode3DMesh(long l, boolean bl) {
        super(ealswigJNI.eal_api_INode3DMesh_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(INode3DMesh iNode3DMesh) {
        return iNode3DMesh == null ? 0L : iNode3DMesh.swigCPtr;
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
                ealswigJNI.delete_eal_api_INode3DMesh(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public IMeshData getData() {
        long l = ealswigJNI.eal_api_INode3DMesh_getData(this.swigCPtr, this);
        return l == 0L ? null : new IMeshData(l, true);
    }

    public boolean setData(IMeshData iMeshData) {
        return ealswigJNI.eal_api_INode3DMesh_setData(this.swigCPtr, this, IMeshData.getCPtr(iMeshData), iMeshData);
    }

    @Override
    public void dispose() {
        ealswigJNI.eal_api_INode3DMesh_dispose(this.swigCPtr, this);
    }
}

