/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.housenumber;

import de.audi.app.navi.evo.addressinput.AbstractEvoMatchspellerModelAccess;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import org.dsi.ifc.global.NavLocation;

public class HousenumberMatchspellerInputModelAccess
extends AbstractEvoMatchspellerModelAccess {
    public HousenumberMatchspellerInputModelAccess(NavigationEnv navigationEnv, int n, int n2, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper) {
        super(navigationEnv, n, n2, iAddressInputFormModelAccessHelper);
    }

    public void onStart(NavLocation navLocation) {
        super.onStart(navLocation);
        this.env.getChoiceModel(400909).setValue(1);
    }

    public void onElementSelected(NavLocation navLocation) {
        this.env.getChoiceModel(400401).setValue(1);
    }
}

