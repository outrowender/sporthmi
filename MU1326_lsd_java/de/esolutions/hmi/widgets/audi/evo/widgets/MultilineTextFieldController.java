/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.EventDispatcher;
import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.TimerEvent;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.model.texteditor.DoubleCursor;
import de.audi.atip.hmi.model.texteditor.MLUtils;
import de.audi.atip.hmi.model.texteditor.TextEditorDDModel;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ICopyTo;
import de.audi.atip.hmi.modelaccess.TextEditorModelDDApp;
import de.audi.atip.hmi.view.AnimationListener;
import de.audi.tghu.hmi.evo.BckSpaceGestureHandlerConfig;
import de.audi.tghu.hmi.evo.IFocusedPropertyObject;
import de.audi.tghu.hmi.evo.IMultilineTextFiledController;
import de.esolutions.fw.util.commons.IntList;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.WidgetRegistry;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AnimationController;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.base.widgets.ModelStubController;
import de.esolutions.hmi.widgets.audi.evo.FocusedPropertyObject;
import de.esolutions.hmi.widgets.audi.evo.prpframework.IPRPEngine;
import de.esolutions.hmi.widgets.audi.evo.prpframework.PRPEngineEurope;
import de.esolutions.hmi.widgets.audi.evo.widgets.IMultilineTextFiledRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ISpellerListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.MultilineTextFieldController$IntArrCompare;
import de.esolutions.hmi.widgets.audi.evo.widgets.MultilineTextFieldController$WordReplacer;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerButtonArgument;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$ISpellerItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController$SpellerButtonType;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchCharSetAndTTSHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchCharSetAndTTSHandler$CharsetListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.anim.AnimUtils;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemSingle;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.AnimatedState;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.BckSpaceGestureHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.DeleteKeyInputHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.FangschaltungHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.FastDeleteHelperImplementation;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.GhostCursor;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.IMLDimensions;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.MLDisplayData;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.MultilineString;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.MultilineTextFieldRightDrawerHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.SChar;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.TouchPadController;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.ViewPort;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MultilineTextFieldController
extends AbstractWidgetController
implements IMultilineTextFiledController,
IMLDimensions,
IMenuItemSingle,
ATIPEventListener,
AnimationListener,
ISpellerListener,
TouchCharSetAndTTSHandler$CharsetListener {
    private static final int ALTERNATIVES_Y_OFFSET;
    private MultilineTextFieldController$WordReplacer wordReplacer;
    private TouchCharSetAndTTSHandler touchUtil;
    private int widgetID = -1;
    private static final int ANIMATION_TYPE;
    private static final float ANIMATION_TARGET;
    public AnimatedState sourceAnim = null;
    public AnimatedState currentAnim = null;
    public AnimatedState targetAnim = null;
    public AbstractAnimation animationContainer = null;
    private boolean isInitialForAnimation = true;
    public static final int DEFAULT_MIN_NO_LINES;
    public static final int DEFAULT_MAX_NO_LINES;
    private FocusedPropertyObject focusPropertyObject = null;
    private MultilineTextFieldRightDrawerHandler cbkHndlr = new MultilineTextFieldRightDrawerHandler(this);
    private BckSpaceGestureHandler bckSpcTouchHandler = null;
    private long lastTouchDeleteGestureTime = -1L;
    private static final MultilineTextFieldController$IntArrCompare IARRCMPINSTANCE;
    private IMultilineTextFiledRenderer renderer;
    private SpellerController speller = null;
    private TouchPadController touchPad = null;
    private MultilineString multilineString = null;
    private int sdsItemSelectedAction = 3;
    public static final int MAX_SPACE_WORDS_PASSED;
    private List passedSpaceWords = new LinkedList();
    private MLDisplayData displayData = null;
    private DeleteKeyInputHandler cbcDelete = null;
    private WidgetRegistry widgetRegistry = null;
    private EventDispatcher eventDispatcher;
    private FangschaltungHandler fangschaltungHandler = null;
    private boolean disableInput = false;
    public int minNoVisibleLines = 3;
    public int maxNoVisibleLines = 8;
    public static final int SPELLER_X_OFFSET;
    public static final int SPELLER_Y_OFFSET;
    public static final int SPELLER_H;
    public static final int SPELLER_W_DELTA;
    private static final int SPELLER_H_EXTRA;
    private static final int[] MENU_ITEM_INSETS;
    private static int layoutMenuItemInsets;
    private static int layoutConfigIdx;
    private LabelController label = null;
    private boolean searchLabel = true;
    private int lastCursorPos = 0;
    private int onFirstDeleteClicks = 0;
    private long lastFastScrollTime = 0L;
    private static final long FASTSCROLL_INTERVAL;
    private static final int FASTSCROLL_CLICKS_ACTIVATE;
    private int factor = 2;
    private static final int MAX_FACTOR;
    int oldCursorDirection = 0;
    private boolean blinkCursorVisible = true;
    private AbstractAnimation cursorBlinkAnimation;
    private Job catchJob;
    private TimerEvent catchTimerEvent;
    private boolean catchTimerRunning = false;
    public static boolean useGostChars;
    private int optionIconYOffset = 0;
    private int descriptiveTextID = -1;
    private int descriptiveTextLength = 0;
    private static final int TRUE;
    private static final int FALSE;
    private ModelStubController modelStub;
    private ChoiceModelApp isInsideSpellerOrAlternatives;
    private String descriptiveText2 = null;

    public MultilineTextFieldController() {
        this(null);
    }

    protected MultilineTextFieldController(EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    protected void initializeWidget() {
        super.initializeWidget();
        this.updateCharsetForPRPandSpeller();
        if (this.wordReplacer == null) {
            this.wordReplacer = new MultilineTextFieldController$WordReplacer(this, (TextEditorModelDDApp)this.model, this.getSpeller());
            this.wordReplacer.updateBounds();
            this.wordReplacer.getSpeller().registerSpellerListener(this);
            this.add(this.wordReplacer.getSpeller());
        }
        this.wordReplacer.close();
        this.initModel();
        this.acquireDescriptiveText2();
        this.fetchReadOnly();
        this.isInitialForAnimation = true;
    }

    @Override
    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.touchUtil.addCharsetListener(this);
    }

    @Override
    public void disconnecting() {
        this.touchUtil.removeCharsetListener(this);
        super.disconnecting();
    }

    @Override
    public void animationStarted(int n, int n2) {
    }

    @Override
    public void animate(int n, float f2, int n2) {
        logMessagingMultilineAnimations.log(-2137614336, "MultilineTextFieldController#animate type:%1   value:%2   id:%3", (double)n, (double)f2, (double)n2);
        if (n == 1) {
            this.toggleBlinkCursor();
            return;
        }
        if (n == 76) {
            this.touchPad.updatePosition();
        }
        this.currentAnim.viewPort.y = AnimUtils.lerp1(this.sourceAnim.viewPort.y, this.targetAnim.viewPort.y, this.animationContainer.getProgress());
        this.currentAnim.viewPort.vpY = AnimUtils.lerp1(this.sourceAnim.viewPort.vpY, this.targetAnim.viewPort.vpY, this.animationContainer.getProgress());
        this.currentAnim.viewPort.h = AnimUtils.lerp1(this.sourceAnim.viewPort.h, this.targetAnim.viewPort.h, this.animationContainer.getProgress());
        this.currentAnim.spellerOpeningProgress = AnimUtils.lerp1(this.sourceAnim.spellerOpeningProgress, this.targetAnim.spellerOpeningProgress, this.animationContainer.getProgress());
        this.optionIconYOffset = (int)(this.currentAnim.spellerOpeningProgress * 23618 / 2.0f);
        this.currentAnim.widgetH = (int)AnimUtils.lerp1(this.sourceAnim.widgetH, this.targetAnim.widgetH, this.animationContainer.getProgress());
        this.invalidateAndApplyProps();
    }

    @Override
    public void animationFinished(int n, int n2) {
        logMessagingMultilineAnimations.log(-2137614336, "MultilineTextFieldController#animationFinished");
        if (this.targetAnim != null && this.displayData != null) {
            this.currentAnim = new AnimatedState(this.targetAnim);
            this.displayData.setLinesNeedRepos(true);
            this.displayData.setNeedsRendering(true);
            this.setCompositesDirty(true);
        }
    }

    public void updateAnim(AnimatedState animatedState) {
        this.targetAnim = animatedState;
        this.sourceAnim = new AnimatedState(this.currentAnim);
        this.currentAnim.viewPort.vpFirstVisibleLine = Math.min(this.currentAnim.viewPort.vpFirstVisibleLine, this.targetAnim.viewPort.vpFirstVisibleLine);
        this.currentAnim.viewPort.vpLastVisibleLine = Math.max(this.currentAnim.viewPort.vpLastVisibleLine, this.targetAnim.viewPort.vpLastVisibleLine);
        this.currentAnim.viewPort.vpNoVisibleLines = this.targetAnim.viewPort.vpNoVisibleLines;
        if (this.animationContainer != null && this.animationContainer.isAnimating()) {
            this.animationContainer.setTarget(this.animationContainer.getTarget() + 31300);
        } else {
            if (this.animationContainer == null) {
                this.animationContainer = ((AnimationController)this.getTerminal().getIAnimationController()).getAnimation(76);
                this.animationContainer.addListener(this);
            }
            float f2 = 0.0f;
            if (this.isInitialForAnimation) {
                this.isInitialForAnimation = false;
                f2 = 31300;
            }
            this.animationContainer.startDynamicAnimation(f2, 31300, 76, false, this);
        }
    }

    public void setDisableInput(boolean bl) {
        logMessagingMultiline.log(-2137614336, "MultilineTextFieldController#setDisableInput disable:%1", bl);
        this.disableInput = bl;
        if (this.disableInput) {
            this.closeSpeller(true);
            this.setCursorModePriv(0);
            this.wordReplacer.close();
        }
    }

    public boolean isDisableInput() {
        logMessagingMultiline.log(-2137614336, "MultilineTextFieldController#getDisableInput disableinput:%1", this.disableInput);
        return this.disableInput;
    }

    public void setMinNoVisibleLines(int n) {
        logMessagingMultiline.log(-2137614336, "MultilineTextFieldController#setMinNoVisibleLines type:%1", (long)n);
        if (this.minNoVisibleLines > -1 && this.minNoVisibleLines != n) {
            this.minNoVisibleLines = n;
            this.maxNoVisibleLines = Math.max(this.minNoVisibleLines, this.maxNoVisibleLines);
            this.updatePreferredHeight();
        }
    }

    public int getMinNoVisibleLines() {
        return this.minNoVisibleLines;
    }

    public void setMaxNoVisibleLines(int n) {
        logMessagingMultiline.log(-2137614336, "MultilineTextFieldController#setMaxNoVisibleLines type:%1", (long)n);
        int n2 = Math.max(n, this.minNoVisibleLines);
        if (n2 != this.maxNoVisibleLines) {
            this.maxNoVisibleLines = n2;
            this.updatePreferredHeight();
        }
    }

    public int getMaxNoVisibleLines() {
        return this.maxNoVisibleLines;
    }

    public static int layoutConfigIDX() {
        return layoutConfigIdx;
    }

    @Override
    public void touchPadPressed(TouchEvent touchEvent) {
        if (!this.disableInput) {
            super.touchPadPressed(touchEvent);
        }
    }

    @Override
    public void touchPadReleased(TouchEvent touchEvent) {
        if (!this.disableInput) {
            super.touchPadReleased(touchEvent);
        }
    }

    @Override
    public void touchPadPositionMoved(TouchEvent touchEvent) {
        if (!this.disableInput) {
            super.touchPadPositionMoved(touchEvent);
        }
        this.setCompositesDirty(true);
    }

    @Override
    public void touchPadCharactersRecognized(TouchEvent touchEvent) {
        if (this.disableInput) {
            return;
        }
        touchEvent.setSdsAction(3);
        String string = touchEvent.getRecognizedCharacters();
        if (string != null) {
            logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#touchpadCharactersRecognized recognizedChars=%1", (Object)string);
        }
        super.touchPadCharactersRecognized(touchEvent);
    }

    private void hideFingerTrace() {
        this.touchPad.hideFingerTrace();
    }

    public TouchCharSetAndTTSHandler getTouchUtil() {
        return this.touchUtil;
    }

    private void fetchReadOnly() {
        this.disableInput = framework.getSysConst(4062) == 1 || AbstractWidget.isAsia() ? true : ((TextEditorDDModel)this.model).isReadOnly();
    }

    private void onModelContentChanged() {
        logMessagingMultiline.log(-2137614336, "MultilineTextFieldController#onModelContentChanged");
        if (this.multilineString.getCursor().length() <= 0 && this.wordReplacer.isVisible()) {
            logMessagingMultiline.log(-2137614336, "MultilineTextFieldController#onModelContentChanged - closing wordReplacer");
            this.wordReplacer.close();
        }
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        super.processModelUpdateEvent(modelUpdateEvent);
        switch (modelUpdateEvent.getUpdateType()) {
            case 20: {
                this.fetchReadOnly();
                break;
            }
            case 6: {
                this.onModelContentChanged();
                break;
            }
            default: {
                logMessagingMultiline.log(-1601830656, "MultilineTextFieldController#processModelUpdateEvent: ignore model update event (%1) here", (Object)modelUpdateEvent);
            }
        }
    }

    public ViewPort getViewPort() {
        return this.currentAnim.viewPort;
    }

    @Override
    protected void initConnect(InitializationContext initializationContext) {
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#initConnect");
        super.initConnect(initializationContext);
        layoutConfigIdx = 0;
        layoutMenuItemInsets = MENU_ITEM_INSETS[layoutConfigIdx];
        AnimatedState.layoutFooterHeight = AnimatedState.FOOTERS[layoutConfigIdx];
        AnimatedState.layoutMaxVPHeight = AnimatedState.MAX_VP_HEIGHTS[layoutConfigIdx];
        if (this.eventDispatcher == null) {
            this.eventDispatcher = this.terminal.getFramework().getHMIService().getEventDispatcher();
        }
        if (this.fangschaltungHandler == null) {
            this.fangschaltungHandler = new FangschaltungHandler(framework);
        }
        this.fangschaltungHandler.init(this.eventDispatcher);
        this.widgetRegistry = this.terminal.getWidgetRegistry();
        if (!(this.model instanceof TextEditorDDModel)) {
            logMessagingMultiline.log(10000, "MultiLineTextFieldController#initConnect Model is no TextEditorDDModel but has to be!");
            return;
        }
        ICopyTo iCopyTo = (TextEditorDDModel)this.model;
        this.multilineString = new MultilineString(((TextEditorDDModel)iCopyTo).getCursor());
        this.multilineString.getCursor().lockLL(false);
        this.closeSpeller(true);
        iCopyTo = this.multilineString.getCursor();
        ((DoubleCursor)iCopyTo).setCursorPos(((DoubleCursor)iCopyTo).getCursorPos());
        this.getLinifiedData();
        this.updateCurrentLine(true, false);
        this.cbcDelete = new DeleteKeyInputHandler(this.multilineString.getCursor(), this.eventDispatcher, this);
        this.getLabel(true);
        if (this.label != null) {
            this.label.setX(this.x);
            this.label.setY(this.y);
        }
        this.touchUtil = this.createTouchCharsetAndTTSHandler();
        this.invalidateAndApplyProps();
    }

    private TouchCharSetAndTTSHandler createTouchCharsetAndTTSHandler() {
        return new TouchCharSetAndTTSHandler(this.terminal);
    }

    public void changeCharset(int n) {
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#changeCharset charset:%1", (long)n);
        this.touchUtil.setCharSet(n);
        this.updateCharsetForPRPandSpeller();
    }

    private void updateCharsetForPRPandSpeller() {
        int n = this.touchUtil.getInternalLanguage();
        this.touchPad.setPRPEngine(this.createPRPEnigeEurope(n));
        this.setLanguage(this.touchUtil);
    }

    protected IPRPEngine createPRPEnigeEurope(int n) {
        return new PRPEngineEurope(96, -1, this.touchPad, n, logPRPEngine);
    }

    protected void setLanguage(TouchCharSetAndTTSHandler touchCharSetAndTTSHandler) {
        if (this.speller == null) {
            return;
        }
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#setLanguage InternalLanguage:%1", (long)touchCharSetAndTTSHandler.getInternalLanguage());
        this.speller.setSpellerBandLanguage(touchCharSetAndTTSHandler);
        this.setCompositesDirty(true);
    }

    private void invalidateAndApplyProps() {
        this.setPreferredHeight(this.currentAnim.widgetH);
        if (this.speller != null) {
            this.speller.setVisible(this.currentAnim.spellerOpeningProgress > 0x6666663F);
            this.speller.setCompositesDirty(true);
        }
        this.displayData.setLinesNeedRepos(true);
        this.displayData.setNeedsRendering(true);
        this.setCompositesDirty(true);
    }

    public void updateCurrentLine(boolean bl, boolean bl2) {
        SChar sChar;
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#updateCurrentLine init:%1  upToDate:%2", bl, bl2);
        DoubleCursor doubleCursor = this.multilineString.getCursor();
        int n = doubleCursor.getCursorPos();
        boolean bl3 = n > this.lastCursorPos;
        this.lastCursorPos = n;
        int n2 = bl3 ? this.displayData.currentLineIdx : 0;
        SChar sChar2 = sChar = n > 0 && this.displayData.charMetaData.size() > n - 1 ? (SChar)this.displayData.charMetaData.get(n - 1) : null;
        if (sChar != null) {
            n2 = sChar.line;
            if (doubleCursor.currentChar() == '\n') {
                ++n2;
            }
        }
        if (bl) {
            this.currentAnim = new AnimatedState(this, this.renderer, n2, this.displayData.sCharLines.size(), false);
            this.sourceAnim = new AnimatedState(this.currentAnim);
            this.targetAnim = new AnimatedState(this.currentAnim);
        } else {
            AnimatedState animatedState = new AnimatedState(this.targetAnim);
            int n3 = Math.max(this.displayData.sCharLines.size(), 1);
            n3 = Math.max(n3, n2 + 1);
            animatedState.updateCurrentLine(n2, n3);
            if (!animatedState.equals(this.targetAnim)) {
                this.updateAnim(animatedState);
            }
        }
    }

    public LabelController getLabel(boolean bl) {
        this.searchLabel = bl;
        if (this.label == null && this.searchLabel) {
            List list = this.getChildren();
            if (list != null) {
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    Object object = iterator.next();
                    if (!(object instanceof LabelController)) continue;
                    this.label = (LabelController)object;
                }
            }
            this.searchLabel = false;
        }
        return this.label;
    }

    public int getOffsetBecauseOfLabel() {
        this.getLabel(false);
        return this.label != null ? this.label.getWidth() : 0;
    }

    @Override
    protected void destroyWidget() {
        this.stopBlinkTimer();
        this.bckSpcTouchHandler = null;
        this.eventDispatcher = null;
        this.multilineString = null;
        this.displayData = null;
        if (this.fangschaltungHandler != null) {
            this.fangschaltungHandler.deinit();
        }
        this.cbcDelete = null;
        this.setWidth(this.getPreferredWidth());
        this.setHeight(this.getPreferredHeight());
        this.animationContainer = null;
        this.currentAnim = null;
        this.sourceAnim = null;
        this.targetAnim = null;
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(IMultilineTextFiledRenderer iMultilineTextFiledRenderer) {
        this.renderer = iMultilineTextFiledRenderer;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#keyPressed evt:%1", (long)keyEvent.getKeyCode());
        this.hideFingerTrace();
        if (this.disableInput) {
            return;
        }
        if (keyEvent.getKeyCode() == 15) {
            if (this.handleHKBack(true)) {
                this.handleCursorModeSwitch(this.displayData.ghostCursor);
                keyEvent.consume(true);
            }
        } else if (this.isSpellerActive()) {
            super.keyPressed(keyEvent);
        } else if (this.wordReplacer.isFocused()) {
            this.wordReplacer.getSpeller().keyPressed(keyEvent);
        } else if (!this.speller.isVisible() && !this.wordReplacer.isVisible() && this.multilineString.getCursor().getString().length() == 0) {
            this.openSpeller(true);
        } else if (keyEvent.getKeyCode() == 17 && this.multilineString.getCursor().getString().length() > 0) {
            this.setCursorModePriv((this.multilineString.getCursor().getCursorMode() + 1) % 2);
            keyEvent.consume(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#keyReleased evt:%1", (long)keyEvent.getKeyCode());
        if (this.disableInput) {
            return;
        }
        if (keyEvent.getKeyCode() == 15) {
            if (this.handleHKBack(false)) {
                this.handleCursorModeSwitch(this.displayData.ghostCursor);
                keyEvent.consume(true);
            }
        } else if (this.isSpellerActive()) {
            super.keyReleased(keyEvent);
        }
    }

    private boolean handleHKBack(boolean bl) {
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#handleHKBack pressed:%1", bl);
        this.hideFingerTrace();
        if (bl && this.multilineString.getCursor().length() <= 0) {
            this.onFirstDeleteClicks = 0;
            if (this.isSpellerActive()) {
                logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#handleHKBack closing speller");
                this.closeSpeller(true);
                return true;
            }
            return false;
        }
        if (this.isCursorOnFirstPos() && bl) {
            ++this.onFirstDeleteClicks;
        }
        this.handleDeleteKey(bl);
        if (this.onFirstDeleteClicks >= 2) {
            this.onFirstDeleteClicks = 0;
            return false;
        }
        return true;
    }

    private void disabledTextScrolling(WheelButtonEvent wheelButtonEvent, int n, int n2) {
        boolean bl = n == 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            boolean bl2 = this.moveCursorToLine(bl);
            if (!bl2) continue;
            wheelButtonEvent.consume(true);
        }
    }

    private boolean handleSDSScrolling(WheelButtonEvent wheelButtonEvent, boolean bl) {
        boolean bl2;
        ChoiceModelApp choiceModelApp = this.terminal.getFramework().getHMIService().getChoiceModel(268);
        boolean bl3 = bl2 = choiceModelApp != null && choiceModelApp.getValue() > 0;
        if (bl2 && bl) {
            wheelButtonEvent.consume();
            return true;
        }
        return false;
    }

    private void scrollThroughWords(WheelButtonEvent wheelButtonEvent, int n, int n2) {
        int n3;
        long l = framework.getMonotonicTime();
        long l2 = l - this.lastFastScrollTime;
        this.lastFastScrollTime = l;
        int n4 = n2;
        int n5 = n3 = n == 1 ? 0 : 1;
        if (l2 <= 0 && n2 >= 3) {
            this.factor = Math.max(this.factor + 1, 7);
            n4 = n2 * this.factor;
            this.oldCursorDirection = n3;
        } else if (l2 >= 0 || n3 != this.oldCursorDirection) {
            this.factor = 2;
            this.oldCursorDirection = 0;
        }
        for (int i2 = 0; i2 < n4; ++i2) {
            boolean bl = this.isCursorOnFirstPos() && n3 == 0;
            boolean bl2 = this.isCursorOnLastPos() && n3 == 1;
            boolean bl3 = bl || bl2;
            boolean bl4 = this.handleSDSScrolling(wheelButtonEvent, bl3);
            if (bl4) break;
            boolean bl5 = this.handleCatch(bl3);
            if (bl5) {
                wheelButtonEvent.consume();
                return;
            }
            boolean bl6 = this.moveCursorPriv(n3);
            if (!bl6) continue;
            if (this.isCursorOnFirstPos() || this.isCursorOnLastPos()) {
                this.startCatchTimer();
            }
            wheelButtonEvent.consume();
        }
    }

    @Override
    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#keyTurned direction:%1   ticks:%2", (long)wheelButtonEvent.getDirection(), (long)wheelButtonEvent.getClickCount());
        this.hideFingerTrace();
        int n = wheelButtonEvent.getDirection();
        int n2 = wheelButtonEvent.getClickCount();
        if (!this.terminal.getFramework().getLanguageMgr().isLeftToRightOrientation()) {
            n = (n + 1) % 2;
        }
        if (this.disableInput) {
            this.disabledTextScrolling(wheelButtonEvent, n, n2);
            return;
        }
        if (this.isSpellerActive()) {
            super.keyTurned(wheelButtonEvent);
            wheelButtonEvent.consume(true);
        } else if (this.wordReplacer.isFocused()) {
            this.wordReplacer.getSpeller().keyTurned(wheelButtonEvent);
            wheelButtonEvent.consume();
        } else {
            this.scrollThroughWords(wheelButtonEvent, n, n2);
            this.wordReplacer.showIfAvailable();
        }
        this.updatePreferredHeight();
    }

    public boolean isSpellerActive() {
        return this.speller != null ? this.speller.isVisible() : false;
    }

    @Override
    public void keyMoved(JoystickEvent joystickEvent) {
        boolean bl;
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#keyTurned direction:%1", (long)joystickEvent.getDirection());
        this.hideFingerTrace();
        if (this.disableInput) {
            return;
        }
        if (joystickEvent.getDirection() == 4 || joystickEvent.getDirection() == 8) {
            return;
        }
        boolean bl2 = bl = this.wordReplacer.isVisible() && !this.wordReplacer.isFocused();
        if ((this.isSpellerActive() || this.currentAnim.spellerOpeningProgress > 0.0f) && joystickEvent.getDirection() == 6) {
            this.closeSpeller(true);
            this.setCursorModePriv(0);
            joystickEvent.consume();
        } else if (this.wordReplacer.isVisible() && joystickEvent.getDirection() == 6) {
            this.wordReplacer.close();
            if (this.isInsideSpellerOrAlternatives != null) {
                this.isInsideSpellerOrAlternatives.setValue(0);
            }
            joystickEvent.consume();
        } else if (bl && joystickEvent.getDirection() == 2) {
            this.wordReplacer.getSpeller().moveCursor(1.0f, false);
            this.wordReplacer.setFocused(true);
            if (this.isInsideSpellerOrAlternatives != null) {
                this.isInsideSpellerOrAlternatives.setValue(1);
            }
            joystickEvent.consume(false);
        } else if (!this.isSpellerActive() && joystickEvent.getDirection() == 2) {
            joystickEvent.consume();
            if (this.multilineString.getCursor().length() <= 0 && this.multilineString.getCursor().getCursorMode() != 1) {
                this.multilineString.getCursor().setCursorMode(1);
            }
            if (!this.wordReplacer.isVisible()) {
                this.openSpeller(true);
            }
        } else {
            super.keyMoved(joystickEvent);
        }
        if (this.isSpellerActive()) {
            joystickEvent.consume();
        }
    }

    @Override
    public void setX(int n) {
        super.setX(n);
        if (this.speller != null) {
            this.speller.setX(n + this.getOffsetBecauseOfLabel());
        }
        if (this.label != null) {
            this.label.setX(n);
        }
        if (this.wordReplacer != null) {
            this.wordReplacer.updateX();
        }
    }

    @Override
    public void setY(int n) {
        super.setY(n);
        if (this.speller != null) {
            this.speller.setY(n + 10);
        }
        if (this.label != null) {
            this.label.setY(n);
        }
        if (this.wordReplacer != null) {
            this.wordReplacer.updateY();
        }
    }

    @Override
    public void setWidth(int n) {
        int n2 = this.width;
        super.setWidth(n);
        if (this.speller != null) {
            int n3 = this.getDescriptiveText() != null ? 25 : 0;
            this.speller.setWidth(this.getInputFieldWidth() - n3);
            this.speller.setX(this.getWidth() - this.getInputFieldWidth() + n3 + 12);
        }
        if (this.wordReplacer != null) {
            this.wordReplacer.updateBounds();
        }
        if (this.isConnected() && n2 != n && this.multilineString != null) {
            this.displayData = this.multilineString.getDisplayDataFull(this);
        }
    }

    @Override
    public void setHeight(int n) {
        super.setHeight(n);
        if (this.speller != null) {
            this.speller.setHeight(38);
        }
        if (this.wordReplacer != null) {
            this.wordReplacer.updateHeight();
        }
    }

    @Override
    public void setBounds(int n, int n2, int n3, int n4) {
        this.setX(n);
        this.setY(n2);
        this.setWidth(n3);
        this.setHeight(n4);
    }

    @Override
    public void setPreferredHeight(int n) {
        int n2 = n + 10;
        logMessagingMultiline.log(-2137614336, "MultilineTextFieldController#processEvent PreferredHeight:%1", (long)n2);
        if (n2 != this.preferredHeight) {
            super.setPreferredHeight(n2);
        }
    }

    private void toggleBlinkCursor() {
        this.blinkCursorVisible = !this.blinkCursorVisible;
        this.setCompositesDirty(true);
    }

    private void startBlinkTimer() {
        if (this.cursorBlinkAnimation == null) {
            this.cursorBlinkAnimation = (AbstractAnimation)this.getTerminal().getIAnimationController().getIAnimation(1);
            this.cursorBlinkAnimation.setBlockRepaint(false);
            this.cursorBlinkAnimation.addListener(this);
        }
        if (!this.cursorBlinkAnimation.isAnimating()) {
            IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "TouchControllerAsAnimationListenerImp#startCursorBlinkAnimation: animation will be started");
            this.cursorBlinkAnimation.startEndlessAnimation(500, this);
        }
    }

    private void stopBlinkTimer() {
        if (this.cursorBlinkAnimation != null && this.cursorBlinkAnimation.isAnimating()) {
            IWidgetLogChannel.tpLogChannelInternal.log(-2137614336, "stopBlinkTimer#stopAnimation: an animation will be stoppped (animationType=%1)", (long)this.cursorBlinkAnimation.getType());
            this.cursorBlinkAnimation.stopAnimation();
            this.blinkCursorVisible = false;
        }
    }

    public boolean isBlinkCursorVisible() {
        return this.blinkCursorVisible;
    }

    private boolean handleCatch(boolean bl) {
        if (bl) {
            return this.catchTimerRunning;
        }
        this.resetCatchTimer();
        return false;
    }

    private void resetCatchTimer() {
        if (this.catchJob != null) {
            this.catchJob.cancel();
            if (this.catchTimerEvent != null) {
                this.catchTimerEvent.consume();
                this.catchTimerEvent = null;
            }
        }
        this.catchTimerRunning = false;
    }

    private void startCatchTimer() {
        this.resetCatchTimer();
        this.catchTimerEvent = new TimerEvent(this);
        this.catchJob = AbstractWidget.framework.getHMIService().getEventDispatcher().postEvent(this.catchTimerEvent, 0);
        this.catchTimerRunning = true;
    }

    @Override
    public void processEvent(ATIPEvent aTIPEvent) {
        if (aTIPEvent.equals(this.catchTimerEvent)) {
            this.catchTimerRunning = false;
        }
    }

    public void setSpeller(SpellerController spellerController) {
        this.speller = spellerController;
        this.speller.setBounds(this.x + 0, this.y + 0, this.width + -10 - this.getOffsetBecauseOfLabel(), 55);
        this.speller.setVisible(false);
        this.speller.setSpellerMode(4);
        this.speller.registerSpellerListener(this);
        super.add(this.speller);
    }

    public SpellerController getSpeller() {
        return this.speller;
    }

    public void setTouchPad(TouchPadController touchPadController) {
        if (this.touchPad != null) {
            super.remove(this.touchPad);
        }
        this.touchPad = touchPadController;
        if (this.touchPad != null) {
            super.add(this.touchPad);
        }
    }

    private void updatePreferredHeight(boolean bl) {
        if (!this.isConnected()) {
            return;
        }
        this.updateCurrentLine(false, bl);
        this.displayData.setLinesNeedRepos(true);
        this.displayData.setNeedsRendering(true);
        this.setCompositesDirty(true);
    }

    private void updatePreferredHeight() {
        this.updatePreferredHeight(false);
    }

    public MLDisplayData getLinifiedData() {
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#getLinifiedData");
        if (this.displayData != null) {
            this.displayData.ghostCursor.setCursorMode((this.displayData.ghostCursor.getCursorMode() + 1) % 2);
            this.displayData.ghostCursor.setCursorMode((this.displayData.ghostCursor.getCursorMode() + 1) % 2);
        }
        DoubleCursor doubleCursor = this.multilineString.getCursor();
        if (this.displayData != null) {
            if (doubleCursor.isDirty()) {
                this.multilineString.invalidateReflowData(this.displayData, this.multilineString.getCursor().getLastFixedChar());
            }
            this.displayData = this.multilineString.getDisplayDataPartial(this, this.displayData);
            this.updatePreferredHeight(true);
        } else {
            this.displayData = this.multilineString.getDisplayDataFull(this);
        }
        doubleCursor.resetDirty();
        this.displayData.setNeedsRendering(true);
        return this.displayData;
    }

    public MultilineString getString() {
        return this.multilineString;
    }

    private void handleDeleteKey(boolean bl) {
        if (this.cbcDelete != null) {
            this.cbcDelete.delete(bl);
        }
    }

    public boolean isTouchPadActive() {
        return this.touchPad != null && this.touchPad.isVisible();
    }

    private void handleCursorModeSwitch(GhostCursor ghostCursor) {
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#handleCursorModeSwitch actualMode:%1", (long)ghostCursor.getCursorMode());
        int n = ghostCursor.getCursorMode();
        if (n == 1) {
            int n2;
            logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#handleCursorModeSwitch CHAR to WORD");
            if (!this.isSpellerActive() && (n2 = ghostCursor.currentIdx()[0]) != -1) {
                int n3 = MLUtils.getCharType(ghostCursor.getCharArray()[n2]);
                if (n3 == 0 && Collections.binarySearch(this.passedSpaceWords, ghostCursor.currentWordIdx(), IARRCMPINSTANCE) < 0) {
                    this.passedSpaceWords.add(ghostCursor.currentWordIdx());
                }
                if (n3 != 0 && this.passedSpaceWords.size() > 1) {
                    ghostCursor.setCursorMode(0);
                    this.passedSpaceWords.clear();
                }
            }
        } else {
            logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#handleCursorModeSwitch WORD to CHAR");
            if (ghostCursor.length() == 0) {
                ghostCursor.setCursorMode(1);
                this.displayData.setNeedsRendering(true);
                this.displayData.setLinesNeedRepos(true);
            }
        }
    }

    private void handleCursorModeSwitch(DoubleCursor doubleCursor) {
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#handleCursorModeSwitch actualMode:%1", (long)doubleCursor.getCursorMode());
        int n = doubleCursor.getCursorMode();
        if (n == 1) {
            int n2;
            logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#handleCursorModeSwitch CHAR to WORD");
            if (!this.isSpellerActive() && (n2 = doubleCursor.currentIdx()[0]) != -1) {
                int n3 = MLUtils.getCharType(doubleCursor.getCharArray()[n2]);
                if (n3 == 0 && Collections.binarySearch(this.passedSpaceWords, doubleCursor.currentWordIdx(), IARRCMPINSTANCE) < 0) {
                    this.passedSpaceWords.add(doubleCursor.currentWordIdx());
                }
                if (n3 != 0 && this.passedSpaceWords.size() > 1) {
                    doubleCursor.setCursorMode(0);
                    this.passedSpaceWords.clear();
                }
            }
        } else {
            logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#handleCursorModeSwitch WORD to CHAR");
            if (doubleCursor.length() == 0) {
                doubleCursor.setCursorMode(1);
            }
        }
    }

    public void closeSpellerRightDrawer() {
        this.closeSpeller(true);
        this.setCursorModePriv(0);
    }

    public void openSpellerRightDrawer() {
        if (this.wordReplacer.isVisible()) {
            this.wordReplacer.close();
        }
        this.openSpeller(true);
    }

    public void openSpeller(boolean bl) {
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#openSpeller  animate:%1", bl);
        if (this.disableInput) {
            return;
        }
        this.setCursorModePriv(1);
        if (this.speller != null && !this.isSpellerActive()) {
            if (this.targetAnim != null) {
                AnimatedState animatedState = new AnimatedState(this.targetAnim);
                animatedState.updateViewPortPos(true);
                if (!animatedState.equals(this.targetAnim)) {
                    this.updateAnim(animatedState);
                }
            }
            if (this.targetAnim == null || !bl) {
                this.speller.setVisible(true);
            }
        }
        if (this.isInsideSpellerOrAlternatives != null) {
            this.isInsideSpellerOrAlternatives.setValue(1);
        }
    }

    public void closeSpeller(boolean bl) {
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#closeSpeller  animate:%1", bl);
        if (this.speller != null && this.isSpellerActive()) {
            if (this.targetAnim != null) {
                AnimatedState animatedState = new AnimatedState(this.targetAnim);
                animatedState.updateViewPortPos(false);
                if (!animatedState.equals(this.targetAnim)) {
                    this.updateAnim(animatedState);
                }
            }
            if (this.targetAnim != null || !bl) {
                this.speller.setVisible(false);
            }
        }
        if (this.isInsideSpellerOrAlternatives != null) {
            this.isInsideSpellerOrAlternatives.setValue(0);
        }
    }

    public void repaintWidgetOnHMIThread() {
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#repaintWidgetOnHMIThread");
        if (this.displayData != null) {
            this.displayData.setNeedsRendering(true);
            this.setCompositesDirty(true);
            this.setInvalid(true);
        }
    }

    private void insertWordPriv(String string) {
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#insertWordPriv  word:%1", (Object)string);
        this.multilineString.getCursor().insertWord(string);
        this.updatePreferredHeight();
        this.repaintWidgetOnHMIThread();
    }

    private int[] replaceWordPriv(String string) {
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#replaceWordPriv  word:%1", (Object)string);
        int[] nArray = new int[]{-1, -1};
        nArray = this.multilineString.getCursor().currentWordIdx();
        if (nArray[0] != -1) {
            this.multilineString.getCursor().removeWord();
            this.multilineString.getCursor().insertWord(string);
            nArray = this.multilineString.getCursor().currentWordIdx();
        }
        this.updatePreferredHeight();
        this.repaintWidgetOnHMIThread();
        return nArray;
    }

    @Override
    public void delete() {
        this.deletePriv();
    }

    private void deletePriv() {
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#deletePriv");
        this.multilineString.getCursor().remove();
        this.updatePreferredHeight();
        this.repaintWidgetOnHMIThread();
    }

    public void clear() {
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#clear");
        this.multilineString.getCursor().clear();
        this.updatePreferredHeight();
        this.repaintWidgetOnHMIThread();
    }

    private boolean next() {
        useGostChars = true;
        return this.nextGhostChars();
    }

    private boolean nextGhostChars() {
        boolean bl = false;
        GhostCursor ghostCursor = this.displayData.ghostCursor;
        int[] nArray = ghostCursor.next();
        bl = nArray[0] != -1;
        this.handleCursorModeSwitch(ghostCursor);
        if (bl) {
            this.updatePreferredHeight();
        }
        return bl;
    }

    private boolean prev() {
        return useGostChars ? this.prevGhostChars() : this.prevOLD();
    }

    private boolean prevGhostChars() {
        boolean bl = false;
        GhostCursor ghostCursor = this.displayData.ghostCursor;
        int[] nArray = ghostCursor.prev();
        bl = nArray[0] != -1;
        this.handleCursorModeSwitch(ghostCursor);
        if (bl) {
            this.updatePreferredHeight();
        }
        return bl;
    }

    private boolean prevOLD() {
        boolean bl = false;
        DoubleCursor doubleCursor = this.multilineString.getCursor();
        int[] nArray = doubleCursor.prev();
        bl = nArray[0] != -1;
        this.handleCursorModeSwitch(doubleCursor);
        if (bl) {
            this.updatePreferredHeight();
        }
        return bl;
    }

    @Override
    public void moveCursor(int n) {
        this.moveCursorPriv(n);
    }

    private boolean moveCursorPriv(int n) {
        boolean bl = n == 1 ? this.next() : this.prev();
        return bl;
    }

    private void setCursorModePriv(int n) {
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#setCursorModePriv   mode:%1", (long)n);
        this.passedSpaceWords.clear();
        DoubleCursor doubleCursor = this.multilineString.getCursor();
        if (n == 1) {
            this.startBlinkTimer();
            if (doubleCursor.currentWord().endsWith(" ")) {
                if (doubleCursor.currentWord().length() == 1) {
                    this.insertStr(" ");
                }
                doubleCursor.setCursorPos(doubleCursor.currentWordIdx()[1]);
            } else if (doubleCursor.currentChar() == '\n') {
                doubleCursor.setCursorPos(doubleCursor.currentWordIdx()[1]);
                this.insertStr(" ");
            } else {
                doubleCursor.setCursorPos(doubleCursor.currentWordIdx()[1] + 1);
            }
        } else if (n == 0) {
            if (this.isEmpty()) {
                return;
            }
            this.stopBlinkTimer();
            if (doubleCursor.currentWord().endsWith("  ")) {
                this.delete();
                this.next();
            }
        }
        doubleCursor.setCursorMode(n);
        if (this.displayData != null) {
            this.displayData.ghostCursor.setCursorMode(n);
        }
        this.repaintWidgetOnHMIThread();
    }

    @Override
    public int charWidth(char c2) {
        int n = this.renderer != null && this.isConnected() ? this.renderer.getCharWidth(c2) : 1;
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#charWidth   charWidth:%1", (long)n);
        return n;
    }

    @Override
    public int stringWidth(String string) {
        int n = this.renderer != null && this.isConnected() ? this.renderer.getStringW(string) : (string != null ? string.length() : 0);
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#stringWidth   charWidth:%1", (long)n);
        return n;
    }

    @Override
    public void setCursorMode(int n) {
        logMessagingMultilineEvents.log(-2137614336, "MultiLineTextFieldController#setCursorMode   mode:%1", (long)n);
        this.setCursorModePriv(n);
    }

    public void touchDelete() {
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#touchDelete");
        if (!this.isConnected()) {
            return;
        }
        if (this.bckSpcTouchHandler == null) {
            this.bckSpcTouchHandler = new BckSpaceGestureHandler(BckSpaceGestureHandlerConfig.getTouchPadType(this.getTerminalImpl().getKbdService() != null ? this.getTerminalImpl().getKbdService().getCurrentKeyboardType() : 6), new FastDeleteHelperImplementation(this.multilineString.getCursor()));
        }
        long l = System.currentTimeMillis();
        if (this.lastTouchDeleteGestureTime == -1L) {
            this.lastTouchDeleteGestureTime = l;
        }
        this.bckSpcTouchHandler.backspaceGesture((int)(l - this.lastTouchDeleteGestureTime));
        this.lastTouchDeleteGestureTime = l;
        this.updatePreferredHeight();
        this.repaintWidgetOnHMIThread();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void replInsChar(char c2) {
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#replInsChar");
        if (!this.isConnected()) {
            return;
        }
        DoubleCursor doubleCursor = this.multilineString.getCursor();
        try {
            this.multilineString.getCursor().freezeModelNotif();
            boolean bl = false;
            boolean bl2 = false;
            boolean bl3 = false;
            if (doubleCursor.getCursorMode() == 0) {
                boolean bl4 = this.displayData != null && this.displayData.ghostCursor != null && this.displayData.ghostCursor.getCurrentWordType() == 0;
                int[] nArray = this.multilineString.getCursor().currentWordIdx();
                this.multilineString.getCursor().setCursorMode(1);
                if (nArray[0] != -1) {
                    char[] cArray = this.multilineString.getCursor().getCharArray();
                    int n = MLUtils.getCharType(cArray[nArray[0]]);
                    if (n == 0) {
                        bl = true;
                        bl2 = true;
                        bl3 = true;
                    } else if (n == 3 || bl4) {
                        this.multilineString.getCursor().setCursorPos(this.multilineString.getCursor().currentWordIdx()[0]);
                        bl = false;
                        bl2 = bl4;
                        bl3 = false;
                    } else if (nArray[1] == this.multilineString.getCursor().length() - 1) {
                        bl = c2 != ' ';
                        bl2 = false;
                        bl3 = false;
                    } else {
                        bl = false;
                        bl2 = false;
                        bl3 = true;
                    }
                }
            }
            if (bl3) {
                this.multilineString.getCursor().removeWord();
            }
            if (bl) {
                this.multilineString.getCursor().insertChar(' ');
            }
            this.multilineString.getCursor().insertChar(c2);
            if (bl2) {
                this.multilineString.getCursor().insertChar(' ');
                this.multilineString.getCursor().setCursorPos(this.multilineString.getCursor().getCursorPos() - 1);
            }
        }
        finally {
            this.multilineString.getCursor().unfreezeModelNotif();
        }
        this.updatePreferredHeight();
        this.repaintWidgetOnHMIThread();
    }

    @Override
    public void insertChar(char c2) {
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#insertChar  char:%1", c2);
        if (c2 != '\b') {
            this.multilineString.getCursor().setCursorMode(1);
        }
        this.multilineString.getCursor().insertChar(c2);
        this.updatePreferredHeight();
        this.repaintWidgetOnHMIThread();
    }

    @Override
    public void insertStr(String string) {
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#insertStr  word:%1", (Object)string);
        this.multilineString.getCursor().insertWord(string);
        this.updatePreferredHeight();
        this.repaintWidgetOnHMIThread();
    }

    @Override
    public void replaceStr(String string) {
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#replaceStr  word:%1", (Object)string);
        int[] nArray = new int[]{-1, -1};
        nArray = this.multilineString.getCursor().currentWordIdx();
        if (nArray[0] != -1) {
            this.multilineString.getCursor().removeWord();
            this.multilineString.getCursor().insertWord(string);
            nArray = this.multilineString.getCursor().currentWordIdx();
        }
        this.updatePreferredHeight();
        this.repaintWidgetOnHMIThread();
    }

    @Override
    public int getSizeForTabulator(int n) {
        return -1;
    }

    @Override
    public int getWidgetID() {
        return this.widgetID;
    }

    public void setWidgetID(int n) {
        this.widgetID = n;
    }

    @Override
    public int getLineOffsetX() {
        return 15;
    }

    @Override
    public int getLineWidth() {
        int n = this.getDescriptiveText() != null ? 25 : 0;
        int n2 = this.getInputFieldWidth() - n - 40;
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#getLineWidth   width:%1", (long)n2);
        return n2;
    }

    @Override
    public int getSdsItemSelectedAction() {
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#getSdsItemSelectedAction   sds:%1", (long)this.sdsItemSelectedAction);
        return this.sdsItemSelectedAction;
    }

    public void setSdsItemSelectedAction(int n) {
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#setSdsItemSelectedAction   sds_new:%1  sds_old:%2", (long)n, (long)this.sdsItemSelectedAction);
        this.sdsItemSelectedAction = n;
    }

    @Override
    public void showExtended(boolean bl) {
    }

    @Override
    public int getPreferredHeight(boolean bl, int n) {
        return this.getPreferredHeight();
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public int getMargin(boolean bl) {
        if (AbstractWidget.isScreenResolution1440()) {
            return bl ? 1 : 3;
        }
        return 0;
    }

    @Override
    public int getGlassplateInsets(boolean bl) {
        return layoutMenuItemInsets;
    }

    @Override
    public boolean hasInfolineText() {
        return false;
    }

    @Override
    public String getInfolineText() {
        return null;
    }

    @Override
    public boolean isFocusable() {
        return true;
    }

    private synchronized void updateFocusedInstance(boolean bl) {
        if (!bl && this.widgetRegistry != null && this.widgetRegistry.getSelectedMultilineWidget() == this) {
            this.widgetRegistry.setSelectedMultilineWidget(null);
        }
        if (bl && this.widgetRegistry != null && this.widgetRegistry.getSelectedMultilineWidget() != this) {
            this.widgetRegistry.setSelectedMultilineWidget(this);
        }
    }

    @Override
    public void setFocused(boolean bl) {
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#setFocused   focused:%1", bl);
        if (bl) {
            this.setCursorModePriv(0);
            this.displayData.setLinesNeedRepos(true);
            this.wordReplacer.showIfAvailable();
            this.resetCatchTimer();
            this.startBlinkTimer();
        } else {
            this.wordReplacer.close();
            if (this.isInsideSpellerOrAlternatives != null) {
                this.isInsideSpellerOrAlternatives.setValue(0);
            }
            this.stopBlinkTimer();
        }
        this.setCompositesDirty(true);
        this.updateFocusedInstance(bl);
        super.setFocused(bl);
    }

    @Override
    public int getOptionIconYOffset() {
        return this.optionIconYOffset;
    }

    @Override
    protected void handleFocusChanged(int n, int n2, int n3) {
        switch (n) {
            case 1: {
                this.stopBlinkTimer();
                break;
            }
            case 2: {
                this.startBlinkTimer();
                break;
            }
            default: {
                this.startBlinkTimer();
            }
        }
    }

    @Override
    public IFocusedPropertyObject getProperty() {
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#getProperty");
        this.hideFingerTrace();
        if (this.disableInput) {
            return null;
        }
        if (!this.isEnabled() && this.multilineString != null && this.multilineString.getCursor() != null) {
            return null;
        }
        if (this.focusPropertyObject == null) {
            this.focusPropertyObject = new FocusedPropertyObject(-657864606, null);
        }
        IntList intList = new IntList(5);
        int n = this.multilineString.getCursor().length();
        if (n > 0) {
            intList.add(144238384);
        }
        if (this.isSpellerActive()) {
            intList.add(-28217558);
        }
        intList.add(this.touchUtil.getFocusPropertyForCurrentCharset());
        this.focusPropertyObject.setProperties(intList.toArray());
        this.focusPropertyObject.setActionReceiverWidget(this.cbkHndlr);
        this.focusPropertyObject.setModelID(this.getModelID());
        return this.focusPropertyObject;
    }

    @Override
    public synchronized void setMultilineMinVisLines(int n) {
        logMessagingMultiline.log(-2137614336, "MultilineTextFieldController#setMinNoVisibleLines type:%1", (long)n);
        if (this.minNoVisibleLines > -1 && this.minNoVisibleLines != n) {
            this.minNoVisibleLines = n;
            this.maxNoVisibleLines = Math.max(this.minNoVisibleLines, this.maxNoVisibleLines);
            this.updatePreferredHeight();
        }
    }

    @Override
    public synchronized void setMultilineMaxVisLines(int n) {
        logMessagingMultiline.log(-2137614336, "MultilineTextFieldController#setMaxNoVisibleLines type:%1", (long)n);
        int n2 = Math.max(n, this.minNoVisibleLines);
        if (n2 != this.maxNoVisibleLines) {
            this.maxNoVisibleLines = n2;
            this.updatePreferredHeight();
        }
    }

    @Override
    public void buttonPressed(SpellerController$SpellerButtonType spellerController$SpellerButtonType, SpellerButtonArgument spellerButtonArgument) {
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#buttonPressed   button:%1", (Object)spellerController$SpellerButtonType);
        if (spellerController$SpellerButtonType == SpellerController$SpellerButtonType.DELETE) {
            this.handleDeleteKey(true);
        } else if (spellerController$SpellerButtonType == SpellerController$SpellerButtonType.CLOSE) {
            if (this.wordReplacer.isFocused()) {
                this.wordReplacer.close();
                this.openSpeller(true);
            } else {
                this.closeSpeller(true);
                this.setCursorModePriv(0);
            }
        } else if (spellerController$SpellerButtonType == SpellerController$SpellerButtonType.OK) {
            this.closeSpeller(true);
        } else if (spellerController$SpellerButtonType == SpellerController$SpellerButtonType.RIGHT) {
            this.moveCursorPriv(1);
        } else if (spellerController$SpellerButtonType == SpellerController$SpellerButtonType.LEFT) {
            this.moveCursorPriv(0);
        } else if (spellerController$SpellerButtonType == SpellerController$SpellerButtonType.NEWLINE) {
            this.insertChar('\n');
        } else if (spellerController$SpellerButtonType == SpellerController$SpellerButtonType.SMILEY_SMILING) {
            this.insertStr(":-)");
        } else if (spellerController$SpellerButtonType == SpellerController$SpellerButtonType.SMILEY_LAUGHING) {
            this.insertStr(":-D");
        } else if (spellerController$SpellerButtonType == SpellerController$SpellerButtonType.SMILEY_WINKING) {
            this.insertStr(";-)");
        } else if (spellerController$SpellerButtonType == SpellerController$SpellerButtonType.SMILEY_DISAPPOINTED) {
            this.insertStr(":-(");
        }
    }

    @Override
    public void buttonLongPressed(SpellerController$SpellerButtonType spellerController$SpellerButtonType) {
    }

    @Override
    public void buttonReleased(SpellerController$SpellerButtonType spellerController$SpellerButtonType) {
        if (spellerController$SpellerButtonType == SpellerController$SpellerButtonType.DELETE) {
            this.handleDeleteKey(false);
        }
    }

    @Override
    public void characterPressed(String string, boolean bl, boolean bl2) {
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#characterPressed   string:%1", (Object)string);
        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#characterPressed   LongPress:%1    Expandable:%2", bl2, bl2);
        if (this.wordReplacer != null && this.wordReplacer.isFocused()) {
            this.replaceWordPriv(string);
            this.touchUtil.speak(string);
        } else if (!bl2 || bl2 && !bl) {
            if (string.length() > 0 && string.charAt(0) == '\b') {
                this.deletePriv();
            } else {
                this.replInsChar(string.charAt(0));
                if (string.length() > 1) {
                    this.insertWordPriv(string.substring(1));
                }
            }
        }
    }

    public int getLanguageIndicatorIconIndex() {
        if (this.touchUtil != null && this.terminal != null && this.terminal.getViewSizeManager() != null && this.terminal.getViewSizeManager().getCurrentViewSize() == 2) {
            return this.touchUtil.getLanguageIndicatorIconIndex();
        }
        return 0;
    }

    @Override
    public void focusedCharacterChanged(String string) {
    }

    @Override
    public void setOptionsIconSpace(int n) {
    }

    @Override
    public int getNoCursorArea(boolean bl) {
        return 0;
    }

    public boolean isCursorOnLastPos() {
        DoubleCursor doubleCursor = this.multilineString.getCursor();
        switch (doubleCursor.getCursorMode()) {
            case 1: {
                return doubleCursor.getCursorPos() + 1 > doubleCursor.getString().length();
            }
            case 0: {
                return doubleCursor.currentWordIdx()[1] + 1 >= doubleCursor.length();
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return this.multilineString.getCursor().getString().length() <= 0;
    }

    public boolean isCursorOnFirstPos() {
        DoubleCursor doubleCursor = this.multilineString.getCursor();
        switch (doubleCursor.getCursorMode()) {
            case 1: {
                return doubleCursor.getCursorPos() == 0;
            }
            case 0: {
                return doubleCursor.currentWordIdx()[0] == 0;
            }
        }
        return false;
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

    public void setDescriptiveTextLenght(int n) {
        this.descriptiveTextLength = n;
    }

    public int getDescriptiveTextLength() {
        return this.descriptiveTextLength;
    }

    private void acquireDescriptiveText2() {
        AbstractWidget abstractWidget;
        AbstractWidget abstractWidget2 = this.getParent();
        if (abstractWidget2 instanceof MenuController && (abstractWidget = ((MenuController)abstractWidget2).getChildOfRole(5)) instanceof TouchController) {
            TouchController touchController = (TouchController)abstractWidget;
            String string = this.getDescriptiveText();
            if (string != null) {
                touchController.setDescriptiveText2(this.getDescriptiveText());
                this.setDescriptiveText2(touchController.getDescriptiveText());
            }
        }
    }

    public int getInputFieldWidth() {
        String string = this.getDescriptiveText();
        return string != null ? this.getWidth() - this.renderer.getTextLength(string) : this.getWidth();
    }

    private void initModel() {
        if (this.modelStub != null && this.modelStub.getModel() instanceof ChoiceModelApp) {
            this.isInsideSpellerOrAlternatives = (ChoiceModelApp)this.modelStub.getModel();
        }
    }

    @Override
    public void add(AbstractWidget abstractWidget) {
        if (abstractWidget instanceof ModelStubController) {
            this.modelStub = (ModelStubController)abstractWidget;
        }
        super.add(abstractWidget);
    }

    public void setDescriptiveText2(String string) {
        this.descriptiveText2 = string;
    }

    public String getDescriptiveText2() {
        return this.descriptiveText2;
    }

    private boolean moveCursorToLine(boolean bl) {
        int n = bl ? 1 : 0;
        int n2 = this.currentAnim.viewPort.vpLastVisibleLine;
        int n3 = this.currentAnim.viewPort.vpFirstVisibleLine;
        int n4 = this.currentAnim.viewPort.vpNoVisibleLines;
        boolean bl2 = true;
        boolean bl3 = false;
        while (bl2 && !bl3) {
            bl2 = this.moveCursorPriv(n);
            if (n == 1) {
                bl3 = n2 != this.targetAnim.viewPort.vpLastVisibleLine;
                continue;
            }
            bl3 = n3 != this.targetAnim.viewPort.vpFirstVisibleLine || n4 != this.targetAnim.viewPort.vpNoVisibleLines;
        }
        return bl3;
    }

    @Override
    public void focusChanged(SpellerController$ISpellerItem spellerController$ISpellerItem, int n) {
    }

    @Override
    public void userCharsetChanged(int n) {
        this.setCompositesDirty(true);
    }

    static /* synthetic */ HMITerminalImpl access$000(MultilineTextFieldController multilineTextFieldController) {
        return multilineTextFieldController.terminal;
    }

    static /* synthetic */ SpellerController access$100(MultilineTextFieldController multilineTextFieldController) {
        return multilineTextFieldController.speller;
    }

    static /* synthetic */ int access$200(MultilineTextFieldController multilineTextFieldController) {
        return multilineTextFieldController.x;
    }

    static /* synthetic */ int access$300(MultilineTextFieldController multilineTextFieldController) {
        return multilineTextFieldController.y;
    }

    static /* synthetic */ int access$400(MultilineTextFieldController multilineTextFieldController) {
        return multilineTextFieldController.width;
    }

    static /* synthetic */ int access$500(MultilineTextFieldController multilineTextFieldController) {
        return multilineTextFieldController.height;
    }

    static {
        IARRCMPINSTANCE = new MultilineTextFieldController$IntArrCompare(null);
        MENU_ITEM_INSETS = new int[]{0, 0};
        layoutMenuItemInsets = MENU_ITEM_INSETS[0];
        layoutConfigIdx = 0;
        useGostChars = true;
    }
}

