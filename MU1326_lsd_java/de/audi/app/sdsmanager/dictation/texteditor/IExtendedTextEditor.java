/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.texteditor;

import de.audi.atip.hmi.modelaccess.TextEditorModelApp;
import java.util.LinkedList;

public interface IExtendedTextEditor {
    public TextEditorModelApp getTextEditorModelApp();

    public void editorTextChanged();

    public void clear();

    public void setText(String var1);

    public void setText(LinkedList var1, int var2);

    public void append(LinkedList var1);

    public void undoAppend();

    public void replaceSelection(LinkedList var1);
}

