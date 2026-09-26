/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.utility;

import de.esolutions.graphics.eal.FlagTexture;
import de.esolutions.graphics.eal.api.INode2D;
import de.esolutions.graphics.eal.api.INode2DManaged;
import de.esolutions.graphics.eal.api.IProject;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.graphics.ealswigJNI;

public class COffscreenHelper {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public COffscreenHelper(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(COffscreenHelper cOffscreenHelper) {
        return cOffscreenHelper == null ? 0L : cOffscreenHelper.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_utility_COffscreenHelper(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public COffscreenHelper(IProject iProject, INode2DManaged iNode2DManaged) {
        this(ealswigJNI.new_eal_utility_COffscreenHelper(IProject.getCPtr(iProject), iProject, INode2DManaged.getCPtr(iNode2DManaged), iNode2DManaged), true);
    }

    public void dispose() {
        ealswigJNI.eal_utility_COffscreenHelper_dispose(this.swigCPtr, this);
    }

    public ITexture enableOffscreen(INode2D iNode2D, long l, long l2, FlagTexture flagTexture, int n) {
        long l3 = ealswigJNI.eal_utility_COffscreenHelper_enableOffscreen__SWIG_0(this.swigCPtr, this, INode2D.getCPtr(iNode2D), iNode2D, l, l2, FlagTexture.getCPtr(flagTexture), flagTexture, n);
        return l3 == 0L ? null : new ITexture(l3, false);
    }

    public ITexture enableOffscreen(INode2D iNode2D, long l, long l2, FlagTexture flagTexture, int n, boolean bl) {
        long l3 = ealswigJNI.eal_utility_COffscreenHelper_enableOffscreen__SWIG_1(this.swigCPtr, this, INode2D.getCPtr(iNode2D), iNode2D, l, l2, FlagTexture.getCPtr(flagTexture), flagTexture, n, bl);
        return l3 == 0L ? null : new ITexture(l3, false);
    }

    public boolean enableOffscreen(INode2D iNode2D, ITexture iTexture, int n) {
        return ealswigJNI.eal_utility_COffscreenHelper_enableOffscreen__SWIG_2(this.swigCPtr, this, INode2D.getCPtr(iNode2D), iNode2D, ITexture.getCPtr(iTexture), iTexture, n);
    }

    public boolean enableOffscreen(INode2D iNode2D, ITexture iTexture, int n, boolean bl) {
        return ealswigJNI.eal_utility_COffscreenHelper_enableOffscreen__SWIG_3(this.swigCPtr, this, INode2D.getCPtr(iNode2D), iNode2D, ITexture.getCPtr(iTexture), iTexture, n, bl);
    }

    public boolean disableOffscreen(INode2D iNode2D) {
        return ealswigJNI.eal_utility_COffscreenHelper_disableOffscreen(this.swigCPtr, this, INode2D.getCPtr(iNode2D), iNode2D);
    }
}

