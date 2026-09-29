/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.tghu.command.ICommandList;
import org.dsi.ifc.global.NavLocation;

public interface NavLocationCallback {
    default public void callBack(NavLocation navLocation, ICommandList iCommandList) {
    }
}

