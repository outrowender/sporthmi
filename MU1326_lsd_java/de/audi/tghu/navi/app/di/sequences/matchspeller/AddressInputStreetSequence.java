/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.commands.LISPGetLocationFromLIValueListElementCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelStartCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.command.LiGetLastStreetHistoryEntryCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputStreetSimpleSequence;
import de.audi.tghu.navi.app.li.SpellerStack;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIStreetHistoryEntry;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputStreetSequence
extends AddressInputStreetSimpleSequence {
    public AddressInputStreetSequence(ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, IMatchspellerModelAccess iMatchspellerModelAccess, IPreviewMap iPreviewMap, SpellerStack spellerStack, IAddressInputManager iAddressInputManager) {
        super(iCommandListFactory, navigationEnv, iMatchspellerModelAccess, iPreviewMap, spellerStack, iAddressInputManager);
    }

    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new ModelStartCommand(this.modelAccess));
        commandList.add(super.getStartCommandList());
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        if (this.previewMap != null) {
            commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, 1, null, null));
        }
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.inputManager));
        return commandList;
    }

    public void checkIfElementIsAmbiguous(LIValueListElement lIValueListElement, final Command command) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
        commandList.add(new NavCommand("Get NavLocation from Response Container"){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getSelectedLocation();
                this.logger.log(10000000, "Get NavLocation from Response Container - location=%1", (Object)navLocation);
                this.getCommandList().put("LocationToTest", navLocation);
                this.getCommandList().commandFinishedWithPostCommand(command);
            }
        });
        commandList.execute(this.CLASS_NAME + "#createCheckIfStreetIsAmbiguousCommandList");
    }

    public void showHistoryLocationInPreviewMap(final IPreviewMap iPreviewMap, LIStreetHistoryEntry lIStreetHistoryEntry) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LiGetLastStreetHistoryEntryCommand(lIStreetHistoryEntry));
        commandList.add(new NavCommand("SetNavLocationForPreviewMap"){

            public void execute() {
                Object object = this.getCommandList().get("STREET_HISTORY_ENTRY_LOCATION");
                if (object == null || !(object instanceof NavLocation)) {
                    this.getCommandList().commandAborted("unexpected Object");
                } else {
                    NavLocation navLocation = (NavLocation)object;
                    iPreviewMap.setPreviewLocationAroundReferencePoint(navLocation, null, 1, null, null);
                    this.getCommandList().commandFinished();
                }
            }
        });
        commandList.execute(this.CLASS_NAME + "#showHistoryLocationInPreviewMap");
    }
}

