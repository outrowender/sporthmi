/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.api.IFontGroupFontHandle;
import de.esolutions.graphics.eal.api.IFontList;
import de.esolutions.graphics.eal.api.IManager;
import de.esolutions.graphics.eal.api.IObject;
import de.esolutions.graphics.ealswigJNI;

public class IFontGroup
extends IObject {
    private long swigCPtr;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$api$IFontGroup$loadingStrategy_t;

    public IFontGroup(long l, boolean bl) {
        super(ealswigJNI.eal_api_IFontGroup_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(IFontGroup iFontGroup) {
        return iFontGroup == null ? 0L : iFontGroup.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_api_IFontGroup(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public IFontGroup(IManager iManager) {
        this(ealswigJNI.new_eal_api_IFontGroup__SWIG_0(IManager.getCPtr(iManager), iManager), true);
    }

    public IFontGroup(IManager iManager, loadingStrategy_t loadingStrategy_t2) {
        this(ealswigJNI.new_eal_api_IFontGroup__SWIG_1(IManager.getCPtr(iManager), iManager, loadingStrategy_t2.swigValue()), true);
    }

    public IFontGroup(IManager iManager, IFontList iFontList, String string, short s) {
        this(ealswigJNI.new_eal_api_IFontGroup__SWIG_2(IManager.getCPtr(iManager), iManager, IFontList.getCPtr(iFontList), iFontList, string, s), true);
    }

    public IFontGroup(IManager iManager, IFontList iFontList, String string, short s, loadingStrategy_t loadingStrategy_t2) {
        this(ealswigJNI.new_eal_api_IFontGroup__SWIG_3(IManager.getCPtr(iManager), iManager, IFontList.getCPtr(iFontList), iFontList, string, s, loadingStrategy_t2.swigValue()), true);
    }

    public void dispose() {
        ealswigJNI.eal_api_IFontGroup_dispose(this.swigCPtr, this);
    }

    public boolean isValid() {
        return ealswigJNI.eal_api_IFontGroup_isValid(this.swigCPtr, this);
    }

    public boolean destroy() {
        return ealswigJNI.eal_api_IFontGroup_destroy(this.swigCPtr, this);
    }

    public IFontGroupFontHandle addFont(String string) {
        long l = ealswigJNI.eal_api_IFontGroup_addFont__SWIG_0(this.swigCPtr, this, string);
        return l == 0L ? null : new IFontGroupFontHandle(l, true);
    }

    public IFontGroupFontHandle addFont(String string, long l) {
        long l2 = ealswigJNI.eal_api_IFontGroup_addFont__SWIG_1(this.swigCPtr, this, string, l);
        return l2 == 0L ? null : new IFontGroupFontHandle(l2, true);
    }

    public boolean addUnicodeRange(long l, long l2, long l3) {
        return ealswigJNI.eal_api_IFontGroup_addUnicodeRange(this.swigCPtr, this, l, l2, l3);
    }

    public boolean linkUnicodeRanges(String string) {
        return ealswigJNI.eal_api_IFontGroup_linkUnicodeRanges(this.swigCPtr, this, string);
    }

    public boolean linkDefaultFont(IFontGroupFontHandle iFontGroupFontHandle) {
        return ealswigJNI.eal_api_IFontGroup_linkDefaultFont(this.swigCPtr, this, IFontGroupFontHandle.getCPtr(iFontGroupFontHandle), iFontGroupFontHandle);
    }

    public boolean activate() {
        return ealswigJNI.eal_api_IFontGroup_activate(this.swigCPtr, this);
    }

    public boolean overwriteNotDefGlyph(long l) {
        return ealswigJNI.eal_api_IFontGroup_overwriteNotDefGlyph(this.swigCPtr, this, l);
    }

    public int getAscent(long l) {
        return ealswigJNI.eal_api_IFontGroup_getAscent(this.swigCPtr, this, l);
    }

    public int getDescent(long l) {
        return ealswigJNI.eal_api_IFontGroup_getDescent(this.swigCPtr, this, l);
    }

    public boolean setSize(long l) {
        return ealswigJNI.eal_api_IFontGroup_setSize(this.swigCPtr, this, l);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    public static final class loadingStrategy_t {
        public static final loadingStrategy_t LOADING_STRATEGY_IMMEDIATELY = new loadingStrategy_t("LOADING_STRATEGY_IMMEDIATELY");
        public static final loadingStrategy_t LOADING_STRATEGY_LAZY = new loadingStrategy_t("LOADING_STRATEGY_LAZY");
        private static loadingStrategy_t[] swigValues = new loadingStrategy_t[]{LOADING_STRATEGY_IMMEDIATELY, LOADING_STRATEGY_LAZY};
        private static int swigNext = 0;
        private final int swigValue;
        private final String swigName;

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static loadingStrategy_t swigToEnum(int n) {
            if (n < swigValues.length && n >= 0 && loadingStrategy_t.swigValues[n].swigValue == n) {
                return swigValues[n];
            }
            for (int i2 = 0; i2 < swigValues.length; ++i2) {
                if (loadingStrategy_t.swigValues[i2].swigValue != n) continue;
                return swigValues[i2];
            }
            throw new IllegalArgumentException("No enum " + (class$de$esolutions$graphics$eal$api$IFontGroup$loadingStrategy_t == null ? (class$de$esolutions$graphics$eal$api$IFontGroup$loadingStrategy_t = IFontGroup.class$("de.esolutions.graphics.eal.api.IFontGroup$loadingStrategy_t")) : class$de$esolutions$graphics$eal$api$IFontGroup$loadingStrategy_t) + " with value " + n);
        }

        private loadingStrategy_t(String string) {
            this.swigName = string;
            this.swigValue = swigNext++;
        }

        private loadingStrategy_t(String string, int n) {
            this.swigName = string;
            this.swigValue = n;
            swigNext = n + 1;
        }

        private loadingStrategy_t(String string, loadingStrategy_t loadingStrategy_t2) {
            this.swigName = string;
            this.swigValue = loadingStrategy_t2.swigValue;
            swigNext = this.swigValue + 1;
        }
    }
}

