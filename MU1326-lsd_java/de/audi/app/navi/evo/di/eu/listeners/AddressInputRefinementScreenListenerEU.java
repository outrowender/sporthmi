/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.eu.listeners;

import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.app.navi.evo.di.eu.listeners.AbstractAddressInputListenerEU;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelListener;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputRefinementSequence;

public class AddressInputRefinementScreenListenerEU
extends AbstractAddressInputListenerEU
implements MenuModelListener,
TiledListModelListener {
    private static final int MENU_MODEL_ID = DIScreensEvo.getDiEuRefinementScreenMenuModel();
    private static final int TILED_LIST_MODEL_ID = DIScreensEvo.getDiEuRefinementScreenTiledListModel();
    private final AddressInputRefinementSequence inputSequence;

    public AddressInputRefinementScreenListenerEU(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager, AddressInputRefinementSequence addressInputRefinementSequence) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager);
        this.inputSequence = addressInputRefinementSequence;
        this.initListeners();
    }

    @Override
    protected void initListeners() {
        this.env.getMenuModel(MENU_MODEL_ID).setListener(this);
        this.env.getTiledListModel(TILED_LIST_MODEL_ID).setListener(this);
    }

    @Override
    public CommandList getStartCommandList() {
        return this.inputSequence.getStartCommandList();
    }

    @Override
    public CommandList getStartCommandList(String string) {
        return this.inputSequence.getStartCommandList(string);
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "%1#itemSelected - item selected was called with model = %2, index = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (evoListRow instanceof AddressInputLIValueListElementListRow) {
            this.logChannel.log(-2137614336, "%1#itemSelected row is instanceOf AILIVLELR", (Object)this.CLASS_NAME);
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            this.inputManager.executeAddressInputEvent(this.inputSequence.getSelectListElementCommandList(addressInputLIValueListElementListRow.getElement()), 702);
            this.env.fireModelEvent(n, n4);
        }
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        this.logChannel.log(-2137614336, "%1#itemFocused (menu model) - menuItemID = %2, model = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "%1#itemFocused (list model) - row=%2, model=%3, index=%4", (Object)this.CLASS_NAME, (Object)evoListRow, (Object)Integer.toString(n), (long)n2);
        if (evoListRow instanceof AddressInputLIValueListElementListRow && this.previewMap != null) {
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            this.removeFocusedItemIsInvalidProperty(evoListRow);
            this.inputSequence.showLocationInPreviewMap(this.previewMap, addressInputLIValueListElementListRow.getElement());
        }
    }

    @Override
    public void requestItems(int n, int n2, int n3, int n4, int n5) {
        this.logChannel.log(-2137614336, "%1#requestItems - was called with requestID = %2, startIndex = %3, model = %4", (Object)this.CLASS_NAME, (Object)Integer.toString(n3), (Object)Integer.toString(n), (long)n4);
        this.inputSequence.requestNextResultListWindow(n, n3);
    }

    @Override
    public void unrequestItems(int n, int n2, int n3, int n4) {
        this.inputSequence.unrequestItems(n, n2);
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }
}

