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
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCountrySequence;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputCountryScreenListenerEU
extends AbstractAddressInputListenerEU
implements TiledListModelListener,
MatchSpellerListener,
MenuModelListener {
    private static final int TILED_LIST_MODEL_ID = DIScreensEvo.getDiEuCountryScreenTiledListModel();
    private static final int MENU_MODEL_ID = DIScreensEvo.getDiEuCountryScreenMenuModel();
    private static final int MATCHSPELLER_MODEL_ID = DIScreensEvo.getDiEuCountryScreenMatchSpellerModel();
    private final AddressInputCountrySequence inputSequence;
    private TiledListModelApp tiledListModel;
    private MenuModelApp menuModel;

    public AddressInputCountryScreenListenerEU(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager, AddressInputCountrySequence addressInputCountrySequence) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager);
        this.inputSequence = addressInputCountrySequence;
        this.initListeners();
    }

    protected void initListeners() {
        this.tiledListModel = this.env.getTiledListModel(TILED_LIST_MODEL_ID);
        this.tiledListModel.setListener(this);
        this.menuModel = this.env.getMenuModel(MENU_MODEL_ID);
        this.menuModel.setListener(this);
        this.env.getMatchSpellerModel(MATCHSPELLER_MODEL_ID).setSpellerListener(this);
    }

    public CommandList getStartCommandList() {
        this.menuModel.resetFocusedItem();
        return this.inputSequence.getStartCommandList();
    }

    public CommandList getStartCommandList(String string) {
        this.menuModel.resetFocusedItem();
        return this.inputSequence.getStartCommandList(string);
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "%1#itemSelected - item selected was called with model = %2, index = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (evoListRow instanceof AddressInputLIValueListElementListRow) {
            this.logChannel.log(10000000, "%1#itemSelected row is instanceOf AddressInputLIValueListElementListRow", (Object)this.CLASS_NAME);
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            LIValueListElement lIValueListElement = addressInputLIValueListElementListRow.getElement();
            this.inputManager.executeAddressInputEvent(this.inputSequence.getSelectListElementCommandList(lIValueListElement), 102);
            this.env.fireModelEvent(n, n4);
        }
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemFocused(int n, int n2, long l, int n3) {
    }

    public void requestItems(int n, int n2, int n3, int n4, int n5) {
        this.logChannel.log(10000000, "%1#requestItems - was called with requestID=%2, startIndex=%3, model=%4", (Object)this.CLASS_NAME, (Object)Integer.toString(n3), (Object)Integer.toString(n), (long)n4);
        this.inputSequence.requestNextResultListWindow(n, n3);
    }

    public void unrequestItems(int n, int n2, int n3, int n4) {
        this.inputSequence.unrequestItems(n, n2);
    }

    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(10000000, "%1#keyTyped - keyTyped was called with model=%2, key=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        long l = this.env.getContainer().getLispValueListCount();
        this.logChannel.log(10000000, "%1#keyTyped - valueListCount=%2 ", (Object)this.CLASS_NAME, l);
        if (l == 1L && this.menuModel != null) {
            if (this.tiledListModel == null) {
                this.logChannel.log(10000000, "%1#keyTyped - tiledListModel is null", (Object)this.CLASS_NAME);
                return;
            }
            if (this.tiledListModel.getRow(0) == null) {
                this.logChannel.log(10000000, "%1#keyTyped - tiledListModel.getRow(0) is null", (Object)this.CLASS_NAME);
                return;
            }
            EvoListRow evoListRow = this.tiledListModel.getRow(0);
            this.menuModel.setFocusedItem(this.tiledListModel.getID(), FocusAdvice.VIEWPORT_FIRST_POSITION, evoListRow.getUniqueID());
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            this.inputManager.executeAddressInputEvent(this.inputSequence.getSelectListElementCommandList(addressInputLIValueListElementListRow.getElement()), 102);
            this.env.fireModelEvent(this.tiledListModel.getID(), n3);
        }
    }

    public void textChanged(int n, String string, char c2, int n2) {
        this.logChannel.log(10000000, "%1#textChanged(%1, %2, %3)", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)string, (long)c2);
        this.setSpellerStatusWaiting(n);
        if ("".equals(string)) {
            this.inputSequence.deleteAllCharacters();
        } else if (c2 == '\b') {
            this.inputSequence.undoCharacter();
        } else {
            this.inputSequence.addCharacter(Character.toString(c2), n, false);
        }
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void focusedCharacter(int n, char c2, int n2) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void commandPressed(int n, int n2, int n3) {
    }
}

