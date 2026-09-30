/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.PriviAction;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.security.AccessController;
import java.text.CharacterIterator;
import java.text.DictionaryBasedBreakIterator;
import java.text.RuleBasedBreakIterator;
import java.text.StringCharacterIterator;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public abstract class BreakIterator
implements Cloneable {
    public static final int DONE = -1;
    private static final int CHARACTER_INDEX = 0;
    private static final int WORD_INDEX = 1;
    private static final int LINE_INDEX = 2;
    private static final int SENTENCE_INDEX = 3;
    private static final SoftReference[] iterCache = new SoftReference[4];

    protected BreakIterator() {
    }

    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError();
        }
    }

    public abstract int first();

    public abstract int last();

    public abstract int next(int var1);

    public abstract int next();

    public abstract int previous();

    public abstract int following(int var1);

    public int preceding(int n) {
        int n2 = this.following(n);
        while (n2 >= n && n2 != -1) {
            n2 = this.previous();
        }
        return n2;
    }

    public boolean isBoundary(int n) {
        if (n == 0) {
            return true;
        }
        return this.following(n - 1) == n;
    }

    public abstract int current();

    public abstract CharacterIterator getText();

    public void setText(String string) {
        this.setText(new StringCharacterIterator(string));
    }

    public abstract void setText(CharacterIterator var1);

    public static BreakIterator getWordInstance() {
        return BreakIterator.getWordInstance(Locale.getDefault());
    }

    public static BreakIterator getWordInstance(Locale locale) {
        return BreakIterator.getBreakInstance(locale, 1, "WordBreakRules", "WordBreakDictionary");
    }

    public static BreakIterator getLineInstance() {
        return BreakIterator.getLineInstance(Locale.getDefault());
    }

    public static BreakIterator getLineInstance(Locale locale) {
        return BreakIterator.getBreakInstance(locale, 2, "LineBreakRules", "LineBreakDictionary");
    }

    public static BreakIterator getCharacterInstance() {
        return BreakIterator.getCharacterInstance(Locale.getDefault());
    }

    public static BreakIterator getCharacterInstance(Locale locale) {
        return BreakIterator.getBreakInstance(locale, 0, "CharacterBreakRules", "CharacterBreakDictionary");
    }

    public static BreakIterator getSentenceInstance() {
        return BreakIterator.getSentenceInstance(Locale.getDefault());
    }

    public static BreakIterator getSentenceInstance(Locale locale) {
        return BreakIterator.getBreakInstance(locale, 3, "SentenceBreakRules", "SentenceBreakDictionary");
    }

    private static BreakIterator getBreakInstance(Locale locale, int n, String string, String string2) {
        Object object;
        Locale locale2 = locale;
        if (locale2 == null) {
            locale2 = Locale.getDefault();
        }
        if (iterCache[n] != null && (object = (BreakIteratorCache)iterCache[n].get()) != null && ((BreakIteratorCache)object).getLocale().equals(locale2)) {
            return ((BreakIteratorCache)object).createBreakInstance();
        }
        object = BreakIterator.createBreakInstance(locale2, n, string, string2);
        BreakIteratorCache breakIteratorCache = new BreakIteratorCache(locale2, (BreakIterator)object);
        BreakIterator.iterCache[n] = new SoftReference(breakIteratorCache);
        return object;
    }

    private static ResourceBundle getBundle(String string, Locale locale) {
        return (ResourceBundle)AccessController.doPrivileged(new PriviAction(string, locale));
    }

    private static BreakIterator createBreakInstance(Locale locale, int n, String string, String string2) {
        ResourceBundle resourceBundle = BreakIterator.getBundle("com.ibm.oti.text.resources.BreakIteratorRules", locale);
        String[] stringArray = resourceBundle.getStringArray("BreakIteratorClasses");
        String string3 = resourceBundle.getString(string);
        if (stringArray[n].equals("RuleBasedBreakIterator")) {
            return new RuleBasedBreakIterator(string3);
        }
        if (stringArray[n].equals("DictionaryBasedBreakIterator")) {
            try {
                URL uRL = (URL)resourceBundle.getObject(string2);
                InputStream inputStream = uRL.openStream();
                return new DictionaryBasedBreakIterator(string3, inputStream);
            }
            catch (IOException iOException) {
            }
            catch (MissingResourceException missingResourceException) {}
            return new RuleBasedBreakIterator(string3);
        }
        throw new IllegalArgumentException(Msg.getString("K000f", stringArray[n]));
    }

    public static synchronized Locale[] getAvailableLocales() {
        return Locale.getAvailableLocales();
    }

    private static final class BreakIteratorCache {
        private BreakIterator iter;
        private Locale where;

        BreakIteratorCache(Locale locale, BreakIterator breakIterator) {
            this.where = locale;
            this.iter = (BreakIterator)breakIterator.clone();
        }

        Locale getLocale() {
            return this.where;
        }

        BreakIterator createBreakInstance() {
            return (BreakIterator)this.iter.clone();
        }
    }
}

