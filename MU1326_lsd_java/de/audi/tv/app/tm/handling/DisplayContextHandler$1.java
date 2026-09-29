/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm.handling;

import de.audi.atip.utils.reactive.observables.Observables$Combinator4;
import de.audi.tv.app.TVUtil;
import de.audi.tv.app.tm.handling.TerminalAndScreenModeTuple;

final class DisplayContextHandler$1
implements Observables$Combinator4 {
    DisplayContextHandler$1() {
    }

    public Boolean combine(Boolean bl, Boolean bl2, Integer n, TerminalAndScreenModeTuple terminalAndScreenModeTuple) {
        boolean bl3;
        boolean bl4;
        boolean bl5 = n == 0;
        boolean bl6 = false;
        if (bl.booleanValue()) {
            bl4 = TVUtil.doesTerminalModeShowFastMovingPictures(terminalAndScreenModeTuple.terminalMode);
            bl6 = bl5 && bl4;
        }
        bl4 = false;
        if (bl2.booleanValue()) {
            bl3 = TVUtil.doesTerminalModeShowTvPictures(terminalAndScreenModeTuple.terminalMode);
            bl4 = bl5 && bl3;
        }
        bl3 = n != 0 && terminalAndScreenModeTuple.terminalMode != 14;
        return new Boolean(!bl6 && !bl4 && !bl3);
    }

    @Override
    public /* synthetic */ Object combine(Object object, Object object2, Object object3, Object object4) {
        return this.combine((Boolean)object, (Boolean)object2, (Integer)object3, (TerminalAndScreenModeTuple)object4);
    }
}

