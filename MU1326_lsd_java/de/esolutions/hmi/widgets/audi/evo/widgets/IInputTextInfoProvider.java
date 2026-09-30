/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

public interface IInputTextInfoProvider {
    public boolean isEmpty();

    public String getCurrentWord();

    public String getCurrentText();

    public boolean isStartOfText();

    public boolean isStartOfWord();

    public int getKeyboardType();

    public String getCurrentDisplayString();

    public int getTextLength();
}

