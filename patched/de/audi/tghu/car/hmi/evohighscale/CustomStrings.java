/*
 * Custom UI string overrides for the Car HMI module (module id 6, text ids 6xxxxx).
 *
 * HOW IT WORKS
 *   Every label in the Car module is resolved through CarScreenFactory.getText(id).
 *   That method now asks this class first. If get(...) returns a non-null string,
 *   that string is shown instead of the original dataset text. If it returns null,
 *   the original (built-in) string is used unchanged.
 *
 * HOW TO ADD A TRANSLATION
 *   Add the HMI language code and translated string to that text ID's map in the
 *   static initializer. Use DEFAULT_LANGUAGE for a generic fallback; omit it to
 *   preserve the dataset text when no language-specific translation exists.
 *
 * LANGUAGES
 *   langCode is the HMI language code of the active language (for example
 *   "en_GB", "en_US", "pt_BR", "de_DE", "fr_FR", ...).
 */
package de.audi.tghu.car.hmi.evohighscale;

import java.util.HashMap;
import java.util.Map;

public final class CustomStrings {

    private static final String DEFAULT_LANGUAGE = "default";
    private static final Map STRINGS_BY_ID = new HashMap();

    static {
        Map sportsDisplay = new HashMap();
        sportsDisplay.put("en_GB", "Sports Display");
        sportsDisplay.put("en_SA", "Sports Display");
        sportsDisplay.put("en_US", "Sports Display");
        sportsDisplay.put("en_JP", "Sports Display");
        sportsDisplay.put("en_CN", "Sports Display");
        sportsDisplay.put("en_KR", "Sports Display");
        sportsDisplay.put("en_TW", "Sports Display");
        STRINGS_BY_ID.put(new Integer(605468), sportsDisplay);

        Map helloWorld = new HashMap();
        helloWorld.put(DEFAULT_LANGUAGE, "Hello World");
        helloWorld.put("pt_BR", "Ol\u00e1 mundo");
        STRINGS_BY_ID.put(new Integer(609901), helloWorld);
    }

    private CustomStrings() {
    }

    /**
     * @param textId   the full text id used by setLabelId / setTextIds (e.g. 605468)
     * @param langCode active HMI language code (may be null), e.g. "en", "de"
     * @return replacement string, or null to keep the original dataset text
     */
    public static String get(int textId, String langCode) {
        Map stringsByLanguage = (Map)STRINGS_BY_ID.get(new Integer(textId));
        if (stringsByLanguage == null) {
            return null;
        }
        String text = (String)stringsByLanguage.get(langCode);
        if (text != null) {
            return text;
        }
        return (String)stringsByLanguage.get(DEFAULT_LANGUAGE);
    }
}
