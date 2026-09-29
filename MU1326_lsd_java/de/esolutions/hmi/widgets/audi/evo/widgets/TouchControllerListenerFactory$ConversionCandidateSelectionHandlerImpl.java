/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.KeyEvent;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionDataFetcherWordPrediction;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionCandidateSelectionHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionDataFetcher;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ITouchInputDataAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.PartialConversionHelperWithUndoImpl;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerFocusState;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchInputDataAsia;

final class TouchControllerListenerFactory$ConversionCandidateSelectionHandlerImpl
implements IConversionCandidateSelectionHandler {
    private TouchControllerAsia touchController = null;

    private TouchControllerListenerFactory$ConversionCandidateSelectionHandlerImpl(TouchControllerAsia touchControllerAsia) {
        this.touchController = touchControllerAsia;
    }

    @Override
    public void acceptConversionCandidateSelection(String string, int n) {
        boolean bl = this.touchController.shouldUseWordPrediction();
        ITouchInputDataAsia iTouchInputDataAsia = (ITouchInputDataAsia)this.touchController.getInputData();
        if (!bl) {
            iTouchInputDataAsia.clearUnconvertedCharacters(false);
            iTouchInputDataAsia.appendRegularCharacters(string, true);
            this.touchController.setConversionLineVisible(false);
            this.touchController.setFocusState(TouchControllerFocusState.SPELLER_LINE_FOCUS);
        } else {
            this.touchController.cacheSelectedPredictionChars(string);
            IConversionDataFetcher iConversionDataFetcher = this.touchController.getConversionDataFetcher();
            if (iConversionDataFetcher instanceof ConversionDataFetcherWordPrediction) {
                ((ConversionDataFetcherWordPrediction)iConversionDataFetcher).candidateSelected(n, 36, TouchControllerListenerFactory$ConversionCandidateSelectionHandlerImpl.getPredictionContext(iTouchInputDataAsia, string, this.touchController.getPartialConversionHelper().getConvertedChars()), string);
            }
        }
    }

    private static String getPredictionContext(ITouchInputDataAsia iTouchInputDataAsia, String string, String string2) {
        Buffer buffer = new Buffer();
        if (!iTouchInputDataAsia.hasUnconvertedCharacters() || PartialConversionHelperWithUndoImpl.countSeparator(iTouchInputDataAsia.getUnconvertedCharacters()) < string.length()) {
            buffer.append(TouchInputDataAsia.getCharsBeforeLastSpaceSeperator(iTouchInputDataAsia.getCurrentText(), false));
            buffer.append(string2);
        }
        return buffer.toString();
    }

    @Override
    public void acceptKeyEventInConversionMatrix(KeyEvent keyEvent) {
        ITouchInputDataAsia iTouchInputDataAsia = (ITouchInputDataAsia)this.touchController.getInputData();
        if (keyEvent.getKeyCode() == 15 && (iTouchInputDataAsia.hasUnconvertedCharacters() || this.touchController.shouldUseWordPrediction())) {
            this.touchController.setConversionLineVisible(true);
            this.touchController.setFocusState(TouchControllerFocusState.CONVERSION_LINE_FOCUS);
            keyEvent.consume();
        }
    }

    /* synthetic */ TouchControllerListenerFactory$ConversionCandidateSelectionHandlerImpl(TouchControllerAsia touchControllerAsia, TouchControllerListenerFactory$1 touchControllerListenerFactory$1) {
        this(touchControllerAsia);
    }
}

