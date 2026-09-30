/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.ecall.hmi.evohighscale;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.LabelModel;
import de.audi.atip.hmi.model.sysconst.SysConstModel;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.hmi.view.HMIView;
import de.audi.atip.hmi.view.Screen;
import de.audi.tghu.ecall.hmi.evohighscale.EcallScreenBag1;
import de.audi.tghu.ecall.hmi.evohighscale.EcallScreenBag2;
import de.audi.tghu.ecall.hmi.evohighscale.FontFactory;
import de.esolutions.hmi.widgets.audi.base.FontLoader;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.ScreenWidgetEVO;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ScreenRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.WaitAnimController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import java.util.NoSuchElementException;

public class EcallScreenFactory
extends AbstractScreenFactory {
    private static HMIService hmiService;
    private static final int MODULE_ID = 33;
    private int[][] errorColors;
    public AbstractWidgetController[][] refWidgets = new AbstractWidgetController[8][1];

    public EcallScreenFactory(IFrameworkAccess iFrameworkAccess) {
        super(33, iFrameworkAccess);
        hmiService = iFrameworkAccess.getHMIService();
    }

    private int[][] getErrorColors() {
        if (this.errorColors == null) {
            this.errorColors = new int[][]{{-16777216, -7829368}, {-16777216, -7829368}, {-16777216, -7829368}, {-16777216, -7829368}, {-16777216, -7829368}};
        }
        return this.errorColors;
    }

    public String getName() {
        return "HMIEcallEvoHighScale";
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
            case 3300000: {
                return EcallScreenBag1.eCALLREFTEMPLATE(this, n2);
            }
            case 3300001: {
                return EcallScreenBag1.oPRPOPUPMANUALCONSIERGE(this, n2);
            }
            case 3300002: {
                return EcallScreenBag1.oPRPOPUPMANUALCALLCENTER(this, n2);
            }
            case 3300003: {
                return EcallScreenBag1.oPRPOPUPAUTOMATIC(this, n2);
            }
            case 3300005: {
                return EcallScreenBag1.oPRPOPUPDATAENDACTIVECALL(this, n2);
            }
            case 3300006: {
                return EcallScreenBag1.sOSPOPUPONLINELICENSENOTEWEBSHOP(this, n2);
            }
            case 3300007: {
                return EcallScreenBag1.oPRPOPUPDATACOLLECT(this, n2);
            }
            case 3300008: {
                return EcallScreenBag1.oPRPOPUPDATASEND(this, n2);
            }
            case 3300009: {
                return EcallScreenBag1.oPRPOPUPCONNECTING(this, n2);
            }
            case 3300010: {
                return EcallScreenBag1.oPRPOPUPCONNECTED(this, n2);
            }
            case 3300011: {
                return EcallScreenBag1.oPRPOPUPDISCONNECT(this, n2);
            }
            case 3300017: {
                return EcallScreenBag1.oPRDESTPOPUPMAIN(this, n2);
            }
            case 3300018: {
                return EcallScreenBag1.sOSPOPUPMECMAIN(this, n2);
            }
            case 3300019: {
                return EcallScreenBag1.sOSPOPUPCONNECTING(this, n2);
            }
            case 3300020: {
                return EcallScreenBag1.sOSPOPUPCONNECTED(this, n2);
            }
            case 3300021: {
                return EcallScreenBag1.sOSPOPUPSENDINGDATA(this, n2);
            }
            case 3300022: {
                return EcallScreenBag1.sOSPOPUPCALLBACKINCOMING(this, n2);
            }
            case 3300024: {
                return EcallScreenBag1.sOSPOPUPONLINELICENSENOTEMAIN(this, n2);
            }
            case 3300025: {
                return EcallScreenBag1.sOSPOPUPONLINELICENSEEXPIRENOTE(this, n2);
            }
            case 3300026: {
                return EcallScreenBag2.sOSPOPUPONLINELICENSEEXPIRENOTEWEBSHOP(this, n2);
            }
            case 3300027: {
                return EcallScreenBag2.sOSPOPUPLICENSETEASERNOTEMAIN(this, n2);
            }
            case 3300028: {
                return EcallScreenBag2.sOSPOPUPLICENSETEASERNOTEWEBSHOP(this, n2);
            }
            case 3300029: {
                return EcallScreenBag2.sOSPOPUPLICENSETEASEREXPIRENOTE(this, n2);
            }
            case 3300030: {
                return EcallScreenBag2.sOSPOPUPLICENSETEASEREXPIRENOTEWEBSHOP(this, n2);
            }
            case 3300031: {
                return EcallScreenBag2.oPRPOPUPCALLFAILED(this, n2);
            }
            case 3300032: {
                return EcallScreenBag2.sOSPOPUPACCOMPLISHED(this, n2);
            }
            case 3300035: {
                return EcallScreenBag2.sOSPOPUPCANCELED(this, n2);
            }
            case 3300036: {
                return EcallScreenBag2.sOSPOPUPFAILED(this, n2);
            }
            case 3300037: {
                return EcallScreenBag2.oPRPOPUPCANCELED(this, n2);
            }
            case 3300038: {
                return EcallScreenBag2.sOSPOPUPMECCONNECTING(this, n2);
            }
            case 3300039: {
                return EcallScreenBag2.sOSPOPUPMECCONNECTED(this, n2);
            }
            case 3300040: {
                return EcallScreenBag2.sOSPOPUPMECSENDINGDATA(this, n2);
            }
            case 3300041: {
                return EcallScreenBag2.sOSPOPUPMECFAILED1(this, n2);
            }
            case 3300042: {
                return EcallScreenBag2.sOSPOPUPMECREDIAL(this, n2);
            }
            case 3300043: {
                return EcallScreenBag2.sOSPOPUPMECACCOMPLISHED(this, n2);
            }
            case 3300044: {
                return EcallScreenBag2.sOSPOPUPMECFAILED(this, n2);
            }
            case 3300045: {
                return EcallScreenBag2.sOSPOPUPMECCANCELED(this, n2);
            }
            case 3300046: {
                return EcallScreenBag2.sOSPOPUPREDIAL(this, n2);
            }
        }
        return this.createDefaultScreen(n, n2);
    }

    public AbstractWidgetController getRefWidget(int n, int n2, EcallScreenFactory ecallScreenFactory) {
        IconController iconController = null;
        switch (n2) {
            case 0: {
                IconController iconController2 = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController2);
                iconController2.setRenderer(iconRendererHigh);
                iconController2.setBitmaps(new int[]{127, 127});
                iconController2.setBounds(0, 0, 100, 100);
                iconController = iconController2;
                break;
            }
            default: {
                this.getFramework().getLogChannel("ScreenFactory").log(10000, "Invalid reference widget id " + n2 + ".");
            }
        }
        this.refWidgets[n][n2] = iconController;
        return iconController;
    }

    protected static final boolean evalCond3300000(int n) {
        return ((SysConstModel)EcallScreenFactory.getModel(3939, n)).getValue() != 1;
    }

    protected static final boolean evalCond3300001(int n) {
        return ((SysConstModel)EcallScreenFactory.getModel(3939, n)).getValue() != 1;
    }

    protected static final boolean evalCond3300002(int n) {
        return ((ChoiceModel)EcallScreenFactory.getModel(167, n)).getValue() == 1 && ((ChoiceModel)EcallScreenFactory.getModel(4181, n)).getValue() == 1;
    }

    protected static final boolean evalCond3300003(int n) {
        return ((ChoiceModel)EcallScreenFactory.getModel(167, n)).getValue() == 1 && ((ChoiceModel)EcallScreenFactory.getModel(4181, n)).getValue() == 1;
    }

    protected static final boolean evalCond3300004(int n) {
        return ((ChoiceModel)EcallScreenFactory.getModel(167, n)).getValue() == 1 && ((ChoiceModel)EcallScreenFactory.getModel(4181, n)).getValue() == 1;
    }

    protected static final boolean evalCond3300005(int n) {
        return ((ChoiceModel)EcallScreenFactory.getModel(167, n)).getValue() == 1 && ((ChoiceModel)EcallScreenFactory.getModel(4181, n)).getValue() == 1;
    }

    protected static final boolean evalCond3300006(int n) {
        return ((ChoiceModel)EcallScreenFactory.getModel(167, n)).getValue() == 1 && ((ChoiceModel)EcallScreenFactory.getModel(4181, n)).getValue() == 1;
    }

    protected static final boolean evalCond3300007(int n) {
        return ((ChoiceModel)EcallScreenFactory.getModel(167, n)).getValue() == 1 && ((ChoiceModel)EcallScreenFactory.getModel(4181, n)).getValue() == 1;
    }

    protected static final boolean evalCond3300008(int n) {
        return ((ChoiceModel)EcallScreenFactory.getModel(167, n)).getValue() == 1 && ((ChoiceModel)EcallScreenFactory.getModel(4181, n)).getValue() == 1;
    }

    protected static final boolean evalCond3300009(int n) {
        return ((ChoiceModel)EcallScreenFactory.getModel(167, n)).getValue() == 1 && ((ChoiceModel)EcallScreenFactory.getModel(4181, n)).getValue() == 1;
    }

    protected static final boolean evalCond3300010(int n) {
        return ((ChoiceModel)EcallScreenFactory.getModel(167, n)).getValue() == 1 && ((ChoiceModel)EcallScreenFactory.getModel(4181, n)).getValue() == 1 && ((SysConstModel)EcallScreenFactory.getModel(442, n)).getValue() != 2;
    }

    protected static final boolean evalCond3300011(int n) {
        return ((ChoiceModel)EcallScreenFactory.getModel(167, n)).getValue() != 1 || ((ChoiceModel)EcallScreenFactory.getModel(4181, n)).getValue() != 1 || ((SysConstModel)EcallScreenFactory.getModel(442, n)).getValue() == 2;
    }

    protected static final boolean evalCond3300012(int n) {
        return ((ChoiceModel)EcallScreenFactory.getModel(167, n)).getValue() == 1 && ((ChoiceModel)EcallScreenFactory.getModel(4181, n)).getValue() == 1 && ((SysConstModel)EcallScreenFactory.getModel(442, n)).getValue() != 2;
    }

    protected static final boolean evalCond3300013(int n) {
        return ((ChoiceModel)EcallScreenFactory.getModel(167, n)).getValue() != 1 || ((ChoiceModel)EcallScreenFactory.getModel(4181, n)).getValue() != 1 || ((SysConstModel)EcallScreenFactory.getModel(442, n)).getValue() == 2;
    }

    public void executeCondition(int n, int n2, HMIView[] hMIViewArray, int n3) {
        switch (n2) {
            case 3300010: {
                this.executeConditionoPRPOPUPCONNECTEDScreen(n, hMIViewArray, n3);
                break;
            }
            case 3300007: {
                this.executeConditionoPRPOPUPDATACOLLECTScreen(n, hMIViewArray, n3);
                break;
            }
            case 3300008: {
                this.executeConditionoPRPOPUPDATASENDScreen(n, hMIViewArray, n3);
                break;
            }
            case 3300011: {
                this.executeConditionoPRPOPUPDISCONNECTScreen(n, hMIViewArray, n3);
                break;
            }
            case 3300020: {
                this.executeConditionsOSPOPUPCONNECTEDScreen(n, hMIViewArray, n3);
                break;
            }
            case 3300029: {
                this.executeConditionsOSPOPUPLICENSETEASEREXPIRENOTEScreen(n, hMIViewArray, n3);
                break;
            }
            case 3300039: {
                this.executeConditionsOSPOPUPMECCONNECTEDScreen(n, hMIViewArray, n3);
                break;
            }
            case 3300040: {
                this.executeConditionsOSPOPUPMECSENDINGDATAScreen(n, hMIViewArray, n3);
                break;
            }
            case 3300025: {
                this.executeConditionsOSPOPUPONLINELICENSEEXPIRENOTEScreen(n, hMIViewArray, n3);
                break;
            }
            case 3300021: {
                this.executeConditionsOSPOPUPSENDINGDATAScreen(n, hMIViewArray, n3);
                break;
            }
        }
    }

    private void executeConditionoPRPOPUPCONNECTEDScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 167: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(3300002, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(3300003, n2));
                break;
            }
            case 4181: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(3300002, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(3300003, n2));
                break;
            }
        }
    }

    private void executeConditionoPRPOPUPDATACOLLECTScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 3939: {
                if (hMIViewArray[0] == null) break;
                ((WaitAnimController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(3300000, n2));
                break;
            }
        }
    }

    private void executeConditionoPRPOPUPDATASENDScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 3939: {
                if (hMIViewArray[0] == null) break;
                ((WaitAnimController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(3300001, n2));
                break;
            }
        }
    }

    private void executeConditionoPRPOPUPDISCONNECTScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 167: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(3300004, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(3300005, n2));
                break;
            }
            case 4181: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(3300004, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(3300005, n2));
                break;
            }
        }
    }

    private void executeConditionsOSPOPUPCONNECTEDScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 167: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(3300006, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(3300007, n2));
                break;
            }
            case 4181: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(3300006, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(3300007, n2));
                break;
            }
        }
    }

    private void executeConditionsOSPOPUPLICENSETEASEREXPIRENOTEScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 363: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueEqualsCondition(363, n2, 1));
                break;
            }
        }
    }

    private void executeConditionsOSPOPUPMECCONNECTEDScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 167: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(3300010, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(3300011, n2));
                break;
            }
            case 442: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(3300010, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(3300011, n2));
                break;
            }
            case 4181: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(3300010, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(3300011, n2));
                break;
            }
        }
    }

    private void executeConditionsOSPOPUPMECSENDINGDATAScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 167: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(3300012, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(3300013, n2));
                break;
            }
            case 442: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(3300012, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(3300013, n2));
                break;
            }
            case 4181: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(3300012, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(hmiService.getComponentConditionManager().isTrue(3300013, n2));
                break;
            }
        }
    }

    private void executeConditionsOSPOPUPONLINELICENSEEXPIRENOTEScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 363: {
                if (hMIViewArray[0] == null) break;
                ((MenuItemController)hMIViewArray[0]).setEnabled(this.evaluateSimpleChoiceModelValueEqualsCondition(363, n2, 1));
                break;
            }
        }
    }

    private void executeConditionsOSPOPUPSENDINGDATAScreen(int n, HMIView[] hMIViewArray, int n2) {
        switch (n) {
            case 167: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(3300008, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(3300009, n2));
                break;
            }
            case 4181: {
                if (hMIViewArray[0] != null) {
                    ((LabelController)hMIViewArray[0]).setVisible(hmiService.getComponentConditionManager().isTrue(3300008, n2));
                }
                if (hMIViewArray[1] == null) break;
                ((LabelController)hMIViewArray[1]).setVisible(!hmiService.getComponentConditionManager().isTrue(3300009, n2));
                break;
            }
        }
    }
}

