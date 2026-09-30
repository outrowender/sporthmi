/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.eal.FlagImage;
import de.esolutions.graphics.eal.FlagTexture;
import de.esolutions.graphics.eal.ICacheCallback;
import de.esolutions.graphics.eal.api.IImage;
import de.esolutions.graphics.eal.api.IProject;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.graphics.ealswigJNI;

public class CCacheLRU {
    private long swigCPtr;
    protected boolean swigCMemOwn;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$CCacheLRU$cacheMode_t;

    public CCacheLRU(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(CCacheLRU cCacheLRU) {
        return cCacheLRU == null ? 0L : cCacheLRU.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_CCacheLRU(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public CCacheLRU(IProject iProject, cacheMode_t cacheMode_t2, int n) {
        this(ealswigJNI.new_eal_CCacheLRU__SWIG_0(IProject.getCPtr(iProject), iProject, cacheMode_t2.swigValue(), n), true);
    }

    public CCacheLRU(IProject iProject, int n, int n2) {
        this(ealswigJNI.new_eal_CCacheLRU__SWIG_1(IProject.getCPtr(iProject), iProject, n, n2), true);
    }

    public boolean defineImage(int n, String string, FlagImage flagImage) {
        return ealswigJNI.eal_CCacheLRU_defineImage(this.swigCPtr, this, n, string, FlagImage.getCPtr(flagImage), flagImage);
    }

    public boolean defineTexture(int n, int n2, FlagTexture flagTexture) {
        return ealswigJNI.eal_CCacheLRU_defineTexture(this.swigCPtr, this, n, n2, FlagTexture.getCPtr(flagTexture), flagTexture);
    }

    public IImage getImage(int n) {
        long l = ealswigJNI.eal_CCacheLRU_getImage(this.swigCPtr, this, n);
        return l == 0L ? null : new IImage(l, false);
    }

    public ITexture getTexture(int n) {
        long l = ealswigJNI.eal_CCacheLRU_getTexture(this.swigCPtr, this, n);
        return l == 0L ? null : new ITexture(l, false);
    }

    public boolean returnObject(int n) {
        return ealswigJNI.eal_CCacheLRU_returnObject(this.swigCPtr, this, n);
    }

    public void dump() {
        ealswigJNI.eal_CCacheLRU_dump(this.swigCPtr, this);
    }

    public boolean isIdentifier(int n) {
        return ealswigJNI.eal_CCacheLRU_isIdentifier(this.swigCPtr, this, n);
    }

    public boolean setCallback(ICacheCallback iCacheCallback) {
        return ealswigJNI.eal_CCacheLRU_setCallback(this.swigCPtr, this, ICacheCallback.getCPtr(iCacheCallback), iCacheCallback);
    }

    public boolean destroyIdentifier(int n) {
        return ealswigJNI.eal_CCacheLRU_destroyIdentifier(this.swigCPtr, this, n);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    public static final class cacheMode_t {
        public static final cacheMode_t CACHE_MODE_DURATION = new cacheMode_t("CACHE_MODE_DURATION");
        public static final cacheMode_t CACHE_MODE_AMOUNT = new cacheMode_t("CACHE_MODE_AMOUNT");
        public static final cacheMode_t CACHE_MODE_SIZE = new cacheMode_t("CACHE_MODE_SIZE");
        private static cacheMode_t[] swigValues = new cacheMode_t[]{CACHE_MODE_DURATION, CACHE_MODE_AMOUNT, CACHE_MODE_SIZE};
        private static int swigNext = 0;
        private final int swigValue;
        private final String swigName;

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static cacheMode_t swigToEnum(int n) {
            if (n < swigValues.length && n >= 0 && cacheMode_t.swigValues[n].swigValue == n) {
                return swigValues[n];
            }
            for (int i2 = 0; i2 < swigValues.length; ++i2) {
                if (cacheMode_t.swigValues[i2].swigValue != n) continue;
                return swigValues[i2];
            }
            throw new IllegalArgumentException("No enum " + (class$de$esolutions$graphics$eal$CCacheLRU$cacheMode_t == null ? (class$de$esolutions$graphics$eal$CCacheLRU$cacheMode_t = CCacheLRU.class$("de.esolutions.graphics.eal.CCacheLRU$cacheMode_t")) : class$de$esolutions$graphics$eal$CCacheLRU$cacheMode_t) + " with value " + n);
        }

        private cacheMode_t(String string) {
            this.swigName = string;
            this.swigValue = swigNext++;
        }

        private cacheMode_t(String string, int n) {
            this.swigName = string;
            this.swigValue = n;
            swigNext = n + 1;
        }

        private cacheMode_t(String string, cacheMode_t cacheMode_t2) {
            this.swigName = string;
            this.swigValue = cacheMode_t2.swigValue;
            swigNext = this.swigValue + 1;
        }
    }
}

