/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.DefaultOptionListener;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.OptionModelApp;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.sdars.dsi.SDARSDSISeekDownManager;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.ifc.ITunerVariantExt;
import java.util.Arrays;
import org.dsi.ifc.sdars.SeekEntry;

public class MusicHandler {
    public final DsiUpListener dsiUpListener = new DsiUpListener();
    private final SDARSDSISeekDownManager seekDsi;
    private final TunerModels models;
    private final ITunerVariantExt variantExt;
    private static final int MUSIC_SEEK_OPT_ID = 0;
    private final BaseListModelApp musicSeekSetupList;
    private final Object mutex = new Object();
    private int markedArtistTitleEntryCount = 0;

    public MusicHandler(TunerBasics tunerBasics, SDARSDSISeekDownManager sDARSDSISeekDownManager, ITunerVariantExt iTunerVariantExt) {
        this.seekDsi = sDARSDSISeekDownManager;
        this.models = tunerBasics.getModels();
        this.variantExt = iTunerVariantExt;
        TunerModels tunerModels = tunerBasics.getModels();
        this.musicSeekSetupList = tunerModels.getBaseListModel(100483);
        this.musicSeekSetupList.setListener(new ListModelListener());
        OptionModelApp optionModelApp = tunerModels.getOptionModel(100658);
        optionModelApp.setListener(new OptionModelListener(), this.musicSeekSetupList.getID());
        tunerModels.getButtonModel(100656).setButtonListener(new ButtonListener());
        MusicSeekListControllerButtonListener musicSeekListControllerButtonListener = new MusicSeekListControllerButtonListener();
        tunerModels.getButtonModel(100699).setButtonListener(musicSeekListControllerButtonListener);
        tunerModels.getButtonModel(100697).setButtonListener(musicSeekListControllerButtonListener);
        tunerModels.getButtonModel(100698).setButtonListener(musicSeekListControllerButtonListener);
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
                MusicSeekRow musicSeekRow = new MusicSeekRow(seekEntry.seekID, seekEntry.title1, seekEntry.title2);
                musicSeekRow.setMarkingCheckboxSelected(false);
                musicSeekRow.setActivationCheckboxSelected(seekEntry.seekActive);
                baseListModelApp.append(musicSeekRow);
                bl = true;
            }
            this.musicSeekSetupList.update(baseListModelApp);
            this.markedArtistTitleEntryCount = 0;
            this.updateArtistTitleControllerButtons();
            this.models.getChoiceModel(100681).setValue(bl ? 1 : 0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void onOptionDeleteCurrentMusicAlert(OptionModelApp optionModelApp, int n, int n2) {
        MusicSeekRow musicSeekRow = null;
        Object object = this.mutex;
        synchronized (object) {
            musicSeekRow = (MusicSeekRow)this.musicSeekSetupList.getRow(n);
            if (musicSeekRow != null) {
                this.musicSeekSetupList.remove(musicSeekRow);
            }
        }
        if (musicSeekRow != null) {
            this.seekDsi.manageSeek2(1, musicSeekRow.getSeekID(), 0, 3);
            optionModelApp.fireEvent(n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void onItemSelectedInSeekSetupList(int n) {
        MusicSeekRow musicSeekRow = null;
        Object object = this.mutex;
        synchronized (object) {
            musicSeekRow = (MusicSeekRow)this.musicSeekSetupList.getRow(n);
            if (musicSeekRow != null) {
                if (Utilities.isPGen1OrBentley()) {
                    this.markedArtistTitleEntryCount += musicSeekRow.toggleMarkCheckbox();
                    this.updateArtistTitleControllerButtons();
                } else {
                    musicSeekRow.toggleActivationCheckbox();
                    int n2 = musicSeekRow.isActivationCheckboxSelected() ? 1 : 2;
                    this.seekDsi.manageSeek2(1, musicSeekRow.getSeekID(), 0, n2);
                }
                this.musicSeekSetupList.setRow(n, musicSeekRow);
            }
        }
    }

    private void updateArtistTitleControllerButtons() {
        ButtonModelApp buttonModelApp = this.models.getButtonModel(100698);
        ButtonModelApp buttonModelApp2 = this.models.getButtonModel(100699);
        ButtonModelApp buttonModelApp3 = this.models.getButtonModel(100697);
        int n = this.musicSeekSetupList.getLength() - this.markedArtistTitleEntryCount;
        buttonModelApp.setStatus(this.markedArtistTitleEntryCount > 0 ? 1 : 3);
        buttonModelApp3.setStatus(this.markedArtistTitleEntryCount > 0 ? 1 : 3);
        buttonModelApp2.setStatus(n > 0 ? 1 : 3);
        LabelModelApp labelModelApp = this.models.getLabelModel(100765);
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
                nArray[i2] = ((MusicSeekRow)this.musicSeekSetupList.getRow(i2)).getSeekID();
            }
        }
        this.deleteMusicSeeks(nArray);
    }

    private void deleteMusicSeeks(int[] nArray) {
        int[] nArray2 = new int[nArray.length];
        Arrays.fill(nArray2, 0);
        this.seekDsi.bulkManageSeek2(1, nArray, nArray2, 3);
    }

    public static class MusicSeekRow
    extends EvoListRow {
        private static final int INDEX_RECORDSET = 0;
        private static final int INDEX_ARTIST = 1;
        private static final int INDEX_SONG = 2;
        private static final int INDEX_CHECKBOX = 3;
        private static final int INDEX_SEEK_ID = 4;
        private static final int INDEX_ARTIST_SONG_SEPARATOR_CHAR = 5;
        private static final int INDEX_PROPERTIES = 6;
        private static final int INDEX_CHECKBOX_MARKING = 7;
        private static final int COLUMN_COUNT = 8;
        private static final int RECORDSET_ARTIST_ONLY = 0;
        private static final int RECORDSET_ARTIST_AND_SONG = 1;

        private MusicSeekRow(int n, String string, String string2) {
            super(n, 8);
            int n2 = 0;
            if (!Utilities.isEmpty(string2)) {
                n2 = 1;
            }
            this.setInteger(0, n2);
            this.setText(1, string);
            this.setText(2, string2);
            this.setInteger(4, n);
            this.setInteger(3, 0);
            this.setInteger(7, 0);
            if (Utilities.isEmpty(string) || Utilities.isEmpty(string2)) {
                this.setText(5, "");
            } else {
                this.setText(5, "-");
            }
            this.setPropertyCell(6, new PropertyListCell(0, new int[0]));
        }

        private MusicSeekRow(MusicSeekRow musicSeekRow) {
            super(musicSeekRow);
        }

        public EvoListRow copy() {
            return new MusicSeekRow(this);
        }

        public int getSeekID() {
            return this.getInteger(4);
        }

        public void setActivationCheckboxSelected(boolean bl) {
            int n = TunerModels.booleanToCheckboxConstant(bl);
            this.setInteger(3, n);
        }

        public boolean isActivationCheckboxSelected() {
            return TunerModels.checkboxConstantToBoolean(this.getInteger(3));
        }

        private void toggleActivationCheckbox() {
            this.setActivationCheckboxSelected(!this.isActivationCheckboxSelected());
        }

        public int setMarkingCheckboxSelected(boolean bl) {
            int n = this.getInteger(7);
            int n2 = TunerModels.booleanToCheckboxConstant(bl);
            this.setInteger(7, n2);
            if (n != n2) {
                return bl ? 1 : -1;
            }
            return 0;
        }

        public boolean isMarkingCheckboxSelected() {
            return TunerModels.checkboxConstantToBoolean(this.getInteger(7));
        }

        private int toggleMarkCheckbox() {
            return this.setMarkingCheckboxSelected(!this.isMarkingCheckboxSelected());
        }
    }

    private class DsiUpListener
    extends SDARSDsiUpInfo {
        private DsiUpListener() {
        }

        public void updateSeekList(SeekEntry[] seekEntryArray) {
            MusicHandler.this.onDSIUpdateSeekList(seekEntryArray);
        }
    }

    private class ButtonListener
    extends DefaultButtonListener {
        private ButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            MusicHandler.this.onButtonClearMusicAlertsTyped();
        }
    }

    private class ListModelListener
    extends DefaultBaseListModelListener {
        private ListModelListener() {
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            MusicHandler.this.onItemSelectedInSeekSetupList(n2);
        }
    }

    private class OptionModelListener
    extends DefaultOptionListener {
        private OptionModelListener() {
        }

        public void keyTyped(int n, int n2, int n3, int n4, int n5) {
            MusicHandler.this.onOptionDeleteCurrentMusicAlert(MusicHandler.this.models.getOptionModel(n), n3, n5);
        }
    }

    private class MusicSeekListControllerButtonListener
    extends DefaultButtonListener {
        private MusicSeekListControllerButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            switch (n) {
                case 100699: {
                    this.setAllEntriesMarked(true);
                    break;
                }
                case 100697: {
                    this.setAllEntriesMarked(false);
                    break;
                }
                case 100698: {
                    this.deleteMarkedEntries();
                    break;
                }
            }
        }

        private void setAllEntriesMarked(boolean bl) {
            BaseListModelApp baseListModelApp = MusicHandler.this.musicSeekSetupList;
            for (int i2 = 0; i2 < baseListModelApp.getLength(); ++i2) {
                MusicSeekRow musicSeekRow = (MusicSeekRow)baseListModelApp.getRow(i2);
                MusicHandler.this.markedArtistTitleEntryCount += musicSeekRow.setMarkingCheckboxSelected(bl);
                baseListModelApp.setRow(i2, musicSeekRow);
            }
            MusicHandler.this.updateArtistTitleControllerButtons();
        }

        private void deleteMarkedEntries() {
            BaseListModelApp baseListModelApp = MusicHandler.this.musicSeekSetupList;
            int[] nArray = new int[baseListModelApp.getLength()];
            int n = 0;
            int n2 = baseListModelApp.getLength();
            for (int i2 = 0; i2 < baseListModelApp.getLength(); ++i2) {
                MusicSeekRow musicSeekRow = (MusicSeekRow)baseListModelApp.getRow(i2);
                if (!musicSeekRow.isMarkingCheckboxSelected()) continue;
                nArray[n++] = musicSeekRow.getSeekID();
            }
            int[] nArray2 = new int[n];
            System.arraycopy((Object)nArray, 0, (Object)nArray2, 0, n);
            MusicHandler.this.deleteMusicSeeks(nArray2);
            if (n2 == n) {
                baseListModelApp.fireEvent(0);
                MusicHandler.this.variantExt.showPartialPopup(4);
            }
        }
    }
}

