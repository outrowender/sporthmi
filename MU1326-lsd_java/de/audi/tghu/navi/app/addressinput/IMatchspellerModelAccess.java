/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput;

import de.audi.tghu.navi.app.addressinput.IAddressInputModelAccess;
import de.audi.tghu.navi.app.addressinput.IRestorableModelAccess;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;

public interface IMatchspellerModelAccess
extends IRestorableModelAccess,
IAddressInputModelAccess {
    public static final int NO_VALUE;

    default public void onUpdateSpeller(String string, String string2, boolean bl, boolean bl2) {
    }

    default public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl, int n, int n2) {
    }

    default public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl) {
    }

    default public void onElementSelected(NavLocation navLocation) {
    }

    default public void onAmbiguousElementSelected() {
    }

    default public void onInputChanged() {
    }

    default public void unrequestItems(int n, int n2) {
    }

    default public void onSpellerStatusChanged(int n) {
    }
}

