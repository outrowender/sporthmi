/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.graphics.eal.api;

import de.esolutions.graphics.eal.Mat3f;
import de.esolutions.graphics.eal.Mat4f;
import de.esolutions.graphics.eal.Vec2f;
import de.esolutions.graphics.eal.Vec3f;
import de.esolutions.graphics.eal.Vec4f;
import de.esolutions.graphics.eal.api.IMaterial;
import de.esolutions.graphics.eal.api.INode3D;
import de.esolutions.graphics.eal.api.IObject;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.graphics.eal.colorRGBAf;
import de.esolutions.graphics.eal.propertyType_t;
import de.esolutions.graphics.ealswigJNI;

public class IProperty
extends IObject {
    private long swigCPtr;

    public IProperty(long l, boolean bl) {
        super(ealswigJNI.eal_api_IProperty_SWIGUpcast(l), bl);
        this.swigCPtr = l;
    }

    public static long getCPtr(IProperty iProperty) {
        return iProperty == null ? 0L : iProperty.swigCPtr;
    }

    @Override
    protected void finalize() {
        this.delete();
    }

    @Override
    public synchronized void delete() {
        if (this.swigCPtr != 0L) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ealswigJNI.delete_eal_api_IProperty(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override
    public boolean isDeleted() {
        return this.swigCPtr == 0L;
    }

    public boolean set(int n) {
        return ealswigJNI.eal_api_IProperty_set__SWIG_0(this.swigCPtr, this, n);
    }

    public boolean set(float f2) {
        return ealswigJNI.eal_api_IProperty_set__SWIG_1(this.swigCPtr, this, f2);
    }

    public boolean set(boolean bl) {
        return ealswigJNI.eal_api_IProperty_set__SWIG_2(this.swigCPtr, this, bl);
    }

    public boolean set(String string) {
        return ealswigJNI.eal_api_IProperty_set__SWIG_3(this.swigCPtr, this, string);
    }

    public boolean set(colorRGBAf colorRGBAf2) {
        return ealswigJNI.eal_api_IProperty_set__SWIG_4(this.swigCPtr, this, colorRGBAf.getCPtr(colorRGBAf2), colorRGBAf2);
    }

    public boolean setColor(long l) {
        return ealswigJNI.eal_api_IProperty_setColor(this.swigCPtr, this, l);
    }

    public boolean set(ITexture iTexture) {
        return ealswigJNI.eal_api_IProperty_set__SWIG_5(this.swigCPtr, this, ITexture.getCPtr(iTexture), iTexture);
    }

    public boolean set(INode3D iNode3D) {
        return ealswigJNI.eal_api_IProperty_set__SWIG_6(this.swigCPtr, this, INode3D.getCPtr(iNode3D), iNode3D);
    }

    public boolean set(IMaterial iMaterial) {
        return ealswigJNI.eal_api_IProperty_set__SWIG_7(this.swigCPtr, this, IMaterial.getCPtr(iMaterial), iMaterial);
    }

    public boolean set(Vec2f vec2f) {
        return ealswigJNI.eal_api_IProperty_set__SWIG_8(this.swigCPtr, this, Vec2f.getCPtr(vec2f), vec2f);
    }

    public boolean set(Vec3f vec3f) {
        return ealswigJNI.eal_api_IProperty_set__SWIG_9(this.swigCPtr, this, Vec3f.getCPtr(vec3f), vec3f);
    }

    public boolean set(Vec4f vec4f) {
        return ealswigJNI.eal_api_IProperty_set__SWIG_10(this.swigCPtr, this, Vec4f.getCPtr(vec4f), vec4f);
    }

    public boolean setDefault() {
        return ealswigJNI.eal_api_IProperty_setDefault(this.swigCPtr, this);
    }

    public int getInt() {
        return ealswigJNI.eal_api_IProperty_getInt(this.swigCPtr, this);
    }

    public float getFloat() {
        return ealswigJNI.eal_api_IProperty_getFloat(this.swigCPtr, this);
    }

    public boolean getBool() {
        return ealswigJNI.eal_api_IProperty_getBool(this.swigCPtr, this);
    }

    public String getString() {
        return ealswigJNI.eal_api_IProperty_getString(this.swigCPtr, this);
    }

    public colorRGBAf getColor() {
        return new colorRGBAf(ealswigJNI.eal_api_IProperty_getColor(this.swigCPtr, this), true);
    }

    public long getColorAsInt() {
        return ealswigJNI.eal_api_IProperty_getColorAsInt(this.swigCPtr, this);
    }

    public Vec2f getVec2D() {
        return new Vec2f(ealswigJNI.eal_api_IProperty_getVec2D(this.swigCPtr, this), true);
    }

    public Vec3f getVec3D() {
        return new Vec3f(ealswigJNI.eal_api_IProperty_getVec3D(this.swigCPtr, this), true);
    }

    public Vec4f getVec4D() {
        return new Vec4f(ealswigJNI.eal_api_IProperty_getVec4D(this.swigCPtr, this), true);
    }

    public ITexture getTexture() {
        long l = ealswigJNI.eal_api_IProperty_getTexture(this.swigCPtr, this);
        return l == 0L ? null : new ITexture(l, true);
    }

    public INode3D getNode3D() {
        long l = ealswigJNI.eal_api_IProperty_getNode3D(this.swigCPtr, this);
        return l == 0L ? null : new INode3D(l, true);
    }

    public IMaterial getMaterial() {
        long l = ealswigJNI.eal_api_IProperty_getMaterial(this.swigCPtr, this);
        return l == 0L ? null : new IMaterial(l, true);
    }

    @Override
    public boolean isValid() {
        return ealswigJNI.eal_api_IProperty_isValid(this.swigCPtr, this);
    }

    public propertyType_t getType() {
        return propertyType_t.swigToEnum(ealswigJNI.eal_api_IProperty_getType(this.swigCPtr, this));
    }

    @Override
    public void dispose() {
        ealswigJNI.eal_api_IProperty_dispose(this.swigCPtr, this);
    }

    public boolean remove() {
        return ealswigJNI.eal_api_IProperty_remove(this.swigCPtr, this);
    }

    public String getName() {
        return ealswigJNI.eal_api_IProperty_getName(this.swigCPtr, this);
    }

    public Mat3f getMatrix3x3() {
        return new Mat3f(ealswigJNI.eal_api_IProperty_getMatrix3x3(this.swigCPtr, this), true);
    }

    public Mat4f getMatrix4x4() {
        return new Mat4f(ealswigJNI.eal_api_IProperty_getMatrix4x4(this.swigCPtr, this), true);
    }
}

