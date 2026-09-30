/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.CMergeInfo;
import de.esolutions.graphics.eal.FlagMerge;
import de.esolutions.graphics.eal.api.IAnimation;
import de.esolutions.graphics.eal.api.IAnimationClip;
import de.esolutions.graphics.eal.api.IMaterial;
import de.esolutions.graphics.eal.api.IMeshData;
import de.esolutions.graphics.eal.api.INode;
import de.esolutions.graphics.eal.api.INode2D;
import de.esolutions.graphics.eal.api.INode2DImage;
import de.esolutions.graphics.eal.api.INode2DLink;
import de.esolutions.graphics.eal.api.INode3D;
import de.esolutions.graphics.eal.api.INode3DCamera;
import de.esolutions.graphics.eal.api.INode3DMesh;
import de.esolutions.graphics.eal.api.INode3DScene;
import de.esolutions.graphics.eal.api.IObject;
import de.esolutions.graphics.eal.api.ITemplateNode2D;
import de.esolutions.graphics.eal.api.ITemplateNode3D;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.graphics.eal.api.ITimeLineSequence;
import de.esolutions.graphics.eal.ealObjectType_t;
import de.esolutions.graphics.eal.merge_t;
import de.esolutions.graphics.eal.nodeType_t;
import de.esolutions.graphics.ealswigJNI;

public class IProject
extends IObject {
    private long swigCPtr;

    public IProject(long l, boolean bl) {
        super(ealswigJNI.eal_api_IProject_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(IProject iProject) {
        return iProject == null ? 0L : iProject.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_api_IProject(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public INode3DScene getScene(String string) {
        long l = ealswigJNI.eal_api_IProject_getScene(this.swigCPtr, this, string);
        return l == 0L ? null : new INode3DScene(l, true);
    }

    public IAnimationClip getAnimationClip(String string) {
        long l = ealswigJNI.eal_api_IProject_getAnimationClip(this.swigCPtr, this, string);
        return l == 0L ? null : new IAnimationClip(l, true);
    }

    public IAnimation getAnimation(String string) {
        long l = ealswigJNI.eal_api_IProject_getAnimation(this.swigCPtr, this, string);
        return l == 0L ? null : new IAnimation(l, true);
    }

    public INode getNode(String string) {
        long l = ealswigJNI.eal_api_IProject_getNode(this.swigCPtr, this, string);
        return l == 0L ? null : new INode(l, true);
    }

    public INode2D getNode2D(String string) {
        long l = ealswigJNI.eal_api_IProject_getNode2D(this.swigCPtr, this, string);
        return l == 0L ? null : new INode2D(l, true);
    }

    public INode2DImage getNode2DImage(String string) {
        long l = ealswigJNI.eal_api_IProject_getNode2DImage(this.swigCPtr, this, string);
        return l == 0L ? null : new INode2DImage(l, true);
    }

    public INode3D getNode3D(String string) {
        long l = ealswigJNI.eal_api_IProject_getNode3D(this.swigCPtr, this, string);
        return l == 0L ? null : new INode3D(l, true);
    }

    public INode3DMesh getNode3DMesh(String string) {
        long l = ealswigJNI.eal_api_IProject_getNode3DMesh(this.swigCPtr, this, string);
        return l == 0L ? null : new INode3DMesh(l, true);
    }

    public INode3DCamera getNode3DCamera(String string) {
        long l = ealswigJNI.eal_api_IProject_getNode3DCamera(this.swigCPtr, this, string);
        return l == 0L ? null : new INode3DCamera(l, true);
    }

    public IMaterial getMaterial(String string) {
        long l = ealswigJNI.eal_api_IProject_getMaterial(this.swigCPtr, this, string);
        return l == 0L ? null : new IMaterial(l, true);
    }

    public INode2DLink getNode2DLink(String string) {
        long l = ealswigJNI.eal_api_IProject_getNode2DLink(this.swigCPtr, this, string);
        return l == 0L ? null : new INode2DLink(l, true);
    }

    public IMeshData getMeshData(String string) {
        long l = ealswigJNI.eal_api_IProject_getMeshData(this.swigCPtr, this, string);
        return l == 0L ? null : new IMeshData(l, true);
    }

    public ITimeLineSequence getTimeLineSequence(String string) {
        long l = ealswigJNI.eal_api_IProject_getTimeLineSequence(this.swigCPtr, this, string);
        return l == 0L ? null : new ITimeLineSequence(l, true);
    }

    public ITemplateNode2D getTemplateNode2D(String string) {
        long l = ealswigJNI.eal_api_IProject_getTemplateNode2D(this.swigCPtr, this, string);
        return l == 0L ? null : new ITemplateNode2D(l, true);
    }

    public ITemplateNode3D getTemplateNode3D(String string) {
        long l = ealswigJNI.eal_api_IProject_getTemplateNode3D(this.swigCPtr, this, string);
        return l == 0L ? null : new ITemplateNode3D(l, true);
    }

    public ITexture getTexture(String string) {
        long l = ealswigJNI.eal_api_IProject_getTexture(this.swigCPtr, this, string);
        return l == 0L ? null : new ITexture(l, true);
    }

    public boolean merge(merge_t merge_t2, String string, CMergeInfo cMergeInfo, FlagMerge flagMerge) {
        return ealswigJNI.eal_api_IProject_merge__SWIG_0(this.swigCPtr, this, merge_t2.swigValue(), string, CMergeInfo.getCPtr(cMergeInfo), cMergeInfo, FlagMerge.getCPtr(flagMerge), flagMerge);
    }

    public boolean merge(merge_t merge_t2, String string, CMergeInfo cMergeInfo) {
        return ealswigJNI.eal_api_IProject_merge__SWIG_1(this.swigCPtr, this, merge_t2.swigValue(), string, CMergeInfo.getCPtr(cMergeInfo), cMergeInfo);
    }

    public boolean merge(merge_t merge_t2, String string) {
        return ealswigJNI.eal_api_IProject_merge__SWIG_2(this.swigCPtr, this, merge_t2.swigValue(), string);
    }

    public boolean isValid() {
        return ealswigJNI.eal_api_IProject_isValid(this.swigCPtr, this);
    }

    public boolean setMainScene(INode3DScene iNode3DScene) {
        return ealswigJNI.eal_api_IProject_setMainScene(this.swigCPtr, this, INode3DScene.getCPtr(iNode3DScene), iNode3DScene);
    }

    public boolean setScreenMain(INode2D iNode2D) {
        return ealswigJNI.eal_api_IProject_setScreenMain(this.swigCPtr, this, INode2D.getCPtr(iNode2D), iNode2D);
    }

    public INode2D getScreenMain() {
        long l = ealswigJNI.eal_api_IProject_getScreenMain(this.swigCPtr, this);
        return l == 0L ? null : new INode2D(l, true);
    }

    public boolean isScreenMain() {
        return ealswigJNI.eal_api_IProject_isScreenMain(this.swigCPtr, this);
    }

    public nodeType_t getTypeOfPath(String string) {
        return nodeType_t.swigToEnum(ealswigJNI.eal_api_IProject_getTypeOfPath(this.swigCPtr, this, string));
    }

    public boolean setRenderpass(String string, boolean bl) {
        return ealswigJNI.eal_api_IProject_setRenderpass(this.swigCPtr, this, string, bl);
    }

    public boolean isNode(String string) {
        return ealswigJNI.eal_api_IProject_isNode(this.swigCPtr, this, string);
    }

    public boolean isPrefab(String string) {
        return ealswigJNI.eal_api_IProject_isPrefab(this.swigCPtr, this, string);
    }

    public boolean isAnimationClip(String string) {
        return ealswigJNI.eal_api_IProject_isAnimationClip(this.swigCPtr, this, string);
    }

    public ITimeLineSequence getDefaultTimeLineSequence() {
        long l = ealswigJNI.eal_api_IProject_getDefaultTimeLineSequence(this.swigCPtr, this);
        return l == 0L ? null : new ITimeLineSequence(l, true);
    }

    public void dispose() {
        ealswigJNI.eal_api_IProject_dispose(this.swigCPtr, this);
    }

    public boolean registerNode(INode iNode, String string) {
        return ealswigJNI.eal_api_IProject_registerNode(this.swigCPtr, this, INode.getCPtr(iNode), iNode, string);
    }

    public void list(ealObjectType_t ealObjectType_t2, boolean bl) {
        ealswigJNI.eal_api_IProject_list__SWIG_0(this.swigCPtr, this, ealObjectType_t2.swigValue(), bl);
    }

    public void list(ealObjectType_t ealObjectType_t2) {
        ealswigJNI.eal_api_IProject_list__SWIG_1(this.swigCPtr, this, ealObjectType_t2.swigValue());
    }

    public boolean list(ealObjectType_t ealObjectType_t2, String string) {
        return ealswigJNI.eal_api_IProject_list__SWIG_2(this.swigCPtr, this, ealObjectType_t2.swigValue(), string);
    }
}

