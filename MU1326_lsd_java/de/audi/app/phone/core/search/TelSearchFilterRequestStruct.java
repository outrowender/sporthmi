/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.search;

import org.dsi.ifc.search.SearchFilter;

public class TelSearchFilterRequestStruct {
    private final int source;
    private final SearchFilter searchFilter;

    public TelSearchFilterRequestStruct(int n, SearchFilter searchFilter) {
        this.source = n;
        this.searchFilter = searchFilter;
    }

    public int getSource() {
        return this.source;
    }

    public SearchFilter getSearchFilter() {
        return this.searchFilter;
    }
}

