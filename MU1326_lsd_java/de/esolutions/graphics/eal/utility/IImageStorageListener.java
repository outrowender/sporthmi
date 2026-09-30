/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.utility;

import de.esolutions.graphics.ealswigJNI;

public class IImageStorageListener {
    private long swigCPtr;
    protected boolean swigCMemOwn;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$utility$IImageStorageListener;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$utility$IImageStorageListener$enType_t;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$utility$IImageStorageListener$enIdent_t;

    public IImageStorageListener(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(IImageStorageListener iImageStorageListener) {
        return iImageStorageListener == null ? 0L : iImageStorageListener.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_utility_IImageStorageListener(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        this.delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        ealswigJNI.eal_utility_IImageStorageListener_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        ealswigJNI.eal_utility_IImageStorageListener_change_ownership(this, this.swigCPtr, true);
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public IImageStorageListener() {
        this(ealswigJNI.new_eal_utility_IImageStorageListener(), true);
        ealswigJNI.eal_utility_IImageStorageListener_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    public void process(enType_t enType_t2, long l) {
        if (this.getClass() == (class$de$esolutions$graphics$eal$utility$IImageStorageListener == null ? (class$de$esolutions$graphics$eal$utility$IImageStorageListener = IImageStorageListener.class$("de.esolutions.graphics.eal.utility.IImageStorageListener")) : class$de$esolutions$graphics$eal$utility$IImageStorageListener)) {
            ealswigJNI.eal_utility_IImageStorageListener_process(this.swigCPtr, this, enType_t2.swigValue(), l);
        } else {
            ealswigJNI.eal_utility_IImageStorageListener_processSwigExplicitIImageStorageListener(this.swigCPtr, this, enType_t2.swigValue(), l);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    public static final class enType_t {
        public static final enType_t TYPE_FINISHED = new enType_t("TYPE_FINISHED");
        public static final enType_t TYPE_ERROR = new enType_t("TYPE_ERROR");
        private static enType_t[] swigValues = new enType_t[]{TYPE_FINISHED, TYPE_ERROR};
        private static int swigNext = 0;
        private final int swigValue;
        private final String swigName;

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static enType_t swigToEnum(int n) {
            if (n < swigValues.length && n >= 0 && enType_t.swigValues[n].swigValue == n) {
                return swigValues[n];
            }
            for (int i2 = 0; i2 < swigValues.length; ++i2) {
                if (enType_t.swigValues[i2].swigValue != n) continue;
                return swigValues[i2];
            }
            throw new IllegalArgumentException("No enum " + (class$de$esolutions$graphics$eal$utility$IImageStorageListener$enType_t == null ? (class$de$esolutions$graphics$eal$utility$IImageStorageListener$enType_t = IImageStorageListener.class$("de.esolutions.graphics.eal.utility.IImageStorageListener$enType_t")) : class$de$esolutions$graphics$eal$utility$IImageStorageListener$enType_t) + " with value " + n);
        }

        private enType_t(String string) {
            this.swigName = string;
            this.swigValue = swigNext++;
        }

        private enType_t(String string, int n) {
            this.swigName = string;
            this.swigValue = n;
            swigNext = n + 1;
        }

        private enType_t(String string, enType_t enType_t2) {
            this.swigName = string;
            this.swigValue = enType_t2.swigValue;
            swigNext = this.swigValue + 1;
        }
    }

    public static final class enIdent_t {
        public static final enIdent_t IDENT_NONE = new enIdent_t("IDENT_NONE", ealswigJNI.eal_utility_IImageStorageListener_IDENT_NONE_get());
        private static enIdent_t[] swigValues = new enIdent_t[]{IDENT_NONE};
        private static int swigNext = 0;
        private final int swigValue;
        private final String swigName;

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static enIdent_t swigToEnum(int n) {
            if (n < swigValues.length && n >= 0 && enIdent_t.swigValues[n].swigValue == n) {
                return swigValues[n];
            }
            for (int i2 = 0; i2 < swigValues.length; ++i2) {
                if (enIdent_t.swigValues[i2].swigValue != n) continue;
                return swigValues[i2];
            }
            throw new IllegalArgumentException("No enum " + (class$de$esolutions$graphics$eal$utility$IImageStorageListener$enIdent_t == null ? (class$de$esolutions$graphics$eal$utility$IImageStorageListener$enIdent_t = IImageStorageListener.class$("de.esolutions.graphics.eal.utility.IImageStorageListener$enIdent_t")) : class$de$esolutions$graphics$eal$utility$IImageStorageListener$enIdent_t) + " with value " + n);
        }

        private enIdent_t(String string) {
            this.swigName = string;
            this.swigValue = swigNext++;
        }

        private enIdent_t(String string, int n) {
            this.swigName = string;
            this.swigValue = n;
            swigNext = n + 1;
        }

        private enIdent_t(String string, enIdent_t enIdent_t2) {
            this.swigName = string;
            this.swigValue = enIdent_t2.swigValue;
            swigNext = this.swigValue + 1;
        }
    }
}

