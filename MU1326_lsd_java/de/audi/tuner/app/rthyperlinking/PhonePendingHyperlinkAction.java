/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rthyperlinking;

import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.rthyperlinking.PhonePendingHyperlinkAction$HyperlinkCallSession;
import de.audi.tuner.app.rthyperlinking.RadiotextHyperlinkProcessor;
import de.audi.tuner.app.rthyperlinking.RadiotextHyperlinkProcessor$AbstractPendingHyperlinkAction;

public class PhonePendingHyperlinkAction
extends RadiotextHyperlinkProcessor$AbstractPendingHyperlinkAction {
    private final ITelService phone;

    public PhonePendingHyperlinkAction(RadiotextHyperlinkProcessor radiotextHyperlinkProcessor, TunerBasics tunerBasics, String string, ITelService iTelService) {
        super(radiotextHyperlinkProcessor, tunerBasics, 1, string);
        this.phone = iTelService;
    }

    public String getTrimedPhoneNumber() {
        String string = this.hyperlinkContent;
        string = Utilities.replaceDelimiter(string, '-', "");
        string = Utilities.replaceDelimiter(string, '/', "");
        string = Utilities.replaceDelimiter(string, ' ', "");
        return string;
    }

    @Override
    public boolean isExecutable(LogChannel logChannel) {
        boolean bl = Utilities.getFramework().getSysConst(473) != 0;
        logChannel.log(-2137614336, "[PhonePendingHyperlinkAction.isExecutable]  %1, isPhoneAvailable %2", (Object)this.hyperlinkContent, (Object)bl);
        return bl;
    }

    @Override
    public void execute() {
        boolean bl;
        boolean bl2 = bl = this.models.getChoiceModel(4091).getValue() == 1;
        if (bl) {
            this.phone.dialNumber(new PhonePendingHyperlinkAction$HyperlinkCallSession(this, null), true);
        } else {
            this.models.getButtonModel(-1131872000).fireEvent(0);
        }
    }
}

