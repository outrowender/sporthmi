/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.cc;

import de.esolutions.fw.util.commons.IntList;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;

public class ComponentConditionTable {
    private final SimpleIntObjectMap modelConditionsMap = new SimpleIntObjectMap(1000);
    private final SimpleIntObjectMap conditionStateMap = new SimpleIntObjectMap(1000);

    ComponentConditionTable() {
    }

    synchronized boolean updateConditionState(int n, boolean bl) {
        boolean bl2;
        Boolean bl3 = (Boolean)this.conditionStateMap.get(n);
        boolean bl4 = bl2 = bl3 != null ? bl3 : false;
        if (bl3 == null || bl2 != bl) {
            this.conditionStateMap.add(n, bl);
            return true;
        }
        return false;
    }

    synchronized void add(int n, int[] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            IntList intList = (IntList)this.modelConditionsMap.get(nArray[i2]);
            if (intList == null) {
                intList = new IntList(50);
            }
            if (intList.contains(n)) continue;
            intList.add(n);
            this.modelConditionsMap.add(nArray[i2], intList);
        }
    }

    synchronized int[] getConditionIDs(int n) {
        IntList intList = (IntList)this.modelConditionsMap.get(n);
        if (intList == null) {
            return new int[0];
        }
        return intList.toArray();
    }
}

