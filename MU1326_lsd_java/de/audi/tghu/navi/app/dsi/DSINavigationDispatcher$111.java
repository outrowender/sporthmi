/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.CountryInfo;

class DSINavigationDispatcher$111
extends CommandResponse {
    private final /* synthetic */ CountryInfo val$countryInfo;
    private final /* synthetic */ int val$resultCode;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$111(DSINavigationDispatcher dSINavigationDispatcher, CountryInfo countryInfo, int n) {
        this.this$0 = dSINavigationDispatcher;
        this.val$countryInfo = countryInfo;
        this.val$resultCode = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).requestCountryInfoResult(this.val$countryInfo, this.val$resultCode);
    }
}

