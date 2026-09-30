/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.SearchResultFormatterNavDb;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.InterAppService;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.car.kombi.ICarKombiService;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.search.SearchResult;

public class SearchResultFormatterNavDbWithIcons
extends SearchResultFormatterNavDb {
    private static final int SEARCHRESULT_MASK_FULL = -1;
    private static final int MISSING = 0;
    protected ICarKombiService carKombiService;
    protected int primaryFueltypeId = 0;
    protected int primaryFueltypeMask;
    protected int secondaryFueltypeId = 0;
    protected int secondaryFueltypeMask;

    public SearchResultFormatterNavDbWithIcons(InterAppService interAppService, IconHandler iconHandler, LogChannel logChannel, INaviFavoriteHandler iNaviFavoriteHandler, NavigationEnv navigationEnv, ICarKombiService iCarKombiService) {
        super(interAppService, iconHandler, logChannel, iNaviFavoriteHandler, navigationEnv);
        this.carKombiService = iCarKombiService;
    }

    public SearchResultListRow formatResult(SearchResult searchResult) {
        SearchResultListRow searchResultListRow = super.formatResult(searchResult);
        if (this.carKombiService != null) {
            this.handleAdditionalIcons(searchResultListRow, searchResult);
        }
        return searchResultListRow;
    }

    private void handleAdditionalIcons(SearchResultListRow searchResultListRow, SearchResult searchResult) {
        if (Util.isHURegionAsia()) {
            searchResultListRow.setInteger(7, 0);
            searchResultListRow.setInteger(8, 0);
            return;
        }
        if (searchResult.entryType != 2 || searchResult.entryType == 2 && searchResult.entryFlags == 0) {
            searchResultListRow.setInteger(7, 0);
            searchResultListRow.setInteger(8, 0);
            return;
        }
        int[] nArray = this.getIdAndMask(this.carKombiService.getEngineTypePrimary());
        this.primaryFueltypeId = nArray[0];
        this.primaryFueltypeMask = nArray[1];
        nArray = this.getIdAndMask(this.carKombiService.getEngineTypeSecondary());
        this.secondaryFueltypeId = nArray[0];
        this.secondaryFueltypeMask = nArray[1];
        if ((searchResult.entryFlags & this.primaryFueltypeMask) == 0) {
            searchResultListRow.setInteger(7, this.primaryFueltypeId);
        } else {
            searchResultListRow.setInteger(7, 0);
        }
        if ((searchResult.entryFlags & this.secondaryFueltypeMask) == 0) {
            searchResultListRow.setInteger(8, this.secondaryFueltypeId);
        } else {
            searchResultListRow.setInteger(8, 0);
        }
    }

    private int[] getIdAndMask(int n) {
        int[] nArray = new int[2];
        switch (n) {
            case 3: {
                nArray[0] = 8;
                nArray[1] = 128;
                break;
            }
            case 6: {
                nArray[0] = 2;
                nArray[1] = 2;
            }
            case 7: {
                nArray[0] = 1;
                nArray[1] = 1;
                break;
            }
            case 8: {
                nArray[0] = 4;
                nArray[1] = 8;
                break;
            }
            case 9: {
                nArray[0] = 3;
                nArray[1] = 4;
                break;
            }
            default: {
                nArray[0] = 0;
                nArray[1] = -1;
            }
        }
        return nArray;
    }
}

