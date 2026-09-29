/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.sortandindex.artisttitle;

import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.sdars.ArtistTitleRow;
import de.audi.tuner.app.sortandindex.AbstractComparatorAndIndexer;
import java.text.Collator;

public abstract class AbstractArtistTitleComparatorAndIndexer
extends AbstractComparatorAndIndexer {
    protected AbstractArtistTitleComparatorAndIndexer(LanguageManager languageManager, boolean bl) {
        super(languageManager, bl);
    }

    @Override
    protected String getStringUsedForIndexing(Object object) {
        return this.getStringUsedForIndexing((ArtistTitleRow)object);
    }

    @Override
    protected int compare(Object object, Object object2, Collator collator) {
        return this.compare((ArtistTitleRow)object, (ArtistTitleRow)object2, collator);
    }

    protected abstract String getStringUsedForIndexing(ArtistTitleRow artistTitleRow) {
    }

    protected abstract int compare(ArtistTitleRow artistTitleRow, ArtistTitleRow artistTitleRow2, Collator collator) {
    }
}

