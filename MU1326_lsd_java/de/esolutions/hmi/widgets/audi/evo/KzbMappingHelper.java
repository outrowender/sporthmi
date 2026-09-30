/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.hmi.KzbFileNameMapping;
import de.audi.tghu.hmi.evo.ICarCodingHelper;
import de.audi.tghu.hmi.evo.IKzbMappingHelper;

public class KzbMappingHelper
implements IKzbMappingHelper {
    private static String empty;
    private static String balanceFader;
    private static String carParkingAra;
    private static String carParkingOps;
    private static String carViewer;
    private static String coverStack;
    private static String cursorWaitAnimation;
    private static String glassplateReflex;
    private static String inputField;
    private static String laneAssistBox;
    private static String mainWizard;
    private static String materialLibrary;
    private static String meccaCompass;
    private static String presetPopupHeadline;
    private static String rotary;
    private static String seat;
    private static String selectionDrawer;
    private static String sportHmi;
    private static String statusBar;
    private static String threePlusOneBox;
    private static String touchFieldFingerTracePlate;
    private static String userHints;

    public KzbMappingHelper(ICarCodingHelper iCarCodingHelper) {
        this.initialize(iCarCodingHelper.getCarType());
    }

    public void initialize(int n) {
        empty = KzbFileNameMapping.EMPTY;
        balanceFader = KzbFileNameMapping.BALANCE_FADER;
        coverStack = KzbFileNameMapping.COVERSTACK;
        cursorWaitAnimation = KzbFileNameMapping.GLASSPLATE;
        glassplateReflex = KzbFileNameMapping.GLASSPLATE;
        inputField = KzbFileNameMapping.SPELLER;
        laneAssistBox = KzbFileNameMapping.LANE_ASSIST_BOX;
        materialLibrary = KzbFileNameMapping.MATERIAL_LIBRARY;
        presetPopupHeadline = KzbFileNameMapping.PRESET_POPUP_HEADLINE;
        rotary = KzbFileNameMapping.ROTARY;
        selectionDrawer = KzbFileNameMapping.SELECTION_DRAWER;
        sportHmi = KzbFileNameMapping.SPORT_HMI;
        statusBar = KzbFileNameMapping.STATUSBAR;
        threePlusOneBox = KzbFileNameMapping.THREE_PLUS_ONE_BOX;
        touchFieldFingerTracePlate = KzbFileNameMapping.SPELLER;
        userHints = KzbFileNameMapping.USERHINT;
        switch (n) {
            case 10: {
                carParkingAra = KzbFileNameMapping.ARA_AU736;
                carParkingOps = KzbFileNameMapping.OPS_AU736;
                carViewer = KzbFileNameMapping.CARMENU_AU736;
                mainWizard = KzbFileNameMapping.MAINWIZARD_AU736;
                meccaCompass = KzbFileNameMapping.MEKKA_COMPASS_AU736;
                seat = KzbFileNameMapping.SEAT_VISUALIZATION_AU736;
                break;
            }
            case 11: {
                carParkingAra = KzbFileNameMapping.ARA_AU736;
                carParkingOps = KzbFileNameMapping.OPS_AU736;
                carViewer = KzbFileNameMapping.CARMENU_AU736_9;
                mainWizard = KzbFileNameMapping.MAINWIZARD_AU736;
                meccaCompass = KzbFileNameMapping.MEKKA_COMPASS_AU736;
                seat = KzbFileNameMapping.SEAT_VISUALIZATION_AU736;
                break;
            }
            case 12: {
                carParkingAra = KzbFileNameMapping.ARA_AU426;
                carParkingOps = KzbFileNameMapping.OPS_AU426;
                carViewer = KzbFileNameMapping.CARMENU_AU426;
                meccaCompass = KzbFileNameMapping.MEKKA_COMPASS_AU426;
                mainWizard = KzbFileNameMapping.MAINWIZARD_AU426;
                seat = KzbFileNameMapping.SEAT_VISUALIZATION_AU736;
                break;
            }
            case 14: {
                carParkingAra = KzbFileNameMapping.ARA_AU426;
                carParkingOps = KzbFileNameMapping.OPS_AU426;
                carViewer = KzbFileNameMapping.CARMENU_AU426_9;
                meccaCompass = KzbFileNameMapping.MEKKA_COMPASS_AU426;
                mainWizard = KzbFileNameMapping.MAINWIZARD_AU426;
                seat = KzbFileNameMapping.SEAT_VISUALIZATION_AU736;
                break;
            }
            case 13: {
                carParkingOps = KzbFileNameMapping.OPS_AU276;
                carViewer = KzbFileNameMapping.CARMENU_AU276;
                mainWizard = KzbFileNameMapping.MAINWIZARD_AU276;
                meccaCompass = KzbFileNameMapping.MEKKA_COMPASS_AU276;
                carParkingAra = KzbFileNameMapping.EMPTY;
                seat = KzbFileNameMapping.EMPTY;
                break;
            }
            case 30: {
                carParkingAra = KzbFileNameMapping.ARA_AU491;
                carParkingOps = KzbFileNameMapping.OPS_AU491;
                carViewer = KzbFileNameMapping.CARMENU_AU491;
                mainWizard = KzbFileNameMapping.MAINWIZARD_AU491;
                meccaCompass = KzbFileNameMapping.MEKKA_COMPASS_AU491;
                seat = KzbFileNameMapping.SEAT_VISUALIZATION_AU491;
                break;
            }
            case 31: {
                carParkingAra = KzbFileNameMapping.ARA_AU492;
                carParkingOps = KzbFileNameMapping.OPS_AU492;
                carViewer = KzbFileNameMapping.CARMENU_AU492;
                mainWizard = KzbFileNameMapping.MAINWIZARD_AU492;
                meccaCompass = KzbFileNameMapping.MEKKA_COMPASS_AU492;
                seat = KzbFileNameMapping.SEAT_VISUALIZATION_AU491;
                break;
            }
            case 32: {
                carParkingAra = KzbFileNameMapping.ARA_AU496;
                carParkingOps = KzbFileNameMapping.OPS_AU492;
                carViewer = KzbFileNameMapping.CARMENU_AU496;
                mainWizard = KzbFileNameMapping.MAINWIZARD_AU496;
                meccaCompass = KzbFileNameMapping.MEKKA_COMPASS_AU496;
                seat = KzbFileNameMapping.SEAT_VISUALIZATION_AU491;
                break;
            }
            case 33: {
                carParkingAra = KzbFileNameMapping.ARA_AU493;
                carParkingOps = KzbFileNameMapping.OPS_AU493;
                carViewer = KzbFileNameMapping.CARMENU_AU493;
                mainWizard = KzbFileNameMapping.MAINWIZARD_AU493;
                meccaCompass = KzbFileNameMapping.MEKKA_COMPASS_AU493;
                seat = KzbFileNameMapping.SEAT_VISUALIZATION_AU491;
                break;
            }
            case 34: {
                carParkingAra = KzbFileNameMapping.ARA_AU494;
                carParkingOps = KzbFileNameMapping.OPS_AU494;
                carViewer = KzbFileNameMapping.CARMENU_AU494;
                mainWizard = KzbFileNameMapping.MAINWIZARD_AU494;
                meccaCompass = KzbFileNameMapping.MEKKA_COMPASS_AU494;
                seat = KzbFileNameMapping.SEAT_VISUALIZATION_AU491;
                break;
            }
            case 35: {
                carParkingAra = KzbFileNameMapping.ARA_AU495;
                carParkingOps = KzbFileNameMapping.OPS_AU495;
                carViewer = KzbFileNameMapping.CARMENU_AU495;
                mainWizard = KzbFileNameMapping.MAINWIZARD_AU495;
                meccaCompass = KzbFileNameMapping.MEKKA_COMPASS_AU495;
                seat = KzbFileNameMapping.SEAT_VISUALIZATION_AU491;
                break;
            }
            case 20: {
                carViewer = KzbFileNameMapping.CARMENU_AU334;
                meccaCompass = KzbFileNameMapping.MEKKA_COMPASS_AU334;
                carParkingAra = KzbFileNameMapping.EMPTY;
                carParkingOps = KzbFileNameMapping.EMPTY;
                mainWizard = KzbFileNameMapping.EMPTY;
                seat = KzbFileNameMapping.EMPTY;
                break;
            }
            case 21: {
                carViewer = KzbFileNameMapping.CARMENU_AU335;
                meccaCompass = KzbFileNameMapping.MEKKA_COMPASS_AU335;
                carParkingAra = KzbFileNameMapping.EMPTY;
                carParkingOps = KzbFileNameMapping.EMPTY;
                mainWizard = KzbFileNameMapping.EMPTY;
                seat = KzbFileNameMapping.EMPTY;
                break;
            }
            case 40: {
                carViewer = KzbFileNameMapping.CARMENU_AU724;
                meccaCompass = KzbFileNameMapping.MEKKA_COMPASS_AU724;
                seat = KzbFileNameMapping.SEAT_VISUALIZATION_AU721;
                carParkingAra = KzbFileNameMapping.EMPTY;
                carParkingOps = KzbFileNameMapping.EMPTY;
                mainWizard = KzbFileNameMapping.EMPTY;
                break;
            }
            case 41: {
                carViewer = KzbFileNameMapping.CARMENU_AU724_8;
                meccaCompass = KzbFileNameMapping.MEKKA_COMPASS_AU724_8;
                seat = KzbFileNameMapping.SEAT_VISUALIZATION_AU721;
                carParkingAra = KzbFileNameMapping.EMPTY;
                carParkingOps = KzbFileNameMapping.EMPTY;
                mainWizard = KzbFileNameMapping.EMPTY;
                break;
            }
            case 42: {
                carViewer = KzbFileNameMapping.CARMENU_AU725;
                meccaCompass = KzbFileNameMapping.MEKKA_COMPASS_AU724;
                seat = KzbFileNameMapping.SEAT_VISUALIZATION_AU721;
                carParkingAra = KzbFileNameMapping.EMPTY;
                carParkingOps = KzbFileNameMapping.EMPTY;
                mainWizard = KzbFileNameMapping.EMPTY;
                break;
            }
            case 43: {
                carViewer = KzbFileNameMapping.CARMENU_AU725_8;
                meccaCompass = KzbFileNameMapping.MEKKA_COMPASS_AU725_8;
                seat = KzbFileNameMapping.SEAT_VISUALIZATION_AU721;
                carParkingAra = KzbFileNameMapping.EMPTY;
                carParkingOps = KzbFileNameMapping.EMPTY;
                mainWizard = KzbFileNameMapping.EMPTY;
                break;
            }
            case 44: {
                carViewer = KzbFileNameMapping.CARMENU_AU724_7;
                meccaCompass = KzbFileNameMapping.MEKKA_COMPASS_AU724;
                seat = KzbFileNameMapping.SEAT_VISUALIZATION_AU721;
                carParkingAra = KzbFileNameMapping.EMPTY;
                carParkingOps = KzbFileNameMapping.EMPTY;
                mainWizard = KzbFileNameMapping.EMPTY;
                break;
            }
            case 50: {
                carParkingOps = KzbFileNameMapping.OPS_AU370;
                carViewer = KzbFileNameMapping.CARMENU_AU370;
                mainWizard = KzbFileNameMapping.MAINWIZARD_AU370;
                meccaCompass = KzbFileNameMapping.MEKKA_COMPASS_AU370;
                carParkingAra = KzbFileNameMapping.EMPTY;
                seat = KzbFileNameMapping.EMPTY;
                break;
            }
            case 51: {
                carParkingOps = KzbFileNameMapping.OPS_AU371;
                carViewer = KzbFileNameMapping.CARMENU_AU371;
                mainWizard = KzbFileNameMapping.MAINWIZARD_AU371;
                meccaCompass = KzbFileNameMapping.MEKKA_COMPASS_AU371;
                carParkingAra = KzbFileNameMapping.EMPTY;
                seat = KzbFileNameMapping.EMPTY;
                break;
            }
            case 52: {
                carParkingOps = KzbFileNameMapping.OPS_AU373;
                carViewer = KzbFileNameMapping.CARMENU_AU373;
                mainWizard = KzbFileNameMapping.MAINWIZARD_AU373;
                meccaCompass = KzbFileNameMapping.MEKKA_COMPASS_AU373;
                carParkingAra = KzbFileNameMapping.EMPTY;
                seat = KzbFileNameMapping.EMPTY;
                break;
            }
            case 53: {
                carParkingOps = KzbFileNameMapping.OPS_AU375;
                carViewer = KzbFileNameMapping.CARMENU_AU375;
                mainWizard = KzbFileNameMapping.MAINWIZARD_AU375;
                meccaCompass = KzbFileNameMapping.MEKKA_COMPASS_AU375;
                carParkingAra = KzbFileNameMapping.EMPTY;
                seat = KzbFileNameMapping.EMPTY;
                break;
            }
            case 54: {
                carParkingOps = KzbFileNameMapping.OPS_AU373;
                carViewer = KzbFileNameMapping.CARMENU_AU373_9;
                mainWizard = KzbFileNameMapping.MAINWIZARD_AU373;
                meccaCompass = KzbFileNameMapping.MEKKA_COMPASS_AU373;
                carParkingAra = KzbFileNameMapping.EMPTY;
                seat = KzbFileNameMapping.EMPTY;
                break;
            }
            default: {
                carParkingAra = KzbFileNameMapping.EMPTY;
                carParkingOps = KzbFileNameMapping.EMPTY;
                carViewer = KzbFileNameMapping.EMPTY;
                mainWizard = KzbFileNameMapping.MAINWIZARD_EMPTY;
                meccaCompass = KzbFileNameMapping.EMPTY;
                seat = KzbFileNameMapping.EMPTY;
            }
        }
    }

    public String get(int n) {
        String string;
        switch (n) {
            case 1: {
                string = carParkingAra;
                break;
            }
            case 2: {
                string = balanceFader;
                break;
            }
            case 3: {
                string = carViewer;
                break;
            }
            case 4: {
                string = coverStack;
                break;
            }
            case 5: {
                string = cursorWaitAnimation;
                break;
            }
            case 6: {
                string = glassplateReflex;
                break;
            }
            case 7: {
                string = inputField;
                break;
            }
            case 8: {
                string = selectionDrawer;
                break;
            }
            case 9: {
                string = mainWizard;
                break;
            }
            case 10: {
                string = materialLibrary;
                break;
            }
            case 11: {
                string = meccaCompass;
                break;
            }
            case 12: {
                string = carParkingOps;
                break;
            }
            case 13: {
                string = presetPopupHeadline;
                break;
            }
            case 14: {
                string = rotary;
                break;
            }
            case 15: {
                string = seat;
                break;
            }
            case 16: {
                string = statusBar;
                break;
            }
            case 17: {
                string = threePlusOneBox;
                break;
            }
            case 18: {
                string = touchFieldFingerTracePlate;
                break;
            }
            case 19: {
                string = userHints;
                break;
            }
            case 20: {
                string = laneAssistBox;
                break;
            }
            case 21: {
                string = sportHmi;
                break;
            }
            default: {
                string = empty;
            }
        }
        return string;
    }
}

