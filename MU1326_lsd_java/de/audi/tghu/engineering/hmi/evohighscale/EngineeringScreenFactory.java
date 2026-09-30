/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.engineering.hmi.evohighscale;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.BufferedListModel;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.LabelModel;
import de.audi.atip.hmi.model.sysconst.SysConstModel;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.hmi.view.HMIView;
import de.audi.atip.hmi.view.IDrawerController;
import de.audi.atip.hmi.view.Screen;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringScreenBag1;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringScreenBag2;
import de.audi.tghu.engineering.hmi.evohighscale.FontFactory;
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
import de.esolutions.hmi.widgets.audi.evo.widgets.SmallStageApplicationIconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import java.util.NoSuchElementException;

public class EngineeringScreenFactory
extends AbstractScreenFactory {
    private static HMIService hmiService;
    private static final int MODULE_ID = 13;
    private int[][] errorColors;
    public AbstractWidgetController[][] refWidgets = new AbstractWidgetController[8][3];

    public EngineeringScreenFactory(IFrameworkAccess iFrameworkAccess) {
        super(13, iFrameworkAccess);
        hmiService = iFrameworkAccess.getHMIService();
    }

    private int[][] getErrorColors() {
        if (this.errorColors == null) {
            this.errorColors = new int[][]{{-16777216, -7829368}, {-16777216, -7829368}, {-16777216, -7829368}, {-16777216, -7829368}, {-16777216, -7829368}};
        }
        return this.errorColors;
    }

    public String getName() {
        return "HMIEngineeringEvoHighScale";
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
            case 1300000: {
                return EngineeringScreenBag1.engRefTemplate(this, n2);
            }
            case 1300001: {
                return EngineeringScreenBag1.engErrMeta(this, n2);
            }
            case 1300002: {
                return EngineeringScreenBag1.engModeMain(this, n2);
            }
            case 1300003: {
                return EngineeringScreenBag1.engModeSystemMain(this, n2);
            }
            case 1300004: {
                return EngineeringScreenBag1.engFSCImportExportKeys(this, n2);
            }
            case 1300005: {
                return EngineeringScreenBag1.engFSCMenu(this, n2);
            }
            case 1300006: {
                return EngineeringScreenBag1.engSettingsMain(this, n2);
            }
            case 1300007: {
                return EngineeringScreenBag1.engFSCInfosLogging(this, n2);
            }
            case 1300008: {
                return EngineeringScreenBag1.engFSCImExProgress(this, n2);
            }
            case 1300009: {
                return EngineeringScreenBag1.engFSCImExError(this, n2);
            }
            case 1300010: {
                return EngineeringScreenBag1.engFSCImExSummary(this, n2);
            }
            case 1300011: {
                return EngineeringScreenBag1.engFSCDetailsInstalledSupported(this, n2);
            }
            case 1300012: {
                return EngineeringScreenBag1.engModeApplConfig(this, n2);
            }
            case 1300013: {
                return EngineeringScreenBag1.engModeApplConfigSWConfig(this, n2);
            }
            case 1300014: {
                return EngineeringScreenBag2.engModeApplConfigBundles(this, n2);
            }
            case 1300018: {
                return EngineeringScreenBag2.engSettingsChooseMedia(this, n2);
            }
            case 1300019: {
                return EngineeringScreenBag2.engSettingsProgressIndication(this, n2);
            }
            case 1300020: {
                return EngineeringScreenBag2.engSettingsImportResults(this, n2);
            }
            case 1300021: {
                return EngineeringScreenBag2.engEbmenuMain(this, n2);
            }
            case 1300022: {
                return EngineeringScreenBag2.engEbmenuLogging(this, n2);
            }
            case 1300023: {
                return EngineeringScreenBag2.engEbmenuLoggingCategory(this, n2);
            }
            case 1300024: {
                return EngineeringScreenBag2.engEbmenuLoggingName(this, n2);
            }
            case 1300025: {
                return EngineeringScreenBag2.engEbmenuMngJxe(this, n2);
            }
            case 1300026: {
                return EngineeringScreenBag2.engFSCLoggingMain(this, n2);
            }
            case 1300027: {
                return EngineeringScreenBag2.engModeInformation(this, n2);
            }
            case 1300028: {
                return EngineeringScreenBag2.eNGTEXTCONST(this, n2);
            }
            case 1300029: {
                return EngineeringScreenBag2.engFSCLoggingMainError(this, n2);
            }
        }
        return this.createDefaultScreen(n, n2);
    }

    public AbstractWidgetController getRefWidget(int n, int n2, EngineeringScreenFactory engineeringScreenFactory) {
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
                smallStageApplicationIconController2.setBitmaps(new int[]{127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127});
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

    protected static final boolean evalCond1300009(int n) {
        return ((ChoiceModel)EngineeringScreenFactory.getModel(375, n)).getValue() == 1 && ((ChoiceModel)EngineeringScreenFactory.getModel(392, n)).getValue() != 1 && ((ChoiceModel)EngineeringScreenFactory.getModel(392, n)).getValue() != -1 && ((ChoiceModel)EngineeringScreenFactory.getModel(543, n)).getValue() != 1 && ((ChoiceModel)EngineeringScreenFactory.getModel(3849, n)).getValue() != 3 || ((ChoiceModel)EngineeringScreenFactory.getModel(392, n)).getValue() == 1 && (((ChoiceModel)EngineeringScreenFactory.getModel(3849, n)).getValue() == 2 || ((ChoiceModel)EngineeringScreenFactory.getModel(3849, n)).getValue() == 7 || ((ChoiceModel)EngineeringScreenFactory.getModel(3849, n)).getValue() == 11);
    }

    protected static final boolean evalCond1300028(int n) {
        return ((BufferedListModel)EngineeringScreenFactory.getModel(1300028, n)).getLength() == 0;
    }

    protected static final boolean evalCond1300030(int n) {
        return ((SysConstModel)EngineeringScreenFactory.getModel(523, n)).getValue() == 0;
    }

    public void executeCondition(int n, int n2, HMIView[] hMIViewArray, int n3) {
        switch (n2) {
            case 1300009: {
                this.executeConditionengFSCImExErrorScreen(n, hMIViewArray, n3);
                break;
            }
            case 1300008: {
                this.executeConditionengFSCImExProgressScreen(n, hMIViewArray, n3);
                break;
            }
            case 1300010: {
                this.executeConditionengFSCImExSummaryScreen(n, hMIViewArray, n3);
                break;
            }
            case 1300004: {
                this.executeConditionengFSCImportExportKeysScreen(n, hMIViewArray, n3);
                break;
            }
            case 1300005: {
                this.executeConditionengFSCMenuScreen(n, hMIViewArray, n3);
                break;
            }
            case 1300002: {
                this.executeConditionengModeMainScreen(n, hMIViewArray, n3);
                break;
            }
            case 1300020: {
                this.executeConditionengSettingsImportResultsScreen(n, hMIViewArray, n3);
                break;
            }
            case 1300006: {
                this.executeConditionengSettingsMainScreen(n, hMIViewArray, n3);
                break;
            }
            case 1300019: {
                this.executeConditionengSettingsProgressIndicationScreen(n, hMIViewArray, n3);
                break;
            }
        }
    }

    private void executeConditionengFSCImExErrorScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1300024: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1300024, n2, 0));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1300024, n2, 1));
                break;
            }
        }
    }

    private void executeConditionengFSCImExProgressScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1300024: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1300024, n2, 0));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1300024, n2, 1));
                break;
            }
        }
    }

    private void executeConditionengFSCImExSummaryScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1300024: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1300024, n2, 0));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1300024, n2, 1));
                break;
            }
        }
    }

    private void executeConditionengFSCImportExportKeysScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1300024: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1300024, n2, 0));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1300024, n2, 1));
                break;
            }
        }
    }

    private void executeConditionengFSCMenuScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1300028: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1300028, n2));
                break;
            }
        }
    }

    private void executeConditionengModeMainScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 375: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1300009, n2));
                break;
            }
            case 392: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1300009, n2));
                break;
            }
            case 523: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(1300030, n2));
                break;
            }
            case 543: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1300009, n2));
                break;
            }
            case 3849: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(1300009, n2));
                break;
            }
            case 3300026: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(3300026, n2, 1));
                break;
            }
        }
    }

    private void executeConditionengSettingsImportResultsScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1300061: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1300061, n2, 0));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1300061, n2, 1));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1300061, n2, 2));
                }
                if (hMIViewArray[3] == null) break;
                ((MenuItemController)hMIViewArray[3]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1300061, n2, 3));
                break;
            }
            case 1300063: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1300063, n2, 0));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1300063, n2, 1));
                break;
            }
        }
    }

    private void executeConditionengSettingsMainScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1700148: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1700148, n2, 0));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1700148, n2, 1));
                break;
            }
        }
    }

    private void executeConditionengSettingsProgressIndicationScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 1300063: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1300063, n2, 0));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(1300063, n2, 1));
                break;
            }
        }
    }

    public IDrawerController[] getSelectionDrawers(int n) {
        return new IDrawerController[]{(IDrawerController)EngineeringScreenBag2.eNGSEL(this, n)};
    }
}

