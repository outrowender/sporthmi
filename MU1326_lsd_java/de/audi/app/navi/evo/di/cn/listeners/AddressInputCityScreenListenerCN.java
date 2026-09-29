/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.cn.listeners;

import de.audi.app.navi.evo.addressinput.AddressInputHistoryElementListRow;
import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.app.navi.evo.di.AddressInputUtilEvo;
import de.audi.app.navi.evo.di.cn.listeners.AbstractAddressInputListenerCN;
import de.audi.app.navi.evo.di.cn.listeners.AddressInputCityScreenListenerCN$1;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory$HistoryEntry;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSequence;
import org.dsi.ifc.navigation.LICityHistoryEntry;

public class AddressInputCityScreenListenerCN
extends AbstractAddressInputListenerCN {
    private final AddressInputCityZipSequence originalInputSequence;

    public AddressInputCityScreenListenerCN(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager, AddressInputCityZipSequence addressInputCityZipSequence, int n, int n2, int n3) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager, addressInputCityZipSequence, n, n2, n3);
        this.originalInputSequence = addressInputCityZipSequence;
        this.initListeners();
    }

    @Override
    protected void initListeners() {
        this.menuModel = this.env.getMenuModel(this.menuModelId);
        this.menuModel.setListener(this);
        this.tiledListModel = this.env.getTiledListModel(this.tiledListModelId);
        this.tiledListModel.setListener(this);
        this.matchspellerModel = this.env.getMatchSpellerModel(this.matchSpellerModelId);
        this.matchspellerModel.setSpellerListenerAsia(this);
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "%1#itemSelected row=%2, model=%3, index=%4", (Object)this.CLASS_NAME, (Object)evoListRow, (Object)Integer.toString(n), (long)n2);
        this.inputManager.getMainScreenListener().resetPreviousLocation();
        CommandList commandList = null;
        if (evoListRow instanceof AddressInputLIValueListElementListRow) {
            this.logChannel.log(-2137614336, "%1#itemSelected row is instanceOf AddressInputLIValueListElementListRow", (Object)this.CLASS_NAME);
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            commandList = this.inputManager.handleAddressInputEvent(this.inputSequence.getSelectListElementCommandList(addressInputLIValueListElementListRow.getElement()), 10102);
        } else if (evoListRow instanceof AddressInputHistoryElementListRow) {
            this.logChannel.log(-2137614336, "%1#itemSelected row is instanceOf AddressInputHistoryElementListRow", (Object)this.CLASS_NAME);
            AddressInputHistoryElementListRow addressInputHistoryElementListRow = (AddressInputHistoryElementListRow)evoListRow;
            CityHistory$HistoryEntry cityHistory$HistoryEntry = addressInputHistoryElementListRow.getHistoryEntry();
            commandList = this.inputManager.handleAddressInputEvent(this.originalInputSequence.getSelectHistoryElementCommandList((LICityHistoryEntry)cityHistory$HistoryEntry.getEntry()), 10103);
        }
        if (AddressInputUtilEvo.isNormalPOIContext(this.env)) {
            commandList.add(new AddressInputCityScreenListenerCN$1(this, "Start POI service with new search area"));
        }
        commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("itemSelected").toString());
        this.env.fireModelEvent(n, n4);
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "%1#itemFocused - item focused was called with model = %2, index = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (evoListRow instanceof AddressInputHistoryElementListRow) {
            if (this.previewMap != null && !this.isSpellerOpen) {
                AddressInputHistoryElementListRow addressInputHistoryElementListRow = (AddressInputHistoryElementListRow)evoListRow;
                CityHistory$HistoryEntry cityHistory$HistoryEntry = addressInputHistoryElementListRow.getHistoryEntry();
                this.originalInputSequence.showHistoryLocationInPreviewMap(this.previewMap, (LICityHistoryEntry)cityHistory$HistoryEntry.getEntry());
            }
        } else if (evoListRow instanceof AddressInputLIValueListElementListRow && this.previewMap != null && !this.isSpellerOpen) {
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            this.originalInputSequence.showLocationInPreviewMap(this.previewMap, addressInputLIValueListElementListRow.getElement());
        }
    }

    static /* synthetic */ IAddressInputManager access$000(AddressInputCityScreenListenerCN addressInputCityScreenListenerCN) {
        return addressInputCityScreenListenerCN.inputManager;
    }
}

