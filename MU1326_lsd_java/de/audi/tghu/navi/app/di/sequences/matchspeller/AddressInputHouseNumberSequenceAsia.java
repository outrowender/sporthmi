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
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputHouseNumberSequenceAsia$1;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputHouseNumberSequenceAsia$2;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputHousenumberMatchSpellerSequence;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputHouseNumberSequenceAsia
extends AddressInputHousenumberMatchSpellerSequence {
    private static boolean isHouseNumberCenterSelected = false;

    public AddressInputHouseNumberSequenceAsia(ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, IMatchspellerModelAccess iMatchspellerModelAccess, IPreviewMap iPreviewMap, SpellerStack spellerStack, IAddressInputManager iAddressInputManager) {
        super(iCommandListFactory, navigationEnv, iMatchspellerModelAccess, iPreviewMap, spellerStack, iAddressInputManager);
    }

    @Override
    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new AddressInputHouseNumberSequenceAsia$1(this, "Check whether center is selected"));
        commandList.add(new AddressInputHouseNumberSequenceAsia$2(this));
        return commandList;
    }

    private boolean isCenterSelected(NavLocation navLocation) {
        if (!navLocation.isPositionValid()) {
            return false;
        }
        String string = Util.getLocationAccessor(navLocation).getHousenumber();
        return Util.isEmpty(string);
    }

    public static void setIsHouseNumberCenterSelected(boolean bl) {
        isHouseNumberCenterSelected = bl;
    }

    public static boolean isHouseNumberCenterSelected() {
        return isHouseNumberCenterSelected;
    }

    static /* synthetic */ boolean access$000(AddressInputHouseNumberSequenceAsia addressInputHouseNumberSequenceAsia, NavLocation navLocation) {
        return addressInputHouseNumberSequenceAsia.isCenterSelected(navLocation);
    }
}

