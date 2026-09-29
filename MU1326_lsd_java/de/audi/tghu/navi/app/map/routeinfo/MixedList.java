/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routeinfo;

import de.audi.tghu.navi.app.map.routeinfo.MixedListItem;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MixedList {
    private List data = new ArrayList();

    public void add(MixedListItem mixedListItem) {
        int n = this.data.indexOf(mixedListItem);
        if (n > 0) {
            this.data.set(n, mixedListItem);
        } else {
            this.data.add(mixedListItem);
        }
    }

    public MixedList add(MixedList mixedList) {
        if (mixedList != null) {
            this.data.addAll(mixedList.data);
        }
        return this;
    }

    public MixedListItem getItem(int n) {
        if (n < this.data.size() && n >= 0) {
            return (MixedListItem)this.data.get(n);
        }
        return null;
    }

    public void sort() {
        Collections.sort(this.data);
    }

    public void clear() {
        this.data.clear();
    }

    public int size() {
        return this.data.size();
    }

    public String toString() {
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < this.size(); ++i2) {
            buffer.append(this.getItem(i2)).append("\n");
        }
        return buffer.toString();
    }

    public void removeItem(int n) {
        this.data.remove(n);
    }

    public void removeItem(MixedListItem mixedListItem) {
        this.data.remove(mixedListItem);
    }

    public boolean containsItem(MixedListItem mixedListItem) {
        return this.data.contains(mixedListItem);
    }
}

