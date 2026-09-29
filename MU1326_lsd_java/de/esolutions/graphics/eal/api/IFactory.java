/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.FlagImage;
import de.esolutions.graphics.eal.IEventFontGroup;
import de.esolutions.graphics.eal.IEventImage;
import de.esolutions.graphics.eal.IEventImageSave;
import de.esolutions.graphics.eal.api.IImage;
import de.esolutions.graphics.eal.api.IManager;
import de.esolutions.graphics.eal.api.INode;
import de.esolutions.graphics.eal.api.IObject;
import de.esolutions.graphics.eal.api.IProject;
import de.esolutions.graphics.eal.ealImageFormat_t;
import de.esolutions.graphics.ealswigJNI;

public class IFactory {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public IFactory(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(IFactory iFactory) {
        return iFactory == null ? 0L : iFactory.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_api_IFactory(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public static boolean dereference(IObject iObject) {
        return ealswigJNI.eal_api_IFactory_dereference(IObject.getCPtr(iObject), iObject);
    }

    public static boolean destroy(INode iNode, boolean bl) {
        return ealswigJNI.eal_api_IFactory_destroy__SWIG_0(INode.getCPtr(iNode), iNode, bl);
    }

    public static boolean destroy(INode iNode) {
        return ealswigJNI.eal_api_IFactory_destroy__SWIG_1(INode.getCPtr(iNode), iNode);
    }

    public static boolean destroy(IProject iProject) {
        return ealswigJNI.eal_api_IFactory_destroy__SWIG_2(IProject.getCPtr(iProject), iProject);
    }

    public static IEventImage requestEventImage(IManager iManager, String string, FlagImage flagImage) {
        long l = ealswigJNI.eal_api_IFactory_requestEventImage__SWIG_0(IManager.getCPtr(iManager), iManager, string, FlagImage.getCPtr(flagImage), flagImage);
        return l == 0L ? null : new IEventImage(l, false);
    }

    public static IEventImage requestEventImage(IManager iManager, String string, FlagImage flagImage, long l, long l2) {
        long l3 = ealswigJNI.eal_api_IFactory_requestEventImage__SWIG_1(IManager.getCPtr(iManager), iManager, string, FlagImage.getCPtr(flagImage), flagImage, l, l2);
        return l3 == 0L ? null : new IEventImage(l3, false);
    }

    public static IEventImageSave requestEventImageSave(IImage iImage, String string, ealImageFormat_t ealImageFormat_t2) {
        long l = ealswigJNI.eal_api_IFactory_requestEventImageSave(IImage.getCPtr(iImage), iImage, string, ealImageFormat_t2.swigValue());
        return l == 0L ? null : new IEventImageSave(l, false);
    }

    public static IEventFontGroup requestEventFontGroup(IManager iManager) {
        long l = ealswigJNI.eal_api_IFactory_requestEventFontGroup(IManager.getCPtr(iManager), iManager);
        return l == 0L ? null : new IEventFontGroup(l, false);
    }
}

