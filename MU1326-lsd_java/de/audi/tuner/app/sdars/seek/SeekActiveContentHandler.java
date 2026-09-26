/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDSISeekDownManager;
import de.audi.tuner.app.sdars.dsi.SDARSDsiDownInfo;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.app.sdars.seek.AbstractSeekListSizeRistrictionHandler;
import de.audi.tuner.app.sdars.seek.SeekActiveContentHandler$ActionProxyListener;
import de.audi.tuner.app.sdars.seek.SeekActiveContentHandler$ButtonListener;
import de.audi.tuner.app.sdars.seek.SeekActiveContentHandler$CancelButtonListener;
import de.audi.tuner.app.sdars.seek.SeekActiveContentHandler$DsiDownListener;
import de.audi.tuner.app.sdars.seek.SeekActiveContentHandler$DsiUpListener;
import de.audi.tuner.app.sdars.seek.SeekActiveContentHandler$FavoriteReplaceListListener;
import de.audi.tuner.app.sdars.seek.SeekActiveContentHandler$ReplaceButtonListener;
import de.audi.tuner.ifc.ITunerVariantExt;
import java.util.HashMap;
import org.dsi.ifc.sdars.SeekEntry;

public class SeekActiveContentHandler {
    public final SDARSDsiDownInfo dsiDownListener = new SeekActiveContentHandler$DsiDownListener(this, null);
    public final SDARSDsiUpInfo dsiUpListener = new SeekActiveContentHandler$DsiUpListener(this, null);
    public final TunerActionProxyListener actionProxyListener = new SeekActiveContentHandler$ActionProxyListener(this, null);
    public static final int SEEKTYPE_NONE;
    public static final int SEEKTYPE_MUSIC;
    public static final int SEEKTYPE_GAME;
    public static final int SEEKTYPE_WEATHER;
    private final LogChannel log;
    private final SDARSDSISeekDownManager dsi;
    private final ITunerVariantExt varExt;
    private final AbstractSeekListSizeRistrictionHandler sizeRestrictionHandler;
    private final TunerModels models;
    private StationInfoExt currentStation = new StationInfoExt();
    private SeekEntry overflowSeek = null;
    private HashMap currentSeeks;
    private boolean waitingForSeek;
    private int relacementFinishedPopupId;

    public SeekActiveContentHandler(TunerBasics tunerBasics, SDARSDSISeekDownManager sDARSDSISeekDownManager, ITunerVariantExt iTunerVariantExt, AbstractSeekListSizeRistrictionHandler abstractSeekListSizeRistrictionHandler) {
        this.log = tunerBasics.getLogger().sdarsSeekDSI;
        this.dsi = sDARSDSISeekDownManager;
        this.varExt = iTunerVariantExt;
        this.models = tunerBasics.getModels();
        this.sizeRestrictionHandler = abstractSeekListSizeRistrictionHandler;
        SeekActiveContentHandler$ButtonListener seekActiveContentHandler$ButtonListener = new SeekActiveContentHandler$ButtonListener(this, null);
        this.models.getButtonModel(646512896).setButtonListener(seekActiveContentHandler$ButtonListener);
        this.models.getButtonModel(663290112).setButtonListener(seekActiveContentHandler$ButtonListener);
        this.models.getButtonModel(629735680).setButtonListener(seekActiveContentHandler$ButtonListener);
        this.models.getButtonModel(680067328).setButtonListener(seekActiveContentHandler$ButtonListener);
        this.models.getButtonModel(-1870069504).setButtonListener(new SeekActiveContentHandler$CancelButtonListener(this, null));
        this.models.getButtonModel(-1886846720).setButtonListener(new SeekActiveContentHandler$ReplaceButtonListener(this, null));
        this.models.getBaseListModel(-1903623936).setListener(new SeekActiveContentHandler$FavoriteReplaceListListener(this, null));
        this.adjustSeekTypeModel(-1);
    }

    public void resetToDefaultSettings() {
        this.log.log(-2137614336, "[SdarsSeekHAndler.resetToDefaultSettings]");
        this.dsi.reset(1);
        this.dsi.reset(2);
    }

    private void updateNewSeek(SeekEntry seekEntry) {
        this.overflowSeek = seekEntry;
    }

    private void adjustSeekTypeModel(int n) {
        this.models.getChoiceModel(1284047104).setValue(n);
    }

    private void cancelReplace() {
        if (this.overflowSeek != null) {
            this.dsi.manageSeek2(this.overflowSeek.getTypeOfContent(), this.overflowSeek.getSeekID(), this.overflowSeek.getContentLink(), 3);
        }
        this.varExt.hidePartialPopup(17);
        this.varExt.hidePartialPopup(19);
        this.varExt.hidePartialPopup(20);
        this.models.getButtonModel(-1870069504).fireEvent(0);
    }

    static /* synthetic */ ITunerVariantExt access$700(SeekActiveContentHandler seekActiveContentHandler) {
        return seekActiveContentHandler.varExt;
    }

    static /* synthetic */ TunerModels access$800(SeekActiveContentHandler seekActiveContentHandler) {
        return seekActiveContentHandler.models;
    }

    static /* synthetic */ AbstractSeekListSizeRistrictionHandler access$900(SeekActiveContentHandler seekActiveContentHandler) {
        return seekActiveContentHandler.sizeRestrictionHandler;
    }

    static /* synthetic */ LogChannel access$1000(SeekActiveContentHandler seekActiveContentHandler) {
        return seekActiveContentHandler.log;
    }

    static /* synthetic */ boolean access$1102(SeekActiveContentHandler seekActiveContentHandler, boolean bl) {
        seekActiveContentHandler.waitingForSeek = bl;
        return seekActiveContentHandler.waitingForSeek;
    }

    static /* synthetic */ int access$1202(SeekActiveContentHandler seekActiveContentHandler, int n) {
        seekActiveContentHandler.relacementFinishedPopupId = n;
        return seekActiveContentHandler.relacementFinishedPopupId;
    }

    static /* synthetic */ StationInfoExt access$1300(SeekActiveContentHandler seekActiveContentHandler) {
        return seekActiveContentHandler.currentStation;
    }

    static /* synthetic */ SDARSDSISeekDownManager access$1400(SeekActiveContentHandler seekActiveContentHandler) {
        return seekActiveContentHandler.dsi;
    }

    static /* synthetic */ void access$1500(SeekActiveContentHandler seekActiveContentHandler) {
        seekActiveContentHandler.cancelReplace();
    }

    static /* synthetic */ SeekEntry access$1600(SeekActiveContentHandler seekActiveContentHandler) {
        return seekActiveContentHandler.overflowSeek;
    }

    static /* synthetic */ int access$1200(SeekActiveContentHandler seekActiveContentHandler) {
        return seekActiveContentHandler.relacementFinishedPopupId;
    }

    static /* synthetic */ SeekEntry access$1602(SeekActiveContentHandler seekActiveContentHandler, SeekEntry seekEntry) {
        seekActiveContentHandler.overflowSeek = seekEntry;
        return seekActiveContentHandler.overflowSeek;
    }

    static /* synthetic */ StationInfoExt access$1302(SeekActiveContentHandler seekActiveContentHandler, StationInfoExt stationInfoExt) {
        seekActiveContentHandler.currentStation = stationInfoExt;
        return seekActiveContentHandler.currentStation;
    }

    static /* synthetic */ HashMap access$1700(SeekActiveContentHandler seekActiveContentHandler) {
        return seekActiveContentHandler.currentSeeks;
    }

    static /* synthetic */ boolean access$1100(SeekActiveContentHandler seekActiveContentHandler) {
        return seekActiveContentHandler.waitingForSeek;
    }

    static /* synthetic */ void access$1800(SeekActiveContentHandler seekActiveContentHandler, SeekEntry seekEntry) {
        seekActiveContentHandler.updateNewSeek(seekEntry);
    }

    static /* synthetic */ HashMap access$1702(SeekActiveContentHandler seekActiveContentHandler, HashMap hashMap) {
        seekActiveContentHandler.currentSeeks = hashMap;
        return seekActiveContentHandler.currentSeeks;
    }

    static /* synthetic */ void access$1900(SeekActiveContentHandler seekActiveContentHandler, int n) {
        seekActiveContentHandler.adjustSeekTypeModel(n);
    }
}

