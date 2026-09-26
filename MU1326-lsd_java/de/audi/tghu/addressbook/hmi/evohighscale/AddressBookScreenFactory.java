/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.addressbook.hmi.evohighscale;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.LabelModel;
import de.audi.atip.hmi.model.ResourceLocatorModel;
import de.audi.atip.hmi.model.SpellerModel;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.list.TiledListModel;
import de.audi.atip.hmi.model.sysconst.SysConstModel;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.hmi.view.HMIView;
import de.audi.atip.hmi.view.IDrawerController;
import de.audi.atip.hmi.view.IPartialPopupController;
import de.audi.atip.hmi.view.Screen;
import de.audi.tghu.addressbook.hmi.evohighscale.AddressBookScreenBag1;
import de.audi.tghu.addressbook.hmi.evohighscale.FontFactory;
import de.esolutions.hmi.widgets.audi.base.FontLoader;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.InstructionTextContoller;
import de.esolutions.hmi.widgets.audi.evo.ScreenWidgetEVO;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ContainerRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.FocusCursorRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconLabelController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MirroredContainerController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MultiLineLabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PartialPopupGlassplateRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PartialPopupRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ScreenRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.menu.MenuRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.FocusCursorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.GlassplateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ImageDecoratorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupGlassplateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupStub;
import de.esolutions.hmi.widgets.audi.evo.widgets.ProgressIconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SharedTextureController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SmallStageApplicationIconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.WaitAnimController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.InfoLineRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.ListController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuSDSNumbersController;
import java.util.NoSuchElementException;

public class AddressBookScreenFactory
extends AbstractScreenFactory {
    private static HMIService hmiService;
    private static final int MODULE_ID;
    private int[][] errorColors;
    public AbstractWidgetController[][] refWidgets = new AbstractWidgetController[8][6];

    public AddressBookScreenFactory(IFrameworkAccess iFrameworkAccess) {
        super(7, iFrameworkAccess);
        hmiService = iFrameworkAccess.getHMIService();
    }

    private int[][] getErrorColors() {
        if (this.errorColors == null) {
            this.errorColors = new int[][]{{255, -2004317953}, {255, -2004317953}, {255, -2004317953}, {255, -2004317953}, {255, -2004317953}};
        }
        return this.errorColors;
    }

    @Override
    public String getName() {
        return "HMIAddressBookEvoHighScale";
    }

    IWrappedFont[] getFonts(int n, int n2) {
        return FontFactory.getFonts(n, n2, this.getFramework());
    }

    public static HMIModel getModel(int n, int n2) {
        HMIModel hMIModel = hmiService.getModel(n2, n);
        if (hMIModel == null) {
            throw new NoSuchElementException(new StringBuffer().append("Model (MODELID#").append(n).append(") for terminal ").append(n2).append(" not available.").toString());
        }
        return hMIModel;
    }

    @Override
    public Screen getScreenWithMainArea(int n, int n2) {
        return this.createScreen(n, n2);
    }

    @Override
    public HMIView getWidgetTemplate(int n, int n2) {
        return this.getRefWidget(n, n2, this);
    }

    @Override
    public void clearRefWidgets(int n) {
        int n2 = this.refWidgets[n].length;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.refWidgets[n][i2] = null;
        }
    }

    @Override
    protected Screen createDefaultScreen(int n, int n2) {
        this.getFramework().getLogChannel("Ext.Diashow").log(10000, "SystemScreenFactory#createDefaultScreen(): There's no screen with id: %1", (long)n);
        ScreenWidgetEVO screenWidgetEVO = new ScreenWidgetEVO(0);
        ScreenRendererHigh screenRendererHigh = new ScreenRendererHigh(screenWidgetEVO);
        screenRendererHigh.setFonts(new IWrappedFont[]{(IWrappedFont)((HMITerminalImpl)this.getFramework().getHMIService().getHMITerminal(n2)).getFontLoader().getFont(FontLoader.STANDARD_FONT_PLAIN, 0, 28)});
        screenWidgetEVO.setRenderer(screenRendererHigh);
        screenWidgetEVO.setColorPalettes(this.getErrorColors());
        screenWidgetEVO.setColorIndices(new int[]{0, 1, 1, 1});
        LabelController labelController = new LabelController();
        labelController.setRenderer(new LabelRendererHigh(labelController));
        labelController.setBounds(0, 150, 800, 30);
        LabelModel labelModel = new LabelModel(0);
        labelModel.setText(new StringBuffer().append("There's no screen with id: ").append(n).toString());
        labelController.setModel(labelModel);
        screenWidgetEVO.add(labelController);
        return screenWidgetEVO;
    }

    @Override
    protected Screen createScreen(int n, int n2) {
        switch (n) {
            case 700000: {
                return AddressBookScreenBag1.aDBMODULREFTEMPLATE(this, n2);
            }
            case 700012: {
                return AddressBookScreenBag1.aDBMAIN(this, n2);
            }
            case 700005: {
                return AddressBookScreenBag1.aDBOPTDETAILVIEWMAIN(this, n2);
            }
            case 700006: {
                return AddressBookScreenBag1.aDBOPTSETUPMAIN(this, n2);
            }
            case 700007: {
                return AddressBookScreenBag1.aDBOPTSETUPMEMORYMAIN(this, n2);
            }
            case 700010: {
                return AddressBookScreenBag1.aDBOPTSETUPDOWNLOADMAIN(this, n2);
            }
            case 700011: {
                return AddressBookScreenBag1.aDBOPTSETUPIMPORTMAIN(this, n2);
            }
            case 700013: {
                return AddressBookScreenBag1.aDBOPTSETUPEXPORTLISTMAIN(this, n2);
            }
            case 700024: {
                return AddressBookScreenBag1.aDBOPTCALLMAIN(this, n2);
            }
            case 700025: {
                return AddressBookScreenBag1.aDBOPTNAVIGATEMAIN(this, n2);
            }
            case 700027: {
                return AddressBookScreenBag1.aDBOPTSETUPEXPORTMAIN(this, n2);
            }
            case 700029: {
                return AddressBookScreenBag1.aDBOPTSETUPEXPORTPROCESSWAIT(this, n2);
            }
            case 700030: {
                return AddressBookScreenBag1.aDBOPTSETUPEXPORTPROCESSEND(this, n2);
            }
            case 700031: {
                return AddressBookScreenBag1.aDBOPTSETUPIMPORTLISTMAIN(this, n2);
            }
            case 700032: {
                return AddressBookScreenBag1.aDBOPTSETUPIMPORTPROCESSEND(this, n2);
            }
            case 700033: {
                return AddressBookScreenBag1.aDBOPTSETUPIMPORTPROCESSWAIT(this, n2);
            }
            case 700059: {
                return AddressBookScreenBag1.aDBDESKTOPWAIT(this, n2);
            }
            case 700015: {
                return AddressBookScreenBag1.sDSADBPICKLISTNAME(this, n2);
            }
            case 700023: {
                return AddressBookScreenBag1.sDSADBPICKLISTNAVIGATENAME(this, n2);
            }
            case 700045: {
                return AddressBookScreenBag1.aDBSDSPOPUPCONTACT(this, n2);
            }
            case 700018: {
                return AddressBookScreenBag1.tELSDSCONTACT(this, n2);
            }
        }
        return this.createDefaultScreen(n, n2);
    }

    public AbstractWidgetController getRefWidget(int n, int n2, AddressBookScreenFactory addressBookScreenFactory) {
        AbstractWidgetController abstractWidgetController = null;
        switch (n2) {
            case 0: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127, 127});
                iconController.setBounds(0, 0, 100, 100);
                abstractWidgetController = iconController;
                break;
            }
            case 1: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127});
                iconController.setBounds(0, 0, 100, 100);
                abstractWidgetController = iconController;
                break;
            }
            case 2: {
                SmallStageApplicationIconController smallStageApplicationIconController = new SmallStageApplicationIconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(smallStageApplicationIconController);
                smallStageApplicationIconController.setRenderer(iconRendererHigh);
                smallStageApplicationIconController.setBitmaps(new int[]{127});
                smallStageApplicationIconController.setBounds(389, 109, 682, 314);
                smallStageApplicationIconController.setCoordinateSets(new int[]{2, 389, 109, 682, 314, 529, 126, 404, 181});
                iconRendererHigh.setScaleMode(3);
                SmallStageApplicationIconController smallStageApplicationIconController2 = new SmallStageApplicationIconController();
                IconRendererHigh iconRendererHigh2 = new IconRendererHigh(smallStageApplicationIconController2);
                smallStageApplicationIconController2.setRenderer(iconRendererHigh2);
                smallStageApplicationIconController2.setBitmaps(new int[]{127, 127, 127, 127, 127, 127, 127, 127, 127, 127});
                smallStageApplicationIconController2.setModelID(138);
                this.refWidgets[n][3] = smallStageApplicationIconController2;
                smallStageApplicationIconController2.setBounds(646, 325, 140, 140);
                smallStageApplicationIconController2.setCoordinateSets(new int[]{2, 646, 325, 140, 140, 666, 240, 100, 100});
                iconRendererHigh2.setScaleFactor(2.0f, 2.0f);
                iconRendererHigh2.setScaleMode(2);
                ContainerController containerController = new ContainerController();
                ContainerRendererHigh containerRendererHigh = new ContainerRendererHigh(containerController);
                containerController.setRenderer(containerRendererHigh);
                containerController.setBounds(0, 0, 0, 0);
                containerController.setEntertainmentMenuTransformation(16449, 16449, -1883081409, -1883081409, 0.0f);
                containerController.setSelectionMenuTransformation(12589380, 35906, -1701242561, -1701242561, 0.0f);
                containerController.add(smallStageApplicationIconController);
                containerController.add(smallStageApplicationIconController2);
                abstractWidgetController = containerController;
                break;
            }
            case 4: {
                PartialPopupGlassplateController partialPopupGlassplateController = new PartialPopupGlassplateController();
                PartialPopupGlassplateRendererHigh partialPopupGlassplateRendererHigh = new PartialPopupGlassplateRendererHigh(partialPopupGlassplateController);
                partialPopupGlassplateController.setRenderer(partialPopupGlassplateRendererHigh);
                partialPopupGlassplateController.setBounds(0, 0, 100, 100);
                LabelController labelController = new LabelController();
                MultiLineLabelRendererHigh multiLineLabelRendererHigh = new MultiLineLabelRendererHigh(labelController);
                labelController.setRenderer(multiLineLabelRendererHigh);
                labelController.setTextIds(new int[]{-508622336});
                labelController.setBounds(0, 0, 0, 109);
                multiLineLabelRendererHigh.setAlignment(2, 4);
                InstructionTextContoller instructionTextContoller = new InstructionTextContoller();
                CompositeRendererHigh compositeRendererHigh = new CompositeRendererHigh(instructionTextContoller);
                instructionTextContoller.setRenderer(compositeRendererHigh);
                instructionTextContoller.setBounds(0, 0, 100, 100);
                instructionTextContoller.setColorIndices(new int[]{1, 0, 4, 0});
                instructionTextContoller.addHintText(labelController);
                PartialPopupController partialPopupController = new PartialPopupController();
                PartialPopupRendererHigh partialPopupRendererHigh = new PartialPopupRendererHigh(partialPopupController);
                partialPopupController.setRenderer(partialPopupRendererHigh);
                partialPopupController.setAutoHideTime(3000);
                partialPopupController.setBounds(400, 400, 634, 128);
                partialPopupController.setConsumeDDSPress(1);
                partialPopupController.setConsumeHKReturn(1);
                partialPopupController.setContentInset(10);
                partialPopupController.setDynamicSize(true);
                partialPopupController.setGreyOutBackground(true);
                partialPopupController.setID(-2102523392);
                partialPopupController.setLayer(1);
                partialPopupController.setPriority(1200);
                partialPopupController.setStyle(1);
                partialPopupController.setZpmPriority(250);
                partialPopupController.setZpmSlot(12);
                partialPopupController.setBackgroundController(partialPopupGlassplateController);
                partialPopupController.add(instructionTextContoller);
                abstractWidgetController = partialPopupController;
                break;
            }
            case 5: {
                PartialPopupGlassplateController partialPopupGlassplateController = new PartialPopupGlassplateController();
                PartialPopupGlassplateRendererHigh partialPopupGlassplateRendererHigh = new PartialPopupGlassplateRendererHigh(partialPopupGlassplateController);
                partialPopupGlassplateController.setRenderer(partialPopupGlassplateRendererHigh);
                partialPopupGlassplateController.setBounds(0, 0, 100, 100);
                partialPopupGlassplateController.setSeparatorYPosition(59);
                LabelController labelController = new LabelController();
                MultiLineLabelRendererHigh multiLineLabelRendererHigh = new MultiLineLabelRendererHigh(labelController);
                labelController.setRenderer(multiLineLabelRendererHigh);
                labelController.setTextIds(new int[]{682625536});
                labelController.setBounds(0, 0, 0, 109);
                multiLineLabelRendererHigh.setAlignment(2, 4);
                FocusCursorController focusCursorController = new FocusCursorController();
                FocusCursorRendererHigh focusCursorRendererHigh = new FocusCursorRendererHigh(focusCursorController);
                focusCursorController.setRenderer(focusCursorRendererHigh);
                focusCursorController.setBounds(0, 0, 100, 100);
                focusCursorController.setColorIndices(new int[]{1, 2, 4, 0});
                focusCursorController.setOptionsIconVisible(false);
                MenuItemController menuItemController = new MenuItemController();
                CompositeRendererHigh compositeRendererHigh = new CompositeRendererHigh(menuItemController);
                menuItemController.setRenderer(compositeRendererHigh);
                menuItemController.setLabelId(716179968);
                menuItemController.setGlassplateInsetsBottom(6);
                menuItemController.setGlassplateInsetsTop(7);
                menuItemController.setInternalID(2075003392);
                menuItemController.setType(2);
                MenuController menuController = new MenuController();
                MenuRendererHigh menuRendererHigh = new MenuRendererHigh(menuController);
                menuController.setRenderer(menuRendererHigh);
                menuController.createInfolineWidgets(new InfoLineRendererHigh());
                menuController.getInfoline().getInfolineRenderer().setFonts(addressBookScreenFactory.getFonts(1, n));
                menuController.setDefaultDisabledInfolineTextId(-1028650496);
                menuController.getInfolineTimer().setIdleTime(800);
                menuController.getInfoline().setColorIndices(new int[]{2, 0, 4, 3});
                menuController.getLayout().setBackgroundInsetsVert(7);
                menuController.getLayout().setContentLeftOffset(12);
                menuController.getLayout().setContentRightOffset(25);
                menuController.getLayout().setContentRightOffsetSmallStage(25);
                menuController.getLayout().setOptionsIconAdditionalRightInsets(16);
                menuController.setBounds(0, 0, 634, 350);
                menuController.setColorIndices(new int[]{1, 0, 4, 0, 2, 3});
                menuController.add(focusCursorController, 1);
                menuController.add(menuItemController);
                InstructionTextContoller instructionTextContoller = new InstructionTextContoller();
                CompositeRendererHigh compositeRendererHigh2 = new CompositeRendererHigh(instructionTextContoller);
                instructionTextContoller.setRenderer(compositeRendererHigh2);
                instructionTextContoller.setBounds(0, 0, 100, 100);
                instructionTextContoller.setColorIndices(new int[]{1, 0, 4, 0});
                instructionTextContoller.addHintText(labelController);
                instructionTextContoller.setOptions(menuController);
                PartialPopupController partialPopupController = new PartialPopupController();
                PartialPopupRendererHigh partialPopupRendererHigh = new PartialPopupRendererHigh(partialPopupController);
                partialPopupController.setRenderer(partialPopupRendererHigh);
                partialPopupController.setBounds(400, 400, 634, 128);
                partialPopupController.setConsumeDDSPress(1);
                partialPopupController.setConsumeHKReturn(1);
                partialPopupController.setConsumeJoystickEast(2);
                partialPopupController.setConsumeJoystickWest(2);
                partialPopupController.setConsumeKeyTurned(4);
                partialPopupController.setConsumeSKPress(4);
                partialPopupController.setDynamicSize(true);
                partialPopupController.setGreyOutBackground(true);
                partialPopupController.setID(-2085746176);
                partialPopupController.setLayer(1);
                partialPopupController.setPriority(1200);
                partialPopupController.setStyle(1);
                partialPopupController.setZpmPriority(250);
                partialPopupController.setZpmSlot(12);
                partialPopupController.setBackgroundController(partialPopupGlassplateController);
                partialPopupController.add(instructionTextContoller);
                abstractWidgetController = partialPopupController;
                break;
            }
            default: {
                this.getFramework().getLogChannel("ScreenFactory").log(10000, new StringBuffer().append("Invalid reference widget id ").append(n2).append(".").toString());
            }
        }
        this.refWidgets[n][n2] = abstractWidgetController;
        return abstractWidgetController;
    }

    protected static final boolean evalCond700049(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(363, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(367, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(360, n)).getValue() == 1;
    }

    protected static final boolean evalCond700084(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(310, n)).getValue() > 0 && (((LabelModel)AddressBookScreenFactory.getModel(-1867511296, n)).getLength() <= 0 || ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 3);
    }

    protected static final boolean evalCond700237(int n) {
        return ((TiledListModel)AddressBookScreenFactory.getModel(598739456, n)).getLength() == 0;
    }

    protected static final boolean evalCond700238(int n) {
        return ((TiledListModel)AddressBookScreenFactory.getModel(598739456, n)).getLength() == 0;
    }

    protected static final boolean evalCond700239(int n) {
        return ((TiledListModel)AddressBookScreenFactory.getModel(800066048, n)).getLength() == 0 && ((ChoiceModel)AddressBookScreenFactory.getModel(967838208, n)).getStatus() == 1;
    }

    protected static final boolean evalCond700240(int n) {
        return ((TiledListModel)AddressBookScreenFactory.getModel(800066048, n)).getLength() == 0;
    }

    protected static final boolean evalCond700303(int n) {
        return ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() != 1 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 3 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 2 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 4 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 5;
    }

    protected static final boolean evalCond700304(int n) {
        return ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(335, n)).getValue() != 2 && ((ChoiceModel)AddressBookScreenFactory.getModel(335, n)).getValue() != 3 && ((ChoiceModel)AddressBookScreenFactory.getModel(335, n)).getValue() != 8 && ((ChoiceModel)AddressBookScreenFactory.getModel(335, n)).getValue() != 9;
    }

    protected static final boolean evalCond700373(int n) {
        return ((TiledListModel)AddressBookScreenFactory.getModel(-1297085952, n)).getLength() == 0 && ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() != 1 || ((SpellerModel)AddressBookScreenFactory.getModel(-1330640384, n)).isEmpty() && ((TiledListModel)AddressBookScreenFactory.getModel(-1297085952, n)).getLength() == 0 && ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() == 1 || ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() == 1 && !((SpellerModel)AddressBookScreenFactory.getModel(-1330640384, n)).isEmpty() && ((ChoiceModel)AddressBookScreenFactory.getModel(1739590144, n)).getValue() == 0 && ((BaseListModel)AddressBookScreenFactory.getModel(-1280308736, n)).getLength() == 0;
    }

    protected static final boolean evalCond700375(int n) {
        return ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() == 1 && !((SpellerModel)AddressBookScreenFactory.getModel(-1330640384, n)).isEmpty();
    }

    protected static final boolean evalCond700376(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(3853, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(1236273664, n)).getValue() == 1 && (((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() != 1 || ((ChoiceModel)AddressBookScreenFactory.getModel(5588, n)).getValue() != 1);
    }

    protected static final boolean evalCond700445(int n) {
        return ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() == 1 && ((SpellerModel)AddressBookScreenFactory.getModel(-1330640384, n)).isEmpty() || ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() != 1;
    }

    protected static final boolean evalCond700516(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(14, n)).getValue() == 0 && ((ChoiceModel)AddressBookScreenFactory.getModel(335, n)).getValue() != 2 && ((ChoiceModel)AddressBookScreenFactory.getModel(335, n)).getValue() != 3 && ((ChoiceModel)AddressBookScreenFactory.getModel(335, n)).getValue() != 8 && ((ChoiceModel)AddressBookScreenFactory.getModel(335, n)).getValue() != 9;
    }

    protected static final boolean evalCond700517(int n) {
        return ((LabelModel)AddressBookScreenFactory.getModel(430967296, n)).getLength() > 0;
    }

    protected static final boolean evalCond700638(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(2075134464, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond700643(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(2075134464, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond700677(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(5588, n)).getValue() == 1 || ((TiledListModel)AddressBookScreenFactory.getModel(598739456, n)).getLength() == 0;
    }

    protected static final boolean evalCond700679(int n) {
        return (((BaseListModel)AddressBookScreenFactory.getModel(-1280308736, n)).getLength() > 100 || ((BaseListModel)AddressBookScreenFactory.getModel(-1280308736, n)).getLength() == 100) && !((SpellerModel)AddressBookScreenFactory.getModel(-1330640384, n)).isEmpty();
    }

    protected static final boolean evalCond700713(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(17, n)).getValue() == 2;
    }

    protected static final boolean evalCond700714(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(17, n)).getValue() == 1;
    }

    protected static final boolean evalCond700715(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(17, n)).getValue() == 0;
    }

    protected static final boolean evalCond700716(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(14, n)).getStatus() == 0 && ((ChoiceModel)AddressBookScreenFactory.getModel(335, n)).getValue() != 2 && ((ChoiceModel)AddressBookScreenFactory.getModel(335, n)).getValue() != 3 && ((ChoiceModel)AddressBookScreenFactory.getModel(335, n)).getValue() != 8 && ((ChoiceModel)AddressBookScreenFactory.getModel(335, n)).getValue() != 9;
    }

    protected static final boolean evalCond700717(int n) {
        return (((TiledListModel)AddressBookScreenFactory.getModel(-1297085952, n)).getLength() == 0 && ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() != 1 || ((SpellerModel)AddressBookScreenFactory.getModel(-1330640384, n)).isEmpty() && ((TiledListModel)AddressBookScreenFactory.getModel(-1297085952, n)).getLength() == 0 && ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() == 1 || ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() == 1 && !((SpellerModel)AddressBookScreenFactory.getModel(-1330640384, n)).isEmpty() && ((ChoiceModel)AddressBookScreenFactory.getModel(1739590144, n)).getValue() == 0 && ((BaseListModel)AddressBookScreenFactory.getModel(-1280308736, n)).getLength() == 0) && ((ChoiceModel)AddressBookScreenFactory.getModel(14, n)).getStatus() == 0 && ((SpellerModel)AddressBookScreenFactory.getModel(-1330640384, n)).isEmpty();
    }

    protected static final boolean evalCond700857(int n) {
        return ((BaseListModel)AddressBookScreenFactory.getModel(1840253440, n)).getLength() == 0 && ((BaseListModel)AddressBookScreenFactory.getModel(1857030656, n)).getLength() == 0 && ((BaseListModel)AddressBookScreenFactory.getModel(1873807872, n)).getLength() == 0;
    }

    protected static final boolean evalCond701008(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(17, n)).getValue() == 0;
    }

    protected static final boolean evalCond701009(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(17, n)).getValue() == 1;
    }

    protected static final boolean evalCond701010(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(17, n)).getValue() == 2;
    }

    protected static final boolean evalCond701035(int n) {
        return ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() == 3 || ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() == 2 || ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() == 4 || ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() == 5;
    }

    protected static final boolean evalCond701036(int n) {
        return ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() == 1;
    }

    protected static final boolean evalCond701037(int n) {
        return ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() == 1;
    }

    protected static final boolean evalCond701152(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(17, n)).getValue() == 0;
    }

    protected static final boolean evalCond701153(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(17, n)).getValue() == 1;
    }

    protected static final boolean evalCond701154(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(17, n)).getValue() == 2;
    }

    protected static final boolean evalCond701198(int n) {
        return (((TiledListModel)AddressBookScreenFactory.getModel(-1297085952, n)).getLength() == 0 && ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() != 1 || ((SpellerModel)AddressBookScreenFactory.getModel(-1330640384, n)).isEmpty() && ((TiledListModel)AddressBookScreenFactory.getModel(-1297085952, n)).getLength() == 0 && ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() == 1 || ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() == 1 && !((SpellerModel)AddressBookScreenFactory.getModel(-1330640384, n)).isEmpty() && ((ChoiceModel)AddressBookScreenFactory.getModel(1739590144, n)).getValue() == 0 && ((BaseListModel)AddressBookScreenFactory.getModel(-1280308736, n)).getLength() == 0) && ((ChoiceModel)AddressBookScreenFactory.getModel(14, n)).getStatus() == 0 && ((SpellerModel)AddressBookScreenFactory.getModel(-1330640384, n)).isEmpty();
    }

    protected static final boolean evalCond701199(int n) {
        return ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() != 0;
    }

    protected static final boolean evalCond701200(int n) {
        return ((LabelModel)AddressBookScreenFactory.getModel(-1867511296, n)).getLength() <= 0 || ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 3;
    }

    protected static final boolean evalCond701201(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(310, n)).getValue() > 0 && ((LabelModel)AddressBookScreenFactory.getModel(-1867511296, n)).getLength() > 0 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() == 3;
    }

    protected static final boolean evalCond701202(int n) {
        return ((LabelModel)AddressBookScreenFactory.getModel(-1867511296, n)).getLength() > 0 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() == 3;
    }

    protected static final boolean evalCond701203(int n) {
        return ((LabelModel)AddressBookScreenFactory.getModel(-1867511296, n)).getLength() <= 0 || ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 3;
    }

    protected static final boolean evalCond701204(int n) {
        return ((LabelModel)AddressBookScreenFactory.getModel(-1867511296, n)).getLength() > 0 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() == 3;
    }

    protected static final boolean evalCond701205(int n) {
        return ((LabelModel)AddressBookScreenFactory.getModel(430967296, n)).getLength() > 0;
    }

    protected static final boolean evalCond701207(int n) {
        return ((BaseListModel)AddressBookScreenFactory.getModel(1840253440, n)).getLength() == 0 && ((BaseListModel)AddressBookScreenFactory.getModel(1857030656, n)).getLength() == 0 && ((BaseListModel)AddressBookScreenFactory.getModel(1873807872, n)).getLength() == 0;
    }

    protected static final boolean evalCond701209(int n) {
        return ((LabelModel)AddressBookScreenFactory.getModel(-1867511296, n)).getLength() > 0;
    }

    protected static final boolean evalCond701211(int n) {
        return ((LabelModel)AddressBookScreenFactory.getModel(-1867511296, n)).getLength() <= 0 || ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 3;
    }

    protected static final boolean evalCond701212(int n) {
        return ((LabelModel)AddressBookScreenFactory.getModel(-1867511296, n)).getLength() > 0 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() == 3;
    }

    protected static final boolean evalCond701301(int n) {
        return (((TiledListModel)AddressBookScreenFactory.getModel(-1297085952, n)).getLength() == 0 && ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() != 1 || ((SpellerModel)AddressBookScreenFactory.getModel(-1330640384, n)).isEmpty() && ((TiledListModel)AddressBookScreenFactory.getModel(-1297085952, n)).getLength() == 0 && ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() == 1 || ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() == 1 && !((SpellerModel)AddressBookScreenFactory.getModel(-1330640384, n)).isEmpty() && ((ChoiceModel)AddressBookScreenFactory.getModel(1739590144, n)).getValue() == 0 && ((BaseListModel)AddressBookScreenFactory.getModel(-1280308736, n)).getLength() == 0) && ((ChoiceModel)AddressBookScreenFactory.getModel(14, n)).getStatus() == 0 && ((SpellerModel)AddressBookScreenFactory.getModel(-1330640384, n)).isEmpty();
    }

    protected static final boolean evalCond701358(int n) {
        return ((TiledListModel)AddressBookScreenFactory.getModel(-1297085952, n)).getLength() == 0 && ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() != 1 || ((SpellerModel)AddressBookScreenFactory.getModel(-1330640384, n)).isEmpty() && ((TiledListModel)AddressBookScreenFactory.getModel(-1297085952, n)).getLength() == 0 && ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() == 1 || ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() == 1 && !((SpellerModel)AddressBookScreenFactory.getModel(-1330640384, n)).isEmpty() && ((ChoiceModel)AddressBookScreenFactory.getModel(1739590144, n)).getValue() == 0 && ((BaseListModel)AddressBookScreenFactory.getModel(-1280308736, n)).getLength() == 0 || ((ChoiceModel)AddressBookScreenFactory.getModel(14, n)).getStatus() == 0;
    }

    protected static final boolean evalCond701434(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(186, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond701435(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(177, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond701436(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(177, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond701437(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(177, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond701438(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(177, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond701439(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(4091, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond701440(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(-1684667392, n)).getValue() != 1 && ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond701441(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(177, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond701442(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(-803273216, n)).getValue() != 1 && ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond701443(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(155, n)).getValue() > 0 && ((ChoiceModel)AddressBookScreenFactory.getModel(4646, n)).getValue() == 1 && (((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() != 0 || ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 3 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 2 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 4 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 5) && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 3 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 2 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 4 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 5 && ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 3 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 2 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 4 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 5;
    }

    protected static final boolean evalCond701444(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(154, n)).getValue() > 0 && ((ChoiceModel)AddressBookScreenFactory.getModel(4649, n)).getValue() == 1 && (((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() != 0 || ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 3 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 2 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 4 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 5) && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 3 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 2 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 4 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 5 && ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 3 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 2 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 4 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 5;
    }

    protected static final boolean evalCond701446(int n) {
        return ((SysConstModel)AddressBookScreenFactory.getModel(522, n)).getValue() == 4;
    }

    protected static final boolean evalCond701447(int n) {
        return ((SysConstModel)AddressBookScreenFactory.getModel(522, n)).getValue() == 4;
    }

    protected static final boolean evalCond701448(int n) {
        return ((SysConstModel)AddressBookScreenFactory.getModel(522, n)).getValue() == 4;
    }

    protected static final boolean evalCond701449(int n) {
        return ((SysConstModel)AddressBookScreenFactory.getModel(522, n)).getValue() == 4;
    }

    protected static final boolean evalCond701450(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(162, n)).getValue() > 99 && ((ChoiceModel)AddressBookScreenFactory.getModel(1780221440, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(2075134464, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(5624, n)).getValue() == 0;
    }

    protected static final boolean evalCond701452(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(162, n)).getValue() > 0 && ((ChoiceModel)AddressBookScreenFactory.getModel(162, n)).getValue() < 100 && ((ChoiceModel)AddressBookScreenFactory.getModel(1780221440, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(2075134464, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond701453(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(2075134464, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1 || ((ResourceLocatorModel)AddressBookScreenFactory.getModel(1555040768, n)).getStatus() == 1 && (((ChoiceModel)AddressBookScreenFactory.getModel(5605, n)).getValue() != 1 || ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() != 1);
    }

    protected static final boolean evalCond701454(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(2075134464, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1 || ((ResourceLocatorModel)AddressBookScreenFactory.getModel(1555040768, n)).getStatus() == 1 && (((ChoiceModel)AddressBookScreenFactory.getModel(5605, n)).getValue() != 1 || ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() != 1);
    }

    protected static final boolean evalCond701455(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(2075134464, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1 || ((ResourceLocatorModel)AddressBookScreenFactory.getModel(1555040768, n)).getStatus() == 1 && (((ChoiceModel)AddressBookScreenFactory.getModel(5605, n)).getValue() != 1 || ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() != 1);
    }

    protected static final boolean evalCond701456(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(2075134464, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1 || ((ResourceLocatorModel)AddressBookScreenFactory.getModel(1555040768, n)).getStatus() == 1 && (((ChoiceModel)AddressBookScreenFactory.getModel(5605, n)).getValue() != 1 || ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() != 1);
    }

    protected static final boolean evalCond701457(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(2075134464, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1 || ((ResourceLocatorModel)AddressBookScreenFactory.getModel(1555040768, n)).getStatus() == 1 && (((ChoiceModel)AddressBookScreenFactory.getModel(5605, n)).getValue() != 1 || ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() != 1);
    }

    protected static final boolean evalCond701458(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(2075134464, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1 || ((ResourceLocatorModel)AddressBookScreenFactory.getModel(1555040768, n)).getStatus() == 1 && (((ChoiceModel)AddressBookScreenFactory.getModel(5605, n)).getValue() != 1 || ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() != 1);
    }

    protected static final boolean evalCond701459(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(2075134464, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1 || ((ResourceLocatorModel)AddressBookScreenFactory.getModel(1555040768, n)).getStatus() == 1 && (((ChoiceModel)AddressBookScreenFactory.getModel(5605, n)).getValue() != 1 || ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() != 1);
    }

    protected static final boolean evalCond701460(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(162, n)).getValue() > 99 && ((ChoiceModel)AddressBookScreenFactory.getModel(1780221440, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(2075134464, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(5624, n)).getValue() == 0;
    }

    protected static final boolean evalCond701462(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(162, n)).getValue() > 0 && ((ChoiceModel)AddressBookScreenFactory.getModel(162, n)).getValue() < 100 && ((ChoiceModel)AddressBookScreenFactory.getModel(1780221440, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(2075134464, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond701463(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(2075134464, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond701464(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(2075134464, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond701465(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(2075134464, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond701466(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(2075134464, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond701467(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(2075134464, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond701468(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(2075134464, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond701469(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(2075134464, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond701470(int n) {
        return ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 3 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 2 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 4 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 5 && ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 3 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 2 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 4 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 5;
    }

    protected static final boolean evalCond701471(int n) {
        return !(((ResourceLocatorModel)AddressBookScreenFactory.getModel(1555040768, n)).getStatus() != 1 || ((ChoiceModel)AddressBookScreenFactory.getModel(5605, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() == 1 || ((ChoiceModel)AddressBookScreenFactory.getModel(2075134464, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1);
    }

    protected static final boolean evalCond701472(int n) {
        return (((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() != 1 || ((ChoiceModel)AddressBookScreenFactory.getModel(5588, n)).getValue() != 1) && ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond701473(int n) {
        return ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() != 0;
    }

    protected static final boolean evalCond701477(int n) {
        return ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)AddressBookScreenFactory.getModel(1396838144, n)).getValue() == 1;
    }

    protected static final boolean evalCond701499(int n) {
        return !(((ChoiceModel)AddressBookScreenFactory.getModel(5593, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() == 1 || ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(5588, n)).getValue() == 1 || ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() != 0);
    }

    protected static final boolean evalCond701500(int n) {
        return !(((ChoiceModel)AddressBookScreenFactory.getModel(5593, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() == 1 || ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(5588, n)).getValue() == 1 || ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() != 0);
    }

    protected static final boolean evalCond701501(int n) {
        return !(((ChoiceModel)AddressBookScreenFactory.getModel(5593, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() == 1 || ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(5588, n)).getValue() == 1 || ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() != 0);
    }

    protected static final boolean evalCond701502(int n) {
        return !(((ChoiceModel)AddressBookScreenFactory.getModel(5593, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() == 1 || ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(5588, n)).getValue() == 1 || ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() != 0);
    }

    protected static final boolean evalCond701503(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(5588, n)).getValue() == 1;
    }

    protected static final boolean evalCond701504(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(5588, n)).getValue() == 1;
    }

    protected static final boolean evalCond701505(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(5588, n)).getValue() == 1;
    }

    protected static final boolean evalCond701506(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(5588, n)).getValue() == 1;
    }

    protected static final boolean evalCond701507(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(5588, n)).getValue() == 1;
    }

    protected static final boolean evalCond701508(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(5588, n)).getValue() == 1;
    }

    protected static final boolean evalCond701509(int n) {
        return (((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() != 1 || ((ChoiceModel)AddressBookScreenFactory.getModel(5588, n)).getValue() != 1) && ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond701510(int n) {
        return (((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() != 1 || ((ChoiceModel)AddressBookScreenFactory.getModel(5588, n)).getValue() != 1) && ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond701511(int n) {
        return (((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() != 1 || ((ChoiceModel)AddressBookScreenFactory.getModel(5588, n)).getValue() != 1) && ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond701514(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(162, n)).getValue() > 99 && ((ChoiceModel)AddressBookScreenFactory.getModel(1780221440, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(2075134464, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(5624, n)).getValue() == 1;
    }

    protected static final boolean evalCond701515(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(162, n)).getValue() > 99 && ((ChoiceModel)AddressBookScreenFactory.getModel(1780221440, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(2075134464, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(5624, n)).getValue() == 1;
    }

    @Override
    public void executeCondition(int n, int n2, HMIView[] hMIViewArray, int n3) {
        switch (n2) {
            case 700059: {
                this.executeConditionaDBDESKTOPWAITScreen(n, hMIViewArray, n3);
                break;
            }
            case 700012: {
                this.executeConditionaDBMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 700020: {
                this.executeConditionaDBOPTScreen(n, hMIViewArray, n3);
                break;
            }
            case 700005: {
                this.executeConditionaDBOPTDETAILVIEWMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 700010: {
                this.executeConditionaDBOPTSETUPDOWNLOADMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 700013: {
                this.executeConditionaDBOPTSETUPEXPORTLISTMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 700027: {
                this.executeConditionaDBOPTSETUPEXPORTMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 700030: {
                this.executeConditionaDBOPTSETUPEXPORTPROCESSENDScreen(n, hMIViewArray, n3);
                break;
            }
            case 700029: {
                this.executeConditionaDBOPTSETUPEXPORTPROCESSWAITScreen(n, hMIViewArray, n3);
                break;
            }
            case 700031: {
                this.executeConditionaDBOPTSETUPIMPORTLISTMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 700011: {
                this.executeConditionaDBOPTSETUPIMPORTMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 700032: {
                this.executeConditionaDBOPTSETUPIMPORTPROCESSENDScreen(n, hMIViewArray, n3);
                break;
            }
            case 700033: {
                this.executeConditionaDBOPTSETUPIMPORTPROCESSWAITScreen(n, hMIViewArray, n3);
                break;
            }
            case 700006: {
                this.executeConditionaDBOPTSETUPMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 700007: {
                this.executeConditionaDBOPTSETUPMEMORYMAINScreen(n, hMIViewArray, n3);
                break;
            }
        }
    }

    private void executeConditionaDBDESKTOPWAITScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 17: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(-525202944, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-508425728, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((LabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(-491648512, n2));
                break;
            }
            case 3939: {
                if (hMIViewArray[0] == null) break;
                ((WaitAnimController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(263391744, n2));
                break;
            }
        }
    }

    private void executeConditionaDBMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 14: {
                if (hMIViewArray[0] != null) {
                    ((ScreenWidgetEVO)hMIViewArray[0]).setOptionIconVisible(hmiService.getComponentConditionManager().isTrue(1974667776, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(246614528, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((InstructionTextContoller)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(766577152, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((ContainerController)hMIViewArray[3]).setVisible(!hmiService.getComponentConditionManager().isTrue(-1363998208, n2));
                }
                if (hMIViewArray[4] == null) break;
                ((WaitAnimController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(749799936, n2));
                break;
            }
            case 17: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1353845248, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1370622464, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((LabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1387399680, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((LabelController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(733022720, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((LabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(716245504, n2));
                }
                if (hMIViewArray[5] == null) break;
                ((LabelController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(699468288, n2));
                break;
            }
            case 93: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueEqualsCondition(93, n2, 1));
                break;
            }
            case 162: {
                if (hMIViewArray[0] != null) {
                    ((ProgressIconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(213125632, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(179571200, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((IconLabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1253313024, n2));
                break;
            }
            case 310: {
                if (hMIViewArray[0] == null) break;
                ((MenuController)hMIViewArray[0]).setSDSSymbolsVisible(this.evaluateSimpleChoiceModelValueGreaterCondition(310, n2, 0));
                break;
            }
            case 335: {
                if (hMIViewArray[0] != null) {
                    ((TouchController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(-1867576832, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((WaitAnimController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(749799936, n2));
                break;
            }
            case 442: {
                if (hMIViewArray[0] == null) break;
                ((TouchController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(-1884354048, n2));
                break;
            }
            case 522: {
                if (hMIViewArray[0] != null) {
                    ((MirroredContainerController)hMIViewArray[0]).setMirrorEnabled(hmiService.getComponentConditionManager().isTrue(112462336, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MirroredContainerController)hMIViewArray[1]).setMirrorEnabled(hmiService.getComponentConditionManager().isTrue(129239552, n2));
                break;
            }
            case 523: {
                if (hMIViewArray[0] != null) {
                    ((ScreenWidgetEVO)hMIViewArray[0]).setOptionIconVisible(hmiService.getComponentConditionManager().isTrue(1974667776, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(246614528, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((TouchController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(-1867576832, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((ListController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(-676394496, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((TouchController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(-1884354048, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((ListController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(498076160, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((MenuItemController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(-709948928, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((InstructionTextContoller)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(766577152, n2));
                }
                if (hMIViewArray[8] == null) break;
                ((ContainerController)hMIViewArray[8]).setVisible(!hmiService.getComponentConditionManager().isTrue(-1363998208, n2));
                break;
            }
            case 556: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(229902848, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((SharedTextureController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-475002368, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((ProgressIconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(213125632, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(179571200, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((IconLabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(1253313024, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(246680064, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((IconController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(263457280, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((IconController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(280234496, n2));
                }
                if (hMIViewArray[8] != null) {
                    ((IconController)hMIViewArray[8]).setVisible(hmiService.getComponentConditionManager().isTrue(297011712, n2));
                }
                if (hMIViewArray[9] != null) {
                    ((IconController)hMIViewArray[9]).setVisible(hmiService.getComponentConditionManager().isTrue(313788928, n2));
                }
                if (hMIViewArray[10] != null) {
                    ((IconController)hMIViewArray[10]).setVisible(hmiService.getComponentConditionManager().isTrue(330566144, n2));
                }
                if (hMIViewArray[11] == null) break;
                ((ImageDecoratorController)hMIViewArray[11]).setVisible(hmiService.getComponentConditionManager().isTrue(531892736, n2));
                break;
            }
            case 4078: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(229902848, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((SharedTextureController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-475002368, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((ProgressIconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(213125632, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(179571200, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((IconLabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(1253313024, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(246680064, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((IconController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(263457280, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((IconController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(280234496, n2));
                }
                if (hMIViewArray[8] != null) {
                    ((IconController)hMIViewArray[8]).setVisible(hmiService.getComponentConditionManager().isTrue(297011712, n2));
                }
                if (hMIViewArray[9] != null) {
                    ((IconController)hMIViewArray[9]).setVisible(hmiService.getComponentConditionManager().isTrue(313788928, n2));
                }
                if (hMIViewArray[10] != null) {
                    ((IconController)hMIViewArray[10]).setVisible(hmiService.getComponentConditionManager().isTrue(330566144, n2));
                }
                if (hMIViewArray[11] == null) break;
                ((ImageDecoratorController)hMIViewArray[11]).setVisible(hmiService.getComponentConditionManager().isTrue(531892736, n2));
                break;
            }
            case 5583: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(229902848, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(246680064, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(263457280, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(280234496, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((IconController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(297011712, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(313788928, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((IconController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(330566144, n2));
                }
                if (hMIViewArray[7] == null) break;
                ((ImageDecoratorController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(531892736, n2));
                break;
            }
            case 5605: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(229902848, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(246680064, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(263457280, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(280234496, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((IconController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(297011712, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(313788928, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((IconController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(330566144, n2));
                }
                if (hMIViewArray[7] == null) break;
                ((ImageDecoratorController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(531892736, n2));
                break;
            }
            case 5624: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(179571200, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((IconLabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1253313024, n2));
                break;
            }
            case 400441: {
                if (this.evaluateSimpleChoiceModelValueEqualsCondition(958137856, n2, 1)) {
                    if (hMIViewArray[0] == null) break;
                    ((SharedTextureController)hMIViewArray[0]).setDisplayableID(19);
                    break;
                }
                if (hMIViewArray[0] == null) break;
                ((SharedTextureController)hMIViewArray[0]).setDisplayableID(19);
                break;
            }
            case 400490: {
                if (hMIViewArray[0] != null) {
                    ((ProgressIconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(213125632, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(179571200, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((IconLabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1253313024, n2));
                break;
            }
            case 700508: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(229902848, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(246680064, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(263457280, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(280234496, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((IconController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(297011712, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(313788928, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((IconController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(330566144, n2));
                }
                if (hMIViewArray[7] == null) break;
                ((ImageDecoratorController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(531892736, n2));
                break;
            }
            case 700519: {
                if (hMIViewArray[0] != null) {
                    ((ScreenWidgetEVO)hMIViewArray[0]).setOptionIconVisible(hmiService.getComponentConditionManager().isTrue(1974667776, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(246614528, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(-709948928, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((InstructionTextContoller)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(766577152, n2));
                }
                if (hMIViewArray[4] == null) break;
                ((ContainerController)hMIViewArray[4]).setVisible(!hmiService.getComponentConditionManager().isTrue(-1363998208, n2));
                break;
            }
            case 700539: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(229902848, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((SharedTextureController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-475002368, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((ProgressIconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(213125632, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(179571200, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((IconLabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(1253313024, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(246680064, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((IconController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(263457280, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((IconController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(280234496, n2));
                }
                if (hMIViewArray[8] != null) {
                    ((IconController)hMIViewArray[8]).setVisible(hmiService.getComponentConditionManager().isTrue(297011712, n2));
                }
                if (hMIViewArray[9] != null) {
                    ((IconController)hMIViewArray[9]).setVisible(hmiService.getComponentConditionManager().isTrue(313788928, n2));
                }
                if (hMIViewArray[10] != null) {
                    ((IconController)hMIViewArray[10]).setVisible(hmiService.getComponentConditionManager().isTrue(330566144, n2));
                }
                if (hMIViewArray[11] == null) break;
                ((ImageDecoratorController)hMIViewArray[11]).setVisible(hmiService.getComponentConditionManager().isTrue(531892736, n2));
                break;
            }
            case 700592: {
                if (hMIViewArray[0] != null) {
                    ((ScreenWidgetEVO)hMIViewArray[0]).setOptionIconVisible(hmiService.getComponentConditionManager().isTrue(1974667776, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(246614528, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((ListController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(-676394496, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((ListController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(498076160, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((MenuItemController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(-709948928, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((MenuItemController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(129042944, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((InstructionTextContoller)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(766577152, n2));
                }
                if (hMIViewArray[7] == null) break;
                ((ContainerController)hMIViewArray[7]).setVisible(!hmiService.getComponentConditionManager().isTrue(-1363998208, n2));
                break;
            }
            case 700594: {
                if (hMIViewArray[0] != null) {
                    ((ScreenWidgetEVO)hMIViewArray[0]).setOptionIconVisible(hmiService.getComponentConditionManager().isTrue(1974667776, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(246614528, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(-709948928, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((InstructionTextContoller)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(766577152, n2));
                }
                if (hMIViewArray[4] == null) break;
                ((ContainerController)hMIViewArray[4]).setVisible(!hmiService.getComponentConditionManager().isTrue(-1363998208, n2));
                break;
            }
            case 700595: {
                if (hMIViewArray[0] != null) {
                    ((ScreenWidgetEVO)hMIViewArray[0]).setOptionIconVisible(hmiService.getComponentConditionManager().isTrue(1974667776, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(246614528, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(-709948928, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(129042944, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((InstructionTextContoller)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(766577152, n2));
                }
                if (hMIViewArray[5] == null) break;
                ((ContainerController)hMIViewArray[5]).setVisible(!hmiService.getComponentConditionManager().isTrue(-1363998208, n2));
                break;
            }
        }
    }

    private void executeConditionaDBOPTScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 154: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(78907904, n2));
                break;
            }
            case 155: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(62130688, n2));
                break;
            }
            case 177: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(-72152576, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-55375360, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(-38598144, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(-21820928, n2));
                }
                if (hMIViewArray[4] == null) break;
                ((MenuItemController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(28576256, n2));
                break;
            }
            case 186: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(-88929792, n2));
                break;
            }
            case 442: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(515115520, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(62130688, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(78907904, n2));
                break;
            }
            case 523: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(62130688, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(78907904, n2));
                break;
            }
            case 3939: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(-88929792, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-72152576, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(hmiService.getComponentConditionManager().isTrue(1001654784, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(-55375360, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((MenuItemController)hMIViewArray[4]).setEnabled(hmiService.getComponentConditionManager().isTrue(1018432000, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((MenuItemController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(-38598144, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((MenuItemController)hMIViewArray[6]).setEnabled(hmiService.getComponentConditionManager().isTrue(1035209216, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((MenuItemController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(-21820928, n2));
                }
                if (hMIViewArray[8] != null) {
                    ((MenuItemController)hMIViewArray[8]).setEnabled(hmiService.getComponentConditionManager().isTrue(1051986432, n2));
                }
                if (hMIViewArray[9] != null) {
                    ((MenuItemController)hMIViewArray[9]).setVisible(hmiService.getComponentConditionManager().isTrue(632556032, n2));
                }
                if (hMIViewArray[10] != null) {
                    ((MenuItemController)hMIViewArray[10]).setEnabled(hmiService.getComponentConditionManager().isTrue(548669952, n2));
                }
                if (hMIViewArray[11] != null) {
                    ((MenuItemController)hMIViewArray[11]).setVisible(hmiService.getComponentConditionManager().isTrue(-5043712, n2));
                }
                if (hMIViewArray[12] != null) {
                    ((MenuItemController)hMIViewArray[12]).setEnabled(hmiService.getComponentConditionManager().isTrue(11799040, n2));
                }
                if (hMIViewArray[13] != null) {
                    ((MenuItemController)hMIViewArray[13]).setVisible(hmiService.getComponentConditionManager().isTrue(28576256, n2));
                }
                if (hMIViewArray[14] != null) {
                    ((MenuItemController)hMIViewArray[14]).setEnabled(hmiService.getComponentConditionManager().isTrue(45353472, n2));
                }
                if (hMIViewArray[15] != null) {
                    ((MenuItemController)hMIViewArray[15]).setVisible(hmiService.getComponentConditionManager().isTrue(515115520, n2));
                }
                if (hMIViewArray[16] != null) {
                    ((MenuItemController)hMIViewArray[16]).setEnabled(hmiService.getComponentConditionManager().isTrue(1169426944, n2));
                }
                if (hMIViewArray[17] != null) {
                    ((MenuItemController)hMIViewArray[17]).setVisible(hmiService.getComponentConditionManager().isTrue(62130688, n2));
                }
                if (hMIViewArray[18] != null) {
                    ((MenuItemController)hMIViewArray[18]).setEnabled(hmiService.getComponentConditionManager().isTrue(1186204160, n2));
                }
                if (hMIViewArray[19] != null) {
                    ((MenuItemController)hMIViewArray[19]).setVisible(hmiService.getComponentConditionManager().isTrue(78907904, n2));
                }
                if (hMIViewArray[20] == null) break;
                ((MenuItemController)hMIViewArray[20]).setEnabled(hmiService.getComponentConditionManager().isTrue(1202981376, n2));
                break;
            }
            case 4091: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(-5043712, n2));
                break;
            }
            case 4646: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(62130688, n2));
                break;
            }
            case 4649: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(78907904, n2));
                break;
            }
            case 5583: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1001654784, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(1102318080, n2)) {
                    if (hMIViewArray[1] != null) {
                        ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(hmiService.getComponentConditionManager().isTrue(1018432000, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setEnabled(hmiService.getComponentConditionManager().isTrue(1035209216, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((MenuItemController)hMIViewArray[4]).setEnabled(hmiService.getComponentConditionManager().isTrue(1051986432, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(1119095296, n2)) {
                    if (hMIViewArray[5] != null) {
                        ((MenuItemController)hMIViewArray[5]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[5] != null) {
                    ((MenuItemController)hMIViewArray[5]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[6] != null) {
                    ((MenuItemController)hMIViewArray[6]).setEnabled(hmiService.getComponentConditionManager().isTrue(548669952, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(1152649728, n2)) {
                    if (hMIViewArray[7] != null) {
                        ((MenuItemController)hMIViewArray[7]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[7] != null) {
                    ((MenuItemController)hMIViewArray[7]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[8] != null) {
                    ((MenuItemController)hMIViewArray[8]).setEnabled(hmiService.getComponentConditionManager().isTrue(1169426944, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(1135872512, n2)) {
                    if (hMIViewArray[9] != null) {
                        ((MenuItemController)hMIViewArray[9]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[9] != null) {
                    ((MenuItemController)hMIViewArray[9]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[10] != null) {
                    ((MenuItemController)hMIViewArray[10]).setEnabled(hmiService.getComponentConditionManager().isTrue(1186204160, n2));
                }
                if (hMIViewArray[11] == null) break;
                ((MenuItemController)hMIViewArray[11]).setEnabled(hmiService.getComponentConditionManager().isTrue(1202981376, n2));
                break;
            }
            case 5588: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1001654784, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(1102318080, n2)) {
                    if (hMIViewArray[1] != null) {
                        ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(hmiService.getComponentConditionManager().isTrue(1018432000, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setEnabled(hmiService.getComponentConditionManager().isTrue(1035209216, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((MenuItemController)hMIViewArray[4]).setEnabled(hmiService.getComponentConditionManager().isTrue(1051986432, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(1119095296, n2)) {
                    if (hMIViewArray[5] != null) {
                        ((MenuItemController)hMIViewArray[5]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[5] != null) {
                    ((MenuItemController)hMIViewArray[5]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[6] != null) {
                    ((MenuItemController)hMIViewArray[6]).setEnabled(hmiService.getComponentConditionManager().isTrue(548669952, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(1152649728, n2)) {
                    if (hMIViewArray[7] != null) {
                        ((MenuItemController)hMIViewArray[7]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[7] != null) {
                    ((MenuItemController)hMIViewArray[7]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[8] != null) {
                    ((MenuItemController)hMIViewArray[8]).setEnabled(hmiService.getComponentConditionManager().isTrue(1169426944, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(1135872512, n2)) {
                    if (hMIViewArray[9] != null) {
                        ((MenuItemController)hMIViewArray[9]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[9] != null) {
                    ((MenuItemController)hMIViewArray[9]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[10] != null) {
                    ((MenuItemController)hMIViewArray[10]).setEnabled(hmiService.getComponentConditionManager().isTrue(1186204160, n2));
                }
                if (hMIViewArray[11] == null) break;
                ((MenuItemController)hMIViewArray[11]).setEnabled(hmiService.getComponentConditionManager().isTrue(1202981376, n2));
                break;
            }
            case 5593: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1001654784, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(1018432000, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(hmiService.getComponentConditionManager().isTrue(1035209216, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((MenuItemController)hMIViewArray[3]).setEnabled(hmiService.getComponentConditionManager().isTrue(1051986432, n2));
                break;
            }
            case 300699: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(11799040, n2));
                break;
            }
            case 401360: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(45353472, n2));
                break;
            }
            case 1000019: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(632556032, n2));
                break;
            }
        }
    }

    private void executeConditionaDBOPTDETAILVIEWMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 93: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueEqualsCondition(93, n2, 1));
                break;
            }
            case 162: {
                if (hMIViewArray[0] != null) {
                    ((ProgressIconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(380897792, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(347343360, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((IconLabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1270090240, n2));
                break;
            }
            case 310: {
                if (hMIViewArray[0] != null) {
                    ((MenuController)hMIViewArray[0]).setSDSSymbolsVisible(hmiService.getComponentConditionManager().isTrue(-1263662592, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuController)hMIViewArray[1]).setSDSSymbolsVisible(hmiService.getComponentConditionManager().isTrue(296946176, n2));
                break;
            }
            case 442: {
                if (hMIViewArray[0] != null) {
                    ((GlassplateController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(464718336, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((GlassplateController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(481495552, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((LayoutContainerController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(330500608, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((MenuController)hMIViewArray[3]).setSDSSymbolsVisible(hmiService.getComponentConditionManager().isTrue(-1263662592, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((MenuController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(280168960, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((LayoutContainerController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(347277824, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((MenuController)hMIViewArray[6]).setSDSSymbolsVisible(hmiService.getComponentConditionManager().isTrue(296946176, n2));
                }
                if (hMIViewArray[7] == null) break;
                ((MenuController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(313723392, n2));
                break;
            }
            case 522: {
                if (hMIViewArray[0] != null) {
                    ((MirroredContainerController)hMIViewArray[0]).setMirrorEnabled(hmiService.getComponentConditionManager().isTrue(146016768, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MirroredContainerController)hMIViewArray[1]).setMirrorEnabled(hmiService.getComponentConditionManager().isTrue(162793984, n2));
                break;
            }
            case 556: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(397675008, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((SharedTextureController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-558888448, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((ProgressIconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(380897792, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(347343360, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((IconLabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(1270090240, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(414452224, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((IconController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(431229440, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((IconController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(448006656, n2));
                }
                if (hMIViewArray[8] != null) {
                    ((IconController)hMIViewArray[8]).setVisible(hmiService.getComponentConditionManager().isTrue(464783872, n2));
                }
                if (hMIViewArray[9] != null) {
                    ((IconController)hMIViewArray[9]).setVisible(hmiService.getComponentConditionManager().isTrue(481561088, n2));
                }
                if (hMIViewArray[10] == null) break;
                ((IconController)hMIViewArray[10]).setVisible(hmiService.getComponentConditionManager().isTrue(498338304, n2));
                break;
            }
            case 4078: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(397675008, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((SharedTextureController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-558888448, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((ProgressIconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(380897792, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(347343360, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((IconLabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(1270090240, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(414452224, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((IconController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(431229440, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((IconController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(448006656, n2));
                }
                if (hMIViewArray[8] != null) {
                    ((IconController)hMIViewArray[8]).setVisible(hmiService.getComponentConditionManager().isTrue(464783872, n2));
                }
                if (hMIViewArray[9] != null) {
                    ((IconController)hMIViewArray[9]).setVisible(hmiService.getComponentConditionManager().isTrue(481561088, n2));
                }
                if (hMIViewArray[10] == null) break;
                ((IconController)hMIViewArray[10]).setVisible(hmiService.getComponentConditionManager().isTrue(498338304, n2));
                break;
            }
            case 5624: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(347343360, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((IconLabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1270090240, n2));
                break;
            }
            case 400441: {
                if (this.evaluateSimpleChoiceModelValueEqualsCondition(958137856, n2, 1)) {
                    if (hMIViewArray[0] == null) break;
                    ((SharedTextureController)hMIViewArray[0]).setDisplayableID(19);
                    break;
                }
                if (hMIViewArray[0] == null) break;
                ((SharedTextureController)hMIViewArray[0]).setDisplayableID(19);
                break;
            }
            case 400490: {
                if (hMIViewArray[0] != null) {
                    ((ProgressIconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(380897792, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(347343360, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((IconLabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1270090240, n2));
                break;
            }
            case 700441: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1706035712, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(364055040, n2));
                break;
            }
            case 700525: {
                if (hMIViewArray[0] != null) {
                    ((MenuSDSNumbersController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(-1179579904, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuSDSNumbersController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(397609472, n2));
                break;
            }
            case 700526: {
                if (hMIViewArray[0] != null) {
                    ((MenuSDSNumbersController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(-1179579904, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuSDSNumbersController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(397609472, n2));
                break;
            }
            case 700527: {
                if (hMIViewArray[0] != null) {
                    ((MenuSDSNumbersController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(-1179579904, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuSDSNumbersController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(397609472, n2));
                break;
            }
            case 700539: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(397675008, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((SharedTextureController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-558888448, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((ProgressIconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(380897792, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(347343360, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((IconLabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(1270090240, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(414452224, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((IconController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(431229440, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((IconController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(448006656, n2));
                }
                if (hMIViewArray[8] != null) {
                    ((IconController)hMIViewArray[8]).setVisible(hmiService.getComponentConditionManager().isTrue(464783872, n2));
                }
                if (hMIViewArray[9] != null) {
                    ((IconController)hMIViewArray[9]).setVisible(hmiService.getComponentConditionManager().isTrue(481561088, n2));
                }
                if (hMIViewArray[10] == null) break;
                ((IconController)hMIViewArray[10]).setVisible(hmiService.getComponentConditionManager().isTrue(498338304, n2));
                break;
            }
            case 700560: {
                if (hMIViewArray[0] != null) {
                    ((GlassplateController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(464718336, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((GlassplateController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(481495552, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((LayoutContainerController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(330500608, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((MenuController)hMIViewArray[3]).setSDSSymbolsVisible(hmiService.getComponentConditionManager().isTrue(-1263662592, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((MenuController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(280168960, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((LayoutContainerController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(347277824, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((LabelController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(431163904, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((MenuController)hMIViewArray[7]).setSDSSymbolsVisible(hmiService.getComponentConditionManager().isTrue(296946176, n2));
                }
                if (hMIViewArray[8] == null) break;
                ((MenuController)hMIViewArray[8]).setVisible(hmiService.getComponentConditionManager().isTrue(313723392, n2));
                break;
            }
        }
    }

    private void executeConditionaDBOPTSETUPDOWNLOADMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 14: {
                if (hMIViewArray[0] == null) break;
                ((WaitAnimController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1689258496, n2));
                break;
            }
            case 335: {
                if (hMIViewArray[0] == null) break;
                ((WaitAnimController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1689258496, n2));
                break;
            }
        }
    }

    private void executeConditionaDBOPTSETUPEXPORTLISTMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 700451: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1320094208, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1303316992, n2));
                break;
            }
            case 700452: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(615516672, n2, 0));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueGreaterCondition(615516672, n2, 0));
                break;
            }
            case 700461: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(766511616, n2, 0));
                break;
            }
        }
    }

    private void executeConditionaDBOPTSETUPEXPORTMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 523: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1823607296, n2));
                break;
            }
            case 700453: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(632293888, n2, 0));
                break;
            }
            case 700454: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(649071104, n2, 0));
                break;
            }
            case 700455: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(665848320, n2, 0));
                break;
            }
            case 700521: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(1773144576, n2, 0));
                break;
            }
        }
    }

    private void executeConditionaDBOPTSETUPEXPORTPROCESSENDScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 700452: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(615516672, n2, 0));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueGreaterCondition(615516672, n2, 0));
                break;
            }
        }
    }

    private void executeConditionaDBOPTSETUPEXPORTPROCESSWAITScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 700452: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(615516672, n2, 0));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueGreaterCondition(615516672, n2, 0));
                break;
            }
        }
    }

    private void executeConditionaDBOPTSETUPIMPORTLISTMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 700463: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1353648640, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1336871424, n2));
                break;
            }
            case 700470: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(917506560, n2, 1));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(917506560, n2, 1));
                }
                if (hMIViewArray[2] != null) {
                    ((LabelController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(917506560, n2, 0));
                }
                if (hMIViewArray[3] != null) {
                    ((LabelController)hMIViewArray[3]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(917506560, n2, 1));
                }
                if (hMIViewArray[4] == null) break;
                ((LabelController)hMIViewArray[4]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(917506560, n2, 0));
                break;
            }
            case 700473: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1336871424, n2));
                break;
            }
            case 700477: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleChoiceModelValueEqualsCondition(1034947072, n2, 1));
                break;
            }
            case 700485: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(1169164800, n2, 0));
                break;
            }
        }
    }

    private void executeConditionaDBOPTSETUPIMPORTMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 360: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1850865152, n2));
                break;
            }
            case 363: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1850865152, n2));
                break;
            }
            case 367: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1850865152, n2));
                break;
            }
            case 523: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1840384512, n2));
                break;
            }
            case 700474: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(984615424, n2, 0));
                break;
            }
            case 700475: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(1001392640, n2, 0));
                break;
            }
            case 700476: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(1018169856, n2, 0));
                break;
            }
            case 700522: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(1789921792, n2, 0));
                break;
            }
        }
    }

    private void executeConditionaDBOPTSETUPIMPORTPROCESSENDScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 700470: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(917506560, n2, 1));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(917506560, n2, 0));
                }
                if (hMIViewArray[2] != null) {
                    ((LabelController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(917506560, n2, 1));
                }
                if (hMIViewArray[3] == null) break;
                ((LabelController)hMIViewArray[3]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(917506560, n2, 0));
                break;
            }
        }
    }

    private void executeConditionaDBOPTSETUPIMPORTPROCESSWAITScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 3939: {
                if (hMIViewArray[0] == null) break;
                ((WaitAnimController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(565447168, n2));
                break;
            }
            case 700470: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(917506560, n2, 1));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(917506560, n2, 0));
                }
                if (hMIViewArray[2] != null) {
                    ((LabelController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(917506560, n2, 1));
                }
                if (hMIViewArray[3] == null) break;
                ((LabelController)hMIViewArray[3]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(917506560, n2, 0));
                break;
            }
        }
    }

    private void executeConditionaDBOPTSETUPMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 17: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(17, n2, 0));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(17, n2, 1));
                }
                if (hMIViewArray[2] == null) break;
                ((MenuItemController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(17, n2, 2));
                break;
            }
            case 442: {
                if (hmiService.getComponentConditionManager().isTrue(1806830080, n2)) {
                    if (hMIViewArray[0] != null) {
                        ((MenuItemController)hMIViewArray[0]).setContentInvisible(0);
                    }
                    if (hMIViewArray[0] == null) break;
                    ((MenuItemController)hMIViewArray[0]).setContentVisible(2);
                    break;
                }
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setContentVisible(0);
                }
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setContentInvisible(2);
                break;
            }
            case 3853: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-659617280, n2));
                break;
            }
            case 5583: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-659617280, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(1068763648, n2)) {
                    if (hMIViewArray[1] != null) {
                        ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(1);
                    }
                } else if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(0);
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(!hmiService.getComponentConditionManager().isTrue(95488512, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(1085540864, n2)) {
                    if (hMIViewArray[3] == null) break;
                    ((MenuItemController)hMIViewArray[3]).setInfoLineDisabledTextIndex(1);
                    break;
                }
                if (hMIViewArray[3] == null) break;
                ((MenuItemController)hMIViewArray[3]).setInfoLineDisabledTextIndex(0);
                break;
            }
            case 5588: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-659617280, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(1068763648, n2)) {
                    if (hMIViewArray[1] != null) {
                        ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(1);
                    }
                } else if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(0);
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(!hmiService.getComponentConditionManager().isTrue(95488512, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(1085540864, n2)) {
                    if (hMIViewArray[3] == null) break;
                    ((MenuItemController)hMIViewArray[3]).setInfoLineDisabledTextIndex(1);
                    break;
                }
                if (hMIViewArray[3] == null) break;
                ((MenuItemController)hMIViewArray[3]).setInfoLineDisabledTextIndex(0);
                break;
            }
            case 700451: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(95488512, n2));
                break;
            }
            case 700489: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-659617280, n2));
                break;
            }
        }
    }

    private void executeConditionaDBOPTSETUPMEMORYMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 700427: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(0xBB00A00, n2, 0));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(0xBB00A00, n2, 0));
                }
                if (hMIViewArray[2] == null) break;
                ((MenuItemController)hMIViewArray[2]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(0xBB00A00, n2, 0));
                break;
            }
        }
    }

    @Override
    public IPartialPopupController getPartialPopup(int n, int n2) {
        switch (n) {
            case 700017: {
                return (IPartialPopupController)((Object)AddressBookScreenBag1.aDBPOPUPDOWNLOADERROR(this, n2));
            }
            case 700055: {
                return (IPartialPopupController)((Object)AddressBookScreenBag1.aDBOPTDELETESINGLEOK(this, n2));
            }
            case 700056: {
                return (IPartialPopupController)((Object)AddressBookScreenBag1.aDBOPTNAVCREATEFROMPOSTAL(this, n2));
            }
        }
        return null;
    }

    @Override
    public IPartialPopupController[] getPartialPopupStubs(int n) {
        return new IPartialPopupController[]{new PartialPopupStub(1907231232, -1, -1, 250, 0, 12, true, 7, n, 1, null, false, true), new PartialPopupStub(-1750201856, -1, -1, 250, 0, 12, true, 7, n, 1, null, false, true), new PartialPopupStub(-1733424640, -1, -1, 250, 0, 12, true, 7, n, 1, null, false, true)};
    }

    @Override
    public IDrawerController[] getOptionDrawers(int n) {
        return new IDrawerController[]{(IDrawerController)AddressBookScreenBag1.aDBOPT(this, n)};
    }
}

