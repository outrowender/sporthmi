/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.global.NavLocation;

public interface ITrufflesNavLocationExtractor {
    default public NavLocation extractNavLocationFromRow(EvoListRow evoListRow) {
    }
}

