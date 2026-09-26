/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.EmptyTextListCell;
import de.audi.atip.hmi.model.ListCell;

public class TextListCell
implements ListCell {
    private String text;

    public static TextListCell create(String string) {
        if (string == null || string.length() == 0) {
            return EmptyTextListCell.INSTANCE;
        }
        return new TextListCell(string);
    }

    public TextListCell(String string) {
        this.text = string;
    }

    public void setText(String string) {
        this.text = string;
    }

    public String getText() {
        return this.text;
    }

    public String toString() {
        return this.text;
    }

    public boolean equals(Object object) {
        if (object == null || !(object instanceof TextListCell)) {
            return false;
        }
        String string = ((TextListCell)object).text;
        if (this.text == null) {
            return this.text == null && string == null;
        }
        return this.text.equals(string);
    }

    public int hashCode() {
        return this.text == null ? 0 : this.text.hashCode();
    }
}

