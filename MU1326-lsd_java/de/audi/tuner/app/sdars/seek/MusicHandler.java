/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.OptionModelApp;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.sdars.dsi.SDARSDSISeekDownManager;
import de.audi.tuner.app.sdars.seek.MusicHandler$ButtonListener;
import de.audi.tuner.app.sdars.seek.MusicHandler$DsiUpListener;
import de.audi.tuner.app.sdars.seek.MusicHandler$ListModelListener;
import de.audi.tuner.app.sdars.seek.MusicHandler$MusicSeekListControllerButtonListener;
import de.audi.tuner.app.sdars.seek.MusicHandler$MusicSeekRow;
import de.audi.tuner.app.sdars.seek.MusicHandler$OptionModelListener;
import de.audi.tuner.ifc.ITunerVariantExt;
import java.util.Arrays;
import org.dsi.ifc.sdars.SeekEntry;

public class MusicHandler {
    public final MusicHandler$DsiUpListener dsiUpListener = new MusicHandler$DsiUpListener(this, null);
    private final SDARSDSISeekDownManager seekDsi;
    private final TunerModels models;
    private final ITunerVariantExt variantExt;
    private static final int MUSIC_SEEK_OPT_ID;
    private final BaseListModelApp musicSeekSetupList;
    private final Object mutex = new Object();
    private int markedArtistTitleEntryCount = 0;

    public MusicHandler(TunerBasics tunerBasics, SDARSDSISeekDownManager sDARSDSISeekDownManager, ITunerVariantExt iTunerVariantExt) {
        this.seekDsi = sDARSDSISeekDownManager;
        this.models = tunerBasics.getModels();
        this.variantExt = iTunerVariantExt;
        TunerModels tunerModels = tunerBasics.getModels();
        this.musicSeekSetupList = tunerModels.getBaseListModel(-2088238848);
        this.musicSeekSetupList.setListener(new MusicHandler$ListModelListener(this, null));
        OptionModelApp optionModelApp = tunerModels.getOptionModel(847839488);
        optionModelApp.setListener(new MusicHandler$OptionModelListener(this, null), this.musicSeekSetupList.getID());
        tunerModels.getButtonModel(814285056).setButtonListener(new MusicHandler$ButtonListener(this, null));
        MusicHandler$MusicSeekListControllerButtonListener musicHandler$MusicSeekListControllerButtonListener = new MusicHandler$MusicSeekListControllerButtonListener(this, null);
        tunerModels.getButtonModel(1535705344).setButtonListener(musicHandler$MusicSeekListControllerButtonListener);
        tunerModels.getButtonModel(1502150912).setButtonListener(musicHandler$MusicSeekListControllerButtonListener);
        tunerModels.getButtonModel(1518928128).setButtonListener(musicHandler$MusicSeekListControllerButtonListener);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void onDSIUpdateSeekList(SeekEntry[] seekEntryArray) {
        boolean bl = false;
        BaseListModelApp baseListModelApp = this.musicSeekSetupList.getEmptyCopy();
        Object object = this.mutex;
        synchronized (object) {
            for (int i2 = 0; i2 < seekEntryArray.length; ++i2) {
                SeekEntry seekEntry = seekEntryArray[i2];
                if (seekEntry.typeOfContent != 1) continue;
                MusicHandler$MusicSeekRow musicHandler$MusicSeekRow = new MusicHandler$MusicSeekRow(seekEntry.seekID, seekEntry.title1, seekEntry.title2, null);
                musicHandler$MusicSeekRow.setMarkingCheckboxSelected(false);
                musicHandler$MusicSeekRow.setActivationCheckboxSelected(seekEntry.seekActive);
                baseListModelApp.append(musicHandler$MusicSeekRow);
                bl = true;
            }
            this.musicSeekSetupList.update(baseListModelApp);
            this.markedArtistTitleEntryCount = 0;
            this.updateArtistTitleControllerButtons();
            this.models.getChoiceModel(1233715456).setValue(bl ? 1 : 0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void onOptionDeleteCurrentMusicAlert(OptionModelApp optionModelApp, int n, int n2) {
        MusicHandler$MusicSeekRow musicHandler$MusicSeekRow = null;
        Object object = this.mutex;
        synchronized (object) {
            musicHandler$MusicSeekRow = (MusicHandler$MusicSeekRow)this.musicSeekSetupList.getRow(n);
            if (musicHandler$MusicSeekRow != null) {
                this.musicSeekSetupList.remove(musicHandler$MusicSeekRow);
            }
        }
        if (musicHandler$MusicSeekRow != null) {
            this.seekDsi.manageSeek2(1, musicHandler$MusicSeekRow.getSeekID(), 0, 3);
            optionModelApp.fireEvent(n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void onItemSelectedInSeekSetupList(int n) {
        MusicHandler$MusicSeekRow musicHandler$MusicSeekRow = null;
        Object object = this.mutex;
        synchronized (object) {
            musicHandler$MusicSeekRow = (MusicHandler$MusicSeekRow)this.musicSeekSetupList.getRow(n);
            if (musicHandler$MusicSeekRow != null) {
                if (Utilities.isPGen1OrBentley()) {
                    this.markedArtistTitleEntryCount += MusicHandler$MusicSeekRow.access$600(musicHandler$MusicSeekRow);
                    this.updateArtistTitleControllerButtons();
                } else {
                    MusicHandler$MusicSeekRow.access$700(musicHandler$MusicSeekRow);
                    int n2 = musicHandler$MusicSeekRow.isActivationCheckboxSelected() ? 1 : 2;
                    this.seekDsi.manageSeek2(1, musicHandler$MusicSeekRow.getSeekID(), 0, n2);
                }
                this.musicSeekSetupList.setRow(n, musicHandler$MusicSeekRow);
            }
        }
    }

    private void updateArtistTitleControllerButtons() {
        ButtonModelApp buttonModelApp = this.models.getButtonModel(1518928128);
        ButtonModelApp buttonModelApp2 = this.models.getButtonModel(1535705344);
        ButtonModelApp buttonModelApp3 = this.models.getButtonModel(1502150912);
        int n = this.musicSeekSetupList.getLength() - this.markedArtistTitleEntryCount;
        buttonModelApp.setStatus(this.markedArtistTitleEntryCount > 0 ? 1 : 3);
        buttonModelApp3.setStatus(this.markedArtistTitleEntryCount > 0 ? 1 : 3);
        buttonModelApp2.setStatus(n > 0 ? 1 : 3);
        LabelModelApp labelModelApp = this.models.getLabelModel(-1651965696);
        labelModelApp.setText(String.valueOf(this.markedArtistTitleEntryCount));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void onButtonClearMusicAlertsTyped() {
        int[] nArray;
        Object object = this.mutex;
        synchronized (object) {
            nArray = new int[this.musicSeekSetupList.getLength()];
            for (int i2 = 0; i2 < this.musicSeekSetupList.getLength(); ++i2) {
                nArray[i2] = ((MusicHandler$MusicSeekRow)this.musicSeekSetupList.getRow(i2)).getSeekID();
            }
        }
        this.deleteMusicSeeks(nArray);
    }

    private void deleteMusicSeeks(int[] nArray) {
        int[] nArray2 = new int[nArray.length];
        Arrays.fill(nArray2, 0);
        this.seekDsi.bulkManageSeek2(1, nArray, nArray2, 3);
    }

    static /* synthetic */ void access$800(MusicHandler musicHandler, SeekEntry[] seekEntryArray) {
        musicHandler.onDSIUpdateSeekList(seekEntryArray);
    }

    static /* synthetic */ TunerModels access$900(MusicHandler musicHandler) {
        return musicHandler.models;
    }

    static /* synthetic */ void access$1000(MusicHandler musicHandler, OptionModelApp optionModelApp, int n, int n2) {
        musicHandler.onOptionDeleteCurrentMusicAlert(optionModelApp, n, n2);
    }

    static /* synthetic */ void access$1100(MusicHandler musicHandler, int n) {
        musicHandler.onItemSelectedInSeekSetupList(n);
    }

    static /* synthetic */ void access$1200(MusicHandler musicHandler) {
        musicHandler.onButtonClearMusicAlertsTyped();
    }

    static /* synthetic */ BaseListModelApp access$1300(MusicHandler musicHandler) {
        return musicHandler.musicSeekSetupList;
    }

    static /* synthetic */ int access$1412(MusicHandler musicHandler, int n) {
        return musicHandler.markedArtistTitleEntryCount += n;
    }

    static /* synthetic */ void access$1500(MusicHandler musicHandler) {
        musicHandler.updateArtistTitleControllerButtons();
    }

    static /* synthetic */ void access$1600(MusicHandler musicHandler, int[] nArray) {
        musicHandler.deleteMusicSeeks(nArray);
    }

    static /* synthetic */ ITunerVariantExt access$1700(MusicHandler musicHandler) {
        return musicHandler.variantExt;
    }
}

