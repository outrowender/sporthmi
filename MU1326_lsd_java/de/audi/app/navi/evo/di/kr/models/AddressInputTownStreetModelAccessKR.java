/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr.models;

import de.audi.app.navi.evo.di.kr.models.AddressInputModelAccessKR;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import org.dsi.ifc.global.NavLocation;

public class AddressInputTownStreetModelAccessKR
extends AddressInputModelAccessKR {
    private final ChoiceModelApp villageAvailable;

    public AddressInputTownStreetModelAccessKR(NavigationEnv navigationEnv, int n, int n2, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper) {
        super(navigationEnv, n, n2, iAddressInputFormModelAccessHelper);
        this.villageAvailable = navigationEnv.getChoiceModel(401726);
    }

    public void onElementSelected(NavLocation navLocation) {
        this.env.getAddressInputLogChannel().log(10000000, "%1# villageAvailable.setValue(VILLAGE_STREET_UNAVAILABLE)", (Object)this.CLASS_NAME);
        this.villageAvailable.setValue(0);
        this.reInitNDFScreenModel.setValue(0);
    }

    public void onAmbiguousElementSelected() {
        this.env.getAddressInputLogChannel().log(10000000, "%1# villageAvailable.setValue(VILLAGE_STREET_AVAILABLE)", (Object)this.CLASS_NAME);
        this.villageAvailable.setValue(1);
        this.reInitNDFScreenModel.setValue(1);
    }
}

