/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.modelaccess.ListModelGUI;
import de.audi.atip.hmi.modelaccess.RangeModelGUI;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.menu.MenuRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;

public class RouteBriefingDetailsButtonController
extends MenuItemController {
    private static final int HEIGHT;
    private static final int WIDTH;
    private IconController iconDetailsButton;
    private LabelController labelDetailsButton;
    private LabelController labelDetailsButtonNumbers;
    private static final int STEP;
    private boolean isSetUp = false;

    @Override
    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        if (!this.isSetUp) {
            this.setupWidgetsAndLayout();
            this.setPreferredHeight(38);
            this.setPreferredWidth(204);
            this.isSetUp = true;
        }
        this.updateContent();
    }

    private static IconController createIcon(int n, int n2, int n3, int n4) {
        IconController iconController = new IconController();
        IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
        iconController.setRenderer(iconRendererHigh);
        iconController.setBounds(n, n2, n3, n4);
        return iconController;
    }

    private static LabelController createLabel(int n, int n2, int n3, int n4, IWrappedFont iWrappedFont) {
        LabelController labelController = new LabelController();
        LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
        labelController.setRenderer(labelRendererHigh);
        labelRendererHigh.setFonts(new IWrappedFont[]{iWrappedFont});
        labelController.setBounds(n, n2, n3, n4);
        return labelController;
    }

    private void setupWidgetsAndLayout() {
        MenuController menuController = (MenuController)this.getParent();
        MenuRendererHigh menuRendererHigh = (MenuRendererHigh)menuController.getRenderer();
        IWrappedFont[] iWrappedFontArray = menuRendererHigh.getFonts();
        this.iconDetailsButton = RouteBriefingDetailsButtonController.createIcon(10, 5, 5, 10);
        this.iconDetailsButton.setBitmaps(this.getBitmapIndices());
        this.labelDetailsButton = RouteBriefingDetailsButtonController.createLabel(50, 14, 90, 90, iWrappedFontArray[0]);
        this.labelDetailsButton.setTextIds(this.getTextIds());
        this.labelDetailsButtonNumbers = RouteBriefingDetailsButtonController.createLabel(150, 19, 55, 90, iWrappedFontArray.length > 1 ? iWrappedFontArray[1] : iWrappedFontArray[0]);
        this.add(this.iconDetailsButton);
        this.add(this.labelDetailsButton);
        this.add(this.labelDetailsButtonNumbers);
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (this.model != null && this.hasState(36) && keyEvent.getKeyCode() == 17) {
            ((RangeModelGUI)this.model).increment(1, this.terminal.getTerminalID());
        }
        keyEvent.consume();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }

    @Override
    public void setFocused(boolean bl) {
        super.setFocused(bl);
        menuItemLogCh.log(-2137614336, "RouteBriefingDetailsButton#setFocused on index = %2. Focused = %1", bl, (long)0);
        if (bl && this.hasState(36)) {
            ((ListModelGUI)((Object)AbstractWidget.hmiService.getModel(1125910016))).itemFocused(2, 0, this.terminal.getTerminalID());
        }
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        mapOverlayLogCh.log(-2137614336, "RouteBriefingDetailsButton#ModelUpdateEvent %1", (Object)modelUpdateEvent);
        if (modelUpdateEvent.getUpdateType() == 1 || modelUpdateEvent.getUpdateType() == 4) {
            this.updateContent();
        }
    }

    private void updateContent() {
        if (this.model != null && this.model instanceof RangeModelGUI) {
            int n = ((RangeModelGUI)this.model).getValue();
            int n2 = ((RangeModelGUI)this.model).getMaximum();
            this.labelDetailsButtonNumbers.setText(new StringBuffer().append(n).append(" / ").append(n2).toString());
        } else {
            if (this.model == null) {
                mapOverlayLogCh.log(10000, "RouteBriefingDetailsButtonController#updateContent: model is null value");
            }
            mapOverlayLogCh.log(10000, "RouteBriefingDetailsButtonController#updateContent: model %1 is not instance of RangeModelGUI", this.model);
        }
    }
}

