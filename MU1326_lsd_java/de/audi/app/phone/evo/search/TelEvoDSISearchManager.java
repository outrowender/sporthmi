/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.search;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.search.TelSearchFilterRequestStruct;
import de.audi.app.phone.core.search.cmd.AbstractTelDSISearchManager;
import org.dsi.ifc.search.SearchFilter;

public class TelEvoDSISearchManager
extends AbstractTelDSISearchManager {
    private final int[] sources = new int[]{7, 18, 3};
    private final TelSearchFilterRequestStruct[] searchFilters = new TelSearchFilterRequestStruct[]{new TelSearchFilterRequestStruct(3, new SearchFilter(new int[]{5}, null, 7, null)), new TelSearchFilterRequestStruct(7, new SearchFilter(new int[]{5, 11}, null, 0, null)), new TelSearchFilterRequestStruct(18, new SearchFilter(new int[]{5, 11}, null, 0, null))};

    public TelEvoDSISearchManager(ITelApplication iTelApplication) {
        super(iTelApplication);
    }

    protected int[] getSources() {
        return this.sources;
    }

    protected TelSearchFilterRequestStruct[] getSearchFilters() {
        return this.searchFilters;
    }
}

