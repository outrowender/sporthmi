/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ButtonController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import java.util.List;

public class ButtonGroupController
extends AbstractWidgetController {
    private IRenderer renderer;
    private boolean doubleCursorMode = false;
    private boolean dynamicLayout = false;
    private int[] buttonPositions;
    private AbstractWidget lastHighlightedChild;
    private boolean groupVisible = true;

    @Override
    protected void initializeWidget() {
        if (this.model != null && this.model instanceof ChoiceModelGUI) {
            this.checkModelValue();
        } else if (this.isEnabled()) {
            for (int i2 = 0; i2 < this.getChildrenSize(); ++i2) {
                ButtonController buttonController = (ButtonController)this.getChild(i2);
                buttonController.setFocused(i2 == this.getChildrenSize() - 1);
            }
        }
        super.initializeWidget();
    }

    private void checkModelValue() {
        int n = ((ChoiceModelGUI)this.model).getValue();
        for (int i2 = 0; i2 < this.getChildrenSize(); ++i2) {
            ButtonController buttonController = (ButtonController)this.getChild(i2);
            if (buttonController.getButtonID() == n) {
                if (this.isEnabled()) {
                    buttonController.setFocused(true);
                }
                if (!this.doubleCursorMode) continue;
                buttonController.setHighlighted(true);
                this.lastHighlightedChild = buttonController;
                continue;
            }
            buttonController.setFocused(false);
            buttonController.setHighlighted(false);
        }
    }

    @Override
    public void setEnabled(boolean bl) {
        if (this.isEnabled() && !bl) {
            for (int i2 = 0; i2 < this.getChildrenSize(); ++i2) {
                ((ButtonController)this.getChild(i2)).setFocused(false);
            }
            super.setEnabled(false);
        } else if (!this.isEnabled() && bl) {
            super.setEnabled(true);
            this.checkModelValue();
        }
    }

    public void setRenderer(IRenderer iRenderer) {
        this.renderer = iRenderer;
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    @Override
    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        if (!this.isEnabled() || !this.isVisible()) {
            return;
        }
        super.keyTurned(wheelButtonEvent);
        if (this.isEnabled() && this.isActive() && this.isVisible()) {
            if (wheelButtonEvent.getClickCount() == 0) {
                wheelButtonEvent.consume(false);
                return;
            }
            int n = wheelButtonEvent.getDirection();
            this.updateSelectedWidget(n);
            wheelButtonEvent.consume();
        }
    }

    @Override
    public void add(AbstractWidget abstractWidget) {
        if (!(abstractWidget instanceof IconController)) {
            return;
        }
        super.add(abstractWidget);
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (!this.isEnabled()) {
            return;
        }
        if (keyEvent.getKeyCode() == 17) {
            if (!(this.isActive() && this.isEnabled() && this.isVisible())) {
                return;
            }
            List list = this.getChildren();
            for (int i2 = 0; i2 < list.size(); ++i2) {
                AbstractWidget abstractWidget = (AbstractWidget)list.get(i2);
                if (!abstractWidget.isFocused()) continue;
                abstractWidget.keyPressed(keyEvent);
                if (!this.doubleCursorMode) continue;
                if (this.lastHighlightedChild != null) {
                    this.lastHighlightedChild.setHighlighted(false);
                }
                abstractWidget.setHighlighted(true);
                this.lastHighlightedChild = abstractWidget;
            }
            keyEvent.consume();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if (!this.isEnabled()) {
            return;
        }
        if (keyEvent.getKeyCode() == 17) {
            if (!(this.isActive() && this.isEnabled() && this.isVisible())) {
                return;
            }
            List list = this.getChildren();
            for (int i2 = 0; i2 < list.size(); ++i2) {
                AbstractWidget abstractWidget = (AbstractWidget)list.get(i2);
                if (!abstractWidget.isFocused()) continue;
                abstractWidget.keyReleased(keyEvent);
            }
            keyEvent.consume();
        }
    }

    private void updateSelectedWidget(int n) {
        int n2;
        List list = this.getChildren();
        int n3 = list.size();
        int n4 = -1;
        for (n2 = 0; n2 < list.size(); ++n2) {
            AbstractWidget abstractWidget = (AbstractWidget)list.get(n2);
            if (!abstractWidget.isFocused()) continue;
            n4 = n2;
        }
        if (n4 == -1) {
            ((AbstractWidget)list.get(list.size() - 1)).setFocused(true);
            n4 = list.size() - 1;
        }
        n2 = n4;
        if (n == 0) {
            for (int i2 = n4 + 1; i2 < n3; ++i2) {
                if (!((AbstractWidget)list.get(i2)).isVisible()) continue;
                n2 = i2;
                break;
            }
        } else {
            for (int i3 = n4 - 1; i3 >= 0; --i3) {
                if (!((AbstractWidget)list.get(i3)).isVisible()) continue;
                n2 = i3;
                break;
            }
        }
        if (n4 != n2) {
            ((AbstractWidget)list.get(n4)).setFocused(false);
            ((AbstractWidget)list.get(n2)).setFocused(true);
        }
    }

    public void setDoubleCursorMode(boolean bl) {
        this.doubleCursorMode = bl;
    }

    public void setDynamicLayout(boolean bl) {
        this.dynamicLayout = bl;
    }

    public void setButtonPositions(int[] nArray) {
        this.buttonPositions = nArray;
    }

    public void childrenChanged() {
        if (this.dynamicLayout) {
            List list = this.getChildren();
            int n = 0;
            for (int i2 = 0; i2 < list.size(); ++i2) {
                ButtonController buttonController = (ButtonController)list.get(i2);
                if (!buttonController.isVisible()) continue;
                if (this.buttonPositions == null || this.buttonPositions.length <= 2 * n + 1) {
                    logChannel.log(10000, "ButtonGroupController#childrenChanged not enough buttonPositions defined for %1 buttons", (long)list.size());
                    return;
                }
                int n2 = this.buttonPositions[2 * n];
                int n3 = this.buttonPositions[2 * n + 1];
                ++n;
                buttonController.setBounds(n2, n3, 100, 100);
            }
        }
    }

    @Override
    public void setVisible(boolean bl) {
        this.groupVisible = bl;
        List list = this.getChildren();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            ButtonController buttonController = (ButtonController)list.get(i2);
            buttonController.setOnScreen(bl);
        }
    }

    @Override
    public boolean isVisible() {
        return this.groupVisible;
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        this.checkModelValue();
        super.processModelUpdateEvent(modelUpdateEvent);
    }
}

