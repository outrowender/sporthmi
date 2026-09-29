/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.NaviService$NaviSUIDetails;

public interface ISUIListRowBuilder {
    default public EvoListRow buildEvoListRow(NaviService$NaviSUIDetails naviService$NaviSUIDetails, int n) {
    }
}

