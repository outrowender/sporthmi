/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.tghu.navi.app.map.ITENMIndication$NullTENMIndication;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.tmc.TmcMessage;

public interface ITENMIndication {
    public static final ITENMIndication$NullTENMIndication NULL_TENM_INDICATION = new ITENMIndication$NullTENMIndication();

    default public void indicateTrafficEventNoticeMap(TmcMessage tmcMessage, NavRectangle navRectangle, int n) {
    }

    default public void cleanup() {
    }
}

