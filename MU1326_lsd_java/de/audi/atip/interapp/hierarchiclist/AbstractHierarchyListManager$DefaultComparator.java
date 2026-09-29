/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.hierarchiclist;

import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.ListRowComparator;
import de.audi.atip.interapp.hierarchiclist.AbstractHierarchyListManager$1;

class AbstractHierarchyListManager$DefaultComparator
implements ListRowComparator {
    private AbstractHierarchyListManager$DefaultComparator() {
    }

    @Override
    public boolean equalsRow(ListRow listRow) {
        return true;
    }

    /* synthetic */ AbstractHierarchyListManager$DefaultComparator(AbstractHierarchyListManager$1 abstractHierarchyListManager$1) {
        this();
    }
}

