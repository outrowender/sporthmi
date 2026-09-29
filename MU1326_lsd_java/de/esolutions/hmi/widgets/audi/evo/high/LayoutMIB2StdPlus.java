/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.esolutions.hmi.widgets.audi.base.Layout;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.evo.high.LayoutMIB2HighScale;

public class LayoutMIB2StdPlus
extends LayoutMIB2HighScale
implements Layout,
WidgetConstants {
    private static int[][] mainWizardIconDecoratorMapping = null;
    private static int[] mainWizardTextOffset = null;

    @Override
    public int getIntegerConstant(int n) {
        switch (n) {
            case 64: {
                return 60;
            }
        }
        return super.getIntegerConstant(n);
    }

    @Override
    public int[][] getMainWizardIconDecoratorMapping() {
        if (mainWizardIconDecoratorMapping == null) {
            mainWizardIconDecoratorMapping = new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}, {0, 0}, {0, 0}, {4, 4}, {0, 0}, {5, 5}, {6, 6}, {7, 7}, {8, 8}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}};
        }
        return mainWizardIconDecoratorMapping;
    }

    @Override
    public int[] getMainWizardTextOffset() {
        if (mainWizardTextOffset == null) {
            mainWizardTextOffset = new int[]{-4, -4, -7, -2, -3};
        }
        return mainWizardTextOffset;
    }
}

