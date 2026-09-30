/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.global.NavLocation;

public interface NavLocationExctractor {
    public NavLocation extractNavLocationFromRow(EvoListRow var1);
}

