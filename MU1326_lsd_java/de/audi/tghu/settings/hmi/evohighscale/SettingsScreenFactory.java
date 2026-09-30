/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.settings.hmi.evohighscale;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.ButtonModel;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.LabelModel;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.sysconst.SysConstModel;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.hmi.view.HMIView;
import de.audi.atip.hmi.view.IDrawerController;
import de.audi.atip.hmi.view.IPartialPopupController;
import de.audi.atip.hmi.view.Screen;
import de.audi.tghu.settings.hmi.evohighscale.FontFactory;
import de.audi.tghu.settings.hmi.evohighscale.SettingsScreenBag1;
import de.audi.tghu.settings.hmi.evohighscale.SettingsScreenBag2;
import de.esolutions.hmi.widgets.audi.base.FontLoader;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.ScreenWidgetEVO;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ContainerRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ScreenRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupStub;
import de.esolutions.hmi.widgets.audi.evo.widgets.SmallStageApplicationIconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.WaitAnimController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.ListController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import java.util.NoSuchElementException;

public class SettingsScreenFactory
extends AbstractScreenFactory {
    private static HMIService hmiService;
    private static final int MODULE_ID = 11;
    private int[][] errorColors;
    public AbstractWidgetController[][] refWidgets = new AbstractWidgetController[8][3];

    public SettingsScreenFactory(IFrameworkAccess iFrameworkAccess) {
        super(11, iFrameworkAccess);
        hmiService = iFrameworkAccess.getHMIService();
    }

    private int[][] getErrorColors() {
        if (this.errorColors == null) {
            this.errorColors = new int[][]{{-16777216, -7829368}, {-16777216, -7829368}, {-16777216, -7829368}, {-16777216, -7829368}, {-16777216, -7829368}};
        }
        return this.errorColors;
    }

    public String getName() {
        return "HMISettingsEvoHighScale";
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
            case 1100002: {
                return SettingsScreenBag1.sETTINGSREFTEMPLATE(this, n2);
            }
            case 1100004: {
                return SettingsScreenBag1.sETTINGSLANGUAGEMAIN(this, n2);
            }
            case 1100005: {
                return SettingsScreenBag1.sETTINGSUNITSMAIN(this, n2);
            }
            case 1100006: {
                return SettingsScreenBag1.sETTINGSSDSMAIN(this, n2);
            }
            case 1100007: {
                return SettingsScreenBag1.sETTINGSFACTORYMAIN(this, n2);
            }
            case 1100008: {
                return SettingsScreenBag1.sETTINGSFACTORYRESET(this, n2);
            }
            case 1100009: {
                return SettingsScreenBag1.sETTINGSTIMEMAIN(this, n2);
            }
            case 1100010: {
                return SettingsScreenBag1.sETTINGSSDSTRAININGMAIN(this, n2);
            }
            case 1100011: {
                return SettingsScreenBag1.sETTINGSSDSTRAININGRESET(this, n2);
            }
            case 1100012: {
                return SettingsScreenBag1.sETTINGSSDSTRAININGERROR(this, n2);
            }
            case 1100013: {
                return SettingsScreenBag1.sETTINGSSDSTRAININGEND(this, n2);
            }
            case 1100016: {
                return SettingsScreenBag1.sETTINGSVERSIONMAIN(this, n2);
            }
            case 1100017: {
                return SettingsScreenBag1.sETTINGSVERSIONNAVDBCOUNTRIES(this, n2);
            }
            case 1100019: {
                return SettingsScreenBag1.sETTINGSSCREENBRIGHTNESSMAIN(this, n2);
            }
            case 1100020: {
                return SettingsScreenBag1.sETTINGSSDSVOLUME(this, n2);
            }
            case 1100023: {
                return SettingsScreenBag1.sETTINGSUSERHINTSMAIN(this, n2);
            }
            case 1100024: {
                return SettingsScreenBag1.sETTINGSUSERHINTSSET(this, n2);
            }
            case 1100025: {
                return SettingsScreenBag1.sETTINGSRESETDRIVERMENU(this, n2);
            }
            case 1100026: {
                return SettingsScreenBag1.sETTINGSRESETDRIVERREQUEST(this, n2);
            }
            case 1100028: {
                return SettingsScreenBag1.sETTINGSTIMETIMEZONE(this, n2);
            }
            case 1100034: {
                return SettingsScreenBag2.sETTINGSVERSIONSOFTWAREINFOHIGH(this, n2);
            }
            case 1100035: {
                return SettingsScreenBag2.sETTINGSSDSTRAININGSTOP(this, n2);
            }
            case 1100039: {
                return SettingsScreenBag2.sETTINGSRSEMAIN(this, n2);
            }
            case 1100040: {
                return SettingsScreenBag2.sETTINGSMMIMAIN(this, n2);
            }
            case 1100041: {
                return SettingsScreenBag2.sETTINGSSYSTEMMAIN(this, n2);
            }
            case 1100057: {
                return SettingsScreenBag2.sETTINGSVERSIONSOFTWAREINFO(this, n2);
            }
            case 1100059: {
                return SettingsScreenBag2.sETTINGSSDSTRAININGSTART(this, n2);
            }
            case 1100075: {
                return SettingsScreenBag2.sETTINGSTEXTCONSTANT(this, n2);
            }
            case 1100076: {
                return SettingsScreenBag2.sETTINGSWIRELESSCHARGINGMAIN(this, n2);
            }
            case 1100079: {
                return SettingsScreenBag2.sETTINGSFACTORYRESETREBOOT(this, n2);
            }
            case 1100044: {
                return SettingsScreenBag2.eTCSETTINGSMAIN(this, n2);
            }
            case 1100046: {
                return SettingsScreenBag2.eTCHISTORYDETAIL(this, n2);
            }
            case 1100047: {
                return SettingsScreenBag2.eTCHARDWAREMAIN(this, n2);
            }
            case 1100082: {
                return SettingsScreenBag2.eTCDESKTOPWITHHISTORYMAIN(this, n2);
            }
        }
        return this.createDefaultScreen(n, n2);
    }

    public AbstractWidgetController getRefWidget(int n, int n2, SettingsScreenFactory settingsScreenFactory) {
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
                this.refWidgets[n][2] = smallStageApplicationIconController2;
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
            default: {
                this.getFramework().getLogChannel("ScreenFactory").log(10000, "Invalid reference widget id " + n2 + ".");
            }
        }
        this.refWidgets[n][n2] = abstractWidgetController;
        return abstractWidgetController;
    }

    protected static final boolean evalCond1100007(int n) {
        return ((ChoiceModel)SettingsScreenFactory.getModel(375, n)).getValue() == 1 && ((ChoiceModel)SettingsScreenFactory.getModel(543, n)).getValue() != 1 && ((ChoiceModel)SettingsScreenFactory.getModel(107, n)).getValue() <= 2 && ((ChoiceModel)SettingsScreenFactory.getModel(3849, n)).getValue() <= 1;
    }

    protected static final boolean evalCond1100082(int n) {
        return ((SysConstModel)SettingsScreenFactory.getModel(3892, n)).getValue() == 1;
    }

    protected static final boolean evalCond1100083(int n) {
        return ((SysConstModel)SettingsScreenFactory.getModel(522, n)).getValue() == 4;
    }

    protected static final boolean evalCond1100084(int n) {
        return ((SysConstModel)SettingsScreenFactory.getModel(460, n)).getValue() != 1 || ((ChoiceModel)SettingsScreenFactory.getModel(323, n)).getValue() != 1 || ((ChoiceModel)SettingsScreenFactory.getModel(4088, n)).getValue() != 0;
    }

    protected static final boolean evalCond1100085(int n) {
        return ((ChoiceModel)SettingsScreenFactory.getModel(509, n)).getValue() == 1024 || ((SysConstModel)SettingsScreenFactory.getModel(461, n)).getValue() != 1;
    }

    protected static final boolean evalCond1100086(int n) {
        return ((ButtonModel)SettingsScreenFactory.getModel(343, n)).getStatus() == 1 && ((ChoiceModel)SettingsScreenFactory.getModel(361, n)).getValue() == 1 && ((SysConstModel)SettingsScreenFactory.getModel(442, n)).getValue() != 5 && ((SysConstModel)SettingsScreenFactory.getModel(442, n)).getValue() != 4;
    }

    protected static final boolean evalCond1100087(int n) {
        return ((SysConstModel)SettingsScreenFactory.getModel(523, n)).getValue() == 0;
    }

    protected static final boolean evalCond1100088(int n) {
        return ((SysConstModel)SettingsScreenFactory.getModel(4108, n)).getValue() == 0;
    }

    protected static final boolean evalCond1100089(int n) {
        return !(((ChoiceModel)SettingsScreenFactory.getModel(375, n)).getValue() != 1 || ((ChoiceModel)SettingsScreenFactory.getModel(391, n)).getValue() != 1 || ((ChoiceModel)SettingsScreenFactory.getModel(543, n)).getValue() == 1 || ((ChoiceModel)SettingsScreenFactory.getModel(392, n)).getValue() != 1 && ((ChoiceModel)SettingsScreenFactory.getModel(392, n)).getValue() == 0 && ((ChoiceModel)SettingsScreenFactory.getModel(390, n)).getValue() == 1 || ((SysConstModel)SettingsScreenFactory.getModel(3969, n)).getValue() == 1 && ((ButtonModel)SettingsScreenFactory.getModel(1700231, n)).getStatus() == 0 || ((ChoiceModel)SettingsScreenFactory.getModel(4468, n)).getValue() == 1);
    }

    protected static final boolean evalCond1100090(int n) {
        return ((ChoiceModel)SettingsScreenFactory.getModel(361, n)).getValue() == 1;
    }

    protected static final boolean evalCond1100099(int n) {
        return ((SysConstModel)SettingsScreenFactory.getModel(522, n)).getValue() != 4 || ((SysConstModel)SettingsScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond1100102(int n) {
        return ((LabelModel)SettingsScreenFactory.getModel(3852, n)).getStatus() == 0 || ((SysConstModel)SettingsScreenFactory.getModel(473, n)).getValue() == 0;
    }

    protected static final boolean evalCond1100103(int n) {
        return ((SysConstModel)SettingsScreenFactory.getModel(3969, n)).getValue() == 0 || ((SysConstModel)SettingsScreenFactory.getModel(522, n)).getValue() == 1 && ((SysConstModel)SettingsScreenFactory.getModel(523, n)).getValue() == 1 && ((SysConstModel)SettingsScreenFactory.getModel(4581, n)).getValue() == 0;
    }

    protected static final boolean evalCond1100104(int n) {
        return ((ChoiceModel)SettingsScreenFactory.getModel(375, n)).getValue() == 1 && ((ChoiceModel)SettingsScreenFactory.getModel(543, n)).getValue() != 1 && ((ChoiceModel)SettingsScreenFactory.getModel(107, n)).getValue() <= 2 && ((ChoiceModel)SettingsScreenFactory.getModel(3849, n)).getValue() <= 1 && ((ChoiceModel)SettingsScreenFactory.getModel(4074, n)).getValue() == 1;
    }

    protected static final boolean evalCond1100106(int n) {
        return ((ChoiceModel)SettingsScreenFactory.getModel(1100189, n)).getValue() == 2 || ((ChoiceModel)SettingsScreenFactory.getModel(1100189, n)).getValue() == 3;
    }

    protected static final boolean evalCond1100111(int n) {
        return ((SysConstModel)SettingsScreenFactory.getModel(522, n)).getValue() == 4;
    }

    protected static final boolean evalCond1100112(int n) {
        return ((ChoiceModel)SettingsScreenFactory.getModel(1100256, n)).getValue() == 1 || ((SysConstModel)SettingsScreenFactory.getModel(442, n)).getValue() == 3 && ((SysConstModel)SettingsScreenFactory.getModel(523, n)).getValue() != 0;
    }

    protected static final boolean evalCond1100121(int n) {
        return (((ChoiceModel)SettingsScreenFactory.getModel(361, n)).getValue() == 512 || ((SysConstModel)SettingsScreenFactory.getModel(459, n)).getValue() != 1) && ((ChoiceModel)SettingsScreenFactory.getModel(263, n)).getValue() != 1 && ((SysConstModel)SettingsScreenFactory.getModel(523, n)).getValue() == 0 || (((ChoiceModel)SettingsScreenFactory.getModel(361, n)).getValue() == 512 || ((SysConstModel)SettingsScreenFactory.getModel(459, n)).getValue() != 1 || ((ChoiceModel)SettingsScreenFactory.getModel(363, n)).getValue() != 1) && (((ChoiceModel)SettingsScreenFactory.getModel(363, n)).getValue() == 1 || ((ChoiceModel)SettingsScreenFactory.getModel(361, n)).getValue() == 512 || ((SysConstModel)SettingsScreenFactory.getModel(459, n)).getValue() != 1) && (((ChoiceModel)SettingsScreenFactory.getModel(361, n)).getValue() != 512 && ((SysConstModel)SettingsScreenFactory.getModel(459, n)).getValue() == 1 || ((ChoiceModel)SettingsScreenFactory.getModel(263, n)).getValue() != 1 || ((ChoiceModel)SettingsScreenFactory.getModel(363, n)).getValue() != 1) && (((ChoiceModel)SettingsScreenFactory.getModel(361, n)).getValue() != 512 && ((SysConstModel)SettingsScreenFactory.getModel(459, n)).getValue() == 1 || ((ChoiceModel)SettingsScreenFactory.getModel(363, n)).getValue() == 1 || ((ChoiceModel)SettingsScreenFactory.getModel(263, n)).getValue() != 1);
    }

    protected static final boolean evalCond1100122(int n) {
        return ((ChoiceModel)SettingsScreenFactory.getModel(361, n)).getValue() != 512 && ((SysConstModel)SettingsScreenFactory.getModel(459, n)).getValue() == 1 && ((ChoiceModel)SettingsScreenFactory.getModel(363, n)).getValue() == 1;
    }

    protected static final boolean evalCond1100123(int n) {
        return ((ChoiceModel)SettingsScreenFactory.getModel(363, n)).getValue() != 1 && ((ChoiceModel)SettingsScreenFactory.getModel(361, n)).getValue() != 512 && ((SysConstModel)SettingsScreenFactory.getModel(459, n)).getValue() == 1;
    }

    protected static final boolean evalCond1100124(int n) {
        return (((ChoiceModel)SettingsScreenFactory.getModel(361, n)).getValue() == 512 || ((SysConstModel)SettingsScreenFactory.getModel(459, n)).getValue() != 1) && ((ChoiceModel)SettingsScreenFactory.getModel(263, n)).getValue() == 1 && ((ChoiceModel)SettingsScreenFactory.getModel(363, n)).getValue() == 1;
    }

    protected static final boolean evalCond1100125(int n) {
        return (((ChoiceModel)SettingsScreenFactory.getModel(361, n)).getValue() == 512 || ((SysConstModel)SettingsScreenFactory.getModel(459, n)).getValue() != 1) && ((ChoiceModel)SettingsScreenFactory.getModel(363, n)).getValue() != 1 && ((ChoiceModel)SettingsScreenFactory.getModel(263, n)).getValue() == 1;
    }

    protected static final boolean evalCond1100127(int n) {
        return ((ChoiceModel)SettingsScreenFactory.getModel(1100225, n)).getValue() == 0 && ((SysConstModel)SettingsScreenFactory.getModel(523, n)).getValue() != 0;
    }

    protected static final boolean evalCond1100131(int n) {
        return ((SysConstModel)SettingsScreenFactory.getModel(460, n)).getValue() == 1;
    }

    protected static final boolean evalCond1100132(int n) {
        return ((SysConstModel)SettingsScreenFactory.getModel(4162, n)).getValue() == 1;
    }

    protected static final boolean evalCond1100133(int n) {
        return ((ChoiceModel)SettingsScreenFactory.getModel(4073, n)).getValue() > 0 || ((ChoiceModel)SettingsScreenFactory.getModel(30, n)).getValue() == 0 || ((ChoiceModel)SettingsScreenFactory.getModel(1000106, n)).getValue() == 1 || ((ChoiceModel)SettingsScreenFactory.getModel(4228, n)).getValue() == 1;
    }

    protected static final boolean evalCond1100134(int n) {
        return ((ChoiceModel)SettingsScreenFactory.getModel(4073, n)).getValue() > 0 || ((ChoiceModel)SettingsScreenFactory.getModel(1000102, n)).getValue() == 0 || ((ChoiceModel)SettingsScreenFactory.getModel(30, n)).getValue() == 0 || ((ChoiceModel)SettingsScreenFactory.getModel(1000106, n)).getValue() == 1 || ((ChoiceModel)SettingsScreenFactory.getModel(4228, n)).getValue() == 1;
    }

    protected static final boolean evalCond1100137(int n) {
        return ((ChoiceModel)SettingsScreenFactory.getModel(375, n)).getValue() == 1 && ((ChoiceModel)SettingsScreenFactory.getModel(391, n)).getValue() == 1 && ((ChoiceModel)SettingsScreenFactory.getModel(543, n)).getValue() != 1 && (((ChoiceModel)SettingsScreenFactory.getModel(392, n)).getValue() == 1 || ((ChoiceModel)SettingsScreenFactory.getModel(392, n)).getValue() != 0 || ((ChoiceModel)SettingsScreenFactory.getModel(390, n)).getValue() != 1) && ((ChoiceModel)SettingsScreenFactory.getModel(1700374, n)).getValue() != 0 && ((ChoiceModel)SettingsScreenFactory.getModel(4468, n)).getValue() != 1;
    }

    protected static final boolean evalCond1100139(int n) {
        return ((ChoiceModel)SettingsScreenFactory.getModel(1100189, n)).getValue() == 0 && ((ChoiceModel)SettingsScreenFactory.getModel(1100139, n)).getValue() == 1;
    }

    protected static final boolean evalCond1100140(int n) {
        return ((ChoiceModel)SettingsScreenFactory.getModel(1100189, n)).getValue() == 0 && ((ChoiceModel)SettingsScreenFactory.getModel(1100139, n)).getValue() == 1;
    }

    protected static final boolean evalCond1100141(int n) {
        return ((ChoiceModel)SettingsScreenFactory.getModel(1100241, n)).getValue() == 0 && ((ChoiceModel)SettingsScreenFactory.getModel(1100180, n)).getValue() == 1;
    }

    protected static final boolean evalCond1100143(int n) {
        return ((ChoiceModel)SettingsScreenFactory.getModel(4073, n)).getValue() > 0 || ((ChoiceModel)SettingsScreenFactory.getModel(30, n)).getValue() == 0 || ((ChoiceModel)SettingsScreenFactory.getModel(1000106, n)).getValue() == 1 || ((ChoiceModel)SettingsScreenFactory.getModel(4228, n)).getValue() == 1;
    }

    protected static final boolean evalCond1100144(int n) {
        return ((SysConstModel)SettingsScreenFactory.getModel(523, n)).getValue() == 0;
    }

    protected static final boolean evalCond1100148(int n) {
        return ((SysConstModel)SettingsScreenFactory.getModel(459, n)).getValue() == 1 && ((ChoiceModel)SettingsScreenFactory.getModel(361, n)).getValue() != 512;
    }

    protected static final boolean evalCond1100162(int n) {
        return ((BaseListModel)SettingsScreenFactory.getModel(1100276, n)).getLength() < 1 && ((ChoiceModel)SettingsScreenFactory.getModel(1100319, n)).getStatus() > 0;
    }

    protected static final boolean evalCond1100166(int n) {
        return ((SysConstModel)SettingsScreenFactory.getModel(4603, n)).getValue() == 1;
    }

    protected static final boolean evalCond1100167(int n) {
        return ((ChoiceModel)SettingsScreenFactory.getModel(361, n)).getValue() == 1 && (((SysConstModel)SettingsScreenFactory.getModel(442, n)).getValue() == 2 || ((SysConstModel)SettingsScreenFactory.getModel(442, n)).getValue() == 4);
    }

    protected static final boolean evalCond1100168(int n) {
        return ((ChoiceModel)SettingsScreenFactory.getModel(361, n)).getValue() == 1 && ((SysConstModel)SettingsScreenFactory.getModel(442, n)).getValue() == 2;
    }

    protected static final boolean evalCond1100169(int n) {
        return ((ChoiceModel)SettingsScreenFactory.getModel(361, n)).getValue() == 1 && ((SysConstModel)SettingsScreenFactory.getModel(442, n)).getValue() == 2;
    }

    public void executeCondition(int n, int n2, HMIView[] hMIViewArray, int n3) {
        switch (n2) {
            case 1100082: {
                this.executeConditioneTCDESKTOPWITHHISTORYMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 1100044: {
                this.executeConditioneTCSETTINGSMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 1100007: {
                this.executeConditionsETTINGSFACTORYMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 1100040: {
                this.executeConditionsETTINGSMMIMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 1100081: {
                this.executeConditionsETTINGSOPTScreen(n, hMIViewArray, n3);
                break;
            }
            case 1100025: {
                this.executeConditionsETTINGSRESETDRIVERMENUScreen(n, hMIViewArray, n3);
                break;
            }
            case 1100039: {
                this.executeConditionsETTINGSRSEMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 1100006: {
                this.executeConditionsETTINGSSDSMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 1100012: {
                this.executeConditionsETTINGSSDSTRAININGERRORScreen(n, hMIViewArray, n3);
                break;
            }
            case 1100010: {
                this.executeConditionsETTINGSSDSTRAININGMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 1100059: {
                this.executeConditionsETTINGSSDSTRAININGSTARTScreen(n, hMIViewArray, n3);
                break;
            }
            case 1100000: {
                this.executeConditionsETTINGSSELScreen(n, hMIViewArray, n3);
                break;
            }
            case 1100041: {
                this.executeConditionsETTINGSSYSTEMMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 1100009: {
                this.executeConditionsETTINGSTIMEMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 1100016: {
                this.executeConditionsETTINGSVERSIONMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 1100017: {
                this.executeConditionsETTINGSVERSIONNAVDBCOUNTRIESScreen(n, hMIViewArray, n3);
                break;
            }
            case 1100076: {
                this.executeConditionsETTINGSWIRELESSCHARGINGMAINScreen(n, hMIViewArray, n3);
                break;
            }
        }
    }

    private void executeConditioneTCDESKTOPWITHHISTORYMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1100276: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1100162, n2));
                break;
            }
            case 1100319: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(this.evaluateSimpleAbstractModelStatusEqualsCondition(1100319, n2, 0));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1100162, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((ListController)hMIViewArray[2]).setVisible(!this.evaluateSimpleAbstractModelStatusEqualsCondition(1100319, n2, 0));
                }
                if (hMIViewArray[3] == null) break;
                ((WaitAnimController)hMIViewArray[3]).setVisible(this.evaluateSimpleAbstractModelStatusEqualsCondition(1100319, n2, 0));
                break;
            }
        }
    }

    private void executeConditioneTCSETTINGSMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 522: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1100111, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSFACTORYMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1100087: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(1100087, n2, 0));
                break;
            }
        }
    }

    private void executeConditionsETTINGSMMIMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 323: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(1100084, n2));
                break;
            }
            case 460: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(1100084, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1100131, n2));
                break;
            }
            case 461: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1100085, n2));
                break;
            }
            case 509: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1100085, n2));
                break;
            }
            case 522: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1100083, n2));
                break;
            }
            case 4088: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(1100084, n2));
                break;
            }
            case 4162: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1100132, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSOPTScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 310: {
                if (hMIViewArray[0] == null) break;
                ((MenuController)hMIViewArray[0]).setSDSSymbolsVisible(this.evaluateSimpleChoiceModelValueGreaterCondition(310, n2, 0));
                break;
            }
        }
    }

    private void executeConditionsETTINGSRESETDRIVERMENUScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 107: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1100104, n2));
                break;
            }
            case 375: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1100104, n2));
                break;
            }
            case 543: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1100104, n2));
                break;
            }
            case 3849: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1100104, n2));
                break;
            }
            case 4074: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1100104, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSRSEMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 361: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1100148, n2));
                break;
            }
            case 459: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1100148, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSSDSMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 30: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(1100143, n2));
                break;
            }
            case 4073: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(1100143, n2));
                break;
            }
            case 4228: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(1100143, n2));
                break;
            }
            case 4603: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1100166, n2));
                break;
            }
            case 1000106: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(1100143, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSSDSTRAININGERRORScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 310: {
                if (hMIViewArray[0] == null) break;
                ((MenuController)hMIViewArray[0]).setSDSSymbolsVisible(this.evaluateSimpleChoiceModelValueGreaterCondition(310, n2, 0));
                break;
            }
        }
    }

    private void executeConditionsETTINGSSDSTRAININGMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 310: {
                if (hMIViewArray[0] == null) break;
                ((MenuController)hMIViewArray[0]).setSDSSymbolsVisible(this.evaluateSimpleChoiceModelValueGreaterCondition(310, n2, 0));
                break;
            }
        }
    }

    private void executeConditionsETTINGSSDSTRAININGSTARTScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 263: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1100121, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1100124, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((LabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1100125, n2));
                break;
            }
            case 361: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1100121, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1100122, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((LabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1100123, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((LabelController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(1100124, n2));
                }
                if (hMIViewArray[4] == null) break;
                ((LabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(1100125, n2));
                break;
            }
            case 363: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1100121, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1100122, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((LabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1100123, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((LabelController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(1100124, n2));
                }
                if (hMIViewArray[4] == null) break;
                ((LabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(1100125, n2));
                break;
            }
            case 459: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1100121, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1100122, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((LabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1100123, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((LabelController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(1100124, n2));
                }
                if (hMIViewArray[4] == null) break;
                ((LabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(1100125, n2));
                break;
            }
            case 523: {
                if (hMIViewArray[0] == null) break;
                ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1100121, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSSELScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 442: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1100112, n2));
                break;
            }
            case 522: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1100099, n2));
                break;
            }
            case 523: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1100112, n2));
                break;
            }
            case 3888: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueEqualsCondition(3888, n2, 1));
                break;
            }
            case 3892: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1100082, n2));
                break;
            }
            case 3939: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1100099, n2));
                break;
            }
            case 1100256: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1100112, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSSYSTEMMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 107: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1100007, n2));
                break;
            }
            case 375: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1100137, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(1100007, n2));
                break;
            }
            case 390: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1100137, n2));
                break;
            }
            case 391: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1100137, n2));
                break;
            }
            case 392: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1100137, n2));
                break;
            }
            case 523: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1100144, n2));
                break;
            }
            case 543: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1100137, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(1100007, n2));
                break;
            }
            case 3849: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1100007, n2));
                break;
            }
            case 4468: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1100137, n2));
                }
                if (this.evaluateSimpleChoiceModelValueEqualsCondition(4468, n2, 1)) {
                    if (hMIViewArray[1] == null) break;
                    ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(1);
                    break;
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(-1);
                break;
            }
            case 1700374: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1100137, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSTIMEMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1100138: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleChoiceModelValueEqualsCondition(1100138, n2, 2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(1100138, n2, 1));
                break;
            }
            case 1100139: {
                if (hmiService.getComponentConditionManager().isTrue(1100140, n2)) {
                    if (hMIViewArray[0] != null) {
                        ((MenuItemController)hMIViewArray[0]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setInfoLineDisabledTextIndex(-1);
                }
                if (hmiService.getComponentConditionManager().isTrue(1100139, n2)) {
                    if (hMIViewArray[1] == null) break;
                    ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(0);
                    break;
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(-1);
                break;
            }
            case 1100142: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleChoiceModelValueEqualsCondition(1100142, n2, 2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(1100142, n2, 1));
                break;
            }
            case 1100180: {
                if (hmiService.getComponentConditionManager().isTrue(1100141, n2)) {
                    if (hMIViewArray[0] == null) break;
                    ((MenuItemController)hMIViewArray[0]).setInfoLineDisabledTextIndex(0);
                    break;
                }
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setInfoLineDisabledTextIndex(-1);
                break;
            }
            case 1100183: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleChoiceModelValueEqualsCondition(1100183, n2, 2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(1100183, n2, 1));
                break;
            }
            case 1100189: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(1100189, n2, 1));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setEnabled(!hmiService.getComponentConditionManager().isTrue(1100106, n2));
                }
                if (this.evaluateSimpleChoiceModelValueEqualsCondition(1100189, n2, 3)) {
                    if (hMIViewArray[2] != null) {
                        ((MenuItemController)hMIViewArray[2]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setInfoLineDisabledTextIndex(-1);
                }
                if (hmiService.getComponentConditionManager().isTrue(1100140, n2)) {
                    if (hMIViewArray[3] != null) {
                        ((MenuItemController)hMIViewArray[3]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setInfoLineDisabledTextIndex(-1);
                }
                if (hmiService.getComponentConditionManager().isTrue(1100139, n2)) {
                    if (hMIViewArray[4] == null) break;
                    ((MenuItemController)hMIViewArray[4]).setInfoLineDisabledTextIndex(0);
                    break;
                }
                if (hMIViewArray[4] == null) break;
                ((MenuItemController)hMIViewArray[4]).setInfoLineDisabledTextIndex(-1);
                break;
            }
            case 1100241: {
                if (hmiService.getComponentConditionManager().isTrue(1100141, n2)) {
                    if (hMIViewArray[0] == null) break;
                    ((MenuItemController)hMIViewArray[0]).setInfoLineDisabledTextIndex(0);
                    break;
                }
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setInfoLineDisabledTextIndex(-1);
                break;
            }
        }
    }

    private void executeConditionsETTINGSVERSIONMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 343: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1100086, n2));
                break;
            }
            case 361: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1100090, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1100167, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1100168, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(1100169, n2));
                }
                if (hMIViewArray[4] == null) break;
                ((MenuItemController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(1100086, n2));
                break;
            }
            case 442: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1100167, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1100168, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1100169, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((MenuItemController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(1100086, n2));
                break;
            }
            case 473: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1100102, n2));
                break;
            }
            case 523: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1100087, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setEnabled(!hmiService.getComponentConditionManager().isTrue(1100127, n2));
                break;
            }
            case 3847: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!this.evaluateSimpleAbstractModelStatusEqualsCondition(3847, n2, 0));
                break;
            }
            case 3852: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1100102, n2));
                break;
            }
            case 4108: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1100088, n2));
                break;
            }
            case 1100225: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(1100127, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSVERSIONNAVDBCOUNTRIESScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 375: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1100089, n2));
                break;
            }
            case 390: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1100089, n2));
                break;
            }
            case 391: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1100089, n2));
                break;
            }
            case 392: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1100089, n2));
                break;
            }
            case 522: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1100103, n2));
                break;
            }
            case 523: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1100103, n2));
                break;
            }
            case 543: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1100089, n2));
                break;
            }
            case 3969: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1100089, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(1100103, n2));
                break;
            }
            case 4468: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1100089, n2));
                }
                if (this.evaluateSimpleChoiceModelValueEqualsCondition(4468, n2, 1)) {
                    if (hMIViewArray[1] == null) break;
                    ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(1);
                    break;
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(-1);
                break;
            }
            case 4581: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1100103, n2));
                break;
            }
            case 1700231: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1100089, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSWIRELESSCHARGINGMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 30: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(1100133, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setEnabled(!hmiService.getComponentConditionManager().isTrue(1100134, n2));
                break;
            }
            case 4073: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(1100133, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setEnabled(!hmiService.getComponentConditionManager().isTrue(1100134, n2));
                break;
            }
            case 4228: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(1100133, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setEnabled(!hmiService.getComponentConditionManager().isTrue(1100134, n2));
                break;
            }
            case 1000019: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1000019, n2, 1));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1000019, n2, 1));
                break;
            }
            case 1000102: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(1100134, n2));
                }
                if (this.evaluateSimpleChoiceModelValueEqualsCondition(1000102, n2, 0)) {
                    if (hMIViewArray[1] == null) break;
                    ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(0);
                    break;
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(-1);
                break;
            }
            case 1000106: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(1100133, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setEnabled(!hmiService.getComponentConditionManager().isTrue(1100134, n2));
                break;
            }
        }
    }

    public IPartialPopupController getPartialPopup(int n, int n2) {
        switch (n) {
            case 1100055: {
                return (IPartialPopupController)((Object)SettingsScreenBag2.mAINPOPUPTIMEZONE(this, n2));
            }
            case 1100056: {
                return (IPartialPopupController)((Object)SettingsScreenBag2.mAINPOPUPSOMMERTIME(this, n2));
            }
            case 1100048: {
                return (IPartialPopupController)((Object)SettingsScreenBag2.eTCPOPUPNOCARDINSERTEDJPMAIN(this, n2));
            }
            case 1100049: {
                return (IPartialPopupController)((Object)SettingsScreenBag2.eTCPOPUPCARDSTILLINSERTJPMAIN(this, n2));
            }
            case 1100053: {
                return (IPartialPopupController)((Object)SettingsScreenBag2.eTCPOPUPERRORJP(this, n2));
            }
            case 1100054: {
                return (IPartialPopupController)((Object)SettingsScreenBag2.eTCPOPUPPASSGATEJP(this, n2));
            }
        }
        return null;
    }

    public IPartialPopupController[] getPartialPopupStubs(int n) {
        return new IPartialPopupController[]{new PartialPopupStub(1100055, -1, -1, 245, 0, 12, true, 7, n, 1, null, true, true), new PartialPopupStub(1100056, -1, -1, 245, 0, 12, true, 7, n, 1, null, true, true), new PartialPopupStub(1100048, -1, -1, 165, 0, 7, true, 7, n, 1, null, false, true), new PartialPopupStub(1100049, -1, -1, 235, 0, 10, true, 7, n, 1, null, false, true), new PartialPopupStub(1100053, -1, -1, 235, 0, 10, true, 7, n, 1, null, true, true), new PartialPopupStub(1100054, -1, -1, 235, 0, 10, true, 7, n, 1, null, false, true)};
    }

    public IDrawerController[] getSelectionDrawers(int n) {
        return new IDrawerController[]{(IDrawerController)SettingsScreenBag1.sETTINGSSEL(this, n)};
    }

    public IDrawerController[] getOptionDrawers(int n) {
        return new IDrawerController[]{(IDrawerController)SettingsScreenBag2.sETTINGSOPT(this, n)};
    }
}

