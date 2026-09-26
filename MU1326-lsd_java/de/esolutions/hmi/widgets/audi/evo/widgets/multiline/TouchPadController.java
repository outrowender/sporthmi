/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.multiline;

import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.model.texteditor.DoubleCursor;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.ExtHMITerminalEvo;
import de.esolutions.hmi.widgets.audi.evo.prpframework.IPRPEngine;
import de.esolutions.hmi.widgets.audi.evo.prpframework.PRPEngineEurope;
import de.esolutions.hmi.widgets.audi.evo.widgets.FingerTraceController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IFingerTraceRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IInputTextInfoProvider;
import de.esolutions.hmi.widgets.audi.evo.widgets.IMultilineTextFiledRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ITouchPadRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.MultilineTextFieldController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchCharSetAndTTSHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.factories.FingerTraceControllerFactory;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.MLDisplayData;
import de.esolutions.hmi.widgets.audi.evo.widgets.multiline.SChar;

public class TouchPadController
extends AbstractWidgetController
implements IInputTextInfoProvider {
    private ITouchPadRenderer renderer;
    private IPRPEngine prpEngine;
    private int kbdType;
    private FingerTraceController fingerTraceWidget;
    private DoubleCursor m_cursor = null;

    public void setRenderer(ITouchPadRenderer iTouchPadRenderer) {
        this.renderer = iTouchPadRenderer;
    }

    @Override
    public boolean isFocused() {
        return true;
    }

    @Override
    protected void initConnect(InitializationContext initializationContext) {
        super.initConnect(initializationContext);
        this.setRecognizerMode();
        int n = this.terminal.getFramework().getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI").getLanguageIndex();
        this.prpEngine = new PRPEngineEurope(96, -1, this, n, logPRPEngine);
        int n2 = this.kbdType = this.terminal.getKbdService() != null ? this.terminal.getKbdService().getCurrentKeyboardType() : 6;
        if (this.fingerTraceWidget == null) {
            IFingerTraceRenderer iFingerTraceRenderer;
            FingerTraceController fingerTraceController = FingerTraceControllerFactory.create();
            IFingerTraceRenderer iFingerTraceRenderer2 = iFingerTraceRenderer = this.terminal instanceof ExtHMITerminalEvo && ((ExtHMITerminalEvo)((Object)this.terminal)).getRendererFactory() != null ? ((ExtHMITerminalEvo)((Object)this.terminal)).getRendererFactory().createFingerTraceRenderer(fingerTraceController) : null;
            if (iFingerTraceRenderer != null) {
                fingerTraceController.setRenderer(iFingerTraceRenderer);
                this.add(fingerTraceController);
                this.fingerTraceWidget = fingerTraceController;
            }
        }
    }

    public IPRPEngine getPRPEnige() {
        return this.prpEngine;
    }

    public void setPRPEngine(IPRPEngine iPRPEngine) {
        this.prpEngine = iPRPEngine;
    }

    private void setRecognizerMode() {
        if (this.terminal != null && this.terminal.getTouchInputManager() != null) {
            this.terminal.getTouchInputManager().setDesiredRecognizerMode(this, 26);
        } else {
            tpLogChannelInternal.log(10000, "TouchPadWidget#setRecognizerMode getTouchInputManager is null, recognizerMode not set!");
        }
    }

    @Override
    public void disconnecting() {
        super.disconnecting();
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void hideFingerTrace() {
        this.fingerTraceWidget.hideFingerTrace();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updatePosition() {
        DoubleCursor doubleCursor = this.getMLCursor();
        if (doubleCursor != null) {
            try {
                if (doubleCursor.mtxAquireLock()) {
                    MultilineTextFieldController multilineTextFieldController = (MultilineTextFieldController)this.parent;
                    int n = doubleCursor.currentCharIdx();
                    IMultilineTextFiledRenderer iMultilineTextFiledRenderer = (IMultilineTextFiledRenderer)multilineTextFieldController.getRenderer();
                    int n2 = multilineTextFieldController.getX() + 5 + multilineTextFieldController.getDescriptiveTextLength();
                    int n3 = multilineTextFieldController.getY();
                    if (n != -1) {
                        MLDisplayData mLDisplayData = multilineTextFieldController.getLinifiedData();
                        if (mLDisplayData.charMetaData.size() > 0 && n < mLDisplayData.charMetaData.size()) {
                            SChar sChar = (SChar)mLDisplayData.charMetaData.get(n);
                            if (mLDisplayData.cursor.currentChar() == '\n' || mLDisplayData.cursor.currentChar() == '\r') {
                                n2 = multilineTextFieldController.getLineOffsetX();
                                n3 += (int)iMultilineTextFiledRenderer.getAbsLineIdxPos(sChar.line + 1) + 4 - (this.getWidth() - iMultilineTextFiledRenderer.getLineHeight()) / 2;
                            } else {
                                n2 += sChar.x + sChar.w;
                                n3 = (int)((float)n3 + (iMultilineTextFiledRenderer.getAbsLineIdxPos(sChar.line) + 32832 - (float)((this.getWidth() - iMultilineTextFiledRenderer.getLineHeight()) / 2)));
                            }
                        }
                    } else {
                        n3 = multilineTextFieldController.isSpellerActive() ? (n3 += 76) : (n3 += 13);
                    }
                    this.setX(n2);
                    this.setY(n3);
                    if (this.fingerTraceWidget != null) {
                        this.fingerTraceWidget.setX(n2);
                        this.fingerTraceWidget.setY(n3);
                    }
                } else {
                    tpLogChannelInternal.log(10000, "TouchPadController#updatePosition: failed to acquire lock");
                }
            }
            finally {
                doubleCursor.mtxReleaseLock();
            }
        }
    }

    @Override
    public void touchPadPressed(TouchEvent touchEvent) {
        this.setVisible(true);
        this.setOnScreen(true);
        this.updatePosition();
        super.touchPadPressed(touchEvent);
    }

    public boolean isFingerTraceVisible() {
        return this.fingerTraceWidget != null ? this.fingerTraceWidget.isLineVisible() : false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void touchPadCharactersRecognized(TouchEvent touchEvent) {
        String string = touchEvent.getRecognizedCharacters();
        if (string != null && string.length() > 0) {
            tpLogChannelKeypanel.log(-2137614336, "TouchPadController#touchpadCharactersRecognized: recognizedCharacters=%1", (Object)string);
            String string2 = null;
            try {
                this.prpEngine.process(touchEvent.getRecognizedCharacters(), touchEvent.getCharacterConfidence(), this.fingerTraceWidget.isMinStrokeReached());
                string2 = this.prpEngine.getResult();
                if (this.parent instanceof MultilineTextFieldController) {
                    TouchCharSetAndTTSHandler touchCharSetAndTTSHandler = ((MultilineTextFieldController)this.parent).getTouchUtil();
                    if (!this.getMLCursor().mtxAquireLock()) {
                        tpLogChannelInternal.log(-1601830656, "TouchPadController#touchPadCharactersRecognized: could not acquire lock");
                    }
                    if (string2 != null && string2.length() > 0) {
                        logMessagingMultiline.log(-2137614336, "MultiLineTextFieldController#touchPadCharactersRecognized filteredChars=%1", (Object)string2);
                        if (string2.charAt(0) == '\b') {
                            touchCharSetAndTTSHandler.sayDelete();
                        } else {
                            touchCharSetAndTTSHandler.speakChar(String.valueOf(string2.charAt(0)));
                        }
                        this.processTouchResult(string2);
                    } else {
                        touchCharSetAndTTSHandler.speakCharWithNegativeTone(String.valueOf(string.charAt(0)));
                    }
                }
            }
            finally {
                this.getMLCursor().mtxReleaseLock();
            }
            this.setCompositesDirty(true);
            this.invalidateParentLayout();
            touchEvent.consume(true);
            if (this.fingerTraceWidget != null) {
                this.fingerTraceWidget.characterRecognized(TouchController.getMostPlausibleCharacter(string2));
            }
        } else if (this.parent instanceof MultilineTextFieldController) {
            ((MultilineTextFieldController)this.parent).getTouchUtil().speakCharWithNegativeTone(null);
        }
        super.touchPadCharactersRecognized(touchEvent);
        this.updatePosition();
    }

    @Override
    public String getCurrentWord() {
        int[] nArray;
        char[] cArray;
        String string = "";
        DoubleCursor doubleCursor = this.getMLCursor();
        if (doubleCursor != null && (cArray = doubleCursor.getCharArray()) != null && cArray.length > 0 && (nArray = doubleCursor.currentWordIdx())[0] != -1) {
            string = new String(cArray, nArray[0], nArray[1] - nArray[0] + 1);
        }
        return string;
    }

    @Override
    public String getCurrentText() {
        DoubleCursor doubleCursor = this.getMLCursor();
        String string = doubleCursor != null ? doubleCursor.getString() : "";
        return string;
    }

    @Override
    public boolean isStartOfText() {
        return this.getCurrentText().length() <= 0;
    }

    @Override
    public boolean isStartOfWord() {
        char c2;
        String string = this.getCurrentText();
        if (string == null || string.length() <= 0) {
            return true;
        }
        boolean bl = false;
        if (string.length() > 0 && ("!.;?\u00a1\u00bf".indexOf(c2 = string.charAt(string.length() - 1)) >= 0 || c2 == ' ')) {
            bl = true;
        }
        return bl;
    }

    @Override
    public int getKeyboardType() {
        return this.kbdType;
    }

    public void setKbdType(int n) {
        this.kbdType = n;
    }

    private DoubleCursor getMLCursor() {
        if (this.parent instanceof MultilineTextFieldController) {
            MultilineTextFieldController multilineTextFieldController = (MultilineTextFieldController)this.parent;
            this.m_cursor = multilineTextFieldController != null && multilineTextFieldController.getString() != null ? multilineTextFieldController.getString().getCursor() : null;
        }
        return this.m_cursor;
    }

    private void processTouchResult(String string) {
        if (string.length() == 0) {
            return;
        }
        char c2 = string.charAt(0);
        if (this.prpEngine != null) {
            this.prpEngine.characterEntered(c2);
        }
        if (this.parent instanceof MultilineTextFieldController) {
            MultilineTextFieldController multilineTextFieldController = (MultilineTextFieldController)this.parent;
            if (c2 != '\b' && c2 != ' ') {
                multilineTextFieldController.closeSpeller(false);
            }
            if (c2 == '\b') {
                multilineTextFieldController.touchDelete();
            } else {
                multilineTextFieldController.replInsChar(c2);
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.getTextLength() == 0;
    }

    @Override
    public String getCurrentDisplayString() {
        return this.getCurrentText();
    }

    @Override
    public int getTextLength() {
        return this.getCurrentText().length();
    }
}

