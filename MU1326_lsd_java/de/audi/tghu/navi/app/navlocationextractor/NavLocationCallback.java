/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.tghu.command.ICommandList;
import org.dsi.ifc.global.NavLocation;

public interface NavLocationCallback {
    public void callBack(NavLocation var1, ICommandList var2);
}

