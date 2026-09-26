/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.listener.asia;

import de.audi.app.navi.evo.addressinput.poi.PoiManager;
import de.audi.app.navi.evo.addressinput.poi.PoiScreensEvo;
import de.audi.app.navi.evo.addressinput.poi.listener.PoiResultScreenWithMatchSpellerHmiListener;
import de.audi.app.navi.evo.addressinput.poi.listener.asia.PoiResultScreenWithMatchSpellerListenerAsia$1;
import de.audi.atip.hmi.model.MatchspellerListenerAsia;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultScreenWithMatchSpellerInputSequenceAsia;
import de.audi.tghu.navi.app.di.AddressInputUtil;
import de.audi.tghu.navi.app.navlocationextractor.AsyncNavLocationExtractor;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiResultScreenWithMatchSpellerListenerAsia
extends PoiResultScreenWithMatchSpellerHmiListener
implements MatchspellerListenerAsia {
    public PoiResultScreenWithMatchSpellerListenerAsia(NavigationEnv navigationEnv, PoiResultScreenWithMatchSpellerInputSequenceAsia poiResultScreenWithMatchSpellerInputSequenceAsia, PoiManager poiManager, IPreviewMap iPreviewMap, PoiSearchArea poiSearchArea, AsyncNavLocationExtractor asyncNavLocationExtractor) {
        super(navigationEnv, poiResultScreenWithMatchSpellerInputSequenceAsia, poiManager, iPreviewMap, poiSearchArea, asyncNavLocationExtractor);
    }

    @Override
    protected void registerAsListener() {
        this.matchSpellerModel = this.env.getMatchSpellerModel(PoiScreensEvo.getPoiResultScreenWithMatchSpellerSpellerModel());
        this.matchSpellerModel.setSpellerListenerAsia(this);
        this.env.getMenuModel(PoiScreensEvo.getPoiResultScreenWithMatchSpellerMenuModel()).setListener(this);
        this.env.getTiledListModel(PoiScreensEvo.getPoiResultScreenWithMatchSpellerTiledListModel()).setListener(this);
    }

    @Override
    public void requestItems(int n, int n2, int n3, int n4, int n5) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#requestItems - was called with requestID = %1, startIndex = %2, model = %3").toString(), (long)n3, (long)n, (long)n4);
        PoiResultScreenWithMatchSpellerListenerAsia$1 poiResultScreenWithMatchSpellerListenerAsia$1 = new PoiResultScreenWithMatchSpellerListenerAsia$1(this, "Update Preview Map", n4);
        this.inputSequence.requestItems(n, n3, n2, poiResultScreenWithMatchSpellerListenerAsia$1);
        this.poiManager.restartRRDForCurrentContext();
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "%1#itemSelected - row=%2, model=%3, index=%4", (Object)this.CLASS_NAME, (Object)evoListRow, (Object)new StringBuffer().append(n).append("").toString(), (Object)new StringBuffer().append(n2).append("").toString());
        LIValueListElement lIValueListElement = PoiScreensEvo.getLiValueListElementFromRow(evoListRow, n);
        int n5 = 0;
        n5 = !lIValueListElement.isValidDestination() ? 302 : 301;
        this.poiManager.executePoiSelectionEvent(this.inputSequence.getSelectElementCommandList(lIValueListElement), n5);
        this.env.fireModelEvent(n, n4);
    }

    @Override
    public void inputModeTPChanged(int n, int n2, int n3) {
        this.logChannel.log(-2137614336, "%1#inputModeTPChanged - modelId=%2, mode=%3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (!AddressInputUtil.getCurrentLanguageCode(this.env).equals("en_US")) {
            ((PoiResultScreenWithMatchSpellerInputSequenceAsia)this.inputSequence).touchPadInputModeChanged(n2);
        }
    }

    @Override
    public void nonAlphaNumTPCharsChanged(int n, int n2, String string) {
        this.logChannel.log(-2137614336, "%1#nonAlphaNumTPCharsChanged - modelId=%2, recognizedChars=%3", (Object)this.CLASS_NAME, (Object)Integer.toString(n), (Object)string);
        ((PoiResultScreenWithMatchSpellerInputSequenceAsia)this.inputSequence).nonAlphaNumTPCharsChanged(n, n2, string, this.matchSpellerModel);
    }

    @Override
    public void requestValidHanziCharsWindow(int n, int n2, int n3, int n4) {
        this.logChannel.log(-2137614336, "%1#requestValidHanziCharsWindow - modelId=%2, offset=%3, windowSize=%4", (Object)this.CLASS_NAME, (Object)String.valueOf(n), (Object)String.valueOf(n3), (Object)String.valueOf(n4));
        ((PoiResultScreenWithMatchSpellerInputSequenceAsia)this.inputSequence).requestValidHanziCharsWindow(n, n3, n4);
    }

    @Override
    public void strokesChanged(int n, int n2, String string, char c2) {
        this.logChannel.log(-2137614336, "%1#strokesChanged(%2, %3, %4)", (Object)this.CLASS_NAME, (Object)String.valueOf(n), (Object)string, (long)c2);
        this.setSpellerStatusWaiting(n);
        if (c2 == '\b') {
            ((PoiResultScreenWithMatchSpellerInputSequenceAsia)this.inputSequence).undoStroke();
        } else {
            ((PoiResultScreenWithMatchSpellerInputSequenceAsia)this.inputSequence).addStroke(String.valueOf(c2));
        }
    }

    static /* synthetic */ void access$000(PoiResultScreenWithMatchSpellerListenerAsia poiResultScreenWithMatchSpellerListenerAsia, int n) {
        poiResultScreenWithMatchSpellerListenerAsia.displayPoisInPreviewMap(n);
    }
}

