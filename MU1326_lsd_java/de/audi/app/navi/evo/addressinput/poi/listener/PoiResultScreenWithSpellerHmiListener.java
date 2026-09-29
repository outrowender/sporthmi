/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listener;

import de.audi.app.navi.evo.addressinput.poi.PoiManager;
import de.audi.app.navi.evo.addressinput.poi.PoiScreensEvo;
import de.audi.app.navi.evo.addressinput.poi.listener.AbstractPoiResultScreenEvoListener;
import de.audi.app.navi.evo.addressinput.poi.listener.PoiResultScreenWithSpellerHmiListener$1;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenWithSpellerInputSequence;
import de.audi.tghu.navi.app.navlocationextractor.AsyncNavLocationExtractor;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiResultScreenWithSpellerHmiListener
extends AbstractPoiResultScreenEvoListener
implements SpellerListener,
TiledListModelListener {
    private final PoiResultScreenWithSpellerInputSequence inputSequence;
    private boolean isSpellerOpened = false;

    public PoiResultScreenWithSpellerHmiListener(NavigationEnv navigationEnv, PoiResultScreenWithSpellerInputSequence poiResultScreenWithSpellerInputSequence, PoiManager poiManager, IPreviewMap iPreviewMap, PoiSearchArea poiSearchArea, AsyncNavLocationExtractor asyncNavLocationExtractor) {
        super(navigationEnv, poiManager, iPreviewMap, poiSearchArea, asyncNavLocationExtractor);
        this.inputSequence = poiResultScreenWithSpellerInputSequence;
        this.preparePreviewMapCommand = null;
    }

    @Override
    public CommandList getStartCommandList() {
        return this.inputSequence.getStartCommandList();
    }

    public CommandList getStartCommandListWithElement() {
        this.preparePreviewMap();
        return this.inputSequence.getStartCommandListWithElement();
    }

    public CommandList getStartCommandListByUID(int n) {
        return this.inputSequence.getStartCommandListByUID(n);
    }

    @Override
    public void preparePreviewMap() {
        this.displayMultiplePois = true;
    }

    @Override
    protected void registerAsListener() {
        this.env.getSpellerModel(PoiScreensEvo.getPoiResultScreenWithSpellerSpellerModel()).setSpellerListener(this);
        this.env.getTiledListModel(PoiScreensEvo.getPoiResultScreenWithSpellerListModel()).setListener(this);
        this.env.getMenuModel(PoiScreensEvo.getPoiResultScreenWithSpellerMenuModel()).setListener(this);
    }

    public PoiResultScreenWithSpellerInputSequence getPoiResultScreenWithSpellerInputSequence() {
        return this.inputSequence;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "PoiResultScreenWithSpellerHmiListener#itemselected(%1, %2, %3)", (long)n, (long)n2, (long)n4);
        if (n != PoiScreensEvo.getPoiResultScreenWithSpellerListModel()) {
            this.logChannel.log(-2137614336, "PoiResultScreenWithSpellerHmiListener#itemSelected: Unexpected model ID: %1", (long)n);
            return;
        }
        LIValueListElement lIValueListElement = PoiScreensEvo.getLiValueListElementFromRow(evoListRow, n);
        this.poiManager.executePoiSelectionEvent(this.inputSequence.getSelectListElement(lIValueListElement), 101);
        this.env.fireModelEvent(n, n4);
    }

    @Override
    public void commandPressed(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "%1#commandPressed model=%2, index=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (n2 == 4711) {
            this.inputSequence.setSpellerOpen(true);
            if (this.preparePreviewMapCommand != null) {
                this.logChannel.log(-2137614336, "%1#commandPressed - stop FocusPreviewMap", (Object)this.CLASS_NAME);
                this.preparePreviewMapCommand.setHidePreviewMap(true);
                this.preparePreviewMapCommand = null;
            } else {
                this.logChannel.log(-2137614336, "%1#commandPressed - preparePreviewMapCommand is null", (Object)this.CLASS_NAME);
            }
            this.inputSequence.hidePreviewMap(this.previewMapInterface);
        } else if (n2 == 4712) {
            this.inputSequence.setSpellerOpen(false);
            this.displayPoisInPreviewMap(n);
        }
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#itemFocused() - menuItemId: %1, model: %2, uniqueListRowID: %3").toString(), (long)n, (long)n2, l);
        this.previewMapComplete = false;
        if (l == -1L && !this.inputSequence.isSpellerOpen()) {
            this.displayPreviewMap(n2, this.inputSequence, PoiScreensEvo.getPoiResultScreenWithSpellerListModel());
        }
        this.currentlyFocusedListIndex = l;
    }

    @Override
    public void updateResultsAvailable() {
        if (this.currentlyFocusedListIndex == -1L && !this.inputSequence.isSpellerOpen()) {
            this.displayPreviewMap(PoiScreensEvo.getPoiResultScreenWithSpellerMenuModel(), this.inputSequence, PoiScreensEvo.getPoiResultScreenWithSpellerListModel());
        }
    }

    private void displayPoisInPreviewMap(int n) {
        this.logChannel.log(-2137614336, "PoiResultScreenWithSpellerHmiListener#displayPoisInPreviewMap model=%1", (long)n);
        if (!this.inputSequence.isSpellerOpen()) {
            LIValueListElement[] lIValueListElementArray = new LIValueListElement[3];
            int n2 = 0;
            for (int i2 = 0; i2 < 3; ++i2) {
                EvoListRow evoListRow = this.env.getTiledListModel(PoiScreensEvo.getPoiResultScreenWithSpellerListModel()).getRow(i2);
                lIValueListElementArray[i2] = PoiScreensEvo.getLiValueListElementFromRow(evoListRow, n);
                if (lIValueListElementArray[i2] == null) continue;
                n2 = i2 + 1;
            }
            if (n2 < 3) {
                LIValueListElement[] lIValueListElementArray2 = new LIValueListElement[n2];
                for (int i3 = 0; i3 < lIValueListElementArray2.length; ++i3) {
                    lIValueListElementArray2[i3] = lIValueListElementArray[i3];
                }
                this.preparePreviewMapCommand = this.inputSequence.preparePreviewMap(this.previewMapInterface, lIValueListElementArray2);
            } else {
                this.preparePreviewMapCommand = this.inputSequence.preparePreviewMap(this.previewMapInterface, lIValueListElementArray);
            }
        }
    }

    @Override
    protected void itemFocusedCallBack(NavLocation navLocation) {
        if (navLocation != null && !navLocation.isPositionValid() || this.inputSequence.isSpellerOpen()) {
            this.logChannel.log(-2137614336, "%1#itemFocusedCallBack hidePreviewMap", (Object)this.CLASS_NAME);
            this.inputSequence.hidePreviewMap(this.previewMapInterface);
        } else {
            this.logChannel.log(-2137614336, "%1#itemFocusedCallBack focusPreviewMap", (Object)this.CLASS_NAME);
            this.inputSequence.focusPreviewMap(this.previewMapInterface, navLocation);
            this.inputSequence.onElementFocused(navLocation);
        }
    }

    @Override
    public void unrequestItems(int n, int n2, int n3, int n4) {
        this.inputSequence.unrequestItems(n, n2);
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        this.poiManager.exitRRD();
        this.inputSequence.setInput(string);
    }

    @Override
    public void requestItems(int n, int n2, int n3, int n4, int n5) {
        this.logChannel.log(-2137614336, "PoiResultScreenWithSpellerHmiListener#requestItems - was called with requestID = %1, startIndex = %2, model = %3", (long)n3, (long)n, (long)n4);
        PoiResultScreenWithSpellerHmiListener$1 poiResultScreenWithSpellerHmiListener$1 = new PoiResultScreenWithSpellerHmiListener$1(this, "Update Preview Map", n4);
        this.inputSequence.requestItems(n, n3, n2, poiResultScreenWithSpellerHmiListener$1);
        this.poiManager.restartRRDForCurrentContext();
    }

    @Override
    public void focusedCharacter(int n, char c2, int n2) {
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    static /* synthetic */ void access$000(PoiResultScreenWithSpellerHmiListener poiResultScreenWithSpellerHmiListener, int n) {
        poiResultScreenWithSpellerHmiListener.displayPoisInPreviewMap(n);
    }
}

