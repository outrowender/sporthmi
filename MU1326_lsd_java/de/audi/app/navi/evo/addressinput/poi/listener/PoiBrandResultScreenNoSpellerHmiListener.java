/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listener;

import de.audi.app.navi.evo.addressinput.poi.PoiManager;
import de.audi.app.navi.evo.addressinput.poi.PoiScreensEvo;
import de.audi.app.navi.evo.addressinput.poi.listener.AbstractPoiResultScreenEvoListener;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiBrandResultScreenNoSpellerInputSequence;
import de.audi.tghu.navi.app.navlocationextractor.AsyncNavLocationExtractor;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiBrandResultScreenNoSpellerHmiListener
extends AbstractPoiResultScreenEvoListener
implements TiledListModelListener,
ButtonListener {
    private final PoiBrandResultScreenNoSpellerInputSequence inputSequence;

    public PoiBrandResultScreenNoSpellerHmiListener(NavigationEnv navigationEnv, PoiBrandResultScreenNoSpellerInputSequence poiBrandResultScreenNoSpellerInputSequence, PoiManager poiManager, IPreviewMap iPreviewMap, PoiSearchArea poiSearchArea, AsyncNavLocationExtractor asyncNavLocationExtractor) {
        super(navigationEnv, poiManager, iPreviewMap, poiSearchArea, asyncNavLocationExtractor);
        this.inputSequence = poiBrandResultScreenNoSpellerInputSequence;
    }

    @Override
    public CommandList getStartCommandList() {
        return this.inputSequence.getStartCommandList();
    }

    @Override
    public void preparePreviewMap() {
        this.displayMultiplePois = true;
    }

    @Override
    protected void registerAsListener() {
        this.env.getTiledListModel(PoiScreensEvo.getPoiBrandResultScreenNoSpellerListModel()).setListener(this);
        this.env.getButtonModel(PoiScreensEvo.getPoiBrandResultScreenNoSpellerSearchByNameButtonModel()).setButtonListener(this);
        this.env.getMenuModel(PoiScreensEvo.getPoiBrandResultScreenNoSpellerMenuModel()).setListener(this);
    }

    public PoiBrandResultScreenNoSpellerInputSequence getPoiBrandResultScreenNoSpellerInputSequence() {
        return this.inputSequence;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "PoiBrandResultScreenNoSpellerHmiListener#keyTyped(%1, %2, %3)", (long)n, (long)n2, (long)n3);
        switch (n) {
            case 401615: {
                this.poiManager.executePoiSelectionEvent(this.inputSequence.getStartSearchByName(), 702);
                break;
            }
        }
        this.env.fireModelEvent(n, n3);
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "PoiBrandResultScreenNoSpellerHmiListener#itemselected(%1, %2, %3)", (long)n, (long)n2, (long)n4);
        if (n != PoiScreensEvo.getPoiBrandResultScreenNoSpellerListModel()) {
            this.logChannel.log(-2137614336, "PoiBrandResultScreenNoSpellerHmiListener#itemSelected: Unexpected model ID: %1", (long)n);
            return;
        }
        LIValueListElement lIValueListElement = PoiScreensEvo.getLiValueListElementFromRow(evoListRow, n);
        this.poiManager.executePoiSelectionEvent(this.inputSequence.getListElementSelected(lIValueListElement), 701);
        this.env.fireModelEvent(n, n4);
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        this.logChannel.log(-2137614336, "PoiBrandResultScreenNoSpellerHmiListener#itemFocused() - menuItemId: %1, model: %2, uniquteListRowID: %3", (long)n, (long)n2, l);
        this.previewMapComplete = false;
        if (l == -1L) {
            this.displayPreviewMap(n2, this.inputSequence, PoiScreensEvo.getPoiBrandResultScreenNoSpellerListModel());
        }
        this.currentlyFocusedListIndex = l;
    }

    @Override
    public void updateResultsAvailable() {
        if (this.currentlyFocusedListIndex == -1L) {
            this.displayPreviewMap(PoiScreensEvo.getPoiBrandResultScreenNoSpellerMenuModel(), this.inputSequence, PoiScreensEvo.getPoiBrandResultScreenNoSpellerListModel());
        }
    }

    @Override
    protected void itemFocusedCallBack(NavLocation navLocation) {
        this.inputSequence.focusPreviewMap(this.previewMapInterface, navLocation);
        this.inputSequence.onElementFocused(navLocation);
    }

    @Override
    public void requestItems(int n, int n2, int n3, int n4, int n5) {
        this.logChannel.log(-2137614336, "PoiBrandResultScreenNoSpellerHmiListener#requestItems - was called with requestID = %1, startIndex = %2, model = %3", (long)n3, (long)n, (long)n4);
        this.inputSequence.requestItems(n, n3);
        this.poiManager.restartRRDForCurrentContext();
    }

    @Override
    public void unrequestItems(int n, int n2, int n3, int n4) {
        this.inputSequence.unrequestItems(n, n2);
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

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }
}

