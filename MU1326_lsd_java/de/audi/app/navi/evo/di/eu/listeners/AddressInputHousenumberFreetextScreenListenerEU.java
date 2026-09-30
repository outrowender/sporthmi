/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.eu.listeners;

import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.app.navi.evo.di.eu.listeners.AbstractAddressInputListenerEU;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelListener;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.freetextspeller.AddressInputHousenumberFreetextSequence;

public class AddressInputHousenumberFreetextScreenListenerEU
extends AbstractAddressInputListenerEU
implements MenuModelListener,
TiledListModelListener,
SpellerListener,
ButtonListener {
    private static final int TILED_LIST_MODEL_ID = DIScreensEvo.getDiEuHousenumberFreetextScreenTiledListModel();
    private static final int MENU_MODEL_ID = DIScreensEvo.getDiEuHousenumberFreetextScreenMenuModel();
    private static final int SPELLER_MODEL_ID = DIScreensEvo.getDiEuHousenumberFreetextScreenSpellerModel();
    private static final int NAVIGATE_TO_HOUSENUMBER_BUTTON_MODEL_ID = DIScreensEvo.getDiEuHousenumberFreetextScreenNavigateToHousenumberButtonModel();
    private static final int IGNORE_HOUSENUMBER_BUTTON_MODEL_ID = DIScreensEvo.getDiEuHousenumberFreetextScreenIgnoreHousenumberButtonModel();
    private final AddressInputHousenumberFreetextSequence inputSequence;

    public AddressInputHousenumberFreetextScreenListenerEU(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager, AddressInputHousenumberFreetextSequence addressInputHousenumberFreetextSequence) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager);
        this.inputSequence = addressInputHousenumberFreetextSequence;
        this.initListeners();
    }

    protected void initListeners() {
        this.env.getMenuModel(MENU_MODEL_ID).setListener(this);
        this.env.getTiledListModel(TILED_LIST_MODEL_ID).setListener(this);
        this.env.getSpellerModel(SPELLER_MODEL_ID).setSpellerListener(this);
        this.env.getButtonModel(NAVIGATE_TO_HOUSENUMBER_BUTTON_MODEL_ID).setButtonListener(this);
        this.env.getButtonModel(IGNORE_HOUSENUMBER_BUTTON_MODEL_ID).setButtonListener(this);
    }

    public CommandList getStartCommandList() {
        return this.inputSequence.getStartCommandList();
    }

    public CommandList getStartCommandList(String string) {
        return this.inputSequence.getStartCommandList(string);
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
        this.inputSequence.setHousenumber(addressInputLIValueListElementListRow.getElement().getData(), true);
        this.env.fireModelEvent(n, n4);
    }

    public void itemFocused(int n, int n2, long l, int n3) {
        this.logChannel.log(10000000, "%1#itemFocused (menu model) menuItemID=%2, model=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (n == SPELLER_MODEL_ID) {
            this.inputSequence.hidePreviewMap(this.previewMap);
        }
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "%1#itemFocused (list model) row=%2, model=%3, index=%4", (Object)this.CLASS_NAME, (Object)evoListRow, (Object)Integer.toString(n), (long)n2);
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, 1, null, null));
        commandList.execute(this.CLASS_NAME + "#itemFocused updatePreviewMap");
    }

    public void keyTyped(int n, int n2, int n3) {
        if (n == IGNORE_HOUSENUMBER_BUTTON_MODEL_ID) {
            this.inputSequence.ignoreHousenumber();
        } else if (n == NAVIGATE_TO_HOUSENUMBER_BUTTON_MODEL_ID) {
            this.inputSequence.selectAlternativeHousenumber();
        } else {
            this.logChannel.log(100000, "%1#keyTyped() - unknown model:%2", (Object)this.CLASS_NAME, (long)n);
        }
        this.env.fireModelEvent(n, n3);
    }

    public void textChanged(int n, String string, char c2, int n2) {
        this.inputSequence.updatePreviewHousenumber(string);
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void focusedCharacter(int n, char c2, int n2) {
    }

    public void commandPressed(int n, int n2, int n3) {
    }

    public void requestItems(int n, int n2, int n3, int n4, int n5) {
    }

    public void unrequestItems(int n, int n2, int n3, int n4) {
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }
}

