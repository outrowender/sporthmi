/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.TextListCell;

public class EmptyTextListCell
extends TextListCell {
    static final TextListCell INSTANCE = new EmptyTextListCell();

    private EmptyTextListCell() {
        super("");
    }

    public void setText(String string) {
        throw new IllegalArgumentException("Changing text of EmptyTextListCell not allowed!");
    }
}

