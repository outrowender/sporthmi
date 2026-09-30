/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

public final class BckSpaceGestureHandlerConfig {
    public static final int MAX_DELTA_TIME = 1500;
    public static final int SPEEDUP_MAX_DELTA_TIME = 350;
    public static final int SLOWDOWN_STEP = 2;
    public static final int MAX_SPEED = 10;
    public static final int SCROLL_DELETE_FACTOR = 2;
    public static final int IDX_INT_MAX_DELTA_TIME = 0;
    public static final int IDX_INT_SPEEDUP_MAX_DELTA_TIME = 1;
    public static final int IDX_INT_SLOWDOWN_STEP = 2;
    public static final int IDX_INT_MAX_SPEED = 3;
    public static final int IDX_INT_SCROLL_DELETE_FACTOR = 4;
    public static final int NO_IDX_INT = 5;
    public static final int[][] INT_DEFAULT_CONFIG = new int[][]{{1500, 350, 2, 10, 2}, {1500, 350, 2, 10, 2}, {1500, 350, 2, 10, 2}};
    public static final String INT_ARRAY_EL_NAMES = "{ MAX_DELTA_TIME, SPEEDUP_MAX_DELTA_TIME, SLOWDOWN_STEP, MAX_SPEED, SCROLL_DELETE_FACTOR };";
    public static final float SPEEDUP_FACTOR = 1.3f;
    public static final float SLOWDOWN_FACTOR = 1.5f;
    public static final float RESET_FACTOR = 2.2f;
    public static final float MAX_SPEED_FACTOR = 1.2f;
    public static final float MAX_SPEED_ADD = 0.7f;
    public static final int IDX_FLOAT_SPEEDUP_FACTOR = 0;
    public static final int IDX_FLOAT_SLOWDOWN_FACTOR = 1;
    public static final int IDX_FLOAT_RESET_FACTOR = 2;
    public static final int IDX_FLOAT_MAX_SPEED_FACTOR = 3;
    public static final int IDX_FLOAT_MAX_SPEED_ADD = 4;
    public static final int NO_IDX_FLOAT = 5;
    public static final float[][] FLOAT_DEFAULT_CONFIG = new float[][]{{1.3f, 1.5f, 2.2f, 1.2f, 0.7f}, {1.3f, 1.5f, 2.2f, 1.2f, 0.7f}, {1.3f, 1.5f, 2.2f, 1.2f, 0.7f}};
    public static final String FLOAT_ARRAY_EL_NAMES = "{ SPEEDUP_FACTOR, SLOWDOWN_FACTOR, RESET_FACTOR, MAX_SPEED_FACTOR, MAX_SPEED_ADD };";
    public static final int IDX_KEYPNL_FIRST = -1;
    public static final int IDX_KEYPNL_OLD = 0;
    public static final int IDX_KEYPNL_NEW_ROTARY = 1;
    public static final int IDX_KEYPNL_NEW_BIG = 2;
    public static final int IDX_KEYPNL_LAST = 3;
    private static volatile BckSpaceGestureHandlerConfig thisIsJimmy = null;
    private volatile int[][] m_intConfig;
    private volatile float[][] m_floatConfig;

    private BckSpaceGestureHandlerConfig(int[][] nArray, float[][] fArray) {
        this.m_intConfig = nArray;
        this.m_floatConfig = fArray;
    }

    public static int getTouchPadType(int n) {
        int n2 = 1;
        switch (n) {
            case 5: {
                n2 = 1;
                break;
            }
            case 6: {
                n2 = 2;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    public static synchronized BckSpaceGestureHandlerConfig getInstance() {
        if (thisIsJimmy == null) {
            System.out.println();
            if (INT_DEFAULT_CONFIG != null && 3 == INT_DEFAULT_CONFIG.length && FLOAT_DEFAULT_CONFIG != null && 3 == FLOAT_DEFAULT_CONFIG.length) {
                int[][] nArrayArray = new int[INT_DEFAULT_CONFIG.length][];
                for (int i2 = 0; i2 < nArrayArray.length; ++i2) {
                    if (INT_DEFAULT_CONFIG[i2] == null) {
                        return null;
                    }
                    nArrayArray[i2] = new int[INT_DEFAULT_CONFIG[i2].length];
                    System.arraycopy((Object)INT_DEFAULT_CONFIG[i2], 0, (Object)nArrayArray[i2], 0, nArrayArray[i2].length);
                }
                float[][] fArrayArray = new float[FLOAT_DEFAULT_CONFIG.length][];
                for (int i3 = 0; i3 < fArrayArray.length; ++i3) {
                    if (FLOAT_DEFAULT_CONFIG[i3] == null) {
                        return null;
                    }
                    fArrayArray[i3] = new float[FLOAT_DEFAULT_CONFIG[i3].length];
                    System.arraycopy((Object)FLOAT_DEFAULT_CONFIG[i3], 0, (Object)fArrayArray[i3], 0, fArrayArray[i3].length);
                }
                thisIsJimmy = new BckSpaceGestureHandlerConfig(nArrayArray, fArrayArray);
            }
        }
        return thisIsJimmy;
    }

    private boolean checkFMat(int n) {
        return this.m_floatConfig != null && n > -1 && n < this.m_floatConfig.length && this.m_floatConfig[n] != null;
    }

    private boolean checkFArr(int n, int n2) {
        return this.checkFMat(n) && n2 > -1 && n2 < this.m_floatConfig[n].length;
    }

    private boolean checkIMat(int n) {
        return this.m_intConfig != null && n > -1 && n < this.m_intConfig.length && this.m_intConfig[n] != null;
    }

    private boolean checkIArr(int n, int n2) {
        return this.checkIMat(n) && n2 > -1 && n2 < this.m_intConfig[n].length;
    }

    public void setConfigFloat(int n, int n2, float f2) {
        if (this.checkFArr(n, n2)) {
            this.m_floatConfig[n][n2] = f2;
        }
    }

    public float getConfigFloat(int n, int n2) {
        if (this.checkFArr(n, n2)) {
            return this.m_floatConfig[n][n2];
        }
        return Float.NaN;
    }

    public synchronized void setConfigFloats(int n, float[] fArray) {
        if (this.checkFMat(n) && fArray != null && this.m_floatConfig[n].length <= fArray.length) {
            System.arraycopy((Object)fArray, 0, (Object)this.m_floatConfig[n], 0, this.m_floatConfig[n].length);
        }
    }

    public synchronized float[] getConfigFloats(int n, float[] fArray) {
        float[] fArray2 = null;
        if (this.checkFMat(n)) {
            fArray2 = fArray != null && fArray.length >= this.m_floatConfig[n].length ? fArray : new float[this.m_floatConfig[n].length];
            System.arraycopy((Object)this.m_floatConfig[n], 0, (Object)fArray2, 0, fArray2.length);
        }
        return fArray2;
    }

    public synchronized void setConfigInt(int n, int n2, int n3) {
        if (this.checkIArr(n, n2)) {
            this.m_intConfig[n][n2] = n3;
        }
    }

    public synchronized int getConfigInt(int n, int n2) {
        if (this.checkIArr(n, n2)) {
            return this.m_intConfig[n][n2];
        }
        return -1;
    }

    public synchronized void setConfigInts(int n, int[] nArray) {
        if (this.checkIMat(n) && nArray != null && this.m_intConfig[n].length <= nArray.length) {
            System.arraycopy((Object)nArray, 0, (Object)this.m_intConfig[n], 0, this.m_intConfig[n].length);
        }
    }

    public synchronized int[] getConfigInts(int n, int[] nArray) {
        int[] nArray2 = null;
        if (this.checkIMat(n)) {
            nArray2 = nArray != null && nArray.length >= this.m_intConfig[n].length ? nArray : new int[this.m_intConfig[n].length];
            System.arraycopy((Object)this.m_intConfig[n], 0, (Object)nArray2, 0, nArray2.length);
        }
        return nArray2;
    }
}

