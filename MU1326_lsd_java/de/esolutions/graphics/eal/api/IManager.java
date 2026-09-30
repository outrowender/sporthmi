/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.IEventFontGroup;
import de.esolutions.graphics.eal.IEventImage;
import de.esolutions.graphics.eal.IEventImageSave;
import de.esolutions.graphics.eal.api.IContext;
import de.esolutions.graphics.eal.api.IObject;
import de.esolutions.graphics.eal.api.IProject;
import de.esolutions.graphics.eal.api.IRenderer;
import de.esolutions.graphics.eal.api.ITextLayout;
import de.esolutions.graphics.eal.api.ITextLayoutResult;
import de.esolutions.graphics.eal.glyphInformation_t;
import de.esolutions.graphics.ealswigJNI;

public class IManager
extends IObject {
    private long swigCPtr;

    public IManager(long l, boolean bl) {
        super(ealswigJNI.eal_api_IManager_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(IManager iManager) {
        return iManager == null ? 0L : iManager.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_api_IManager(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public IManager() {
        this(ealswigJNI.new_eal_api_IManager(), true);
    }

    public boolean start() {
        return ealswigJNI.eal_api_IManager_start(this.swigCPtr, this);
    }

    public boolean stop() {
        return ealswigJNI.eal_api_IManager_stop(this.swigCPtr, this);
    }

    public IContext getContext() {
        long l = ealswigJNI.eal_api_IManager_getContext(this.swigCPtr, this);
        return l == 0L ? null : new IContext(l, true);
    }

    public IProject load(String string) {
        long l = ealswigJNI.eal_api_IManager_load(this.swigCPtr, this, string);
        return l == 0L ? null : new IProject(l, true);
    }

    public IProject getDefaultProject() {
        long l = ealswigJNI.eal_api_IManager_getDefaultProject(this.swigCPtr, this);
        return l == 0L ? null : new IProject(l, true);
    }

    public IProject createDefaultProject() {
        long l = ealswigJNI.eal_api_IManager_createDefaultProject(this.swigCPtr, this);
        return l == 0L ? null : new IProject(l, true);
    }

    public boolean setDefaultProject(IProject iProject) {
        return ealswigJNI.eal_api_IManager_setDefaultProject(this.swigCPtr, this, IProject.getCPtr(iProject), iProject);
    }

    public boolean destroyDefaultProject(IProject iProject) {
        return ealswigJNI.eal_api_IManager_destroyDefaultProject(this.swigCPtr, this, IProject.getCPtr(iProject), iProject);
    }

    public void printMemoryStatus() {
        ealswigJNI.eal_api_IManager_printMemoryStatus(this.swigCPtr, this);
    }

    public long getMemoryVRAM() {
        return ealswigJNI.eal_api_IManager_getMemoryVRAM(this.swigCPtr, this);
    }

    public long getMemoryRAM() {
        return ealswigJNI.eal_api_IManager_getMemoryRAM(this.swigCPtr, this);
    }

    public long getMemoryRAMFree() {
        return ealswigJNI.eal_api_IManager_getMemoryRAMFree(this.swigCPtr, this);
    }

    public boolean setMemorySize(long l) {
        return ealswigJNI.eal_api_IManager_setMemorySize(this.swigCPtr, this, l);
    }

    public boolean isValid() {
        return ealswigJNI.eal_api_IManager_isValid(this.swigCPtr, this);
    }

    public IRenderer getRenderer() {
        long l = ealswigJNI.eal_api_IManager_getRenderer(this.swigCPtr, this);
        return l == 0L ? null : new IRenderer(l, true);
    }

    public void dispose() {
        ealswigJNI.eal_api_IManager_dispose(this.swigCPtr, this);
    }

    public boolean dumpFontCaches(String string) {
        return ealswigJNI.eal_api_IManager_dumpFontCaches(this.swigCPtr, this, string);
    }

    public static String triggerDump() {
        return ealswigJNI.eal_api_IManager_triggerDump();
    }

    public ITextLayoutResult layout(ITextLayout iTextLayout, String string) {
        long l = ealswigJNI.eal_api_IManager_layout(this.swigCPtr, this, ITextLayout.getCPtr(iTextLayout), iTextLayout, string);
        return l == 0L ? null : new ITextLayoutResult(l, true);
    }

    public boolean layoutGetWidth(ITextLayoutResult iTextLayoutResult, int[] nArray, int n) {
        return ealswigJNI.eal_api_IManager_layoutGetWidth(this.swigCPtr, this, ITextLayoutResult.getCPtr(iTextLayoutResult), iTextLayoutResult, nArray, n);
    }

    public boolean computeAvailableGlyphs(String string, ITextLayout iTextLayout, glyphInformation_t glyphInformation_t2) {
        return ealswigJNI.eal_api_IManager_computeAvailableGlyphs(this.swigCPtr, this, string, ITextLayout.getCPtr(iTextLayout), iTextLayout, glyphInformation_t.getCPtr(glyphInformation_t2), glyphInformation_t2);
    }

    public boolean isMerged(IProject iProject, String string) {
        return ealswigJNI.eal_api_IManager_isMerged(this.swigCPtr, this, IProject.getCPtr(iProject), iProject, string);
    }

    public boolean execute(IEventImage iEventImage) {
        return ealswigJNI.eal_api_IManager_execute__SWIG_0(this.swigCPtr, this, IEventImage.getCPtr(iEventImage), iEventImage);
    }

    public boolean execute(IEventImageSave iEventImageSave) {
        return ealswigJNI.eal_api_IManager_execute__SWIG_1(this.swigCPtr, this, IEventImageSave.getCPtr(iEventImageSave), iEventImageSave);
    }

    public boolean execute(IEventFontGroup iEventFontGroup) {
        return ealswigJNI.eal_api_IManager_execute__SWIG_2(this.swigCPtr, this, IEventFontGroup.getCPtr(iEventFontGroup), iEventFontGroup);
    }

    public void setObjectTracer(boolean bl) {
        ealswigJNI.eal_api_IManager_setObjectTracer(this.swigCPtr, this, bl);
    }

    public void dumpObjects() {
        ealswigJNI.eal_api_IManager_dumpObjects(this.swigCPtr, this);
    }

    public void dumpProfiling() {
        ealswigJNI.eal_api_IManager_dumpProfiling(this.swigCPtr, this);
    }

    public void dumpRegistry() {
        ealswigJNI.eal_api_IManager_dumpRegistry(this.swigCPtr, this);
    }

    public void dumpMemory() {
        ealswigJNI.eal_api_IManager_dumpMemory(this.swigCPtr, this);
    }

    public void dumpResources() {
        ealswigJNI.eal_api_IManager_dumpResources(this.swigCPtr, this);
    }

    public void setRegistry(boolean bl) {
        ealswigJNI.eal_api_IManager_setRegistry(this.swigCPtr, this, bl);
    }

    public void setObjectWarnLimit(long l) {
        ealswigJNI.eal_api_IManager_setObjectWarnLimit(this.swigCPtr, this, l);
    }

    public boolean setOpacityInvalidationInherit(boolean bl) {
        return ealswigJNI.eal_api_IManager_setOpacityInvalidationInherit(this.swigCPtr, this, bl);
    }

    public boolean setEventThreadNumber(long l) {
        return ealswigJNI.eal_api_IManager_setEventThreadNumber(this.swigCPtr, this, l);
    }

    public boolean setFontDpi(int n) {
        return ealswigJNI.eal_api_IManager_setFontDpi(this.swigCPtr, this, n);
    }

    public int getCurrentFontDpi() {
        return ealswigJNI.eal_api_IManager_getCurrentFontDpi(this.swigCPtr, this);
    }
}

