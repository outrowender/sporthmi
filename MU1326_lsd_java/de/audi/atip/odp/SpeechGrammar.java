/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.odp;

import de.audi.atip.odp.SpeechGrammarListItem;

public class SpeechGrammar {
    private final int grammarID;
    private final byte grammarType;
    private final String grammarText;
    private final SpeechGrammarListItem[] listItems;

    public SpeechGrammar(int n, byte by, SpeechGrammarListItem[] speechGrammarListItemArray) {
        this.grammarID = n;
        this.grammarType = by;
        this.listItems = speechGrammarListItemArray;
        this.grammarText = "";
    }

    public SpeechGrammar(int n, byte by, String string) {
        this.grammarID = n;
        this.grammarType = by;
        this.listItems = new SpeechGrammarListItem[0];
        this.grammarText = string;
    }

    public int getGrammarID() {
        return this.grammarID;
    }

    public byte getGrammarType() {
        return this.grammarType;
    }

    public String getGrammarText() {
        return this.grammarText;
    }

    public SpeechGrammarListItem[] getListItems() {
        return this.listItems;
    }

    public String toString() {
        return "Grammar (id=" + this.grammarID + ", type=" + this.grammarType + ", grammarText='" + this.grammarText + "'" + ", listItems=" + this.listItems + ")";
    }
}

