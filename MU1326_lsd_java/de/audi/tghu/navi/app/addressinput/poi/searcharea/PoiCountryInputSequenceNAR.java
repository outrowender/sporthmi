/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.searcharea;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelStartCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.IPoiSearchAreaModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiCountryInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.SpellerStack;

public class PoiCountryInputSequenceNAR
extends PoiCountryInputSequence {
    public PoiCountryInputSequenceNAR(IMatchspellerModelAccess iMatchspellerModelAccess, IPoiSearchAreaModelAccess iPoiSearchAreaModelAccess, SpellerStack spellerStack, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, IAddressInputForm iAddressInputForm, IPreviewMap iPreviewMap, NavigationEnv navigationEnv) {
        super(iMatchspellerModelAccess, iPoiSearchAreaModelAccess, spellerStack, iCommandListFactory, poiSearchArea, iAddressInputForm, iPreviewMap, navigationEnv);
    }

    public CommandList createStartCommandList(boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        this.addGetStateCommand(commandList, bl, null);
        commandList.add(new ModelStartCommand(this.modelAccess));
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new NavCommand(){

            public void execute() {
                if (this.dsiResponseContainer.selectionCriterionAvailable(1) && this.dsiResponseContainer.selectionCriterionAvailable(138)) {
                    this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(1, 138, true, true, true));
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
}

