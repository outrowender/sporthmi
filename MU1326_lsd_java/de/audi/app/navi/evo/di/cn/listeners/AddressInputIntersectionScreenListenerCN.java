/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.cn.listeners;

import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.app.navi.evo.di.cn.listeners.AbstractAddressInputListenerCN;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputJunctionSequence;

public class AddressInputIntersectionScreenListenerCN
extends AbstractAddressInputListenerCN {
    public AddressInputIntersectionScreenListenerCN(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager, AddressInputJunctionSequence addressInputJunctionSequence, int n, int n2, int n3) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager, addressInputJunctionSequence, n, n2, n3);
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

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "%1#itemSelected - item selected was called with model = %2, index = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        this.inputManager.getMainScreenListener().resetPreviousLocation();
        if (evoListRow instanceof AddressInputLIValueListElementListRow) {
            this.logChannel.log(10000000, "%1#itemSelected row is instanceOf AILIVLELR", (Object)this.CLASS_NAME);
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            this.inputManager.executeAddressInputEvent(this.inputSequence.getSelectListElementCommandList(addressInputLIValueListElementListRow.getElement()), 10602);
            this.env.fireModelEvent(n, n4);
        }
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "%1#itemFocused - item focused was called with model = %2, index = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (evoListRow instanceof AddressInputLIValueListElementListRow && this.previewMap != null && !this.isSpellerOpen) {
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            this.inputSequence.showLocationInPreviewMap(this.previewMap, addressInputLIValueListElementListRow.getElement());
        }
    }
}

