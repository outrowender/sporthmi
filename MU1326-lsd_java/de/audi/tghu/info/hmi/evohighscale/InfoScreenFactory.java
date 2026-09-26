/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.hmi.evohighscale;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.ButtonModel;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.LabelModel;
import de.audi.atip.hmi.model.VirtualButtonModel;
import de.audi.atip.hmi.model.sysconst.SysConstModel;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.hmi.view.HMIView;
import de.audi.atip.hmi.view.Screen;
import de.audi.tghu.info.hmi.evohighscale.FontFactory;
import de.audi.tghu.info.hmi.evohighscale.InfoScreenBag1;
import de.esolutions.hmi.widgets.audi.base.FontLoader;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.VirtualButton;
import de.esolutions.hmi.widgets.audi.evo.InstructionTextContoller;
import de.esolutions.hmi.widgets.audi.evo.ScreenWidgetEVO;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ContainerRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconLabelController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MirroredContainerController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ScreenRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ProgressIconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ScrollbarController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SharedTextureController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SmallStageApplicationIconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.SeparatingLineController;
import java.util.NoSuchElementException;

public class InfoScreenFactory
extends AbstractScreenFactory {
    private static HMIService hmiService;
    private static final int MODULE_ID;
    private int[][] errorColors;
    public AbstractWidgetController[][] refWidgets = new AbstractWidgetController[8][3];

    public InfoScreenFactory(IFrameworkAccess iFrameworkAccess) {
        super(5, iFrameworkAccess);
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
        return "HMIInfoEvoHighScale";
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
            case 500002: {
                return InfoScreenBag1.mAPTRAFFICREFTEMPLATE(this, n2);
            }
            case 500003: {
                return InfoScreenBag1.mAPTRAFFICDETAILS(this, n2);
            }
            case 500004: {
                return InfoScreenBag1.mAPTRAFFICDETAILSOVERVIEW(this, n2);
            }
            case 500005: {
                return InfoScreenBag1.mAPTRAFFICNOMESSAGES(this, n2);
            }
            case 500006: {
                return InfoScreenBag1.mAPPOPUPSHOWURGENTWARNINGMAIN(this, n2);
            }
            case 500008: {
                return InfoScreenBag1.iNFOTEXTCONSTANT(this, n2);
            }
        }
        return this.createDefaultScreen(n, n2);
    }

    public AbstractWidgetController getRefWidget(int n, int n2, InfoScreenFactory infoScreenFactory) {
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
                containerController.setEntertainmentMenuTransformation(16449, 16449, -1883081409, -1883081409, 0.0f);
                containerController.setSelectionMenuTransformation(12589380, 35906, -1701242561, -1701242561, 0.0f);
                containerController.add(smallStageApplicationIconController);
                containerController.add(smallStageApplicationIconController2);
                abstractWidgetController = containerController;
                break;
            }
            default: {
                this.getFramework().getLogChannel("ScreenFactory").log(10000, new StringBuffer().append("Invalid reference widget id ").append(n2).append(".").toString());
            }
        }
        this.refWidgets[n][n2] = abstractWidgetController;
        return abstractWidgetController;
    }

    protected static final boolean evalCond500003(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond500007(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(-1331624192, n)).getValue() > 0;
    }

    protected static final boolean evalCond500008(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(-1331624192, n)).getValue() > 0;
    }

    protected static final boolean evalCond500009(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(-1331624192, n)).getValue() == 2;
    }

    protected static final boolean evalCond500012(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(-1331624192, n)).getValue() == 2 || ((ChoiceModel)InfoScreenFactory.getModel(-1331624192, n)).getValue() == 3;
    }

    protected static final boolean evalCond500013(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(-1331624192, n)).getValue() == 2 || ((ChoiceModel)InfoScreenFactory.getModel(-1331624192, n)).getValue() == 3;
    }

    protected static final boolean evalCond500016(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond500019(int n) {
        return ((ButtonModel)InfoScreenFactory.getModel(-794753280, n)).getStatus() == 1;
    }

    protected static final boolean evalCond500020(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(361, n)).getValue() == 1 && ((ChoiceModel)InfoScreenFactory.getModel(656475648, n)).getValue() > 0;
    }

    protected static final boolean evalCond500021(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(361, n)).getValue() == 1 && ((ChoiceModel)InfoScreenFactory.getModel(656475648, n)).getValue() > 0;
    }

    protected static final boolean evalCond500022(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(361, n)).getValue() == 1 && ((ChoiceModel)InfoScreenFactory.getModel(656475648, n)).getValue() == 0;
    }

    protected static final boolean evalCond500025(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(-1331624192, n)).getValue() == 2;
    }

    protected static final boolean evalCond500026(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(162, n)).getValue() > 99 && ((ChoiceModel)InfoScreenFactory.getModel(1780221440, n)).getValue() == 1 && ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1 && ((ChoiceModel)InfoScreenFactory.getModel(5624, n)).getValue() == 0;
    }

    protected static final boolean evalCond500028(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(162, n)).getValue() > 0 && ((ChoiceModel)InfoScreenFactory.getModel(162, n)).getValue() < 100 && ((ChoiceModel)InfoScreenFactory.getModel(1780221440, n)).getValue() == 1 && ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond500029(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(162, n)).getValue() > 99 && ((ChoiceModel)InfoScreenFactory.getModel(1780221440, n)).getValue() == 1 && ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1 && ((ChoiceModel)InfoScreenFactory.getModel(5624, n)).getValue() == 0;
    }

    protected static final boolean evalCond500031(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(162, n)).getValue() > 0 && ((ChoiceModel)InfoScreenFactory.getModel(162, n)).getValue() < 100 && ((ChoiceModel)InfoScreenFactory.getModel(1780221440, n)).getValue() == 1 && ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond500032(int n) {
        return ((VirtualButtonModel)InfoScreenFactory.getModel(-694089984, n)).getStatus() == 0;
    }

    protected static final boolean evalCond500035(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(-526317824, n)).getValue() == 1;
    }

    protected static final boolean evalCond500036(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(376, n)).getValue() <= -1;
    }

    protected static final boolean evalCond500037(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(162, n)).getValue() > 99 && ((ChoiceModel)InfoScreenFactory.getModel(1780221440, n)).getValue() == 1 && ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1 && ((ChoiceModel)InfoScreenFactory.getModel(5624, n)).getValue() == 0;
    }

    protected static final boolean evalCond500039(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(162, n)).getValue() > 0 && ((ChoiceModel)InfoScreenFactory.getModel(162, n)).getValue() < 100 && ((ChoiceModel)InfoScreenFactory.getModel(1780221440, n)).getValue() == 1 && ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond500041(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond500045(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(162, n)).getValue() > 99 && ((ChoiceModel)InfoScreenFactory.getModel(1780221440, n)).getValue() == 1 && ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1 && ((ChoiceModel)InfoScreenFactory.getModel(5624, n)).getValue() == 0;
    }

    protected static final boolean evalCond500047(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(162, n)).getValue() > 0 && ((ChoiceModel)InfoScreenFactory.getModel(162, n)).getValue() < 100 && ((ChoiceModel)InfoScreenFactory.getModel(1780221440, n)).getValue() == 1 && ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond500048(int n) {
        return ((SysConstModel)InfoScreenFactory.getModel(522, n)).getValue() == 4 || ((SysConstModel)InfoScreenFactory.getModel(522, n)).getValue() == 1;
    }

    protected static final boolean evalCond500049(int n) {
        return ((SysConstModel)InfoScreenFactory.getModel(522, n)).getValue() == 2;
    }

    protected static final boolean evalCond500051(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond500056(int n) {
        return ((SysConstModel)InfoScreenFactory.getModel(522, n)).getValue() == 2;
    }

    protected static final boolean evalCond500057(int n) {
        return ((SysConstModel)InfoScreenFactory.getModel(522, n)).getValue() == 4;
    }

    protected static final boolean evalCond500058(int n) {
        return ((SysConstModel)InfoScreenFactory.getModel(522, n)).getValue() == 4;
    }

    protected static final boolean evalCond500059(int n) {
        return ((SysConstModel)InfoScreenFactory.getModel(522, n)).getValue() == 4;
    }

    protected static final boolean evalCond500060(int n) {
        return ((SysConstModel)InfoScreenFactory.getModel(522, n)).getValue() == 4;
    }

    protected static final boolean evalCond500061(int n) {
        return ((SysConstModel)InfoScreenFactory.getModel(522, n)).getValue() == 4;
    }

    protected static final boolean evalCond500062(int n) {
        return ((SysConstModel)InfoScreenFactory.getModel(522, n)).getValue() == 4;
    }

    protected static final boolean evalCond500063(int n) {
        return ((SysConstModel)InfoScreenFactory.getModel(522, n)).getValue() == 4;
    }

    protected static final boolean evalCond500064(int n) {
        return ((SysConstModel)InfoScreenFactory.getModel(522, n)).getValue() == 4;
    }

    protected static final boolean evalCond500065(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond500066(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond500067(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond500068(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond500069(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond500070(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond500071(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond500072(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond500073(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond500074(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond500075(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond500076(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond500077(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond500078(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond500079(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond500080(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1;
    }

    protected static final boolean evalCond500085(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(162, n)).getValue() > 99 && ((ChoiceModel)InfoScreenFactory.getModel(1780221440, n)).getValue() == 1 && ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1 && ((ChoiceModel)InfoScreenFactory.getModel(5624, n)).getValue() == 1;
    }

    protected static final boolean evalCond500086(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(162, n)).getValue() > 99 && ((ChoiceModel)InfoScreenFactory.getModel(1780221440, n)).getValue() == 1 && ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1 && ((ChoiceModel)InfoScreenFactory.getModel(5624, n)).getValue() == 1;
    }

    protected static final boolean evalCond500087(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(162, n)).getValue() > 99 && ((ChoiceModel)InfoScreenFactory.getModel(1780221440, n)).getValue() == 1 && ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1 && ((ChoiceModel)InfoScreenFactory.getModel(5624, n)).getValue() == 1;
    }

    protected static final boolean evalCond500088(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(162, n)).getValue() > 99 && ((ChoiceModel)InfoScreenFactory.getModel(1780221440, n)).getValue() == 1 && ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1 && ((ChoiceModel)InfoScreenFactory.getModel(5624, n)).getValue() == 1;
    }

    protected static final boolean evalCond500089(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() != 1 || ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() != 1;
    }

    protected static final boolean evalCond500090(int n) {
        return ((ChoiceModel)InfoScreenFactory.getModel(-1591867904, n)).getValue() == 1 && ((SysConstModel)InfoScreenFactory.getModel(556, n)).getValue() == 1;
    }

    @Override
    public void executeCondition(int n, int n2, HMIView[] hMIViewArray, int n3) {
        switch (n2) {
            case 500006: {
                this.executeConditionmAPPOPUPSHOWURGENTWARNINGMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 500003: {
                this.executeConditionmAPTRAFFICDETAILSScreen(n, hMIViewArray, n3);
                break;
            }
            case 500004: {
                this.executeConditionmAPTRAFFICDETAILSOVERVIEWScreen(n, hMIViewArray, n3);
                break;
            }
            case 500005: {
                this.executeConditionmAPTRAFFICNOMESSAGESScreen(n, hMIViewArray, n3);
                break;
            }
        }
    }

    private void executeConditionmAPPOPUPSHOWURGENTWARNINGMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 93: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueEqualsCondition(93, n2, 1));
                break;
            }
            case 162: {
                if (hMIViewArray[0] != null) {
                    ((ProgressIconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1201735424, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1168180992, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((IconLabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1973487360, n2));
                break;
            }
            case 522: {
                if (hMIViewArray[0] != null) {
                    ((MirroredContainerController)hMIViewArray[0]).setMirrorEnabled(hmiService.getComponentConditionManager().isTrue(1503725312, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MirroredContainerController)hMIViewArray[1]).setMirrorEnabled(hmiService.getComponentConditionManager().isTrue(1520502528, n2));
                break;
            }
            case 556: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1705051904, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((SharedTextureController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1235289856, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((ProgressIconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1201735424, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(1168180992, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((IconLabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(1973487360, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(1721829120, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((IconController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(1738606336, n2));
                }
                if (hMIViewArray[7] == null) break;
                ((IconController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(1755383552, n2));
                break;
            }
            case 5624: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1168180992, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((IconLabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1973487360, n2));
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
                    ((ProgressIconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1201735424, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1168180992, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((IconLabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1973487360, n2));
                break;
            }
            case 401057: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1705051904, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((SharedTextureController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1235289856, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((ProgressIconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1201735424, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(1168180992, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((IconLabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(1973487360, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(1721829120, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((IconController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(1738606336, n2));
                }
                if (hMIViewArray[7] == null) break;
                ((IconController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(1755383552, n2));
                break;
            }
        }
    }

    private void executeConditionmAPTRAFFICDETAILSScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 93: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueEqualsCondition(93, n2, 1));
                break;
            }
            case 162: {
                if (hMIViewArray[0] != null) {
                    ((ProgressIconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1017186048, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(983631616, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((IconLabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1990264576, n2));
                break;
            }
            case 361: {
                if (hMIViewArray[0] != null) {
                    ((VirtualButton)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(882968320, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(899745536, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((LabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(916522752, n2));
                break;
            }
            case 376: {
                if (hMIViewArray[0] == null) break;
                ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1151403776, n2));
                break;
            }
            case 522: {
                if (hMIViewArray[0] != null) {
                    ((MirroredContainerController)hMIViewArray[0]).setMirrorEnabled(hmiService.getComponentConditionManager().isTrue(1537279744, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MirroredContainerController)hMIViewArray[1]).setMirrorEnabled(hmiService.getComponentConditionManager().isTrue(1554056960, n2));
                break;
            }
            case 556: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1637943040, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((SharedTextureController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(815859456, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((ProgressIconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1017186048, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(983631616, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((IconLabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(1990264576, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(1654720256, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((IconController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(1671497472, n2));
                }
                if (hMIViewArray[7] == null) break;
                ((IconController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(1688274688, n2));
                break;
            }
            case 5624: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(983631616, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((IconLabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1990264576, n2));
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
                    ((ProgressIconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1017186048, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(983631616, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((IconLabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1990264576, n2));
                break;
            }
            case 401057: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1637943040, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((SharedTextureController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(815859456, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((ProgressIconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1017186048, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(983631616, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((IconLabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(1990264576, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(1654720256, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((IconController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(1671497472, n2));
                }
                if (hMIViewArray[7] == null) break;
                ((IconController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(1688274688, n2));
                break;
            }
            case 401703: {
                if (hMIViewArray[0] != null) {
                    ((VirtualButton)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(882968320, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(899745536, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((LabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(916522752, n2));
                break;
            }
            case 500176: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(866191104, n2));
                break;
            }
        }
    }

    private void executeConditionmAPTRAFFICDETAILSOVERVIEWScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 93: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueEqualsCondition(93, n2, 1));
                break;
            }
            case 162: {
                if (hMIViewArray[0] != null) {
                    ((ProgressIconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1067517696, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1033963264, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((IconLabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2007041792, n2));
                break;
            }
            case 522: {
                if (hMIViewArray[0] != null) {
                    ((MirroredContainerController)hMIViewArray[0]).setMirrorEnabled(hmiService.getComponentConditionManager().isTrue(1570834176, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MirroredContainerController)hMIViewArray[1]).setMirrorEnabled(hmiService.getComponentConditionManager().isTrue(1587611392, n2));
                break;
            }
            case 556: {
                if (hMIViewArray[0] != null) {
                    ((ScrollbarController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2040596224, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((ScrollbarController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2057373440, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1772160768, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((SharedTextureController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(597755648, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((ProgressIconController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(1067517696, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(1033963264, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((IconLabelController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(2007041792, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((IconController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(1788937984, n2));
                }
                if (hMIViewArray[8] != null) {
                    ((IconController)hMIViewArray[8]).setVisible(hmiService.getComponentConditionManager().isTrue(1805715200, n2));
                }
                if (hMIViewArray[9] == null) break;
                ((IconController)hMIViewArray[9]).setVisible(hmiService.getComponentConditionManager().isTrue(1822492416, n2));
                break;
            }
            case 5624: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1033963264, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((IconLabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2007041792, n2));
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
                    ((ProgressIconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1067517696, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1033963264, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((IconLabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2007041792, n2));
                break;
            }
            case 401057: {
                if (hMIViewArray[0] != null) {
                    ((ScrollbarController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2040596224, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((ScrollbarController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2057373440, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1772160768, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((SharedTextureController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(597755648, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((ProgressIconController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(1067517696, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(1033963264, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((IconLabelController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(2007041792, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((IconController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(1788937984, n2));
                }
                if (hMIViewArray[8] != null) {
                    ((IconController)hMIViewArray[8]).setVisible(hmiService.getComponentConditionManager().isTrue(1805715200, n2));
                }
                if (hMIViewArray[9] == null) break;
                ((IconController)hMIViewArray[9]).setVisible(hmiService.getComponentConditionManager().isTrue(1822492416, n2));
                break;
            }
            case 500144: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(681641728, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setFocusable(hmiService.getComponentConditionManager().isTrue(966854400, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(698418944, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((LabelController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(765527808, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((LabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(748750592, n2));
                }
                if (hMIViewArray[5] == null) break;
                ((SeparatingLineController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(664864512, n2));
                break;
            }
            case 500182: {
                if (hMIViewArray[0] == null) break;
                ((VirtualButton)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(1084294912, n2));
                break;
            }
            case 500192: {
                if (hMIViewArray[0] == null) break;
                ((ScreenWidgetEVO)hMIViewArray[0]).setOpenSelectionDrawerByHkReturn(!hmiService.getComponentConditionManager().isTrue(1134626560, n2));
                break;
            }
        }
    }

    private void executeConditionmAPTRAFFICNOMESSAGESScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 93: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueEqualsCondition(93, n2, 1));
                break;
            }
            case 162: {
                if (hMIViewArray[0] != null) {
                    ((ProgressIconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1335953152, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1302398720, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((IconLabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2023819008, n2));
                break;
            }
            case 522: {
                if (hMIViewArray[0] != null) {
                    ((InstructionTextContoller)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1352730368, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1486948096, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((LabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1369507584, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((MirroredContainerController)hMIViewArray[3]).setMirrorEnabled(hmiService.getComponentConditionManager().isTrue(1604388608, n2));
                }
                if (hMIViewArray[4] == null) break;
                ((MirroredContainerController)hMIViewArray[4]).setMirrorEnabled(hmiService.getComponentConditionManager().isTrue(1621165824, n2));
                break;
            }
            case 556: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1839269632, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((SharedTextureController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1403062016, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((ProgressIconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1335953152, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(1302398720, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((IconLabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(2023819008, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(1856046848, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((IconController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(1872824064, n2));
                }
                if (hMIViewArray[7] == null) break;
                ((IconController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(1889601280, n2));
                break;
            }
            case 5624: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1302398720, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((IconLabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2023819008, n2));
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
                    ((ProgressIconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1335953152, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1302398720, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((IconLabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2023819008, n2));
                break;
            }
            case 401057: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(1839269632, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((SharedTextureController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(1403062016, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((ProgressIconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(1335953152, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(1302398720, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((IconLabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(2023819008, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(1856046848, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((IconController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(1872824064, n2));
                }
                if (hMIViewArray[7] == null) break;
                ((IconController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(1889601280, n2));
                break;
            }
            case 500192: {
                if (hMIViewArray[0] == null) break;
                ((ScreenWidgetEVO)hMIViewArray[0]).setOpenSelectionDrawerByHkReturn(!this.evaluateSimpleChoiceModelValueEqualsCondition(-526317824, n2, 1));
                break;
            }
        }
    }
}

