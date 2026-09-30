/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.NaviService;

public interface ISUIListRowBuilder {
    public EvoListRow buildEvoListRow(NaviService.NaviSUIDetails var1, int var2);
}

