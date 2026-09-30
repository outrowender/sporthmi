/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rthyperlinking;

import de.audi.atip.interapp.phone.ITelCallControl;
import de.audi.atip.interapp.phone.ITelCallInformation;
import de.audi.atip.interapp.phone.ITelCallSession;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.rthyperlinking.RadiotextHyperlinkProcessor;

public class PhonePendingHyperlinkAction
extends RadiotextHyperlinkProcessor.AbstractPendingHyperlinkAction {
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

    public boolean isExecutable(LogChannel logChannel) {
        boolean bl = Utilities.getFramework().getSysConst(473) != 0;
        logChannel.log(10000000, "[PhonePendingHyperlinkAction.isExecutable]  %1, isPhoneAvailable %2", (Object)this.hyperlinkContent, (Object)bl);
        return bl;
    }

    public void execute() {
        boolean bl;
        boolean bl2 = bl = this.models.getChoiceModel(4091).getValue() == 1;
        if (bl) {
            this.phone.dialNumber(new HyperlinkCallSession(), true);
        } else {
            this.models.getButtonModel(100796).fireEvent(0);
        }
    }

    private class HyperlinkCallSession
    implements ITelCallSession {
        private HyperlinkCallSession() {
        }

        public int getCallType() {
            return 0;
        }

        public String getTelephoneNumber() {
            return PhonePendingHyperlinkAction.this.getTrimedPhoneNumber();
        }

        public void onActive(ITelCallControl iTelCallControl) {
        }

        public void onClose() {
        }

        public void updateCallInformation(ITelCallInformation iTelCallInformation, int n) {
        }
    }
}

