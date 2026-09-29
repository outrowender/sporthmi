/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.utils;

import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.atip.hmi.model.texteditor.DoubleCursor;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.TextEditorModelDDApp;
import de.audi.atip.log.LogChannel;
import java.util.LinkedList;

public class EditorModelHandler {
    public static final int CURSOR_POSITION_BEGINNING;
    public static final int CURSOR_POSITION_END;
    private final TextEditorModelDDApp editorModel;
    private final ChoiceModelApp editorInputMode;
    private LinkedList lastReceivedText;
    private LogChannel lc = Logger.getMainLog();

    public EditorModelHandler(TextEditorModelDDApp textEditorModelDDApp, ChoiceModelApp choiceModelApp, LogChannel logChannel) {
        this.editorModel = textEditorModelDDApp;
        this.editorInputMode = choiceModelApp;
        if (logChannel != null) {
            this.lc = logChannel;
        }
    }

    public void clearText() {
        this.lc.log(-2137614336, "EditorModelHandler#clearText() called");
        this.editorModel.clear();
    }

    public void setText(LinkedList linkedList) {
        this.lc.log(-2137614336, "EditorModelHandler#setText() called");
        if (SDSUtils.isEmpty(linkedList)) {
            this.lc.log(-2137614336, "EditorModelHandler#setText(): empty text -> clearBody!");
            this.editorModel.clear();
            return;
        }
        try {
            this.lastReceivedText = linkedList;
            this.editorModel.setText(SDSUtils.convertToStringArray(linkedList), -1);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(-1601830656, "EditorModelHandler#setText() Exception %1 failed because of bad text format: %2", (Object)classCastException.toString(), (Object)classCastException.getMessage());
        }
    }

    public void resetText() {
        this.setText(this.lastReceivedText);
    }

    public void appendText(LinkedList linkedList) {
        String[][] stringArray = null;
        try {
            stringArray = SDSUtils.convertToStringArray(linkedList);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(-1601830656, "EditorModelHandler#appendText() Exception %1 failed because of bad text format: %2", (Object)classCastException.toString(), (Object)classCastException.getMessage());
        }
        DoubleCursor doubleCursor = this.editorModel.getCursor();
        int n = doubleCursor.getCursorPos();
        String string = doubleCursor.current();
        int n2 = doubleCursor.length();
        this.printTextStatus("EditorModelHandler#appendText()");
        if (n == 0 || SDSUtils.isEmpty(string) || SDSUtils.isEmpty(string.trim())) {
            doubleCursor.insertWords(stringArray);
        } else {
            String string2;
            do {
                int[] nArray = doubleCursor.next();
                int n3 = doubleCursor.getCursorPos();
                string2 = doubleCursor.current();
                if (n3 != doubleCursor.length() && nArray[0] != -1) continue;
                doubleCursor.insertWord(" ");
                doubleCursor.insertWords(stringArray);
                return;
            } while (!SDSUtils.isEmpty(string2.trim()));
            doubleCursor.insertWords(stringArray);
        }
        if (n2 > 0) {
            doubleCursor.insertWord(" ");
        }
        this.printTextStatus("EditorModelHandler#appendText() after insertion");
    }

    private void printTextStatus(String string) {
        DoubleCursor doubleCursor = this.editorModel.getCursor();
        int n = doubleCursor.getCursorPos();
        String string2 = doubleCursor.current();
        this.lc.log(-2137614336, "%1: cursor=%2, cursor.current()=%3, position=%4!", (Object)string, (Object)doubleCursor, (Object)string2, (long)n);
        this.lc.log(-2137614336, "%1: %2!", (Object)string, (Object)this.editorModel.getText());
    }

    public void replaceSelectedWord(LinkedList linkedList) {
        this.printTextStatus("EditorModelHandler#replaceSelectedWord() before:");
        try {
            String[][] stringArray = SDSUtils.convertToStringArray(linkedList);
            this.lc.log(-2137614336, "EditorModelHandler#replaceSelectedWord() replace with %1", (Object)SDSUtils.toString(stringArray));
            this.editorModel.getCursor().replace(stringArray);
        }
        catch (ClassCastException classCastException) {
            this.lc.log(-1601830656, "EditorModelHandler#replaceSelectedWord() Exception %1 failed because of bad text format: %2", (Object)classCastException.toString(), (Object)classCastException.getMessage());
        }
        this.printTextStatus("EditorModelHandler#replaceSelectedWord() after:");
    }

    public boolean undoLastInsertion() {
        this.lc.log(-2137614336, "EditorModelHandler#undoLastInsertion() called");
        int n = this.editorModel.getText().length();
        this.editorModel.undoLastInsertion();
        int n2 = this.editorModel.getText().length();
        this.lc.log(-2137614336, "EditorModelHandler#undoLastInsertion(), lengthBefore=%1, lengthAfter=%2", (long)n, (long)n2);
        return n != n2;
    }

    public void positionCursor(int n) {
        DoubleCursor doubleCursor = this.editorModel.getCursor();
        if (doubleCursor == null) {
            return;
        }
        this.lc.log(-2137614336, "EditorModelHandler#positionCursor() cursor=%1 to position %2", (Object)doubleCursor.currentIdx(), (long)n);
        switch (n) {
            case 1: {
                doubleCursor.setCursorPos(doubleCursor.length());
                doubleCursor.setCursorMode(0);
                break;
            }
            default: {
                doubleCursor.setCursorPos(0);
                doubleCursor.setCursorMode(0);
            }
        }
    }

    public boolean areAlternativesOpen() {
        return this.editorInputMode.getValue() == 1;
    }
}

