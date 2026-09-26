/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.intercommunication.MixedListConstants;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListController2;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListLayout;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListPlaceholder;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListPlaceholderContainer;

public class MixedListLayoutPackage
implements MixedListConstants {
    public static boolean isKombi = false;
    public static boolean isNAR = false;
    public static boolean isAsia = false;
    public static boolean isJp = false;
    public static boolean isKr = false;

    public static final MixedListLayout createAsiaDestinationLayout(int n) {
        MixedListLayout mixedListLayout = new MixedListLayout(n);
        mixedListLayout.add(new MixedListPlaceholder(18, 5, 8, 226, 100));
        mixedListLayout.add(new MixedListPlaceholder(20, 1, 33, 100, 100));
        mixedListLayout.add(new MixedListPlaceholder(11, 63, 42, 170, 50));
        mixedListLayout.add(MixedListLayoutPackage.createBottomRowLayoutForDistanceAndTime());
        return mixedListLayout;
    }

    public static final MixedListLayout createAsiaDestination2Layout(int n) {
        MixedListLayout mixedListLayout = MixedListLayoutPackage.createAsiaDestinationLayout(n);
        mixedListLayout.add(new MixedListPlaceholder(5, 66, 35, 50, 50));
        mixedListLayout.getPlaceholderByModelColumn(11).setBounds(104, 42, 129, 50);
        return mixedListLayout;
    }

    public static final MixedListLayout createAsiaLaneGuidanceLayout1() {
        MixedListLayout mixedListLayout = new MixedListLayout(70);
        mixedListLayout.add(MixedListLayoutPackage.createTopRowForIconAndPrimaryTextAsia(new MixedListPlaceholder(21), new MixedListPlaceholder(18)));
        mixedListLayout.add(new MixedListPlaceholder(61, 5, 36, 100, 100));
        mixedListLayout.add(new MixedListPlaceholder(51, 6, 77, 228, 50));
        return mixedListLayout;
    }

    public static final MixedListLayout createAsiaLaneGuidanceLayout2() {
        MixedListLayout mixedListLayout = new MixedListLayout(71);
        mixedListLayout.add(new MixedListPlaceholder(21, 35, 18, 100, 100, true));
        mixedListLayout.add(new MixedListPlaceholder(18, 73, 9, 160, 50));
        mixedListLayout.add(new MixedListPlaceholder(61, 5, 36, 100, 100));
        mixedListLayout.add(new MixedListPlaceholder(51, 6, 77, 228, 50));
        return mixedListLayout;
    }

    private static final MixedListLayout createAsiaMotorwayBasicLayout(int n) {
        MixedListLayout mixedListLayout = new MixedListLayout(n);
        mixedListLayout.add(MixedListLayoutPackage.createTopRowForIconAndPrimaryText(new MixedListPlaceholder(5), new MixedListPlaceholder(18)));
        mixedListLayout.add(new MixedListPlaceholder(20, 1, 38, 100, 10));
        mixedListLayout.add(new MixedListPlaceholder(11, 63, 43, 168, 100));
        return mixedListLayout;
    }

    public static final MixedListLayout createAsiaMotorwayEntranceLayout() {
        MixedListLayout mixedListLayout = MixedListLayoutPackage.createAsiaMotorwayBasicLayout(93);
        mixedListLayout.add(new MixedListPlaceholder(51, 64, 77, 168, 50));
        return mixedListLayout;
    }

    public static final MixedListLayout createAsiaMotorwaySAPALayout() {
        MixedListLayout mixedListLayout = MixedListLayoutPackage.createAsiaMotorwayBasicLayout(95);
        mixedListLayout.add(MixedListLayoutPackage.createBottomRowLayoutForDistanceAndTime());
        return mixedListLayout;
    }

    public static final MixedListLayout createAsiaMotorwayICLayout() {
        MixedListLayout mixedListLayout = MixedListLayoutPackage.createAsiaMotorwaySAPALayout();
        mixedListLayout.setLayoutFormat(94);
        return mixedListLayout;
    }

    public static final MixedListLayout createAsiaMotorwayJCTLayout() {
        MixedListLayout mixedListLayout = MixedListLayoutPackage.createAsiaMotorwayICLayout();
        mixedListLayout.setLayoutFormat(96);
        return mixedListLayout;
    }

    public static final MixedListLayout createAsiaETCLayout() {
        MixedListLayout mixedListLayout = new MixedListLayout(92);
        int n = 9;
        if (isJp) {
            n = 10;
        } else if (isKr) {
            n = 11;
        }
        mixedListLayout.add(new MixedListPlaceholder(50, 7, 5, 100, 100, new Integer(n)));
        MixedListPlaceholder mixedListPlaceholder = new MixedListPlaceholder(54);
        if (!isKr) {
            mixedListPlaceholder.setBounds(56, 9, 170, 100);
        } else {
            mixedListPlaceholder.setBounds(70, 9, 156, 100);
        }
        mixedListLayout.add(mixedListPlaceholder);
        mixedListLayout.add(new MixedListPlaceholder(60, 5, 37, 200, 100));
        mixedListLayout.add(MixedListLayoutPackage.createBottomRowLayoutForDistanceAndTime(new MixedListPlaceholder(51), new MixedListPlaceholder(52)));
        return mixedListLayout;
    }

    public static final MixedListLayout createAsiaParkingAreaLayout() {
        MixedListLayout mixedListLayout = new MixedListLayout(75);
        mixedListLayout.add(new MixedListPlaceholder(5, 23, 19, 100, 100, true));
        mixedListLayout.add(new MixedListPlaceholder(54, 47, 9, 185, 100));
        mixedListLayout.add(new MixedListPlaceholder(6, 23, 52, 50, 50, true));
        mixedListLayout.add(new MixedListPlaceholder(7, 57, 52, 50, 50, true));
        mixedListLayout.add(new MixedListPlaceholder(8, 91, 52, 50, 50, true));
        mixedListLayout.add(MixedListLayoutPackage.createBottomRowLayoutForDistanceAndTime(new MixedListPlaceholder(51), new MixedListPlaceholder(52)));
        return mixedListLayout;
    }

    public static final MixedListLayout createAsiaOffroadWarningLayout() {
        MixedListLayout mixedListLayout = new MixedListLayout(89);
        mixedListLayout.add(new MixedListPlaceholder(18, 5, 8, 226, 100));
        mixedListLayout.add(new MixedListPlaceholder(58, 5, 42, 226, 100));
        mixedListLayout.add(new MixedListPlaceholder(51, MixedListLayoutPackage.getInnerWidth() - 229 - 7, 76, 229, 50, 1, 4));
        return mixedListLayout;
    }

    public static final MixedListLayout createAsiaSimpleEventLayout(int n) {
        MixedListLayout mixedListLayout = new MixedListLayout(n);
        mixedListLayout.add(MixedListLayoutPackage.createTopRowForIconAndPrimaryText(new MixedListPlaceholder(5), new MixedListPlaceholder(18)));
        mixedListLayout.add(new MixedListPlaceholder(51, MixedListLayoutPackage.getInnerWidth() - 229 - 7, 76, 229, 50, 1, 4));
        return mixedListLayout;
    }

    public static final MixedListLayout createAsiaSimpleEvent2Layout(int n) {
        MixedListLayout mixedListLayout = MixedListLayoutPackage.createAsiaSimpleEventLayout(n);
        MixedListPlaceholder mixedListPlaceholder = mixedListLayout.getPlaceholderByModelColumn(51);
        mixedListLayout.remove(mixedListPlaceholder);
        mixedListLayout.add(MixedListLayoutPackage.createBottomRowLayoutForDistanceAndTime(mixedListPlaceholder, new MixedListPlaceholder(52)));
        return mixedListLayout;
    }

    public static final MixedListLayout createAsiaSimpleEvent3Layout(int n) {
        MixedListLayout mixedListLayout = new MixedListLayout(n);
        int n2 = MixedListLayoutPackage.getInnerWidth();
        mixedListLayout.add(MixedListLayoutPackage.createTopRowForIconAndPrimaryText(new MixedListPlaceholder(5), new MixedListPlaceholder(11)));
        mixedListLayout.add(new MixedListPlaceholder(18, 4, 43, n2 - 16, 100));
        mixedListLayout.add(MixedListLayoutPackage.createBottomRowLayoutForDistanceAndTime(new MixedListPlaceholder(51), new MixedListPlaceholder(52)));
        return mixedListLayout;
    }

    public static final MixedListLayout createAsiaTollPaymentGateLayout() {
        MixedListLayout mixedListLayout = MixedListLayoutPackage.createAsiaSimpleEvent3Layout(97);
        MixedListPlaceholder mixedListPlaceholder = mixedListLayout.getPlaceholderByModelColumn(18);
        mixedListLayout.remove(mixedListPlaceholder);
        return mixedListLayout;
    }

    public static final MixedListLayout createBorderCrossingLayout() {
        MixedListPlaceholder mixedListPlaceholder = new MixedListPlaceholder(28);
        MixedListPlaceholder mixedListPlaceholder2 = new MixedListPlaceholder(29);
        MixedListPlaceholder mixedListPlaceholder3 = new MixedListPlaceholder(30);
        MixedListPlaceholder mixedListPlaceholder4 = new MixedListPlaceholder(31);
        MixedListPlaceholder mixedListPlaceholder5 = new MixedListPlaceholder(32);
        MixedListPlaceholder mixedListPlaceholder6 = new MixedListPlaceholder(33);
        MixedListPlaceholder mixedListPlaceholder7 = new MixedListPlaceholder(34);
        MixedListPlaceholder mixedListPlaceholder8 = new MixedListPlaceholder(35);
        MixedListPlaceholder mixedListPlaceholder9 = new MixedListPlaceholder(36);
        MixedListPlaceholder mixedListPlaceholder10 = new MixedListPlaceholder(37);
        MixedListPlaceholder mixedListPlaceholder11 = new MixedListPlaceholder(38);
        MixedListPlaceholder mixedListPlaceholder12 = new MixedListPlaceholder(27);
        MixedListLayout mixedListLayout = new MixedListLayout(6);
        mixedListLayout.add(mixedListPlaceholder);
        mixedListLayout.add(mixedListPlaceholder3);
        mixedListLayout.add(mixedListPlaceholder4);
        mixedListLayout.add(mixedListPlaceholder5);
        mixedListLayout.add(mixedListPlaceholder6);
        mixedListLayout.add(mixedListPlaceholder7);
        mixedListLayout.add(mixedListPlaceholder8);
        mixedListLayout.add(mixedListPlaceholder9);
        mixedListLayout.add(mixedListPlaceholder10);
        mixedListLayout.add(mixedListPlaceholder12);
        int n = MixedListLayoutPackage.getInnerWidth();
        if (isKombi) {
            mixedListPlaceholder.setBounds(5, 8, 175, 50);
            mixedListPlaceholder12.setBounds(188, 6, 100, 100);
            mixedListPlaceholder3.setBounds(15, 54, 100, 100);
            mixedListPlaceholder4.setBounds(75, 54, 100, 100);
            mixedListPlaceholder5.setBounds(134, 54, 100, 100);
            mixedListPlaceholder6.setBounds(193, 54, 100, 100);
            mixedListPlaceholder7.setBounds(6, 96, 100, 100);
            mixedListPlaceholder8.setBounds(66, 96, 100, 100);
            mixedListPlaceholder9.setBounds(125, 96, 100, 100);
            mixedListPlaceholder10.setBounds(184, 96, 100, 100);
        } else {
            mixedListLayout.add(mixedListPlaceholder2);
            mixedListLayout.add(mixedListPlaceholder11);
            mixedListPlaceholder12.setBounds(191, 6, 100, 100);
            mixedListPlaceholder3.setBounds(15, 74, 100, 100);
            mixedListPlaceholder4.setBounds(75, 74, 100, 100);
            mixedListPlaceholder5.setBounds(134, 74, 100, 100);
            mixedListPlaceholder6.setBounds(193, 74, 100, 100);
            mixedListPlaceholder7.setBounds(6, 117, 100, 100);
            mixedListPlaceholder8.setBounds(66, 117, 100, 100);
            mixedListPlaceholder9.setBounds(125, 117, 100, 100);
            mixedListPlaceholder10.setBounds(184, 117, 100, 100);
            mixedListPlaceholder.setBounds(4, 8, 175, 50);
            mixedListPlaceholder2.setBounds(4, 42, n - 16, 50);
            mixedListPlaceholder11.setBounds(0, 180, MixedListLayoutPackage.getInnerWidth() - 7, 50);
            mixedListPlaceholder11.setAlignment(3, 4);
        }
        return mixedListLayout;
    }

    public static final MixedListLayout createBorderCrossingSingleLayout() {
        MixedListLayout mixedListLayout = new MixedListLayout(8);
        int n = MixedListLayoutPackage.getInnerWidth();
        mixedListLayout.add(new MixedListPlaceholder(25, 5, 8, 176, 50));
        mixedListLayout.add(new MixedListPlaceholder(26, 5, 76, n - 16, 50));
        mixedListLayout.add(new MixedListPlaceholder(27, 191, 6, 0, 0));
        return mixedListLayout;
    }

    public static final MixedListLayout createBorderCrossingSingleLayoutNAR() {
        MixedListLayout mixedListLayout = new MixedListLayout(8);
        int n = MixedListLayoutPackage.getInnerWidth();
        mixedListLayout.add(new MixedListPlaceholder(25, 6, 9, 200, 50));
        mixedListLayout.add(new MixedListPlaceholder(26, 5, 77, n - 16, 50, 3, 4));
        mixedListLayout.add(new MixedListPlaceholder(27, n - 50, 7, 0, 0));
        mixedListLayout.add(new MixedListPlaceholder(24, n - 127, 40, 120, 50, 3, 4));
        return mixedListLayout;
    }

    public static final MixedListLayout createCalculatingLayout() {
        MixedListLayout mixedListLayout = new MixedListLayout(3);
        mixedListLayout.add(new MixedListPlaceholder(22, 0, 0, MixedListLayoutPackage.getInnerWidth(), MixedListLayoutPackage.getInnerHeight(), 2, 5));
        return mixedListLayout;
    }

    public static final MixedListLayout createDefaultLayout() {
        MixedListLayout mixedListLayout = new MixedListLayout(-1);
        mixedListLayout.add(new MixedListPlaceholder(-1, 0, 0, MixedListLayoutPackage.getInnerWidth(), MixedListLayoutPackage.getInnerHeight(), 2, 5));
        return mixedListLayout;
    }

    public static final MixedListLayout createDestinationLayout() {
        MixedListLayout mixedListLayout = new MixedListLayout(16);
        int n = MixedListLayoutPackage.getInnerWidth();
        mixedListLayout.add(new MixedListPlaceholder(54, 4, 8, n - 16, 50));
        mixedListLayout.add(new MixedListPlaceholder(20, 1, 33, 100, 100));
        MixedListPlaceholder mixedListPlaceholder = new MixedListPlaceholder(51);
        if (isNAR) {
            mixedListPlaceholder.setBounds(n - 158, 77, 150, 50);
            mixedListPlaceholder.setAlignment(3, 4);
        } else {
            mixedListPlaceholder.setBounds(64, 76, 168, 50);
        }
        mixedListLayout.add(mixedListPlaceholder);
        return mixedListLayout;
    }

    public static final MixedListLayout createTMCCar2XLayout() {
        MixedListLayout mixedListLayout = new MixedListLayout(18);
        int n = MixedListLayoutPackage.getInnerWidth();
        MixedListPlaceholder mixedListPlaceholder = new MixedListPlaceholder(3, 4, 8, n - 16, 50);
        MixedListPlaceholder mixedListPlaceholder2 = new MixedListPlaceholder(1, 30, 52, 0, 0, true);
        MixedListPlaceholder mixedListPlaceholder3 = new MixedListPlaceholder(67, 64, 42, n - 72, 50);
        MixedListPlaceholder mixedListPlaceholder4 = new MixedListPlaceholder(4, 64, 76, n - 128, 50);
        MixedListPlaceholder mixedListPlaceholder5 = new MixedListPlaceholder(50, 201, 72, 0, 0);
        mixedListPlaceholder5.additionalData = new Integer(7);
        mixedListLayout.add(mixedListPlaceholder);
        mixedListLayout.add(mixedListPlaceholder2);
        mixedListLayout.add(mixedListPlaceholder3);
        mixedListLayout.add(mixedListPlaceholder4);
        mixedListLayout.add(mixedListPlaceholder5);
        return mixedListLayout;
    }

    public static final MixedListLayout createPictureNavLayout() {
        MixedListLayout mixedListLayout = new MixedListLayout(9);
        mixedListLayout.add(new MixedListPlaceholder(20, 5, 0, 0, 0));
        mixedListLayout.add(new MixedListPlaceholder(19, 64, 129, 168, 50));
        mixedListLayout.add(new MixedListPlaceholder(45, 66, 6, 168, 114));
        return mixedListLayout;
    }

    public static final MixedListLayout createPictureNavLayoutNAR() {
        MixedListLayout mixedListLayout = new MixedListLayout(9);
        int n = MixedListLayoutPackage.getInnerWidth();
        mixedListLayout.add(new MixedListPlaceholder(20, 5, 0, 0, 0));
        mixedListLayout.add(new MixedListPlaceholder(19, 0, 181, n - 6, 50, 3, 4));
        mixedListLayout.add(new MixedListPlaceholder(45, 75, 10, 186, 165));
        return mixedListLayout;
    }

    public static final MixedListLayout createPictureNavSingleLayout() {
        MixedListLayout mixedListLayout = new MixedListLayout(17);
        mixedListLayout.add(new MixedListPlaceholder(20, 8, 0, 0, 0));
        mixedListLayout.add(new MixedListPlaceholder(19, 5, 76, 226, 100));
        mixedListLayout.add(new MixedListPlaceholder(45, 150, 9, 84, 83));
        return mixedListLayout;
    }

    public static final MixedListLayout createPictureNavSingleLayoutNAR() {
        MixedListLayout mixedListLayout = new MixedListLayout(17);
        int n = MixedListLayoutPackage.getInnerWidth();
        mixedListLayout.add(new MixedListPlaceholder(20, 8, 0, 0, 0));
        mixedListLayout.add(new MixedListPlaceholder(19, 5, 77, 226, 100));
        mixedListLayout.add(new MixedListPlaceholder(45, n - 91, 10, 84, 83));
        return mixedListLayout;
    }

    public static final MixedListLayout createAsiaPOILayout() {
        MixedListLayout mixedListLayout = new MixedListLayout(1);
        mixedListLayout.add(MixedListLayoutPackage.createTopRowForIconAndPrimaryText(new MixedListPlaceholder(5), new MixedListPlaceholder(11)));
        mixedListLayout.add(new MixedListPlaceholder(6, 5, 36, 100, 100));
        mixedListLayout.add(new MixedListPlaceholder(7, 40, 36, 100, 100));
        mixedListLayout.add(new MixedListPlaceholder(8, 75, 36, 100, 100));
        mixedListLayout.add(new MixedListPlaceholder(9, 110, 36, 100, 100));
        mixedListLayout.add(new MixedListPlaceholder(10, 145, 36, 100, 100));
        mixedListLayout.add(MixedListLayoutPackage.createBottomRowLayoutForDistanceAndTime(new MixedListPlaceholder(51), new MixedListPlaceholder(52)));
        return mixedListLayout;
    }

    public static final MixedListLayout createPOILayout() {
        MixedListLayout mixedListLayout = new MixedListLayout(1);
        int n = MixedListLayoutPackage.getInnerWidth();
        mixedListLayout.add(new MixedListPlaceholder(11, 4, 8, n - 16, 100));
        mixedListLayout.add(new MixedListPlaceholder(5, 5, 35, 100, 100));
        mixedListLayout.add(new MixedListPlaceholder(6, 40, 35, 100, 100));
        mixedListLayout.add(new MixedListPlaceholder(7, 75, 35, 100, 100));
        mixedListLayout.add(new MixedListPlaceholder(8, 110, 35, 100, 100));
        mixedListLayout.add(new MixedListPlaceholder(9, 145, 35, 100, 100));
        mixedListLayout.add(MixedListLayoutPackage.createBottomRowLayoutForDistanceAndTime(new MixedListPlaceholder(12), new MixedListPlaceholder(13)));
        return mixedListLayout;
    }

    public static final MixedListLayout createPOILayoutNAR() {
        MixedListLayout mixedListLayout = new MixedListLayout(1);
        int n = MixedListLayoutPackage.getInnerWidth();
        mixedListLayout.add(new MixedListPlaceholder(11, 4, 9, n - 16, 100));
        mixedListLayout.add(new MixedListPlaceholder(5, 6, 35, 100, 100));
        mixedListLayout.add(new MixedListPlaceholder(6, 41, 35, 100, 100));
        mixedListLayout.add(new MixedListPlaceholder(7, 76, 35, 100, 100));
        mixedListLayout.add(new MixedListPlaceholder(8, 111, 35, 100, 100));
        mixedListLayout.add(new MixedListPlaceholder(9, 146, 35, 100, 100));
        mixedListLayout.add(new MixedListPlaceholder(12, 5, 76, 109, 50));
        MixedListPlaceholder mixedListPlaceholder = new MixedListPlaceholder(13, n - 125, 76, 120, 50, 3, 4);
        if (!isKombi) {
            mixedListLayout.add(new MixedListPlaceholder(24, n - 125, 74, 120, 50, 3, 4, mixedListPlaceholder));
        } else {
            mixedListLayout.add(mixedListPlaceholder);
        }
        return mixedListLayout;
    }

    public static final MixedListLayout createTMCLayout() {
        MixedListLayout mixedListLayout = new MixedListLayout(2);
        int n = MixedListLayoutPackage.getInnerWidth();
        mixedListLayout.add(new MixedListPlaceholder(3, 4, 8, n - 16, 50));
        mixedListLayout.add(new MixedListPlaceholder(1, 30, 52, 0, 0, true));
        mixedListLayout.add(new MixedListPlaceholder(4, 5, 76, n - 16, 50));
        MixedListPlaceholder mixedListPlaceholder = new MixedListPlaceholder(2);
        mixedListPlaceholder.setBounds(66, 36, 0, 0);
        mixedListLayout.add(mixedListPlaceholder);
        return mixedListLayout;
    }

    public static final MixedListLayout createTMCLayoutAsia() {
        MixedListLayout mixedListLayout = new MixedListLayout(22);
        int n = MixedListLayoutPackage.getInnerWidth();
        mixedListLayout.add(new MixedListPlaceholder(1, 24, 20, 0, 0, true));
        mixedListLayout.add(new MixedListPlaceholder(3, 44, 10, n - 52, 50));
        mixedListLayout.add(new MixedListPlaceholder(66, 4, 40, n - 16, 50));
        mixedListLayout.add(new MixedListPlaceholder(4, 5, 76, n - 16, 50));
        mixedListLayout.add(new MixedListPlaceholder(63, 146, 76, n - 154, 50, 3, 4));
        return mixedListLayout;
    }

    public static final MixedListLayout createTMCLayoutNAR() {
        MixedListLayout mixedListLayout = new MixedListLayout(2);
        int n = MixedListLayoutPackage.getInnerWidth();
        mixedListLayout.add(new MixedListPlaceholder(3, 4, 9, n - 16, 50));
        mixedListLayout.add(new MixedListPlaceholder(1, -19, 11, 100, 100, 2, 5));
        mixedListLayout.add(new MixedListPlaceholder(4, n - (isKombi ? 128 : 158), 77, isKombi ? 120 : 150, 50, 3, 4));
        mixedListLayout.add(new MixedListPlaceholder(2, 66, 37, 100, 100));
        mixedListLayout.add(new MixedListPlaceholder(49, 112, 43, 30, 50, 2, 4));
        if (!isKombi) {
            mixedListLayout.add(new MixedListPlaceholder(24, 142, 40, 120, 50, 3, 4));
        }
        return mixedListLayout;
    }

    public static final MixedListLayout createTurnLayout() {
        MixedListLayout mixedListLayout = new MixedListLayout(0);
        int n = MixedListLayoutPackage.getInnerWidth();
        mixedListLayout.add(new MixedListPlaceholder(18, 4, 8, n - 16, 50));
        mixedListLayout.add(new MixedListPlaceholder(20, 1, 33, 100, 100));
        MixedListPlaceholder mixedListPlaceholder = new MixedListPlaceholder();
        if (isAsia) {
            mixedListPlaceholder.setModelColumn(51);
        } else {
            mixedListPlaceholder.setModelColumn(19);
        }
        mixedListPlaceholder.setBounds(64, 76, 168, 50);
        mixedListLayout.add(mixedListPlaceholder);
        MixedListPlaceholder mixedListPlaceholder2 = new MixedListPlaceholder(21);
        if (isAsia) {
            mixedListPlaceholder2.setCenterAligned(true);
            mixedListPlaceholder2.setBounds(94, 52, 100, 100);
        } else {
            mixedListPlaceholder2.setBounds(66, 36, 100, 100);
        }
        mixedListLayout.add(mixedListPlaceholder2);
        return mixedListLayout;
    }

    public static final MixedListLayout createTurnLayoutNAR_G24() {
        MixedListLayout mixedListLayout = new MixedListLayout(0);
        int n = 241;
        mixedListLayout.add(new MixedListPlaceholder(18, 4, 9, n - 16, 50));
        mixedListLayout.add(new MixedListPlaceholder(20, 4, 34, 100, 100));
        mixedListLayout.add(new MixedListPlaceholder(21, 66, 37, 100, 100));
        mixedListLayout.add(new MixedListPlaceholder(49, 112, 43, 30, 50, 2, 4));
        mixedListLayout.add(new MixedListPlaceholder(19, n - 128, 77, 120, 50, 3, 4));
        return mixedListLayout;
    }

    public static final MixedListLayout createTurnLayoutNAR() {
        MixedListLayout mixedListLayout = new MixedListLayout(0);
        int n = MixedListLayoutPackage.getInnerWidth();
        mixedListLayout.add(new MixedListPlaceholder(18, 4, 9, n - 16, 50));
        mixedListLayout.add(new MixedListPlaceholder(20, 4, 34, 100, 100));
        mixedListLayout.add(new MixedListPlaceholder(19, n - 158, 77, 150, 50, 3, 4));
        mixedListLayout.add(new MixedListPlaceholder(21, 66, 37, 100, 100));
        mixedListLayout.add(new MixedListPlaceholder(49, 112, 43, 30, 50, 2, 4));
        mixedListLayout.add(new MixedListPlaceholder(24, 141, 40, 120, 50, 3, 4));
        return mixedListLayout;
    }

    private static final int getInnerHeight() {
        return isKombi ? 99 : 104;
    }

    private static final int getInnerWidth() {
        return MixedListController2.getInnerWidth();
    }

    private static MixedListPlaceholderContainer createBottomRowLayoutForDistanceAndTime(MixedListPlaceholder mixedListPlaceholder, MixedListPlaceholder mixedListPlaceholder2) {
        MixedListPlaceholderContainer mixedListPlaceholderContainer = new MixedListPlaceholderContainer();
        mixedListPlaceholderContainer.placeholder = new MixedListPlaceholder[]{mixedListPlaceholder, mixedListPlaceholder2};
        GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
        GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
        gridLayoutHints2.setAlignmentHoriz(3);
        mixedListPlaceholderContainer.hints = new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2};
        mixedListPlaceholderContainer.layout = new GridLayout(2, 1);
        AxisConstraints axisConstraints = (AxisConstraints)mixedListPlaceholderContainer.layout.getColumnConstraints();
        axisConstraints.gaps = new int[]{0, 10, 0};
        axisConstraints.grow = new float[]{1.0f, 1.0f};
        mixedListPlaceholderContainer.setBounds(5, 76, MixedListLayoutPackage.getInnerWidth() - 12, 50);
        return mixedListPlaceholderContainer;
    }

    private static MixedListPlaceholderContainer createBottomRowLayoutForDistanceAndTime() {
        MixedListPlaceholder mixedListPlaceholder = new MixedListPlaceholder();
        mixedListPlaceholder.setModelColumn(51);
        MixedListPlaceholder mixedListPlaceholder2 = new MixedListPlaceholder();
        mixedListPlaceholder2.setModelColumn(63);
        MixedListPlaceholderContainer mixedListPlaceholderContainer = MixedListLayoutPackage.createBottomRowLayoutForDistanceAndTime(mixedListPlaceholder, mixedListPlaceholder2);
        mixedListPlaceholderContainer.setBounds(64, 76, 168, 50);
        return mixedListPlaceholderContainer;
    }

    private static MixedListPlaceholderContainer createTopRowForIconAndPrimaryText(MixedListPlaceholder mixedListPlaceholder, MixedListPlaceholder mixedListPlaceholder2) {
        MixedListPlaceholderContainer mixedListPlaceholderContainer = new MixedListPlaceholderContainer();
        mixedListPlaceholderContainer.placeholder = new MixedListPlaceholder[]{mixedListPlaceholder, mixedListPlaceholder2};
        GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
        gridLayoutHints.widthMax = 33;
        gridLayoutHints.heightMax = 33;
        gridLayoutHints.alignmentVert = 5;
        gridLayoutHints.alignmentHoriz = 2;
        GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
        mixedListPlaceholderContainer.hints = new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2};
        mixedListPlaceholderContainer.layout = new GridLayout(2, 1);
        AxisConstraints axisConstraints = (AxisConstraints)mixedListPlaceholderContainer.layout.getColumnConstraints();
        axisConstraints.gaps = new int[]{0, 10, 0};
        axisConstraints.grow = new float[]{0.0f, 1.0f};
        axisConstraints.setHidemode(new int[]{2, 2});
        AxisConstraints axisConstraints2 = (AxisConstraints)mixedListPlaceholderContainer.layout.getRowConstraints();
        axisConstraints2.alignment = new int[]{5};
        axisConstraints2.min = new int[]{33};
        mixedListPlaceholderContainer.setBounds(5, 3, MixedListLayoutPackage.getInnerWidth() - 12, 50);
        return mixedListPlaceholderContainer;
    }

    private static MixedListPlaceholderContainer createTopRowForIconAndPrimaryTextAsia(MixedListPlaceholder mixedListPlaceholder, MixedListPlaceholder mixedListPlaceholder2) {
        MixedListPlaceholderContainer mixedListPlaceholderContainer = new MixedListPlaceholderContainer();
        mixedListPlaceholderContainer.placeholder = new MixedListPlaceholder[]{mixedListPlaceholder, mixedListPlaceholder2};
        GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
        GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
        mixedListPlaceholderContainer.hints = new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2};
        mixedListPlaceholderContainer.layout = new GridLayout(2, 1);
        AxisConstraints axisConstraints = (AxisConstraints)mixedListPlaceholderContainer.layout.getColumnConstraints();
        axisConstraints.gaps = new int[]{0, 10, 0};
        axisConstraints.grow = new float[]{0.0f, 1.0f};
        axisConstraints.setHidemode(new int[]{2, 2});
        AxisConstraints axisConstraints2 = (AxisConstraints)mixedListPlaceholderContainer.layout.getRowConstraints();
        axisConstraints2.alignment = new int[]{5};
        axisConstraints2.grow = new float[]{1.0f};
        mixedListPlaceholderContainer.setBounds(5, -32, MixedListLayoutPackage.getInnerWidth() - 12, 100);
        return mixedListPlaceholderContainer;
    }

    public static final MixedListLayout createTrafficConcept() {
        MixedListLayout mixedListLayout = new MixedListLayout(21);
        int n = MixedListLayoutPackage.getInnerWidth();
        mixedListLayout.add(new MixedListPlaceholder(3, 4, 8, n - 16, 50));
        mixedListLayout.add(new MixedListPlaceholder(1, 30, 52, 0, 0, true));
        mixedListLayout.add(new MixedListPlaceholder(2, 66, 36, 0, 0));
        mixedListLayout.add(MixedListLayoutPackage.createBottomRowLayoutForDistanceAndTime(new MixedListPlaceholder(4), new MixedListPlaceholder(65)));
        return mixedListLayout;
    }

    public static final MixedListLayout createTrafficConceptNAR() {
        MixedListLayout mixedListLayout = new MixedListLayout(21);
        int n = MixedListLayoutPackage.getInnerWidth();
        mixedListLayout.add(new MixedListPlaceholder(3, 4, 9, n - 16, 50));
        mixedListLayout.add(new MixedListPlaceholder(1, -19, 11, 100, 100, 2, 5));
        mixedListLayout.add(new MixedListPlaceholder(2, 66, 37, 100, 100));
        mixedListLayout.add(new MixedListPlaceholder(49, 112, 43, 30, 50, 3, 4));
        mixedListLayout.add(new MixedListPlaceholder(4, n - (isKombi ? 128 : 158), 77, isKombi ? 120 : 150, 50, 3, 4));
        mixedListLayout.add(new MixedListPlaceholder(65, n - 108, 43, 100, 50, 3, 4));
        return mixedListLayout;
    }
}

