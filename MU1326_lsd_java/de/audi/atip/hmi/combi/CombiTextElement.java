/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.combi;

import de.audi.atip.hmi.combi.AbstractCombiElement;
import de.esolutions.fw.util.commons.Buffer;

public class CombiTextElement
extends AbstractCombiElement {
    public String text;
    public boolean highlighted = false;
    public boolean enabled = true;
    public boolean textChanged = false;
    public boolean fontChanged = false;
    public boolean deleteText = true;
    public int alignment = 0;
    public int font = 1;

    public final void setText(String string) {
        boolean bl = false;
        if (this.text != null) {
            if (string != null) {
                if (this.text.compareTo(string) != 0) {
                    bl = true;
                }
            } else {
                bl = true;
            }
        } else if (string != null) {
            bl = true;
        }
        if (bl) {
            this.text = string;
            this.dirty = true;
            this.textChanged = true;
        }
        this.deleteText = false;
    }

    public String getText() {
        return this.text;
    }

    public final void setHighlighted(boolean bl) {
        if (this.highlighted != bl) {
            this.highlighted = bl;
            this.dirty = true;
        }
    }

    public boolean isHighlighted() {
        return this.highlighted;
    }

    public void setEnabled(boolean bl) {
        if (this.enabled != bl) {
            this.dirty = true;
            this.enabled = bl;
        }
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setAlignment(int n) {
        if (this.alignment != n) {
            this.alignment = n;
            this.dirty = true;
        }
    }

    public int getAlignment() {
        return this.alignment;
    }

    public void setFont(int n) {
        if (this.font != n) {
            this.font = n;
            this.dirty = true;
            this.fontChanged = true;
        }
    }

    public int getFont() {
        return this.font;
    }

    public final void copyTo(CombiTextElement combiTextElement) {
        super.copyTo(combiTextElement);
        combiTextElement.text = this.text;
        combiTextElement.highlighted = this.highlighted;
        combiTextElement.textChanged = this.textChanged;
        combiTextElement.deleteText = this.deleteText;
        combiTextElement.enabled = this.enabled;
        combiTextElement.alignment = this.alignment;
        combiTextElement.font = this.font;
        combiTextElement.fontChanged = this.fontChanged;
        if (this.deleteText) {
            combiTextElement.dirty = true;
            this.text = null;
        }
    }

    @Override
    public void reset() {
        this.textChanged = false;
        if (this.text != null && this.text.length() > 0) {
            this.deleteText = true;
        }
        this.alignment = 0;
        this.fontChanged = false;
        this.setMergingAllowed(true);
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("text: ").append(this.text);
        buffer.append(" | enabled: ").append(this.enabled);
        buffer.append(" | highlighted: ").append(this.highlighted);
        buffer.append(" | textChanged: ").append(this.textChanged);
        buffer.append(" | alignment: ").append(this.alignment);
        buffer.append(" | font: ").append(this.font);
        buffer.append(" | fontChanged: ").append(this.fontChanged);
        return buffer.toString();
    }
}

