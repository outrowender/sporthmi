/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.CountryInfo;

class DSINavigationDispatcher$106
extends CommandResponse {
    private final /* synthetic */ CountryInfo[] val$countryInfo;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$106(DSINavigationDispatcher dSINavigationDispatcher, CountryInfo[] countryInfoArray) {
        this.this$0 = dSINavigationDispatcher;
        this.val$countryInfo = countryInfoArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateCountryInfo(this.val$countryInfo);
    }
}

