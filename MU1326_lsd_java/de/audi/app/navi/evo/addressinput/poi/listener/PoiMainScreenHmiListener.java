/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listener;

import de.audi.app.navi.evo.addressinput.poi.PoiManager;
import de.audi.app.navi.evo.addressinput.poi.PoiScreensEvo;
import de.audi.app.navi.evo.addressinput.poi.listener.AbstractPoiScreenHmiListener;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiMainScreenInputSequence;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiMainScreenHmiListener
extends AbstractPoiScreenHmiListener
implements ButtonListener,
BaseListModelListener,
MenuModelListener {
    private final PoiMainScreenInputSequence inputSequence;

    public PoiMainScreenHmiListener(NavigationEnv navigationEnv, PoiMainScreenInputSequence poiMainScreenInputSequence, PoiManager poiManager, IPreviewMap iPreviewMap, PoiSearchArea poiSearchArea) {
        super(navigationEnv, poiManager, iPreviewMap, poiSearchArea);
        this.inputSequence = poiMainScreenInputSequence;
    }

    @Override
    public CommandList getStartCommandList() {
        CommandList commandList = this.inputSequence.getStartCommandList();
        return commandList;
    }

    @Override
    public void preparePreviewMap() {
        this.displayMultiplePois = true;
        this.logChannel.log(-2137614336, "PoiMainScreenHmiListener#preparePreviewMap() - enter");
        NavLocation navLocation = this.poiSearchArea.getLocation();
        int n = this.poiSearchArea.getSearchContext();
        this.logChannel.log(-2137614336, "PoiMainScreenHmiListener#preparePreviewMap() - search context=%2, currentSearchLocation=%1", (Object)LocationFormatter.formatLocationShort(navLocation), (long)n);
        if (n == 5) {
            this.previewMapInterface.setPreviewAreaAroundCCP(1);
        } else if (n == 1) {
            this.previewMapInterface.setPreviewRoute(true, 1, null, null);
        } else if (navLocation == null) {
            this.previewMapInterface.setPreviewAreaAroundCCP(1);
        } else if (n == 4) {
            this.previewMapInterface.setPreviewLocationCity(navLocation, 1, null, null);
        } else {
            this.previewMapInterface.setPreviewDestination(navLocation, 1, null, null);
        }
    }

    @Override
    protected void registerAsListener() {
        this.env.getButtonModel(PoiScreensEvo.getPoiMainScreenSearchByNameButtonModel()).setButtonListener(this);
        this.env.getButtonModel(PoiScreensEvo.getPoiMainScreenAllClassesButtonModel()).setButtonListener(this);
        this.env.getButtonModel(PoiScreensEvo.getPoiMainScreenPersonalPoiButtonModel()).setButtonListener(this);
        this.env.getBaseListModel(PoiScreensEvo.getPoiMainScreenListModel()).setListener(this);
        this.env.getMenuModel(PoiScreensEvo.getPoiMainScreenMenuModel()).setListener(this);
    }

    public PoiMainScreenInputSequence getPoiMainScreenInputSequence() {
        return this.inputSequence;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "PoiMainScreenHmiListener#keyTyped(%1, %2, %3)", (long)n, (long)n2, (long)n3);
        switch (n) {
            case 400200: {
                this.env.getChoiceModel(1730086400).setValue(0);
                this.poiManager.executePoiSelectionEvent(this.inputSequence.getStartSearchByName(), 5);
                break;
            }
            case 400184: {
                this.env.getChoiceModel(1730086400).setValue(0);
                this.poiManager.executePoiSelectionEvent(this.inputSequence.getStartClasses(), 2);
                break;
            }
            case 402561: {
                if (this.env.getChoiceModel(1696531968).getValue() != 1) break;
                this.env.getChoiceModel(1730086400).setValue(1);
                this.poiManager.executePoiSelectionEvent(this.inputSequence.getStartPersonalPoi(), 3);
                break;
            }
            default: {
                this.logChannel.log(-2137614336, "PoiMainScreenHmiListener#keyTyped: Unexpected model ID: %1", (long)n);
            }
        }
        this.env.fireModelEvent(n, n3);
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "PoiMainScreenHmiListener#itemSelected(%1, %2, %3)", (long)n, (long)n2, (long)n4);
        if (n != PoiScreensEvo.getPoiMainScreenListModel()) {
            this.logChannel.log(-2137614336, "PoiMainScreenHmiListener#itemSelected: Unexpected model ID: %1", (long)n);
            return;
        }
        LIValueListElement lIValueListElement = PoiScreensEvo.getLiValueListElementFromRow(evoListRow, n);
        this.env.getChoiceModel(1730086400).setValue(0);
        this.poiManager.executePoiSelectionEvent(this.inputSequence.getSelectListElement(lIValueListElement), 1);
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "PoiMainScreenHmiListener#itemSelected: Selected element.data = %1", (Object)lIValueListElement.getData());
        }
        this.env.fireModelEvent(n, n4);
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "PoiMainScreenHmiListener#itemFocused() - menuItemId: %1, model: %2, uniquteListRowID: %3", (long)n, (long)n2, l);
        }
        this.preparePreviewMap();
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public LIValueListElement getPoiMainScreenTopPoiListEntry(int n) {
        BaseListModelApp baseListModelApp = this.env.getBaseListModel(PoiScreensEvo.getPoiMainScreenListModel());
        EvoListRow evoListRow = baseListModelApp.getRow(n);
        return PoiScreensEvo.getLiValueListElementFromRow(evoListRow, 0);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }
}

