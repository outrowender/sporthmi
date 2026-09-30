/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.cn.listeners;

import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.app.navi.evo.di.cn.listeners.AbstractAddressInputListenerCN;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToPOIOnlineSearchSequence;
import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToRemoteHmiFromCurrentLDSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputStreetSequence;

public class AddressInputStreetScreenListenerCN
extends AbstractAddressInputListenerCN {
    public AddressInputStreetScreenListenerCN(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager, AddressInputStreetSequence addressInputStreetSequence, int n, int n2, int n3) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager, addressInputStreetSequence, n, n2, n3);
        this.initListeners();
    }

    protected void initListeners() {
        this.menuModel = this.env.getMenuModel(this.menuModelId);
        this.menuModel.setListener(this);
        this.tiledListModel = this.env.getTiledListModel(this.tiledListModelId);
        this.tiledListModel.setListener(this);
        this.matchspellerModel = this.env.getMatchSpellerModel(this.matchSpellerModelId);
        this.matchspellerModel.setSpellerListenerAsia(this);
    }

    public void itemSelected(EvoListRow evoListRow, final int n, int n2, int n3, final int n4) {
        this.logChannel.log(10000000, "%1#itemSelected - item selected was called with model = %2, index = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        this.inputManager.getMainScreenListener().resetPreviousLocation();
        CommandList commandList = null;
        int n5 = this.inputManager.getActiveSpellerContextId();
        if (evoListRow instanceof AddressInputLIValueListElementListRow) {
            this.logChannel.log(10000000, "%1#itemSelected row is instanceOf AILIVLELR", (Object)this.CLASS_NAME);
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            commandList = this.inputManager.handleAddressInputEvent(this.inputSequence.getSelectListElementCommandList(addressInputLIValueListElementListRow.getElement()), 10402);
        }
        if (commandList != null) {
            if (n5 == 86) {
                commandList.add(new ReturnNavLocationToPOIOnlineSearchSequence(this.commandListFactory).getStartCommandList());
            } else if (n5 == 87) {
                commandList.add(new ReturnNavLocationToRemoteHmiFromCurrentLDSequence(this.commandListFactory).getStartCommandList());
            }
            commandList.add(new NavCommand("Delay fire model event"){

                public void execute() {
                    this.env.fireModelEvent(n, n4);
                    this.getCommandList().commandFinished();
                }
            });
            commandList.execute(this.CLASS_NAME + "#itemSelected");
        } else {
            this.env.fireModelEvent(n, n4);
        }
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "%1#itemFocused row=%2, model=%3, index=%4", (Object)this.CLASS_NAME, (Object)evoListRow, (Object)Integer.toString(n), (long)n2);
        if (evoListRow instanceof AddressInputLIValueListElementListRow && this.previewMap != null && !this.isSpellerOpen) {
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            this.removeFocusedItemIsInvalidProperty(evoListRow);
            this.inputSequence.showLocationInPreviewMap(this.previewMap, addressInputLIValueListElementListRow.getElement());
        }
    }
}

