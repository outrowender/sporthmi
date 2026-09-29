/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.balancefader;

import de.esolutions.fw.util.commons.Buffer;

public class ValuePair {
    private float x;
    private float y;

    public ValuePair() {
        this.x = 0.0f;
        this.y = 0.0f;
    }

    public ValuePair(float f2, float f3) {
        this.x = f2;
        this.y = f3;
    }

    public ValuePair(ValuePair valuePair) {
        this.x = valuePair.getX();
        this.y = valuePair.getY();
    }

    public ValuePair add(ValuePair valuePair) {
        float f2 = this.x + valuePair.getX();
        float f3 = this.y + valuePair.getY();
        return new ValuePair(f2, f3);
    }

    public ValuePair add(float f2) {
        float f3 = this.x + f2;
        float f4 = this.y + f2;
        return new ValuePair(f3, f4);
    }

    public ValuePair add(float f2, float f3) {
        float f4 = this.x + f2;
        float f5 = this.y + f3;
        return new ValuePair(f4, f5);
    }

    public ValuePair subtract(ValuePair valuePair) {
        float f2 = this.x - valuePair.getX();
        float f3 = this.y - valuePair.getY();
        return new ValuePair(f2, f3);
    }

    public ValuePair subtract(float f2) {
        float f3 = this.x - f2;
        float f4 = this.y - f2;
        return new ValuePair(f3, f4);
    }

    public ValuePair multiplyWith(ValuePair valuePair) {
        float f2 = this.x * valuePair.getX();
        float f3 = this.y * valuePair.getY();
        return new ValuePair(f2, f3);
    }

    public ValuePair multiplyWith(float f2) {
        float f3 = this.x * f2;
        float f4 = this.y * f2;
        return new ValuePair(f3, f4);
    }

    public ValuePair divideBy(ValuePair valuePair) {
        float f2 = this.x;
        float f3 = this.y;
        if (valuePair.getX() != 0.0f) {
            f2 = this.x / valuePair.getX();
        }
        if (valuePair.getY() != 0.0f) {
            f3 = this.y / valuePair.getY();
        }
        return new ValuePair(f2, f3);
    }

    public ValuePair divideBy(float f2) {
        float f3 = this.x;
        float f4 = this.y;
        if (f2 != 0.0f) {
            f3 = this.x / f2;
            f4 = this.y / f2;
        }
        return new ValuePair(f3, f4);
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + Float.floatToIntBits(this.x);
        n = 31 * n + Float.floatToIntBits(this.y);
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof ValuePair)) {
            return false;
        }
        ValuePair valuePair = (ValuePair)object;
        if (Float.floatToIntBits(this.x) != Float.floatToIntBits(valuePair.x)) {
            return false;
        }
        return Float.floatToIntBits(this.y) == Float.floatToIntBits(valuePair.y);
    }

    public float getY() {
        return this.y;
    }

    public float getX() {
        return this.x;
    }

    public void setX(float f2) {
        this.x = f2;
    }

    public void setY(float f2) {
        this.y = f2;
    }

    public void setXY(ValuePair valuePair) {
        this.x = valuePair.getX();
        this.y = valuePair.getY();
    }

    public void setXY(float f2, float f3) {
        this.x = f2;
        this.y = f3;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("[ ").append(this.x).append(", ").append(this.y).append(" ]");
        return buffer.toString();
    }

    public ValuePair norm(ValuePair valuePair, ValuePair valuePair2) {
        ValuePair valuePair3 = this.subtract(valuePair);
        ValuePair valuePair4 = valuePair2.subtract(valuePair);
        valuePair3 = valuePair3.divideBy(valuePair4);
        return valuePair3;
    }

    public ValuePair clamp(float f2, float f3) {
        float f4 = Math.min(Math.max(f2, this.x), f3);
        float f5 = Math.min(Math.max(f2, this.y), f3);
        return new ValuePair(f4, f5);
    }
}

