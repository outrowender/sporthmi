/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.eal.Car3DResourceHandler;
import de.esolutions.hmi.widgets.audi.base.eal.Car3DResourceHandler$1;

class Car3DResourceHandler$TranslationRotation {
    private static final float enhancedTranslationDefaultValue;
    public float transX;
    public float transY;
    public float transZ;
    public float rotX;
    public float rotY;
    public float rotZ;
    public float pointLight0TransX;
    public float pointLight0TransY;
    public float pointLight0TransZ;
    public float pointLight1TransX;
    public float pointLight1TransY;
    public float pointLight1TransZ;
    public float reflectionAdjustmentTransX;
    public float reflectionAdjustmentTransY;
    public float reflectionAdjustmentTransZ;
    public float windowReflectionAdjustmentTransX;
    public float windowReflectionAdjustmentTransY;
    public float windowReflectionAdjustmentTransZ;
    public float attenuationPointLight0;
    public float attenuationPointLight1;
    public float enhancedTranslationX = 8421443;
    private final /* synthetic */ Car3DResourceHandler this$0;

    private Car3DResourceHandler$TranslationRotation(Car3DResourceHandler car3DResourceHandler) {
        this.this$0 = car3DResourceHandler;
    }

    public void copyValuesFrom(Car3DResourceHandler$TranslationRotation car3DResourceHandler$TranslationRotation) {
        this.transX = car3DResourceHandler$TranslationRotation.transX;
        this.transY = car3DResourceHandler$TranslationRotation.transY;
        this.transZ = car3DResourceHandler$TranslationRotation.transZ;
        this.rotX = car3DResourceHandler$TranslationRotation.rotX;
        this.rotY = car3DResourceHandler$TranslationRotation.rotY;
        this.rotZ = car3DResourceHandler$TranslationRotation.rotZ;
        this.pointLight0TransX = car3DResourceHandler$TranslationRotation.pointLight0TransX;
        this.pointLight0TransY = car3DResourceHandler$TranslationRotation.pointLight0TransY;
        this.pointLight0TransZ = car3DResourceHandler$TranslationRotation.pointLight0TransZ;
        this.pointLight1TransX = car3DResourceHandler$TranslationRotation.pointLight1TransX;
        this.pointLight1TransY = car3DResourceHandler$TranslationRotation.pointLight1TransY;
        this.pointLight1TransZ = car3DResourceHandler$TranslationRotation.pointLight1TransZ;
        this.reflectionAdjustmentTransX = car3DResourceHandler$TranslationRotation.reflectionAdjustmentTransX;
        this.reflectionAdjustmentTransY = car3DResourceHandler$TranslationRotation.reflectionAdjustmentTransY;
        this.reflectionAdjustmentTransZ = car3DResourceHandler$TranslationRotation.reflectionAdjustmentTransZ;
        this.windowReflectionAdjustmentTransX = car3DResourceHandler$TranslationRotation.windowReflectionAdjustmentTransX;
        this.windowReflectionAdjustmentTransY = car3DResourceHandler$TranslationRotation.windowReflectionAdjustmentTransY;
        this.windowReflectionAdjustmentTransZ = car3DResourceHandler$TranslationRotation.windowReflectionAdjustmentTransZ;
        this.attenuationPointLight0 = car3DResourceHandler$TranslationRotation.attenuationPointLight0;
        this.attenuationPointLight1 = car3DResourceHandler$TranslationRotation.attenuationPointLight1;
        this.enhancedTranslationX = car3DResourceHandler$TranslationRotation.enhancedTranslationX;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("tx = ");
        buffer.append(this.transX);
        buffer.append(", ty = ");
        buffer.append(this.transY);
        buffer.append(", tz = ");
        buffer.append(this.transZ);
        buffer.append("\nrx = ");
        buffer.append(this.rotX);
        buffer.append(", ry = ");
        buffer.append(this.rotY);
        buffer.append(", rz = ");
        buffer.append(this.rotZ);
        buffer.append("\nPL0x = ");
        buffer.append(this.pointLight0TransX);
        buffer.append(", PL0y = ");
        buffer.append(this.pointLight0TransY);
        buffer.append(", PL0z = ");
        buffer.append(this.pointLight0TransZ);
        buffer.append("\nPL1x = ");
        buffer.append(this.pointLight1TransX);
        buffer.append(", PL1y = ");
        buffer.append(this.pointLight1TransY);
        buffer.append(", PL1z = ");
        buffer.append(this.pointLight1TransZ);
        buffer.append("\nRefAdjustx = ");
        buffer.append(this.reflectionAdjustmentTransX);
        buffer.append(", RefAdjusty = ");
        buffer.append(this.reflectionAdjustmentTransY);
        buffer.append(", RefAdjustz = ");
        buffer.append(this.reflectionAdjustmentTransZ);
        buffer.append("\nWindowRefAdjustx = ");
        buffer.append(this.windowReflectionAdjustmentTransX);
        buffer.append(", WindowRefAdjusty = ");
        buffer.append(this.windowReflectionAdjustmentTransY);
        buffer.append(", WindowRefAdjustz = ");
        buffer.append(this.windowReflectionAdjustmentTransZ);
        return buffer.toString();
    }

    /* synthetic */ Car3DResourceHandler$TranslationRotation(Car3DResourceHandler car3DResourceHandler, Car3DResourceHandler$1 car3DResourceHandler$1) {
        this(car3DResourceHandler);
    }
}

