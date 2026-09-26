/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import de.audi.tghu.navi.app.addressinput.poi.sequences.CallPhoneNumberSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.CallPhoneNumberSequence$1$1;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

class CallPhoneNumberSequence$1
extends NavCommand {
    private final /* synthetic */ ITelService val$telService;
    private final /* synthetic */ LogChannel val$logChannel;
    private final /* synthetic */ CallPhoneNumberSequence this$0;

    CallPhoneNumberSequence$1(CallPhoneNumberSequence callPhoneNumberSequence, ITelService iTelService, LogChannel logChannel) {
        this.this$0 = callPhoneNumberSequence;
        this.val$telService = iTelService;
        this.val$logChannel = logChannel;
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getSelectedLocation();
        String string = LocationFormatter.formatPhonenumber(navLocation);
        this.val$telService.dialNumber(string, new CallPhoneNumberSequence$1$1(this), true);
        this.getCommandList().commandFinished();
    }

    static /* synthetic */ LogChannel access$000(CallPhoneNumberSequence$1 callPhoneNumberSequence$1) {
        return callPhoneNumberSequence$1.val$logChannel;
    }
}

