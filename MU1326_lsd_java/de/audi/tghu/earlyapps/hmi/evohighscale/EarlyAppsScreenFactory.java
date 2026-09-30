/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.earlyapps.hmi.evohighscale;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.LabelModel;
import de.audi.atip.hmi.model.sysconst.SysConstModel;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.hmi.view.HMIView;
import de.audi.atip.hmi.view.IDrawerController;
import de.audi.atip.hmi.view.IPartialPopupController;
import de.audi.atip.hmi.view.Screen;
import de.audi.tghu.earlyapps.hmi.evohighscale.EarlyAppsScreenBag1;
import de.audi.tghu.earlyapps.hmi.evohighscale.EarlyAppsScreenBag2;
import de.audi.tghu.earlyapps.hmi.evohighscale.FontFactory;
import de.esolutions.hmi.widgets.audi.base.FontLoader;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.VirtualButton;
import de.esolutions.hmi.widgets.audi.evo.FocusedPropertyConfig;
import de.esolutions.hmi.widgets.audi.evo.ScreenWidgetEVO;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MirroredContainerController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ScreenRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.ButtonController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ButtonGroupController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.DisclaimerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.OPSController;
import de.esolutions.hmi.widgets.audi.evo.widgets.OPSSectorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupGlassplateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupStub;
import de.esolutions.hmi.widgets.audi.evo.widgets.TitleBarWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.VisibilityProxyWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import java.util.NoSuchElementException;

public class EarlyAppsScreenFactory
extends AbstractScreenFactory {
    private static HMIService hmiService;
    private static final int MODULE_ID = 21;
    private int[][] errorColors;
    public AbstractWidgetController[][] refWidgets = new AbstractWidgetController[8][0];

    public EarlyAppsScreenFactory(IFrameworkAccess iFrameworkAccess) {
        super(21, iFrameworkAccess);
        hmiService = iFrameworkAccess.getHMIService();
    }

    private int[][] getErrorColors() {
        if (this.errorColors == null) {
            this.errorColors = new int[][]{{-16777216, -7829368}, {-16777216, -7829368}, {-16777216, -7829368}, {-16777216, -7829368}, {-16777216, -7829368}};
        }
        return this.errorColors;
    }

    public String getName() {
        return "HMIEarlyAppsEvoHighScale";
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
            case 0x200B20: {
                return EarlyAppsScreenBag1.cARPOPUPPARKINGPLAACTIVEPARK(this, n2);
            }
            case 2100001: {
                return EarlyAppsScreenBag1.cARPOPUPPARKINGAPSOPSVPSRVC(this, n2);
            }
            case 0x200B22: {
                return EarlyAppsScreenBag1.cARPOPUPPARKINGARA(this, n2);
            }
            case 2100030: {
                return EarlyAppsScreenBag1.cARPOPUPSEATKOMBILEFT(this, n2);
            }
            case 2100031: {
                return EarlyAppsScreenBag1.cARPOPUPSEATKOMBIRIGHT(this, n2);
            }
            case 2100037: {
                return EarlyAppsScreenBag1.cARPOPUPPARKINGVISIBLE(this, n2);
            }
            case 2100042: {
                return EarlyAppsScreenBag2.cARPOPUPCHARGEENDINVISIBLE(this, n2);
            }
            case 2100047: {
                return EarlyAppsScreenBag2.eARLYAPPSREFTEMPLATE(this, n2);
            }
            case 2100059: {
                return EarlyAppsScreenBag2.cAROPTCHARGETIMER1MAIN(this, n2);
            }
            case 2100060: {
                return EarlyAppsScreenBag2.cAROPTCHARGETIMER1WEEKDAYS(this, n2);
            }
            case 2100061: {
                return EarlyAppsScreenBag2.cAROPTCHARGETIMER2MAIN(this, n2);
            }
            case 2100062: {
                return EarlyAppsScreenBag2.cAROPTCHARGETIMER2WEEKDAYS(this, n2);
            }
            case 2100063: {
                return EarlyAppsScreenBag2.cAROPTAUXACTIMER1MAIN(this, n2);
            }
            case 2100064: {
                return EarlyAppsScreenBag2.cAROPTAUXACTIMER2MAIN(this, n2);
            }
            case 2100065: {
                return EarlyAppsScreenBag2.cARPOPUPENDAUXCOMBINEDMAIN(this, n2);
            }
            case 2100066: {
                return EarlyAppsScreenBag2.cARPOPUPENDAUXACMAIN(this, n2);
            }
            case 2100067: {
                return EarlyAppsScreenBag2.cARPOPUPCHARGEEND(this, n2);
            }
            case 2100068: {
                return EarlyAppsScreenBag2.cAROPTCHARGETIMERDATEDISCLAIMER(this, n2);
            }
            case 2100069: {
                return EarlyAppsScreenBag2.cAROPTCHARGETIMERSINGLEDISCLAIMER(this, n2);
            }
            case 2100070: {
                return EarlyAppsScreenBag2.cARPOPUPCHARGEENDINVISIBLEA3MQB(this, n2);
            }
        }
        return this.createDefaultScreen(n, n2);
    }

    public AbstractWidgetController getRefWidget(int n, int n2, EarlyAppsScreenFactory earlyAppsScreenFactory) {
        AbstractWidgetController abstractWidgetController = null;
        switch (n2) {
            default: 
        }
        this.getFramework().getLogChannel("ScreenFactory").log(10000, "Invalid reference widget id " + n2 + ".");
        this.refWidgets[n][n2] = abstractWidgetController;
        return abstractWidgetController;
    }

    protected static final boolean evalCond2100140(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100179, n)).getValue() == 1 || ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100179, n)).getValue() == 3;
    }

    protected static final boolean evalCond2100141(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100179, n)).getValue() == 1 || ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100179, n)).getValue() == 3;
    }

    protected static final boolean evalCond2100588(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100180, n)).getValue() == 2 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100166, n)).getValue() != 2;
    }

    protected static final boolean evalCond2100653(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100196, n)).getValue() > 26 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100196, n)).getValue() < 30;
    }

    protected static final boolean evalCond2100654(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100180, n)).getValue() == 2 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100166, n)).getValue() != 2 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100180, n)).getValue() != 1;
    }

    protected static final boolean evalCond2101279(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100196, n)).getValue() > 26 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100196, n)).getValue() < 30;
    }

    protected static final boolean evalCond2101403(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100196, n)).getValue() > 26 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100196, n)).getValue() < 30;
    }

    protected static final boolean evalCond2101438(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100303, n)).getValue() != 1;
    }

    protected static final boolean evalCond2101440(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100179, n)).getValue() > -1 && (((ChoiceModel)EarlyAppsScreenFactory.getModel(2100178, n)).getValue() == 0 || ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100176, n)).getValue() == 0) && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100166, n)).getValue() == 0;
    }

    protected static final boolean evalCond2101441(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100166, n)).getValue() > 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100179, n)).getValue() != 4;
    }

    protected static final boolean evalCond2101442(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100166, n)).getValue() > 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100177, n)).getValue() == 0;
    }

    protected static final boolean evalCond2101443(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100326, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100166, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100179, n)).getValue() != 4 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100179, n)).getValue() > -1;
    }

    protected static final boolean evalCond2101444(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(377, n)).getValue() == 1 && (((ChoiceModel)EarlyAppsScreenFactory.getModel(4073, n)).getValue() <= 0 || ((ChoiceModel)EarlyAppsScreenFactory.getModel(4073, n)).getValue() == 1);
    }

    protected static final boolean evalCond2101445(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(4073, n)).getValue() <= 0 || ((ChoiceModel)EarlyAppsScreenFactory.getModel(4073, n)).getValue() == 1;
    }

    protected static final boolean evalCond2101446(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(4073, n)).getValue() <= 0 || ((ChoiceModel)EarlyAppsScreenFactory.getModel(4073, n)).getValue() == 1;
    }

    protected static final boolean evalCond2101515(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100333, n)).getValue() != 1;
    }

    protected static final boolean evalCond2101516(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100333, n)).getValue() <= 1;
    }

    protected static final boolean evalCond2101517(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() != 1 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100382, n)).getValue() < 2;
    }

    protected static final boolean evalCond2101518(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() != 1 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && (((ChoiceModel)EarlyAppsScreenFactory.getModel(2100508, n)).getValue() == 0 || ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100507, n)).getValue() == 0);
    }

    protected static final boolean evalCond2101519(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() != 1 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100507, n)).getValue() < 2;
    }

    protected static final boolean evalCond2101520(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() != 1 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100508, n)).getValue() < 2;
    }

    protected static final boolean evalCond2101522(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100178, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100326, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100179, n)).getValue() != 4;
    }

    protected static final boolean evalCond2101523(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100178, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100406, n)).getValue() != 1;
    }

    protected static final boolean evalCond2101524(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100166, n)).getValue() > 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100177, n)).getValue() == 0;
    }

    protected static final boolean evalCond2101525(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100156, n)).getValue() != 1 && (((ChoiceModel)EarlyAppsScreenFactory.getModel(2100178, n)).getValue() == 0 || ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100176, n)).getValue() == 0) && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100166, n)).getValue() == 0;
    }

    protected static final boolean evalCond2101526(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100156, n)).getValue() < 2;
    }

    protected static final boolean evalCond2101527(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100101, n)).getValue() != 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(3915, n)).getValue() > 0;
    }

    protected static final boolean evalCond2101528(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100101, n)).getValue() < 2 && (((ChoiceModel)EarlyAppsScreenFactory.getModel(4073, n)).getValue() <= 0 || ((ChoiceModel)EarlyAppsScreenFactory.getModel(4073, n)).getValue() == 1);
    }

    protected static final boolean evalCond2101529(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100708, n)).getValue() != 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(3915, n)).getValue() > 0;
    }

    protected static final boolean evalCond2101530(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(377, n)).getValue() == 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100708, n)).getValue() < 2 && (((ChoiceModel)EarlyAppsScreenFactory.getModel(4073, n)).getValue() <= 0 || ((ChoiceModel)EarlyAppsScreenFactory.getModel(4073, n)).getValue() == 1);
    }

    protected static final boolean evalCond2101531(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100382, n)).getValue() != 1;
    }

    protected static final boolean evalCond2101532(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100196, n)).getValue() > 26 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100196, n)).getValue() < 30;
    }

    protected static final boolean evalCond2101533(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100360, n)).getValue() < 2;
    }

    protected static final boolean evalCond2101534(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100365, n)).getValue() < 2;
    }

    protected static final boolean evalCond2101535(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100099, n)).getValue() != 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(3915, n)).getValue() > 0;
    }

    protected static final boolean evalCond2101536(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && (((ChoiceModel)EarlyAppsScreenFactory.getModel(4073, n)).getValue() <= 0 || ((ChoiceModel)EarlyAppsScreenFactory.getModel(4073, n)).getValue() == 1) && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100099, n)).getValue() < 2;
    }

    protected static final boolean evalCond2101537(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100179, n)).getValue() == 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100166, n)).getValue() == 0;
    }

    protected static final boolean evalCond2101549(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100401, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100490, n)).getValue() == 2;
    }

    protected static final boolean evalCond2101550(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100401, n)).getValue() == 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100490, n)).getValue() == 2;
    }

    protected static final boolean evalCond2101575(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100335, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100166, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100179, n)).getValue() == 1;
    }

    protected static final boolean evalCond2101610(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(601056, n)).getValue() != 604135;
    }

    protected static final boolean evalCond2101613(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100412, n)).getValue() == 1;
    }

    protected static final boolean evalCond2101614(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(601056, n)).getValue() != 604135;
    }

    protected static final boolean evalCond2101631(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100466, n)).getValue() == 0;
    }

    protected static final boolean evalCond2101632(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100466, n)).getValue() == 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100166, n)).getValue() == 1;
    }

    protected static final boolean evalCond2101634(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100466, n)).getValue() == 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100166, n)).getValue() == 1;
    }

    protected static final boolean evalCond2101655(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100466, n)).getValue() != 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100532, n)).getValue() != 1;
    }

    protected static final boolean evalCond2101656(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100361, n)).getValue() != 0 || ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100368, n)).getValue() != 0;
    }

    protected static final boolean evalCond2101660(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(601234, n)).getValue() == 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(600815, n)).getValue() == 1 && ((SysConstModel)EarlyAppsScreenFactory.getModel(522, n)).getValue() != 4 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(601056, n)).getValue() != 600039;
    }

    protected static final boolean evalCond2101661(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(601056, n)).getValue() != 600039 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(600815, n)).getValue() != 1 && ((SysConstModel)EarlyAppsScreenFactory.getModel(522, n)).getValue() != 4;
    }

    protected static final boolean evalCond2101662(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(601234, n)).getValue() != 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(600815, n)).getValue() == 1 && ((SysConstModel)EarlyAppsScreenFactory.getModel(522, n)).getValue() != 4 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(601056, n)).getValue() != 600039;
    }

    protected static final boolean evalCond2101663(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(601056, n)).getValue() != 600039 && ((SysConstModel)EarlyAppsScreenFactory.getModel(522, n)).getValue() == 4;
    }

    protected static final boolean evalCond2101670(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(601056, n)).getValue() != 600039;
    }

    protected static final boolean evalCond2101680(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(601234, n)).getValue() == 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(600815, n)).getValue() == 1 && ((SysConstModel)EarlyAppsScreenFactory.getModel(522, n)).getValue() != 4 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(601056, n)).getValue() != 600039;
    }

    protected static final boolean evalCond2101681(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(601056, n)).getValue() != 600039 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(600815, n)).getValue() != 1 && ((SysConstModel)EarlyAppsScreenFactory.getModel(522, n)).getValue() != 4;
    }

    protected static final boolean evalCond2101682(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(601234, n)).getValue() != 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(600815, n)).getValue() == 1 && ((SysConstModel)EarlyAppsScreenFactory.getModel(522, n)).getValue() != 4 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(601056, n)).getValue() != 600039;
    }

    protected static final boolean evalCond2101683(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(601056, n)).getValue() != 600039 && ((SysConstModel)EarlyAppsScreenFactory.getModel(522, n)).getValue() == 4;
    }

    protected static final boolean evalCond2101690(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(601056, n)).getValue() != 600039;
    }

    protected static final boolean evalCond2101700(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(522, n)).getValue() != 4 || ((ChoiceModel)EarlyAppsScreenFactory.getModel(601056, n)).getValue() == 604139;
    }

    protected static final boolean evalCond2101701(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(601234, n)).getValue() == 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(600815, n)).getValue() == 1 && ((SysConstModel)EarlyAppsScreenFactory.getModel(522, n)).getValue() != 4 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(601056, n)).getValue() != 600039;
    }

    protected static final boolean evalCond2101702(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(601056, n)).getValue() != 600039 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(600815, n)).getValue() != 1 && ((SysConstModel)EarlyAppsScreenFactory.getModel(522, n)).getValue() != 4;
    }

    protected static final boolean evalCond2101703(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(601234, n)).getValue() != 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(600815, n)).getValue() == 1 && ((SysConstModel)EarlyAppsScreenFactory.getModel(522, n)).getValue() != 4 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(601056, n)).getValue() != 600039;
    }

    protected static final boolean evalCond2101704(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(601056, n)).getValue() != 600039 && ((SysConstModel)EarlyAppsScreenFactory.getModel(522, n)).getValue() == 4;
    }

    protected static final boolean evalCond2101705(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(601056, n)).getValue() != 600039;
    }

    protected static final boolean evalCond2101709(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100412, n)).getValue() == 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100408, n)).getValue() == 0;
    }

    protected static final boolean evalCond2101711(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100412, n)).getValue() == 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100410, n)).getValue() == 0;
    }

    protected static final boolean evalCond2101713(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100412, n)).getValue() == 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100423, n)).getValue() == 0;
    }

    protected static final boolean evalCond2101715(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100412, n)).getValue() == 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100417, n)).getValue() == 0;
    }

    protected static final boolean evalCond2101717(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100412, n)).getValue() == 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(0x200CC0, n)).getValue() == 0;
    }

    protected static final boolean evalCond2101719(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100412, n)).getValue() == 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100414, n)).getValue() == 0;
    }

    protected static final boolean evalCond2101721(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100412, n)).getValue() == 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100421, n)).getValue() == 0;
    }

    protected static final boolean evalCond2101723(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100426, n)).getValue() == 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(0x200CC2, n)).getValue() == 0;
    }

    protected static final boolean evalCond2101725(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100426, n)).getValue() == 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100422, n)).getValue() == 0;
    }

    protected static final boolean evalCond2101727(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100426, n)).getValue() == 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100424, n)).getValue() == 0;
    }

    protected static final boolean evalCond2101729(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100426, n)).getValue() == 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100431, n)).getValue() == 0;
    }

    protected static final boolean evalCond2101731(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100426, n)).getValue() == 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100429, n)).getValue() == 0;
    }

    protected static final boolean evalCond2101733(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100426, n)).getValue() == 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100434, n)).getValue() == 0;
    }

    protected static final boolean evalCond2101735(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100426, n)).getValue() == 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100430, n)).getValue() == 0;
    }

    protected static final boolean evalCond2101741(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100369, n)).getValue() != 0 || ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100362, n)).getValue() != 0;
    }

    protected static final boolean evalCond2101742(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100490, n)).getValue() == 3 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100490, n)).getValue() == 3 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100491, n)).getValue() != 1;
    }

    protected static final boolean evalCond2101743(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100490, n)).getValue() == 3 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100490, n)).getValue() == 3 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100492, n)).getValue() != 1;
    }

    protected static final boolean evalCond2101744(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100490, n)).getValue() == 3 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100490, n)).getValue() == 3 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100494, n)).getValue() != 1;
    }

    protected static final boolean evalCond2101745(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100491, n)).getValue() < 2;
    }

    protected static final boolean evalCond2101746(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100492, n)).getValue() < 2;
    }

    protected static final boolean evalCond2101747(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100494, n)).getValue() < 2;
    }

    protected static final boolean evalCond2101761(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() != 1 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100509, n)).getValue() < 2;
    }

    protected static final boolean evalCond2101762(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100509, n)).getValue() != 1;
    }

    protected static final boolean evalCond2101765(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100401, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100490, n)).getValue() == 3;
    }

    protected static final boolean evalCond2101766(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100401, n)).getValue() == 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100490, n)).getValue() == 3;
    }

    protected static final boolean evalCond2101767(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100507, n)).getValue() != 1;
    }

    protected static final boolean evalCond2101768(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100508, n)).getValue() != 1;
    }

    protected static final boolean evalCond2101771(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100360, n)).getValue() != 1;
    }

    protected static final boolean evalCond2101772(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100365, n)).getValue() != 1;
    }

    protected static final boolean evalCond2101773(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && (((ChoiceModel)EarlyAppsScreenFactory.getModel(2100360, n)).getValue() == 0 || ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100365, n)).getValue() == 0);
    }

    protected static final boolean evalCond2101779(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100401, n)).getValue() == 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100490, n)).getValue() == 2;
    }

    protected static final boolean evalCond2101780(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100401, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100490, n)).getValue() == 2;
    }

    protected static final boolean evalCond2101786(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100527, n)).getValue() != 1;
    }

    protected static final boolean evalCond2101787(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100527, n)).getValue() < 2;
    }

    protected static final boolean evalCond2101788(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100466, n)).getValue() != 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100532, n)).getValue() != 1;
    }

    protected static final boolean evalCond2101789(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100553, n)).getValue() != 1 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100562, n)).getValue() == 1;
    }

    protected static final boolean evalCond2101790(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((SysConstModel)EarlyAppsScreenFactory.getModel(3939, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100553, n)).getValue() < 2;
    }

    protected static final boolean evalCond2101791(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100179, n)).getValue() == 1 || ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100179, n)).getValue() == 3;
    }

    protected static final boolean evalCond2101793(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(466, n)).getValue() == 4 && ((SysConstModel)EarlyAppsScreenFactory.getModel(469, n)).getValue() == 2 && ((SysConstModel)EarlyAppsScreenFactory.getModel(467, n)).getValue() == 6;
    }

    protected static final boolean evalCond2101794(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(466, n)).getValue() == 4 && ((SysConstModel)EarlyAppsScreenFactory.getModel(469, n)).getValue() == 9 && ((SysConstModel)EarlyAppsScreenFactory.getModel(467, n)).getValue() == 1;
    }

    protected static final boolean evalCond2101795(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(466, n)).getValue() == 4 && ((SysConstModel)EarlyAppsScreenFactory.getModel(469, n)).getValue() == 9 && ((SysConstModel)EarlyAppsScreenFactory.getModel(467, n)).getValue() == 2;
    }

    protected static final boolean evalCond2101796(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(466, n)).getValue() == 7 && ((SysConstModel)EarlyAppsScreenFactory.getModel(469, n)).getValue() == 3 && ((SysConstModel)EarlyAppsScreenFactory.getModel(467, n)).getValue() == 6;
    }

    protected static final boolean evalCond2101801(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(522, n)).getValue() != 4;
    }

    protected static final boolean evalCond2101802(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(522, n)).getValue() != 4;
    }

    protected static final boolean evalCond2101810(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100361, n)).getValue() != 0 || ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100368, n)).getValue() != 0;
    }

    protected static final boolean evalCond2101811(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100369, n)).getValue() != 0 || ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100362, n)).getValue() != 0;
    }

    protected static final boolean evalCond2101827(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(522, n)).getValue() == 2;
    }

    protected static final boolean evalCond2101829(int n) {
        return (((SysConstModel)EarlyAppsScreenFactory.getModel(466, n)).getValue() & 3) != 3 || (((SysConstModel)EarlyAppsScreenFactory.getModel(469, n)).getValue() & 7) != 7;
    }

    protected static final boolean evalCond2101830(int n) {
        return (((SysConstModel)EarlyAppsScreenFactory.getModel(466, n)).getValue() & 3) != 3 || (((SysConstModel)EarlyAppsScreenFactory.getModel(469, n)).getValue() & 7) != 7;
    }

    protected static final boolean evalCond2101833(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100477, n)).getValue() == 1;
    }

    protected static final boolean evalCond2101834(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100477, n)).getValue() == 1;
    }

    protected static final boolean evalCond2101835(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(466, n)).getValue() == 3 && ((SysConstModel)EarlyAppsScreenFactory.getModel(469, n)).getValue() == 7 && ((SysConstModel)EarlyAppsScreenFactory.getModel(467, n)).getValue() == 3;
    }

    protected static final boolean evalCond2101837(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(466, n)).getValue() == 2 && ((SysConstModel)EarlyAppsScreenFactory.getModel(469, n)).getValue() == 7 && ((SysConstModel)EarlyAppsScreenFactory.getModel(467, n)).getValue() == 6;
    }

    protected static final boolean evalCond2101838(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(466, n)).getValue() == 3 && ((SysConstModel)EarlyAppsScreenFactory.getModel(469, n)).getValue() == 7 && ((SysConstModel)EarlyAppsScreenFactory.getModel(467, n)).getValue() == 0;
    }

    protected static final boolean evalCond2101839(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(466, n)).getValue() == 3 && ((SysConstModel)EarlyAppsScreenFactory.getModel(469, n)).getValue() == 7 && ((SysConstModel)EarlyAppsScreenFactory.getModel(467, n)).getValue() == 1;
    }

    protected static final boolean evalCond2101840(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(466, n)).getValue() == 3 && ((SysConstModel)EarlyAppsScreenFactory.getModel(469, n)).getValue() == 7 && ((SysConstModel)EarlyAppsScreenFactory.getModel(467, n)).getValue() == 5;
    }

    protected static final boolean evalCond2101841(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(466, n)).getValue() == 4 && ((SysConstModel)EarlyAppsScreenFactory.getModel(469, n)).getValue() == 9 && ((SysConstModel)EarlyAppsScreenFactory.getModel(467, n)).getValue() == 3;
    }

    protected static final boolean evalCond2101842(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(466, n)).getValue() == 4 && ((SysConstModel)EarlyAppsScreenFactory.getModel(469, n)).getValue() == 9 && ((SysConstModel)EarlyAppsScreenFactory.getModel(467, n)).getValue() == 4;
    }

    protected static final boolean evalCond2101843(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(466, n)).getValue() == 4 && ((SysConstModel)EarlyAppsScreenFactory.getModel(469, n)).getValue() == 9 && ((SysConstModel)EarlyAppsScreenFactory.getModel(467, n)).getValue() == 5;
    }

    protected static final boolean evalCond2101844(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(522, n)).getValue() == 4 && ((SysConstModel)EarlyAppsScreenFactory.getModel(466, n)).getValue() == 3 && ((SysConstModel)EarlyAppsScreenFactory.getModel(469, n)).getValue() == 3;
    }

    protected static final boolean evalCond2101845(int n) {
        return ((SysConstModel)EarlyAppsScreenFactory.getModel(522, n)).getValue() == 4 && ((SysConstModel)EarlyAppsScreenFactory.getModel(466, n)).getValue() == 7 && ((SysConstModel)EarlyAppsScreenFactory.getModel(469, n)).getValue() == 2;
    }

    protected static final boolean evalCond2101867(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100433, n)).getValue() != 0 || ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100472, n)).getValue() <= 0;
    }

    protected static final boolean evalCond2101868(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100433, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100472, n)).getValue() > 0;
    }

    protected static final boolean evalCond2101869(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100415, n)).getValue() != 0 || ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100481, n)).getValue() <= 0;
    }

    protected static final boolean evalCond2101870(int n) {
        return ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100415, n)).getValue() == 0 && ((ChoiceModel)EarlyAppsScreenFactory.getModel(2100481, n)).getValue() > 0;
    }

    public void executeCondition(int n, int n2, HMIView[] hMIViewArray, int n3) {
        switch (n2) {
            case 2100059: {
                this.executeConditioncAROPTCHARGETIMER1MAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 2100060: {
                this.executeConditioncAROPTCHARGETIMER1WEEKDAYSScreen(n, hMIViewArray, n3);
                break;
            }
            case 2100061: {
                this.executeConditioncAROPTCHARGETIMER2MAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 2100062: {
                this.executeConditioncAROPTCHARGETIMER2WEEKDAYSScreen(n, hMIViewArray, n3);
                break;
            }
            case 2100067: {
                this.executeConditioncARPOPUPCHARGEENDScreen(n, hMIViewArray, n3);
                break;
            }
            case 2100042: {
                this.executeConditioncARPOPUPCHARGEENDINVISIBLEScreen(n, hMIViewArray, n3);
                break;
            }
            case 2100070: {
                this.executeConditioncARPOPUPCHARGEENDINVISIBLEA3MQBScreen(n, hMIViewArray, n3);
                break;
            }
            case 2100066: {
                this.executeConditioncARPOPUPENDAUXACMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 2100065: {
                this.executeConditioncARPOPUPENDAUXCOMBINEDMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 2100001: {
                this.executeConditioncARPOPUPPARKINGAPSOPSVPSRVCScreen(n, hMIViewArray, n3);
                break;
            }
            case 0x200B22: {
                this.executeConditioncARPOPUPPARKINGARAScreen(n, hMIViewArray, n3);
                break;
            }
            case 2100008: {
                this.executeConditioncARPOPUPPARKINGOPSScreen(n, hMIViewArray, n3);
                break;
            }
            case 0x200B20: {
                this.executeConditioncARPOPUPPARKINGPLAACTIVEPARKScreen(n, hMIViewArray, n3);
                break;
            }
            case 2100010: {
                this.executeConditioncARPOPUPPARKINGPLATEXTSMAINScreen(n, hMIViewArray, n3);
                break;
            }
            case 2100044: {
                this.executeConditioncARPOPUPPARKINGPLATEXTSOPSCENTERScreen(n, hMIViewArray, n3);
                break;
            }
            case 2100035: {
                this.executeConditioncARPOPUPPARKINGPLATEXTSOPSLEFTScreen(n, hMIViewArray, n3);
                break;
            }
            case 2100040: {
                this.executeConditioncARPOPUPPARKINGPLATEXTSOPSRIGHTScreen(n, hMIViewArray, n3);
                break;
            }
            case 2100037: {
                this.executeConditioncARPOPUPPARKINGVISIBLEScreen(n, hMIViewArray, n3);
                break;
            }
            case 2100024: {
                this.executeConditionearlyAppsOPTScreen(n, hMIViewArray, n3);
                break;
            }
        }
    }

    private void executeConditioncAROPTCHARGETIMER1MAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 0x200CC2: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueEqualsCondition(0x200CC2, n2, 1));
                break;
            }
            case 2100422: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueEqualsCondition(2100422, n2, 1));
                break;
            }
            case 2100424: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueEqualsCondition(2100424, n2, 1));
                break;
            }
            case 2100426: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100426, n2, 1));
                break;
            }
            case 2100429: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueEqualsCondition(2100429, n2, 1));
                break;
            }
            case 2100430: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueEqualsCondition(2100430, n2, 1));
                break;
            }
            case 2100431: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueEqualsCondition(2100431, n2, 1));
                break;
            }
            case 2100434: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueEqualsCondition(2100434, n2, 1));
                break;
            }
        }
    }

    private void executeConditioncAROPTCHARGETIMER1WEEKDAYSScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 601056: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101610, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(601056, n2, 604135));
                break;
            }
        }
    }

    private void executeConditioncAROPTCHARGETIMER2MAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2100408: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueEqualsCondition(2100408, n2, 1));
                break;
            }
            case 2100410: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueEqualsCondition(2100410, n2, 1));
                break;
            }
            case 2100412: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100412, n2, 1));
                break;
            }
            case 2100414: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueEqualsCondition(2100414, n2, 1));
                break;
            }
            case 0x200CC0: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueEqualsCondition(0x200CC0, n2, 1));
                break;
            }
            case 2100417: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueEqualsCondition(2100417, n2, 1));
                break;
            }
            case 2100421: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueEqualsCondition(2100421, n2, 1));
                break;
            }
            case 2100423: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueEqualsCondition(2100423, n2, 1));
                break;
            }
        }
    }

    private void executeConditioncAROPTCHARGETIMER2WEEKDAYSScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 601056: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101614, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(601056, n2, 604135));
                break;
            }
            case 2100412: {
                if (hmiService.getComponentConditionManager().isTrue(2101613, n2)) {
                    if (hMIViewArray[0] == null) break;
                    ((DisclaimerController)hMIViewArray[0]).setSelector(0);
                    break;
                }
                if (hMIViewArray[0] == null) break;
                ((DisclaimerController)hMIViewArray[0]).setSelector(1);
                break;
            }
        }
    }

    private void executeConditioncARPOPUPCHARGEENDScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 522: {
                if (hmiService.getComponentConditionManager().isTrue(2101700, n2)) {
                    if (hMIViewArray[0] != null) {
                        ((MenuItemController)hMIViewArray[0]).setKeyHandler(-1);
                    }
                } else if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setKeyHandler(11);
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101701, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((LabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2101702, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((LabelController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2101703, n2));
                }
                if (hMIViewArray[4] == null) break;
                ((LabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(2101704, n2));
                break;
            }
            case 600815: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101701, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101702, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((LabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2101703, n2));
                break;
            }
            case 601056: {
                if (hmiService.getComponentConditionManager().isTrue(2101700, n2)) {
                    if (hMIViewArray[0] != null) {
                        ((MenuItemController)hMIViewArray[0]).setKeyHandler(-1);
                    }
                } else if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setKeyHandler(11);
                }
                if (hMIViewArray[1] != null) {
                    ((TitleBarWidget)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101705, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((LabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2101701, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((LabelController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2101702, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((LabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(2101703, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((LabelController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(2101704, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((TitleBarWidget)hMIViewArray[6]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(601056, n2, 600039));
                }
                if (hMIViewArray[7] != null) {
                    ((LabelController)hMIViewArray[7]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(601056, n2, 600039));
                }
                if (hMIViewArray[8] == null) break;
                ((LabelController)hMIViewArray[8]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(601056, n2, 600039));
                break;
            }
            case 601234: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101701, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101703, n2));
                break;
            }
            case 2100360: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueLesserCondition(2100360, n2, 2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setEnabled(this.evaluateSimpleChoiceModelValueLesserCondition(2100360, n2, 2));
                }
                if (hMIViewArray[2] == null) break;
                ((IconController)hMIViewArray[2]).setEnabled(this.evaluateSimpleChoiceModelValueLesserCondition(2100360, n2, 2));
                break;
            }
            case 2100365: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueLesserCondition(2100365, n2, 2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setEnabled(this.evaluateSimpleChoiceModelValueLesserCondition(2100365, n2, 2));
                }
                if (hMIViewArray[2] == null) break;
                ((IconController)hMIViewArray[2]).setEnabled(this.evaluateSimpleChoiceModelValueLesserCondition(2100365, n2, 2));
                break;
            }
            case 2100408: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101709, n2));
                break;
            }
            case 2100410: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101711, n2));
                break;
            }
            case 2100412: {
                if (hMIViewArray[0] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101713, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[1]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100412, n2, 0));
                }
                if (hMIViewArray[2] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[2]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101711, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[3]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100412, n2, 0));
                }
                if (hMIViewArray[4] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[4]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101715, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[5]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100412, n2, 0));
                }
                if (hMIViewArray[6] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[6]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101717, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[7]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100412, n2, 0));
                }
                if (hMIViewArray[8] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[8]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101719, n2));
                }
                if (hMIViewArray[9] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[9]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100412, n2, 0));
                }
                if (hMIViewArray[10] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[10]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101721, n2));
                }
                if (hMIViewArray[11] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[11]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100412, n2, 0));
                }
                if (hMIViewArray[12] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[12]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101709, n2));
                }
                if (hMIViewArray[13] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[13]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100412, n2, 0));
                break;
            }
            case 2100414: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101719, n2));
                break;
            }
            case 0x200CC0: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101717, n2));
                break;
            }
            case 2100417: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101715, n2));
                break;
            }
            case 0x200CC2: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101723, n2));
                break;
            }
            case 2100421: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101721, n2));
                break;
            }
            case 2100422: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101725, n2));
                break;
            }
            case 2100423: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101713, n2));
                break;
            }
            case 2100424: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101727, n2));
                break;
            }
            case 2100426: {
                if (hMIViewArray[0] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101729, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[1]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100426, n2, 0));
                }
                if (hMIViewArray[2] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[2]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101723, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[3]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100426, n2, 0));
                }
                if (hMIViewArray[4] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[4]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101731, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[5]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100426, n2, 0));
                }
                if (hMIViewArray[6] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[6]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101727, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[7]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100426, n2, 0));
                }
                if (hMIViewArray[8] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[8]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101733, n2));
                }
                if (hMIViewArray[9] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[9]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100426, n2, 0));
                }
                if (hMIViewArray[10] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[10]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101735, n2));
                }
                if (hMIViewArray[11] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[11]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100426, n2, 0));
                }
                if (hMIViewArray[12] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[12]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101725, n2));
                }
                if (hMIViewArray[13] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[13]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100426, n2, 0));
                break;
            }
            case 2100429: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101731, n2));
                break;
            }
            case 2100430: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101735, n2));
                break;
            }
            case 2100431: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101729, n2));
                break;
            }
            case 2100434: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101733, n2));
                break;
            }
        }
    }

    private void executeConditioncARPOPUPCHARGEENDINVISIBLEScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 522: {
                if (hMIViewArray[0] == null) break;
                ((ContainerController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101827, n2));
                break;
            }
            case 601477: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueLesserCondition(601477, n2, 2));
                break;
            }
            case 2100360: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueLesserCondition(2100360, n2, 2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setEnabled(this.evaluateSimpleChoiceModelValueLesserCondition(2100360, n2, 2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setEnabled(this.evaluateSimpleChoiceModelValueLesserCondition(2100360, n2, 2));
                }
                if (hMIViewArray[3] == null) break;
                ((IconController)hMIViewArray[3]).setEnabled(this.evaluateSimpleChoiceModelValueLesserCondition(2100360, n2, 2));
                break;
            }
            case 2100361: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(2101656, n2));
                break;
            }
            case 2100362: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(2101741, n2));
                break;
            }
            case 2100365: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueLesserCondition(2100365, n2, 2));
                }
                if (hMIViewArray[1] == null) break;
                ((IconController)hMIViewArray[1]).setEnabled(this.evaluateSimpleChoiceModelValueLesserCondition(2100365, n2, 2));
                break;
            }
            case 2100368: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(2101656, n2));
                break;
            }
            case 2100369: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(2101741, n2));
                break;
            }
            case 2100401: {
                if (hMIViewArray[0] != null) {
                    ((FocusedPropertyConfig)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101779, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101549, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((FocusedPropertyConfig)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2101780, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2101550, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(2101765, n2));
                }
                if (hMIViewArray[5] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(2101766, n2));
                break;
            }
            case 2100412: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100412, n2, 1));
                break;
            }
            case 2100426: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100426, n2, 1));
                break;
            }
            case 2100477: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101833, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101834, n2));
                break;
            }
            case 2100490: {
                if (hMIViewArray[0] != null) {
                    ((FocusedPropertyConfig)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101779, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101549, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((FocusedPropertyConfig)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2101780, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2101550, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(2101765, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(2101766, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((MenuItemController)hMIViewArray[6]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100490, n2, 3));
                }
                if (hMIViewArray[7] == null) break;
                ((MenuItemController)hMIViewArray[7]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100490, n2, 2));
                break;
            }
        }
    }

    private void executeConditioncARPOPUPCHARGEENDINVISIBLEA3MQBScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 466: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101829, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101830, n2));
                break;
            }
            case 469: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101829, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101830, n2));
                break;
            }
            case 2100361: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(2101810, n2));
                break;
            }
            case 2100362: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(2101811, n2));
                break;
            }
            case 2100368: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(2101810, n2));
                break;
            }
            case 2100369: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(2101811, n2));
                break;
            }
            case 2100373: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100373, n2, 1));
                break;
            }
            case 2100374: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100374, n2, 1));
                break;
            }
            case 2100412: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100412, n2, 1));
                break;
            }
            case 2100415: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101869, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101870, n2));
                break;
            }
            case 2100426: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100426, n2, 1));
                break;
            }
            case 2100433: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101867, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101868, n2));
                break;
            }
            case 2100467: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100467, n2, 1));
                break;
            }
            case 2100468: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100468, n2, 1));
                break;
            }
            case 2100472: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101867, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101868, n2));
                break;
            }
            case 2100481: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101869, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101870, n2));
                break;
            }
            case 2100490: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100490, n2, 3));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100490, n2, 2));
                break;
            }
        }
    }

    private void executeConditioncARPOPUPENDAUXACMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 522: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101680, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101681, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((LabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2101682, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((LabelController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2101683, n2));
                break;
            }
            case 600815: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101680, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101681, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((LabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2101682, n2));
                break;
            }
            case 601056: {
                if (hMIViewArray[0] != null) {
                    ((TitleBarWidget)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101690, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101680, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((LabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2101681, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((LabelController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2101682, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((LabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(2101683, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((TitleBarWidget)hMIViewArray[5]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(601056, n2, 600039));
                }
                if (hMIViewArray[6] != null) {
                    ((LabelController)hMIViewArray[6]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(601056, n2, 600039));
                }
                if (hMIViewArray[7] == null) break;
                ((LabelController)hMIViewArray[7]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(601056, n2, 600039));
                break;
            }
            case 601234: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101680, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101682, n2));
                break;
            }
            case 2100476: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100476, n2, 1));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100476, n2, 2));
                }
                if (hMIViewArray[2] == null) break;
                ((IconController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100476, n2, 0));
                break;
            }
            case 2100477: {
                if (hMIViewArray[0] != null) {
                    ((LayoutContainerController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100477, n2, 2));
                }
                if (hMIViewArray[1] != null) {
                    ((LayoutContainerController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100477, n2, 1));
                }
                if (hMIViewArray[2] == null) break;
                ((LayoutContainerController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100477, n2, 0));
                break;
            }
        }
    }

    private void executeConditioncARPOPUPENDAUXCOMBINEDMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 522: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101660, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101661, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((LabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2101662, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((LabelController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2101663, n2));
                break;
            }
            case 600815: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101660, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101661, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((LabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2101662, n2));
                break;
            }
            case 601056: {
                if (hMIViewArray[0] != null) {
                    ((TitleBarWidget)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101670, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101660, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((LabelController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2101661, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((LabelController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2101662, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((LabelController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(2101663, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((TitleBarWidget)hMIViewArray[5]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(601056, n2, 600039));
                }
                if (hMIViewArray[6] != null) {
                    ((LabelController)hMIViewArray[6]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(601056, n2, 600039));
                }
                if (hMIViewArray[7] == null) break;
                ((LabelController)hMIViewArray[7]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(601056, n2, 600039));
                break;
            }
            case 601234: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101660, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101662, n2));
                break;
            }
            case 2100376: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueLesserCondition(2100376, n2, 2));
                }
                if (hMIViewArray[1] == null) break;
                ((IconController)hMIViewArray[1]).setEnabled(this.evaluateSimpleChoiceModelValueLesserCondition(2100376, n2, 2));
                break;
            }
            case 2100476: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100476, n2, 1));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100476, n2, 2));
                }
                if (hMIViewArray[2] == null) break;
                ((IconController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100476, n2, 0));
                break;
            }
            case 2100477: {
                if (hMIViewArray[0] != null) {
                    ((LayoutContainerController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100477, n2, 2));
                }
                if (hMIViewArray[1] != null) {
                    ((LayoutContainerController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100477, n2, 1));
                }
                if (hMIViewArray[2] == null) break;
                ((LayoutContainerController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100477, n2, 0));
                break;
            }
        }
    }

    private void executeConditioncARPOPUPPARKINGAPSOPSVPSRVCScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 466: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101837, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101838, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2101839, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2101835, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((IconController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(2101840, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(0x201221, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((IconController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(0x201222, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((IconController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(2101795, n2));
                }
                if (hMIViewArray[8] != null) {
                    ((IconController)hMIViewArray[8]).setVisible(hmiService.getComponentConditionManager().isTrue(2101841, n2));
                }
                if (hMIViewArray[9] != null) {
                    ((IconController)hMIViewArray[9]).setVisible(hmiService.getComponentConditionManager().isTrue(2101842, n2));
                }
                if (hMIViewArray[10] != null) {
                    ((IconController)hMIViewArray[10]).setVisible(hmiService.getComponentConditionManager().isTrue(2101843, n2));
                }
                if (hMIViewArray[11] == null) break;
                ((IconController)hMIViewArray[11]).setVisible(hmiService.getComponentConditionManager().isTrue(2101796, n2));
                break;
            }
            case 467: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101837, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101838, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2101839, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2101835, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((IconController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(2101840, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(0x201221, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((IconController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(0x201222, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((IconController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(2101795, n2));
                }
                if (hMIViewArray[8] != null) {
                    ((IconController)hMIViewArray[8]).setVisible(hmiService.getComponentConditionManager().isTrue(2101841, n2));
                }
                if (hMIViewArray[9] != null) {
                    ((IconController)hMIViewArray[9]).setVisible(hmiService.getComponentConditionManager().isTrue(2101842, n2));
                }
                if (hMIViewArray[10] != null) {
                    ((IconController)hMIViewArray[10]).setVisible(hmiService.getComponentConditionManager().isTrue(2101843, n2));
                }
                if (hMIViewArray[11] == null) break;
                ((IconController)hMIViewArray[11]).setVisible(hmiService.getComponentConditionManager().isTrue(2101796, n2));
                break;
            }
            case 469: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101837, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101838, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((IconController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2101839, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((IconController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2101835, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((IconController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(2101840, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((IconController)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(0x201221, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((IconController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(0x201222, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((IconController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(2101795, n2));
                }
                if (hMIViewArray[8] != null) {
                    ((IconController)hMIViewArray[8]).setVisible(hmiService.getComponentConditionManager().isTrue(2101841, n2));
                }
                if (hMIViewArray[9] != null) {
                    ((IconController)hMIViewArray[9]).setVisible(hmiService.getComponentConditionManager().isTrue(2101842, n2));
                }
                if (hMIViewArray[10] != null) {
                    ((IconController)hMIViewArray[10]).setVisible(hmiService.getComponentConditionManager().isTrue(2101843, n2));
                }
                if (hMIViewArray[11] == null) break;
                ((IconController)hMIViewArray[11]).setVisible(hmiService.getComponentConditionManager().isTrue(2101796, n2));
                break;
            }
            case 2100106: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100106, n2, 0));
                break;
            }
            case 2100108: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100108, n2, 0));
                break;
            }
            case 2100110: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100110, n2, 0));
                break;
            }
            case 2100112: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100112, n2, 0));
                break;
            }
            case 2100114: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100114, n2, 0));
                break;
            }
            case 2100116: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100116, n2, 0));
                break;
            }
            case 2100118: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100118, n2, 0));
                break;
            }
            case 2100120: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100120, n2, 0));
                break;
            }
            case 2100122: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100122, n2, 0));
                break;
            }
            case 2100124: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100124, n2, 0));
                break;
            }
            case 2100126: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100126, n2, 0));
                break;
            }
            case 2100128: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100128, n2, 0));
                break;
            }
            case 2100130: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100130, n2, 0));
                break;
            }
            case 2100132: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100132, n2, 0));
                break;
            }
            case 2100134: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100134, n2, 0));
                break;
            }
            case 2100136: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100136, n2, 0));
                break;
            }
            case 2100166: {
                if (hMIViewArray[0] != null) {
                    ((VirtualButton)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueEqualsCondition(2100166, n2, 2));
                }
                if (hMIViewArray[1] != null) {
                    ((ContainerController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2100654, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((ButtonGroupController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2100588, n2));
                break;
            }
            case 2100174: {
                if (hMIViewArray[0] == null) break;
                ((ButtonController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100174, n2, 0));
                break;
            }
            case 2100175: {
                if (hMIViewArray[0] == null) break;
                ((ButtonController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100175, n2, 0));
                break;
            }
            case 2100176: {
                if (hMIViewArray[0] == null) break;
                ((ButtonController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100176, n2, 0));
                break;
            }
            case 2100177: {
                if (hMIViewArray[0] == null) break;
                ((ButtonController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100177, n2, 0));
                break;
            }
            case 2100178: {
                if (hMIViewArray[0] == null) break;
                ((ButtonController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100178, n2, 0));
                break;
            }
            case 2100179: {
                if (hMIViewArray[0] != null) {
                    ((OPSController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100179, n2, 4));
                }
                if (hMIViewArray[1] != null) {
                    ((LabelController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100179, n2, 0));
                }
                if (hMIViewArray[2] != null) {
                    ((LabelController)hMIViewArray[2]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100179, n2, 2));
                }
                if (hMIViewArray[3] != null) {
                    ((LabelController)hMIViewArray[3]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100179, n2, 3));
                }
                if (hMIViewArray[4] != null) {
                    ((LabelController)hMIViewArray[4]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100179, n2, 4));
                }
                if (hMIViewArray[5] != null) {
                    ((LabelController)hMIViewArray[5]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100179, n2, 1));
                }
                if (hMIViewArray[6] != null) {
                    ((IconController)hMIViewArray[6]).setVisible(hmiService.getComponentConditionManager().isTrue(2100140, n2));
                }
                if (hMIViewArray[7] == null) break;
                ((IconController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(2100141, n2));
                break;
            }
            case 2100180: {
                if (hMIViewArray[0] != null) {
                    ((ContainerController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2100654, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((ButtonGroupController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2100588, n2));
                break;
            }
            case 2100732: {
                if (hMIViewArray[0] == null) break;
                ((ContainerController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100732, n2, 1));
                break;
            }
        }
    }

    private void executeConditioncARPOPUPPARKINGARAScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2100303: {
                if (hMIViewArray[0] == null) break;
                ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101438, n2));
                break;
            }
        }
    }

    private void executeConditioncARPOPUPPARKINGOPSScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 377: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101444, n2));
                break;
            }
            case 4073: {
                if (hMIViewArray[0] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101445, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101446, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[2]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101444, n2));
                break;
            }
            case 2100106: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100106, n2, 0));
                break;
            }
            case 2100108: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100108, n2, 0));
                break;
            }
            case 2100110: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100110, n2, 0));
                break;
            }
            case 2100112: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100112, n2, 0));
                break;
            }
            case 2100114: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100114, n2, 0));
                break;
            }
            case 2100116: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100116, n2, 0));
                break;
            }
            case 2100118: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100118, n2, 0));
                break;
            }
            case 2100120: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100120, n2, 0));
                break;
            }
            case 2100122: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100122, n2, 0));
                break;
            }
            case 2100124: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100124, n2, 0));
                break;
            }
            case 2100126: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100126, n2, 0));
                break;
            }
            case 2100128: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100128, n2, 0));
                break;
            }
            case 2100130: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100130, n2, 0));
                break;
            }
            case 2100132: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100132, n2, 0));
                break;
            }
            case 2100134: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100134, n2, 0));
                break;
            }
            case 2100136: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100136, n2, 0));
                break;
            }
            case 2100166: {
                if (hMIViewArray[0] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(0x201121, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101443, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2101441, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2101442, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[4]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101634, n2));
                }
                if (hMIViewArray[5] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[5]).setVisible(hmiService.getComponentConditionManager().isTrue(2101440, n2));
                break;
            }
            case 2100176: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101440, n2));
                break;
            }
            case 2100177: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101442, n2));
                break;
            }
            case 2100178: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101440, n2));
                break;
            }
            case 2100179: {
                if (hMIViewArray[0] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(0x201121, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101443, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2101441, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2101440, n2));
                }
                if (hMIViewArray[4] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(2101791, n2));
                break;
            }
            case 2100303: {
                if (hMIViewArray[0] == null) break;
                ((VirtualButton)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueEqualsCondition(2100303, n2, 2));
                break;
            }
            case 2100326: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101443, n2));
                break;
            }
            case 2100466: {
                if (hMIViewArray[0] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101655, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((VisibilityProxyWidget)hMIViewArray[1]).setEnabled(this.evaluateSimpleChoiceModelValueEqualsCondition(2100466, n2, 0));
                }
                if (hMIViewArray[2] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[2]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101634, n2));
                break;
            }
            case 2100510: {
                if (hMIViewArray[0] == null) break;
                ((ContainerController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(2100510, n2, 0));
                break;
            }
            case 2100532: {
                if (hMIViewArray[0] == null) break;
                ((VisibilityProxyWidget)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101655, n2));
                break;
            }
        }
    }

    private void executeConditioncARPOPUPPARKINGPLAACTIVEPARKScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 3916: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(3916, n2, 5));
                }
                if (hMIViewArray[1] == null) break;
                ((IconController)hMIViewArray[1]).setVisible(this.evaluateSimpleChoiceModelValueEqualsCondition(3916, n2, 5));
                break;
            }
            case 2100106: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100106, n2, 0));
                break;
            }
            case 2100108: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100108, n2, 0));
                break;
            }
            case 2100110: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100110, n2, 0));
                break;
            }
            case 2100112: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100112, n2, 0));
                break;
            }
            case 2100114: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100114, n2, 0));
                break;
            }
            case 2100116: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100116, n2, 0));
                break;
            }
            case 2100118: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100118, n2, 0));
                break;
            }
            case 2100120: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100120, n2, 0));
                break;
            }
            case 2100122: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100122, n2, 0));
                break;
            }
            case 2100124: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100124, n2, 0));
                break;
            }
            case 2100126: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100126, n2, 0));
                break;
            }
            case 2100128: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100128, n2, 0));
                break;
            }
            case 2100130: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100130, n2, 0));
                break;
            }
            case 2100132: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100132, n2, 0));
                break;
            }
            case 2100134: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100134, n2, 0));
                break;
            }
            case 2100136: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100136, n2, 0));
                break;
            }
        }
    }

    private void executeConditioncARPOPUPPARKINGPLATEXTSMAINScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2100196: {
                if (hMIViewArray[0] == null) break;
                ((PartialPopupGlassplateController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(2100653, n2));
                break;
            }
        }
    }

    private void executeConditioncARPOPUPPARKINGPLATEXTSOPSCENTERScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2100196: {
                if (hMIViewArray[0] == null) break;
                ((PartialPopupGlassplateController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(2101532, n2));
                break;
            }
        }
    }

    private void executeConditioncARPOPUPPARKINGPLATEXTSOPSLEFTScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2100196: {
                if (hMIViewArray[0] == null) break;
                ((PartialPopupGlassplateController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(2101279, n2));
                break;
            }
        }
    }

    private void executeConditioncARPOPUPPARKINGPLATEXTSOPSRIGHTScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2100196: {
                if (hMIViewArray[0] == null) break;
                ((PartialPopupGlassplateController)hMIViewArray[0]).setVisible(!hmiService.getComponentConditionManager().isTrue(2101403, n2));
                break;
            }
        }
    }

    private void executeConditioncARPOPUPPARKINGVISIBLEScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 2100106: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100106, n2, 0));
                break;
            }
            case 2100108: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100108, n2, 0));
                break;
            }
            case 2100110: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100110, n2, 0));
                break;
            }
            case 2100112: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100112, n2, 0));
                break;
            }
            case 2100114: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100114, n2, 0));
                break;
            }
            case 2100116: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100116, n2, 0));
                break;
            }
            case 2100118: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100118, n2, 0));
                break;
            }
            case 2100120: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100120, n2, 0));
                break;
            }
            case 2100122: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100122, n2, 0));
                break;
            }
            case 2100124: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100124, n2, 0));
                break;
            }
            case 2100126: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100126, n2, 0));
                break;
            }
            case 2100128: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100128, n2, 0));
                break;
            }
            case 2100130: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100130, n2, 0));
                break;
            }
            case 2100132: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100132, n2, 0));
                break;
            }
            case 2100134: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100134, n2, 0));
                break;
            }
            case 2100136: {
                if (hMIViewArray[0] == null) break;
                ((OPSSectorController)hMIViewArray[0]).setVisible(!this.evaluateSimpleChoiceModelValueEqualsCondition(2100136, n2, 0));
                break;
            }
        }
    }

    private void executeConditionearlyAppsOPTScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 310: {
                if (hMIViewArray[0] == null) break;
                ((MenuController)hMIViewArray[0]).setSDSSymbolsVisible(this.evaluateSimpleChoiceModelValueGreaterCondition(310, n2, 0));
                break;
            }
            case 377: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101530, n2));
                break;
            }
            case 466: {
                if (hMIViewArray[0] != null) {
                    ((MirroredContainerController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101844, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MirroredContainerController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101845, n2));
                break;
            }
            case 469: {
                if (hMIViewArray[0] != null) {
                    ((MirroredContainerController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101844, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MirroredContainerController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101845, n2));
                break;
            }
            case 522: {
                if (hMIViewArray[0] != null) {
                    ((IconController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101801, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((IconController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101802, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MirroredContainerController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2101844, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((MirroredContainerController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2101845, n2));
                break;
            }
            case 3915: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101535, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101527, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2101529, n2));
                break;
            }
            case 3939: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101515, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101516, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2101531, n2));
                }
                if (hMIViewArray[3] != null) {
                    ((MenuItemController)hMIViewArray[3]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101517, n2));
                }
                if (hMIViewArray[4] != null) {
                    ((MenuItemController)hMIViewArray[4]).setVisible(hmiService.getComponentConditionManager().isTrue(0x201202, n2));
                }
                if (hMIViewArray[5] != null) {
                    ((MenuItemController)hMIViewArray[5]).setEnabled(hmiService.getComponentConditionManager().isTrue(0x201201, n2));
                }
                if (hMIViewArray[6] != null) {
                    ((MenuItemController)hMIViewArray[6]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101773, n2));
                }
                if (hMIViewArray[7] != null) {
                    ((MenuItemController)hMIViewArray[7]).setVisible(hmiService.getComponentConditionManager().isTrue(2101771, n2));
                }
                if (hMIViewArray[8] != null) {
                    ((MenuItemController)hMIViewArray[8]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101533, n2));
                }
                if (hMIViewArray[9] != null) {
                    ((MenuItemController)hMIViewArray[9]).setVisible(hmiService.getComponentConditionManager().isTrue(2101772, n2));
                }
                if (hMIViewArray[10] != null) {
                    ((MenuItemController)hMIViewArray[10]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101534, n2));
                }
                if (hMIViewArray[11] != null) {
                    ((MenuItemController)hMIViewArray[11]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101518, n2));
                }
                if (hMIViewArray[12] != null) {
                    ((MenuItemController)hMIViewArray[12]).setVisible(hmiService.getComponentConditionManager().isTrue(2101767, n2));
                }
                if (hMIViewArray[13] != null) {
                    ((MenuItemController)hMIViewArray[13]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101519, n2));
                }
                if (hMIViewArray[14] != null) {
                    ((MenuItemController)hMIViewArray[14]).setVisible(hmiService.getComponentConditionManager().isTrue(2101768, n2));
                }
                if (hMIViewArray[15] != null) {
                    ((MenuItemController)hMIViewArray[15]).setEnabled(hmiService.getComponentConditionManager().isTrue(0x201110, n2));
                }
                if (hMIViewArray[16] != null) {
                    ((MenuItemController)hMIViewArray[16]).setVisible(hmiService.getComponentConditionManager().isTrue(2101575, n2));
                }
                if (hMIViewArray[17] != null) {
                    ((MenuItemController)hMIViewArray[17]).setVisible(hmiService.getComponentConditionManager().isTrue(2101786, n2));
                }
                if (hMIViewArray[18] != null) {
                    ((MenuItemController)hMIViewArray[18]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101787, n2));
                }
                if (hMIViewArray[19] != null) {
                    ((MenuItemController)hMIViewArray[19]).setVisible(hmiService.getComponentConditionManager().isTrue(0x201112, n2));
                }
                if (hMIViewArray[20] != null) {
                    ((MenuItemController)hMIViewArray[20]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101788, n2));
                }
                if (hMIViewArray[21] != null) {
                    ((MenuItemController)hMIViewArray[21]).setVisible(hmiService.getComponentConditionManager().isTrue(2101523, n2));
                }
                if (hMIViewArray[22] != null) {
                    ((MenuItemController)hMIViewArray[22]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101631, n2));
                }
                if (hMIViewArray[23] != null) {
                    ((MenuItemController)hMIViewArray[23]).setVisible(hmiService.getComponentConditionManager().isTrue(2101524, n2));
                }
                if (hMIViewArray[24] != null) {
                    ((MenuItemController)hMIViewArray[24]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101632, n2));
                }
                if (hMIViewArray[25] != null) {
                    ((MenuItemController)hMIViewArray[25]).setVisible(hmiService.getComponentConditionManager().isTrue(2101789, n2));
                }
                if (hMIViewArray[26] != null) {
                    ((MenuItemController)hMIViewArray[26]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101790, n2));
                }
                if (hMIViewArray[27] != null) {
                    ((MenuItemController)hMIViewArray[27]).setVisible(hmiService.getComponentConditionManager().isTrue(2101525, n2));
                }
                if (hMIViewArray[28] != null) {
                    ((MenuItemController)hMIViewArray[28]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101526, n2));
                }
                if (hMIViewArray[29] != null) {
                    ((MenuItemController)hMIViewArray[29]).setVisible(hmiService.getComponentConditionManager().isTrue(2101535, n2));
                }
                if (hMIViewArray[30] != null) {
                    ((MenuItemController)hMIViewArray[30]).setEnabled(hmiService.getComponentConditionManager().isTrue(0x201120, n2));
                }
                if (hMIViewArray[31] != null) {
                    ((MenuItemController)hMIViewArray[31]).setVisible(hmiService.getComponentConditionManager().isTrue(2101527, n2));
                }
                if (hMIViewArray[32] != null) {
                    ((MenuItemController)hMIViewArray[32]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101528, n2));
                }
                if (hMIViewArray[33] != null) {
                    ((MenuItemController)hMIViewArray[33]).setVisible(hmiService.getComponentConditionManager().isTrue(2101529, n2));
                }
                if (hMIViewArray[34] != null) {
                    ((MenuItemController)hMIViewArray[34]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101530, n2));
                }
                if (hMIViewArray[35] != null) {
                    ((MenuItemController)hMIViewArray[35]).setVisible(hmiService.getComponentConditionManager().isTrue(2101742, n2));
                }
                if (hMIViewArray[36] != null) {
                    ((MenuItemController)hMIViewArray[36]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101745, n2));
                }
                if (hMIViewArray[37] != null) {
                    ((MenuItemController)hMIViewArray[37]).setVisible(hmiService.getComponentConditionManager().isTrue(2101743, n2));
                }
                if (hMIViewArray[38] != null) {
                    ((MenuItemController)hMIViewArray[38]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101746, n2));
                }
                if (hMIViewArray[39] != null) {
                    ((MenuItemController)hMIViewArray[39]).setVisible(hmiService.getComponentConditionManager().isTrue(2101744, n2));
                }
                if (hMIViewArray[40] == null) break;
                ((MenuItemController)hMIViewArray[40]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101747, n2));
                break;
            }
            case 4073: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(0x201120, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101528, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((MenuItemController)hMIViewArray[2]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101530, n2));
                break;
            }
            case 2100099: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101535, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(0x201120, n2));
                break;
            }
            case 2100101: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101527, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101528, n2));
                break;
            }
            case 2100156: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101525, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101526, n2));
                break;
            }
            case 2100166: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101575, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101524, n2));
                }
                if (hMIViewArray[2] != null) {
                    ((MenuItemController)hMIViewArray[2]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101632, n2));
                }
                if (hMIViewArray[3] == null) break;
                ((MenuItemController)hMIViewArray[3]).setVisible(hmiService.getComponentConditionManager().isTrue(2101525, n2));
                break;
            }
            case 2100176: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101525, n2));
                break;
            }
            case 2100177: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101524, n2));
                break;
            }
            case 2100178: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(0x201112, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101523, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2101525, n2));
                break;
            }
            case 2100179: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101575, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(0x201112, n2));
                break;
            }
            case 2100326: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(0x201112, n2));
                break;
            }
            case 2100333: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101515, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101516, n2));
                break;
            }
            case 2100335: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101575, n2));
                break;
            }
            case 2100360: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101773, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101771, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((MenuItemController)hMIViewArray[2]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101533, n2));
                break;
            }
            case 2100365: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101773, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101772, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((MenuItemController)hMIViewArray[2]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101534, n2));
                break;
            }
            case 2100382: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101531, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101517, n2));
                break;
            }
            case 2100406: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101523, n2));
                break;
            }
            case 2100466: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101788, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101631, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((MenuItemController)hMIViewArray[2]).setEnabled(!hmiService.getComponentConditionManager().isTrue(2101632, n2));
                break;
            }
            case 2100490: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101742, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101743, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((MenuItemController)hMIViewArray[2]).setVisible(hmiService.getComponentConditionManager().isTrue(2101744, n2));
                break;
            }
            case 2100491: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101742, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101745, n2));
                break;
            }
            case 2100492: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101743, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101746, n2));
                break;
            }
            case 2100494: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101744, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101747, n2));
                break;
            }
            case 2100507: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101518, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101767, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((MenuItemController)hMIViewArray[2]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101519, n2));
                break;
            }
            case 2100508: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101518, n2));
                }
                if (hMIViewArray[1] != null) {
                    ((MenuItemController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(2101768, n2));
                }
                if (hMIViewArray[2] == null) break;
                ((MenuItemController)hMIViewArray[2]).setEnabled(hmiService.getComponentConditionManager().isTrue(0x201110, n2));
                break;
            }
            case 2100509: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(0x201202, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(0x201201, n2));
                break;
            }
            case 2100527: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101786, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101787, n2));
                break;
            }
            case 2100532: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101788, n2));
                break;
            }
            case 2100553: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101789, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101790, n2));
                break;
            }
            case 2100562: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101789, n2));
                break;
            }
            case 2100708: {
                if (hMIViewArray[0] != null) {
                    ((MenuItemController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(2101529, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((MenuItemController)hMIViewArray[1]).setEnabled(hmiService.getComponentConditionManager().isTrue(2101530, n2));
                break;
            }
        }
    }

    public IPartialPopupController getPartialPopup(int n, int n2) {
        switch (n) {
            case 2100008: {
                return (IPartialPopupController)((Object)EarlyAppsScreenBag1.cARPOPUPPARKINGOPS(this, n2));
            }
            case 2100009: {
                return (IPartialPopupController)((Object)EarlyAppsScreenBag1.cARPOPUPPARKINGARATEXTS(this, n2));
            }
            case 2100010: {
                return (IPartialPopupController)((Object)EarlyAppsScreenBag1.cARPOPUPPARKINGPLATEXTSMAIN(this, n2));
            }
            case 2100016: {
                return (IPartialPopupController)((Object)EarlyAppsScreenBag1.cARPOPUPSEATRIGHT(this, n2));
            }
            case 2100017: {
                return (IPartialPopupController)((Object)EarlyAppsScreenBag1.cARPOPUPSEATLEFT(this, n2));
            }
            case 2100018: {
                return (IPartialPopupController)((Object)EarlyAppsScreenBag1.cARPOPUPSEATMEMORYLEFT(this, n2));
            }
            case 2100021: {
                return (IPartialPopupController)((Object)EarlyAppsScreenBag1.cARPOPUPSEATMEMORYRIGHT(this, n2));
            }
            case 2100035: {
                return (IPartialPopupController)((Object)EarlyAppsScreenBag1.cARPOPUPPARKINGPLATEXTSOPSLEFT(this, n2));
            }
            case 2100036: {
                return (IPartialPopupController)((Object)EarlyAppsScreenBag1.cARPOPUPPARKINGPLATEXTSPLASELECTION(this, n2));
            }
            case 2100038: {
                return (IPartialPopupController)((Object)EarlyAppsScreenBag1.cARPOPUPPARKINGPLATEXTOK(this, n2));
            }
            case 2100040: {
                return (IPartialPopupController)((Object)EarlyAppsScreenBag1.cARPOPUPPARKINGPLATEXTSOPSRIGHT(this, n2));
            }
            case 2100043: {
                return (IPartialPopupController)((Object)EarlyAppsScreenBag2.cARPOPUPPARKINGPLATEXTSPLAOUT(this, n2));
            }
            case 2100044: {
                return (IPartialPopupController)((Object)EarlyAppsScreenBag2.cARPOPUPPARKINGPLATEXTSOPSCENTER(this, n2));
            }
            case 2100045: {
                return (IPartialPopupController)((Object)EarlyAppsScreenBag2.cARPOPUPSOCCONTROLMAIN(this, n2));
            }
            case 2100071: {
                return (IPartialPopupController)((Object)EarlyAppsScreenBag2.cARPOPUPPARKINGARATEXTSCENTER(this, n2));
            }
        }
        return null;
    }

    public IPartialPopupController[] getPartialPopupStubs(int n) {
        return new IPartialPopupController[]{new PartialPopupStub(2100008, -1, -1, 135, 4, 1, true, 7, n, 2, null, true, true), new PartialPopupStub(2100009, -1, -1, 135, 9, 1, true, 7, n, 1, null, true, true), new PartialPopupStub(2100010, -1, -1, 12, 9, 1, true, 7, n, 2, null, true, true), new PartialPopupStub(2100016, 2100300, -1, 145, 2, 5, true, 7, n, 1, null, true, true), new PartialPopupStub(2100017, 2100301, -1, 145, 1, 5, true, 7, n, 1, null, true, true), new PartialPopupStub(2100018, -1, -1, 145, 1, 5, true, 7, n, 1, null, true, true), new PartialPopupStub(2100021, -1, -1, 145, 2, 5, true, 7, n, 1, null, true, true), new PartialPopupStub(2100035, -1, -1, 12, 9, 1, true, 7, n, 2, null, true, true), new PartialPopupStub(2100036, -1, -1, 12, 9, 1, true, 7, n, 2, null, true, true), new PartialPopupStub(2100038, -1, -1, 12, 9, 1, true, 7, n, 2, null, true, true), new PartialPopupStub(2100040, -1, -1, 12, 9, 1, true, 7, n, 2, null, true, true), new PartialPopupStub(2100043, -1, -1, 12, 9, 1, true, 7, n, 2, null, true, true), new PartialPopupStub(2100044, -1, -1, 12, 9, 1, true, 7, n, 2, null, true, true), new PartialPopupStub(2100045, 2100389, -1, 140, 0, 4, true, 7, n, 1, null, true, true), new PartialPopupStub(2100071, -1, -1, 135, 9, 1, true, 7, n, 1, null, true, true)};
    }

    public IDrawerController[] getOptionDrawers(int n) {
        return new IDrawerController[]{(IDrawerController)EarlyAppsScreenBag1.earlyAppsOPT(this, n)};
    }
}

