/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.commands.LispSelectListItemByIdent;
import de.audi.tghu.navi.app.addressinput.commands.ModelSelectListElementCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelStartCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
import de.audi.tghu.navi.app.addressinput.commands.SetHistoryContextWithCurrentLDCommand;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.addressinput.country.UpdateDestinationCountryCodeCommand;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.LISetCountryForCityAndStreetHistoryCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AbstractAddressInputMatchSpellerSequence;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputCountrySequence
extends AbstractAddressInputMatchSpellerSequence {
    public AddressInputCountrySequence(ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, IMatchspellerModelAccess iMatchspellerModelAccess, IPreviewMap iPreviewMap, SpellerStack spellerStack, IAddressInputManager iAddressInputManager) {
        super(iCommandListFactory, navigationEnv, iMatchspellerModelAccess, iPreviewMap, spellerStack, iAddressInputManager);
    }

    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new ModelStartCommand(this.modelAccess));
        commandList.add(new LISPCancelSpellerCommand());
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessorFactory().createLocationAccessorFromGeoPos(0, 0);
        NavLocation navLocation = Util.getLocationAccessorFactory().toLocation(iMyLocationAccessor);
        commandList.add(new LISetCurrentLDCommand(navLocation));
        commandList.add(new NavCommand("Decide to start Country+State or just Country Speller"){

            public void execute() {
                if (Util.isHURegionNAR()) {
                    this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(139, true, true, true));
                } else if (this.dsiResponseContainer.selectionCriterionAvailable(1)) {
                    this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(1, true, true, true));
                } else {
                    this.getCommandList().commandAborted("SELCRITDES_COUNTRY_STATE is not available as selection criteria");
                }
            }
        });
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        return commandList;
    }

    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new SetHistoryContextWithCurrentLDCommand());
        commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccess));
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.inputManager));
        if (this.env.getInputModeManager().isSdsActive()) {
            commandList.add(new UpdateDestinationCountryCodeCommand());
        }
        commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, 1, null, null));
        return commandList;
    }

    public CommandList getSelectElementByIdentifierCommandList(String string) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LispSelectListItemByIdent(string));
        commandList.add(new NavCommand(){

            public void execute() {
                this.getCommandList().commandFinishedWithPostCommand(new LISetCountryForCityAndStreetHistoryCommand(this.dsiResponseContainer.getLiCurrentLD().getCountryAbbreviation()));
            }
        });
        commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        return commandList;
    }

    public void showLocationInPreviewMap(IPreviewMap iPreviewMap, LIValueListElement lIValueListElement) {
    }
}

