/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import de.audi.atip.phone.ITelServiceListener;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.addressinput.commands.LISPGetLocationFromLIValueListElementCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public class CallPhoneNumberSequence {
    private final ICommandListFactory commandListFactory;

    public CallPhoneNumberSequence(ICommandListFactory iCommandListFactory) {
        this.commandListFactory = iCommandListFactory;
    }

    public void start(final LogChannel logChannel, LIValueListElement lIValueListElement, final ITelService iTelService) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
        commandList.add(new NavCommand(){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getSelectedLocation();
                String string = LocationFormatter.formatPhonenumber(navLocation);
                iTelService.dialNumber(string, new ITelServiceListener(){

                    public void dialNumberResponse(int n) {
                        logChannel.log(10000000, "CallPhoneNumberSequence#start with liValueListElement - result=%1", (long)n);
                        if (n != 0) {
                            logChannel.log(10000, "CallPhoneNumberSequence#start with liValueListElement - dial was not successful, result=%1", (long)n);
                        }
                    }
                }, true);
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("CallPhoneNumberSequence#start with liValueListElement");
    }

    public void start(final LogChannel logChannel, final NavLocation navLocation, final ITelService iTelService) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand(){

            public void execute() {
                String string = LocationFormatter.formatPhonenumber(navLocation);
                iTelService.dialNumber(string, new ITelServiceListener(){

                    public void dialNumberResponse(int n) {
                        logChannel.log(10000000, "CallPhoneNumberSequence#start with navLocation - result=%1", (long)n);
                        if (n != 0) {
                            logChannel.log(10000, "CallPhoneNumberSequence#start with navLocation - dial was not successful, result=%1", (long)n);
                        }
                    }
                }, true);
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("CallPhoneNumberSequence#start with NavLocation");
    }
}

