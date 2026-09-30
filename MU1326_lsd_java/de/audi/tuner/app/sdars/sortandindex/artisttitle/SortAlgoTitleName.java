/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.sortandindex.artisttitle;

import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.sdars.ArtistTitleRow;
import de.audi.tuner.app.sdars.sortandindex.artisttitle.AbstractArtistTitleComparatorAndIndexer;
import java.text.Collator;

public class SortAlgoTitleName
extends AbstractArtistTitleComparatorAndIndexer {
    public SortAlgoTitleName(LanguageManager languageManager) {
        super(languageManager, true);
    }

    protected String getStringUsedForIndexing(ArtistTitleRow artistTitleRow) {
        return artistTitleRow.getRadioText().longProgramTitle;
    }

    protected int compare(ArtistTitleRow artistTitleRow, ArtistTitleRow artistTitleRow2, Collator collator) {
        int n = collator.compare(artistTitleRow.getRadioText().longProgramTitle, artistTitleRow2.getRadioText().longProgramTitle);
        if (n != 0) {
            return n;
        }
        n = collator.compare(artistTitleRow.getRadioText().longArtistName, artistTitleRow2.getRadioText().longArtistName);
        if (n != 0) {
            return n;
        }
        return artistTitleRow.getStation().stationNumber - artistTitleRow2.getStation().stationNumber;
    }
}

