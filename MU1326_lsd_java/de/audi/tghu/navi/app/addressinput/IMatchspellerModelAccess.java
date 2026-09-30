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
    public static final int NO_VALUE = -2;

    public void onUpdateSpeller(String var1, String var2, boolean var3, boolean var4);

    public void onUpdateResultList(LIValueList var1, long var2, String var4, boolean var5, int var6, int var7);

    public void onUpdateResultList(LIValueList var1, long var2, String var4, boolean var5);

    public void onElementSelected(NavLocation var1);

    public void onAmbiguousElementSelected();

    public void onInputChanged();

    public void unrequestItems(int var1, int var2);

    public void onSpellerStatusChanged(int var1);
}

