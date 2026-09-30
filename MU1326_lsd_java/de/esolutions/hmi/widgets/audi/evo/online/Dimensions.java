/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.online;

import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;

public class Dimensions {
    public static int STAGE_LARGE = 0;
    public static int STAGE_SMALL = 1;
    public static final int DIMENSIONS_PER_STAGE = 4;
    public static final int X = 0;
    public static final int Y = 1;
    public static final int WIDTH = 2;
    public static final int HEIGHT = 3;
    public static final int FLAGS = 0;
    public static final int UNDEFINED = -1;
    public static final int[] STAGE_OFFSETS = new int[]{1, 5};
    public static int DIMENSIONS_SIZE = STAGE_OFFSETS[STAGE_OFFSETS.length - 1] + 4;

    private Dimensions() {
    }

    public static void setAll(AbstractWidgetController abstractWidgetController, int[] nArray, int n) {
        int[] nArray2 = abstractWidgetController.getCoordinateSets();
        if (nArray2 != null && nArray2.length == DIMENSIONS_SIZE) {
            abstractWidgetController.setCoordinateSets(nArray);
        }
        int n2 = STAGE_OFFSETS[n];
        abstractWidgetController.setX(nArray[n2 + 0]);
        abstractWidgetController.setY(nArray[n2 + 1]);
        abstractWidgetController.setWidth(nArray[n2 + 2]);
        abstractWidgetController.setHeight(nArray[n2 + 3]);
    }

    public static int[] getAll(AbstractWidgetController abstractWidgetController) {
        int[] nArray = abstractWidgetController.getCoordinateSets();
        if (nArray != null && nArray.length == DIMENSIONS_SIZE) {
            return (int[])nArray.clone();
        }
        int[] nArray2 = new int[DIMENSIONS_SIZE];
        nArray2[0] = -1;
        for (int i2 = 0; i2 < STAGE_OFFSETS.length; ++i2) {
            int n = STAGE_OFFSETS[i2];
            nArray2[n + 0] = abstractWidgetController.getX();
            nArray2[n + 1] = abstractWidgetController.getY();
            nArray2[n + 2] = abstractWidgetController.getWidth();
            nArray2[n + 3] = abstractWidgetController.getHeight();
        }
        return nArray2;
    }

    public static int getWidgetHeightInStage(AbstractWidgetController abstractWidgetController, int n) {
        int[] nArray = abstractWidgetController.getCoordinateSets();
        if (nArray != null && nArray.length == DIMENSIONS_SIZE) {
            return nArray[STAGE_OFFSETS[n] + 3];
        }
        return abstractWidgetController.getHeight();
    }
}

