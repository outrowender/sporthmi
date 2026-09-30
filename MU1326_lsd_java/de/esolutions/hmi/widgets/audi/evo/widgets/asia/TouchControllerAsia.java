/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;
import de.audi.atip.hmi.modelaccess.MatchspellerModelGUI;
import de.audi.atip.hmi.modelaccess.SpellerModelGUI;
import de.audi.atip.hmi.view.IPartialPopupController;
import de.audi.atip.util.StringUtilities;
import de.audi.atip.wordprediction.IWordPrediction;
import de.audi.atip.wordprediction.IWordPredictionServiceListener;
import de.audi.tghu.hmi.evo.IPartialPopupManagerEvo;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IUserHintHandler;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.IWordPredictionAccess;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.evo.IRendererFactory;
import de.esolutions.hmi.widgets.audi.evo.prpframework.IPRPEngine;
import de.esolutions.hmi.widgets.audi.evo.widgets.FingerTraceController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IFingerTraceRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchCharSetAndTTSHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerDebugInfo;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractToneAndCaseTogglingTable;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AsianInputMethod;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionDataFetcherFreetext;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionDataFetcherStrokeMatchspeller;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionDataFetcherWordPrediction;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionLineController;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionMatrixController;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionMatrixModel;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionCandidateSelectionHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionDataFetcher;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionMatrixModel;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionMatrixPreparationFinishedListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IConversionWidgetRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IPartialConversionHelper;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IStrokeMatchspellerProtocol;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ITouchInputDataAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ITouchResultLine;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IWordPredictionDataFetcher;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerBandState;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.SpellerControllerAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.StrokeMatchspellerProtocol;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerFocusState;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.prpframework.PRPEngineAsia;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuCallback;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateDelta;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TouchControllerAsia
extends TouchController
implements IWordPredictionServiceListener,
IConversionMatrixPreparationFinishedListener,
IMenuCallback {
    private static final String BACKSPACE = Character.toString('\b');
    public static final char WORD_PREDICTION_SEPARATOR = '\'';
    private TouchControllerFocusState currentFocusState = TouchControllerFocusState.INPUT_LINE_FOCUS;
    private ConversionLineController conversionLine = null;
    private SpellerControllerAsia asianSpeller;
    private final ITouchInputDataAsia asianTouchInputData;
    private IConversionDataFetcher conversionDataFetcher;
    protected final IConversionCandidateSelectionHandler touchControllerAsSelectionHandler;
    protected final TouchControllerListenerFactory.TimerListenerImplAsia timerListenerAsia;
    private Buffer cacheLastblockedTouchInputCharacter = null;
    private IStrokeMatchspellerProtocol strokeMatchspellerProtocol = null;
    private int currentInputModeSetForMatchspeller = 0;
    private final ConversionMatrixModel conversionMatrixModel;
    private IPRPEngine prpEngineForMatchspellerFiltering;
    private TouchEvent cachedTouchEvent = null;
    private boolean isImplicityAccept = false;
    private final boolean isWordPredictionAvailable;
    private IWordPredictionAccess wordPredictionAccess = IWordPredictionAccess.NULL;
    private String toneLowerCaseButtonValidChars;
    protected IPartialConversionHelper partialConversionHelper;

    public TouchControllerAsia(ITouchInputDataAsia iTouchInputDataAsia, boolean bl, IPartialConversionHelper iPartialConversionHelper) {
        super(iTouchInputDataAsia);
        this.asianTouchInputData = iTouchInputDataAsia;
        this.touchControllerAsSelectionHandler = this.listenerFactory.createConversionCandidateSelectionHandler();
        this.timerListenerAsia = (TouchControllerListenerFactory.TimerListenerImplAsia)this.timerListener;
        this.conversionMatrixModel = new ConversionMatrixModel();
        this.isWordPredictionAvailable = bl;
        this.partialConversionHelper = iPartialConversionHelper;
        this.showFocusStateDebugInfo();
    }

    protected TouchCharSetAndTTSHandler createTouchCharsetAndTTSHandler() {
        return new TouchCharSetAndTTSHandler(this.terminal, true);
    }

    protected void initializeWidget() {
        super.initializeWidget();
        if (this.isMapcodeOrMatchPhoneNumber()) {
            if (this.initContext.isReinit()) {
                this.openSpeller(false);
            }
            this.setRecognizerMode(0);
        }
        this.initializeConversionDataFetcher(this.asianTouchInputData.getInputMethod());
        this.conversionMatrixModel.registerConversionCandidateSelectionHandler(this.touchControllerAsSelectionHandler);
        this.conversionMatrixModel.setConversionDataFetcher(this.conversionDataFetcher);
        this.asianSpeller.setShouldUseWordPredictionForTouch(this.shouldUseWordPrediction(), !this.touchUtil.isEnglishSystemLanguage());
        this.asianSpeller.setIsTruffleSearch(this.isTruffleSearch());
        this.toneLowerCaseButtonValidChars = "";
    }

    protected boolean isMapcodeOrMatchPhoneNumber() {
        return this.isJPMapCode() || this.isMatchedPhoneNumber();
    }

    public void showFocusStateDebugInfo() {
        SpellerBandState spellerBandState = null;
        if (this.asianSpeller != null) {
            spellerBandState = this.asianSpeller.getCurrentSpellerState();
        }
        TouchControllerDebugInfo.showFocusStateDebugInfo(this.terminal, this, spellerBandState, this.currentFocusState);
    }

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.showFocusStateDebugInfo();
        TouchControllerDebugInfo.showTouchModeDebugInfo(this.terminal, this, this.getTouchpadMode());
        TouchControllerDebugInfo.showSpellerModelDebugInfo(this.terminal, this, this.getSpeller().getSpellerMode());
        this.registerSpellerForWordPrediction();
    }

    protected void notifyMatchspellerModelAboutInputModeChange(int n) {
        n = this.getTouchUtil().convertMatchspellerInputMode(n);
        if (this.isMatchspellerModel() && this.currentInputModeSetForMatchspeller != n) {
            this.currentInputModeSetForMatchspeller = n;
            tpLogChannelInternal.log(10000000, "TouchControllerAsia#notifyMatchspellerModelAboutInputModeChange [MODEL COMMUNICATION ->] calling inputModeTPChanged with mode %1 (%2 is speller mode, %3 is HWR mode)", (long)n, 0L, 1L);
            ((MatchspellerModelGUI)this.model).inputModeTPChanged(n, this.terminal.getTerminalID());
            TouchControllerDebugInfo.showInputModeDebugInfo(this.terminal, this, this.currentInputModeSetForMatchspeller);
        }
    }

    public final void setRecognitionTimeOutValue(int n) {
        if (this.terminal != null && this.terminal.getKbdService() != null) {
            this.terminal.getKbdService().setRecognitionTimeoutAsia(n);
        } else {
            tpLogChannelInternal.log(10000, "TouchControllerAsia#setRecognitionTimeOutValue: terminal or keyboard service is not available");
        }
    }

    public void initConnect(InitializationContext initializationContext) {
        super.initConnect(initializationContext);
        if (this.conversionLine == null) {
            ConversionLineController conversionLineController = new ConversionLineController(this);
            IRendererFactory iRendererFactory = this.getRendererFactory();
            if (iRendererFactory != null) {
                IConversionWidgetRenderer iConversionWidgetRenderer = iRendererFactory.createConversionLineRenderer(conversionLineController, this.getRenderer());
                conversionLineController.setRenderer(iConversionWidgetRenderer);
                conversionLineController.setBitmaps(this.getBitmapIndices());
            } else {
                tpLogChannelInternal.log(10000, "TouchControllerAsia#initConnect: could not create CandidateMatrix renderer");
            }
            this.addConversionLineWidget(conversionLineController);
        }
    }

    private void initializeConversionDataFetcher(AsianInputMethod asianInputMethod) {
        tpLogChannelInternal.log(10000000, "TouchControllerAsia#initializeConversionDataFetcher: initial conversion data fetcher");
        boolean bl = this.conversionDataFetcher != null;
        boolean bl2 = this.isMatchspellerModel() && asianInputMethod == AsianInputMethod.STROKE;
        this.strokeMatchspellerProtocol = null;
        if (bl && !bl2) {
            this.conversionDataFetcher.setInputMethod(asianInputMethod);
        } else {
            if (bl) {
                this.asianTouchInputData.unregisterDataChangeListener(this.conversionDataFetcher);
                this.conversionDataFetcher.unregisterConversionFetcherListener(this.conversionLine);
                this.conversionDataFetcher.unregisterConversionFetcherListener(this.asianSpeller);
            }
            if (bl2) {
                this.strokeMatchspellerProtocol = new StrokeMatchspellerProtocol((MatchspellerModelGUI)this.model, this.asianTouchInputData, this, this.terminal);
                this.conversionDataFetcher = new ConversionDataFetcherStrokeMatchspeller(this.strokeMatchspellerProtocol);
            } else if (this.isMatchspellerModel()) {
                this.conversionDataFetcher = IConversionDataFetcher.NULL;
            } else if (this.isWordPredictionAvailable) {
                this.conversionDataFetcher = new ConversionDataFetcherWordPrediction(this.wordPredictionAccess);
                this.asianSpeller.setWordPredictionDataFetcher((IWordPredictionDataFetcher)this.conversionDataFetcher);
                this.partialConversionHelper.reset();
            } else {
                ConversionDataFetcherFreetext conversionDataFetcherFreetext = new ConversionDataFetcherFreetext();
                conversionDataFetcherFreetext.setInputMethod(asianInputMethod);
                this.conversionDataFetcher = conversionDataFetcherFreetext;
            }
            if (tpLogChannelInternal.isDebug()) {
                tpLogChannelInternal.log(10000000, "TouchControllerAsia#initializeConversionDataFetcher: using data fetcher ( %1 )", (Object)this.conversionDataFetcher.getClass().getName());
            }
            this.asianTouchInputData.registerDataChangeListener(this.conversionDataFetcher);
            this.conversionDataFetcher.registerConversionFetcherListener(this.conversionLine);
            this.conversionDataFetcher.registerConversionFetcherListener(this.asianSpeller);
        }
    }

    public void setTouchpadMode(int n) {
        super.setTouchpadMode(n);
        if (this.isTruffleSearch()) {
            this.asianTouchInputData.setNeedPreviewDataUpdateToModel(true);
        }
        TouchControllerDebugInfo.showTouchModeDebugInfo(this.terminal, this, this.getTouchpadMode());
    }

    public void setWidth(int n) {
        int n2 = this.asianSpeller.getWidth();
        super.setWidth(n);
        int n3 = this.asianSpeller.getWidth();
        if (this.conversionLine != null && n2 != n3) {
            this.conversionLine.setWidth(n3);
        }
    }

    protected void addConversionLineWidget(ConversionLineController conversionLineController) {
        this.add(conversionLineController);
        this.conversionLine = conversionLineController;
        this.conversionLine.setVisible(false);
        this.conversionLine.setConversionCandidateSelectionHandler(this.touchControllerAsSelectionHandler);
    }

    public ConversionLineController getConversionLine() {
        return this.conversionLine;
    }

    protected void addFingerTraceWidget(FingerTraceController fingerTraceController) {
        super.addFingerTraceWidget(fingerTraceController);
    }

    protected void closeSpeller(boolean bl, boolean bl2) {
        super.closeSpeller(bl, bl2);
        this.asianTouchInputData.spellerClosed();
        this.clearSuggestion();
        this.setConversionLineVisible(false);
        this.setMatrixPopupVisible(false);
        this.setFocusState(TouchControllerFocusState.INPUT_LINE_FOCUS);
    }

    protected void openSpeller(boolean bl) {
        if (this.getCurrentFocusState() == TouchControllerFocusState.TOUCH_RESULT_LINE_FOCUS || this.getCurrentFocusState() == TouchControllerFocusState.TOUCH_PREDICTION_LINE_FOCUS) {
            this.asianSpeller.changeSpellerState(SpellerBandState.DEFAULT_SPELLER);
            this.asianTouchInputData.setHandWrittenModeIsActive(false);
        } else {
            super.openSpeller(bl);
        }
        this.setFocusState(TouchControllerFocusState.SPELLER_LINE_FOCUS);
        this.notifyMatchspellerModelAboutInputModeChange(0);
        if (!this.isOpenSpellerAfterViewSizeChange() && !this.isOpenSpellerOnOtherScreen()) {
            this.updateInputDescriptionLineVisibility(true);
        }
    }

    public void setSpeller(SpellerController spellerController) {
        super.setSpeller(spellerController);
        if (!(spellerController instanceof SpellerControllerAsia)) {
            tpLogChannelInternal.log(10000, "TouchControllerAsia#setSpeller: Speller version does not match, expects Asian speller.");
            this.asianSpeller = null;
        } else {
            this.asianSpeller = (SpellerControllerAsia)spellerController;
        }
    }

    protected void processTouchResult(String string) {
        if (!this.isInputLocked()) {
            if (this.asianSpeller != null) {
                if (null == string) {
                    return;
                }
                if (string.length() == 0) {
                    this.processEmptyTouchResult();
                    return;
                }
                if (TouchControllerAsia.isOnlyBackSpace(string)) {
                    tpLogChannelInternal.log(10000000, "#TouchControllerAsia#forwardTouchpadCharactersToSpeller: forwardTouchpadCharactersToSpeller with result \\b");
                    if (!this.asianTouchInputData.hasNonRegularCharacters()) {
                        this.handleDeletionForTruffleButton();
                        this.setEmptyWordPredictionContext();
                    }
                    this.forwardTouchpadCharactersToSpeller(string);
                } else {
                    this.asianTouchInputData.setHandWrittenModeIsActive(true);
                    super.setLastInputByTouch(true);
                    if (this.isMatchspellerModel()) {
                        this.notifyMatchspellerModelAboutInputModeChange(1);
                        if (this.asianTouchInputData.hasTouchResultPreview()) {
                            this.asianTouchInputData.acceptTouchResultPreview();
                            this.isImplicityAccept = true;
                        } else {
                            if (this.currentInputModeSetForMatchspeller == 1) {
                                tpLogChannelInternal.log(10000000, "TouchControllerAsia#processTouchResult [MODEL COMMUNICATION ->] calling nonAlphaNumTPCharsChanged with \"%1\"", (Object)string);
                                ((MatchspellerModelGUI)this.model).nonAlphaNumTPCharsChanged(string, this.terminal.getTerminalID());
                            } else {
                                tpLogChannelInternal.log(10000000, "TouchControllerAsia#processTouchResult: calling mode_speller filteredRecognizedCharacters = %1", (Object)string);
                                string = this.filterAgainstValidChars(string);
                                if (!StringUtilities.isNullOrEmpty(string)) {
                                    this.openTouchResultLine(string);
                                } else {
                                    this.speakHighConfidenceCharIfApplies();
                                }
                            }
                            if (this.isImplicityAccept) {
                                this.isImplicityAccept = false;
                            }
                        }
                    } else {
                        this.openTouchResultLine(string);
                    }
                }
            } else {
                tpLogChannelInternal.log(10000000, "#TouchControllerAsia#processTouchResult: Speller is NULL and call super#processTouchResult");
                super.processTouchResult(string);
            }
            this.updateInfoLineState(false);
            this.updateInputDescriptionLineVisibility(false);
        } else {
            this.cacheRecognizedChars(string);
        }
    }

    private String filterAgainstValidChars(String string) {
        IPRPEngine iPRPEngine = this.getPRPEngineForMatchSpellerFiltering();
        iPRPEngine.process(string, null, this.getMatchSpellerValidChars(), true);
        return iPRPEngine.getResult();
    }

    private IPRPEngine getPRPEngineForMatchSpellerFiltering() {
        if (this.prpEngineForMatchspellerFiltering == null) {
            this.prpEngineForMatchspellerFiltering = new PRPEngineAsia(18193, this.asianSpeller.getSpellerMode(), super.getInputData(), 14, IWidgetLogChannel.logPRPEngine);
        }
        return this.prpEngineForMatchspellerFiltering;
    }

    protected boolean needRequestBigStageForTouchResult(String string) {
        return !TouchControllerAsia.isOnlyBackSpace(string);
    }

    protected void processEmptyTouchResult() {
        this.asianTouchInputData.acceptTouchResultPreview();
        this.forwardTouchpadCharactersToSpeller("");
    }

    private void cacheRecognizedChars(String string) {
        if (null == this.cacheLastblockedTouchInputCharacter) {
            this.cacheLastblockedTouchInputCharacter = new Buffer();
        }
        this.cacheLastblockedTouchInputCharacter.append(string);
    }

    public void destroyCache() {
        if (null != this.cacheLastblockedTouchInputCharacter) {
            this.cacheLastblockedTouchInputCharacter.clear();
            this.cacheLastblockedTouchInputCharacter = null;
        }
    }

    public void changeCharset(int n) {
        super.changeCharset(n);
        if (n == 0) {
            this.setConversionLineVisible(false);
        } else if (this.isSpellerOpen()) {
            this.updateInputDescriptionLineVisibility(true);
        } else {
            this.setConversionLineVisible(false);
        }
    }

    public static boolean isOnlyBackSpace(String string) {
        return !StringUtilities.isNullOrEmpty(string) && string.length() == 1 && string.charAt(0) == '\b';
    }

    private void forwardTouchpadCharactersToSpeller(String string) {
        if (!this.isTextMaxLengthMet()) {
            tpLogChannelInternal.log(10000000, "#TouchControllerAsia#forwardTouchpadCharactersToSpeller: Last valid chars [%1]", (Object)string);
            this.asianSpeller.touchPadFilteredCharactersRecognized(string);
            if (this.isMatchspellerModel()) {
                boolean bl = false;
                if (string != null) {
                    boolean bl2 = bl = string.indexOf(" ") >= 0;
                }
                if (this.getMatchSpellerValidChars() != null) {
                    bl |= this.getMatchSpellerValidChars().indexOf(" ") >= 0;
                }
                this.asianSpeller.getTouchResultLine().setSpaceItemEnabled(bl);
            }
            if (!this.implicitlyAcceptTouchResultPreviewIfNeeded()) {
                super.processTouchResult(string);
            } else if (!this.isOpenSpellerAfterViewSizeChange()) {
                this.checkShowHints();
            }
        } else if (TouchControllerAsia.isOnlyBackSpace(string)) {
            this.asianSpeller.touchPadFilteredCharactersRecognized(string);
            if (!this.implicitlyAcceptTouchResultPreviewIfNeeded()) {
                super.processTouchResult(string);
            } else if (!this.isOpenSpellerAfterViewSizeChange()) {
                this.checkShowHints();
            }
        } else {
            this.speakRecogCharWithNegtiveTone(string);
        }
    }

    private void speakRecogCharWithNegtiveTone(String string) {
        if (StringUtilities.isNullOrEmpty(string)) {
            return;
        }
        char c2 = string.charAt(0);
        String string2 = Character.toString(c2);
        tpLogChannelInternal.log(10000000, "TouchControllerAsia#forwardTouchpadCharactersToSpeller: max text length reached speak char('%1') followed by negative tone", (Object)string2);
        if (this.fingerTraceWidget.isMinStrokeReached()) {
            this.getTouchUtil().speakCharWithNegativeTone(string2);
        }
    }

    private void checkShowHints() {
        this.checkShowDeleteHint();
        this.checkShowSpaceHint();
    }

    private void checkShowSpaceHint() {
        if (this.shouldShowSpaceHint(' ')) {
            this.showUserHintAnimation(78);
        }
    }

    private void checkShowDeleteHint() {
        if (this.shouldShowDeleteHint()) {
            this.showUserHintAnimation(75);
        }
    }

    protected boolean shouldShowSpaceHint(char c2) {
        return this.checkInputCondition() && c2 != '\b';
    }

    private boolean checkInputCondition() {
        if (this.getCurrentFocusState() == TouchControllerFocusState.CONVERSION_LINE_FOCUS) {
            return this.asianTouchInputData.getTextLength() + (this.asianTouchInputData.hasTouchResultPreview() ? 1 : this.asianTouchInputData.getUnconvertedCharacters().length()) >= 2;
        }
        return this.asianTouchInputData.getTextLength() + (this.asianTouchInputData.hasTouchResultPreview() ? 1 : this.asianTouchInputData.getUnconvertedCharacters().length()) == 2;
    }

    private boolean shouldShowDeleteHint() {
        return this.asianTouchInputData.getCurrentText().length() == 0 && this.asianTouchInputData.isHandWrittenModeActive();
    }

    private boolean implicitlyAcceptTouchResultPreviewIfNeeded() {
        boolean bl = this.asianSpeller.hasPendingTouchResult();
        if (bl) {
            this.asianTouchInputData.acceptTouchResultPreview();
            this.asianTouchInputData.setTouchResultPreview(this.asianSpeller.getPendingTouchResult());
        }
        return bl;
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        if (this.isMatchspellerModel()) {
            tpLogChannelInternal.log(10000000, "TouchControllerAsia#processModelUpdateEvent [MODEL COMMUNICATION <-] processing event %1", (Object)modelUpdateEvent);
            if (modelUpdateEvent.getUpdateType() == 17) {
                String string = ((MatchspellerModelGUI)this.model).getValidNonAlphaNumTPCharacters(this.terminal.getTerminalID());
                tpLogChannelInternal.log(10000000, "TouchControllerAsia#processModelUpdateEvent: VALID_TP_CHARS_CHANGED, validNonAlphaNumTPCharacters=\"%1\"", (Object)string);
                if (string != null) {
                    if (string.length() == 0) {
                        if (this.currentFocusState == TouchControllerFocusState.TOUCH_RESULT_LINE_FOCUS) {
                            this.forwardTouchpadCharactersToSpeller("");
                        } else if (this.currentFocusState != TouchControllerFocusState.INPUT_LINE_FOCUS) {
                            this.notifyMatchspellerModelAboutInputModeChange(0);
                            this.asianTouchInputData.setHandWrittenModeIsActive(false);
                        }
                        this.speakHighConfidenceCharIfApplies();
                    } else if (TouchControllerAsia.isOnlyBackSpace(string)) {
                        if (!this.asianTouchInputData.hasNonRegularCharacters()) {
                            this.asianTouchInputData.delete(false);
                        }
                        this.forwardTouchpadCharactersToSpeller(string);
                    } else {
                        this.stringToSpeak = String.valueOf(string.charAt(0));
                        this.openTouchResultLine(string);
                    }
                } else {
                    this.speakHighConfidenceCharIfApplies();
                }
                modelUpdateEvent.consume();
            } else if (modelUpdateEvent.getUpdateType() == 19 && this.strokeMatchspellerProtocol != null) {
                tpLogChannelInternal.log(10000000, "#TouchControllerAsia#processModelUpdateEvent: VALID_CONVERSION_CHARS_CHANGED, isWaitingForMatchSpellerDataBack=%1", this.isInputLocked());
                this.strokeMatchspellerProtocol.notifyMatchspellerStrokeConversionsAvailable();
                modelUpdateEvent.consume();
            } else if (modelUpdateEvent.getUpdateType() == 1) {
                if (this.asianTouchInputData.hasUnconvertedCharacters() && this.asianTouchInputData.getInputMethod() == AsianInputMethod.STROKE) {
                    this.strokeMatchspellerProtocol.notifyModelTextValueChanged();
                } else {
                    this.updateValueFromModel();
                }
                modelUpdateEvent.consume();
            } else if (modelUpdateEvent.getUpdateType() == 11) {
                super.processModelUpdateEvent(modelUpdateEvent);
                this.setToggleCharSetButtonEnabledForMatchSpeller();
            }
            tpLogChannelInternal.log(10000000, "#TouchControllerAsia#processModelUpdateEvent: event was consumed: %1", modelUpdateEvent.isConsumed());
        }
        if (!modelUpdateEvent.isConsumed() || modelUpdateEvent.getUpdateType() == 10) {
            super.processModelUpdateEvent(modelUpdateEvent);
        }
        if (!this.isInputLocked() && modelUpdateEvent.isConsumed() && this.isMatchspellerModel() && this.isImplicityAccept) {
            tpLogChannelInternal.log(10000000, "#TouchControllerAsia#processModelUpdateEvent: processing touch event after model updated because of implicitly acception of touch preview,  chars are [%1]", (Object)this.cachedTouchEvent.getRecognizedCharacters());
            this.isImplicityAccept = false;
            this.asianSpeller.touchPadFilteredCharactersRecognized("");
            this.touchPadCharactersRecognizedAction(this.cachedTouchEvent, true);
        }
    }

    protected void updateSuggestions() {
        if (this.model instanceof SpellerModelGUI) {
            if (this.isTruffleSearch() && !this.blockSuggestions) {
                SpellerModelGUI spellerModelGUI = (SpellerModelGUI)this.model;
                String string = spellerModelGUI.getTruffleSuggestion();
                if (!StringUtilities.isNullOrEmpty(string)) {
                    string = StringUtilities.trimEnd(string);
                    string = this.inputFieldData.doCaseBalancingForSuggestion(string);
                }
                if (tpLogChannelInternal.isDebug()) {
                    tpLogChannelInternal.log(10000000, "TouchControllerAsia#updateSuggestions: set new suggestion=%1 / current text is: %2", (Object)string, (Object)this.inputFieldData.getCurrentText());
                }
                this.asianTouchInputData.setSuggestion(string);
                this.updateSuggestionParts();
            } else {
                super.updateSuggestions();
            }
        }
    }

    protected void updateSuggestionParts() {
        if (this.shouldIgnoreSuggestionUpdate()) {
            return;
        }
        this.setCompositesDirty(true);
        boolean bl = this.suggestionsAvailable();
        if (this.getCurrentFocusState() == TouchControllerFocusState.SPELLER_LINE_FOCUS || this.getCurrentFocusState() == TouchControllerFocusState.CONVERSION_LINE_FOCUS) {
            this.conversionLine.onSuggestionChange(bl);
        } else if (this.getCurrentFocusState() == TouchControllerFocusState.TOUCH_PREDICTION_LINE_FOCUS || this.getCurrentFocusState() == TouchControllerFocusState.TOUCH_RESULT_LINE_FOCUS) {
            this.asianSpeller.onSuggestionChange(bl);
        }
    }

    private boolean shouldIgnoreSuggestionUpdate() {
        return !this.isWordPredictionAvailable() || !this.isTruffleSearch() || this.asianTouchInputData.getCurrentText().length() < 1 && this.getCurrentFocusState() != TouchControllerFocusState.TOUCH_RESULT_LINE_FOCUS || this.isSpellerClosed();
    }

    public void clearSuggestion() {
        this.asianTouchInputData.setSuggestion(null);
        this.updateSuggestionParts();
    }

    public String getCurrentSuggestion() {
        return this.asianTouchInputData.getSuggestion();
    }

    public boolean suggestionsAvailable() {
        return this.asianTouchInputData.isSuggestionValid() && this.isSpellerOpen();
    }

    private void speakHighConfidenceCharIfApplies() {
        MatchspellerModelGUI matchspellerModelGUI = (MatchspellerModelGUI)this.model;
        if (!matchspellerModelGUI.isFullMatch()) {
            String string = null;
            if (this.prpEngine != null) {
                string = this.prpEngine.getSpeechTopMatch();
            }
            tpLogChannelInternal.log(100000000, "#TouchControllerAsia#speakHighConfidenceCharIfApplies: charToSpeak=\"%1\"", (Object)string);
            if (!StringUtilities.isNullOrEmpty(string)) {
                this.getTouchUtil().speakCharWithNegativeTone(string);
            }
        }
    }

    protected void setToggleCharSetButtonEnabledForMatchSpeller() {
        if (this.isMatchspellerModel() && (this.getTouchUtil().isTraditionalChineseSystemLanguage() || this.getTouchUtil().isSystemLanguageKorean())) {
            boolean bl = this.isCharSetToggleButtonEnabled(this.getMatchSpellerValidChars());
            SpellerController.ToggleCharsetButtonItem toggleCharsetButtonItem = this.asianSpeller.getCharsetToggleButton();
            if (toggleCharsetButtonItem != null && toggleCharsetButtonItem.isEnabled() != bl) {
                toggleCharsetButtonItem.setEnabled(bl);
            }
        }
    }

    private void openTouchResultLine(String string) {
        tpLogChannelInternal.log(10000000, "#TouchControllerAsia#openTouchResultLine: validNonAlphaNumTPCharacters: %1", (Object)string);
        if (!this.isTextMaxLengthMet()) {
            this.setFocusState(TouchControllerFocusState.TOUCH_RESULT_LINE_FOCUS);
        } else if (TouchControllerAsia.isOnlyBackSpace(string)) {
            this.setFocusState(TouchControllerFocusState.TOUCH_RESULT_LINE_FOCUS);
        }
        if (!this.isSpellerOpen() && !this.animationListener.isSpellerOpening()) {
            this.handleSpellerState(true, true);
        }
        this.forwardTouchpadCharactersToSpeller(string);
    }

    protected void propagateValidChars(boolean bl) {
        if (this.currentFocusState == TouchControllerFocusState.TOUCH_RESULT_LINE_FOCUS) {
            if (this.isMatchspellerModel()) {
                return;
            }
            if (this.asianSpeller.getCurrentSpellerBand() instanceof SpellerControllerAsia.TouchResultsLine) {
                ITouchResultLine iTouchResultLine = this.asianSpeller.getTouchResultLine();
                if (this.isTextMaxLengthMet()) {
                    iTouchResultLine.setSpaceItemEnabled(false);
                } else {
                    iTouchResultLine.setSpaceItemEnabled(true);
                }
            }
        } else {
            this.updateMatchSpellerToggleToneCaseButtonStatus();
            super.propagateValidChars(bl);
        }
    }

    protected void stringEntered(String string, String[] stringArray) {
        boolean bl;
        boolean bl2 = '\b' == TouchControllerAsia.getMostPlausibleCharacter(string) && this.asianTouchInputData.hasNonRegularCharacters();
        boolean bl3 = bl = '\b' == TouchControllerAsia.getMostPlausibleCharacter(string) && !this.asianTouchInputData.hasNonRegularCharacters() && this.shouldUseWordPrediction();
        if (bl2) {
            this.asianTouchInputData.insertString(string, stringArray, true);
            this.partialConversionHelper.setIsDeleteOperation(true);
            this.clearSuggestion();
            this.blockSuggestions = true;
        } else {
            if (bl) {
                this.handleDeleteWithoutUnconvertedCharsButWithWP();
                this.clearSuggestion();
                this.blockSuggestions = true;
            }
            super.stringEntered(string, stringArray);
        }
        this.checkShowSpaceHint();
    }

    public void handleDeletionForTruffleButton() {
        if (this.isTruffleActive()) {
            if ((this.getCurrentFocusState() == TouchControllerFocusState.CONVERSION_LINE_FOCUS || this.getCurrentFocusState() == TouchControllerFocusState.SPELLER_LINE_FOCUS) && this.getConversionLine().isVisible()) {
                this.getConversionLine().onConversionAvailableChange("", Collections.EMPTY_LIST);
                ConversionLineController.TRUFFLE_BUTTON_ITEM.setEnabled(false);
            } else if (this.getCurrentFocusState() == TouchControllerFocusState.TOUCH_PREDICTION_LINE_FOCUS) {
                this.asianSpeller.getTouchPredictionLine().getTruffleButton().setEnabled(false);
            }
        }
    }

    public final boolean isTruffleActive() {
        return this.isTruffleSearch() && this.isWordPredictionAvailable();
    }

    public void handleDeleteWithoutUnconvertedCharsButWithWP() {
        this.getConversionLine().setMode(1);
        if (this.isSpellerOpen() && this.getCurrentFocusState() == TouchControllerFocusState.CONVERSION_LINE_FOCUS) {
            this.setFocusState(TouchControllerFocusState.SPELLER_LINE_FOCUS);
        }
        this.handleDeletionForTruffleButton();
    }

    protected boolean shouldSpellerCloseAfterTouchInput() {
        return false;
    }

    protected IPRPEngine getPRPEngine(int n) {
        return new PRPEngineAsia(super.getTouchpadMode(), this.asianSpeller.getSpellerMode(), super.getInputData(), n, logPRPEngine);
    }

    public String getAllNonRegularCharacters() {
        if (this.asianTouchInputData.hasUnconvertedCharacters()) {
            return this.asianTouchInputData.getUnconvertedCharacters();
        }
        if (this.asianTouchInputData.hasTouchResultPreview()) {
            return this.asianTouchInputData.getTouchResultPreview();
        }
        return "";
    }

    protected void handleTurnEvent(WheelButtonEvent wheelButtonEvent) {
        this.currentFocusState.getKeyHandler().handleKeyTurn(this, wheelButtonEvent);
        if (!wheelButtonEvent.isConsumed()) {
            super.handleTurnEvent(wheelButtonEvent);
        }
    }

    protected void setTouchResultPreviewIfExisting() {
        if (this.asianSpeller != null && this.asianSpeller.hasPendingTouchResult()) {
            String string = this.asianSpeller.getPendingTouchResult();
            this.asianTouchInputData.setTouchResultPreview(string);
        }
    }

    public void setHandWrittenModeIsActive(boolean bl) {
        this.asianTouchInputData.setHandWrittenModeIsActive(false);
    }

    public boolean isToggleButtonTargetOfCursor() {
        return this.asianSpeller.isToggleButtonTargetOfCursor();
    }

    public boolean hasNonRegularCharacters() {
        return this.asianTouchInputData.hasNonRegularCharacters();
    }

    public String getFullTextFromInputField() {
        return this.asianTouchInputData.getFullText();
    }

    protected void handleMoveEvent(JoystickEvent joystickEvent) {
        this.currentFocusState.getKeyHandler().handleKeyMove(this, joystickEvent);
        if (!joystickEvent.isConsumed()) {
            super.handleMoveEvent(joystickEvent);
        }
    }

    protected void handlePressedEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 17 && this.isSpellerClosed()) {
            this.openSpeller(true);
            keyEvent.consume();
        }
        this.currentFocusState.getKeyHandler().handleKeyPress(this, keyEvent);
        if (!keyEvent.isConsumed()) {
            super.handlePressedEvent(keyEvent);
        }
        if (this.currentFocusState == TouchControllerFocusState.TOUCH_RESULT_LINE_FOCUS || this.currentFocusState == TouchControllerFocusState.TOUCH_PREDICTION_LINE_FOCUS) {
            super.setLastInputByTouch(true);
        }
    }

    protected void handleHKBackShortPress() {
        if (this.currentFocusState == TouchControllerFocusState.TOUCH_RESULT_LINE_FOCUS || this.currentFocusState == TouchControllerFocusState.TOUCH_PREDICTION_LINE_FOCUS) {
            this.asianSpeller.clearTouchResultsFromBand();
        }
        this.handleDeletionForTruffleButton();
        if (this.asianTouchInputData.hasNonRegularCharacters()) {
            this.stringEntered(BACKSPACE, null);
        } else {
            super.handleHKBackShortPress();
            this.partialConversionHelper.setIsDeleteOperation(true);
            this.blockSuggestions = true;
            this.setEmptyWordPredictionContext();
        }
    }

    protected void handleHKBackLongPress() {
        super.handleHKBackLongPress();
        this.partialConversionHelper.reset();
    }

    protected void setLanguage(TouchCharSetAndTTSHandler touchCharSetAndTTSHandler) {
        boolean bl;
        super.setLanguage(touchCharSetAndTTSHandler);
        if (this.isTextMaxLengthMet()) {
            this.asianSpeller.updateValidChars("");
        }
        this.setToggleCharSetButtonEnabledForMatchSpeller();
        AsianInputMethod asianInputMethod = touchCharSetAndTTSHandler.getAsianInputMethodForInternalLanguage();
        boolean bl2 = bl = this.asianSpeller.getSpellerMode() == 11 && asianInputMethod == AsianInputMethod.STROKE;
        if (!bl) {
            if (this.isSpellerInMatchspellerMode()) {
                asianInputMethod = AsianInputMethod.NO_CONVERSION;
            } else if (this.isLatinOnly()) {
                asianInputMethod = AsianInputMethod.NO_CONVERSION;
                this.setWordPredictionAccess(IWordPredictionAccess.NULL);
            }
        }
        this.asianTouchInputData.setInputMethod(asianInputMethod);
        this.initializeConversionDataFetcher(asianInputMethod);
        if (!this.isTextMaxLengthMet()) {
            this.conversionDataFetcher.requestInitialValidCharacters();
        }
        this.partialConversionHelper.reset();
    }

    private boolean isSpellerInMatchspellerMode() {
        return this.asianSpeller.getSpellerMode() == 11 || this.asianSpeller.getSpellerMode() == 9 || this.asianSpeller.getSpellerMode() == 8;
    }

    public void setFocusState(TouchControllerFocusState touchControllerFocusState) {
        TouchControllerFocusState touchControllerFocusState2;
        if (touchControllerFocusState == TouchControllerFocusState.TOUCH_RESULT_LINE_FOCUS && this.asianSpeller.getCurrentSpellerState() == SpellerBandState.TOUCH_PREDICTION_LINE) {
            touchControllerFocusState2 = TouchControllerFocusState.TOUCH_PREDICTION_LINE_FOCUS;
            if (tpLogChannelInternal.isDebug()) {
                tpLogChannelInternal.log(10000000, "TouchControllerAsia#setFocusState: argument was %1, but speller is in prediction line state -> turned it into %2", (Object)touchControllerFocusState, (Object)touchControllerFocusState2);
            }
        } else {
            touchControllerFocusState2 = touchControllerFocusState;
        }
        if (tpLogChannelInternal.isDebug()) {
            tpLogChannelInternal.log(10000000, "TouchControllerAsia#setFocusState: changing focus state from %1 to %2", (Object)this.currentFocusState, (Object)touchControllerFocusState2);
        }
        this.currentFocusState = touchControllerFocusState2;
        this.showFocusStateDebugInfo();
        this.notifySpellerAndConversionLineAboutFocusState();
    }

    public void updateInputDescriptionLineVisibility(boolean bl) {
        if (this.asianTouchInputData.hasUnconvertedCharacters()) {
            return;
        }
        if (this.checkInputDescriptionLineCriticalClosingConditions()) {
            this.setConversionLineVisible(false);
        } else if (bl) {
            this.getConversionLine().showInputDescription(this.getInputDescriptionText());
        } else if (!this.isWordPredictionAvailable() || !this.isTruffleSearch()) {
            if (this.checkInputDescriptionLineExtraClosingCondition()) {
                this.setConversionLineVisible(false);
            } else {
                this.getConversionLine().showInputDescription(this.getInputDescriptionText());
            }
        }
    }

    private boolean checkInputDescriptionLineCriticalClosingConditions() {
        return this.asianSpeller == null || this.asianTouchInputData.getInputMethod().getInputDescriptionId() == -1 || TouchControllerFocusState.TOUCH_RESULT_LINE_FOCUS == this.getCurrentFocusState() || TouchControllerFocusState.TOUCH_PREDICTION_LINE_FOCUS == this.getCurrentFocusState() || TouchControllerFocusState.INPUT_LINE_FOCUS == this.getCurrentFocusState();
    }

    private boolean checkInputDescriptionLineExtraClosingCondition() {
        return this.isSpellerInMatchspellerMode() && this.asianTouchInputData.getInputMethod() != AsianInputMethod.STROKE || this.asianTouchInputData.getCurrentText().length() > 0 || this.asianTouchInputData.getUnconvertedCharacters().length() > 0 || !this.isSpellerOpen();
    }

    private void notifySpellerAndConversionLineAboutFocusState() {
        boolean bl = this.currentFocusState == TouchControllerFocusState.CONVERSION_LINE_FOCUS;
        this.conversionLine.setHasTouchControllerFocus(bl);
        this.asianSpeller.setConversionLineFocused(bl);
    }

    public TouchControllerFocusState getCurrentFocusState() {
        return this.currentFocusState;
    }

    protected SpellerController getSpeller() {
        return this.asianSpeller;
    }

    protected int getRightDrawerCategoryForThisWidget() {
        return -798640533;
    }

    protected boolean isRightDrawerConditionSpellerOpen() {
        return this.getCurrentFocusState() == TouchControllerFocusState.SPELLER_LINE_FOCUS || this.getCurrentFocusState() == TouchControllerFocusState.CONVERSION_LINE_FOCUS;
    }

    protected boolean isCharsetSwitchingAvailable() {
        boolean bl = super.isCharsetSwitchingAvailable();
        if (bl && this.isMatchspellerModel()) {
            if (this.getTouchUtil().isTraditionalChineseSystemLanguage() || this.getTouchUtil().isSystemLanguageKorean()) {
                return this.isCharSetToggleButtonEnabled(this.getMatchSpellerValidChars());
            }
            return false;
        }
        return bl;
    }

    public void predisconnecting() {
        this.setMatrixPopupVisible(false);
        this.wordPredictionAccess.spellerDisconnected();
        super.predisconnecting();
    }

    public void disconnecting() {
        if (tpLogChannelInternal.isDebug2()) {
            tpLogChannelInternal.log(100000000, "TouchControllerAsia#disconnecting: Disconnecting");
        }
        this.asianTouchInputData.clear(false);
        this.setConversionLineVisible(false);
        this.conversionMatrixModel.setIsActivated(false);
        this.conversionMatrixModel.unRegisterConversionCandidateSelectionHandler(this.touchControllerAsSelectionHandler);
        this.conversionMatrixModel.removeConversionFetcher(this.conversionDataFetcher);
        this.conversionMatrixModel.removeConversionMatrixPreparationFinishedListener();
        this.destroyCache();
        this.partialConversionHelper.reset();
        super.disconnecting();
        this.currentInputModeSetForMatchspeller = 0;
        TouchControllerDebugInfo.clear(this.terminal);
    }

    protected void handleBigStageAndSpellerOpen() {
        super.handleBigStageAndSpellerOpen();
        this.updateInputDescriptionLineVisibility(true);
        if (this.asianSpeller.getCurrentSpellerState() != SpellerBandState.DEFAULT_SPELLER) {
            this.checkShowHints();
        }
    }

    protected void setMatrixPopupVisible(boolean bl) {
        IPartialPopupManagerEvo iPartialPopupManagerEvo = this.terminal.getPartialPopupManagerEvo();
        if (iPartialPopupManagerEvo != null) {
            if (bl) {
                iPartialPopupManagerEvo.showPopup(119, this.conversionMatrixModel);
            } else {
                iPartialPopupManagerEvo.hidePopup(119);
            }
        }
    }

    public void showMatrixPopup() {
        tpLogChannelInternal.log(10000000, "TouchControllerAsia#showMatrixPopup tried to open the conversion matrix with unconverted characters: %1", (Object)this.asianTouchInputData.getUnconvertedCharacters());
        this.connectMatrixModelToMatrixController();
        this.conversionMatrixModel.setIsActivated(true);
        this.setConversionLineVisible(false);
        String string = this.asianTouchInputData.getUnconvertedCharacters();
        this.conversionMatrixModel.setUnconvertedCharacters(string, this);
    }

    protected void connectMatrixModelToMatrixController() {
        if (this.terminal.getPartialPopupManagerEvo() != null) {
            IPartialPopupController iPartialPopupController = this.terminal.getPartialPopupManagerEvo().getPartialPopup(119);
            ConversionMatrixController.connectConversionMatrixControllerWithModel(iPartialPopupController, this.conversionMatrixModel);
        } else {
            tpLogChannelInternal.log(10000, "TouchControllerAsia#initializeWidget: Could not retrieve IPartialPopupManagerEvo.");
        }
    }

    public void setConversionLineVisible(boolean bl) {
        if (TouchControllerAsia.isKr() && !this.isWordPredictionAvailable && bl) {
            return;
        }
        if (this.conversionLine != null) {
            this.conversionLine.setConversionLineVisible(bl);
        } else {
            tpLogChannelInternal.log(10000000, "TouchControllerAsia#setConversionLineVisible tried to set the conversion line visibility to %1, but the controller was null.", bl);
        }
    }

    protected void handleTouchInputDataChanged(int n, boolean bl, String string, String string2) {
        if (tpLogChannelInternal.isDebug2()) {
            tpLogChannelInternal.log(100000000, "TouchControllerAsia#handleTouchInputDataChanged TouchInputDataAsia update type = %1 / modelNotification = %2 / old text = %3 / new text = %4.", (Object)String.valueOf(n), (Object)String.valueOf(bl), (Object)string, (Object)string2);
        }
        if (n == 2 && !this.suppressTTSOutput() && !StringUtilities.isNullOrEmpty(string2)) {
            if (StringUtilities.isNullOrEmpty(string)) {
                this.getTouchUtil().speakChar(string2);
            } else {
                this.timerListenerAsia.speakPreviewCharacter(string2);
            }
        } else if (n == 1 && this.modelNeedsTextUpdate(string2)) {
            super.handleTouchInputDataChanged(n, bl, string, string2);
            this.setEnteredString(string2);
        }
        if (n == 1) {
            this.updateInputDescriptionLineVisibility(false);
            this.updateSuggestionParts();
        } else if (n == 3) {
            this.updateFreeInputToggleToneCaseButtonStatus();
        }
    }

    protected String getInputDescriptionText() {
        return AbstractWidget.hmiService.getText(this.asianTouchInputData.getInputMethod().getInputDescriptionId());
    }

    public void toggleCharStatusForJapan() {
        if (!TouchControllerAsia.isJp()) {
            return;
        }
        if (this.isMatchspellerModel()) {
            this.toggleCharStatusForMatchInput();
        } else if (this.asianTouchInputData.getInputMethod() == AsianInputMethod.HIRAGANA) {
            this.toggleCharStatusForFreeInput();
        }
    }

    private void toggleCharStatusForMatchInput() {
        String string;
        String string2;
        if (this.asianTouchInputData.getTextLength() > 0 && AbstractToneAndCaseTogglingTable.hasToneOrCaseVariance(string2 = (string = this.asianTouchInputData.getCurrentText()).substring(string.length() - 1))) {
            AbstractToneAndCaseTogglingTable.ICharacterWithToneAndCase iCharacterWithToneAndCase = AbstractToneAndCaseTogglingTable.getCharWithToneAndCaseForJPLang(string2);
            String string3 = String.valueOf(iCharacterWithToneAndCase.getNextCharWithStatus().getCurrentStatusChar());
            this.asianTouchInputData.delete(false);
            this.asianTouchInputData.appendRegularCharacters(string3, true);
        }
    }

    private void toggleCharStatusForFreeInput() {
        String string;
        String string2;
        if (this.asianTouchInputData.hasUnconvertedCharacters() && AbstractToneAndCaseTogglingTable.hasToneOrCaseVariance(string2 = (string = this.asianTouchInputData.getUnconvertedCharacters()).substring(string.length() - 1))) {
            AbstractToneAndCaseTogglingTable.ICharacterWithToneAndCase iCharacterWithToneAndCase = AbstractToneAndCaseTogglingTable.getCharWithToneAndCaseForJPLang(string2);
            String string3 = String.valueOf(iCharacterWithToneAndCase.getNextCharWithStatus().getCurrentStatusChar());
            this.asianTouchInputData.replaceLastUnconvertedCharacter(string3);
        }
    }

    public void handleSpellerLastMode() {
        if (this.spellerLastMode == 1 && this.isEnabled()) {
            super.handleSpellerLastMode();
        }
    }

    private void updateMatchSpellerToggleToneCaseButtonStatus() {
        if (this.asianSpeller != null) {
            boolean bl = false;
            if (this.asianTouchInputData.getTextLength() > 0) {
                String string = this.asianTouchInputData.getCurrentText();
                String string2 = string.substring(string.length() - 1);
                if (!"".equals(this.toneLowerCaseButtonValidChars) && AbstractToneAndCaseTogglingTable.hasToneOrCaseVariance(string2)) {
                    bl = true;
                }
            }
            this.asianSpeller.setToneCaseToggleButtonStatus(bl);
        }
    }

    private void updateFreeInputToggleToneCaseButtonStatus() {
        if (this.asianSpeller != null) {
            String string;
            String string2;
            boolean bl = false;
            if (this.asianTouchInputData.hasUnconvertedCharacters() && AbstractToneAndCaseTogglingTable.hasToneOrCaseVariance(string2 = (string = this.asianTouchInputData.getUnconvertedCharacters()).substring(string.length() - 1))) {
                bl = true;
            }
            this.asianSpeller.setToneCaseToggleButtonStatus(bl);
        }
    }

    private boolean isJPMapCode() {
        return TouchControllerAsia.isJp() && this.getTouchpadMode() == 22;
    }

    private boolean isMatchedPhoneNumber() {
        return this.getTouchpadMode() == 23 && (TouchControllerAsia.isJp() || TouchControllerAsia.isKr());
    }

    protected boolean checkIfModelUpdateChangesText(String string) {
        if (this.isTruffleSearch()) {
            String string2 = StringUtility.concatenate(this.asianTouchInputData.getCurrentText(), this.asianTouchInputData.getTouchResultPreview());
            return !string2.equals(string);
        }
        boolean bl = super.checkIfModelUpdateChangesText(string);
        int n = this.inputFieldData.getCurrentText().length();
        if (bl && n > 0 && n < string.length()) {
            this.setToneLowerCaseButtonValidChars("");
        }
        return bl;
    }

    public void forceFocusOnItem(SpellerController.SpellerButtonType spellerButtonType) {
        if (spellerButtonType.isCharsetToggleButton()) {
            this.asianSpeller.focusToCharSetToggleButtonIfPossible(spellerButtonType);
        }
    }

    protected IConversionMatrixModel getConversionMatrixModel() {
        return this.conversionMatrixModel;
    }

    private boolean isCharSetToggleButtonEnabled(String string) {
        boolean bl = false;
        SpellerController.ISpellerBand iSpellerBand = this.asianSpeller.getCurrentSpellerBand();
        if (iSpellerBand instanceof SpellerControllerAsia.SpellerBandImplAsia) {
            SpellerControllerAsia.SpellerBandImplAsia spellerBandImplAsia = (SpellerControllerAsia.SpellerBandImplAsia)iSpellerBand;
            int n = spellerBandImplAsia.getSpellerBandInternalLanguage();
            if (n == 15) {
                bl = StringUtility.containsAny(string, "\u4e00\u4e28\u4e3f\u4e36\u4e59".toCharArray(), false);
            } else if (n == 25) {
                bl = StringUtility.containsAny(string, "\u3105-\u3129".toCharArray(), true);
                if (!bl) {
                    bl |= StringUtility.containsAny(string, "\u02ca\u02c7\u02cb\u02d9".toCharArray(), false);
                }
            } else if (n == 17) {
                bl = StringUtility.containsAny(string, "\u3131-\u3163".toCharArray(), true);
            } else if (!(n != 23 && n != 24 && n != 16 || (bl = StringUtility.containsAny(string, "A-Z".toCharArray(), true)))) {
                bl |= StringUtility.containsAny(string, "a-z".toCharArray(), true);
            }
        }
        return bl;
    }

    protected boolean getIsTouchpadKeypanelWithActiveStatus() {
        return this.terminal.getKbdService().isTouchKeypanel() && !this.isJPMapCode() && !this.isMatchedPhoneNumber();
    }

    protected boolean isTextMaxLengthMet() {
        int n = this.asianTouchInputData.getMaximumTextLength();
        boolean bl = false;
        bl = this.asianTouchInputData.hasTouchResultPreview() ? this.asianTouchInputData.getTextLength() + this.asianTouchInputData.getTouchResultPreview().length() >= n : (this.asianTouchInputData.hasUnconvertedCharacters() ? this.asianTouchInputData.getTextLength() + this.asianTouchInputData.getUnconvertedCharacters().length() >= n : this.asianTouchInputData.getTextLength() >= n);
        return bl;
    }

    public void touchPadCharactersRecognized(TouchEvent touchEvent) {
        if (this.isMapcodeOrMatchPhoneNumber()) {
            touchEvent.consume();
            return;
        }
        this.cachedTouchEvent = touchEvent;
        super.touchPadCharactersRecognized(touchEvent);
    }

    protected void handleAutoCompletion(String string) {
        tpLogChannelInternal.log(10000000, "TouchControllerAsia#handleAutoCompletion: completion = %1", (Object)string);
        if (this.isSpellerClosed()) {
            this.openSpeller(true);
        } else if (string != null && !StringUtilities.isNullOrEmpty(string)) {
            super.handleAutoCompletion(string);
            this.clearSuggestion();
        }
    }

    protected String getCurrentTextForSuggestion() {
        return this.asianTouchInputData.getFullText();
    }

    public void switchToSpeller(int n) {
        if (this.isSpellerOpen()) {
            this.openSpeller(true);
        }
        this.changeCharset(n);
        this.clearSuggestion();
        if (this.isSpellerOpen() && this.getCurrentFocusState() != TouchControllerFocusState.SPELLER_LINE_FOCUS) {
            this.setFocusState(TouchControllerFocusState.SPELLER_LINE_FOCUS);
        }
    }

    protected void updatePRPEngineWithLanguageIndex() {
        int n = this.getTouchUtil().getSystemLanguage();
        this.prpEngine = this.getPRPEngine(n);
    }

    protected void userHintPosUpdate(IUserHintHandler iUserHintHandler) {
        if (this.isG22High() || this.isG21()) {
            int n = -5;
            int n2 = TouchControllerAsia.getAbsoluteX(this) + this.getWidth();
            int n3 = TouchControllerAsia.getAbsoluteY(this) + this.getHeight() + n;
            tpLogChannelInternal.log(10000000, "TouchController#showUserHintAnimation: getAbsoluteY(this): " + TouchControllerAsia.getAbsoluteY(this) + ", this.getHeight(): " + this.getHeight() + ", getHintYOffset():" + n);
            tpLogChannelInternal.log(10000000, "TouchController#showUserHintAnimation: rightBorderWidget: " + n2 + ", bottomBorderOfWidget: " + n3);
            iUserHintHandler.updateUserHintPos(TouchControllerAsia.getAbsoluteX(this) + this.getWidth(), TouchControllerAsia.getAbsoluteY(this) + this.getHeight() + n);
        } else if (this.isG24MMIKombi()) {
            int n = 6;
            int n4 = TouchControllerAsia.getAbsoluteX(this) + this.getWidth();
            int n5 = TouchControllerAsia.getAbsoluteY(this) + this.getHeight() + n;
            tpLogChannelInternal.log(10000000, "TouchController#showUserHintAnimation: getAbsoluteY(this): " + TouchControllerAsia.getAbsoluteY(this) + ", this.getHeight(): " + this.getHeight() + ", getHintYOffset():" + n);
            tpLogChannelInternal.log(10000000, "TouchController#showUserHintAnimation: rightBorderWidget: " + n4 + ", bottomBorderOfWidget: " + n5);
            iUserHintHandler.updateUserHintPos(TouchControllerAsia.getAbsoluteX(this) + this.getWidth(), TouchControllerAsia.getAbsoluteY(this) + this.getHeight() + n);
        }
    }

    protected int getHintYOffset() {
        if (this.isG22High()) {
            if (!this.isSpellerClosed()) {
                return 0;
            }
            return 5;
        }
        if (this.isG24MMIKombi()) {
            if (!this.isSpellerClosed()) {
                return 11;
            }
            return 5;
        }
        return 0;
    }

    protected boolean isG24MMIKombi() {
        return AbstractWidget.isScreenResolution1440();
    }

    protected boolean isG22High() {
        return AbstractWidget.isScreenResolution1024();
    }

    protected boolean isG21() {
        return AbstractWidget.isScreenResolution800();
    }

    public void updateCandidates(String[] stringArray) {
        if (!this.isConnected()) {
            return;
        }
        if (tpLogChannelInternal.isDebug()) {
            tpLogChannelInternal.log(10000000, "TouchControllerAsia#updateCandidates: new candidates (%1)", (Object)stringArray);
        }
        if (this.conversionDataFetcher instanceof ConversionDataFetcherWordPrediction) {
            String string;
            List list;
            ConversionDataFetcherWordPrediction conversionDataFetcherWordPrediction = (ConversionDataFetcherWordPrediction)this.conversionDataFetcher;
            ITouchInputDataAsia iTouchInputDataAsia = (ITouchInputDataAsia)this.inputFieldData;
            if (stringArray == null) {
                list = Collections.EMPTY_LIST;
                string = "";
            } else {
                list = Arrays.asList(stringArray);
                string = iTouchInputDataAsia.getUnconvertedCharacters();
            }
            conversionDataFetcherWordPrediction.notifyConversionsAvailable(string, list);
            this.updateSuggestionParts();
        }
    }

    public void onWordPredictionServiceReady() {
        if (tpLogChannelInternal.isDebug()) {
            tpLogChannelInternal.log(10000000, "TouchControllerAsia#onWordPredictionServiceReady: Word prediction service ready");
        }
        if (this.isWordPredictionAvailable) {
            if (tpLogChannelInternal.isDebug()) {
                tpLogChannelInternal.log(10000000, "TouchControllerAsia#onWordPredictionServiceReady: switch to new data fetcher");
            }
            this.registerSpellerForWordPrediction();
        }
    }

    private void registerSpellerForWordPrediction() {
        String[] stringArray = this.getAdditionalDatabaseForWordPredictionID() != -1 ? new String[]{IWordPrediction.ADDITIONAL_WORDDATABASES[this.getAdditionalDatabaseForWordPredictionID()]} : EMPTY_STRING_ARRAY;
        this.wordPredictionAccess.spellerConnected(this.getTouchUtil().getSystemLanguage(), stringArray);
    }

    public void setModel(Object object) {
        super.setModel(object);
        if (this.isMatchSpellerMode()) {
            this.setWordPredictionAccess(IWordPredictionAccess.NULL);
        }
    }

    public void setModel(HMIModelGUI hMIModelGUI) {
        this.setModel((Object)hMIModelGUI);
    }

    public void setWordPredictionAccess(IWordPredictionAccess iWordPredictionAccess) {
        this.wordPredictionAccess = iWordPredictionAccess;
        this.asianTouchInputData.setWordPredictionAccess(iWordPredictionAccess);
    }

    public IConversionDataFetcher getConversionDataFetcher() {
        return this.conversionDataFetcher;
    }

    public final boolean shouldUseWordPrediction() {
        return this.isWordPredictionAvailable && !this.isMatchSpellerMode() && !this.isLatinOnly();
    }

    protected final boolean isWordPredictionUsed() {
        return this.wordPredictionAccess != IWordPredictionAccess.NULL;
    }

    public void updateSpelling(String string) {
        if (!this.isConnected()) {
            return;
        }
        if (tpLogChannelInternal.isDebug()) {
            tpLogChannelInternal.log(10000000, "TouchControllerAsia#updateSpelling: new spelling (%1)", (Object)string);
        }
        this.partialConversionHelper.handlePartialConversion(string, this.asianTouchInputData, this.wordPredictionAccess);
        this.checkShowSpaceHint();
    }

    public void updateAutoConvertedCharacters(String string) {
        if (!this.isConnected()) {
            return;
        }
        this.asianTouchInputData.appendRegularCharacters(string, true);
    }

    public void handleError(String string) {
        tpLogChannelInternal.log(10000, "TouchControllerAsia#handleError: %1", (Object)string);
        this.handleWordPredictionOutage();
    }

    public void updateWordPredictionContext(String string, boolean bl) {
        if (this.isWordPredictionAvailable()) {
            String string2 = this.asianTouchInputData.getPredictionContextWithLastInputWord(string, bl);
            if (this.getCurrentFocusState() == TouchControllerFocusState.TOUCH_PREDICTION_LINE_FOCUS || this.getCurrentFocusState() == TouchControllerFocusState.TOUCH_RESULT_LINE_FOCUS) {
                this.asianSpeller.getTouchPredictionLine().updateWordPredictionContext(string2, string);
            } else if (this.getCurrentFocusState() == TouchControllerFocusState.CONVERSION_LINE_FOCUS || this.getCurrentFocusState() == TouchControllerFocusState.SPELLER_LINE_FOCUS) {
                this.wordPredictionAccess.startContextBasedPrediction(string2, string, 36);
            }
        }
    }

    public void setEmptyWordPredictionContext() {
        if (this.isWordPredictionAvailable()) {
            if (this.getCurrentFocusState() == TouchControllerFocusState.TOUCH_PREDICTION_LINE_FOCUS || this.getCurrentFocusState() == TouchControllerFocusState.TOUCH_RESULT_LINE_FOCUS) {
                this.asianSpeller.getTouchPredictionLine().updateWordPredictionContext("", "");
            } else if (this.getCurrentFocusState() == TouchControllerFocusState.CONVERSION_LINE_FOCUS || this.getCurrentFocusState() == TouchControllerFocusState.SPELLER_LINE_FOCUS) {
                this.wordPredictionAccess.startContextBasedPrediction("", "", 36);
            }
        }
    }

    public void cacheSelectedPredictionChars(String string) {
        this.partialConversionHelper.setCurrentSelectedPredictionChars(string);
    }

    public void clear(boolean bl) {
        super.clear(bl);
        if (this.shouldUseWordPrediction() && !this.asianTouchInputData.hasNonRegularCharacters()) {
            this.handleDeleteWithoutUnconvertedCharsButWithWP();
        }
    }

    protected void clearInputData(boolean bl) {
        if (bl) {
            this.asianTouchInputData.clearModelTriggered();
        } else {
            this.asianTouchInputData.clear(!bl);
            if (this.currentFocusState == TouchControllerFocusState.TOUCH_RESULT_LINE_FOCUS || this.currentFocusState == TouchControllerFocusState.TOUCH_PREDICTION_LINE_FOCUS) {
                this.asianSpeller.clearTouchResultsFromBand();
            }
        }
    }

    public void onWordPredictionServiceRemoved() {
        this.handleWordPredictionOutage();
    }

    private void handleWordPredictionOutage() {
        this.asianTouchInputData.onWordPredictionServiceRemoved();
        this.updateCandidates(null);
        if (TouchControllerFocusState.CONVERSION_LINE_FOCUS == this.getCurrentFocusState()) {
            this.setFocusState(TouchControllerFocusState.SPELLER_LINE_FOCUS);
            this.updateSpelling("");
        } else if (TouchControllerFocusState.TOUCH_PREDICTION_LINE_FOCUS == this.getCurrentFocusState()) {
            this.setFocusState(TouchControllerFocusState.TOUCH_RESULT_LINE_FOCUS);
        }
        this.partialConversionHelper.reset();
    }

    public boolean showJumpDownToListArrow() {
        boolean bl = super.showJumpDownToListArrow();
        return bl && this.getCurrentFocusState() != TouchControllerFocusState.CONVERSION_LINE_FOCUS;
    }

    public void setToneLowerCaseButtonValidChars(String string) {
        this.toneLowerCaseButtonValidChars = string;
    }

    public void matrixPreparationFinished() {
        String string = this.asianTouchInputData.getUnconvertedCharacters();
        this.conversionMatrixModel.updateUnconvertedChars(string);
        this.setMatrixPopupVisible(true);
        this.conversionMatrixModel.removeConversionMatrixPreparationFinishedListener();
    }

    public IPartialConversionHelper getPartialConversionHelper() {
        return this.partialConversionHelper;
    }

    protected void speakAutocompletion() {
        MatchspellerModelGUI matchspellerModelGUI = (MatchspellerModelGUI)this.model;
        if (!matchspellerModelGUI.isFullMatch()) {
            super.speakAutocompletion();
        }
    }

    public void keepCloseMatrix() {
        this.conversionMatrixModel.setIsActivated(false);
        this.conversionMatrixModel.removeConversionMatrixPreparationFinishedListener();
        this.updateInputDescriptionLineVisibility(true);
    }

    public void acceptSuggestion() {
        this.asianTouchInputData.acceptSuggestion(true);
        this.updateWordPredictionContext("", true);
    }

    public boolean isWordPredictionAvailable() {
        return this.isWordPredictionAvailable;
    }

    protected boolean isLatinOnly() {
        boolean bl = super.isLatinOnly();
        bl |= this.getTouchpadMode() == 80 || this.getTouchpadMode() == 97;
        if (this.asianSpeller != null) {
            bl |= this.asianSpeller.getSpellerMode() == 6;
        }
        return bl;
    }

    public boolean shouldShowSuggestionBackground() {
        return !this.blockSuggestions && (this.conversionLineSingleTruffleButtonShowSuggestionBackground() || this.conversionLineWithCandidatesShowSuggestionBackground() || this.touchPredictionLineShowSuggestionBackground());
    }

    private boolean touchPredictionLineShowSuggestionBackground() {
        SpellerController.ButtonItem buttonItem = (SpellerController.ButtonItem)this.asianSpeller.getTouchPredictionLine().getTruffleButton();
        return this.getCurrentFocusState() == TouchControllerFocusState.TOUCH_PREDICTION_LINE_FOCUS && this.asianSpeller.getCurrentCursorTarget() == buttonItem && buttonItem.isEnabled();
    }

    private boolean conversionLineWithCandidatesShowSuggestionBackground() {
        return this.getConversionLine().isVisible() && this.getConversionLine().getCurrentFocus() == ConversionLineController.TRUFFLE_BUTTON_ITEM;
    }

    private boolean conversionLineSingleTruffleButtonShowSuggestionBackground() {
        return this.getConversionLine().isSingleTruffleButtonShowed() && ConversionLineController.TRUFFLE_BUTTON_ITEM.isEnabled();
    }

    public void menuLayouted() {
        this.getConversionLine().setSizeChanged(true);
        IFingerTraceRenderer iFingerTraceRenderer = (IFingerTraceRenderer)this.fingerTraceWidget.getRenderer();
        iFingerTraceRenderer.viewSizeChanged();
    }

    public void viewportUpdated(boolean bl) {
    }

    public void setActiveMenuController(MenuController menuController) {
    }

    public void menuFocusChanged(MenuItemIndex menuItemIndex) {
    }

    public void menuFocusChangeFinished() {
    }

    public void menuSelectionChanged(MenuItemIndex menuItemIndex, Long l, MenuUpdateDelta menuUpdateDelta) {
    }

    public void setHideOverlayDecoratorDuringScrolling(boolean bl) {
    }

    public void touchPadPositionMoved(TouchEvent touchEvent) {
        if (this.isMapcodeOrMatchPhoneNumber()) {
            return;
        }
        super.touchPadPositionMoved(touchEvent);
    }

    public boolean isStartContextBasedPredictionValid() {
        return this.shouldUseWordPrediction() && !this.touchUtil.isEnglishSystemLanguage();
    }

    public int getLanguageIndicatorIconIndex() {
        return 0;
    }

    protected boolean shouldBlockJump5Rule() {
        return this.isImplicityAccept;
    }

    protected void postActionsKeyTurn() {
    }
}

