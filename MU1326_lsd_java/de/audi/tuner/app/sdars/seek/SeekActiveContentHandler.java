/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDSISeekDownManager;
import de.audi.tuner.app.sdars.dsi.SDARSDsiDownInfo;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.app.sdars.seek.AbstractSeekListSizeRistrictionHandler;
import de.audi.tuner.app.sdars.seek.MusicHandler;
import de.audi.tuner.app.sdars.seek.SelectedTeamRow;
import de.audi.tuner.ifc.ITunerVariantExt;
import java.util.HashMap;
import org.dsi.ifc.sdars.SeekEntry;
import org.dsi.ifc.sdars.SeekPossibility;

public class SeekActiveContentHandler {
    public final SDARSDsiDownInfo dsiDownListener = new DsiDownListener();
    public final SDARSDsiUpInfo dsiUpListener = new DsiUpListener();
    public final TunerActionProxyListener actionProxyListener = new ActionProxyListener();
    public static final int SEEKTYPE_NONE = -1;
    public static final int SEEKTYPE_MUSIC = 0;
    public static final int SEEKTYPE_GAME = 1;
    public static final int SEEKTYPE_WEATHER = 2;
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
        ButtonListener buttonListener = new ButtonListener();
        this.models.getButtonModel(100646).setButtonListener(buttonListener);
        this.models.getButtonModel(100647).setButtonListener(buttonListener);
        this.models.getButtonModel(100645).setButtonListener(buttonListener);
        this.models.getButtonModel(100648).setButtonListener(buttonListener);
        this.models.getButtonModel(100752).setButtonListener(new CancelButtonListener());
        this.models.getButtonModel(100751).setButtonListener(new ReplaceButtonListener());
        this.models.getBaseListModel(100750).setListener(new FavoriteReplaceListListener());
        this.adjustSeekTypeModel(-1);
    }

    public void resetToDefaultSettings() {
        this.log.log(10000000, "[SdarsSeekHAndler.resetToDefaultSettings]");
        this.dsi.reset(1);
        this.dsi.reset(2);
    }

    private void updateNewSeek(SeekEntry seekEntry) {
        this.overflowSeek = seekEntry;
    }

    private void adjustSeekTypeModel(int n) {
        this.models.getChoiceModel(100684).setValue(n);
    }

    private void cancelReplace() {
        if (this.overflowSeek != null) {
            this.dsi.manageSeek2(this.overflowSeek.getTypeOfContent(), this.overflowSeek.getSeekID(), this.overflowSeek.getContentLink(), 3);
        }
        this.varExt.hidePartialPopup(17);
        this.varExt.hidePartialPopup(19);
        this.varExt.hidePartialPopup(20);
        this.models.getButtonModel(100752).fireEvent(0);
    }

    private class DsiUpListener
    extends SDARSDsiUpInfo {
        private DsiUpListener() {
        }

        public void updateSelectedStation(StationInfoExt stationInfoExt) {
            SeekActiveContentHandler.this.currentStation = stationInfoExt;
        }

        public void updateSeekList(SeekEntry[] seekEntryArray) {
            if (SeekActiveContentHandler.this.currentSeeks != null && SeekActiveContentHandler.this.waitingForSeek) {
                SeekActiveContentHandler.this.waitingForSeek = false;
                for (int i2 = 0; i2 < seekEntryArray.length; ++i2) {
                    SeekEntry seekEntry = seekEntryArray[i2];
                    if (SeekActiveContentHandler.this.currentSeeks.containsKey(new Integer(seekEntry.getSeekID()))) continue;
                    SeekActiveContentHandler.this.updateNewSeek(seekEntry);
                    break;
                }
            }
            HashMap hashMap = new HashMap();
            for (int i3 = 0; i3 < seekEntryArray.length; ++i3) {
                SeekEntry seekEntry = seekEntryArray[i3];
                hashMap.put(new Integer(seekEntry.getSeekID()), seekEntry);
            }
            SeekActiveContentHandler.this.currentSeeks = hashMap;
        }

        public void updateSeekPossibility(SeekPossibility seekPossibility) {
            int n = -1;
            switch (seekPossibility.getTypeOfContent()) {
                case 1: {
                    n = 0;
                    break;
                }
                case 3: {
                    n = 1;
                    break;
                }
            }
            SeekActiveContentHandler.this.adjustSeekTypeModel(n);
        }
    }

    private class ButtonListener
    extends DefaultButtonListener {
        private ButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            boolean bl;
            int n4;
            String string;
            int n5;
            SeekActiveContentHandler.this.varExt.hidePartialPopup(12);
            switch (n) {
                case 100646: {
                    n5 = 2;
                    string = SeekActiveContentHandler.this.models.getLabelModel(100349).getText();
                    n4 = 13;
                    bl = SeekActiveContentHandler.this.sizeRestrictionHandler.isSeekListFull(1);
                    break;
                }
                case 100647: {
                    n5 = 1;
                    string = SeekActiveContentHandler.this.models.getLabelModel(100351).getText();
                    n4 = 14;
                    bl = SeekActiveContentHandler.this.sizeRestrictionHandler.isSeekListFull(1);
                    break;
                }
                case 100645: {
                    n5 = 4;
                    string = SeekActiveContentHandler.this.models.getLabelModel(100192).getText();
                    n4 = 15;
                    bl = SeekActiveContentHandler.this.sizeRestrictionHandler.isSeekListFull(3);
                    break;
                }
                case 100648: {
                    n5 = 5;
                    string = SeekActiveContentHandler.this.models.getLabelModel(100194).getText();
                    n4 = 15;
                    bl = SeekActiveContentHandler.this.sizeRestrictionHandler.isSeekListFull(3);
                    break;
                }
                default: {
                    n5 = 0;
                    string = "";
                    n4 = -1;
                    bl = false;
                    SeekActiveContentHandler.this.log.log(10000, "[SeekActiveContentHandler.ButtonListener.keyTyped] wrong seekContentType!");
                }
            }
            if (bl) {
                BaseListModelApp baseListModelApp;
                switch (n) {
                    case 100646: 
                    case 100647: {
                        baseListModelApp = SeekActiveContentHandler.this.models.getBaseListModel(100483);
                        break;
                    }
                    case 100645: 
                    case 100648: {
                        baseListModelApp = SeekActiveContentHandler.this.models.getBaseListModel(100481);
                        break;
                    }
                    default: {
                        baseListModelApp = null;
                    }
                }
                if (baseListModelApp != null) {
                    BaseListModelApp baseListModelApp2 = SeekActiveContentHandler.this.models.getBaseListModel(100750);
                    baseListModelApp2.removeAll();
                    for (int i2 = 0; i2 < baseListModelApp.getLength(); ++i2) {
                        baseListModelApp2.append(baseListModelApp.getRow(i2));
                    }
                    SeekActiveContentHandler.this.waitingForSeek = true;
                    SeekActiveContentHandler.this.relacementFinishedPopupId = n4;
                    SeekActiveContentHandler.this.dsi.setSeekCommand(((SeekActiveContentHandler)SeekActiveContentHandler.this).currentStation.sID, n5, 1);
                    SeekActiveContentHandler.this.varExt.showPartialPopup(17);
                }
            } else {
                SeekActiveContentHandler.this.log.log(10000000, "[DSISDARSSeek.setSeekCommand] sId %1, seekType %2", (long)((SeekActiveContentHandler)SeekActiveContentHandler.this).currentStation.sID, (long)n5);
                SeekActiveContentHandler.this.dsi.setSeekCommand(((SeekActiveContentHandler)SeekActiveContentHandler.this).currentStation.sID, n5, 1);
                SeekActiveContentHandler.this.models.getLabelModel(100670).setText(string);
                SeekActiveContentHandler.this.varExt.showPartialPopup(n4);
            }
        }
    }

    private class DsiDownListener
    extends SDARSDsiDownInfo {
        private DsiDownListener() {
        }

        public void preTuneAction(StationInfoExt stationInfoExt) {
            SeekActiveContentHandler.this.adjustSeekTypeModel(-1);
        }
    }

    private class ActionProxyListener
    extends TunerActionProxyListener {
        private ActionProxyListener() {
        }

        public void sdarsReplaceListLeft() {
            SeekActiveContentHandler.this.cancelReplace();
        }

        public void hmiDeactivatedTuner() {
            SeekActiveContentHandler.this.cancelReplace();
        }
    }

    private class CancelButtonListener
    extends DefaultButtonListener {
        private CancelButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            SeekActiveContentHandler.this.cancelReplace();
        }
    }

    private class ReplaceButtonListener
    extends DefaultButtonListener {
        private ReplaceButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            if (SeekActiveContentHandler.this.overflowSeek != null) {
                SeekActiveContentHandler.this.varExt.hidePartialPopup(17);
                switch (SeekActiveContentHandler.this.overflowSeek.getTypeOfContent()) {
                    case 1: {
                        SeekActiveContentHandler.this.varExt.showPartialPopup(19);
                        break;
                    }
                    case 2: 
                    case 3: {
                        SeekActiveContentHandler.this.varExt.showPartialPopup(20);
                        break;
                    }
                }
            }
        }
    }

    private class FavoriteReplaceListListener
    extends DefaultBaseListModelListener {
        private FavoriteReplaceListListener() {
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            SeekActiveContentHandler.this.models.getBaseListModel(100750).setSelectedIndex(n2);
            SeekActiveContentHandler.this.models.getBaseListModel(100750).fireEvent(n4);
            SeekActiveContentHandler.this.varExt.hidePartialPopup(19);
            SeekActiveContentHandler.this.varExt.hidePartialPopup(20);
            if (SeekActiveContentHandler.this.overflowSeek != null) {
                if (SeekActiveContentHandler.this.overflowSeek.getTypeOfContent() == 1) {
                    MusicHandler.MusicSeekRow musicSeekRow = (MusicHandler.MusicSeekRow)evoListRow;
                    SeekActiveContentHandler.this.dsi.manageSeek2(1, musicSeekRow.getSeekID(), -1, 3);
                    SeekActiveContentHandler.this.varExt.showPartialPopup(SeekActiveContentHandler.this.relacementFinishedPopupId);
                } else if (SeekActiveContentHandler.this.overflowSeek.getTypeOfContent() == 3) {
                    SelectedTeamRow selectedTeamRow = (SelectedTeamRow)evoListRow;
                    SeekActiveContentHandler.this.dsi.manageSeek2(3, selectedTeamRow.getTeamID(), selectedTeamRow.getLeagueId(), 3);
                    SeekActiveContentHandler.this.varExt.showPartialPopup(15);
                }
                SeekActiveContentHandler.this.overflowSeek = null;
            }
        }
    }
}

