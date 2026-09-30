/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.street;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.commands.LISPGetLocationFromLIValueListElementCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelStartCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.addressinput.street.StreetInputSimpleSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public class StreetInputSequence
extends StreetInputSimpleSequence {
    public static final String LOCATION_TO_TEST = "LocationToTest";

    public StreetInputSequence(IMatchspellerModelAccess iMatchspellerModelAccess, IMatchspellerModelAccess iMatchspellerModelAccess2, SpellerStack spellerStack, ICommandListFactory iCommandListFactory, boolean bl, IPreviewMap iPreviewMap, IAddressInputForm iAddressInputForm) {
        super(iMatchspellerModelAccess, iMatchspellerModelAccess2, spellerStack, iCommandListFactory, bl, iPreviewMap, iAddressInputForm);
    }

    public StreetInputSequence(IMatchspellerModelAccess iMatchspellerModelAccess, IMatchspellerModelAccess iMatchspellerModelAccess2, SpellerStack spellerStack, ICommandListFactory iCommandListFactory, IPreviewMap iPreviewMap, IAddressInputForm iAddressInputForm) {
        super(iMatchspellerModelAccess, iMatchspellerModelAccess2, spellerStack, iCommandListFactory, true, iPreviewMap, iAddressInputForm);
    }

    public CommandList createStartCommandList(boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        this.addGetStateCommand(commandList, bl, null);
        commandList.add(new ModelStartCommand(this.modelAccess));
        commandList.add(super.createStartCommandList(bl));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        if (this.previewMap != null) {
            commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, 1, null, null));
        }
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.addressInputForm));
        return commandList;
    }

    public void checkIfElementIsAmbiguous(LIValueListElement lIValueListElement, final Command command) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
        commandList.add(new NavCommand("Get NavLocation from Response Container"){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getSelectedLocation();
                this.logger.log(10000000, "Get NavLocation from Response Container - location=%1", (Object)navLocation);
                this.getCommandList().put(StreetInputSequence.LOCATION_TO_TEST, navLocation);
                this.getCommandList().commandFinishedWithPostCommand(command);
            }
        });
        commandList.execute("StreetInputSequence#createCheckIfStreetIsAmbiguousCommandList");
    }
}

