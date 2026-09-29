/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util;

import de.audi.tghu.navi.app.util.StringHighlighter$HighlightingResult;
import de.audi.tghu.navi.app.util.Util;
import java.text.Collator;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.Locale;

public class StringHighlighter {
    private static StringHighlighter instance;
    private boolean useCollator = false;
    private Collator collator = null;

    private StringHighlighter(Locale locale, boolean bl) {
        this.useCollator = bl;
        this.initilize(locale);
    }

    public static synchronized StringHighlighter createInstance(Locale locale, boolean bl) {
        if (instance == null) {
            instance = new StringHighlighter(locale, bl);
        }
        return instance;
    }

    public static StringHighlighter getInstance() {
        return instance;
    }

    public boolean initilize(Locale locale) {
        boolean bl;
        if (this.useCollator) {
            RuleBasedCollator ruleBasedCollator = (RuleBasedCollator)(locale == null ? Collator.getInstance() : Collator.getInstance(locale));
            String string = ruleBasedCollator.getRules();
            string = new StringBuffer().append(string).append("& a, A, ae, aE, Ae, AE, \u00e4, \u00c4").toString();
            string = new StringBuffer().append(string).append("& o, O, oe, oE, Oe, OE, \u00f6, \u00d6").toString();
            string = new StringBuffer().append(string).append("& u, U, ue, uE, Ue, UE, \u00fc, \u00dc").toString();
            try {
                this.collator = new RuleBasedCollator(string);
                this.collator.setStrength(0);
                bl = true;
            }
            catch (ParseException parseException) {
                parseException.printStackTrace();
                this.collator = null;
                bl = false;
            }
        } else {
            this.collator = null;
            bl = true;
        }
        return bl;
    }

    public StringHighlighter$HighlightingResult findHighlight(String string, String string2, boolean bl) {
        if (Util.isEmpty(string)) {
            return null;
        }
        if (Util.isEmpty(string2)) {
            return null;
        }
        boolean bl2 = false;
        String string3 = string;
        int n = string3.length();
        StringHighlighter$HighlightingResult highlightingResult = null;
        while (!bl2 && n > 0) {
            highlightingResult = this.findMatch(string3, string2, bl);
            if (highlightingResult != null) {
                bl2 = true;
                continue;
            }
            string3 = string3.substring(0, --n);
        }
        return highlightingResult;
    }

    private boolean isSeparatorChar(char c2) {
        return Character.isWhitespace(c2) || c2 == '-';
    }

    private StringHighlighter$HighlightingResult findMatch(String string, String string2, boolean bl) {
        char c2 = string.charAt(0);
        boolean bl2 = this.isSeparatorChar(c2);
        int n = 0;
        int n2 = n + 1;
        int n3 = string2.length();
        boolean bl3 = false;
        String string3 = null;
        while (!bl3 && n < n3) {
            if (!bl2 && this.isSeparatorChar(string2.charAt(n))) {
                n2 = ++n + 1;
            }
            while (!bl3 && n2 <= n3) {
                string3 = string2.substring(n, n2);
                bl3 = this.collator == null ? string3.equalsIgnoreCase(string) : this.collator.equals(string3, string);
                ++n2;
            }
            if (bl || bl3) break;
            n2 = ++n + 1;
        }
        StringHighlighter$HighlightingResult stringHighlighter$HighlightingResult = null;
        if (bl3) {
            stringHighlighter$HighlightingResult = new StringHighlighter$HighlightingResult(string3, n, n2 - 1);
        }
        return stringHighlighter$HighlightingResult;
    }

    public void setUseCollator(boolean bl) {
        this.useCollator = bl;
    }

    public static synchronized void deInit() {
        instance = null;
    }
}

