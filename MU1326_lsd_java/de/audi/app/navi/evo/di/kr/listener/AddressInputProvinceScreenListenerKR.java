/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr.listener;

import de.audi.app.navi.evo.addressinput.AddressInputHistoryElementListRow;
import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.app.navi.evo.di.kr.listener.AbstractAddressInputListenerKR;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputProvinceSequenceAsia;
import org.dsi.ifc.navigation.LIStateHistoryEntry;

public class AddressInputProvinceScreenListenerKR
extends AbstractAddressInputListenerKR
implements ButtonListener {
    private final AddressInputProvinceSequenceAsia provinceSequence;
    private final int nationWideButtonModelId = DIScreensEvo.getDiKrProvinceScreenNationWideButtonModel();
    private ButtonModelApp buttonModel;
    private final ChoiceModelApp provinceNationwideSelectedChoice;

    public AddressInputProvinceScreenListenerKR(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager, AddressInputProvinceSequenceAsia addressInputProvinceSequenceAsia, int n, int n2, int n3) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager, addressInputProvinceSequenceAsia, n, n2, n3);
        this.provinceSequence = addressInputProvinceSequenceAsia;
        this.provinceNationwideSelectedChoice = navigationEnv.getChoiceModel(DIScreensEvo.getDiKrProvinceNationwideButtonSelectedChoiceModel());
        this.initListeners();
    }

    protected void initListeners() {
        this.tiledListModel = this.env.getTiledListModel(this.tiledListModelId);
        this.tiledListModel.setListener(this);
        this.matchspellerModel = this.env.getMatchSpellerModel(this.matchSpellerModelId);
        this.matchspellerModel.setSpellerListenerAsia(this);
        this.menuModel = this.env.getMenuModel(this.menuModelId);
        this.menuModel.setListener(this);
        this.buttonModel = this.env.getButtonModel(this.nationWideButtonModelId);
        this.buttonModel.setButtonListener(this);
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "%1#itemSelected row=%2, model=%3, index=%4", (Object)this.CLASS_NAME, (Object)evoListRow, (Object)Integer.toString(n), (long)n2);
        this.provinceNationwideSelectedChoice.setValue(0);
        if (evoListRow instanceof AddressInputLIValueListElementListRow) {
            this.logChannel.log(10000000, "%1#itemSelected row is instanceOf AddressInputLIValueListElementListRow", (Object)this.CLASS_NAME);
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            this.inputManager.executeAddressInputEvent(this.inputSequence.getSelectListElementCommandList(addressInputLIValueListElementListRow.getElement()), 40102);
        } else if (evoListRow instanceof AddressInputHistoryElementListRow) {
            this.logChannel.log(10000000, "%1#itemSelected row is instanceOf AddressInputHistoryElementListRow", (Object)this.CLASS_NAME);
            AddressInputHistoryElementListRow addressInputHistoryElementListRow = (AddressInputHistoryElementListRow)evoListRow;
            CityHistory.HistoryEntry historyEntry = addressInputHistoryElementListRow.getHistoryEntry();
            this.inputManager.executeAddressInputEvent(this.provinceSequence.getSelectHistoryElementCommandList((LIStateHistoryEntry)historyEntry.getEntry()), 40103);
        }
        this.env.fireModelEvent(n, n4);
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "%1#itemFocused - item focused was called with model = %2, index = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (evoListRow instanceof AddressInputHistoryElementListRow) {
            this.logChannel.log(10000000, "%1#itemFocused row is instanceOf AddressInputHistoryElementListRow", (Object)this.CLASS_NAME);
            if (this.previewMap != null && !this.isSpellerOpen) {
                AddressInputHistoryElementListRow addressInputHistoryElementListRow = (AddressInputHistoryElementListRow)evoListRow;
                CityHistory.HistoryEntry historyEntry = addressInputHistoryElementListRow.getHistoryEntry();
                this.provinceSequence.showHistoryLocationInPreviewMap(this.previewMap, (LIStateHistoryEntry)historyEntry.getEntry());
            }
        } else {
            super.itemFocused(evoListRow, n, n2, n3, n4);
        }
    }

    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(10000000, "%1#keyTyped - keyTyped was called with modelID = %2, keyID = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (n == this.nationWideButtonModelId) {
            this.provinceNationwideSelectedChoice.setValue(1);
            this.inputManager.getMainScreenListener().resetPreviousLocation();
            this.inputManager.executeAddressInputEvent(this.provinceSequence.getNationWideElementSelectedCommandList(), 40104);
            this.env.fireModelEvent(n, n3);
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }
}

