/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listener;

import de.audi.app.navi.evo.addressinput.poi.PoiManager;
import de.audi.app.navi.evo.addressinput.poi.PoiScreensEvo;
import de.audi.app.navi.evo.addressinput.poi.listener.AbstractPoiScreenHmiListener;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiClassScreenInputSequence;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiClassScreenHmiListener
extends AbstractPoiScreenHmiListener
implements ButtonListener,
BaseListModelListener {
    private final PoiClassScreenInputSequence inputSequence;

    public PoiClassScreenHmiListener(NavigationEnv navigationEnv, PoiClassScreenInputSequence poiClassScreenInputSequence, PoiManager poiManager, IPreviewMap iPreviewMap, PoiSearchArea poiSearchArea) {
        super(navigationEnv, poiManager, iPreviewMap, poiSearchArea);
        this.inputSequence = poiClassScreenInputSequence;
    }

    public CommandList getStartCommandList() {
        return this.inputSequence.getStartCommandList();
    }

    public void preparePreviewMap() {
        this.displayMultiplePois = true;
        this.previewSearchLocation(this.poiSearchArea.getSearchContext(), this.poiSearchArea.getLocation());
    }

    protected void registerAsListener() {
        this.env.getBaseListModel(PoiScreensEvo.getPoiClassScreenBaseListModel()).setListener(this);
        this.env.getButtonModel(PoiScreensEvo.getPoiClassScreenSearchByNameButtonModel()).setButtonListener(this);
        this.env.getMenuModel(PoiScreensEvo.getPoiClassScreenMenuModel()).setListener(this);
    }

    public PoiClassScreenInputSequence getPoiClassScreenInputSequence() {
        return this.inputSequence;
    }

    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 401586: {
                this.poiManager.executePoiSelectionEvent(this.inputSequence.getStartSearchByName(), 402);
                break;
            }
            default: {
                this.logChannel.log(10000000, "PoiClassScreenHmiListener#keyTyped: Unexpected model ID: %1", (long)n);
            }
        }
        this.env.fireModelEvent(n, n3);
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "PoiClassScreenHmiListener#itemselected(%1, %2, %3)", (long)n, (long)n2, (long)n4);
        if (n != PoiScreensEvo.getPoiClassScreenBaseListModel()) {
            this.logChannel.log(10000000, "PoiClassScreenHmiListener#itemSelected: Unexpected model ID: %1", (long)n);
            return;
        }
        LIValueListElement lIValueListElement = PoiScreensEvo.getLiValueListElementFromRow(evoListRow, n);
        this.poiManager.executePoiSelectionEvent(this.inputSequence.getStartCategories(lIValueListElement), 401);
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "PoiClassScreenHmiListener#itemSelected: Selected element.data = %1", (Object)lIValueListElement.getData());
        }
        this.env.fireModelEvent(n, n4);
    }

    public void itemFocused(int n, int n2, long l, int n3) {
        this.logChannel.log(100000000, "PoiClassScreenHmiListener#itemFocused() - menuItemId: %1, model: %2, uniquteListRowID: %3", (long)n, (long)n2, l);
        this.preparePreviewMap();
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }
}

