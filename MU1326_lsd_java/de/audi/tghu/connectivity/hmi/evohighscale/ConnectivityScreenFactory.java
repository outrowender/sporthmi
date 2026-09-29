/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.connectivity.hmi.evohighscale;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
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
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityScreenBag1;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityScreenBag2;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityScreenBag3;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityScreenBag4;
import de.audi.tghu.connectivity.hmi.evohighscale.FontFactory;
import de.esolutions.hmi.widgets.audi.base.FontLoader;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.InstructionTextContoller;
import de.esolutions.hmi.widgets.audi.evo.ScreenWidgetEVO;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CheckboxRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ContainerRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.FocusCursorRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.GlassplateRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MultiLineLabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PartialPopupGlassplateRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PartialPopupRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ScreenRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ScrollbarRendererKanziHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.menu.MenuRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.CheckboxController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.DirectWritingController;
import de.esolutions.hmi.widgets.audi.evo.widgets.FocusCursorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.GlassplateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupGlassplateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupStub;
import de.esolutions.hmi.widgets.audi.evo.widgets.ScrollbarController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SmallStageApplicationIconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.WaitAnimController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.InfoLineRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.ListController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.SeparatingLineController;
import java.util.NoSuchElementException;

public class ConnectivityScreenFactory
extends AbstractScreenFactory {
    private static HMIService hmiService;
    private static final int MODULE_ID;
    private int[][] errorColors;
    public AbstractWidgetController[][] refWidgets = new AbstractWidgetController[8][21];

    public ConnectivityScreenFactory(IFrameworkAccess iFrameworkAccess) {
        super(25, iFrameworkAccess);
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
        return "HMIConnectivityEvoHighScale";
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
            case 2500000: {
                return ConnectivityScreenBag1.cMREFTEMPLATE(this, n2);
            }
            case 2500003: {
                return ConnectivityScreenBag1.cMOPTBLUETOOTHNAMEEDIT(this, n2);
            }
            case 2500004: {
                return ConnectivityScreenBag1.cMOPTBLUETOOTHMAIN(this, n2);
            }
            case 2500005: {
                return ConnectivityScreenBag1.cMMAIN(this, n2);
            }
            case 2500007: {
                return ConnectivityScreenBag1.cMOPTBLUETOOTHBONDINGSEARCH(this, n2);
            }
            case 2500009: {
                return ConnectivityScreenBag1.cMOPTBLUETOOTHBONDINGDEVICE(this, n2);
            }
            case 2500010: {
                return ConnectivityScreenBag1.cMOPTBLUETOOTHBONDINGWAIT(this, n2);
            }
            case 2500011: {
                return ConnectivityScreenBag1.cMOPTBLUETOOTHBONDINGCOMPARE(this, n2);
            }
            case 2500012: {
                return ConnectivityScreenBag1.cMOPTBLUETOOTHBONDINGCODEEDIT(this, n2);
            }
            case 2500013: {
                return ConnectivityScreenBag1.cMOPTBLUETOOTHBONDINGDISP(this, n2);
            }
            case 2500014: {
                return ConnectivityScreenBag1.cMOPTBLUETOOTHBONDINGDISPSELECT(this, n2);
            }
            case 2500015: {
                return ConnectivityScreenBag1.cMOPTBLUETOOTHBONDINGCODEERROR(this, n2);
            }
            case 2500016: {
                return ConnectivityScreenBag1.cMPOPUPBLUETOOTHBONDINGERROR(this, n2);
            }
            case 2500017: {
                return ConnectivityScreenBag1.cMPOPUPBLUETOOTHOBEXCODEID(this, n2);
            }
            case 2500018: {
                return ConnectivityScreenBag1.cMPOPUPBLUETOOTHOBEXCODEPASSWORD(this, n2);
            }
            case 2500019: {
                return ConnectivityScreenBag1.cMOPTBLUETOOTHBONDINGPAIREDHFP(this, n2);
            }
            case 2500020: {
                return ConnectivityScreenBag1.cMOPTBLUETOOTHBONDINGPAIREDSAP(this, n2);
            }
            case 2500021: {
                return ConnectivityScreenBag1.cMOPTBLUETOOTHBONDINGPAIREDSAPHOTSPOT(this, n2);
            }
            case 2500022: {
                return ConnectivityScreenBag1.cMOPTBLUETOOTHBONDINGPAIREDHFPTETHERING(this, n2);
            }
            case 2500023: {
                return ConnectivityScreenBag1.cMOPTWLANMAIN(this, n2);
            }
            case 2500024: {
                return ConnectivityScreenBag2.cMOPTWLANSETUP(this, n2);
            }
            case 2500025: {
                return ConnectivityScreenBag2.cMOPTWLANSETUPEDITSSID(this, n2);
            }
            case 2500026: {
                return ConnectivityScreenBag2.cMOPTWLANSETUPEDITPASSWORD(this, n2);
            }
            case 2500027: {
                return ConnectivityScreenBag2.cMOPTWLANTETHERINGSEARCH(this, n2);
            }
            case 2500028: {
                return ConnectivityScreenBag2.cMOPTWLANTETHERINGDEVICES(this, n2);
            }
            case 2500030: {
                return ConnectivityScreenBag2.cMOPTWLANTETHERINGCODEERROR(this, n2);
            }
            case 2500031: {
                return ConnectivityScreenBag2.cMOPTWLANTETHERINGCODEEDIT(this, n2);
            }
            case 2500032: {
                return ConnectivityScreenBag2.cMOPTWLANBONDINGCONNECTEDWAIT(this, n2);
            }
            case 2500033: {
                return ConnectivityScreenBag2.cMOPTCONNECTSETUPDATAMAIN(this, n2);
            }
            case 2500034: {
                return ConnectivityScreenBag2.cMOPTCONNECTSETUPMAIN(this, n2);
            }
            case 2500035: {
                return ConnectivityScreenBag2.cMOPTCONNECTSETUPEDITAPN(this, n2);
            }
            case 2500036: {
                return ConnectivityScreenBag2.cMOPTCONNECTSETUPEDITUSER(this, n2);
            }
            case 2500037: {
                return ConnectivityScreenBag2.cMOPTCONNECTSETUPEDITPASSWORD(this, n2);
            }
            case 2500039: {
                return ConnectivityScreenBag2.cMPOPUPBLUETOOTHEXTERNALCODEEDIT(this, n2);
            }
            case 2500040: {
                return ConnectivityScreenBag2.cMOPTONLINESETUPDATACOUNTER(this, n2);
            }
            case 2500044: {
                return ConnectivityScreenBag2.cMPOPUPONLINEDISCLAIMERSHOW(this, n2);
            }
            case 2500045: {
                return ConnectivityScreenBag2.cMPOPUPONLINECONNECTIONREQUEST(this, n2);
            }
            case 2500047: {
                return ConnectivityScreenBag2.cMPOPUPONLINEERRORNOCONFIG(this, n2);
            }
            case 2500048: {
                return ConnectivityScreenBag2.cMPOPUPONLINEERRORNOPHONE(this, n2);
            }
            case 2500049: {
                return ConnectivityScreenBag2.cMPOPUPONLINEERRORNOPIN(this, n2);
            }
            case 2500050: {
                return ConnectivityScreenBag2.cMPOPUPONLINEERRORNOSIMAP(this, n2);
            }
            case 2500051: {
                return ConnectivityScreenBag3.cMPOPUPONLINEERRORDATADEACTIVATE(this, n2);
            }
            case 2500052: {
                return ConnectivityScreenBag3.cMPOPUPONLINEERRORNOROAMING(this, n2);
            }
            case 2500053: {
                return ConnectivityScreenBag3.cMPOPUPONLINEERRORGSMACTIVE(this, n2);
            }
            case 2500054: {
                return ConnectivityScreenBag3.cMPOPUPONLINEERRORROAMINGDISCLAIMER(this, n2);
            }
            case 2500058: {
                return ConnectivityScreenBag3.cMPOPUPONLINEERRORNOSIM(this, n2);
            }
            case 0x262611: {
                return ConnectivityScreenBag3.cMPOPUPONLINEERRORDATAMODULEDEACTIVATE(this, n2);
            }
            case 2500059: {
                return ConnectivityScreenBag3.cMOPTWLANBONDINGCONNECTEDMAIN(this, n2);
            }
            case 2500060: {
                return ConnectivityScreenBag3.cMPOPUPWLANBONDINGERRORELSE(this, n2);
            }
            case 2500061: {
                return ConnectivityScreenBag3.cMPOPUPWLANBONDINGERRORPIN(this, n2);
            }
            case 2500063: {
                return ConnectivityScreenBag3.cMOPTCHANGEACBONDINGDISCLAIMER(this, n2);
            }
            case 2500065: {
                return ConnectivityScreenBag3.cMPOPUPONLINEERRORSSERVERMULTICONFIGPROFILESMAIN(this, n2);
            }
            case 2500072: {
                return ConnectivityScreenBag3.cMOPTBLUETOOTHDEVICESPROFILESSHOWN(this, n2);
            }
            case 2500084: {
                return ConnectivityScreenBag3.cMOPTONLINESETUPMAIN(this, n2);
            }
            case 2500085: {
                return ConnectivityScreenBag3.cMOPTONLINESETUPDATASTATUS(this, n2);
            }
            case 2500087: {
                return ConnectivityScreenBag3.cMOPTONLINESETUPSECURITYMAIN(this, n2);
            }
            case 2500089: {
                return ConnectivityScreenBag3.cMOPTBLUETOOTHSCONTACTERROR(this, n2);
            }
            case 2500090: {
                return ConnectivityScreenBag3.cMPOPUPONLINEERRORNOPUK(this, n2);
            }
            case 2500091: {
                return ConnectivityScreenBag3.cMOPTONLINEUNLOCKPUKBLOCKED(this, n2);
            }
            case 2500092: {
                return ConnectivityScreenBag3.cMPOPUPONLINEERRORSIMFAILURE(this, n2);
            }
            case 2500093: {
                return ConnectivityScreenBag3.cMOPTWLANSCONTACTERROR(this, n2);
            }
            case 0x262602: {
                return ConnectivityScreenBag4.cMPOPUPBLUETOOTHOBEXMAIN(this, n2);
            }
            case 2500099: {
                return ConnectivityScreenBag4.cMPOPUPBLUETOOTHNA(this, n2);
            }
            case 2500109: {
                return ConnectivityScreenBag4.cMTEXTCONST(this, n2);
            }
            case 2500110: {
                return ConnectivityScreenBag4.cMOPTCHANGEACHOTSPOT(this, n2);
            }
            case 2500116: {
                return ConnectivityScreenBag4.cMOPTBLUETOOTHBONDINGWAITAUDIO(this, n2);
            }
            case 2500111: {
                return ConnectivityScreenBag4.cMPOPUPONLINEERRORSSERVERMULTICONFIG(this, n2);
            }
            case 2500112: {
                return ConnectivityScreenBag4.cMOPTBLUETOOTHBONDINGCONNECTEDSAPESIMACTIVE(this, n2);
            }
            case 0x262625: {
                return ConnectivityScreenBag4.cMOPTBLUETOOTHBONDINGTRUSTEDDEVICES(this, n2);
            }
            case 0x262629: {
                return ConnectivityScreenBag4.cMPOPUPONLINEERRORNOESIM(this, n2);
            }
            case 0x26262A: {
                return ConnectivityScreenBag4.cMPOPUPONLINEERRORNOPHONEESIM(this, n2);
            }
            case 0x26262C: {
                return ConnectivityScreenBag4.cMOPTABOUTCARPLAY(this, n2);
            }
            case 0x26262D: {
                return ConnectivityScreenBag4.cMOPTABOUTANDROIDAUTO(this, n2);
            }
            case 0x26262F: {
                return ConnectivityScreenBag4.cMOPTCONNECTSETUPMAIN2(this, n2);
            }
            case 2500144: {
                return ConnectivityScreenBag4.cMOPTCONNECTSETUPEDITAPN2(this, n2);
            }
            case 2500145: {
                return ConnectivityScreenBag4.cMOPTCONNECTSETUPEDITUSERAPN2(this, n2);
            }
            case 0x262632: {
                return ConnectivityScreenBag4.cMOPTCONNECTSETUPEDITPASSWORDAPN2(this, n2);
            }
            case 2500148: {
                return ConnectivityScreenBag4.cMOPTABOUTBAIDUCARLIFE(this, n2);
            }
            case 0x262636: {
                return ConnectivityScreenBag4.cMPOPUPONLINEGPS(this, n2);
            }
        }
        return this.createDefaultScreen(n, n2);
    }

    public AbstractWidgetController getRefWidget(int n, int n2, ConnectivityScreenFactory connectivityScreenFactory) {
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
                GlassplateController glassplateController = new GlassplateController();
                GlassplateRendererHigh glassplateRendererHigh = new GlassplateRendererHigh(glassplateController);
                glassplateController.setRenderer(glassplateRendererHigh);
                glassplateController.setBounds(0, 0, 100, 100);
                glassplateController.setSdsNumbersGapWidth(4);
                glassplateController.setSdsNumbersWidth(64);
                ScrollbarController scrollbarController = new ScrollbarController();
                ScrollbarRendererKanziHigh scrollbarRendererKanziHigh = new ScrollbarRendererKanziHigh(scrollbarController);
                scrollbarController.setRenderer(scrollbarRendererKanziHigh);
                scrollbarController.setBounds(703, 11, 5, 302);
                FocusCursorController focusCursorController = new FocusCursorController();
                FocusCursorRendererHigh focusCursorRendererHigh = new FocusCursorRendererHigh(focusCursorController);
                focusCursorController.setRenderer(focusCursorRendererHigh);
                focusCursorController.setBounds(0, 0, 100, 100);
                focusCursorController.setColorIndices(new int[]{1, 2, 4, 0});
                focusCursorController.setOptionsIconVisible(false);
                MenuController menuController = new MenuController();
                MenuRendererHigh menuRendererHigh = new MenuRendererHigh(menuController);
                menuController.setRenderer(menuRendererHigh);
                menuController.createInfolineWidgets(new InfoLineRendererHigh());
                menuController.getInfoline().getInfolineRenderer().setFonts(connectivityScreenFactory.getFonts(1, n));
                menuController.setDefaultDisabledInfolineTextId(-2027411968);
                menuController.getInfolineTimer().setIdleTime(800);
                menuController.getInfoline().setColorIndices(new int[]{2, 0, 4, 3});
                menuController.getLayout().setBackgroundInsetsVert(7);
                menuController.getLayout().setContentLeftOffset(12);
                menuController.getLayout().setContentRightOffset(25);
                menuController.getLayout().setContentRightOffsetSmallStage(25);
                menuController.getLayout().setItemsGap(9);
                menuController.getLayout().setOptionsIconAdditionalRightInsets(16);
                menuController.setBounds(62, 77, 716, 324);
                menuController.setColorIndices(new int[]{1, 0, 4, 0, 2, 3});
                menuController.setCoordinateSets(new int[]{2, 62, 77, 716, 324, 62, 77, 716, 324});
                menuController.add(glassplateController, 4);
                menuController.add(scrollbarController, 3);
                menuController.add(focusCursorController, 1);
                LabelController labelController = new LabelController();
                MultiLineLabelRendererHigh multiLineLabelRendererHigh = new MultiLineLabelRendererHigh(labelController);
                labelController.setRenderer(multiLineLabelRendererHigh);
                labelController.setTextIds(new int[]{1428694528});
                labelController.setCoordinateSets(new int[]{2, -1, -1, 0, 0, -1, -1, 0, 0});
                labelController.setModelColumn(1);
                InstructionTextContoller instructionTextContoller = new InstructionTextContoller();
                instructionTextContoller.setBounds(0, 0, 100, 100);
                instructionTextContoller.setColorIndices(new int[]{1, 0, 4, 0});
                instructionTextContoller.setCoordinateSets(new int[]{2, 0, 0, 100, 100, 0, 0, 100, 100});
                instructionTextContoller.setOptions(menuController);
                instructionTextContoller.addHintText(labelController);
                abstractWidgetController = instructionTextContoller;
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
                partialPopupGlassplateController.setSeparatorVisible(true);
                partialPopupGlassplateController.setSeparatorYPosition(227);
                LabelController labelController = new LabelController();
                MultiLineLabelRendererHigh multiLineLabelRendererHigh = new MultiLineLabelRendererHigh(labelController);
                labelController.setRenderer(multiLineLabelRendererHigh);
                labelController.setTextIds(new int[]{757540352});
                labelController.setReplacementModelIds(new int[]{-1306188288, -1356519936});
                this.refWidgets[n][5] = labelController;
                labelController.setBounds(0, 0, 0, 227);
                multiLineLabelRendererHigh.setAlignment(2, 4);
                FocusCursorController focusCursorController = new FocusCursorController();
                FocusCursorRendererHigh focusCursorRendererHigh = new FocusCursorRendererHigh(focusCursorController);
                focusCursorController.setRenderer(focusCursorRendererHigh);
                focusCursorController.setBounds(0, 0, 100, 100);
                focusCursorController.setColorIndices(new int[]{1, 2, 4, 0});
                focusCursorController.setOptionsIconVisible(false);
                MenuController menuController = new MenuController();
                MenuRendererHigh menuRendererHigh = new MenuRendererHigh(menuController);
                menuController.setRenderer(menuRendererHigh);
                menuController.createInfolineWidgets(new InfoLineRendererHigh());
                menuController.getInfoline().getInfolineRenderer().setFonts(connectivityScreenFactory.getFonts(1, n));
                menuController.setDefaultDisabledInfolineTextId(-1960303104);
                menuController.getInfolineTimer().setIdleTime(800);
                menuController.getInfoline().setColorIndices(new int[]{2, 0, 4, 3});
                menuController.getLayout().setBackgroundInsetsVert(7);
                menuController.getLayout().setContentLeftOffset(12);
                menuController.getLayout().setContentRightOffset(25);
                menuController.getLayout().setContentRightOffsetSmallStage(25);
                menuController.getLayout().setItemsGap(9);
                menuController.getLayout().setOptionsIconAdditionalRightInsets(16);
                menuController.setBounds(0, 191, 634, 305);
                menuController.setColorIndices(new int[]{1, 0, 4, 0, 2, 3});
                menuController.setCoordinateSets(new int[]{3, 0, 191, 634, 305, 551, 423, 337, 249});
                menuController.add(focusCursorController, 1);
                InstructionTextContoller instructionTextContoller = new InstructionTextContoller();
                CompositeRendererHigh compositeRendererHigh = new CompositeRendererHigh(instructionTextContoller);
                instructionTextContoller.setRenderer(compositeRendererHigh);
                instructionTextContoller.setBounds(0, 0, 100, 100);
                instructionTextContoller.setColorIndices(new int[]{1, 0, 4, 0});
                instructionTextContoller.addHintText(labelController);
                instructionTextContoller.setOptions(menuController);
                PartialPopupController partialPopupController = new PartialPopupController();
                PartialPopupRendererHigh partialPopupRendererHigh = new PartialPopupRendererHigh(partialPopupController);
                partialPopupController.setRenderer(partialPopupRendererHigh);
                partialPopupController.setAutoHideTime(2500);
                partialPopupController.setBounds(400, 400, 634, 128);
                partialPopupController.setConsumeDDSPress(2);
                partialPopupController.setConsumeHKReturn(1);
                partialPopupController.setConsumeKeyTurned(2);
                partialPopupController.setDynamicSize(true);
                partialPopupController.setGreyOutBackground(true);
                partialPopupController.setID(-266000896);
                partialPopupController.setPriority(1200);
                partialPopupController.setStyle(1);
                partialPopupController.setZpmPriority(250);
                partialPopupController.setZpmSlot(12);
                partialPopupController.setBackgroundController(partialPopupGlassplateController);
                partialPopupController.add(instructionTextContoller);
                abstractWidgetController = partialPopupController;
                break;
            }
            case 6: {
                PartialPopupGlassplateController partialPopupGlassplateController = new PartialPopupGlassplateController();
                PartialPopupGlassplateRendererHigh partialPopupGlassplateRendererHigh = new PartialPopupGlassplateRendererHigh(partialPopupGlassplateController);
                partialPopupGlassplateController.setRenderer(partialPopupGlassplateRendererHigh);
                partialPopupGlassplateController.setBounds(0, 0, 100, 100);
                partialPopupGlassplateController.setSeparatorVisible(true);
                partialPopupGlassplateController.setSeparatorYPosition(227);
                LabelController labelController = new LabelController();
                MultiLineLabelRendererHigh multiLineLabelRendererHigh = new MultiLineLabelRendererHigh(labelController);
                labelController.setRenderer(multiLineLabelRendererHigh);
                labelController.setTextIds(new int[]{774317568});
                labelController.setReplacementModelIds(new int[]{-1306188288, -1356519936});
                this.refWidgets[n][7] = labelController;
                labelController.setBounds(0, 0, 0, 227);
                multiLineLabelRendererHigh.setAlignment(2, 4);
                FocusCursorController focusCursorController = new FocusCursorController();
                FocusCursorRendererHigh focusCursorRendererHigh = new FocusCursorRendererHigh(focusCursorController);
                focusCursorController.setRenderer(focusCursorRendererHigh);
                focusCursorController.setBounds(0, 0, 100, 100);
                focusCursorController.setColorIndices(new int[]{1, 2, 4, 0});
                focusCursorController.setOptionsIconVisible(false);
                MenuController menuController = new MenuController();
                MenuRendererHigh menuRendererHigh = new MenuRendererHigh(menuController);
                menuController.setRenderer(menuRendererHigh);
                menuController.createInfolineWidgets(new InfoLineRendererHigh());
                menuController.getInfoline().getInfolineRenderer().setFonts(connectivityScreenFactory.getFonts(1, n));
                menuController.setDefaultDisabledInfolineTextId(-1960303104);
                menuController.getInfolineTimer().setIdleTime(800);
                menuController.getInfoline().setColorIndices(new int[]{2, 0, 4, 3});
                menuController.getLayout().setBackgroundInsetsVert(7);
                menuController.getLayout().setContentLeftOffset(12);
                menuController.getLayout().setContentRightOffset(25);
                menuController.getLayout().setContentRightOffsetSmallStage(25);
                menuController.getLayout().setItemsGap(9);
                menuController.getLayout().setOptionsIconAdditionalRightInsets(16);
                menuController.setBounds(0, 191, 634, 305);
                menuController.setColorIndices(new int[]{1, 0, 4, 0, 2, 3});
                menuController.setCoordinateSets(new int[]{3, 0, 191, 634, 305, 551, 423, 337, 249});
                menuController.add(focusCursorController, 1);
                InstructionTextContoller instructionTextContoller = new InstructionTextContoller();
                CompositeRendererHigh compositeRendererHigh = new CompositeRendererHigh(instructionTextContoller);
                instructionTextContoller.setRenderer(compositeRendererHigh);
                instructionTextContoller.setBounds(0, 0, 100, 100);
                instructionTextContoller.setColorIndices(new int[]{1, 0, 4, 0});
                instructionTextContoller.addHintText(labelController);
                instructionTextContoller.setOptions(menuController);
                PartialPopupController partialPopupController = new PartialPopupController();
                PartialPopupRendererHigh partialPopupRendererHigh = new PartialPopupRendererHigh(partialPopupController);
                partialPopupController.setRenderer(partialPopupRendererHigh);
                partialPopupController.setBounds(400, 400, 634, 100);
                partialPopupController.setConsumeDDSPress(2);
                partialPopupController.setConsumeHKReturn(3);
                partialPopupController.setConsumeKeyTurned(2);
                partialPopupController.setDynamicSize(true);
                partialPopupController.setGreyOutBackground(true);
                partialPopupController.setID(-249223680);
                partialPopupController.setPriority(1200);
                partialPopupController.setStyle(1);
                partialPopupController.setZpmPriority(250);
                partialPopupController.setZpmSlot(12);
                partialPopupController.setBackgroundController(partialPopupGlassplateController);
                partialPopupController.add(instructionTextContoller);
                abstractWidgetController = partialPopupController;
                break;
            }
            case 8: {
                PartialPopupGlassplateController partialPopupGlassplateController = new PartialPopupGlassplateController();
                PartialPopupGlassplateRendererHigh partialPopupGlassplateRendererHigh = new PartialPopupGlassplateRendererHigh(partialPopupGlassplateController);
                partialPopupGlassplateController.setRenderer(partialPopupGlassplateRendererHigh);
                partialPopupGlassplateController.setBounds(0, 0, 100, 100);
                LabelController labelController = new LabelController();
                MultiLineLabelRendererHigh multiLineLabelRendererHigh = new MultiLineLabelRendererHigh(labelController);
                labelController.setRenderer(multiLineLabelRendererHigh);
                labelController.setTextIds(new int[]{841426432});
                labelController.setBounds(0, 0, 0, 232);
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
                menuItemController.setLabelId(858203648);
                menuItemController.setGlassplateInsetsBottom(6);
                menuItemController.setGlassplateInsetsTop(7);
                menuItemController.setInternalID(1009133056);
                menuItemController.setType(2);
                MenuController menuController = new MenuController();
                MenuRendererHigh menuRendererHigh = new MenuRendererHigh(menuController);
                menuController.setRenderer(menuRendererHigh);
                menuController.createInfolineWidgets(new InfoLineRendererHigh());
                menuController.getInfoline().getInfolineRenderer().setFonts(connectivityScreenFactory.getFonts(1, n));
                menuController.setDefaultDisabledInfolineTextId(-1960303104);
                menuController.getInfolineTimer().setIdleTime(800);
                menuController.getInfoline().setColorIndices(new int[]{2, 0, 4, 3});
                menuController.getLayout().setBackgroundInsetsVert(7);
                menuController.getLayout().setContentLeftOffset(12);
                menuController.getLayout().setContentRightOffset(25);
                menuController.getLayout().setContentRightOffsetSmallStage(25);
                menuController.getLayout().setItemsGap(9);
                menuController.getLayout().setOptionsIconAdditionalRightInsets(16);
                menuController.setBounds(0, 191, 634, 101);
                menuController.setCalculatePreferredSize(true);
                menuController.setColorIndices(new int[]{1, 0, 4, 0, 2, 3});
                menuController.setCoordinateSets(new int[]{3, 0, 191, 634, 101, 551, 423, 337, 249});
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
                partialPopupController.setBounds(400, 400, 634, 0);
                partialPopupController.setConsumeDDSPress(1);
                partialPopupController.setConsumeHKReturn(1);
                partialPopupController.setConsumeJoystickEast(2);
                partialPopupController.setConsumeJoystickWest(2);
                partialPopupController.setConsumeKeyTurned(2);
                partialPopupController.setConsumeSKPress(4);
                partialPopupController.setContentInset(10);
                partialPopupController.setDynamicSize(true);
                partialPopupController.setGreyOutBackground(true);
                partialPopupController.setID(-232446464);
                partialPopupController.setPriority(1200);
                partialPopupController.setStyle(1);
                partialPopupController.setZpmPriority(250);
                partialPopupController.setZpmSlot(12);
                partialPopupController.setBackgroundController(partialPopupGlassplateController);
                partialPopupController.add(instructionTextContoller);
                abstractWidgetController = partialPopupController;
                break;
            }
            case 9: {
                PartialPopupGlassplateController partialPopupGlassplateController = new PartialPopupGlassplateController();
                PartialPopupGlassplateRendererHigh partialPopupGlassplateRendererHigh = new PartialPopupGlassplateRendererHigh(partialPopupGlassplateController);
                partialPopupGlassplateController.setRenderer(partialPopupGlassplateRendererHigh);
                partialPopupGlassplateController.setBounds(0, 0, 100, 100);
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{975644160});
                labelController.setModelColumn(1);
                LabelController labelController2 = new LabelController();
                LabelRendererHigh labelRendererHigh2 = new LabelRendererHigh(labelController2);
                labelController2.setRenderer(labelRendererHigh2);
                labelController2.setTextIds(new int[]{992421376});
                this.refWidgets[n][10] = labelController2;
                labelController2.setModelColumn(1);
                LayoutContainerController layoutContainerController = new LayoutContainerController();
                CompositeRendererHigh compositeRendererHigh = new CompositeRendererHigh(layoutContainerController);
                layoutContainerController.setRenderer(compositeRendererHigh);
                layoutContainerController.setBounds(0, 0, 100, 100);
                GridLayout gridLayout = new GridLayout();
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.grow = new float[]{1.0f};
                gridLayout.setColumnConstraints(axisConstraints);
                AxisConstraints axisConstraints2 = new AxisConstraints(2);
                axisConstraints2.gaps = new int[]{0, 11, 11};
                gridLayout.setRowConstraints(axisConstraints2);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(0, 1);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2}, new Object[]{labelController, labelController2});
                layoutContainerController.setLayoutManager(gridLayout);
                layoutContainerController.add(labelController);
                layoutContainerController.add(labelController2);
                LabelController labelController3 = new LabelController();
                LabelRendererHigh labelRendererHigh3 = new LabelRendererHigh(labelController3);
                labelController3.setRenderer(labelRendererHigh3);
                labelController3.setTextIds(new int[]{1009198592});
                this.refWidgets[n][11] = labelController3;
                labelController3.setModelColumn(1);
                CheckboxController checkboxController = new CheckboxController();
                CheckboxRendererHigh checkboxRendererHigh = new CheckboxRendererHigh(checkboxController);
                checkboxController.setRenderer(checkboxRendererHigh);
                checkboxController.setModelID(1562781184);
                this.refWidgets[n][12] = checkboxController;
                checkboxController.setBounds(0, 0, 100, 100);
                checkboxController.setMapping(new int[][]{{0}, {2}});
                checkboxController.setModelColumn(2);
                LabelController labelController4 = new LabelController();
                LabelRendererHigh labelRendererHigh4 = new LabelRendererHigh(labelController4);
                labelController4.setRenderer(labelRendererHigh4);
                labelController4.setTextIds(new int[]{1025975808});
                this.refWidgets[n][13] = labelController4;
                labelController4.setModelColumn(1);
                CheckboxController checkboxController2 = new CheckboxController();
                CheckboxRendererHigh checkboxRendererHigh2 = new CheckboxRendererHigh(checkboxController2);
                checkboxController2.setRenderer(checkboxRendererHigh2);
                checkboxController2.setModelID(1596335616);
                this.refWidgets[n][14] = checkboxController2;
                checkboxController2.setBounds(0, 0, 100, 100);
                checkboxController2.setMapping(new int[][]{{0}, {2}});
                LabelController labelController5 = new LabelController();
                LabelRendererHigh labelRendererHigh5 = new LabelRendererHigh(labelController5);
                labelController5.setRenderer(labelRendererHigh5);
                labelController5.setTextIds(new int[]{1042753024});
                this.refWidgets[n][15] = labelController5;
                labelController5.setModelColumn(1);
                CheckboxController checkboxController3 = new CheckboxController();
                CheckboxRendererHigh checkboxRendererHigh3 = new CheckboxRendererHigh(checkboxController3);
                checkboxController3.setRenderer(checkboxRendererHigh3);
                checkboxController3.setModelID(1579558400);
                this.refWidgets[n][16] = checkboxController3;
                checkboxController3.setBounds(0, 0, 100, 100);
                checkboxController3.setMapping(new int[][]{{0}, {2}});
                LabelController labelController6 = new LabelController();
                LabelRendererHigh labelRendererHigh6 = new LabelRendererHigh(labelController6);
                labelController6.setRenderer(labelRendererHigh6);
                labelController6.setTextIds(new int[]{1059530240});
                this.refWidgets[n][17] = labelController6;
                labelController6.setModelColumn(1);
                CheckboxController checkboxController4 = new CheckboxController();
                CheckboxRendererHigh checkboxRendererHigh4 = new CheckboxRendererHigh(checkboxController4);
                checkboxController4.setRenderer(checkboxRendererHigh4);
                checkboxController4.setModelID(1546003968);
                this.refWidgets[n][18] = checkboxController4;
                checkboxController4.setBounds(0, 0, 100, 100);
                checkboxController4.setMapping(new int[][]{{0}, {2}});
                LabelController labelController7 = new LabelController();
                LabelRendererHigh labelRendererHigh7 = new LabelRendererHigh(labelController7);
                labelController7.setRenderer(labelRendererHigh7);
                labelController7.setTextIds(new int[]{1076307456});
                this.refWidgets[n][19] = labelController7;
                labelController7.setModelColumn(1);
                CheckboxController checkboxController5 = new CheckboxController();
                CheckboxRendererHigh checkboxRendererHigh5 = new CheckboxRendererHigh(checkboxController5);
                checkboxController5.setRenderer(checkboxRendererHigh5);
                checkboxController5.setModelID(1529226752);
                this.refWidgets[n][20] = checkboxController5;
                checkboxController5.setBounds(0, 0, 100, 100);
                checkboxController5.setMapping(new int[][]{{0}, {2}});
                LayoutContainerController layoutContainerController2 = new LayoutContainerController();
                CompositeRendererHigh compositeRendererHigh3 = new CompositeRendererHigh(layoutContainerController2);
                layoutContainerController2.setRenderer(compositeRendererHigh3);
                layoutContainerController2.setBounds(0, 0, 100, 100);
                GridLayout gridLayout2 = new GridLayout();
                AxisConstraints axisConstraints3 = new AxisConstraints(2);
                axisConstraints3.alignment = new int[]{8, 3};
                axisConstraints3.gaps = new int[]{0, 10, 0};
                axisConstraints3.grow = new float[]{1.0f, 0.0f};
                gridLayout2.setColumnConstraints(axisConstraints3);
                AxisConstraints axisConstraints4 = new AxisConstraints(5);
                axisConstraints4.gaps = new int[]{0, 11, 11, 11, 11, 0};
                gridLayout2.setRowConstraints(axisConstraints4);
                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(0, 0);
                GridLayoutHints gridLayoutHints4 = new GridLayoutHints(1, 0);
                GridLayoutHints gridLayoutHints5 = new GridLayoutHints(0, 1);
                gridLayoutHints5.visibleConditions = -2;
                GridLayoutHints gridLayoutHints6 = new GridLayoutHints(1, 1);
                GridLayoutHints gridLayoutHints7 = new GridLayoutHints(0, 2);
                GridLayoutHints gridLayoutHints8 = new GridLayoutHints(1, 2);
                GridLayoutHints gridLayoutHints9 = new GridLayoutHints(0, 3);
                GridLayoutHints gridLayoutHints10 = new GridLayoutHints(1, 3);
                GridLayoutHints gridLayoutHints11 = new GridLayoutHints(0, 4);
                GridLayoutHints gridLayoutHints12 = new GridLayoutHints(1, 4);
                gridLayout2.setCellConstraints(new GridLayoutHints[]{gridLayoutHints3, gridLayoutHints4, gridLayoutHints5, gridLayoutHints6, gridLayoutHints7, gridLayoutHints8, gridLayoutHints9, gridLayoutHints10, gridLayoutHints11, gridLayoutHints12}, new Object[]{labelController3, checkboxController, labelController4, checkboxController2, labelController5, checkboxController3, labelController6, checkboxController4, labelController7, checkboxController5});
                layoutContainerController2.setLayoutManager(gridLayout2);
                layoutContainerController2.add(labelController3);
                layoutContainerController2.add(checkboxController);
                layoutContainerController2.add(labelController4);
                layoutContainerController2.add(checkboxController2);
                layoutContainerController2.add(labelController5);
                layoutContainerController2.add(checkboxController3);
                layoutContainerController2.add(labelController6);
                layoutContainerController2.add(checkboxController4);
                layoutContainerController2.add(labelController7);
                layoutContainerController2.add(checkboxController5);
                LayoutContainerController layoutContainerController3 = new LayoutContainerController();
                CompositeRendererHigh compositeRendererHigh4 = new CompositeRendererHigh(layoutContainerController3);
                layoutContainerController3.setRenderer(compositeRendererHigh4);
                layoutContainerController3.setBounds(0, 0, 100, 100);
                layoutContainerController3.setColorIndices(new int[]{1, 0, 4, 0});
                GridLayout gridLayout3 = new GridLayout();
                AxisConstraints axisConstraints5 = new AxisConstraints(1);
                axisConstraints5.grow = new float[]{1.0f};
                gridLayout3.setColumnConstraints(axisConstraints5);
                AxisConstraints axisConstraints6 = new AxisConstraints(2);
                gridLayout3.setRowConstraints(axisConstraints6);
                GridLayoutHints gridLayoutHints13 = new GridLayoutHints(0, 0);
                GridLayoutHints gridLayoutHints14 = new GridLayoutHints(0, 1);
                gridLayout3.setCellConstraints(new GridLayoutHints[]{gridLayoutHints13, gridLayoutHints14}, new Object[]{layoutContainerController, layoutContainerController2});
                layoutContainerController3.setLayoutManager(gridLayout3);
                layoutContainerController3.add(layoutContainerController);
                layoutContainerController3.add(layoutContainerController2);
                PartialPopupController partialPopupController = new PartialPopupController();
                PartialPopupRendererHigh partialPopupRendererHigh = new PartialPopupRendererHigh(partialPopupController);
                partialPopupController.setRenderer(partialPopupRendererHigh);
                partialPopupController.setBounds(400, 400, 634, 179);
                partialPopupController.setConsumeDDSPress(7);
                partialPopupController.setConsumeHKReturn(3);
                partialPopupController.setConsumeJoystickEast(2);
                partialPopupController.setConsumeJoystickWest(2);
                partialPopupController.setConsumeKeyTurned(2);
                partialPopupController.setConsumeSKPress(4);
                partialPopupController.setContentInset(20);
                partialPopupController.setDynamicSize(true);
                partialPopupController.setGreyOutBackground(true);
                partialPopupController.setID(-349886976);
                partialPopupController.setPriority(1200);
                partialPopupController.setStyle(1);
                partialPopupController.setZpmPriority(250);
                partialPopupController.setZpmSlot(12);
                partialPopupController.setBackgroundController(partialPopupGlassplateController);
                partialPopupController.add(layoutContainerController3);
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

    protected static final boolean evalCond2500004(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(354821632, n)).getValue() != 0;
    }

    protected static final boolean evalCond2500010(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(463, n)).getValue() != 1;
    }

    protected static final boolean evalCond2500011(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(463, n)).getValue() == 1;
    }

    protected static final boolean evalCond2500012(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(463, n)).getValue() == 1;
    }

    protected static final boolean evalCond2500034(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(874915328, n)).getValue() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(1663444480, n)).getValue() == 0;
    }

    protected static final boolean evalCond2500035(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(874915328, n)).getValue() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(-551148032, n)).getValue() != 3 && ((ChoiceModel)ConnectivityScreenFactory.getModel(740697600, n)).getValue() != 2;
    }

    protected static final boolean evalCond2500037(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(874915328, n)).getValue() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(740697600, n)).getValue() != 2;
    }

    protected static final boolean evalCond2500051(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(-2027543040, n)).getValue() == 2 || ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(5588, n)).getValue() == 1;
    }

    protected static final boolean evalCond2500052(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(-2027543040, n)).getValue() == 2 || ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(5588, n)).getValue() == 1;
    }

    protected static final boolean evalCond2500201(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(494, n)).getValue() == 1 && ((SysConstModel)ConnectivityScreenFactory.getModel(463, n)).getValue() == 1 && (((ChoiceModel)ConnectivityScreenFactory.getModel(798426112, n)).getValue() == 0 || ((ChoiceModel)ConnectivityScreenFactory.getModel(798426112, n)).getValue() == 7);
    }

    protected static final boolean evalCond2500231(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(463, n)).getValue() == 1;
    }

    protected static final boolean evalCond2500232(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(463, n)).getValue() == 1;
    }

    protected static final boolean evalCond2500234(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(494, n)).getValue() == 1 && ((SysConstModel)ConnectivityScreenFactory.getModel(463, n)).getValue() == 1 && (((ChoiceModel)ConnectivityScreenFactory.getModel(798426112, n)).getValue() == 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(798426112, n)).getValue() == 8);
    }

    protected static final boolean evalCond2500289(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(310, n)).getValue() > 0 && ((ChoiceModel)ConnectivityScreenFactory.getModel(516, n)).getValue() == 192;
    }

    protected static final boolean evalCond2500290(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(310, n)).getValue() > 0 && ((ChoiceModel)ConnectivityScreenFactory.getModel(516, n)).getValue() == 135;
    }

    protected static final boolean evalCond2500321(int n) {
        return ((LabelModel)ConnectivityScreenFactory.getModel(1948657152, n)).getLength() > 0;
    }

    protected static final boolean evalCond2500322(int n) {
        return ((LabelModel)ConnectivityScreenFactory.getModel(1948657152, n)).getLength() > 0;
    }

    protected static final boolean evalCond2500324(int n) {
        return ((LabelModel)ConnectivityScreenFactory.getModel(1948657152, n)).getLength() > 0;
    }

    protected static final boolean evalCond2500420(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(874915328, n)).getValue() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(1663444480, n)).getValue() != 1;
    }

    protected static final boolean evalCond2500422(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(2082874880, n)).getValue() == 1;
    }

    protected static final boolean evalCond2500423(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(-2061097472, n)).getValue() == 0 || ((ChoiceModel)ConnectivityScreenFactory.getModel(-2061097472, n)).getStatus() == 0;
    }

    protected static final boolean evalCond2500425(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(3899, n)).getValue() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(-601479680, n)).getValue() != 1;
    }

    protected static final boolean evalCond2500426(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(3897, n)).getValue() == 0;
    }

    protected static final boolean evalCond2500427(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(3897, n)).getValue() != 0;
    }

    protected static final boolean evalCond2500455(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(492, n)).getValue() == 0;
    }

    protected static final boolean evalCond2500456(int n) {
        return ((BaseListModel)ConnectivityScreenFactory.getModel(2099652096, n)).getLength() > 0;
    }

    protected static final boolean evalCond2500457(int n) {
        return ((BaseListModel)ConnectivityScreenFactory.getModel(2116429312, n)).getStatus() == 1 && ((BaseListModel)ConnectivityScreenFactory.getModel(2116429312, n)).getLength() == 0 && ((ChoiceModel)ConnectivityScreenFactory.getModel(354821632, n)).getValue() != 1;
    }

    protected static final boolean evalCond2500458(int n) {
        return ((BaseListModel)ConnectivityScreenFactory.getModel(2116429312, n)).getStatus() == 1 && ((BaseListModel)ConnectivityScreenFactory.getModel(2116429312, n)).getLength() == 0 && ((ChoiceModel)ConnectivityScreenFactory.getModel(354821632, n)).getValue() != 1;
    }

    protected static final boolean evalCond2500459(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(463, n)).getValue() == 1;
    }

    protected static final boolean evalCond2500460(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(463, n)).getValue() != 1;
    }

    protected static final boolean evalCond2500516(int n) {
        return ((BaseListModel)ConnectivityScreenFactory.getModel(2133206528, n)).getStatus() == 1 && ((BaseListModel)ConnectivityScreenFactory.getModel(2133206528, n)).getLength() == 0 && ((ChoiceModel)ConnectivityScreenFactory.getModel(-500881920, n)).getValue() != 1;
    }

    protected static final boolean evalCond2500543(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(-1775884800, n)).getStatus() == 0 || ((ChoiceModel)ConnectivityScreenFactory.getModel(5619, n)).getValue() == 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(52, n)).getValue() == 0;
    }

    protected static final boolean evalCond2500629(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(874915328, n)).getStatus() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(874915328, n)).getValue() == 1 && (((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() != 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(5588, n)).getValue() != 1);
    }

    protected static final boolean evalCond2500630(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(874915328, n)).getStatus() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(1663444480, n)).getValue() != 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(874915328, n)).getValue() == 1;
    }

    protected static final boolean evalCond2500633(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(4442, n)).getValue() == 1;
    }

    protected static final boolean evalCond2500734(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(4196, n)).getValue() == 0 && ((ChoiceModel)ConnectivityScreenFactory.getModel(3848, n)).getValue() == 0;
    }

    protected static final boolean evalCond2500756(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(-500881920, n)).getValue() != 0 && ((ChoiceModel)ConnectivityScreenFactory.getModel(335, n)).getValue() != 2 && ((ChoiceModel)ConnectivityScreenFactory.getModel(335, n)).getValue() != 3 && ((ChoiceModel)ConnectivityScreenFactory.getModel(335, n)).getValue() != 8 && ((ChoiceModel)ConnectivityScreenFactory.getModel(335, n)).getValue() != 9;
    }

    protected static final boolean evalCond2500835(int n) {
        return ((BaseListModel)ConnectivityScreenFactory.getModel(2116429312, n)).getStatus() == 1 && ((BaseListModel)ConnectivityScreenFactory.getModel(2116429312, n)).getLength() == 0 && ((ChoiceModel)ConnectivityScreenFactory.getModel(354821632, n)).getValue() != 1;
    }

    protected static final boolean evalCond2500861(int n) {
        return ((BaseListModel)ConnectivityScreenFactory.getModel(2133206528, n)).getStatus() == 1 && ((BaseListModel)ConnectivityScreenFactory.getModel(2133206528, n)).getLength() == 0 && ((ChoiceModel)ConnectivityScreenFactory.getModel(-500881920, n)).getValue() != 1;
    }

    protected static final boolean evalCond2500897(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(153495040, n)).getValue() != 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(153495040, n)).getValue() != 2 && ((ChoiceModel)ConnectivityScreenFactory.getModel(153495040, n)).getValue() != 3;
    }

    protected static final boolean evalCond2500920(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(1562781184, n)).getValue() == 2 || ((ChoiceModel)ConnectivityScreenFactory.getModel(1596335616, n)).getValue() == 2 || ((ChoiceModel)ConnectivityScreenFactory.getModel(1579558400, n)).getValue() == 2 || ((ChoiceModel)ConnectivityScreenFactory.getModel(1546003968, n)).getValue() == 2 || ((ChoiceModel)ConnectivityScreenFactory.getModel(1529226752, n)).getValue() == 2;
    }

    protected static final boolean evalCond2500921(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(1562781184, n)).getValue() == 2 || ((ChoiceModel)ConnectivityScreenFactory.getModel(1596335616, n)).getValue() == 2 || ((ChoiceModel)ConnectivityScreenFactory.getModel(1579558400, n)).getValue() == 2 || ((ChoiceModel)ConnectivityScreenFactory.getModel(1546003968, n)).getValue() == 2 || ((ChoiceModel)ConnectivityScreenFactory.getModel(1529226752, n)).getValue() == 2;
    }

    protected static final boolean evalCond2500946(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(-1097595904, n)).getValue() == 1 && (((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() != 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(5588, n)).getValue() != 1);
    }

    protected static final boolean evalCond2500947(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(354821632, n)).getValue() != 0 && ((ChoiceModel)ConnectivityScreenFactory.getModel(335, n)).getValue() != 2 && ((ChoiceModel)ConnectivityScreenFactory.getModel(335, n)).getValue() != 3 && ((ChoiceModel)ConnectivityScreenFactory.getModel(335, n)).getValue() != 8 && ((ChoiceModel)ConnectivityScreenFactory.getModel(335, n)).getValue() != 9;
    }

    protected static final boolean evalCond2500950(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(-601479680, n)).getValue() == 0 && (((ChoiceModel)ConnectivityScreenFactory.getModel(19342848, n)).getValue() == 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(19342848, n)).getValue() == 3);
    }

    protected static final boolean evalCond2500952(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)ConnectivityScreenFactory.getModel(463, n)).getValue() == 1 && ((SysConstModel)ConnectivityScreenFactory.getModel(442, n)).getValue() != 1;
    }

    protected static final boolean evalCond2500953(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)ConnectivityScreenFactory.getModel(463, n)).getValue() == 1;
    }

    protected static final boolean evalCond2500954(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)ConnectivityScreenFactory.getModel(463, n)).getValue() == 1 && ((SysConstModel)ConnectivityScreenFactory.getModel(487, n)).getValue() == 1;
    }

    protected static final boolean evalCond2500956(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)ConnectivityScreenFactory.getModel(492, n)).getValue() == 1;
    }

    protected static final boolean evalCond2500957(int n) {
        return (((SysConstModel)ConnectivityScreenFactory.getModel(442, n)).getValue() == 0 && ((SysConstModel)ConnectivityScreenFactory.getModel(4306, n)).getValue() == 0 || ((SysConstModel)ConnectivityScreenFactory.getModel(442, n)).getValue() == 6) && ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2500958(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(4306, n)).getValue() == 1 && ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2500959(int n) {
        return (((ChoiceModel)ConnectivityScreenFactory.getModel(4076, n)).getValue() == 5 || ((ChoiceModel)ConnectivityScreenFactory.getModel(4076, n)).getValue() == 6 || ((ChoiceModel)ConnectivityScreenFactory.getModel(4076, n)).getValue() == 15) && ((ChoiceModel)ConnectivityScreenFactory.getModel(4494, n)).getValue() != 1 && ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2500960(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(377, n)).getValue() == 1 && (((ChoiceModel)ConnectivityScreenFactory.getModel(1396838144, n)).getValue() == 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(377, n)).getValue() != 1) && ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2500961(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(442, n)).getValue() == 2 && (((ChoiceModel)ConnectivityScreenFactory.getModel(-1563881472, n)).getValue() == 14 || ((ChoiceModel)ConnectivityScreenFactory.getModel(-1563881472, n)).getValue() == 15) && ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2500962(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(442, n)).getValue() == 2 && ((ChoiceModel)ConnectivityScreenFactory.getModel(-1563881472, n)).getValue() == 23 && ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2500963(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(442, n)).getValue() == 5 && ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2500964(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(442, n)).getValue() == 3 && ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2500965(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(442, n)).getValue() == 4 && ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2500966(int n) {
        return (((ChoiceModel)ConnectivityScreenFactory.getModel(4076, n)).getValue() == 5 || ((ChoiceModel)ConnectivityScreenFactory.getModel(4076, n)).getValue() == 6 || ((ChoiceModel)ConnectivityScreenFactory.getModel(4076, n)).getValue() == 15) && ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2500967(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)ConnectivityScreenFactory.getModel(523, n)).getValue() != 0;
    }

    protected static final boolean evalCond2500969(int n) {
        return ((BaseListModel)ConnectivityScreenFactory.getModel(2116429312, n)).getStatus() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(354821632, n)).getValue() != 1;
    }

    protected static final boolean evalCond2500970(int n) {
        return ((BaseListModel)ConnectivityScreenFactory.getModel(2133206528, n)).getStatus() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(-500881920, n)).getValue() != 1;
    }

    protected static final boolean evalCond2500973(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)ConnectivityScreenFactory.getModel(463, n)).getValue() == 1;
    }

    protected static final boolean evalCond2500974(int n) {
        return (((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() != 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(5588, n)).getValue() != 1) && ((SysConstModel)ConnectivityScreenFactory.getModel(463, n)).getValue() == 1;
    }

    protected static final boolean evalCond2500975(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(523, n)).getValue() == 1 && ((SysConstModel)ConnectivityScreenFactory.getModel(522, n)).getValue() == 1;
    }

    protected static final boolean evalCond2500976(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(523, n)).getValue() == 1 && ((SysConstModel)ConnectivityScreenFactory.getModel(522, n)).getValue() == 1;
    }

    protected static final boolean evalCond2500977(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(492, n)).getValue() == 1;
    }

    protected static final boolean evalCond2500980(int n) {
        return (((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() != 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(5588, n)).getValue() != 1) && ((SysConstModel)ConnectivityScreenFactory.getModel(463, n)).getValue() == 1 && (((ChoiceModel)ConnectivityScreenFactory.getModel(874915328, n)).getStatus() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(874915328, n)).getValue() == 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(874915328, n)).getStatus() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(1663444480, n)).getValue() != 1 && (((ChoiceModel)ConnectivityScreenFactory.getModel(494, n)).getValue() == 0 && ((ChoiceModel)ConnectivityScreenFactory.getModel(2023097344, n)).getValue() == 0 && ((ChoiceModel)ConnectivityScreenFactory.getModel(-1013709824, n)).getValue() == 9 && (((ChoiceModel)ConnectivityScreenFactory.getModel(1385497600, n)).getValue() == 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(1385497600, n)).getValue() == 2 || ((ChoiceModel)ConnectivityScreenFactory.getModel(1385497600, n)).getValue() == 3) || ((ChoiceModel)ConnectivityScreenFactory.getModel(494, n)).getValue() == 0 && ((ChoiceModel)ConnectivityScreenFactory.getModel(-1734933504, n)).getValue() == 0 && ((ChoiceModel)ConnectivityScreenFactory.getModel(-1718156288, n)).getValue() == 9 && (((ChoiceModel)ConnectivityScreenFactory.getModel(-1349057536, n)).getValue() == 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(-1349057536, n)).getValue() == 2 || ((ChoiceModel)ConnectivityScreenFactory.getModel(-1349057536, n)).getValue() == 3) || ((ChoiceModel)ConnectivityScreenFactory.getModel(494, n)).getValue() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(1150682112, n)).getValue() == 0 && ((ChoiceModel)ConnectivityScreenFactory.getModel(1184236544, n)).getValue() == 9) || ((ChoiceModel)ConnectivityScreenFactory.getModel(874915328, n)).getStatus() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(1663444480, n)).getValue() != 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(874915328, n)).getValue() == 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(494, n)).getValue() == 1 && ((SysConstModel)ConnectivityScreenFactory.getModel(463, n)).getValue() == 1 && (((ChoiceModel)ConnectivityScreenFactory.getModel(798426112, n)).getValue() == 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(798426112, n)).getValue() == 8) || ((ChoiceModel)ConnectivityScreenFactory.getModel(494, n)).getValue() == 1 && ((SysConstModel)ConnectivityScreenFactory.getModel(463, n)).getValue() == 1 && (((ChoiceModel)ConnectivityScreenFactory.getModel(798426112, n)).getValue() == 0 || ((ChoiceModel)ConnectivityScreenFactory.getModel(798426112, n)).getValue() == 7));
    }

    protected static final boolean evalCond2500981(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(463, n)).getValue() == 1;
    }

    protected static final boolean evalCond2500983(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)ConnectivityScreenFactory.getModel(4451, n)).getValue() == 1;
    }

    protected static final boolean evalCond2500984(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)ConnectivityScreenFactory.getModel(4451, n)).getValue() == 2;
    }

    protected static final boolean evalCond2500985(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(-1097595904, n)).getValue() == 1;
    }

    protected static final boolean evalCond2500986(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)ConnectivityScreenFactory.getModel(4239, n)).getValue() == 1;
    }

    protected static final boolean evalCond2500987(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)ConnectivityScreenFactory.getModel(4239, n)).getValue() == 2;
    }

    protected static final boolean evalCond2500989(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)ConnectivityScreenFactory.getModel(4239, n)).getValue() == 0;
    }

    protected static final boolean evalCond2500990(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(874915328, n)).getValue() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(1663444480, n)).getValue() == 0;
    }

    protected static final boolean evalCond2500991(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(-601479680, n)).getValue() == 0 && (((ChoiceModel)ConnectivityScreenFactory.getModel(19342848, n)).getValue() == 2 || ((ChoiceModel)ConnectivityScreenFactory.getModel(19342848, n)).getValue() == 3);
    }

    protected static final boolean evalCond2500995(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(523, n)).getValue() == 1 && ((SysConstModel)ConnectivityScreenFactory.getModel(522, n)).getValue() == 1;
    }

    protected static final boolean evalCond2500997(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(523, n)).getValue() == 1 && ((SysConstModel)ConnectivityScreenFactory.getModel(522, n)).getValue() == 1;
    }

    protected static final boolean evalCond2501001(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(523, n)).getValue() == 0 && (((SysConstModel)ConnectivityScreenFactory.getModel(442, n)).getValue() == 3 || ((SysConstModel)ConnectivityScreenFactory.getModel(442, n)).getValue() == 2 || ((SysConstModel)ConnectivityScreenFactory.getModel(442, n)).getValue() == 4 || ((SysConstModel)ConnectivityScreenFactory.getModel(442, n)).getValue() == 5);
    }

    protected static final boolean evalCond2501002(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(523, n)).getValue() == 0 && (((SysConstModel)ConnectivityScreenFactory.getModel(442, n)).getValue() == 3 || ((SysConstModel)ConnectivityScreenFactory.getModel(442, n)).getValue() == 2 || ((SysConstModel)ConnectivityScreenFactory.getModel(442, n)).getValue() == 4 || ((SysConstModel)ConnectivityScreenFactory.getModel(442, n)).getValue() == 5);
    }

    protected static final boolean evalCond2501008(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(4442, n)).getValue() == 1;
    }

    protected static final boolean evalCond2501009(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(-2061097472, n)).getValue() != 0 && ((ChoiceModel)ConnectivityScreenFactory.getModel(2082874880, n)).getValue() == 1;
    }

    protected static final boolean evalCond2501012(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(442, n)).getValue() != 1 && (((ChoiceModel)ConnectivityScreenFactory.getModel(5606, n)).getValue() != 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(5602, n)).getValue() != 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() != 1) && ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2501013(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(442, n)).getValue() != 1 && ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2501019(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(76874752, n)).getValue() != 1 && (((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() != 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(5588, n)).getValue() != 1) && ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)ConnectivityScreenFactory.getModel(4239, n)).getValue() <= 0;
    }

    protected static final boolean evalCond2501020(int n) {
        return ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)ConnectivityScreenFactory.getModel(4451, n)).getValue() == 3;
    }

    protected static final boolean evalCond2501022(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(874915328, n)).getStatus() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(1663444480, n)).getValue() != 1 && (((ChoiceModel)ConnectivityScreenFactory.getModel(494, n)).getValue() == 0 && ((ChoiceModel)ConnectivityScreenFactory.getModel(2023097344, n)).getValue() == 0 && ((ChoiceModel)ConnectivityScreenFactory.getModel(-1013709824, n)).getValue() == 9 && (((ChoiceModel)ConnectivityScreenFactory.getModel(1385497600, n)).getValue() == 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(1385497600, n)).getValue() == 2 || ((ChoiceModel)ConnectivityScreenFactory.getModel(1385497600, n)).getValue() == 3) || ((ChoiceModel)ConnectivityScreenFactory.getModel(494, n)).getValue() == 0 && ((ChoiceModel)ConnectivityScreenFactory.getModel(-1734933504, n)).getValue() == 0 && ((ChoiceModel)ConnectivityScreenFactory.getModel(-1718156288, n)).getValue() == 9 && (((ChoiceModel)ConnectivityScreenFactory.getModel(-1349057536, n)).getValue() == 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(-1349057536, n)).getValue() == 2 || ((ChoiceModel)ConnectivityScreenFactory.getModel(-1349057536, n)).getValue() == 3) || ((ChoiceModel)ConnectivityScreenFactory.getModel(494, n)).getValue() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(1150682112, n)).getValue() == 0 && ((ChoiceModel)ConnectivityScreenFactory.getModel(1184236544, n)).getValue() == 9) && (((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() != 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(5588, n)).getValue() != 1);
    }

    protected static final boolean evalCond2501023(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() != 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(5602, n)).getValue() != 1;
    }

    protected static final boolean evalCond2501024(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5602, n)).getValue() != 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() != 1;
    }

    protected static final boolean evalCond2501025(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() != 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(5602, n)).getValue() != 1;
    }

    protected static final boolean evalCond2501026(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5602, n)).getValue() != 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() != 1;
    }

    protected static final boolean evalCond2501027(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() != 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(5602, n)).getValue() != 1;
    }

    protected static final boolean evalCond2501028(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5602, n)).getValue() != 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() != 1;
    }

    protected static final boolean evalCond2501029(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() != 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(5602, n)).getValue() != 1;
    }

    protected static final boolean evalCond2501030(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() != 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(5602, n)).getValue() != 1;
    }

    protected static final boolean evalCond2501031(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() != 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(5602, n)).getValue() != 1;
    }

    protected static final boolean evalCond2501032(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() != 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(5602, n)).getValue() != 1;
    }

    protected static final boolean evalCond2501033(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() != 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(5602, n)).getValue() != 1;
    }

    protected static final boolean evalCond2501034(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5602, n)).getValue() != 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() != 1;
    }

    protected static final boolean evalCond2501035(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() != 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(5602, n)).getValue() != 1;
    }

    protected static final boolean evalCond2501036(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5602, n)).getValue() != 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() != 1;
    }

    protected static final boolean evalCond2501037(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() != 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(5602, n)).getValue() != 1;
    }

    protected static final boolean evalCond2501038(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5602, n)).getValue() != 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() != 1;
    }

    protected static final boolean evalCond2501040(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(925246976, n)).getValue() != 1;
    }

    protected static final boolean evalCond2501048(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(925246976, n)).getValue() != 2;
    }

    protected static final boolean evalCond2501052(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5602, n)).getValue() != 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() != 1;
    }

    protected static final boolean evalCond2501057(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(925246976, n)).getValue() != 2;
    }

    protected static final boolean evalCond2501095(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5619, n)).getValue() == 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(52, n)).getValue() == 0 || ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(5588, n)).getValue() == 1;
    }

    protected static final boolean evalCond2501096(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5619, n)).getValue() == 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(52, n)).getValue() == 0 || ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(5588, n)).getValue() == 1;
    }

    protected static final boolean evalCond2501098(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(5588, n)).getValue() == 1;
    }

    protected static final boolean evalCond2501099(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(5588, n)).getValue() == 1;
    }

    protected static final boolean evalCond2501100(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(5588, n)).getValue() == 1;
    }

    protected static final boolean evalCond2501101(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(5588, n)).getValue() == 1;
    }

    protected static final boolean evalCond2501102(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() != 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(5588, n)).getValue() != 1;
    }

    protected static final boolean evalCond2501103(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5588, n)).getValue() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() == 1;
    }

    protected static final boolean evalCond2501104(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(5588, n)).getValue() == 1;
    }

    protected static final boolean evalCond2501105(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(5588, n)).getValue() == 1;
    }

    protected static final boolean evalCond2501107(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(5588, n)).getValue() == 1;
    }

    protected static final boolean evalCond2501108(int n) {
        return (((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() != 1 || ((ChoiceModel)ConnectivityScreenFactory.getModel(5588, n)).getValue() != 1) && ((SysConstModel)ConnectivityScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2501109(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(5588, n)).getValue() == 1;
    }

    protected static final boolean evalCond2501110(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(5588, n)).getValue() == 1;
    }

    protected static final boolean evalCond2501111(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(5588, n)).getValue() == 1;
    }

    protected static final boolean evalCond2501112(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(5588, n)).getValue() == 1;
    }

    protected static final boolean evalCond2501113(int n) {
        return ((ChoiceModel)ConnectivityScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)ConnectivityScreenFactory.getModel(5588, n)).getValue() == 1;
    }

    @Override
    public void executeCondition(int n, int n2, HMIView[] hMIViewArray, int n3) {
        switch (n2) {
            case 2500005: {
                this.executeConditioncMMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500001: {
                this.executeConditioncMOPTScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500012: {
                this.executeConditioncMOPTBLUETOOTHBONDINGCODEEDITScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500112: {
                this.executeConditioncMOPTBLUETOOTHBONDINGCONNECTEDSAPESIMACTIVEScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500009: {
                this.executeConditioncMOPTBLUETOOTHBONDINGDEVICEScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500014: {
                this.executeConditioncMOPTBLUETOOTHBONDINGDISPSELECTScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500019: {
                this.executeConditioncMOPTBLUETOOTHBONDINGPAIREDHFPScreen(n, hMIViewArray, n3);
                break;
            }
            case 0x262625: {
                this.executeConditioncMOPTBLUETOOTHBONDINGTRUSTEDDEVICESScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500010: {
                this.executeConditioncMOPTBLUETOOTHBONDINGWAITScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500116: {
                this.executeConditioncMOPTBLUETOOTHBONDINGWAITAUDIOScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500004: {
                this.executeConditioncMOPTBLUETOOTHMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500003: {
                this.executeConditioncMOPTBLUETOOTHNAMEEDITScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500033: {
                this.executeConditioncMOPTCONNECTSETUPDATAMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500035: {
                this.executeConditioncMOPTCONNECTSETUPEDITAPNScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500144: {
                this.executeConditioncMOPTCONNECTSETUPEDITAPN2Screen(n, hMIViewArray, n3);
                break;
            }
            case 2500037: {
                this.executeConditioncMOPTCONNECTSETUPEDITPASSWORDScreen(n, hMIViewArray, n3);
                break;
            }
            case 0x262632: {
                this.executeConditioncMOPTCONNECTSETUPEDITPASSWORDAPN2Screen(n, hMIViewArray, n3);
                break;
            }
            case 2500036: {
                this.executeConditioncMOPTCONNECTSETUPEDITUSERScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500145: {
                this.executeConditioncMOPTCONNECTSETUPEDITUSERAPN2Screen(n, hMIViewArray, n3);
                break;
            }
            case 2500034: {
                this.executeConditioncMOPTCONNECTSETUPMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 0x26262F: {
                this.executeConditioncMOPTCONNECTSETUPMAIN2Screen(n, hMIViewArray, n3);
                break;
            }
            case 2500085: {
                this.executeConditioncMOPTONLINESETUPDATASTATUSScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500084: {
                this.executeConditioncMOPTONLINESETUPMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500087: {
                this.executeConditioncMOPTONLINESETUPSECURITYMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500023: {
                this.executeConditioncMOPTWLANMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500024: {
                this.executeConditioncMOPTWLANSETUPScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500026: {
                this.executeConditioncMOPTWLANSETUPEDITPASSWORDScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500025: {
                this.executeConditioncMOPTWLANSETUPEDITSSIDScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500031: {
                this.executeConditioncMOPTWLANTETHERINGCODEEDITScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500028: {
                this.executeConditioncMOPTWLANTETHERINGDEVICESScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500016: {
                this.executeConditioncMPOPUPBLUETOOTHBONDINGERRORScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500039: {
                this.executeConditioncMPOPUPBLUETOOTHEXTERNALCODEEDITScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500083: {
                this.executeConditioncMPOPUPBLUETOOTHEXTERNALMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500017: {
                this.executeConditioncMPOPUPBLUETOOTHOBEXCODEIDScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500018: {
                this.executeConditioncMPOPUPBLUETOOTHOBEXCODEPASSWORDScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500045: {
                this.executeConditioncMPOPUPONLINECONNECTIONREQUESTScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500044: {
                this.executeConditioncMPOPUPONLINEDISCLAIMERSHOWScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500065: {
                this.executeConditioncMPOPUPONLINEERRORSSERVERMULTICONFIGPROFILESMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 0x262611: {
                this.executeConditioncMPOPUPONLINEERRORDATAMODULEDEACTIVATEScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500047: {
                this.executeConditioncMPOPUPONLINEERRORNOCONFIGScreen(n, hMIViewArray, n3);
                break;
            }
            case 0x262629: {
                this.executeConditioncMPOPUPONLINEERRORNOESIMScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500048: {
                this.executeConditioncMPOPUPONLINEERRORNOPHONEScreen(n, hMIViewArray, n3);
                break;
            }
            case 0x26262A: {
                this.executeConditioncMPOPUPONLINEERRORNOPHONEESIMScreen(n, hMIViewArray, n3);
                break;
            }
            case 2500058: {
                this.executeConditioncMPOPUPONLINEERRORNOSIMScreen(n, hMIViewArray, n3);
                break;
            }
            case 0x262636: {
                this.executeConditioncMPOPUPONLINEGPSScreen(n, hMIViewArray, n3);
                break;
            }
        }
    }

    private void executeConditioncMMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 300292: {
                if (hMIViewArray[0] == null) break;
                ((ListController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleChoiceModelValueEqualsCondition(76874752, n2, 1));
                break;
            }
        }
    }

    private void executeConditioncMOPTScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 377: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1613309440, n2));
                break;
            }
            case 442: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(-1809242624, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-1792465408, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1562977792, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(1630086656, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((MenuItemController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(1646863872, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((MenuItemController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(1663641088, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((MenuItemController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(1680418304, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((MenuItemController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(1697195520, n2));
                }
                if (hMIViewArray[8] == null) break;
                ((MenuItemController)hMIViewArray[8]).setVisible(hmiService.getComponentConditionManager().isTrue(1479091712, n2));
                break;
            }
            case 463: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1831413248, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(1848190464, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1479091712, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setEnabled(hmiService.getComponentConditionManager().isTrue(1495868928, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((MenuItemController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(1512646144, n2));
                }
                if (hMIViewArray[5] == null) break;
                ((MenuItemController)hMIViewArray[5]).setEnabled(hmiService.getComponentConditionManager().isTrue(1948853760, n2));
                break;
            }
            case 487: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1512646144, n2));
                break;
            }
            case 492: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1546200576, n2));
                break;
            }
            case 494: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1948853760, n2));
                break;
            }
            case 523: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1730749952, n2));
                break;
            }
            case 3939: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(-1809242624, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-1792465408, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1562977792, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(1579755008, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((MenuItemController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(1630086656, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((MenuItemController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(1646863872, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((MenuItemController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(1663641088, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((MenuItemController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(1680418304, n2));
                }
                if (hMIViewArray[8] != null) {
                    ((MenuItemController)hMIViewArray[8]).setVisible(hmiService.getComponentConditionManager().isTrue(1697195520, n2));
                }
                if (hMIViewArray[9] != null) {
                    ((MenuItemController)hMIViewArray[9]).setVisible(hmiService.getComponentConditionManager().isTrue(1713972736, n2));
                }
                if (hMIViewArray[10] != null) {
                    ((MenuItemController)hMIViewArray[10]).setVisible(hmiService.getComponentConditionManager().isTrue(1596532224, n2));
                }
                if (hMIViewArray[11] != null) {
                    ((MenuItemController)hMIViewArray[11]).setEnabled(hmiService.getComponentConditionManager().isTrue(1613309440, n2));
                }
                if (hMIViewArray[12] != null) {
                    ((MenuItemController)hMIViewArray[12]).setVisible(hmiService.getComponentConditionManager().isTrue(1730749952, n2));
                }
                if (hMIViewArray[13] != null) {
                    ((MenuItemController)hMIViewArray[13]).setEnabled(hmiService.getComponentConditionManager().isTrue(2099848704, n2));
                }
                if (hMIViewArray[14] != null) {
                    ((MenuItemController)hMIViewArray[14]).setVisible(hmiService.getComponentConditionManager().isTrue(1831413248, n2));
                }
                if (hMIViewArray[15] != null) {
                    ((MenuItemController)hMIViewArray[15]).setVisible(hmiService.getComponentConditionManager().isTrue(1479091712, n2));
                }
                if (hMIViewArray[16] != null) {
                    ((MenuItemController)hMIViewArray[16]).setEnabled(hmiService.getComponentConditionManager().isTrue(1495868928, n2));
                }
                if (hMIViewArray[17] != null) {
                    ((MenuItemController)hMIViewArray[17]).setVisible(hmiService.getComponentConditionManager().isTrue(1999185408, n2));
                }
                if (hMIViewArray[18] != null) {
                    ((MenuItemController)hMIViewArray[18]).setVisible(hmiService.getComponentConditionManager().isTrue(2015962624, n2));
                }
                if (hMIViewArray[19] != null) {
                    ((MenuItemController)hMIViewArray[19]).setVisible(hmiService.getComponentConditionManager().isTrue(-1675024896, n2));
                }
                if (hMIViewArray[20] != null) {
                    ((MenuItemController)hMIViewArray[20]).setVisible(hmiService.getComponentConditionManager().isTrue(2049517056, n2));
                }
                if (hMIViewArray[21] != null) {
                    ((MenuItemController)hMIViewArray[21]).setVisible(hmiService.getComponentConditionManager().isTrue(2066294272, n2));
                }
                if (hMIViewArray[22] != null) {
                    ((MenuItemController)hMIViewArray[22]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1691802112, n2));
                }
                if (hMIViewArray[23] != null) {
                    ((MenuItemController)hMIViewArray[23]).setVisible(hmiService.getComponentConditionManager().isTrue(1512646144, n2));
                }
                if (hMIViewArray[24] != null) {
                    ((MenuItemController)hMIViewArray[24]).setVisible(hmiService.getComponentConditionManager().isTrue(1546200576, n2));
                }
                if (hMIViewArray[25] == null) break;
                ((MenuItemController)hMIViewArray[25]).setEnabled(hmiService.getComponentConditionManager().isTrue(-198629888, n2));
                break;
            }
            case 4076: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1713972736, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1596532224, n2));
                break;
            }
            case 4239: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(2099848704, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2049517056, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2066294272, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((MenuItemController)hMIViewArray[3]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1691802112, n2));
                break;
            }
            case 4306: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1562977792, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1579755008, n2));
                break;
            }
            case 4451: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1999185408, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2015962624, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(-1675024896, n2));
                break;
            }
            case 4494: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1596532224, n2));
                break;
            }
            case 5583: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(-1809242624, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(1848190464, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(-114743808, n2)) {
                    if (hMIViewArray[2] != null) {
                        ((MenuItemController)hMIViewArray[2]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1691802112, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(-148298240, n2)) {
                    if (hMIViewArray[4] != null) {
                        ((MenuItemController)hMIViewArray[4]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[4] != null) {
                    ((MenuItemController)hMIViewArray[4]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[5] != null) {
                    ((MenuItemController)hMIViewArray[5]).setEnabled(hmiService.getComponentConditionManager().isTrue(1948853760, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(-181852672, n2)) {
                    if (hMIViewArray[6] != null) {
                        ((MenuItemController)hMIViewArray[6]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[6] != null) {
                    ((MenuItemController)hMIViewArray[6]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[7] != null) {
                    ((MenuItemController)hMIViewArray[7]).setEnabled(hmiService.getComponentConditionManager().isTrue(-198629888, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(-165075456, n2)) {
                    if (hMIViewArray[8] == null) break;
                    ((MenuItemController)hMIViewArray[8]).setInfoLineDisabledTextIndex(0);
                    break;
                }
                if (hMIViewArray[8] == null) break;
                ((MenuItemController)hMIViewArray[8]).setInfoLineDisabledTextIndex(-1);
                break;
            }
            case 5588: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1848190464, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(-114743808, n2)) {
                    if (hMIViewArray[1] != null) {
                        ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1691802112, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(-148298240, n2)) {
                    if (hMIViewArray[3] != null) {
                        ((MenuItemController)hMIViewArray[3]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[4] != null) {
                    ((MenuItemController)hMIViewArray[4]).setEnabled(hmiService.getComponentConditionManager().isTrue(1948853760, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(-181852672, n2)) {
                    if (hMIViewArray[5] != null) {
                        ((MenuItemController)hMIViewArray[5]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[5] != null) {
                    ((MenuItemController)hMIViewArray[5]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[6] != null) {
                    ((MenuItemController)hMIViewArray[6]).setEnabled(hmiService.getComponentConditionManager().isTrue(-198629888, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(-165075456, n2)) {
                    if (hMIViewArray[7] == null) break;
                    ((MenuItemController)hMIViewArray[7]).setInfoLineDisabledTextIndex(0);
                    break;
                }
                if (hMIViewArray[7] == null) break;
                ((MenuItemController)hMIViewArray[7]).setInfoLineDisabledTextIndex(-1);
                break;
            }
            case 5602: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(-1809242624, n2));
                break;
            }
            case 5606: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(-1809242624, n2));
                break;
            }
            case 300227: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1948853760, n2));
                break;
            }
            case 300292: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1691802112, n2));
                break;
            }
            case 300370: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1948853760, n2));
                break;
            }
            case 300612: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1948853760, n2));
                break;
            }
            case 300614: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1948853760, n2));
                break;
            }
            case 300664: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1948853760, n2));
                break;
            }
            case 300847: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1948853760, n2));
                break;
            }
            case 300952: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1948853760, n2));
                break;
            }
            case 300953: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1948853760, n2));
                break;
            }
            case 300975: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1948853760, n2));
                break;
            }
            case 1000019: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1613309440, n2));
                break;
            }
            case 1100194: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1630086656, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1646863872, n2));
                break;
            }
            case 2500148: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1948853760, n2));
                break;
            }
            case 0x262663: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1948853760, n2));
                break;
            }
        }
    }

    private void executeConditioncMOPTBLUETOOTHBONDINGCODEEDITScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2500119: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(this.evaluateSimpleAbstractModelStatusEqualsCondition(388376064, n2, 0));
                break;
            }
        }
    }

    private void executeConditioncMOPTBLUETOOTHBONDINGCONNECTEDSAPESIMACTIVEScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2500187: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(942220800, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1529226752, n2, 2));
                }
                if (hMIViewArray[2] == null) break;
                ((CheckboxController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1529226752, n2, 2));
                break;
            }
            case 2500188: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(942220800, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1546003968, n2, 2));
                }
                if (hMIViewArray[2] == null) break;
                ((CheckboxController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1546003968, n2, 2));
                break;
            }
            case 2500189: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(942220800, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1562781184, n2, 2));
                }
                if (hMIViewArray[2] == null) break;
                ((CheckboxController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1562781184, n2, 2));
                break;
            }
            case 2500190: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(942220800, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1579558400, n2, 2));
                }
                if (hMIViewArray[2] == null) break;
                ((CheckboxController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1579558400, n2, 2));
                break;
            }
            case 2500191: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(942220800, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1596335616, n2, 2));
                }
                if (hMIViewArray[2] == null) break;
                ((CheckboxController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1596335616, n2, 2));
                break;
            }
        }
    }

    private void executeConditioncMOPTBLUETOOTHBONDINGDEVICEScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 335: {
                if (hMIViewArray[0] == null) break;
                ((WaitAnimController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1395205632, n2));
                break;
            }
            case 2500117: {
                if (hMIViewArray[0] != null) {
                    ((MenuController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(-483908096, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-1541069312, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(!this.evaluateSimpleChoiceModelValueEqualsCondition(354821632, n2, 2));
                }
                if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(1764304384, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((InstructionTextContoller)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(1764173312, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((MenuItemController)hMIViewArray[5]).setEnabled(hmiService.getComponentConditionManager().isTrue(1780950528, n2));
                }
                if (hMIViewArray[6] == null) break;
                ((WaitAnimController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(1395205632, n2));
                break;
            }
            case 2500222: {
                if (hMIViewArray[0] != null) {
                    ((MenuController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(-483908096, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1764304384, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((InstructionTextContoller)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1764173312, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((MenuItemController)hMIViewArray[3]).setEnabled(hmiService.getComponentConditionManager().isTrue(1780950528, n2));
                break;
            }
        }
    }

    private void executeConditioncMOPTBLUETOOTHBONDINGDISPSELECTScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2500187: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(942220800, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1529226752, n2, 2));
                }
                if (hMIViewArray[2] == null) break;
                ((CheckboxController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1529226752, n2, 2));
                break;
            }
            case 2500188: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(942220800, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1546003968, n2, 2));
                }
                if (hMIViewArray[2] == null) break;
                ((CheckboxController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1546003968, n2, 2));
                break;
            }
            case 2500189: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(942220800, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1562781184, n2, 2));
                }
                if (hMIViewArray[2] == null) break;
                ((CheckboxController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1562781184, n2, 2));
                break;
            }
            case 2500190: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(942220800, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1579558400, n2, 2));
                }
                if (hMIViewArray[2] == null) break;
                ((CheckboxController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1579558400, n2, 2));
                break;
            }
            case 2500191: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(942220800, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1596335616, n2, 2));
                }
                if (hMIViewArray[2] == null) break;
                ((CheckboxController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1596335616, n2, 2));
                break;
            }
        }
    }

    private void executeConditioncMOPTBLUETOOTHBONDINGPAIREDHFPScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 463: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(-1406851584, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-1423628800, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(-1440406016, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((LabelController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(1814504960, n2));
                }
                if (hMIViewArray[4] == null) break;
                ((LabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(1797727744, n2));
                break;
            }
        }
    }

    private void executeConditioncMOPTBLUETOOTHBONDINGTRUSTEDDEVICESScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 5583: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(-282515968, n2));
                break;
            }
            case 5588: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(-282515968, n2));
                break;
            }
        }
    }

    private void executeConditioncMOPTBLUETOOTHBONDINGWAITScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2500187: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(942220800, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1529226752, n2, 2));
                }
                if (hMIViewArray[2] == null) break;
                ((CheckboxController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1529226752, n2, 2));
                break;
            }
            case 2500188: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(942220800, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1546003968, n2, 2));
                }
                if (hMIViewArray[2] == null) break;
                ((CheckboxController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1546003968, n2, 2));
                break;
            }
            case 2500189: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(942220800, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1562781184, n2, 2));
                }
                if (hMIViewArray[2] == null) break;
                ((CheckboxController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1562781184, n2, 2));
                break;
            }
            case 2500190: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(942220800, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1579558400, n2, 2));
                }
                if (hMIViewArray[2] == null) break;
                ((CheckboxController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1579558400, n2, 2));
                break;
            }
            case 2500191: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(942220800, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1596335616, n2, 2));
                }
                if (hMIViewArray[2] == null) break;
                ((CheckboxController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1596335616, n2, 2));
                break;
            }
        }
    }

    private void executeConditioncMOPTBLUETOOTHBONDINGWAITAUDIOScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2500187: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(958998016, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1529226752, n2, 2));
                }
                if (hMIViewArray[2] == null) break;
                ((CheckboxController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1529226752, n2, 2));
                break;
            }
            case 2500188: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(958998016, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1546003968, n2, 2));
                }
                if (hMIViewArray[2] == null) break;
                ((CheckboxController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1546003968, n2, 2));
                break;
            }
            case 2500189: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(958998016, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1562781184, n2, 2));
                }
                if (hMIViewArray[2] == null) break;
                ((CheckboxController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1562781184, n2, 2));
                break;
            }
            case 2500190: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(958998016, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1579558400, n2, 2));
                }
                if (hMIViewArray[2] == null) break;
                ((CheckboxController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1579558400, n2, 2));
                break;
            }
            case 2500191: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(958998016, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1596335616, n2, 2));
                }
                if (hMIViewArray[2] == null) break;
                ((CheckboxController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1596335616, n2, 2));
                break;
            }
        }
    }

    private void executeConditioncMOPTBLUETOOTHMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 3848: {
                if (hmiService.getComponentConditionManager().isTrue(2116560384, n2)) {
                    if (hMIViewArray[0] == null) break;
                    ((MenuItemController)hMIViewArray[0]).setContentEnabled(2);
                    break;
                }
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setContentDisabled(2);
                break;
            }
            case 4196: {
                if (hmiService.getComponentConditionManager().isTrue(2116560384, n2)) {
                    if (hMIViewArray[0] == null) break;
                    ((MenuItemController)hMIViewArray[0]).setContentEnabled(2);
                    break;
                }
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setContentDisabled(2);
                break;
            }
            case 5583: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(-735762944, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(-366402048, n2)) {
                    if (hMIViewArray[1] != null) {
                        ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(1);
                    }
                } else if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(0);
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(!hmiService.getComponentConditionManager().isTrue(-752540160, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(-349624832, n2)) {
                    if (hMIViewArray[3] != null) {
                        ((MenuItemController)hMIViewArray[3]).setInfoLineDisabledTextIndex(1);
                    }
                } else if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setInfoLineDisabledTextIndex(0);
                }
                if (hMIViewArray[4] == null) break;
                ((DirectWritingController)hMIViewArray[4]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1138153984, n2));
                break;
            }
            case 5588: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(-735762944, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(-366402048, n2)) {
                    if (hMIViewArray[1] != null) {
                        ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(1);
                    }
                } else if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(0);
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(!hmiService.getComponentConditionManager().isTrue(-752540160, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(-349624832, n2)) {
                    if (hMIViewArray[3] == null) break;
                    ((MenuItemController)hMIViewArray[3]).setInfoLineDisabledTextIndex(1);
                    break;
                }
                if (hMIViewArray[3] == null) break;
                ((MenuItemController)hMIViewArray[3]).setInfoLineDisabledTextIndex(0);
                break;
            }
            case 5602: {
                if (hMIViewArray[0] == null) break;
                ((DirectWritingController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1138153984, n2));
                break;
            }
            case 2500231: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(-735762944, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setEnabled(!hmiService.getComponentConditionManager().isTrue(-752540160, n2));
                break;
            }
        }
    }

    private void executeConditioncMOPTBLUETOOTHNAMEEDITScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 442: {
                if (hMIViewArray[0] != null) {
                    ((TouchController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(-1993792000, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((TouchController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-1977014784, n2));
                break;
            }
            case 523: {
                if (hMIViewArray[0] != null) {
                    ((TouchController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(-1993792000, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((TouchController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-1977014784, n2));
                break;
            }
            case 2500126: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusGreaterCondition(505816576, n2, 0));
                break;
            }
        }
    }

    private void executeConditioncMOPTCONNECTSETUPDATAMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 492: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1898522112, n2));
                break;
            }
            case 0x26262C: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-987421184, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1020975616, n2));
                break;
            }
            case 2500148: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueEqualsCondition(874915328, n2, 1));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(1143416320, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(hmiService.getComponentConditionManager().isTrue(-987421184, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setEnabled(this.evaluateSimpleChoiceModelValueEqualsCondition(874915328, n2, 1));
                }
                if (hMIViewArray[4] != null) {
                    ((MenuItemController)hMIViewArray[4]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1020975616, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((MenuItemController)hMIViewArray[5]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1037752832, n2));
                }
                if (hMIViewArray[6] == null) break;
                ((MenuItemController)hMIViewArray[6]).setEnabled(hmiService.getComponentConditionManager().isTrue(2116625920, n2));
                break;
            }
            case 0x262663: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1143416320, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1037752832, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((MenuItemController)hMIViewArray[2]).setEnabled(hmiService.getComponentConditionManager().isTrue(2116625920, n2));
                break;
            }
            case 2500285: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(-1121573376, n2, 0));
                }
                if (hMIViewArray[1] == null) break;
                ((IconController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(-1121573376, n2, 1));
                break;
            }
            case 2500316: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(-601479680, n2, 1));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(-601479680, n2, 1));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1445537280, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2133403136, n2));
                }
                if (hMIViewArray[4] == null) break;
                ((MenuItemController)hMIViewArray[4]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(-601479680, n2, 1));
                break;
            }
            case 2500319: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1020975616, n2));
                break;
            }
            case 2500353: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1445537280, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2133403136, n2));
                break;
            }
        }
    }

    private void executeConditioncMOPTCONNECTSETUPEDITAPNScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 0x262624: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(this.evaluateSimpleAbstractModelStatusEqualsCondition(606479872, n2, 0));
                break;
            }
        }
    }

    private void executeConditioncMOPTCONNECTSETUPEDITAPN2Screen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2500362: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(this.evaluateSimpleAbstractModelStatusEqualsCondition(170337792, n2, 0));
                break;
            }
        }
    }

    private void executeConditioncMOPTCONNECTSETUPEDITPASSWORDScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 522: {
                if (hMIViewArray[0] == null) break;
                ((TouchController)hMIViewArray[0]).setOpenSpellerInitiallyIfNoTouchpad(hmiService.getComponentConditionManager().isTrue(1864967680, n2));
                break;
            }
            case 523: {
                if (hMIViewArray[0] == null) break;
                ((TouchController)hMIViewArray[0]).setOpenSpellerInitiallyIfNoTouchpad(hmiService.getComponentConditionManager().isTrue(1864967680, n2));
                break;
            }
            case 0x262632: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(this.evaluateSimpleAbstractModelStatusEqualsCondition(841360896, n2, 0));
                break;
            }
        }
    }

    private void executeConditioncMOPTCONNECTSETUPEDITPASSWORDAPN2Screen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 522: {
                if (hMIViewArray[0] == null) break;
                ((TouchController)hMIViewArray[0]).setOpenSpellerInitiallyIfNoTouchpad(hmiService.getComponentConditionManager().isTrue(-2094455296, n2));
                break;
            }
            case 523: {
                if (hMIViewArray[0] == null) break;
                ((TouchController)hMIViewArray[0]).setOpenSpellerInitiallyIfNoTouchpad(hmiService.getComponentConditionManager().isTrue(-2094455296, n2));
                break;
            }
            case 2500366: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(this.evaluateSimpleAbstractModelStatusEqualsCondition(237446656, n2, 0));
                break;
            }
        }
    }

    private void executeConditioncMOPTCONNECTSETUPEDITUSERScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 522: {
                if (hMIViewArray[0] == null) break;
                ((TouchController)hMIViewArray[0]).setOpenSpellerInitiallyIfNoTouchpad(hmiService.getComponentConditionManager().isTrue(1881744896, n2));
                break;
            }
            case 523: {
                if (hMIViewArray[0] == null) break;
                ((TouchController)hMIViewArray[0]).setOpenSpellerInitiallyIfNoTouchpad(hmiService.getComponentConditionManager().isTrue(1881744896, n2));
                break;
            }
            case 2500157: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(this.evaluateSimpleAbstractModelStatusEqualsCondition(1025910272, n2, 0));
                break;
            }
        }
    }

    private void executeConditioncMOPTCONNECTSETUPEDITUSERAPN2Screen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 522: {
                if (hMIViewArray[0] == null) break;
                ((TouchController)hMIViewArray[0]).setOpenSpellerInitiallyIfNoTouchpad(hmiService.getComponentConditionManager().isTrue(-2060900864, n2));
                break;
            }
            case 523: {
                if (hMIViewArray[0] == null) break;
                ((TouchController)hMIViewArray[0]).setOpenSpellerInitiallyIfNoTouchpad(hmiService.getComponentConditionManager().isTrue(-2060900864, n2));
                break;
            }
            case 2500359: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(this.evaluateSimpleAbstractModelStatusEqualsCondition(120006144, n2, 0));
                break;
            }
        }
    }

    private void executeConditioncMOPTCONNECTSETUPMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 5583: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1624693248, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((DirectWritingController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1607916032, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1591138816, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((DirectWritingController)hMIViewArray[3]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1574361600, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((MenuItemController)hMIViewArray[4]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1557584384, n2));
                }
                if (hMIViewArray[5] == null) break;
                ((DirectWritingController)hMIViewArray[5]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1540807168, n2));
                break;
            }
            case 5602: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1624693248, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((DirectWritingController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1607916032, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1591138816, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((DirectWritingController)hMIViewArray[3]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1574361600, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((MenuItemController)hMIViewArray[4]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1557584384, n2));
                }
                if (hMIViewArray[5] == null) break;
                ((DirectWritingController)hMIViewArray[5]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1540807168, n2));
                break;
            }
            case 2500285: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(-1121573376, n2, 0));
                }
                if (hMIViewArray[1] == null) break;
                ((IconController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(-1121573376, n2, 1));
                break;
            }
        }
    }

    private void executeConditioncMOPTCONNECTSETUPMAIN2Screen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 5583: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1456921088, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((DirectWritingController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1440143872, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1423366656, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((DirectWritingController)hMIViewArray[3]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1406589440, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((MenuItemController)hMIViewArray[4]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1389812224, n2));
                }
                if (hMIViewArray[5] == null) break;
                ((DirectWritingController)hMIViewArray[5]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1373035008, n2));
                break;
            }
            case 5602: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1456921088, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((DirectWritingController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1440143872, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1423366656, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((DirectWritingController)hMIViewArray[3]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1406589440, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((MenuItemController)hMIViewArray[4]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1389812224, n2));
                }
                if (hMIViewArray[5] == null) break;
                ((DirectWritingController)hMIViewArray[5]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1373035008, n2));
                break;
            }
            case 2500285: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(-1121573376, n2, 0));
                }
                if (hMIViewArray[1] == null) break;
                ((IconController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(-1121573376, n2, 1));
                break;
            }
        }
    }

    private void executeConditioncMOPTONLINESETUPDATASTATUSScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 3897: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1260856832, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1244079616, n2));
                break;
            }
            case 3899: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1227302400, n2));
                break;
            }
            case 2500316: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1227302400, n2));
                break;
            }
        }
    }

    private void executeConditioncMOPTONLINESETUPMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 52: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(-416733696, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setEnabled(!hmiService.getComponentConditionManager().isTrue(-399956480, n2));
                break;
            }
            case 463: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1764107776, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-1977211392, n2));
                break;
            }
            case 494: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1641470464, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1764107776, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(-1977211392, n2));
                break;
            }
            case 5583: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1641470464, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(-332847616, n2)) {
                    if (hMIViewArray[1] != null) {
                        ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(hmiService.getComponentConditionManager().isTrue(354952704, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(-316070400, n2)) {
                    if (hMIViewArray[3] != null) {
                        ((MenuItemController)hMIViewArray[3]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[4] != null) {
                    ((MenuItemController)hMIViewArray[4]).setEnabled(!hmiService.getComponentConditionManager().isTrue(-416733696, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(-265738752, n2)) {
                    if (hMIViewArray[5] != null) {
                        ((MenuItemController)hMIViewArray[5]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[5] != null) {
                    ((MenuItemController)hMIViewArray[5]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[6] != null) {
                    ((MenuItemController)hMIViewArray[6]).setEnabled(!hmiService.getComponentConditionManager().isTrue(-399956480, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(-248961536, n2)) {
                    if (hMIViewArray[7] == null) break;
                    ((MenuItemController)hMIViewArray[7]).setInfoLineDisabledTextIndex(0);
                    break;
                }
                if (hMIViewArray[7] == null) break;
                ((MenuItemController)hMIViewArray[7]).setInfoLineDisabledTextIndex(-1);
                break;
            }
            case 5588: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1641470464, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(-332847616, n2)) {
                    if (hMIViewArray[1] != null) {
                        ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(hmiService.getComponentConditionManager().isTrue(354952704, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(-316070400, n2)) {
                    if (hMIViewArray[3] != null) {
                        ((MenuItemController)hMIViewArray[3]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[4] != null) {
                    ((MenuItemController)hMIViewArray[4]).setEnabled(!hmiService.getComponentConditionManager().isTrue(-416733696, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(-265738752, n2)) {
                    if (hMIViewArray[5] != null) {
                        ((MenuItemController)hMIViewArray[5]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[5] != null) {
                    ((MenuItemController)hMIViewArray[5]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[6] != null) {
                    ((MenuItemController)hMIViewArray[6]).setEnabled(!hmiService.getComponentConditionManager().isTrue(-399956480, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(-248961536, n2)) {
                    if (hMIViewArray[7] == null) break;
                    ((MenuItemController)hMIViewArray[7]).setInfoLineDisabledTextIndex(0);
                    break;
                }
                if (hMIViewArray[7] == null) break;
                ((MenuItemController)hMIViewArray[7]).setInfoLineDisabledTextIndex(-1);
                break;
            }
            case 5619: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(-416733696, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setEnabled(!hmiService.getComponentConditionManager().isTrue(-399956480, n2));
                break;
            }
            case 300227: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1641470464, n2));
                break;
            }
            case 300370: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1641470464, n2));
                break;
            }
            case 300612: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1641470464, n2));
                break;
            }
            case 300614: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1641470464, n2));
                break;
            }
            case 300664: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1641470464, n2));
                break;
            }
            case 300847: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1764107776, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-1977211392, n2));
                break;
            }
            case 300952: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1641470464, n2));
                break;
            }
            case 300953: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1641470464, n2));
                break;
            }
            case 300975: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1641470464, n2));
                break;
            }
            case 2500148: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1641470464, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(354952704, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((MenuItemController)hMIViewArray[2]).setEnabled(hmiService.getComponentConditionManager().isTrue(371729920, n2));
                break;
            }
            case 0x262663: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1641470464, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(371729920, n2));
                break;
            }
        }
    }

    private void executeConditioncMOPTONLINESETUPSECURITYMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 463: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(-2010765824, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-2027543040, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1965630976, n2));
                break;
            }
            case 5583: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1378428416, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(-215407104, n2)) {
                    if (hMIViewArray[1] == null) break;
                    ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(0);
                    break;
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(-1);
                break;
            }
            case 5588: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1378428416, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(-215407104, n2)) {
                    if (hMIViewArray[1] == null) break;
                    ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(0);
                    break;
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(-1);
                break;
            }
            case 300222: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(2032739840, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(1378428416, n2));
                break;
            }
        }
    }

    private void executeConditioncMOPTWLANMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 492: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1730618880, n2));
                break;
            }
            case 4442: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(422061568, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-1876351488, n2));
                break;
            }
            case 2500220: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1176970752, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1859574272, n2));
                break;
            }
            case 2500229: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(-2061097472, n2, 0));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setEnabled(!hmiService.getComponentConditionManager().isTrue(1193747968, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((MenuItemController)hMIViewArray[2]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1859574272, n2));
                break;
            }
        }
    }

    private void executeConditioncMOPTWLANSETUPScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 5583: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1524029952, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((DirectWritingController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1507252736, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1490475520, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((DirectWritingController)hMIViewArray[3]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1473698304, n2));
                }
                if (hMIViewArray[4] == null) break;
                ((MenuItemController)hMIViewArray[4]).setEnabled(hmiService.getComponentConditionManager().isTrue(-299293184, n2));
                break;
            }
            case 5588: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-299293184, n2));
                break;
            }
            case 5602: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1524029952, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((DirectWritingController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1507252736, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1490475520, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((DirectWritingController)hMIViewArray[3]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1473698304, n2));
                break;
            }
        }
    }

    private void executeConditioncMOPTWLANSETUPEDITPASSWORDScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2500016: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(this.evaluateSimpleAbstractModelStatusEqualsCondition(-1339742720, n2, 0));
                break;
            }
        }
    }

    private void executeConditioncMOPTWLANSETUPEDITSSIDScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2500019: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(this.evaluateSimpleAbstractModelStatusEqualsCondition(-1289411072, n2, 0));
                break;
            }
        }
    }

    private void executeConditioncMOPTWLANTETHERINGCODEEDITScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2500045: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(this.evaluateSimpleAbstractModelStatusEqualsCondition(-853203456, n2, 1));
                break;
            }
        }
    }

    private void executeConditioncMOPTWLANTETHERINGDEVICESScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 335: {
                if (hMIViewArray[0] == null) break;
                ((WaitAnimController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(-1809308160, n2));
                break;
            }
            case 2500066: {
                if (hMIViewArray[0] != null) {
                    ((MenuController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(-47700480, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(-500881920, n2, 0));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(!this.evaluateSimpleChoiceModelValueEqualsCondition(-500881920, n2, 2));
                }
                if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(1781081600, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((InstructionTextContoller)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(-1540938240, n2));
                }
                if (hMIViewArray[5] == null) break;
                ((WaitAnimController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(-1809308160, n2));
                break;
            }
            case 2500223: {
                if (hMIViewArray[0] != null) {
                    ((MenuController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(-47700480, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1781081600, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((InstructionTextContoller)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(-1540938240, n2));
                break;
            }
        }
    }

    private void executeConditioncMPOPUPBLUETOOTHBONDINGERRORScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2500105: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(153495040, n2, 1));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(153495040, n2, 2));
                }
                if (hMIViewArray[2] != null) {
                    ((LabelController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(153495040, n2, 3));
                }
                if (hMIViewArray[3] == null) break;
                ((LabelController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(556344832, n2));
                break;
            }
        }
    }

    private void executeConditioncMPOPUPBLUETOOTHEXTERNALCODEEDITScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2500119: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(this.evaluateSimpleAbstractModelStatusEqualsCondition(388376064, n2, 0));
                break;
            }
        }
    }

    private void executeConditioncMPOPUPBLUETOOTHEXTERNALMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 5583: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(-131521024, n2));
                break;
            }
            case 5588: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(-131521024, n2));
                break;
            }
        }
    }

    private void executeConditioncMPOPUPBLUETOOTHOBEXCODEIDScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2500211: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(this.evaluateSimpleAbstractModelStatusEqualsCondition(1931879936, n2, 1));
                break;
            }
        }
    }

    private void executeConditioncMPOPUPBLUETOOTHOBEXCODEPASSWORDScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2500209: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(this.evaluateSimpleAbstractModelStatusEqualsCondition(1898325504, n2, 1));
                break;
            }
            case 2500212: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(-467261952, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-500816384, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((LabelController)hMIViewArray[2]).setVisible(!hmiService.getComponentConditionManager().isTrue(-517593600, n2));
                break;
            }
        }
    }

    private void executeConditioncMPOPUPONLINECONNECTIONREQUESTScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 310: {
                if (hMIViewArray[0] == null) break;
                ((MenuController)hMIViewArray[0]).setSDSSymbolsVisible(hmiService.getComponentConditionManager().isTrue(-1054464512, n2));
                break;
            }
            case 516: {
                if (hMIViewArray[0] == null) break;
                ((MenuController)hMIViewArray[0]).setSDSSymbolsVisible(hmiService.getComponentConditionManager().isTrue(-1054464512, n2));
                break;
            }
            case 2500218: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2049320448, n2, 0));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2049320448, n2, 0));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2049320448, n2, 0));
                }
                if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2049320448, n2, 1));
                }
                if (hMIViewArray[4] != null) {
                    ((MenuItemController)hMIViewArray[4]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2049320448, n2, 1));
                }
                if (hMIViewArray[5] != null) {
                    ((MenuItemController)hMIViewArray[5]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2049320448, n2, 1));
                }
                if (hMIViewArray[6] != null) {
                    ((LabelController)hMIViewArray[6]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2049320448, n2, 0));
                }
                if (hMIViewArray[7] != null) {
                    ((LabelController)hMIViewArray[7]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2049320448, n2, 1));
                }
                if (hMIViewArray[8] == null) break;
                ((LabelController)hMIViewArray[8]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2049320448, n2, 2));
                break;
            }
        }
    }

    private void executeConditioncMPOPUPONLINEDISCLAIMERSHOWScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 310: {
                if (hMIViewArray[0] == null) break;
                ((MenuController)hMIViewArray[0]).setSDSSymbolsVisible(hmiService.getComponentConditionManager().isTrue(-1037687296, n2));
                break;
            }
            case 516: {
                if (hMIViewArray[0] == null) break;
                ((MenuController)hMIViewArray[0]).setSDSSymbolsVisible(hmiService.getComponentConditionManager().isTrue(-1037687296, n2));
                break;
            }
        }
    }

    private void executeConditioncMPOPUPONLINEERRORSSERVERMULTICONFIGPROFILESMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2500221: {
                if (hMIViewArray[0] == null) break;
                ((SeparatingLineController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1747396096, n2));
                break;
            }
            case 2500285: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(-1121573376, n2, 0));
                }
                if (hMIViewArray[1] == null) break;
                ((IconController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(-1121573376, n2, 1));
                break;
            }
        }
    }

    private void executeConditioncMPOPUPONLINEERRORDATAMODULEDEACTIVATEScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 52: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(-1087953408, n2));
                break;
            }
            case 5619: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(-1087953408, n2));
                break;
            }
            case 0x262696: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(-1087953408, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(-1775884800, n2, 0));
                }
                if (hMIViewArray[2] == null) break;
                ((WaitAnimController)hMIViewArray[2]).setVisible(this.evaluateSimpleAbstractModelStatusEqualsCondition(-1775884800, n2, 0));
                break;
            }
        }
    }

    private void executeConditioncMPOPUPONLINEERRORNOCONFIGScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2500148: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(this.evaluateSimpleAbstractModelStatusEqualsCondition(874915328, n2, 1));
                }
                if (hMIViewArray[1] == null) break;
                ((WaitAnimController)hMIViewArray[1]).setVisible(this.evaluateSimpleAbstractModelStatusEqualsCondition(874915328, n2, 0));
                break;
            }
        }
    }

    private void executeConditioncMPOPUPONLINEERRORNOESIMScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2500151: {
                if (hMIViewArray[0] == null) break;
                ((WaitAnimController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(925246976, n2, 11));
                break;
            }
        }
    }

    private void executeConditioncMPOPUPONLINEERRORNOPHONEScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 4367: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleChoiceModelValueGreaterCondition(4367, n2, 0));
                break;
            }
            case 2500151: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(925246976, n2, 2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(925246976, n2, 2));
                }
                if (hMIViewArray[2] != null) {
                    ((LabelController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(925246976, n2, 2));
                }
                if (hMIViewArray[3] != null) {
                    ((LabelController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(-1205262848, n2));
                }
                if (hMIViewArray[4] == null) break;
                ((WaitAnimController)hMIViewArray[4]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(925246976, n2, 12));
                break;
            }
            case 2500368: {
                if (this.evaluateSimpleChoiceModelValueEqualsCondition(271001088, n2, 1)) {
                    if (hMIViewArray[0] == null) break;
                    ((ScreenWidgetEVO)hMIViewArray[0]).setOpenSelectionDrawerByHkReturn(true);
                    break;
                }
                if (hMIViewArray[0] == null) break;
                ((ScreenWidgetEVO)hMIViewArray[0]).setOpenSelectionDrawerByHkReturn(true);
                break;
            }
        }
    }

    private void executeConditioncMPOPUPONLINEERRORNOPHONEESIMScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2500151: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(925246976, n2, 2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(925246976, n2, 2));
                }
                if (hMIViewArray[2] != null) {
                    ((LabelController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(925246976, n2, 2));
                }
                if (hMIViewArray[3] != null) {
                    ((LabelController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(-1054267904, n2));
                }
                if (hMIViewArray[4] == null) break;
                ((WaitAnimController)hMIViewArray[4]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(925246976, n2, 12));
                break;
            }
        }
    }

    private void executeConditioncMPOPUPONLINEERRORNOSIMScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2500151: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(925246976, n2, 1));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(925246976, n2, 1));
                }
                if (hMIViewArray[2] != null) {
                    ((LabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(-1339480576, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((WaitAnimController)hMIViewArray[3]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(925246976, n2, 11));
                break;
            }
            case 2500368: {
                if (hMIViewArray[0] == null) break;
                ((ScreenWidgetEVO)hMIViewArray[0]).setOpenSelectionDrawerByHkReturn(this.evaluateSimpleChoiceModelValueEqualsCondition(271001088, n2, 1));
                break;
            }
        }
    }

    private void executeConditioncMPOPUPONLINEGPSScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 335: {
                if (hmiService.getComponentConditionManager().isTrue(1095, n2)) {
                    if (hMIViewArray[0] == null) break;
                    ((MenuItemController)hMIViewArray[0]).setSdsItemSelectedAction(3);
                    break;
                }
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setSdsItemSelectedAction(0);
                break;
            }
        }
    }

    @Override
    public IPartialPopupController getPartialPopup(int n, int n2) {
        switch (n) {
            case 2500083: {
                return (IPartialPopupController)((Object)ConnectivityScreenBag3.cMPOPUPBLUETOOTHEXTERNALMAIN(this, n2));
            }
        }
        return null;
    }

    @Override
    public IPartialPopupController[] getPartialPopupStubs(int n) {
        return new IPartialPopupController[]{new PartialPopupStub(-215669248, -1, -1, 175, 0, 4, true, 7, n, 1, null, true, true)};
    }

    @Override
    public IDrawerController[] getOptionDrawers(int n) {
        return new IDrawerController[]{(IDrawerController)ConnectivityScreenBag1.cMOPT(this, n)};
    }
}

