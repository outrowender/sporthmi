/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.modelaccess.SpellerModelGUI;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.LayoutManager;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.ExtHMITerminalEvo;
import de.esolutions.hmi.widgets.audi.evo.IRendererFactory;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AbstractGridLayout;
import de.esolutions.hmi.widgets.audi.evo.prpframework.IPRPEngine;
import de.esolutions.hmi.widgets.audi.evo.prpframework.PRPEngineEurope;
import de.esolutions.hmi.widgets.audi.evo.widgets.FingerTraceController;
import de.esolutions.hmi.widgets.audi.evo.widgets.FormfieldInputController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IFingerTraceRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IInputTextInfoProvider;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchCharSetAndTTSHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.factories.FingerTraceControllerFactory;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import java.util.Iterator;

public class DirectWritingController
extends AbstractWidgetController
implements IInputTextInfoProvider {
    private FingerTraceController fingerTraceWidget;
    private TouchCharSetAndTTSHandler touchUtil;
    private int touchMode = 16;
    private IPRPEngine prp;
    private boolean fingertracePositionIsSet = false;

    private IRendererFactory getRendererFactory() {
        ExtHMITerminalEvo extHMITerminalEvo = (ExtHMITerminalEvo)this.getTerminal();
        if (extHMITerminalEvo == null) {
            return null;
        }
        return extHMITerminalEvo.getRendererFactory();
    }

    protected void initializeWidget() {
        super.initializeWidget();
        if (DirectWritingController.isAsia()) {
            tpLogChannelKeypanel.log(1000000, "DirectWritingController#initializeWidget: Asian system detected, direct writing is disabled");
            return;
        }
        if (this.terminal != null) {
            if (this.terminal.getTouchInputManager() != null) {
                this.terminal.getTouchInputManager().setDesiredRecognizerMode(this, 26);
            }
            this.touchUtil = new TouchCharSetAndTTSHandler(this.terminal);
            this.prp = new PRPEngineEurope(this.touchMode, -1, this, this.touchUtil.getInternalLanguage(), tpLogChannelKeypanel, framework.isNar());
        }
    }

    protected void initConnect(InitializationContext initializationContext) {
        super.initConnect(initializationContext);
        if (DirectWritingController.isAsia()) {
            return;
        }
        if (this.fingerTraceWidget == null) {
            FingerTraceController fingerTraceController = FingerTraceControllerFactory.create();
            fingerTraceController.setChainedAction(1, 1);
            IRendererFactory iRendererFactory = this.getRendererFactory();
            if (iRendererFactory != null) {
                IFingerTraceRenderer iFingerTraceRenderer = iRendererFactory.createFingerTraceRenderer(fingerTraceController);
                fingerTraceController.setRenderer(iFingerTraceRenderer);
            } else {
                tpLogChannelInternal.log(10000, "DirectWritingController#initConnect: could not create fingertrace renderer");
            }
            this.add(fingerTraceController);
            this.fingerTraceWidget = fingerTraceController;
        }
        this.fingertracePositionIsSet = false;
    }

    private void setFingerTracePos() {
        if (DirectWritingController.isAsia()) {
            return;
        }
        if (!this.fingertracePositionIsSet) {
            int n = 0;
            n = this.getTabPosition(n);
            this.fingerTraceWidget.setX(TouchController.getAbsoluteX(this) + n);
            int n2 = TouchController.getAbsoluteY(this);
            this.fingerTraceWidget.setY(n2 - 10);
            this.fingertracePositionIsSet = true;
        }
    }

    private int getTabPosition(int n) {
        LayoutManager layoutManager;
        if (this.parent instanceof MenuItemController && (layoutManager = ((MenuItemController)this.parent).getLayoutManager()) instanceof AbstractGridLayout) {
            n = ((AbstractGridLayout)((Object)layoutManager)).getTabulator(2);
            Iterator iterator = this.parent.getChildren().iterator();
            while (iterator.hasNext()) {
                AbstractWidgetController abstractWidgetController = (AbstractWidgetController)iterator.next();
                if (!(abstractWidgetController instanceof FormfieldInputController)) continue;
                n = abstractWidgetController.getX();
                break;
            }
        }
        return n;
    }

    public IRenderer getRenderer() {
        return null;
    }

    public void touchPadCharactersRecognized(TouchEvent touchEvent) {
        if (!(this.model instanceof SpellerModelGUI) || DirectWritingController.isAsia()) {
            return;
        }
        String string = touchEvent.getRecognizedCharacters();
        char c2 = '\u0000';
        if (this.fingerTraceWidget == null || !this.fingerTraceWidget.exceededMinStrokeLength()) {
            tpLogChannelKeypanel.log(1000000, "DirectWritingController#touchPadCharactersRecognized Did not exceed min stroke Length");
        } else if (!this.isEnabled()) {
            tpLogChannelKeypanel.log(1000000, "DirectWritingController#touchPadCharactersRecognized Not enabled.");
        } else if (string == null || string.length() == 0) {
            this.touchUtil.speakCharWithNegativeTone(null);
        } else if (this.parent != null && this.parent.isEnabled() && this.parent.isActive()) {
            this.prp.process(string, touchEvent.getCharacterConfidence(), true);
            String string2 = this.prp.getResult();
            tpLogChannelKeypanel.log(1000000, "DirectWritingController#touchPadCharactersRecognized: result after PRP", (Object)string2);
            if (string2 != null && string2.length() > 0) {
                c2 = this.prp.getResult().charAt(0);
                if (this.isStartOfText() && c2 == '\b') {
                    c2 = '\u0000';
                }
                if (!this.suppressTTSOutput()) {
                    this.touchUtil.speakChar(Character.toString(c2));
                }
            }
            if (c2 == '\u0000') {
                tpLogChannelKeypanel.log(1000000, "DirectWritingController#touchPadCharactersRecognized: no valid char recognized (after PRP)");
                this.touchUtil.speakCharWithNegativeTone(null);
            } else {
                tpLogChannelKeypanel.log(1000000, "DirectWritingController#touchPadCharactersRecognized: write char: %1 to model (modelID: %2)", (long)c2, (long)this.modelID);
                ((SpellerModelGUI)this.model).textChanged(String.valueOf(c2), c2, this.terminal.getTerminalID());
            }
            this.fingerTraceWidget.characterRecognized(c2);
            this.fingerTraceWidget.hideFingerTrace();
            touchEvent.consume();
        }
    }

    private boolean isPassWordField() {
        return this.touchMode == 64 || this.touchMode == 80 || this.touchMode == 82;
    }

    protected final boolean suppressTTSOutput() {
        return this.isPassWordField() || this.touchMode == 81;
    }

    public void touchPadPressed(TouchEvent touchEvent) {
        if (this.fingerTraceWidget != null && this.isEnabled()) {
            tpLogChannelKeypanel.log(1000000, "DirectWritingController#touchPadPressed: X=%1 / Y=%2 / fingerCount=%3", (long)touchEvent.getX(), (long)touchEvent.getY(), (long)touchEvent.getFingerCount());
            this.setFingerTracePos();
            this.fingerTraceWidget.touchPadPressed(touchEvent);
        }
    }

    public void touchPadReleased(TouchEvent touchEvent) {
        if (this.fingerTraceWidget != null && this.isEnabled()) {
            this.fingerTraceWidget.touchPadReleased(touchEvent);
        }
    }

    public void touchPadPositionMoved(TouchEvent touchEvent) {
        if (!this.fingertracePositionIsSet) {
            return;
        }
        if (this.fingerTraceWidget != null && this.isEnabled()) {
            tpLogChannelKeypanel.log(1000000, "DirectWritingController#touchPadMoved: X=%1 / Y=%2 / fingerCount=%3", (long)touchEvent.getX(), (long)touchEvent.getY(), (long)touchEvent.getFingerCount());
            this.fingerTraceWidget.touchPadPositionMoved(touchEvent);
        }
    }

    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        if (this.fingerTraceWidget != null && wheelButtonEvent.getClickCount() != 0 && this.isEnabled()) {
            this.fingerTraceWidget.hideFingerTrace();
        }
        super.keyTurned(wheelButtonEvent);
    }

    public boolean isFocused() {
        if (this.parent != null) {
            return this.parent.isFocused();
        }
        return super.isFocused();
    }

    public void setTouchMode(int n) {
        this.touchMode = n;
    }

    public String getCurrentWord() {
        return "";
    }

    public String getCurrentText() {
        return "";
    }

    public boolean isStartOfText() {
        return true;
    }

    public boolean isStartOfWord() {
        return true;
    }

    public int getKeyboardType() {
        return this.terminal.getKbdService().getCurrentKeyboardType();
    }

    public boolean isEmpty() {
        return false;
    }

    public String getCurrentDisplayString() {
        return this.getCurrentText();
    }

    public int getTextLength() {
        return 0;
    }
}

