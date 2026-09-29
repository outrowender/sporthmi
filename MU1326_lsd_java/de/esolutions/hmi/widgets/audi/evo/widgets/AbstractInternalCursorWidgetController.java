/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.view.Screen;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.BaselineWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.ITextDescriptorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ITimeDateSetttingsRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import java.util.ArrayList;

public abstract class AbstractInternalCursorWidgetController
extends AbstractWidgetController
implements BaselineWidget,
ITextDescriptorController {
    protected int cursorPosition = -1;
    private MenuController menu;
    protected boolean dds_pressed = false;
    protected boolean cursorHidden = false;
    protected boolean isInEditableMode = false;

    protected static String appendOneLeadingZero(int n) {
        if (n < 10) {
            return "0";
        }
        return "";
    }

    protected static String appendTwoLeadingZeros(int n) {
        if (n < 10) {
            return "00";
        }
        if (n < 100) {
            return "0";
        }
        return "";
    }

    @Override
    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        if (this.menu == null) {
            this.menu = this.getMenuParent(this.getParent());
        }
    }

    protected void dimScreen(boolean bl) {
    }

    @Override
    public void disconnecting() {
        menuItemLogCh.log(-2137614336, "AbstractInternalCursorWidgetController#disconnecting %1, (%2)", (Object)this, (long)this.hashCode());
        this.cursorPosition = -1;
        if (this.isHighlighted()) {
            this.setHighlighted(false);
        }
        if (this.cursorHidden) {
            this.switchONParentMenuCursor();
        }
        this.isInEditableMode = false;
        super.disconnecting();
    }

    protected abstract void enterEditableMode() {
    }

    protected abstract void exitEditableMode() {
    }

    protected abstract void exitEditableModeWithoutSavings() {
    }

    @Override
    public int getBaseline() {
        return ((ITimeDateSetttingsRenderer)this.getRenderer()).getBaseline();
    }

    public int getCursorPos() {
        return this.cursorPosition;
    }

    public int getCursorIndex() {
        return this.getCursorPos();
    }

    public MenuController getMenu() {
        return this.menu;
    }

    public MenuController getMenuParent(AbstractWidget abstractWidget) {
        MenuController menuController = null;
        if (abstractWidget instanceof MenuController) {
            menuController = (MenuController)abstractWidget;
        } else {
            if (abstractWidget == null || abstractWidget instanceof Screen) {
                menuItemLogCh.log(10000, "AbstractInternalCursorWidgetController#getMenuParent not attached to a MenuController");
                return null;
            }
            menuController = this.getMenuParent(abstractWidget.getParent());
        }
        return menuController;
    }

    @Override
    public int getPreferredHeight() {
        ITimeDateSetttingsRenderer iTimeDateSetttingsRenderer = (ITimeDateSetttingsRenderer)this.getRenderer();
        if (iTimeDateSetttingsRenderer != null) {
            return iTimeDateSetttingsRenderer.getPreferredHeight();
        }
        return 0;
    }

    @Override
    public int getPreferredWidth() {
        ITimeDateSetttingsRenderer iTimeDateSetttingsRenderer = (ITimeDateSetttingsRenderer)this.getRenderer();
        if (iTimeDateSetttingsRenderer != null) {
            return iTimeDateSetttingsRenderer.getPreferredWidth();
        }
        return 0;
    }

    @Override
    public abstract IRenderer getRenderer() {
    }

    public abstract boolean isInEditableMode() {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        menuItemLogCh.log(-2137614336, "%1#keyPressed KeyCode = %2", (Object)this.getClassName(), (long)keyEvent.getKeyCode());
        if (keyEvent.getKeyCode() == 17) {
            if (this.isEnabled()) {
                this.dds_pressed = true;
                keyEvent.consume();
            }
        } else if (keyEvent.getKeyCode() == 15 && this.getCurrentVisState() == 3) {
            keyEvent.consume();
        }
    }

    @Override
    public abstract void keyReleased(KeyEvent keyEvent) {
    }

    @Override
    public final void keyTurned(WheelButtonEvent wheelButtonEvent) {
        int n = wheelButtonEvent.getClickCount();
        if (n == 0) {
            wheelButtonEvent.consume(false);
            return;
        }
        int n2 = wheelButtonEvent.getDirection();
        if (wheelButtonEvent.getKeyCode() == 20) {
            int n3 = n2 = wheelButtonEvent.getDirection() == 0 ? 1 : 0;
        }
        if (n2 == 1) {
            n *= -1;
        }
        WheelButtonEvent wheelButtonEvent2 = new WheelButtonEvent(wheelButtonEvent.getReceiver(), wheelButtonEvent.getID(), wheelButtonEvent.getWhen(), wheelButtonEvent.getKeyCode(), n2, n, wheelButtonEvent.getSubClickCount(), wheelButtonEvent.getTerminalID());
        this.keyTurned1(wheelButtonEvent2);
        if (wheelButtonEvent2.isConsumed()) {
            wheelButtonEvent.consume(wheelButtonEvent2.isRepaintNeeded());
        }
    }

    public abstract void keyTurned1(WheelButtonEvent wheelButtonEvent) {
    }

    @Override
    public abstract void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
    }

    public String getText(int n) {
        return this.getInitContext().getScreenFactory().getText(n);
    }

    @Override
    public void setEnabled(boolean bl) {
        if (!bl) {
            this.exitEditableModeWithoutSavings();
        }
        this.setCompositesDirty(true);
        super.setEnabled(bl);
    }

    public void setMenu(MenuController menuController) {
        this.menu = menuController;
    }

    protected void switchONParentMenuCursor() {
        if (this.menu != null) {
            if (!this.menu.isFocusCursorVisible()) {
                menuItemLogCh.log(-2137614336, "AbstractInternalCursorWidgetController#switchONParentMenuCursor");
                this.menu.setFocusCursorVisible(true, this.getCursorHideReason());
                this.menu.setCompositesDirty(true);
            }
            this.cursorHidden = false;
        }
    }

    protected void switchOFFParentMenuCursor() {
        if (this.menu != null) {
            if (this.menu.isFocusCursorVisible()) {
                menuItemLogCh.log(-2137614336, "AbstractInternalCursorWidgetController#switchOFFParentMenuCursor");
                this.menu.setFocusCursorVisible(false, this.getCursorHideReason());
                logRepaintCause.log(-2137614336, "AbstractInternalCursorWidgetController#switchOFFParentMenuCursor: trigger repaint. screen id: %1", (long)this.getScreenId());
                this.menu.triggerRepaint();
            }
            this.cursorHidden = true;
        }
    }

    private Object getCursorHideReason() {
        return this;
    }

    @Override
    public boolean hasBaseline() {
        return false;
    }

    protected static ArrayList permutate(ArrayList arrayList, int[] nArray) {
        int n = arrayList.size();
        if (n != nArray.length) {
            return arrayList;
        }
        ArrayList arrayList2 = (ArrayList)arrayList.clone();
        for (int i2 = 0; i2 < n; ++i2) {
            arrayList2.set(nArray[i2], arrayList.get(i2));
        }
        return arrayList2;
    }
}

