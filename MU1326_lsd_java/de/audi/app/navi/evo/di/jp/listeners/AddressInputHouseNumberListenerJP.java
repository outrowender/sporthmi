/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.listeners;

import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.app.navi.evo.di.AddressInputUtilEvo;
import de.audi.app.navi.evo.di.jp.listeners.AbstractAddressInputListenerJP;
import de.audi.app.navi.evo.di.jp.listeners.AddressInputHouseNumberListenerJP$1;
import de.audi.app.navi.evo.di.jp.listeners.AddressInputHouseNumberListenerJP$2;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelListener;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToPOIOnlineSearchSequence;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputHousenumberMatchSpellerSequence;

public class AddressInputHouseNumberListenerJP
extends AbstractAddressInputListenerJP
implements TiledListModelListener,
MenuModelListener {
    public AddressInputHouseNumberListenerJP(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager, AddressInputHousenumberMatchSpellerSequence addressInputHousenumberMatchSpellerSequence, int n, int n2, int n3) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager, addressInputHousenumberMatchSpellerSequence, n, n2, n3);
        this.initListeners();
    }

    @Override
    protected void initListeners() {
        this.tiledListModel = this.env.getTiledListModel(this.tiledListModelId);
        this.tiledListModel.setListener(this);
        this.menuModel = this.env.getMenuModel(this.menuModelId);
        this.menuModel.setListener(this);
        this.matchspellerModel = this.env.getMatchSpellerModel(this.matchSpellerModelId);
        this.matchspellerModel.setSpellerListener(this);
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "%1#itemSelected - item selected was called with model = %2, index = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        this.inputManager.getMainScreenListener().resetPreviousLocation();
        CommandList commandList = null;
        if (evoListRow instanceof AddressInputLIValueListElementListRow) {
            this.logChannel.log(-2137614336, "%1#itemSelected row is instanceOf AILIVLELR", (Object)this.CLASS_NAME);
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            commandList = this.inputManager.handleAddressInputEvent(this.inputSequence.getSelectListElementCommandList(addressInputLIValueListElementListRow.getElement()), 20802);
        }
        if (commandList != null) {
            if (AddressInputUtilEvo.isOnlinePOIContext(this.env)) {
                this.logChannel.log(-2137614336, "%1#itemSelected - in online POI new area set, finish new area setting.", (Object)this.CLASS_NAME);
                commandList.add(new ReturnNavLocationToPOIOnlineSearchSequence(this.commandListFactory).getStartCommandList());
                this.addFireModelEventCommand(n, n4, commandList);
            } else if (AddressInputUtilEvo.isNormalPOIContext(this.env)) {
                this.logChannel.log(-2137614336, "%1#itemSelected - in normal POI new area set, finish new area setting.", (Object)this.CLASS_NAME);
                this.addFireModelEventCommand(n, n4, commandList);
                commandList.add(new AddressInputHouseNumberListenerJP$1(this));
            } else {
                this.logChannel.log(-2137614336, "%1#itemSelected - in address input context.", (Object)this.CLASS_NAME);
                this.addFireModelEventCommand(n, n4, commandList);
            }
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#itemSelected").toString());
        } else {
            this.env.fireModelEvent(n, n4);
        }
    }

    private void addFireModelEventCommand(int n, int n2, ICommandList iCommandList) {
        iCommandList.add(new AddressInputHouseNumberListenerJP$2(this, "Delay fire model event", n, n2));
    }

    static /* synthetic */ IAddressInputManager access$000(AddressInputHouseNumberListenerJP addressInputHouseNumberListenerJP) {
        return addressInputHouseNumberListenerJP.inputManager;
    }
}

