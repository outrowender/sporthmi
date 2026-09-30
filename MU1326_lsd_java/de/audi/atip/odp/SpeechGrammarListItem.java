/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.odp;

public class SpeechGrammarListItem {
    protected final String content;
    protected final long id;

    public SpeechGrammarListItem(long l, String string) {
        this.id = l;
        this.content = string;
    }

    public String getContent() {
        return this.content;
    }

    public long getID() {
        return this.id;
    }

    public String toString() {
        return "id=" + this.id + ", content=" + this.content;
    }
}

