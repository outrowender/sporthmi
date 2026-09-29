/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.eu.listeners;

import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.app.navi.evo.di.eu.listeners.AbstractAddressInputListenerEU;
import de.audi.atip.hmi.model.MatchSpellerListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.model.list.TiledListModelListener;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputJunctionSequence;

public class AddressInputJunctionScreenListenerEU
extends AbstractAddressInputListenerEU
implements MenuModelListener,
TiledListModelListener,
MatchSpellerListener {
    private static final int MENU_MODEL_ID = DIScreensEvo.getDiEuJunctionScreenMenuModel();
    private static final int TILED_LIST_MODEL_ID = DIScreensEvo.getDiEuJunctionScreenTiledListModel();
    private static final int MATCH_SPELLER_MODEL_ID = DIScreensEvo.getDiEuJunctionScreenMatchSpellerModel();
    private final AddressInputJunctionSequence inputSequence;
    private TiledListModelApp tiledListModel;
    private MenuModelApp menuModel;

    public AddressInputJunctionScreenListenerEU(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager, AddressInputJunctionSequence addressInputJunctionSequence) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager);
        this.inputSequence = addressInputJunctionSequence;
        this.initListeners();
    }

    @Override
    protected void initListeners() {
        this.menuModel = this.env.getMenuModel(MENU_MODEL_ID);
        this.menuModel.setListener(this);
        this.tiledListModel = this.env.getTiledListModel(TILED_LIST_MODEL_ID);
        this.tiledListModel.setListener(this);
        this.env.getMatchSpellerModel(MATCH_SPELLER_MODEL_ID).setSpellerListener(this);
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
            this.logChannel.log(-2137614336, "#itemSelected row is instanceOf AILIVLELR", (Object)this.CLASS_NAME);
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            this.inputManager.executeAddressInputEvent(this.inputSequence.getSelectListElementCommandList(addressInputLIValueListElementListRow.getElement()), 602);
            this.env.fireModelEvent(n, n4);
        }
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        this.logChannel.log(-2137614336, "%1#itemFocused (menu model) - menuItemId=%2, model=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (n == MATCH_SPELLER_MODEL_ID) {
            this.inputSequence.hidePreviewMap(this.previewMap);
        }
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "%1#itemFocused (list model) - model = %2, index = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (evoListRow instanceof AddressInputLIValueListElementListRow && this.previewMap != null) {
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            this.inputSequence.showLocationInPreviewMap(this.previewMap, addressInputLIValueListElementListRow.getElement());
        }
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "%1#keyTyped - keyTyped - model = %2, index = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        long l = this.env.getContainer().getLispValueListCount();
        this.logChannel.log(-2137614336, "%1#keyTyped - valueListCount = %2 ", (Object)this.CLASS_NAME, l);
        if (l == 1L && null != this.menuModel) {
            if (this.tiledListModel == null) {
                this.logChannel.log(-2137614336, "%1#keyTyped - tiledListModel is null", (Object)this.CLASS_NAME);
                return;
            }
            if (this.tiledListModel.getRow(0) == null) {
                this.logChannel.log(-2137614336, "%1#keyTyped - tiledListModel.getRow(0) is null", (Object)this.CLASS_NAME);
                return;
            }
            EvoListRow evoListRow = this.tiledListModel.getRow(0);
            this.menuModel.setFocusedItem(this.tiledListModel.getID(), FocusAdvice.VIEWPORT_FIRST_POSITION, evoListRow.getUniqueID());
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            this.inputManager.executeAddressInputEvent(this.inputSequence.getSelectListElementCommandList(addressInputLIValueListElementListRow.getElement()), 602);
            this.env.fireModelEvent(this.tiledListModel.getID(), n3);
        }
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        this.logChannel.log(-2137614336, "%1#textChanged(%2, %3, %4)", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)string, (long)c2);
        this.setSpellerStatusWaiting(n);
        if ("".equals(string)) {
            this.inputSequence.deleteAllCharacters();
        } else if (c2 == '\b') {
            this.inputSequence.undoCharacter();
        } else {
            this.inputSequence.addCharacter(Character.toString(c2), n, false);
        }
    }

    @Override
    public void requestItems(int n, int n2, int n3, int n4, int n5) {
        this.logChannel.log(-2137614336, "%1#requestItems - requestID = %2, startIndex = %3, model = %4", (Object)this.CLASS_NAME, (Object)Integer.toString(n3), (Object)Integer.toString(n), (long)n4);
        this.inputSequence.requestNextResultListWindow(n, n3);
    }

    @Override
    public void unrequestItems(int n, int n2, int n3, int n4) {
        this.inputSequence.unrequestItems(n, n2);
    }

    @Override
    public void focusedCharacter(int n, char c2, int n2) {
    }

    @Override
    public void commandPressed(int n, int n2, int n3) {
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }
}

