/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import de.audi.tghu.navi.app.addressinput.poi.sequences.CallPhoneNumberSequence;
import de.audi.tghu.navi.app.addressinput.poi.sequences.CallPhoneNumberSequence$2$1;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

class CallPhoneNumberSequence$2
extends NavCommand {
    private final /* synthetic */ NavLocation val$location;
    private final /* synthetic */ ITelService val$telService;
    private final /* synthetic */ LogChannel val$logChannel;
    private final /* synthetic */ CallPhoneNumberSequence this$0;

    CallPhoneNumberSequence$2(CallPhoneNumberSequence callPhoneNumberSequence, NavLocation navLocation, ITelService iTelService, LogChannel logChannel) {
        this.this$0 = callPhoneNumberSequence;
        this.val$location = navLocation;
        this.val$telService = iTelService;
        this.val$logChannel = logChannel;
    }

    @Override
    public void execute() {
        String string = LocationFormatter.formatPhonenumber(this.val$location);
        this.val$telService.dialNumber(string, new CallPhoneNumberSequence$2$1(this), true);
        this.getCommandList().commandFinished();
    }

    static /* synthetic */ LogChannel access$100(CallPhoneNumberSequence$2 callPhoneNumberSequence$2) {
        return callPhoneNumberSequence$2.val$logChannel;
    }
}

