/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$IUpdateOperation;

class NaviServiceListenerController$4
implements NaviServiceListenerController$IUpdateOperation {
    private final /* synthetic */ String val$country;
    private final /* synthetic */ String val$countryAbbreviation;
    private final /* synthetic */ NaviServiceListenerController this$0;

    NaviServiceListenerController$4(NaviServiceListenerController naviServiceListenerController, String string, String string2) {
        this.this$0 = naviServiceListenerController;
        this.val$country = string;
        this.val$countryAbbreviation = string2;
    }

    @Override
    public void update(NaviServiceListener naviServiceListener) {
        naviServiceListener.updateDestinationCountryCode(this.val$country, this.val$countryAbbreviation);
    }
}

