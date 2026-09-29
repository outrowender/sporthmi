/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr.models;

import de.audi.app.navi.evo.di.AbstractAddressInputModelAccessEvo;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;

public class AddressInputMainScreenModelAccessKR
extends AbstractAddressInputModelAccessEvo {
    private final NavigationEnv env;
    private final LogChannel logChannel;

    public AddressInputMainScreenModelAccessKR(NavigationEnv navigationEnv, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper) {
        super(iAddressInputFormModelAccessHelper);
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getAddressInputLogChannel();
    }

    @Override
    public void onStart(NavLocation navLocation) {
        this.env.getBaseListModel(-1474361856).removeAll();
    }

    @Override
    public void onUpdateLocation(NavLocation navLocation, Map map) {
        this.modelAccessHelper.onUpdateLocation(this.env, this.logChannel, navLocation, map);
    }

    @Override
    public void onUpdateSpeller(String string, String string2, boolean bl, boolean bl2) {
    }

    @Override
    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl, int n, int n2) {
    }

    @Override
    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl) {
    }

    @Override
    public void onElementSelected(NavLocation navLocation) {
    }

    @Override
    public void onAmbiguousElementSelected() {
    }

    @Override
    public void unrequestItems(int n, int n2) {
    }

    @Override
    public void onRestore() {
    }

    @Override
    public void onInputChanged() {
    }
}

