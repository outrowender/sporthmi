/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.eu.listeners;

import de.audi.app.navi.evo.addressinput.AddressInputHistoryElementListRow;
import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.app.navi.evo.di.eu.listeners.AbstractAddressInputListenerEU;
import de.audi.atip.hmi.model.MatchSpellerListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelListener;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToPOIOnlineSearchSequence;
import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToRemoteHmiFromCurrentLDSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSequence;
import de.audi.tghu.navi.app.rows.LiValueListRow;
import org.dsi.ifc.navigation.LICityHistoryEntry;

public class AddressInputCityZipScreenListenerEU
extends AbstractAddressInputListenerEU
implements TiledListModelListener,
MatchSpellerListener,
MenuModelListener {
    private static final int TILED_LIST_MODEL_ID = DIScreensEvo.getDiEuCityZipScreenTiledListModel();
    private static final int MATCHSPELLER_MODEL_ID = DIScreensEvo.getDiEuCityZipScreenMatchSpellerModel();
    private static final int MENU_MODEL_ID = DIScreensEvo.getDiEuCityZipScreenMenuModel();
    private final AddressInputCityZipSequence inputSequence;

    public AddressInputCityZipScreenListenerEU(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager, AddressInputCityZipSequence addressInputCityZipSequence) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager);
        this.inputSequence = addressInputCityZipSequence;
        this.initListeners();
    }

    protected void initListeners() {
        this.env.getTiledListModel(TILED_LIST_MODEL_ID).setListener(this);
        this.env.getMatchSpellerModel(MATCHSPELLER_MODEL_ID).setSpellerListener(this);
        this.env.getMenuModel(MENU_MODEL_ID).setListener(this);
    }

    public CommandList getStartCommandList() {
        return this.inputSequence.getStartCommandList();
    }

    public CommandList getStartCommandList(String string) {
        return this.inputSequence.getStartCommandList(string);
    }

    public void itemSelected(EvoListRow evoListRow, final int n, int n2, int n3, final int n4) {
        this.logChannel.log(10000000, "%1#itemSelected row=%2, model=%3, index=%4", (Object)this.CLASS_NAME, (Object)evoListRow, (Object)Integer.toString(n), (long)n2);
        int n5 = this.inputManager.getActiveSpellerContextId();
        CommandList commandList = null;
        if (evoListRow instanceof AddressInputLIValueListElementListRow) {
            this.logChannel.log(10000000, "%1#itemSelected row is instanceOf AddressInputLIValueListElementListRow", (Object)this.CLASS_NAME);
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            commandList = this.inputManager.handleAddressInputEvent(this.inputSequence.getSelectListElementCommandList(addressInputLIValueListElementListRow.getElement()), 202);
        } else if (evoListRow instanceof AddressInputHistoryElementListRow) {
            this.logChannel.log(10000000, "%1#itemSelected row is instanceOf AddressInputHistoryElementListRow", (Object)this.CLASS_NAME);
            AddressInputHistoryElementListRow addressInputHistoryElementListRow = (AddressInputHistoryElementListRow)evoListRow;
            CityHistory.HistoryEntry historyEntry = addressInputHistoryElementListRow.getHistoryEntry();
            commandList = this.inputManager.handleAddressInputEvent(this.inputSequence.getSelectHistoryElementCommandList((LICityHistoryEntry)historyEntry.getEntry()), 203);
        }
        if (commandList != null) {
            if (n5 == 49) {
                commandList.add(new ReturnNavLocationToPOIOnlineSearchSequence(this.commandListFactory).getStartCommandList());
            } else if (n5 == 77) {
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
    }

    public void itemFocused(int n, int n2, long l, int n3) {
        this.logChannel.log(10000000, "%1#itemFocused (menu model) - was called with menuItemId=%2, model=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (n == MATCHSPELLER_MODEL_ID) {
            this.inputSequence.hidePreviewMap(this.previewMap);
        }
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        EvoListRow evoListRow2;
        this.logChannel.log(10000000, "%1#itemFocused (list model) - was called with model = %2, index = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (evoListRow instanceof AddressInputHistoryElementListRow && this.previewMap != null) {
            evoListRow2 = (AddressInputHistoryElementListRow)evoListRow;
            CityHistory.HistoryEntry historyEntry = ((AddressInputHistoryElementListRow)evoListRow2).getHistoryEntry();
            this.inputSequence.showHistoryLocationInPreviewMap(this.previewMap, (LICityHistoryEntry)historyEntry.getEntry());
        }
        if (evoListRow instanceof AddressInputLIValueListElementListRow && this.previewMap != null) {
            evoListRow2 = (AddressInputLIValueListElementListRow)evoListRow;
            this.inputSequence.showLocationInPreviewMap(this.previewMap, ((LiValueListRow)evoListRow2).getElement());
        }
    }

    public void requestItems(int n, int n2, int n3, int n4, int n5) {
        this.logChannel.log(10000000, "%1#requestItems - was called with requestID = %2, startIndex = %3, model = %4", (Object)this.CLASS_NAME, (Object)Integer.toString(n3), (Object)Integer.toString(n), (long)n4);
        this.inputSequence.requestNextResultListWindow(n, n3);
    }

    public void unrequestItems(int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "%1#unrequestItems - was called with startIndex = %2, model = %3", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (long)n3);
        this.inputSequence.unrequestItems(n, n2);
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

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void focusedCharacter(int n, char c2, int n2) {
    }

    public void commandPressed(int n, int n2, int n3) {
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }
}

