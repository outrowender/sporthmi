/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.IDSINavigationHandler;
import org.dsi.ifc.base.DSIListener;

class DSINavigationDispatcher$52
extends CommandResponse {
    private final /* synthetic */ String val$countryAbbreviation;
    private final /* synthetic */ DSINavigationDispatcher this$0;

    DSINavigationDispatcher$52(DSINavigationDispatcher dSINavigationDispatcher, String string) {
        this.this$0 = dSINavigationDispatcher;
        this.val$countryAbbreviation = string;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((IDSINavigationHandler)dSIListener).updateLiCountryForCityAndStreetHistory(this.val$countryAbbreviation);
    }
}

