/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.search.truffles;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.common.ADBListRow;
import de.audi.app.addressbook.core.common.ADBModelUtils;
import de.audi.app.addressbook.core.common.search.ADBSearchListRow;
import de.audi.app.addressbook.core.common.search.truffles.AbstractADBTruffleSearch;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractGuiSearchHandler;
import de.audi.atip.search.util.SearchResultListRow;

public abstract class AbstractADBTruffleSearchGuiHandler
extends AbstractGuiSearchHandler {
    protected final LogChannel log;
    protected final ADBApplication appAdr;
    protected final AbstractADBTruffleSearch adbSearch;
    protected final ResourceLocatorModelApp contactPicture;

    public AbstractADBTruffleSearchGuiHandler(LogChannel logChannel, LogChannel logChannel2, ADBApplication aDBApplication, AbstractADBTruffleSearch abstractADBTruffleSearch, BaseListModelApp baseListModelApp, SpellerModelApp spellerModelApp, ChoiceModelApp choiceModelApp, ResourceLocatorModelApp resourceLocatorModelApp) {
        super(new int[]{3}, baseListModelApp, spellerModelApp, choiceModelApp, logChannel2, abstractADBTruffleSearch);
        this.log = logChannel;
        this.appAdr = aDBApplication;
        this.adbSearch = abstractADBTruffleSearch;
        this.contactPicture = resourceLocatorModelApp;
    }

    public void startSearch() {
        this.mdlSpellerSearchText.clear();
        this.refreshQuery();
    }

    public void refreshQuery() {
        this.log.log(1000000, "AbstractADBTruffleSearchGuiHandler#refreshQuery()");
        super.refreshQuery();
    }

    public void searchResultSelected(SearchResultListRow searchResultListRow, int n, int n2) {
        if (searchResultListRow instanceof ADBSearchListRow) {
            ADBSearchListRow aDBSearchListRow = (ADBSearchListRow)((Object)searchResultListRow);
            this.log.log(1000000, "AbstractADBTruffleSearchGuiHandler#searchResultSelected(): \"%1\", entryId: %2", (Object)aDBSearchListRow.getCombinedName(), aDBSearchListRow.getEntryId());
            this.appAdr.entrySelected(this.adbSearch, aDBSearchListRow, n2, n);
        } else {
            this.log.log(10000, "AbstractADBTruffleSearchGuiHandler#searchResultSelected(): listRow is not an ADBSearchListRow!");
        }
    }

    public void requestChildrenNodes(SearchResultListRow searchResultListRow, int n) {
        if (searchResultListRow instanceof ADBSearchListRow) {
            ADBSearchListRow aDBSearchListRow = (ADBSearchListRow)((Object)searchResultListRow);
            this.log.log(1000000, "AbstractADBTruffleSearchGuiHandler#requestChildrenNodes(): \"%1\", entryId: %2", (Object)aDBSearchListRow.getCombinedName(), aDBSearchListRow.getEntryId());
            this.appAdr.entrySelected(this.adbSearch, aDBSearchListRow, this.mdlListSearchResults.getID(), n);
        } else {
            this.log.log(10000, "AbstractADBTruffleSearchGuiHandler#requestChildrenNodes(): listRow is not an ADBSearchListRow!");
        }
    }

    public void childNodeSelected(EvoListRow evoListRow, int n, int n2) {
        if (evoListRow instanceof ADBEntryDetailsListRow) {
            ADBEntryDetailsListRow aDBEntryDetailsListRow = (ADBEntryDetailsListRow)evoListRow;
            this.log.log(1000000, "AbstractADBTruffleSearchGuiHandler#childNodeSelected(): %1", (Object)ADBDbgUtils.dbgShort(aDBEntryDetailsListRow.getEntry()));
            this.appAdr.detailsSelected(aDBEntryDetailsListRow, n2, n);
        } else {
            this.log.log(10000, "AbstractADBTruffleSearchGuiHandler#childNodeSelected(): listRow is not an ADBEntryDetailsListRow!");
        }
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (evoListRow != null && evoListRow instanceof ADBListRow) {
            ADBListRow aDBListRow = (ADBListRow)((Object)evoListRow);
            this.log.log(1000000, "AbstractADBTruffleSearchGuiHandler#itemFocused(): \"%1\", entryId: %2", (Object)aDBListRow.getCombinedName(), aDBListRow.getEntryId());
            this.appAdr.setFocusedEntryId(aDBListRow.getEntryId());
            this.appAdr.setFocusedEntryType(aDBListRow.getEntryType());
            if (this.contactPicture != null) {
                ADBModelUtils.updatePicture(aDBListRow.getContactPicture(), this.contactPicture, this.log);
            }
        } else {
            this.log.log(10000, "AbstractADBTruffleSearchGuiHandler#itemFocused(): row is null or has an unknown type!");
        }
    }

    protected synchronized void performQuery(String string) {
        this.log.log(1000000, "AbstractADBTruffleSearchGuiHandler#performQuery(): searchText: %1", (Object)string);
        super.performQuery(string);
    }
}

