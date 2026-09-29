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
import de.audi.tghu.swdl.hmi.evohighscale.SWDLScreenFactory$1;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLScreenFactory$2;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLScreenFactory$3;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLScreenFactory$4;
import de.esolutions.hmi.widgets.audi.base.FontLoader;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.VirtualButton;
import de.esolutions.hmi.widgets.audi.evo.ScreenWidgetEVO;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ContainerRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MultiLineLabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ScreenRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.GlassplateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupStub;
import de.esolutions.hmi.widgets.audi.evo.widgets.SmallStageApplicationIconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.WaitAnimController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.ListController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.OldListModelAccess;
import java.util.NoSuchElementException;

public class SWDLScreenFactory
extends AbstractScreenFactory {
    private static HMIService hmiService;
    private static final int MODULE_ID;
    private int[][] errorColors;
    public AbstractWidgetController[][] refWidgets = new AbstractWidgetController[8][11];

    public SWDLScreenFactory(IFrameworkAccess iFrameworkAccess) {
        super(17, iFrameworkAccess);
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
        return "HMISWDLEvoHighScale";
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
                containerController.setEntertainmentMenuTransformation(16449, 16449, -1883081409, -1883081409, 0.0f);
                containerController.setOpacitySet(1.0f, -842216386);
                containerController.setOptionMenuTransformation(32960, 57408, -1701242561, -1701242561, 0.0f);
                containerController.setSelectionMenuTransformation(8438595, 57408, -1701242561, -1701242561, 0.0f);
                containerController.add(labelController);
                abstractWidgetController = containerController;
                break;
            }
            case 2: {
                LabelController labelController = new LabelController();
                MultiLineLabelRendererHigh multiLineLabelRendererHigh = new MultiLineLabelRendererHigh(labelController);
                labelController.setRenderer(multiLineLabelRendererHigh);
                multiLineLabelRendererHigh.setFonts(sWDLScreenFactory.getFonts(2, n));
                labelController.setTextIds(new int[]{1794513152});
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
                containerController.setEntertainmentMenuTransformation(16449, 16449, -1883081409, -1883081409, 0.0f);
                containerController.setSelectionMenuTransformation(12589380, 35906, -1701242561, -1701242561, 0.0f);
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
                containerController.setEntertainmentMenuTransformation(16449, 16449, -1883081409, -1883081409, 0.0f);
                containerController.setSelectionMenuTransformation(12589380, 35906, -1701242561, -1701242561, 0.0f);
                containerController.add(smallStageApplicationIconController);
                containerController.add(smallStageApplicationIconController3);
                abstractWidgetController = containerController;
                break;
            }
            case 7: {
                ListController listController = new ListController();
                listController.setModelID(636557568);
                listController.setEvent(-1359996672);
                listController.setBounds(0, 0, 0, 0);
                listController.setGlassplateInsetsBottom(new int[0]);
                listController.setGlassplateInsetsTop(new int[0]);
                listController.setIdColumn(0);
                listController.setNoFocusAreasBottom(new int[0]);
                listController.setNoFocusAreasTop(new int[0]);
                listController.setRecordSetColumn(3);
                listController.setDataAccess(new OldListModelAccess());
                listController.setItemFactory(new SWDLScreenFactory$1(this));
                abstractWidgetController = listController;
                break;
            }
            case 8: {
                ListController listController = new ListController();
                listController.setModelID(435230976);
                listController.setEvent(-403695360);
                listController.setBounds(0, 0, 0, 0);
                listController.setGlassplateInsetsBottom(new int[0]);
                listController.setGlassplateInsetsTop(new int[0]);
                listController.setIdColumn(0);
                listController.setNoFocusAreasBottom(new int[0]);
                listController.setNoFocusAreasTop(new int[0]);
                listController.setRecordSetColumn(6);
                listController.setItemFactory(new SWDLScreenFactory$2(this));
                abstractWidgetController = listController;
                break;
            }
            case 9: {
                ListController listController = new ListController();
                listController.setModelID(720443648);
                listController.setEvent(-1074784000);
                listController.setBounds(0, 0, 0, 0);
                listController.setGlassplateInsetsBottom(new int[0]);
                listController.setGlassplateInsetsTop(new int[0]);
                listController.setIdColumn(0);
                listController.setNoFocusAreasBottom(new int[0]);
                listController.setNoFocusAreasTop(new int[0]);
                listController.setRecordSetColumn(3);
                listController.setItemFactory(new SWDLScreenFactory$3(this));
                abstractWidgetController = listController;
                break;
            }
            case 10: {
                ListController listController = new ListController();
                listController.setModelID(619780352);
                listController.setEvent(-1041229568);
                listController.setBounds(0, 0, 0, 0);
                listController.setColorIndices(new int[]{0, 0, 0, 0});
                listController.setEnabledColumn(2);
                listController.setGlassplateInsetsBottom(new int[0]);
                listController.setGlassplateInsetsTop(new int[0]);
                listController.setIdColumn(0);
                listController.setNoFocusAreasBottom(new int[0]);
                listController.setNoFocusAreasTop(new int[0]);
                listController.setRecordSetColumn(3);
                listController.setItemFactory(new SWDLScreenFactory$4(this));
                abstractWidgetController = listController;
                break;
            }
            default: {
                this.getFramework().getLogChannel("ScreenFactory").log(10000, new StringBuffer().append("Invalid reference widget id ").append(n2).append(".").toString());
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
        return ((ButtonModel)SWDLScreenFactory.getModel(2112952576, n)).getStatus() == 1;
    }

    protected static final boolean evalCond1700024(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(376, n)).getValue() > -1;
    }

    protected static final boolean evalCond1700025(int n) {
        return ((ButtonModel)SWDLScreenFactory.getModel(2129729792, n)).getStatus() == 1;
    }

    protected static final boolean evalCond1700045(int n) {
        return ((ButtonModel)SWDLScreenFactory.getModel(-739239680, n)).getStatus() == 1;
    }

    protected static final boolean evalCond1700049(int n) {
        return ((LabelModel)SWDLScreenFactory.getModel(-1796138752, n)).getStatus() <= 1;
    }

    protected static final boolean evalCond1700057(int n) {
        return ((BufferedListModel)SWDLScreenFactory.getModel(636557568, n)).getLength() > 0;
    }

    protected static final boolean evalCond1700058(int n) {
        return ((BufferedListModel)SWDLScreenFactory.getModel(636557568, n)).getLength() > 0;
    }

    protected static final boolean evalCond1700060(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(3849, n)).getValue() == 2 || ((ChoiceModel)SWDLScreenFactory.getModel(-1544480512, n)).getValue() == 7;
    }

    protected static final boolean evalCond1700061(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(3849, n)).getValue() != 2 && ((ChoiceModel)SWDLScreenFactory.getModel(-1544480512, n)).getValue() != 7;
    }

    protected static final boolean evalCond1700063(int n) {
        return ((SysConstModel)SWDLScreenFactory.getModel(3969, n)).getValue() == 0;
    }

    protected static final boolean evalCond1700068(int n) {
        return ((LabelModel)SWDLScreenFactory.getModel(-1192158976, n)).getStatus() == 0 && ((ChoiceModel)SWDLScreenFactory.getModel(267524352, n)).getValue() == 0;
    }

    protected static final boolean evalCond1700072(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(334567680, n)).getValue() == 0 && ((ChoiceModel)SWDLScreenFactory.getModel(301013248, n)).getValue() == 0 && ((ChoiceModel)SWDLScreenFactory.getModel(368122112, n)).getValue() == 0 && ((ChoiceModel)SWDLScreenFactory.getModel(267458816, n)).getValue() == 0 && ((ChoiceModel)SWDLScreenFactory.getModel(250681600, n)).getValue() == 0;
    }

    protected static final boolean evalCond1700073(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(334567680, n)).getValue() == 0 && ((ChoiceModel)SWDLScreenFactory.getModel(301013248, n)).getValue() == 0 && ((ChoiceModel)SWDLScreenFactory.getModel(284236032, n)).getValue() == 0 && ((ChoiceModel)SWDLScreenFactory.getModel(368122112, n)).getValue() == 0 && ((ChoiceModel)SWDLScreenFactory.getModel(250681600, n)).getValue() == 0;
    }

    protected static final boolean evalCond1700074(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(334567680, n)).getValue() == 0 && ((ChoiceModel)SWDLScreenFactory.getModel(301013248, n)).getValue() == 0 && ((ChoiceModel)SWDLScreenFactory.getModel(368122112, n)).getValue() == 0 && ((ChoiceModel)SWDLScreenFactory.getModel(317790464, n)).getValue() == 0 && ((ChoiceModel)SWDLScreenFactory.getModel(250681600, n)).getValue() == 0;
    }

    protected static final boolean evalCond1700075(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(-1896802048, n)).getValue() == 0 || ((ChoiceModel)SWDLScreenFactory.getModel(298455040, n)).getValue() == 1;
    }

    protected static final boolean evalCond1700089(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(217192704, n)).getValue() != 1 && ((BaseListModel)SWDLScreenFactory.getModel(-84862720, n)).getLength() != 0;
    }

    protected static final boolean evalCond1700090(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(217192704, n)).getValue() != 1;
    }

    protected static final boolean evalCond1700093(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(217192704, n)).getValue() != 1;
    }

    protected static final boolean evalCond1700094(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(217192704, n)).getValue() == 1 && ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() != 1 && ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() != 2 && ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() != 3;
    }

    protected static final boolean evalCond1700095(int n) {
        return ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 1 || ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 2 || ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 3 || ((ChoiceModel)SWDLScreenFactory.getModel(217192704, n)).getValue() == 1;
    }

    protected static final boolean evalCond1700096(int n) {
        return ((LabelModel)SWDLScreenFactory.getModel(-1192158976, n)).getStatus() == 0 && ((ChoiceModel)SWDLScreenFactory.getModel(267524352, n)).getValue() == 0;
    }

    protected static final boolean evalCond1700097(int n) {
        return ((LabelModel)SWDLScreenFactory.getModel(569514240, n)).getLength() == 0 || ((LabelModel)SWDLScreenFactory.getModel(-1947133696, n)).getLength() == 0;
    }

    protected static final boolean evalCond1700098(int n) {
        return ((LabelModel)SWDLScreenFactory.getModel(233969920, n)).getLength() == 0 && ((LabelModel)SWDLScreenFactory.getModel(-1343153920, n)).getLength() == 0;
    }

    protected static final boolean evalCond1700101(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(-672065280, n)).getValue() <= -1;
    }

    protected static final boolean evalCond1700102(int n) {
        return ((LabelModel)SWDLScreenFactory.getModel(-1947133696, n)).getLength() != 0 || ((LabelModel)SWDLScreenFactory.getModel(569514240, n)).getLength() == 0;
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
        return ((ChoiceModel)SWDLScreenFactory.getModel(217192704, n)).getValue() != 1 && ((BaseListModel)SWDLScreenFactory.getModel(-84862720, n)).getLength() == 0;
    }

    protected static final boolean evalCond1700119(int n) {
        return ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() != 2;
    }

    protected static final boolean evalCond1700120(int n) {
        return ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 2;
    }

    protected static final boolean evalCond1700122(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(267524352, n)).getValue() == 0 || ((ChoiceModel)SWDLScreenFactory.getModel(267524352, n)).getValue() == 1 || ((ChoiceModel)SWDLScreenFactory.getModel(267524352, n)).getValue() == 3;
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
        return ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 3 || ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 2 || ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 1 || ((ChoiceModel)SWDLScreenFactory.getModel(217192704, n)).getValue() == 1;
    }

    protected static final boolean evalCond1700136(int n) {
        return ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 3 || ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 2 || ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 1 || ((ChoiceModel)SWDLScreenFactory.getModel(217192704, n)).getValue() == 1;
    }

    protected static final boolean evalCond1700137(int n) {
        return ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 2 || ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 3 || ((SysConstModel)SWDLScreenFactory.getModel(442, n)).getValue() == 1 || ((ChoiceModel)SWDLScreenFactory.getModel(217192704, n)).getValue() == 1;
    }

    protected static final boolean evalCond1700139(int n) {
        return (((SysConstModel)SWDLScreenFactory.getModel(522, n)).getValue() == 1 || ((ChoiceModel)SWDLScreenFactory.getModel(603068672, n)).getValue() == 1) && ((SysConstModel)SWDLScreenFactory.getModel(4581, n)).getValue() == 0;
    }

    protected static final boolean evalCond1700146(int n) {
        return ((ChoiceModel)SWDLScreenFactory.getModel(-403629824, n)).getValue() != 6;
    }

    @Override
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
                ((MenuItemController)hMIViewArray[0]).setVisible(!this.evaluateSimpleAbstractModelStatusEqualsCondition(-1057941248, n2, 2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSPOPUPONLINEUPDATESERVERFAILUREScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 3849: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(133241088, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((VirtualButton)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(233904384, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((VirtualButton)hMIViewArray[2]).setEnabled(hmiService.getComponentConditionManager().isTrue(250681600, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSPOPUPUPDATENAVDBSUMMARYUOTASUCCESSFULScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700235: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(32577792, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(116463872, n2));
                break;
            }
            case 1700271: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(49355008, n2));
                break;
            }
            case 1700365: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(49355008, n2));
                break;
            }
            case 1700385: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(32577792, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(116463872, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSPOPUPUPDATEONLINENEWDATAAVAILABLELICENCEAVAILABLEScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 442: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(401676544, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(418453760, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSPOPUPUPDATEPERSONALIZEScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 522: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(737220864, n2));
                break;
            }
            case 4581: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(737220864, n2));
                break;
            }
            case 1700387: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(737220864, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSPOPUPUPDATESOURCECONFIRMATIONScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 3849: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(-571467520, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-588244736, n2));
                break;
            }
            case 1700259: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(-571467520, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-588244736, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSPOPUPUPDATESYSTEMPROPOSALScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 442: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(686889216, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(569448704, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((LabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(586225920, n2));
                break;
            }
            case 0x19F1F9: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(-101639936, n2, 0));
                break;
            }
            case 1700364: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(686889216, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSPOPUPUPDATESYSTEMPROPOSALDESTINATIONScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 442: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(703666432, n2));
                break;
            }
            case 1700364: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(703666432, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSPOPUPUPDATESYSTEMPROPOSALDISCLAIMERScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 442: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(351344896, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(368122112, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSUPDATEDOWNLOADScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700244: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(-772794112, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(this.evaluateSimpleAbstractModelStatusGreaterCondition(-1796138752, n2, 1));
                break;
            }
            case 1700288: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!this.evaluateSimpleAbstractModelStatusEqualsCondition(-1057941248, n2, 2));
                break;
            }
            case 1700327: {
                if (hmiService.getComponentConditionManager().isTrue(854661376, n2)) {
                    if (hMIViewArray[0] != null) {
                        ((GlassplateController)hMIViewArray[0]).setSeparatorYPosition(245);
                    }
                } else if (hMIViewArray[0] != null) {
                    ((GlassplateController)hMIViewArray[0]).setSeparatorYPosition(-1);
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(-403629824, n2, 6));
                }
                if (hMIViewArray[2] == null) break;
                ((VirtualButton)hMIViewArray[2]).setEnabled(!this.evaluateSimpleChoiceModelValueEqualsCondition(-403629824, n2, 6));
                break;
            }
        }
    }

    private void executeConditionsETTINGSUPDATEONLINESOURCEDATAOKSTARTScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700247: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(-1745807104, n2, 0));
                break;
            }
        }
    }

    private void executeConditionsETTINGSUPDATEPROGRESSPROCESSBARScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700280: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(15800576, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-454027008, n2));
                break;
            }
            case 1700367: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(15800576, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-454027008, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((WaitAnimController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(452008192, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSUPDATESOURCEScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 522: {
                if (hMIViewArray[0] != null) {
                    ((ListController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(468785408, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((ListController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(485562624, n2));
                break;
            }
            case 523: {
                if (hMIViewArray[0] != null) {
                    ((ListController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(468785408, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((ListController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(485562624, n2));
                break;
            }
            case 3969: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(-537913088, n2));
                break;
            }
            case 1100305: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(-336586496, n2));
                break;
            }
            case 1700238: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(-336586496, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSUPDATESOURCEACCESSFAILUREScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700386: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(586291456, n2, 1));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(586291456, n2, 0));
                break;
            }
        }
    }

    private void executeConditionsETTINGSUPDATESOURCEDATAOKNAVDBADDITIONALCOUNTRIESScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 442: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(502339840, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(519117056, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSUPDATESOURCEDATAOKNAVDBCOUNTRYScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 442: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(-17819392, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(670112000, n2)) {
                    if (hMIViewArray[1] != null) {
                        ((MenuItemController)hMIViewArray[1]).setVisible(false);
                    }
                } else if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(false);
                }
                if (hmiService.getComponentConditionManager().isTrue(-1042176, n2)) {
                    if (hMIViewArray[2] != null) {
                        ((MenuItemController)hMIViewArray[2]).setVisible(false);
                    }
                } else if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(false);
                }
                if (hMIViewArray[3] != null) {
                    ((LabelController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(535894272, n2));
                }
                if (hMIViewArray[4] == null) break;
                ((LabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(552671488, n2));
                break;
            }
            case 1700346: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(-101705472, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(384899328, n2));
                break;
            }
            case 1700364: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(-17819392, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-101705472, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(384899328, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((ListController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(-84928256, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((ListController)hMIViewArray[4]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(217192704, n2, 1));
                }
                if (hmiService.getComponentConditionManager().isTrue(670112000, n2)) {
                    if (hMIViewArray[5] != null) {
                        ((MenuItemController)hMIViewArray[5]).setVisible(false);
                    }
                } else if (hMIViewArray[5] != null) {
                    ((MenuItemController)hMIViewArray[5]).setVisible(false);
                }
                if (hmiService.getComponentConditionManager().isTrue(-1042176, n2)) {
                    if (hMIViewArray[6] != null) {
                        ((MenuItemController)hMIViewArray[6]).setVisible(false);
                    }
                } else if (hMIViewArray[6] != null) {
                    ((MenuItemController)hMIViewArray[6]).setVisible(false);
                }
                if (hMIViewArray[7] == null) break;
                ((MenuItemController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(-34596608, n2));
                break;
            }
        }
    }

    private void executeConditionsETTINGSUPDATESOURCEDATAOKSTARTScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700262: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(-1494148864, n2, 0));
                break;
            }
        }
    }

    private void executeConditionsETTINGSUPDATESOURCENODATAScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700386: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(586291456, n2, 1));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(586291456, n2, 0));
                break;
            }
        }
    }

    private void executeConditionsWDLOPTScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 376: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(-1292887808, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1276110592, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(-1259333376, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1242556160, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((MenuItemController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(-1225778944, n2));
                }
                if (hMIViewArray[5] == null) break;
                ((MenuItemController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(-1192224512, n2));
                break;
            }
            case 1700221: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1209001728, n2));
                break;
            }
            case 1700222: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-1175447296, n2));
                break;
            }
        }
    }

    private void executeConditionswdlPopupScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700110: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(250681600, n2, 0));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-386918144, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(-370140928, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((MenuItemController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(-353363712, n2));
                break;
            }
            case 1700111: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(267458816, n2, 0));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-386918144, n2));
                break;
            }
            case 1700112: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(284236032, n2, 0));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-370140928, n2));
                break;
            }
            case 0x19F111: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(301013248, n2, 0));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-386918144, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(-370140928, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((MenuItemController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(-353363712, n2));
                break;
            }
            case 1700114: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(317790464, n2, 0));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-353363712, n2));
                break;
            }
            case 1700115: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(334567680, n2, 0));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-386918144, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(-370140928, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((MenuItemController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(-353363712, n2));
                break;
            }
            case 1700117: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(368122112, n2, 0));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-386918144, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(-370140928, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((MenuItemController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(-353363712, n2));
                break;
            }
        }
    }

    private void executeConditionswdlReadMetaProgressScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700311: {
                if (hMIViewArray[0] != null) {
                    ((ContainerController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueGreaterCondition(-672065280, n2, -1));
                }
                if (hMIViewArray[1] == null) break;
                ((ContainerController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(99686656, n2));
                break;
            }
        }
    }

    private void executeConditionswdlRebootScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 3939: {
                if (hMIViewArray[0] == null) break;
                ((WaitAnimController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(200349952, n2));
                break;
            }
        }
    }

    private void executeConditionswdlSelectAppBlScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700108: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(217127168, n2, 1));
                break;
            }
        }
    }

    private void executeConditionswdlSelectAppBlNoRDScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700108: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(217127168, n2, 1));
                break;
            }
        }
    }

    private void executeConditionswdlSelectCompScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700051: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(this.evaluateSimpleAbstractModelStatusEqualsCondition(-739239680, n2, 1));
                break;
            }
        }
    }

    private void executeConditionswdlSelectCompNoRDScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700051: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(-839902976, n2));
                break;
            }
            case 1700311: {
                if (hMIViewArray[0] == null) break;
                ((LabelController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(-672065280, n2, 0));
                break;
            }
        }
    }

    private void executeConditionswdlSelectUpdateScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700171: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueEqualsCondition(1274091776, n2, 1));
                break;
            }
        }
    }

    private void executeConditionswdlStartAbortDownloadUpdateRunningScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 3939: {
                if (hMIViewArray[0] == null) break;
                ((WaitAnimController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(217127168, n2));
                break;
            }
        }
    }

    private void executeConditionswdlSummaryScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700133: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(-621799168, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(-638576384, n2));
                break;
            }
            case 1700161: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleChoiceModelValueEqualsCondition(1106319616, n2, 1));
                break;
            }
        }
    }

    @Override
    public IPartialPopupController getPartialPopup(int n, int n2) {
        switch (n) {
            case 1700144: {
                return (IPartialPopupController)((Object)SWDLScreenBag4.sETTINGSPOPUPUPDATEPERSONALIZE(this, n2));
            }
        }
        return null;
    }

    @Override
    public IPartialPopupController[] getPartialPopupStubs(int n) {
        return new IPartialPopupController[]{new PartialPopupStub(821106944, -1, -1, 250, 0, 12, true, 7, n, 1, null, false, true)};
    }

    @Override
    public IDrawerController[] getOptionDrawers(int n) {
        return new IDrawerController[]{(IDrawerController)SWDLScreenBag1.sWDLOPT(this, n)};
    }
}

