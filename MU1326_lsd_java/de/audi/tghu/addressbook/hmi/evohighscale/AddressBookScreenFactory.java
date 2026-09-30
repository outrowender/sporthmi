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
    private static final int MODULE_ID = 7;
    private int[][] errorColors;
    public AbstractWidgetController[][] refWidgets = new AbstractWidgetController[8][6];

    public AddressBookScreenFactory(IFrameworkAccess iFrameworkAccess) {
        super(7, iFrameworkAccess);
        hmiService = iFrameworkAccess.getHMIService();
    }

    private int[][] getErrorColors() {
        if (this.errorColors == null) {
            this.errorColors = new int[][]{{-16777216, -7829368}, {-16777216, -7829368}, {-16777216, -7829368}, {-16777216, -7829368}, {-16777216, -7829368}};
        }
        return this.errorColors;
    }

    public String getName() {
        return "HMIAddressBookEvoHighScale";
    }

    IWrappedFont[] getFonts(int n, int n2) {
        return FontFactory.getFonts(n, n2, this.getFramework());
    }

    public static HMIModel getModel(int n, int n2) throws NoSuchElementException {
        HMIModel hMIModel = hmiService.getModel(n2, n);
        if (hMIModel == null) {
            throw new NoSuchElementException("Model (MODELID#" + n + ") for terminal " + n2 + " not available.");
        }
        return hMIModel;
    }

    public Screen getScreenWithMainArea(int n, int n2) {
        return this.createScreen(n, n2);
    }

    public HMIView getWidgetTemplate(int n, int n2) {
        return this.getRefWidget(n, n2, this);
    }

    public void clearRefWidgets(int n) {
        int n2 = this.refWidgets[n].length;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.refWidgets[n][i2] = null;
        }
    }

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
        labelModel.setText("There's no screen with id: " + n);
        labelController.setModel(labelModel);
        screenWidgetEVO.add(labelController);
        return screenWidgetEVO;
    }

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
                containerController.setEntertainmentMenuTransformation(12.0f, 12.0f, 0.96f, 0.96f, 0.0f);
                containerController.setSelectionMenuTransformation(615.0f, 70.0f, 0.6f, 0.6f, 0.0f);
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
                labelController.setTextIds(new int[]{700385});
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
                partialPopupController.setID(700034);
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
                labelController.setTextIds(new int[]{700456});
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
                menuItemController.setLabelId(700458);
                menuItemController.setGlassplateInsetsBottom(6);
                menuItemController.setGlassplateInsetsTop(7);
                menuItemController.setInternalID(700027);
                menuItemController.setType(2);
                MenuController menuController = new MenuController();
                MenuRendererHigh menuRendererHigh = new MenuRendererHigh(menuController);
                menuController.setRenderer(menuRendererHigh);
                menuController.createInfolineWidgets(new InfoLineRendererHigh());
                menuController.getInfoline().getInfolineRenderer().setFonts(addressBookScreenFactory.getFonts(1, n));
                menuController.setDefaultDisabledInfolineTextId(700610);
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
                partialPopupController.setID(700035);
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
                this.getFramework().getLogChannel("ScreenFactory").log(10000, "Invalid reference widget id " + n2 + ".");
            }
        }
        this.refWidgets[n][n2] = abstractWidgetController;
        return abstractWidgetController;
    }

    protected static final boolean evalCond700049(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(363, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(367, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(360, n)).getValue() == 1;
    }

    protected static final boolean evalCond700084(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(310, n)).getValue() > 0 && (((LabelModel)AddressBookScreenFactory.getModel(700560, n)).getLength() <= 0 || ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 3);
    }

    protected static final boolean evalCond700237(int n) {
        return ((TiledListModel)AddressBookScreenFactory.getModel(700451, n)).getLength() == 0;
    }

    protected static final boolean evalCond700238(int n) {
        return ((TiledListModel)AddressBookScreenFactory.getModel(700451, n)).getLength() == 0;
    }

    protected static final boolean evalCond700239(int n) {
        return ((TiledListModel)AddressBookScreenFactory.getModel(700463, n)).getLength() == 0 && ((ChoiceModel)AddressBookScreenFactory.getModel(700473, n)).getStatus() == 1;
    }

    protected static final boolean evalCond700240(int n) {
        return ((TiledListModel)AddressBookScreenFactory.getModel(700463, n)).getLength() == 0;
    }

    protected static final boolean evalCond700303(int n) {
        return ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() != 1 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 3 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 2 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 4 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 5;
    }

    protected static final boolean evalCond700304(int n) {
        return ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(335, n)).getValue() != 2 && ((ChoiceModel)AddressBookScreenFactory.getModel(335, n)).getValue() != 3 && ((ChoiceModel)AddressBookScreenFactory.getModel(335, n)).getValue() != 8 && ((ChoiceModel)AddressBookScreenFactory.getModel(335, n)).getValue() != 9;
    }

    protected static final boolean evalCond700373(int n) {
        return ((TiledListModel)AddressBookScreenFactory.getModel(700594, n)).getLength() == 0 && ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() != 1 || ((SpellerModel)AddressBookScreenFactory.getModel(700592, n)).isEmpty() && ((TiledListModel)AddressBookScreenFactory.getModel(700594, n)).getLength() == 0 && ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() == 1 || ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() == 1 && !((SpellerModel)AddressBookScreenFactory.getModel(700592, n)).isEmpty() && ((ChoiceModel)AddressBookScreenFactory.getModel(700519, n)).getValue() == 0 && ((BaseListModel)AddressBookScreenFactory.getModel(700595, n)).getLength() == 0;
    }

    protected static final boolean evalCond700375(int n) {
        return ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() == 1 && !((SpellerModel)AddressBookScreenFactory.getModel(700592, n)).isEmpty();
    }

    protected static final boolean evalCond700376(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(3853, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(700489, n)).getValue() == 1 && (((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() != 1 || ((ChoiceModel)AddressBookScreenFactory.getModel(5588, n)).getValue() != 1);
    }

    protected static final boolean evalCond700445(int n) {
        return ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() == 1 && ((SpellerModel)AddressBookScreenFactory.getModel(700592, n)).isEmpty() || ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() != 1;
    }

    protected static final boolean evalCond700516(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(14, n)).getValue() == 0 && ((ChoiceModel)AddressBookScreenFactory.getModel(335, n)).getValue() != 2 && ((ChoiceModel)AddressBookScreenFactory.getModel(335, n)).getValue() != 3 && ((ChoiceModel)AddressBookScreenFactory.getModel(335, n)).getValue() != 8 && ((ChoiceModel)AddressBookScreenFactory.getModel(335, n)).getValue() != 9;
    }

    protected static final boolean evalCond700517(int n) {
        return ((LabelModel)AddressBookScreenFactory.getModel(700441, n)).getLength() > 0;
    }

    protected static final boolean evalCond700638(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(700539, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond700643(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(700539, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond700677(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(5588, n)).getValue() == 1 || ((TiledListModel)AddressBookScreenFactory.getModel(700451, n)).getLength() == 0;
    }

    protected static final boolean evalCond700679(int n) {
        return (((BaseListModel)AddressBookScreenFactory.getModel(700595, n)).getLength() > 100 || ((BaseListModel)AddressBookScreenFactory.getModel(700595, n)).getLength() == 100) && !((SpellerModel)AddressBookScreenFactory.getModel(700592, n)).isEmpty();
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
        return (((TiledListModel)AddressBookScreenFactory.getModel(700594, n)).getLength() == 0 && ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() != 1 || ((SpellerModel)AddressBookScreenFactory.getModel(700592, n)).isEmpty() && ((TiledListModel)AddressBookScreenFactory.getModel(700594, n)).getLength() == 0 && ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() == 1 || ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() == 1 && !((SpellerModel)AddressBookScreenFactory.getModel(700592, n)).isEmpty() && ((ChoiceModel)AddressBookScreenFactory.getModel(700519, n)).getValue() == 0 && ((BaseListModel)AddressBookScreenFactory.getModel(700595, n)).getLength() == 0) && ((ChoiceModel)AddressBookScreenFactory.getModel(14, n)).getStatus() == 0 && ((SpellerModel)AddressBookScreenFactory.getModel(700592, n)).isEmpty();
    }

    protected static final boolean evalCond700857(int n) {
        return ((BaseListModel)AddressBookScreenFactory.getModel(700525, n)).getLength() == 0 && ((BaseListModel)AddressBookScreenFactory.getModel(700526, n)).getLength() == 0 && ((BaseListModel)AddressBookScreenFactory.getModel(700527, n)).getLength() == 0;
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
        return (((TiledListModel)AddressBookScreenFactory.getModel(700594, n)).getLength() == 0 && ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() != 1 || ((SpellerModel)AddressBookScreenFactory.getModel(700592, n)).isEmpty() && ((TiledListModel)AddressBookScreenFactory.getModel(700594, n)).getLength() == 0 && ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() == 1 || ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() == 1 && !((SpellerModel)AddressBookScreenFactory.getModel(700592, n)).isEmpty() && ((ChoiceModel)AddressBookScreenFactory.getModel(700519, n)).getValue() == 0 && ((BaseListModel)AddressBookScreenFactory.getModel(700595, n)).getLength() == 0) && ((ChoiceModel)AddressBookScreenFactory.getModel(14, n)).getStatus() == 0 && ((SpellerModel)AddressBookScreenFactory.getModel(700592, n)).isEmpty();
    }

    protected static final boolean evalCond701199(int n) {
        return ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() != 0;
    }

    protected static final boolean evalCond701200(int n) {
        return ((LabelModel)AddressBookScreenFactory.getModel(700560, n)).getLength() <= 0 || ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 3;
    }

    protected static final boolean evalCond701201(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(310, n)).getValue() > 0 && ((LabelModel)AddressBookScreenFactory.getModel(700560, n)).getLength() > 0 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() == 3;
    }

    protected static final boolean evalCond701202(int n) {
        return ((LabelModel)AddressBookScreenFactory.getModel(700560, n)).getLength() > 0 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() == 3;
    }

    protected static final boolean evalCond701203(int n) {
        return ((LabelModel)AddressBookScreenFactory.getModel(700560, n)).getLength() <= 0 || ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 3;
    }

    protected static final boolean evalCond701204(int n) {
        return ((LabelModel)AddressBookScreenFactory.getModel(700560, n)).getLength() > 0 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() == 3;
    }

    protected static final boolean evalCond701205(int n) {
        return ((LabelModel)AddressBookScreenFactory.getModel(700441, n)).getLength() > 0;
    }

    protected static final boolean evalCond701207(int n) {
        return ((BaseListModel)AddressBookScreenFactory.getModel(700525, n)).getLength() == 0 && ((BaseListModel)AddressBookScreenFactory.getModel(700526, n)).getLength() == 0 && ((BaseListModel)AddressBookScreenFactory.getModel(700527, n)).getLength() == 0;
    }

    protected static final boolean evalCond701209(int n) {
        return ((LabelModel)AddressBookScreenFactory.getModel(700560, n)).getLength() > 0;
    }

    protected static final boolean evalCond701211(int n) {
        return ((LabelModel)AddressBookScreenFactory.getModel(700560, n)).getLength() <= 0 || ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 3;
    }

    protected static final boolean evalCond701212(int n) {
        return ((LabelModel)AddressBookScreenFactory.getModel(700560, n)).getLength() > 0 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() == 3;
    }

    protected static final boolean evalCond701301(int n) {
        return (((TiledListModel)AddressBookScreenFactory.getModel(700594, n)).getLength() == 0 && ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() != 1 || ((SpellerModel)AddressBookScreenFactory.getModel(700592, n)).isEmpty() && ((TiledListModel)AddressBookScreenFactory.getModel(700594, n)).getLength() == 0 && ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() == 1 || ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() == 1 && !((SpellerModel)AddressBookScreenFactory.getModel(700592, n)).isEmpty() && ((ChoiceModel)AddressBookScreenFactory.getModel(700519, n)).getValue() == 0 && ((BaseListModel)AddressBookScreenFactory.getModel(700595, n)).getLength() == 0) && ((ChoiceModel)AddressBookScreenFactory.getModel(14, n)).getStatus() == 0 && ((SpellerModel)AddressBookScreenFactory.getModel(700592, n)).isEmpty();
    }

    protected static final boolean evalCond701358(int n) {
        return ((TiledListModel)AddressBookScreenFactory.getModel(700594, n)).getLength() == 0 && ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() != 1 || ((SpellerModel)AddressBookScreenFactory.getModel(700592, n)).isEmpty() && ((TiledListModel)AddressBookScreenFactory.getModel(700594, n)).getLength() == 0 && ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() == 1 || ((SysConstModel)AddressBookScreenFactory.getModel(523, n)).getValue() == 1 && !((SpellerModel)AddressBookScreenFactory.getModel(700592, n)).isEmpty() && ((ChoiceModel)AddressBookScreenFactory.getModel(700519, n)).getValue() == 0 && ((BaseListModel)AddressBookScreenFactory.getModel(700595, n)).getLength() == 0 || ((ChoiceModel)AddressBookScreenFactory.getModel(14, n)).getStatus() == 0;
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
        return ((ChoiceModel)AddressBookScreenFactory.getModel(300699, n)).getValue() != 1 && ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond701441(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(177, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond701442(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(401360, n)).getValue() != 1 && ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() == 0;
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
        return ((ChoiceModel)AddressBookScreenFactory.getModel(162, n)).getValue() > 99 && ((ChoiceModel)AddressBookScreenFactory.getModel(400490, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(700539, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(5624, n)).getValue() == 0;
    }

    protected static final boolean evalCond701452(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(162, n)).getValue() > 0 && ((ChoiceModel)AddressBookScreenFactory.getModel(162, n)).getValue() < 100 && ((ChoiceModel)AddressBookScreenFactory.getModel(400490, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(700539, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond701453(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(700539, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1 || ((ResourceLocatorModel)AddressBookScreenFactory.getModel(700508, n)).getStatus() == 1 && (((ChoiceModel)AddressBookScreenFactory.getModel(5605, n)).getValue() != 1 || ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() != 1);
    }

    protected static final boolean evalCond701454(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(700539, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1 || ((ResourceLocatorModel)AddressBookScreenFactory.getModel(700508, n)).getStatus() == 1 && (((ChoiceModel)AddressBookScreenFactory.getModel(5605, n)).getValue() != 1 || ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() != 1);
    }

    protected static final boolean evalCond701455(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(700539, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1 || ((ResourceLocatorModel)AddressBookScreenFactory.getModel(700508, n)).getStatus() == 1 && (((ChoiceModel)AddressBookScreenFactory.getModel(5605, n)).getValue() != 1 || ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() != 1);
    }

    protected static final boolean evalCond701456(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(700539, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1 || ((ResourceLocatorModel)AddressBookScreenFactory.getModel(700508, n)).getStatus() == 1 && (((ChoiceModel)AddressBookScreenFactory.getModel(5605, n)).getValue() != 1 || ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() != 1);
    }

    protected static final boolean evalCond701457(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(700539, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1 || ((ResourceLocatorModel)AddressBookScreenFactory.getModel(700508, n)).getStatus() == 1 && (((ChoiceModel)AddressBookScreenFactory.getModel(5605, n)).getValue() != 1 || ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() != 1);
    }

    protected static final boolean evalCond701458(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(700539, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1 || ((ResourceLocatorModel)AddressBookScreenFactory.getModel(700508, n)).getStatus() == 1 && (((ChoiceModel)AddressBookScreenFactory.getModel(5605, n)).getValue() != 1 || ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() != 1);
    }

    protected static final boolean evalCond701459(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(700539, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1 || ((ResourceLocatorModel)AddressBookScreenFactory.getModel(700508, n)).getStatus() == 1 && (((ChoiceModel)AddressBookScreenFactory.getModel(5605, n)).getValue() != 1 || ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() != 1);
    }

    protected static final boolean evalCond701460(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(162, n)).getValue() > 99 && ((ChoiceModel)AddressBookScreenFactory.getModel(400490, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(700539, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(5624, n)).getValue() == 0;
    }

    protected static final boolean evalCond701462(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(162, n)).getValue() > 0 && ((ChoiceModel)AddressBookScreenFactory.getModel(162, n)).getValue() < 100 && ((ChoiceModel)AddressBookScreenFactory.getModel(400490, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(700539, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond701463(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(700539, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond701464(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(700539, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond701465(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(700539, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond701466(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(700539, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond701467(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(700539, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond701468(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(700539, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond701469(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(700539, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond701470(int n) {
        return ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 3 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 2 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 4 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 5 && ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 3 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 2 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 4 && ((SysConstModel)AddressBookScreenFactory.getModel(442, n)).getValue() != 5;
    }

    protected static final boolean evalCond701471(int n) {
        return !(((ResourceLocatorModel)AddressBookScreenFactory.getModel(700508, n)).getStatus() != 1 || ((ChoiceModel)AddressBookScreenFactory.getModel(5605, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() == 1 || ((ChoiceModel)AddressBookScreenFactory.getModel(700539, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1);
    }

    protected static final boolean evalCond701472(int n) {
        return (((ChoiceModel)AddressBookScreenFactory.getModel(5583, n)).getValue() != 1 || ((ChoiceModel)AddressBookScreenFactory.getModel(5588, n)).getValue() != 1) && ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond701473(int n) {
        return ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() != 0;
    }

    protected static final boolean evalCond701477(int n) {
        return ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)AddressBookScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)AddressBookScreenFactory.getModel(1000019, n)).getValue() == 1;
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
        return ((ChoiceModel)AddressBookScreenFactory.getModel(162, n)).getValue() > 99 && ((ChoiceModel)AddressBookScreenFactory.getModel(400490, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(700539, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(5624, n)).getValue() == 1;
    }

    protected static final boolean evalCond701515(int n) {
        return ((ChoiceModel)AddressBookScreenFactory.getModel(162, n)).getValue() > 99 && ((ChoiceModel)AddressBookScreenFactory.getModel(400490, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(700539, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(4078, n)).getValue() == 1 && ((SysConstModel)AddressBookScreenFactory.getModel(556, n)).getValue() == 1 && ((ChoiceModel)AddressBookScreenFactory.getModel(5624, n)).getValue() == 1;
    }

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
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701152, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(701153, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((LabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(701154, n2));
                break;
            }
            case 3939: {
                if (hMIViewArray[0] == null) break;
                ((WaitAnimController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(701199, n2));
                break;
            }
        }
    }

    private void executeConditionaDBMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 14: {
                if (hMIViewArray[0] != null) {
                    ((ScreenWidgetEVO)hMIViewArray[0]).setOptionIconVisible(hmiService.getComponentConditionManager().isTrue(701301, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(701198, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((InstructionTextContoller)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(700717, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((ContainerController)hMIViewArray[3]).setVisible(!hmiService.getComponentConditionManager().isTrue(701358, n2));
                }
                if (hMIViewArray[4] == null) break;
                ((WaitAnimController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(700716, n2));
                break;
            }
            case 17: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701008, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(701009, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((LabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(701010, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((LabelController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(700715, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((LabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(700714, n2));
                }
                if (hMIViewArray[5] == null) break;
                ((LabelController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(700713, n2));
                break;
            }
            case 93: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueEqualsCondition(93, n2, 1));
                break;
            }
            case 162: {
                if (hMIViewArray[0] != null) {
                    ((ProgressIconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701452, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(701450, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((IconLabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(701514, n2));
                break;
            }
            case 310: {
                if (hMIViewArray[0] == null) break;
                ((MenuController)hMIViewArray[0]).setSDSSymbolsVisible(this.evaluateSimpleChoiceModelValueGreaterCondition(310, n2, 0));
                break;
            }
            case 335: {
                if (hMIViewArray[0] != null) {
                    ((TouchController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(700304, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((WaitAnimController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(700716, n2));
                break;
            }
            case 442: {
                if (hMIViewArray[0] == null) break;
                ((TouchController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(700303, n2));
                break;
            }
            case 522: {
                if (hMIViewArray[0] != null) {
                    ((MirroredContainerController)hMIViewArray[0]).setMirrorEnabled(hmiService.getComponentConditionManager().isTrue(701446, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MirroredContainerController)hMIViewArray[1]).setMirrorEnabled(hmiService.getComponentConditionManager().isTrue(701447, n2));
                break;
            }
            case 523: {
                if (hMIViewArray[0] != null) {
                    ((ScreenWidgetEVO)hMIViewArray[0]).setOptionIconVisible(hmiService.getComponentConditionManager().isTrue(701301, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(701198, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((TouchController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(700304, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((ListController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(700375, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((TouchController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(700303, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((ListController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(700445, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((MenuItemController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(700373, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((InstructionTextContoller)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(700717, n2));
                }
                if (hMIViewArray[8] == null) break;
                ((ContainerController)hMIViewArray[8]).setVisible(!hmiService.getComponentConditionManager().isTrue(701358, n2));
                break;
            }
            case 556: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701453, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((SharedTextureController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(700643, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((ProgressIconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(701452, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(701450, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((IconLabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(701514, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(701454, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((IconController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(701455, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((IconController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(701456, n2));
                }
                if (hMIViewArray[8] != null) {
                    ((IconController)hMIViewArray[8]).setVisible(hmiService.getComponentConditionManager().isTrue(701457, n2));
                }
                if (hMIViewArray[9] != null) {
                    ((IconController)hMIViewArray[9]).setVisible(hmiService.getComponentConditionManager().isTrue(701458, n2));
                }
                if (hMIViewArray[10] != null) {
                    ((IconController)hMIViewArray[10]).setVisible(hmiService.getComponentConditionManager().isTrue(701459, n2));
                }
                if (hMIViewArray[11] == null) break;
                ((ImageDecoratorController)hMIViewArray[11]).setVisible(hmiService.getComponentConditionManager().isTrue(701471, n2));
                break;
            }
            case 4078: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701453, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((SharedTextureController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(700643, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((ProgressIconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(701452, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(701450, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((IconLabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(701514, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(701454, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((IconController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(701455, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((IconController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(701456, n2));
                }
                if (hMIViewArray[8] != null) {
                    ((IconController)hMIViewArray[8]).setVisible(hmiService.getComponentConditionManager().isTrue(701457, n2));
                }
                if (hMIViewArray[9] != null) {
                    ((IconController)hMIViewArray[9]).setVisible(hmiService.getComponentConditionManager().isTrue(701458, n2));
                }
                if (hMIViewArray[10] != null) {
                    ((IconController)hMIViewArray[10]).setVisible(hmiService.getComponentConditionManager().isTrue(701459, n2));
                }
                if (hMIViewArray[11] == null) break;
                ((ImageDecoratorController)hMIViewArray[11]).setVisible(hmiService.getComponentConditionManager().isTrue(701471, n2));
                break;
            }
            case 5583: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701453, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(701454, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(701455, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(701456, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((IconController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(701457, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(701458, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((IconController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(701459, n2));
                }
                if (hMIViewArray[7] == null) break;
                ((ImageDecoratorController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(701471, n2));
                break;
            }
            case 5605: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701453, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(701454, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(701455, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(701456, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((IconController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(701457, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(701458, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((IconController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(701459, n2));
                }
                if (hMIViewArray[7] == null) break;
                ((ImageDecoratorController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(701471, n2));
                break;
            }
            case 5624: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701450, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((IconLabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(701514, n2));
                break;
            }
            case 400441: {
                if (this.evaluateSimpleChoiceModelValueEqualsCondition(400441, n2, 1)) {
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
                    ((ProgressIconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701452, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(701450, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((IconLabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(701514, n2));
                break;
            }
            case 700508: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701453, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(701454, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(701455, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(701456, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((IconController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(701457, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(701458, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((IconController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(701459, n2));
                }
                if (hMIViewArray[7] == null) break;
                ((ImageDecoratorController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(701471, n2));
                break;
            }
            case 700519: {
                if (hMIViewArray[0] != null) {
                    ((ScreenWidgetEVO)hMIViewArray[0]).setOptionIconVisible(hmiService.getComponentConditionManager().isTrue(701301, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(701198, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(700373, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((InstructionTextContoller)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(700717, n2));
                }
                if (hMIViewArray[4] == null) break;
                ((ContainerController)hMIViewArray[4]).setVisible(!hmiService.getComponentConditionManager().isTrue(701358, n2));
                break;
            }
            case 700539: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701453, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((SharedTextureController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(700643, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((ProgressIconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(701452, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(701450, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((IconLabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(701514, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(701454, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((IconController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(701455, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((IconController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(701456, n2));
                }
                if (hMIViewArray[8] != null) {
                    ((IconController)hMIViewArray[8]).setVisible(hmiService.getComponentConditionManager().isTrue(701457, n2));
                }
                if (hMIViewArray[9] != null) {
                    ((IconController)hMIViewArray[9]).setVisible(hmiService.getComponentConditionManager().isTrue(701458, n2));
                }
                if (hMIViewArray[10] != null) {
                    ((IconController)hMIViewArray[10]).setVisible(hmiService.getComponentConditionManager().isTrue(701459, n2));
                }
                if (hMIViewArray[11] == null) break;
                ((ImageDecoratorController)hMIViewArray[11]).setVisible(hmiService.getComponentConditionManager().isTrue(701471, n2));
                break;
            }
            case 700592: {
                if (hMIViewArray[0] != null) {
                    ((ScreenWidgetEVO)hMIViewArray[0]).setOptionIconVisible(hmiService.getComponentConditionManager().isTrue(701301, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(701198, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((ListController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(700375, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((ListController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(700445, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((MenuItemController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(700373, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((MenuItemController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(700679, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((InstructionTextContoller)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(700717, n2));
                }
                if (hMIViewArray[7] == null) break;
                ((ContainerController)hMIViewArray[7]).setVisible(!hmiService.getComponentConditionManager().isTrue(701358, n2));
                break;
            }
            case 700594: {
                if (hMIViewArray[0] != null) {
                    ((ScreenWidgetEVO)hMIViewArray[0]).setOptionIconVisible(hmiService.getComponentConditionManager().isTrue(701301, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(701198, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(700373, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((InstructionTextContoller)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(700717, n2));
                }
                if (hMIViewArray[4] == null) break;
                ((ContainerController)hMIViewArray[4]).setVisible(!hmiService.getComponentConditionManager().isTrue(701358, n2));
                break;
            }
            case 700595: {
                if (hMIViewArray[0] != null) {
                    ((ScreenWidgetEVO)hMIViewArray[0]).setOptionIconVisible(hmiService.getComponentConditionManager().isTrue(701301, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(701198, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(700373, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(700679, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((InstructionTextContoller)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(700717, n2));
                }
                if (hMIViewArray[5] == null) break;
                ((ContainerController)hMIViewArray[5]).setVisible(!hmiService.getComponentConditionManager().isTrue(701358, n2));
                break;
            }
        }
    }

    private void executeConditionaDBOPTScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 154: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701444, n2));
                break;
            }
            case 155: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701443, n2));
                break;
            }
            case 177: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701435, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(701436, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(701437, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(701438, n2));
                }
                if (hMIViewArray[4] == null) break;
                ((MenuItemController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(701441, n2));
                break;
            }
            case 186: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701434, n2));
                break;
            }
            case 442: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701470, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(701443, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(701444, n2));
                break;
            }
            case 523: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701443, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(701444, n2));
                break;
            }
            case 3939: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701434, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(701435, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(hmiService.getComponentConditionManager().isTrue(701499, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(701436, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((MenuItemController)hMIViewArray[4]).setEnabled(hmiService.getComponentConditionManager().isTrue(701500, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((MenuItemController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(701437, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((MenuItemController)hMIViewArray[6]).setEnabled(hmiService.getComponentConditionManager().isTrue(701501, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((MenuItemController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(701438, n2));
                }
                if (hMIViewArray[8] != null) {
                    ((MenuItemController)hMIViewArray[8]).setEnabled(hmiService.getComponentConditionManager().isTrue(701502, n2));
                }
                if (hMIViewArray[9] != null) {
                    ((MenuItemController)hMIViewArray[9]).setVisible(hmiService.getComponentConditionManager().isTrue(701477, n2));
                }
                if (hMIViewArray[10] != null) {
                    ((MenuItemController)hMIViewArray[10]).setEnabled(hmiService.getComponentConditionManager().isTrue(701472, n2));
                }
                if (hMIViewArray[11] != null) {
                    ((MenuItemController)hMIViewArray[11]).setVisible(hmiService.getComponentConditionManager().isTrue(701439, n2));
                }
                if (hMIViewArray[12] != null) {
                    ((MenuItemController)hMIViewArray[12]).setEnabled(hmiService.getComponentConditionManager().isTrue(701440, n2));
                }
                if (hMIViewArray[13] != null) {
                    ((MenuItemController)hMIViewArray[13]).setVisible(hmiService.getComponentConditionManager().isTrue(701441, n2));
                }
                if (hMIViewArray[14] != null) {
                    ((MenuItemController)hMIViewArray[14]).setEnabled(hmiService.getComponentConditionManager().isTrue(701442, n2));
                }
                if (hMIViewArray[15] != null) {
                    ((MenuItemController)hMIViewArray[15]).setVisible(hmiService.getComponentConditionManager().isTrue(701470, n2));
                }
                if (hMIViewArray[16] != null) {
                    ((MenuItemController)hMIViewArray[16]).setEnabled(hmiService.getComponentConditionManager().isTrue(701509, n2));
                }
                if (hMIViewArray[17] != null) {
                    ((MenuItemController)hMIViewArray[17]).setVisible(hmiService.getComponentConditionManager().isTrue(701443, n2));
                }
                if (hMIViewArray[18] != null) {
                    ((MenuItemController)hMIViewArray[18]).setEnabled(hmiService.getComponentConditionManager().isTrue(701510, n2));
                }
                if (hMIViewArray[19] != null) {
                    ((MenuItemController)hMIViewArray[19]).setVisible(hmiService.getComponentConditionManager().isTrue(701444, n2));
                }
                if (hMIViewArray[20] == null) break;
                ((MenuItemController)hMIViewArray[20]).setEnabled(hmiService.getComponentConditionManager().isTrue(701511, n2));
                break;
            }
            case 4091: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701439, n2));
                break;
            }
            case 4646: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701443, n2));
                break;
            }
            case 4649: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701444, n2));
                break;
            }
            case 5583: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(701499, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(701505, n2)) {
                    if (hMIViewArray[1] != null) {
                        ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(hmiService.getComponentConditionManager().isTrue(701500, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setEnabled(hmiService.getComponentConditionManager().isTrue(701501, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((MenuItemController)hMIViewArray[4]).setEnabled(hmiService.getComponentConditionManager().isTrue(701502, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(701506, n2)) {
                    if (hMIViewArray[5] != null) {
                        ((MenuItemController)hMIViewArray[5]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[5] != null) {
                    ((MenuItemController)hMIViewArray[5]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[6] != null) {
                    ((MenuItemController)hMIViewArray[6]).setEnabled(hmiService.getComponentConditionManager().isTrue(701472, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(701508, n2)) {
                    if (hMIViewArray[7] != null) {
                        ((MenuItemController)hMIViewArray[7]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[7] != null) {
                    ((MenuItemController)hMIViewArray[7]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[8] != null) {
                    ((MenuItemController)hMIViewArray[8]).setEnabled(hmiService.getComponentConditionManager().isTrue(701509, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(701507, n2)) {
                    if (hMIViewArray[9] != null) {
                        ((MenuItemController)hMIViewArray[9]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[9] != null) {
                    ((MenuItemController)hMIViewArray[9]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[10] != null) {
                    ((MenuItemController)hMIViewArray[10]).setEnabled(hmiService.getComponentConditionManager().isTrue(701510, n2));
                }
                if (hMIViewArray[11] == null) break;
                ((MenuItemController)hMIViewArray[11]).setEnabled(hmiService.getComponentConditionManager().isTrue(701511, n2));
                break;
            }
            case 5588: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(701499, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(701505, n2)) {
                    if (hMIViewArray[1] != null) {
                        ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(hmiService.getComponentConditionManager().isTrue(701500, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setEnabled(hmiService.getComponentConditionManager().isTrue(701501, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((MenuItemController)hMIViewArray[4]).setEnabled(hmiService.getComponentConditionManager().isTrue(701502, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(701506, n2)) {
                    if (hMIViewArray[5] != null) {
                        ((MenuItemController)hMIViewArray[5]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[5] != null) {
                    ((MenuItemController)hMIViewArray[5]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[6] != null) {
                    ((MenuItemController)hMIViewArray[6]).setEnabled(hmiService.getComponentConditionManager().isTrue(701472, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(701508, n2)) {
                    if (hMIViewArray[7] != null) {
                        ((MenuItemController)hMIViewArray[7]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[7] != null) {
                    ((MenuItemController)hMIViewArray[7]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[8] != null) {
                    ((MenuItemController)hMIViewArray[8]).setEnabled(hmiService.getComponentConditionManager().isTrue(701509, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(701507, n2)) {
                    if (hMIViewArray[9] != null) {
                        ((MenuItemController)hMIViewArray[9]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[9] != null) {
                    ((MenuItemController)hMIViewArray[9]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[10] != null) {
                    ((MenuItemController)hMIViewArray[10]).setEnabled(hmiService.getComponentConditionManager().isTrue(701510, n2));
                }
                if (hMIViewArray[11] == null) break;
                ((MenuItemController)hMIViewArray[11]).setEnabled(hmiService.getComponentConditionManager().isTrue(701511, n2));
                break;
            }
            case 5593: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(701499, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(701500, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(hmiService.getComponentConditionManager().isTrue(701501, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((MenuItemController)hMIViewArray[3]).setEnabled(hmiService.getComponentConditionManager().isTrue(701502, n2));
                break;
            }
            case 300699: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(701440, n2));
                break;
            }
            case 401360: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(701442, n2));
                break;
            }
            case 1000019: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701477, n2));
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
                    ((ProgressIconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701462, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(701460, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((IconLabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(701515, n2));
                break;
            }
            case 310: {
                if (hMIViewArray[0] != null) {
                    ((MenuController)hMIViewArray[0]).setSDSSymbolsVisible(hmiService.getComponentConditionManager().isTrue(700084, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuController)hMIViewArray[1]).setSDSSymbolsVisible(hmiService.getComponentConditionManager().isTrue(701201, n2));
                break;
            }
            case 442: {
                if (hMIViewArray[0] != null) {
                    ((GlassplateController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701211, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((GlassplateController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(701212, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((LayoutContainerController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(701203, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((MenuController)hMIViewArray[3]).setSDSSymbolsVisible(hmiService.getComponentConditionManager().isTrue(700084, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((MenuController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(701200, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((LayoutContainerController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(701204, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((MenuController)hMIViewArray[6]).setSDSSymbolsVisible(hmiService.getComponentConditionManager().isTrue(701201, n2));
                }
                if (hMIViewArray[7] == null) break;
                ((MenuController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(701202, n2));
                break;
            }
            case 522: {
                if (hMIViewArray[0] != null) {
                    ((MirroredContainerController)hMIViewArray[0]).setMirrorEnabled(hmiService.getComponentConditionManager().isTrue(701448, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MirroredContainerController)hMIViewArray[1]).setMirrorEnabled(hmiService.getComponentConditionManager().isTrue(701449, n2));
                break;
            }
            case 556: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701463, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((SharedTextureController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(700638, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((ProgressIconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(701462, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(701460, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((IconLabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(701515, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(701464, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((IconController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(701465, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((IconController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(701466, n2));
                }
                if (hMIViewArray[8] != null) {
                    ((IconController)hMIViewArray[8]).setVisible(hmiService.getComponentConditionManager().isTrue(701467, n2));
                }
                if (hMIViewArray[9] != null) {
                    ((IconController)hMIViewArray[9]).setVisible(hmiService.getComponentConditionManager().isTrue(701468, n2));
                }
                if (hMIViewArray[10] == null) break;
                ((IconController)hMIViewArray[10]).setVisible(hmiService.getComponentConditionManager().isTrue(701469, n2));
                break;
            }
            case 4078: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701463, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((SharedTextureController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(700638, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((ProgressIconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(701462, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(701460, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((IconLabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(701515, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(701464, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((IconController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(701465, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((IconController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(701466, n2));
                }
                if (hMIViewArray[8] != null) {
                    ((IconController)hMIViewArray[8]).setVisible(hmiService.getComponentConditionManager().isTrue(701467, n2));
                }
                if (hMIViewArray[9] != null) {
                    ((IconController)hMIViewArray[9]).setVisible(hmiService.getComponentConditionManager().isTrue(701468, n2));
                }
                if (hMIViewArray[10] == null) break;
                ((IconController)hMIViewArray[10]).setVisible(hmiService.getComponentConditionManager().isTrue(701469, n2));
                break;
            }
            case 5624: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701460, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((IconLabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(701515, n2));
                break;
            }
            case 400441: {
                if (this.evaluateSimpleChoiceModelValueEqualsCondition(400441, n2, 1)) {
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
                    ((ProgressIconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701462, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(701460, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((IconLabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(701515, n2));
                break;
            }
            case 700441: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(700517, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(701205, n2));
                break;
            }
            case 700525: {
                if (hMIViewArray[0] != null) {
                    ((MenuSDSNumbersController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(700857, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuSDSNumbersController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(701207, n2));
                break;
            }
            case 700526: {
                if (hMIViewArray[0] != null) {
                    ((MenuSDSNumbersController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(700857, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuSDSNumbersController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(701207, n2));
                break;
            }
            case 700527: {
                if (hMIViewArray[0] != null) {
                    ((MenuSDSNumbersController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(700857, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuSDSNumbersController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(701207, n2));
                break;
            }
            case 700539: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701463, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((SharedTextureController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(700638, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((ProgressIconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(701462, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(701460, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((IconLabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(701515, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(701464, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((IconController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(701465, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((IconController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(701466, n2));
                }
                if (hMIViewArray[8] != null) {
                    ((IconController)hMIViewArray[8]).setVisible(hmiService.getComponentConditionManager().isTrue(701467, n2));
                }
                if (hMIViewArray[9] != null) {
                    ((IconController)hMIViewArray[9]).setVisible(hmiService.getComponentConditionManager().isTrue(701468, n2));
                }
                if (hMIViewArray[10] == null) break;
                ((IconController)hMIViewArray[10]).setVisible(hmiService.getComponentConditionManager().isTrue(701469, n2));
                break;
            }
            case 700560: {
                if (hMIViewArray[0] != null) {
                    ((GlassplateController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701211, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((GlassplateController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(701212, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((LayoutContainerController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(701203, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((MenuController)hMIViewArray[3]).setSDSSymbolsVisible(hmiService.getComponentConditionManager().isTrue(700084, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((MenuController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(701200, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((LayoutContainerController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(701204, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((LabelController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(701209, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((MenuController)hMIViewArray[7]).setSDSSymbolsVisible(hmiService.getComponentConditionManager().isTrue(701201, n2));
                }
                if (hMIViewArray[8] == null) break;
                ((MenuController)hMIViewArray[8]).setVisible(hmiService.getComponentConditionManager().isTrue(701202, n2));
                break;
            }
        }
    }

    private void executeConditionaDBOPTSETUPDOWNLOADMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 14: {
                if (hMIViewArray[0] == null) break;
                ((WaitAnimController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(700516, n2));
                break;
            }
            case 335: {
                if (hMIViewArray[0] == null) break;
                ((WaitAnimController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(700516, n2));
                break;
            }
        }
    }

    private void executeConditionaDBOPTSETUPEXPORTLISTMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 700451: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(700238, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(700237, n2));
                break;
            }
            case 700452: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(700452, n2, 0));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueGreaterCondition(700452, n2, 0));
                break;
            }
            case 700461: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(700461, n2, 0));
                break;
            }
        }
    }

    private void executeConditionaDBOPTSETUPEXPORTMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 523: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701036, n2));
                break;
            }
            case 700453: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(700453, n2, 0));
                break;
            }
            case 700454: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(700454, n2, 0));
                break;
            }
            case 700455: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(700455, n2, 0));
                break;
            }
            case 700521: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(700521, n2, 0));
                break;
            }
        }
    }

    private void executeConditionaDBOPTSETUPEXPORTPROCESSENDScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 700452: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(700452, n2, 0));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueGreaterCondition(700452, n2, 0));
                break;
            }
        }
    }

    private void executeConditionaDBOPTSETUPEXPORTPROCESSWAITScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 700452: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(700452, n2, 0));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueGreaterCondition(700452, n2, 0));
                break;
            }
        }
    }

    private void executeConditionaDBOPTSETUPIMPORTLISTMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 700463: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(700240, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(700239, n2));
                break;
            }
            case 700470: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(700470, n2, 1));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(700470, n2, 1));
                }
                if (hMIViewArray[2] != null) {
                    ((LabelController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(700470, n2, 0));
                }
                if (hMIViewArray[3] != null) {
                    ((LabelController)hMIViewArray[3]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(700470, n2, 1));
                }
                if (hMIViewArray[4] == null) break;
                ((LabelController)hMIViewArray[4]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(700470, n2, 0));
                break;
            }
            case 700473: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(700239, n2));
                break;
            }
            case 700477: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleChoiceModelValueEqualsCondition(700477, n2, 1));
                break;
            }
            case 700485: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(700485, n2, 0));
                break;
            }
        }
    }

    private void executeConditionaDBOPTSETUPIMPORTMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 360: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(700049, n2));
                break;
            }
            case 363: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(700049, n2));
                break;
            }
            case 367: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(700049, n2));
                break;
            }
            case 523: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(701037, n2));
                break;
            }
            case 700474: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(700474, n2, 0));
                break;
            }
            case 700475: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(700475, n2, 0));
                break;
            }
            case 700476: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(700476, n2, 0));
                break;
            }
            case 700522: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(700522, n2, 0));
                break;
            }
        }
    }

    private void executeConditionaDBOPTSETUPIMPORTPROCESSENDScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 700470: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(700470, n2, 1));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(700470, n2, 0));
                }
                if (hMIViewArray[2] != null) {
                    ((LabelController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(700470, n2, 1));
                }
                if (hMIViewArray[3] == null) break;
                ((LabelController)hMIViewArray[3]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(700470, n2, 0));
                break;
            }
        }
    }

    private void executeConditionaDBOPTSETUPIMPORTPROCESSWAITScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 3939: {
                if (hMIViewArray[0] == null) break;
                ((WaitAnimController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(701473, n2));
                break;
            }
            case 700470: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(700470, n2, 1));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(700470, n2, 0));
                }
                if (hMIViewArray[2] != null) {
                    ((LabelController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(700470, n2, 1));
                }
                if (hMIViewArray[3] == null) break;
                ((LabelController)hMIViewArray[3]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(700470, n2, 0));
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
                if (hmiService.getComponentConditionManager().isTrue(701035, n2)) {
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
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(700376, n2));
                break;
            }
            case 5583: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(700376, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(701503, n2)) {
                    if (hMIViewArray[1] != null) {
                        ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(1);
                    }
                } else if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(0);
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(!hmiService.getComponentConditionManager().isTrue(700677, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(701504, n2)) {
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
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(700376, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(701503, n2)) {
                    if (hMIViewArray[1] != null) {
                        ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(1);
                    }
                } else if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(0);
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(!hmiService.getComponentConditionManager().isTrue(700677, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(701504, n2)) {
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
                ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(700677, n2));
                break;
            }
            case 700489: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(700376, n2));
                break;
            }
        }
    }

    private void executeConditionaDBOPTSETUPMEMORYMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 700427: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(700427, n2, 0));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(700427, n2, 0));
                }
                if (hMIViewArray[2] == null) break;
                ((MenuItemController)hMIViewArray[2]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(700427, n2, 0));
                break;
            }
        }
    }

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

    public IPartialPopupController[] getPartialPopupStubs(int n) {
        return new IPartialPopupController[]{new PartialPopupStub(700017, -1, -1, 250, 0, 12, true, 7, n, 1, null, false, true), new PartialPopupStub(700055, -1, -1, 250, 0, 12, true, 7, n, 1, null, false, true), new PartialPopupStub(700056, -1, -1, 250, 0, 12, true, 7, n, 1, null, false, true)};
    }

    public IDrawerController[] getOptionDrawers(int n) {
        return new IDrawerController[]{(IDrawerController)AddressBookScreenBag1.aDBOPT(this, n)};
    }
}

