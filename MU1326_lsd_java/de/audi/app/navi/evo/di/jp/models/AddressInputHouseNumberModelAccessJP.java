/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.models;

import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.app.navi.evo.di.jp.models.AddressInputModelAccessJP;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class AddressInputHouseNumberModelAccessJP
extends AddressInputModelAccessJP {
    private final ChoiceModelApp chomeNeededChoiceModel;

    public AddressInputHouseNumberModelAccessJP(NavigationEnv navigationEnv, int n, int n2, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper) {
        super(navigationEnv, n, n2, iAddressInputFormModelAccessHelper);
        this.chomeNeededChoiceModel = navigationEnv.getChoiceModel(DIScreensEvo.getDiJpNeedsChome());
    }

    @Override
    public void onStart(NavLocation navLocation) {
        Util.setModelStatus(this.matchSpellerModelApp, 1);
        this.matchSpellerModelApp.clear();
        this.matchSpellerModelApp.setMatchCount(-1);
        this.previewListModelApp.clearAll();
        if (this.chomeNeededChoiceModel.getValue() == 1) {
            this.reInitNDFScreenModel.setValue(1);
        } else {
            this.reInitNDFScreenModel.setValue(0);
        }
    }
}

