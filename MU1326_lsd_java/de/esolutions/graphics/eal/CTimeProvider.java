/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.ealswigJNI;
import java.math.BigInteger;

public class CTimeProvider {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public CTimeProvider(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(CTimeProvider cTimeProvider) {
        return cTimeProvider == null ? 0L : cTimeProvider.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_CTimeProvider(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public static BigInteger getTime() {
        return ealswigJNI.eal_CTimeProvider_getTime();
    }

    public static BigInteger getDeltaTime() {
        return ealswigJNI.eal_CTimeProvider_getDeltaTime();
    }

    public CTimeProvider() {
        this(ealswigJNI.new_eal_CTimeProvider(), true);
    }
}

