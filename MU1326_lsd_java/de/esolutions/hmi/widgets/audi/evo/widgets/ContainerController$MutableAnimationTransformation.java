/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController$AnimationTransformation;

public class ContainerController$MutableAnimationTransformation
implements ContainerController$AnimationTransformation {
    private float transX;
    private float transY;
    private float scale;
    private float opacity;

    public ContainerController$MutableAnimationTransformation(float f2, float f3, float f4, float f5) {
        this.transX = f2;
        this.transY = f3;
        this.scale = f4;
        this.opacity = f5;
    }

    public ContainerController$MutableAnimationTransformation(ContainerController$AnimationTransformation containerController$AnimationTransformation) {
        this.transX = containerController$AnimationTransformation.getTransX();
        this.transY = containerController$AnimationTransformation.getTransY();
        this.scale = containerController$AnimationTransformation.getScale();
        this.opacity = containerController$AnimationTransformation.getOpacity();
    }

    public ContainerController$MutableAnimationTransformation() {
        this(ContainerController.access$000());
    }

    @Override
    public ContainerController$MutableAnimationTransformation getIntermediateTransformation(ContainerController$MutableAnimationTransformation containerController$MutableAnimationTransformation, ContainerController$AnimationTransformation containerController$AnimationTransformation, float f2) {
        if (containerController$AnimationTransformation == null) {
            ContainerController.access$100().log(-2137614336, "ContainerController#MutableAnimationTransformation#getIntermediateTransformation: targetTransformation is null");
            return null;
        }
        float f3 = ContainerController$MutableAnimationTransformation.getAnimatedValue(this.transX, containerController$AnimationTransformation.getTransX(), f2);
        float f4 = ContainerController$MutableAnimationTransformation.getAnimatedValue(this.transY, containerController$AnimationTransformation.getTransY(), f2);
        float f5 = ContainerController$MutableAnimationTransformation.getAnimatedValue(this.scale, containerController$AnimationTransformation.getScale(), f2);
        float f6 = ContainerController$MutableAnimationTransformation.getAnimatedValue(this.opacity, containerController$AnimationTransformation.getOpacity(), f2);
        if (containerController$MutableAnimationTransformation == null) {
            containerController$MutableAnimationTransformation = new ContainerController$MutableAnimationTransformation();
        }
        return containerController$MutableAnimationTransformation.setTranslation(f3, f4, 0.0f).setScale(f5).setOpacity(f6);
    }

    @Override
    public ContainerController$MutableAnimationTransformation copyTo(ContainerController$MutableAnimationTransformation containerController$MutableAnimationTransformation) {
        containerController$MutableAnimationTransformation.setTranslation(this.transX, this.transY, 0.0f);
        containerController$MutableAnimationTransformation.setScale(this.scale);
        containerController$MutableAnimationTransformation.setOpacity(this.opacity);
        return this;
    }

    public ContainerController$MutableAnimationTransformation copyFrom(ContainerController$AnimationTransformation containerController$AnimationTransformation) {
        this.transX = containerController$AnimationTransformation.getTransX();
        this.transY = containerController$AnimationTransformation.getTransY();
        this.scale = containerController$AnimationTransformation.getScale();
        this.opacity = containerController$AnimationTransformation.getOpacity();
        return this;
    }

    private static float getAnimatedValue(float f2, float f3, float f4) {
        return f2 + f4 * (f3 - f2);
    }

    public ContainerController$MutableAnimationTransformation setOpacity(float f2) {
        this.opacity = f2;
        return this;
    }

    public ContainerController$MutableAnimationTransformation setScale(float f2) {
        this.scale = f2;
        return this;
    }

    public ContainerController$MutableAnimationTransformation move(float f2, float f3, float f4) {
        this.transX += f2;
        this.transY += f3;
        return this;
    }

    public ContainerController$MutableAnimationTransformation setTranslation(float f2, float f3, float f4) {
        this.transX = f2;
        this.transY = f3;
        return this;
    }

    @Override
    public float getTransX() {
        return this.transX;
    }

    @Override
    public float getTransY() {
        return this.transY;
    }

    @Override
    public float getScale() {
        return this.scale;
    }

    @Override
    public float getOpacity() {
        return this.opacity;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + Float.floatToIntBits(this.opacity);
        n = 31 * n + Float.floatToIntBits(this.scale);
        n = 31 * n + Float.floatToIntBits(this.transX);
        n = 31 * n + Float.floatToIntBits(this.transY);
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof ContainerController$MutableAnimationTransformation)) {
            return false;
        }
        ContainerController$MutableAnimationTransformation containerController$MutableAnimationTransformation = (ContainerController$MutableAnimationTransformation)object;
        if (Float.floatToIntBits(this.opacity) != Float.floatToIntBits(containerController$MutableAnimationTransformation.opacity)) {
            return false;
        }
        if (Float.floatToIntBits(this.scale) != Float.floatToIntBits(containerController$MutableAnimationTransformation.scale)) {
            return false;
        }
        if (Float.floatToIntBits(this.transX) != Float.floatToIntBits(containerController$MutableAnimationTransformation.transX)) {
            return false;
        }
        return Float.floatToIntBits(this.transY) == Float.floatToIntBits(containerController$MutableAnimationTransformation.transY);
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("[x=").append(this.transX);
        buffer.append(", y=").append(this.transY);
        buffer.append(", scale=").append(this.scale);
        buffer.append(", opacity=").append(this.opacity).append(']');
        return buffer.toString();
    }

    public ContainerController$MutableAnimationTransformation combine(ContainerController$AnimationTransformation containerController$AnimationTransformation) {
        this.transX += containerController$AnimationTransformation.getTransX();
        this.transY += containerController$AnimationTransformation.getTransY();
        this.scale *= containerController$AnimationTransformation.getScale();
        this.opacity *= containerController$AnimationTransformation.getOpacity();
        return this;
    }

    public ContainerController$MutableAnimationTransformation multiplyOpacity(float f2) {
        this.opacity *= f2;
        return this;
    }

    public ContainerController$MutableAnimationTransformation resetToIdentityTransformation() {
        this.transX = 0.0f;
        this.transY = 0.0f;
        this.scale = 1.0f;
        this.opacity = 1.0f;
        return this;
    }

    static /* synthetic */ float access$200(ContainerController$MutableAnimationTransformation containerController$MutableAnimationTransformation) {
        return containerController$MutableAnimationTransformation.opacity;
    }
}

