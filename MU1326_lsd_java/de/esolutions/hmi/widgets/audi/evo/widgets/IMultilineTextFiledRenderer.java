/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;

public interface IMultilineTextFiledRenderer
extends IRenderer {
    public int getCharWidth(char var1);

    public int getStringW(String var1);

    public int getLineHeight();

    public int getLineOffsetY();

    public int getYTranslation();

    public float getAbsLineIdxPos(int var1);

    public int getTextLength(String var1);
}

