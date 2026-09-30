/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.OptionModel;
import de.audi.atip.hmi.view.HMIView;
import de.audi.atip.hmi.view.IModelConnectService;
import de.audi.atip.hmi.view.Screen;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.Layout;
import de.esolutions.hmi.widgets.audi.base.LayoutManager;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.ButtonModelKeyHandler;
import de.esolutions.hmi.widgets.audi.evo.ChoiceModelKeyHandler;
import de.esolutions.hmi.widgets.audi.evo.CloseDrawerKeyHandler;
import de.esolutions.hmi.widgets.audi.evo.ExtHMITerminalEvo;
import de.esolutions.hmi.widgets.audi.evo.IWidgetKeyHandler;
import de.esolutions.hmi.widgets.audi.evo.OptionModelKeyHandler;
import de.esolutions.hmi.widgets.audi.evo.StateMachineKeyHandler;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AbstractGridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.IAxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.IGridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPartialPopupController;
import de.esolutions.hmi.widgets.audi.evo.widgets.CheckboxController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ComboBoxController;
import de.esolutions.hmi.widgets.audi.evo.widgets.CompositeRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.DateSettingsWidgetController;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.FormfieldInputController;
import de.esolutions.hmi.widgets.audi.evo.widgets.FormfieldInputRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.GeoPosSettingsController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ITimeDateSetttingsRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupStub;
import de.esolutions.hmi.widgets.audi.evo.widgets.RadioButtonController;
import de.esolutions.hmi.widgets.audi.evo.widgets.RotaryController;
import de.esolutions.hmi.widgets.audi.evo.widgets.RotaryRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.TimeSettingsWidgetController;
import de.esolutions.hmi.widgets.audi.evo.widgets.VisibilityProxyWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemColumnsConstraints;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MultiLineMenuItemController;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MenuItemBuilder
implements WidgetConstants {
    public static final int CHAIN_ALL_ACTIONS = 17;
    public static final int CHAIN_ALL_TRIGGER = 3;
    public static final int TABULATOR_ROW_END = 9;
    public static final int PRIMARY_BITMAP_INDEX = 0;
    public static final int RRB_RANGE_OVERLAY_BITMAP_IDX = 1;
    public static final int SECONDARY_BITMAP_INDEX = 4;

    public static void configureMenuItem(MenuItemController menuItemController, ExtHMITerminalEvo extHMITerminalEvo) {
        int n = menuItemController.getType();
        if (n == 1 || n == 32) {
            MenuItemBuilder.setupLabelMenuItem(menuItemController, extHMITerminalEvo);
        } else if (n == 8 || n == 9) {
            MenuItemBuilder.setupCheckboxMenuItem(menuItemController, extHMITerminalEvo);
        } else if (n == 2 || n == 3) {
            MenuItemBuilder.setupActionMenuItem(menuItemController, extHMITerminalEvo);
        } else if (n == 4 || n == 5) {
            MenuItemBuilder.setupSubmenuMenuItem(menuItemController, extHMITerminalEvo);
        } else if (n == 128 || n == 129) {
            MenuItemBuilder.setupRotaryMenuItem(menuItemController, extHMITerminalEvo);
        } else if (n == 64) {
            MenuItemBuilder.setupComboBoxMenuItem(menuItemController, extHMITerminalEvo);
        } else if (n == 256 || n == 257) {
            MenuItemBuilder.setupRadioButtonMenuItem(menuItemController, extHMITerminalEvo);
        } else if (n == 512 || n == 513) {
            MenuItemBuilder.setupSubmenuPreviewMenuItem(menuItemController, extHMITerminalEvo);
        } else if (n == 1024) {
            MenuItemBuilder.setupTimeSettingsWidget(menuItemController, extHMITerminalEvo);
        } else if (n == 1025) {
            MenuItemBuilder.setupDateSettingsWidget(menuItemController, extHMITerminalEvo, -1);
        } else if (n == 0x4010001) {
            MenuItemBuilder.setupDateSettingsWidget(menuItemController, extHMITerminalEvo, 1);
        } else if (n == 4198402) {
            MenuItemBuilder.setupDateSettingsWidget(menuItemController, extHMITerminalEvo, 2);
        } else if (n == 1026) {
            MenuItemBuilder.setupAuxHeaterProgrammingWidget(menuItemController, extHMITerminalEvo);
        } else if (n == 4206593) {
            MenuItemBuilder.setupGeoCoordinateSettingsWidget(menuItemController, extHMITerminalEvo, false);
        } else if (n == 4206594) {
            MenuItemBuilder.setupGeoCoordinateSettingsWidget(menuItemController, extHMITerminalEvo, true);
        } else if (n == 1028) {
            MenuItemBuilder.setupRouteBriefingMenuItem(menuItemController, extHMITerminalEvo);
        } else if (n == 1030) {
            MenuItemBuilder.setupRouteBriefingMenuItem(menuItemController, extHMITerminalEvo);
        } else if (n == 768) {
            MenuItemBuilder.setupFormfieldInputWidget(menuItemController, extHMITerminalEvo);
        } else if (n == 1027) {
            MenuItemBuilder.setupSDSCommandWidget(menuItemController, extHMITerminalEvo);
        } else if (n == 1029) {
            MenuItemBuilder.setupSDSBulletLabel(menuItemController, extHMITerminalEvo);
        }
        if (n != 16) {
            menuItemController.setRealType(n);
        }
        menuItemController.setType(16);
    }

    private static boolean isMultiline(int n) {
        return n == 3 || n == 32 || n == 9 || n == 257 || n == 129 || n == 5 || n == 1029;
    }

    private static void setupLabelMenuItem(MenuItemController menuItemController, ExtHMITerminalEvo extHMITerminalEvo) {
        LabelController labelController = MenuItemBuilder.createLeftLabel(menuItemController, extHMITerminalEvo);
        if (menuItemController.getModelID() != -1) {
            labelController.setModelID(menuItemController.getModelID());
            labelController.setModel(menuItemController.getModel());
            MenuItemBuilder.setupScreenViews(menuItemController.getInitContext().getScreen(), labelController, menuItemController.getModelID());
        }
        menuItemController.add(labelController);
        IconController iconController = MenuItemBuilder.createAndAddIcon(menuItemController, extHMITerminalEvo, 0);
        menuItemController.setLayoutManager(MenuItemBuilder.createMenuItemLayout(iconController, labelController, null, extHMITerminalEvo));
    }

    private static void setupLabelMultiLineMenuItem(MultiLineMenuItemController multiLineMenuItemController, ExtHMITerminalEvo extHMITerminalEvo) {
        LabelController labelController = new LabelController();
        labelController.setRenderer(extHMITerminalEvo.getRendererFactory().createMultiLineLabelRenderer(labelController, multiLineMenuItemController.getAutoWrap()));
        labelController.setTextIds(new int[]{multiLineMenuItemController.getLabelId()});
        labelController.setReplacementModelIds(multiLineMenuItemController.getReplacementModelIds());
        MenuItemBuilder.setupScreenTextReplacement(multiLineMenuItemController.getInitContext().getScreen(), labelController, multiLineMenuItemController.getReplacementModelIds());
        labelController.setChainedAction(3, 17);
        if (multiLineMenuItemController.getModelID() != -1) {
            labelController.setModelID(multiLineMenuItemController.getModelID());
            labelController.setModel(multiLineMenuItemController.getModel());
            MenuItemBuilder.setupScreenViews(multiLineMenuItemController.getInitContext().getScreen(), labelController, multiLineMenuItemController.getModelID());
        }
        multiLineMenuItemController.setLabel(labelController);
    }

    private static void setupCheckboxMenuItem(MenuItemController menuItemController, ExtHMITerminalEvo extHMITerminalEvo) {
        LabelController labelController = MenuItemBuilder.createLeftLabel(menuItemController, extHMITerminalEvo);
        menuItemController.add(labelController);
        IconController iconController = MenuItemBuilder.createAndAddIcon(menuItemController, extHMITerminalEvo, 0);
        CheckboxController checkboxController = new CheckboxController();
        checkboxController.setRenderer(extHMITerminalEvo.getRendererFactory().createCheckboxRenderer(checkboxController));
        checkboxController.setModelID(menuItemController.getModelID());
        checkboxController.setModel(menuItemController.getModel());
        checkboxController.setChainedAction(3, 17);
        MenuItemBuilder.setupScreenViews(menuItemController.getInitContext().getScreen(), checkboxController, menuItemController.getModelID());
        menuItemController.add(checkboxController);
        checkboxController.setMapping(menuItemController.getMapping());
        menuItemController.setLayoutManager(MenuItemBuilder.createMenuItemLayout(iconController, labelController, checkboxController, null));
    }

    private static void setupRadioButtonMenuItem(MenuItemController menuItemController, ExtHMITerminalEvo extHMITerminalEvo) {
        LabelController labelController = MenuItemBuilder.createLeftLabel(menuItemController, extHMITerminalEvo);
        menuItemController.add(labelController);
        IconController iconController = MenuItemBuilder.createAndAddIcon(menuItemController, extHMITerminalEvo, 0);
        RadioButtonController radioButtonController = new RadioButtonController();
        radioButtonController.setRenderer(extHMITerminalEvo.getRendererFactory().createRadioButtonRenderer(radioButtonController));
        radioButtonController.setModelID(menuItemController.getModelID());
        radioButtonController.setModel(menuItemController.getModel());
        radioButtonController.setChainedAction(3, 17);
        radioButtonController.setWidgetID(menuItemController.getWidgetID());
        MenuItemBuilder.setupScreenViews(menuItemController.getInitContext().getScreen(), radioButtonController, menuItemController.getModelID());
        menuItemController.add(radioButtonController);
        menuItemController.setLayoutManager(MenuItemBuilder.createMenuItemLayout(iconController, labelController, radioButtonController, null));
        if (menuItemController.hasBitmap(1)) {
            radioButtonController.setBitmaps(new int[]{menuItemController.getBitmap(1)});
        }
        MenuItemBuilder.configureKeyHandler(menuItemController);
    }

    private static void setupScreenViews(Screen screen, AbstractWidgetController abstractWidgetController, int n) {
        Object object;
        HMIView[][] hMIViewArray;
        if (screen instanceof PartialPopupStub && (hMIViewArray = ((PartialPopupStub)(object = (PartialPopupStub)screen)).getSkeleton()) instanceof Screen) {
            screen = (Screen)hMIViewArray;
        }
        if ((object = (Object)screen.getViewIDs()) == null) {
            return;
        }
        if (n <= 0) {
            IWidgetLogChannel.menuItemLogCh.log(100000, "MenuItemBuilder#setupScreenViews: menu item has no model. Item Widget: %1, ModelID: %2, ", (Object)abstractWidgetController, (long)n);
            return;
        }
        hMIViewArray = new HMIView[((Object)object).length][];
        for (int i2 = 0; i2 < ((Object)object).length; ++i2) {
            Object object2 = object[i2];
            HMIView[] hMIViewArray2 = screen instanceof AbstractScreenWidget ? ((AbstractScreenWidget)screen).findViews((int)object2) : (screen instanceof DrawerController ? ((DrawerController)screen).findViews((int)object2) : ((AbstractPartialPopupController)screen).findViews((int)object2));
            if (hMIViewArray2 == null) {
                hMIViewArray2 = new HMIView[]{};
            }
            if (object2 == n) {
                HMIView[] hMIViewArray3 = new HMIView[hMIViewArray2.length + 1];
                System.arraycopy((Object)hMIViewArray2, 0, (Object)hMIViewArray3, 0, hMIViewArray2.length);
                hMIViewArray3[hMIViewArray3.length - 1] = abstractWidgetController;
                hMIViewArray2 = hMIViewArray3;
            }
            hMIViewArray[i2] = hMIViewArray2;
        }
        screen.setViews((int[])object, hMIViewArray);
        IModelConnectService iModelConnectService = AbstractWidget.hmiService.getModelConnectService(screen.getTerminalID());
        iModelConnectService.modifiyModelReference(new HMIView[]{abstractWidgetController}, null, null, true, false);
    }

    private static void setupScreenTextReplacement(Screen screen, AbstractWidgetController abstractWidgetController, int[] nArray) {
        int[] nArray2 = screen.getReplacementIDs();
        HMIView[][] hMIViewArray = screen.getReplacementWidgets();
        if (nArray2 == null || nArray == null || hMIViewArray == null) {
            return;
        }
        block0: for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n = nArray[i2];
            for (int i3 = 0; i3 < nArray2.length; ++i3) {
                if (n != nArray2[i3]) continue;
                HMIView[] hMIViewArray2 = new HMIView[hMIViewArray[i3].length + 1];
                System.arraycopy((Object)hMIViewArray[i3], 0, (Object)hMIViewArray2, 0, hMIViewArray[i3].length);
                hMIViewArray2[hMIViewArray2.length - 1] = abstractWidgetController;
                hMIViewArray[i3] = hMIViewArray2;
                continue block0;
            }
        }
        screen.setReplacementWidgets(nArray2, hMIViewArray);
        IModelConnectService iModelConnectService = AbstractWidget.hmiService.getModelConnectService(screen.getTerminalID());
        iModelConnectService.modifiyModelReference(null, null, nArray, true, false);
    }

    private static void setupSubmenuMenuItem(MenuItemController menuItemController, ExtHMITerminalEvo extHMITerminalEvo) {
        LabelController labelController = MenuItemBuilder.createLeftLabel(menuItemController, extHMITerminalEvo);
        menuItemController.add(labelController);
        IconController iconController = MenuItemBuilder.createAndAddIcon(menuItemController, extHMITerminalEvo, 4);
        menuItemController.setLayoutManager(MenuItemBuilder.createMenuItemLayout(iconController, labelController, null, null));
        MenuItemBuilder.configureKeyHandler(menuItemController);
    }

    private static void setupSubmenuPreviewMenuItem(MenuItemController menuItemController, ExtHMITerminalEvo extHMITerminalEvo) {
        WidgetConstants widgetConstants;
        WidgetConstants widgetConstants2;
        int n;
        int n2;
        WidgetConstants widgetConstants3;
        Object object;
        Object object2;
        AbstractWidgetController abstractWidgetController;
        Layout layout = ((HMITerminalImpl)((Object)extHMITerminalEvo)).getLayout();
        LabelController labelController = MenuItemBuilder.createLeftLabel(menuItemController, extHMITerminalEvo);
        menuItemController.add(labelController);
        Object object3 = null;
        Iterator iterator = menuItemController.getChildren().iterator();
        while (iterator.hasNext()) {
            abstractWidgetController = (AbstractWidgetController)iterator.next();
            if (abstractWidgetController.getRole() != 0x800000) continue;
            object3 = abstractWidgetController;
            break;
        }
        if (object3 == null) {
            abstractWidgetController = new LabelController();
            ((LabelController)abstractWidgetController).setRenderer(extHMITerminalEvo.getRendererFactory().createLabelRenderer((LabelController)abstractWidgetController));
            abstractWidgetController.setChainedAction(3, 17);
            if (menuItemController.getModelID() != -1) {
                abstractWidgetController.setModelID(menuItemController.getModelID());
                abstractWidgetController.setModel(menuItemController.getModel());
                MenuItemBuilder.setupScreenViews(menuItemController.getInitContext().getScreen(), abstractWidgetController, menuItemController.getModelID());
            }
            if (menuItemController.getLabelId() != -1) {
                ((LabelController)abstractWidgetController).setTextIds(menuItemController.getTextIds());
                ((LabelController)abstractWidgetController).setReplacementModelIds(menuItemController.getReplacementModelIds());
                ((LabelController)abstractWidgetController).setReplacementTextIds(menuItemController.getReplacementTextIds());
                ((LabelController)abstractWidgetController).setTextOrientationHints(menuItemController.getTextOrientationHints());
                MenuItemBuilder.setupScreenTextReplacement(menuItemController.getInitContext().getScreen(), abstractWidgetController, menuItemController.getReplacementModelIds());
            }
            object2 = new LayoutContainerController();
            object = extHMITerminalEvo.getRendererFactory().createCompositeRenderer((AbstractWidgetController)object2);
            ((LayoutContainerController)object2).setRenderer((CompositeRenderer)object);
            ((LayoutContainerController)object2).add(abstractWidgetController);
            widgetConstants3 = new GridLayout(1, 1);
            n2 = layout.getDistance(213);
            n = 0;
            widgetConstants2 = (AxisConstraints)((AbstractGridLayout)widgetConstants3).getColumnConstraints();
            ((AxisConstraints)widgetConstants2).gaps = new int[]{n2, n};
            ((AxisConstraints)widgetConstants2).grow = new float[]{1.0f};
            if (menuItemController.getModelID() == 5549) {
                ((AxisConstraints)widgetConstants2).alignment = new int[]{3};
            }
            widgetConstants = new GridLayoutHints(0, 0);
            ((GridLayout)widgetConstants3).setWidgetConstraints(new GridLayoutHints[]{widgetConstants}, new AbstractWidgetController[]{abstractWidgetController});
            ((LayoutContainerController)object2).setLayoutManager((LayoutManager)((Object)widgetConstants3));
            menuItemController.add((AbstractWidget)object2);
            object3 = object2;
        }
        abstractWidgetController = new FormfieldInputController();
        object2 = extHMITerminalEvo.getRendererFactory().createFormfieldInputRenderer((FormfieldInputController)abstractWidgetController, true, false);
        ((FormfieldInputController)abstractWidgetController).setRenderer((FormfieldInputRenderer)object2);
        object2.setUseControllerHeight(false);
        object = new GridLayoutHints(1, 0);
        ((GridLayoutHints)object).alignmentVert = 9;
        ((GridLayoutHints)object).ignoreForCellSizes = true;
        ((GridLayoutHints)object).overlapGaps = 8;
        widgetConstants3 = MenuItemBuilder.createAndAddIcon(menuItemController, extHMITerminalEvo, 0);
        if (widgetConstants3 == null) {
            widgetConstants3 = new IconController();
        }
        n2 = layout.getIntegerConstant(70);
        n = layout.getIntegerConstant(68);
        widgetConstants2 = new GridLayout();
        widgetConstants = new AxisConstraints(1);
        MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(2);
        menuItemColumnsConstraints.grow = new float[]{1.0f, 0.0f};
        menuItemColumnsConstraints.gaps = new int[]{0, n2, 0};
        menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f};
        menuItemColumnsConstraints.min = new int[]{0, n};
        menuItemColumnsConstraints.max = new int[]{-1, -1};
        menuItemColumnsConstraints.setTabulatorIDs(new int[]{1, 3, 9});
        ((AbstractGridLayout)widgetConstants2).setColumnConstraints(menuItemColumnsConstraints);
        ((AbstractGridLayout)widgetConstants2).setRowConstraints((IAxisConstraints)widgetConstants);
        ((GridLayout)widgetConstants2).setWidgetConstraints(new GridLayoutHints[]{new GridLayoutHints(0, 0), new GridLayoutHints(1, 0), object}, new AbstractWidgetController[]{labelController, object3, abstractWidgetController});
        menuItemController.setLayoutManager((LayoutManager)((Object)widgetConstants2));
        menuItemController.addWithPosition(abstractWidgetController, 0);
        LayoutContainerController.autoLayoutSetup((GridLayout)widgetConstants2);
        MenuItemBuilder.configureKeyHandler(menuItemController);
    }

    private static void setupRotaryMenuItem(MenuItemController menuItemController, ExtHMITerminalEvo extHMITerminalEvo) {
        LabelController labelController = MenuItemBuilder.createLeftLabel(menuItemController, extHMITerminalEvo);
        RotaryController rotaryController = new RotaryController();
        RotaryRenderer rotaryRenderer = extHMITerminalEvo.getRendererFactory().createRotaryRenderer(rotaryController);
        rotaryController.setRenderer(rotaryRenderer);
        rotaryController.setModelID(menuItemController.getModelID());
        rotaryController.setModel(menuItemController.getModel());
        rotaryController.setPreferredWidth(rotaryRenderer.getPreferredWidth((HMITerminalImpl)((Object)extHMITerminalEvo)));
        rotaryController.setPreferredHeight(rotaryRenderer.getPreferredHeight((HMITerminalImpl)((Object)extHMITerminalEvo)));
        rotaryController.setActive(false);
        rotaryController.setChainedAction(3, 17);
        MenuItemBuilder.setupScreenViews(menuItemController.getInitContext().getScreen(), rotaryController, menuItemController.getModelID());
        menuItemController.add(labelController);
        menuItemController.add(rotaryController);
        menuItemController.setLayoutManager(MenuItemBuilder.createMenuItemLayout(null, labelController, rotaryController, null));
        MenuItemBuilder.configureKeyHandler(menuItemController);
    }

    private static void setupActionMenuItem(MenuItemController menuItemController, ExtHMITerminalEvo extHMITerminalEvo) {
        LabelController labelController = MenuItemBuilder.createLeftLabel(menuItemController, extHMITerminalEvo);
        menuItemController.add(labelController);
        IconController iconController = null;
        IconController iconController2 = null;
        if (menuItemController.getRenderer() != null) {
            iconController = MenuItemBuilder.createAndAddIcon(menuItemController, extHMITerminalEvo, 0);
            iconController2 = MenuItemBuilder.createAndAddIcon(menuItemController, extHMITerminalEvo, 4);
        }
        menuItemController.setLayoutManager(MenuItemBuilder.createMenuItemLayout(iconController2, labelController, iconController, null));
        MenuItemBuilder.configureKeyHandler(menuItemController);
        IWidgetKeyHandler iWidgetKeyHandler = menuItemController.getKeyHandler();
        if (iWidgetKeyHandler == null) {
            menuItemController.setKeyHandler(MenuItemBuilder.createAutomaticallyReplacingKeyHandlerWhenModelIsAvailable(menuItemController));
        } else {
            menuItemController.setKeyHandler(MenuItemBuilder.createDrawerClosingKeyHandler(iWidgetKeyHandler, false));
        }
    }

    private static CloseDrawerKeyHandler createDrawerClosingKeyHandler(IWidgetKeyHandler iWidgetKeyHandler, boolean bl) {
        return new CloseDrawerKeyHandler(iWidgetKeyHandler, bl);
    }

    private static IWidgetKeyHandler createAutomaticallyReplacingKeyHandlerWhenModelIsAvailable(final MenuItemController menuItemController) {
        final CloseDrawerKeyHandler closeDrawerKeyHandler = MenuItemBuilder.createDrawerClosingKeyHandler(null, true);
        IWidgetKeyHandler iWidgetKeyHandler = new IWidgetKeyHandler(){

            public void keyTurned(AbstractWidgetController abstractWidgetController, WheelButtonEvent wheelButtonEvent) {
                this.replaceKeyHandler().keyTurned(abstractWidgetController, wheelButtonEvent);
            }

            public void keyReleased(AbstractWidgetController abstractWidgetController, KeyEvent keyEvent) {
                this.replaceKeyHandler().keyReleased(abstractWidgetController, keyEvent);
            }

            public void keyPressed(AbstractWidgetController abstractWidgetController, KeyEvent keyEvent) {
                this.replaceKeyHandler().keyPressed(abstractWidgetController, keyEvent);
            }

            public void keyMoved(AbstractWidgetController abstractWidgetController, JoystickEvent joystickEvent) {
                this.replaceKeyHandler().keyMoved(abstractWidgetController, joystickEvent);
            }

            private IWidgetKeyHandler replaceKeyHandler() {
                IWidgetKeyHandler iWidgetKeyHandler = menuItemController.getKeyHandler();
                menuItemController.setKeyHandler(null);
                MenuItemBuilder.configureKeyHandler(menuItemController);
                IWidgetKeyHandler iWidgetKeyHandler2 = menuItemController.getKeyHandler();
                if (iWidgetKeyHandler2 == null) {
                    menuItemController.setKeyHandler(iWidgetKeyHandler);
                    return closeDrawerKeyHandler;
                }
                IWidgetLogChannel.logDrawerFocus.log(1000000, "MenuItemBuilder#createAutomaticallyReplacingKeyHandlerWhenModelIsAvailable#replaceKeyHandler replacing keyhandler in %1", (Object)menuItemController);
                CloseDrawerKeyHandler closeDrawerKeyHandler2 = MenuItemBuilder.createDrawerClosingKeyHandler(iWidgetKeyHandler2, false);
                menuItemController.setKeyHandler(closeDrawerKeyHandler2);
                closeDrawerKeyHandler2.setCloseOptionDrawerAfterScreenConnected(menuItemController.getCloseOptionDrawerAfterScreenConnected());
                return closeDrawerKeyHandler2;
            }
        };
        return iWidgetKeyHandler;
    }

    public static void configureKeyHandler(MenuItemController menuItemController) {
        if (menuItemController.getKeyHandler() != null) {
            return;
        }
        Object object = menuItemController.getModel();
        if (object == null) {
            if (menuItemController.getModelID() == -1) {
                menuItemController.setKeyHandler(StateMachineKeyHandler.STATE_MACHINE_HANDLER_INSTANCE);
            }
        } else if (object instanceof ChoiceModel && menuItemController.getWidgetID() != -1) {
            menuItemController.setKeyHandler(ChoiceModelKeyHandler.CHOICE_MODEL_HANDLER_INSTANCE);
        } else if (object instanceof OptionModel) {
            menuItemController.setKeyHandler(OptionModelKeyHandler.OPTION_MODEL_KEY_HANDLER_INSTANCE);
        } else {
            menuItemController.setKeyHandler(ButtonModelKeyHandler.BUTTON_MODEL_KEY_HANDLER_INSTANCE);
        }
    }

    private static LabelController createLeftLabel(MenuItemController menuItemController, ExtHMITerminalEvo extHMITerminalEvo) {
        LabelController labelController = new LabelController();
        if (MenuItemBuilder.isMultiline(menuItemController.getType())) {
            labelController.setRenderer(extHMITerminalEvo.getRendererFactory().createMultiLineLabelRenderer(labelController, menuItemController.getAutoWrap()));
        } else {
            labelController.setRenderer(extHMITerminalEvo.getRendererFactory().createLabelRenderer(labelController));
        }
        labelController.setTextIds(MenuItemBuilder.getLabelIdOrContentIds(menuItemController));
        labelController.setReplacementModelIds(menuItemController.getReplacementModelIds());
        labelController.setReplacementTextIds(menuItemController.getReplacementTextIds());
        labelController.setTextOrientationHints(menuItemController.getTextOrientationHints());
        MenuItemBuilder.setupScreenTextReplacement(menuItemController.getInitContext().getScreen(), labelController, menuItemController.getReplacementModelIds());
        labelController.setChainedAction(3, 17);
        return labelController;
    }

    private static IconController createAndAddIcon(MenuItemController menuItemController, ExtHMITerminalEvo extHMITerminalEvo, int n) {
        if (menuItemController.hasBitmap(n)) {
            IconController iconController = MenuItemBuilder.createIcon(menuItemController, extHMITerminalEvo, n);
            menuItemController.add(iconController);
            return iconController;
        }
        return null;
    }

    private static IconController createIcon(MenuItemController menuItemController, ExtHMITerminalEvo extHMITerminalEvo, int n) {
        IconController iconController = new IconController();
        iconController.setRenderer(extHMITerminalEvo.getRendererFactory().createIconRenderer(iconController));
        int[] nArray = menuItemController.getBitmapIndices();
        if (n == 0) {
            iconController.setBitmaps(nArray);
        } else {
            int[] nArray2 = new int[4];
            int n2 = Math.min(nArray2.length, nArray.length - n);
            if (n2 > 0) {
                System.arraycopy((Object)nArray, n, (Object)nArray2, 0, n2);
            }
            for (int i2 = n2; i2 < nArray2.length; ++i2) {
                nArray2[i2] = -1;
            }
            iconController.setBitmaps(nArray2);
        }
        iconController.setChainedAction(3, 17);
        iconController.setProcessStateChange(2);
        return iconController;
    }

    private static int[] getLabelIdOrContentIds(MenuItemController menuItemController) {
        int n = menuItemController.getLabelId();
        if (n != -1) {
            return new int[]{n};
        }
        return menuItemController.getTextIds();
    }

    private static void setupComboBoxMenuItem(MenuItemController menuItemController, ExtHMITerminalEvo extHMITerminalEvo) {
        Boolean bl;
        Integer n;
        Map.Entry entry;
        Iterator iterator;
        LabelController labelController = new LabelController();
        labelController.setRenderer(extHMITerminalEvo.getRendererFactory().createLabelRenderer(labelController));
        labelController.setTextIds(new int[]{menuItemController.getLabelId()});
        labelController.setChainedAction(3, 17);
        ComboBoxController comboBoxController = new ComboBoxController();
        comboBoxController.setRenderer(extHMITerminalEvo.getRendererFactory().createComboRenderer(comboBoxController, menuItemController.getRenderer()));
        comboBoxController.setTextIds(menuItemController.getTextIds());
        comboBoxController.setModelID(menuItemController.getModelID());
        comboBoxController.setModel(menuItemController.getModel());
        comboBoxController.setChainedAction(3, 17);
        comboBoxController.setBitmaps(menuItemController.getBitmapIndices());
        comboBoxController.setMapping(menuItemController.getMapping());
        menuItemController.addContentEnabledListener(comboBoxController);
        MenuItemBuilder.setupScreenViews(menuItemController.getInitContext().getScreen(), comboBoxController, menuItemController.getModelID());
        MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(2);
        menuItemColumnsConstraints.grow = new float[]{1.0f, 0.0f};
        menuItemColumnsConstraints.shrink = new float[]{1.0f, 0.0f};
        menuItemColumnsConstraints.gaps = new int[]{0, ((HMITerminalImpl)((Object)extHMITerminalEvo)).getLayout().getIntegerConstant(24), 0};
        menuItemColumnsConstraints.tabulatorIDs = new int[]{-1, 3, 9};
        AxisConstraints axisConstraints = new AxisConstraints(1);
        axisConstraints.alignment = new int[]{7};
        GridLayout gridLayout = new GridLayout();
        gridLayout.setColumnConstraints(menuItemColumnsConstraints);
        gridLayout.setRowConstraints(axisConstraints);
        gridLayout.setWidgetConstraints(new GridLayoutHints[]{new GridLayoutHints(0, 0), new GridLayoutHints(1, 0)}, new AbstractWidgetController[]{labelController, comboBoxController});
        menuItemController.add(labelController);
        menuItemController.add(comboBoxController);
        if (menuItemController.itemPreCreatedEnableState != null) {
            iterator = menuItemController.itemPreCreatedEnableState.entrySet().iterator();
            while (iterator.hasNext()) {
                entry = (Map.Entry)iterator.next();
                n = (Integer)entry.getKey();
                bl = (Boolean)entry.getValue();
                comboBoxController.setContentEnabled(n, bl);
            }
            menuItemController.itemPreCreatedEnableState.clear();
            menuItemController.itemPreCreatedEnableState = null;
        }
        if (menuItemController.itemPreCreatedVisibility != null) {
            iterator = menuItemController.itemPreCreatedVisibility.entrySet().iterator();
            while (iterator.hasNext()) {
                entry = (Map.Entry)iterator.next();
                n = (Integer)entry.getKey();
                bl = (Boolean)entry.getValue();
                comboBoxController.setContentVisible(n, bl);
            }
            menuItemController.itemPreCreatedVisibility.clear();
            menuItemController.itemPreCreatedVisibility = null;
        }
        menuItemController.setLayoutManager(gridLayout);
        LayoutContainerController.autoLayoutSetup(gridLayout);
    }

    public static LayoutManager createMenuItemLayout(AbstractWidgetController abstractWidgetController, AbstractWidgetController abstractWidgetController2, AbstractWidgetController abstractWidgetController3, ExtHMITerminalEvo extHMITerminalEvo) {
        IGridLayoutHints[] iGridLayoutHintsArray;
        MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(3);
        menuItemColumnsConstraints.grow = new float[]{0.0f, 1.0f, 0.0f};
        menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f, 0.0f};
        menuItemColumnsConstraints.alignment = new int[]{1, 8, 8};
        menuItemColumnsConstraints.gaps = AbstractWidget.framework.getScreenRes() == 0 ? new int[]{0, 5, 12, 0} : new int[]{0, 5, 22, 0};
        menuItemColumnsConstraints.hidemode = new int[]{2, 2, 2};
        AxisConstraints axisConstraints = new AxisConstraints(1);
        axisConstraints.alignment = new int[]{5};
        GridLayout gridLayout = new GridLayout();
        gridLayout.setColumnConstraints(menuItemColumnsConstraints);
        gridLayout.setRowConstraints(axisConstraints);
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        if (abstractWidgetController != null) {
            arrayList.add(abstractWidgetController);
            iGridLayoutHintsArray = new GridLayoutHints(0, 0);
            if (extHMITerminalEvo != null) {
                iGridLayoutHintsArray.setHeightMax(extHMITerminalEvo.getRendererFactory().getUppercaseFontHeight(abstractWidgetController.getRenderer(), 0));
            }
            arrayList2.add(iGridLayoutHintsArray);
        }
        if (abstractWidgetController2 != null) {
            arrayList.add(abstractWidgetController2);
            arrayList2.add(new GridLayoutHints(1, 0));
        }
        if (abstractWidgetController3 != null) {
            arrayList.add(abstractWidgetController3);
            arrayList2.add(new GridLayoutHints(2, 0));
        }
        iGridLayoutHintsArray = (GridLayoutHints[])arrayList2.toArray(new GridLayoutHints[arrayList2.size()]);
        gridLayout.setCellConstraints(iGridLayoutHintsArray, arrayList.toArray());
        LayoutContainerController.autoLayoutSetup(gridLayout);
        return gridLayout;
    }

    public static void configureChaining(MenuItemController menuItemController) {
        for (int i2 = 0; i2 < menuItemController.getChildrenSize(); ++i2) {
            AbstractWidget abstractWidget = menuItemController.getChild(i2);
            if (abstractWidget instanceof VisibilityProxyWidget) continue;
            ((AbstractWidgetController)abstractWidget).setChainedAction(3, 17);
        }
    }

    private static void setupTimeSettingsWidget(MenuItemController menuItemController, ExtHMITerminalEvo extHMITerminalEvo) {
        WidgetConstants widgetConstants;
        LabelController labelController = new LabelController();
        labelController.setRenderer(extHMITerminalEvo.getRendererFactory().createLabelRenderer(labelController));
        labelController.setTextIds(new int[]{menuItemController.getLabelId()});
        labelController.setChainedAction(3, 17);
        MenuController menuController = (MenuController)menuItemController.getParent();
        IRenderer iRenderer = menuItemController.getRenderer();
        int n = menuItemController.getModelID();
        Object object = menuItemController.getModel();
        int[] nArray = menuItemController.getTextIds();
        int[] nArray2 = menuItemController.getBitmapIndices();
        TimeSettingsWidgetController timeSettingsWidgetController = new TimeSettingsWidgetController();
        ITimeDateSetttingsRenderer iTimeDateSetttingsRenderer = extHMITerminalEvo.getRendererFactory().createInternalCursorWidgetRenderer(timeSettingsWidgetController, iRenderer, null);
        timeSettingsWidgetController.setRenderer(iTimeDateSetttingsRenderer);
        timeSettingsWidgetController.setMenu(menuController);
        timeSettingsWidgetController.setModelID(n);
        timeSettingsWidgetController.setModel(object);
        timeSettingsWidgetController.setTextIds(nArray);
        timeSettingsWidgetController.setChainedAction(3, 17);
        timeSettingsWidgetController.setBitmaps(nArray2);
        MenuItemBuilder.setupScreenViews(menuItemController.getInitContext().getScreen(), timeSettingsWidgetController, menuItemController.getModelID());
        IconController iconController = null;
        List list = menuItemController.getChildren();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            widgetConstants = (AbstractWidget)list.get(i2);
            if (!(widgetConstants instanceof IconController)) continue;
            iconController = (IconController)widgetConstants;
            break;
        }
        widgetConstants = new GridLayout(3, 1);
        AxisConstraints axisConstraints = (AxisConstraints)((AbstractGridLayout)widgetConstants).getColumnConstraints();
        axisConstraints.grow = new float[]{1.0f, 0.0f, 0.0f};
        axisConstraints.shrink = new float[]{1.0f, 0.0f, 0.0f};
        axisConstraints.gaps = new int[]{0, 0, 10, 0};
        axisConstraints.tabulatorIDs = new int[]{-1, -1, 3, 9};
        GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
        gridLayoutHints.alignmentHoriz = 1;
        GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
        gridLayoutHints2.alignmentHoriz = 3;
        GridLayoutHints gridLayoutHints3 = new GridLayoutHints(2, 0);
        if (iconController != null) {
            ((GridLayout)widgetConstants).setWidgetConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2, gridLayoutHints3}, new AbstractWidgetController[]{labelController, iconController, timeSettingsWidgetController});
        } else {
            ((GridLayout)widgetConstants).setWidgetConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints3}, new AbstractWidgetController[]{labelController, timeSettingsWidgetController});
        }
        menuItemController.setLayoutManager((LayoutManager)((Object)widgetConstants));
        menuItemController.add(labelController);
        menuItemController.add(timeSettingsWidgetController);
        LayoutContainerController.autoLayoutSetup((GridLayout)widgetConstants);
        axisConstraints.gaps[axisConstraints.gaps.length - 1] = 0;
        menuItemController.setAutoLayoutSetup(false);
    }

    private static void setupDateSettingsWidget(MenuItemController menuItemController, ExtHMITerminalEvo extHMITerminalEvo, int n) {
        LabelController labelController = new LabelController();
        labelController.setRenderer(extHMITerminalEvo.getRendererFactory().createLabelRenderer(labelController));
        labelController.setTextIds(new int[]{menuItemController.getLabelId()});
        labelController.setChainedAction(3, 17);
        MenuController menuController = (MenuController)menuItemController.getParent();
        IRenderer iRenderer = menuItemController.getRenderer();
        int n2 = menuItemController.getModelID();
        Object object = menuItemController.getModel();
        int[] nArray = menuItemController.getTextIds();
        DateSettingsWidgetController dateSettingsWidgetController = new DateSettingsWidgetController();
        ITimeDateSetttingsRenderer iTimeDateSetttingsRenderer = extHMITerminalEvo.getRendererFactory().createInternalCursorWidgetRenderer(dateSettingsWidgetController, iRenderer, null);
        dateSettingsWidgetController.setRenderer(iTimeDateSetttingsRenderer);
        dateSettingsWidgetController.setMenu(menuController);
        dateSettingsWidgetController.setModelID(n2);
        dateSettingsWidgetController.setModel(object);
        dateSettingsWidgetController.setTextIds(nArray);
        dateSettingsWidgetController.setMaxDaysInFuture(n);
        dateSettingsWidgetController.setChainedAction(3, 17);
        MenuItemBuilder.setupScreenViews(menuItemController.getInitContext().getScreen(), dateSettingsWidgetController, menuItemController.getModelID());
        GridLayout gridLayout = new GridLayout(2, 1);
        AxisConstraints axisConstraints = (AxisConstraints)gridLayout.getColumnConstraints();
        axisConstraints.grow = new float[]{1.0f, 0.0f};
        axisConstraints.shrink = new float[]{1.0f, 0.0f};
        axisConstraints.tabulatorIDs = new int[]{-1, 3, 9};
        GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
        gridLayoutHints.alignmentHoriz = 1;
        GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
        gridLayout.setWidgetConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2}, new AbstractWidgetController[]{labelController, dateSettingsWidgetController});
        menuItemController.setLayoutManager(gridLayout);
        menuItemController.add(labelController);
        menuItemController.add(dateSettingsWidgetController);
        LayoutContainerController.autoLayoutSetup(gridLayout);
        axisConstraints.gaps[axisConstraints.gaps.length - 1] = 0;
        menuItemController.setAutoLayoutSetup(false);
    }

    private static void setupAuxHeaterProgrammingWidget(MenuItemController menuItemController, ExtHMITerminalEvo extHMITerminalEvo) {
        menuItemController.setAutoLayoutSetup(false);
        IWidgetLogChannel.menuItemLogCh.log(10000000, "MenuItemBuilder#setupAuxHeaterProgrammingWidget");
        LabelController labelController = new LabelController();
        labelController.setRenderer(extHMITerminalEvo.getRendererFactory().createLabelRenderer(labelController));
        labelController.setTextIds(new int[]{menuItemController.getLabelId()});
        labelController.setChainedAction(3, 17);
        MenuController menuController = (MenuController)menuItemController.getParent();
        IRenderer iRenderer = menuItemController.getRenderer();
        int n = menuItemController.getModelID();
        Object object = menuItemController.getModel();
        int[] nArray = menuItemController.getTextIds();
        final DateSettingsWidgetController dateSettingsWidgetController = new DateSettingsWidgetController();
        ITimeDateSetttingsRenderer iTimeDateSetttingsRenderer = extHMITerminalEvo.getRendererFactory().createInternalCursorWidgetRenderer(dateSettingsWidgetController, iRenderer, null);
        dateSettingsWidgetController.setRenderer(iTimeDateSetttingsRenderer);
        dateSettingsWidgetController.setMenu(menuController);
        dateSettingsWidgetController.setModelID(n);
        dateSettingsWidgetController.setModel(object);
        dateSettingsWidgetController.setMaxDaysInFuture(6);
        dateSettingsWidgetController.setTextIds(new int[]{nArray[2], nArray[3], nArray[4], nArray[5], nArray[6], nArray[7], nArray[8]});
        dateSettingsWidgetController.setChainedAction(3, 17);
        dateSettingsWidgetController.setSuppressModelReadsOnEnteringEditableMode(true);
        MenuItemBuilder.setupScreenViews(menuItemController.getInitContext().getScreen(), dateSettingsWidgetController, menuItemController.getModelID());
        TimeSettingsWidgetController timeSettingsWidgetController = new TimeSettingsWidgetController(){

            public void calendarModified(Calendar calendar) {
                if (dateSettingsWidgetController.isDateInPast(calendar)) {
                    calendar.add(5, 1);
                }
            }
        };
        ITimeDateSetttingsRenderer iTimeDateSetttingsRenderer2 = extHMITerminalEvo.getRendererFactory().createInternalCursorWidgetRenderer(timeSettingsWidgetController, iRenderer, null);
        timeSettingsWidgetController.setRenderer(iTimeDateSetttingsRenderer2);
        timeSettingsWidgetController.setMenu(menuController);
        timeSettingsWidgetController.setModelID(n);
        timeSettingsWidgetController.setModel(object);
        timeSettingsWidgetController.setTextIds(new int[]{nArray[0], nArray[1]});
        timeSettingsWidgetController.setChainedAction(3, 17);
        timeSettingsWidgetController.setSuppressModelWrites(true);
        timeSettingsWidgetController.setCalendar(dateSettingsWidgetController.getCalendar());
        MenuItemBuilder.setupScreenViews(menuItemController.getInitContext().getScreen(), timeSettingsWidgetController, menuItemController.getModelID());
        GridLayout gridLayout = new GridLayout(2, 2);
        AxisConstraints axisConstraints = (AxisConstraints)gridLayout.getColumnConstraints();
        axisConstraints.alignment = new int[]{1, 8};
        axisConstraints.grow = new float[]{1.0f, 0.0f};
        axisConstraints.shrink = new float[]{1.0f, 0.0f};
        GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
        GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
        GridLayoutHints gridLayoutHints3 = new GridLayoutHints(1, 1);
        gridLayout.setWidgetConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2, gridLayoutHints3}, new AbstractWidgetController[]{labelController, timeSettingsWidgetController, dateSettingsWidgetController});
        menuItemController.setLayoutManager(gridLayout);
        menuItemController.add(timeSettingsWidgetController);
        menuItemController.add(dateSettingsWidgetController);
        menuItemController.add(labelController);
        LayoutContainerController.autoLayoutSetup(gridLayout);
        int n2 = ((HMITerminalImpl)((Object)extHMITerminalEvo)).getLayout().getIntegerConstant(27);
        ((AxisConstraints)gridLayout.getRowConstraints()).gaps = new int[]{10, 2 * n2 + 5, 10};
    }

    private static void setupGeoCoordinateSettingsWidget(MenuItemController menuItemController, ExtHMITerminalEvo extHMITerminalEvo, boolean bl) {
        LabelController labelController = new LabelController();
        labelController.setRenderer(extHMITerminalEvo.getRendererFactory().createLabelRenderer(labelController));
        labelController.setTextIds(new int[]{menuItemController.getLabelId()});
        labelController.setChainedAction(3, 17);
        MenuController menuController = (MenuController)menuItemController.getParent();
        IRenderer iRenderer = menuItemController.getRenderer();
        int n = menuItemController.getModelID();
        Object object = menuItemController.getModel();
        int[] nArray = menuItemController.getTextIds();
        GeoPosSettingsController geoPosSettingsController = new GeoPosSettingsController();
        ITimeDateSetttingsRenderer iTimeDateSetttingsRenderer = extHMITerminalEvo.getRendererFactory().createInternalCursorWidgetRenderer(geoPosSettingsController, iRenderer, new int[]{1});
        geoPosSettingsController.setRenderer(iTimeDateSetttingsRenderer);
        if (bl) {
            geoPosSettingsController.setInputType(1);
        } else {
            geoPosSettingsController.setInputType(0);
        }
        geoPosSettingsController.setMenu(menuController);
        geoPosSettingsController.setModelID(n);
        geoPosSettingsController.setModel(object);
        geoPosSettingsController.setTextIDs(nArray);
        geoPosSettingsController.setChainedAction(3, 17);
        MenuItemBuilder.setupScreenViews(menuItemController.getInitContext().getScreen(), geoPosSettingsController, menuItemController.getModelID());
        GridLayout gridLayout = new GridLayout(2, 1);
        AxisConstraints axisConstraints = (AxisConstraints)gridLayout.getColumnConstraints();
        axisConstraints.grow = new float[]{1.0f, 0.0f};
        axisConstraints.shrink = new float[]{1.0f, 0.0f};
        GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
        gridLayoutHints.alignmentHoriz = 1;
        GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
        GridLayoutHints gridLayoutHints3 = new GridLayoutHints(1, 0);
        gridLayoutHints3.alignmentVert = 9;
        gridLayoutHints3.ignoreForCellSizes = true;
        gridLayoutHints3.overlapGaps = 15;
        gridLayout.setWidgetConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2, gridLayoutHints3}, new AbstractWidgetController[]{labelController, geoPosSettingsController, iTimeDateSetttingsRenderer.getFormfieldStub()});
        menuItemController.setLayoutManager(gridLayout);
        menuItemController.add(labelController);
        menuItemController.add(geoPosSettingsController);
        LayoutContainerController.autoLayoutSetup(gridLayout);
        axisConstraints.gaps[axisConstraints.gaps.length - 1] = 0;
        menuItemController.setAutoLayoutSetup(false);
        int[] nArray2 = new int[]{2, 0, 44};
        if (AbstractWidget.isScreenResolution1440()) {
            nArray2 = new int[]{2, -1, 40};
        }
        iTimeDateSetttingsRenderer.setAutoConfig(false);
        iTimeDateSetttingsRenderer.setTextVerticalOffset(nArray2[0]);
        iTimeDateSetttingsRenderer.setBackgroundVerticalOffset(nArray2[1]);
        iTimeDateSetttingsRenderer.setBackgroundHeight(nArray2[2]);
    }

    private static void setupRouteBriefingMenuItem(MenuItemController menuItemController, ExtHMITerminalEvo extHMITerminalEvo) {
        menuItemController.setAutoLayoutSetup(false);
    }

    private static void setupFormfieldInputWidget(MenuItemController menuItemController, ExtHMITerminalEvo extHMITerminalEvo) {
        LabelController labelController = MenuItemBuilder.createLeftLabel(menuItemController, extHMITerminalEvo);
        LabelController labelController2 = new LabelController();
        labelController2.setRenderer(extHMITerminalEvo.getRendererFactory().createLabelRenderer(labelController2));
        labelController2.setChainedAction(3, 17);
        if (menuItemController.getModelID() != -1) {
            labelController2.setModelID(menuItemController.getModelID());
            labelController2.setModel(menuItemController.getModel());
            MenuItemBuilder.setupScreenViews(menuItemController.getInitContext().getScreen(), labelController2, menuItemController.getModelID());
        }
        Layout layout = ((HMITerminalImpl)((Object)extHMITerminalEvo)).getLayout();
        GridLayout gridLayout = new GridLayout(1, 1);
        int n = layout.getDistance(213);
        int n2 = 0;
        AxisConstraints axisConstraints = (AxisConstraints)gridLayout.getColumnConstraints();
        axisConstraints.gaps = new int[]{n, n2};
        axisConstraints.grow = new float[]{1.0f};
        axisConstraints.shrink = new float[]{1.0f};
        GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
        gridLayout.setWidgetConstraints(new GridLayoutHints[]{gridLayoutHints}, new AbstractWidgetController[]{labelController2});
        FormfieldInputController formfieldInputController = new FormfieldInputController();
        FormfieldInputRenderer formfieldInputRenderer = extHMITerminalEvo.getRendererFactory().createFormfieldInputRenderer(formfieldInputController, true, false);
        formfieldInputController.setRenderer(formfieldInputRenderer);
        formfieldInputRenderer.setUseControllerHeight(false);
        GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
        gridLayoutHints2.alignmentVert = 9;
        gridLayoutHints2.ignoreForCellSizes = true;
        gridLayoutHints2.overlapGaps = 8;
        GridLayout gridLayout2 = new GridLayout(2, 1);
        AxisConstraints axisConstraints2 = (AxisConstraints)gridLayout2.getColumnConstraints();
        axisConstraints2.grow = new float[]{0.0f, 1.0f};
        axisConstraints2.shrink = new float[]{0.0f, 1.0f};
        axisConstraints2.gaps = new int[]{0, 32, 0};
        GridLayoutHints gridLayoutHints3 = new GridLayoutHints(0, 0);
        GridLayoutHints gridLayoutHints4 = new GridLayoutHints(1, 0);
        gridLayout2.setCellConstraints(new GridLayoutHints[]{gridLayoutHints3, gridLayoutHints4, gridLayoutHints2}, new Object[]{labelController, gridLayout, formfieldInputController});
        menuItemController.setLayoutManager(gridLayout2);
        axisConstraints2.setTabulatorIDs(new int[]{1, 2, 9});
        menuItemController.add(formfieldInputController);
        menuItemController.add(labelController);
        menuItemController.add(labelController2);
        LayoutContainerController.autoLayoutSetup(gridLayout2);
    }

    public static void configureMultiLineMenuItem(MultiLineMenuItemController multiLineMenuItemController, ExtHMITerminalEvo extHMITerminalEvo) {
        MenuItemBuilder.setupLabelMultiLineMenuItem(multiLineMenuItemController, extHMITerminalEvo);
    }

    private static void setupSDSCommandWidget(MenuItemController menuItemController, ExtHMITerminalEvo extHMITerminalEvo) {
        WidgetConstants widgetConstants;
        IWidgetLogChannel.menuItemLogCh.log(10000000, "MenuItemBuilder#setupSDSCommandWidget - Called");
        menuItemController.setAutoLayoutSetup(false);
        int[] nArray = new int[]{7, 7, 7, 0, 6, 0, 0};
        int[] nArray2 = new int[]{4, 6, 6, 0, 6, 0, 0};
        int n = AbstractWidget.framework.getScreenRes();
        menuItemController.setGlassplateInsetsTop(nArray[n]);
        menuItemController.setGlassplateInsetsBottom(nArray2[n]);
        List list = menuItemController.getChildren();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        GridLayout gridLayout = new GridLayout();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            widgetConstants = (AbstractWidgetController)list.get(i2);
            if (!widgetConstants.isVisible()) {
                IWidgetLogChannel.menuItemLogCh.log(10000000, "MenuItemBuilder#setupSDSCommandWidget - Label is invisible, continue with next item");
                continue;
            }
            if (widgetConstants instanceof LabelController) {
                arrayList2.add(widgetConstants);
                continue;
            }
            if (!(widgetConstants instanceof IconController)) continue;
            arrayList.add(widgetConstants);
        }
        MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(1);
        menuItemColumnsConstraints.hidemode = new int[]{2};
        gridLayout.setColumnConstraints(menuItemColumnsConstraints);
        widgetConstants = new AxisConstraints(arrayList2.size());
        int[] nArray3 = new int[arrayList2.size() + 1];
        for (int i3 = 1; i3 < nArray3.length - 1; ++i3) {
            nArray3[i3] = 22;
        }
        nArray3[0] = 4;
        nArray3[nArray3.length - 1] = 0;
        ((AxisConstraints)widgetConstants).gaps = nArray3;
        gridLayout.setRowConstraints((IAxisConstraints)widgetConstants);
        Object[] objectArray = new GridLayout[arrayList2.size()];
        IGridLayoutHints[] iGridLayoutHintsArray = new GridLayoutHints[arrayList2.size()];
        for (int i4 = 0; i4 < iGridLayoutHintsArray.length; ++i4) {
            GridLayoutHints gridLayoutHints = new GridLayoutHints(0, i4);
            iGridLayoutHintsArray[i4] = gridLayoutHints;
            IconController iconController = null;
            if (i4 < arrayList.size()) {
                iconController = (IconController)arrayList.get(i4);
            }
            if (iconController == null) {
                iconController = MenuItemBuilder.createAndAddIcon(menuItemController, extHMITerminalEvo, 0);
            }
            if (iconController == null) {
                iconController = new IconController();
                iconController.setRenderer(extHMITerminalEvo.getRendererFactory().createIconRenderer(iconController));
            }
            GridLayout gridLayout2 = new GridLayout(2, 1);
            AxisConstraints axisConstraints = (AxisConstraints)gridLayout2.getColumnConstraints();
            axisConstraints.shrink = new float[]{0.0f, 1.0f};
            GridLayoutHints gridLayoutHints2 = new GridLayoutHints(0, 0);
            gridLayoutHints2.setHeightMax(extHMITerminalEvo.getRendererFactory().getUppercaseFontHeight(menuItemController.getRenderer(), 0));
            gridLayoutHints2.setAlignmentVert(5);
            GridLayoutHints gridLayoutHints3 = new GridLayoutHints(1, 0);
            gridLayout2.setWidgetConstraints(new GridLayoutHints[]{gridLayoutHints2, gridLayoutHints3}, new AbstractWidgetController[]{iconController, (AbstractWidgetController)arrayList2.get(i4)});
            objectArray[i4] = gridLayout2;
        }
        gridLayout.setCellConstraints(iGridLayoutHintsArray, objectArray);
        menuItemController.setLayoutManager(gridLayout);
    }

    private static void setupSDSBulletLabel(MenuItemController menuItemController, ExtHMITerminalEvo extHMITerminalEvo) {
        LabelController labelController = MenuItemBuilder.createLeftLabel(menuItemController, extHMITerminalEvo);
        menuItemController.add(labelController);
        IconController iconController = MenuItemBuilder.createAndAddIcon(menuItemController, extHMITerminalEvo, 0);
        GridLayout gridLayout = (GridLayout)MenuItemBuilder.createMenuItemLayout(iconController, labelController, null, extHMITerminalEvo);
        AxisConstraints axisConstraints = (AxisConstraints)gridLayout.getColumnConstraints();
        int[] nArray = axisConstraints.gaps;
        axisConstraints.gaps = new int[]{0, 4, nArray[2], nArray[3]};
        menuItemController.setAutoLayoutSetup(false);
        menuItemController.setLayoutManager(gridLayout);
    }
}

