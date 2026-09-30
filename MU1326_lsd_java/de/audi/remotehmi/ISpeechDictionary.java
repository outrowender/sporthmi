/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi;

import java.util.List;

public interface ISpeechDictionary {
    public static final int type = 2;

    public List getDictionaryEntries();

    public String getId();

    public String getLanguage();

    public String getFormat();

    public int getType();
}

