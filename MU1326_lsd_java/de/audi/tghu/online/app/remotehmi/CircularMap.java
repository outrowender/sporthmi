/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import java.util.HashMap;
import java.util.Map;

public class CircularMap {
    private final int ringSize;
    private final Map map = new HashMap();
    private final Object[] ring;
    private int nextInsertPosition;

    public CircularMap(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException(new StringBuffer().append("CircularMap#constructor: maximum size must be > 0, but maxSize=").append(n).toString());
        }
        this.ringSize = n;
        this.ring = new Object[n];
    }

    public Object get(Object object) {
        return this.map.get(object);
    }

    public boolean containsKey(Object object) {
        return this.map.containsKey(object);
    }

    public void put(Object object, Object object2) {
        if (object == null) {
            throw new IllegalArgumentException("CircularMap#put: null key is not allowed!");
        }
        if (!this.map.containsKey(object)) {
            Object object3 = this.ring[this.nextInsertPosition];
            if (object3 != null) {
                this.map.remove(object3);
            }
            this.ring[this.nextInsertPosition] = object;
            this.nextInsertPosition = (this.nextInsertPosition + 1) % this.ringSize;
        }
        this.map.put(object, object2);
    }

    public Object removeLastKey() {
        int n = (this.nextInsertPosition + this.ringSize - 1) % this.ringSize;
        Object object = this.ring[n];
        if (object != null) {
            this.map.remove(object);
            this.ring[n] = null;
            this.nextInsertPosition = n;
            return object;
        }
        return null;
    }
}

