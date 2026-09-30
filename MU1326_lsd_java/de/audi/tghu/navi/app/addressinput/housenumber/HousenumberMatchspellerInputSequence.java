/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.housenumber;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelSelectListElementCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelStartCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.addressinput.housenumber.HousenumberMatchspellerInputSimpleSequence;
import de.audi.tghu.navi.app.li.SpellerStack;
import org.dsi.ifc.navigation.LIValueListElement;

public class HousenumberMatchspellerInputSequence
extends HousenumberMatchspellerInputSimpleSequence {
    public HousenumberMatchspellerInputSequence(IMatchspellerModelAccess iMatchspellerModelAccess, SpellerStack spellerStack, ICommandListFactory iCommandListFactory, IPreviewMap iPreviewMap, IAddressInputForm iAddressInputForm) {
        super(iMatchspellerModelAccess, spellerStack, iCommandListFactory, iPreviewMap, iAddressInputForm);
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

    public CommandList getSelectElementByIndexCommandList(int n) {
        CommandList commandList = this.commandListFactory.createCommandList();
        LIValueListElement lIValueListElement = new LIValueListElement();
        lIValueListElement.toRefine = false;
        lIValueListElement.listIndex = n;
        commandList.add(this.getSelectListElementCommandList(lIValueListElement, true));
        commandList.add(new LISPSelectListItemCommand(n));
        commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        return commandList;
    }
}

