/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.MetricsModel;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;
import de.audi.atip.metrics.GeoMetric;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.LineElement;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractInternalCursorWidgetController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IGeoPosConstants;
import de.esolutions.hmi.widgets.audi.evo.widgets.ITimeDateSetttingsRenderer;
import java.util.ArrayList;
import java.util.List;

public class GeoPosSettingsController
extends AbstractInternalCursorWidgetController
implements IGeoPosConstants {
    private static int cpDegree = 0;
    private static int cpMinutes = 1;
    private static int cpSeconds = 2;
    private static int cpSecondsAfterComma = 3;
    private static int cpDirection = 4;
    private static int cpDecimal1 = 1;
    private static int cpDecimal2 = 2;
    private static int cpDecimal3 = 3;
    private static int cpDecimal4 = 4;
    private static int cpDecimal5 = 5;
    private ChoiceModel triggerModel;
    private static final int INDEX_TEXT_N;
    private static final int INDEX_TEXT_E;
    private static final int INDEX_TEXT_S;
    private static final int INDEX_TEXT_W;
    private int[] textIDs;
    private boolean isDecimal = false;
    private int[][] geoValues;
    private int[][] geoValuesDecimal;
    private int[][] originalValues = new int[2][5];
    private ITimeDateSetttingsRenderer renderer;
    private int inputType = -1;

    private void adjustSmallerValues(boolean bl, int n) {
        if (bl) {
            for (int i2 = 1; i2 < 4; ++i2) {
                this.originalValues[n][i2] = this.geoValues[n][i2];
                this.geoValues[n][i2] = 0;
            }
        } else {
            for (int i3 = 1; i3 < 4; ++i3) {
                this.geoValues[n][i3] = this.originalValues[n][i3];
            }
        }
    }

    protected int calculateRequiredSpace(int[] nArray) {
        int n = this.renderer.getTextWidth("0");
        int n2 = 0;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            n2 = Math.max(n2, this.renderer.getTextWidth(this.getText(this.getTextID(nArray[i2]))));
        }
        int n3 = 8;
        int n4 = (n2 + n3) / n + 1;
        return n4 * n;
    }

    @Override
    public void connected(InitializationContext initializationContext) {
        boolean bl;
        super.connected(initializationContext);
        this.readDataFromModel();
        if (this.triggerModel == null) {
            this.triggerModel = (ChoiceModel)hmiService.getModel(153093632);
        }
        if (!(bl = this.terminal.getFramework().getLanguageMgr().isLeftToRightOrientation())) {
            cpDegree = 3;
            cpMinutes = 2;
            cpSeconds = 1;
            cpSecondsAfterComma = 0;
            cpDecimal1 = 4;
            cpDecimal2 = 3;
            cpDecimal3 = 2;
            cpDecimal4 = 1;
            cpDecimal5 = 0;
            cpDegree = this.getFormat() == 1 ? 5 : 3;
        } else {
            cpDegree = 0;
            cpMinutes = 1;
            cpSeconds = 2;
            cpSecondsAfterComma = 3;
            cpDecimal1 = 1;
            cpDecimal2 = 2;
            cpDecimal3 = 3;
            cpDecimal4 = 4;
            cpDecimal5 = 5;
        }
        cpDirection = this.getFormat() == 1 ? 6 : 4;
    }

    public static int[] convertDecimalToDegree(int[] nArray, int n, boolean bl) {
        double d2 = 0.0;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            d2 += (double)nArray[i2] * Math.pow(10.0, -(i2 + 1));
        }
        return GeoPosSettingsController.convertDecimalToDegree(d2, n, bl);
    }

    public static int[] convertDecimalToDegree(double d2, int n, boolean bl) {
        int n2 = (int)Math.floor(d2 *= 60.0);
        d2 -= (double)n2;
        int n3 = (int)Math.floor(d2 *= 60.0);
        int[] nArray = new int[2 + n];
        nArray[0] = n2;
        nArray[1] = n3;
        int n4 = 2;
        int n5 = n3;
        int n6 = 0;
        while (n6 < n) {
            d2 -= (double)n5;
            nArray[n4] = (int)Math.floor(d2 *= 10.0);
            n5 = nArray[n4];
            ++n6;
            ++n4;
        }
        if (bl) {
            n6 = n4 - 1;
            if (nArray[n6] >= 5) {
                nArray[n6] = 10;
                while (nArray[n6] == 10 && n6 >= 2) {
                    nArray[n6] = 0;
                    int n7 = n6 - 1;
                    nArray[n7] = nArray[n7] + 1;
                    --n6;
                }
                if (nArray[1] == 60) {
                    nArray[1] = 0;
                    nArray[0] = nArray[0] + 1;
                }
            } else {
                nArray[n6] = 0;
            }
        }
        return nArray;
    }

    public static int[] convertDegreeToDecimal(int n, int n2, int[] nArray, int n3, boolean bl) {
        int n4;
        double d2 = 0.0;
        for (n4 = 0; n4 < nArray.length; ++n4) {
            d2 += (double)nArray[n4] * Math.pow(10.0, -(n4 + 1));
        }
        double d3 = ((double)n + ((double)n2 + d2) / 60.0) / 60.0;
        int[] nArray2 = new int[n3];
        for (n4 = 0; n4 < n3; ++n4) {
            nArray2[n4] = (int)Math.floor(d3 *= 10.0);
            d3 -= (double)nArray2[n4];
        }
        if (bl) {
            if (nArray2[--n4] >= 5) {
                nArray2[n4] = 10;
                while (nArray2[n4] == 10 && n4 > 0) {
                    nArray2[n4] = 0;
                    int n5 = n4 - 1;
                    nArray2[n5] = nArray2[n5] + 1;
                    --n4;
                }
            } else {
                nArray2[n4] = 0;
            }
        }
        return nArray2;
    }

    private void copyDecimalToDegree() {
        if (this.geoValuesDecimal != null && this.geoValues != null) {
            int[] nArray = GeoPosSettingsController.convertDecimalToDegree(this.geoValuesDecimal[0], 2, true);
            int[] nArray2 = GeoPosSettingsController.convertDecimalToDegree(this.geoValuesDecimal[1], 2, true);
            this.geoValues[0][1] = nArray[0];
            this.geoValues[0][2] = nArray[1];
            this.geoValues[0][3] = nArray[2];
            this.geoValues[1][1] = nArray2[0];
            this.geoValues[1][2] = nArray2[1];
            this.geoValues[1][3] = nArray2[2];
        }
    }

    private void copyDegreeToDecimal() {
        if (this.geoValuesDecimal == null) {
            this.geoValuesDecimal = new int[2][];
        }
        if (this.geoValues != null) {
            this.geoValuesDecimal[0] = GeoPosSettingsController.convertDegreeToDecimal(this.geoValues[0][1], this.geoValues[0][2], new int[]{this.geoValues[0][3]}, 6, false);
            this.geoValuesDecimal[1] = GeoPosSettingsController.convertDegreeToDecimal(this.geoValues[1][1], this.geoValues[1][2], new int[]{this.geoValues[1][3]}, 6, false);
        }
    }

    @Override
    protected void enterEditableMode() {
        this.isInEditableMode = true;
        this.setHighlighted(true);
        this.cursorPosition = cpDegree;
        this.switchOFFParentMenuCursor();
        if (this.triggerModel != null) {
            this.triggerModel.itemFocused(this.getInputType(), this.terminal.getTerminalID());
        } else {
            menuItemLogCh.log(10000, "GeoPosSettingsController#exitEditableMode Application trigger model is not available.");
        }
    }

    @Override
    protected void exitEditableMode() {
        this.isInEditableMode = false;
        this.setHighlighted(false);
        this.cursorPosition = -1;
        this.switchONParentMenuCursor();
        this.writeDataToModel();
    }

    @Override
    protected void exitEditableModeWithoutSavings() {
        this.isInEditableMode = false;
        this.setHighlighted(false);
        this.cursorPosition = -1;
        this.switchONParentMenuCursor();
    }

    public int getGeoValue(int n, int n2) {
        if (this.geoValues != null) {
            return this.geoValues[n][n2];
        }
        return -1;
    }

    public int getGeoValueDecimal(int n, int n2) {
        if (this.geoValuesDecimal == null) {
            this.copyDegreeToDecimal();
        }
        return this.geoValuesDecimal[n][n2];
    }

    public int getInputType() {
        return this.inputType;
    }

    @Override
    public List getLineDescription() {
        int n;
        boolean bl = true;
        if (this.isConnected()) {
            bl = this.terminal.getFramework().getLanguageMgr().isLeftToRightOrientation();
        }
        ArrayList arrayList = new ArrayList(8);
        int n2 = this.getInputType();
        int n3 = this.getGeoValue(n2, 0);
        arrayList.add(new LineElement(new StringBuffer().append(n2 == 0 ? GeoPosSettingsController.appendOneLeadingZero(n3) : GeoPosSettingsController.appendTwoLeadingZeros(n3)).append(n3).toString(), true, this.renderer.getTextWidth("000"), bl ? 3 : 1));
        if (this.getFormat() == 0) {
            arrayList.add(new LineElement("\u00b0"));
            n3 = this.getGeoValue(n2, 1);
            arrayList.add(new LineElement(new StringBuffer().append(GeoPosSettingsController.appendOneLeadingZero(n3)).append(n3).toString(), true));
            arrayList.add(new LineElement("'"));
            n3 = this.getGeoValue(n2, 2);
            arrayList.add(new LineElement(new StringBuffer().append(GeoPosSettingsController.appendOneLeadingZero(n3)).append(n3).toString(), true));
            arrayList.add(new LineElement(","));
            arrayList.add(new LineElement(String.valueOf(this.getGeoValue(n2, 3)), true));
            arrayList.add(new LineElement("\""));
        } else {
            arrayList.add(new LineElement(","));
            for (n = 0; n < 5; ++n) {
                n3 = this.getGeoValueDecimal(n2, n);
                arrayList.add(new LineElement(String.valueOf(n3), true));
            }
            arrayList.add(new LineElement("\u00b0"));
        }
        n = this.calculateRequiredSpace(new int[]{2, 3, 4, 5});
        String string = "";
        string = n2 == 0 ? (this.getGeoValue(n2, 4) == 1 ? this.getText(this.getTextID(2)) : this.getText(this.getTextID(4))) : (this.getGeoValue(n2, 4) == 1 ? this.getText(this.getTextID(3)) : this.getText(this.getTextID(5)));
        arrayList.add(new LineElement(string, true, n, 2));
        if (!bl) {
            arrayList = this.getFormat() == 0 ? GeoPosSettingsController.permutate(arrayList, new int[]{7, 6, 5, 4, 3, 2, 1, 0, 8}) : GeoPosSettingsController.permutate(arrayList, new int[]{7, 6, 5, 4, 3, 2, 1, 0, 8});
        }
        return arrayList;
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    @Override
    public int getCursorIndex() {
        int n = this.getCursorPos();
        return n;
    }

    public int getFormat() {
        return this.isDecimal ? 1 : 0;
    }

    public int getTextID(int n) {
        if (this.textIDs != null && 0 <= n && n < this.textIDs.length) {
            return this.textIDs[n];
        }
        menuItemLogCh.log(10000, "GeoPosWidget#getTextID Failure getting text id %2. Field ist null? %1", this.textIDs == null, (long)n);
        return 0;
    }

    private void handleDecimalChange(int n, int n2, int n3) {
        int[] nArray = this.geoValuesDecimal[n2];
        int n4 = n3;
        nArray[n4] = nArray[n4] + n;
        int n5 = nArray[n4];
        if (n5 > 9) {
            int[] nArray2 = this.geoValuesDecimal[n2];
            int n6 = n3;
            nArray2[n6] = nArray2[n6] - 10;
            return;
        }
        if (n5 < 0) {
            int[] nArray3 = this.geoValuesDecimal[n2];
            int n7 = n3;
            nArray3[n7] = nArray3[n7] + 10;
            return;
        }
    }

    private void handleDegreeChange(int n, int n2, int n3) {
        if (n2 == 1) {
            if (this.geoValues[n2][n3] == 180) {
                this.adjustSmallerValues(false, n3);
            }
            this.updateWithBorders(n, 0, 180, n2, n3);
            if (this.geoValues[n2][n3] == 180) {
                this.adjustSmallerValues(true, n3);
            }
        } else {
            if (this.geoValues[n2][n3] == 90) {
                this.adjustSmallerValues(false, n3);
            }
            this.updateWithBorders(n, 0, 90, n2, n3);
            if (this.geoValues[n2][n3] == 90) {
                this.adjustSmallerValues(true, n3);
            }
        }
    }

    @Override
    public boolean isInEditableMode() {
        return this.isInEditableMode;
    }

    @Override
    public void keyMoved(JoystickEvent joystickEvent) {
        menuItemLogCh.log(-2137614336, "AbstractGeoPosController#keyMoved KeyCode = %1", (long)joystickEvent.getKeyCode());
        if (joystickEvent.getDirection() == 8 && this.getCurrentVisState() == 3) {
            joystickEvent.consume();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        menuItemLogCh.log(-2137614336, "AbstractGeoPosController#keyReleased KeyCode = %1", (long)keyEvent.getKeyCode());
        if (this.dds_pressed && keyEvent.getKeyCode() == 17) {
            this.menuEnterKeyPressed(keyEvent);
        } else if (keyEvent.getKeyCode() == 15) {
            this.backKeyPressed(keyEvent);
        }
    }

    private void menuEnterKeyPressed(KeyEvent keyEvent) {
        if (this.getCurrentVisState() == 1) {
            this.enterEditableMode();
        } else if (this.getCurrentVisState() == 3) {
            if (this.getFormat() == 0) {
                if (this.cursorPosition == cpDegree) {
                    this.cursorPosition = cpMinutes;
                } else if (this.cursorPosition == cpMinutes) {
                    this.cursorPosition = cpSeconds;
                } else if (this.cursorPosition == cpSeconds) {
                    this.cursorPosition = cpSecondsAfterComma;
                } else if (this.cursorPosition == cpSecondsAfterComma) {
                    this.cursorPosition = cpDirection;
                } else if (this.cursorPosition == cpDirection) {
                    this.exitEditableMode();
                } else {
                    menuItemLogCh.log(10000, "AbstractGeoPosController#keyReleased No case defined for cursorPosition = %1", (long)this.cursorPosition);
                }
            } else if (this.getFormat() == 1) {
                if (this.cursorPosition == cpDegree) {
                    this.cursorPosition = cpDecimal1;
                } else if (this.cursorPosition == cpDecimal1) {
                    this.cursorPosition = cpDecimal2;
                } else if (this.cursorPosition == cpDecimal2) {
                    this.cursorPosition = cpDecimal3;
                } else if (this.cursorPosition == cpDecimal3) {
                    this.cursorPosition = cpDecimal4;
                } else if (this.cursorPosition == cpDecimal4) {
                    this.cursorPosition = cpDecimal5;
                } else if (this.cursorPosition == cpDecimal5) {
                    this.cursorPosition = cpDirection;
                } else if (this.cursorPosition == cpDirection) {
                    this.exitEditableMode();
                } else {
                    menuItemLogCh.log(10000, "AbstractGeoPosController#keyReleased No case defined for cursorPosition = %1", (long)this.cursorPosition);
                }
            } else {
                menuItemLogCh.log(10000, "AbstractGeoPosController#keyReleased Unknown Format %1", (long)this.getFormat());
            }
        }
        this.setCompositesDirty(true);
        this.dds_pressed = false;
        keyEvent.consume();
    }

    private void backKeyPressed(KeyEvent keyEvent) {
        if (this.getCurrentVisState() == 3) {
            if (this.getFormat() == 0) {
                if (this.cursorPosition == cpDegree) {
                    this.exitEditableMode();
                } else if (this.cursorPosition == cpMinutes) {
                    this.cursorPosition = cpDegree;
                } else if (this.cursorPosition == cpSeconds) {
                    this.cursorPosition = cpMinutes;
                } else if (this.cursorPosition == cpSecondsAfterComma) {
                    this.cursorPosition = cpSeconds;
                } else if (this.cursorPosition == cpDirection) {
                    this.cursorPosition = cpSecondsAfterComma;
                } else {
                    menuItemLogCh.log(10000, "AbstractGeoPosController#keyReleased No case defined for cursorPosition = %1", (long)this.cursorPosition);
                }
            } else if (this.getFormat() == 1) {
                if (this.cursorPosition == cpDegree) {
                    this.exitEditableMode();
                } else if (this.cursorPosition == cpDecimal1) {
                    this.cursorPosition = cpDegree;
                } else if (this.cursorPosition == cpDecimal2) {
                    this.cursorPosition = cpDecimal1;
                } else if (this.cursorPosition == cpDecimal3) {
                    this.cursorPosition = cpDecimal2;
                } else if (this.cursorPosition == cpDecimal4) {
                    this.cursorPosition = cpDecimal3;
                } else if (this.cursorPosition == cpDecimal5) {
                    this.cursorPosition = cpDecimal4;
                } else if (this.cursorPosition == cpDirection) {
                    this.cursorPosition = cpDecimal5;
                } else {
                    menuItemLogCh.log(10000, "AbstractGeoPosController#keyReleased No case defined for cursorPosition = %1", (long)this.cursorPosition);
                }
            }
            this.setCompositesDirty(true);
            keyEvent.consume();
        }
    }

    @Override
    public void keyTurned1(WheelButtonEvent wheelButtonEvent) {
        if (this.getCurrentVisState() == 3 && this.isInEditableMode) {
            int n = wheelButtonEvent.getClickCount();
            int n2 = this.getInputType();
            if (this.getFormat() == 0) {
                if (this.cursorPosition == cpDegree) {
                    this.handleDegreeChange(n, n2, 0);
                } else if (this.cursorPosition == cpMinutes) {
                    this.updateWithBorders(n, 0, 59, n2, 1);
                } else if (this.cursorPosition == cpDirection) {
                    this.toggleValue(n, 1, -1, n2, 4);
                } else if (this.cursorPosition == cpSeconds) {
                    this.updateWithBorders(n, 0, 59, n2, 2);
                } else if (this.cursorPosition == cpSecondsAfterComma) {
                    this.updateWithBorders(n, 0, 9, n2, 3);
                } else {
                    menuItemLogCh.log(10000, "AbstractGeoPosController#keyTurned No case defined for cursorPosition = %1 in format = %2", (long)this.cursorPosition, (long)this.getFormat());
                }
            } else if (this.cursorPosition == cpDegree) {
                this.handleDegreeChange(n, n2, 0);
            } else if (this.cursorPosition == cpDecimal1) {
                this.handleDecimalChange(n, n2, 0);
            } else if (this.cursorPosition == cpDecimal2) {
                this.handleDecimalChange(n, n2, 1);
            } else if (this.cursorPosition == cpDecimal3) {
                this.handleDecimalChange(n, n2, 2);
            } else if (this.cursorPosition == cpDecimal4) {
                this.handleDecimalChange(n, n2, 3);
            } else if (this.cursorPosition == cpDecimal5) {
                this.handleDecimalChange(n, n2, 4);
            } else if (this.cursorPosition == cpDirection) {
                this.toggleValue(n, 1, -1, n2, 4);
            } else {
                menuItemLogCh.log(10000, "AbstractGeoPosController#keyTurned No case defined for cursorPosition = %1 in format = %2", (long)this.cursorPosition, (long)this.getFormat());
            }
            this.setCompositesDirty(true);
            wheelButtonEvent.consume();
        }
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        if (modelUpdateEvent.getModelType() == 9 && modelUpdateEvent.getUpdateType() != 2) {
            this.readDataFromModel();
            modelUpdateEvent.consume();
        }
    }

    private void readDataFromModel() {
        if (this.model != null && ((HMIModelGUI)this.model).getModelType() == 9) {
            GeoMetric geoMetric = null;
            if (((MetricsModel)this.model).getMetric() instanceof GeoMetric) {
                geoMetric = (GeoMetric)((MetricsModel)this.model).getMetric();
                geoMetric.format();
            }
            this.geoValues = GeoPosSettingsController.getDeepCopy(geoMetric != null ? geoMetric.getGeoValues() : (int[][])null);
        }
        if (this.geoValues == null) {
            return;
        }
        if (Math.abs(this.geoValues[0][4]) != 1) {
            this.geoValues[0][4] = 1;
        }
        if (Math.abs(this.geoValues[1][4]) != 1) {
            this.geoValues[1][4] = 1;
        }
        if (this.isDecimal) {
            this.copyDegreeToDecimal();
        }
    }

    public void setIsDecimal(boolean bl) {
        this.isDecimal = bl;
        if (this.getFormat() == 1) {
            this.copyDegreeToDecimal();
        } else {
            this.copyDecimalToDegree();
        }
    }

    public void setInputType(int n) {
        this.inputType = n;
    }

    public void setRenderer(ITimeDateSetttingsRenderer iTimeDateSetttingsRenderer) {
        this.renderer = iTimeDateSetttingsRenderer;
    }

    public void setTextIDs(int[] nArray) {
        this.textIDs = nArray;
    }

    private static int[][] getDeepCopy(int[][] nArray) {
        int[][] nArray2;
        if (nArray != null && nArray.length == 2) {
            nArray2 = new int[nArray.length][nArray[0].length];
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                for (int i3 = 0; i3 < nArray[0].length; ++i3) {
                    nArray2[i2][i3] = nArray[i2][i3];
                }
            }
        } else {
            menuItemLogCh.log(-2137614336, "GeoPosWidget#getDeepCopy original doesn't have right dimensions");
            nArray2 = new int[2][5];
        }
        return nArray2;
    }

    private void toggleValue(int n, int n2, int n3, int n4, int n5) {
        int n6 = this.geoValues[n4][n5];
        if (n % 2 != 0) {
            this.geoValues[n4][n5] = n6 == n2 ? n3 : n2;
        }
    }

    private void updateWithBorders(int n, int n2, int n3, int n4, int n5) {
        int n6 = this.geoValues[n4][n5];
        if (n6 + n < n2) {
            this.geoValues[n4][n5] = n3 + (n6 + n + 1) % n3;
        } else if (n6 + n > n3) {
            this.geoValues[n4][n5] = n2 + (n6 + n - 1) % n3;
        } else {
            int[] nArray = this.geoValues[n4];
            int n7 = n5;
            nArray[n7] = nArray[n7] + n;
        }
    }

    private void writeDataToModel() {
        if (this.isDecimal) {
            this.copyDecimalToDegree();
        }
        if (this.model != null && ((HMIModelGUI)this.model).getModelType() == 9) {
            GeoMetric geoMetric = null;
            if (((MetricsModel)this.model).getMetric() instanceof GeoMetric) {
                geoMetric = (GeoMetric)((MetricsModel)this.model).getMetric();
                geoMetric.setGeoValues(GeoPosSettingsController.getDeepCopy(this.geoValues));
                ((MetricsModel)this.model).metricsUpdated(this.terminal.getTerminalID());
            }
        }
    }
}

