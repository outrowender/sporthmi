/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;

public interface IMultilineTextFiledRenderer
extends IRenderer {
    default public int getCharWidth(char c2) {
    }

    default public int getStringW(String string) {
    }

    default public int getLineHeight() {
    }

    default public int getLineOffsetY() {
    }

    default public int getYTranslation() {
    }

    default public float getAbsLineIdxPos(int n) {
    }

    default public int getTextLength(String string) {
    }
}

