/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.combi;

import de.audi.atip.hmi.combi.AbstractCombiElement;
import de.esolutions.fw.util.commons.Buffer;

public class CombiCursorBarElement
extends AbstractCombiElement {
    public int position;
    public boolean showCursor;
    public boolean showArrowUp;
    public boolean showArrowDown;
    public int animationStyle;
    public boolean sliderVisible;
    public int sliderLength;
    public int sliderPosition;

    public final void copyTo(CombiCursorBarElement combiCursorBarElement) {
        super.copyTo(combiCursorBarElement);
        combiCursorBarElement.position = this.position;
        combiCursorBarElement.showCursor = this.showCursor;
        combiCursorBarElement.showArrowUp = this.showArrowUp;
        combiCursorBarElement.showArrowDown = this.showArrowDown;
        combiCursorBarElement.sliderVisible = this.sliderVisible;
        combiCursorBarElement.sliderLength = this.sliderLength;
        combiCursorBarElement.sliderPosition = this.sliderPosition;
        combiCursorBarElement.animationStyle = this.animationStyle;
    }

    public void reset() {
        this.position = 0;
        this.showCursor = false;
        this.showArrowUp = false;
        this.showArrowDown = false;
        this.animationStyle = 0;
        this.sliderVisible = false;
        this.sliderLength = 0;
        this.sliderPosition = 0;
        this.dirty = true;
        this.setMergingAllowed(true);
    }

    public short getStyle() {
        if (!this.showCursor) {
            return 240;
        }
        return (short)(this.animationStyle + (this.showArrowUp ? 1 : 0) + (this.showArrowDown ? 2 : 0));
    }

    public short getSliderLengthAndVisibility() {
        return this.sliderVisible ? (short)(128 + this.sliderLength) : (short)0;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("pos: ").append(this.position);
        buffer.append(" | visible: ").append(this.showCursor);
        buffer.append(" | up: ").append(this.showArrowUp);
        buffer.append(" | down: ").append(this.showArrowDown);
        buffer.append(" | style: ").append(Integer.toBinaryString(this.animationStyle));
        return buffer.toString();
    }
}

