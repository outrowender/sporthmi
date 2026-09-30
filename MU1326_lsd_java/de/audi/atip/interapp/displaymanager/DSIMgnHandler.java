/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.displaymanager;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.interapp.displaymanager.Cropping;
import org.dsi.ifc.displaymanagement.DSIDisplayManagement;

public class DSIMgnHandler {
    public static final int RATIO_4_3 = 0;
    public static final int RATIO_16_9 = 1;
    public static final int RATIO_15_9 = 2;
    public static final int RATIO_47_20 = 3;
    public static final int RATIO_ZOOM = 4;
    public static final int CROPPING_BASE_FULLSCREEN = 0;
    public static final int CROPPING_BASE_1440_640_360_1 = 1;
    public static final int CROPPING_BASE_1440_640_360_2 = 2;
    private final IFrameworkAccess frameworkAccess;

    public DSIMgnHandler(IFrameworkAccess iFrameworkAccess) {
        this.frameworkAccess = iFrameworkAccess;
    }

    private int[] getTargetOffsetXY(int n) {
        switch (n) {
            case 1: {
                return new int[]{400, 106};
            }
            case 2: {
                return new int[]{400, 90};
            }
        }
        return new int[]{0, 0};
    }

    private int[] getCroppingResolution(int n) {
        int n2 = this.frameworkAccess.getScreenRes();
        if (n == 0) {
            switch (n2) {
                case 1: {
                    return new int[]{800, 480};
                }
                case 2: {
                    return new int[]{1024, 480};
                }
                case 3: {
                    return new int[]{1280, 540};
                }
                case 4: {
                    return new int[]{1440, 540};
                }
                case 5: {
                    return new int[]{1680, 580};
                }
                case 6: {
                    return new int[]{1920, 580};
                }
            }
            throw new IllegalArgumentException("No valid system screen resolution set: " + n2);
        }
        if (n == 1 || n == 2) {
            return new int[]{640, 360};
        }
        throw new IllegalArgumentException("No valid video cropping base set: " + n);
    }

    public Cropping getCropping(int n) {
        int n2;
        int n3;
        int n4 = this.frameworkAccess.getSysConst(4348);
        int[] nArray = this.getTargetOffsetXY(n4);
        int[] nArray2 = this.getCroppingResolution(n4);
        switch (n) {
            case 0: {
                n3 = 4;
                n2 = 3;
                break;
            }
            case 1: {
                n3 = 16;
                n2 = 9;
                break;
            }
            case 2: {
                n3 = 15;
                n2 = 9;
                break;
            }
            case 3: {
                n3 = 47;
                n2 = 20;
                break;
            }
            case 4: {
                return new Cropping(nArray2[0], nArray2[1]);
            }
            default: {
                return null;
            }
        }
        return new Cropping(n3, n2, nArray2[0], nArray2[1], nArray[0], nArray[1]);
    }

    public void setCropping(int n, int n2, int n3, int n4, DSIDisplayManagement dSIDisplayManagement) {
        Cropping cropping = this.getCropping(n2);
        dSIDisplayManagement.setCropping(0, n, 0, 0, 0, 0, cropping.tgtX, cropping.tgtY, cropping.tgtWidth, cropping.tgtHeight);
    }

    public void setCropping(int n, int n2, int n3, int n4, int n5, int n6, int n7, DSIDisplayManagement dSIDisplayManagement) {
        Cropping cropping = this.getCropping(n3);
        dSIDisplayManagement.setCropping(n, n2, n4, n5, n6, n7, cropping.tgtX, cropping.tgtY, cropping.tgtWidth, cropping.tgtHeight);
    }
}

