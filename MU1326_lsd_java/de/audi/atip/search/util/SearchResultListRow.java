/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.search.util;

import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.search.SearchResult;

public abstract class SearchResultListRow
extends EvoListRow {
    public static final int NODE_TYPE_SIMPLE = 0;
    public static final int NODE_TYPE_PARENT = 1;
    public static final int NODE_TYPE_CHILD = 2;
    private final SearchResult searchResult;
    private int nodeType;
    private boolean isOpen;
    private int childrenCount;

    public SearchResultListRow(SearchResult searchResult, int n, long l) {
        super(l, n);
        this.searchResult = searchResult;
        this.nodeType = 0;
    }

    protected SearchResultListRow(SearchResultListRow searchResultListRow) {
        super(searchResultListRow);
        this.searchResult = searchResultListRow.getSearchResult();
        this.nodeType = searchResultListRow.nodeType;
        this.isOpen = searchResultListRow.isOpen;
        this.childrenCount = searchResultListRow.childrenCount;
    }

    public abstract EvoListRow copy();

    public SearchResult getSearchResult() {
        return this.searchResult;
    }

    public int getNodeType() {
        return this.nodeType;
    }

    public void setNodeType(int n) {
        this.nodeType = n;
    }

    public int getChildrenCount() {
        return this.childrenCount;
    }

    public void setChildrenCount(int n) {
        this.childrenCount = n;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void setOpen(boolean bl) {
        this.isOpen = bl;
    }
}

