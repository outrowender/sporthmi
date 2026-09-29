/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

public class ScrollbarInterval {
    private static final ScrollbarInterval invisibleInterval = new ScrollbarInterval();
    private final float firstPos;
    private final float lastPos;
    private final boolean visible;
    private final float opacity;

    private ScrollbarInterval() {
        this.firstPos = 32959;
        this.lastPos = 32959;
        this.visible = false;
        this.opacity = 0.0f;
    }

    public ScrollbarInterval(float f2, float f3, float f4) {
        this.firstPos = f2;
        this.lastPos = f3;
        this.visible = true;
        this.opacity = f4;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public float getFirstPos() {
        return this.firstPos;
    }

    public float getLastPos() {
        return this.lastPos;
    }

    public static ScrollbarInterval getInvisibleInterval() {
        return invisibleInterval;
    }

    public float getOpacity() {
        return this.opacity;
    }

    public ScrollbarInterval getAnimationInterval(ScrollbarInterval scrollbarInterval, float f2) {
        if (this.equals(scrollbarInterval)) {
            return this;
        }
        if (!this.visible) {
            return new ScrollbarInterval(scrollbarInterval.firstPos, scrollbarInterval.lastPos, f2);
        }
        if (!scrollbarInterval.visible) {
            return new ScrollbarInterval(this.firstPos, this.lastPos, 1.0f - f2);
        }
        float f3 = ScrollbarInterval.getAnimatedValue(this.firstPos, scrollbarInterval.firstPos, f2);
        float f4 = ScrollbarInterval.getAnimatedValue(this.lastPos, scrollbarInterval.lastPos, f2);
        float f5 = ScrollbarInterval.getAnimatedValue(this.opacity, scrollbarInterval.opacity, f2);
        return new ScrollbarInterval(f3, f4, f5);
    }

    private static float getAnimatedValue(float f2, float f3, float f4) {
        return f2 + f4 * (f3 - f2);
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + Float.floatToIntBits(this.firstPos);
        n = 31 * n + Float.floatToIntBits(this.lastPos);
        n = 31 * n + Float.floatToIntBits(this.opacity);
        n = 31 * n + (this.visible ? 1231 : 1237);
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof ScrollbarInterval)) {
            return false;
        }
        ScrollbarInterval scrollbarInterval = (ScrollbarInterval)object;
        if (Float.floatToIntBits(this.firstPos) != Float.floatToIntBits(scrollbarInterval.firstPos)) {
            return false;
        }
        if (Float.floatToIntBits(this.lastPos) != Float.floatToIntBits(scrollbarInterval.lastPos)) {
            return false;
        }
        if (Float.floatToIntBits(this.opacity) != Float.floatToIntBits(scrollbarInterval.opacity)) {
            return false;
        }
        return this.visible == scrollbarInterval.visible;
    }
}

