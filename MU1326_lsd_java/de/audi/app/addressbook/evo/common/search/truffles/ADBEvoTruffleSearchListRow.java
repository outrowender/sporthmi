/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.evo.common.search.truffles;

import de.audi.app.addressbook.core.common.search.truffles.ADBTruffleSearchListRow;
import de.audi.app.addressbook.evo.common.search.ADBFocusPropertiesHelper;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.search.SearchResult;

public class ADBEvoTruffleSearchListRow
extends ADBTruffleSearchListRow {
    protected int drawerCategory;

    public ADBEvoTruffleSearchListRow(SearchResult searchResult, int n, int n2) {
        super(searchResult, n);
        this.setNodeType(1);
        this.drawerCategory = n2;
        this.setPropertyCell(4, new PropertyListCell(n2, ADBFocusPropertiesHelper.getFocusProperties(searchResult)));
        this.setInteger(8, 0);
    }

    public EvoListRow copy() {
        ADBEvoTruffleSearchListRow aDBEvoTruffleSearchListRow = new ADBEvoTruffleSearchListRow(this.getSearchResult(), this.adbMode, this.drawerCategory);
        aDBEvoTruffleSearchListRow.setOpen(this.isOpen());
        aDBEvoTruffleSearchListRow.setChildrenCount(this.getChildrenCount());
        return aDBEvoTruffleSearchListRow;
    }

    public void setOpen(boolean bl) {
        super.setOpen(bl);
        this.setInteger(8, bl ? 1 : 0);
    }
}

