/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelStartCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.LiGetLastStreetHistoryEntryCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputStreetSequence;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputStreetSequenceNAR$1;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputStreetSequenceNAR$2;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputStreetSequenceNAR$3;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputStreetSequenceNAR$4;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputStreetSequenceNAR$5;
import de.audi.tghu.navi.app.li.SpellerStack;
import org.dsi.ifc.navigation.LIStreetHistoryEntry;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputStreetSequenceNAR
extends AddressInputStreetSequence {
    public AddressInputStreetSequenceNAR(ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, IMatchspellerModelAccess iMatchspellerModelAccess, IPreviewMap iPreviewMap, SpellerStack spellerStack, IAddressInputManager iAddressInputManager) {
        super(iCommandListFactory, navigationEnv, iMatchspellerModelAccess, iPreviewMap, spellerStack, iAddressInputManager);
    }

    @Override
    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new ModelStartCommand(this.modelAccess));
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new AddressInputStreetSequenceNAR$1(this));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        return commandList;
    }

    @Override
    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("selectedElement", lIValueListElement);
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new AddressInputStreetSequenceNAR$2(this));
        return commandList;
    }

    public CommandList getSelectHistoryElementCommandList(LIStreetHistoryEntry lIStreetHistoryEntry) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("selectedElement", lIStreetHistoryEntry);
        commandList.add(new LiGetLastStreetHistoryEntryCommand(lIStreetHistoryEntry));
        commandList.add(new AddressInputStreetSequenceNAR$3(this));
        commandList.add(new AddressInputStreetSequenceNAR$4(this));
        commandList.add(new AddressInputStreetSequenceNAR$5(this));
        return commandList;
    }
}

