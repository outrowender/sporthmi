/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ParkingFocusPropertyCollection {
    private final Set focusPropertyIDs = new HashSet();

    public void addFocusProperty(int n) {
        this.focusPropertyIDs.add(new Integer(n));
    }

    public int[] getFocusPropertyArray() {
        int[] nArray = new int[this.focusPropertyIDs.size()];
        Iterator iterator = this.focusPropertyIDs.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            nArray[n] = (Integer)iterator.next();
            ++n;
        }
        return nArray;
    }
}

