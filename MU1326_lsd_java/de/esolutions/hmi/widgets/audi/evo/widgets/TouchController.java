/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.HMIImageConstantsSystem;
import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.TimerEvent;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.model.LabelModel;
import de.audi.atip.hmi.model.MatchspellerModel;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.modelaccess.MatchspellerModelGUI;
import de.audi.atip.hmi.modelaccess.SpellerModelGUI;
import de.audi.atip.mmicombi.IViewSizeManager;
import de.audi.atip.util.StringUtilities;
import de.audi.tghu.hmi.evo.HMITerminalEvo;
import de.audi.tghu.hmi.evo.IFocusedPropertyObject;
import de.audi.tghu.hmi.evo.ILockingListener;
import de.audi.tghu.hmi.evo.IRightDrawerActionReceiver;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.IntList;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IUserHintHandler;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.ScreenMainArea;
import de.esolutions.hmi.widgets.audi.base.StringUtility;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.base.widgets.ModelStubController;
import de.esolutions.hmi.widgets.audi.evo.ExtHMITerminalEvo;
import de.esolutions.hmi.widgets.audi.evo.FocusedPropertyObject;
import de.esolutions.hmi.widgets.audi.evo.IRendererFactory;
import de.esolutions.hmi.widgets.audi.evo.LockingManager;
import de.esolutions.hmi.widgets.audi.evo.prpframework.IPRPEngine;
import de.esolutions.hmi.widgets.audi.evo.prpframework.PRPEngineEurope;
import de.esolutions.hmi.widgets.audi.evo.widgets.FingerTraceController;
import de.esolutions.hmi.widgets.audi.evo.widgets.FingerTraceListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.IFingerTraceRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IFingerTraceWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.IInputTextInfoProvider;
import de.esolutions.hmi.widgets.audi.evo.widgets.ISpellerListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.ITouchInputData;
import de.esolutions.hmi.widgets.audi.evo.widgets.ITouchInputDataChangeHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.ITouchRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IViewSizeAnimatable;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerButtonArgument;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SuggestionController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchCharSetAndTTSHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerDebugInfo;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchInputData;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.IInputLocker;
import de.esolutions.hmi.widgets.audi.evo.widgets.factories.FingerTraceControllerFactory;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuCallback;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuCallbackProvider;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemSingle;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuCallbackAdapter;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import java.util.Iterator;

public class TouchController
extends AbstractWidgetController
implements IMenuItemSingle,
IMenuCallbackProvider,
IViewSizeAnimatable,
ATIPEventListener,
ITouchInputDataChangeHandler,
IInputLocker,
TouchCharSetAndTTSHandler.CharsetListener,
ILockingListener {
    public static final int SPELLER_Y_OFFSET_MMIKOMBI = 4;
    private static final float SPELLER_FADE_IN_POINT = 0.7f;
    public static final int TOUCHFIELD_HEIGHT = 60;
    private int topImageSmallIndex = -1;
    private int topImageBigIndex = -1;
    private int topImageSmallIndexKB = -1;
    private int topImageBigIndexKB = -1;
    private boolean isTopImageVisible = true;
    private String topImageLabelText = null;
    private ModelStubController topImageLabelTextItem = null;
    private static final int ROLE_TOP_IMAGE_LABEL_TEXT = 2;
    private boolean isLockingActive = false;
    public static final int LOCK_NOTHING = 0;
    public static final int LOCK_SPELLER = 1;
    public static final int LOCK_TOUCH = 2;
    public static final int LOCK_ANY = 3;
    private int lockLevel = 0;
    public static final int TOUCH_CONTROLLER_SCREEN_LEVEL_1 = 1;
    public static final int TOUCH_CONTROLLER_SCREEN_LEVEL_2 = 2;
    private int touchControllerScreenLevel = 1;
    private ModelStubController lockSpellerInputModel = null;
    private ModelStubController lockAllInputModel = null;
    private static final int NO_SPELLER_INPUT_POPUP = 192;
    private static final int NO_GENERAL_INPUT_POPUP = 191;
    public static final int MODE_MATCH_SPELLER_GENERAL = 16;
    public static final int MODE_MATCH_SPELLER_NAV_DEST_COUNTRY = 17;
    public static final int MODE_MATCH_SPELLER_NAV_DEST_CITY = 18;
    public static final int MODE_MATCH_SPELLER_NAV_DEST_STREET = 19;
    public static final int MODE_MATCH_SPELLER_NAV_DEST_HOUSENUMBER = 20;
    public static final int MODE_MATCH_SPELLER_PHONE_STANDARD = 21;
    public static final int MODE_MATCH_SPELLER_JP_MAPCODE = 22;
    public static final int MODE_MATCH_SPELLER_JP_PHONE_SEARCH = 23;
    public static final int MODE_FREETEXT_GENERAL = 32;
    public static final int MODE_FREETEXT_SSID = 33;
    public static final int MODE_SEARCHTEXT_GENERAL = 48;
    public static final int MODE_SEARCHTEXT_FAVORITES = 49;
    public static final int MODE_SEARCHTEXT_ADRESSBOOK = 50;
    public static final int MODE_SEARCHTEXT_NAVI = 51;
    public static final int MODE_SEARCHTEXT_PHONE = 52;
    public static final int MODE_SEARCHTEXT_SMS_EMAIL = 53;
    public static final int MODE_SEARCHTEXT_GOOGLE_ONLINE = 54;
    public static final int MODE_SEARCHTEXT_PHONE_LIST = 55;
    public static final int MODE_PIN_INPUT = 64;
    public static final int MODE_PASSWORD_INPUT_GENERAL = 80;
    public static final int MODE_PASSWORD_INPUT_WLAN_APN = 81;
    public static final int MODE_PASSWORD_INPUT_WLAN_CLIENT = 82;
    public static final int MODE_PASSWORD_INPUT_VEHICLE_CODE = 83;
    public static final int MODE_MESSAGING_MULTILINE = 96;
    public static final int MODE_MESSAGING_EMAIL_RECIPIENT = 97;
    public static final int MODE_MESSAGING_SMS_RECIPIENT = 98;
    public static final int MODE_DTMF_INPUT = 113;
    public static final int MODE_PHONE_NUMBER_INPUT = 114;
    private static final int SPELLER_HEIGHT = 35;
    public static final int RIGHT_OFFSET_SPELLER = 37;
    private static final int MATCH_COUNT_AUTOMATIC_SPELLER_CLOSE = 5;
    public static final int LASTMODE_TOUCHINPUT = 0;
    public static final int LASTMODE_SPELLER = 1;
    private static final int TOP_IMAGE_SMALL_INDEX = 3;
    private static final int TOP_IMAGE_BIG_INDEX = 4;
    private static final int TOP_IMAGE_SMALL_INDEX_KB = 5;
    private static final int TOP_IMAGE_BIG_INDEX_KB = 6;
    private boolean openSpellerInitiallyIfNoTouchpad = false;
    public static final int CURSOR_VERTICAL_INDENT = 1;
    private static final Object userHintCursorHideReason = "TouchController_UserHintShown";
    private static int truffleInputCount = 0;
    private int touchpadMode = 32;
    private IRenderer renderer;
    protected String matchSpellerValidChars = "";
    private SpellerController speller;
    private int marginTop = 0;
    private int marginBottom = 0;
    private int glassplateInsetsTop = 0;
    private int glassplateInsetsBottom = 0;
    protected final ITouchInputData inputFieldData;
    private int widgetID = -1;
    private int[] infoTextIDs = null;
    private String infoLineText;
    private int[] infoTextSDSIDs = null;
    private int chosenInfoLineTextIndex;
    private int chosenInfoLineTextSDSIndex;
    private int initialTextID = -1;
    private String initialText = null;
    private LabelController initialTextLabel = null;
    protected IPRPEngine prpEngine;
    private boolean smartDeleteCaseSensitive = true;
    private boolean isAutoCharsetSwitch = true;
    private int sdsItemSelectedAction = 0;
    private String currentSuggestion = null;
    private String currentSuggestedNewSearchString = null;
    protected boolean blockSuggestions = false;
    private boolean isSDSActive = false;
    protected IFingerTraceWidget fingerTraceWidget;
    private FocusedPropertyObject focusPropertyObject;
    private int kbdType = 6;
    protected int spellerLastMode = 0;
    private boolean isPrefilledInputField = false;
    private boolean firstChar;
    private boolean openSpellerAfterViewSizeChange;
    protected TouchCharSetAndTTSHandler touchUtil;
    private int infoLineChoiceModelID = -1;
    private int descriptiveTextID = -1;
    private float cursorOpacity = 0.0f;
    private Job takeBackSmallStageJob = null;
    private TimerEvent takeBackSmallStageTimerEvent = null;
    private static final long TAKE_ME_BACK_TO_SMALL_STAGE_DEFAULT_DELAY = 10000L;
    private Job hidePinByStarJob = null;
    private TimerEvent hidePinByStarTimerEvent = null;
    private static final int HIDE_PIN_BY_STAR_DELAY = 3000;
    private boolean isPinReplacedByStar = false;
    private boolean isCursorVisible = true;
    private boolean isCursorAtInitialPosition = true;
    private boolean fastDelete = false;
    private String enteredString = null;
    protected String stringToSpeak = null;
    private boolean blockSpellerInput = false;
    protected char lastInput;
    protected long lastBackspaceTime = 0L;
    protected static final long LAST_BACKSPACE_TIME_DELAY = 1500L;
    protected final TouchControllerListenerFactory listenerFactory;
    protected final TouchControllerListenerFactory.AnimationListenerImpl animationListener;
    protected final TouchControllerListenerFactory.IUserHintPartialPopupListener userHintPartialPopupListener;
    private final IRightDrawerActionReceiver rightDrawerActionReceiver;
    protected final TouchControllerListenerFactory.TimerListenerImpl timerListener;
    private final ISpellerListener spellerListener;
    private final FingerTraceListener fingerTraceListener;
    private String descriptiveText2 = null;
    private String stringRepresentation;
    private boolean openSpellerOnOtherScreen = false;
    private boolean useAdditionalDatabaseForWordPrediction = false;
    public static final int POI_ADDITIONAL_DATABASE_ID = 0;
    public static final int CONTACT_ADDITIONAL_DATABASE_ID = 1;
    public static final int MEDIA_ADDITIONAL_DATABASE_ID = 2;
    private static final int LOCK_INFO_MESSAGE_INDEX = 0;
    private int additionalDatabaseForWordPredictionID = -1;
    private static final String VANITY_LIST = "0123456789*+#";
    private boolean switchedLanguageVanityNum = false;
    private char preChange;
    private boolean isLastInputByTouch = false;
    private int initialMatchCount = -1;
    private final MenuCallback menuCallback = new MenuCallback();

    public TouchController() {
        this(new TouchInputData());
    }

    protected TouchController(ITouchInputData iTouchInputData) {
        this.inputFieldData = iTouchInputData;
        this.inputFieldData.registerDataChangeListener(this);
        this.listenerFactory = new TouchControllerListenerFactory(this);
        this.animationListener = this.listenerFactory.createAnimationListener();
        this.userHintPartialPopupListener = this.listenerFactory.createUserHintPartialPopupListener();
        this.timerListener = this.listenerFactory.createJobEventListener();
        this.rightDrawerActionReceiver = this.listenerFactory.createRightDrawerActionReceiver();
        this.spellerListener = this.listenerFactory.createSpellerListener();
        this.fingerTraceListener = this.listenerFactory.createFingertraceListener();
    }

    protected IRendererFactory getRendererFactory() {
        ExtHMITerminalEvo extHMITerminalEvo = (ExtHMITerminalEvo)this.getTerminal();
        if (extHMITerminalEvo == null) {
            return null;
        }
        return extHMITerminalEvo.getRendererFactory();
    }

    public int getSizeForTabulator(int n) {
        return -1;
    }

    public void showExtended(boolean bl) {
    }

    public int getPreferredHeight(boolean bl, int n) {
        int n2 = this.getTouchInputFieldHeight();
        float f2 = Math.max(this.getSpellerOpenProgress(), this.getInfoLineProgress());
        float f3 = this.getMMIKombiExtraHeight();
        int n3 = this.terminal.getLayout().getIntegerConstant(12);
        return (int)((float)n2 + f2 * (float)n3 + f3) + this.marginTop + this.marginBottom + this.getTopImageHeight();
    }

    public float getMMIKombiExtraHeight() {
        float f2 = 0.0f;
        f2 = this.isG24() ? this.getSpellerOpenProgress() * 24.0f : (this.isG22() ? this.getSpellerOpenProgress() * 24.0f : this.getSpellerOpenProgress() * 12.0f);
        return f2;
    }

    public int getTouchInputFieldHeight() {
        int n = this.getPreferredHeight();
        if (n == -1) {
            n = 60;
        }
        return n;
    }

    public final IFocusedPropertyObject getProperty() {
        if (!this.isEnabled() || this.speller == null) {
            return null;
        }
        if (this.focusPropertyObject == null) {
            this.focusPropertyObject = new FocusedPropertyObject(this.getRightDrawerCategoryForThisWidget(), null);
        }
        IntList intList = new IntList(5);
        if (!this.inputFieldData.isEmpty()) {
            intList.add(820484104);
        }
        if (this.isRightDrawerConditionSpellerOpen()) {
            intList.add(711938558);
        }
        intList.add(this.touchUtil.getFocusPropertyForCurrentCharset());
        if (!this.isCharsetSwitchingAvailable()) {
            intList.add(585970340);
        }
        this.focusPropertyObject.setProperties(intList.toArray());
        this.focusPropertyObject.setActionReceiverWidget(this.rightDrawerActionReceiver);
        this.focusPropertyObject.setModelID(this.getModelID());
        return this.focusPropertyObject;
    }

    protected int getRightDrawerCategoryForThisWidget() {
        return 1657326040;
    }

    protected boolean isRightDrawerConditionSpellerOpen() {
        return this.isSpellerOpen();
    }

    protected boolean isCharsetSwitchingAvailable() {
        return !this.isLatinOnly();
    }

    protected boolean isLatinOnly() {
        boolean bl = this.touchpadMode == 113 || this.touchpadMode == 114 || this.touchpadMode == 64 || this.touchpadMode == 33 || this.touchpadMode == 81 || this.touchpadMode == 82 || this.touchpadMode == 83 || this.touchpadMode == 22 || this.touchpadMode == 23;
        return bl;
    }

    public boolean isSelected() {
        return false;
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    protected void initializeWidget() {
        int n;
        int n2;
        tpLogChannelInternal.log(1000000, "TouchController#initializeWidget: Touchpadmode=%2, InputData=%1", (Object)this.inputFieldData, (long)this.touchpadMode);
        this.calculateInfoTextChoices();
        if (this.terminal.getKbdService() != null) {
            this.kbdType = this.terminal.getKbdService().getCurrentKeyboardType();
            this.inputFieldData.setKbdType(this.kbdType);
            tpLogChannelInternal.log(1000000, "TouchController#initializeWidget: kbdType=%1", (long)this.kbdType);
        }
        this.firstChar = true;
        if (this.initContext.isReinit()) {
            this.inputFieldData.clear(false);
            this.matchSpellerValidChars = "";
        }
        this.initializeTextCursor();
        this.updateValueFromModel();
        this.blockSuggestions = false;
        this.updateSuggestions();
        if (this.isMatchSpellerMode()) {
            this.updateValidChars();
        }
        this.updateRecognizerMode();
        if (this.speller != null) {
            if (this.getSpellerOpenProgress() != 0.0f) {
                this.invalidateParentLayout();
            }
            this.animationListener.setSpellerOpenProgress(0.0f);
            this.speller.setForceOKButton(this.touchpadMode == 52 || this.touchpadMode == 55);
        }
        this.setSpellerLastMode(0);
        this.setLastInputByTouch(false);
        this.touchUtil = this.createTouchCharsetAndTTSHandler();
        this.updateCharSetForPRPandSpeller();
        this.updateInfoLineState(false);
        this.setCompositesDirty(true);
        if (truffleInputCount > 0 && this.isTruffleSearch()) {
            ++truffleInputCount;
        }
        this.updateTakeBackSmallStageTimer();
        this.setFastDelete(false);
        this.stringToSpeak = null;
        if (this.bitmapIndices != null && this.bitmapIndices.length > 4) {
            n2 = this.bitmapIndices[3] != HMIImageConstantsSystem.empty_image ? this.bitmapIndices[3] : -1;
            n = this.bitmapIndices[4] != HMIImageConstantsSystem.empty_image ? this.bitmapIndices[4] : -1;
            this.setTopImageIndex(n2, n);
        }
        if (this.bitmapIndices != null && this.bitmapIndices.length > 6) {
            n2 = this.bitmapIndices[5] != HMIImageConstantsSystem.empty_image ? this.bitmapIndices[5] : -1;
            n = this.bitmapIndices[6] != HMIImageConstantsSystem.empty_image ? this.bitmapIndices[6] : -1;
            this.setTopImageIndexKB(n2, n);
        }
    }

    protected void updateRecognizerMode() {
        if (this.kbdType == 6) {
            if (this.isFocused()) {
                this.setRecognizerMode(26);
            } else {
                this.setRecognizerMode(24);
            }
        } else {
            this.setRecognizerMode(26);
        }
    }

    protected void propagateConnected(InitializationContext initializationContext) {
        super.propagateConnected(initializationContext);
        this.preOpenSpellerByModel();
    }

    protected void preOpenSpellerByModel() {
        if (this.model instanceof SpellerModelGUI) {
            SpellerModelGUI spellerModelGUI = (SpellerModelGUI)this.model;
            if (this.isVisible() && spellerModelGUI.shallSpellerBeInitiallyOpen()) {
                TouchEvent touchEvent = spellerModelGUI.getTouchEventForFollowUpScreen();
                if (null != touchEvent) {
                    if (!this.isFocused()) {
                        this.setFocused(true);
                    }
                    this.touchPadCharactersRecognizedAction(touchEvent, true);
                    spellerModelGUI.setTouchEventForFollowUpScreen(null);
                } else {
                    this.openSpeller(false);
                }
                spellerModelGUI.setSpellerInitiallyOpen(false);
                tpLogChannelInternal.log(10000000, "TouchController#preOpenSpellerByModel: [MODEL COMMUNICATION ->] called setSpellerInitiallyOpen with argument false.");
            }
        }
        if (this.openSpellerInitial()) {
            this.openSpeller(false);
        }
    }

    private boolean openSpellerInitial() {
        return this.openSpellerInitiallyIfNoTouchpad && !this.isTouchpadKeypanelWithActiveStatus() && this.isVisible();
    }

    public void setOpenSpellerInitiallyIfNoTouchpad(boolean bl) {
        this.openSpellerInitiallyIfNoTouchpad = bl;
    }

    private void setTopImageIndex(int n, int n2) {
        this.topImageSmallIndex = n;
        this.topImageBigIndex = n2;
    }

    private void setTopImageIndexKB(int n, int n2) {
        this.topImageSmallIndexKB = n;
        this.topImageBigIndexKB = n2;
    }

    protected TouchCharSetAndTTSHandler createTouchCharsetAndTTSHandler() {
        return new TouchCharSetAndTTSHandler(this.terminal);
    }

    private void doShowInitialHint() {
        boolean bl = this.isVisibleInHierarchy();
        tpLogChannelInternal.log(10000000, "TouchController#doShowInitialHint: isVisibleInHierarchy: %1, touchController: %2", bl, (Object)this);
        if (bl && this.isVisibleOnCurrentStage() && !this.isSDSActive() && this.terminal.getViewSizeManager() != null && this.isBigStage()) {
            ChoiceModelApp choiceModelApp;
            if (this.touchpadMode == 52 || this.touchpadMode == 55 || this.touchpadMode == 21) {
                ChoiceModelApp choiceModelApp2 = this.terminal.getFramework().getHMIService().getChoiceModel(3848);
                if (choiceModelApp2 != null && choiceModelApp2.getValue() == 0) {
                    this.terminal.getUserHintHandler().requestInitialHint(96, this.userHintPartialPopupListener);
                    tpLogChannelInternal.log(10000000, "TouchController#doShowInitialHint: showing initial phone hint");
                }
            } else if (this.touchpadMode == 51 && (choiceModelApp = this.terminal.getFramework().getHMIService().getChoiceModel(400871)) != null && choiceModelApp.getValue() != 2) {
                this.terminal.getUserHintHandler().requestInitialHint(97, this.userHintPartialPopupListener);
            }
        }
    }

    private void initializeTextCursor() {
        this.isCursorVisible = this.isFocused();
        this.calculateCursorPosition();
        if (this.isFocused()) {
            this.startCursorBlinkAnimation();
        }
    }

    private boolean hasLockInfoMessage() {
        return this.lockSpellerInputModel != null || this.lockAllInputModel != null;
    }

    private void calculateInfoTextChoices() {
        if (this.infoTextIDs != null && this.infoTextIDs.length > 0) {
            int n;
            ChoiceModelApp choiceModelApp;
            int n2;
            int n3 = n2 = this.hasLockInfoMessage() ? 1 : 0;
            if (this.infoTextIDs.length == n2) {
                this.chosenInfoLineTextIndex = -1;
            } else {
                long l = framework.getMonotonicTimeSource().getCurrentTime();
                this.chosenInfoLineTextIndex = n2 + (int)(l % (long)(this.infoTextIDs.length - n2));
            }
            if (this.infoLineChoiceModelID != -1 && (choiceModelApp = hmiService.getChoiceModel(this.infoLineChoiceModelID)) != null && (n = choiceModelApp.getValue()) >= 0 && n < this.infoTextIDs.length) {
                this.chosenInfoLineTextIndex = n;
            }
        } else {
            this.chosenInfoLineTextIndex = 0;
        }
        this.chosenInfoLineTextSDSIndex = this.infoTextSDSIDs != null && this.infoTextSDSIDs.length > 0 ? (int)(framework.getMonotonicTimeSource().getCurrentTime() % (long)this.infoTextSDSIDs.length) : 0;
    }

    protected void initConnect(InitializationContext initializationContext) {
        super.initConnect(initializationContext);
        if (this.fingerTraceWidget == null) {
            FingerTraceController fingerTraceController = FingerTraceControllerFactory.create();
            IRendererFactory iRendererFactory = this.getRendererFactory();
            if (iRendererFactory != null) {
                IFingerTraceRenderer iFingerTraceRenderer = iRendererFactory.createFingerTraceRenderer(fingerTraceController);
                fingerTraceController.setRenderer(iFingerTraceRenderer);
            } else {
                tpLogChannelInternal.log(10000, "TouchController#initConnect: could not create fingertrace renderer");
            }
            this.addFingerTraceWidget(fingerTraceController);
        }
        if (this.speller != null && this.speller.getSpellerMode() == 0 && (this.touchpadMode == 16 || this.touchpadMode == 18 || this.touchpadMode == 17 || this.touchpadMode == 19)) {
            this.speller.setSpellerMode(11);
            tpLogChannelInternal.log(10000000, "TouchController#initConnect: changed speller mode to MODE_MATCHSPELLER, touchpad mode was %1", (long)this.touchpadMode);
        }
    }

    protected void addFingerTraceWidget(IFingerTraceWidget iFingerTraceWidget) {
        this.add(iFingerTraceWidget.toAbstractWidget());
        this.fingerTraceWidget = iFingerTraceWidget;
        this.fingerTraceWidget.registerFTListener(this.fingerTraceListener);
    }

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.updateButtonStates();
        if (this.fingerTraceWidget != null) {
            this.fingerTraceWidget.hideFingerTrace();
        }
        this.setInputLock(false);
        if (this.model instanceof MatchspellerModelGUI) {
            this.initialMatchCount = ((MatchspellerModelGUI)this.model).getMatchCount();
            tpLogChannelInternal.log(10000000, "TouchController#connected initial match count: %1", (long)this.initialMatchCount);
        }
        this.touchUtil.addCharsetListener(this);
        this.calculateLockLevel();
        LockingManager.registerListener(this);
    }

    public void setBounds(int n, int n2, int n3, int n4) {
        if (this.hasBounds(n, n2, n3, n4)) {
            return;
        }
        this.setX(n);
        this.setY(n2);
        this.setWidth(n3);
        this.setHeight(n4);
    }

    public void setY(int n) {
        int n2 = this.y;
        super.setY(n);
        if (n2 != n) {
            this.updateUserHintPos();
            if (this.speller != null) {
                if (this.isG24()) {
                    this.speller.setY(n + 4);
                } else {
                    this.speller.setY(n);
                }
            }
        }
    }

    public void setX(int n) {
        int n2 = this.x;
        super.setX(n);
        if (n2 != n) {
            this.updateUserHintPos();
            if (this.speller != null) {
                this.speller.setX(n);
            }
        }
    }

    public void setHeight(int n) {
        int n2 = this.height;
        super.setHeight(n);
        if (n2 != n) {
            this.updateUserHintPos();
            if (this.speller != null) {
                this.speller.setHeight(n);
            }
        }
    }

    public void setWidth(int n) {
        int n2 = this.width;
        super.setWidth(n);
        if (n2 != n) {
            this.updateUserHintPos();
            if (this.speller != null) {
                this.speller.setWidth(this.calculateSpellerWidth());
            }
        }
    }

    public int calculateSpellerWidth() {
        if (this.parent == null) {
            return 0;
        }
        return this.parent.getWidth() - 37;
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        tpLogChannelInternal.log(10000000, "TouchController#processModelUpdateEvent: [MODEL COMMUNICATION <-] processing event %1", (Object)modelUpdateEvent);
        super.processModelUpdateEvent(modelUpdateEvent);
        if (modelUpdateEvent.getModelId() == this.getModelID()) {
            int n;
            int n2 = modelUpdateEvent.getUpdateType();
            if (n2 == 1) {
                this.updateValueFromModel();
                modelUpdateEvent.consume();
            } else if (n2 == 11) {
                if (this.isMatchspellerModel()) {
                    this.updateValidChars();
                    modelUpdateEvent.consume();
                }
                this.updateButtonStates();
            } else if (n2 == 6) {
                if (this.isMatchspellerModel()) {
                    this.updateMatchCount();
                    modelUpdateEvent.consume();
                }
            } else if (n2 == 10) {
                this.updateSuggestions();
                modelUpdateEvent.consume();
            } else if (n2 == 2 && (n = modelUpdateEvent.getClientData1()) == 1) {
                this.setInputLock(false);
                if (this.shouldSpeakAutocompletion()) {
                    this.speakAutocompletion();
                }
                this.stringToSpeak = null;
                modelUpdateEvent.consume();
            }
        } else if (this.topImageLabelTextItem != null && this.topImageLabelTextItem.getModelID() == modelUpdateEvent.getModelId()) {
            this.updateTopImageLabelText();
        } else if (this.lockSpellerInputModel != null && this.lockSpellerInputModel.getModelID() == modelUpdateEvent.getModelId()) {
            this.updateLockLevelFromModelStub(this.lockSpellerInputModel, 1);
            this.setCompositesDirty(true);
        } else if (this.lockAllInputModel != null && this.lockAllInputModel.getModelID() == modelUpdateEvent.getModelId()) {
            this.updateLockLevelFromModelStub(this.lockAllInputModel, 3);
            this.setCompositesDirty(true);
        }
        tpLogChannelInternal.log(10000000, "#TouchController#processModelUpdateEvent: event was consumed: %1", modelUpdateEvent.isConsumed());
    }

    private void calculateLockLevel() {
        this.updateLockLevelFromModelStub(this.lockSpellerInputModel, 1);
        if (this.touchControllerScreenLevel == 2) {
            this.updateLockLevelFromModelStub(this.lockAllInputModel, 3);
        }
        logLocking.log(10000000, "TouchController#calculateLockLevel: new lock level=%1", (long)this.lockLevel);
    }

    private void updateLockLevelFromModelStub(ModelStubController modelStubController, int n) {
        Object object;
        if (modelStubController != null && (object = modelStubController.getModel()) instanceof ChoiceModelGUI) {
            if (((ChoiceModelGUI)object).getValue() == 1) {
                this.lockLevel = n;
            }
            logLocking.log(10000000, "TouchController#updateLockLevelFromModelStub: modelStub=%1, oldLockLevel=%2, newLockLevel=%3", (Object)modelStubController, (long)this.lockLevel, (long)n);
        }
    }

    private boolean isSpellerInputAllowed() {
        if (this.isLockingActive) {
            switch (this.lockLevel) {
                case 1: 
                case 3: {
                    return false;
                }
                case 0: 
                case 2: {
                    return true;
                }
            }
            logLocking.log(100000, "TouchController#isSpellerInputAllowed: unknown lock level is set: %1", (long)this.lockLevel);
        }
        return true;
    }

    private boolean isTouchInputAllowed() {
        if (this.isLockingActive) {
            switch (this.lockLevel) {
                case 2: 
                case 3: {
                    return false;
                }
                case 0: 
                case 1: {
                    return true;
                }
            }
            logLocking.log(100000, "TouchController#isTouchInputAllowed: unknown lock level is set: %1", (long)this.lockLevel);
        }
        return true;
    }

    public void isLockingActive(boolean bl, boolean bl2) {
        this.isLockingActive = bl;
        if (this.isLockingActive && this.lockLevel != 0) {
            this.propagateValidChars(false);
            if (this.lockLevel == 3) {
                this.stopCursorBlinkAnimation();
            }
        } else {
            this.propagateValidChars(true);
            this.startCursorBlinkAnimation();
        }
        if (this.speller != null) {
            this.speller.setEnabled(this.isSpellerInputAllowed());
        } else {
            logLocking.log(100000, "TouchController#lockingActive: speller couldn't set enabled=%1 because the object is null", this.isSpellerInputAllowed());
        }
        this.updateInfoLineState(true);
        this.setCompositesDirty(true);
        logLocking.log(10000000, "TouchController#lockingActive: isLockingActive=%1 lockLevel=%2", this.isLockingActive, (long)this.lockLevel);
    }

    public boolean isInterestedOnTimerEvents() {
        return false;
    }

    public void setLockLevel(int n) {
        if (n <= 3 && n >= 0) {
            this.lockLevel = n;
        } else {
            logLocking.log(100000, "TouchController#setLockLevel: unknown lock level was set: locklevel=%1", (long)n);
        }
    }

    public void setTouchControllerScreenLevel(int n) {
        this.touchControllerScreenLevel = n;
    }

    public boolean isAllInputLocked() {
        return this.isLockingActive && this.lockLevel == 3;
    }

    private void showNoInputPopup() {
        switch (this.lockLevel) {
            case 1: {
                framework.getHMIService().showPartialPopup(this.terminal.getTerminalID(), 192);
                break;
            }
            case 2: 
            case 3: {
                framework.getHMIService().showPartialPopup(this.terminal.getTerminalID(), 191);
                break;
            }
            default: {
                logLocking.log(1000000, "TouchController#showNoInputPopup: no popup for the locklevel = %1 defined", (long)this.lockLevel);
            }
        }
    }

    protected final boolean shouldSpeakAutocompletion() {
        return this.isMatchspellerModel() && !this.isSpellerInput() && !this.suppressTTSOutput();
    }

    protected boolean isSpellerInput() {
        return !this.isLastInputByTouch();
    }

    private void updateMatchCount() {
        MatchspellerModelGUI matchspellerModelGUI;
        int n;
        if (!this.isSpellerClosed() && (n = (matchspellerModelGUI = (MatchspellerModelGUI)this.model).getMatchCount()) <= 5 && this.lastInput != '\b' && !this.shouldBlockJump5Rule()) {
            tpLogChannelInternal.log(10000000, "TouchController#updateMatchCount closing speller because of jump-5 rule");
            this.closeSpeller(true, false);
        }
    }

    protected void updateSuggestions() {
        if (this.model instanceof SpellerModelGUI) {
            SpellerModelGUI spellerModelGUI = (SpellerModelGUI)this.model;
            String string = spellerModelGUI.getTruffleSuggestion();
            if (!this.blockSuggestions && this.speller != null && !this.isSpellerClosed() && this.isJoystickKeypanel() && this.isSpellerInputAllowed()) {
                String string2 = spellerModelGUI.getCompletionText();
                tpLogChannelInternal.log(10000000, "#TouchController#updateSuggestions: set new autocompletion at speller: %1", (Object)string2);
                this.speller.setAutoCompletionText(string2, this.getCurrentTextForSuggestion());
            }
            this.currentSuggestedNewSearchString = spellerModelGUI.getSuggestedNewSearchString();
            if (this.isSuggestionValid(string, this.currentSuggestedNewSearchString)) {
                this.currentSuggestion = this.inputFieldData.doCaseBalancingForSuggestion(string);
                if (tpLogChannelInternal.isDebug()) {
                    tpLogChannelInternal.log(10000000, "#TouchController#updateSuggestions: set new suggestion=%1 / current text is: %2", (Object)this.currentSuggestion, (Object)this.inputFieldData.getCurrentText());
                }
                if (truffleInputCount >= 2 && this.inputFieldData.getTextLength() >= 2 && !TouchController.isAsia()) {
                    this.showUserHintAnimation(98);
                }
            } else {
                if (tpLogChannelInternal.isDebug()) {
                    tpLogChannelInternal.log(10000000, "#TouchController#updateSuggestions: suggestion (%1) is not valid for current text (%2)", (Object)string, (Object)this.inputFieldData.getCurrentText());
                }
                this.currentSuggestion = null;
            }
            this.setCompositesDirty(true);
        } else {
            tpLogChannelInternal.log(10000, "TouchController#updateSuggestions: no speller model set (model=%1)", this.model);
        }
    }

    protected String getCurrentTextForSuggestion() {
        return this.inputFieldData.getCurrentText();
    }

    protected void speakAutocompletion() {
        boolean bl = this.touchUtil.trySpeakFullMatchWithPhonemes((MatchspellerModelGUI)this.model);
        if (!bl && !StringUtilities.isNullOrEmpty(this.stringToSpeak)) {
            tpLogChannelInternal.log(10000000, "TouchController#speakAutocompletion stringToSpeak: %1", (Object)this.stringToSpeak);
            this.touchUtil.speak(this.stringToSpeak);
        }
    }

    private void updateValidChars() {
        MatchspellerModelGUI matchspellerModelGUI = (MatchspellerModelGUI)this.model;
        this.matchSpellerValidChars = matchspellerModelGUI.getValidChars();
        this.propagateValidChars(false);
        tpLogChannelInternal.log(10000000, "TouchControllerAsia#updateValidChars validChars: %1", (Object)this.matchSpellerValidChars);
    }

    protected final void updateValueFromModel() {
        int n;
        String string = null;
        int n2 = 0;
        int n3 = Integer.MAX_VALUE;
        boolean bl = this.inputFieldData.isEmpty();
        if (this.model instanceof SpellerModelGUI) {
            string = ((SpellerModelGUI)this.model).getText();
            n2 = ((SpellerModelGUI)this.model).getMinLength();
            n3 = ((SpellerModelGUI)this.model).getMaxLength();
            if (string == null) {
                tpLogChannelInternal.log(1000000, "TouchController#updateValueFromModel: model text (modelID=%1) is null; using EMPTY_STRING instead", (long)this.modelID);
                string = "";
            }
        } else {
            string = "";
            tpLogChannelInternal.log(10000, "TouchController#updateValueFromModel: no supported model connected model=%1", this.model);
            return;
        }
        this.inputFieldData.setMinimumTextLength(n2);
        this.inputFieldData.setMaximumTextLength(n3);
        tpLogChannelInternal.log(10000000, "TouchController#updateValueFromModel: enteredText=%1 | modelText=%2", (Object)this.getEnteredString(), (Object)string);
        if (this.getEnteredString() != null && string != null && this.getEnteredString().length() < string.length()) {
            n = this.getEnteredString().length();
            String string2 = string.substring(n >= 1 ? n - 1 : n);
            Buffer buffer = new Buffer(string2.length() * 2);
            for (int i2 = 0; i2 < string2.length(); ++i2) {
                buffer.append(string2.charAt(i2));
                buffer.append(' ');
            }
            this.stringToSpeak = buffer.toString();
            this.setEnteredString(string);
        }
        tpLogChannelInternal.log(10000000, "TouchController#updateValueFromModel: update touchfield from model: value=%1 modelID=%2", (Object)string, (long)this.modelID);
        tpLogChannelInternal.log(10000000, "TouchController#updateValueFromModel: update touchfield from model: minLength=%1; maxLength=%2", (long)n2, (long)n3);
        int n4 = n = string.length() == 0 ? 1 : 0;
        if (n != 0) {
            this.clear(false);
        } else if (this.checkIfModelUpdateChangesText(string)) {
            this.inputFieldData.clear(false);
            this.inputFieldData.insertString(string, null, false);
            if (this.isPasswordField()) {
                this.inputFieldData.hideCharacters();
            }
            this.setCompositesDirty(true);
        } else {
            tpLogChannelInternal.log(10000000, "TouchController#updateValueFromModel: ignore value from model, because we are the master of the text for mode NAVI_TRUFFLES");
        }
        this.propagateValidChars(false);
        this.updateButtonStates();
        if (this.inputFieldData.isEmpty() != bl) {
            this.invalidateParentLayout();
        }
    }

    protected boolean checkIfModelUpdateChangesText(String string) {
        return !this.inputFieldData.getCurrentText().equals(string);
    }

    public boolean isPasswordField() {
        return this.touchpadMode == 64 || this.touchpadMode == 80 || this.touchpadMode == 82 || this.touchpadMode == 83;
    }

    protected final boolean suppressTTSOutput() {
        return this.isPasswordField() || this.touchpadMode == 81;
    }

    protected final void updateButtonStates() {
        if (this.speller != null) {
            boolean bl;
            boolean bl2 = !this.inputFieldData.isStartOfText();
            boolean bl3 = this.inputFieldData.getTextLength() >= this.inputFieldData.getMinimumTextLength();
            boolean bl4 = true;
            boolean bl5 = this.inputFieldData.getCursorPos() > 0;
            boolean bl6 = bl = this.inputFieldData.getCursorPos() < this.inputFieldData.getTextLength();
            if (this.model instanceof SpellerModelGUI) {
                SpellerModelGUI spellerModelGUI = (SpellerModelGUI)this.model;
                bl3 &= spellerModelGUI.getCommandAvailable(7);
            }
            this.speller.setButtonStates(bl2, bl3, bl4, bl5, bl);
        }
    }

    public void add(AbstractWidget abstractWidget) {
        if (abstractWidget instanceof ModelStubController) {
            return;
        }
        super.add(abstractWidget);
    }

    public void add(AbstractWidget abstractWidget, int n) {
        if (abstractWidget instanceof ModelStubController) {
            switch (n) {
                case 2: {
                    this.topImageLabelTextItem = (ModelStubController)abstractWidget;
                    break;
                }
                case 0x8000000: {
                    this.lockSpellerInputModel = (ModelStubController)abstractWidget;
                    break;
                }
                case 0x10000000: {
                    this.lockAllInputModel = (ModelStubController)abstractWidget;
                    break;
                }
                default: {
                    tpLogChannelInternal.log(100000, "TouchController#add: no model with the given role=%1 exists", (long)n);
                }
            }
        }
        super.add(abstractWidget);
    }

    public void predisconnecting() {
        this.timerListener.preDisconnecting();
        this.terminal.getUserHintHandler().removeCurrentUserHint();
        this.closeSpeller(false, false);
        super.predisconnecting();
    }

    public void disconnecting() {
        this.isSDSActive = false;
        this.matchSpellerValidChars = "";
        this.animationListener.setSpellerOpenProgress(0.0f);
        this.animationListener.disconnecting();
        this.timerListener.disconnecting();
        this.openSpellerAfterViewSizeChange = false;
        this.terminal.getViewSizeManager().unrequestLargeViewSize(11);
        this.stopTakeBackSmallStageJob();
        this.setInputLock(false);
        if (!this.isPinReplacedByStar) {
            this.inputFieldData.hideCharacters();
        }
        this.cancelHidePinTimer();
        this.setTitleAreaVisible(true);
        this.touchUtil.removeCharsetListener(this);
        LockingManager.deregisterListener(this);
        super.disconnecting();
    }

    private void setTitleAreaVisible(boolean bl) {
        if (this.initContext != null && this.initContext.getScreen() != null) {
            ScreenMainArea screenMainArea = ((AbstractScreenWidget)this.initContext.getScreen()).getTitleArea();
            if (screenMainArea != null) {
                screenMainArea.getScreenAreaWidget().setOnScreen(bl);
            } else {
                tpLogChannelInternal.log(100000, "TouchController#setTitleAreaVisible TtitleArea is NULL!");
            }
        } else {
            tpLogChannelInternal.log(100000, "TouchController#setTitleAreaVisible initContext or screen is NULL");
        }
    }

    protected final void touchPadCharactersRecognizedAction(TouchEvent touchEvent, boolean bl) {
        boolean bl2;
        if (this.shallIgnoreEvents()) {
            return;
        }
        if (this.isOpenSpellerOnOtherScreen() && this.isTouchInputAllowed()) {
            if (this.model instanceof SpellerModelGUI) {
                ((SpellerModelGUI)this.model).setTouchEventForFollowUpScreen(touchEvent);
            }
            this.notifyAppAboutSpellerState(true);
            return;
        }
        boolean bl3 = bl2 = bl ? true : this.fingerTraceWidget.exceededMinStrokeLength();
        if (bl2 && !this.isTouchInputAllowed()) {
            touchEvent.consume(true);
            this.hideFingerTrace();
            this.showNoInputPopup();
            return;
        }
        if (!this.isTouchInputAllowed()) {
            touchEvent.consume(true);
            this.hideFingerTrace();
            return;
        }
        String string = touchEvent.getRecognizedCharacters();
        if (this.isFastDeleteGuesture(string)) {
            string = String.valueOf('\b');
        }
        this.restartUserHintIdleJob();
        char c2 = '\u0000';
        if (string != null && string.length() > 0) {
            tpLogChannelKeypanel.log(10000000, "TouchController#touchpadCharactersRecognized: recognizedCharacters=[%1] CharacterConfidence=[%2]", (Object)string, (Object)touchEvent.getCharacterConfidence());
            if (this.isMatchSpellerMode() && !TouchController.isAsia()) {
                this.prpEngine.process(string, touchEvent.getCharacterConfidence(), StringUtility.concatenate('\b', this.matchSpellerValidChars), bl2);
            } else {
                this.prpEngine.process(string, touchEvent.getCharacterConfidence(), bl2);
            }
            String string2 = this.prpEngine.getResult();
            if (TouchController.isAllowedMinCharSizeCharacter(string) && this.inputFieldData.isStartOfText()) {
                string2 = "";
            }
            tpLogChannelKeypanel.log(10000000, "TouchController#touchpadCharactersRecognized: filteredCharacters=%1", (Object)string2);
            this.setFastDelete(true);
            this.processTouchResult(string2);
            c2 = TouchController.getMostPlausibleCharacter(string2);
            this.setCompositesDirty(true);
            this.invalidateParentLayout();
            touchEvent.consume(true);
            if (this.isSDSMultimodal() || string2 == null || string2.length() == 0) {
                tpLogChannelKeypanel.log(10000000, "TouchController#touchpadCharactersRecognized: continue SDS dialog");
                touchEvent.setSdsAction(3);
            }
        } else if (string != null && string.length() == 0) {
            this.processEmptyTouchResult();
        }
        this.fingerTraceWidget.characterRecognized(c2);
        if (this.showIcon() && c2 == '\u0000') {
            this.hideFingerTrace();
        }
    }

    public void touchPadCharactersRecognized(TouchEvent touchEvent) {
        this.touchPadCharactersRecognizedAction(touchEvent, false);
    }

    private boolean isFastDeleteGuesture(String string) {
        return !this.fingerTraceWidget.exceededMinStrokeLength() && string != null && string.length() > 0 && this.lastInput == '\b' && string.charAt(0) == '\b' && framework.getMonotonicTime() - this.lastBackspaceTime < 1500L;
    }

    protected void processEmptyTouchResult() {
    }

    public static char getMostPlausibleCharacter(String string) {
        if (StringUtilities.isNullOrEmpty(string)) {
            return '\u0000';
        }
        return string.charAt(0);
    }

    private static boolean isAllowedMinCharSizeCharacter(String string) {
        if (string != null && string.length() > 0) {
            char c2 = string.charAt(0);
            return c2 == '.' || c2 == ';' || c2 == '\b';
        }
        return false;
    }

    protected final boolean isMatchSpellerMode() {
        return this.model instanceof MatchspellerModelGUI || this.touchpadMode >= 16 && this.touchpadMode <= 21;
    }

    private void cancelHidePinTimer() {
        if (this.hidePinByStarJob != null && !this.hidePinByStarJob.isCanceled()) {
            this.hidePinByStarJob.cancel();
        }
    }

    private void restartHidePinTimer() {
        if (this.hidePinByStarTimerEvent == null) {
            this.hidePinByStarTimerEvent = new TimerEvent(this);
        }
        this.cancelHidePinTimer();
        this.hidePinByStarJob = hmiService.getEventDispatcher().postEvent(this.hidePinByStarTimerEvent, 3000L);
    }

    protected void stringEntered(String string, String[] stringArray) {
        if (string == null || string.length() == 0 || this.isInputLocked()) {
            tpLogChannelKeypanel.log(10000000, "TouchController#stringEntered return because inputString is Empty or cuz blockSpellerInput=%1", this.isInputLocked());
            return;
        }
        char c2 = string.charAt(string.length() - 1);
        if (c2 == '\b') {
            this.handleDelete();
            return;
        }
        if (this.isPasswordField() && !this.isWlanPasswordField() && !this.isPinReplacedByStar) {
            tpLogChannelInternal.log(10000000, "TouchController#stringEntered: hide already entered characters (if it's a Password field)");
            this.inputFieldData.hideCharacters();
        }
        this.inputFieldData.insertString(string, stringArray, true);
        if (this.isPasswordField() && !this.isWlanPasswordField()) {
            this.isPinReplacedByStar = false;
            this.restartHidePinTimer();
        }
        if (!this.isSuggestionValid(this.currentSuggestion, this.currentSuggestedNewSearchString)) {
            this.currentSuggestion = null;
            this.currentSuggestedNewSearchString = null;
        }
        this.updateVanityNumberInput();
    }

    protected void updateVanityNumberInput() {
        if (!this.isStd() || this.speller.getSpellerMode() != 8) {
            return;
        }
        if (this.inputFieldData.isEmpty() && this.switchedLanguageVanityNum) {
            this.changeCharset(this.touchUtil.getSystemDefaultLanguage());
            this.speller.setNewFocus(this.preChange);
            this.switchedLanguageVanityNum = false;
        } else if (this.inputFieldData.getCurrentText().length() == 1 && this.isInVanityList(this.lastInput) && !this.isCurrentSpellerLanguageLatinBased()) {
            this.changeCharset(0);
            this.preChange = this.lastInput;
            this.speller.setNewFocus(this.lastInput);
            this.switchedLanguageVanityNum = true;
        }
    }

    private boolean isInVanityList(char c2) {
        return VANITY_LIST.indexOf(c2) > -1;
    }

    protected boolean isCurrentSpellerLanguageLatinBased() {
        return this.touchUtil.getCharSet() == 0;
    }

    private boolean isWlanPasswordField() {
        return this.touchpadMode == 82;
    }

    protected void processTouchResult(String string) {
        this.setFastDelete(true);
        if (string.length() == 0) {
            String string2 = null;
            if (this.prpEngine != null) {
                string2 = this.prpEngine.getSpeechTopMatch();
            }
            tpLogChannelInternal.log(10000000, "TouchController#processTouchResult: negative tone because of empty result inputfield empty, minStrokeExceeded=%1", this.fingerTraceWidget.isMinStrokeReached());
            tpLogChannelInternal.log(10000000, "TouchController#processTouchResult: charToSpeak=%1", (Object)string2);
            if (this.fingerTraceWidget.exceededMinStrokeLength()) {
                this.touchUtil.speakCharWithNegativeTone(string2);
            }
            if (this.inputFieldData.isEmpty()) {
                this.hideFingerTrace();
            }
            return;
        }
        char c2 = string.charAt(0);
        if (this.isTextMaxLengthMet() && c2 != '\b') {
            String string3 = Character.toString(c2);
            tpLogChannelInternal.log(10000000, "TouchController#processTouchResult: max text length reached speak char('%1') followed by negative tone", (Object)string3);
            if (this.fingerTraceWidget.isMinStrokeReached()) {
                this.touchUtil.speakCharWithNegativeTone(string3);
            }
            return;
        }
        boolean bl = this.needRequestBigStageForTouchResult(string);
        this.requestBigStage(bl);
        if (this.prpEngine != null) {
            this.prpEngine.characterEntered(c2);
        }
        if (c2 != '\b' && c2 != ' ') {
            if (this.shouldSpellerCloseAfterTouchInput() && this.isSpellerOpen()) {
                this.closeSpeller(false, true);
            }
            if (this.speller != null) {
                this.speller.resetInitialItem();
            }
            if (this.inputFieldData.isEmpty()) {
                this.showUserHintAnimation(75);
            }
            this.setSpellerLastMode(0);
            this.setLastInputByTouch(true);
        } else if (this.isSpellerClosed()) {
            this.setSpellerLastMode(0);
            this.setLastInputByTouch(true);
        } else {
            this.setLastInputByTouch(false);
        }
        String string4 = Character.toString(c2);
        this.stringEntered(string4, new String[]{string});
        if (this.shouldShowSpaceHint(c2)) {
            this.showUserHintAnimation(78);
        } else if (this.firstChar && c2 != '\b') {
            this.firstChar = false;
            if (this.isTruffleSearch()) {
                ++truffleInputCount;
            }
        }
        if (c2 == '\b') {
            tpLogChannelInternal.log(10000000, "TouchController#processTouchResult speak 'L\u00f6schen'");
            this.touchUtil.sayDelete();
            this.stringToSpeak = null;
        } else if (!this.suppressTTSOutput()) {
            if (this.isMatchspellerModel()) {
                this.stringToSpeak = string4;
            } else {
                this.touchUtil.speakChar(string4);
            }
        } else {
            this.stringToSpeak = null;
            tpLogChannelInternal.log(10000000, "TouchController#processTouchResult: do not speak character because we are in password mode");
        }
    }

    protected void notifyPRPAboutSpellerInput(char c2) {
        if (this.prpEngine != null) {
            this.prpEngine.characterEntered(c2);
        }
    }

    protected boolean shouldShowSpaceHint(char c2) {
        return this.isSpellerClosed() && this.inputFieldData.getTextLength() == 4 && c2 != '\b';
    }

    protected boolean needRequestBigStageForTouchResult(String string) {
        return false;
    }

    protected boolean shouldSpellerCloseAfterTouchInput() {
        return true;
    }

    public final boolean isTruffleSearch() {
        return this.touchpadMode >= 48 && this.touchpadMode < 64 || this.touchpadMode == 97 || this.touchpadMode == 98;
    }

    public final boolean isPureFreetext() {
        return this.touchpadMode == 32;
    }

    protected final void showUserHintAnimation(int n) {
        tpLogChannelKeypanel.log(10000000, "TouchController#showUserHintAnimation(%1) isTouchpadKeypanel=%2", (Object)String.valueOf(n), (Object)String.valueOf(this.isTouchpadKeypanelWithActiveStatus()));
        if (!this.shouldRender()) {
            tpLogChannelInternal.log(10000000, "TouchController#showUserHintAnimation: not showing user hint (id=%1) because field is not visible", (long)n);
            return;
        }
        if (!this.isTruffleSearch() && !this.isStd()) {
            tpLogChannelInternal.log(10000000, "TouchController#showUserHintAnimation: not showing user hint (id=%1) because this is not a truffle field", (long)n);
            return;
        }
        IUserHintHandler iUserHintHandler = this.terminal.getUserHintHandler();
        if (iUserHintHandler != null) {
            int n2 = TouchController.getAbsoluteX(this) + this.getWidth();
            int n3 = TouchController.getAbsoluteY(this) + this.getHeight() + this.getHintYOffset();
            tpLogChannelInternal.log(10000000, new StringBuffer().append("TouchController#showUserHintAnimation: hintID: ").append(n).append(", getAbsoluteY(this): ").append(TouchController.getAbsoluteY(this)).append(", this.getHeight(): ").append(this.getHeight()).append(", getHintYOffset():").append(this.getHintYOffset()).toString());
            tpLogChannelInternal.log(10000000, new StringBuffer().append("TouchController#showUserHintAnimation: hintID: ").append(n).append(", rightBorderWidget: ").append(n2).append(", bottomBorderOfWidget: ").append(n3).toString());
            iUserHintHandler.requestHintAnimation(n, n2, n3);
        } else {
            tpLogChannelInternal.log(10000, "TouchController#showUserHintAnimation: not able to show user hint (id=%1), because user hint handler is null!", (long)n);
        }
    }

    protected int getHintYOffset() {
        return 0;
    }

    protected void updateUserHintPos() {
        if (this.terminal != null) {
            IUserHintHandler iUserHintHandler = this.terminal.getUserHintHandler();
            this.userHintPosUpdate(iUserHintHandler);
        }
    }

    protected void userHintPosUpdate(IUserHintHandler iUserHintHandler) {
        iUserHintHandler.updateUserHintPos(TouchController.getAbsoluteX(this) + this.getWidth(), TouchController.getAbsoluteY(this) + this.getHeight());
    }

    public static int getAbsoluteY(AbstractWidget abstractWidget) {
        int n = abstractWidget.getY();
        while (abstractWidget.getParent() != null) {
            abstractWidget = abstractWidget.getParent();
            n += abstractWidget.getY();
        }
        return n;
    }

    public static int getAbsoluteX(AbstractWidget abstractWidget) {
        int n = abstractWidget.getX();
        while (abstractWidget.getParent() != null) {
            abstractWidget = abstractWidget.getParent();
            n += abstractWidget.getX();
        }
        return n;
    }

    protected void handleHKBackShortPress() {
        this.setFastDelete(false);
        this.handleDelete();
        this.notifyPRPAboutSpellerInput('\b');
    }

    protected void handleHKBackLongPress() {
        this.clear(true);
    }

    private void takeMeBackToSmallStage() {
        if (tpLogChannelInternal.isDebug()) {
            tpLogChannelInternal.log(10000000, "TouchController#takeMeBackToSmallStage: isFocused=%1 | spellerOpen=%1, spellerClosed=%2 / jobCanceled=%3", this.isFocused(), this.isSpellerOpen(), this.takeBackSmallStageJob.isCanceled());
        }
        if (!this.isFocused() || this.isSpellerOpen() || this.animationListener.isSpellerOpening() || !this.inputFieldData.isEmpty()) {
            tpLogChannelInternal.log(10000000, "TouchController#takeMeBackToSmallStage: abort!");
            return;
        }
        this.terminal.getViewSizeManager().unrequestLargeViewSize(11);
    }

    private void restartTakeBackSmallStageJob() {
        tpLogChannelInternal.log(10000000, "TouchController#restartTakeBackSmallStageJob");
        this.stopTakeBackSmallStageJob();
        this.takeBackSmallStageTimerEvent = new TimerEvent(this);
        this.takeBackSmallStageJob = framework.getHMIService().getEventDispatcher().postEvent(this.takeBackSmallStageTimerEvent, 10000L);
    }

    private void stopTakeBackSmallStageJob() {
        tpLogChannelInternal.log(10000000, "TouchController#stopTakeBackSmallStageJob");
        if (this.takeBackSmallStageTimerEvent != null) {
            this.takeBackSmallStageTimerEvent.consume();
            this.takeBackSmallStageTimerEvent = null;
        }
        if (this.takeBackSmallStageJob != null) {
            this.takeBackSmallStageJob.cancel();
            this.takeBackSmallStageJob = null;
        }
    }

    private void updateTakeBackSmallStageTimer() {
        if (tpLogChannelInternal.isDebug()) {
            tpLogChannelInternal.log(10000000, "TouchController#updateTakeBackSmallStageJob: spellerOpen(ing)=%1, spellerClosed=%2 / focused=%3", this.animationListener.isSpellerOpening() || this.isSpellerOpen(), this.isSpellerClosed(), this.isFocused());
        }
        if (this.animationListener.isSpellerOpening() || this.isSpellerOpen() || !this.inputFieldData.isEmpty() || !this.isFocused()) {
            this.stopTakeBackSmallStageJob();
        } else if (this.isSpellerClosed() && this.isFocused() && this.inputFieldData.isEmpty()) {
            this.restartTakeBackSmallStageJob();
        }
    }

    protected final void iconDelayEventFired() {
        this.updateInfoLineState(true);
        this.calculateCursorPosition();
        this.setCompositesDirty(true);
        if (this.showTopImage()) {
            this.invalidateParentLayout();
        }
    }

    private void handleDelete() {
        if (!this.inputFieldData.isStartOfText()) {
            boolean bl = this.inputFieldData.delete(this.fastDelete);
            this.clearSuggestion();
            if (bl) {
                this.showUserHintAnimation(80);
            }
        }
        this.updateVanityNumberInput();
        if (this.showTopImage()) {
            this.invalidateParentLayout();
        }
    }

    public void clearSuggestion() {
        this.currentSuggestion = null;
        this.currentSuggestedNewSearchString = null;
        this.blockSuggestions = true;
        if (this.speller != null && !this.isSpellerClosed()) {
            this.speller.setAutoCompletionText(null, "");
        }
    }

    protected void updateModelText(String string, char c2) {
        if (this.model instanceof SpellerModelGUI) {
            this.lastInput = c2;
            if (c2 != '\b') {
                this.blockSuggestions = false;
            } else {
                this.stringToSpeak = null;
                this.lastBackspaceTime = framework.getMonotonicTime();
            }
            String string2 = string;
            char c3 = TouchController.calculateLastCharacterInRightCase(string2, c2);
            if (tpLogChannelInternal.isDebug()) {
                tpLogChannelInternal.log(10000000, "TouchController#updateModelText [MODEL COMMUNICATION ->] writing to Model: modelString: %1 / lastCharacter=%2", (Object)string2, (Object)StringUtility.sanitizeCharacterForLogging(c3));
            }
            SpellerModelGUI spellerModelGUI = (SpellerModelGUI)this.model;
            spellerModelGUI.textChanged(string2, c3, this.terminal.getTerminalID());
            this.setInputLock(true);
            if (this.isSDSActive()) {
                if (tpLogChannelInternal.isDebug()) {
                    tpLogChannelInternal.log(10000000, "TouchController#updateModelText notify SDS about text change: modelString: %1 / lastCharacter=%2", (Object)string2, (Object)StringUtility.sanitizeCharacterForLogging(c3));
                }
                AbstractWidget.sdsService.textChanged(spellerModelGUI.getID(), string2, c3);
                tpLogChannelInternal.log(10000000, "TouchController#updateModelText notify SDS about text change - method returned");
            }
            this.setEnteredString(string2);
        }
        if (c2 == '\b' && this.inputFieldData.isEmpty()) {
            this.firstChar = true;
            if (this.isSpellerClosed()) {
                tpLogChannelInternal.log(10000000, "TouchController#updateModelText: restart IconDelayTimer");
                this.timerListener.restartShowIconAfterFingerTraceCleanDelayTimer();
            }
        }
        this.updateInfoLineState(true);
        this.propagateValidChars(false);
        this.updateTakeBackSmallStageTimer();
    }

    private static char calculateLastCharacterInRightCase(String string, char c2) {
        if (c2 == '\b' || c2 == '\u0000' || string == null || string.length() == 0) {
            return c2;
        }
        return string.charAt(string.length() - 1);
    }

    public final void keyPressed(KeyEvent keyEvent) {
        if (this.shallIgnoreEvents()) {
            tpLogChannelKeypanel.log(10000000, "TouchController#keyPressed: Key Event ignored");
            return;
        }
        tpLogChannelKeypanel.log(10000000, "TouchController#keyPressed evt: %1, model: %2", (Object)keyEvent, this.model);
        if (keyEvent.isConsumed()) {
            return;
        }
        if (this.isSDSMultimodal()) {
            keyEvent.setSdsAction(3);
        }
        this.restartUserHintIdleJob();
        this.handlePressedEvent(keyEvent);
        this.hideFingerTrace();
    }

    protected void handlePressedEvent(KeyEvent keyEvent) {
        int n = keyEvent.getKeyCode();
        this.setLastInputByTouch(false);
        if (n == 15 && !this.inputFieldData.isEmpty() && !this.isAllInputLocked()) {
            this.timerListener.startHKBackLongPressJobIfNotRunning();
            this.calculateCursorPosition();
            keyEvent.consume(false);
            return;
        }
        if (n == 15 && (this.isSpellerOpen() || this.animationListener.isSpellerOpening())) {
            this.closeSpeller(false, true);
            keyEvent.consume(true);
            return;
        }
        if (n == 17 && this.isSpellerOpen()) {
            if (!this.isSpellerInputAllowed()) {
                this.showNoInputPopup();
                return;
            }
            super.keyPressed(keyEvent);
            return;
        }
        if (this.suggestionsAvailable() && n == 17 && !this.isAllInputLocked()) {
            this.handleAutoCompletion(this.currentSuggestedNewSearchString);
            this.currentSuggestion = null;
            this.currentSuggestedNewSearchString = null;
            this.setCompositesDirty(true);
            keyEvent.consume(true);
            return;
        }
        if (!(n != 17 || this.isSpellerOpen() || !this.isAllInputLocked() && this.isSpellerInputAllowed())) {
            keyEvent.consume(false);
            return;
        }
        if (n == 17 && this.speller != null && (this.inputFieldData.isEmpty() || this.isPrefilledInputField() || !this.isTouchpadKeypanelWithActiveStatus())) {
            this.openSpeller(true);
            keyEvent.consume(true);
            return;
        }
        if (n == 17 && this.hasState(36) && (this.isMatchSpellerMode() || this.isTruffleSearch() || this.isPureFreetext() || this.speller == null) && this.model instanceof SpellerModelGUI) {
            this.okPressed(null);
            keyEvent.consume(true);
            return;
        }
    }

    public boolean isPrefilledInputField() {
        return this.isPrefilledInputField;
    }

    public void setPrefilledInputField(boolean bl) {
        this.isPrefilledInputField = bl;
    }

    private boolean isSDSMultimodal() {
        return this.touchpadMode == 64 || this.touchpadMode == 114;
    }

    public boolean isMatchspellerModel() {
        return this.model instanceof MatchspellerModelGUI;
    }

    public String getCurrentSuggestion() {
        return this.currentSuggestion;
    }

    public void keyReleased(KeyEvent keyEvent) {
        this.hideFingerTrace();
        if (this.shallIgnoreEvents()) {
            return;
        }
        tpLogChannelKeypanel.log(10000000, "TouchController#keyReleased evt: %1, model: %2", (Object)keyEvent, this.model);
        if (keyEvent.getKeyCode() == 15 && this.timerListener.isHKBackLongPressJobRunning()) {
            this.timerListener.cancelHKBackLongPressTimer();
            this.handleHKBackShortPress();
            keyEvent.consume();
        }
        super.keyReleased(keyEvent);
    }

    protected final void closeSpeller() {
        this.closeSpeller(true, true);
    }

    protected void closeSpeller(boolean bl, boolean bl2) {
        this.handleSpellerState(false, bl2);
        if (!this.isDTMF() && bl) {
            if (bl2) {
                this.animationListener.setFocusFirstMenuLineAfterSpellerClose(true);
            } else {
                this.focusFirstMenuLineAfterTouchfield();
            }
            this.stopCursorBlinkAnimation();
        }
    }

    private boolean isDTMF() {
        return this.touchpadMode == 113;
    }

    public final void keyTurned(WheelButtonEvent wheelButtonEvent) {
        if (this.shallIgnoreEvents()) {
            return;
        }
        this.handleTurnEvent(wheelButtonEvent);
        this.hideFingerTrace();
        this.calculateCursorPosition();
    }

    protected void handleTurnEvent(WheelButtonEvent wheelButtonEvent) {
        if (this.speller != null && !this.isSpellerClosed()) {
            if (!this.isSpellerInputAllowed()) {
                this.speller.updateValidChars("");
                wheelButtonEvent.consume();
                this.showNoInputPopup();
                return;
            }
            this.speller.keyTurned(wheelButtonEvent);
            this.postActionsKeyTurn();
        }
    }

    protected void postActionsKeyTurn() {
        if (!this.getSpeller().shallShowAutoCompletion()) {
            this.setTitleAreaVisible(true);
        }
    }

    public final void keyMoved(JoystickEvent joystickEvent) {
        if (this.shallIgnoreEvents() || joystickEvent.isConsumed()) {
            return;
        }
        this.handleMoveEvent(joystickEvent);
        this.hideFingerTrace();
        if (joystickEvent.isConsumed() && !this.isSDSMultimodal()) {
            joystickEvent.setSdsAction(0);
        }
        super.keyMoved(joystickEvent);
    }

    protected void handleMoveEvent(JoystickEvent joystickEvent) {
        boolean bl;
        if (this.isSpellerClosed() && joystickEvent.getDirection() == 2) {
            if (this.isSpellerInputAllowed()) {
                this.openSpeller(true);
            }
            joystickEvent.consume(true);
        } else if (!this.isSpellerClosed() && joystickEvent.getDirection() == 6) {
            this.closeSpeller();
            joystickEvent.consume(true);
        } else if (this.isSpellerOpen() && joystickEvent.getDirection() == 2 && this.speller.shallShowAutoCompletion()) {
            tpLogChannelInternal.log(10000000, "TouchController#handleMoveEvent currentSuggestedNewSearchString: %1", (Object)this.currentSuggestedNewSearchString);
            String string = null;
            string = this.isSpellerOpen() && this.currentSuggestedNewSearchString != null ? this.currentSuggestedNewSearchString : this.speller.getAutoCompletion();
            this.handleAutoCompletion(string);
            this.setCompositesDirty(true);
            joystickEvent.consume(true);
        } else if (!this.isSpellerOpen() && joystickEvent.getDirection() == 6 && (bl = this.focusFirstMenuLineAfterTouchfield())) {
            joystickEvent.consume();
        }
    }

    protected void openSpeller(boolean bl) {
        if (this.isOpenSpellerOnOtherScreen()) {
            if (this.model instanceof SpellerModelGUI) {
                ((SpellerModelGUI)this.model).setTouchEventForFollowUpScreen(null);
            }
            this.notifyAppAboutSpellerState(true);
        } else {
            this.handleSpellerState(true, bl);
            if (this.getSpeller().shallShowAutoCompletion()) {
                this.setTitleAreaVisible(false);
            }
        }
    }

    protected void moveFieldToTopOfMenu() {
        if (this.parent instanceof MenuController && this.isConnectedSubtree()) {
            MenuController menuController = (MenuController)this.parent;
            MenuItemIndex menuItemIndex = menuController.getMenuItemIndex(this);
            menuLogCh.log(10000000, "TouchController#moveFieldToTopOfMenu: scroll speller item to top: %1", (Object)menuItemIndex);
            menuController.focusItemImmediately(menuItemIndex, FocusAdvice.VIEWPORT_FIRST_POSITION);
        }
    }

    protected final boolean focusFirstMenuLineAfterTouchfield() {
        return this.focusFirstMenuLineAfterTouchfield(false);
    }

    protected final boolean focusFirstMenuLineAfterTouchfield(boolean bl) {
        if (this.parent instanceof MenuController) {
            MenuController menuController = (MenuController)this.parent;
            MenuItemIndex menuItemIndex = menuController.getFocusedIndex();
            Iterator iterator = menuController.iterator(menuItemIndex, true, false);
            if (iterator.hasNext()) {
                MenuItemIndex menuItemIndex2 = (MenuItemIndex)iterator.next();
                menuLogCh.log(10000000, "TouchController#focusFirstMenuLineAfterTouchfield: focus next item (index: %1) after touchfield", (Object)menuItemIndex2);
                if (bl) {
                    menuController.focusItem(menuItemIndex2);
                } else {
                    menuController.focusItemImmediately(menuItemIndex2, FocusAdvice.KEEP_POSITION);
                }
                return true;
            }
            this.startCursorBlinkAnimation();
            tpLogChannelInternal.log(1000000, "TouchController#focusFirstMenuLineAfterTouchfield: Cannot focus first menu line after touchField. There seems to be none!");
            return false;
        }
        return false;
    }

    protected void handleAutoCompletion(String string) {
        tpLogChannelInternal.log(10000000, "TouchController#handleAutoCompletion: completion=%1", (Object)string);
        this.inputFieldData.clear(false);
        this.inputFieldData.insertAutoCompletion(string);
        this.speller.getCurrentSpellerBand().autoCompletionAccepted();
        this.clearSuggestion();
        this.blockSuggestions = false;
        this.setTitleAreaVisible(true);
    }

    public boolean suggestionsAvailable() {
        return this.currentSuggestion != null;
    }

    protected final boolean isSuggestionValid(String string, String string2) {
        boolean bl;
        int n = this.inputFieldData.getTextLength();
        boolean bl2 = bl = this.isTouchInputAllowed() && this.isTouchpadKeypanelWithActiveStatus() && !this.blockSuggestions && string != null && string.length() > n && string2 != null && string2.length() > n;
        if (bl) {
            bl &= this.isSpellerClosed();
            bl &= string.toUpperCase().startsWith(this.inputFieldData.getCurrentText().toUpperCase());
            bl &= !this.inputFieldData.isEmpty();
        }
        if (tpLogChannelInternal.isDebug()) {
            tpLogChannelInternal.log(10000000, "TouchController#isSuggestionValid: suggestion =%1 / current touch input data is: %2 / suggestedNewSearchString = %3 / validSuggestion = %4", (Object)string, (Object)this.inputFieldData, (Object)string2, (Object)String.valueOf(bl));
        }
        return bl;
    }

    public boolean isSpellerClosed() {
        return this.speller == null || this.getSpellerOpenProgress() == 0.0f;
    }

    protected final boolean isSpellerOpen() {
        return this.speller != null && this.getSpellerOpenProgress() == 1.0f;
    }

    protected final void setRecognizerMode(int n) {
        if (this.terminal != null && this.terminal.getTouchInputManager() != null) {
            this.terminal.getTouchInputManager().setDesiredRecognizerMode(this, n);
        } else {
            tpLogChannelInternal.log(10000, "TouchController#setRecognizerMode getTouchInputManager is null, recognizerMode not set!");
        }
    }

    public void setRenderer(IRenderer iRenderer) {
        this.renderer = iRenderer;
    }

    public void setTouchpadMode(int n) {
        if (n >= 16) {
            spellerLogChannel.log(10000000, "TouchController#setTouchpadMode: changing speller mode from %1 to %2", (long)this.touchpadMode, (long)n);
            this.touchpadMode = n;
            boolean bl = this.isPasswordField() && !this.isWlanPasswordField();
            this.inputFieldData.setPasswordMode(bl);
            this.inputFieldData.setCaseBalanced(this.hasCaseBalancing(n));
            this.inputFieldData.setUpperCaseOnly(this.isMatchSpellerMode() || n == 83);
        } else {
            tpLogChannelInternal.log(10000, "TouchController#setTouchpadMode: Touchpadmode=%1 is not deprecated - use new touchpad modes.", (long)n);
            this.touchpadMode = 32;
        }
    }

    private boolean hasCaseBalancing(int n) {
        return n == 32 || n == 98 || n >= 48 && n < 64;
    }

    protected void handleSpellerState(boolean bl, boolean bl2) {
        tpLogChannelInternal.log(1000000, "TouchController#handleSpellerState: isFadeIn=%1; animate=%2", bl, bl2);
        if (this.speller == null) {
            return;
        }
        if (bl) {
            this.animationListener.setFocusFirstMenuLineAfterSpellerClose(false);
            if (this.requestBigStage(true)) {
                return;
            }
            this.currentSuggestion = null;
            this.currentSuggestedNewSearchString = null;
            this.propagateValidChars(true);
            this.updateButtonStates();
            this.spellerCharacterFocused(TouchController.extractFirstCharacter(this.speller.extractString(this.speller.getCurrentFocus())));
            if (!this.isDTMF()) {
                this.moveFieldToTopOfMenu();
            }
            this.hideFingerTrace();
            this.setSpellerLastMode(1);
            this.timerListener.stopUserHintIdleJob();
        } else {
            this.openSpellerAfterViewSizeChange = false;
            this.spellerCharacterFocused('\u0000');
            if (this.shouldRender() && this.initContext != null && this.initContext.getScreen() != null) {
                ((AbstractScreenWidget)this.initContext.getScreen()).getTitleArea().getScreenAreaWidget().setOnScreen(true);
            }
        }
        this.animationListener.setTargetSpellerOpenProgress(bl ? 1.0f : 0.0f);
        this.calculateCursorPosition();
        if (this.getTargetSpellerOpenProgress() == this.getSpellerOpenProgress()) {
            return;
        }
        this.notifyAppAboutSpellerState(bl);
        if (!bl2) {
            this.animationListener.setSpellerOpenProgress(this.getTargetSpellerOpenProgress());
            this.updateSuggestions();
            return;
        }
        this.animationListener.setStartSpellerOpenProgress(this.getSpellerOpenProgress());
        AbstractAnimation abstractAnimation = this.animationListener.getSpellerOpenAnimation();
        if (abstractAnimation.isAnimating()) {
            abstractAnimation.setTarget(abstractAnimation.getTarget() + 1000.0f);
        } else {
            abstractAnimation.startDynamicAnimation(0.0f, 1000.0f, 77, false, this);
        }
    }

    public static char extractFirstCharacter(String string) {
        if (StringUtilities.isNullOrEmpty(string)) {
            return '\u0000';
        }
        return string.charAt(0);
    }

    protected void calculateCursorPosition() {
        this.isCursorAtInitialPosition = !this.isTouchpadKeypanelWithActiveStatus() ? false : (this.timerListener.isShowIconAfterFingerTraceCleanDelayJobRunning() ? false : (this.fingerTraceWidget != null && this.fingerTraceWidget.isLineVisible() ? false : (this.isSpellerClosed() || this.animationListener.isSpellerClosing()) && !this.animationListener.isSpellerOpening() && this.inputFieldData.isEmpty()));
        this.setCompositesDirty(true);
    }

    private void notifyAppAboutSpellerState(boolean bl) {
        if (this.model instanceof SpellerModelGUI) {
            int n = bl ? 4711 : 4712;
            ((SpellerModelGUI)this.model).commandPressed(n, this.terminal.getTerminalID());
            tpLogChannelInternal.log(10000000, "TouchController#notifyAppAboutSpellerState [MODEL COMMUNICATION ->] commandPressed=%1 (COMMAND_SPELLER_OPENED=%2, COMMAND_SPELLER_CLOSED=%3)", (long)n, 4711L, 4712L);
        }
        this.updateTakeBackSmallStageTimer();
    }

    private boolean requestBigStage(boolean bl) {
        if (this.terminal.getViewSizeManager() != null) {
            tpLogChannelInternal.log(10000000, "TouchController#requestBigStage: Request large stage, because of speller opening or touch input!");
            if (!this.terminal.getViewSizeManager().isRequestActive(11)) {
                this.terminal.getViewSizeManager().requestLargeViewSize(11);
            }
            if (this.terminal.getViewSizeManager().getCurrentViewSize() == 1) {
                this.openSpellerAfterViewSizeChange = bl;
                return true;
            }
        }
        return false;
    }

    protected void propagateValidChars(boolean bl) {
        tpLogChannelInternal.log(10000000, "TouchController#propagateValidChars validChars='%2' blocked=%1", this.isInputLocked(), (Object)this.matchSpellerValidChars);
        if (!this.isSpellerClosed() || bl && this.speller != null) {
            if (this.isTextMaxLengthMet() || !this.isSpellerInputAllowed()) {
                this.speller.updateValidChars("", true);
            } else if (this.isMatchSpellerMode()) {
                this.speller.updateValidChars(this.matchSpellerValidChars, bl);
            } else {
                this.speller.updateValidChars(null);
            }
        }
    }

    protected boolean isTextMaxLengthMet() {
        boolean bl = false;
        bl = this.inputFieldData.getTextLength() >= this.inputFieldData.getMaximumTextLength();
        return bl;
    }

    protected final void updateMenuCursorVisibility() {
        if (this.parent instanceof MenuController) {
            ((MenuController)this.parent).setFocusCursorVisible(this.isSpellerClosed(), this);
            ((MenuController)this.parent).setFocusCursorVisible(!this.userHintPartialPopupListener.isUserHintShown(), userHintCursorHideReason);
        }
    }

    public void animate(int n, float f2) {
        this.animationListener.animate(n, f2, 0);
    }

    public float getCursorOpacity() {
        return this.cursorOpacity;
    }

    public void setCursorOpacity(float f2) {
        this.cursorOpacity = f2;
    }

    public int getSpellerHeight() {
        return 35;
    }

    public void setSpeller(SpellerController spellerController) {
        spellerController.registerSpellerListener(this.spellerListener);
        this.speller = spellerController;
        super.add(spellerController);
    }

    public void setSuggestionWidget(SuggestionController suggestionController) {
        super.add(suggestionController);
    }

    public void clear(boolean bl) {
        boolean bl2 = !bl;
        tpLogChannelInternal.log(10000000, "TouchController#clear: Clear textfieldContent - isModelTriggered=%1", bl2);
        this.clearInputData(bl2);
        this.clearSuggestion();
        if (bl2) {
            this.updateInfoLineState(false);
        } else {
            this.hideFingerTrace();
        }
        if (!this.firstChar && this.isTruffleSearch()) {
            ++truffleInputCount;
        }
        this.updateVanityNumberInput();
        if (this.showTopImage()) {
            this.invalidateParentLayout();
        }
    }

    protected void clearInputData(boolean bl) {
        this.inputFieldData.clear(!bl);
    }

    public void hideFingerTrace() {
        if (this.fingerTraceWidget != null) {
            tpLogChannelInternal.log(10000000, "TouchController#hideFingerTrace: called!");
            this.fingerTraceWidget.hideFingerTrace();
        }
    }

    public void okPressed(SpellerButtonArgument spellerButtonArgument) {
        int n = this.inputFieldData.getTextLength();
        if (this.model instanceof SpellerModelGUI && n >= this.inputFieldData.getMinimumTextLength() && n <= this.inputFieldData.getMaximumTextLength()) {
            tpLogChannelKeypanel.log(1000000, "TouchController#keyPressed [MODEL COMMUNICATION ->] calling keyTyped at SpellerModelGUI");
            SpellerModelGUI spellerModelGUI = (SpellerModelGUI)this.model;
            spellerModelGUI.keyTyped(0, this.terminal.getTerminalID());
            if (spellerButtonArgument != null) {
                tpLogChannelKeypanel.log(10000000, "TouchController#okPressed button argument executing");
                spellerButtonArgument.execute();
            }
        } else {
            tpLogChannelKeypanel.log(10000000, "TouchController#keyPressed NOT calling keyTyped at model (model=%1, minLength=%2, maxLength=%3)", this.model, (long)this.inputFieldData.getMinimumTextLength(), (long)this.inputFieldData.getMaximumTextLength());
        }
    }

    public void moveCursorLeft() {
        this.inputFieldData.moveCursor(-1);
        this.updateButtonStates();
        this.setCompositesDirty(true);
    }

    public void moveCursorRight() {
        this.inputFieldData.moveCursor(1);
        this.updateButtonStates();
        this.setCompositesDirty(true);
    }

    public void moveCursorNewLine() {
        this.updateButtonStates();
    }

    public int getMarginTop() {
        return this.marginTop;
    }

    public void setCursorOffsetTop(int n) {
        this.setMarginTop(n);
    }

    public void setMarginTop(int n) {
        this.marginTop = n;
    }

    public int getMarginBottom() {
        return (int)((float)this.marginBottom + this.getMMIKombiExtraHeight());
    }

    public void setCursorOffsetBottom(int n) {
        this.setMarginBottom(-n);
    }

    public void setMarginBottom(int n) {
        this.marginBottom = n;
    }

    public int getGlassplateInsetsTop() {
        return this.glassplateInsetsTop;
    }

    public void setGlassplateInsetsTop(int n) {
        this.glassplateInsetsTop = n;
    }

    public int getGlassplateInsetsBottom() {
        return this.glassplateInsetsBottom;
    }

    public void setGlassplateInsetsBottom(int n) {
        this.glassplateInsetsBottom = n;
    }

    public int getGlassplateInsets(boolean bl) {
        return bl ? this.glassplateInsetsTop : this.glassplateInsetsBottom;
    }

    public int getMargin(boolean bl) {
        int n = bl ? this.getMarginTop() : this.getMarginBottom();
        return n + 1;
    }

    public void setSpellerAlwaysOpen(boolean bl) {
    }

    public void touchPadPressed(TouchEvent touchEvent) {
        if (this.shallIgnoreEvents()) {
            return;
        }
        if (!this.isAllInputLocked()) {
            this.fingerTraceWidget.touchPadPressed(touchEvent);
        }
        if (!this.isSpellerClosed()) {
            touchEvent.consume(false);
        }
        this.restartUserHintIdleJob();
    }

    private boolean shallIgnoreEvents() {
        return !this.isEnabled() || !this.isFocused();
    }

    public void touchPadReleased(TouchEvent touchEvent) {
        if (this.shallIgnoreEvents()) {
            return;
        }
        if (!this.isAllInputLocked()) {
            this.fingerTraceWidget.touchPadReleased(touchEvent);
        }
        if (!this.isSpellerClosed()) {
            touchEvent.consume(false);
        }
        this.restartUserHintIdleJob();
    }

    public void touchPadPositionMoved(TouchEvent touchEvent) {
        if (this.shallIgnoreEvents()) {
            return;
        }
        if (!this.isAllInputLocked()) {
            this.fingerTraceWidget.touchPadPositionMoved(touchEvent);
        }
        if (!this.isSpellerClosed()) {
            touchEvent.consume(false);
        }
    }

    protected final void spellerCharacterFocused(char c2) {
        if (this.model instanceof SpellerModelGUI) {
            if (tpLogChannelInternal.isDebug()) {
                tpLogChannelInternal.log(10000000, "TouchController#spellerCharacterFocused [MODEL COMMUNICATION ->] focusedCharacter called and propagated to model with character: '%1'!", (Object)StringUtility.sanitizeCharacterForLogging(c2));
            }
            ((SpellerModelGUI)this.model).focusedCharacter(c2, this.getTerminal().getTerminalID());
        }
    }

    public void setFocused(boolean bl) {
        boolean bl2 = this.isFocused() != bl;
        super.setFocused(bl);
        tpLogChannelInternal.log(10000000, "TouchController#setFocused: called with focused=%1; focusChanged=%2", bl, bl2);
        if (bl2) {
            this.isCursorVisible = bl;
            if (!bl) {
                this.hideFingerTrace();
                this.stopCursorBlinkAnimation();
                if (this.timerListener.isShowIconAfterFingerTraceCleanDelayJobRunning()) {
                    this.timerListener.stopShowIconAfterFingerTraceCleanDelayJob();
                    this.updateInfoLineState(true);
                }
                this.timerListener.stopUserHintIdleJob();
                this.terminal.getUserHintHandler().removeCurrentUserHint();
                this.stopTakeBackSmallStageJob();
                if (this.isPasswordField()) {
                    this.inputFieldData.hideCharacters();
                }
                this.closeSpeller(false, false);
            } else {
                this.startCursorBlinkAnimation();
                this.restartUserHintIdleJob();
            }
            this.setCompositesDirty(true);
        }
        this.calculateCursorPosition();
        this.updateRecognizerMode();
    }

    protected boolean shouldPropagatePaint() {
        return true;
    }

    protected void updateInfoLineState(boolean bl) {
        if (this.animationListener.setInfoLineProgress(this.isInfoLineVisible(), bl)) {
            this.setCompositesDirty(true);
            this.invalidateParentLayout();
        }
    }

    public int getWidgetID() {
        return this.widgetID;
    }

    public void setWidgetID(int n) {
        this.widgetID = n;
    }

    public final boolean isInfoLineVisible() {
        boolean bl;
        boolean bl2 = this.inputFieldData != null && !this.inputFieldData.isEmpty();
        int n = this.hasLockInfoMessage() ? 1 : 0;
        boolean bl3 = bl = !this.isEnabled() || this.animationListener.isSpellerFading() || this.timerListener.isShowIconAfterFingerTraceCleanDelayJobRunning() || this.infoLineText == null && (this.infoTextIDs == null || this.infoTextIDs.length == n && !this.isAllInputLocked()) || bl2 && !this.isAllInputLocked();
        if (bl) {
            return false;
        }
        boolean bl4 = this.terminal.getUserHintHandler().shallShowUserHints() || this.isAllInputLocked();
        return bl4;
    }

    public String getInfoText() {
        int n;
        int n2 = n = this.isAllInputLocked() && this.hasLockInfoMessage() ? 0 : this.chosenInfoLineTextIndex;
        if (this.infoLineText != null) {
            return this.infoLineText;
        }
        if (this.infoTextIDs != null && this.infoTextIDs.length > n && n >= 0) {
            if (this.terminal != null && this.terminal.getViewSizeManager() != null) {
                int n3 = 0;
                n3 = this.isSportSkin() ? (this.terminal.getViewSizeManager().isSportskinSmallStage() ? 1 : 2) : this.terminal.getViewSizeManager().getCurrentViewSize();
                return this.getInitContext().getScreenFactory().getText(this.infoTextIDs[n], n3);
            }
            return this.getInitContext().getScreenFactory().getText(this.infoTextIDs[n]);
        }
        return null;
    }

    public String getInfoTextSDS() {
        if (this.infoTextSDSIDs != null && this.infoTextSDSIDs.length > this.chosenInfoLineTextSDSIndex) {
            if (this.terminal != null && this.terminal.getViewSizeManager() != null) {
                return this.getInitContext().getScreenFactory().getText(this.infoTextIDs[this.chosenInfoLineTextIndex], this.terminal.getViewSizeManager().getCurrentViewSize());
            }
            return this.getInitContext().getScreenFactory().getText(this.infoTextIDs[this.chosenInfoLineTextIndex]);
        }
        return null;
    }

    public void setInfoTextIDs(int[] nArray) {
        this.infoTextIDs = nArray;
    }

    public void setInfoLineText(String string) {
        this.infoLineText = string;
    }

    public void setInfoTextIDSDS(int[] nArray) {
        this.infoTextSDSIDs = nArray;
    }

    public void setInitialTextID(int n) {
        this.initialTextID = n;
    }

    public void setInitialText(String string) {
        this.initialText = string;
    }

    public String getInitialText() {
        if (this.initialTextLabel != null) {
            return this.initialTextLabel.getText();
        }
        if (this.initialTextID != -1) {
            if (this.terminal != null && this.terminal.getViewSizeManager() != null) {
                int n = 0;
                n = this.isSportSkin() ? (this.terminal.getViewSizeManager().isSportskinSmallStage() ? 1 : 2) : this.terminal.getViewSizeManager().getCurrentViewSize();
                return this.getInitContext().getScreenFactory().getText(this.initialTextID, n);
            }
            return this.getInitContext().getScreenFactory().getText(this.initialTextID);
        }
        if (this.initialText != null) {
            return this.initialText;
        }
        return null;
    }

    public void setInitialTextLabel(LabelController labelController) {
        this.add(labelController);
        this.initialTextLabel = labelController;
    }

    public IInputTextInfoProvider getInputData() {
        return this.inputFieldData;
    }

    public int getCursorPosition() {
        return this.inputFieldData.getCursorPos();
    }

    public void setViewSizeAnimation(float f2, float[] fArray, float[] fArray2, boolean bl) {
        if (bl) {
            if (fArray2[0] == 1.0f) {
                this.closeSpeller(false, false);
            }
            this.setCompositesDirty(true);
        }
    }

    protected void handleBigStageAndSpellerOpen() {
        tpLogChannelInternal.log(10000000, "TouchController#setViewSizeAnimation: Opening speller on large stage!");
        this.handleSpellerState(true, false);
        this.openSpellerAfterViewSizeChange = false;
    }

    public void viewSizeAnimationStarted(float f2, float[] fArray, float[] fArray2) {
    }

    public void setViewSizeAnimationFinished(float[] fArray, boolean bl) {
        if (fArray[0] == 1.0f && !this.isSportSkin()) {
            this.terminal.getViewSizeManager().unrequestLargeViewSize(11);
        }
        if (this.openSpellerAfterViewSizeChange && fArray[0] == 0.0f) {
            this.handleBigStageAndSpellerOpen();
            this.setCompositesDirty(true);
        }
        if (this.isSportSkin()) {
            this.setCompositesDirty(true);
        }
    }

    private boolean isSportSkin() {
        if (this.terminal != null) {
            return ((HMITerminalEvo)((Object)this.terminal)).getSkin() == 1;
        }
        tpLogChannelInternal.log(10000, "TouchCcontroller#isTTS terminal is NULL");
        return false;
    }

    public void viewSizeTargetChanged(float[] fArray, float[] fArray2, boolean bl) {
        if (fArray2[0] == 1.0f) {
            this.terminal.getUserHintHandler().removeCurrentUserHint();
            this.openSpellerAfterViewSizeChange = false;
            if (this.isSportSkin()) {
                this.closeSpeller(false, true);
            }
        }
    }

    public int getSdsItemSelectedAction() {
        return this.isSDSMultimodal() ? 3 : this.sdsItemSelectedAction;
    }

    public void setSdsItemSelectedAction(int n) {
        this.sdsItemSelectedAction = n;
    }

    public boolean hasInfolineText() {
        return false;
    }

    public String getInfolineText() {
        return null;
    }

    public boolean showIcon() {
        return this.inputFieldData.isEmpty() && this.getSpellerOpenProgress() < 1.0f && (this.fingerTraceWidget == null || !this.fingerTraceWidget.isLineVisible() || !this.isFocused()) && !this.timerListener.isShowIconAfterFingerTraceCleanDelayJobRunning();
    }

    public boolean isTouchpadKeypanelWithActiveStatus() {
        if (this.terminal != null && this.terminal.getKbdService() != null) {
            return this.getIsTouchpadKeypanelWithActiveStatus();
        }
        return true;
    }

    protected boolean getIsTouchpadKeypanelWithActiveStatus() {
        return this.terminal.getKbdService().isTouchKeypanel();
    }

    private boolean isJoystickKeypanel() {
        if (this.terminal != null && this.terminal.getKbdService() != null) {
            return this.terminal.getKbdService().isPanelWithJoystick();
        }
        return true;
    }

    public void setFingerTracePlatePosition(int n, int n2) {
        this.fingerTraceWidget.toAbstractWidget().setX(n);
        this.fingerTraceWidget.toAbstractWidget().setY(n2 + this.getTopImageHeight());
    }

    public void changeCharset(int n) {
        this.touchUtil.setCharSet(n);
        this.updateCharSetForPRPandSpeller();
        this.switchedLanguageVanityNum = false;
        this.setCompositesDirty(true);
    }

    private void updateCharSetForPRPandSpeller() {
        this.updatePRPEngineWithLanguageIndex();
        this.setLanguage(this.touchUtil);
    }

    protected void updatePRPEngineWithLanguageIndex() {
        int n = this.touchUtil.getInternalLanguage();
        this.prpEngine = this.getPRPEngine(n);
    }

    protected void setLanguage(TouchCharSetAndTTSHandler touchCharSetAndTTSHandler) {
        if (this.speller != null) {
            this.speller.setSpellerBandLanguage(touchCharSetAndTTSHandler);
            this.updateButtonStates();
        }
    }

    public char getLastInputChar() {
        return this.lastInput;
    }

    protected IPRPEngine getPRPEngine(int n) {
        boolean bl = framework.isNar();
        PRPEngineEurope pRPEngineEurope = new PRPEngineEurope(this.touchpadMode, -1, this.inputFieldData, n, logPRPEngine, bl);
        pRPEngineEurope.setSmartDeleteCaseSensitive(this.isSmartDeleteCaseSensitive());
        return pRPEngineEurope;
    }

    public void setSmartDeleteCaseSensitive(boolean bl) {
        this.smartDeleteCaseSensitive = bl;
    }

    public boolean isSmartDeleteCaseSensitive() {
        return this.smartDeleteCaseSensitive;
    }

    public void setEnabled(boolean bl) {
        boolean bl2 = this.isEnabled();
        super.setEnabled(bl);
        if (this.isConnected() && this.terminal != null && this.terminal.getDrawerFocusManager() != null && this.terminal.getDrawerFocusManager().getDrawerState() == 16) {
            if (this.isFocused()) {
                this.startCursorBlinkAnimation();
            }
            this.hideMenuInfoLine();
        }
        if (bl != bl2) {
            this.updateInfoLineState(false);
            this.setCompositesDirty(true);
        }
        if (!bl && this.isConnected()) {
            this.closeSpeller(false, false);
        }
    }

    private void hideMenuInfoLine() {
        AbstractWidget abstractWidget = this.getParent();
        if (abstractWidget instanceof MenuController) {
            MenuController menuController = (MenuController)abstractWidget;
            if (this.isEnabled() && menuController.getInfolineItemIndex() != null && menuController.getInfolineItemIndex().equals(menuController.getMenuItemIndex(this))) {
                menuController.hideInfoline(false);
            }
        }
    }

    public void setSDSActive(boolean bl) {
        this.isSDSActive = bl;
        if (bl) {
            this.terminal.getUserHintHandler().removeCurrentUserHint();
            if (this.isTruffleSearch()) {
                tpLogChannelInternal.log(1000000, "TouchController#setSDSActive: clear touchfield because SDS gets active in a truffle field (touchpadMode=%2, modelID=%1)", (long)this.modelID, (long)this.touchpadMode);
                this.clear(true);
            }
        }
        this.setCompositesDirty(true);
    }

    public void setInputLock(boolean bl) {
        if (bl && this.model instanceof MatchspellerModel) {
            tpLogChannelInternal.log(10000000, "TouchController#setInputLock: LOCK. model=%1", this.model);
            this.blockSpellerInput = true;
        } else {
            tpLogChannelInternal.log(10000000, "TouchController#setInputLock: UNLOCK. model=%1", this.model);
            this.blockSpellerInput = false;
        }
        TouchControllerDebugInfo.showLockDebugInfo(this.terminal, this, this.blockSpellerInput);
    }

    public boolean isInputLocked() {
        return this.blockSpellerInput;
    }

    public boolean isSDSActive() {
        if (this.isSDSActive) {
            return this.isSDSActive;
        }
        return AbstractWidget.sdsService != null && AbstractWidget.sdsService.isSDSActive();
    }

    public boolean isFocusable() {
        return true;
    }

    public void handleSpellerLastMode() {
        if (this.spellerLastMode == 1 && this.isEnabled() && this.isSpellerInputAllowed()) {
            tpLogChannelInternal.log(10000000, "TouchController#handleSpellerLastMode: Open Speller because of last mode!");
            this.openSpeller(true);
        }
    }

    protected final void setSpellerLastMode(int n) {
        tpLogChannelInternal.log(10000000, "TouchController#setSpellerLastMode: new spellerLastMode is %1!", (long)n);
        this.spellerLastMode = n;
    }

    public int getOptionIconYOffset() {
        return 0;
    }

    private void restartUserHintIdleJob() {
        if (!(this.timerListener.hasUserHintIdleTimerFiredOnce() || this.isSpellerOpen() || this.inputFieldData.isEmpty())) {
            this.timerListener.restartUserHintIdleTimer();
        }
    }

    public void setInfoLineChoiceModelID(int n) {
        this.infoLineChoiceModelID = n;
    }

    public void setVisible(boolean bl) {
        if (!bl) {
            this.forceCloseSpeller();
        } else if (this.isDTMF() && bl && !this.isTouchpadKeypanelWithActiveStatus() && this.isConnected()) {
            this.openSpeller(false);
        }
        super.setVisible(bl);
    }

    private void forceCloseSpeller() {
        if (this.speller != null && this.speller.isConnected()) {
            this.closeSpeller(false, false);
            this.speller.triggerRepaint();
        }
    }

    protected void handleFocusChanged(int n, int n2, int n3) {
        tpLogChannelInternal.log(1000000, "Touchcontroller#handleFocusChanged: evt:%1   state:%2", (long)n, (long)n2);
        if (n == 1 && n2 != 16) {
            this.hideFingerTrace();
            this.stopCursorBlinkAnimation();
            this.timerListener.stopShowIconAfterFingerTraceCleanDelayJob();
            this.iconDelayEventFired();
            this.isCursorVisible = false;
        } else if (n == 2 && n2 == 16) {
            if (this.isFocused()) {
                this.startCursorBlinkAnimation();
                this.restartUserHintIdleJob();
                this.isCursorVisible = true;
                this.calculateCursorPosition();
            }
            tpLogChannelInternal.log(10000000, "Touchcontroller#handleFocusChanged Focus gained. Trying to show Userhint");
            this.doShowInitialHint();
        }
    }

    public static void resetTruffleInputCount() {
        truffleInputCount = 0;
    }

    public void setDescriptiveText(int n) {
        this.descriptiveTextID = n;
    }

    public String getDescriptiveText() {
        if (this.descriptiveTextID != -1) {
            return this.getInitContext().getScreenFactory().getText(this.descriptiveTextID);
        }
        return null;
    }

    public boolean isCursorVisible() {
        if (!this.isEnabled()) {
            return false;
        }
        return this.isCursorVisible;
    }

    public boolean isCursorAtInitialPosition() {
        return this.isCursorAtInitialPosition;
    }

    public void processEvent(ATIPEvent aTIPEvent) {
        if (tpLogChannelInternal.isDebug()) {
            if (this.takeBackSmallStageJob != null) {
                tpLogChannelInternal.log(10000000, "TouchController#processEvent timerCalceled=%1", this.takeBackSmallStageJob.isCanceled());
            } else {
                tpLogChannelInternal.log(10000000, "TouchController#processEvent no timer available");
            }
        }
        if (aTIPEvent.equals(this.takeBackSmallStageTimerEvent)) {
            this.takeMeBackToSmallStage();
        } else if (aTIPEvent.equals(this.hidePinByStarTimerEvent)) {
            this.inputFieldData.hideCharacters();
            this.isPinReplacedByStar = true;
            this.setCompositesDirty(true);
        }
    }

    public void setFastDelete(boolean bl) {
        this.fastDelete = bl;
    }

    protected SpellerController getSpeller() {
        return this.speller;
    }

    protected final int getTouchpadMode() {
        return this.touchpadMode;
    }

    public final TouchCharSetAndTTSHandler getTouchUtil() {
        return this.touchUtil;
    }

    public int getLanguageIndicatorIconIndex() {
        if (this.touchUtil == null || this.terminal == null || this.terminal.getViewSizeManager() == null || this.terminal.getViewSizeManager().getCurrentViewSize() != 2) {
            return 0;
        }
        if (this.isLatinOnly()) {
            if (this.touchUtil.getSystemDefaultLanguage() == 0) {
                return 0;
            }
            return 1;
        }
        return this.touchUtil.getLanguageIndicatorIconIndex();
    }

    public int getCurrentViewSize() {
        if (this.terminal != null) {
            if (this.isSportSkin()) {
                if (this.isSmallStage()) {
                    return 1;
                }
                return 2;
            }
            return this.terminal.getViewSizeManager().getCurrentViewSize();
        }
        return 2;
    }

    public void setOptionsIconSpace(int n) {
    }

    public final void stopCursorBlinkAnimation() {
        this.animationListener.stopCursorBlinkAnimation();
    }

    public final void startCursorBlinkAnimation() {
        if (!this.isLockingActive || this.lockLevel != 3) {
            this.animationListener.startCursorBlinkAnimation();
        }
    }

    public final float getInfoLineProgress() {
        return this.animationListener.getInfoLineProgress();
    }

    public final float getSpellerOpenProgress() {
        return this.animationListener.getSpellerOpenProgress();
    }

    public final float getTargetSpellerOpenProgress() {
        return this.animationListener.getTargetSpellerOpenProgress();
    }

    protected final void handleSpellerOpenProgressChange(float f2) {
        if (this.speller != null) {
            if (f2 > 0.0f) {
                float f3 = (f2 - 0.7f) * 3.3333333f;
                f3 = Math.max(0.0f, f3);
                this.speller.setOpacity(f3);
                this.speller.setVisible(true);
                this.speller.setCompositesDirty(true);
            } else {
                this.speller.setVisible(false);
                this.speller.closed();
                this.restartUserHintIdleJob();
                this.updateTakeBackSmallStageTimer();
            }
            this.updateMenuCursorVisibility();
            this.invalidateParentLayout();
            this.setCompositesDirty(true);
        }
    }

    private boolean isBigStage() {
        IViewSizeManager iViewSizeManager = this.terminal.getViewSizeManager();
        if (this.isSportSkin()) {
            return !iViewSizeManager.isSportskinSmallStage();
        }
        return iViewSizeManager.getCurrentViewSize() == 2;
    }

    private boolean isSmallStage() {
        IViewSizeManager iViewSizeManager = this.terminal.getViewSizeManager();
        if (this.isSportSkin()) {
            return iViewSizeManager.isSportskinSmallStage();
        }
        return this.terminal.getViewSizeManager().getCurrentViewSize() == 1;
    }

    public int getTopImageIndex() {
        if (this.showTopImage()) {
            boolean bl;
            boolean bl2 = bl = this.isInfoLineVisible() || this.animationListener.getInfoLineProgress() > 0.0f;
            if (this.isBigStage()) {
                if (this.topImageSmallIndex != -1 && (bl || this.isMenuInfoLineVisible())) {
                    return this.topImageSmallIndex;
                }
                if (this.topImageBigIndex != -1 && !bl && !this.isMenuInfoLineVisible()) {
                    return this.topImageBigIndex;
                }
            } else if (this.isSmallStage()) {
                if (this.topImageSmallIndexKB != -1 && (bl || this.isMenuInfoLineVisible())) {
                    return this.topImageSmallIndexKB;
                }
                if (this.topImageBigIndexKB != -1 && !bl && !this.isMenuInfoLineVisible()) {
                    return this.topImageBigIndexKB;
                }
            }
        }
        return -1;
    }

    public String getTopImageLabelText() {
        this.updateTopImageLabelText();
        return this.topImageLabelText;
    }

    private void updateTopImageLabelText() {
        if (this.topImageLabelTextItem == null) {
            this.topImageLabelText = null;
            return;
        }
        Object object = this.topImageLabelTextItem.getModel();
        if (object instanceof LabelModel) {
            String string;
            LabelModel labelModel = (LabelModel)object;
            String string2 = string = labelModel != null ? labelModel.getText() : null;
            if (string != this.topImageLabelText) {
                this.topImageLabelText = string != null && string.length() > 0 ? string : null;
                this.setCompositesDirty(true);
            }
        } else {
            IWidgetLogChannel.tpLogChannelInternal.log(10000, "TouchController#updateTopImageLabelText: Model is no LabelModel");
        }
    }

    private boolean isMenuInfoLineVisible() {
        if (this.parent instanceof MenuController) {
            return ((MenuController)this.parent).isInfolineVisible();
        }
        return false;
    }

    public void setTopImageVisible(boolean bl) {
        this.isTopImageVisible = bl;
        this.invalidateParentLayout();
    }

    private boolean showTopImage() {
        boolean bl = this.topImageBigIndex != -1 || this.topImageSmallIndex != -1;
        return this.isTopImageVisible && bl && this.inputFieldData.isEmpty();
    }

    private int getTopImageHeight() {
        int n = 0;
        if (this.getTopImageIndex() != -1 && this.renderer != null) {
            n += ((ITouchRenderer)this.renderer).getTextureHeight(this.getTopImageIndex());
        }
        if (n != 0 && !this.isSpellerClosed()) {
            n = (int)((1.0f - this.getSpellerOpenProgress()) * (float)n);
        }
        return n;
    }

    public int getExtraClippingHeight() {
        return this.isSpellerClosed() ? (this.isG24() ? 80 : 60) : 0;
    }

    public final void touchInputDataChanged(int n, boolean bl, String string, String string2) {
        if (!this.isConnected()) {
            return;
        }
        if (!(this.model instanceof SpellerModelGUI)) {
            IWidgetLogChannel.tpLogChannelInternal.log(10000, "TouchController#touchInputDataChanged: no speller model set (model=%1)", this.model);
            return;
        }
        this.handleTouchInputDataChanged(n, bl, string, string2);
        this.calculateCursorPosition();
        this.updateButtonStates();
        this.setCompositesDirty(true);
    }

    protected void handleTouchInputDataChanged(int n, boolean bl, String string, String string2) {
        if (tpLogChannelInternal.isDebug2()) {
            this.dumpMessageHandleTouchInputDataChanged(n);
        }
        if (n == 1 && bl) {
            if (!this.modelNeedsTextUpdate(string2)) {
                tpLogChannelInternal.log(100000, "TouchController#handleTouchInputDataChanged: ignoring UPDATE_TYPE_TEXT_CHANGED (text=\"%1\") notification, because model text is already up-to-date.", (Object)string2);
                return;
            }
            this.stringToSpeak = null;
            char c2 = TouchControllerListenerFactory.calculateLastInputChar(string, string2);
            this.updateModelText(string2, c2);
        } else if (n == 2 && this.autoSwitch()) {
            if (TouchController.isArabia()) {
                this.setAutoCharsetSwitch(true);
            }
            if (this.touchUtil.getCharSet() != 2) {
                this.changeCharset(2);
                this.speller.moveCursorToItem(this.speller.getCurrentSpellerBand().getDeleteButton());
            }
        } else if (n == 3 && this.autoSwitch() && this.touchUtil.getCharSet() != 0) {
            if (TouchController.isArabia()) {
                this.setAutoCharsetSwitch(true);
            }
            this.changeCharset(0);
            this.speller.moveCursorToItem(this.speller.getCurrentSpellerBand().getDeleteButton());
        }
    }

    private boolean autoSwitch() {
        return !this.inputFieldData.isEmpty() && !this.isLatinOnly();
    }

    protected void dumpMessageHandleTouchInputDataChanged(int n) {
        String string;
        switch (n) {
            case 1: {
                string = "UPDATE_TYPE_TEXT_CHANGED";
                break;
            }
            case 2: {
                string = "UPDATE_LANGUAGE_SET_ARABIC";
                break;
            }
            case 3: {
                string = "UPDATE_LANGUAGE_SET_LATIN";
                break;
            }
            default: {
                string = "UNKOWN";
            }
        }
        String string2 = "";
        if (this.touchUtil != null) {
            switch (this.touchUtil.getCharSet()) {
                case 2: {
                    string2 = "CS_ARABIC";
                    break;
                }
                case 0: {
                    string2 = "CS_LATIN";
                    break;
                }
                default: {
                    string2 = "UNKOWN";
                }
            }
        }
        boolean bl = this.inputFieldData != null ? this.inputFieldData.isEmpty() : true;
        tpLogChannelInternal.log(10000000, "TouchController#handleTouchInputDataChanged currentCharSet:%2 updateType:%3 inputEmptyOrNULL=%1", bl, (Object)string2, (Object)string);
    }

    protected final boolean isOpenSpellerAfterViewSizeChange() {
        return this.openSpellerAfterViewSizeChange;
    }

    protected String getMatchSpellerValidChars() {
        return this.matchSpellerValidChars;
    }

    public int getNoCursorArea(boolean bl) {
        return bl ? this.getTopImageHeight() : 0;
    }

    protected final boolean modelNeedsTextUpdate(String string) {
        return this.model != null && !string.equals(((SpellerModelGUI)this.model).getText());
    }

    public void setDescriptiveText2(String string) {
        this.descriptiveText2 = string;
    }

    public String getDescriptiveText2() {
        return this.descriptiveText2;
    }

    public final String getEnteredString() {
        return this.enteredString;
    }

    public final void setEnteredString(String string) {
        this.enteredString = string;
    }

    public int getAdditionalDatabaseForWordPredictionID() {
        return this.additionalDatabaseForWordPredictionID;
    }

    public void setAdditionalDatabaseForWordPredictionID(int n) {
        this.additionalDatabaseForWordPredictionID = n;
    }

    public boolean useAdditionalDatabaseForWordPrediction() {
        return this.useAdditionalDatabaseForWordPrediction;
    }

    public void setUseAdditionalDatabaseForWordPrediction(boolean bl) {
        this.useAdditionalDatabaseForWordPrediction = bl;
    }

    public String toString() {
        if (this.stringRepresentation == null) {
            Buffer buffer = new Buffer(this.getClassName()).append(" [touchpadmode=").append(this.getTouchpadMode());
            if (this.getSpeller() != null) {
                buffer.append("; spellermode=").append(this.getSpeller().getSpellerMode());
            } else {
                buffer.append("; speller null");
            }
            this.stringRepresentation = buffer.append("; screenid=").append(this.getScreenId()).append("]").toString();
        }
        return this.stringRepresentation;
    }

    public boolean isOpenSpellerOnOtherScreen() {
        return this.openSpellerOnOtherScreen;
    }

    public void setOpenSpellerOnOtherScreen(boolean bl) {
        this.openSpellerOnOtherScreen = bl;
    }

    public void setAutoCharsetSwitch(boolean bl) {
        this.isAutoCharsetSwitch = bl;
    }

    public boolean isAutoCharsetSwitch() {
        return this.isAutoCharsetSwitch;
    }

    public boolean showJumpDownToListArrow() {
        return this.isJoystickKeypanel();
    }

    public boolean isLastInputByTouch() {
        return this.isLastInputByTouch;
    }

    protected void setLastInputByTouch(boolean bl) {
        this.isLastInputByTouch = bl;
    }

    public IMenuCallback getMenuCallback() {
        return this.menuCallback;
    }

    public void userCharsetChanged(int n) {
        this.setCompositesDirty(true);
    }

    protected boolean shouldBlockJump5Rule() {
        return false;
    }

    private boolean isStd() {
        return framework.getSysConst(523) == 0;
    }

    private boolean isG22() {
        return framework.getSysConst(522) == 2;
    }

    private boolean isG24() {
        return framework.getSysConst(522) == 4;
    }

    private final class MenuCallback
    extends MenuCallbackAdapter {
        private MenuCallback() {
        }

        public void menuLayouted() {
            if (this.shouldExecuteInitialJump5()) {
                IWidgetLogChannel.tpLogChannelInternal.log(10000000, "TouchController.MenuCallback#menuLayouted initially focus first menu item because of jump-5 rule");
                TouchController.this.focusFirstMenuLineAfterTouchfield(true);
            }
            TouchController.this.initialMatchCount = -1;
        }

        private boolean shouldExecuteInitialJump5() {
            return TouchController.this.initialMatchCount > 0 && TouchController.this.initialMatchCount <= 5 && TouchController.this.isVisibleInHierarchy() && TouchController.this.isFocused() && !TouchController.this.userHintPartialPopupListener.isUserHintShown();
        }
    }
}

