/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.boardbook;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractGuiSearchHandler;
import de.audi.atip.search.AbstractSearch;
import de.audi.atip.search.util.SearchResultListRow;

public class BoardbookSearchGUI
extends AbstractGuiSearchHandler {
    public BoardbookSearchGUI(HMIService hMIService, LogChannel logChannel, AbstractSearch abstractSearch) {
        super(new int[0], null, null, null, logChannel, abstractSearch);
    }

    public void searchResultSelected(SearchResultListRow searchResultListRow, int n, int n2) {
    }

    public void childNodeSelected(EvoListRow evoListRow, int n, int n2) {
    }

    public void requestChildrenNodes(SearchResultListRow searchResultListRow, int n) {
    }
}

