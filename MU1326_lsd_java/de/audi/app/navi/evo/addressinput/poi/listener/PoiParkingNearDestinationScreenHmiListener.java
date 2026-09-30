/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listener;

import de.audi.app.navi.evo.addressinput.poi.PoiManager;
import de.audi.app.navi.evo.addressinput.poi.PoiScreensEvo;
import de.audi.app.navi.evo.addressinput.poi.listener.AbstractPoiResultScreenEvoListener;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiParkingNearDestinationScreenInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.navlocationextractor.AsyncNavLocationExtractor;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiParkingNearDestinationScreenHmiListener
extends AbstractPoiResultScreenEvoListener
implements SpellerListener,
TiledListModelListener {
    private boolean isSpellerOpened;
    private final PoiParkingNearDestinationScreenInputSequence inputSequence;

    public PoiParkingNearDestinationScreenHmiListener(NavigationEnv navigationEnv, PoiManager poiManager, IPreviewMap iPreviewMap, PoiSearchArea poiSearchArea, PoiParkingNearDestinationScreenInputSequence poiParkingNearDestinationScreenInputSequence, AsyncNavLocationExtractor asyncNavLocationExtractor) {
        super(navigationEnv, poiManager, iPreviewMap, poiSearchArea, asyncNavLocationExtractor);
        this.inputSequence = poiParkingNearDestinationScreenInputSequence;
    }

    public CommandList getStartCommandList() {
        return this.inputSequence.getStartCommandList();
    }

    public void preparePreviewMap() {
        this.displayMultiplePois = true;
    }

    protected void registerAsListener() {
        this.env.getSpellerModel(PoiScreensEvo.getPoiParkingNearDestinationScreenSpellerModel()).setSpellerListener(this);
        this.env.getTiledListModel(PoiScreensEvo.getPoiParkingNearDestinationScreenListModel()).setListener(this);
        this.env.getMenuModel(PoiScreensEvo.getPoiParkingNearDestinationScreenMenuModel()).setListener(this);
    }

    public PoiParkingNearDestinationScreenInputSequence getPoiParkingNearDestinationScreenInputSequence() {
        return this.inputSequence;
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "PoiParkingNearDestinationScreenHmiListener#itemselected(%1, %2, %3)", (long)n, (long)n2, (long)n4);
        if (n != PoiScreensEvo.getPoiParkingNearDestinationScreenListModel()) {
            this.logChannel.log(10000000, "PoiParkingNearDestinationScreenHmiListener#itemSelected: Unexpected model ID: %1", (long)n);
            return;
        }
        LIValueListElement lIValueListElement = PoiScreensEvo.getLiValueListElementFromRow(evoListRow, n);
        this.poiManager.executePoiSelectionEvent(this.inputSequence.getListElementSelected(lIValueListElement), 1202);
        this.env.fireModelEvent(n, n4);
    }

    private void displayPoisInPreviewMap(int n) {
        this.logChannel.log(10000000, "PoiParkingNearDestinationScreenHmiListener#displayPoisInPreviewMap model=%1", (long)n);
        if (!this.isSpellerOpened) {
            LIValueListElement[] lIValueListElementArray = new LIValueListElement[3];
            int n2 = 0;
            for (int i2 = 0; i2 < 3; ++i2) {
                EvoListRow evoListRow = this.env.getTiledListModel(PoiScreensEvo.getPoiParkingNearDestinationScreenListModel()).getRow(i2);
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

    public void itemFocused(int n, int n2, long l, int n3) {
        this.logChannel.log(10000000, "PoiParkingNearDestinationScreenHmiListener#itemFocused() - menuItemId: %1, model: %2, uniqueListRowID: %3", (long)n, (long)n2, l);
        this.logChannel.log(10000000, "PoiParkingNearDestinationScreenHmiListener#itemFocused() - displayMultiplePois=%1", this.displayMultiplePois);
        if (n != PoiScreensEvo.getPoiParkingNearDestinationScreenListModel() && this.displayMultiplePois) {
            this.preparePreviewMap();
            this.displayPoisInPreviewMap(n2);
        }
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "PoiParkingNearDestinationScreenHmiListener#itemFocused: model is: %1", (long)n);
        this.preparePreviewMap();
        LIValueListElement lIValueListElement = PoiScreensEvo.getLiValueListElementFromRow(evoListRow, n);
        this.inputSequence.preparePreviewMap(this.previewMapInterface, lIValueListElement);
    }

    public void requestItems(int n, int n2, int n3, final int n4, int n5) {
        this.logChannel.log(10000000, "PoiParkingNearDestinationScreenHmiListener#requestItems - was called with requestID = %1, startIndex = %2, model = %3", (long)n3, (long)n, (long)n4);
        NavCommand navCommand = new NavCommand("Update Preview Map"){

            public void execute() {
                PoiParkingNearDestinationScreenHmiListener.this.displayPoisInPreviewMap(n4);
                this.getCommandList().commandFinished();
            }
        };
        this.inputSequence.requestItems(n, n3, n2, navCommand);
    }

    public void unrequestItems(int n, int n2, int n3, int n4) {
        this.inputSequence.unrequestItems(n, n2);
    }

    public void textChanged(int n, String string, char c2, int n2) {
        this.inputSequence.setInput(string);
    }

    public void commandPressed(int n, int n2, int n3) {
        this.logChannel.log(10000000, "PoiParkingNearDestinationScreenHmiListener#commandPressed model=%1, index=%2", (long)n, (long)n2);
        if (n2 == 4711) {
            this.isSpellerOpened = true;
            if (this.preparePreviewMapCommand != null) {
                this.logChannel.log(10000000, "%1#commandPressed - stop FocusPreviewMap", (Object)this.CLASS_NAME);
                this.preparePreviewMapCommand.setHidePreviewMap(true);
                this.preparePreviewMapCommand = null;
            } else {
                this.logChannel.log(10000000, "%1#commandPressed - preparePreviewMapCommand is null", (Object)this.CLASS_NAME);
            }
            this.inputSequence.hidePreviewMap(this.previewMapInterface);
        } else if (n2 == 4712) {
            this.isSpellerOpened = false;
            this.displayPoisInPreviewMap(n);
        }
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void focusedCharacter(int n, char c2, int n2) {
    }

    protected void itemFocusedCallBack(NavLocation navLocation) {
    }
}

