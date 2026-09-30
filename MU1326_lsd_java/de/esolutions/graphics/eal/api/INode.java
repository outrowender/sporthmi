/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.FlagPrint;
import de.esolutions.graphics.eal.api.IObject;
import de.esolutions.graphics.eal.api.IProperty;
import de.esolutions.graphics.eal.ealPropertyType_t;
import de.esolutions.graphics.eal.nodeType_t;
import de.esolutions.graphics.ealswigJNI;

public class INode
extends IObject {
    private long swigCPtr;
    static /* synthetic */ Class class$de$esolutions$graphics$eal$api$INode$blendMode_t;

    public INode(long l, boolean bl) {
        super(ealswigJNI.eal_api_INode_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(INode iNode) {
        return iNode == null ? 0L : iNode.swigCPtr;
    }

    protected void finalize() {
        this.delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_api_INode(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public boolean clear() {
        return ealswigJNI.eal_api_INode_clear(this.swigCPtr, this);
    }

    public boolean remove(INode iNode) {
        return ealswigJNI.eal_api_INode_remove__SWIG_0(this.swigCPtr, this, INode.getCPtr(iNode), iNode);
    }

    public boolean remove(long l) {
        return ealswigJNI.eal_api_INode_remove__SWIG_1(this.swigCPtr, this, l);
    }

    public long getChildCount() {
        return ealswigJNI.eal_api_INode_getChildCount(this.swigCPtr, this);
    }

    public boolean hasChild(INode iNode) {
        return ealswigJNI.eal_api_INode_hasChild(this.swigCPtr, this, INode.getCPtr(iNode), iNode);
    }

    public boolean setVisible(boolean bl) {
        return ealswigJNI.eal_api_INode_setVisible(this.swigCPtr, this, bl);
    }

    public boolean isVisible() {
        return ealswigJNI.eal_api_INode_isVisible(this.swigCPtr, this);
    }

    public boolean isValid() {
        return ealswigJNI.eal_api_INode_isValid(this.swigCPtr, this);
    }

    public boolean isParent() {
        return ealswigJNI.eal_api_INode_isParent(this.swigCPtr, this);
    }

    public boolean hasProperty(String string) {
        return ealswigJNI.eal_api_INode_hasProperty(this.swigCPtr, this, string);
    }

    public IProperty getProperty(String string) {
        long l = ealswigJNI.eal_api_INode_getProperty__SWIG_0(this.swigCPtr, this, string);
        return l == 0L ? null : new IProperty(l, true);
    }

    public IProperty getProperty(String string, ealPropertyType_t ealPropertyType_t2) {
        long l = ealswigJNI.eal_api_INode_getProperty__SWIG_1(this.swigCPtr, this, string, ealPropertyType_t2.swigValue());
        return l == 0L ? null : new IProperty(l, true);
    }

    public void print() {
        ealswigJNI.eal_api_INode_print__SWIG_0(this.swigCPtr, this);
    }

    public void print(FlagPrint flagPrint) {
        ealswigJNI.eal_api_INode_print__SWIG_1(this.swigCPtr, this, FlagPrint.getCPtr(flagPrint), flagPrint);
    }

    public void printAllProperties() {
        ealswigJNI.eal_api_INode_printAllProperties(this.swigCPtr, this);
    }

    public boolean equals(IObject iObject) {
        return ealswigJNI.eal_api_INode_equals(this.swigCPtr, this, IObject.getCPtr(iObject), iObject);
    }

    public String getName() {
        return ealswigJNI.eal_api_INode_getName(this.swigCPtr, this);
    }

    public boolean setName(String string) {
        return ealswigJNI.eal_api_INode_setName(this.swigCPtr, this, string);
    }

    public boolean copyProperty(INode iNode, IProperty iProperty) {
        return ealswigJNI.eal_api_INode_copyProperty(this.swigCPtr, this, INode.getCPtr(iNode), iNode, IProperty.getCPtr(iProperty), iProperty);
    }

    public boolean setOpacity(float f2, boolean bl) {
        return ealswigJNI.eal_api_INode_setOpacity__SWIG_0(this.swigCPtr, this, f2, bl);
    }

    public boolean setOpacity(float f2) {
        return ealswigJNI.eal_api_INode_setOpacity__SWIG_1(this.swigCPtr, this, f2);
    }

    public float getOpacity() {
        return ealswigJNI.eal_api_INode_getOpacity(this.swigCPtr, this);
    }

    public float getOpacityRecursive() {
        return ealswigJNI.eal_api_INode_getOpacityRecursive(this.swigCPtr, this);
    }

    public void dispose() {
        ealswigJNI.eal_api_INode_dispose(this.swigCPtr, this);
    }

    public boolean invalidateObject() {
        return ealswigJNI.eal_api_INode_invalidateObject(this.swigCPtr, this);
    }

    public boolean invalidateTree() {
        return ealswigJNI.eal_api_INode_invalidateTree(this.swigCPtr, this);
    }

    public nodeType_t getType() {
        return nodeType_t.swigToEnum(ealswigJNI.eal_api_INode_getType(this.swigCPtr, this));
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    public static final class blendMode_t {
        public static final blendMode_t BLENDMODE_OPAQUE = new blendMode_t("BLENDMODE_OPAQUE");
        public static final blendMode_t BLENDMODE_ALPHA = new blendMode_t("BLENDMODE_ALPHA");
        public static final blendMode_t BLENDMODE_ADDITIVE = new blendMode_t("BLENDMODE_ADDITIVE");
        private static blendMode_t[] swigValues = new blendMode_t[]{BLENDMODE_OPAQUE, BLENDMODE_ALPHA, BLENDMODE_ADDITIVE};
        private static int swigNext = 0;
        private final int swigValue;
        private final String swigName;

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static blendMode_t swigToEnum(int n) {
            if (n < swigValues.length && n >= 0 && blendMode_t.swigValues[n].swigValue == n) {
                return swigValues[n];
            }
            for (int i2 = 0; i2 < swigValues.length; ++i2) {
                if (blendMode_t.swigValues[i2].swigValue != n) continue;
                return swigValues[i2];
            }
            throw new IllegalArgumentException("No enum " + (class$de$esolutions$graphics$eal$api$INode$blendMode_t == null ? (class$de$esolutions$graphics$eal$api$INode$blendMode_t = INode.class$("de.esolutions.graphics.eal.api.INode$blendMode_t")) : class$de$esolutions$graphics$eal$api$INode$blendMode_t) + " with value " + n);
        }

        private blendMode_t(String string) {
            this.swigName = string;
            this.swigValue = swigNext++;
        }

        private blendMode_t(String string, int n) {
            this.swigName = string;
            this.swigValue = n;
            swigNext = n + 1;
        }

        private blendMode_t(String string, blendMode_t blendMode_t2) {
            this.swigName = string;
            this.swigValue = blendMode_t2.swigValue;
            swigNext = this.swigValue + 1;
        }
    }
}

