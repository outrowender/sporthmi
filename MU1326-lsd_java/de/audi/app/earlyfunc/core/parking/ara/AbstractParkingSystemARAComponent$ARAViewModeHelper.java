/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.ara;

import org.dsi.ifc.carparkingsystem.DisplayContent;

final class AbstractParkingSystemARAComponent$ARAViewModeHelper {
    private static DisplayContent lastDisplayContent;

    private AbstractParkingSystemARAComponent$ARAViewModeHelper() {
    }

    private static DisplayContent getDisplayContent(DisplayContent displayContent, int n, int n2, int n3, int n4) {
        boolean bl = AbstractParkingSystemARAComponent$ARAViewModeHelper.isFlankguard(displayContent);
        if (n == n3 && n2 == n4) {
            return displayContent;
        }
        DisplayContent displayContent2 = n == 1 && n2 == 1 ? (n3 == 1 && n4 == 0 ? new DisplayContent(bl ? 14 : 13, 2, 1, 12) : (n3 == 0 && n4 == 1 ? new DisplayContent(bl ? 8 : 3, AbstractParkingSystemARAComponent$ARAViewModeHelper.getLastShownScreen(displayContent.getScreen()), 1, 12) : AbstractParkingSystemARAComponent$ARAViewModeHelper.getFallbackDisplayContent(n3, n4))) : (n == 1 && n2 == 0 ? (n3 == 1 && n4 == 1 ? new DisplayContent(bl ? 11 : 10, displayContent.getScreen(), displayContent.getView(), displayContent.getMode()) : (n3 == 0 && n4 == 0 ? new DisplayContent(bl ? 8 : 3, 2, 1, 12) : AbstractParkingSystemARAComponent$ARAViewModeHelper.getFallbackDisplayContent(n3, n4))) : (n == 0 && n2 == 1 ? (n3 == 1 && n4 == 1 ? new DisplayContent(bl ? 11 : 10, displayContent.getScreen(), displayContent.getView(), displayContent.getMode()) : (n3 == 0 && n4 == 0 ? new DisplayContent(bl ? 8 : 3, displayContent.getScreen(), displayContent.getView(), displayContent.getMode()) : AbstractParkingSystemARAComponent$ARAViewModeHelper.getFallbackDisplayContent(n3, n4))) : (n == 0 && n2 == 0 ? (n3 == 1 && n4 == 0 ? new DisplayContent(bl ? 14 : 13, displayContent.getScreen(), displayContent.getView(), displayContent.getMode()) : (n3 == 0 && n4 == 1 ? new DisplayContent(bl ? 8 : 3, displayContent.getScreen(), displayContent.getView(), displayContent.getMode()) : AbstractParkingSystemARAComponent$ARAViewModeHelper.getFallbackDisplayContent(n3, n4))) : AbstractParkingSystemARAComponent$ARAViewModeHelper.getFallbackDisplayContent(n3, n4))));
        lastDisplayContent = displayContent2;
        return displayContent2;
    }

    private static int getLastShownScreen(int n) {
        if (n != 0) {
            return n;
        }
        if (lastDisplayContent.getScreen() != 0) {
            return lastDisplayContent.getScreen();
        }
        return 2;
    }

    private static DisplayContent getFallbackDisplayContent(int n, int n2) {
        DisplayContent displayContent = n == 1 && n2 == 1 ? new DisplayContent(10, 2, 0, 0) : (n == 1 && n2 == 0 ? new DisplayContent(13, 2, 1, 12) : (n == 0 && n2 == 1 ? new DisplayContent(3, 2, 1, 12) : (n == 0 && n2 == 0 ? new DisplayContent(3, 2, 1, 12) : null)));
        return displayContent;
    }

    private static int getViewModeARA(DisplayContent displayContent) {
        int n = displayContent.getPopup();
        if (3 == n || 8 == n) {
            return 0;
        }
        if (10 == n || 11 == n || 13 == n || 14 == n) {
            return 1;
        }
        return -1;
    }

    private static boolean isFlankguard(DisplayContent displayContent) {
        switch (displayContent.getPopup()) {
            case 7: 
            case 8: 
            case 11: 
            case 14: 
            case 15: 
            case 16: {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ DisplayContent access$000(DisplayContent displayContent, int n, int n2, int n3, int n4) {
        return AbstractParkingSystemARAComponent$ARAViewModeHelper.getDisplayContent(displayContent, n, n2, n3, n4);
    }

    static /* synthetic */ int access$100(DisplayContent displayContent) {
        return AbstractParkingSystemARAComponent$ARAViewModeHelper.getViewModeARA(displayContent);
    }
}

