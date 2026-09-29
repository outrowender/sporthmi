/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

public class AbstractPlaceholderMenuController$AnimatedFloatProperty {
    private float current;
    private float start;
    private float target;

    public AbstractPlaceholderMenuController$AnimatedFloatProperty(float f2) {
        this.current = f2;
        this.start = f2;
        this.target = f2;
    }

    public float getCurrent() {
        return this.current;
    }

    public float getStart() {
        return this.start;
    }

    public float getTarget() {
        return this.target;
    }

    public float setProgress(float f2) {
        this.current = f2 >= 1.0f ? this.target : (f2 <= 0.0f ? this.start : this.start + (this.target - this.start) * f2);
        return this.current;
    }

    public void setUnanimatedValue(float f2) {
        this.current = f2;
        this.start = f2;
        this.target = f2;
    }

    public boolean updateTarget(float f2) {
        this.start = this.current;
        this.target = f2;
        return this.current != f2;
    }
}

