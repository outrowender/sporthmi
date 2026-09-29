/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr.listener;

import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.app.navi.evo.di.AddressInputUtilEvo;
import de.audi.app.navi.evo.di.kr.listener.AbstractAddressInputListenerKR;
import de.audi.app.navi.evo.di.kr.listener.AddressInputTownStreetScreenListenerKR$1;
import de.audi.app.navi.evo.di.kr.listener.AddressInputTownStreetScreenListenerKR$2;
import de.audi.app.navi.evo.di.kr.listener.AddressInputTownStreetScreenListenerKR$3;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputTownStreetSequence;

public class AddressInputTownStreetScreenListenerKR
extends AbstractAddressInputListenerKR {
    private static final int townStreetNeedsVillageStreet;

    public AddressInputTownStreetScreenListenerKR(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager, AddressInputTownStreetSequence addressInputTownStreetSequence, int n, int n2, int n3) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager, addressInputTownStreetSequence, n, n2, n3);
        this.initListeners();
    }

    @Override
    protected void initListeners() {
        this.tiledListModel = this.env.getTiledListModel(this.tiledListModelId);
        this.tiledListModel.setListener(this);
        this.menuModel = this.env.getMenuModel(this.menuModelId);
        this.menuModel.setListener(this);
        this.matchspellerModel = this.env.getMatchSpellerModel(this.matchSpellerModelId);
        this.matchspellerModel.setSpellerListenerAsia(this);
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "%1#itemSelected - item selected was called with model = %2, index = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        CommandList commandList = null;
        if (evoListRow instanceof AddressInputLIValueListElementListRow) {
            this.logChannel.log(-2137614336, "%1#itemSelected row is instanceOf AILIVLELR", (Object)this.CLASS_NAME);
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            commandList = this.inputManager.handleAddressInputEvent(this.inputSequence.getSelectListElementCommandList(addressInputLIValueListElementListRow.getElement()), 916324352);
        }
        if (commandList != null) {
            if (AddressInputUtilEvo.isInPOIRelatedContext(this.env)) {
                commandList.add(new AddressInputTownStreetScreenListenerKR$1(this, "start poi with search context"));
                this.addFireModelEventCommand(n, n4, commandList);
            } else {
                commandList.add(new AddressInputTownStreetScreenListenerKR$2(this, n, n4));
            }
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#itemSelected").toString());
        } else {
            this.env.fireModelEvent(n, n4);
        }
    }

    private void addFireModelEventCommand(int n, int n2, ICommandList iCommandList) {
        iCommandList.add(new AddressInputTownStreetScreenListenerKR$3(this, "Delay fire model event", n, n2));
    }

    static /* synthetic */ IAddressInputManager access$000(AddressInputTownStreetScreenListenerKR addressInputTownStreetScreenListenerKR) {
        return addressInputTownStreetScreenListenerKR.inputManager;
    }

    static /* synthetic */ ICommandListFactory access$100(AddressInputTownStreetScreenListenerKR addressInputTownStreetScreenListenerKR) {
        return addressInputTownStreetScreenListenerKR.commandListFactory;
    }

    static /* synthetic */ void access$200(AddressInputTownStreetScreenListenerKR addressInputTownStreetScreenListenerKR, int n, int n2, ICommandList iCommandList) {
        addressInputTownStreetScreenListenerKR.addFireModelEventCommand(n, n2, iCommandList);
    }

    static /* synthetic */ ICommandListFactory access$300(AddressInputTownStreetScreenListenerKR addressInputTownStreetScreenListenerKR) {
        return addressInputTownStreetScreenListenerKR.commandListFactory;
    }

    static /* synthetic */ IAddressInputManager access$400(AddressInputTownStreetScreenListenerKR addressInputTownStreetScreenListenerKR) {
        return addressInputTownStreetScreenListenerKR.inputManager;
    }
}

