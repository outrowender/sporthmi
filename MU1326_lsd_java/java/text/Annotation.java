/*
 * Decompiled with CFR 0.152.
 */
package java.text;

public class Annotation {
    private Object value;

    public Annotation(Object object) {
        this.value = object;
    }

    public Object getValue() {
        return this.value;
    }

    public String toString() {
        return String.valueOf(this.getClass().getName()) + "[value=" + this.value + ']';
    }
}

