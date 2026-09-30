/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.tghu.hmi.evo.IMultilineWidget;

public interface IMultilineTextFiledController
extends IMultilineWidget {
    public static final int CURSOR_DIR_LEFT = 0;
    public static final int CURSOR_DIR_RIGHT = 1;
    public static final int CURSOR_MODE_WORD = 0;
    public static final int CURSOR_MODE_CHAR = 1;

    public void moveCursor(int var1);

    public void setCursorMode(int var1);

    public void delete();

    public void insertChar(char var1);

    public void insertStr(String var1);

    public void replaceStr(String var1);
}

