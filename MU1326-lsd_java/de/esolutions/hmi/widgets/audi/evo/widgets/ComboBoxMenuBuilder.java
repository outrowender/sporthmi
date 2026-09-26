/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.Layout;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.ExtHMITerminalEvo;
import de.esolutions.hmi.widgets.audi.evo.MenuItemBuilder;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.widgets.ComboBoxBackgroundController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ComboBoxController;
import de.esolutions.hmi.widgets.audi.evo.widgets.CursorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.CursorRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.FocusCursorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ScrollbarController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ScrollbarRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;

public class ComboBoxMenuBuilder {
    private static final int CLOSED_ICON_INDEX;
    private final ExtHMITerminalEvo terminal;

    public ComboBoxMenuBuilder(ExtHMITerminalEvo extHMITerminalEvo) {
        this.terminal = extHMITerminalEvo;
    }

    public void configureMenu(MenuController menuController, ComboBoxController comboBoxController, int[] nArray) {
        int n;
        MenuItemController menuItemController;
        int n2;
        LabelController[] labelControllerArray;
        menuController.setRenderer(this.terminal.getRendererFactory().createMenuRenderer(menuController));
        menuController.add(this.createFocusCursor(comboBoxController, nArray), 1);
        IconController iconController = null;
        if (comboBoxController.getType() == 0) {
            iconController = this.createC2Icon(comboBoxController);
            menuController.add(iconController, 11);
        }
        ScrollbarController scrollbarController = this.createScrollbar(comboBoxController);
        menuController.add(scrollbarController, 3);
        int[] nArray2 = comboBoxController.getTextIds();
        if (nArray2 != null) {
            for (int i2 = 0; i2 < nArray2.length; ++i2) {
                MenuItemController menuItemController2 = (MenuItemController)this.createComboItem(comboBoxController, nArray2[i2]);
                menuItemController2.setWidgetID(i2);
                menuController.add(menuItemController2);
            }
        }
        if ((labelControllerArray = comboBoxController.getLabelControllers()) != null) {
            int n3 = nArray2 == null ? 0 : nArray2.length;
            n2 = labelControllerArray.length;
            for (int i3 = 0; i3 < n2; ++i3) {
                menuItemController = (MenuItemController)this.createComboItem(comboBoxController, labelControllerArray[i3]);
                menuItemController.setWidgetID(i3);
                menuController.add(menuItemController);
                menuItemController.setLabelId(n3 + i3);
            }
        }
        comboBoxController.add(menuController);
        int n4 = 0;
        Object object = menuController.getChildren().iterator();
        while (object.hasNext()) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)object.next();
            if (!menuController.isMenuItem(abstractWidgetController)) continue;
            menuItemController = (MenuItemController)abstractWidgetController;
            menuItemController.setMarginBottom(0);
            menuItemController.setGlassplateInsetsTop(0);
            n = abstractWidgetController.getPreferredWidth();
            if (comboBoxController.getType() == 0) {
                GridLayout gridLayout = (GridLayout)menuItemController.getLayoutManager();
                n4 = Math.max(n4, (n -= gridLayout.getColumnConstraints().getGap(gridLayout.getColumnConstraints().getLength())) + ((AbstractWidgetController)iconController).getPreferredWidth());
                continue;
            }
            n4 = Math.max(n4, n);
        }
        object = ((HMITerminalImpl)((Object)this.terminal)).getLayout();
        n2 = 0;
        if (comboBoxController.getType() == 0) {
            int n5 = object.getIntegerConstant(33);
            n = object.getIntegerConstant(32);
            int n6 = object.getIntegerConstant(35);
            int n7 = object.getIntegerConstant(0);
            n2 = Math.max(n7, n4 += n5 + n + n6);
        } else {
            int n8 = object.getIntegerConstant(0);
            n2 = Math.max(n8, this.calculateMenuWidthForSubelement((Layout)object, n4));
        }
        menuController.setBounds(0, 0, n2, 20);
        menuController.getLayout().setBackgroundInsetsVert(5);
        menuController.getLayout().setItemsGap(2);
        menuController.getLayout().setContentLeftOffset(0);
        menuController.getLayout().setContentRightOffset(0);
        menuController.getInitialization().setPersistentLayout(false);
        scrollbarController.setBounds(menuController.getWidth() - (object.getIntegerConstant(20) + object.getIntegerConstant(21) + object.getIntegerConstant(19)), object.getIntegerConstant(22), object.getIntegerConstant(20), menuController.getHeight() - object.getIntegerConstant(22) + object.getIntegerConstant(23));
    }

    private IconController createC2Icon(ComboBoxController comboBoxController) {
        IconController iconController = new IconController();
        IconRenderer iconRenderer = this.terminal.getRendererFactory().createIconRenderer(iconController);
        iconController.setRenderer(iconRenderer);
        iconController.setBitmaps(new int[]{comboBoxController.getBitmap(43)});
        return iconController;
    }

    private CursorController createFocusCursor(ComboBoxController comboBoxController, int[] nArray) {
        FocusCursorController focusCursorController = new FocusCursorController();
        focusCursorController.setOptionsIconVisible(false);
        CursorRenderer cursorRenderer = this.terminal.getRendererFactory().createFocusCursorRenderer(focusCursorController);
        focusCursorController.setRenderer(cursorRenderer);
        if (nArray != null) {
            focusCursorController.setColorIndices(nArray);
        }
        return focusCursorController;
    }

    private ScrollbarController createScrollbar(ComboBoxController comboBoxController) {
        ScrollbarController scrollbarController = new ScrollbarController();
        ScrollbarRenderer scrollbarRenderer = this.terminal.getRendererFactory().createScrollbarRenderer(scrollbarController);
        scrollbarController.setRenderer(scrollbarRenderer);
        return scrollbarController;
    }

    private AbstractWidgetController createComboItem(ComboBoxController comboBoxController, int n) {
        MenuItemController menuItemController = new MenuItemController();
        menuItemController.setAutoLayoutSetup(false);
        menuItemController.setRenderer(this.terminal.getRendererFactory().createCompositeRenderer(menuItemController));
        menuItemController.setTextIds(new int[]{n});
        menuItemController.setType(1);
        menuItemController.setMarginBottom(0);
        menuItemController.setGlassplateInsetsTop(0);
        return menuItemController;
    }

    private AbstractWidgetController createComboItem(ComboBoxController comboBoxController, LabelController labelController) {
        MenuItemController menuItemController = new MenuItemController();
        menuItemController.setRenderer(this.terminal.getRendererFactory().createCompositeRenderer(menuItemController));
        menuItemController.setType(16);
        menuItemController.setMarginBottom(0);
        menuItemController.setGlassplateInsetsTop(0);
        labelController.setChainedAction(3, 17);
        menuItemController.add(labelController);
        menuItemController.setLayoutManager(MenuItemBuilder.createMenuItemLayout(null, labelController, null, null));
        menuItemController.setEnabled(labelController.isEnabled());
        return menuItemController;
    }

    public LabelController createPreviewLabel(ComboBoxController comboBoxController) {
        LabelController labelController = new LabelController();
        labelController.setRenderer(this.terminal.getRendererFactory().createLabelRenderer(labelController));
        labelController.setChainedAction(3, 17);
        comboBoxController.add(labelController);
        return labelController;
    }

    public IconController createClosedIcon(ComboBoxController comboBoxController) {
        IconController iconController = new IconController();
        iconController.setRenderer(this.terminal.getRendererFactory().createIconRenderer(iconController));
        int[] nArray = this.getSubArray(comboBoxController.getBitmapIndices(), 42, 1);
        if (nArray == null || nArray[0] == 0) {
            nArray = new int[]{39};
        }
        iconController.setBitmaps(nArray);
        iconController.setChainedAction(3, 17);
        iconController.setProcessStateChange(2);
        comboBoxController.add(iconController);
        return iconController;
    }

    public ComboBoxBackgroundController createComboBoxBackground(ComboBoxController comboBoxController) {
        ComboBoxBackgroundController comboBoxBackgroundController = new ComboBoxBackgroundController();
        comboBoxBackgroundController.setRenderer(this.terminal.getRendererFactory().createComboBoxBackgroundRenderer(comboBoxBackgroundController));
        comboBoxController.add(comboBoxBackgroundController);
        return comboBoxBackgroundController;
    }

    private int[] getSubArray(int[] nArray, int n, int n2) {
        if (nArray == null) {
            return null;
        }
        int[] nArray2 = new int[n2];
        if (nArray.length >= n + n2) {
            System.arraycopy((Object)nArray, n, (Object)nArray2, 0, n2);
        }
        return nArray2;
    }

    private int calculateMenuWidthForSubelement(Layout layout, int n) {
        int n2 = layout.getIntegerConstant(75);
        int n3 = layout.getIntegerConstant(74);
        if (n > n2 && n2 != -1) {
            n = n2;
        } else if (n < n3 && n2 != -1) {
            n = n3;
        }
        return n;
    }
}

