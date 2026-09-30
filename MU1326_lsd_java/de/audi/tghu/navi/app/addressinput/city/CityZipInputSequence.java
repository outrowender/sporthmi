/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.city;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.city.CityZipInputSimpleSequence;
import de.audi.tghu.navi.app.addressinput.commands.ModelStartCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.li.SpellerStack;

public class CityZipInputSequence
extends CityZipInputSimpleSequence {
    public CityZipInputSequence(IMatchspellerModelAccess iMatchspellerModelAccess, SpellerStack spellerStack, ICommandListFactory iCommandListFactory, CityHistory cityHistory, IPreviewMap iPreviewMap, IAddressInputForm iAddressInputForm) {
        super(iMatchspellerModelAccess, spellerStack, iCommandListFactory, cityHistory, -1, iPreviewMap, iAddressInputForm);
    }

    public CityZipInputSequence(IMatchspellerModelAccess iMatchspellerModelAccess, SpellerStack spellerStack, ICommandListFactory iCommandListFactory, CityHistory cityHistory, int n, IPreviewMap iPreviewMap, IAddressInputForm iAddressInputForm) {
        super(iMatchspellerModelAccess, spellerStack, iCommandListFactory, cityHistory, n, iPreviewMap, iAddressInputForm);
    }

    public CommandList createStartCommandList(boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        this.addGetStateCommand(commandList, bl, null);
        commandList.add(new ModelStartCommand(this.modelAccess));
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(super.createStartCommandList(bl));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        if (this.previewMap != null) {
            commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
        }
        return commandList;
    }
}

