/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.FlagTexture;
import de.esolutions.graphics.eal.api.INode2D;
import de.esolutions.graphics.eal.api.INode3DScene;
import de.esolutions.graphics.eal.api.IProject;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.graphics.ealswigJNI;

public class INode2DLink
extends INode2D {
    private long swigCPtr;

    public INode2DLink(long l, boolean bl) {
        super(ealswigJNI.eal_api_INode2DLink_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(INode2DLink iNode2DLink) {
        return iNode2DLink == null ? 0L : iNode2DLink.swigCPtr;
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
                ealswigJNI.delete_eal_api_INode2DLink(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public INode2DLink(IProject iProject, String string) {
        this(ealswigJNI.new_eal_api_INode2DLink(IProject.getCPtr(iProject), iProject, string), true);
    }

    public boolean setScene(INode3DScene iNode3DScene) {
        return ealswigJNI.eal_api_INode2DLink_setScene__SWIG_0(this.swigCPtr, this, INode3DScene.getCPtr(iNode3DScene), iNode3DScene);
    }

    public boolean setScene(INode3DScene iNode3DScene, boolean bl) {
        return ealswigJNI.eal_api_INode2DLink_setScene__SWIG_1(this.swigCPtr, this, INode3DScene.getCPtr(iNode3DScene), iNode3DScene, bl);
    }

    public boolean unsetScene() {
        return ealswigJNI.eal_api_INode2DLink_unsetScene(this.swigCPtr, this);
    }

    @Override
    public void dispose() {
        ealswigJNI.eal_api_INode2DLink_dispose(this.swigCPtr, this);
    }

    public ITexture enablePortal(float f2, float f3, float f4, float f5, FlagTexture flagTexture) {
        long l = ealswigJNI.eal_api_INode2DLink_enablePortal(this.swigCPtr, this, f2, f3, f4, f5, FlagTexture.getCPtr(flagTexture), flagTexture);
        return l == 0L ? null : new ITexture(l, true);
    }

    public boolean disablePortal() {
        return ealswigJNI.eal_api_INode2DLink_disablePortal(this.swigCPtr, this);
    }
}

