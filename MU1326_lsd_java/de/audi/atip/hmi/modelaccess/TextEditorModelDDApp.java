/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.TextEditorListenerDD;
import de.audi.atip.hmi.model.texteditor.DoubleCursor;
import de.audi.atip.hmi.modelaccess.ICopyTo;

public interface TextEditorModelDDApp
extends ICopyTo {
    public static final int CURSOR_POS_START = 0;
    public static final int CURSOR_POS_DEFAULT = -1;
    public static final int CURSOR_POS_END = -2;
    public static final int CURSOR_POS_OLD = -3;
    public static final int NO_TEXT_LENGHT_LIMIT = -1;
    public static final int MODE_EDIT = 0;
    public static final int MODE_READ_ONLY = 1;

    public void resetListener();

    public void setListener(TextEditorListenerDD var1);

    public void addListener(TextEditorListenerDD var1);

    public void removeListener(TextEditorListenerDD var1);

    public boolean setText(String[][] var1, int var2);

    public boolean setText(String var1, int var2);

    public boolean replace(String[][] var1);

    public boolean replace(String var1);

    public boolean append(String[][] var1, int var2);

    public boolean append(String var1, int var2);

    public String getLastInsertion();

    public boolean undoLastInsertion();

    public String getText();

    public String getSelectedWord();

    public String[] getAlternatives();

    public boolean selectAlternative(int var1);

    public void clear();

    public DoubleCursor getCursor();

    public TextEditorModelDDApp getSyncedModel();

    public void setMaxLength(int var1);

    public int getMaxLength();

    public boolean lock();

    public void unlock();

    public String validityCheck();

    public boolean insert(String var1);

    public boolean insert(String[] var1);

    public boolean insert(String[][] var1);

    public void remove(int var1, int var2, int var3);

    public void setMode(int var1);
}

