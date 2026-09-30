/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tv.hmi.evohighscale;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.ButtonModel;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.LabelModel;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.MetricsModel;
import de.audi.atip.hmi.model.SpellerModel;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.sysconst.SysConstModel;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.hmi.view.HMIView;
import de.audi.atip.hmi.view.IDrawerController;
import de.audi.atip.hmi.view.IPartialPopupController;
import de.audi.atip.hmi.view.Screen;
import de.audi.tghu.tv.hmi.evohighscale.FontFactory;
import de.audi.tghu.tv.hmi.evohighscale.TVScreenBag1;
import de.audi.tghu.tv.hmi.evohighscale.TVScreenBag2;
import de.esolutions.hmi.widgets.audi.base.FontLoader;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IdleTimerController;
import de.esolutions.hmi.widgets.audi.base.widgets.ModelStubController;
import de.esolutions.hmi.widgets.audi.base.widgets.VirtualButton;
import de.esolutions.hmi.widgets.audi.evo.InstructionTextContoller;
import de.esolutions.hmi.widgets.audi.evo.ScreenWidgetEVO;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ContainerRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.HighlightingLabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MenuItemRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.OperationPanelController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.OperationPanelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ScreenRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.SpellerRendererEuropeHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.factories.SpellerRendererHighFactory;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerContentController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupStub;
import de.esolutions.hmi.widgets.audi.evo.widgets.ProgressBarController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SmallStageApplicationIconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SpellerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.StatusBarStubController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchMediaHandler;
import de.esolutions.hmi.widgets.audi.evo.widgets.factories.SpellerControllerFactory;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.BaseListModelAccess;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.ListController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemColumnsConstraints;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuMergeTimerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemFactory;
import java.util.NoSuchElementException;

public class TVScreenFactory
extends AbstractScreenFactory {
    private static HMIService hmiService;
    private static final int MODULE_ID = 26;
    private int[][] errorColors;
    public AbstractWidgetController[][] refWidgets = new AbstractWidgetController[8][32];

    public TVScreenFactory(IFrameworkAccess iFrameworkAccess) {
        super(26, iFrameworkAccess);
        hmiService = iFrameworkAccess.getHMIService();
    }

    private int[][] getErrorColors() {
        if (this.errorColors == null) {
            this.errorColors = new int[][]{{-16777216, -7829368}, {-16777216, -7829368}, {-16777216, -7829368}, {-16777216, -7829368}, {-16777216, -7829368}};
        }
        return this.errorColors;
    }

    public String getName() {
        return "HMITVEvoHighScale";
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
            case 2600000: {
                return TVScreenBag1.tVREFTEMPLATE(this, n2);
            }
            case 2600052: {
                return TVScreenBag1.tVTEXTCONST(this, n2);
            }
            case 2600005: {
                return TVScreenBag1.tVFULLSCREENMAIN(this, n2);
            }
            case 2600006: {
                return TVScreenBag1.tVCHANNELMAIN(this, n2);
            }
            case 2600007: {
                return TVScreenBag1.tVFULLSCREENDISCLAIMEROBSOLETE(this, n2);
            }
            case 2600008: {
                return TVScreenBag1.tVCASDISCLAIMERFIRST(this, n2);
            }
            case 2600009: {
                return TVScreenBag1.tVCASDISCLAIMERSECOND(this, n2);
            }
            case 2600010: {
                return TVScreenBag1.tVFULLSCREENMOVIERATING(this, n2);
            }
            case 2600015: {
                return TVScreenBag1.tVPOPUPEWSMAIN(this, n2);
            }
            case 2600016: {
                return TVScreenBag1.tVPOPUPEWSPREFECTURES(this, n2);
            }
            case 2600017: {
                return TVScreenBag1.tVAVMAIN(this, n2);
            }
            case 2600018: {
                return TVScreenBag1.tVAVFULLSCREEN(this, n2);
            }
            case 2600019: {
                return TVScreenBag1.tVAVFULLSCREENDISCLAIMEROBSOLETE(this, n2);
            }
            case 2600042: {
                return TVScreenBag1.tVFAVORITEMAIN(this, n2);
            }
            case 2600045: {
                return TVScreenBag1.tVPOPUPEWSSMT(this, n2);
            }
            case 2600082: {
                return TVScreenBag1.tVSTANDBYMAIN(this, n2);
            }
            case 2600083: {
                return TVScreenBag1.tVAVFULLSCREENDISCLAIMER(this, n2);
            }
            case 2600032: {
                return TVScreenBag1.tVOPTCASIDMAIN(this, n2);
            }
            case 2600013: {
                return TVScreenBag2.tVOPTDATABROADCASTDISCLAIMEROBSOLETE(this, n2);
            }
            case 2600012: {
                return TVScreenBag2.tVOPTDATABROADCASTMAIN(this, n2);
            }
            case 2600033: {
                return TVScreenBag2.tVOPTENGINEERINGMAIN(this, n2);
            }
            case 2600011: {
                return TVScreenBag2.tVOPTEPGMAIN(this, n2);
            }
            case 2600023: {
                return TVScreenBag2.tVOPTPARENTALBLOCKED(this, n2);
            }
            case 2600022: {
                return TVScreenBag2.tVOPTPARENTALENTERPWD(this, n2);
            }
            case 2600024: {
                return TVScreenBag2.tVOPTPARENTALENTERPWDWRONG(this, n2);
            }
            case 2600025: {
                return TVScreenBag2.tVOPTPARENTALSELECT(this, n2);
            }
            case 2600027: {
                return TVScreenBag2.tVOPTPARENTALSELECTCHANGEFIRST(this, n2);
            }
            case 2600028: {
                return TVScreenBag2.tVOPTPARENTALSELECTCHANGESECOND(this, n2);
            }
            case 2600029: {
                return TVScreenBag2.tVOPTPARENTALSELECTCHANGEUNEQUAL(this, n2);
            }
            case 2600026: {
                return TVScreenBag2.tVOPTPARENTALSELECTLEVEL(this, n2);
            }
            case 2600031: {
                return TVScreenBag2.tVOPTREGIONVARIANTMAIN(this, n2);
            }
            case 2600038: {
                return TVScreenBag2.tVOPTSEEKMAIN(this, n2);
            }
            case 2600021: {
                return TVScreenBag2.tVOPTSETTINGS(this, n2);
            }
            case 2600020: {
                return TVScreenBag2.tVOPTVISUALAUDIOMAIN(this, n2);
            }
            case 2600030: {
                return TVScreenBag2.tVOPTSOUNDCHANNELMAIN(this, n2);
            }
            case 2600035: {
                return TVScreenBag2.tVOPTTELETEXTDISCLAIMEROBSOLETE(this, n2);
            }
            case 2600034: {
                return TVScreenBag2.tVOPTTELETEXTMAIN(this, n2);
            }
            case 2600047: {
                return TVScreenBag2.tVOPTPICTUREMAIN(this, n2);
            }
            case 2600048: {
                return TVScreenBag2.tVOPTPICTUREBRIGHTNESS(this, n2);
            }
            case 2600049: {
                return TVScreenBag2.tVOPTPICTURECONTRAST(this, n2);
            }
            case 2600050: {
                return TVScreenBag2.tVOPTPICTURECOLOR(this, n2);
            }
            case 2600084: {
                return TVScreenBag2.tVOPTOPENSOURCEMAIN(this, n2);
            }
        }
        return this.createDefaultScreen(n, n2);
    }

    public AbstractWidgetController getRefWidget(int n, int n2, TVScreenFactory tVScreenFactory) {
        AbstractWidgetController abstractWidgetController = null;
        switch (n2) {
            case 0: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127, 127});
                iconController.setBounds(0, 0, 800, 480);
                abstractWidgetController = iconController;
                break;
            }
            case 1: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{27});
                iconController.setModelID(2600180);
                iconController.setBounds(0, 0, 800, 480);
                iconRendererHigh.setScaleMode(1);
                abstractWidgetController = iconController;
                break;
            }
            case 2: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{27});
                this.refWidgets[n][3] = iconController;
                iconController.setBounds(0, 0, 800, 480);
                iconController.setCoordinateSets(new int[]{3, 0, 0, 800, 480, 0, 0, 1440, 540});
                ContainerController containerController = new ContainerController();
                ContainerRendererHigh containerRendererHigh = new ContainerRendererHigh(containerController);
                containerController.setRenderer(containerRendererHigh);
                containerController.setBounds(0, 0, 0, 0);
                containerController.setScreenLayer(3);
                containerController.add(iconController);
                abstractWidgetController = containerController;
                break;
            }
            case 4: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{2600090});
                iconController.setBounds(0, 0, 100, 100);
                iconController.setCoordinateSets(new int[]{1, 0, 0, 100, 100, 0, 0, 100, 100});
                abstractWidgetController = iconController;
                break;
            }
            case 5: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{2600091});
                iconController.setBounds(0, 0, 100, 100);
                iconController.setCoordinateSets(new int[]{1, 0, 0, 100, 100, 0, 0, 100, 100});
                abstractWidgetController = iconController;
                break;
            }
            case 6: {
                VirtualButton virtualButton = new VirtualButton();
                virtualButton.setEvent(2600002);
                virtualButton.setBounds(0, 0, 100, 100);
                virtualButton.setEventConfiguration(1);
                abstractWidgetController = virtualButton;
                break;
            }
            case 7: {
                VirtualButton virtualButton = new VirtualButton();
                virtualButton.setEvent(2600035);
                virtualButton.setBounds(0, 0, 100, 100);
                virtualButton.setEventConfiguration(4);
                abstractWidgetController = virtualButton;
                break;
            }
            case 8: {
                VirtualButton virtualButton = new VirtualButton();
                virtualButton.setModelID(2600153);
                virtualButton.setBounds(0, 0, 100, 100);
                virtualButton.setConsumeEvents(false);
                virtualButton.setEventConfiguration(2047);
                virtualButton.setHandleKeyTurnedAsKeyPressed(true);
                abstractWidgetController = virtualButton;
                break;
            }
            case 9: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{2600092});
                iconController.setBounds(59, 371, 30, 30);
                iconController.setCoordinateSets(new int[]{1, 59, 371, 30, 30, 59, 371, 30, 30});
                abstractWidgetController = iconController;
                break;
            }
            case 10: {
                MenuMergeTimerController menuMergeTimerController = new MenuMergeTimerController();
                menuMergeTimerController.setBounds(0, 0, 100, 100);
                menuMergeTimerController.setIdleTime(3000);
                abstractWidgetController = menuMergeTimerController;
                break;
            }
            case 11: {
                ListController listController = new ListController();
                listController.setModelID(2600116);
                listController.setEvent(2600089);
                listController.setBounds(0, 0, 0, 0);
                listController.setColorIndices(new int[]{1, 0, 4, 2});
                listController.setGlassplateInsetsBottom(new int[0]);
                listController.setGlassplateInsetsTop(new int[0]);
                listController.setIdColumn(0);
                listController.setNoFocusAreasBottom(new int[0]);
                listController.setNoFocusAreasTop(new int[0]);
                listController.setPropertyColumn(1);
                listController.setDataAccess(new BaseListModelAccess());
                listController.setItemFactory(new ListItemFactory(){

                    public AbstractWidgetController createListItem(int n, ListCell[] listCellArray) {
                        switch (n) {
                            case 0: {
                                MenuItemController menuItemController = new MenuItemController();
                                menuItemController.setType(16);
                                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                                GridLayout gridLayout = new GridLayout();
                                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(3);
                                menuItemColumnsConstraints.gaps = new int[]{0, 15, 12, 0};
                                menuItemColumnsConstraints.grow = new float[]{0.0f, 1.0f, 0.0f};
                                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f, 0.0f};
                                menuItemColumnsConstraints.size = new int[]{30, -1, -1};
                                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                                AxisConstraints axisConstraints = new AxisConstraints(1);
                                axisConstraints.alignment = new int[]{5};
                                gridLayout.setRowConstraints(axisConstraints);
                                AbstractWidgetController abstractWidgetController = this.createCell(0);
                                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                                AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
                                AbstractWidgetController abstractWidgetController3 = this.createCell(2);
                                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(2, 0);
                                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2, gridLayoutHints3}, new Object[]{abstractWidgetController, abstractWidgetController2, abstractWidgetController3});
                                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                                menuItemController.add(abstractWidgetController);
                                menuItemController.add(abstractWidgetController2);
                                menuItemController.add(abstractWidgetController3);
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
                                IconController iconController = new IconController();
                                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                                iconController.setRenderer(iconRendererHigh);
                                iconController.setBitmaps(new int[]{127, 2600000});
                                iconController.setModelColumn(4);
                                iconController.setPreferredHeight(1);
                                iconRendererHigh.setAlignment(1, 5);
                                return iconController;
                            }
                            case 1: {
                                LabelController labelController = new LabelController();
                                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                                labelController.setRenderer(highlightingLabelRendererHigh);
                                labelController.setModelColumn(0);
                                return labelController;
                            }
                            case 2: {
                                IconController iconController = new IconController();
                                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                                iconController.setRenderer(iconRendererHigh);
                                iconController.setBitmaps(new int[]{127, 127, 2600016, 2600017, 2600018, 2600015, 2600019, 2600020, 2600027, 2600021, 2600022, 2600094, 2600095, 127, 127, 127});
                                iconController.setModelColumn(3);
                                iconController.setPreferredHeight(1);
                                iconRendererHigh.setAlignment(1, 5);
                                return iconController;
                            }
                        }
                        return null;
                    }
                });
                abstractWidgetController = listController;
                break;
            }
            case 12: {
                IdleTimerController idleTimerController = new IdleTimerController();
                idleTimerController.setModelID(2600169);
                this.refWidgets[n][13] = idleTimerController;
                idleTimerController.setBounds(0, 0, 100, 100);
                idleTimerController.setFireWhenOptionDrawerOpen(false);
                idleTimerController.setFireWhenSelectionDrawerOpen(false);
                idleTimerController.setIdleTimeout(2500);
                idleTimerController.setStartTimerAutomatically(true);
                TouchMediaHandler touchMediaHandler = new TouchMediaHandler();
                touchMediaHandler.setModelID(2600106);
                this.refWidgets[n][14] = touchMediaHandler;
                touchMediaHandler.setBounds(0, 0, 100, 100);
                ModelStubController modelStubController = new ModelStubController();
                modelStubController.setModelID(2600089);
                this.refWidgets[n][16] = modelStubController;
                modelStubController.setBounds(0, 0, 100, 100);
                ModelStubController modelStubController2 = new ModelStubController();
                modelStubController2.setModelID(2600157);
                this.refWidgets[n][17] = modelStubController2;
                modelStubController2.setBounds(0, 0, 100, 100);
                ModelStubController modelStubController3 = new ModelStubController();
                modelStubController3.setModelID(2600158);
                this.refWidgets[n][18] = modelStubController3;
                modelStubController3.setBounds(0, 0, 100, 100);
                SpellerController spellerController = SpellerControllerFactory.create();
                SpellerRendererEuropeHigh spellerRendererEuropeHigh = SpellerRendererHighFactory.create(spellerController);
                spellerController.setRenderer(spellerRendererEuropeHigh);
                spellerController.setBitmaps(new int[]{421, 84, 85, 86, 87, 88, 89, 424, 425, 90, 91, 92, 93, 94, 95, 2600086, 2600087, 98, 99, 187, 188, 189, 190, 473, 473, 475, 476, 475, 475, 479, 480, 479, 479, 486, 487, 488, 489, 490, 491, 492, 493, 494, 495, 496, 497});
                spellerRendererEuropeHigh.setFonts(tVScreenFactory.getFonts(2, n));
                spellerController.setColorIndices(new int[]{2, 0, 4, 0});
                OperationPanelController operationPanelController = new OperationPanelController();
                OperationPanelRendererHigh operationPanelRendererHigh = new OperationPanelRendererHigh(operationPanelController);
                operationPanelController.setRenderer(operationPanelRendererHigh);
                operationPanelController.setBitmaps(new int[]{2600060, 2600061, 2600062, 2600063, 2600064, 2600065, 2600066, 2600067, 2600068, 2600069, 2600070, 2600071, 2600072, 2600073, 2600074, 2600075, 2600076, 2600077, 2600078, 2600079, 2600080, 2600081, 2600082, 2600083, 2600084, 2600085, 2600097, 2600098, 2600099});
                operationPanelController.setModelID(2600156);
                this.refWidgets[n][15] = operationPanelController;
                operationPanelController.setBounds(0, 0, 100, 100);
                operationPanelController.setCoordinateSets(new int[]{1, 0, 0, 100, 100, 0, 0, 100, 100});
                operationPanelController.setPositions(new int[]{14, 3, 772, 3});
                operationPanelController.add(modelStubController);
                operationPanelController.add(modelStubController2);
                operationPanelController.add(modelStubController3);
                operationPanelController.add(spellerController);
                VirtualButton virtualButton = new VirtualButton();
                virtualButton.setModelID(2600177);
                virtualButton.setEvent(2600093);
                this.refWidgets[n][19] = virtualButton;
                virtualButton.setBounds(0, 0, 100, 100);
                virtualButton.setEventConfiguration(2);
                VirtualButton virtualButton2 = new VirtualButton();
                virtualButton2.setModelID(2600196);
                virtualButton2.setEvent(2600093);
                this.refWidgets[n][20] = virtualButton2;
                virtualButton2.setBounds(0, 0, 100, 100);
                virtualButton2.setEventConfiguration(8);
                virtualButton2.setJoystickDirectionBlocked(new boolean[]{true, true, true, true, true, true, true, true, false});
                VirtualButton virtualButton3 = new VirtualButton();
                virtualButton3.setModelID(2600188);
                virtualButton3.setEvent(1750);
                this.refWidgets[n][21] = virtualButton3;
                virtualButton3.setBounds(0, 0, 100, 100);
                virtualButton3.setEventConfiguration(64);
                VirtualButton virtualButton4 = new VirtualButton();
                virtualButton4.setModelID(2600106);
                this.refWidgets[n][22] = virtualButton4;
                virtualButton4.setBounds(0, 0, 100, 100);
                virtualButton4.setEventConfiguration(4);
                ContainerController containerController = new ContainerController();
                ContainerRendererHigh containerRendererHigh = new ContainerRendererHigh(containerController);
                containerController.setRenderer(containerRendererHigh);
                containerController.setBounds(0, 0, 100, 100);
                containerController.setEntertainmentMenuTransformation(12.0f, 12.0f, 0.96f, 0.96f, 0.5f);
                containerController.setOpacitySet(1.0f, 0.4f);
                containerController.setOptionMenuTransformation(-4.0f, 7.0f, 0.6f, 0.6f, 0.5f);
                containerController.setSelectionMenuTransformation(318.0f, 7.0f, 0.58f, 0.6f, 0.25f);
                containerController.add(idleTimerController);
                containerController.add(touchMediaHandler);
                containerController.add(operationPanelController);
                containerController.add(virtualButton);
                containerController.add(virtualButton2);
                containerController.add(virtualButton3);
                containerController.add(virtualButton4);
                abstractWidgetController = containerController;
                break;
            }
            case 23: {
                SmallStageApplicationIconController smallStageApplicationIconController = new SmallStageApplicationIconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(smallStageApplicationIconController);
                smallStageApplicationIconController.setRenderer(iconRendererHigh);
                smallStageApplicationIconController.setBitmaps(new int[]{27});
                smallStageApplicationIconController.setBounds(0, 0, 800, 480);
                smallStageApplicationIconController.setCoordinateSets(new int[]{2, 0, 0, 800, 480, 0, 0, 1440, 540});
                ContainerController containerController = new ContainerController();
                ContainerRendererHigh containerRendererHigh = new ContainerRendererHigh(containerController);
                containerController.setRenderer(containerRendererHigh);
                containerController.setBounds(0, 1, 0, 0);
                containerController.setEntertainmentMenuTransformation(12.0f, 12.0f, 0.96f, 0.96f, 0.0f);
                containerController.setHideSmallStageContentOnSelectionDrawer(false);
                containerController.setNoScreenChangeAnimation(true);
                containerController.setScreenLayer(3);
                containerController.setSelectionMenuTransformation(0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                containerController.add(smallStageApplicationIconController);
                abstractWidgetController = containerController;
                break;
            }
            case 24: {
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
                this.refWidgets[n][25] = smallStageApplicationIconController2;
                smallStageApplicationIconController2.setBounds(646, 325, 140, 140);
                smallStageApplicationIconController2.setCoordinateSets(new int[]{2, 646, 325, 140, 140, 666, 240, 100, 100});
                iconRendererHigh2.setScaleFactor(2.0f, 2.0f);
                iconRendererHigh2.setScaleMode(2);
                ContainerController containerController = new ContainerController();
                ContainerRendererHigh containerRendererHigh = new ContainerRendererHigh(containerController);
                containerController.setRenderer(containerRendererHigh);
                containerController.setBounds(0, 0, 0, 0);
                containerController.setSelectionMenuTransformation(615.0f, 70.0f, 0.6f, 0.6f, 0.0f);
                containerController.add(smallStageApplicationIconController);
                containerController.add(smallStageApplicationIconController2);
                abstractWidgetController = containerController;
                break;
            }
            case 26: {
                SmallStageApplicationIconController smallStageApplicationIconController = new SmallStageApplicationIconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(smallStageApplicationIconController);
                smallStageApplicationIconController.setRenderer(iconRendererHigh);
                smallStageApplicationIconController.setBitmaps(new int[]{27});
                smallStageApplicationIconController.setBounds(0, 0, 800, 480);
                smallStageApplicationIconController.setCoordinateSets(new int[]{2, 0, 0, 800, 480, 0, 0, 1440, 540});
                SmallStageApplicationIconController smallStageApplicationIconController3 = new SmallStageApplicationIconController();
                IconRendererHigh iconRendererHigh3 = new IconRendererHigh(smallStageApplicationIconController3);
                smallStageApplicationIconController3.setRenderer(iconRendererHigh3);
                smallStageApplicationIconController3.setBitmaps(new int[]{127, 127, 127, 127, 127, 127, 127, 127, 127, 127});
                smallStageApplicationIconController3.setModelID(138);
                this.refWidgets[n][27] = smallStageApplicationIconController3;
                smallStageApplicationIconController3.setBounds(646, 325, 140, 140);
                smallStageApplicationIconController3.setCoordinateSets(new int[]{2, 646, 325, 140, 140, 666, 240, 100, 100});
                iconRendererHigh3.setScaleFactor(2.0f, 2.0f);
                iconRendererHigh3.setScaleMode(2);
                ContainerController containerController = new ContainerController();
                ContainerRendererHigh containerRendererHigh = new ContainerRendererHigh(containerController);
                containerController.setRenderer(containerRendererHigh);
                containerController.setBounds(0, 0, 0, 0);
                containerController.setEntertainmentMenuTransformation(12.0f, 12.0f, 0.96f, 0.96f, 0.0f);
                containerController.add(smallStageApplicationIconController);
                containerController.add(smallStageApplicationIconController3);
                abstractWidgetController = containerController;
                break;
            }
            case 28: {
                SmallStageApplicationIconController smallStageApplicationIconController = new SmallStageApplicationIconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(smallStageApplicationIconController);
                smallStageApplicationIconController.setRenderer(iconRendererHigh);
                smallStageApplicationIconController.setBitmaps(new int[]{127});
                smallStageApplicationIconController.setBounds(389, 109, 682, 314);
                smallStageApplicationIconController.setCoordinateSets(new int[]{2, 389, 109, 682, 314, 529, 126, 404, 181});
                iconRendererHigh.setScaleMode(3);
                SmallStageApplicationIconController smallStageApplicationIconController4 = new SmallStageApplicationIconController();
                IconRendererHigh iconRendererHigh4 = new IconRendererHigh(smallStageApplicationIconController4);
                smallStageApplicationIconController4.setRenderer(iconRendererHigh4);
                smallStageApplicationIconController4.setBitmaps(new int[]{127, 127, 127, 127, 127, 127, 127, 127, 127, 127});
                smallStageApplicationIconController4.setModelID(138);
                this.refWidgets[n][29] = smallStageApplicationIconController4;
                smallStageApplicationIconController4.setBounds(646, 325, 140, 140);
                smallStageApplicationIconController4.setCoordinateSets(new int[]{2, 646, 325, 140, 140, 666, 240, 100, 100});
                iconRendererHigh4.setScaleFactor(2.0f, 2.0f);
                iconRendererHigh4.setScaleMode(2);
                ContainerController containerController = new ContainerController();
                ContainerRendererHigh containerRendererHigh = new ContainerRendererHigh(containerController);
                containerController.setRenderer(containerRendererHigh);
                containerController.setBounds(0, 0, 0, 0);
                containerController.setEntertainmentMenuTransformation(12.0f, 12.0f, 0.96f, 0.96f, 0.0f);
                containerController.add(smallStageApplicationIconController);
                containerController.add(smallStageApplicationIconController4);
                abstractWidgetController = containerController;
                break;
            }
            case 30: {
                SmallStageApplicationIconController smallStageApplicationIconController = new SmallStageApplicationIconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(smallStageApplicationIconController);
                smallStageApplicationIconController.setRenderer(iconRendererHigh);
                smallStageApplicationIconController.setBitmaps(new int[]{127, 127, 127, 127, 127, 127, 127, 127, 127, 127});
                smallStageApplicationIconController.setModelID(138);
                this.refWidgets[n][31] = smallStageApplicationIconController;
                smallStageApplicationIconController.setBounds(646, 325, 140, 140);
                smallStageApplicationIconController.setCoordinateSets(new int[]{2, 646, 325, 140, 140, 666, 240, 100, 100});
                iconRendererHigh.setScaleFactor(2.0f, 2.0f);
                iconRendererHigh.setScaleMode(2);
                ContainerController containerController = new ContainerController();
                ContainerRendererHigh containerRendererHigh = new ContainerRendererHigh(containerController);
                containerController.setRenderer(containerRendererHigh);
                containerController.setBounds(0, 0, 0, 0);
                containerController.setEntertainmentMenuTransformation(12.0f, 12.0f, 0.96f, 0.96f, 0.0f);
                containerController.add(smallStageApplicationIconController);
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

    protected static final boolean evalCond2600000(int n) {
        return ((BaseListModel)TVScreenFactory.getModel(2600000, n)).getLength() > 0 && ((SpellerModel)TVScreenFactory.getModel(2600114, n)).getStatus() == 0;
    }

    protected static final boolean evalCond2600035(int n) {
        return ((BaseListModel)TVScreenFactory.getModel(2600045, n)).getLength() > 0 && ((SpellerModel)TVScreenFactory.getModel(2600114, n)).getStatus() == 0;
    }

    protected static final boolean evalCond2600103(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600057, n)).getValue() == 1;
    }

    protected static final boolean evalCond2600104(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600084, n)).getValue() == 1;
    }

    protected static final boolean evalCond2600105(int n) {
        return !(((ChoiceModel)TVScreenFactory.getModel(2600040, n)).getValue() == 0 && ((BaseListModel)TVScreenFactory.getModel(2600000, n)).getLength() > 0 || ((ChoiceModel)TVScreenFactory.getModel(2600040, n)).getValue() == 1 && ((BaseListModel)TVScreenFactory.getModel(2600045, n)).getLength() > 0 || ((ChoiceModel)TVScreenFactory.getModel(379, n)).getValue() == 1);
    }

    protected static final boolean evalCond2600106(int n) {
        return (((ChoiceModel)TVScreenFactory.getModel(2600040, n)).getValue() == 0 && ((BaseListModel)TVScreenFactory.getModel(2600000, n)).getLength() > 0 || ((ChoiceModel)TVScreenFactory.getModel(2600040, n)).getValue() == 1 && ((BaseListModel)TVScreenFactory.getModel(2600045, n)).getLength() > 0) && ((ChoiceModel)TVScreenFactory.getModel(379, n)).getValue() != 1;
    }

    protected static final boolean evalCond2600107(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600040, n)).getValue() == 1 && ((ChoiceModel)TVScreenFactory.getModel(2600026, n)).getValue() == 0;
    }

    protected static final boolean evalCond2600108(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600040, n)).getValue() == 0 && ((ChoiceModel)TVScreenFactory.getModel(2600026, n)).getValue() == 0;
    }

    protected static final boolean evalCond2600109(int n) {
        return ((BaseListModel)TVScreenFactory.getModel(2600000, n)).getLength() > 0;
    }

    protected static final boolean evalCond2600110(int n) {
        return ((BaseListModel)TVScreenFactory.getModel(2600000, n)).getLength() == 0;
    }

    protected static final boolean evalCond2600111(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600040, n)).getValue() == 0 && ((ChoiceModel)TVScreenFactory.getModel(2600026, n)).getValue() == 0;
    }

    protected static final boolean evalCond2600112(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600040, n)).getValue() == 1 && ((ChoiceModel)TVScreenFactory.getModel(2600026, n)).getValue() == 0;
    }

    protected static final boolean evalCond2600113(int n) {
        return ((BaseListModel)TVScreenFactory.getModel(2600045, n)).getLength() > 0;
    }

    protected static final boolean evalCond2600114(int n) {
        return ((BaseListModel)TVScreenFactory.getModel(2600045, n)).getLength() == 0;
    }

    protected static final boolean evalCond2600151(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600026, n)).getValue() == 1 && ((ChoiceModel)TVScreenFactory.getModel(2600054, n)).getValue() == 1;
    }

    protected static final boolean evalCond2600152(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600026, n)).getValue() == 0 && ((ChoiceModel)TVScreenFactory.getModel(2600062, n)).getValue() == 1;
    }

    protected static final boolean evalCond2600347(int n) {
        return ((LabelModel)TVScreenFactory.getModel(2600042, n)).getLength() == 0;
    }

    protected static final boolean evalCond2600348(int n) {
        return ((LabelModel)TVScreenFactory.getModel(2600042, n)).getLength() != 0;
    }

    protected static final boolean evalCond2600349(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600056, n)).getValue() == 1;
    }

    protected static final boolean evalCond2600351(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600016, n)).getValue() == 1 || ((ChoiceModel)TVScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)TVScreenFactory.getModel(5618, n)).getValue() == 1;
    }

    protected static final boolean evalCond2600352(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600016, n)).getValue() == 1 || ((ChoiceModel)TVScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)TVScreenFactory.getModel(5618, n)).getValue() == 1;
    }

    protected static final boolean evalCond2600353(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600016, n)).getValue() == 1 || ((ChoiceModel)TVScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)TVScreenFactory.getModel(5618, n)).getValue() == 1;
    }

    protected static final boolean evalCond2600354(int n) {
        return ((BaseListModel)TVScreenFactory.getModel(2600031, n)).getLength() == 0;
    }

    protected static final boolean evalCond2600355(int n) {
        return ((BaseListModel)TVScreenFactory.getModel(2600031, n)).getLength() > 0;
    }

    protected static final boolean evalCond2600426(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600053, n)).getValue() == 1 && ((BaseListModel)TVScreenFactory.getModel(2600031, n)).getLength() == 0;
    }

    protected static final boolean evalCond2600427(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600053, n)).getValue() == 1 && ((BaseListModel)TVScreenFactory.getModel(2600031, n)).getLength() > 0;
    }

    protected static final boolean evalCond2600428(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600059, n)).getValue() == 1;
    }

    protected static final boolean evalCond2600429(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600060, n)).getValue() == 1;
    }

    protected static final boolean evalCond2600430(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600061, n)).getValue() == 1;
    }

    protected static final boolean evalCond2600431(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600063, n)).getValue() == 1;
    }

    protected static final boolean evalCond2600434(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600080, n)).getValue() == 1 || ((ChoiceModel)TVScreenFactory.getModel(2600183, n)).getValue() == 0 || ((ChoiceModel)TVScreenFactory.getModel(2600101, n)).getValue() == 0 && (((ChoiceModel)TVScreenFactory.getModel(2600016, n)).getValue() == 1 || ((ChoiceModel)TVScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)TVScreenFactory.getModel(5618, n)).getValue() == 1);
    }

    protected static final boolean evalCond2600435(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600101, n)).getValue() == 1;
    }

    protected static final boolean evalCond2600436(int n) {
        return ((SpellerModel)TVScreenFactory.getModel(2600114, n)).getStatus() == 2;
    }

    protected static final boolean evalCond2600437(int n) {
        return ((SysConstModel)TVScreenFactory.getModel(523, n)).getValue() == 1;
    }

    protected static final boolean evalCond2600438(int n) {
        return ((SpellerModel)TVScreenFactory.getModel(2600114, n)).getStatus() == 2;
    }

    protected static final boolean evalCond2600439(int n) {
        return ((SysConstModel)TVScreenFactory.getModel(523, n)).getValue() == 1;
    }

    protected static final boolean evalCond2600440(int n) {
        return ((SysConstModel)TVScreenFactory.getModel(523, n)).getValue() == 1 && ((BaseListModel)TVScreenFactory.getModel(2600116, n)).getLength() > 0 && ((SpellerModel)TVScreenFactory.getModel(2600114, n)).getStatus() == 3;
    }

    protected static final boolean evalCond2600517(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600121, n)).getValue() == 1;
    }

    protected static final boolean evalCond2600518(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600121, n)).getValue() == 1;
    }

    protected static final boolean evalCond2600562(int n) {
        return ((MetricsModel)TVScreenFactory.getModel(2600109, n)).getStatus() == 0 || ((MetricsModel)TVScreenFactory.getModel(2600108, n)).getStatus() == 0;
    }

    protected static final boolean evalCond2600563(int n) {
        return ((MetricsModel)TVScreenFactory.getModel(2600109, n)).getStatus() == 0 || ((MetricsModel)TVScreenFactory.getModel(2600108, n)).getStatus() == 0;
    }

    protected static final boolean evalCond2600564(int n) {
        return ((MetricsModel)TVScreenFactory.getModel(2600109, n)).getStatus() == 0 || ((MetricsModel)TVScreenFactory.getModel(2600108, n)).getStatus() == 0;
    }

    protected static final boolean evalCond2600565(int n) {
        return ((MetricsModel)TVScreenFactory.getModel(2600109, n)).getStatus() == 0 || ((MetricsModel)TVScreenFactory.getModel(2600108, n)).getStatus() == 0;
    }

    protected static final boolean evalCond2600818(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600101, n)).getValue() == 1 || ((ChoiceModel)TVScreenFactory.getModel(2600101, n)).getValue() == 2;
    }

    protected static final boolean evalCond2600926(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600160, n)).getValue() == 1;
    }

    protected static final boolean evalCond2600997(int n) {
        return ((SpellerModel)TVScreenFactory.getModel(2600114, n)).getStatus() == 0;
    }

    protected static final boolean evalCond2600998(int n) {
        return ((SpellerModel)TVScreenFactory.getModel(2600114, n)).getStatus() != 0;
    }

    protected static final boolean evalCond2600999(int n) {
        return ((SpellerModel)TVScreenFactory.getModel(2600114, n)).getStatus() == 0;
    }

    protected static final boolean evalCond2601000(int n) {
        return ((SpellerModel)TVScreenFactory.getModel(2600114, n)).getStatus() != 0;
    }

    protected static final boolean evalCond2601021(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600166, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601040(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(379, n)).getValue() == 1 && ((ChoiceModel)TVScreenFactory.getModel(8, n)).getValue() == 2;
    }

    protected static final boolean evalCond2601041(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(379, n)).getValue() == 1;
    }

    protected static final boolean evalCond2601042(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(379, n)).getValue() == 1;
    }

    protected static final boolean evalCond2601043(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(379, n)).getValue() == 1;
    }

    protected static final boolean evalCond2601044(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(379, n)).getValue() == 1;
    }

    protected static final boolean evalCond2601045(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(379, n)).getValue() != 1;
    }

    protected static final boolean evalCond2601046(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(379, n)).getValue() == 1;
    }

    protected static final boolean evalCond2601048(int n) {
        return ((BaseListModel)TVScreenFactory.getModel(2600000, n)).getLength() != 0 || ((SpellerModel)TVScreenFactory.getModel(2600114, n)).getStatus() != 0;
    }

    protected static final boolean evalCond2601049(int n) {
        return ((BaseListModel)TVScreenFactory.getModel(2600000, n)).getLength() == 0 && ((SpellerModel)TVScreenFactory.getModel(2600114, n)).getStatus() == 0;
    }

    protected static final boolean evalCond2601050(int n) {
        return ((BaseListModel)TVScreenFactory.getModel(2600000, n)).getLength() != 0 || ((SpellerModel)TVScreenFactory.getModel(2600114, n)).getStatus() != 0;
    }

    protected static final boolean evalCond2601051(int n) {
        return (((BaseListModel)TVScreenFactory.getModel(2600000, n)).getLength() != 0 || ((SpellerModel)TVScreenFactory.getModel(2600114, n)).getStatus() != 0) && ((SpellerModel)TVScreenFactory.getModel(2600114, n)).getStatus() == 0;
    }

    protected static final boolean evalCond2601052(int n) {
        return ((BaseListModel)TVScreenFactory.getModel(2600045, n)).getLength() != 0 || ((SpellerModel)TVScreenFactory.getModel(2600114, n)).getStatus() != 0;
    }

    protected static final boolean evalCond2601053(int n) {
        return ((BaseListModel)TVScreenFactory.getModel(2600045, n)).getLength() == 0 && ((SpellerModel)TVScreenFactory.getModel(2600114, n)).getStatus() == 0;
    }

    protected static final boolean evalCond2601054(int n) {
        return ((BaseListModel)TVScreenFactory.getModel(2600045, n)).getLength() != 0 || ((SpellerModel)TVScreenFactory.getModel(2600114, n)).getStatus() != 0;
    }

    protected static final boolean evalCond2601055(int n) {
        return (((BaseListModel)TVScreenFactory.getModel(2600045, n)).getLength() != 0 || ((SpellerModel)TVScreenFactory.getModel(2600114, n)).getStatus() != 0) && ((SpellerModel)TVScreenFactory.getModel(2600114, n)).getStatus() == 0;
    }

    protected static final boolean evalCond2601136(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600101, n)).getValue() == 2;
    }

    protected static final boolean evalCond2601181(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600176, n)).getValue() == 1 && ((ChoiceModel)TVScreenFactory.getModel(2600101, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601276(int n) {
        return (((ChoiceModel)TVScreenFactory.getModel(335, n)).getValue() == 2 || ((ChoiceModel)TVScreenFactory.getModel(335, n)).getValue() == 3 || ((ChoiceModel)TVScreenFactory.getModel(335, n)).getValue() == 8 || ((ChoiceModel)TVScreenFactory.getModel(335, n)).getValue() == 9) && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601278(int n) {
        return (((ChoiceModel)TVScreenFactory.getModel(335, n)).getValue() == 2 || ((ChoiceModel)TVScreenFactory.getModel(335, n)).getValue() == 3 || ((ChoiceModel)TVScreenFactory.getModel(335, n)).getValue() == 8 || ((ChoiceModel)TVScreenFactory.getModel(335, n)).getValue() == 9) && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601279(int n) {
        return (((SysConstModel)TVScreenFactory.getModel(442, n)).getValue() == 0 && ((SysConstModel)TVScreenFactory.getModel(4306, n)).getValue() == 0 || ((SysConstModel)TVScreenFactory.getModel(442, n)).getValue() == 6) && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601280(int n) {
        return ((SysConstModel)TVScreenFactory.getModel(4306, n)).getValue() == 1 && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601281(int n) {
        return ((SysConstModel)TVScreenFactory.getModel(442, n)).getValue() == 2 && (((ChoiceModel)TVScreenFactory.getModel(1100194, n)).getValue() == 14 || ((ChoiceModel)TVScreenFactory.getModel(1100194, n)).getValue() == 15) && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601282(int n) {
        return ((SysConstModel)TVScreenFactory.getModel(442, n)).getValue() == 2 && ((ChoiceModel)TVScreenFactory.getModel(1100194, n)).getValue() == 23 && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601283(int n) {
        return ((SysConstModel)TVScreenFactory.getModel(442, n)).getValue() == 5 && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601284(int n) {
        return ((SysConstModel)TVScreenFactory.getModel(442, n)).getValue() == 3 && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601285(int n) {
        return ((SysConstModel)TVScreenFactory.getModel(442, n)).getValue() == 4 && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601286(int n) {
        return (((ChoiceModel)TVScreenFactory.getModel(4076, n)).getValue() == 5 || ((ChoiceModel)TVScreenFactory.getModel(4076, n)).getValue() == 6 || ((ChoiceModel)TVScreenFactory.getModel(4076, n)).getValue() == 15) && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601287(int n) {
        return (((ChoiceModel)TVScreenFactory.getModel(4076, n)).getValue() == 5 || ((ChoiceModel)TVScreenFactory.getModel(4076, n)).getValue() == 6 || ((ChoiceModel)TVScreenFactory.getModel(4076, n)).getValue() == 15) && ((ChoiceModel)TVScreenFactory.getModel(4494, n)).getValue() != 1 && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601288(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(377, n)).getValue() == 1 && (((ChoiceModel)TVScreenFactory.getModel(1000019, n)).getValue() == 1 || ((ChoiceModel)TVScreenFactory.getModel(377, n)).getValue() != 1) && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601289(int n) {
        return ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)TVScreenFactory.getModel(377, n)).getValue() == 1;
    }

    protected static final boolean evalCond2601290(int n) {
        return ((BaseListModel)TVScreenFactory.getModel(2600045, n)).getLength() <= 49 && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601291(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600159, n)).getValue() != 1 && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0 && ((BaseListModel)TVScreenFactory.getModel(2600045, n)).getLength() > 1;
    }

    protected static final boolean evalCond2601292(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600159, n)).getValue() != 1 && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)TVScreenFactory.getModel(2600040, n)).getValue() == 1;
    }

    protected static final boolean evalCond2601293(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600159, n)).getValue() != 1 && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)TVScreenFactory.getModel(2600040, n)).getValue() == 1;
    }

    protected static final boolean evalCond2601294(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600159, n)).getValue() != 1 && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)TVScreenFactory.getModel(2600040, n)).getValue() == 1;
    }

    protected static final boolean evalCond2601295(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(3913, n)).getValue() == 1 && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601296(int n) {
        return (((ChoiceModel)TVScreenFactory.getModel(5592, n)).getValue() != 1 || ((ChoiceModel)TVScreenFactory.getModel(5583, n)).getValue() != 1) && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)TVScreenFactory.getModel(2600080, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601297(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600068, n)).getValue() == 1 && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601298(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600070, n)).getValue() == 1 && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601299(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600066, n)).getValue() == 1 && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601300(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600083, n)).getValue() == 1 && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601301(int n) {
        return ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)TVScreenFactory.getModel(2600058, n)).getValue() == 1;
    }

    protected static final boolean evalCond2601302(int n) {
        return ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)TVScreenFactory.getModel(2600055, n)).getValue() == 1;
    }

    protected static final boolean evalCond2601306(int n) {
        return ((MetricsModel)TVScreenFactory.getModel(2600109, n)).getStatus() == 0 || ((MetricsModel)TVScreenFactory.getModel(2600108, n)).getStatus() == 0;
    }

    protected static final boolean evalCond2601307(int n) {
        return ((ButtonModel)TVScreenFactory.getModel(2600122, n)).getStatus() == 0;
    }

    protected static final boolean evalCond2601308(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600032, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601309(int n) {
        return ((BaseListModel)TVScreenFactory.getModel(2600033, n)).getLength() == 0;
    }

    protected static final boolean evalCond2601310(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600037, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601311(int n) {
        return ((LabelModel)TVScreenFactory.getModel(2600088, n)).getLength() == 0;
    }

    protected static final boolean evalCond2601312(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600166, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601313(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(379, n)).getValue() == 1;
    }

    protected static final boolean evalCond2601314(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(379, n)).getValue() == 1;
    }

    protected static final boolean evalCond2601315(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(379, n)).getValue() != 1;
    }

    protected static final boolean evalCond2601316(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(379, n)).getValue() == 1;
    }

    protected static final boolean evalCond2601317(int n) {
        return (((ChoiceModel)TVScreenFactory.getModel(2600040, n)).getValue() == 0 && ((BaseListModel)TVScreenFactory.getModel(2600000, n)).getLength() > 0 || ((ChoiceModel)TVScreenFactory.getModel(2600040, n)).getValue() == 1 && ((BaseListModel)TVScreenFactory.getModel(2600045, n)).getLength() > 0) && ((ChoiceModel)TVScreenFactory.getModel(379, n)).getValue() != 1;
    }

    protected static final boolean evalCond2601318(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600026, n)).getValue() == 1;
    }

    protected static final boolean evalCond2601319(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600026, n)).getValue() == 1;
    }

    protected static final boolean evalCond2601320(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600026, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601321(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600026, n)).getValue() == 1;
    }

    protected static final boolean evalCond2601327(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600026, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601328(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600026, n)).getValue() == 1;
    }

    protected static final boolean evalCond2601329(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(1100244, n)).getValue() != 0 && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601332(int n) {
        return ((SysConstModel)TVScreenFactory.getModel(442, n)).getValue() != 1 && (((ChoiceModel)TVScreenFactory.getModel(5606, n)).getValue() != 1 && ((ChoiceModel)TVScreenFactory.getModel(5602, n)).getValue() != 1 || ((ChoiceModel)TVScreenFactory.getModel(5583, n)).getValue() != 1) && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601333(int n) {
        return ((SysConstModel)TVScreenFactory.getModel(442, n)).getValue() != 1 && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601334(int n) {
        return ((ButtonModel)TVScreenFactory.getModel(2600122, n)).getStatus() != 0;
    }

    protected static final boolean evalCond2601337(int n) {
        return !(((ChoiceModel)TVScreenFactory.getModel(335, n)).getValue() != 2 && ((ChoiceModel)TVScreenFactory.getModel(335, n)).getValue() != 3 && ((ChoiceModel)TVScreenFactory.getModel(335, n)).getValue() != 8 && ((ChoiceModel)TVScreenFactory.getModel(335, n)).getValue() != 9 || ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() != 0 || ((ChoiceModel)TVScreenFactory.getModel(5583, n)).getValue() == 1 && ((ChoiceModel)TVScreenFactory.getModel(5600, n)).getValue() == 1);
    }

    protected static final boolean evalCond2601341(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600065, n)).getValue() == 1 && ((SysConstModel)TVScreenFactory.getModel(442, n)).getValue() != 3 && ((SysConstModel)TVScreenFactory.getModel(442, n)).getValue() != 2 && ((SysConstModel)TVScreenFactory.getModel(442, n)).getValue() != 4 && ((SysConstModel)TVScreenFactory.getModel(442, n)).getValue() != 5;
    }

    protected static final boolean evalCond2601342(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(2600065, n)).getValue() == 0 || ((SysConstModel)TVScreenFactory.getModel(442, n)).getValue() == 3 || ((SysConstModel)TVScreenFactory.getModel(442, n)).getValue() == 2 || ((SysConstModel)TVScreenFactory.getModel(442, n)).getValue() == 4 || ((SysConstModel)TVScreenFactory.getModel(442, n)).getValue() == 5;
    }

    protected static final boolean evalCond2601382(int n) {
        return (((ChoiceModel)TVScreenFactory.getModel(5592, n)).getValue() != 1 || ((ChoiceModel)TVScreenFactory.getModel(5583, n)).getValue() != 1) && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601383(int n) {
        return (((ChoiceModel)TVScreenFactory.getModel(5592, n)).getValue() != 1 || ((ChoiceModel)TVScreenFactory.getModel(5583, n)).getValue() != 1) && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601384(int n) {
        return (((ChoiceModel)TVScreenFactory.getModel(5592, n)).getValue() != 1 || ((ChoiceModel)TVScreenFactory.getModel(5583, n)).getValue() != 1) && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601385(int n) {
        return (((ChoiceModel)TVScreenFactory.getModel(5592, n)).getValue() != 1 || ((ChoiceModel)TVScreenFactory.getModel(5583, n)).getValue() != 1) && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601386(int n) {
        return (((ChoiceModel)TVScreenFactory.getModel(5592, n)).getValue() != 1 || ((ChoiceModel)TVScreenFactory.getModel(5583, n)).getValue() != 1) && ((SysConstModel)TVScreenFactory.getModel(3939, n)).getValue() == 0;
    }

    protected static final boolean evalCond2601396(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(5592, n)).getValue() == 1 && ((ChoiceModel)TVScreenFactory.getModel(5583, n)).getValue() == 1;
    }

    protected static final boolean evalCond2601397(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(5592, n)).getValue() == 1 && ((ChoiceModel)TVScreenFactory.getModel(5583, n)).getValue() == 1;
    }

    protected static final boolean evalCond2601398(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(5592, n)).getValue() == 1 && ((ChoiceModel)TVScreenFactory.getModel(5583, n)).getValue() == 1;
    }

    protected static final boolean evalCond2601399(int n) {
        return ((ChoiceModel)TVScreenFactory.getModel(5592, n)).getValue() == 1 && ((ChoiceModel)TVScreenFactory.getModel(5583, n)).getValue() == 1;
    }

    public void executeCondition(int n, int n2, HMIView[] hMIViewArray, int n3) {
        switch (n2) {
            case 2600001: {
                this.executeConditiontVAUDIOScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600018: {
                this.executeConditiontVAVFULLSCREENScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600083: {
                this.executeConditiontVAVFULLSCREENDISCLAIMERScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600009: {
                this.executeConditiontVCASDISCLAIMERSECONDScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600006: {
                this.executeConditiontVCHANNELMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600042: {
                this.executeConditiontVFAVORITEMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600005: {
                this.executeConditiontVFULLSCREENMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600010: {
                this.executeConditiontVFULLSCREENMOVIERATINGScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600036: {
                this.executeConditiontVOPTScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600032: {
                this.executeConditiontVOPTCASIDMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600012: {
                this.executeConditiontVOPTDATABROADCASTMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600033: {
                this.executeConditiontVOPTENGINEERINGMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600011: {
                this.executeConditiontVOPTEPGMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600084: {
                this.executeConditiontVOPTOPENSOURCEMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600023: {
                this.executeConditiontVOPTPARENTALBLOCKEDScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600022: {
                this.executeConditiontVOPTPARENTALENTERPWDScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600024: {
                this.executeConditiontVOPTPARENTALENTERPWDWRONGScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600025: {
                this.executeConditiontVOPTPARENTALSELECTScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600027: {
                this.executeConditiontVOPTPARENTALSELECTCHANGEFIRSTScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600028: {
                this.executeConditiontVOPTPARENTALSELECTCHANGESECONDScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600029: {
                this.executeConditiontVOPTPARENTALSELECTCHANGEUNEQUALScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600026: {
                this.executeConditiontVOPTPARENTALSELECTLEVELScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600048: {
                this.executeConditiontVOPTPICTUREBRIGHTNESSScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600050: {
                this.executeConditiontVOPTPICTURECOLORScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600049: {
                this.executeConditiontVOPTPICTURECONTRASTScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600047: {
                this.executeConditiontVOPTPICTUREMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600031: {
                this.executeConditiontVOPTREGIONVARIANTMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600038: {
                this.executeConditiontVOPTSEEKMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600021: {
                this.executeConditiontVOPTSETTINGSScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600030: {
                this.executeConditiontVOPTSOUNDCHANNELMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600034: {
                this.executeConditiontVOPTTELETEXTMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600020: {
                this.executeConditiontVOPTVISUALAUDIOMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600015: {
                this.executeConditiontVPOPUPEWSMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600053: {
                this.executeConditiontVPPFULLSCREENMAINOSDScreen(n, hMIViewArray, n3);
                break;
            }
            case 2600000: {
                this.executeConditiontVREFTEMPLATEScreen(n, hMIViewArray, n3);
                break;
            }
        }
    }

    private void executeConditiontVAUDIOScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 8: {
                if (hmiService.getComponentConditionManager().isTrue(2601040, n2)) {
                    if (hMIViewArray[0] == null) break;
                    ((EntertainmentDrawerContentController)hMIViewArray[0]).setEntertainmentDrawerStateRequest(6);
                    break;
                }
                if (hMIViewArray[0] == null) break;
                ((EntertainmentDrawerContentController)hMIViewArray[0]).setEntertainmentDrawerStateRequest(1);
                break;
            }
            case 379: {
                if (hmiService.getComponentConditionManager().isTrue(2601040, n2)) {
                    if (hMIViewArray[0] != null) {
                        ((EntertainmentDrawerContentController)hMIViewArray[0]).setEntertainmentDrawerStateRequest(6);
                    }
                } else if (hMIViewArray[0] != null) {
                    ((EntertainmentDrawerContentController)hMIViewArray[0]).setEntertainmentDrawerStateRequest(1);
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(2601041, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2601042, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((IconController)hMIViewArray[3]).setVisible(!hmiService.getComponentConditionManager().isTrue(2601043, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((IconController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(2601044, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(!hmiService.getComponentConditionManager().isTrue(2601313, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((IconController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(2601314, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((IconController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(2601045, n2));
                }
                if (hMIViewArray[8] != null) {
                    ((IconController)hMIViewArray[8]).setVisible(hmiService.getComponentConditionManager().isTrue(2601046, n2));
                }
                if (hMIViewArray[9] != null) {
                    ((LabelController)hMIViewArray[9]).setVisible(hmiService.getComponentConditionManager().isTrue(2600106, n2));
                }
                if (hMIViewArray[10] != null) {
                    ((LabelController)hMIViewArray[10]).setVisible(hmiService.getComponentConditionManager().isTrue(2600105, n2));
                }
                if (hMIViewArray[11] != null) {
                    ((IconController)hMIViewArray[11]).setVisible(hmiService.getComponentConditionManager().isTrue(2601315, n2));
                }
                if (hMIViewArray[12] != null) {
                    ((IconController)hMIViewArray[12]).setVisible(hmiService.getComponentConditionManager().isTrue(2601316, n2));
                }
                if (hMIViewArray[13] == null) break;
                ((LabelController)hMIViewArray[13]).setVisible(hmiService.getComponentConditionManager().isTrue(2601317, n2));
                break;
            }
            case 2600000: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600110, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((ListController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600109, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((LabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2600106, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((LabelController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2600105, n2));
                }
                if (hMIViewArray[4] == null) break;
                ((LabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(2601317, n2));
                break;
            }
            case 2600026: {
                if (hMIViewArray[0] != null) {
                    ((LayoutContainerController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600108, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LayoutContainerController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600107, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((LayoutContainerController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2601318, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((MenuController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2600111, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((MenuController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(2600112, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((MenuController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(2601319, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((LayoutContainerController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(2601320, n2));
                }
                if (hMIViewArray[7] == null) break;
                ((LayoutContainerController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(2601321, n2));
                break;
            }
            case 2600040: {
                if (hMIViewArray[0] != null) {
                    ((LayoutContainerController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600108, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LayoutContainerController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600107, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2600111, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((MenuController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2600112, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((LabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(2600106, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((LabelController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(2600105, n2));
                }
                if (hMIViewArray[6] == null) break;
                ((LabelController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(2601317, n2));
                break;
            }
            case 2600045: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600114, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((ListController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600113, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((LabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2600106, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((LabelController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2600105, n2));
                }
                if (hMIViewArray[4] == null) break;
                ((LabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(2601317, n2));
                break;
            }
        }
    }

    private void executeConditiontVAVFULLSCREENScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 3915: {
                if (this.evaluateSimpleChoiceModelValueEqualsCondition(3915, n2, 1)) {
                    if (hMIViewArray[0] == null) break;
                    ((StatusBarStubController)hMIViewArray[0]).setRenderStyle(0);
                    break;
                }
                if (hMIViewArray[0] == null) break;
                ((StatusBarStubController)hMIViewArray[0]).setRenderStyle(2);
                break;
            }
            case 5583: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 5618: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600016: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600080: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600101: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2601136, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2600435, n2));
                break;
            }
            case 2600176: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                break;
            }
            case 2600183: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
        }
    }

    private void executeConditiontVAVFULLSCREENDISCLAIMERScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2600026: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601327, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2601328, n2));
                break;
            }
        }
    }

    private void executeConditiontVCASDISCLAIMERSECONDScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2600101: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                break;
            }
            case 2600166: {
                if (hMIViewArray[0] == null) break;
                ((OperationPanelController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(2601021, n2));
                break;
            }
            case 2600176: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                break;
            }
        }
    }

    private void executeConditiontVCHANNELMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 523: {
                if (hMIViewArray[0] != null) {
                    ((TouchController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600437, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((ListController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600440, n2));
                break;
            }
            case 5583: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 5618: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600000: {
                if (hMIViewArray[0] != null) {
                    ((MenuController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601048, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((ListController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600000, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((InstructionTextContoller)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2601049, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2601050, n2));
                }
                if (hMIViewArray[4] == null) break;
                ((IdleTimerController)hMIViewArray[4]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601051, n2));
                break;
            }
            case 2600016: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600080: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600101: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2601136, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2600435, n2));
                break;
            }
            case 2600114: {
                if (hMIViewArray[0] != null) {
                    ((MenuController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601048, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((ListController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600440, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2600436, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((ListController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2600000, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((InstructionTextContoller)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(2601049, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(2601050, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((LabelController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(2600997, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((LabelController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(2600998, n2));
                }
                if (hMIViewArray[8] == null) break;
                ((IdleTimerController)hMIViewArray[8]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601051, n2));
                break;
            }
            case 2600116: {
                if (hMIViewArray[0] == null) break;
                ((ListController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600440, n2));
                break;
            }
            case 2600121: {
                if (hMIViewArray[0] == null) break;
                ((TouchController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(2600517, n2));
                break;
            }
            case 2600176: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                break;
            }
            case 2600183: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
        }
    }

    private void executeConditiontVFAVORITEMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 523: {
                if (hMIViewArray[0] != null) {
                    ((TouchController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600439, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((ListController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600440, n2));
                break;
            }
            case 5583: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 5618: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600016: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600045: {
                if (hMIViewArray[0] != null) {
                    ((MenuController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601052, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((ListController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600035, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((InstructionTextContoller)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2601053, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2601054, n2));
                }
                if (hMIViewArray[4] == null) break;
                ((IdleTimerController)hMIViewArray[4]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601055, n2));
                break;
            }
            case 2600080: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600101: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2601136, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2600435, n2));
                break;
            }
            case 2600114: {
                if (hMIViewArray[0] != null) {
                    ((MenuController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601052, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((ListController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600440, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2600438, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((ListController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2600035, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((InstructionTextContoller)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(2601053, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(2601054, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((LabelController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(2600999, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((LabelController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(2601000, n2));
                }
                if (hMIViewArray[8] == null) break;
                ((IdleTimerController)hMIViewArray[8]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601055, n2));
                break;
            }
            case 2600116: {
                if (hMIViewArray[0] == null) break;
                ((ListController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600440, n2));
                break;
            }
            case 2600121: {
                if (hMIViewArray[0] == null) break;
                ((TouchController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(2600518, n2));
                break;
            }
            case 2600176: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                break;
            }
            case 2600183: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
        }
    }

    private void executeConditiontVFULLSCREENMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 3915: {
                if (this.evaluateSimpleChoiceModelValueEqualsCondition(3915, n2, 1)) {
                    if (hMIViewArray[0] == null) break;
                    ((StatusBarStubController)hMIViewArray[0]).setRenderStyle(0);
                    break;
                }
                if (hMIViewArray[0] == null) break;
                ((StatusBarStubController)hMIViewArray[0]).setRenderStyle(2);
                break;
            }
            case 5583: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 5618: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600016: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600080: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600101: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2601136, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2600435, n2));
                break;
            }
            case 2600176: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                break;
            }
            case 2600183: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
        }
    }

    private void executeConditiontVFULLSCREENMOVIERATINGScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2600101: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601136, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600435, n2));
                break;
            }
        }
    }

    private void executeConditiontVOPTScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 335: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601276, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2601337, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2601278, n2));
                break;
            }
            case 377: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601288, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601289, n2));
                break;
            }
            case 442: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601332, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2601333, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2601279, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2601281, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((MenuItemController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(2601282, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((MenuItemController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(2601283, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((MenuItemController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(2601284, n2));
                }
                if (hMIViewArray[7] == null) break;
                ((MenuItemController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(2601285, n2));
                break;
            }
            case 3913: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601295, n2));
                break;
            }
            case 3939: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601276, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2601337, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2601278, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2601332, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((MenuItemController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(2601333, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((MenuItemController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(2601279, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((MenuItemController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(2601280, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((MenuItemController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(2601281, n2));
                }
                if (hMIViewArray[8] != null) {
                    ((MenuItemController)hMIViewArray[8]).setVisible(hmiService.getComponentConditionManager().isTrue(2601282, n2));
                }
                if (hMIViewArray[9] != null) {
                    ((MenuItemController)hMIViewArray[9]).setVisible(hmiService.getComponentConditionManager().isTrue(2601283, n2));
                }
                if (hMIViewArray[10] != null) {
                    ((MenuItemController)hMIViewArray[10]).setVisible(hmiService.getComponentConditionManager().isTrue(2601284, n2));
                }
                if (hMIViewArray[11] != null) {
                    ((MenuItemController)hMIViewArray[11]).setVisible(hmiService.getComponentConditionManager().isTrue(2601285, n2));
                }
                if (hMIViewArray[12] != null) {
                    ((MenuItemController)hMIViewArray[12]).setVisible(hmiService.getComponentConditionManager().isTrue(2601286, n2));
                }
                if (hMIViewArray[13] != null) {
                    ((MenuItemController)hMIViewArray[13]).setVisible(hmiService.getComponentConditionManager().isTrue(2601287, n2));
                }
                if (hMIViewArray[14] != null) {
                    ((MenuItemController)hMIViewArray[14]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601288, n2));
                }
                if (hMIViewArray[15] != null) {
                    ((MenuItemController)hMIViewArray[15]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601289, n2));
                }
                if (hMIViewArray[16] != null) {
                    ((MenuItemController)hMIViewArray[16]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601290, n2));
                }
                if (hMIViewArray[17] != null) {
                    ((MenuItemController)hMIViewArray[17]).setVisible(hmiService.getComponentConditionManager().isTrue(2601291, n2));
                }
                if (hMIViewArray[18] != null) {
                    ((MenuItemController)hMIViewArray[18]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601382, n2));
                }
                if (hMIViewArray[19] != null) {
                    ((MenuItemController)hMIViewArray[19]).setVisible(hmiService.getComponentConditionManager().isTrue(2601292, n2));
                }
                if (hMIViewArray[20] != null) {
                    ((MenuItemController)hMIViewArray[20]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601383, n2));
                }
                if (hMIViewArray[21] != null) {
                    ((MenuItemController)hMIViewArray[21]).setVisible(hmiService.getComponentConditionManager().isTrue(2601293, n2));
                }
                if (hMIViewArray[22] != null) {
                    ((MenuItemController)hMIViewArray[22]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601384, n2));
                }
                if (hMIViewArray[23] != null) {
                    ((MenuItemController)hMIViewArray[23]).setVisible(hmiService.getComponentConditionManager().isTrue(2601294, n2));
                }
                if (hMIViewArray[24] != null) {
                    ((MenuItemController)hMIViewArray[24]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601385, n2));
                }
                if (hMIViewArray[25] != null) {
                    ((MenuItemController)hMIViewArray[25]).setVisible(hmiService.getComponentConditionManager().isTrue(2601295, n2));
                }
                if (hMIViewArray[26] != null) {
                    ((MenuItemController)hMIViewArray[26]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601329, n2));
                }
                if (hMIViewArray[27] != null) {
                    ((MenuItemController)hMIViewArray[27]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601296, n2));
                }
                if (hMIViewArray[28] != null) {
                    ((MenuItemController)hMIViewArray[28]).setVisible(hmiService.getComponentConditionManager().isTrue(2601297, n2));
                }
                if (hMIViewArray[29] != null) {
                    ((MenuItemController)hMIViewArray[29]).setVisible(hmiService.getComponentConditionManager().isTrue(2601298, n2));
                }
                if (hMIViewArray[30] != null) {
                    ((MenuItemController)hMIViewArray[30]).setVisible(hmiService.getComponentConditionManager().isTrue(2601299, n2));
                }
                if (hMIViewArray[31] != null) {
                    ((MenuItemController)hMIViewArray[31]).setVisible(hmiService.getComponentConditionManager().isTrue(2601300, n2));
                }
                if (hMIViewArray[32] != null) {
                    ((MenuItemController)hMIViewArray[32]).setVisible(hmiService.getComponentConditionManager().isTrue(2601301, n2));
                }
                if (hMIViewArray[33] != null) {
                    ((MenuItemController)hMIViewArray[33]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601386, n2));
                }
                if (hMIViewArray[34] == null) break;
                ((MenuItemController)hMIViewArray[34]).setVisible(hmiService.getComponentConditionManager().isTrue(2601302, n2));
                break;
            }
            case 4076: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601286, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2601287, n2));
                break;
            }
            case 4306: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601279, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2601280, n2));
                break;
            }
            case 4494: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601287, n2));
                break;
            }
            case 5583: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601337, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2601332, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601382, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(2601396, n2)) {
                    if (hMIViewArray[3] != null) {
                        ((MenuItemController)hMIViewArray[3]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[4] != null) {
                    ((MenuItemController)hMIViewArray[4]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601383, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(2601397, n2)) {
                    if (hMIViewArray[5] != null) {
                        ((MenuItemController)hMIViewArray[5]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[5] != null) {
                    ((MenuItemController)hMIViewArray[5]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[6] != null) {
                    ((MenuItemController)hMIViewArray[6]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601384, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((MenuItemController)hMIViewArray[7]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601385, n2));
                }
                if (hMIViewArray[8] != null) {
                    ((MenuItemController)hMIViewArray[8]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601296, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(2601398, n2)) {
                    if (hMIViewArray[9] != null) {
                        ((MenuItemController)hMIViewArray[9]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[9] != null) {
                    ((MenuItemController)hMIViewArray[9]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[10] != null) {
                    ((MenuItemController)hMIViewArray[10]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601386, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(2601399, n2)) {
                    if (hMIViewArray[11] == null) break;
                    ((MenuItemController)hMIViewArray[11]).setInfoLineDisabledTextIndex(0);
                    break;
                }
                if (hMIViewArray[11] == null) break;
                ((MenuItemController)hMIViewArray[11]).setInfoLineDisabledTextIndex(-1);
                break;
            }
            case 5592: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601382, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(2601396, n2)) {
                    if (hMIViewArray[1] != null) {
                        ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601383, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(2601397, n2)) {
                    if (hMIViewArray[3] != null) {
                        ((MenuItemController)hMIViewArray[3]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[4] != null) {
                    ((MenuItemController)hMIViewArray[4]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601384, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((MenuItemController)hMIViewArray[5]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601385, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((MenuItemController)hMIViewArray[6]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601296, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(2601398, n2)) {
                    if (hMIViewArray[7] != null) {
                        ((MenuItemController)hMIViewArray[7]).setInfoLineDisabledTextIndex(0);
                    }
                } else if (hMIViewArray[7] != null) {
                    ((MenuItemController)hMIViewArray[7]).setInfoLineDisabledTextIndex(-1);
                }
                if (hMIViewArray[8] != null) {
                    ((MenuItemController)hMIViewArray[8]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601386, n2));
                }
                if (hmiService.getComponentConditionManager().isTrue(2601399, n2)) {
                    if (hMIViewArray[9] == null) break;
                    ((MenuItemController)hMIViewArray[9]).setInfoLineDisabledTextIndex(0);
                    break;
                }
                if (hMIViewArray[9] == null) break;
                ((MenuItemController)hMIViewArray[9]).setInfoLineDisabledTextIndex(-1);
                break;
            }
            case 5600: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601337, n2));
                break;
            }
            case 5602: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601332, n2));
                break;
            }
            case 5606: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601332, n2));
                break;
            }
            case 1000019: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601288, n2));
                break;
            }
            case 1100194: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601281, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2601282, n2));
                break;
            }
            case 1100244: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601329, n2));
                break;
            }
            case 2600040: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601292, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2601293, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2601294, n2));
                break;
            }
            case 2600045: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601290, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2601291, n2));
                break;
            }
            case 2600055: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601302, n2));
                break;
            }
            case 2600058: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601301, n2));
                break;
            }
            case 2600066: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601299, n2));
                break;
            }
            case 2600068: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601297, n2));
                break;
            }
            case 2600070: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601298, n2));
                break;
            }
            case 2600080: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(2601296, n2));
                break;
            }
            case 2600083: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601300, n2));
                break;
            }
            case 2600159: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601291, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2601292, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2601293, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((MenuItemController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2601294, n2));
                break;
            }
        }
    }

    private void executeConditiontVOPTCASIDMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 442: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601341, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2601342, n2));
                break;
            }
            case 2600042: {
                if (hMIViewArray[0] != null) {
                    ((InstructionTextContoller)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600348, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((InstructionTextContoller)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600347, n2));
                break;
            }
            case 2600065: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601341, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2601342, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((LabelController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2600065, n2, 1));
                }
                if (hMIViewArray[3] == null) break;
                ((LabelController)hMIViewArray[3]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2600065, n2, 0));
                break;
            }
        }
    }

    private void executeConditiontVOPTDATABROADCASTMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 5583: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 5618: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600016: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600080: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600101: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2601136, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2600435, n2));
                break;
            }
            case 2600166: {
                if (hMIViewArray[0] != null) {
                    ((OperationPanelController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(2601021, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((IconController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(2601312, n2));
                break;
            }
            case 2600176: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                break;
            }
            case 2600183: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
        }
    }

    private void executeConditiontVOPTENGINEERINGMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2600101: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2601136, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2600435, n2));
                break;
            }
            case 2600166: {
                if (hMIViewArray[0] != null) {
                    ((OperationPanelController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(2601021, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((IconController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(2601312, n2));
                break;
            }
            case 2600176: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                break;
            }
        }
    }

    private void executeConditiontVOPTEPGMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2600101: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                break;
            }
            case 2600166: {
                if (hMIViewArray[0] != null) {
                    ((OperationPanelController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(2601021, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((IconController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(2601312, n2));
                break;
            }
            case 2600176: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                break;
            }
        }
    }

    private void executeConditiontVOPTOPENSOURCEMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2600101: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                break;
            }
            case 2600166: {
                if (hMIViewArray[0] != null) {
                    ((OperationPanelController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(2601021, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((IconController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(2601312, n2));
                break;
            }
            case 2600176: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                break;
            }
        }
    }

    private void executeConditiontVOPTPARENTALBLOCKEDScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 5583: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 5618: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600016: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600080: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600101: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2601136, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2600435, n2));
                break;
            }
            case 2600176: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                break;
            }
            case 2600183: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
        }
    }

    private void executeConditiontVOPTPARENTALENTERPWDScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 5583: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 5618: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600016: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600080: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600101: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2601136, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2600435, n2));
                break;
            }
            case 2600122: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601307, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2601334, n2));
                break;
            }
            case 2600124: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(2600124, n2, 0));
                break;
            }
            case 2600176: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                break;
            }
            case 2600183: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
        }
    }

    private void executeConditiontVOPTPARENTALENTERPWDWRONGScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 5583: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 5618: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600016: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600080: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600101: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2601136, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2600435, n2));
                break;
            }
            case 2600176: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                break;
            }
            case 2600183: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
        }
    }

    private void executeConditiontVOPTPARENTALSELECTScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 5583: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 5618: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600016: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600080: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600101: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2601136, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2600435, n2));
                break;
            }
            case 2600176: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                break;
            }
            case 2600183: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
        }
    }

    private void executeConditiontVOPTPARENTALSELECTCHANGEFIRSTScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 5583: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 5618: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600016: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600080: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600101: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2601136, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2600435, n2));
                break;
            }
            case 2600124: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(2600124, n2, 0));
                break;
            }
            case 2600176: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                break;
            }
            case 2600183: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
        }
    }

    private void executeConditiontVOPTPARENTALSELECTCHANGESECONDScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 5583: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 5618: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600016: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600080: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600101: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2601136, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2600435, n2));
                break;
            }
            case 2600124: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleAbstractModelStatusEqualsCondition(2600124, n2, 0));
                break;
            }
            case 2600176: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                break;
            }
            case 2600183: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
        }
    }

    private void executeConditiontVOPTPARENTALSELECTCHANGEUNEQUALScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 5583: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 5618: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600016: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600080: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600101: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2601136, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2600435, n2));
                break;
            }
            case 2600176: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                break;
            }
            case 2600183: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
        }
    }

    private void executeConditiontVOPTPARENTALSELECTLEVELScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 5583: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 5618: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600016: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600080: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600101: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2601136, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2600435, n2));
                break;
            }
            case 2600176: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                break;
            }
            case 2600183: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
        }
    }

    private void executeConditiontVOPTPICTUREBRIGHTNESSScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 5583: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 5618: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600016: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600080: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600101: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2601136, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2600435, n2));
                break;
            }
            case 2600176: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                break;
            }
            case 2600183: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
        }
    }

    private void executeConditiontVOPTPICTURECOLORScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 5583: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 5618: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600016: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600080: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600101: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2601136, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2600435, n2));
                break;
            }
            case 2600176: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                break;
            }
            case 2600183: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
        }
    }

    private void executeConditiontVOPTPICTURECONTRASTScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 5583: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 5618: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600016: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600080: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600101: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2601136, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2600435, n2));
                break;
            }
            case 2600176: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                break;
            }
            case 2600183: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
        }
    }

    private void executeConditiontVOPTPICTUREMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 5583: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2600353, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2600352, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((MenuItemController)hMIViewArray[3]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2600351, n2));
                break;
            }
            case 5618: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2600353, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2600352, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((MenuItemController)hMIViewArray[3]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2600351, n2));
                break;
            }
            case 2600016: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2600353, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2600352, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((MenuItemController)hMIViewArray[3]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2600351, n2));
                break;
            }
            case 2600026: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600152, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600151, n2));
                break;
            }
            case 2600054: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600151, n2));
                break;
            }
            case 2600062: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600152, n2));
                break;
            }
            case 2600080: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600101: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2601136, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2600435, n2));
                break;
            }
            case 2600176: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                break;
            }
            case 2600183: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
        }
    }

    private void executeConditiontVOPTREGIONVARIANTMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 5583: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 5618: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600016: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600080: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600101: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2601136, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2600435, n2));
                break;
            }
            case 2600176: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                break;
            }
            case 2600183: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
        }
    }

    private void executeConditiontVOPTSEEKMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 5583: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 5618: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600016: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600080: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600101: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2601136, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2600435, n2));
                break;
            }
            case 2600108: {
                if (hMIViewArray[0] == null) break;
                ((LabelController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(2601306, n2));
                break;
            }
            case 2600109: {
                if (hMIViewArray[0] == null) break;
                ((LabelController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(2601306, n2));
                break;
            }
            case 2600176: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                break;
            }
            case 2600183: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
        }
    }

    private void executeConditiontVOPTSETTINGSScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 5583: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 5618: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600016: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600031: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600427, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600426, n2));
                break;
            }
            case 2600053: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600427, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600426, n2));
                break;
            }
            case 2600056: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600349, n2));
                break;
            }
            case 2600057: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600103, n2));
                break;
            }
            case 2600059: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600428, n2));
                break;
            }
            case 2600060: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600429, n2));
                break;
            }
            case 2600061: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600430, n2));
                break;
            }
            case 2600063: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600431, n2));
                break;
            }
            case 2600069: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2600069, n2, 1));
                break;
            }
            case 2600080: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600084: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600104, n2));
                break;
            }
            case 2600101: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2601136, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2600435, n2));
                break;
            }
            case 2600160: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600926, n2));
                break;
            }
            case 2600176: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                break;
            }
            case 2600183: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
        }
    }

    private void executeConditiontVOPTSOUNDCHANNELMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 5583: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 5618: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600016: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600031: {
                if (hMIViewArray[0] != null) {
                    ((ListController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600355, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600354, n2));
                break;
            }
            case 2600080: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600101: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2601136, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2600435, n2));
                break;
            }
            case 2600176: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                break;
            }
            case 2600183: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
        }
    }

    private void executeConditiontVOPTTELETEXTMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 5583: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 5618: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600016: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600080: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600101: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600166: {
                if (hMIViewArray[0] != null) {
                    ((OperationPanelController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(2601021, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((IconController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(2601312, n2));
                break;
            }
            case 2600176: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                break;
            }
            case 2600183: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
        }
    }

    private void executeConditiontVOPTVISUALAUDIOMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 5583: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 5618: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600016: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600080: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600101: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600166: {
                if (hMIViewArray[0] == null) break;
                ((OperationPanelController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(2601021, n2));
                break;
            }
            case 2600176: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                break;
            }
            case 2600183: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
        }
    }

    private void executeConditiontVPOPUPEWSMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2600032: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(2601308, n2));
                break;
            }
            case 2600033: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2601309, n2));
                break;
            }
            case 2600037: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(2601310, n2));
                break;
            }
            case 2600088: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2601311, n2));
                break;
            }
        }
    }

    private void executeConditiontVPPFULLSCREENMAINOSDScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2600101: {
                if (hmiService.getComponentConditionManager().isTrue(2600818, n2)) {
                    if (hMIViewArray[0] == null) break;
                    ((PartialPopupController)hMIViewArray[0]).setAutoHideTime(0);
                    break;
                }
                if (hMIViewArray[0] == null) break;
                ((PartialPopupController)hMIViewArray[0]).setAutoHideTime(10000);
                break;
            }
            case 2600108: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(2600562, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(2600563, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((LabelController)hMIViewArray[2]).setVisible(!hmiService.getComponentConditionManager().isTrue(2600564, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((ProgressBarController)hMIViewArray[3]).setVisible(!hmiService.getComponentConditionManager().isTrue(2600565, n2));
                break;
            }
            case 2600109: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(2600562, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(2600563, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((LabelController)hMIViewArray[2]).setVisible(!hmiService.getComponentConditionManager().isTrue(2600564, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((ProgressBarController)hMIViewArray[3]).setVisible(!hmiService.getComponentConditionManager().isTrue(2600565, n2));
                break;
            }
        }
    }

    private void executeConditiontVREFTEMPLATEScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 523: {
                if (hMIViewArray[0] == null) break;
                ((ListController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600440, n2));
                break;
            }
            case 5583: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 5618: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600016: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600080: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
            case 2600101: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2601136, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2600435, n2));
                break;
            }
            case 2600114: {
                if (hMIViewArray[0] == null) break;
                ((ListController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600440, n2));
                break;
            }
            case 2600116: {
                if (hMIViewArray[0] == null) break;
                ((ListController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600440, n2));
                break;
            }
            case 2600166: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(2601312, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((OperationPanelController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(2601021, n2));
                break;
            }
            case 2600176: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2601181, n2));
                break;
            }
            case 2600183: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2600434, n2));
                break;
            }
        }
    }

    public IPartialPopupController getPartialPopup(int n, int n2) {
        switch (n) {
            case 2600040: {
                return (IPartialPopupController)((Object)TVScreenBag1.tVPPOPTFAVORITEDELETEALL(this, n2));
            }
            case 2600041: {
                return (IPartialPopupController)((Object)TVScreenBag1.tVPPOPTFAVORITEDELETEALLDONE(this, n2));
            }
            case 2600043: {
                return (IPartialPopupController)((Object)TVScreenBag1.tVPPOPTPARENTALSUCCESSFULPWDCHANGE(this, n2));
            }
            case 2600046: {
                return (IPartialPopupController)((Object)TVScreenBag1.tVPPOPTFAVORITESTOREOK(this, n2));
            }
            case 2600053: {
                return (IPartialPopupController)((Object)TVScreenBag1.tVPPFULLSCREENMAINOSD(this, n2));
            }
        }
        return null;
    }

    public IPartialPopupController[] getPartialPopupStubs(int n) {
        return new IPartialPopupController[]{new PartialPopupStub(2600040, -1, -1, 250, 0, 12, true, 7, n, 1, null, false, true), new PartialPopupStub(2600041, -1, -1, 250, 0, 12, true, 7, n, 1, null, true, true), new PartialPopupStub(2600043, -1, -1, 250, 0, 12, true, 7, n, 1, null, true, true), new PartialPopupStub(2600046, -1, -1, 250, 0, 12, true, 7, n, 1, null, true, true), new PartialPopupStub(2600053, 2600107, -1, 250, 11, 12, true, 7, n, 2, null, true, true)};
    }

    public IDrawerController[] getOptionDrawers(int n) {
        return new IDrawerController[]{(IDrawerController)TVScreenBag1.tVOPT(this, n)};
    }

    public IDrawerController[] getEntertainmentDrawerContents(int n) {
        return new IDrawerController[]{(IDrawerController)TVScreenBag1.tVAUDIO(this, n)};
    }
}

