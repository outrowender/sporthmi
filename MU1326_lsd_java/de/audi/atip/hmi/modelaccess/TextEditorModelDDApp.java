/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.TextEditorListenerDD;
import de.audi.atip.hmi.model.texteditor.DoubleCursor;
import de.audi.atip.hmi.modelaccess.ICopyTo;

public interface TextEditorModelDDApp
extends ICopyTo {
    public static final int CURSOR_POS_START;
    public static final int CURSOR_POS_DEFAULT;
    public static final int CURSOR_POS_END;
    public static final int CURSOR_POS_OLD;
    public static final int NO_TEXT_LENGHT_LIMIT;
    public static final int MODE_EDIT;
    public static final int MODE_READ_ONLY;

    default public void resetListener() {
    }

    default public void setListener(TextEditorListenerDD textEditorListenerDD) {
    }

    default public void addListener(TextEditorListenerDD textEditorListenerDD) {
    }

    default public void removeListener(TextEditorListenerDD textEditorListenerDD) {
    }

    default public boolean setText(String[][] stringArray, int n) {
    }

    default public boolean setText(String string, int n) {
    }

    default public boolean replace(String[][] stringArray) {
    }

    default public boolean replace(String string) {
    }

    default public boolean append(String[][] stringArray, int n) {
    }

    default public boolean append(String string, int n) {
    }

    default public String getLastInsertion() {
    }

    default public boolean undoLastInsertion() {
    }

    default public String getText() {
    }

    default public String getSelectedWord() {
    }

    default public String[] getAlternatives() {
    }

    default public boolean selectAlternative(int n) {
    }

    default public void clear() {
    }

    default public DoubleCursor getCursor() {
    }

    default public TextEditorModelDDApp getSyncedModel() {
    }

    default public void setMaxLength(int n) {
    }

    default public int getMaxLength() {
    }

    default public boolean lock() {
    }

    default public void unlock() {
    }

    default public String validityCheck() {
    }

    default public boolean insert(String string) {
    }

    default public boolean insert(String[] stringArray) {
    }

    default public boolean insert(String[][] stringArray) {
    }

    default public void remove(int n, int n2, int n3) {
    }

    default public void setMode(int n) {
    }
}

