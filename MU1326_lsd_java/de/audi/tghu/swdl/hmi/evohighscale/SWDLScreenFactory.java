/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.hmi.evohighscale;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.BufferedListModel;
import de.audi.atip.hmi.model.ButtonModel;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.LabelModel;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.sysconst.SysConstModel;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.hmi.view.HMIView;
import de.audi.atip.hmi.view.IDrawerController;
import de.audi.atip.hmi.view.IPartialPopupController;
import de.audi.atip.hmi.view.Screen;
import de.audi.tghu.swdl.hmi.evohighscale.FontFactory;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLScreenBag1;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLScreenBag2;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLScreenBag3;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLScreenBag4;
import de.esolutions.hmi.widgets.audi.base.FontLoader;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.VirtualButton;
import de.esolutions.hmi.widgets.audi.evo.ScreenWidgetEVO;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CheckboxRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ContainerRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MenuItemRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MultiLineLabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ScreenRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.CheckboxController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.GlassplateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupStub;
import de.esolutions.hmi.widgets.audi.evo.widgets.SmallStageApplicationIconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.WaitAnimController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.ListController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemColumnsConstraints;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.OldListModelAccess;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemFactory;
import java.util.NoSuchElementException;

public class SWDLScreenFactory
extends AbstractScreenFactory {
    private static HMIService hmiService;
    private static final int MODULE_ID = 17;
    private int[][] errorColors;
    public AbstractWidgetController[][] refWidgets = new AbstractWidgetController[8][11];

    public SWDLScreenFactory(IFrameworkAccess iFrameworkAccess) {
        super(17, iFrameworkAccess);
        hmiService = iFrameworkAccess.getHMIService();
    }

    private int[][] getErrorColors() {
        if (this.errorColors == null) {
            this.errorColors = new int[][]{{-16777216, -7829368}, {-16777216, -7829368}, {-16777216, -7829368}, {-16777216, -7829368}, {-16777216, -7829368}};
        }
        return this.errorColors;
    }

    public String getName() {
        return "HMISWDLEvoHighScale";
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
            case 1700000: {
                return SWDLScreenBag1.sWDLREFTEMPLATE(this, n2);
            }
            case 1700001: {
                return SWDLScreenBag1.swdlSelectMedium(this, n2);
            }
            case 1700003: {
                return SWDLScreenBag1.swdlReadReleaseInfo(this, n2);
            }
            case 1700004: {
                return SWDLScreenBag1.swdlErrRelease(this, n2);
            }
            case 1700005: {
                return SWDLScreenBag1.swdlSelectRelease(this, n2);
            }
            case 1700007: {
                return SWDLScreenBag1.swdlErrMeta(this, n2);
            }
            case 1700008: {
                return SWDLScreenBag1.swdlSelectUpdate(this, n2);
            }
            case 1700009: {
                return SWDLScreenBag1.swdlSelectComp(this, n2);
            }
            case 1700010: {
                return SWDLScreenBag1.swdlStartAbortDownload(this, n2);
            }
            case 1700011: {
                return SWDLScreenBag1.swdlReboot(this, n2);
            }
            case 1700012: {
                return SWDLScreenBag1.swdlProgress(this, n2);
            }
            case 1700006: {
                return SWDLScreenBag1.swdlReadMetaInfo(this, n2);
            }
            case 1700013: {
                return SWDLScreenBag1.swdlSummary(this, n2);
            }
            case 1700016: {
                return SWDLScreenBag1.swdlWaitForLostDevices(this, n2);
            }
            case 1700017: {
                return SWDLScreenBag1.swdlStartVersionUpload(this, n2);
            }
            case 1700018: {
                return SWDLScreenBag1.swdlVersionUploadResult(this, n2);
            }
            case 1700019: {
                return SWDLScreenBag1.swdlReadMetaProgress(this, n2);
            }
            case 1700020: {
                return SWDLScreenBag1.swdlSummaryChanged(this, n2);
            }
            case 1700021: {
                return SWDLScreenBag1.swdlPopup(this, n2);
            }
            case 1700022: {
                return SWDLScreenBag1.swdlSelectModule(this, n2);
            }
            case 1700023: {
                return SWDLScreenBag1.swdlSelectAppBl(this, n2);
            }
            case 1700024: {
                return SWDLScreenBag2.swdlSummaryMod(this, n2);
            }
            case 1700025: {
                return SWDLScreenBag2.swdlSummaryModDetail(this, n2);
            }
            case 1700026: {
                return SWDLScreenBag2.swdlSummaryModText(this, n2);
            }
            case 1700027: {
                return SWDLScreenBag2.swdlSummaryModDeviceErrors(this, n2);
            }
            case 1700028: {
                return SWDLScreenBag2.swdlLogDownloads(this, n2);
            }
            case 1700029: {
                return SWDLScreenBag2.swdlLogSequential(this, n2);
            }
            case 1700030: {
                return SWDLScreenBag2.swdlLogOverview(this, n2);
            }
            case 1700031: {
                return SWDLScreenBag2.swdlLogGeneral(this, n2);
            }
            case 1700032: {
                return SWDLScreenBag2.swdlLogDeviceSelection(this, n2);
            }
            case 1700033: {
                return SWDLScreenBag2.swdlLogPreSelectModule(this, n2);
            }
            case 1700034: {
                return SWDLScreenBag2.swdlLogPreSelectAppBl(this, n2);
            }
            case 1700035: {
                return SWDLScreenBag2.swdlLogUnusualEvents(this, n2);
            }
            case 1700036: {
                return SWDLScreenBag2.swdlLogUnusualEventsDetails(this, n2);
            }
            case 1700037: {
                return SWDLScreenBag2.swdlLogPostSelectModule(this, n2);
            }
            case 1700038: {
                return SWDLScreenBag2.swdlLogDeviceErrors(this, n2);
            }
            case 1700039: {
                return SWDLScreenBag2.swdlLogPostSelectAppBl(this, n2);
            }
            case 1700040: {
                return SWDLScreenBag2.swdlSummaryFileDetails(this, n2);
            }
            case 1700041: {
                return SWDLScreenBag2.swdlListIncompDev(this, n2);
            }
            case 1700042: {
                return SWDLScreenBag2.swdlInconsistentUpdate(this, n2);
            }
            case 1700046: {
                return SWDLScreenBag2.sETTINGSPOPUPUPDATEGENERALSUMMARYFAILURE(this, n2);
            }
            case 1700047: {
                return SWDLScreenBag2.sETTINGSPOPUPUPDATEGENERALSUMMARYSUCCESSFUL(this, n2);
            }
            case 1700048: {
                return SWDLScreenBag2.sETTINGSPOPUPUPDATEGENERALSUMMARYINTERRUPTSD(this, n2);
            }
            case 1700049: {
                return SWDLScreenBag3.sETTINGSUPDATESOURCEREAD(this, n2);
            }
            case 1700050: {
                return SWDLScreenBag3.sETTINGSUPDATESOURCEDATAOKSTART(this, n2);
            }
            case 1700051: {
                return SWDLScreenBag3.sETTINGSUPDATESOURCEINCOMPATIBLEDATA(this, n2);
            }
            case 1700052: {
                return SWDLScreenBag3.sETTINGSUPDATESOURCENODATA(this, n2);
            }
            case 1700053: {
                return SWDLScreenBag3.sETTINGSUPDATESOURCENOTACTIVATED(this, n2);
            }
            case 1700054: {
                return SWDLScreenBag3.sETTINGSPOPUPUPDATESOURCECONFIRMATION(this, n2);
            }
            case 1700055: {
                return SWDLScreenBag3.swdlInternalInit(this, n2);
            }
            case 1700057: {
                return SWDLScreenBag3.swdlProgressDetails(this, n2);
            }
            case 1700060: {
                return SWDLScreenBag3.sETTINGSUPDATEONLINESOURCEDATAOKSTART(this, n2);
            }
            case 1700061: {
                return SWDLScreenBag3.sETTINGSUPDATEDOWNLOAD(this, n2);
            }
            case 1700062: {
                return SWDLScreenBag3.sETTINGSUPDATESOURCEDATAOKNAVDBCOUNTRYCONF(this, n2);
            }
            case 1700063: {
                return SWDLScreenBag3.sETTINGSUPDATEDOWNLOADINTERRUPTION(this, n2);
            }
            case 1700066: {
                return SWDLScreenBag3.sETTINGSUPDATESOURCEACCESSFAILURE(this, n2);
            }
            case 1700067: {
                return SWDLScreenBag3.sETTINGSUPDATESOURCEDATAOKNAVDBCOUNTRY(this, n2);
            }
            case 1700068: {
                return SWDLScreenBag3.sETTINGSUPDATESOURCEDATAOKNAVDBADDITIONALCOUNTRIES(this, n2);
            }
            case 1700070: {
                return SWDLScreenBag3.swdlSelectCompNoRD(this, n2);
            }
            case 1700071: {
                return SWDLScreenBag3.swdlSelectAppBlNoRD(this, n2);
            }
            case 1700072: {
                return SWDLScreenBag3.swdlSelectModuleNoRD(this, n2);
            }
            case 1700073: {
                return SWDLScreenBag3.swdlStartAbortDownloadUpdateRunning(this, n2);
            }
            case 1700074: {
                return SWDLScreenBag3.swdlDowngradeDetection(this, n2);
            }
            case 1700076: {
                return SWDLScreenBag3.sETTINGSPOPUPUPDATEONLINENEWDATAAVAILABLELICENCEAVAILABLE(this, n2);
            }
            case 1700077: {
                return SWDLScreenBag3.sETTINGSPOPUPNAVINEWDATAAVAILABLELICENCENOTAVAILABLE(this, n2);
            }
            case 1700078: {
                return SWDLScreenBag4.sETTINGSPOPUPNAVILICENCEGETTTINGINVALID(this, n2);
            }
            case 1700079: {
                return SWDLScreenBag4.sETTINGSPOPUPGENNEWDATAAVAILABLE(this, n2);
            }
            case 1700081: {
                return SWDLScreenBag4.sWDLTEXTCONSTANT(this, n2);
            }
            case 1700082: {
                return SWDLScreenBag4.sETTINGSPOPUPONLINEUPDATEDOWNLOADFAILURERETRYPOSSIBLE(this, n2);
            }
            case 1700083: {
                return SWDLScreenBag4.sETTINGSPOPUPONLINEUPDATEDOWNLOADFAILURE(this, n2);
            }
            case 1700084: {
                return SWDLScreenBag4.sETTINGSPOPUPONLINEUPDATEACCESSFAILURE(this, n2);
            }
            case 1700085: {
                return SWDLScreenBag4.sETTINGSPOPUPONLINEUPDATENODATA(this, n2);
            }
            case 1700086: {
                return SWDLScreenBag4.sETTINGSPOPUPONLINEUPDATEINCOMPATIBLEDATA(this, n2);
            }
            case 1700087: {
                return SWDLScreenBag4.sETTINGSPOPUPONLINEUPDATESERVERFAILURE(this, n2);
            }
            case 1700088: {
                return SWDLScreenBag4.sETTINGSUPDATESOURCE(this, n2);
            }
            case 1700089: {
                return SWDLScreenBag4.sETTINGSUPDATEPROGRESSPROCESSBAR(this, n2);
            }
            case 1700090: {
                return SWDLScreenBag4.sETTINGSPOPUPUPDATESYSTEMPROPOSALDISCLAIMER(this, n2);
            }
            case 1700091: {
                return SWDLScreenBag4.sETTINGSPOPUPUPDATESYSTEMPROPOSAL(this, n2);
            }
            case 1700140: {
                return SWDLScreenBag4.sETTINGSPOPUPUPDATEONLINEPROPOSALTRAVELNEWDATAAVAILABLELICENCE(this, n2);
            }
            case 1700141: {
                return SWDLScreenBag4.sETTINGSPOPUPUPDATESYSTEMPROPOSALDESTINATION(this, n2);
            }
            case 1700142: {
                return SWDLScreenBag4.sETTINGSPOPUPUPDATENAVDBSUMMARYUOTASUCCESSFUL(this, n2);
            }
            case 1700143: {
                return SWDLScreenBag4.sETTINGSPOPUPUPDATEPPOISUMMARYUOTASUCCESSFUL(this, n2);
            }
            case 1700145: {
                return SWDLScreenBag4.sETTINGSPOPUPONLINEUPDATEUOTASERVERFAILURE(this, n2);
            }
            case 1700146: {
                return SWDLScreenBag4.sETTINGSPOPUPONLINEUPDATENOSERVICE(this, n2);
            }
        }
        return this.createDefaultScreen(n, n2);
    }

    public AbstractWidgetController getRefWidget(int n, int n2, SWDLScreenFactory sWDLScreenFactory) {
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
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(sWDLScreenFactory.getFonts(1, n));
                labelController.setBounds(530, 10, 360, 30);
                ContainerController containerController = new ContainerController();
                ContainerRendererHigh containerRendererHigh = new ContainerRendererHigh(containerController);
                containerController.setRenderer(containerRendererHigh);
                containerController.setBounds(0, 0, 800, 0);
                containerController.setEntertainmentMenuTransformation(12.0f, 12.0f, 0.96f, 0.96f, 0.0f);
                containerController.setOpacitySet(1.0f, 0.4f);
                containerController.setOptionMenuTransformation(-4.0f, 7.0f, 0.6f, 0.6f, 0.0f);
                containerController.setSelectionMenuTransformation(391.0f, 7.0f, 0.6f, 0.6f, 0.0f);
                containerController.add(labelController);
                abstractWidgetController = containerController;
                break;
            }
            case 2: {
                LabelController labelController = new LabelController();
                MultiLineLabelRendererHigh multiLineLabelRendererHigh = new MultiLineLabelRendererHigh(labelController);
                labelController.setRenderer(multiLineLabelRendererHigh);
                multiLineLabelRendererHigh.setFonts(sWDLScreenFactory.getFonts(2, n));
                labelController.setTextIds(new int[]{1701482});
                labelController.setBounds(0, 430, 800, 50);
                multiLineLabelRendererHigh.setAlignment(2, 4);
                abstractWidgetController = labelController;
                break;
            }
            case 3: {
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
                smallStageApplicationIconController2.setBitmaps(new int[]{127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127});
                smallStageApplicationIconController2.setModelID(138);
                this.refWidgets[n][4] = smallStageApplicationIconController2;
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
            case 5: {
                SmallStageApplicationIconController smallStageApplicationIconController = new SmallStageApplicationIconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(smallStageApplicationIconController);
                smallStageApplicationIconController.setRenderer(iconRendererHigh);
                smallStageApplicationIconController.setBitmaps(new int[]{127});
                smallStageApplicationIconController.setBounds(389, 109, 682, 314);
                smallStageApplicationIconController.setCoordinateSets(new int[]{2, 389, 109, 682, 314, 529, 126, 404, 181});
                iconRendererHigh.setScaleMode(3);
                SmallStageApplicationIconController smallStageApplicationIconController3 = new SmallStageApplicationIconController();
                IconRendererHigh iconRendererHigh3 = new IconRendererHigh(smallStageApplicationIconController3);
                smallStageApplicationIconController3.setRenderer(iconRendererHigh3);
                smallStageApplicationIconController3.setBitmaps(new int[]{127, 127, 127, 127, 127, 127, 127, 127, 127, 127});
                smallStageApplicationIconController3.setModelID(138);
                this.refWidgets[n][6] = smallStageApplicationIconController3;
                smallStageApplicationIconController3.setBounds(646, 325, 140, 140);
                smallStageApplicationIconController3.setCoordinateSets(new int[]{2, 646, 325, 140, 140, 666, 240, 100, 100});
                iconRendererHigh3.setScaleFactor(2.0f, 2.0f);
                iconRendererHigh3.setScaleMode(2);
                ContainerController containerController = new ContainerController();
                ContainerRendererHigh containerRendererHigh = new ContainerRendererHigh(containerController);
                containerController.setRenderer(containerRendererHigh);
                containerController.setBounds(0, 0, 0, 0);
                containerController.setEntertainmentMenuTransformation(12.0f, 12.0f, 0.96f, 0.96f, 0.0f);
                containerController.setSelectionMenuTransformation(615.0f, 70.0f, 0.6f, 0.6f, 0.0f);
                containerController.add(smallStageApplicationIconController);
                containerController.add(smallStageApplicationIconController3);
                abstractWidgetController = containerController;
                break;
            }
            case 7: {
                ListController listController = new ListController();
                listController.setModelID(1700133);
                listController.setEvent(1700014);
                listController.setBounds(0, 0, 0, 0);
                listController.setGlassplateInsetsBottom(new int[0]);
                listController.setGlassplateInsetsTop(new int[0]);
                listController.setIdColumn(0);
                listController.setNoFocusAreasBottom(new int[0]);
                listController.setNoFocusAreasTop(new int[0]);
                listController.setRecordSetColumn(3);
                listController.setDataAccess(new OldListModelAccess());
                listController.setItemFactory(new ListItemFactory(){

                    public AbstractWidgetController createListItem(int n, ListCell[] listCellArray) {
                        switch (n) {
                            case 0: {
                                MenuItemController menuItemController = new MenuItemController();
                                menuItemController.setType(16);
                                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                                GridLayout gridLayout = new GridLayout();
                                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(5);
                                menuItemColumnsConstraints.gaps = new int[]{0, 5, 0, 0, 5, 0};
                                menuItemColumnsConstraints.grow = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                                menuItemColumnsConstraints.shrink = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                                menuItemColumnsConstraints.hidemode = new int[]{0, 1, 1, 1, 1};
                                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                                AxisConstraints axisConstraints = new AxisConstraints(1);
                                gridLayout.setRowConstraints(axisConstraints);
                                AbstractWidgetController abstractWidgetController = this.createCell(0);
                                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                                gridLayoutHints.alignmentHoriz = 1;
                                gridLayoutHints.hidemode = 0;
                                AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
                                gridLayoutHints2.alignmentHoriz = 3;
                                AbstractWidgetController abstractWidgetController3 = this.createCell(2);
                                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(2, 0);
                                gridLayoutHints3.alignmentHoriz = 3;
                                AbstractWidgetController abstractWidgetController4 = this.createCell(3);
                                GridLayoutHints gridLayoutHints4 = new GridLayoutHints(3, 0);
                                gridLayoutHints4.alignmentHoriz = 3;
                                AbstractWidgetController abstractWidgetController5 = this.createCell(4);
                                GridLayoutHints gridLayoutHints5 = new GridLayoutHints(4, 0);
                                gridLayoutHints5.alignmentHoriz = 3;
                                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2, gridLayoutHints3, gridLayoutHints4, gridLayoutHints5}, new Object[]{abstractWidgetController, abstractWidgetController2, abstractWidgetController3, abstractWidgetController4, abstractWidgetController5});
                                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                                menuItemController.add(abstractWidgetController);
                                menuItemController.add(abstractWidgetController5);
                                menuItemController.add(abstractWidgetController2);
                                menuItemController.add(abstractWidgetController4);
                                menuItemController.add(abstractWidgetController3);
                                return menuItemController;
                            }
                            case 1: {
                                MenuItemController menuItemController = new MenuItemController();
                                menuItemController.setType(16);
                                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                                GridLayout gridLayout = new GridLayout();
                                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(5);
                                menuItemColumnsConstraints.gaps = new int[]{0, 5, 0, 0, 5, 0};
                                menuItemColumnsConstraints.grow = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                                menuItemColumnsConstraints.shrink = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                                menuItemColumnsConstraints.hidemode = new int[]{0, 1, 1, 1, 1};
                                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                                AxisConstraints axisConstraints = new AxisConstraints(1);
                                gridLayout.setRowConstraints(axisConstraints);
                                AbstractWidgetController abstractWidgetController = this.createCell(0);
                                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                                gridLayoutHints.alignmentHoriz = 1;
                                gridLayoutHints.hidemode = 0;
                                AbstractWidgetController abstractWidgetController6 = this.createCell(1);
                                GridLayoutHints gridLayoutHints6 = new GridLayoutHints(1, 0);
                                gridLayoutHints6.alignmentHoriz = 3;
                                AbstractWidgetController abstractWidgetController7 = this.createCell(5);
                                GridLayoutHints gridLayoutHints7 = new GridLayoutHints(2, 0);
                                gridLayoutHints7.alignmentHoriz = 3;
                                AbstractWidgetController abstractWidgetController8 = this.createCell(3);
                                GridLayoutHints gridLayoutHints8 = new GridLayoutHints(3, 0);
                                gridLayoutHints8.alignmentHoriz = 3;
                                AbstractWidgetController abstractWidgetController9 = this.createCell(4);
                                GridLayoutHints gridLayoutHints9 = new GridLayoutHints(4, 0);
                                gridLayoutHints9.alignmentHoriz = 3;
                                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints6, gridLayoutHints7, gridLayoutHints8, gridLayoutHints9}, new Object[]{abstractWidgetController, abstractWidgetController6, abstractWidgetController7, abstractWidgetController8, abstractWidgetController9});
                                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                                menuItemController.add(abstractWidgetController);
                                menuItemController.add(abstractWidgetController9);
                                menuItemController.add(abstractWidgetController6);
                                menuItemController.add(abstractWidgetController8);
                                menuItemController.add(abstractWidgetController7);
                                return menuItemController;
                            }
                            case 2: {
                                MenuItemController menuItemController = new MenuItemController();
                                menuItemController.setType(16);
                                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                                GridLayout gridLayout = new GridLayout();
                                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(2);
                                menuItemColumnsConstraints.alignment = new int[]{8, 8};
                                menuItemColumnsConstraints.gaps = new int[]{0, 5, 0};
                                menuItemColumnsConstraints.grow = new float[]{1.0f, 0.0f};
                                menuItemColumnsConstraints.shrink = new float[]{1.0f, 0.0f};
                                menuItemColumnsConstraints.hidemode = new int[]{0, 1};
                                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                                AxisConstraints axisConstraints = new AxisConstraints(1);
                                gridLayout.setRowConstraints(axisConstraints);
                                AbstractWidgetController abstractWidgetController = this.createCell(0);
                                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                                gridLayoutHints.alignmentHoriz = 1;
                                gridLayoutHints.hidemode = 0;
                                AbstractWidgetController abstractWidgetController10 = this.createCell(4);
                                GridLayoutHints gridLayoutHints10 = new GridLayoutHints(1, 0);
                                gridLayoutHints10.alignmentHoriz = 3;
                                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints10}, new Object[]{abstractWidgetController, abstractWidgetController10});
                                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                                menuItemController.add(abstractWidgetController);
                                menuItemController.add(abstractWidgetController10);
                                return menuItemController;
                            }
                        }
                        return null;
                    }

                    public AbstractWidgetController createListItemNoData() {
                        return null;
                    }

                    public AbstractWidgetController createCell(int n) {
                        switch (n) {
                            case 0: {
                                LabelController labelController = new LabelController();
                                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                                labelController.setRenderer(labelRendererHigh);
                                labelController.setModelColumn(1);
                                return labelController;
                            }
                            case 1: {
                                LabelController labelController = new LabelController();
                                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                                labelController.setRenderer(labelRendererHigh);
                                labelController.setTextIds(new int[]{1700353});
                                return labelController;
                            }
                            case 2: {
                                LabelController labelController = new LabelController();
                                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                                labelController.setRenderer(labelRendererHigh);
                                labelController.setTextIds(new int[]{1700356, 1700357, 1700358, 1700359, 1700360, 1700361, 1700362, 1700363, 1701591, 1701592, 1701593, 1701594, 1701595, 1701596, 1700364, 1701597});
                                labelController.setModelColumn(4);
                                return labelController;
                            }
                            case 3: {
                                LabelController labelController = new LabelController();
                                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                                labelController.setRenderer(labelRendererHigh);
                                labelController.setTextIds(new int[]{1700354});
                                return labelController;
                            }
                            case 4: {
                                IconController iconController = new IconController();
                                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                                iconController.setRenderer(iconRendererHigh);
                                iconController.setBitmaps(new int[]{39, 39, 39, 39});
                                return iconController;
                            }
                            case 5: {
                                LabelController labelController = new LabelController();
                                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                                labelController.setRenderer(labelRendererHigh);
                                labelController.setTextIds(new int[]{1701551, 1701552, 1700365, 1700366, 1700367, 1700368});
                                labelController.setModelColumn(4);
                                return labelController;
                            }
                        }
                        return null;
                    }
                });
                abstractWidgetController = listController;
                break;
            }
            case 8: {
                ListController listController = new ListController();
                listController.setModelID(0x19F119);
                listController.setEvent(1700071);
                listController.setBounds(0, 0, 0, 0);
                listController.setGlassplateInsetsBottom(new int[0]);
                listController.setGlassplateInsetsTop(new int[0]);
                listController.setIdColumn(0);
                listController.setNoFocusAreasBottom(new int[0]);
                listController.setNoFocusAreasTop(new int[0]);
                listController.setRecordSetColumn(6);
                listController.setItemFactory(new ListItemFactory(){

                    public AbstractWidgetController createListItem(int n, ListCell[] listCellArray) {
                        switch (n) {
                            case 0: {
                                MenuItemController menuItemController = new MenuItemController();
                                menuItemController.setType(16);
                                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                                GridLayout gridLayout = new GridLayout();
                                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(2);
                                menuItemColumnsConstraints.gaps = new int[]{0, 5, 0};
                                menuItemColumnsConstraints.grow = new float[]{1.0f, 0.0f};
                                menuItemColumnsConstraints.shrink = new float[]{1.0f, 0.0f};
                                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                                AxisConstraints axisConstraints = new AxisConstraints(1);
                                gridLayout.setRowConstraints(axisConstraints);
                                AbstractWidgetController abstractWidgetController = this.createCell(0);
                                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                                gridLayoutHints.hidemode = 0;
                                AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
                                gridLayoutHints2.hidemode = 0;
                                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2}, new Object[]{abstractWidgetController, abstractWidgetController2});
                                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                                menuItemController.add(abstractWidgetController);
                                menuItemController.add(abstractWidgetController2);
                                return menuItemController;
                            }
                            case 1: {
                                MenuItemController menuItemController = new MenuItemController();
                                menuItemController.setType(16);
                                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                                GridLayout gridLayout = new GridLayout();
                                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(4);
                                menuItemColumnsConstraints.alignment = new int[]{8, 3, 8, 8};
                                menuItemColumnsConstraints.gaps = new int[]{0, 5, 5, 5, 0};
                                menuItemColumnsConstraints.grow = new float[]{0.0f, 1.0f, 0.0f, 0.0f};
                                menuItemColumnsConstraints.shrink = new float[]{1.0f, 0.0f, 1.0f, 1.0f};
                                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                                AxisConstraints axisConstraints = new AxisConstraints(1);
                                gridLayout.setRowConstraints(axisConstraints);
                                AbstractWidgetController abstractWidgetController = this.createCell(0);
                                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                                gridLayoutHints.hidemode = 0;
                                AbstractWidgetController abstractWidgetController3 = this.createCell(2);
                                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(1, 0);
                                gridLayoutHints3.hidemode = 0;
                                AbstractWidgetController abstractWidgetController4 = this.createCell(3);
                                GridLayoutHints gridLayoutHints4 = new GridLayoutHints(2, 0);
                                gridLayoutHints4.hidemode = 0;
                                AbstractWidgetController abstractWidgetController5 = this.createCell(4);
                                GridLayoutHints gridLayoutHints5 = new GridLayoutHints(3, 0);
                                gridLayoutHints5.hidemode = 0;
                                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints3, gridLayoutHints4, gridLayoutHints5}, new Object[]{abstractWidgetController, abstractWidgetController3, abstractWidgetController4, abstractWidgetController5});
                                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                                menuItemController.add(abstractWidgetController);
                                menuItemController.add(abstractWidgetController4);
                                menuItemController.add(abstractWidgetController3);
                                menuItemController.add(abstractWidgetController5);
                                return menuItemController;
                            }
                            case 2: {
                                MenuItemController menuItemController = new MenuItemController();
                                menuItemController.setType(16);
                                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                                GridLayout gridLayout = new GridLayout();
                                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(1);
                                menuItemColumnsConstraints.grow = new float[]{1.0f};
                                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                                AxisConstraints axisConstraints = new AxisConstraints(1);
                                gridLayout.setRowConstraints(axisConstraints);
                                AbstractWidgetController abstractWidgetController = this.createCell(0);
                                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                                gridLayoutHints.hidemode = 0;
                                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints}, new Object[]{abstractWidgetController});
                                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                                menuItemController.add(abstractWidgetController);
                                return menuItemController;
                            }
                        }
                        return null;
                    }

                    public AbstractWidgetController createListItemNoData() {
                        return null;
                    }

                    public AbstractWidgetController createCell(int n) {
                        switch (n) {
                            case 0: {
                                LabelController labelController = new LabelController();
                                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                                labelController.setRenderer(labelRendererHigh);
                                labelController.setModelColumn(1);
                                return labelController;
                            }
                            case 1: {
                                LabelController labelController = new LabelController();
                                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                                labelController.setRenderer(labelRendererHigh);
                                labelController.setModelColumn(2);
                                return labelController;
                            }
                            case 2: {
                                LabelController labelController = new LabelController();
                                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                                labelController.setRenderer(labelRendererHigh);
                                labelController.setTextIds(new int[]{1700272});
                                return labelController;
                            }
                            case 3: {
                                LabelController labelController = new LabelController();
                                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                                labelController.setRenderer(labelRendererHigh);
                                labelController.setModelColumn(4);
                                return labelController;
                            }
                            case 4: {
                                LabelController labelController = new LabelController();
                                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                                labelController.setRenderer(labelRendererHigh);
                                labelController.setTextIds(new int[]{1700273});
                                return labelController;
                            }
                        }
                        return null;
                    }
                });
                abstractWidgetController = listController;
                break;
            }
            case 9: {
                ListController listController = new ListController();
                listController.setModelID(1700138);
                listController.setEvent(1700031);
                listController.setBounds(0, 0, 0, 0);
                listController.setGlassplateInsetsBottom(new int[0]);
                listController.setGlassplateInsetsTop(new int[0]);
                listController.setIdColumn(0);
                listController.setNoFocusAreasBottom(new int[0]);
                listController.setNoFocusAreasTop(new int[0]);
                listController.setRecordSetColumn(3);
                listController.setItemFactory(new ListItemFactory(){

                    public AbstractWidgetController createListItem(int n, ListCell[] listCellArray) {
                        switch (n) {
                            case 0: {
                                MenuItemController menuItemController = new MenuItemController();
                                menuItemController.setType(16);
                                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                                GridLayout gridLayout = new GridLayout();
                                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(8);
                                menuItemColumnsConstraints.alignment = new int[]{8, 1, 8, 8, 8, 8, 8, 8};
                                menuItemColumnsConstraints.gaps = new int[]{0, 5, 0, 0, 5, 0, 0, 5, 0};
                                menuItemColumnsConstraints.grow = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                                menuItemColumnsConstraints.shrink = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                                menuItemColumnsConstraints.hidemode = new int[]{0, 1, 1, 1, 1, 1, 1, 1};
                                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                                AxisConstraints axisConstraints = new AxisConstraints(1);
                                gridLayout.setRowConstraints(axisConstraints);
                                AbstractWidgetController abstractWidgetController = this.createCell(0);
                                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                                gridLayoutHints.alignmentHoriz = 1;
                                gridLayoutHints.hidemode = 0;
                                AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
                                gridLayoutHints2.alignmentHoriz = 1;
                                gridLayoutHints2.hidemode = 0;
                                AbstractWidgetController abstractWidgetController3 = this.createCell(2);
                                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(2, 0);
                                gridLayoutHints3.alignmentHoriz = 1;
                                gridLayoutHints3.hidemode = 1;
                                AbstractWidgetController abstractWidgetController4 = this.createCell(3);
                                GridLayoutHints gridLayoutHints4 = new GridLayoutHints(3, 0);
                                gridLayoutHints4.alignmentHoriz = 1;
                                AbstractWidgetController abstractWidgetController5 = this.createCell(4);
                                GridLayoutHints gridLayoutHints5 = new GridLayoutHints(4, 0);
                                gridLayoutHints5.alignmentHoriz = 3;
                                AbstractWidgetController abstractWidgetController6 = this.createCell(5);
                                GridLayoutHints gridLayoutHints6 = new GridLayoutHints(5, 0);
                                gridLayoutHints6.alignmentHoriz = 3;
                                AbstractWidgetController abstractWidgetController7 = this.createCell(6);
                                GridLayoutHints gridLayoutHints7 = new GridLayoutHints(6, 0);
                                gridLayoutHints7.alignmentHoriz = 3;
                                AbstractWidgetController abstractWidgetController8 = this.createCell(7);
                                GridLayoutHints gridLayoutHints8 = new GridLayoutHints(7, 0);
                                gridLayoutHints8.alignmentHoriz = 3;
                                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2, gridLayoutHints3, gridLayoutHints4, gridLayoutHints5, gridLayoutHints6, gridLayoutHints7, gridLayoutHints8}, new Object[]{abstractWidgetController, abstractWidgetController2, abstractWidgetController3, abstractWidgetController4, abstractWidgetController5, abstractWidgetController6, abstractWidgetController7, abstractWidgetController8});
                                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                                menuItemController.add(abstractWidgetController);
                                menuItemController.add(abstractWidgetController8);
                                menuItemController.add(abstractWidgetController3);
                                menuItemController.add(abstractWidgetController6);
                                menuItemController.add(abstractWidgetController2);
                                menuItemController.add(abstractWidgetController4);
                                menuItemController.add(abstractWidgetController5);
                                menuItemController.add(abstractWidgetController7);
                                return menuItemController;
                            }
                            case 1: {
                                MenuItemController menuItemController = new MenuItemController();
                                menuItemController.setType(16);
                                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                                GridLayout gridLayout = new GridLayout();
                                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(8);
                                menuItemColumnsConstraints.alignment = new int[]{1, 8, 8, 8, 8, 8, 8, 8};
                                menuItemColumnsConstraints.gaps = new int[]{0, 5, 0, 0, 5, 0, 0, 5, 0};
                                menuItemColumnsConstraints.grow = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                                menuItemColumnsConstraints.shrink = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                                menuItemColumnsConstraints.hidemode = new int[]{0, 1, 1, 1, 1, 1, 1, 1};
                                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                                AxisConstraints axisConstraints = new AxisConstraints(1);
                                gridLayout.setRowConstraints(axisConstraints);
                                AbstractWidgetController abstractWidgetController = this.createCell(0);
                                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                                gridLayoutHints.alignmentHoriz = 1;
                                gridLayoutHints.hidemode = 1;
                                AbstractWidgetController abstractWidgetController9 = this.createCell(1);
                                GridLayoutHints gridLayoutHints9 = new GridLayoutHints(1, 0);
                                gridLayoutHints9.alignmentHoriz = 1;
                                gridLayoutHints9.hidemode = 0;
                                AbstractWidgetController abstractWidgetController10 = this.createCell(2);
                                GridLayoutHints gridLayoutHints10 = new GridLayoutHints(2, 0);
                                gridLayoutHints10.alignmentHoriz = 1;
                                gridLayoutHints10.hidemode = 0;
                                AbstractWidgetController abstractWidgetController11 = this.createCell(3);
                                GridLayoutHints gridLayoutHints11 = new GridLayoutHints(3, 0);
                                gridLayoutHints11.alignmentHoriz = 1;
                                AbstractWidgetController abstractWidgetController12 = this.createCell(4);
                                GridLayoutHints gridLayoutHints12 = new GridLayoutHints(4, 0);
                                gridLayoutHints12.alignmentHoriz = 3;
                                AbstractWidgetController abstractWidgetController13 = this.createCell(8);
                                GridLayoutHints gridLayoutHints13 = new GridLayoutHints(5, 0);
                                gridLayoutHints13.alignmentHoriz = 3;
                                AbstractWidgetController abstractWidgetController14 = this.createCell(6);
                                GridLayoutHints gridLayoutHints14 = new GridLayoutHints(6, 0);
                                gridLayoutHints14.alignmentHoriz = 3;
                                AbstractWidgetController abstractWidgetController15 = this.createCell(7);
                                GridLayoutHints gridLayoutHints15 = new GridLayoutHints(7, 0);
                                gridLayoutHints15.alignmentHoriz = 3;
                                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints9, gridLayoutHints10, gridLayoutHints11, gridLayoutHints12, gridLayoutHints13, gridLayoutHints14, gridLayoutHints15}, new Object[]{abstractWidgetController, abstractWidgetController9, abstractWidgetController10, abstractWidgetController11, abstractWidgetController12, abstractWidgetController13, abstractWidgetController14, abstractWidgetController15});
                                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                                menuItemController.add(abstractWidgetController);
                                menuItemController.add(abstractWidgetController15);
                                menuItemController.add(abstractWidgetController10);
                                menuItemController.add(abstractWidgetController13);
                                menuItemController.add(abstractWidgetController9);
                                menuItemController.add(abstractWidgetController11);
                                menuItemController.add(abstractWidgetController12);
                                menuItemController.add(abstractWidgetController14);
                                return menuItemController;
                            }
                            case 2: {
                                MenuItemController menuItemController = new MenuItemController();
                                menuItemController.setType(16);
                                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                                GridLayout gridLayout = new GridLayout();
                                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(5);
                                menuItemColumnsConstraints.alignment = new int[]{8, 1, 8, 8, 8};
                                menuItemColumnsConstraints.gaps = new int[]{0, 5, 0, 0, 5, 0};
                                menuItemColumnsConstraints.grow = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
                                menuItemColumnsConstraints.shrink = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                                menuItemColumnsConstraints.hidemode = new int[]{0, 1, 1, 1, 1};
                                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                                AxisConstraints axisConstraints = new AxisConstraints(1);
                                gridLayout.setRowConstraints(axisConstraints);
                                AbstractWidgetController abstractWidgetController = this.createCell(0);
                                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                                gridLayoutHints.alignmentHoriz = 1;
                                gridLayoutHints.hidemode = 0;
                                AbstractWidgetController abstractWidgetController16 = this.createCell(1);
                                GridLayoutHints gridLayoutHints16 = new GridLayoutHints(1, 0);
                                gridLayoutHints16.hidemode = 0;
                                AbstractWidgetController abstractWidgetController17 = this.createCell(2);
                                GridLayoutHints gridLayoutHints17 = new GridLayoutHints(2, 0);
                                gridLayoutHints17.alignmentHoriz = 1;
                                gridLayoutHints17.hidemode = 0;
                                AbstractWidgetController abstractWidgetController18 = this.createCell(3);
                                GridLayoutHints gridLayoutHints18 = new GridLayoutHints(3, 0);
                                gridLayoutHints18.alignmentHoriz = 1;
                                AbstractWidgetController abstractWidgetController19 = this.createCell(7);
                                GridLayoutHints gridLayoutHints19 = new GridLayoutHints(4, 0);
                                gridLayoutHints19.alignmentHoriz = 3;
                                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints16, gridLayoutHints17, gridLayoutHints18, gridLayoutHints19}, new Object[]{abstractWidgetController, abstractWidgetController16, abstractWidgetController17, abstractWidgetController18, abstractWidgetController19});
                                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                                menuItemController.add(abstractWidgetController);
                                menuItemController.add(abstractWidgetController19);
                                menuItemController.add(abstractWidgetController17);
                                menuItemController.add(abstractWidgetController16);
                                menuItemController.add(abstractWidgetController18);
                                return menuItemController;
                            }
                        }
                        return null;
                    }

                    public AbstractWidgetController createListItemNoData() {
                        return null;
                    }

                    public AbstractWidgetController createCell(int n) {
                        switch (n) {
                            case 0: {
                                LabelController labelController = new LabelController();
                                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                                labelController.setRenderer(labelRendererHigh);
                                labelController.setModelColumn(1);
                                return labelController;
                            }
                            case 1: {
                                LabelController labelController = new LabelController();
                                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                                labelController.setRenderer(labelRendererHigh);
                                labelController.setTextIds(new int[]{0x19F1FF});
                                return labelController;
                            }
                            case 2: {
                                LabelController labelController = new LabelController();
                                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                                labelController.setRenderer(labelRendererHigh);
                                labelController.setModelColumn(4);
                                return labelController;
                            }
                            case 3: {
                                LabelController labelController = new LabelController();
                                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                                labelController.setRenderer(labelRendererHigh);
                                labelController.setTextIds(new int[]{1700352});
                                return labelController;
                            }
                            case 4: {
                                LabelController labelController = new LabelController();
                                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                                labelController.setRenderer(labelRendererHigh);
                                labelController.setTextIds(new int[]{1701885});
                                return labelController;
                            }
                            case 5: {
                                LabelController labelController = new LabelController();
                                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                                labelController.setRenderer(labelRendererHigh);
                                labelController.setTextIds(new int[]{1701598, 1701599, 1701421, 1701886, 1701600, 1701601, 1701887, 1701888, 1701889, 1701890, 1701891, 1701892, 1701893, 1701894, 1701895, 1701896});
                                labelController.setModelColumn(5);
                                return labelController;
                            }
                            case 6: {
                                LabelController labelController = new LabelController();
                                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                                labelController.setRenderer(labelRendererHigh);
                                labelController.setTextIds(new int[]{1701897});
                                return labelController;
                            }
                            case 7: {
                                IconController iconController = new IconController();
                                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                                iconController.setRenderer(iconRendererHigh);
                                iconController.setBitmaps(new int[]{39, 39, 39, 39});
                                return iconController;
                            }
                            case 8: {
                                LabelController labelController = new LabelController();
                                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                                labelController.setRenderer(labelRendererHigh);
                                labelController.setTextIds(new int[]{1701551, 1701552, 1700365, 1700366, 1700367, 1700368});
                                labelController.setModelColumn(5);
                                return labelController;
                            }
                        }
                        return null;
                    }
                });
                abstractWidgetController = listController;
                break;
            }
            case 10: {
                ListController listController = new ListController();
                listController.setModelID(1700132);
                listController.setEvent(1700033);
                listController.setBounds(0, 0, 0, 0);
                listController.setColorIndices(new int[]{0, 0, 0, 0});
                listController.setEnabledColumn(2);
                listController.setGlassplateInsetsBottom(new int[0]);
                listController.setGlassplateInsetsTop(new int[0]);
                listController.setIdColumn(0);
                listController.setNoFocusAreasBottom(new int[0]);
                listController.setNoFocusAreasTop(new int[0]);
                listController.setRecordSetColumn(3);
                listController.setItemFactory(new ListItemFactory(){

                    public AbstractWidgetController createListItem(int n, ListCell[] listCellArray) {
                        switch (n) {
                            case 0: {
                                MenuItemController menuItemController = new MenuItemController();
                                menuItemController.setType(16);
                                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                                GridLayout gridLayout = new GridLayout();
                                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(6);
                                menuItemColumnsConstraints.alignment = new int[]{8, 1, 8, 8, 8, 8};
                                menuItemColumnsConstraints.gaps = new int[]{0, 0, 0, 0, 0, 5, 0};
                                menuItemColumnsConstraints.grow = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
                                menuItemColumnsConstraints.shrink = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                                menuItemColumnsConstraints.hidemode = new int[]{0, 1, 1, 1, 1, 1};
                                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                                AxisConstraints axisConstraints = new AxisConstraints(2);
                                gridLayout.setRowConstraints(axisConstraints);
                                AbstractWidgetController abstractWidgetController = this.createCell(0);
                                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                                gridLayoutHints.alignmentHoriz = 1;
                                gridLayoutHints.hidemode = 0;
                                gridLayoutHints.columnSpan = 5;
                                AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(5, 0);
                                gridLayoutHints2.alignmentHoriz = 3;
                                AbstractWidgetController abstractWidgetController3 = this.createCell(2);
                                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(0, 1);
                                AbstractWidgetController abstractWidgetController4 = this.createCell(3);
                                GridLayoutHints gridLayoutHints4 = new GridLayoutHints(1, 1);
                                AbstractWidgetController abstractWidgetController5 = this.createCell(4);
                                GridLayoutHints gridLayoutHints5 = new GridLayoutHints(2, 1);
                                AbstractWidgetController abstractWidgetController6 = this.createCell(5);
                                GridLayoutHints gridLayoutHints6 = new GridLayoutHints(3, 1);
                                AbstractWidgetController abstractWidgetController7 = this.createCell(6);
                                GridLayoutHints gridLayoutHints7 = new GridLayoutHints(4, 1);
                                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2, gridLayoutHints3, gridLayoutHints4, gridLayoutHints5, gridLayoutHints6, gridLayoutHints7}, new Object[]{abstractWidgetController, abstractWidgetController2, abstractWidgetController3, abstractWidgetController4, abstractWidgetController5, abstractWidgetController6, abstractWidgetController7});
                                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                                menuItemController.add(abstractWidgetController);
                                menuItemController.add(abstractWidgetController3);
                                menuItemController.add(abstractWidgetController7);
                                menuItemController.add(abstractWidgetController2);
                                menuItemController.add(abstractWidgetController4);
                                menuItemController.add(abstractWidgetController6);
                                menuItemController.add(abstractWidgetController5);
                                return menuItemController;
                            }
                            case 1: {
                                MenuItemController menuItemController = new MenuItemController();
                                menuItemController.setType(16);
                                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                                GridLayout gridLayout = new GridLayout();
                                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(10);
                                menuItemColumnsConstraints.gaps = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0};
                                menuItemColumnsConstraints.grow = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                                AxisConstraints axisConstraints = new AxisConstraints(2);
                                gridLayout.setRowConstraints(axisConstraints);
                                AbstractWidgetController abstractWidgetController = this.createCell(0);
                                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                                gridLayoutHints.columnSpan = 6;
                                AbstractWidgetController abstractWidgetController8 = this.createCell(7);
                                GridLayoutHints gridLayoutHints8 = new GridLayoutHints(6, 0);
                                AbstractWidgetController abstractWidgetController9 = this.createCell(8);
                                GridLayoutHints gridLayoutHints9 = new GridLayoutHints(7, 0);
                                AbstractWidgetController abstractWidgetController10 = this.createCell(9);
                                GridLayoutHints gridLayoutHints10 = new GridLayoutHints(8, 0);
                                AbstractWidgetController abstractWidgetController11 = this.createCell(10);
                                GridLayoutHints gridLayoutHints11 = new GridLayoutHints(9, 0);
                                AbstractWidgetController abstractWidgetController12 = this.createCell(2);
                                GridLayoutHints gridLayoutHints12 = new GridLayoutHints(0, 1);
                                gridLayoutHints12.hidemode = 2;
                                AbstractWidgetController abstractWidgetController13 = this.createCell(3);
                                GridLayoutHints gridLayoutHints13 = new GridLayoutHints(1, 1);
                                AbstractWidgetController abstractWidgetController14 = this.createCell(4);
                                GridLayoutHints gridLayoutHints14 = new GridLayoutHints(2, 1);
                                AbstractWidgetController abstractWidgetController15 = this.createCell(5);
                                GridLayoutHints gridLayoutHints15 = new GridLayoutHints(3, 1);
                                AbstractWidgetController abstractWidgetController16 = this.createCell(6);
                                GridLayoutHints gridLayoutHints16 = new GridLayoutHints(4, 1);
                                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints8, gridLayoutHints9, gridLayoutHints10, gridLayoutHints11, gridLayoutHints12, gridLayoutHints13, gridLayoutHints14, gridLayoutHints15, gridLayoutHints16}, new Object[]{abstractWidgetController, abstractWidgetController8, abstractWidgetController9, abstractWidgetController10, abstractWidgetController11, abstractWidgetController12, abstractWidgetController13, abstractWidgetController14, abstractWidgetController15, abstractWidgetController16});
                                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                                menuItemController.add(abstractWidgetController);
                                menuItemController.add(abstractWidgetController11);
                                menuItemController.add(abstractWidgetController12);
                                menuItemController.add(abstractWidgetController16);
                                menuItemController.add(abstractWidgetController8);
                                menuItemController.add(abstractWidgetController10);
                                menuItemController.add(abstractWidgetController13);
                                menuItemController.add(abstractWidgetController15);
                                menuItemController.add(abstractWidgetController14);
                                menuItemController.add(abstractWidgetController9);
                                return menuItemController;
                            }
                            case 2: {
                                MenuItemController menuItemController = new MenuItemController();
                                menuItemController.setType(16);
                                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                                GridLayout gridLayout = new GridLayout();
                                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(2);
                                menuItemColumnsConstraints.gaps = new int[]{0, 5, 0};
                                menuItemColumnsConstraints.grow = new float[]{1.0f, 0.0f};
                                menuItemColumnsConstraints.shrink = new float[]{1.0f, 0.0f};
                                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                                AxisConstraints axisConstraints = new AxisConstraints(1);
                                gridLayout.setRowConstraints(axisConstraints);
                                AbstractWidgetController abstractWidgetController = this.createCell(0);
                                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                                AbstractWidgetController abstractWidgetController17 = this.createCell(3);
                                GridLayoutHints gridLayoutHints17 = new GridLayoutHints(1, 0);
                                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints17}, new Object[]{abstractWidgetController, abstractWidgetController17});
                                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                                menuItemController.add(abstractWidgetController);
                                menuItemController.add(abstractWidgetController17);
                                return menuItemController;
                            }
                        }
                        return null;
                    }

                    public AbstractWidgetController createListItemNoData() {
                        return null;
                    }

                    public AbstractWidgetController createCell(int n) {
                        switch (n) {
                            case 0: {
                                LabelController labelController = new LabelController();
                                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                                labelController.setRenderer(labelRendererHigh);
                                labelController.setModelColumn(1);
                                return labelController;
                            }
                            case 1: {
                                CheckboxController checkboxController = new CheckboxController();
                                CheckboxRendererHigh checkboxRendererHigh = new CheckboxRendererHigh(checkboxController);
                                checkboxController.setRenderer(checkboxRendererHigh);
                                checkboxController.setBounds(0, 0, 100, 100);
                                checkboxController.setColorIndices(new int[]{1, 0, 4, 0, 2, 3});
                                checkboxController.setModelColumn(7);
                                return checkboxController;
                            }
                            case 2: {
                                LabelController labelController = new LabelController();
                                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                                labelController.setRenderer(labelRendererHigh);
                                labelController.setTextIds(new int[]{0x19F1FF});
                                return labelController;
                            }
                            case 3: {
                                LabelController labelController = new LabelController();
                                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                                labelController.setRenderer(labelRendererHigh);
                                labelController.setModelColumn(5);
                                return labelController;
                            }
                            case 4: {
                                LabelController labelController = new LabelController();
                                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                                labelController.setRenderer(labelRendererHigh);
                                labelController.setTextIds(new int[]{1700370});
                                return labelController;
                            }
                            case 5: {
                                LabelController labelController = new LabelController();
                                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                                labelController.setRenderer(labelRendererHigh);
                                labelController.setModelColumn(6);
                                return labelController;
                            }
                            case 6: {
                                LabelController labelController = new LabelController();
                                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                                labelController.setRenderer(labelRendererHigh);
                                labelController.setTextIds(new int[]{1700352});
                                return labelController;
                            }
                            case 7: {
                                LabelController labelController = new LabelController();
                                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                                labelController.setRenderer(labelRendererHigh);
                                labelController.setTextIds(new int[]{1700353});
                                return labelController;
                            }
                            case 8: {
                                LabelController labelController = new LabelController();
                                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                                labelController.setRenderer(labelRendererHigh);
                                labelController.setTextIds(new int[]{1701551, 1701552, 1700365, 1700366, 1700367, 1700368});
                                labelController.setModelColumn(8);
                                return labelController;
                            }
                            case 9: {
                                LabelController labelController = new LabelController();
                                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                                labelController.setRenderer(labelRendererHigh);
                                labelController.setTextIds(new int[]{1701897});
                                return labelController;
                            }
                            case 10: {
                                IconController iconController = new IconController();
                                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                                iconController.setRenderer(iconRendererHigh);
                                iconController.setBitmaps(new int[]{39, 39, 39, 39});
                                return iconController;
                            }
                        }
                        return null;
                    }
                });
                abstractWidgetController = listController;
                break;
            }
            default: {
                this.getFramework().getLogChannel("ScreenFactory").log(10000, "Invalid reference widget id " + n2 + ".");
            }
        }
        this.refWidgets[n][n2] = abstractWidgetController;
        return abstractWidgetController;
    }

    protected static final boolean evalCond1700018(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(376, n)).getValue() > -1;
    }

    protected static final boolean evalCond1700019(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(376, n)).getValue() > -1;
    }

    protected static final boolean evalCond1700020(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(376, n)).getValue() > -1;
    }

    protected static final boolean evalCond1700021(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(376, n)).getValue() > -1;
    }

    protected static final boolean evalCond1700022(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(376, n)).getValue() > -1;
    }

    protected static final boolean evalCond1700023(int n) {
        return ((ButtonModel)SWDLScreenFactory.getModel(1700221, n)).getStatus() == 1;
    }

    protected static final boolean evalCond1700024(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(376, n)).getValue() > -1;
    }

    protected static final boolean evalCond1700025(int n) {
        return ((ButtonModel)SWDLScreenFactory.getModel(1700222, n)).getStatus() == 1;
    }

    protected static final boolean evalCond1700045(int n) {
        return ((ButtonModel)SWDLScreenFactory.getModel(1700051, n)).getStatus() == 1;
    }

    protected static final boolean evalCond1700049(int n) {
        return ((LabelModel)SWDLScreenFactory.getModel(1700244, n)).getStatus() <= 1;
    }

    protected static final boolean evalCond1700057(int n) {
        return ((BufferedListModel)SWDLScreenFactory.getModel(1700133, n)).getLength() > 0;
    }

    protected static final boolean evalCond1700058(int n) {
        return ((BufferedListModel)SWDLScreenFactory.getModel(1700133, n)).getLength() > 0;
    }

    protected static final boolean evalCond1700060(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(3849, n)).getValue() == 2 || ((ChoiceModel)SWDLScreenFactory.getModel(1700259, n)).getValue() == 7;
    }

    protected static final boolean evalCond1700061(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(3849, n)).getValue() != 2 && ((ChoiceModel)SWDLScreenFactory.getModel(1700259, n)).getValue() != 7;
    }

    protected static final boolean evalCond1700063(int n) {
        return ((SysConstModel)SWDLScreenFactory.getModel(3969, n)).getValue() == 0;
    }

    protected static final boolean evalCond1700068(int n) {
        return ((LabelModel)SWDLScreenFactory.getModel(1700280, n)).getStatus() == 0 && ((ChoiceModel)SWDLScreenFactory.getModel(1700367, n)).getValue() == 0;
    }

    protected static final boolean evalCond1700072(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(1700115, n)).getValue() == 0 && ((ChoiceModel)SWDLScreenFactory.getModel(0x19F111, n)).getValue() == 0 && ((ChoiceModel)SWDLScreenFactory.getModel(1700117, n)).getValue() == 0 && ((ChoiceModel)SWDLScreenFactory.getModel(1700111, n)).getValue() == 0 && ((ChoiceModel)SWDLScreenFactory.getModel(1700110, n)).getValue() == 0;
    }

    protected static final boolean evalCond1700073(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(1700115, n)).getValue() == 0 && ((ChoiceModel)SWDLScreenFactory.getModel(0x19F111, n)).getValue() == 0 && ((ChoiceModel)SWDLScreenFactory.getModel(1700112, n)).getValue() == 0 && ((ChoiceModel)SWDLScreenFactory.getModel(1700117, n)).getValue() == 0 && ((ChoiceModel)SWDLScreenFactory.getModel(1700110, n)).getValue() == 0;
    }

    protected static final boolean evalCond1700074(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(1700115, n)).getValue() == 0 && ((ChoiceModel)SWDLScreenFactory.getModel(0x19F111, n)).getValue() == 0 && ((ChoiceModel)SWDLScreenFactory.getModel(1700117, n)).getValue() == 0 && ((ChoiceModel)SWDLScreenFactory.getModel(1700114, n)).getValue() == 0 && ((ChoiceModel)SWDLScreenFactory.getModel(1700110, n)).getValue() == 0;
    }

    protected static final boolean evalCond1700075(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(1700238, n)).getValue() == 0 || ((ChoiceModel)SWDLScreenFactory.getModel(1100305, n)).getValue() == 1;
    }

    protected static final boolean evalCond1700089(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(1700364, n)).getValue() != 1 && ((BaseListModel)SWDLScreenFactory.getModel(1700346, n)).getLength() != 0;
    }

    protected static final boolean evalCond1700090(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(1700364, n)).getValue() != 1;
    }

    protected static final boolean evalCond1700093(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(1700364, n)).getValue() != 1;
    }

    protected static final boolean evalCond1700094(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(1700364, n)).getValue() == 1 && ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() != 1 && ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() != 2 && ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() != 3;
    }

    protected static final boolean evalCond1700095(int n) {
        return ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 1 || ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 2 || ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 3 || ((ChoiceModel)SWDLScreenFactory.getModel(1700364, n)).getValue() == 1;
    }

    protected static final boolean evalCond1700096(int n) {
        return ((LabelModel)SWDLScreenFactory.getModel(1700280, n)).getStatus() == 0 && ((ChoiceModel)SWDLScreenFactory.getModel(1700367, n)).getValue() == 0;
    }

    protected static final boolean evalCond1700097(int n) {
        return ((LabelModel)SWDLScreenFactory.getModel(1700385, n)).getLength() == 0 || ((LabelModel)SWDLScreenFactory.getModel(1700235, n)).getLength() == 0;
    }

    protected static final boolean evalCond1700098(int n) {
        return ((LabelModel)SWDLScreenFactory.getModel(1700365, n)).getLength() == 0 && ((LabelModel)SWDLScreenFactory.getModel(1700271, n)).getLength() == 0;
    }

    protected static final boolean evalCond1700101(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(1700311, n)).getValue() <= -1;
    }

    protected static final boolean evalCond1700102(int n) {
        return ((LabelModel)SWDLScreenFactory.getModel(1700235, n)).getLength() != 0 || ((LabelModel)SWDLScreenFactory.getModel(1700385, n)).getLength() == 0;
    }

    protected static final boolean evalCond1700103(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(3849, n)).getValue() == 2 || ((ChoiceModel)SWDLScreenFactory.getModel(3849, n)).getValue() == 11;
    }

    protected static final boolean evalCond1700107(int n) {
        return ((SysConstModel)SWDLScreenFactory.getModel(3939, n)).getValue() != 0;
    }

    protected static final boolean evalCond1700108(int n) {
        return ((SysConstModel)SWDLScreenFactory.getModel(3939, n)).getValue() != 0;
    }

    protected static final boolean evalCond1700109(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(3849, n)).getValue() != 2 && ((ChoiceModel)SWDLScreenFactory.getModel(3849, n)).getValue() != 11;
    }

    protected static final boolean evalCond1700110(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(3849, n)).getValue() == 2 || ((ChoiceModel)SWDLScreenFactory.getModel(3849, n)).getValue() == 11;
    }

    protected static final boolean evalCond1700116(int n) {
        return ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() != 1 && ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() != 3 && ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() != 2;
    }

    protected static final boolean evalCond1700117(int n) {
        return ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 1 || ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 3 || ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 2;
    }

    protected static final boolean evalCond1700118(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(1700364, n)).getValue() != 1 && ((BaseListModel)SWDLScreenFactory.getModel(1700346, n)).getLength() == 0;
    }

    protected static final boolean evalCond1700119(int n) {
        return ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() != 2;
    }

    protected static final boolean evalCond1700120(int n) {
        return ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 2;
    }

    protected static final boolean evalCond1700122(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(1700367, n)).getValue() == 0 || ((ChoiceModel)SWDLScreenFactory.getModel(1700367, n)).getValue() == 1 || ((ChoiceModel)SWDLScreenFactory.getModel(1700367, n)).getValue() == 3;
    }

    protected static final boolean evalCond1700123(int n) {
        return ((SysConstModel)SWDLScreenFactory.getModel(522, n)).getValue() == 4 || ((SysConstModel)SWDLScreenFactory.getModel(522, n)).getValue() == 2 || ((SysConstModel)SWDLScreenFactory.getModel(522, n)).getValue() == 1 && ((SysConstModel)SWDLScreenFactory.getModel(523, n)).getValue() == 1;
    }

    protected static final boolean evalCond1700124(int n) {
        return ((SysConstModel)SWDLScreenFactory.getModel(522, n)).getValue() == 4 || ((SysConstModel)SWDLScreenFactory.getModel(522, n)).getValue() == 2 || ((SysConstModel)SWDLScreenFactory.getModel(522, n)).getValue() == 1 && ((SysConstModel)SWDLScreenFactory.getModel(523, n)).getValue() == 1;
    }

    protected static final boolean evalCond1700125(int n) {
        return ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() != 3 && ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() != 2;
    }

    protected static final boolean evalCond1700126(int n) {
        return ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 2 || ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 3;
    }

    protected static final boolean evalCond1700127(int n) {
        return ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() != 2 && ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() != 3;
    }

    protected static final boolean evalCond1700128(int n) {
        return ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 3 || ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 2;
    }

    protected static final boolean evalCond1700129(int n) {
        return ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() != 3 && ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() != 2;
    }

    protected static final boolean evalCond1700130(int n) {
        return ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 3 || ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 2;
    }

    protected static final boolean evalCond1700135(int n) {
        return ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 3 || ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 2 || ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 1 || ((ChoiceModel)SWDLScreenFactory.getModel(1700364, n)).getValue() == 1;
    }

    protected static final boolean evalCond1700136(int n) {
        return ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 3 || ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 2 || ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 1 || ((ChoiceModel)SWDLScreenFactory.getModel(1700364, n)).getValue() == 1;
    }

    protected static final boolean evalCond1700137(int n) {
        return ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 2 || ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 3 || ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 1 || ((ChoiceModel)SWDLScreenFactory.getModel(1700364, n)).getValue() == 1;
    }

    protected static final boolean evalCond1700139(int n) {
        return (((SysConstModel)SWDLScreenFactory.getModel(522, n)).getValue() == 1 || ((ChoiceModel)SWDLScreenFactory.getModel(1700387, n)).getValue() == 1) && ((SysConstModel)SWDLScreenFactory.getModel(4581, n)).getValue() == 0;
    }

    protected static final boolean evalCond1700146(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(1700327, n)).getValue() != 6;
    }

    public void executeCondition(int n, int n2, HMIView[] hMIViewArray, int n3) {
        switch (n2) {
            case 1700082: {
                this.executeConditionsETTINGSPOPUPONLINEUPDATEDOWNLOADFAILURERETRYPOSSIBLEScreen(n, hMIViewArray, n3);
                break;
            }
            case 1700087: {
                this.executeConditionsETTINGSPOPUPONLINEUPDATESERVERFAILUREScreen(n, hMIViewArray, n3);
                break;
            }
            case 1700142: {
                this.executeConditionsETTINGSPOPUPUPDATENAVDBSUMMARYUOTASUCCESSFULScreen(n, hMIViewArray, n3);
                break;
            }
            case 1700076: {
                this.executeConditionsETTINGSPOPUPUPDATEONLINENEWDATAAVAILABLELICENCEAVAILABLEScreen(n, hMIViewArray, n3);
                break;
            }
            case 1700144: {
                this.executeConditionsETTINGSPOPUPUPDATEPERSONALIZEScreen(n, hMIViewArray, n3);
                break;
            }
            case 1700054: {
                this.executeConditionsETTINGSPOPUPUPDATESOURCECONFIRMATIONScreen(n, hMIViewArray, n3);
                break;
            }
            case 1700091: {
                this.executeConditionsETTINGSPOPUPUPDATESYSTEMPROPOSALScreen(n, hMIViewArray, n3);
                break;
            }
            case 1700141: {
                this.executeConditionsETTINGSPOPUPUPDATESYSTEMPROPOSALDESTINATIONScreen(n, hMIViewArray, n3);
                break;
            }
            case 1700090: {
                this.executeConditionsETTINGSPOPUPUPDATESYSTEMPROPOSALDISCLAIMERScreen(n, hMIViewArray, n3);
                break;
            }
            case 1700061: {
                this.executeConditionsETTINGSUPDATEDOWNLOADScreen(n, hMIViewArray, n3);
                break;
            }
            case 1700060: {
                this.executeConditionsETTINGSUPDATEONLINESOURCEDATAOKSTARTScreen(n, hMIViewArray, n3);
                break;
            }
            case 1700089: {
                this.executeConditionsETTINGSUPDATEPROGRESSPROCESSBARScreen(n, hMIViewArray, n3);
                break;
            }
            case 1700088: {
                this.executeConditionsETTINGSUPDATESOURCEScreen(n, hMIViewArray, n3);
                break;
            }
            case 1700066: {
                this.executeConditionsETTINGSUPDATESOURCEACCESSFAILUREScreen(n, hMIViewArray, n3);
                break;
            }
            case 1700068: {
                this.executeConditionsETTINGSUPDATESOURCEDATAOKNAVDBADDITIONALCOUNTRIESScreen(n, hMIViewArray, n3);
                break;
            }
            case 1700067: {
                this.executeConditionsETTINGSUPDATESOURCEDATAOKNAVDBCOUNTRYScreen(n, hMIViewArray, n3);
                break;
            }
            case 1700050: {
                this.executeConditionsETTINGSUPDATESOURCEDATAOKSTARTScreen(n, hMIViewArray, n3);
                break;
            }
            case 1700052: {
                this.executeConditionsETTINGSUPDATESOURCENODATAScreen(n, hMIViewArray, n3);
                break;
            }
            case 1700015: {
                this.executeConditionsWDLOPTScreen(n, hMIViewArray, n3);
                break;
            }
            case 1700021: {
                this.executeConditionswdlPopupScreen(n, hMIViewArray, n3);
                break;
            }
            case 1700019: {
                this.executeConditionswdlReadMetaProgressScreen(n, hMIViewArray, n3);
                break;
            }
            case 1700011: {
                this.executeConditionswdlRebootScreen(n, hMIViewArray, n3);
                break;
            }
            case 1700023: {
                this.executeConditionswdlSelectAppBlScreen(n, hMIViewArray, n3);
                break;
            }
            case 1700071: {
                this.executeConditionswdlSelectAppBlNoRDScreen(n, hMIViewArray, n3);
                break;
            }
            case 1700009: {
                this.executeConditionswdlSelectCompScreen(n, hMIViewArray, n3);
                break;
            }
            case 1700070: {
                this.executeConditionswdlSelectCompNoRDScreen(n, hMIViewArray, n3);
                break;
            }
            case 1700008: {
                this.executeConditionswdlSelectUpdateScreen(n, hMIViewArray, n3);
                break;
            }
            case 1700073: {
                this.executeConditionswdlStartAbortDownloadUpdateRunningScreen(n, hMIViewArray, n3);
                break;
            }
            case 1700013: {
                this.executeConditionswdlSummaryScreen(n, hMIViewArray, n3);
                break;
            }
        }
    }

    private void executeConditionsETTINGSPOPUPONLINEUPDATEDOWNLOADFAILURERETRYPOSSIBLEScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700288: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!this.evaluateSimpleAbstractModelStatusEqualsCondition(1700288, n2, 2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSPOPUPONLINEUPDATESERVERFAILUREScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 3849: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1700103, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((VirtualButton)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(1700109, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((VirtualButton)hMIViewArray[2]).setEnabled(hmiService.getComponentConditionManager().isTrue(1700110, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSPOPUPUPDATENAVDBSUMMARYUOTASUCCESSFULScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700235: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1700097, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(1700102, n2));
                break;
            }
            case 1700271: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1700098, n2));
                break;
            }
            case 1700365: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1700098, n2));
                break;
            }
            case 1700385: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1700097, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(1700102, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSPOPUPUPDATEONLINENEWDATAAVAILABLELICENCEAVAILABLEScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 442: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1700119, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1700120, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSPOPUPUPDATEPERSONALIZEScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 522: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1700139, n2));
                break;
            }
            case 4581: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1700139, n2));
                break;
            }
            case 1700387: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1700139, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSPOPUPUPDATESOURCECONFIRMATIONScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 3849: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1700061, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1700060, n2));
                break;
            }
            case 1700259: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1700061, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1700060, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSPOPUPUPDATESYSTEMPROPOSALScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 442: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1700136, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1700129, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((LabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1700130, n2));
                break;
            }
            case 0x19F1F9: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(0x19F1F9, n2, 0));
                break;
            }
            case 1700364: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1700136, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSPOPUPUPDATESYSTEMPROPOSALDESTINATIONScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 442: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1700137, n2));
                break;
            }
            case 1700364: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1700137, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSPOPUPUPDATESYSTEMPROPOSALDISCLAIMERScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 442: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1700116, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1700117, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSUPDATEDOWNLOADScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700244: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1700049, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(this.evaluateSimpleAbstractModelStatusGreaterCondition(1700244, n2, 1));
                break;
            }
            case 1700288: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!this.evaluateSimpleAbstractModelStatusEqualsCondition(1700288, n2, 2));
                break;
            }
            case 1700327: {
                if (hmiService.getComponentConditionManager().isTrue(1700146, n2)) {
                    if (hMIViewArray[0] != null) {
                        ((GlassplateController)hMIViewArray[0]).setSeparatorYPosition(245);
                    }
                } else if (hMIViewArray[0] != null) {
                    ((GlassplateController)hMIViewArray[0]).setSeparatorYPosition(-1);
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(1700327, n2, 6));
                }
                if (hMIViewArray[2] == null) break;
                ((VirtualButton)hMIViewArray[2]).setEnabled(!this.evaluateSimpleChoiceModelValueEqualsCondition(1700327, n2, 6));
                break;
            }
        }
    }

    private void executeConditionsETTINGSUPDATEONLINESOURCEDATAOKSTARTScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700247: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(1700247, n2, 0));
                break;
            }
        }
    }

    private void executeConditionsETTINGSUPDATEPROGRESSPROCESSBARScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700280: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1700096, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1700068, n2));
                break;
            }
            case 1700367: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1700096, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1700068, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((WaitAnimController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1700122, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSUPDATESOURCEScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 522: {
                if (hMIViewArray[0] != null) {
                    ((ListController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1700123, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((ListController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(1700124, n2));
                break;
            }
            case 523: {
                if (hMIViewArray[0] != null) {
                    ((ListController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1700123, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((ListController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(1700124, n2));
                break;
            }
            case 3969: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1700063, n2));
                break;
            }
            case 1100305: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(1700075, n2));
                break;
            }
            case 1700238: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(1700075, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSUPDATESOURCEACCESSFAILUREScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700386: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1700386, n2, 1));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1700386, n2, 0));
                break;
            }
        }
    }

    private void executeConditionsETTINGSUPDATESOURCEDATAOKNAVDBADDITIONALCOUNTRIESScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 442: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1700125, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1700126, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSUPDATESOURCEDATAOKNAVDBCOUNTRYScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 442: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1700094, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(1700135, n2)) {
                    if (hMIViewArray[1] != null) {
                        ((MenuItemController)hMIViewArray[1]).setVisible(false);
                    }
                } else if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(false);
                }
                if (hmiService.getComponentConditionManager().isTrue(1700095, n2)) {
                    if (hMIViewArray[2] != null) {
                        ((MenuItemController)hMIViewArray[2]).setVisible(false);
                    }
                } else if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(false);
                }
                if (hMIViewArray[3] != null) {
                    ((LabelController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(0x19F11F, n2));
                }
                if (hMIViewArray[4] == null) break;
                ((LabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(1700128, n2));
                break;
            }
            case 1700346: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1700089, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1700118, n2));
                break;
            }
            case 1700364: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1700094, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1700089, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1700118, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((ListController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(1700090, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((ListController)hMIViewArray[4]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1700364, n2, 1));
                }
                if (hmiService.getComponentConditionManager().isTrue(1700135, n2)) {
                    if (hMIViewArray[5] != null) {
                        ((MenuItemController)hMIViewArray[5]).setVisible(false);
                    }
                } else if (hMIViewArray[5] != null) {
                    ((MenuItemController)hMIViewArray[5]).setVisible(false);
                }
                if (hmiService.getComponentConditionManager().isTrue(1700095, n2)) {
                    if (hMIViewArray[6] != null) {
                        ((MenuItemController)hMIViewArray[6]).setVisible(false);
                    }
                } else if (hMIViewArray[6] != null) {
                    ((MenuItemController)hMIViewArray[6]).setVisible(false);
                }
                if (hMIViewArray[7] == null) break;
                ((MenuItemController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(1700093, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSUPDATESOURCEDATAOKSTARTScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700262: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(1700262, n2, 0));
                break;
            }
        }
    }

    private void executeConditionsETTINGSUPDATESOURCENODATAScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700386: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1700386, n2, 1));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1700386, n2, 0));
                break;
            }
        }
    }

    private void executeConditionsWDLOPTScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 376: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1700018, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(1700019, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1700020, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setEnabled(hmiService.getComponentConditionManager().isTrue(1700021, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((MenuItemController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(1700022, n2));
                }
                if (hMIViewArray[5] == null) break;
                ((MenuItemController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(1700024, n2));
                break;
            }
            case 1700221: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1700023, n2));
                break;
            }
            case 1700222: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1700025, n2));
                break;
            }
        }
    }

    private void executeConditionswdlPopupScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700110: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(1700110, n2, 0));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1700072, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1700073, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((MenuItemController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(1700074, n2));
                break;
            }
            case 1700111: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(1700111, n2, 0));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1700072, n2));
                break;
            }
            case 1700112: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(1700112, n2, 0));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1700073, n2));
                break;
            }
            case 0x19F111: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(0x19F111, n2, 0));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1700072, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1700073, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((MenuItemController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(1700074, n2));
                break;
            }
            case 1700114: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(1700114, n2, 0));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1700074, n2));
                break;
            }
            case 1700115: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(1700115, n2, 0));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1700072, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1700073, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((MenuItemController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(1700074, n2));
                break;
            }
            case 1700117: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(1700117, n2, 0));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1700072, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1700073, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((MenuItemController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(1700074, n2));
                break;
            }
        }
    }

    private void executeConditionswdlReadMetaProgressScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700311: {
                if (hMIViewArray[0] != null) {
                    ((ContainerController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueGreaterCondition(1700311, n2, -1));
                }
                if (hMIViewArray[1] == null) break;
                ((ContainerController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1700101, n2));
                break;
            }
        }
    }

    private void executeConditionswdlRebootScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 3939: {
                if (hMIViewArray[0] == null) break;
                ((WaitAnimController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1700107, n2));
                break;
            }
        }
    }

    private void executeConditionswdlSelectAppBlScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700108: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1700108, n2, 1));
                break;
            }
        }
    }

    private void executeConditionswdlSelectAppBlNoRDScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700108: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1700108, n2, 1));
                break;
            }
        }
    }

    private void executeConditionswdlSelectCompScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700051: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(this.evaluateSimpleAbstractModelStatusEqualsCondition(1700051, n2, 1));
                break;
            }
        }
    }

    private void executeConditionswdlSelectCompNoRDScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700051: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1700045, n2));
                break;
            }
            case 1700311: {
                if (hMIViewArray[0] == null) break;
                ((LabelController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(1700311, n2, 0));
                break;
            }
        }
    }

    private void executeConditionswdlSelectUpdateScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700171: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueEqualsCondition(1700171, n2, 1));
                break;
            }
        }
    }

    private void executeConditionswdlStartAbortDownloadUpdateRunningScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 3939: {
                if (hMIViewArray[0] == null) break;
                ((WaitAnimController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1700108, n2));
                break;
            }
        }
    }

    private void executeConditionswdlSummaryScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700133: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1700058, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1700057, n2));
                break;
            }
            case 1700161: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleChoiceModelValueEqualsCondition(1700161, n2, 1));
                break;
            }
        }
    }

    public IPartialPopupController getPartialPopup(int n, int n2) {
        switch (n) {
            case 1700144: {
                return (IPartialPopupController)((Object)SWDLScreenBag4.sETTINGSPOPUPUPDATEPERSONALIZE(this, n2));
            }
        }
        return null;
    }

    public IPartialPopupController[] getPartialPopupStubs(int n) {
        return new IPartialPopupController[]{new PartialPopupStub(1700144, -1, -1, 250, 0, 12, true, 7, n, 1, null, false, true)};
    }

    public IDrawerController[] getOptionDrawers(int n) {
        return new IDrawerController[]{(IDrawerController)SWDLScreenBag1.sWDLOPT(this, n)};
    }
}

