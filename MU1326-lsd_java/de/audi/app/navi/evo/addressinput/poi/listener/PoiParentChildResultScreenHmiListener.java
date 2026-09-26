/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listener;

import de.audi.app.navi.evo.addressinput.poi.PoiManager;
import de.audi.app.navi.evo.addressinput.poi.PoiScreensEvo;
import de.audi.app.navi.evo.addressinput.poi.listener.AbstractPoiResultScreenEvoListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiParentChildResultScreenInputSequence;
import de.audi.tghu.navi.app.navlocationextractor.AsyncNavLocationExtractor;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiParentChildResultScreenHmiListener
extends AbstractPoiResultScreenEvoListener
implements TiledListModelListener {
    private final PoiParentChildResultScreenInputSequence inputSequence;

    public PoiParentChildResultScreenHmiListener(NavigationEnv navigationEnv, PoiParentChildResultScreenInputSequence poiParentChildResultScreenInputSequence, PoiManager poiManager, IPreviewMap iPreviewMap, PoiSearchArea poiSearchArea, AsyncNavLocationExtractor asyncNavLocationExtractor) {
        super(navigationEnv, poiManager, iPreviewMap, poiSearchArea, asyncNavLocationExtractor);
        this.inputSequence = poiParentChildResultScreenInputSequence;
    }

    @Override
    public CommandList getStartCommandList() {
        return this.inputSequence.getStartCommandList();
    }

    @Override
    public void preparePreviewMap() {
    }

    @Override
    protected void registerAsListener() {
        this.env.getTiledListModel(PoiScreensEvo.getPoiParentChildResultScreenListModel()).setListener(this);
        this.env.getMenuModel(PoiScreensEvo.getPoiParentChildResultScreenMenuModel()).setListener(this);
    }

    public PoiParentChildResultScreenInputSequence getParentChildResultScreenInputSequence() {
        return this.inputSequence;
    }

    @Override
    protected void itemFocusedCallBack(NavLocation navLocation) {
        if (Util.isHURegionAsia()) {
            this.inputSequence.focusPreviewMap(this.previewMapInterface, navLocation);
            this.inputSequence.onElementFocused(navLocation);
        } else {
            this.inputSequence.onElementFocused(navLocation);
        }
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "PoiParentChildResultScreenHmiListener#itemselected(%1, %2, %3)", (long)n, (long)n2, (long)n4);
        if (n != PoiScreensEvo.getPoiParentChildResultScreenListModel()) {
            this.logChannel.log(-2137614336, "PoiParentChildResultScreenHmiListener#itemSelected: Unexpected model ID: %1", (long)n);
            return;
        }
        LIValueListElement lIValueListElement = PoiScreensEvo.getLiValueListElementFromRow(evoListRow, n);
        int n5 = 1102;
        this.poiManager.executePoiSelectionEvent(this.inputSequence.getListElementSelected(lIValueListElement), n5);
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "PoiParentChildResultScreenHmiListener#itemSelected: Selected element.data = %1", (Object)lIValueListElement.getData());
        }
        this.env.fireModelEvent(n, n4);
    }

    @Override
    public void requestItems(int n, int n2, int n3, int n4, int n5) {
        this.logChannel.log(-2137614336, "PoiParentChildResultScreenHmiListener#requestItems - was called with requestID = %1, startIndex = %2, model = %3", (long)n3, (long)n, (long)n4);
        this.inputSequence.requestItems(n, n3);
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
}

