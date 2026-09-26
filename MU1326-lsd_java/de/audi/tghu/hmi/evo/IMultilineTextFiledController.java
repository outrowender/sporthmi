/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.tghu.hmi.evo.IMultilineWidget;

public interface IMultilineTextFiledController
extends IMultilineWidget {
    public static final int CURSOR_DIR_LEFT;
    public static final int CURSOR_DIR_RIGHT;
    public static final int CURSOR_MODE_WORD;
    public static final int CURSOR_MODE_CHAR;

    default public void moveCursor(int n) {
    }

    default public void setCursorMode(int n) {
    }

    default public void delete() {
    }

    default public void insertChar(char c2) {
    }

    default public void insertStr(String string) {
    }

    default public void replaceStr(String string) {
    }
}

