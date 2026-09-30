/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.IAnimationClip;
import de.esolutions.graphics.eal.api.IObject;
import de.esolutions.graphics.eal.api.IProject;
import de.esolutions.graphics.eal.api.ITimeLineSequence;
import de.esolutions.graphics.ealswigJNI;

public class IAnimationPlayer
extends IObject {
    private long swigCPtr;

    public IAnimationPlayer(long l, boolean bl) {
        super(ealswigJNI.eal_api_IAnimationPlayer_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(IAnimationPlayer iAnimationPlayer) {
        return iAnimationPlayer == null ? 0L : iAnimationPlayer.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_api_IAnimationPlayer(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public IAnimationPlayer(IProject iProject) {
        this(ealswigJNI.new_eal_api_IAnimationPlayer(IProject.getCPtr(iProject), iProject), true);
    }

    public boolean add(IAnimationClip iAnimationClip) {
        return ealswigJNI.eal_api_IAnimationPlayer_add__SWIG_0(this.swigCPtr, this, IAnimationClip.getCPtr(iAnimationClip), iAnimationClip);
    }

    public boolean add(ITimeLineSequence iTimeLineSequence) {
        return ealswigJNI.eal_api_IAnimationPlayer_add__SWIG_1(this.swigCPtr, this, ITimeLineSequence.getCPtr(iTimeLineSequence), iTimeLineSequence);
    }

    public boolean remove(IAnimationClip iAnimationClip) {
        return ealswigJNI.eal_api_IAnimationPlayer_remove(this.swigCPtr, this, IAnimationClip.getCPtr(iAnimationClip), iAnimationClip);
    }

    public void play() {
        ealswigJNI.eal_api_IAnimationPlayer_play(this.swigCPtr, this);
    }

    public void pause() {
        ealswigJNI.eal_api_IAnimationPlayer_pause(this.swigCPtr, this);
    }

    public boolean isValid() {
        return ealswigJNI.eal_api_IAnimationPlayer_isValid(this.swigCPtr, this);
    }

    public void dispose() {
        ealswigJNI.eal_api_IAnimationPlayer_dispose(this.swigCPtr, this);
    }
}

