/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.listeners;

import de.audi.app.navi.evo.addressinput.AddressInputHistoryElementListRow;
import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.app.navi.evo.di.nar.listeners.AbstractAddressInputListenerNAR;
import de.audi.app.navi.evo.di.nar.listeners.AddressInputCityZipScreenListenerNAR$1;
import de.audi.app.navi.evo.di.nar.listeners.AddressInputCityZipScreenListenerNAR$2;
import de.audi.app.navi.evo.di.nar.listeners.AddressInputCityZipScreenListenerNAR$3;
import de.audi.atip.hmi.model.MatchSpellerListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelListener;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory$HistoryEntry;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToPOIOnlineSearchSequence;
import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToRemoteHmiFromCurrentLDSequence;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSequenceNAR;
import de.audi.tghu.navi.app.rows.LiValueListRow;
import org.dsi.ifc.navigation.LICityHistoryEntry;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputCityZipScreenListenerNAR
extends AbstractAddressInputListenerNAR
implements TiledListModelListener,
MatchSpellerListener,
MenuModelListener {
    public static final int ZIP_AVAILABLE;
    public static final int ZIP_NOT_AVAILABLE;
    private static final int TILED_LIST_MODEL_ID;
    private static final int MATCHSPELLER_MODEL_ID;
    private static final int MENU_MODEL_ID;
    private final AddressInputCityZipSequenceNAR inputSequence;

    public AddressInputCityZipScreenListenerNAR(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager, AddressInputCityZipSequenceNAR addressInputCityZipSequenceNAR) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager);
        this.inputSequence = addressInputCityZipSequenceNAR;
        this.initListeners();
    }

    @Override
    protected void initListeners() {
        this.env.getTiledListModel(TILED_LIST_MODEL_ID).setListener(this);
        this.env.getMatchSpellerModel(MATCHSPELLER_MODEL_ID).setSpellerListener(this);
        this.env.getMenuModel(MENU_MODEL_ID).setListener(this);
    }

    @Override
    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new AddressInputCityZipScreenListenerNAR$1(this, "AddressInputCityZipScreenListenerNAR#getStartCommandList set zip available model"));
        commandList.add(this.inputSequence.getStartCommandList());
        return commandList;
    }

    @Override
    public CommandList getStartCommandList(String string) {
        return this.inputSequence.getStartCommandList(string);
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#textChanged(%1, %2, %3)").toString(), (Object)new StringBuffer().append(n).append("").toString(), (Object)string, (long)c2);
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
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "%1#itemSelected row=%2, model=%3, index=%4", (Object)this.CLASS_NAME, (Object)evoListRow, (Object)Integer.toString(n), (long)n2);
        int n5 = this.inputManager.getActiveSpellerContextId();
        CommandList commandList = null;
        if (evoListRow instanceof AddressInputLIValueListElementListRow) {
            this.logChannel.log(-2137614336, "%1#itemSelected row is instanceOf AddressInputLIValueListElementListRow", (Object)this.CLASS_NAME);
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            commandList = this.inputManager.handleAddressInputEvent(this.inputSequence.getSelectListElementCommandList(addressInputLIValueListElementListRow.getElement()), 30202);
        } else if (evoListRow instanceof AddressInputHistoryElementListRow) {
            this.logChannel.log(-2137614336, "%1#itemSelected row is instanceOf AddressInputHistoryElementListRow", (Object)this.CLASS_NAME);
            AddressInputHistoryElementListRow addressInputHistoryElementListRow = (AddressInputHistoryElementListRow)evoListRow;
            CityHistory$HistoryEntry cityHistory$HistoryEntry = addressInputHistoryElementListRow.getHistoryEntry();
            commandList = this.inputManager.handleAddressInputEvent(this.inputSequence.getSelectHistoryElementCommandList((LICityHistoryEntry)cityHistory$HistoryEntry.getEntry()), 30203);
        }
        if (commandList != null) {
            if (n5 == 60) {
                commandList.add(new ReturnNavLocationToPOIOnlineSearchSequence(this.commandListFactory).getStartCommandList());
            } else if (n5 == 103) {
                commandList.add(new ReturnNavLocationToRemoteHmiFromCurrentLDSequence(this.commandListFactory).getStartCommandList());
            }
            commandList.add(new AddressInputCityZipScreenListenerNAR$2(this, "Delay fire model event", n, n4));
            commandList.add(new AddressInputCityZipScreenListenerNAR$3(this, "AddressInputCityZipScreenListenerNAR#getStartCommandList reset zip available model"));
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#itemSelected").toString());
        } else {
            this.env.fireModelEvent(n, n4);
        }
    }

    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement) {
        return this.inputSequence.getSelectListElementCommandList(lIValueListElement);
    }

    @Override
    public void requestItems(int n, int n2, int n3, int n4, int n5) {
        this.logChannel.log(-2137614336, "%1#requestItems - was called with requestID = %2, startIndex = %3, model = %4", (Object)this.CLASS_NAME, (Object)Integer.toString(n3), (Object)Integer.toString(n), (long)n4);
        this.inputSequence.requestNextResultListWindow(n, n3);
    }

    @Override
    public void unrequestItems(int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "%1#unrequestItems - was called with startIndex = %2, model = %3", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (long)n3);
        this.inputSequence.unrequestItems(n, n2);
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        this.logChannel.log(-2137614336, "%1#itemFocused (menu model) - was called with menuItemId=%2, model=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (n == MATCHSPELLER_MODEL_ID) {
            this.inputSequence.hidePreviewMap(this.previewMap);
        }
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        EvoListRow evoListRow2;
        this.logChannel.log(-2137614336, "%1#itemFocused (list model) - was called with model = %2, index = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (evoListRow instanceof AddressInputHistoryElementListRow && this.previewMap != null) {
            evoListRow2 = (AddressInputHistoryElementListRow)evoListRow;
            CityHistory$HistoryEntry cityHistory$HistoryEntry = ((AddressInputHistoryElementListRow)evoListRow2).getHistoryEntry();
            this.inputSequence.showHistoryLocationInPreviewMap(this.previewMap, (LICityHistoryEntry)cityHistory$HistoryEntry.getEntry());
        }
        if (evoListRow instanceof AddressInputLIValueListElementListRow && this.previewMap != null) {
            evoListRow2 = (AddressInputLIValueListElementListRow)evoListRow;
            this.inputSequence.showLocationInPreviewMap(this.previewMap, ((LiValueListRow)evoListRow2).getElement());
        }
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
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    static {
        TILED_LIST_MODEL_ID = DIScreensEvo.getDiNarCityZipScreenTiledListModel();
        MATCHSPELLER_MODEL_ID = DIScreensEvo.getDiNarCityZipScreenMatchSpellerModel();
        MENU_MODEL_ID = DIScreensEvo.getDiNarCityZipScreenMenuModel();
    }
}

