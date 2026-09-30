/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listener;

import de.audi.app.navi.evo.addressinput.poi.PoiManager;
import de.audi.app.navi.evo.addressinput.poi.PoiScreensEvo;
import de.audi.app.navi.evo.addressinput.poi.listener.AbstractPoiScreenHmiListener;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiBrandScreenInputSequence;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiBrandScreenHmiListener
extends AbstractPoiScreenHmiListener
implements BaseListModelListener {
    private final PoiBrandScreenInputSequence inputSequence;

    public PoiBrandScreenHmiListener(NavigationEnv navigationEnv, PoiBrandScreenInputSequence poiBrandScreenInputSequence, PoiManager poiManager, IPreviewMap iPreviewMap, PoiSearchArea poiSearchArea) {
        super(navigationEnv, poiManager, iPreviewMap, poiSearchArea);
        this.inputSequence = poiBrandScreenInputSequence;
    }

    public CommandList getStartCommandList() {
        return this.inputSequence.getStartCommandList();
    }

    public void preparePreviewMap() {
        this.displayMultiplePois = true;
    }

    protected void registerAsListener() {
        this.env.getBaseListModel(PoiScreensEvo.getPoiBrandScreenBaseListModel()).setListener(this);
        this.env.getMenuModel(PoiScreensEvo.getPoiBrandScreenMenuModel()).setListener(this);
    }

    public PoiBrandScreenInputSequence getPoiBrandScreenInputSequence() {
        return this.inputSequence;
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "PoiBrandScreenHmiListener#itemselected(%1, %2, %3)", (long)n, (long)n2, (long)n4);
        if (n != 402570) {
            this.logChannel.log(10000000, "PoiBrandScreenHmiListener#itemSelected: Unexpected model ID: %1", (long)n);
            return;
        }
        LIValueListElement lIValueListElement = PoiScreensEvo.getLiValueListElementFromRow(evoListRow, n);
        this.poiManager.executePoiSelectionEvent(this.inputSequence.getListElementSelected(lIValueListElement), 601);
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "PoiBrandScreenHmiListener#itemSelected: Selected element.data = %1", (Object)lIValueListElement.getData());
        }
        this.env.fireModelEvent(n, n4);
    }

    public void itemFocused(int n, int n2, long l, int n3) {
        this.inputSequence.hidePreviewMap(this.previewMapInterface);
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }
}

