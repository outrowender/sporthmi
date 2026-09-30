/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.IObject;
import de.esolutions.graphics.ealswigJNI;

public class IMeshData
extends IObject {
    private long swigCPtr;

    public IMeshData(long l, boolean bl) {
        super(ealswigJNI.eal_api_IMeshData_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(IMeshData iMeshData) {
        return iMeshData == null ? 0L : iMeshData.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_api_IMeshData(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public boolean morph(IMeshData iMeshData, long l, float f2) {
        return ealswigJNI.eal_api_IMeshData_morph(this.swigCPtr, this, IMeshData.getCPtr(iMeshData), iMeshData, l, f2);
    }

    public boolean isValid() {
        return ealswigJNI.eal_api_IMeshData_isValid(this.swigCPtr, this);
    }

    public void dispose() {
        ealswigJNI.eal_api_IMeshData_dispose(this.swigCPtr, this);
    }
}

