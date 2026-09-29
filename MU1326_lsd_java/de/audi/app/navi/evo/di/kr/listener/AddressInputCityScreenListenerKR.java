/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr.listener;

import de.audi.app.navi.evo.addressinput.AddressInputHistoryElementListRow;
import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.app.navi.evo.di.kr.listener.AbstractAddressInputListenerKR;
import de.audi.app.navi.evo.di.kr.listener.AddressInputCityScreenListenerKR$1;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory$HistoryEntry;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSequence;
import org.dsi.ifc.navigation.LICityHistoryEntry;

public class AddressInputCityScreenListenerKR
extends AbstractAddressInputListenerKR {
    private final int cityNeedsWard;
    private final int wardAvailable;
    private final int wardUnavailable;

    public AddressInputCityScreenListenerKR(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager, AddressInputCityZipSequence addressInputCityZipSequence, int n, int n2, int n3) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager, addressInputCityZipSequence, n, n2, n3);
        this.cityNeedsWard = -1641806336;
        this.wardAvailable = 1;
        this.wardUnavailable = 0;
        this.initListeners();
    }

    @Override
    protected void initListeners() {
        this.tiledListModel = this.env.getTiledListModel(this.tiledListModelId);
        this.tiledListModel.setListener(this);
        this.matchspellerModel = this.env.getMatchSpellerModel(this.matchSpellerModelId);
        this.matchspellerModel.setSpellerListenerAsia(this);
        this.menuModel = this.env.getMenuModel(this.menuModelId);
        this.menuModel.setListener(this);
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "%1#itemSelected row=%2, model=%3, index=%4", (Object)this.CLASS_NAME, (Object)evoListRow, (Object)Integer.toString(n), (long)n2);
        this.inputManager.getMainScreenListener().resetPreviousLocation();
        CommandList commandList = null;
        if (evoListRow instanceof AddressInputLIValueListElementListRow) {
            this.logChannel.log(-2137614336, "%1#itemSelected row is instanceOf AddressInputLIValueListElementListRow", (Object)this.CLASS_NAME);
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            commandList = this.inputManager.handleAddressInputEvent(this.inputSequence.getSelectListElementCommandList(addressInputLIValueListElementListRow.getElement()), 178061312);
        } else if (evoListRow instanceof AddressInputHistoryElementListRow) {
            this.logChannel.log(-2137614336, "%1#itemSelected row is instanceOf AddressInputHistoryElementListRow", (Object)this.CLASS_NAME);
            AddressInputHistoryElementListRow addressInputHistoryElementListRow = (AddressInputHistoryElementListRow)evoListRow;
            CityHistory$HistoryEntry cityHistory$HistoryEntry = addressInputHistoryElementListRow.getHistoryEntry();
            commandList = this.inputManager.handleAddressInputEvent(((AddressInputCityZipSequence)this.inputSequence).getSelectHistoryElementCommandList((LICityHistoryEntry)cityHistory$HistoryEntry.getEntry()), 194838528);
        }
        if (commandList != null) {
            commandList.add(new AddressInputCityScreenListenerKR$1(this, n, n4));
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#itemSelected").toString());
        } else {
            this.env.fireModelEvent(n, n4);
        }
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "%1#itemFocused - item focused was called with model = %2, index = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (evoListRow instanceof AddressInputHistoryElementListRow) {
            if (this.previewMap != null && !this.isSpellerOpen) {
                AddressInputHistoryElementListRow addressInputHistoryElementListRow = (AddressInputHistoryElementListRow)evoListRow;
                CityHistory$HistoryEntry cityHistory$HistoryEntry = addressInputHistoryElementListRow.getHistoryEntry();
                ((AddressInputCityZipSequence)this.inputSequence).showHistoryLocationInPreviewMap(this.previewMap, (LICityHistoryEntry)cityHistory$HistoryEntry.getEntry());
            }
        } else {
            super.itemFocused(evoListRow, n, n2, n3, n4);
        }
    }

    static /* synthetic */ ICommandListFactory access$000(AddressInputCityScreenListenerKR addressInputCityScreenListenerKR) {
        return addressInputCityScreenListenerKR.commandListFactory;
    }

    static /* synthetic */ ICommandListFactory access$300(AddressInputCityScreenListenerKR addressInputCityScreenListenerKR) {
        return addressInputCityScreenListenerKR.commandListFactory;
    }

    static /* synthetic */ IAddressInputManager access$400(AddressInputCityScreenListenerKR addressInputCityScreenListenerKR) {
        return addressInputCityScreenListenerKR.inputManager;
    }
}

