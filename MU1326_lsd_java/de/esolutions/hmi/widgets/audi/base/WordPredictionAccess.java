/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.IWordPredictionResponseEvent;
import de.audi.atip.log.LogChannel;
import de.audi.atip.wordprediction.IWordPrediction;
import de.audi.atip.wordprediction.IWordPredictionResponseListener;
import de.audi.atip.wordprediction.IWordPredictionServiceListener;
import de.audi.atip.wordprediction.WordPredictionUseCase;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.IWordPredictionAccess;

public final class WordPredictionAccess
implements IWordPredictionAccess,
ATIPEventListener {
    private static IWordPrediction wordPrediction;
    private static IWordPredictionServiceListener serviceListener;
    private final IWordPredictionResponseListener responseListener;
    private static final ResponsePeeker RESPONSE_PEEKER;
    private int currentReponseId;
    private int lastResponseIdForValueRespondingMethod;
    private WordPredictionUseCase lastValueRespondingMethodCalled;

    public WordPredictionAccess(IWordPredictionResponseListener iWordPredictionResponseListener) {
        this.responseListener = iWordPredictionResponseListener;
        this.currentReponseId = 0;
        this.lastResponseIdForValueRespondingMethod = -1;
        this.lastValueRespondingMethodCalled = WordPredictionUseCase.NULL;
    }

    protected static void setWordPrediction(IWordPrediction iWordPrediction) {
        wordPrediction = iWordPrediction;
        WordPredictionAccess.getWidgetStartupLogChannel().log(100000000, "WordPredictionAccess#setWordPrediction to service listener %1", (Object)serviceListener);
        if (serviceListener != null) {
            if (iWordPrediction == null) {
                serviceListener.onWordPredictionServiceRemoved();
            } else {
                serviceListener.onWordPredictionServiceReady();
            }
        }
    }

    public void processEvent(ATIPEvent aTIPEvent) {
        IWidgetLogChannel.tpLogChannelInternal.log(10000000, "WordPredictionAccess#processEvent %1", (Object)aTIPEvent);
        if (aTIPEvent instanceof IWordPredictionResponseEvent) {
            IWordPredictionResponseEvent iWordPredictionResponseEvent = (IWordPredictionResponseEvent)((Object)aTIPEvent);
            if (!this.isOutdatedEvent(iWordPredictionResponseEvent)) {
                iWordPredictionResponseEvent.dispatchToResponseListener(this.responseListener, IWidgetLogChannel.tpLogChannelInternal);
            }
        } else {
            IWidgetLogChannel.tpLogChannelInternal.log(10000, "WordPredictionAccess#processEvent event is not a WordPredictionEvent: %1", (Object)aTIPEvent);
        }
    }

    private boolean isOutdatedEvent(IWordPredictionResponseEvent iWordPredictionResponseEvent) {
        boolean bl;
        boolean bl2 = bl = iWordPredictionResponseEvent.getEventType() == 120012 && iWordPredictionResponseEvent.getResponseId() < this.lastResponseIdForValueRespondingMethod;
        if (bl) {
            if (WordPredictionAccess.isHighPriorityUpdateEvent(iWordPredictionResponseEvent)) {
                IWidgetLogChannel.tpLogChannelInternal.log(10000000, "WordPredictionAccess#isOutdatedEvent dispatching UPDATE_VALUES event although it is outdated, because it has high priority (latest response id: %3 set by calling %1, event: %2)", (Object)this.lastValueRespondingMethodCalled, (Object)iWordPredictionResponseEvent, (long)this.lastResponseIdForValueRespondingMethod);
                return false;
            }
            WordPredictionAccess.getWordPredictionLogChannel().log(1000000, "WordPredictionAccess#isOutdatedEvent ignoring %2, because it is outdated (expected latest response id: %3, %1) and not high prio.", (Object)this.lastValueRespondingMethodCalled, (Object)iWordPredictionResponseEvent, (long)this.lastResponseIdForValueRespondingMethod);
            return true;
        }
        return false;
    }

    private static boolean isHighPriorityUpdateEvent(IWordPredictionResponseEvent iWordPredictionResponseEvent) {
        iWordPredictionResponseEvent.dispatchToResponseListener(RESPONSE_PEEKER, IWidgetLogChannel.tpLogChannelInternal);
        boolean bl = RESPONSE_PEEKER.isEmptySpellingUpdate() || RESPONSE_PEEKER.hasAutoConvertedCharacters();
        RESPONSE_PEEKER.reset();
        return bl;
    }

    public void spellerConnected(int n, String[] stringArray) {
        if (WordPredictionAccess.isWordPredictionActive("spellerConnected")) {
            IWidgetLogChannel.tpLogChannelInternal.log(10000000, "WordPredictionAccess#spellerConnected (responseId=%2) was called with languageIndex=%3, wordDataBaseNames=%1", (Object)stringArray, (long)this.currentReponseId, (long)n);
            wordPrediction.spellerConnected(this, this.currentReponseId, n, stringArray);
            this.incrementResponseId(WordPredictionUseCase.SPELLER_CONNECTED);
        }
        if (this.responseListener instanceof IWordPredictionServiceListener) {
            serviceListener = (IWordPredictionServiceListener)this.responseListener;
        }
    }

    public void spellerDisconnected() {
        if (WordPredictionAccess.isWordPredictionActive("spellerDisconnected")) {
            IWidgetLogChannel.tpLogChannelInternal.log(10000000, "WordPredictionAccess#spellerDisconnected (responseId=%1) was called", (long)this.currentReponseId);
            wordPrediction.spellerDisconnected(this, this.currentReponseId);
            this.incrementResponseId(WordPredictionUseCase.SPELLER_DISCONNECTED);
        }
        serviceListener = null;
    }

    public void unconvertedTextChanged(String string, String string2, int n) {
        if (WordPredictionAccess.isWordPredictionActive("unconvertedTextChanged")) {
            if (IWidgetLogChannel.tpLogChannelInternal.isDebug()) {
                IWidgetLogChannel.tpLogChannelInternal.log(10000000, "WordPredictionAccess#unconvertedTextChanged (responseId=%1) was called with newUnconvertedText=\"%2\", oldUnconvertedText=\"%3\", maxVisibleCandidates=%4", (Object)new Integer(this.currentReponseId), (Object)string, (Object)string2, (long)n);
            }
            wordPrediction.unconvertedTextChanged(this, this.currentReponseId, string, string2, n);
            this.incrementResponseId(WordPredictionUseCase.UNCONVERTED_TEXT_CHANGED);
        }
    }

    private void incrementResponseId(WordPredictionUseCase wordPredictionUseCase) {
        if (wordPredictionUseCase.sendsUpdateValueResponse()) {
            this.lastResponseIdForValueRespondingMethod = this.currentReponseId;
            this.lastValueRespondingMethodCalled = wordPredictionUseCase;
        }
        ++this.currentReponseId;
    }

    public void startContextBasedPrediction(String string, String string2, int n) {
        if (serviceListener == null) {
            IWidgetLogChannel.tpLogChannelInternal.log(10000000, "WordPredictionAccess#startContextBasedPrediction serviceListener = null", new Throwable());
        } else if (WordPredictionAccess.isWordPredictionActive("startContextBasedPrediction") && serviceListener.isStartContextBasedPredictionValid()) {
            if (IWidgetLogChannel.tpLogChannelInternal.isDebug()) {
                IWidgetLogChannel.tpLogChannelInternal.log(10000000, "WordPredictionAccess#startContextBasedPrediction (responseId=%1) was called with regularText=\"%2\", regularText=\"%3\", maxVisibleCandidates=%4", (Object)new Integer(this.currentReponseId), (Object)string, (Object)string2, (long)n);
            }
            wordPrediction.startContextBasedPrediction(this, this.currentReponseId, string, string2, n);
            this.incrementResponseId(WordPredictionUseCase.START_CONTEXT_BASED_PREDICTION);
        }
    }

    public void selectedCandidate(String string, int n, String string2, int n2) {
        if (WordPredictionAccess.isWordPredictionActive("selectedCandidate")) {
            if (IWidgetLogChannel.tpLogChannelInternal.isDebug()) {
                IWidgetLogChannel.tpLogChannelInternal.log(10000000, "WordPredictionAccess#selectedCandidate (responseId=%1) was called with inputField=\"%2\", index=%3, maxVisibleCandidates=%4", (Object)new Integer(this.currentReponseId), (Object)string, (Object)new Integer(n), (long)n2);
            }
            wordPrediction.selectedCandidate(this, this.currentReponseId, string, n, string2, n2);
            this.incrementResponseId(WordPredictionUseCase.SELECTED_CANDIDATE);
        }
    }

    public void getCandidates(int n) {
        if (WordPredictionAccess.isWordPredictionActive("getCandidates")) {
            IWidgetLogChannel.tpLogChannelInternal.log(10000000, "WordPredictionAccess#getCandidates (responseId=%1) was called with amount=%2", (long)this.currentReponseId, (long)n);
            wordPrediction.getCandidates(this, this.currentReponseId, n);
            this.incrementResponseId(WordPredictionUseCase.GET_CANDIDATES);
        }
    }

    public void convertedAllCharactersInternally() {
        if (WordPredictionAccess.isWordPredictionActive("convertedAllCharactersInternally")) {
            IWidgetLogChannel.tpLogChannelInternal.log(10000000, "WordPredictionAccess#convertedAllCharactersInternally (responseId=%1) was called", (long)this.currentReponseId);
            wordPrediction.convertedAllCharactersInternally(this, this.currentReponseId);
            this.incrementResponseId(WordPredictionUseCase.CONVERTED_ALL_CHARACTERS_INTERNALLY);
        }
    }

    private static boolean isWordPredictionActive(String string) {
        if (wordPrediction == null) {
            IWidgetLogChannel.tpLogChannelInternal.log(100000, "WordPredictionAccess: method %1 was called, but word prediction is not ready!", (Object)string);
            return false;
        }
        return true;
    }

    public String toString() {
        return new Buffer("WordPredictionAccess [responseListener=").append(this.responseListener).append("]").toString();
    }

    protected static LogChannel getWidgetStartupLogChannel() {
        return IWidgetLogChannel.logWidgetStartup;
    }

    protected static LogChannel getWordPredictionLogChannel() {
        return AbstractWidget.framework.getLogChannel("App.WordPrediction.Main");
    }

    public void addToUserPreference(String string, String string2) {
        if (WordPredictionAccess.isWordPredictionActive("addToUserPreference")) {
            IWidgetLogChannel.tpLogChannelInternal.log(10000000, "WordPredictionAccess#addToUserPreference (responseId=%3) was called with unconvertedCharacters=\"%1\", preferredConversion=%2", (Object)string, (Object)string2, (long)this.currentReponseId);
            wordPrediction.addToUserPreference(this, this.currentReponseId, string, string2);
            this.incrementResponseId(WordPredictionUseCase.ADD_TO_USER_PREFERENCE);
        }
    }

    protected int getCurrentReponseId() {
        return this.currentReponseId;
    }

    public void getConversionAndSpellingImmediately(String string, int n) {
        if (WordPredictionAccess.isWordPredictionActive("getConversionAndSpellingImmediately")) {
            IWidgetLogChannel.tpLogChannelInternal.log(10000000, "WordPredictionAccess#getConversionAndSpellingImmediately (responseId=%2) was called with unconvertedCharacters=\"%1\"", (Object)string, (long)this.currentReponseId);
            wordPrediction.getConversionAndSpellingImmediately(this, this.currentReponseId, string, n);
            this.incrementResponseId(WordPredictionUseCase.GET_CONVERSION_AND_SPELLING_IMMEDIATELY);
        }
    }

    static {
        RESPONSE_PEEKER = new ResponsePeeker();
    }

    private static final class ResponsePeeker
    implements IWordPredictionResponseListener {
        String spelling = "NOT EMPTY";
        String autoConvertedChars = "";

        private ResponsePeeker() {
        }

        boolean isEmptySpellingUpdate() {
            return "".equals(this.spelling);
        }

        boolean hasAutoConvertedCharacters() {
            return !"".equals(this.autoConvertedChars);
        }

        void reset() {
            this.spelling = "NOT EMPTY";
            this.autoConvertedChars = "";
        }

        public void updateSpelling(String string) {
            this.spelling = string;
        }

        public void updateCandidates(String[] stringArray) {
        }

        public void updateAutoConvertedCharacters(String string) {
            this.autoConvertedChars = string;
        }

        public void handleError(String string) {
        }
    }
}

