/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput;

import java.util.Map;
import org.dsi.ifc.global.NavLocation;

public interface IAddressInputModelAccess {
    public void onStart(NavLocation var1);

    public void onUpdateLocation(NavLocation var1, Map var2);
}

