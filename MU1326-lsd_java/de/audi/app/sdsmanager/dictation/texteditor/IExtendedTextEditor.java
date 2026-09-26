/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.texteditor;

import de.audi.atip.hmi.modelaccess.TextEditorModelApp;
import java.util.LinkedList;

public interface IExtendedTextEditor {
    default public TextEditorModelApp getTextEditorModelApp() {
    }

    default public void editorTextChanged() {
    }

    default public void clear() {
    }

    default public void setText(String string) {
    }

    default public void setText(LinkedList linkedList, int n) {
    }

    default public void append(LinkedList linkedList) {
    }

    default public void undoAppend() {
    }

    default public void replaceSelection(LinkedList linkedList) {
    }
}

