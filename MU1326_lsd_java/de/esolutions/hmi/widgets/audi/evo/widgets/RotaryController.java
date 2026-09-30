/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;
import de.audi.atip.hmi.modelaccess.RangeModelGUI;
import de.audi.atip.i18n.ILanguageManager;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.BaseListModelKeyHandler;
import de.esolutions.hmi.widgets.audi.evo.IWidgetKeyHandler;
import de.esolutions.hmi.widgets.audi.evo.RangeModelKeyHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.RotaryRenderer;
import java.util.ArrayList;

public class RotaryController
extends AbstractWidgetController {
    private IRenderer renderer;
    private int value;
    private int medPositon;
    private int step;
    private int minPosition;
    private int maxPosition;
    private int ambientColorNum;
    private ArrayList colorsList;
    private float scaleFactor = 1.0f;
    private IWidgetKeyHandler keyHandler = this.getKeyHandler();

    private IWidgetKeyHandler getKeyHandler() {
        if (this.model instanceof BaseListModel) {
            return BaseListModelKeyHandler.BASE_LIST_MODEL_KEY_HANDLER_INSTANCE;
        }
        return RangeModelKeyHandler.RANGE_MODEL_KEY_HANDLER_INSTANCE;
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(RotaryRenderer rotaryRenderer) {
        this.renderer = rotaryRenderer;
    }

    protected void initializeWidget() {
        super.initializeWidget();
        this.updateValues();
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getUpdateType();
        if (n == 1 || n == 4 || n == 22 || n == 14) {
            this.updateValues();
        }
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    protected void updateValues() {
        HMIModelGUI hMIModelGUI;
        if (this.model instanceof RangeModelGUI) {
            hMIModelGUI = (RangeModelGUI)this.model;
            this.maxPosition = hMIModelGUI.getMaximum();
            this.minPosition = hMIModelGUI.getMinimum();
            this.step = hMIModelGUI.getStep();
            if (this.step < 1) {
                logChannel.log(10000, "RotaryController#updateValues: a step smaller than 1 is not allowed. step=", (long)this.step);
                this.step = 1;
            }
            this.medPositon = hMIModelGUI.getMedialPosition();
            this.value = hMIModelGUI.getValue();
        }
        if (this.model instanceof BaseListModel) {
            hMIModelGUI = (BaseListModel)this.model;
            this.ambientColorNum = ((BaseListModel)hMIModelGUI).getLength();
            this.maxPosition = this.ambientColorNum - 1;
            this.minPosition = 0;
            this.step = 1;
            if (this.colorsList == null) {
                this.colorsList = new ArrayList();
            }
            this.colorsList.clear();
            for (int i2 = 0; i2 < this.ambientColorNum; ++i2) {
                this.colorsList.add(i2, ((BaseListModel)hMIModelGUI).getRow(i2));
            }
            this.value = ((BaseListModel)hMIModelGUI).getSelected() == null ? 0 : ((BaseListModel)hMIModelGUI).getSelected().getIndex();
        }
        this.setCompositesDirty(true);
        this.invalidateParentLayout();
    }

    public EvoListRow getColorRowAtIndex(int n) {
        if (this.colorsList != null) {
            return (EvoListRow)this.colorsList.get(n);
        }
        return null;
    }

    public void keyPressed(KeyEvent keyEvent) {
        super.keyPressed(keyEvent);
        if (keyEvent.isConsumed()) {
            return;
        }
        logChannel.log(10000000, "MenuItemWidget#keyPressed. Key code: %2, widget state: %3, model: %1", this.model, (long)keyEvent.getKeyCode(), (long)this.widgetState);
        boolean bl = this.hasState(36);
        if (bl && this.keyHandler != null) {
            this.keyHandler.keyPressed(this, keyEvent);
            return;
        }
        if (keyEvent.getKeyCode() == 17 && !bl && this.isFunctional()) {
            keyEvent.consume(true);
        }
    }

    public void keyReleased(KeyEvent keyEvent) {
        super.keyReleased(keyEvent);
        if (keyEvent.isConsumed()) {
            return;
        }
        if (this.hasState(36) && this.keyHandler != null) {
            this.keyHandler.keyReleased(this, keyEvent);
        }
        super.keyReleased(keyEvent);
    }

    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        super.keyTurned(wheelButtonEvent);
        if (wheelButtonEvent.isConsumed()) {
            return;
        }
        if (this.hasState(36) && this.keyHandler != null) {
            WheelButtonEvent wheelButtonEvent2 = wheelButtonEvent;
            if (wheelButtonEvent.getKeyCode() == 20) {
                int n = wheelButtonEvent.getDirection() == 0 ? 1 : 0;
                wheelButtonEvent2 = new WheelButtonEvent(wheelButtonEvent.getReceiver(), wheelButtonEvent.getID(), wheelButtonEvent.getWhen(), 17, n, wheelButtonEvent.getClickCount(), wheelButtonEvent.getSubClickCount(), wheelButtonEvent.getTerminalID());
            }
            this.keyHandler.keyTurned(this, wheelButtonEvent2);
        }
    }

    public int getMinPosition() {
        return this.minPosition;
    }

    public int getMaxPosition() {
        return this.maxPosition;
    }

    public int getValue() {
        return this.value;
    }

    public int getMedPositon() {
        return this.medPositon;
    }

    public int getStep() {
        return this.step;
    }

    public int getAmbientColorNum() {
        return this.ambientColorNum;
    }

    public void setScaleFactor(float f2) {
        this.scaleFactor = f2;
    }

    public float getScaleFactor() {
        return this.scaleFactor;
    }

    public void setModel(HMIModelGUI hMIModelGUI) {
        this.model = hMIModelGUI;
        this.keyHandler = this.getKeyHandler();
    }

    public void setEnabled(boolean bl) {
        if (bl != this.isEnabled()) {
            this.setCompositesDirty(true);
        }
        super.setEnabled(bl);
    }

    public boolean showDistanceIndicatorLine() {
        ILanguageManager iLanguageManager;
        IFrameworkAccess iFrameworkAccess = AbstractWidget.framework;
        if (iFrameworkAccess != null && (iLanguageManager = iFrameworkAccess.getLanguageMgr()) != null) {
            return iLanguageManager.getCurrentLanguage("LANG_COMPONENT_HMI").getLanguageIndex() == 0;
        }
        return false;
    }
}

