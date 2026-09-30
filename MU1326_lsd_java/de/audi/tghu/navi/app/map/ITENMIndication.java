/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.tmc.TmcMessage;

public interface ITENMIndication {
    public static final NullTENMIndication NULL_TENM_INDICATION = new NullTENMIndication();

    public void indicateTrafficEventNoticeMap(TmcMessage var1, NavRectangle var2, int var3);

    public void cleanup();

    public static class NullTENMIndication
    implements ITENMIndication {
        public void indicateTrafficEventNoticeMap(TmcMessage tmcMessage, NavRectangle navRectangle, int n) {
        }

        public void cleanup() {
        }
    }
}

