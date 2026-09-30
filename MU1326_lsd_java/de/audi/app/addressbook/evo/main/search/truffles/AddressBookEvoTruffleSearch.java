/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.evo.main.search.truffles;

import de.audi.app.addressbook.core.common.search.ADBSearch;
import de.audi.app.addressbook.core.common.search.truffles.AbstractADBTruffleSearch;
import de.audi.app.addressbook.evo.main.AddressBookEvoApplication;
import de.audi.app.addressbook.evo.main.search.truffles.AddressBookEvoTruffleSearchGuiHandler;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;

public class AddressBookEvoTruffleSearch
extends AbstractADBTruffleSearch
implements ADBSearch {
    public AddressBookEvoTruffleSearch(BundleContext bundleContext, AddressBookEvoApplication addressBookEvoApplication, LogChannel logChannel, int n) {
        super(bundleContext, addressBookEvoApplication, logChannel, n);
    }

    public void init() {
        AddressBookEvoTruffleSearchGuiHandler addressBookEvoTruffleSearchGuiHandler = new AddressBookEvoTruffleSearchGuiHandler(this.appAdr.getLog(), this.logChannel, (AddressBookEvoApplication)this.appAdr, this);
        this.setActiveGuiSearchHandler(addressBookEvoTruffleSearchGuiHandler);
        this.startDSI();
    }
}

