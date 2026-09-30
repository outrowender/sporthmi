/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.evo.main.search.truffles;

import de.audi.app.addressbook.evo.common.search.truffles.ADBEvoTruffleSearchListRow;
import de.audi.app.addressbook.evo.main.AddressBookEvoApplication;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.util.AbstractSearchResultFormatter;
import de.audi.atip.search.util.SearchResultListRow;
import org.dsi.ifc.search.SearchResult;

public class AddressBookEvoSearchResultFormatter
extends AbstractSearchResultFormatter {
    private LogChannel log;
    private AddressBookEvoApplication appAdr;

    public AddressBookEvoSearchResultFormatter(LogChannel logChannel, AddressBookEvoApplication addressBookEvoApplication) {
        this.log = logChannel;
        this.appAdr = addressBookEvoApplication;
    }

    public SearchResultListRow formatResult(SearchResult searchResult) {
        if (searchResult == null) {
            this.log.log(10000, "AddressBookEvoSearchResultFormatter#formatResult(): result is null");
            return null;
        }
        this.log.log(10000000, "AddressBookEvoSearchResultFormatter#formatResult(): result: %1", (Object)searchResult);
        return new ADBEvoTruffleSearchListRow(searchResult, this.appAdr.getAdbMode(), 692197399);
    }
}

