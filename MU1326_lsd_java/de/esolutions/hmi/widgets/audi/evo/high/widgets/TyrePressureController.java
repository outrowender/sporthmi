/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.modelaccess.ListModelGUI;
import de.audi.tghu.hmi.evo.ICarCodingHelper;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MirroredContainerController;

public class TyrePressureController
extends AbstractWidgetController {
    private static final int[] DEFAULT_INIT = new int[]{1, 1, 1, 1, 1};
    private static final int DEFAULT_P_U = 1;
    private static final int DEFAULT_T_U = 1;
    private IRenderer renderer;
    private int[] tyrePressure = new int[5];
    private int[] tyreTemperature = new int[5];
    private int[] tyreState = new int[5];
    private int pressureUnit;
    private int temperatureUnit;
    private int axleWidth;
    private int frontAxleYPosition;
    private int rearAxleYPosition;
    private int rightTyreOffset;
    private int leftTyreOffset;
    static final int[][] OFFSET_FIXED_AXLE_FOR_CARS = new int[][]{{25, 170, 52, 1, 0}, {27, 172, 58, 1, 0}, {25, 164, 56, 0, 0}, {25, 170, 56, 2, 0}, {26, 170, 56, 2, 0}, {23, 161, 54, 2, 0}, {25, 170, 58, 1, 0}, {25, 170, 58, 2, 2}, {25, 170, 56, 2, 0}, {26, 170, 56, 2, -1}, {28, 166, 56, -1, -1}, {32, 170, 56, -1, -1}, {23, 167, 58, 1, 0}, {17, 86, 23, 1, 1}};
    static final int ROW_Q7 = 0;
    static final int ROW_B9_LIMO_ALLROAD = 1;
    static final int ROW_R8 = 2;
    static final int ROW_A3_COUPE_SPORTBACK_PHEV = 3;
    static final int ROW_B9_CABRIO = 4;
    static final int ROW_TT = 5;
    static final int ROW_Q5 = 6;
    static final int ROW_A3_CABRIO = 7;
    static final int ROW_A3_LIMO = 8;
    static final int ROW_B9_COUPE_SPORTBACK = 9;
    static final int ROW_R8_SPYDER = 10;
    static final int ROW_R8_ETRON = 11;
    static final int ROW_Q2 = 12;
    static final int ROW_Q2_G20STD = 13;
    static final int PICTURE_INDEX_LINE = 0;
    static final int PICTURE_INDEX_VARIANT_Q7_CAR = 1;
    static final int PICTURE_INDEX_VARIANT_Q7_WHEEL = 2;
    static final int PICTURE_INDEX_VARIANT_Q5_CAR = 3;
    static final int PICTURE_INDEX_VARIANT_B9_LIMO_CAR = 4;
    static final int PICTURE_INDEX_VARIANT_B9_AVANT_CAR = 5;
    static final int PICTURE_INDEX_VARIANT_A3_KURZHECK_CAR = 6;
    static final int PICTURE_INDEX_VARIANT_A3_SportBACK_CAR = 7;
    static final int PICTURE_INDEX_VARIANT_A3_CABRIO_CAR = 8;
    static final int PICTURE_INDEX_VARIANT_A3_LIMO_CAR = 9;
    static final int PICTURE_INDEX_VARIANT_B9_COUPE_CAR = 10;
    static final int PICTURE_INDEX_VARIANT_B9_SPORTBACK_CAR = 11;
    static final int PICTURE_INDEX_VARIANT_B9_Q5_A3_WHEEL = 12;
    static final int PICTURE_INDEX_VARIANT_TT3_CABRIO_CAR = 13;
    static final int PICTURE_INDEX_VARIANT_TT3_COUPE_CAR = 14;
    static final int PICTURE_INDEX_VARIANT_TT3_WHEEL_FRONT = 15;
    static final int PICTURE_INDEX_VARIANT_TT3_WHEEL_BACK = 16;
    static final int PICTURE_INDEX_VARIANT_R8_CAR_LHD = 17;
    static final int PICTURE_INDEX_VARIANT_R8_CAR_RHD = 26;
    static final int PICTURE_INDEX_VARIANT_R8_WHEEL_FRONT = 18;
    static final int PICTURE_INDEX_VARIANT_R8_WHEEL_BACK = 19;
    static final int PICTURE_INDEX_VARIANT_B9_CABRIO_CAR = 20;
    static final int PICTURE_INDEX_VARIANT_R8_ETRON_CAR = 21;
    static final int PICTURE_INDEX_VARIANT_R8_SPYDER_CAR = 22;
    static final int PICTURE_INDEX_VARIANT_R8_ETRON_SPYDER_WHEEL_BACK = 23;
    static final int PICTURE_INDEX_VARIANT_R8_ETRON_SPYDER_WHEEL_FRONT = 24;
    static final int PICTURE_INDEX_VARIANT_Q2_CAR = 25;
    static final int PICTURE_INDEX_VARIANT_Q2_WHEEL = 12;
    static final int PICTURE_INDEX_VARIANT_Q2_WHEEL_G20STD = 2;
    private int pictureIndexLine;
    private int pictureIndexCar;
    private int pictureIndexWheelFront;
    private int pictureIndexWheelBack;
    private boolean variantSettingsAreSet = false;

    protected void initializeWidget() {
        super.initializeWidget();
        this.updateModelValue();
        if (!this.variantSettingsAreSet) {
            this.updateVariantSpecificSettings();
            this.variantSettingsAreSet = true;
        }
    }

    private void updateModelValue() {
        if (this.model instanceof ListModelGUI) {
            ListModelGUI listModelGUI = (ListModelGUI)this.model;
            this.setTyrePressures(listModelGUI);
            this.setTyreTemperatures(listModelGUI);
            this.setTyreStates(listModelGUI);
            this.setPressureUnit(listModelGUI);
            this.setTemperatureUnit(listModelGUI);
        }
    }

    private void setTyrePressures(ListModelGUI listModelGUI) {
        try {
            for (int i2 = 0; i2 <= 4; ++i2) {
                this.tyrePressure[i2] = ((IntegerListCell)listModelGUI.getCell(i2, 0)).getValue();
            }
        }
        catch (Exception exception) {
            System.arraycopy((Object)DEFAULT_INIT, 0, (Object)this.tyrePressure, 0, 5);
            exception.printStackTrace();
        }
    }

    private void setTyreTemperatures(ListModelGUI listModelGUI) {
        try {
            for (int i2 = 5; i2 <= 9; ++i2) {
                this.tyreTemperature[i2 - 5] = ((IntegerListCell)listModelGUI.getCell(i2, 0)).getValue();
            }
        }
        catch (Exception exception) {
            System.arraycopy((Object)DEFAULT_INIT, 0, (Object)this.tyreTemperature, 0, 5);
            exception.printStackTrace();
        }
    }

    private void setTyreStates(ListModelGUI listModelGUI) {
        try {
            for (int i2 = 10; i2 <= 14; ++i2) {
                int n = ((IntegerListCell)listModelGUI.getCell(i2, 0)).getValue();
                if (n < 0 || n > 3) {
                    n = 3;
                }
                this.tyreState[i2 - 10] = n;
            }
        }
        catch (Exception exception) {
            System.arraycopy((Object)DEFAULT_INIT, 0, (Object)this.tyreState, 0, 5);
            exception.printStackTrace();
        }
    }

    private void setPressureUnit(ListModelGUI listModelGUI) {
        try {
            this.pressureUnit = ((IntegerListCell)listModelGUI.getCell(15, 0)).getValue();
        }
        catch (Exception exception) {
            this.pressureUnit = 1;
            exception.printStackTrace();
        }
    }

    private void setTemperatureUnit(ListModelGUI listModelGUI) {
        try {
            this.temperatureUnit = ((IntegerListCell)listModelGUI.getCell(16, 0)).getValue();
        }
        catch (Exception exception) {
            this.temperatureUnit = 1;
            exception.printStackTrace();
        }
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(IRenderer iRenderer) {
        this.renderer = iRenderer;
    }

    public int[] getTyrePressure() {
        return this.tyrePressure;
    }

    public int[] getTyreTemperature() {
        return this.tyreTemperature;
    }

    public int[] getTyreState() {
        return this.tyreState;
    }

    public int getPressureUnit() {
        return this.pressureUnit;
    }

    public int getTemperatureUnit() {
        return this.temperatureUnit;
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        this.updateModelValue();
        this.setCompositesDirty(true);
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    public int getFrontAxleYPosition() {
        return this.frontAxleYPosition;
    }

    public void setFrontAxleYPosition(int n) {
        this.frontAxleYPosition = n;
    }

    public int getRearAxleYPosition() {
        return this.rearAxleYPosition;
    }

    public void setRearAxleYPosition(int n) {
        this.rearAxleYPosition = n;
    }

    public int getAxleWidth() {
        return this.axleWidth;
    }

    public void setAxleWidth(int n) {
        this.axleWidth = n;
    }

    public boolean shouldTextsBeBackmirrored() {
        return this.getParent() instanceof MirroredContainerController;
    }

    void updateVariantSpecificSettings() {
        this.pictureIndexLine = 0;
        ICarCodingHelper iCarCodingHelper = this.terminal.getCarCodingHelper();
        if (iCarCodingHelper == null) {
            return;
        }
        switch (iCarCodingHelper.getCarType()) {
            case 10: 
            case 11: {
                this.pictureIndexCar = 1;
                this.pictureIndexWheelFront = 2;
                this.pictureIndexWheelBack = 2;
                this.setOffsetValues(0);
                break;
            }
            case 30: {
                this.pictureIndexCar = 4;
                this.pictureIndexWheelFront = 12;
                this.pictureIndexWheelBack = 12;
                this.setOffsetValues(1);
                break;
            }
            case 31: 
            case 32: {
                this.pictureIndexCar = 5;
                this.pictureIndexWheelFront = 12;
                this.pictureIndexWheelBack = 12;
                this.setOffsetValues(1);
                break;
            }
            case 40: 
            case 41: {
                this.pictureIndexCar = AbstractWidget.isRightHandDrive() ? 26 : 17;
                this.pictureIndexWheelFront = 18;
                this.pictureIndexWheelBack = 19;
                this.setOffsetValues(2);
                break;
            }
            case 50: {
                this.pictureIndexCar = 6;
                this.pictureIndexWheelFront = 12;
                this.pictureIndexWheelBack = 12;
                this.setOffsetValues(3);
                break;
            }
            case 52: 
            case 54: {
                this.pictureIndexCar = 7;
                this.pictureIndexWheelFront = 12;
                this.pictureIndexWheelBack = 12;
                this.setOffsetValues(3);
                break;
            }
            case 53: {
                this.pictureIndexCar = 8;
                this.pictureIndexWheelFront = 12;
                this.pictureIndexWheelBack = 12;
                this.setOffsetValues(7);
                break;
            }
            case 51: {
                this.pictureIndexCar = 9;
                this.pictureIndexWheelFront = 12;
                this.pictureIndexWheelBack = 12;
                this.setOffsetValues(8);
                break;
            }
            case 35: {
                this.pictureIndexCar = 20;
                this.pictureIndexWheelFront = 12;
                this.pictureIndexWheelBack = 12;
                this.setOffsetValues(4);
                break;
            }
            case 34: {
                this.pictureIndexCar = 10;
                this.pictureIndexWheelFront = 12;
                this.pictureIndexWheelBack = 12;
                this.setOffsetValues(9);
                break;
            }
            case 33: {
                this.pictureIndexCar = 11;
                this.pictureIndexWheelFront = 12;
                this.pictureIndexWheelBack = 12;
                this.setOffsetValues(9);
                break;
            }
            case 20: {
                this.pictureIndexCar = 14;
                this.pictureIndexWheelFront = 15;
                this.pictureIndexWheelBack = 16;
                this.setOffsetValues(5);
                break;
            }
            case 21: {
                this.pictureIndexCar = 13;
                this.pictureIndexWheelFront = 15;
                this.pictureIndexWheelBack = 16;
                this.setOffsetValues(5);
                break;
            }
            case 12: 
            case 14: {
                this.pictureIndexCar = 3;
                this.pictureIndexWheelFront = 12;
                this.pictureIndexWheelBack = 12;
                this.setOffsetValues(6);
                break;
            }
            case 42: 
            case 43: {
                this.pictureIndexCar = 22;
                this.pictureIndexWheelFront = 24;
                this.pictureIndexWheelBack = 23;
                this.setOffsetValues(10);
                break;
            }
            case 44: {
                this.pictureIndexCar = 21;
                this.pictureIndexWheelFront = 18;
                this.pictureIndexWheelBack = 19;
                this.setOffsetValues(11);
                break;
            }
            case 13: {
                this.pictureIndexCar = 25;
                if (AbstractWidget.framework.getScreenRes() == 0) {
                    this.pictureIndexWheelFront = 2;
                    this.pictureIndexWheelBack = 2;
                    this.setOffsetValues(13);
                    break;
                }
                this.pictureIndexWheelFront = 12;
                this.pictureIndexWheelBack = 12;
                this.setOffsetValues(12);
                break;
            }
            default: {
                this.pictureIndexCar = 1;
                this.pictureIndexWheelFront = 2;
                this.pictureIndexWheelBack = 2;
                this.setOffsetValues(0);
            }
        }
    }

    private void setOffsetValues(int n) {
        this.frontAxleYPosition = OFFSET_FIXED_AXLE_FOR_CARS[n][0];
        this.rearAxleYPosition = OFFSET_FIXED_AXLE_FOR_CARS[n][1];
        this.axleWidth = OFFSET_FIXED_AXLE_FOR_CARS[n][2];
        this.rightTyreOffset = OFFSET_FIXED_AXLE_FOR_CARS[n][3];
        this.leftTyreOffset = OFFSET_FIXED_AXLE_FOR_CARS[n][4];
    }

    public final int getPictureIndexLine() {
        return this.pictureIndexLine;
    }

    public final int getPictureIndexCar() {
        return this.pictureIndexCar;
    }

    public final int getPictureIndexWheelFront() {
        return this.pictureIndexWheelFront;
    }

    public final int getPictureIndexWheelBack() {
        return this.pictureIndexWheelBack;
    }

    public int getRightTyreOffset() {
        return this.rightTyreOffset;
    }

    public int getLeftTyreOffset() {
        return this.leftTyreOffset;
    }
}

