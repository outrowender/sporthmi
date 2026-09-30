/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.DisclaimerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;

public class VisibilityProxyWidget
extends AbstractWidgetController {
    public static final int VP_STATE_VISIBLE_ENABLED = 0;
    public static final int VP_STATE_INVISIBLE = 1;
    public static final int VP_STATE_VISIBLE_DISABLED = 2;
    public static final int VP_STATE_VISIBLE_DISABLED_FUNCTIONAL = 3;
    private boolean visibleByCondition = true;
    private boolean enabledByCondition = true;
    private boolean functionalByCondition = true;
    private boolean disableAvailable = true;

    public void initializeWidget() {
        super.initializeWidget();
        this.updateValue();
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getUpdateType();
        if (n == 1 || n == 14) {
            this.updateValue();
        }
        if (this.parent != null && this.parent instanceof MenuItemController) {
            ((MenuItemController)this.parent).updateInfoLineText();
        }
        if (this.parent != null && this.parent instanceof DisclaimerController) {
            ((DisclaimerController)this.parent).processModelUpdateEvent(modelUpdateEvent);
        }
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    private void updateValue() {
        if (this.model instanceof ChoiceModelGUI) {
            this.refreshVisibilityStatus(((ChoiceModelGUI)this.model).getValue());
        }
    }

    private void refreshVisibilityStatus(int n) {
        if (this.parent != null) {
            boolean bl;
            boolean bl2 = true;
            boolean bl3 = true;
            boolean bl4 = true;
            switch (n) {
                case 0: {
                    bl2 = true;
                    bl3 = true;
                    break;
                }
                case 1: {
                    bl2 = false;
                    break;
                }
                default: {
                    bl2 = true;
                    bl3 = this.setByDisabledMode();
                    bl4 = this.setFunctionalByModelStatus();
                    logChannel.log(100000, "VisibilityProxyWidget#refreshVisibilityStatus status: %1 is undefined - set parent DISABLED and FUNCTIONAL", (long)n);
                }
            }
            boolean bl5 = bl2 && this.visibleByCondition;
            boolean bl6 = bl3 && this.enabledByCondition;
            boolean bl7 = bl = bl4 && this.functionalByCondition;
            if (bl5 != this.parent.isVisible()) {
                this.parent.setVisible(bl5);
            }
            if (bl6 != this.parent.isEnabled()) {
                this.parent.setEnabled(bl6);
            }
            if (bl != this.parent.isFunctional()) {
                this.parent.setFunctional(bl);
            }
        }
    }

    private boolean setFunctionalByModelStatus() {
        int n;
        return this.model instanceof AbstractModel && (n = ((AbstractModel)this.model).getStatus()) == 1;
    }

    private boolean setByDisabledMode() {
        return !this.disableAvailable;
    }

    public void setEnabled(boolean bl) {
        this.enabledByCondition = bl;
        this.updateValue();
    }

    public void setVisible(boolean bl) {
        this.visibleByCondition = bl;
        this.updateValue();
    }

    public void setFunctional(boolean bl) {
        this.functionalByCondition = bl;
        this.updateValue();
    }

    public IRenderer getRenderer() {
        return null;
    }

    public void setDisableAvailable(boolean bl) {
        this.disableAvailable = bl;
    }

    public boolean isDisableAvailable() {
        return this.disableAvailable;
    }
}

