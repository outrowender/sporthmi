/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr.models;

import de.audi.app.navi.evo.di.kr.models.AddressInputModelAccessKR;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class AddressInputVillageStreetModelAccessKR
extends AddressInputModelAccessKR {
    public AddressInputVillageStreetModelAccessKR(NavigationEnv navigationEnv, int n, int n2, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper) {
        super(navigationEnv, n, n2, iAddressInputFormModelAccessHelper);
    }

    public void onStart(NavLocation navLocation) {
        Util.setModelStatus(this.matchSpellerModelApp, 1);
        this.matchSpellerModelApp.clear();
        this.matchSpellerModelApp.setMatchCount(-1);
        this.previewListModelApp.clearAll();
        this.reInitNDFScreenModel.setValue(1);
    }
}

