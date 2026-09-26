/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting;

import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.navigation.PhonemeData;
import org.dsi.ifc.search.Highlight;
import org.dsi.ifc.search.Token;

public class FormattedHighlightedText {
    public static final int EMPTY;
    public static final int NOT_EMPTY;
    public final int stateText;
    public final int stateHighlights;
    public final String formattedText;
    public final Highlight[] highlightedTextPositions;
    public final int phoneticType;
    public String phonemeText;

    public FormattedHighlightedText(String string) {
        this.formattedText = string;
        this.highlightedTextPositions = new Highlight[0];
        this.stateText = Util.isEmpty(string) ? 0 : 1;
        this.stateHighlights = 0;
        this.phoneticType = 0;
    }

    public FormattedHighlightedText(String string, int n) {
        this.formattedText = string;
        this.phoneticType = n;
        this.highlightedTextPositions = new Highlight[0];
        this.stateText = Util.isEmpty(string) ? 0 : 1;
        this.stateHighlights = 0;
    }

    public FormattedHighlightedText(int n) {
        this.formattedText = String.valueOf(n);
        this.highlightedTextPositions = new Highlight[0];
        this.stateText = 1;
        this.stateHighlights = 0;
        this.phoneticType = 0;
    }

    public FormattedHighlightedText(Token token) {
        this.formattedText = token.token;
        this.highlightedTextPositions = token.highlights;
        this.stateText = Util.isEmpty(token.token) ? 0 : 1;
        this.stateHighlights = token.highlights != null && token.highlights.length > 0 ? 1 : 0;
        this.phoneticType = 0;
    }

    public FormattedHighlightedText() {
        this.formattedText = "";
        this.highlightedTextPositions = new Highlight[0];
        this.stateText = 0;
        this.stateHighlights = 0;
        this.phoneticType = 0;
    }

    public boolean isEmpty() {
        return this.stateText == 0;
    }

    public boolean isHighlighted() {
        return this.stateHighlights == 0;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (object instanceof FormattedHighlightedText) {
            FormattedHighlightedText formattedHighlightedText = (FormattedHighlightedText)object;
            if (formattedHighlightedText.formattedText != null && formattedHighlightedText.formattedText.equals(this.formattedText)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.formattedText == null ? 0 : this.formattedText.hashCode());
        return n;
    }

    public void formatToPhoneticType(IMyLocationAccessor iMyLocationAccessor) {
        LogChannel logChannel = Navigation.getInstance().getEnv().getLogChannel();
        if (this.stateText == 1 && this.phoneticType != 0) {
            this.phonemeText = this.phoneticType == 13 && Util.isHURegionNAR() ? new StringBuffer().append(LocationFormatter.getStringForPhoneticType(this.phoneticType)).append(LocationFormatter.splitStringToSingleCharactersWithWhitespace(this.formattedText)).toString() : (iMyLocationAccessor.isTownOrder9() && this.phoneticType == 2 ? new StringBuffer().append(LocationFormatter.getStringForPhoneticType(3)).append(this.formattedText).toString() : (iMyLocationAccessor.isTownOrder9() && this.phoneticType == 3 ? new StringBuffer().append(LocationFormatter.getStringForPhoneticType(2)).append(this.formattedText).toString() : new StringBuffer().append(LocationFormatter.getStringForPhoneticType(this.phoneticType)).append(this.formattedText).toString()));
            if (this.phoneticType <= 8 && this.phoneticType >= 0) {
                if (logChannel.isDebug2()) {
                    logChannel.log(14808325, "   --> Try to Add Phoneme and Alphabet for Case: %1", (long)this.phoneticType);
                }
                if (null != iMyLocationAccessor) {
                    PhonemeData phonemeData = iMyLocationAccessor.getPhoneme(this.phoneticType);
                    if (null != phonemeData) {
                        if (null != phonemeData.getAlphabet() && null != phonemeData.getPhoneme()) {
                            Buffer buffer = new Buffer();
                            buffer.append("\u241e");
                            buffer.append(phonemeData.getAlphabet());
                            if (logChannel.isDebug2()) {
                                logChannel.log(14808325, "   --> ADDING Alphabet: %1", (Object)phonemeData.getAlphabet());
                            }
                            buffer.append("\u241e");
                            buffer.append(phonemeData.getPhoneme());
                            if (logChannel.isDebug2()) {
                                logChannel.log(14808325, "   --> ADDING Phoneme: %1", (Object)phonemeData.getPhoneme());
                            }
                            this.phonemeText = new StringBuffer().append(this.phonemeText).append(buffer.toString()).toString();
                        }
                    } else if (logChannel.isDebug2()) {
                        logChannel.log(14808325, "      --> locationAccessor.getPhoneme(%1) is NULL", (long)this.phoneticType);
                    }
                } else if (logChannel.isDebug2()) {
                    logChannel.log(14808325, "      --> locationAccessor is NULL", (long)this.phoneticType);
                }
            } else if (logChannel.isDebug2()) {
                logChannel.log(14808325, "      --> CONVERTING FROM PHONEME IS NO SUPPORTED", (long)this.phoneticType);
            }
        }
    }

    public boolean isPhonetic() {
        return this.phoneticType != 0;
    }
}

