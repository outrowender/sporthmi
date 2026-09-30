/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.mer;

import de.audi.app.car.common.mer.IMenuEntry;
import de.audi.app.car.common.mer.IMenuEntryStructure;
import de.audi.app.car.common.mer.IncludeMenuEntry;
import de.audi.app.car.common.mer.MenuEntry;
import de.audi.app.car.common.mer.MenuEntryPersistence;
import de.audi.app.car.common.mer.SlotMenuEntry;
import de.audi.app.car.evo.mer.CarEvoMenuEntryIDs;
import de.audi.app.car.evo.mer.EvoMenuEntryFactory;
import de.audi.app.car.evo.mer.MenuEntryMMICombi;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.atip.sysapp.carcoding.CarFuncAdap;
import java.util.HashMap;

public class CarEvoMenuEntryStructure
implements IMenuEntryStructure,
CarEvoMenuEntryIDs {
    private final HashMap menuEntries;
    private final IFrameworkAccess framework;
    private final EvoMenuEntryFactory entryFactory;

    public CarEvoMenuEntryStructure(IFrameworkAccess iFrameworkAccess, LogChannel logChannel, CarFuncAdap carFuncAdap) {
        MenuEntry menuEntry;
        this.framework = iFrameworkAccess;
        this.menuEntries = new HashMap();
        this.entryFactory = new EvoMenuEntryFactory(iFrameworkAccess, logChannel, this.menuEntries);
        MenuEntry menuEntry2 = this.entryFactory.createMenuEntry(600159, "CAR_FUNC_CHARISMA", 600815);
        MenuEntry menuEntry3 = this.entryFactory.createMenuEntry(600161, "CAR_FUNC_SETTINGS", 601010);
        MenuEntry menuEntry4 = this.entryFactory.createMenuEntry(600162, "CAR_FUNC_DRIVE_ASSIST", 601008);
        MenuEntry menuEntry5 = this.entryFactory.createMenuEntry(600163, "CAR_FUNC_AIR_CONDITION", 601005);
        MenuEntry menuEntry6 = this.entryFactory.createMenuEntry(600164, "CAR_FUNC_AUXHEAT", 601007);
        MenuEntry menuEntry7 = this.entryFactory.createMenuEntry(10, "CAR_FUNC_AUX_AC)", 601006);
        MenuEntry menuEntry8 = this.entryFactory.createMenuEntry(11, "CAR_FUNC_AUX_COMBINED)", 601672);
        MenuEntry menuEntry9 = this.entryFactory.createMenuEntry(600166, "CAR_FUNC_SERVICE", 601009);
        MenuEntry menuEntry10 = this.entryFactory.createMenuEntry(600390, "CAR_FUNC_BORDBOOK", 601172);
        MenuEntry menuEntry11 = this.entryFactory.createMenuEntry(600614, "CAR_FUNC_CHARGE", 601234);
        MenuEntry menuEntry12 = this.entryFactory.createMenuEntry(600809, "CAR_FUNC_STATISTICS", 601579);
        MenuEntry menuEntry13 = this.entryFactory.createMenuEntry(12, "CAR_FUNC_SPORT", 602119);
        if (this.framework.getKombiType() == 4) {
            menuEntry = this.entryFactory.createMMICombiMenuEntry(507, "CAR_FUNC_CHARISMA_COMBI", 11);
            MenuEntryMMICombi menuEntryMMICombi = this.entryFactory.createMMICombiMenuEntry(501, "CAR_FUNC_SETTINGS_COMBI", 7);
            MenuEntryMMICombi menuEntryMMICombi2 = this.entryFactory.createMMICombiMenuEntry(503, "CAR_FUNC_DRIVE_ASSIST_COMBI", 0);
            MenuEntryMMICombi menuEntryMMICombi3 = this.entryFactory.createMMICombiMenuEntry(508, "CAR_FUNC_AIR_CONDITION_COMBI", 6);
            MenuEntryMMICombi menuEntryMMICombi4 = this.entryFactory.createMMICombiMenuEntry(504, "CAR_FUNC_AUXHEAT_COMBI", 5);
            MenuEntryMMICombi menuEntryMMICombi5 = this.entryFactory.createMMICombiMenuEntry(505, "CAR_FUNC_AUX_AC_COMBI", 10);
            MenuEntryMMICombi menuEntryMMICombi6 = this.entryFactory.createMMICombiMenuEntry(502, "CAR_FUNC_SERVICE_COMBI", 4);
            MenuEntryMMICombi menuEntryMMICombi7 = this.entryFactory.createMMICombiMenuEntry(509, "CAR_FUNC_BORDBOOK_COMBI", 12);
            MenuEntryMMICombi menuEntryMMICombi8 = this.entryFactory.createMMICombiMenuEntry(510, "CAR_FUNC_STATISTICS_COMBI", 9);
            menuEntry.setChildren(new IMenuEntry[]{menuEntry2});
            menuEntryMMICombi.setChildren(new IMenuEntry[]{menuEntry3});
            menuEntryMMICombi2.setChildren(new IMenuEntry[]{menuEntry4});
            menuEntryMMICombi3.setChildren(new IMenuEntry[]{menuEntry5});
            menuEntryMMICombi4.setChildren(new IMenuEntry[]{menuEntry6});
            menuEntryMMICombi5.setChildren(new IMenuEntry[]{menuEntry7});
            menuEntryMMICombi6.setChildren(new IMenuEntry[]{menuEntry9});
            menuEntryMMICombi7.setChildren(new IMenuEntry[]{menuEntry10});
            menuEntryMMICombi8.setChildren(new IMenuEntry[]{menuEntry12});
        } else {
            menuEntry = this.entryFactory.createMenuEntry(1, "CAR_MAIN", 600773);
            menuEntry.setChildren(new IMenuEntry[]{menuEntry2, menuEntry3, menuEntry4, menuEntry5, menuEntry6, menuEntry7, menuEntry8, menuEntry9, menuEntry10, menuEntry11, menuEntry12, menuEntry13});
        }
        menuEntry11.setChildren(this.buildMenuCharge(logChannel));
        menuEntry2.setChildren(this.buildMenuCharisma(logChannel));
        menuEntry3.setChildren(this.buildMenuSettings(logChannel));
        menuEntry4.setChildren(this.buildMenuDriveAssist(logChannel));
        menuEntry5.setChildren(this.buildMenuAirCondition(logChannel));
        menuEntry13.setChildren(this.buildMenuSport(logChannel));
        boolean bl = carFuncAdap.isMenuDisplayActivated((short)9);
        boolean bl2 = carFuncAdap.isMenuDisplayActivated((short)46);
        if (bl) {
            if (bl2) {
                menuEntry8.setChildren(this.buildMenuAuxAC(logChannel));
            } else {
                menuEntry6.setChildren(this.buildMenuAuxheat(logChannel));
            }
        } else if (bl2) {
            menuEntry7.setChildren(this.buildMenuAuxAC(logChannel));
        }
        menuEntry9.setChildren(this.buildMenuService(logChannel));
        menuEntry12.setChildren(this.buildMenuStatistics());
        this.buildDrawerIntLightMenuEntries(logChannel);
        this.makeDefaultBinding(logChannel);
    }

    private IMenuEntry[] buildMenuSport(LogChannel logChannel) {
        MenuEntry menuEntry = this.entryFactory.createMenuEntry(604, "SPORT_TORQUE", 602118);
        MenuEntry menuEntry2 = this.entryFactory.createMenuEntry(605, "SPORT_TORQUE_MAX");
        MenuEntry menuEntry3 = this.entryFactory.createMenuEntry(606, "SPORT_TORQUE_CURRENT");
        menuEntry.setChildren(new IMenuEntry[]{menuEntry2, menuEntry3});
        MenuEntry menuEntry4 = this.entryFactory.createMenuEntry(601, "SPORT_POWER", 602116);
        MenuEntry menuEntry5 = this.entryFactory.createMenuEntry(602, "SPORT_POWER_MAX");
        MenuEntry menuEntry6 = this.entryFactory.createMenuEntry(603, "SPORT_POWER_CURRENT");
        menuEntry4.setChildren(new IMenuEntry[]{menuEntry5, menuEntry6});
        MenuEntry menuEntry7 = this.entryFactory.createMenuEntry(607, "SPORT_OIL_TEMPERATURE", 602113);
        MenuEntry menuEntry8 = this.entryFactory.createMenuEntry(608, "SPORT_AIR_PRESSURE", 602114);
        return new IMenuEntry[]{menuEntry4, menuEntry, menuEntry7, menuEntry8};
    }

    private IMenuEntry[] buildMenuCharge(LogChannel logChannel) {
        MenuEntry menuEntry = this.entryFactory.createMenuEntry(511, "CHARGE_TIMER1");
        MenuEntry menuEntry2 = this.entryFactory.createMenuEntry(512, "CHARGE_TIMER2");
        return new IMenuEntry[]{menuEntry, menuEntry2};
    }

    private IMenuEntry[] buildMenuStatistics() {
        MenuEntry menuEntry = this.entryFactory.createMenuEntry(17, "CAR_FUNC_HYBRID_RANGE_MONITOR", 602240);
        MenuEntry menuEntry2 = this.entryFactory.createMenuEntry(18, "CAR_FUNC_HYBRID_RANGE_MONITOR_RANGE", 602247);
        MenuEntry menuEntry3 = this.entryFactory.createMenuEntry(19, "CAR_FUNC_HYBRID_RANGE_MONITOR", 602246);
        MenuEntry menuEntry4 = this.entryFactory.createMenuEntry(20, "CAR_FUNC_HYBRID_RANGE_MONITOR_CONSUMER_LIST", 602244);
        MenuEntry menuEntry5 = this.entryFactory.createMenuEntry(21, "CAR_FUNC_HYBRID_RANGE_MONITOR_STATISTICS", 602245);
        menuEntry.setChildren(new IMenuEntry[]{menuEntry2, menuEntry3, menuEntry4, menuEntry5});
        MenuEntry menuEntry6 = this.entryFactory.createMenuEntry(15, "CAR_FUNC_HYBRID_STATISTICS_SHORT_TERM", 601885);
        MenuEntry menuEntry7 = this.entryFactory.createMenuEntry(16, "CAR_FUNC_HYBRID_STATISTICS_LONG_TERM", 601888);
        MenuEntry menuEntry8 = this.entryFactory.createMenuEntry(14, "CAR_FUNC_HYBRID_STATISTICS_LONG_TERM_RESET", 601809);
        return new IMenuEntry[]{menuEntry, menuEntry6, menuEntry7};
    }

    private void makeDefaultBinding(LogChannel logChannel) {
        if (this.menuEntries != null) {
            try {
                IncludeMenuEntry includeMenuEntry = (IncludeMenuEntry)this.menuEntries.get(new Integer(56));
                SlotMenuEntry slotMenuEntry = (SlotMenuEntry)this.menuEntries.get(new Integer(55));
                if (includeMenuEntry != null && slotMenuEntry != null) {
                    includeMenuEntry.moveToSlot(slotMenuEntry);
                } else {
                    logChannel.log(1000, "[CarEvoMenuEntryStructure#makeDefaultBinding] null value received from menuEntries hashMap");
                }
            }
            catch (ClassCastException classCastException) {
                logChannel.log(1000, "[CarEvoMenuEntryStructure#makeDefaultBinding] cce occured: ", (Throwable)classCastException);
            }
        }
    }

    private void buildDrawerIntLightMenuEntries(LogChannel logChannel) {
        this.entryFactory.createMenuEntry(340, "INTLIGHT_INDIVIDUAL_AMBIENT_COLOR", 601135);
        this.entryFactory.createMenuEntry(341, "INTLIGHT_INDIVIDUAL_CONTOUR_BRIGHTNESS", 601136);
        this.entryFactory.createMenuEntry(342, "INTLIGHT_INDIVIDUAL_CONTOUR_COLOR", 601137);
        this.entryFactory.createMenuEntry(343, "INTLIGHT_INDIVIDUAL_DOOR_BRIGHTNESS", 601138);
        this.entryFactory.createMenuEntry(344, "INTLIGHT_INDIVIDUAL_FOOT_BRIGHTNESS", 602395);
        this.entryFactory.createMenuEntry(345, "INTLIGHT_INDIVIDUAL_FRONT_BRIGHTNESS", 602379);
        this.entryFactory.createMenuEntry(346, "INTLIGHT_INDIVIDUAL_ROOF_BRIGHTNESS", 601141);
        this.entryFactory.createMenuEntry(347, "INTLIGHT_INDIVIDUAL_SURFACE_BRIGHTNESS", 602076);
    }

    private IMenuEntry[] buildMenuDriveAssist(LogChannel logChannel) {
        MenuEntry menuEntry = this.entryFactory.createMenuEntry(600242, "DRIVE_ASSIST_RAIN", 600444);
        MenuEntry menuEntry2 = this.entryFactory.createMenuEntry(600113, "DRIVE_ASSIST_NV_CONTRAST", 600334);
        MenuEntry menuEntry3 = this.entryFactory.createMenuEntry(600241, "DRIVE_ASSIST_MKE_PAUSE", 601039);
        MenuEntry menuEntry4 = this.entryFactory.createMenuEntry(600115, "DRIVE_ASSIST_DISTANCE_WARNING", 601048);
        MenuEntry menuEntry5 = this.entryFactory.createMenuEntry(600114, "DRIVE_ASSIST_SWA", 602373);
        MenuEntry menuEntry6 = this.entryFactory.createMenuEntry(600102, "PARKING_SETTINGS", 600344);
        MenuEntry menuEntry7 = this.entryFactory.createMenuEntry(600243, "ACC_TRAFFIC_JAM_ASSIST", 600677);
        MenuEntry menuEntry8 = this.entryFactory.createMenuEntry(600245, "DRIVING_SCHOOL", 600889);
        MenuEntry menuEntry9 = this.entryFactory.createMenuEntry(600103, "DRIVE_ASSIST_HUD", 600919);
        MenuEntry menuEntry10 = this.entryFactory.createMenuEntry(600098, "HUD_BRIGHTNESS", 600921);
        MenuEntry menuEntry11 = this.entryFactory.createMenuEntry(600151, "HUD_ROTATION", 601111);
        MenuEntry menuEntry12 = this.entryFactory.createMenuEntry(600097, "HUD_CONTENT", 600922);
        MenuEntry menuEntry13 = this.entryFactory.createMenuEntry(600222, "HUD_CONTENT_ACC", 600918);
        MenuEntry menuEntry14 = this.entryFactory.createMenuEntry(600221, "HUD_CONTENT_GRA", 600924);
        MenuEntry menuEntry15 = this.entryFactory.createMenuEntry(600223, "HUD_CONTENT_HCA", 600928);
        MenuEntry menuEntry16 = this.entryFactory.createMenuEntry(60, "HUD_CONTENT_HCA_ACC", 600927);
        MenuEntry menuEntry17 = this.entryFactory.createMenuEntry(600777, "HUD_CONTENT_NAV_RGI_COMBINED", 602110);
        MenuEntry menuEntry18 = this.entryFactory.createMenuEntry(600219, "HUD_CONTENT_RGI", 600936);
        MenuEntry menuEntry19 = this.entryFactory.createMenuEntry(600226, "HUD_CONTENT_NV", 600932);
        MenuEntry menuEntry20 = this.entryFactory.createMenuEntry(600220, "HUD_CONTENT_TRAFFICSIGN", 600938);
        MenuEntry menuEntry21 = this.entryFactory.createMenuEntry(600225, "HUD_CONTENT_PEA", 601109);
        MenuEntry menuEntry22 = this.entryFactory.createMenuEntry(600377, "HUD_CONTENT_SPEEDLIMITER", 601125);
        MenuEntry menuEntry23 = this.entryFactory.createMenuEntry(600378, "HUD_CONTENT_DRIVEASSIST", 601123);
        menuEntry12.setChildren(new IMenuEntry[]{menuEntry13, menuEntry14, menuEntry15, menuEntry16, menuEntry18, menuEntry19, menuEntry20, menuEntry21, menuEntry17, menuEntry22, menuEntry23});
        menuEntry9.setChildren(new IMenuEntry[]{menuEntry10, menuEntry12, menuEntry11});
        MenuEntry menuEntry24 = this.entryFactory.createMenuEntry(600105, "DRIVE_ASSIST_ACC", 600664);
        MenuEntry menuEntry25 = this.entryFactory.createMenuEntry(600227, "ACC_TIME_GAP", 600675);
        MenuEntry menuEntry26 = this.entryFactory.createMenuEntry(600228, "ACC_DRIVING_PROGRAM", 600668);
        MenuEntry menuEntry27 = this.entryFactory.createMenuEntry(600773, "ACC_SPEED_LIMIT_OFFSET", 600673);
        MenuEntry menuEntry28 = this.entryFactory.createMenuEntry(600774, "ACC_CURVE_ASSIST", 600666);
        MenuEntry menuEntry29 = this.entryFactory.createMenuEntry(600776, "ACC_PACC", 602151);
        menuEntry29.setChildren(new IMenuEntry[]{menuEntry27, menuEntry28});
        MenuEntry menuEntry30 = this.entryFactory.createMenuEntry(600778, "ACC_LASTDISTANCE", 602149);
        MenuEntry menuEntry31 = this.entryFactory.createMenuEntry(600229, "ACC_SPEED_LIMIT_ADOPTION", 600671);
        menuEntry24.setChildren(new IMenuEntry[]{menuEntry26, menuEntry25, menuEntry29, menuEntry31, menuEntry30});
        MenuEntry menuEntry32 = this.entryFactory.createMenuEntry(600110, "DRIVE_ASSIST_LDW", 600995);
        MenuEntry menuEntry33 = this.entryFactory.createMenuEntry(600236, "LDW_INTERVENTION", 600998);
        MenuEntry menuEntry34 = this.entryFactory.createMenuEntry(600235, "LDW_TOLERANCE_LEVEL", 602396);
        menuEntry32.setChildren(new IMenuEntry[]{menuEntry33, menuEntry34});
        MenuEntry menuEntry35 = this.entryFactory.createMenuEntry(600111, "DRIVE_ASSIST_TSD", 600407);
        MenuEntry menuEntry36 = this.entryFactory.createMenuEntry(600237, "TSD_TRAILER_DETECTION", 600411);
        MenuEntry menuEntry37 = this.entryFactory.createMenuEntry(600112, "TSD_TRAILER_SPEED_LIMIT", 600464);
        menuEntry35.setChildren(new IMenuEntry[]{menuEntry36, menuEntry37});
        MenuEntry menuEntry38 = this.entryFactory.createMenuEntry(600106, "PRESENSE_RGS", 600611);
        MenuEntry menuEntry39 = this.entryFactory.createMenuEntry(600107, "PRESENSE_RGS_SYSTEM", 600613);
        MenuEntry menuEntry40 = this.entryFactory.createMenuEntry(600232, "PRESENSE_RGS_WARNING", 600615);
        menuEntry38.setChildren(new IMenuEntry[]{menuEntry39, menuEntry40});
        MenuEntry menuEntry41 = this.entryFactory.createMenuEntry(600109, "PRESENSE_AWV", 600739);
        MenuEntry menuEntry42 = this.entryFactory.createMenuEntry(600233, "PRESENSE_AWV_SYSTEM", 600741);
        MenuEntry menuEntry43 = this.entryFactory.createMenuEntry(600234, "PRESENSE_AWV_WARNING", 600743);
        MenuEntry menuEntry44 = this.entryFactory.createMenuEntry(600811, "PRESENSE_AWV_WARNING_TIMEGAP", 602685);
        menuEntry41.setChildren(new IMenuEntry[]{menuEntry42, menuEntry43, menuEntry44});
        MenuEntry menuEntry45 = this.entryFactory.createMenuEntry(600099, "DRIVE_ASSIST_SPEED_WARNING_HIGH", 600516);
        MenuEntry menuEntry46 = this.entryFactory.createMenuEntry(600101, "DRIVE_ASSIST_SPEED_WARNING_LOW", 601074);
        MenuEntry menuEntry47 = this.entryFactory.createMenuEntry(600100, "SPEEDWARNING_MANUAL", 600748);
        MenuEntry menuEntry48 = this.entryFactory.createMenuEntry(53, "SPEEDWARNING_CAMERA", 600751);
        MenuEntry menuEntry49 = this.entryFactory.createMenuEntry(600213, "SPEEDWARNING_CAMERA_KMPH");
        MenuEntry menuEntry50 = this.entryFactory.createMenuEntry(600214, "SPEEDWARNING_CAMERA_MPH");
        menuEntry48.setChildren(new IMenuEntry[]{menuEntry49, menuEntry50});
        SlotMenuEntry slotMenuEntry = this.entryFactory.createSlotMenuEntry(55, "SPEEDWARNING_SLOT_LOW_VARIANT", new int[]{56});
        SlotMenuEntry slotMenuEntry2 = this.entryFactory.createSlotMenuEntry(54, "SPEEDWARNING_SLOT_HIGH_VARIANT", new int[]{56});
        IncludeMenuEntry includeMenuEntry = this.entryFactory.createIncludeMenuEntry(56, "SPEEDWARNING_INCLUDE", new int[]{slotMenuEntry.getID(), slotMenuEntry2.getID()});
        includeMenuEntry.setChildren(new IMenuEntry[]{menuEntry47});
        menuEntry45.setChildren(new IMenuEntry[]{menuEntry48, slotMenuEntry2});
        menuEntry46.setChildren(new IMenuEntry[]{slotMenuEntry});
        MenuEntry menuEntry51 = this.entryFactory.createMenuEntry(600216, "PARKING_SETTINGS_VOLUME_FRONT");
        MenuEntry menuEntry52 = this.entryFactory.createMenuEntry(600217, "PARKING_SETTINGS_VOLUME_REAR");
        MenuEntry menuEntry53 = this.entryFactory.createMenuEntry(600218, "PARKING_SETTINGS_ENTERTAINMENT_LOWERING");
        MenuEntry menuEntry54 = this.entryFactory.createMenuEntry(600215, "PARKING_SETTINGS_AUTO_VPS_VIEW_SWITCHING");
        MenuEntry menuEntry55 = this.entryFactory.createMenuEntry(600, "PARKING_SETTINGS_OPS_AUTO_ACTIVATION");
        menuEntry6.setChildren(new IMenuEntry[]{menuEntry51, menuEntry52, menuEntry53, menuEntry54, menuEntry55});
        MenuEntry menuEntry56 = this.entryFactory.createMenuEntry(600152, "FAS_PEA", 601119);
        MenuEntry menuEntry57 = this.entryFactory.createMenuEntry(600238, "PEA_SYSTEM", 601113);
        MenuEntry menuEntry58 = this.entryFactory.createMenuEntry(600239, "PEA_PEDAL", 601115);
        MenuEntry menuEntry59 = this.entryFactory.createMenuEntry(600622, "PEA_FREEWHEEL", 601607);
        MenuEntry menuEntry60 = this.entryFactory.createMenuEntry(450, "PEA_HYBRID_FUNCTIONS", 601748);
        MenuEntry menuEntry61 = this.entryFactory.createMenuEntry(451, "PEA_HYBRID_SYSTEM", 601747);
        MenuEntry menuEntry62 = this.entryFactory.createMenuEntry(452, "PEA_HYBRID_BURNER", 601746);
        menuEntry60.setChildren(new IMenuEntry[]{menuEntry61, menuEntry62});
        menuEntry56.setChildren(new IMenuEntry[]{menuEntry57, menuEntry58, menuEntry59, menuEntry60});
        MenuEntry menuEntry63 = this.entryFactory.createMenuEntry(600621, "FAS_PEA_SIMPLE", 601605);
        return new IMenuEntry[]{menuEntry, menuEntry2, menuEntry9, menuEntry24, menuEntry4, menuEntry3, menuEntry32, menuEntry35, menuEntry5, menuEntry38, menuEntry41, menuEntry45, menuEntry46, menuEntry6, menuEntry7, menuEntry8, menuEntry56, menuEntry63};
    }

    private IMenuEntry[] buildMenuSettings(LogChannel logChannel) {
        MenuEntry menuEntry = this.entryFactory.createMenuEntry(600061, "SETTINGS_JOKER", 602388);
        MenuEntry menuEntry2 = this.entryFactory.createMenuEntry(600532, "SETTINGS_JOKER_KEY_POI_CALL", 601313);
        MenuEntry menuEntry3 = this.entryFactory.createMenuEntry(600171, "SETTINGS_JOKER_KEY_AUX_HEATING_ON_OFF", 601062);
        MenuEntry menuEntry4 = this.entryFactory.createMenuEntry(600172, "SETTINGS_JOKER_KEY_CHANGE_DRIVE_SELECT_MODE", 601063);
        MenuEntry menuEntry5 = this.entryFactory.createMenuEntry(600173, "SETTINGS_JOKER_KEY_NAV_ANNOUNCEMENT", 601066);
        MenuEntry menuEntry6 = this.entryFactory.createMenuEntry(600174, "SETTINGS_JOKER_KEY_NAV_MAP_COLOR_DAY_NIGHT", 602378);
        MenuEntry menuEntry7 = this.entryFactory.createMenuEntry(70, "SETTINGS_JOKER_KEY_NAV_MAP_ADDITIONAL_INFO", 601067);
        MenuEntry menuEntry8 = this.entryFactory.createMenuEntry(600177, "SETTINGS_JOKER_KEY_SHOW_TMC_MESSAGES", 601077);
        MenuEntry menuEntry9 = this.entryFactory.createMenuEntry(600176, "SETTINGS_JOKER_KEY_TRAFFIC_ANNOUNCEMENT", 601071);
        MenuEntry menuEntry10 = this.entryFactory.createMenuEntry(600178, "SETTINGS_JOKER_KEY_CLUSTER_SCREENSAVER", 601064);
        MenuEntry menuEntry11 = this.entryFactory.createMenuEntry(71, "SETTINGS_JOKER_KEY_CLUSTER_TRAFFIC_SIGNS_ON_OFF", 601065);
        MenuEntry menuEntry12 = this.entryFactory.createMenuEntry(600384, "SETTINGS_JOKER_KEY_CLUSTER_SWITCH_TO_TRAFFIC_SIGNS", 601168);
        MenuEntry menuEntry13 = this.entryFactory.createMenuEntry(600180, "SETTINGS_JOKER_KEY_SWITCH_TUNER_MEDIA", 601070);
        MenuEntry menuEntry14 = this.entryFactory.createMenuEntry(600181, "SETTINGS_JOKER_KEY_SKIP_FORWARD", 601069);
        menuEntry.setChildren(new IMenuEntry[]{menuEntry2, menuEntry3, menuEntry4, menuEntry5, menuEntry6, menuEntry7, menuEntry8, menuEntry9, menuEntry10, menuEntry11, menuEntry12, menuEntry13, menuEntry14});
        MenuEntry menuEntry15 = this.entryFactory.createMenuEntry(600075, "SETTINGS_LOCKING", 600868);
        MenuEntry menuEntry16 = this.entryFactory.createMenuEntry(600206, "LOCKING_UNLOCK", 600885);
        MenuEntry menuEntry17 = this.entryFactory.createMenuEntry(600207, "LOCKING_LONGPUSH", 600875);
        MenuEntry menuEntry18 = this.entryFactory.createMenuEntry(600208, "LOCKING_AUTOLOCK", 600867);
        MenuEntry menuEntry19 = this.entryFactory.createMenuEntry(600209, "LOCKING_BOOT", 600872);
        MenuEntry menuEntry20 = this.entryFactory.createMenuEntry(600210, "LOCKING_MIRROR", 600883);
        MenuEntry menuEntry21 = this.entryFactory.createMenuEntry(600211, "LOCKING_BEEP", 600870);
        MenuEntry menuEntry22 = this.entryFactory.createMenuEntry(600822, "LOCKING_KEYLESS", 602733);
        menuEntry15.setChildren(new IMenuEntry[]{menuEntry16, menuEntry17, menuEntry18, menuEntry19, menuEntry20, menuEntry21, menuEntry22});
        MenuEntry menuEntry23 = this.entryFactory.createMenuEntry(600072, "SETTINGS_EXTLIGHT", 602381);
        MenuEntry menuEntry24 = this.entryFactory.createMenuEntry(600058, "EXTLIGHT_AUTOMATIC_LIGHT", 600894);
        MenuEntry menuEntry25 = this.entryFactory.createMenuEntry(600194, "EXTLIGHT_DAY_LIGHT", 600901);
        MenuEntry menuEntry26 = this.entryFactory.createMenuEntry(600195, "EXTLIGHT_TOURIST_LEFT", 602387);
        MenuEntry menuEntry27 = this.entryFactory.createMenuEntry(600196, "EXTLIGHT_TOURIST_RIGHT", 600916);
        MenuEntry menuEntry28 = this.entryFactory.createMenuEntry(600193, "EXTLIGHT_COMING_LEAVING_HOME", 600899);
        menuEntry23.setChildren(new IMenuEntry[]{menuEntry24, menuEntry25, menuEntry26, menuEntry27, menuEntry28});
        MenuEntry menuEntry29 = this.entryFactory.createMenuEntry(600188, "EXTLIGHT_SWITCH_ON_SENSITIVITY", 600912);
        MenuEntry menuEntry30 = this.entryFactory.createMenuEntry(600190, "EXTLIGHT_HEAD_LIGHT", 602383);
        MenuEntry menuEntry31 = this.entryFactory.createMenuEntry(600189, "EXTLIGHT_GLIDING_LIGHT", 600904);
        MenuEntry menuEntry32 = this.entryFactory.createMenuEntry(600191, "EXTLIGHT_MATRIX_BEAM", 600910);
        MenuEntry menuEntry33 = this.entryFactory.createMenuEntry(600542, "EXTLIGHT_HEAD_LIGHT_SUBMENU", 601296);
        MenuEntry menuEntry34 = this.entryFactory.createMenuEntry(600539, "EXTLIGHT_HEAD_LIGHT_NORMAL", 601299);
        MenuEntry menuEntry35 = this.entryFactory.createMenuEntry(600545, "EXTLIGHT_HEAD_LIGHT_LASER", 601292);
        menuEntry33.setChildren(new IMenuEntry[]{menuEntry34, menuEntry35});
        MenuEntry menuEntry36 = this.entryFactory.createMenuEntry(600543, "EXTLIGHT_GLIDING_LIGHT_SUBMENU", 601295);
        MenuEntry menuEntry37 = this.entryFactory.createMenuEntry(600540, "EXTLIGHT_GLIDING_LIGHT_NORMAL", 601298);
        MenuEntry menuEntry38 = this.entryFactory.createMenuEntry(600546, "EXTLIGHT_GLIDING_LIGHT_LASER", 601290);
        menuEntry36.setChildren(new IMenuEntry[]{menuEntry37, menuEntry38});
        MenuEntry menuEntry39 = this.entryFactory.createMenuEntry(600544, "EXTLIGHT_MATRIX_BEAM_SUBMENU", 601297);
        MenuEntry menuEntry40 = this.entryFactory.createMenuEntry(600541, "EXTLIGHT_MATRIX_BEAM_NORMAL", 601300);
        MenuEntry menuEntry41 = this.entryFactory.createMenuEntry(600537, "EXTLIGHT_MATRIX_BEAM_LASER", 601294);
        menuEntry39.setChildren(new IMenuEntry[]{menuEntry40, menuEntry41});
        menuEntry24.setChildren(new IMenuEntry[]{menuEntry29, menuEntry30, menuEntry31, menuEntry32, menuEntry33, menuEntry36, menuEntry39});
        MenuEntry menuEntry42 = this.entryFactory.createMenuEntry(600076, "SETTINGS_UGDO", 600412);
        MenuEntry menuEntry43 = this.entryFactory.createMenuEntry(600077, "UGDO_LEARNING", 600416);
        MenuEntry menuEntry44 = this.entryFactory.createMenuEntry(600081, "UGDO_DELETE", 600413);
        MenuEntry menuEntry45 = this.entryFactory.createMenuEntry(6003, "UGDO_VERSION", 602710);
        menuEntry42.setChildren(new IMenuEntry[]{menuEntry43, menuEntry44, menuEntry45});
        MenuEntry menuEntry46 = this.entryFactory.createMenuEntry(600078, "UGDO_LEARN_BUTTON1", 602359);
        MenuEntry menuEntry47 = this.entryFactory.createMenuEntry(600079, "UGDO_LEARN_BUTTON2", 600419);
        MenuEntry menuEntry48 = this.entryFactory.createMenuEntry(600080, "UGDO_LEARN_BUTTON3", 600421);
        MenuEntry menuEntry49 = this.entryFactory.createMenuEntry(6001, "UGDO_LEARN_BUTTON_DEFAULT_MODE", 602201);
        MenuEntry menuEntry50 = this.entryFactory.createMenuEntry(6002, "UGDO_LEARN_BUTTON_FIXKIT", 602202);
        menuEntry43.setChildren(new IMenuEntry[]{menuEntry46, menuEntry47, menuEntry48, menuEntry49, menuEntry50});
        MenuEntry menuEntry51 = this.entryFactory.createMenuEntry(600073, "INTLIGHT_PROFILES", 601061);
        MenuEntry menuEntry52 = this.entryFactory.createMenuEntry(600197, "INTLIGHT_PROFILE_1", 602368);
        MenuEntry menuEntry53 = this.entryFactory.createMenuEntry(600198, "INTLIGHT_PROFILE_2", 601079);
        MenuEntry menuEntry54 = this.entryFactory.createMenuEntry(600199, "INTLIGHT_PROFILE_3", 601080);
        MenuEntry menuEntry55 = this.entryFactory.createMenuEntry(600200, "INTLIGHT_PROFILE_4", 601081);
        MenuEntry menuEntry56 = this.entryFactory.createMenuEntry(600201, "INTLIGHT_PROFILE_5", 601082);
        MenuEntry menuEntry57 = this.entryFactory.createMenuEntry(600202, "INTLIGHT_PROFILE_6", 601083);
        MenuEntry menuEntry58 = this.entryFactory.createMenuEntry(600203, "INTLIGHT_PROFILE_7", 601084);
        MenuEntry menuEntry59 = this.entryFactory.createMenuEntry(600204, "INTLIGHT_PROFILE_8", 601085);
        MenuEntry menuEntry60 = this.entryFactory.createMenuEntry(338, "INTLIGHT_INDIVIDUAL", 601086);
        menuEntry51.setChildren(new IMenuEntry[]{menuEntry52, menuEntry53, menuEntry54, menuEntry55, menuEntry56, menuEntry57, menuEntry58, menuEntry59, menuEntry60});
        MenuEntry menuEntry61 = this.entryFactory.createMenuEntry(600074, "INTLIGHT_ROTARY_ONLY", 601087);
        MenuEntry menuEntry62 = this.entryFactory.createMenuEntry(600062, "SETTINGS_SEAT", 600545);
        MenuEntry menuEntry63 = this.entryFactory.createMenuEntry(600063, "SEAT_DRIVER_HIGH_VARIANT", 600549);
        MenuEntry menuEntry64 = this.entryFactory.createMenuEntry(600071, "SEAT_DRIVER_LOW_VARIANT", 600588);
        MenuEntry menuEntry65 = this.entryFactory.createMenuEntry(600064, "SEAT_CODRIVER", 600546);
        MenuEntry menuEntry66 = this.entryFactory.createMenuEntry(600068, "SEAT_REAR", 600553);
        MenuEntry menuEntry67 = this.entryFactory.createMenuEntry(600069, "NORMAL_POSITION", 600552);
        menuEntry62.setChildren(new IMenuEntry[]{menuEntry63, menuEntry65, menuEntry66, menuEntry67});
        SlotMenuEntry slotMenuEntry = this.entryFactory.createSlotMenuEntry(700063, "SEAT_SLOT_HIGH_VARIANT", new int[]{800025});
        menuEntry63.setChildren(new IMenuEntry[]{slotMenuEntry});
        SlotMenuEntry slotMenuEntry2 = this.entryFactory.createSlotMenuEntry(700071, "SEAT_SLOT_LOW_VARIANT", new int[]{800025});
        menuEntry64.setChildren(new IMenuEntry[]{slotMenuEntry2});
        IncludeMenuEntry includeMenuEntry = this.entryFactory.createIncludeMenuEntry(800025, "SEAT_INCLUDE_DRIVER", new int[]{slotMenuEntry.getID(), slotMenuEntry2.getID()});
        MenuEntry menuEntry68 = this.entryFactory.createMenuEntry(600182, "SEAT_DRIVER_EASY_ENTRY", 600550);
        MenuEntry menuEntry69 = this.entryFactory.createMenuEntry(600184, "SEAT_DRIVER_RADIO_KEY", 600551);
        MenuEntry menuEntry70 = this.entryFactory.createMenuEntry(600738, "SEAT_DRIVER_PRELOAD_DEVICE", 601879);
        includeMenuEntry.setChildren(new IMenuEntry[]{menuEntry68, menuEntry69, menuEntry70});
        MenuEntry menuEntry71 = this.entryFactory.createMenuEntry(600186, "SEAT_REAR_EASY_ENTRY", 600555);
        MenuEntry menuEntry72 = this.entryFactory.createMenuEntry(600187, "SEAT_REAR_CODRIVER_POS", 600554);
        menuEntry66.setChildren(new IMenuEntry[]{menuEntry71, menuEntry72});
        MenuEntry menuEntry73 = this.entryFactory.createMenuEntry(600065, "SEAT_CO_DRV_POSITION", 600547);
        MenuEntry menuEntry74 = this.entryFactory.createMenuEntry(600066, "SEAT_CO_DRV_SYMMETRY", 600548);
        MenuEntry menuEntry75 = this.entryFactory.createMenuEntry(600739, "SEAT_CODRIVER_PRELOAD_DEVICE", 601878);
        menuEntry65.setChildren(new IMenuEntry[]{menuEntry73, menuEntry74, menuEntry75});
        MenuEntry menuEntry76 = this.entryFactory.createMenuEntry(600212, "AIR_SUSPENSION_TRAILER_MODE", 601047);
        MenuEntry menuEntry77 = this.entryFactory.createMenuEntry(600744, "SETTINGS_PEA_HYBRID", 601748);
        MenuEntry menuEntry78 = this.entryFactory.createMenuEntry(600745, "SETTINGS_PEA_HYBRID_PEDAL", 601747);
        MenuEntry menuEntry79 = this.entryFactory.createMenuEntry(600746, "SETTINGS_PEA_HYBRID_COMBUSTOR", 601746);
        menuEntry77.setChildren(new IMenuEntry[]{menuEntry78, menuEntry79});
        return new IMenuEntry[]{menuEntry, menuEntry15, menuEntry23, menuEntry42, menuEntry62, menuEntry64, menuEntry76, menuEntry51, menuEntry61, menuEntry77};
    }

    private IMenuEntry[] buildMenuAuxheat(LogChannel logChannel) {
        MenuEntry menuEntry = this.entryFactory.createMenuEntry(221, "AUXHEAT_NOW", 602392);
        MenuEntry menuEntry2 = this.entryFactory.createMenuEntry(600054, "AUXHEAT_NOW_ON");
        MenuEntry menuEntry3 = this.entryFactory.createMenuEntry(600055, "AUXHEAT_NOW_OFF");
        menuEntry.setChildren(new IMenuEntry[]{menuEntry2, menuEntry3});
        this.entryFactory.createMenuEntry(222, "AUXHEAT_TIMER1", 602377);
        this.entryFactory.createMenuEntry(223, "AUXHEAT_TIMER2", 600731);
        this.entryFactory.createMenuEntry(224, "AUXHEAT_HEATING_EFFECT_RIGHT_DRAWER", 601106);
        MenuEntry menuEntry4 = this.entryFactory.createMenuEntry(2210, "AUXHEAT_NOW_VO");
        MenuEntry menuEntry5 = this.entryFactory.createMenuEntry(2220, "AUXHEAT_TIMER1_VO");
        MenuEntry menuEntry6 = this.entryFactory.createMenuEntry(2230, "AUXHEAT_TIMER2_VO");
        MenuEntry menuEntry7 = this.buildMenuAuxAcExtendedOptions();
        return new IMenuEntry[]{menuEntry4, menuEntry5, menuEntry6, menuEntry7};
    }

    private IMenuEntry[] buildMenuAuxAC(LogChannel logChannel) {
        MenuEntry menuEntry = this.entryFactory.createMenuEntry(221, "AUXHEAT_NOW");
        MenuEntry menuEntry2 = this.entryFactory.createMenuEntry(600573, "AUXCOOLER_NOW_ON");
        MenuEntry menuEntry3 = this.entryFactory.createMenuEntry(600657, "AUXCOOLER_NOW_OFF");
        MenuEntry menuEntry4 = this.entryFactory.createMenuEntry(600723, "AUXCOMBINED_NOW_ON");
        MenuEntry menuEntry5 = this.entryFactory.createMenuEntry(600724, "AUXCOMBINED_NOW_OFF");
        menuEntry.setChildren(new IMenuEntry[]{menuEntry2, menuEntry3, menuEntry4, menuEntry5});
        MenuEntry menuEntry6 = this.entryFactory.createMenuEntry(222, "AUXHEAT_TIMER1");
        MenuEntry menuEntry7 = this.entryFactory.createMenuEntry(223, "AUXHEAT_TIMER2");
        MenuEntry menuEntry8 = this.buildMenuAuxAcExtendedOptions();
        this.entryFactory.createMenuEntry(225, "AUX_AC_IMMEDIATE_AC_TYPE_RIGHT_DRAWER", 601720);
        this.entryFactory.createMenuEntry(226, "AUX_AC_TIMER1_AC_TYPE_RIGHT_DRAWER", 601719);
        this.entryFactory.createMenuEntry(227, "AUX_AC_TIMER2_AC_TYPE_RIGHT_DRAWER", 601721);
        return new IMenuEntry[]{menuEntry, menuEntry6, menuEntry7, menuEntry8};
    }

    private MenuEntry buildMenuAuxAcExtendedOptions() {
        MenuEntry menuEntry = this.entryFactory.createMenuEntry(600812, "AUX_AC_EXTENDED_CONDITIONING", 602717);
        MenuEntry menuEntry2 = this.entryFactory.createMenuEntry(600813, "AUX_AC_EXTENDED_ZONES", 602718);
        MenuEntry menuEntry3 = this.entryFactory.createMenuEntry(600814, "AUX_AC_WINDOWS_ZONES", 602713);
        MenuEntry menuEntry4 = this.entryFactory.createMenuEntry(600815, "AUX_AC_UNLOCK_CLIMATING", 602716);
        MenuEntry menuEntry5 = this.entryFactory.createMenuEntry(600817, "AUX_AC_Z1RL", 602722);
        MenuEntry menuEntry6 = this.entryFactory.createMenuEntry(600818, "AUX_AC_Z1RR", 602726);
        MenuEntry menuEntry7 = this.entryFactory.createMenuEntry(600819, "AUX_AC_Z2RL", 602724);
        MenuEntry menuEntry8 = this.entryFactory.createMenuEntry(600820, "AUX_AC_Z2RR", 602725);
        menuEntry2.setChildren(new IMenuEntry[]{menuEntry5, menuEntry6, menuEntry7, menuEntry8});
        menuEntry.setChildren(new IMenuEntry[]{menuEntry2, menuEntry3, menuEntry4});
        return menuEntry;
    }

    private IMenuEntry[] buildMenuService(LogChannel logChannel) {
        MenuEntry menuEntry = this.entryFactory.createMenuEntry(600247, "SERVICE_WIPERPOSITION", 600446);
        MenuEntry menuEntry2 = this.entryFactory.createMenuEntry(600131, "SERVICE_OILLEVEL", 600339);
        MenuEntry menuEntry3 = this.entryFactory.createMenuEntry(600133, "SERVICE_VEHICLE_INFO", 601197);
        MenuEntry menuEntry4 = this.entryFactory.createMenuEntry(182, "SERVICE_VIN", 600442);
        MenuEntry menuEntry5 = this.entryFactory.createMenuEntry(181, "SERVICE_KEYDATA", 601156);
        menuEntry3.setChildren(new IMenuEntry[]{menuEntry4, menuEntry5});
        MenuEntry menuEntry6 = this.entryFactory.createMenuEntry(600132, "SERVICE_SIA", 600393);
        MenuEntry menuEntry7 = this.entryFactory.createMenuEntry(402, "SIA_OIL_CHANGE_INTERVAL", 600394);
        MenuEntry menuEntry8 = this.entryFactory.createMenuEntry(403, "SIA_SERVICE_INTERVAL", 600400);
        MenuEntry menuEntry9 = this.entryFactory.createMenuEntry(600476, "SIA_OIL_RESET", 600399);
        menuEntry6.setChildren(new IMenuEntry[]{menuEntry7, menuEntry8, menuEntry9});
        MenuEntry menuEntry10 = this.entryFactory.createMenuEntry(600130, "RDK_LOW_MAIN", 600467);
        MenuEntry menuEntry11 = this.entryFactory.createMenuEntry(600124, "RDK_HIGH_MAIN", 600466);
        MenuEntry menuEntry12 = this.entryFactory.createMenuEntry(600126, "RDK_HIGH_SAVE_PRESSURE", 600353);
        MenuEntry menuEntry13 = this.entryFactory.createMenuEntry(600125, "RDK_HIGH_DISPLAY_PRESSURE", 600355);
        MenuEntry menuEntry14 = this.entryFactory.createMenuEntry(600129, "RDK_HIGH_TYRE_CHANGED", 600354);
        menuEntry11.setChildren(new IMenuEntry[]{menuEntry12, menuEntry13, menuEntry14});
        MenuEntry menuEntry15 = this.entryFactory.createMenuEntry(600246, "AIR_SUSPENSION_CAR_JACK_MODE", 601046);
        MenuEntry menuEntry16 = this.entryFactory.createMenuEntry(600134, "AD_BLUE", 601045);
        return new IMenuEntry[]{menuEntry, menuEntry2, menuEntry3, menuEntry6, menuEntry10, menuEntry11, menuEntry15, menuEntry16};
    }

    private IMenuEntry[] buildMenuAirCondition(LogChannel logChannel) {
        IStorageAccess iStorageAccess = this.framework.getStorageMgr();
        MenuEntry menuEntry = this.entryFactory.createMenuEntry(600168, "AIRCONDITION_CIRCULATION", 601041, new MenuEntryPersistence(iStorageAccess, 80));
        MenuEntry menuEntry2 = this.entryFactory.createMenuEntry(600714, "AIRCONDITION_FOOTWELL_DRIVER_LH", 601757, new MenuEntryPersistence(iStorageAccess, 83));
        MenuEntry menuEntry3 = this.entryFactory.createMenuEntry(600715, "AIRCONDITION_FOOTWELL_CODRIVER_LH", 601756, new MenuEntryPersistence(iStorageAccess, 84));
        MenuEntry menuEntry4 = this.entryFactory.createMenuEntry(600805, "AIRCONDITION_FOOTWELL_DRIVER_RH", 602296, new MenuEntryPersistence(iStorageAccess, 85));
        MenuEntry menuEntry5 = this.entryFactory.createMenuEntry(600806, "AIRCONDITION_FOOTWELL_CODRIVER_RH", 602297, new MenuEntryPersistence(iStorageAccess, 86));
        MenuEntry menuEntry6 = this.entryFactory.createMenuEntry(600713, "AIRCONDITION_FOOTWELL", 601042);
        menuEntry6.setChildren(new IMenuEntry[]{menuEntry2, menuEntry3, menuEntry4, menuEntry5});
        MenuEntry menuEntry7 = this.entryFactory.createMenuEntry(600169, "AIRCONDITION_HEATER", 601043, new MenuEntryPersistence(iStorageAccess, 81));
        MenuEntry menuEntry8 = this.entryFactory.createMenuEntry(600170, "AIRCONDITION_SOLAR", 601044, new MenuEntryPersistence(iStorageAccess, 82));
        MenuEntry menuEntry9 = this.entryFactory.createMenuEntry(600047, "AIRCONDITION_SEAT_HEATING", 601452);
        MenuEntry menuEntry10 = this.entryFactory.createMenuEntry(600034, "AIRCONDITION_SEAT_VENTILATION", 601451);
        MenuEntry menuEntry11 = this.entryFactory.createMenuEntry(600035, "AC_SEAT_VENTILATION_DRIVER", 601454, new MenuEntryPersistence(iStorageAccess, 90));
        MenuEntry menuEntry12 = this.entryFactory.createMenuEntry(600038, "AC_SEAT_VENTILATION_CODRIVER", 601453, new MenuEntryPersistence(iStorageAccess, 91));
        MenuEntry menuEntry13 = this.entryFactory.createMenuEntry(600041, "AC_SEAT_VENTILATION_REAR_DRIVER", 601456, new MenuEntryPersistence(iStorageAccess, 92));
        MenuEntry menuEntry14 = this.entryFactory.createMenuEntry(600044, "AC_SEAT_VENTILATION_REAR_CODRIVER", 601455, new MenuEntryPersistence(iStorageAccess, 93));
        MenuEntry menuEntry15 = this.entryFactory.createMenuEntry(600048, "AC_SEAT_HEATING_DRIVER", 601461, new MenuEntryPersistence(iStorageAccess, 94));
        MenuEntry menuEntry16 = this.entryFactory.createMenuEntry(600049, "AC_SEAT_HEATING_CODRIVER", 601460, new MenuEntryPersistence(iStorageAccess, 95));
        MenuEntry menuEntry17 = this.entryFactory.createMenuEntry(600050, "AC_SEAT_HEATING_REAR_DRIVER", 601463, new MenuEntryPersistence(iStorageAccess, 96));
        MenuEntry menuEntry18 = this.entryFactory.createMenuEntry(600051, "AC_SEAT_HEATING_REAR_CODRIVER", 601462, new MenuEntryPersistence(iStorageAccess, 97));
        IMenuEntry[] iMenuEntryArray = new IMenuEntry[]{menuEntry11, menuEntry12, menuEntry13, menuEntry14};
        IMenuEntry[] iMenuEntryArray2 = new IMenuEntry[]{menuEntry15, menuEntry16, menuEntry17, menuEntry18};
        menuEntry10.setChildren(iMenuEntryArray);
        menuEntry9.setChildren(iMenuEntryArray2);
        return new IMenuEntry[]{menuEntry, menuEntry6, menuEntry7, menuEntry8, menuEntry9, menuEntry10};
    }

    private IMenuEntry[] buildMenuCharisma(LogChannel logChannel) {
        MenuEntry menuEntry = this.entryFactory.createMenuEntry(600140, "CHARISMA_PROFILE_ALLROAD", 600853);
        MenuEntry menuEntry2 = this.entryFactory.createMenuEntry(600139, "CHARISMA_PROFILE_OFFROAD", 600860);
        MenuEntry menuEntry3 = this.entryFactory.createMenuEntry(600143, "CHARISMA_PROFILE_AUTO", 602410);
        MenuEntry menuEntry4 = this.entryFactory.createMenuEntry(600144, "CHARISMA_PROFILE_DYNAMIC", 602357);
        MenuEntry menuEntry5 = this.entryFactory.createMenuEntry(600141, "CHARISMA_PROFILE_EFFICIENY", 600857);
        MenuEntry menuEntry6 = this.entryFactory.createMenuEntry(600142, "CHARISMA_PROFILE_COMFORT", 600855);
        MenuEntry menuEntry7 = this.entryFactory.createMenuEntry(600145, "CHARISMA_PROFILE_INDIVIDUAL", 602399);
        MenuEntry menuEntry8 = this.entryFactory.createMenuEntry(600693, "CHARSIMA_PROFILE_LIFT", 600859);
        MenuEntry menuEntry9 = this.entryFactory.createMenuEntry(238, "CHARISMA_PROFILE_RACE", 602386);
        MenuEntry menuEntry10 = this.entryFactory.createMenuEntry(600138, "CHARSIMA_PROFILE_LIFT_OFFROAD", 601752);
        menuEntry8.setFunctionalStateValues(new int[]{4});
        menuEntry2.setFunctionalStateValues(new int[]{4});
        menuEntry10.setFunctionalStateValues(new int[]{4});
        menuEntry5.setFunctionalStateValues(new int[]{8});
        this.entryFactory.createMenuEntry(260, "AIR_SUSPENSION_INDICATOR", 601102);
        this.entryFactory.createMenuEntry(240, "CHARISMA_INDIVIDUAL_ACC", 600819);
        this.entryFactory.createMenuEntry(241, "CHARISMA_INDIVIDUAL_AIRSUSPENSION", 600823);
        this.entryFactory.createMenuEntry(242, "CHARISMA_INDIVIDUAL_DAMPER", 600828);
        this.entryFactory.createMenuEntry(243, "CHARISMA_INDIVIDUAL_ENGINE", 600830);
        this.entryFactory.createMenuEntry(244, "CHARISMA_INDIVIDUAL_GEAR_ENGINE", 600832);
        this.entryFactory.createMenuEntry(245, "CHARISMA_INDIVIDUAL_POWER_STEERING", 600836);
        this.entryFactory.createMenuEntry(246, "CHARISMA_INDIVIDUAL_SOUND", 600838);
        this.entryFactory.createMenuEntry(247, "CHARISMA_INDIVIDUAL_STEERING_LIGHT", 600842);
        this.entryFactory.createMenuEntry(248, "CHARISMA_INDIVIDUAL_SUPERPOS_STEERING", 600844);
        this.entryFactory.createMenuEntry(270, "CHARISMA_EFFICIENCY_BCME_LIVE_TIPS", 601443);
        MenuEntry menuEntry11 = this.entryFactory.createMenuEntry(250, "CHARISMA_EFFICIENCY_BCME_ADD_INFO", 601457);
        MenuEntry menuEntry12 = this.entryFactory.createMenuEntry(252, "CHARISMA_EFFICIENCY_BCME_CONSUMPTION_BARGRAPH", 601440);
        MenuEntry menuEntry13 = this.entryFactory.createMenuEntry(251, "CHARISMA_EFFICIENCY_BCME_CONSUMER_LIST", 601458);
        menuEntry11.setChildren(new IMenuEntry[]{menuEntry12, menuEntry13});
        MenuEntry menuEntry14 = this.entryFactory.createMenuEntry(326, "TAD_MAIN", 601207);
        MenuEntry menuEntry15 = this.entryFactory.createMenuEntry(328, "TAD_PITCH_ANGLE", 601205);
        MenuEntry menuEntry16 = this.entryFactory.createMenuEntry(327, "TAD_ROLL_ANGLE", 601206);
        menuEntry14.setChildren(new IMenuEntry[]{menuEntry15, menuEntry16});
        return new IMenuEntry[]{menuEntry, menuEntry2, menuEntry3, menuEntry4, menuEntry5, menuEntry7, menuEntry6, menuEntry8, menuEntry10, menuEntry9};
    }

    public HashMap getMenuEntries() {
        return this.menuEntries;
    }
}

