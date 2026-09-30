/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.Layout;
import de.esolutions.hmi.widgets.audi.base.LayoutManager;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.HMITerminalEvoImpl;
import de.esolutions.hmi.widgets.audi.evo.InstructionTextContoller;
import de.esolutions.hmi.widgets.audi.evo.widgets.GlassplateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IViewSizeAnimatable;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupGlassplateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ScrollbarController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuLayout;

public class InstructionTextLayout
implements LayoutManager,
IViewSizeAnimatable {
    private static final int DEFAULT_MAX_WIDTH = 680;
    private int maximumWidthSmallStage = 341;
    private int minimumWidthBigStage = 382;
    private int width = 1;
    private int height = 1;
    private Layout layout = null;
    private int menuOriginalX = Integer.MIN_VALUE;
    private int menuOriginalY = Integer.MIN_VALUE;
    private int menuOriginalHeight = Integer.MIN_VALUE;
    private int scrollBarHeightOffset = 0;
    private int hintTextOriginalX = Integer.MIN_VALUE;
    private int hintTextOriginalY = Integer.MIN_VALUE;
    private int numberOfHintTextRows = 0;
    private int numberOfOptions = 0;
    private int maxWidth = 680;
    private float currentWidthWeight = Float.MIN_VALUE;
    private boolean touchfieldLayout = false;
    private int clipFromSeparator = 3;
    private int clipFromGlassPlate = -3;
    private static final int Y_OFFSET_QVGA_SEPARATOR_4_ROWS_1_OPTION = 2;
    private static final int INDEX_HINT_TEXT_HEIGHT_1_LINE = 0;
    private static final int INDEX_HINT_TEXT_HEIGHT_2_LINE = 1;
    private static final int INDEX_HINT_TEXT_HEIGHT_3_LINE = 2;
    private static final int INDEX_HINT_TEXT_HEIGHT_4_LINE = 3;
    private static final int INDEX_HINT_TEXT_HEIGHT_5_LINE = 4;
    private static final int INDEX_HINT_TEXT_MENU_Y_1_LINE = 6;
    private static final int INDEX_HINT_TEXT_MENU_Y_2_LINE = 7;
    private static final int INDEX_HINT_TEXT_MENU_Y_3_LINE = 8;
    private static final int INDEX_HINT_TEXT_MENU_Y_4_LINE = 9;
    private static final int INDEX_HINT_TEXT_MENU_Y_5_LINE = 10;
    private static final int INDEX_HINT_TEXT_MENU_HEIGHT_PER_ROW = 11;
    private static final int INDEX_HINT_TEXT_MENU_INIT_SIZE = 12;
    private static final int INDEX_HINT_TEXT_SEPARATOR_Y_OFFSET = 13;
    private static final int INDEX_PP_MENU_CONTENT_LEFT_OFFSET = 14;
    private static final int INDEX_PP_MENU_CONTENT_RIGHT_OFFSET = 15;
    private static final int INDEX_PP_MENU_CONTENT_RIGHT_OFFSET_SMALL_STAGE = 16;
    private static final int INDEX_PP_MENU_ITEM_GAP = 17;
    private static final int INDEX_PP_LEFT_RIGHT_INSET = 18;
    private static final int INDEX_PP_HINT_TEXT_Y_OFFSET_NO_OPTIONS = 19;
    private static final int INDEX_PP_HINT_TEXT_Y_OFFSET_MORE_OPTIONS = 20;
    private static final int INDEX_PP_LINE_SPACING_HINT_TEXT = 21;
    private static final int INDEX_PP_LINE_SPACING_OPTIONS = 22;
    private static final int INDEX_PP_DISTANCE_TEXT_SEPARATOR_NO_OPTIONS = 23;
    private static final int INDEX_PP_DISTANCE_TEXT_SEPARATOR_ONE_OPTION = 24;
    private static final int INDEX_PP_DISTANCE_TEXT_SEPARATOR_MORE_OPTIONS = 25;
    private static final int INDEX_TF_HINT_TEXT_HEIGHT_1_LINE = 26;
    private static final int INDEX_TF_HINT_TEXT_HEIGHT_2_LINE = 27;
    private static final int INDEX_TF_HINT_TEXT_HEIGHT_3_LINE = 28;
    private static final int INDEX_TF_HINT_TEXT_HEIGHT_4_LINE = 29;
    private static final int INDEX_TF_HINT_TEXT_HEIGHT_5_LINE = 30;
    private static final int INDEX_TF_HINT_TEXT_MENU_Y_1_LINE = 32;
    private static final int INDEX_TF_HINT_TEXT_MENU_Y_2_LINE = 33;
    private static final int INDEX_TF_HINT_TEXT_MENU_Y_3_LINE = 34;
    private static final int INDEX_TF_HINT_TEXT_MENU_Y_4_LINE = 35;
    private static final int INDEX_TF_HINT_TEXT_MENU_Y_5_LINE = 36;
    private static final int INDEX_TF_HINT_TEXT_SEPARATOR_Y_OFFSET = 39;
    private static final int INDEX_HINT_TEXT_LEFT_OFFSET = 40;
    private static final int INDEX_HINT_TEXT_RIGHT_OFFSET = 41;
    private static final int INDEX_PP_MENU_SEPARATOR_OFFSET = 42;
    private static final int INDEX_PP_SEPARATOR_LINE_OFFSET = 43;
    private static final int INDEX_PP_OPTIONS_HEIGHT_OFFSET = 44;
    private static final int INDEX_PP_TOP_BOTTOM_INSET = 45;
    private static final int INDEX_TF_HINT_TEXT_LINE_HEIGHT = 47;
    private static final int INDEX_PP_HINT_TEXT_LINE_HEIGHT = 48;
    private static final int INDEX_PP_HINT_TEXT_Y_OFFSET_1_LINE_OFFSET = 49;
    private static final int INDEX_HINT_TEXT_X_OFFSET_ICON_LEFT_SIDE = 50;
    private static final int INDEX_HINT_TEXT_Y_OFFSET_ICON_LEFT_SIDE = 51;
    private static final int INDEX_PP_HINT_TEXT_X_OFFSET_ICON_LEFT_SIDE = 52;
    private static final int ICON_WIDTH = 25;
    private static final int SMALL_STAGE_OFFSET = 551;

    public InstructionTextLayout(Layout layout) {
        this.layout = layout;
        this.maximumWidthSmallStage = layout.getIntegerConstant(50) - 2 * layout.getInstructionTextLayoutParams()[18];
        this.minimumWidthBigStage = layout.getIntegerConstant(51);
    }

    private int getInfoPopupWidth(InstructionTextContoller instructionTextContoller) {
        int n;
        int n2 = this.getHintTextWidth(instructionTextContoller);
        int n3 = Math.max(n2, n = this.getOptionMenuWidth(instructionTextContoller));
        if (n3 < this.minimumWidthBigStage) {
            n3 = this.minimumWidthBigStage;
        } else if (n3 > this.maxWidth) {
            n3 = this.maxWidth;
        }
        return n3;
    }

    private int getHintTextWidth(InstructionTextContoller instructionTextContoller) {
        int n = 0;
        this.numberOfHintTextRows = 0;
        if (instructionTextContoller.getHintText() != null && instructionTextContoller.getHintText().getRenderer() instanceof LabelRenderer) {
            LabelRenderer labelRenderer = (LabelRenderer)instructionTextContoller.getHintText().getRenderer();
            n = labelRenderer.getPreferredWidth();
            this.numberOfHintTextRows = instructionTextContoller.getOptions() != null ? labelRenderer.getNumberOfRows(instructionTextContoller.getOptions().getWidth()) : labelRenderer.getNumberOfRows(instructionTextContoller.getHintText().getWidth());
        }
        return n;
    }

    private int getOptionMenuWidth(InstructionTextContoller instructionTextContoller) {
        this.numberOfOptions = 0;
        if (instructionTextContoller.getOptions() != null) {
            MenuController menuController = instructionTextContoller.getOptions();
            this.numberOfOptions = menuController.getFlatMenuItemCount();
            return menuController.getPreferredWidth();
        }
        return 0;
    }

    private void calculateRows(InstructionTextContoller instructionTextContoller) {
        AbstractWidgetController abstractWidgetController;
        this.numberOfOptions = 0;
        if (instructionTextContoller.getOptions() != null) {
            this.numberOfOptions = instructionTextContoller.getOptions().getFlatMenuItemCount();
        }
        this.numberOfHintTextRows = 0;
        if (instructionTextContoller.getHintText() != null && instructionTextContoller.getHintText() instanceof LabelController) {
            abstractWidgetController = instructionTextContoller.getHintText();
            int n = this.calculateMaxNumberOfTextRows(instructionTextContoller);
            ((LabelController)abstractWidgetController).setMaxLines(n);
            int[] nArray = this.layout.getInstructionTextLayoutParams();
            this.numberOfHintTextRows = instructionTextContoller.getOptions() != null ? (instructionTextContoller.getHintTextIconLeftSide() == null ? ((LabelRenderer)((LabelController)abstractWidgetController).getRenderer()).getNumberOfRows(instructionTextContoller.getOptions().getWidth() - nArray[40] - nArray[41]) : ((LabelRenderer)((LabelController)abstractWidgetController).getRenderer()).getNumberOfRows(instructionTextContoller.getOptions().getWidth() - (25 + nArray[52] + nArray[50]))) : (instructionTextContoller.getHintTextIconLeftSide() == null ? ((LabelRenderer)((LabelController)abstractWidgetController).getRenderer()).getNumberOfRows(instructionTextContoller.getHintText().getWidth() - nArray[40] - nArray[41]) : ((LabelRenderer)((LabelController)abstractWidgetController).getRenderer()).getNumberOfRows(instructionTextContoller.getHintText().getWidth() - (25 + nArray[52] + nArray[50])));
        }
        if (instructionTextContoller.getHintTextMenu() != null) {
            abstractWidgetController = instructionTextContoller.getHintTextMenu();
            this.numberOfHintTextRows = ((MenuController)abstractWidgetController).getFlatMenuItemCount();
        }
    }

    private int calculateMaxNumberOfTextRows(InstructionTextContoller instructionTextContoller) {
        int n = 6;
        int n2 = 0;
        if (AbstractWidget.framework.getScreenRes() == 0) {
            n = 5;
            n2 = 1;
        }
        if (instructionTextContoller.getIcon() != null) {
            ++this.numberOfOptions;
        }
        switch (this.numberOfOptions) {
            case 0: {
                n = 6 - n2;
                break;
            }
            case 1: {
                n = 5 - n2;
                break;
            }
            default: {
                n = 4 - n2;
            }
        }
        return n;
    }

    public void layout(AbstractWidget abstractWidget) {
        if (abstractWidget != null) {
            if (abstractWidget.getParent() instanceof PartialPopupController) {
                this.layoutPartialPopup(abstractWidget, (PartialPopupController)abstractWidget.getParent());
            } else if (this.touchfieldLayout) {
                this.layoutCenterAreaMenuTouchfield(abstractWidget);
            } else {
                this.layoutCenterAreaMenu(abstractWidget);
            }
        }
    }

    private void layoutPartialPopup(AbstractWidget abstractWidget, PartialPopupController partialPopupController) {
        int n;
        int n2;
        int n3;
        Object object;
        InstructionTextContoller instructionTextContoller = (InstructionTextContoller)abstractWidget;
        PartialPopupGlassplateController partialPopupGlassplateController = instructionTextContoller.getGlassPlate();
        if (partialPopupGlassplateController == null) {
            IWidgetLogChannel.logChannel.log(10000, "InstructionTextLayout#layoutPartialPopup glassPlate is null - abort rendering");
            return;
        }
        int[] nArray = this.layout.getInstructionTextLayoutParams();
        partialPopupController.setContentInset(nArray[40], nArray[45]);
        this.width = this.getInfoPopupWidth(instructionTextContoller);
        int n4 = this.getCurrentWidth();
        this.calculateRows(instructionTextContoller);
        int n5 = this.numberOfOptions;
        if (this.numberOfOptions > 0) {
            int n6 = this.getHintTextHeight(nArray);
            if (this.numberOfHintTextRows + this.numberOfOptions > 6 && n5 > 2) {
                n5 = 2;
            }
            MenuController menuController = instructionTextContoller.getOptions();
            object = (HMITerminalEvoImpl)menuController.getTerminal();
            n3 = 0;
            if (object != null) {
                int n7 = n3 = ((HMITerminalImpl)object).getViewSizeManager().getCurrentViewSize() == 1 ? 1 : 0;
            }
            if (this.menuOriginalX == Integer.MIN_VALUE) {
                this.menuOriginalX = n3 != 0 ? menuController.getX() - 10 + (nArray[18] - nArray[40]) - 551 : menuController.getX() - 10 + (nArray[18] - nArray[40]);
            }
            n2 = n6 + nArray[42];
            n = n6 + nArray[43];
            if (instructionTextContoller.getIcon() != null) {
                n2 += 45;
                n += nArray[0];
            }
            if (n4 + nArray[40] + nArray[41] <= this.maxWidth) {
                menuController.setBounds(this.menuOriginalX, n2, n4 + nArray[40] + nArray[41], this.getOptionsHeight(n5, nArray));
            } else {
                menuController.setBounds(this.menuOriginalX, n2, this.maxWidth, this.getOptionsHeight(n5, nArray));
            }
            MenuLayout menuLayout = menuController.getLayout();
            menuLayout.setContentLeftOffset(nArray[14]);
            menuLayout.setContentRightOffset(nArray[15]);
            menuLayout.setContentRightOffsetSmallStage(nArray[16]);
            menuLayout.setBackgroundInsetsVert(0);
            menuLayout.setItemsGap(nArray[17]);
            menuController.relayout();
            partialPopupGlassplateController.setSeparatorVisible(true);
            partialPopupGlassplateController.setSeparatorYPosition(n);
            this.height = n6 + this.getOptionsHeight(n5, nArray);
            this.setClippingBordersPartialPopUp(menuController, this.height, n6);
        } else {
            partialPopupGlassplateController.setSeparatorVisible(false);
            this.height = this.getHintTextHeight(nArray);
        }
        LabelController labelController = instructionTextContoller.getHintText();
        if (labelController != null) {
            if (this.hintTextOriginalX == Integer.MIN_VALUE) {
                this.hintTextOriginalX = labelController.getX();
            }
            if (this.hintTextOriginalY == Integer.MIN_VALUE) {
                this.hintTextOriginalY = labelController.getY();
            }
            labelController.setX(this.hintTextOriginalX);
            int n8 = nArray[19];
            if (instructionTextContoller.getIcon() != null) {
                instructionTextContoller.getIcon().setY(15);
                instructionTextContoller.getIcon().setX(n4 / 2);
                ++this.numberOfHintTextRows;
            }
            if (this.numberOfHintTextRows > 1) {
                n8 = nArray[20];
            }
            if (instructionTextContoller.getIcon() != null) {
                n8 += nArray[0];
            }
            labelController.setY(this.hintTextOriginalY + n8);
            if (n4 <= this.maxWidth - nArray[40] - nArray[41]) {
                labelController.setWidth(n4);
            } else {
                labelController.setWidth(this.maxWidth - nArray[40] - nArray[41]);
            }
            labelController.setHeight(this.getHintTextHeight(nArray));
            if (instructionTextContoller.getHintTextIconLeftSide() != null) {
                boolean bl;
                object = instructionTextContoller.getHintTextIconLeftSide();
                n3 = nArray[52];
                n2 = nArray[50];
                n = n3 + 25 + n2;
                int n9 = labelController.getPreferredWidth();
                int n10 = labelController.getX() + (labelController.getWidth() - n9) / 2;
                boolean bl2 = bl = n10 - n >= 0;
                if (bl) {
                    ((AbstractWidgetController)object).setX(n10 - 25 - n2);
                } else {
                    ((AbstractWidgetController)object).setX(n3);
                    labelController.setX(n);
                    labelController.setWidth(n4 - n);
                }
                ((AbstractWidgetController)object).setY(this.hintTextOriginalY + (labelController.getHeight() - labelController.getPreferredHeight()) / 2 - nArray[51]);
            }
            if (labelController.getRenderer() instanceof LabelRenderer) {
                ((LabelRenderer)labelController.getRenderer()).setLineHeight(nArray[48]);
            }
        } else {
            IWidgetLogChannel.logChannel.log(10000, "InstructionTextLayout#layoutPartialPopup hintText is null - text might be aligned wrong");
        }
    }

    private int getOptionsHeight(int n, int[] nArray) {
        return nArray[44] + (n - 1) * nArray[22] + nArray[23];
    }

    private int getHintTextHeight(int[] nArray) {
        if (this.numberOfOptions == 0) {
            return this.numberOfHintTextRows * nArray[21] + nArray[23];
        }
        if (this.numberOfHintTextRows > 1) {
            return this.numberOfHintTextRows * nArray[21] + nArray[25];
        }
        return this.numberOfHintTextRows * nArray[21] + nArray[24];
    }

    public int[] calculateSize(AbstractWidget abstractWidget, int n) {
        if (abstractWidget instanceof InstructionTextContoller) {
            this.layout(abstractWidget);
            return new int[]{this.getCurrentWidth(), this.height};
        }
        return new int[]{0, 0};
    }

    private void layoutCenterAreaMenu(AbstractWidget abstractWidget) {
        InstructionTextContoller instructionTextContoller = (InstructionTextContoller)abstractWidget;
        GlassplateController glassplateController = (GlassplateController)instructionTextContoller.getOptions().getChildOfRole(4);
        if (glassplateController == null) {
            IWidgetLogChannel.logChannel.log(10000, "InstructionTextLayout#layoutCenterAreaMenu glassPlate is null - abort rendering");
            return;
        }
        this.calculateRows(instructionTextContoller);
        int n = this.numberOfOptions;
        MenuController menuController = instructionTextContoller.getOptions();
        if (this.menuOriginalY == Integer.MIN_VALUE) {
            this.menuOriginalY = menuController.getY();
            this.menuOriginalHeight = menuController.getHeight();
            ScrollbarController scrollbarController = (ScrollbarController)menuController.getChildOfRole(3);
            if (scrollbarController != null) {
                this.scrollBarHeightOffset = this.menuOriginalHeight - scrollbarController.getHeight();
            }
        }
        int n2 = 0;
        int n3 = 0;
        int n4 = 4;
        int n5 = 0;
        int[] nArray = this.layout.getInstructionTextLayoutParams();
        if (this.numberOfOptions > 0) {
            Object object;
            if (AbstractWidget.framework.getScreenRes() != 0) {
                block0 : switch (this.numberOfOptions) {
                    case 1: {
                        switch (this.numberOfHintTextRows) {
                            case 0: {
                                IWidgetLogChannel.logChannel.log(100000, "InstructionTextLayout#layoutCenterAreaMenu numberOfHintTextRows is 0 - no hint text is shown");
                            }
                            case 1: 
                            case 2: 
                            case 3: {
                                n5 = nArray[8];
                                n2 = this.menuOriginalY + nArray[9];
                                n3 = nArray[8];
                                n = 3;
                                break block0;
                            }
                            case 4: {
                                n5 = nArray[3];
                                n2 = this.menuOriginalY + nArray[9];
                                n3 = nArray[9];
                                n = 2;
                                break block0;
                            }
                        }
                        n5 = nArray[4];
                        n2 = this.menuOriginalY + nArray[10];
                        n3 = nArray[10];
                        n = 1;
                        break;
                    }
                    case 2: {
                        switch (this.numberOfHintTextRows) {
                            case 0: {
                                IWidgetLogChannel.logChannel.log(100000, "InstructionTextLayout#layoutCenterAreaMenu numberOfHintTextRows is 0 - no hint text is shown");
                            }
                            case 1: 
                            case 2: 
                            case 3: {
                                n5 = nArray[2];
                                n2 = this.menuOriginalY + nArray[8];
                                n3 = nArray[8];
                                n = 3;
                                break block0;
                            }
                            case 4: {
                                n5 = nArray[3];
                                n2 = this.menuOriginalY + nArray[9];
                                n3 = nArray[9];
                                n = 2;
                                break block0;
                            }
                        }
                        n5 = nArray[4];
                        n2 = this.menuOriginalY + nArray[10];
                        n3 = nArray[10];
                        n = 1;
                        break;
                    }
                    case 3: {
                        switch (this.numberOfHintTextRows) {
                            case 0: {
                                IWidgetLogChannel.logChannel.log(100000, "InstructionTextLayout#layoutCenterAreaMenu numberOfHintTextRows is 0 - no hint text is shown");
                            }
                            case 1: 
                            case 2: 
                            case 3: {
                                n5 = nArray[2];
                                n2 = this.menuOriginalY + nArray[8];
                                n3 = nArray[8];
                                n = 3;
                                break block0;
                            }
                            case 4: {
                                n5 = nArray[3];
                                n2 = this.menuOriginalY + nArray[9];
                                n3 = nArray[9];
                                n = 2;
                                break block0;
                            }
                        }
                        n5 = nArray[4];
                        n2 = this.menuOriginalY + nArray[10];
                        n3 = nArray[10];
                        n = 1;
                        break;
                    }
                    case 4: {
                        switch (this.numberOfHintTextRows) {
                            case 0: {
                                IWidgetLogChannel.logChannel.log(100000, "InstructionTextLayout#layoutCenterAreaMenu numberOfHintTextRows is 0 - no hint text is shown");
                            }
                            case 1: 
                            case 2: {
                                n5 = nArray[1];
                                n2 = this.menuOriginalY + nArray[7];
                                n3 = nArray[7];
                                n = 4;
                                break block0;
                            }
                            case 3: {
                                n5 = nArray[2];
                                n2 = this.menuOriginalY + nArray[8];
                                n3 = nArray[8];
                                n = 3;
                                break block0;
                            }
                            case 4: {
                                n5 = nArray[3];
                                n2 = this.menuOriginalY + nArray[9];
                                n3 = nArray[9];
                                n = 2;
                                break block0;
                            }
                        }
                        n5 = nArray[4];
                        n2 = this.menuOriginalY + nArray[10];
                        n3 = nArray[10];
                        n = 1;
                        break;
                    }
                    case 5: 
                    case 6: {
                        switch (this.numberOfHintTextRows) {
                            case 0: {
                                IWidgetLogChannel.logChannel.log(100000, "InstructionTextLayout#layoutCenterAreaMenu numberOfHintTextRows is 0 - no hint text is shown");
                            }
                            case 1: {
                                n5 = nArray[0];
                                n2 = this.menuOriginalY + nArray[6];
                                n3 = nArray[6];
                                n = 5;
                                break block0;
                            }
                            case 2: {
                                n5 = nArray[1];
                                n2 = this.menuOriginalY + nArray[7];
                                n3 = nArray[7];
                                n = 4;
                                break block0;
                            }
                            case 3: {
                                n5 = nArray[2];
                                n2 = this.menuOriginalY + nArray[8];
                                n3 = nArray[8];
                                n = 3;
                                break block0;
                            }
                            case 4: {
                                n5 = nArray[3];
                                n2 = this.menuOriginalY + nArray[9];
                                n3 = nArray[9];
                                n = 2;
                                break block0;
                            }
                        }
                        n5 = nArray[4];
                        n2 = this.menuOriginalY + nArray[10];
                        n3 = nArray[10];
                        n = 1;
                        break;
                    }
                }
            } else {
                object = this.layoutItStd(nArray, this.numberOfOptions, this.numberOfHintTextRows);
                n2 = object[0];
                n3 = object[1];
                n5 = object[2];
                n = object[3];
            }
            if (instructionTextContoller.getFixedNumberOfOptions() != -1) {
                n = instructionTextContoller.getFixedNumberOfOptions();
            }
            menuController.setY(n2);
            menuController.getLayout().setBackgroundVerticalDimension(-n2 + this.menuOriginalY, this.menuOriginalHeight);
            menuController.setHeight(n * nArray[11] + nArray[12]);
            menuController.relayout();
            IWidgetLogChannel.menuLogCh.log(10000000, "InstructionTextLayout#InstructionTextLayout: refresh menu because of layout change: %1", (Object)menuController);
            menuController.refreshAllItems();
            object = (ScrollbarController)menuController.getChildOfRole(3);
            if (object != null) {
                ((AbstractWidgetController)object).setHeight(menuController.getHeight() - this.scrollBarHeightOffset);
            }
            glassplateController.setSeparatorVisible(true);
            glassplateController.setSeparatorYPosition(n3 + nArray[13]);
        } else {
            if (AbstractWidget.framework.getScreenRes() == 0) {
                menuController.setHeight(5 * nArray[11] + nArray[12]);
            } else {
                menuController.setHeight(6 * nArray[11] + nArray[12]);
            }
            glassplateController.setSeparatorVisible(false);
            n5 = menuController.getHeight();
            if (AbstractWidgetController.framework.getKombiType() == 4) {
                menuController.getLayout().setBackgroundVerticalDimension(0, this.menuOriginalHeight);
            }
        }
        this.layoutHintText(instructionTextContoller, menuController, nArray, n5);
        this.setClippingBorders(menuController, -n2 + this.menuOriginalY, this.menuOriginalHeight, n3);
    }

    private int[] layoutItStd(int[] nArray, int n, int n2) {
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = n;
        block0 : switch (n) {
            case 1: {
                switch (n2) {
                    case 0: {
                        IWidgetLogChannel.logChannel.log(100000, "InstructionTextLayout#layoutItStd numberOfHintTextRows is 0 - no hint text is shown");
                    }
                    case 1: {
                        n4 = nArray[1];
                        n3 = this.menuOriginalY + nArray[9];
                        n5 = nArray[8];
                        n6 = 2;
                        break block0;
                    }
                    case 2: {
                        n4 = nArray[1];
                        n3 = this.menuOriginalY + nArray[9];
                        n5 = nArray[8];
                        n6 = 2;
                        break block0;
                    }
                    case 3: {
                        n4 = nArray[2];
                        n3 = this.menuOriginalY + nArray[9];
                        n5 = nArray[9];
                        n6 = 2;
                        break block0;
                    }
                    case 4: {
                        n4 = nArray[3];
                        n3 = this.menuOriginalY + nArray[10];
                        n5 = nArray[10] + 2;
                        break block0;
                    }
                }
                IWidgetLogChannel.logChannel.log(10000, "InstructionTextLayout#layoutItStd numberOfHintTextRows is invalid: %1 - layout errors will occur", (long)n2);
                break;
            }
            case 2: {
                switch (n2) {
                    case 0: {
                        IWidgetLogChannel.logChannel.log(100000, "InstructionTextLayout#layoutItStd numberOfHintTextRows is 0 - no hint text is shown");
                    }
                    case 1: {
                        n4 = nArray[1];
                        n3 = this.menuOriginalY + nArray[8];
                        n5 = nArray[8];
                        n6 = 3;
                        break block0;
                    }
                    case 2: {
                        n4 = nArray[1];
                        n3 = this.menuOriginalY + nArray[8];
                        n5 = nArray[8];
                        n6 = 3;
                        break block0;
                    }
                    case 3: {
                        n4 = nArray[2];
                        n3 = this.menuOriginalY + nArray[9];
                        n5 = nArray[9];
                        n6 = 2;
                        break block0;
                    }
                    case 4: {
                        n4 = nArray[3];
                        n3 = this.menuOriginalY + nArray[10];
                        n5 = nArray[10] + 2;
                        n6 = 1;
                        break block0;
                    }
                }
                n4 = nArray[3];
                n3 = this.menuOriginalY + nArray[10];
                n5 = nArray[10] + 2;
                n6 = 1;
                break;
            }
            case 3: {
                switch (n2) {
                    case 0: {
                        IWidgetLogChannel.logChannel.log(100000, "InstructionTextLayout#layoutItStd numberOfHintTextRows is 0 - no hint text is shown");
                    }
                    case 1: {
                        n4 = nArray[1];
                        n3 = this.menuOriginalY + nArray[8];
                        n5 = nArray[8];
                        n6 = 3;
                        break block0;
                    }
                    case 2: {
                        n4 = nArray[1];
                        n3 = this.menuOriginalY + nArray[8];
                        n5 = nArray[8];
                        n6 = 3;
                        break block0;
                    }
                    case 3: {
                        n4 = nArray[2];
                        n3 = this.menuOriginalY + nArray[9];
                        n5 = nArray[9];
                        n6 = 2;
                        break block0;
                    }
                    case 4: {
                        n4 = nArray[3];
                        n3 = this.menuOriginalY + nArray[10];
                        n5 = nArray[10] + 2;
                        n6 = 1;
                        break block0;
                    }
                }
                n4 = nArray[3];
                n3 = this.menuOriginalY + nArray[10];
                n5 = nArray[10] + 2;
                n6 = 1;
                break;
            }
            case 4: {
                switch (n2) {
                    case 0: {
                        IWidgetLogChannel.logChannel.log(100000, "InstructionTextLayout#layoutItStd numberOfHintTextRows is 0 - no hint text is shown");
                    }
                    case 1: {
                        n4 = nArray[0];
                        n3 = this.menuOriginalY + nArray[7];
                        n5 = nArray[7];
                        n6 = 4;
                        break block0;
                    }
                    case 2: {
                        n4 = nArray[1];
                        n3 = this.menuOriginalY + nArray[8];
                        n5 = nArray[8];
                        n6 = 3;
                        break block0;
                    }
                    case 3: {
                        n4 = nArray[2];
                        n3 = this.menuOriginalY + nArray[9];
                        n5 = nArray[9];
                        n6 = 2;
                        break block0;
                    }
                    case 4: {
                        n4 = nArray[3];
                        n3 = this.menuOriginalY + nArray[10];
                        n5 = nArray[10] + 2;
                        n6 = 1;
                        break block0;
                    }
                }
                n4 = nArray[3];
                n3 = this.menuOriginalY + nArray[10];
                n5 = nArray[10] + 2;
                n6 = 1;
                break;
            }
        }
        return new int[]{n3, n5, n4, n6};
    }

    private void setClippingBorders(MenuController menuController, int n, int n2, int n3) {
        int n4 = n + n3;
        int n5 = n + n2 - menuController.getHeight();
        menuController.setClipOffsetTop(n4 + this.clipFromSeparator);
        menuController.setClipOffsetBottom(n5 + this.clipFromGlassPlate);
    }

    private void setClippingBordersPartialPopUp(MenuController menuController, int n, int n2) {
        int n3 = n2 - menuController.getY();
        int n4 = n - (menuController.getY() + menuController.getHeight());
        menuController.setClipOffsetTop(n3 + this.clipFromSeparator);
        menuController.setClipOffsetBottom(n4 + this.clipFromGlassPlate);
    }

    private void layoutCenterAreaMenuTouchfield(AbstractWidget abstractWidget) {
        InstructionTextContoller instructionTextContoller = (InstructionTextContoller)abstractWidget;
        GlassplateController glassplateController = (GlassplateController)instructionTextContoller.getOptions().getChildOfRole(4);
        if (glassplateController == null) {
            IWidgetLogChannel.logChannel.log(10000, "InstructionTextLayout#layoutCenterAreaMenuTouchfield glassPlate is null - abort rendering");
            return;
        }
        this.calculateRows(instructionTextContoller);
        MenuController menuController = instructionTextContoller.getOptions();
        if (this.menuOriginalY == Integer.MIN_VALUE) {
            this.menuOriginalY = menuController.getY();
            this.menuOriginalHeight = menuController.getHeight();
            ScrollbarController scrollbarController = (ScrollbarController)menuController.getChildOfRole(3);
            if (scrollbarController != null) {
                this.scrollBarHeightOffset = this.menuOriginalHeight - scrollbarController.getHeight();
            }
        }
        int n = 0;
        int n2 = 4;
        int n3 = 0;
        int[] nArray = this.layout.getInstructionTextLayoutParams();
        if (this.numberOfOptions > 0) {
            block0 : switch (this.numberOfOptions) {
                case 1: {
                    switch (this.numberOfHintTextRows) {
                        case 0: {
                            IWidgetLogChannel.logChannel.log(100000, "InstructionTextLayout#layoutCenterAreaMenuTouchfield numberOfHintTextRows is 0 - no hint text is shown");
                        }
                        case 1: 
                        case 2: {
                            n3 = nArray[27];
                            n = this.menuOriginalY + nArray[33];
                            break block0;
                        }
                        case 3: {
                            n3 = nArray[28];
                            n = this.menuOriginalY + nArray[34];
                            break block0;
                        }
                        case 4: {
                            n3 = nArray[29];
                            n = this.menuOriginalY + nArray[35];
                            break block0;
                        }
                        case 5: {
                            n3 = nArray[30];
                            n = this.menuOriginalY + nArray[36];
                            break block0;
                        }
                    }
                    break;
                }
                case 2: {
                    switch (this.numberOfHintTextRows) {
                        case 0: {
                            IWidgetLogChannel.logChannel.log(100000, "InstructionTextLayout#layoutCenterAreaMenuTouchfield numberOfHintTextRows is 0 - no hint text is shown");
                        }
                        case 1: 
                        case 2: {
                            n3 = nArray[27];
                            n = this.menuOriginalY + nArray[33];
                            break block0;
                        }
                        case 3: 
                        case 4: {
                            n3 = nArray[28];
                            n = this.menuOriginalY + nArray[34];
                            break block0;
                        }
                    }
                    n3 = nArray[30];
                    n = this.menuOriginalY + nArray[36];
                    break;
                }
                case 3: {
                    switch (this.numberOfHintTextRows) {
                        case 0: {
                            IWidgetLogChannel.logChannel.log(100000, "InstructionTextLayout#layoutCenterAreaMenuTouchfield numberOfHintTextRows is 0 - no hint text is shown");
                        }
                        case 1: 
                        case 2: {
                            n3 = nArray[27];
                            n = this.menuOriginalY + nArray[33];
                            break block0;
                        }
                        case 3: {
                            n3 = nArray[28];
                            n = this.menuOriginalY + nArray[34];
                            break block0;
                        }
                        case 4: {
                            n3 = nArray[29];
                            n = this.menuOriginalY + nArray[35];
                            break block0;
                        }
                    }
                    n3 = nArray[30];
                    n = this.menuOriginalY + nArray[36];
                    break;
                }
                case 4: {
                    switch (this.numberOfHintTextRows) {
                        case 0: {
                            IWidgetLogChannel.logChannel.log(100000, "InstructionTextLayout#layoutCenterAreaMenuTouchfield numberOfHintTextRows is 0 - no hint text is shown");
                        }
                        case 1: {
                            n3 = nArray[26];
                            n = this.menuOriginalY + nArray[32];
                            break block0;
                        }
                        case 2: {
                            n3 = nArray[27];
                            n = this.menuOriginalY + nArray[33];
                            break block0;
                        }
                        case 3: {
                            n3 = nArray[28];
                            n = this.menuOriginalY + nArray[34];
                            break block0;
                        }
                    }
                    n3 = nArray[29];
                    n = this.menuOriginalY + nArray[35];
                    break;
                }
                case 5: 
                case 6: {
                    switch (this.numberOfHintTextRows) {
                        case 0: {
                            IWidgetLogChannel.logChannel.log(100000, "InstructionTextLayout#layoutCenterAreaMenuTouchfield numberOfHintTextRows is 0 - no hint text is shown");
                        }
                        case 1: {
                            n3 = nArray[26];
                            n = this.menuOriginalY + nArray[32];
                            break block0;
                        }
                        case 2: {
                            n3 = nArray[27];
                            n = this.menuOriginalY + nArray[33];
                            break block0;
                        }
                        case 3: {
                            n3 = nArray[28];
                            n = this.menuOriginalY + nArray[34];
                            break block0;
                        }
                    }
                    n3 = nArray[29];
                    n = this.menuOriginalY + nArray[35];
                    break;
                }
            }
            menuController.setY(n);
            menuController.getLayout().setBackgroundVerticalDimension(-n + this.menuOriginalY, this.menuOriginalHeight);
            glassplateController.setSeparatorVisible(true);
            glassplateController.setSeparatorYPosition(n - this.menuOriginalY + nArray[39]);
            menuController.setHeight(this.menuOriginalHeight - glassplateController.getSeparatorYPosition());
            menuController.relayout();
            IWidgetLogChannel.menuLogCh.log(10000000, "InstructionTextLayout#InstructionTextLayout: refresh menu because of layout change: %1", (Object)menuController);
            menuController.refreshAllItems();
            ScrollbarController scrollbarController = (ScrollbarController)menuController.getChildOfRole(3);
            if (scrollbarController != null) {
                scrollbarController.setHeight(menuController.getHeight() - 20);
            }
        } else {
            glassplateController.setSeparatorVisible(false);
            n3 = menuController.getHeight();
        }
        this.layoutHintText(instructionTextContoller, menuController, nArray, n3);
        this.setClippingBorders(menuController, -n + this.menuOriginalY, this.menuOriginalHeight, glassplateController.getSeparatorYPosition());
    }

    private void layoutHintText(InstructionTextContoller instructionTextContoller, MenuController menuController, int[] nArray, int n) {
        LabelController labelController = instructionTextContoller.getHintText();
        if (labelController != null) {
            int n2 = nArray[40];
            int n3 = nArray[41];
            int n4 = this.menuOriginalY;
            if (labelController.getRenderer() instanceof LabelRenderer) {
                LabelRenderer labelRenderer = (LabelRenderer)labelController.getRenderer();
                labelRenderer.setAlignment(instructionTextContoller.getHintTextHorizontalOrientation(), 5);
                labelRenderer.setLineHeight(nArray[47]);
            }
            int n5 = menuController.getWidth() - n2 - n3;
            int n6 = menuController.getX() + n2;
            if (instructionTextContoller.getHintTextIconLeftSide() != null) {
                boolean bl;
                IconController iconController = instructionTextContoller.getHintTextIconLeftSide();
                int n7 = nArray[52];
                int n8 = nArray[50];
                int n9 = n7 + 25 + n8;
                int n10 = labelController.getPreferredWidth();
                int n11 = n6 + (menuController.getWidth() - n10) / 2;
                boolean bl2 = bl = n11 - n9 >= 0;
                if (bl) {
                    iconController.setX(menuController.getX() + (menuController.getWidth() - n10) / 2 - 25 - n8);
                    n5 = menuController.getWidth();
                    n6 -= n2;
                } else {
                    n6 = menuController.getX() + n9;
                    n5 -= n9;
                    iconController.setX(menuController.getX() + n7);
                }
                iconController.setY(this.menuOriginalY + (n - labelController.getPreferredHeight()) / 2 - nArray[51]);
            }
            labelController.setBounds(n6, n4, n5, n);
        } else if (instructionTextContoller.getHintTextMenu() != null) {
            MenuController menuController2 = instructionTextContoller.getHintTextMenu();
            if (this.hintTextOriginalY == Integer.MIN_VALUE) {
                this.hintTextOriginalY = menuController2.getY();
            }
            int n12 = nArray[19] + nArray[49];
            if (this.numberOfHintTextRows > 1) {
                n12 = 0;
            }
            menuController2.setY(this.hintTextOriginalY + n12);
        } else {
            IWidgetLogChannel.logChannel.log(10000, "InstructionTextLayout#layoutHintText hintText is null - text might be aligned wrong");
        }
    }

    public void flushCache() {
    }

    public void setMaxWidth(int n) {
        if (n > 0) {
            this.maxWidth = n;
        }
    }

    public void setViewSizeAnimation(float f2, float[] fArray, float[] fArray2, boolean bl) {
        if (fArray != null && fArray.length > 0) {
            this.currentWidthWeight = fArray[0];
        }
    }

    public void setViewSizeAnimationFinished(float[] fArray, boolean bl) {
        if (fArray != null && fArray.length > 0) {
            this.currentWidthWeight = fArray[0];
        }
    }

    private int getCurrentWidth() {
        if (this.currentWidthWeight == Float.MIN_VALUE) {
            return this.width;
        }
        int n = this.width;
        if (0.0f <= this.currentWidthWeight && this.currentWidthWeight <= 1.0f && this.width > this.maximumWidthSmallStage) {
            int n2 = this.width - this.maximumWidthSmallStage;
            n = Math.round((float)this.maximumWidthSmallStage + (float)n2 * (1.0f - this.currentWidthWeight));
        }
        return n;
    }

    public void setTouchfieldLayout(boolean bl) {
        this.touchfieldLayout = bl;
    }

    public void viewSizeTargetChanged(float[] fArray, float[] fArray2, boolean bl) {
    }

    public void viewSizeAnimationStarted(float f2, float[] fArray, float[] fArray2) {
    }
}

