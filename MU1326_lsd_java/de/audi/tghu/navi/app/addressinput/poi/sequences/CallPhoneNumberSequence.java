/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.addressinput.commands.LISPGetLocationFromLIValueListElementCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.CallPhoneNumberSequence$1;
import de.audi.tghu.navi.app.addressinput.poi.sequences.CallPhoneNumberSequence$2;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public class CallPhoneNumberSequence {
    private final ICommandListFactory commandListFactory;

    public CallPhoneNumberSequence(ICommandListFactory iCommandListFactory) {
        this.commandListFactory = iCommandListFactory;
    }

    public void start(LogChannel logChannel, LIValueListElement lIValueListElement, ITelService iTelService) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
        commandList.add(new CallPhoneNumberSequence$1(this, iTelService, logChannel));
        commandList.execute("CallPhoneNumberSequence#start with liValueListElement");
    }

    public void start(LogChannel logChannel, NavLocation navLocation, ITelService iTelService) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new CallPhoneNumberSequence$2(this, navLocation, iTelService, logChannel));
        commandList.execute("CallPhoneNumberSequence#start with NavLocation");
    }
}

