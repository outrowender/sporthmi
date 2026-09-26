/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.search.truffles;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.common.search.ADBSearch;
import de.audi.app.addressbook.core.common.search.ADBSearchListRow;
import de.audi.app.addressbook.core.common.search.truffles.AbstractADBTruffleSearchGuiHandler;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractSearch;
import de.audi.atip.search.util.SearchResultListRow;
import org.dsi.ifc.search.SearchFilter;
import org.osgi.framework.BundleContext;

public abstract class AbstractADBTruffleSearch
extends AbstractSearch
implements ADBSearch {
    protected ADBApplication appAdr;
    private SearchFilter noFilter = new SearchFilter(new int[]{5}, null, 0, null);
    private SearchFilter phoneNumberFilter = new SearchFilter(new int[]{5}, null, 7, null);
    private SearchFilter addressDataFilter = new SearchFilter(new int[]{5}, null, 240, null);
    private SearchFilter emailAddressFilter = new SearchFilter(new int[]{5}, null, 8, null);

    public AbstractADBTruffleSearch(BundleContext bundleContext, ADBApplication aDBApplication, LogChannel logChannel, int n) {
        super(bundleContext, aDBApplication.getFramework(), logChannel, n);
        this.appAdr = aDBApplication;
    }

    @Override
    public void deinit(BundleContext bundleContext) {
        this.getActiveGuiSearchHandler().release();
        this.stopDSI(bundleContext);
    }

    @Override
    public void startSearch() {
        ((AbstractADBTruffleSearchGuiHandler)this.getActiveGuiSearchHandler()).startSearch();
    }

    @Override
    public void enableFiltering(boolean bl) {
        if (bl) {
            switch (this.appAdr.getAdbMode()) {
                case 0: {
                    this.setSearchFilter(3, this.phoneNumberFilter);
                    break;
                }
                case 1: {
                    this.setSearchFilter(3, this.addressDataFilter);
                    break;
                }
                case 2: {
                    this.setSearchFilter(3, this.emailAddressFilter);
                    break;
                }
            }
        } else {
            this.setSearchFilter(3, this.noFilter);
        }
    }

    @Override
    public void setSearchResultDetails(ADBEntryDetailsListRow[] aDBEntryDetailsListRowArray, ADBSearchListRow aDBSearchListRow) {
        this.getActiveGuiSearchHandler().setChildrenNodes(aDBEntryDetailsListRowArray, (SearchResultListRow)((Object)aDBSearchListRow));
    }
}

