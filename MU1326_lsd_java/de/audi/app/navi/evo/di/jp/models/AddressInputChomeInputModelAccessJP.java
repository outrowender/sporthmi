/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.models;

import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.app.navi.evo.di.jp.models.AddressInputModelAccessJP;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import org.dsi.ifc.global.NavLocation;

public class AddressInputChomeInputModelAccessJP
extends AddressInputModelAccessJP {
    private final ChoiceModelApp housenumberAvailable;

    public AddressInputChomeInputModelAccessJP(NavigationEnv navigationEnv, int n, int n2, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper) {
        super(navigationEnv, n, n2, iAddressInputFormModelAccessHelper);
        this.housenumberAvailable = navigationEnv.getChoiceModel(DIScreensEvo.getDiJpChomeNeedsNumberChoice());
    }

    public void onElementSelected(NavLocation navLocation) {
        this.env.getAddressInputLogChannel().log(10000000, "%1#onElementSelected - housenumberAvailable.setValue(NavigationConstants.CHOME_NEEDS_NO_NUMBER)", (Object)this.CLASS_NAME);
        this.housenumberAvailable.setValue(0);
        this.reInitNDFScreenModel.setValue(0);
    }

    public void onAmbiguousElementSelected() {
        this.env.getAddressInputLogChannel().log(10000000, "%1#onAmbiguousElementSelected - housenumberAvailable.setValue(NavigationConstants.CHOME_NEEDS_NUMBER)", (Object)this.CLASS_NAME);
        this.housenumberAvailable.setValue(1);
        this.reInitNDFScreenModel.setValue(1);
    }
}

