/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.commands.AddressInputRequestValueListByIndexCommand;
import de.audi.tghu.navi.app.addressinput.commands.GetLastStateHistoryEntryCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPRequestValueListByListIndexCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelSelectListElementCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelStartCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.sds.LIStripLocationCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSequence;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputProvinceSequenceAsia$1;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputProvinceSequenceAsia$2;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputProvinceSequenceAsia$3;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputProvinceSequenceAsia$4;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIStateHistoryEntry;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputProvinceSequenceAsia
extends AddressInputCityZipSequence {
    public AddressInputProvinceSequenceAsia(ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, IMatchspellerModelAccess iMatchspellerModelAccess, IPreviewMap iPreviewMap, SpellerStack spellerStack, IAddressInputManager iAddressInputManager, CityHistory cityHistory) {
        super(iCommandListFactory, navigationEnv, iMatchspellerModelAccess, iPreviewMap, spellerStack, iAddressInputManager, cityHistory);
    }

    @Override
    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new ModelStartCommand(this.modelAccess));
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(new LIStartSpellerCommand(138, false, false, false));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        if (this.previewMap != null) {
            commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
        }
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.inputManager));
        return commandList;
    }

    @Override
    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new AddressInputProvinceSequenceAsia$1(this, new StringBuffer().append(this.CLASS_NAME).append("#getSelectListElementCommandList Strip location and add to history").toString()));
        commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccess));
        commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.inputManager));
        return commandList;
    }

    public CommandList getNationWideElementSelectedCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        NavLocation navLocation = this.env.getContainer().getLiCurrentLD();
        commandList.add(new LIStripLocationCommand(navLocation, 15));
        commandList.add(new AddressInputProvinceSequenceAsia$2(this, "Set stripped location as currentLd"));
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccess));
        commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.inputManager));
        return commandList;
    }

    public CommandList getSelectHistoryElementCommandList(LIStateHistoryEntry lIStateHistoryEntry) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("selectedElement", lIStateHistoryEntry);
        commandList.add(new GetLastStateHistoryEntryCommand(lIStateHistoryEntry));
        commandList.add(new AddressInputProvinceSequenceAsia$3(this, new StringBuffer().append(this.CLASS_NAME).append("#getSelectHistoryElementCommandList - get history location from command list context").toString()));
        commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccess));
        commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.inputManager));
        return commandList;
    }

    public void showHistoryLocationInPreviewMap(IPreviewMap iPreviewMap, LIStateHistoryEntry lIStateHistoryEntry) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new GetLastStateHistoryEntryCommand(lIStateHistoryEntry));
        commandList.add(new AddressInputProvinceSequenceAsia$4(this, new StringBuffer().append(this.CLASS_NAME).append("#showHistoryLocationInPreviewMap - SetNavLocationForPreviewMap").toString(), iPreviewMap));
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#showHistoryLocationInPreviewMap").toString());
    }

    @Override
    public void requestNextResultListWindow(int n, int n2) {
        this.logChannel.log(-2137614336, "%1#requestNextResultListWindow(), anchorIndex = %2, requestID = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        CommandList commandList = this.commandListFactory.createCommandList(1);
        if (Util.isPorsche(this.env.getFramework()) || Util.isPorscheGen2(this.env.getFramework()) || Util.isBentley(this.env.getFramework())) {
            commandList.add(new AddressInputRequestValueListByIndexCommand(n, true));
            commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess, n2, n));
        } else {
            int n3 = 0;
            String string = this.env.getContainer().getLispCurrentInput();
            if (this.cityHistory != null && this.cityHistory.getMatchingLastStates(string) != null) {
                n3 = this.cityHistory.getMatchingLastStates(string).size();
            }
            commandList.add(new LISPRequestValueListByListIndexCommand(n - n3, true));
            commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess, n2, n));
        }
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#requestNextResultListWindows").toString());
    }
}

