/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.list;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RowMap {
    private final Map indexRowMap = new HashMap(500);
    private final Map uniqueIndexMap = new HashMap(500);

    public void insert(int n, EvoListRow evoListRow) {
        ArrayList arrayList = new ArrayList(this.indexRowMap.keySet());
        Collections.sort(arrayList);
        for (int i2 = arrayList.size() - 1; i2 >= 0; --i2) {
            EvoListRow evoListRow2;
            int n2 = (Integer)arrayList.get(i2);
            if (n2 < n || (evoListRow2 = this.remove(n2)) == null) continue;
            this.set(n2 + 1, evoListRow2);
        }
        this.set(n, evoListRow);
    }

    public void set(int n, EvoListRow evoListRow) {
        this.set(RowMap.createInteger(n), evoListRow);
    }

    public void set(Integer n, EvoListRow evoListRow) {
        if (n == null || n < 0) {
            throw new IllegalArgumentException("Invalid index: " + n);
        }
        if (evoListRow == null) {
            throw new IllegalArgumentException("Row is NULL!");
        }
        Long l = RowMap.createLong(evoListRow.getUniqueID());
        this.indexRowMap.put(n, evoListRow);
        this.uniqueIndexMap.put(l, n);
    }

    public EvoListRow get(int n) {
        return this.get(RowMap.createInteger(n));
    }

    public EvoListRow get(Integer n) {
        return (EvoListRow)this.indexRowMap.get(n);
    }

    public EvoListRow getFirstOccupied() {
        Integer[] integerArray = this.getIndices();
        if (integerArray.length > 0) {
            return this.get(integerArray[0]);
        }
        return null;
    }

    public int getIndex(long l) {
        Integer n = (Integer)this.uniqueIndexMap.get(RowMap.createLong(l));
        if (n == null) {
            return -1;
        }
        return n;
    }

    public EvoListRow remove(int n) {
        EvoListRow evoListRow = (EvoListRow)this.indexRowMap.remove(RowMap.createInteger(n));
        if (evoListRow != null) {
            Long l = RowMap.createLong(evoListRow.getUniqueID());
            this.uniqueIndexMap.remove(l);
        }
        return evoListRow;
    }

    public EvoListRow removeAndShift(int n) {
        EvoListRow evoListRow = this.remove(n);
        if (evoListRow == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.indexRowMap.keySet());
        Collections.sort(arrayList);
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            EvoListRow evoListRow2;
            int n2 = (Integer)arrayList.get(i2);
            if (n2 < n || (evoListRow2 = this.remove(n2)) == null) continue;
            this.set(n2 - 1, evoListRow2);
        }
        return evoListRow;
    }

    public void clear() {
        this.indexRowMap.clear();
        this.uniqueIndexMap.clear();
    }

    public Integer[] getIndices() {
        Set set = this.indexRowMap.keySet();
        return (Integer[])set.toArray(new Integer[set.size()]);
    }

    public boolean containsIndex(int n) {
        return this.indexRowMap.containsKey(RowMap.createInteger(n));
    }

    public boolean containsUniqueID(long l) {
        return this.uniqueIndexMap.containsKey(RowMap.createLong(l));
    }

    private static Integer createInteger(int n) {
        return Util.createInteger(n);
    }

    private static Long createLong(long l) {
        return Util.createLong(l);
    }
}

