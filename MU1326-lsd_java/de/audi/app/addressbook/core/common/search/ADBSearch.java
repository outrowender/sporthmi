/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.search;

import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.common.search.ADBSearchListRow;
import org.osgi.framework.BundleContext;

public interface ADBSearch {
    default public void init() {
    }

    default public void deinit(BundleContext bundleContext) {
    }

    default public void startSearch() {
    }

    default public void enableFiltering(boolean bl) {
    }

    default public void setSearchResultDetails(ADBEntryDetailsListRow[] aDBEntryDetailsListRowArray, ADBSearchListRow aDBSearchListRow) {
    }
}

