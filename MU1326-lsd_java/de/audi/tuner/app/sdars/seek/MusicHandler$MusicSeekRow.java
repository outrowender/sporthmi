/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.sdars.seek.MusicHandler$1;

public class MusicHandler$MusicSeekRow
extends EvoListRow {
    private static final int INDEX_RECORDSET;
    private static final int INDEX_ARTIST;
    private static final int INDEX_SONG;
    private static final int INDEX_CHECKBOX;
    private static final int INDEX_SEEK_ID;
    private static final int INDEX_ARTIST_SONG_SEPARATOR_CHAR;
    private static final int INDEX_PROPERTIES;
    private static final int INDEX_CHECKBOX_MARKING;
    private static final int COLUMN_COUNT;
    private static final int RECORDSET_ARTIST_ONLY;
    private static final int RECORDSET_ARTIST_AND_SONG;

    private MusicHandler$MusicSeekRow(int n, String string, String string2) {
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

    private MusicHandler$MusicSeekRow(MusicHandler$MusicSeekRow musicHandler$MusicSeekRow) {
        super(musicHandler$MusicSeekRow);
    }

    @Override
    public EvoListRow copy() {
        return new MusicHandler$MusicSeekRow(this);
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

    /* synthetic */ MusicHandler$MusicSeekRow(int n, String string, String string2, MusicHandler$1 musicHandler$1) {
        this(n, string, string2);
    }

    static /* synthetic */ int access$600(MusicHandler$MusicSeekRow musicHandler$MusicSeekRow) {
        return musicHandler$MusicSeekRow.toggleMarkCheckbox();
    }

    static /* synthetic */ void access$700(MusicHandler$MusicSeekRow musicHandler$MusicSeekRow) {
        musicHandler$MusicSeekRow.toggleActivationCheckbox();
    }
}

