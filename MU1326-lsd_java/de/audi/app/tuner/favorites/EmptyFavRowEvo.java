/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.favorites;

import de.audi.app.tuner.RadioRowProperties;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.memory.EmptyMemoryRow;

public class EmptyFavRowEvo
extends EmptyMemoryRow {
    private static final int INDEX_PROPERTIES;
    private static final int INDEX_DEFAULT_IMAGE_ID;
    private static final int INDEX_PRESET_POS;
    public static final int NUM_COLS;
    private final RadioRowProperties props;

    public EmptyFavRowEvo(int n) {
        super(23);
        this.props = new RadioRowProperties();
        this.props.setCategory(1688373834);
        this.setPropertyCell(14, new PropertyListCell(this.props.getCategory(), this.props.toArray()));
        this.setInteger(15, 2);
        this.setInteger(16, Utilities.adjustPresetPosForNar(n + 1));
    }

    private EmptyFavRowEvo(EmptyFavRowEvo emptyFavRowEvo) {
        super(emptyFavRowEvo);
        this.props = emptyFavRowEvo.props;
    }

    @Override
    public EvoListRow copy() {
        return new EmptyFavRowEvo(this);
    }
}

