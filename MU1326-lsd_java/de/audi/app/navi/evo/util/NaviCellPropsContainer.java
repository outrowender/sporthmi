/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class NaviCellPropsContainer {
    private int category;
    private Set properties = new HashSet();

    public void addProperty(int n) {
        this.properties.add(new Integer(n));
    }

    public void removeProperty(int n) {
        this.properties.remove(new Integer(n));
    }

    public int[] getProperties() {
        int[] nArray = new int[this.properties.size()];
        Iterator iterator = this.properties.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            nArray[n] = (Integer)iterator.next();
            ++n;
        }
        return nArray;
    }

    public int getCategory() {
        return this.category;
    }

    public void setCategory(int n) {
        this.category = n;
    }
}

