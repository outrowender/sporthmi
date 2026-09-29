/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rthyperlinking;

import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.rthyperlinking.RadiotextHyperlinkProcessor;
import de.audi.tuner.app.rthyperlinking.RadiotextHyperlinkProcessor$AbstractPendingHyperlinkAction;

public class NavPendingHyperlinkAction
extends RadiotextHyperlinkProcessor$AbstractPendingHyperlinkAction {
    private final NaviService navi;

    public NavPendingHyperlinkAction(RadiotextHyperlinkProcessor radiotextHyperlinkProcessor, TunerBasics tunerBasics, String string, NaviService naviService) {
        super(radiotextHyperlinkProcessor, tunerBasics, 0, string);
        this.navi = naviService;
    }

    @Override
    public boolean isExecutable(LogChannel logChannel) {
        boolean bl = Utilities.getFramework().getSysConst(459) != 0;
        boolean bl2 = this.models.getChoiceModel(177).getValue() != 0;
        logChannel.log(-2137614336, "[NavPendingHyperlinkAction.isExecutable] %1, isNavAvailable %2, navReady %3", (Object)this.hyperlinkContent, (Object)bl, (Object)bl2);
        if (!bl) {
            return false;
        }
        return bl2;
    }

    @Override
    public void execute() {
        this.navi.startTrufflesSearch(this.hyperlinkContent, new String[0]);
    }
}

