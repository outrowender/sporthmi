/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.listeners;

import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.app.navi.evo.di.jp.listeners.AbstractAddressInputListenerJP;
import de.audi.app.navi.evo.di.jp.listeners.AddressInputChomeScreenListenerJP$1;
import de.audi.app.navi.evo.di.jp.listeners.AddressInputChomeScreenListenerJP$2;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelListener;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputChomeSequence;

public class AddressInputChomeScreenListenerJP
extends AbstractAddressInputListenerJP
implements TiledListModelListener,
MenuModelListener {
    private final ChoiceModelApp housenumberAvailable;

    public AddressInputChomeScreenListenerJP(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager, AddressInputChomeSequence addressInputChomeSequence, int n, int n2, int n3) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager, addressInputChomeSequence, n, n2, n3);
        this.initListeners();
        this.housenumberAvailable = navigationEnv.getChoiceModel(DIScreensEvo.getDiJpChomeNeedsNumberChoice());
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
        this.inputManager.getMainScreenListener().resetPreviousLocation();
        CommandList commandList = null;
        int n5 = this.inputManager.getActiveSpellerContextId();
        if (evoListRow instanceof AddressInputLIValueListElementListRow) {
            this.logChannel.log(-2137614336, "%1#itemSelected row is instanceOf AILIVLELR", (Object)this.CLASS_NAME);
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            commandList = this.inputManager.handleAddressInputEvent(this.inputSequence.getSelectListElementCommandList(addressInputLIValueListElementListRow.getElement()), 20502);
        }
        if (commandList != null) {
            commandList.add(new AddressInputChomeScreenListenerJP$1(this, "Add post command list based on if number is available", n, n4, n5));
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#itemSelected").toString());
        } else {
            this.env.fireModelEvent(n, n4);
        }
    }

    private void addFireModelEventCommand(int n, int n2, ICommandList iCommandList) {
        iCommandList.add(new AddressInputChomeScreenListenerJP$2(this, "Delay fire model event", n, n2));
    }

    static /* synthetic */ ChoiceModelApp access$000(AddressInputChomeScreenListenerJP addressInputChomeScreenListenerJP) {
        return addressInputChomeScreenListenerJP.housenumberAvailable;
    }

    static /* synthetic */ void access$100(AddressInputChomeScreenListenerJP addressInputChomeScreenListenerJP, int n, int n2, ICommandList iCommandList) {
        addressInputChomeScreenListenerJP.addFireModelEventCommand(n, n2, iCommandList);
    }

    static /* synthetic */ ICommandListFactory access$200(AddressInputChomeScreenListenerJP addressInputChomeScreenListenerJP) {
        return addressInputChomeScreenListenerJP.commandListFactory;
    }

    static /* synthetic */ IAddressInputManager access$300(AddressInputChomeScreenListenerJP addressInputChomeScreenListenerJP) {
        return addressInputChomeScreenListenerJP.inputManager;
    }

    static /* synthetic */ ICommandListFactory access$400(AddressInputChomeScreenListenerJP addressInputChomeScreenListenerJP) {
        return addressInputChomeScreenListenerJP.commandListFactory;
    }

    static /* synthetic */ ICommandListFactory access$500(AddressInputChomeScreenListenerJP addressInputChomeScreenListenerJP) {
        return addressInputChomeScreenListenerJP.commandListFactory;
    }

    static /* synthetic */ IAddressInputManager access$700(AddressInputChomeScreenListenerJP addressInputChomeScreenListenerJP) {
        return addressInputChomeScreenListenerJP.inputManager;
    }
}

