/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.audi.atip.util.StringUtilities;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractConversionDataFetcher;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AsianInputMethod;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionDataFetcher;
import java.util.Collections;
import java.util.List;

public class ConversionDataFetcherFreetext
extends AbstractConversionDataFetcher
implements IConversionDataFetcher {
    private AsianInputMethod inputMethod = AsianInputMethod.NO_CONVERSION;

    public final void touchInputDataChanged(int n, boolean bl, String string, String string2) {
        if (n == 3) {
            this.requestConversions(string2, TouchControllerListenerFactory.calculateLastInputChar(string, string2), 0, 36);
        }
    }

    public void setInputMethod(AsianInputMethod asianInputMethod) {
        this.inputMethod = asianInputMethod;
    }

    protected void requestConversions(String string, char c2, int n, int n2) {
        this.requestConversions(string, c2, n, n2, false);
    }

    public void requestConversions(String string, char c2, int n, int n2, boolean bl) {
        Object object;
        this.notifyNextValidCharactersChanged(string, null);
        this.inputMethod.getCharacterConverter().setUnconvertedCharacters(string);
        if (StringUtilities.isNullOrEmpty(string) || n2 <= 0) {
            this.notifyConversionsAvailable("", Collections.EMPTY_LIST);
        } else {
            int n3 = n + n2;
            object = this.inputMethod.getCharacterConverter().getConversions(n3);
            object = object.subList(n, object.size());
            this.notifyConversionsAvailable(string, (List)object);
        }
        if (this.inputMethod == AsianInputMethod.STROKE && StringUtilities.isNullOrEmpty(string)) {
            this.notifyNextValidCharactersChanged(string, null);
        } else if (this.inputMethod == AsianInputMethod.ZHUYIN || this.inputMethod == AsianInputMethod.STROKE) {
            String string2 = this.inputMethod.getCharacterConverter().getValidCharacters();
            object = this.inputMethod == AsianInputMethod.ZHUYIN ? " " : null;
            this.notifyNextValidCharactersChanged(string, string2, (String)object);
        }
    }

    public void requestInitialValidCharacters() {
        this.requestConversions("", '\u0000', 0, 0, false);
    }
}

