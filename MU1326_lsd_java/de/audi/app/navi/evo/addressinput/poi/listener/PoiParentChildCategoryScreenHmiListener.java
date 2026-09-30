/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listener;

import de.audi.app.navi.evo.addressinput.poi.PoiManager;
import de.audi.app.navi.evo.addressinput.poi.PoiScreensEvo;
import de.audi.app.navi.evo.addressinput.poi.listbuilders.PoiIconedParentCategoriesParentListRow;
import de.audi.app.navi.evo.addressinput.poi.listener.AbstractPoiScreenHmiListener;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiParentChildCategoryScreenInputSequence;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiParentChildCategoryScreenHmiListener
extends AbstractPoiScreenHmiListener
implements BaseListModelListener {
    private final PoiParentChildCategoryScreenInputSequence inputSequence;
    private int lastFocusedRow = -1;

    public PoiParentChildCategoryScreenHmiListener(NavigationEnv navigationEnv, PoiParentChildCategoryScreenInputSequence poiParentChildCategoryScreenInputSequence, PoiManager poiManager, IPreviewMap iPreviewMap, PoiSearchArea poiSearchArea) {
        super(navigationEnv, poiManager, iPreviewMap, poiSearchArea);
        this.inputSequence = poiParentChildCategoryScreenInputSequence;
    }

    public CommandList getStartCommandList() {
        return this.inputSequence.getStartCommandList();
    }

    public void preparePreviewMap() {
    }

    protected void registerAsListener() {
        this.env.getBaseListModel(PoiScreensEvo.getPoiParentChildCategoryScreenBaseListModel()).setListener(this);
        this.env.getMenuModel(PoiScreensEvo.getPoiParentChildCategoryScreenMenuModel()).setListener(this);
    }

    public PoiParentChildCategoryScreenInputSequence getPoiParentChildCategoryScreenInputSequence() {
        return this.inputSequence;
    }

    public void itemFocused(int n, int n2, long l, int n3) {
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(1000000, "PoiParentChildCategoryScreenHmiListener#itemFocused index= %1", (long)n2);
        if (this.lastFocusedRow == n2) {
            this.inputSequence.focusPreviewMap(this.previewMapInterface, this.env.getContainer().getLiCurrentLD());
        }
        this.lastFocusedRow = n2;
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "PoiParentChildCategoryScreenHmiListener#itemselected(%1, %2, %3)", (long)n, (long)n2, (long)n4);
        if (n != PoiScreensEvo.getPoiParentChildCategoryScreenBaseListModel()) {
            this.logChannel.log(10000000, "PoiParentChildCategoryScreenHmiListener#itemSelected: Unexpected model ID: %1", (long)n);
            return;
        }
        LIValueListElement lIValueListElement = PoiScreensEvo.getLiValueListElementFromRow(evoListRow, n);
        int n5 = 1002;
        if (evoListRow instanceof PoiIconedParentCategoriesParentListRow) {
            n5 = 1003;
        }
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "PoiParentChildCategoryScreenHmiListener#itemSelected: Selected element.data = %1, event=%2", (Object)lIValueListElement.getData(), (long)n5);
        }
        this.poiManager.executePoiSelectionEvent(this.inputSequence.getListElementSelected(lIValueListElement), n5);
        this.env.fireModelEvent(n, n4);
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }
}

