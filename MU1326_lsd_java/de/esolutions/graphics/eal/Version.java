/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal;

import de.esolutions.graphics.ealswigJNI;

public class Version {
    private long swigCPtr;
    protected boolean swigCMemOwn;

    public Version(long l, boolean bl) {
        this.swigCMemOwn = bl;
        this.swigCPtr = l;
    }

    public static long getCPtr(Version version) {
        return version == null ? 0L : version.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_Version(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public Version() {
        this(ealswigJNI.new_eal_Version(), true);
    }

    public static void print() {
        ealswigJNI.eal_Version_print();
    }

    public static String verToString() {
        return ealswigJNI.eal_Version_verToString__SWIG_0();
    }

    public static boolean isValid() {
        return ealswigJNI.eal_Version_isValid();
    }

    public static int getVersion() {
        return ealswigJNI.eal_Version_getVersion();
    }

    public static String verToString(int n) {
        return ealswigJNI.eal_Version_verToString__SWIG_1(n);
    }

    public static void setJava(boolean bl) {
        ealswigJNI.eal_Version_setJava(bl);
    }

    public static boolean isJava() {
        return ealswigJNI.eal_Version_isJava();
    }

    public static void registerBinding(int n) {
        ealswigJNI.eal_Version_registerBinding(n);
    }
}

