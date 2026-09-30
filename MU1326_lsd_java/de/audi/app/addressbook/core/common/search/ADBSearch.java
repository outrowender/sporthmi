/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.search;

import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.common.search.ADBSearchListRow;
import org.osgi.framework.BundleContext;

public interface ADBSearch {
    public void init();

    public void deinit(BundleContext var1);

    public void startSearch();

    public void enableFiltering(boolean var1);

    public void setSearchResultDetails(ADBEntryDetailsListRow[] var1, ADBSearchListRow var2);
}

