/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.eal.FlagImage;
import de.esolutions.graphics.eal.FlagTexture;
import de.esolutions.graphics.ealswigJNI;

public class Defaults {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public Defaults(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(Defaults defaults) {
        return defaults == null ? 0L : defaults.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_Defaults(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public static FlagImage getFlagsImage() {
        return new FlagImage(ealswigJNI.eal_Defaults_getFlagsImage(), true);
    }

    public static FlagTexture getFlagsTexture() {
        return new FlagTexture(ealswigJNI.eal_Defaults_getFlagsTexture(), true);
    }
}

