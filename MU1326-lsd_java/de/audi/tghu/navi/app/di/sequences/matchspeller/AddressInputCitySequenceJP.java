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
import de.audi.tghu.navi.app.addressinput.commands.GetLastCityHistoryEntryCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCitySequenceJP$1;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCitySequenceJP$2;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCitySequenceJP$3;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCitySequenceJP$4;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCitySequenceJP$5;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSequenceAsia;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LICityHistoryEntry;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputCitySequenceJP
extends AddressInputCityZipSequenceAsia {
    public AddressInputCitySequenceJP(ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, IMatchspellerModelAccess iMatchspellerModelAccess, IPreviewMap iPreviewMap, SpellerStack spellerStack, IAddressInputManager iAddressInputManager, CityHistory cityHistory) {
        super(iCommandListFactory, navigationEnv, iMatchspellerModelAccess, iPreviewMap, spellerStack, iAddressInputManager, cityHistory);
    }

    @Override
    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("selectedElement", lIValueListElement);
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new AddressInputCitySequenceJP$1(this, "Check whether center is selected"));
        commandList.add(new AddressInputCitySequenceJP$2(this, "Update value of choice model"));
        commandList.add(new AddressInputCitySequenceJP$3(this, new StringBuffer().append(this.CLASS_NAME).append("#getSelectListElementCommandList Strip city and add to history").toString()));
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccess));
        commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.inputManager));
        return commandList;
    }

    protected int getStripLocationType() {
        return 25;
    }

    @Override
    public CommandList getSelectHistoryElementCommandList(LICityHistoryEntry lICityHistoryEntry) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("selectedElement", lICityHistoryEntry);
        commandList.add(new GetLastCityHistoryEntryCommand(lICityHistoryEntry));
        commandList.add(new AddressInputCitySequenceJP$4(this, new StringBuffer().append(this.CLASS_NAME).append("#getSelectHistoryElementCommandList - get history location from command list context").toString()));
        commandList.add(new AddressInputCitySequenceJP$5(this, "Update value of city_needs_ward choice model"));
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccess));
        commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.inputManager));
        return commandList;
    }

    private boolean isCenterSelected(NavLocation navLocation) {
        if (!navLocation.isPositionValid()) {
            return false;
        }
        String string = Util.getLocationAccessor(navLocation).getTown();
        return Util.isEmpty(string);
    }

    static /* synthetic */ boolean access$000(AddressInputCitySequenceJP addressInputCitySequenceJP, NavLocation navLocation) {
        return addressInputCitySequenceJP.isCenterSelected(navLocation);
    }
}

