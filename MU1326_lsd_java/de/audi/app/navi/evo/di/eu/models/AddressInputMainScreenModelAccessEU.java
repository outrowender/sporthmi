/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.eu.models;

import de.audi.app.navi.evo.di.eu.models.AbstractAddressInputModelAccessEU;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;

public class AddressInputMainScreenModelAccessEU
extends AbstractAddressInputModelAccessEU {
    private final NavigationEnv env;
    private final LogChannel logChannel;

    public AddressInputMainScreenModelAccessEU(NavigationEnv navigationEnv, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper) {
        super(iAddressInputFormModelAccessHelper);
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getAddressInputLogChannel();
    }

    public void onStart(NavLocation navLocation) {
        this.env.getBaseListModel(401320).removeAll();
    }

    public void onUpdateLocation(NavLocation navLocation, Map map) {
        this.modelAccessHelper.onUpdateLocation(this.env, this.logChannel, navLocation, map);
    }

    public void onUpdateSpeller(String string, String string2, boolean bl, boolean bl2) {
    }

    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl, int n, int n2) {
    }

    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl) {
    }

    public void onElementSelected(NavLocation navLocation) {
    }

    public void onAmbiguousElementSelected() {
    }

    public void unrequestItems(int n, int n2) {
    }

    public void onRestore() {
    }

    public void onInputChanged() {
    }
}

