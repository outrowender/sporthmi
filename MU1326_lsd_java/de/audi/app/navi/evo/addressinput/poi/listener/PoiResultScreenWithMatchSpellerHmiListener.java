/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listener;

import de.audi.app.navi.evo.addressinput.poi.PoiManager;
import de.audi.app.navi.evo.addressinput.poi.PoiScreensEvo;
import de.audi.app.navi.evo.addressinput.poi.listener.AbstractPoiResultScreenEvoListener;
import de.audi.app.navi.evo.addressinput.poi.listener.PoiResultScreenWithMatchSpellerHmiListener$1;
import de.audi.atip.hmi.model.MatchSpellerListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelListener;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenWithMatchSpellerInputSequence;
import de.audi.tghu.navi.app.navlocationextractor.AsyncNavLocationExtractor;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiResultScreenWithMatchSpellerHmiListener
extends AbstractPoiResultScreenEvoListener
implements TiledListModelListener,
MatchSpellerListener {
    protected final PoiResultScreenWithMatchSpellerInputSequence inputSequence;
    protected boolean isSpellerOpened = false;
    protected MatchspellerModelApp matchSpellerModel;

    public PoiResultScreenWithMatchSpellerHmiListener(NavigationEnv navigationEnv, PoiResultScreenWithMatchSpellerInputSequence poiResultScreenWithMatchSpellerInputSequence, PoiManager poiManager, IPreviewMap iPreviewMap, PoiSearchArea poiSearchArea, AsyncNavLocationExtractor asyncNavLocationExtractor) {
        super(navigationEnv, poiManager, iPreviewMap, poiSearchArea, asyncNavLocationExtractor);
        this.inputSequence = poiResultScreenWithMatchSpellerInputSequence;
        this.preparePreviewMapCommand = null;
    }

    @Override
    public CommandList getStartCommandList() {
        this.preparePreviewMap();
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
        this.matchSpellerModel = this.env.getMatchSpellerModel(PoiScreensEvo.getPoiResultScreenWithMatchSpellerSpellerModel());
        this.matchSpellerModel.setSpellerListener(this);
        this.env.getMenuModel(PoiScreensEvo.getPoiResultScreenWithMatchSpellerMenuModel()).setListener(this);
        this.env.getTiledListModel(PoiScreensEvo.getPoiResultScreenWithMatchSpellerTiledListModel()).setListener(this);
    }

    public PoiResultScreenWithMatchSpellerInputSequence getPoiResultScreenWithMatchSpellerInputSequence() {
        return this.inputSequence;
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        this.logChannel.log(-2137614336, "%1#textChanged() was invoked", (Object)this.CLASS_NAME);
        this.setSpellerStatusWaiting(n);
        if ("".equals(string)) {
            this.inputSequence.deleteAllCharacters();
        } else if (c2 == '\b') {
            this.inputSequence.undoCharacter();
        } else {
            this.inputSequence.addCharacter(Character.toString(c2));
        }
    }

    @Override
    public void requestItems(int n, int n2, int n3, int n4, int n5) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#requestItems - was called with requestID = %1, startIndex = %2, model = %3").toString(), (long)n3, (long)n, (long)n4);
        PoiResultScreenWithMatchSpellerHmiListener$1 poiResultScreenWithMatchSpellerHmiListener$1 = new PoiResultScreenWithMatchSpellerHmiListener$1(this, "Update Preview Map", n4);
        this.inputSequence.requestItems(n, n3, n2, poiResultScreenWithMatchSpellerHmiListener$1);
        this.poiManager.restartRRDForCurrentContext();
    }

    @Override
    public void unrequestItems(int n, int n2, int n3, int n4) {
        this.inputSequence.unrequestItems(n, n2);
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
    protected void itemFocusedCallBack(NavLocation navLocation) {
        this.logChannel.log(-2137614336, "%1#itemFocusedCallBack", (Object)this.CLASS_NAME);
        this.inputSequence.onElementFocused(navLocation);
        if (navLocation == null || !navLocation.isPositionValid() || this.inputSequence.isSpellerOpen()) {
            this.logChannel.log(-2137614336, "%1#itemFocusedCallBack hidePreviewMap", (Object)this.CLASS_NAME);
            this.inputSequence.hidePreviewMap(this.previewMapInterface);
        } else {
            this.logChannel.log(-2137614336, "%1#itemFocusedCallBack focusPreviewMap", (Object)this.CLASS_NAME);
            this.inputSequence.focusPreviewMap(this.previewMapInterface, navLocation);
        }
    }

    protected void displayPoisInPreviewMap(int n) {
        this.logChannel.log(-2137614336, "%1#displayPoisInPreviewMap model=%2", (Object)this.CLASS_NAME, (long)n);
        if (!this.inputSequence.isSpellerOpen()) {
            LIValueListElement[] lIValueListElementArray = new LIValueListElement[3];
            int n2 = 0;
            for (int i2 = 0; i2 < 3; ++i2) {
                EvoListRow evoListRow = this.env.getTiledListModel(PoiScreensEvo.getPoiResultScreenWithMatchSpellerTiledListModel()).getRow(i2);
                LIValueListElement lIValueListElement = PoiScreensEvo.getLiValueListElementFromRow(evoListRow, n);
                if (lIValueListElement != null) {
                    if (lIValueListElement.latitude == 0 && lIValueListElement.longitude == 0) {
                        lIValueListElementArray[i2] = null;
                        continue;
                    }
                    lIValueListElementArray[i2] = lIValueListElement;
                    ++n2;
                    continue;
                }
                lIValueListElementArray[i2] = lIValueListElement;
            }
            if (n2 == 0) {
                this.inputSequence.hidePreviewMap(this.previewMapInterface);
            } else if (n2 < 3) {
                LIValueListElement[] lIValueListElementArray2 = new LIValueListElement[n2];
                int n3 = 0;
                for (int i3 = 0; i3 < lIValueListElementArray2.length; ++i3) {
                    while (lIValueListElementArray[n3] == null) {
                        ++n3;
                    }
                    lIValueListElementArray2[i3] = lIValueListElementArray[n3];
                    ++n3;
                }
                this.preparePreviewMapCommand = this.inputSequence.preparePreviewMap(this.previewMapInterface, lIValueListElementArray2);
            } else {
                this.preparePreviewMapCommand = this.inputSequence.preparePreviewMap(this.previewMapInterface, lIValueListElementArray);
            }
        }
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#itemFocused() - menuItemId: %1, model: %2, uniqueListRowID: %3").toString(), (long)n, (long)n2, l);
        this.previewMapComplete = false;
        if (l == -1L && !this.inputSequence.isSpellerOpen()) {
            this.displayPreviewMap(n2, this.inputSequence, PoiScreensEvo.getPoiResultScreenWithMatchSpellerTiledListModel());
        }
        this.currentlyFocusedListIndex = l;
    }

    @Override
    public void updateResultsAvailable() {
        if (this.currentlyFocusedListIndex == -1L && !this.inputSequence.isSpellerOpen()) {
            this.displayPreviewMap(PoiScreensEvo.getPoiResultScreenWithMatchSpellerSpellerModel(), this.inputSequence, PoiScreensEvo.getPoiResultScreenWithMatchSpellerTiledListModel());
        }
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
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
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void focusedCharacter(int n, char c2, int n2) {
    }
}

