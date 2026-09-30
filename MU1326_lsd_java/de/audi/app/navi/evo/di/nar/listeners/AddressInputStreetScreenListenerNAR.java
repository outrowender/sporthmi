/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.listeners;

import de.audi.app.navi.evo.addressinput.AddressInputHistoryElementListRow;
import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.app.navi.evo.addressinput.poi.PoiScreensEvo;
import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.app.navi.evo.di.nar.listeners.AbstractAddressInputListenerNAR;
import de.audi.atip.hmi.model.MatchSpellerListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.model.list.TiledListModelListener;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputStreetSequenceNAR;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIStreetHistoryEntry;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputStreetScreenListenerNAR
extends AbstractAddressInputListenerNAR
implements TiledListModelListener,
MatchSpellerListener,
MenuModelListener {
    private static final int TILED_LIST_MODEL_ID = DIScreensEvo.getDiNarStreetScreenTiledListModel();
    private static final int MATCHSPELLER_MODEL_ID = DIScreensEvo.getDiNarStreetScreenMatchSpellerModel();
    private static final int MENU_MODEL_ID = DIScreensEvo.getDiNarStreetScreenMenuModel();
    private TiledListModelApp tiledListModel;
    private MenuModelApp menuModel;
    private MatchspellerModelApp matchspellerModel;
    private final AddressInputStreetSequenceNAR inputSequence;

    public AddressInputStreetScreenListenerNAR(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager, AddressInputStreetSequenceNAR addressInputStreetSequenceNAR) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager);
        this.inputSequence = addressInputStreetSequenceNAR;
        this.initListeners();
    }

    protected void initListeners() {
        this.tiledListModel = this.env.getTiledListModel(TILED_LIST_MODEL_ID);
        this.tiledListModel.setListener(this);
        this.matchspellerModel = this.env.getMatchSpellerModel(MATCHSPELLER_MODEL_ID);
        this.matchspellerModel.setSpellerListener(this);
        this.menuModel = this.env.getMenuModel(MENU_MODEL_ID);
        this.menuModel.setListener(this);
    }

    public CommandList getStartCommandList() {
        return this.inputSequence.getStartCommandList();
    }

    public CommandList getStartCommandList(String string) {
        return this.inputSequence.getStartCommandList(string);
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "%1#itemSelected - item selected was called with model = %2, index = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (evoListRow instanceof AddressInputLIValueListElementListRow) {
            this.logChannel.log(10000000, "%1#itemSelected row is instanceOf AILIVLELR", (Object)this.CLASS_NAME);
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            this.inputManager.executeAddressInputEvent(this.inputSequence.getSelectListElementCommandList(addressInputLIValueListElementListRow.getElement()), 30302);
        } else if (evoListRow instanceof AddressInputHistoryElementListRow) {
            this.logChannel.log(10000000, "%1#itemSelected row is instanceOf AddressInputHistoryElementListRow", (Object)this.CLASS_NAME);
            AddressInputHistoryElementListRow addressInputHistoryElementListRow = (AddressInputHistoryElementListRow)evoListRow;
            CityHistory.HistoryEntry historyEntry = addressInputHistoryElementListRow.getHistoryEntry();
            this.inputManager.executeAddressInputEvent(this.inputSequence.getSelectHistoryElementCommandList((LIStreetHistoryEntry)historyEntry.getEntry()), 30305);
        }
        this.env.fireModelEvent(n, n4);
    }

    public void itemFocused(int n, int n2, long l, int n3) {
        this.logChannel.log(10000000, "%1#itemFocused (menu model) menuItemID=%2, model=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (n == MATCHSPELLER_MODEL_ID) {
            this.inputSequence.hidePreviewMap(this.previewMap);
        }
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "%1#itemFocused (list model) model=%3, index=%4, row=%2", (Object)this.CLASS_NAME, (Object)evoListRow, (Object)Integer.toString(n), (long)n2);
        LIValueListElement lIValueListElement = PoiScreensEvo.getLiValueListElementFromRow(evoListRow, n);
        if (evoListRow instanceof AddressInputHistoryElementListRow && this.previewMap != null) {
            AddressInputHistoryElementListRow addressInputHistoryElementListRow = (AddressInputHistoryElementListRow)evoListRow;
            CityHistory.HistoryEntry historyEntry = addressInputHistoryElementListRow.getHistoryEntry();
            this.inputSequence.showHistoryLocationInPreviewMap(this.previewMap, (LIStreetHistoryEntry)historyEntry.getEntry());
        }
        if (evoListRow instanceof AddressInputLIValueListElementListRow && this.previewMap != null) {
            this.inputSequence.checkIfElementIsAmbiguous(lIValueListElement, new StreetInputGetNavLocationCallbackCommand(evoListRow, this));
        }
    }

    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(10000000, "%1#keyTyped - keyTyped was called with model = %2, index = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        long l = this.env.getContainer().getLispValueListCount();
        this.logChannel.log(10000000, "%1#keyTyped - valueListCount = %2 ", (Object)this.CLASS_NAME, l);
        if (l == 1L && null != this.menuModel) {
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
            this.inputManager.executeAddressInputEvent(this.inputSequence.getSelectListElementCommandList(addressInputLIValueListElementListRow.getElement()), 30302);
            this.env.fireModelEvent(this.tiledListModel.getID(), n3);
        }
    }

    public void textChanged(int n, String string, char c2, int n2) {
        this.logChannel.log(10000000, "%1#textChanged(%2, %3, %4)", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)string, (long)c2);
        this.setSpellerStatusWaiting(n);
        if ("".equals(string)) {
            this.inputSequence.deleteAllCharacters();
        } else if (c2 == '\b') {
            this.inputSequence.undoCharacter();
        } else {
            this.inputSequence.addCharacter(Character.toString(c2), n, false);
        }
    }

    public void requestItems(int n, int n2, int n3, int n4, int n5) {
        this.logChannel.log(10000000, "%1#requestItems - was called with requestID = %2, startIndex = %3, model = %4", (Object)this.CLASS_NAME, (Object)Integer.toString(n3), (Object)Integer.toString(n), (long)n4);
        this.inputSequence.requestNextResultListWindow(n, n3);
    }

    public void unrequestItems(int n, int n2, int n3, int n4) {
        this.inputSequence.unrequestItems(n, n2);
    }

    private void locationCallback(NavLocation navLocation, EvoListRow evoListRow) {
        if (this.isLocationValid(navLocation)) {
            this.removeFocusedItemIsInvalidProperty(evoListRow);
            this.previewMap.setPreviewLocation(navLocation, 1, null, null);
        } else {
            this.previewMap.hidePreviewMap();
        }
    }

    private boolean isLocationValid(NavLocation navLocation) {
        if (navLocation == null) {
            return false;
        }
        return navLocation.latitude != 0 && navLocation.longitude != 0;
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void focusedCharacter(int n, char c2, int n2) {
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void commandPressed(int n, int n2, int n3) {
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    private class StreetInputGetNavLocationCallbackCommand
    extends NavCommand {
        private final EvoListRow row;
        private final AddressInputStreetScreenListenerNAR listener;

        private StreetInputGetNavLocationCallbackCommand(EvoListRow evoListRow, AddressInputStreetScreenListenerNAR addressInputStreetScreenListenerNAR2) {
            this.row = evoListRow;
            this.listener = addressInputStreetScreenListenerNAR2;
        }

        public void execute() {
            NavLocation navLocation = (NavLocation)this.getCommandList().get("LocationToTest");
            this.listener.locationCallback(navLocation, this.row);
            this.getCommandList().commandFinished();
        }
    }
}

