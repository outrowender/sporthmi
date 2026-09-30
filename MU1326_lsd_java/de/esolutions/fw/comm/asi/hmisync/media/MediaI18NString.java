/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media;

public class MediaI18NString {
    public int i18nKey;
    public String name;

    public int getI18nKey() {
        return this.i18nKey;
    }

    public void setI18nKey(int n) {
        this.i18nKey = n;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public MediaI18NString() {
    }

    public MediaI18NString(int n, String string) {
        this.i18nKey = n;
        this.name = string;
    }

    public String toString() {
        return "MediaI18NString{" + "i18nKey=" + this.i18nKey + ", name=" + this.name + "}";
    }
}

