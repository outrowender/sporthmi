/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.i18n;

import java.util.Locale;

public final class Language
implements Comparable {
    private final int languageIndex;
    private final String languageCode;
    private final String languageName;
    private final String hmiCode;
    private int voiceId;
    private final int direction;
    private final Locale locale;
    private final int sdisLanguage;
    private final Locale sdisLocale;
    public static final int TEXTDIRECTION_LTR = 0;
    public static final int TEXTDIRECTION_RTL = 1;
    public static final int TEXTDIRECTION_DEFAULT = 0;

    public Language(int n, String string, String string2, String string3, int n2, Locale locale) {
        this(n, string, string2, string3, n2, 0, locale);
    }

    public Language(int n, String string, String string2, String string3, int n2, Locale locale, Locale locale2) {
        this(n, string, string2, string3, n2, 0, locale, locale2);
    }

    public Language(int n, String string, String string2, String string3, int n2, int n3, Locale locale) {
        this(n, string, string2, string3, n2, n3, locale, locale);
    }

    public Language(int n, String string, String string2, String string3, int n2, int n3, Locale locale, Locale locale2) {
        this.languageIndex = n;
        this.hmiCode = string;
        this.languageCode = string3;
        this.languageName = string2;
        this.locale = locale;
        this.sdisLanguage = n2;
        this.sdisLocale = locale2;
        this.voiceId = this.languageIndex == 21 || this.languageIndex == 8 || this.languageIndex == 26 ? 1 : 0;
        this.direction = n3;
    }

    public int getLanguageIndex() {
        return this.languageIndex;
    }

    public String getHmiCode() {
        return this.hmiCode;
    }

    public String getLanguageCode() {
        return this.languageCode;
    }

    public int getSDISLanguage() {
        return this.sdisLanguage;
    }

    public String getLanguageName() {
        return this.languageName;
    }

    public int getVoiceId() {
        return this.voiceId;
    }

    public void setVoiceId(int n) {
        this.voiceId = n;
    }

    public int getTextDirection() {
        return this.direction;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public Locale getSDISLocale() {
        return this.sdisLocale;
    }

    public int compareTo(Object object) {
        return this.languageName.compareTo(((Language)object).languageName);
    }

    public int hashCode() {
        return this.languageIndex;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        Language language = (Language)object;
        return !(this.hmiCode == null ? language.hmiCode != null : !this.hmiCode.equals(language.hmiCode));
    }

    public String toString() {
        return "LangCode=" + this.languageCode + ", HMICode=" + this.hmiCode + ", VoiceId=" + this.voiceId + ", Idx=" + this.languageIndex;
    }
}

