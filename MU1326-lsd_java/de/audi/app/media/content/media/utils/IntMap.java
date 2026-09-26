/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.utils;

import de.audi.app.media.content.media.utils.Integers;
import de.audi.app.media.content.media.utils.NoMapElementException;
import java.util.HashMap;

public class IntMap {
    private HashMap map;

    public IntMap(int n) {
        this.map = new HashMap(n);
    }

    public void put(int n, int n2) {
        this.map.put(Integers.valueOf(n), Integers.valueOf(n2));
    }

    public boolean containsValue(int n) {
        return this.map.containsValue(Integers.valueOf(n));
    }

    public boolean containsKey(int n) {
        return this.map.containsKey(Integers.valueOf(n));
    }

    public int get(int n) {
        Object object = this.map.get(Integers.valueOf(n));
        if (object == null) {
            throw new NoMapElementException(new StringBuffer().append("The element for the key ").append(n).append(" was not found!").toString());
        }
        return (Integer)object;
    }
}

