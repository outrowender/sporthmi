/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.util.StringUtilities;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.IWordPredictionAccess;
import java.util.Arrays;

public class NullWordPredictionAccess
implements IWordPredictionAccess {
    @Override
    public void spellerConnected(int n, String[] stringArray) {
        if (IWidgetLogChannel.tpLogChannelInternal.isDebug()) {
            IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "NullWordPredictionAccess: Not processing spellerConnected with language index %1 and wordDataBaseNames (%2)", (Object)Integer.toString(n), (Object)StringUtilities.concatStringArray(Arrays.asList(stringArray), "|"));
        }
    }

    @Override
    public void spellerDisconnected() {
        if (IWidgetLogChannel.tpLogChannelInternal.isDebug()) {
            IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "NullWordPredictionAccess: Not processing spellerDisconnected.");
        }
    }

    @Override
    public void unconvertedTextChanged(String string, String string2, int n) {
        if (IWidgetLogChannel.tpLogChannelInternal.isDebug()) {
            IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "NullWordPredictionAccess: Not processing textChanged with newText (%1), oldText (%2) and maxVisibleCandidates = %3.", (Object)string, (Object)string2, (Object)Integer.toString(n));
        }
    }

    @Override
    public void selectedCandidate(String string, int n, String string2, int n2) {
        if (IWidgetLogChannel.tpLogChannelInternal.isDebug()) {
            IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "NullWordPredictionAccess: Not processing selectedCandidate with predictionContext = '%1', index=%2 selectedCandidate = %3 and maxVisibleCandidates=%4", (Object)string, (Object)String.valueOf(n), (Object)string2, (Object)String.valueOf(n2));
        }
    }

    @Override
    public void getCandidates(int n) {
        if (IWidgetLogChannel.tpLogChannelInternal.isDebug()) {
            IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "NullWordPredictionAccess: Not processing getCandidates with amount=%1", (long)n);
        }
    }

    @Override
    public void convertedAllCharactersInternally() {
        if (IWidgetLogChannel.tpLogChannelInternal.isDebug()) {
            IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "NullWordPredictionAccess: Not processing convertedAllCharactersInternally");
        }
    }

    public void startContextBasedPrediction(String string, int n) {
        this.startContextBasedPrediction(string, "", n);
    }

    @Override
    public void startContextBasedPrediction(String string, String string2, int n) {
        if (IWidgetLogChannel.tpLogChannelInternal.isDebug()) {
            IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "NullWordPredictionAccess: Not processing touchPreviewSelected with regularText (%1), lastInput (%2) and maxVisibleCandidates = %3.", (Object)string, (Object)string2, (Object)Integer.toString(n));
        }
    }

    public void autoConvertedStrokes(char c2, String string, String string2, int n) {
        if (IWidgetLogChannel.tpLogChannelInternal.isDebug()) {
            IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "NullWordPredictionAccess: Not processing autoconvertedLastStrokes with newStroke=(%1), convertedStrokes='%2', regularText='%3' and maxVisibleCandidates = %4.", (Object)Character.toString(c2), (Object)string, (Object)string2, (long)n);
        }
    }

    @Override
    public void addToUserPreference(String string, String string2) {
        if (IWidgetLogChannel.tpLogChannelInternal.isDebug()) {
            IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "NullWordPredictionAccess: Not processing addToUserPreference with unconvertedCharacters=(%1), preferredConversion='%2'.", (Object)string, (Object)string2);
        }
    }

    @Override
    public void getConversionAndSpellingImmediately(String string, int n) {
        if (IWidgetLogChannel.tpLogChannelInternal.isDebug()) {
            IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "NullWordPredictionAccess: Not processing getConversionAndSpellingImmediately with unconvertedCharacters=(%1).", (Object)string);
        }
    }
}

