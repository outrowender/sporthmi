/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.listeners;

import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.app.navi.evo.di.AddressInputUtilEvo;
import de.audi.app.navi.evo.di.jp.listeners.AbstractAddressInputListenerJP;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToRemoteHmiFromCurrentLDSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AbstractAddressInputMatchSpellerSequence;

public class AddressInputWardScreenListenerJP
extends AbstractAddressInputListenerJP {
    public AddressInputWardScreenListenerJP(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager, AbstractAddressInputMatchSpellerSequence abstractAddressInputMatchSpellerSequence, int n, int n2, int n3) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager, abstractAddressInputMatchSpellerSequence, n, n2, n3);
        this.initListeners();
    }

    protected void initListeners() {
        this.tiledListModel = this.env.getTiledListModel(this.tiledListModelId);
        this.tiledListModel.setListener(this);
        this.matchspellerModel = this.env.getMatchSpellerModel(this.matchSpellerModelId);
        this.matchspellerModel.setSpellerListenerAsia(this);
        this.menuModel = this.env.getMenuModel(this.menuModelId);
        this.menuModel.setListener(this);
    }

    public void itemSelected(EvoListRow evoListRow, final int n, int n2, int n3, final int n4) {
        this.logChannel.log(10000000, "%1#itemSelected - item selected was called with model = %2, index = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        this.inputManager.getMainScreenListener().resetPreviousLocation();
        CommandList commandList = null;
        if (evoListRow instanceof AddressInputLIValueListElementListRow) {
            this.logChannel.log(10000000, "%1#itemSelected row is instanceOf AILIVLELR", (Object)this.CLASS_NAME);
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            commandList = this.inputManager.handleAddressInputEvent(this.inputSequence.getSelectListElementCommandList(addressInputLIValueListElementListRow.getElement()), 20702);
        }
        int n5 = this.inputManager.getActiveSpellerContextId();
        this.logChannel.log(10000000, this.CLASS_NAME + "itemSelected -- activeSpellerContextId = " + n5);
        if (commandList != null) {
            if (AddressInputUtilEvo.isRemoteHMIPOIContext(this.env) && n5 == 82) {
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
        this.env.fireModelEvent(n, n4);
    }
}

