/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.multiline;

public interface FastDeleteHelper {
    public int getWordLength();

    public boolean isEditMode();

    public boolean deleteOneChar();

    public void deleteWordIncludingPrecedingWhitespaces();

    public int getTextLength();

    public boolean lock();

    public void unlock();
}

