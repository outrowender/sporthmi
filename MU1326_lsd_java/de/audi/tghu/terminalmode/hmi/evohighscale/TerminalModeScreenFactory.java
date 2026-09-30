/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.terminalmode.hmi.evohighscale;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.LabelModel;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.hmi.view.HMIView;
import de.audi.atip.hmi.view.IDrawerController;
import de.audi.atip.hmi.view.IPartialPopupController;
import de.audi.atip.hmi.view.Screen;
import de.audi.tghu.terminalmode.hmi.evohighscale.FontFactory;
import de.audi.tghu.terminalmode.hmi.evohighscale.TerminalModeScreenBag1;
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
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupStub;
import de.esolutions.hmi.widgets.audi.evo.widgets.SmallStageApplicationIconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.StatusBarStubController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import java.util.NoSuchElementException;

public class TerminalModeScreenFactory
extends AbstractScreenFactory {
    private static HMIService hmiService;
    private static final int MODULE_ID = 32;
    private int[][] errorColors;
    public AbstractWidgetController[][] refWidgets = new AbstractWidgetController[8][2];

    public TerminalModeScreenFactory(IFrameworkAccess iFrameworkAccess) {
        super(32, iFrameworkAccess);
        hmiService = iFrameworkAccess.getHMIService();
    }

    private int[][] getErrorColors() {
        if (this.errorColors == null) {
            this.errorColors = new int[][]{{-16777216, -7829368}, {-16777216, -7829368}, {-16777216, -7829368}, {-16777216, -7829368}, {-16777216, -7829368}};
        }
        return this.errorColors;
    }

    public String getName() {
        return "HMITerminalModeEvoHighScale";
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
            case 3200000: {
                return TerminalModeScreenBag1.tERMINALMODEIPODOUT(this, n2);
            }
            case 3200002: {
                return TerminalModeScreenBag1.tERMINALMODEACTIVATEFIRST(this, n2);
            }
            case 3200003: {
                return TerminalModeScreenBag1.tERMINALMODEDATADISCLAIMER(this, n2);
            }
            case 3200004: {
                return TerminalModeScreenBag1.tERMINALMODENOTCONFIRMED(this, n2);
            }
            case 3200005: {
                return TerminalModeScreenBag1.tERMINALMODEINVALIDCOUNTRY(this, n2);
            }
            case 3200006: {
                return TerminalModeScreenBag1.tERMINALMODENODEVICE(this, n2);
            }
            case 3200009: {
                return TerminalModeScreenBag1.tERMINALMODEBLOCKED(this, n2);
            }
            case 3200010: {
                return TerminalModeScreenBag1.tERMINALMODENOCONNECTION(this, n2);
            }
            case 3200011: {
                return TerminalModeScreenBag1.tERMINALMODESTOPPED(this, n2);
            }
        }
        return this.createDefaultScreen(n, n2);
    }

    public AbstractWidgetController getRefWidget(int n, int n2, TerminalModeScreenFactory terminalModeScreenFactory) {
        ContainerController containerController = null;
        switch (n2) {
            case 0: {
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
                this.refWidgets[n][1] = smallStageApplicationIconController2;
                smallStageApplicationIconController2.setBounds(646, 325, 140, 140);
                smallStageApplicationIconController2.setCoordinateSets(new int[]{2, 646, 325, 140, 140, 666, 240, 100, 100});
                iconRendererHigh2.setScaleFactor(2.0f, 2.0f);
                iconRendererHigh2.setScaleMode(2);
                ContainerController containerController2 = new ContainerController();
                ContainerRendererHigh containerRendererHigh = new ContainerRendererHigh(containerController2);
                containerController2.setRenderer(containerRendererHigh);
                containerController2.setBounds(0, 0, 0, 0);
                containerController2.setEntertainmentMenuTransformation(12.0f, 12.0f, 0.96f, 0.96f, 0.0f);
                containerController2.setSelectionMenuTransformation(615.0f, 70.0f, 0.6f, 0.6f, 0.0f);
                containerController2.add(smallStageApplicationIconController);
                containerController2.add(smallStageApplicationIconController2);
                containerController = containerController2;
                break;
            }
            default: {
                this.getFramework().getLogChannel("ScreenFactory").log(10000, "Invalid reference widget id " + n2 + ".");
            }
        }
        this.refWidgets[n][n2] = containerController;
        return containerController;
    }

    protected static final boolean evalCond3200000(int n) {
        return ((ChoiceModel)TerminalModeScreenFactory.getModel(379, n)).getValue() != 1;
    }

    protected static final boolean evalCond3200001(int n) {
        return ((ChoiceModel)TerminalModeScreenFactory.getModel(379, n)).getValue() == 1;
    }

    protected static final boolean evalCond3200002(int n) {
        return ((ChoiceModel)TerminalModeScreenFactory.getModel(379, n)).getValue() != 1;
    }

    protected static final boolean evalCond3200003(int n) {
        return ((ChoiceModel)TerminalModeScreenFactory.getModel(379, n)).getValue() != 1;
    }

    protected static final boolean evalCond3200004(int n) {
        return ((ChoiceModel)TerminalModeScreenFactory.getModel(379, n)).getValue() == 1;
    }

    protected static final boolean evalCond3200006(int n) {
        return ((ChoiceModel)TerminalModeScreenFactory.getModel(3200045, n)).getValue() != 2;
    }

    protected static final boolean evalCond3200014(int n) {
        return ((ChoiceModel)TerminalModeScreenFactory.getModel(3200068, n)).getValue() == 1;
    }

    protected static final boolean evalCond3200015(int n) {
        return ((LabelModel)TerminalModeScreenFactory.getModel(3200025, n)).getLength() > 0;
    }

    protected static final boolean evalCond3200016(int n) {
        return ((LabelModel)TerminalModeScreenFactory.getModel(3200025, n)).getLength() == 0;
    }

    protected static final boolean evalCond3200017(int n) {
        return ((LabelModel)TerminalModeScreenFactory.getModel(3200027, n)).getLength() > 0;
    }

    protected static final boolean evalCond3200018(int n) {
        return ((LabelModel)TerminalModeScreenFactory.getModel(3200027, n)).getLength() == 0;
    }

    protected static final boolean evalCond3200019(int n) {
        return ((LabelModel)TerminalModeScreenFactory.getModel(3200029, n)).getLength() > 0;
    }

    protected static final boolean evalCond3200020(int n) {
        return ((LabelModel)TerminalModeScreenFactory.getModel(3200029, n)).getLength() == 0;
    }

    protected static final boolean evalCond3200037(int n) {
        return ((ChoiceModel)TerminalModeScreenFactory.getModel(3200070, n)).getValue() == 1;
    }

    public void executeCondition(int n, int n2, HMIView[] hMIViewArray, int n3) {
        switch (n2) {
            case 3200001: {
                this.executeConditiontERMINALAUDIOScreen(n, hMIViewArray, n3);
                break;
            }
            case 3200002: {
                this.executeConditiontERMINALMODEACTIVATEFIRSTScreen(n, hMIViewArray, n3);
                break;
            }
            case 3200000: {
                this.executeConditiontERMINALMODEIPODOUTScreen(n, hMIViewArray, n3);
                break;
            }
            case 3200010: {
                this.executeConditiontERMINALMODENOCONNECTIONScreen(n, hMIViewArray, n3);
                break;
            }
        }
    }

    private void executeConditiontERMINALAUDIOScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 379: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(3200000, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(3200001, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((LabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(3200002, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(3200003, n2));
                }
                if (hMIViewArray[4] == null) break;
                ((IconController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(3200004, n2));
                break;
            }
            case 3200025: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(3200015, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(3200016, n2));
                break;
            }
            case 3200027: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(3200017, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(3200018, n2));
                break;
            }
            case 3200029: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(3200019, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(3200020, n2));
                break;
            }
            case 3200068: {
                if (hMIViewArray[0] == null) break;
                ((LayoutContainerController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(3200014, n2));
                break;
            }
        }
    }

    private void executeConditiontERMINALMODEACTIVATEFIRSTScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 3200045: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(3200006, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueGreaterCondition(3200045, n2, 1));
                break;
            }
        }
    }

    private void executeConditiontERMINALMODEIPODOUTScreen(int n, HMIView[] hMIViewArray, int n2) {
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
        }
    }

    private void executeConditiontERMINALMODENOCONNECTIONScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 3200070: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(3200037, n2));
                break;
            }
        }
    }

    public IPartialPopupController getPartialPopup(int n, int n2) {
        switch (n) {
            case 3200007: {
                return (IPartialPopupController)((Object)TerminalModeScreenBag1.tERMINALMODEBTACTIVATED(this, n2));
            }
        }
        return null;
    }

    public IPartialPopupController[] getPartialPopupStubs(int n) {
        return new IPartialPopupController[]{new PartialPopupStub(3200007, -1, -1, 250, 0, 12, true, 7, n, 1, null, true, true)};
    }

    public IDrawerController[] getEntertainmentDrawerContents(int n) {
        return new IDrawerController[]{(IDrawerController)TerminalModeScreenBag1.tERMINALAUDIO(this, n), (IDrawerController)TerminalModeScreenBag1.tERMINALEMPTYAUDIO(this, n)};
    }
}

