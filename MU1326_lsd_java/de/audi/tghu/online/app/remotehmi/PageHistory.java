/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.ui.mib2.grid.IGrid;
import de.audi.remotehmi.ui.mib2.grid.IGridList;
import de.audi.remotehmi.ui.mib2.grid.IPageHistory;
import java.util.HashMap;
import java.util.ListIterator;

public class PageHistory
implements IPageHistory {
    private HashMap IdMap = new HashMap();
    private HashMap IndexMap = new HashMap();
    private final LogChannel logChannel;

    public void setExpansionState(String string, int n, boolean bl) {
        Boolean bl2 = new Boolean(bl);
        this.IdMap.put(string, bl2);
        this.IndexMap.put(new Integer(n), bl2);
    }

    public PageHistory(LogChannel logChannel) {
        this.logChannel = logChannel;
    }

    public boolean isExpanded(String string, int n, boolean bl) {
        if (this.IdMap.containsKey(string)) {
            Boolean bl2 = (Boolean)this.IdMap.get(string);
            return bl2;
        }
        Integer n2 = new Integer(n);
        if (this.IndexMap.containsKey(n2)) {
            Boolean bl3 = (Boolean)this.IndexMap.get(n2);
            return bl3;
        }
        return bl;
    }

    public void restoreToGrid(IGridList iGridList) {
        ListIterator listIterator = iGridList.listIterator();
        while (listIterator.hasNext()) {
            IGrid iGrid = (IGrid)listIterator.next();
            iGrid.setExpanded(this.isExpanded(iGrid.getId(), listIterator.previousIndex(), iGrid.isExpanded()));
        }
    }
}

