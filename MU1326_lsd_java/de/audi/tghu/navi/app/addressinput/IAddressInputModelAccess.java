/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput;

import java.util.Map;
import org.dsi.ifc.global.NavLocation;

public interface IAddressInputModelAccess {
    default public void onStart(NavLocation navLocation) {
    }

    default public void onUpdateLocation(NavLocation navLocation, Map map) {
    }
}

