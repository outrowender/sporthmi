/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.audi.tv.app.BCDTime;
import de.audi.tv.app.IEWSListener;
import de.audi.tv.app.IEWSPopupHandler;
import de.audi.tv.app.audio.EWSBeepHandler;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.settings.DefaultSettingListener;
import de.audi.tv.app.settings.ISettingListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.dsi.ifc.tvtuner.EWSInfo;
import org.dsi.ifc.tvtuner.StartUpConfig;

public class EWS {
    private LinkedList ewsList = new LinkedList();
    private final Object ewsListMutex = new Object();
    public final DefaultTVListener tvListener = new TVListenerExt();
    public final ISettingListener settingListener = new SettingListener();
    private final TVEnv env;
    private final EWSBeepHandler beepHandler;
    private final IEWSListener ewsListener;
    private final BaseListModelApp affectedList;
    private final ChoiceModelApp ewsTimeoutChoice;
    private boolean isEWSAvailable = false;
    private final LogChannel log;
    private boolean isEwsActive = false;
    private volatile boolean isEwsEnabled = true;
    public static final Map AREA_MAPPING = new HashMap();
    public static final Map COUNTRY_MAPPING = new HashMap();
    public static final int UNKNOWN_AREA = 53;
    private IEWSPopupHandler popupHandler = new IEWSPopupHandler(){

        public void showPopup() {
        }

        public void showDetails() {
        }

        public void showAreaList() {
        }

        public void hidePopup() {
        }
    };

    public EWS(TVEnv tVEnv, EWSBeepHandler eWSBeepHandler, IEWSListener iEWSListener) {
        this.env = tVEnv;
        this.log = tVEnv.lcMain;
        this.beepHandler = eWSBeepHandler;
        this.ewsListener = iEWSListener;
        this.affectedList = tVEnv.getBaseListModel(2600033);
        PopUpCloseListener popUpCloseListener = new PopUpCloseListener();
        tVEnv.getButtonModel(2600155).setButtonListener(popUpCloseListener);
        this.ewsTimeoutChoice = tVEnv.getChoiceModel(2600150);
        this.ewsTimeoutChoice.setButtonListener(popUpCloseListener);
        this.ewsTimeoutChoice.setStatus(0);
        tVEnv.getButtonModel(2600179).setButtonListener(popUpCloseListener);
        tVEnv.getButtonModel(2600178).setButtonListener(popUpCloseListener);
        tVEnv.getChoiceModel(2600153).setChoiceListener(new DefaultChoiceListener(){

            public void keyTyped(int n, int n2, int n3) {
                EWS.this.log.log(1000000, "[EWS.itemFocused] cancel timeout");
                EWS.this.ewsTimeoutChoice.setStatus(1);
                EWS.this.ewsTimeoutChoice.setStatus(0);
            }
        });
    }

    public void registerPopupHandler(IEWSPopupHandler iEWSPopupHandler) {
        this.popupHandler = iEWSPopupHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setEWSInfoList(EWSInfo[] eWSInfoArray) {
        this.log.log(1000000, "[EWS.setEWSInfoList] show 'popup'");
        Object object = this.ewsListMutex;
        synchronized (object) {
            for (int i2 = 0; i2 < eWSInfoArray.length; ++i2) {
                this.ewsList.add(eWSInfoArray[i2]);
            }
            if (!this.ewsList.isEmpty() && !this.isEwsActive) {
                this.ewsListener.onEWSInfosActivated();
                this.isEwsActive = true;
                this.showNextEWSPopup();
            }
        }
    }

    public boolean showNextEWSPopup() {
        if (this.ewsList.isEmpty()) {
            this.log.log(1000000, "[EWS.showNextEWSPopup] No EWS info found --> remove 'popup'");
            this.isEwsActive = false;
            this.ewsTimeoutChoice.fireEvent(0);
            this.popupHandler.hidePopup();
            this.ewsListener.onEWSInfosDeactivated();
            return false;
        }
        this.popupHandler.hidePopup();
        EWSInfo eWSInfo = (EWSInfo)this.ewsList.removeFirst();
        if (eWSInfo.warningTime != null) {
            this.log.log(10000000, "[EWS.showNextEWSPopup] hour:0x%1 minute:0x%2", (long)eWSInfo.warningTime.hour, (long)eWSInfo.warningTime.minute);
        }
        this.log.log(10000000, "[EWS.showNextEWSPopup] warningType:0x%1 affectedArea:0x%2", (long)eWSInfo.warningType, (long)eWSInfo.affectedArea);
        this.setWarningTime(eWSInfo);
        this.env.getChoiceModel(2600035).setValue(eWSInfo.warningPrio);
        this.env.getChoiceModel(2600035).setStatus(eWSInfo.warningPrio > 0 ? 1 : 0);
        this.env.getChoiceModel(2600036).setValue(eWSInfo.warningSrcClass);
        this.env.getChoiceModel(2600036).setStatus(eWSInfo.warningSrcClass > 0 ? 1 : 0);
        this.env.getChoiceModel(2600037).setValue(eWSInfo.warningType);
        this.env.getChoiceModel(2600037).setStatus(eWSInfo.warningType > 0 ? 1 : 0);
        this.env.getChoiceModel(2600032).setValue(eWSInfo.affectedArea);
        this.env.getChoiceModel(2600032).setStatus(eWSInfo.affectedArea > 0 ? 1 : 0);
        String string = eWSInfo.messageText != null ? eWSInfo.messageText : "";
        this.env.getLabelModel(2600088).setText(string);
        this.env.getLabelModel(2600088).setStatus("".equals(string) ? 0 : 1);
        int n = this.getHMICountryCode(eWSInfo.getOriginCountry());
        this.env.getChoiceModel(2600182).setValue(n);
        this.env.getChoiceModel(2600182).setStatus(n >= 0 ? 1 : 0);
        boolean bl = this.setTimeout(eWSInfo.warningPrio);
        BaseListModelApp baseListModelApp = this.affectedList.getEmptyCopy();
        if (eWSInfo.areaCodeListNames != null) {
            for (int i2 = 0; i2 < eWSInfo.areaCodeListNames.length; ++i2) {
                int n2 = this.getHMIAreaCode(eWSInfo.areaCodeListNames[i2]);
                if (n2 == 53) continue;
                baseListModelApp.append(new EWSAreaRow(n2, eWSInfo.areaCodeListNames[i2]));
            }
        }
        this.affectedList.update(baseListModelApp);
        this.affectedList.setStatus(this.affectedList.getLength() > 0 ? 1 : 0);
        if (bl) {
            this.ewsTimeoutChoice.setStatus(0);
            this.ewsTimeoutChoice.setStatus(1);
        } else {
            this.ewsTimeoutChoice.setStatus(1);
            this.ewsTimeoutChoice.setStatus(0);
            this.ewsTimeoutChoice.setValue(0);
        }
        this.popupHandler.showPopup();
        return true;
    }

    private void setWarningTime(EWSInfo eWSInfo) {
        DateMetric dateMetric = BCDTime.getDateMetric(eWSInfo.warningTime);
        MetricsModelApp metricsModelApp = this.env.getMetricsModel(2600152);
        metricsModelApp.setMetric(dateMetric);
        metricsModelApp.setStatus(dateMetric != null ? 1 : 0);
        MetricsModelApp metricsModelApp2 = this.env.getMetricsModel(2600228);
        DateMetric dateMetric2 = BCDTime.getDateMetric(eWSInfo.receivingTime);
        metricsModelApp2.setMetric(dateMetric2);
        metricsModelApp2.setStatus(dateMetric2 != null ? 1 : 0);
    }

    private boolean setTimeout(int n) {
        switch (n) {
            case 2: 
            case 3: 
            case 8: 
            case 9: {
                this.ewsTimeoutChoice.setValue(30000);
                return true;
            }
            case 12: 
            case 14: {
                this.ewsTimeoutChoice.setValue(60000);
                return true;
            }
        }
        this.ewsTimeoutChoice.setValue(0);
        return false;
    }

    private void playWarnTone(int n) {
        this.beepHandler.playWarnTone(n);
        switch (n) {
            case 2: 
            case 7: 
            case 8: 
            case 12: {
                break;
            }
            case 3: 
            case 4: 
            case 9: 
            case 13: {
                break;
            }
            case 5: 
            case 10: 
            case 14: 
            case 15: {
                break;
            }
        }
    }

    private int getHMIAreaCode(String string) {
        Integer n = (Integer)AREA_MAPPING.get(string);
        int n2 = n != null ? n : 53;
        this.log.log(10000000, "[EWS.getHMIAreaCode] %1 --> %2", (Object)string, (long)n2);
        if (n2 == 53) {
            this.log.log(100000, "[EWS.getHMIAreaCode] area code %1 is unknown!", (Object)string);
        }
        return n2;
    }

    private int getHMICountryCode(String string) {
        Integer n;
        String string2 = "XUX";
        if (string != null) {
            if (string.length() == 2) {
                string2 = string;
            } else if (string.length() > 2 && string.charAt(2) == '-') {
                string2 = string.substring(0, 2);
            }
        }
        int n2 = (n = (Integer)COUNTRY_MAPPING.get(string2)) != null ? n : -1;
        this.log.log(10000000, "[EWS.getHMICountryCode] %1 --> %2", (Object)string2, (long)n2);
        return n2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void onEwsPopupClosed() {
        Object object = this.ewsListMutex;
        synchronized (object) {
            this.log.log(1000000, "[EWS.onEwsPopupClosed]");
            this.ewsList.clear();
            this.showNextEWSPopup();
        }
    }

    static {
        AREA_MAPPING.put("001101001101", new Integer(0));
        AREA_MAPPING.put("010110100101", new Integer(1));
        AREA_MAPPING.put("011100101010", new Integer(2));
        AREA_MAPPING.put("100011010101", new Integer(3));
        AREA_MAPPING.put("011010011001", new Integer(4));
        AREA_MAPPING.put("010101010011", new Integer(5));
        AREA_MAPPING.put("000101101011", new Integer(6));
        AREA_MAPPING.put("010001100111", new Integer(7));
        AREA_MAPPING.put("010111010100", new Integer(8));
        AREA_MAPPING.put("011101011000", new Integer(9));
        AREA_MAPPING.put("101011000110", new Integer(10));
        AREA_MAPPING.put("111001001100", new Integer(11));
        AREA_MAPPING.put("000110101110", new Integer(12));
        AREA_MAPPING.put("110001101001", new Integer(13));
        AREA_MAPPING.put("111000111000", new Integer(14));
        AREA_MAPPING.put("100110001011", new Integer(15));
        AREA_MAPPING.put("011001001011", new Integer(16));
        AREA_MAPPING.put("000111000111", new Integer(17));
        AREA_MAPPING.put("101010101100", new Integer(18));
        AREA_MAPPING.put("010101101100", new Integer(19));
        AREA_MAPPING.put("010011001110", new Integer(20));
        AREA_MAPPING.put("010100111001", new Integer(21));
        AREA_MAPPING.put("011010100110", new Integer(22));
        AREA_MAPPING.put("100100101101", new Integer(23));
        AREA_MAPPING.put("110101001010", new Integer(24));
        AREA_MAPPING.put("100111010010", new Integer(25));
        AREA_MAPPING.put("101001100101", new Integer(26));
        AREA_MAPPING.put("101001011010", new Integer(27));
        AREA_MAPPING.put("100101100110", new Integer(28));
        AREA_MAPPING.put("001011011100", new Integer(29));
        AREA_MAPPING.put("110011100100", new Integer(30));
        AREA_MAPPING.put("010110011010", new Integer(31));
        AREA_MAPPING.put("110010110010", new Integer(32));
        AREA_MAPPING.put("011001110100", new Integer(33));
        AREA_MAPPING.put("101010010011", new Integer(34));
        AREA_MAPPING.put("001110010110", new Integer(35));
        AREA_MAPPING.put("110100100011", new Integer(36));
        AREA_MAPPING.put("001100011011", new Integer(37));
        AREA_MAPPING.put("001010110101", new Integer(38));
        AREA_MAPPING.put("101100110001", new Integer(39));
        AREA_MAPPING.put("101110011000", new Integer(40));
        AREA_MAPPING.put("111001100010", new Integer(41));
        AREA_MAPPING.put("100110110100", new Integer(42));
        AREA_MAPPING.put("000110011101", new Integer(43));
        AREA_MAPPING.put("001011100011", new Integer(44));
        AREA_MAPPING.put("011000101101", new Integer(45));
        AREA_MAPPING.put("100101011001", new Integer(46));
        AREA_MAPPING.put("101000101011", new Integer(47));
        AREA_MAPPING.put("100010100111", new Integer(48));
        AREA_MAPPING.put("110010001101", new Integer(49));
        AREA_MAPPING.put("110100011100", new Integer(50));
        AREA_MAPPING.put("110101000101", new Integer(51));
        AREA_MAPPING.put("001101110010", new Integer(52));
        AREA_MAPPING.put("1100000000", new Integer(54));
        AREA_MAPPING.put("1111000000", new Integer(55));
        AREA_MAPPING.put("1114000000", new Integer(56));
        AREA_MAPPING.put("1117000000", new Integer(57));
        AREA_MAPPING.put("1120000000", new Integer(58));
        AREA_MAPPING.put("1121500000", new Integer(59));
        AREA_MAPPING.put("1123000000", new Integer(60));
        AREA_MAPPING.put("1126000000", new Integer(61));
        AREA_MAPPING.put("1129000000", new Integer(62));
        AREA_MAPPING.put("1130500000", new Integer(63));
        AREA_MAPPING.put("1132000000", new Integer(64));
        AREA_MAPPING.put("1135000000", new Integer(65));
        AREA_MAPPING.put("1138000000", new Integer(66));
        AREA_MAPPING.put("1141000000", new Integer(67));
        AREA_MAPPING.put("1144000000", new Integer(68));
        AREA_MAPPING.put("1147000000", new Integer(69));
        AREA_MAPPING.put("1150000000", new Integer(70));
        AREA_MAPPING.put("1153000000", new Integer(71));
        AREA_MAPPING.put("1154500000", new Integer(72));
        AREA_MAPPING.put("1156000000", new Integer(73));
        AREA_MAPPING.put("1159000000", new Integer(74));
        AREA_MAPPING.put("1162000000", new Integer(75));
        AREA_MAPPING.put("1165000000", new Integer(76));
        AREA_MAPPING.put("1168000000", new Integer(77));
        AREA_MAPPING.put("1171000000", new Integer(78));
        AREA_MAPPING.put("1174000000", new Integer(79));
        AREA_MAPPING.put("2600000000", new Integer(80));
        AREA_MAPPING.put("2611000000", new Integer(81));
        AREA_MAPPING.put("2614000000", new Integer(82));
        AREA_MAPPING.put("2617000000", new Integer(83));
        AREA_MAPPING.put("2620000000", new Integer(84));
        AREA_MAPPING.put("2623000000", new Integer(85));
        AREA_MAPPING.put("2626000000", new Integer(86));
        AREA_MAPPING.put("2629000000", new Integer(87));
        AREA_MAPPING.put("2632000000", new Integer(88));
        AREA_MAPPING.put("2635000000", new Integer(89));
        AREA_MAPPING.put("2638000000", new Integer(90));
        AREA_MAPPING.put("2641000000", new Integer(91));
        AREA_MAPPING.put("2644000000", new Integer(92));
        AREA_MAPPING.put("2647000000", new Integer(93));
        AREA_MAPPING.put("2650000000", new Integer(94));
        AREA_MAPPING.put("2653000000", new Integer(95));
        AREA_MAPPING.put("2671000000", new Integer(96));
        AREA_MAPPING.put("2700000000", new Integer(97));
        AREA_MAPPING.put("2711000000", new Integer(98));
        AREA_MAPPING.put("2714000000", new Integer(99));
        AREA_MAPPING.put("2717000000", new Integer(100));
        AREA_MAPPING.put("2720000000", new Integer(101));
        AREA_MAPPING.put("2723000000", new Integer(102));
        AREA_MAPPING.put("2726000000", new Integer(103));
        AREA_MAPPING.put("2729000000", new Integer(104));
        AREA_MAPPING.put("2771000000", new Integer(105));
        AREA_MAPPING.put("2800000000", new Integer(106));
        AREA_MAPPING.put("2811000000", new Integer(108));
        AREA_MAPPING.put("2811500000", new Integer(108));
        AREA_MAPPING.put("2811600000", new Integer(109));
        AREA_MAPPING.put("2814000000", new Integer(110));
        AREA_MAPPING.put("2817000000", new Integer(111));
        AREA_MAPPING.put("2818500000", new Integer(112));
        AREA_MAPPING.put("2820000000", new Integer(113));
        AREA_MAPPING.put("2823700000", new Integer(114));
        AREA_MAPPING.put("2824500000", new Integer(115));
        AREA_MAPPING.put("2826000000", new Integer(116));
        AREA_MAPPING.put("2826500000", new Integer(117));
        AREA_MAPPING.put("2871000000", new Integer(118));
        AREA_MAPPING.put("2872000000", new Integer(119));
        AREA_MAPPING.put("2900000000", new Integer(120));
        AREA_MAPPING.put("2911000000", new Integer(121));
        AREA_MAPPING.put("2914000000", new Integer(122));
        AREA_MAPPING.put("2915500000", new Integer(123));
        AREA_MAPPING.put("2917000000", new Integer(124));
        AREA_MAPPING.put("2920000000", new Integer(125));
        AREA_MAPPING.put("3000000000", new Integer(126));
        AREA_MAPPING.put("3011000000", new Integer(127));
        AREA_MAPPING.put("3014000000", new Integer(128));
        AREA_MAPPING.put("3017000000", new Integer(129));
        AREA_MAPPING.put("3020000000", new Integer(130));
        AREA_MAPPING.put("3023000000", new Integer(131));
        AREA_MAPPING.put("3100000000", new Integer(132));
        AREA_MAPPING.put("3111000000", new Integer(133));
        AREA_MAPPING.put("3114000000", new Integer(134));
        AREA_MAPPING.put("3117000000", new Integer(135));
        AREA_MAPPING.put("3120000000", new Integer(136));
        AREA_MAPPING.put("3171000000", new Integer(137));
        AREA_MAPPING.put("4100000000", new Integer(138));
        AREA_MAPPING.put("4110500000", new Integer(139));
        AREA_MAPPING.put("4111000000", new Integer(140));
        AREA_MAPPING.put("4111100000", new Integer(141));
        AREA_MAPPING.put("4111300000", new Integer(142));
        AREA_MAPPING.put("4111500000", new Integer(143));
        AREA_MAPPING.put("4111700000", new Integer(144));
        AREA_MAPPING.put("4113000000", new Integer(145));
        AREA_MAPPING.put("4113100000", new Integer(146));
        AREA_MAPPING.put("4113300000", new Integer(147));
        AREA_MAPPING.put("4113500000", new Integer(148));
        AREA_MAPPING.put("4115000000", new Integer(149));
        AREA_MAPPING.put("4117000000", new Integer(150));
        AREA_MAPPING.put("4117100000", new Integer(151));
        AREA_MAPPING.put("4117300000", new Integer(152));
        AREA_MAPPING.put("4119000000", new Integer(153));
        AREA_MAPPING.put("4119500000", new Integer(154));
        AREA_MAPPING.put("4119700000", new Integer(155));
        AREA_MAPPING.put("4119900000", new Integer(156));
        AREA_MAPPING.put("4121000000", new Integer(157));
        AREA_MAPPING.put("4122000000", new Integer(158));
        AREA_MAPPING.put("4125000000", new Integer(159));
        AREA_MAPPING.put("4127000000", new Integer(160));
        AREA_MAPPING.put("4127100000", new Integer(161));
        AREA_MAPPING.put("4127300000", new Integer(162));
        AREA_MAPPING.put("4128000000", new Integer(163));
        AREA_MAPPING.put("4128100000", new Integer(164));
        AREA_MAPPING.put("4128500000", new Integer(165));
        AREA_MAPPING.put("4128700000", new Integer(166));
        AREA_MAPPING.put("4129000000", new Integer(167));
        AREA_MAPPING.put("4131000000", new Integer(168));
        AREA_MAPPING.put("4136000000", new Integer(169));
        AREA_MAPPING.put("4137000000", new Integer(170));
        AREA_MAPPING.put("4139000000", new Integer(171));
        AREA_MAPPING.put("4141000000", new Integer(172));
        AREA_MAPPING.put("4143000000", new Integer(173));
        AREA_MAPPING.put("4145000000", new Integer(174));
        AREA_MAPPING.put("4146000000", new Integer(175));
        AREA_MAPPING.put("4146100000", new Integer(176));
        AREA_MAPPING.put("4146300000", new Integer(177));
        AREA_MAPPING.put("4146500000", new Integer(178));
        AREA_MAPPING.put("4148000000", new Integer(179));
        AREA_MAPPING.put("4150000000", new Integer(180));
        AREA_MAPPING.put("4155000000", new Integer(181));
        AREA_MAPPING.put("4157000000", new Integer(182));
        AREA_MAPPING.put("4159000000", new Integer(183));
        AREA_MAPPING.put("4161000000", new Integer(184));
        AREA_MAPPING.put("4163000000", new Integer(185));
        AREA_MAPPING.put("4165000000", new Integer(186));
        AREA_MAPPING.put("4173000000", new Integer(187));
        AREA_MAPPING.put("4180000000", new Integer(188));
        AREA_MAPPING.put("4182000000", new Integer(189));
        AREA_MAPPING.put("4183000000", new Integer(190));
        AREA_MAPPING.put("4200000000", new Integer(191));
        AREA_MAPPING.put("4210500000", new Integer(192));
        AREA_MAPPING.put("4211000000", new Integer(193));
        AREA_MAPPING.put("4213000000", new Integer(194));
        AREA_MAPPING.put("4215000000", new Integer(195));
        AREA_MAPPING.put("4217000000", new Integer(196));
        AREA_MAPPING.put("4219000000", new Integer(197));
        AREA_MAPPING.put("4221000000", new Integer(198));
        AREA_MAPPING.put("4223000000", new Integer(199));
        AREA_MAPPING.put("4272000000", new Integer(200));
        AREA_MAPPING.put("4273000000", new Integer(201));
        AREA_MAPPING.put("4275000000", new Integer(202));
        AREA_MAPPING.put("4276000000", new Integer(203));
        AREA_MAPPING.put("4277000000", new Integer(204));
        AREA_MAPPING.put("4278000000", new Integer(205));
        AREA_MAPPING.put("4279000000", new Integer(206));
        AREA_MAPPING.put("4280000000", new Integer(207));
        AREA_MAPPING.put("4281000000", new Integer(208));
        AREA_MAPPING.put("4282000000", new Integer(209));
        AREA_MAPPING.put("4283000000", new Integer(210));
        AREA_MAPPING.put("4300000000", new Integer(211));
        AREA_MAPPING.put("4311000000", new Integer(212));
        AREA_MAPPING.put("4311100000", new Integer(213));
        AREA_MAPPING.put("4311300000", new Integer(214));
        AREA_MAPPING.put("4313000000", new Integer(215));
        AREA_MAPPING.put("4315000000", new Integer(216));
        AREA_MAPPING.put("4371000000", new Integer(217));
        AREA_MAPPING.put("4372000000", new Integer(218));
        AREA_MAPPING.put("4373000000", new Integer(219));
        AREA_MAPPING.put("4374000000", new Integer(220));
        AREA_MAPPING.put("4374500000", new Integer(221));
        AREA_MAPPING.put("4375000000", new Integer(222));
        AREA_MAPPING.put("4376000000", new Integer(223));
        AREA_MAPPING.put("4377000000", new Integer(224));
        AREA_MAPPING.put("4380000000", new Integer(225));
        AREA_MAPPING.put("4400000000", new Integer(226));
        AREA_MAPPING.put("4413000000", new Integer(227));
        AREA_MAPPING.put("4413100000", new Integer(228));
        AREA_MAPPING.put("4413300000", new Integer(229));
        AREA_MAPPING.put("4415000000", new Integer(230));
        AREA_MAPPING.put("4418000000", new Integer(231));
        AREA_MAPPING.put("4420000000", new Integer(232));
        AREA_MAPPING.put("4421000000", new Integer(233));
        AREA_MAPPING.put("4423000000", new Integer(234));
        AREA_MAPPING.put("4425000000", new Integer(235));
        AREA_MAPPING.put("4471000000", new Integer(236));
        AREA_MAPPING.put("4473000000", new Integer(237));
        AREA_MAPPING.put("4476000000", new Integer(238));
        AREA_MAPPING.put("4477000000", new Integer(239));
        AREA_MAPPING.put("4479000000", new Integer(240));
        AREA_MAPPING.put("4480000000", new Integer(241));
        AREA_MAPPING.put("4481000000", new Integer(242));
        AREA_MAPPING.put("4482500000", new Integer(243));
        AREA_MAPPING.put("4483000000", new Integer(244));
        AREA_MAPPING.put("4500000000", new Integer(245));
        AREA_MAPPING.put("4511000000", new Integer(246));
        AREA_MAPPING.put("4511100000", new Integer(247));
        AREA_MAPPING.put("4511300000", new Integer(248));
        AREA_MAPPING.put("4511800000", new Integer(249));
        AREA_MAPPING.put("4513000000", new Integer(250));
        AREA_MAPPING.put("4514000000", new Integer(251));
        AREA_MAPPING.put("4514500000", new Integer(252));
        AREA_MAPPING.put("4518000000", new Integer(253));
        AREA_MAPPING.put("4519000000", new Integer(254));
        AREA_MAPPING.put("4521000000", new Integer(255));
        AREA_MAPPING.put("4571000000", new Integer(256));
        AREA_MAPPING.put("4572000000", new Integer(257));
        AREA_MAPPING.put("4573000000", new Integer(258));
        AREA_MAPPING.put("4574000000", new Integer(259));
        AREA_MAPPING.put("4575000000", new Integer(260));
        AREA_MAPPING.put("4577000000", new Integer(261));
        AREA_MAPPING.put("4579000000", new Integer(262));
        AREA_MAPPING.put("4580000000", new Integer(263));
        AREA_MAPPING.put("4600000000", new Integer(264));
        AREA_MAPPING.put("4611000000", new Integer(265));
        AREA_MAPPING.put("4613000000", new Integer(266));
        AREA_MAPPING.put("4615000000", new Integer(267));
        AREA_MAPPING.put("4617000000", new Integer(268));
        AREA_MAPPING.put("4623000000", new Integer(269));
        AREA_MAPPING.put("4671000000", new Integer(270));
        AREA_MAPPING.put("4672000000", new Integer(271));
        AREA_MAPPING.put("4673000000", new Integer(272));
        AREA_MAPPING.put("4677000000", new Integer(273));
        AREA_MAPPING.put("4678000000", new Integer(274));
        AREA_MAPPING.put("4679000000", new Integer(275));
        AREA_MAPPING.put("4680000000", new Integer(276));
        AREA_MAPPING.put("4681000000", new Integer(277));
        AREA_MAPPING.put("4682000000", new Integer(278));
        AREA_MAPPING.put("4683000000", new Integer(279));
        AREA_MAPPING.put("4684000000", new Integer(280));
        AREA_MAPPING.put("4686000000", new Integer(281));
        AREA_MAPPING.put("4687000000", new Integer(282));
        AREA_MAPPING.put("4688000000", new Integer(283));
        AREA_MAPPING.put("4689000000", new Integer(284));
        AREA_MAPPING.put("4690000000", new Integer(285));
        AREA_MAPPING.put("4691000000", new Integer(286));
        AREA_MAPPING.put("4700000000", new Integer(287));
        AREA_MAPPING.put("4711000000", new Integer(288));
        AREA_MAPPING.put("4711100000", new Integer(289));
        AREA_MAPPING.put("4711300000", new Integer(290));
        AREA_MAPPING.put("4713000000", new Integer(291));
        AREA_MAPPING.put("4715000000", new Integer(292));
        AREA_MAPPING.put("4717000000", new Integer(293));
        AREA_MAPPING.put("4719000000", new Integer(294));
        AREA_MAPPING.put("4721000000", new Integer(295));
        AREA_MAPPING.put("4723000000", new Integer(296));
        AREA_MAPPING.put("4725000000", new Integer(297));
        AREA_MAPPING.put("4728000000", new Integer(298));
        AREA_MAPPING.put("4729000000", new Integer(299));
        AREA_MAPPING.put("4772000000", new Integer(300));
        AREA_MAPPING.put("4773000000", new Integer(301));
        AREA_MAPPING.put("4775000000", new Integer(302));
        AREA_MAPPING.put("4776000000", new Integer(303));
        AREA_MAPPING.put("4777000000", new Integer(304));
        AREA_MAPPING.put("4782000000", new Integer(305));
        AREA_MAPPING.put("4783000000", new Integer(306));
        AREA_MAPPING.put("4784000000", new Integer(307));
        AREA_MAPPING.put("4785000000", new Integer(308));
        AREA_MAPPING.put("4790000000", new Integer(309));
        AREA_MAPPING.put("4792000000", new Integer(310));
        AREA_MAPPING.put("4793000000", new Integer(311));
        AREA_MAPPING.put("4794000000", new Integer(312));
        AREA_MAPPING.put("4800000000", new Integer(313));
        AREA_MAPPING.put("4812000000", new Integer(314));
        AREA_MAPPING.put("4817000000", new Integer(315));
        AREA_MAPPING.put("4822000000", new Integer(316));
        AREA_MAPPING.put("4824000000", new Integer(317));
        AREA_MAPPING.put("4824500000", new Integer(318));
        AREA_MAPPING.put("4825000000", new Integer(319));
        AREA_MAPPING.put("4827000000", new Integer(320));
        AREA_MAPPING.put("4831000000", new Integer(321));
        AREA_MAPPING.put("4833000000", new Integer(322));
        AREA_MAPPING.put("4872000000", new Integer(323));
        AREA_MAPPING.put("4873000000", new Integer(324));
        AREA_MAPPING.put("4874000000", new Integer(325));
        AREA_MAPPING.put("4882000000", new Integer(326));
        AREA_MAPPING.put("4884000000", new Integer(327));
        AREA_MAPPING.put("4885000000", new Integer(328));
        AREA_MAPPING.put("4886000000", new Integer(329));
        AREA_MAPPING.put("4887000000", new Integer(330));
        AREA_MAPPING.put("4888000000", new Integer(331));
        AREA_MAPPING.put("4889000000", new Integer(332));
        AREA_MAPPING.put("5000000000", new Integer(333));
        AREA_MAPPING.put("5011000000", new Integer(334));
        AREA_MAPPING.put("5013000000", new Integer(335));
        COUNTRY_MAPPING.put("JP", new Integer(0));
        COUNTRY_MAPPING.put("CN", new Integer(1));
        COUNTRY_MAPPING.put("HK", new Integer(2));
        COUNTRY_MAPPING.put("MO", new Integer(3));
        COUNTRY_MAPPING.put("TW", new Integer(4));
        COUNTRY_MAPPING.put("AD", new Integer(5));
        COUNTRY_MAPPING.put("AF", new Integer(6));
        COUNTRY_MAPPING.put("AX", new Integer(7));
        COUNTRY_MAPPING.put("AL", new Integer(8));
        COUNTRY_MAPPING.put("DZ", new Integer(9));
        COUNTRY_MAPPING.put("AS", new Integer(10));
        COUNTRY_MAPPING.put("AO", new Integer(11));
        COUNTRY_MAPPING.put("AI", new Integer(12));
        COUNTRY_MAPPING.put("AQ", new Integer(13));
        COUNTRY_MAPPING.put("AG", new Integer(14));
        COUNTRY_MAPPING.put("AM", new Integer(15));
        COUNTRY_MAPPING.put("AW", new Integer(16));
        COUNTRY_MAPPING.put("AU", new Integer(17));
        COUNTRY_MAPPING.put("AT", new Integer(18));
        COUNTRY_MAPPING.put("AZ", new Integer(19));
        COUNTRY_MAPPING.put("BS", new Integer(20));
        COUNTRY_MAPPING.put("BH", new Integer(21));
        COUNTRY_MAPPING.put("BD", new Integer(22));
        COUNTRY_MAPPING.put("BB", new Integer(23));
        COUNTRY_MAPPING.put("BY", new Integer(24));
        COUNTRY_MAPPING.put("BE", new Integer(25));
        COUNTRY_MAPPING.put("BZ", new Integer(26));
        COUNTRY_MAPPING.put("BJ", new Integer(27));
        COUNTRY_MAPPING.put("BM", new Integer(28));
        COUNTRY_MAPPING.put("BT", new Integer(29));
        COUNTRY_MAPPING.put("BQ", new Integer(30));
        COUNTRY_MAPPING.put("BA", new Integer(31));
        COUNTRY_MAPPING.put("BW", new Integer(32));
        COUNTRY_MAPPING.put("BV", new Integer(33));
        COUNTRY_MAPPING.put("IO", new Integer(34));
        COUNTRY_MAPPING.put("BN", new Integer(35));
        COUNTRY_MAPPING.put("BG", new Integer(36));
        COUNTRY_MAPPING.put("BF", new Integer(37));
        COUNTRY_MAPPING.put("BI", new Integer(38));
        COUNTRY_MAPPING.put("CV", new Integer(39));
        COUNTRY_MAPPING.put("KH", new Integer(40));
        COUNTRY_MAPPING.put("CM", new Integer(41));
        COUNTRY_MAPPING.put("CA", new Integer(42));
        COUNTRY_MAPPING.put("KY", new Integer(43));
        COUNTRY_MAPPING.put("CF", new Integer(44));
        COUNTRY_MAPPING.put("TD", new Integer(45));
        COUNTRY_MAPPING.put("CX", new Integer(46));
        COUNTRY_MAPPING.put("CC", new Integer(47));
        COUNTRY_MAPPING.put("KM", new Integer(48));
        COUNTRY_MAPPING.put("CG", new Integer(49));
        COUNTRY_MAPPING.put("CD", new Integer(50));
        COUNTRY_MAPPING.put("CK", new Integer(51));
        COUNTRY_MAPPING.put("CI", new Integer(52));
        COUNTRY_MAPPING.put("HR", new Integer(53));
        COUNTRY_MAPPING.put("CU", new Integer(54));
        COUNTRY_MAPPING.put("CW", new Integer(55));
        COUNTRY_MAPPING.put("CY", new Integer(56));
        COUNTRY_MAPPING.put("CZ", new Integer(57));
        COUNTRY_MAPPING.put("DK", new Integer(58));
        COUNTRY_MAPPING.put("DJ", new Integer(59));
        COUNTRY_MAPPING.put("DM", new Integer(60));
        COUNTRY_MAPPING.put("DO", new Integer(61));
        COUNTRY_MAPPING.put("EC", new Integer(62));
        COUNTRY_MAPPING.put("EG", new Integer(63));
        COUNTRY_MAPPING.put("SV", new Integer(64));
        COUNTRY_MAPPING.put("GQ", new Integer(65));
        COUNTRY_MAPPING.put("ER", new Integer(66));
        COUNTRY_MAPPING.put("EE", new Integer(67));
        COUNTRY_MAPPING.put("ET", new Integer(68));
        COUNTRY_MAPPING.put("FK", new Integer(69));
        COUNTRY_MAPPING.put("FO", new Integer(70));
        COUNTRY_MAPPING.put("FJ", new Integer(71));
        COUNTRY_MAPPING.put("FI", new Integer(72));
        COUNTRY_MAPPING.put("FR", new Integer(73));
        COUNTRY_MAPPING.put("PF", new Integer(74));
        COUNTRY_MAPPING.put("TF", new Integer(75));
        COUNTRY_MAPPING.put("GA", new Integer(76));
        COUNTRY_MAPPING.put("GM", new Integer(77));
        COUNTRY_MAPPING.put("GE", new Integer(78));
        COUNTRY_MAPPING.put("DE", new Integer(79));
        COUNTRY_MAPPING.put("GH", new Integer(80));
        COUNTRY_MAPPING.put("GI", new Integer(81));
        COUNTRY_MAPPING.put("GR", new Integer(82));
        COUNTRY_MAPPING.put("GL", new Integer(83));
        COUNTRY_MAPPING.put("GD", new Integer(84));
        COUNTRY_MAPPING.put("GP", new Integer(85));
        COUNTRY_MAPPING.put("GU", new Integer(86));
        COUNTRY_MAPPING.put("GT", new Integer(87));
        COUNTRY_MAPPING.put("GG", new Integer(88));
        COUNTRY_MAPPING.put("GN", new Integer(89));
        COUNTRY_MAPPING.put("GW", new Integer(90));
        COUNTRY_MAPPING.put("HT", new Integer(91));
        COUNTRY_MAPPING.put("HM", new Integer(92));
        COUNTRY_MAPPING.put("VA", new Integer(93));
        COUNTRY_MAPPING.put("HU", new Integer(94));
        COUNTRY_MAPPING.put("IS", new Integer(95));
        COUNTRY_MAPPING.put("IN", new Integer(96));
        COUNTRY_MAPPING.put("ID", new Integer(97));
        COUNTRY_MAPPING.put("IR", new Integer(98));
        COUNTRY_MAPPING.put("IQ", new Integer(99));
        COUNTRY_MAPPING.put("IE", new Integer(100));
        COUNTRY_MAPPING.put("IM", new Integer(101));
        COUNTRY_MAPPING.put("IL", new Integer(102));
        COUNTRY_MAPPING.put("IT", new Integer(103));
        COUNTRY_MAPPING.put("JM", new Integer(104));
        COUNTRY_MAPPING.put("JE", new Integer(105));
        COUNTRY_MAPPING.put("JO", new Integer(106));
        COUNTRY_MAPPING.put("KZ", new Integer(107));
        COUNTRY_MAPPING.put("KE", new Integer(108));
        COUNTRY_MAPPING.put("KI", new Integer(109));
        COUNTRY_MAPPING.put("KW", new Integer(110));
        COUNTRY_MAPPING.put("KG", new Integer(111));
        COUNTRY_MAPPING.put("LA", new Integer(112));
        COUNTRY_MAPPING.put("LV", new Integer(113));
        COUNTRY_MAPPING.put("LB", new Integer(114));
        COUNTRY_MAPPING.put("LS", new Integer(115));
        COUNTRY_MAPPING.put("LR", new Integer(116));
        COUNTRY_MAPPING.put("LY", new Integer(117));
        COUNTRY_MAPPING.put("LI", new Integer(118));
        COUNTRY_MAPPING.put("LT", new Integer(119));
        COUNTRY_MAPPING.put("LU", new Integer(120));
        COUNTRY_MAPPING.put("MK", new Integer(121));
        COUNTRY_MAPPING.put("MG", new Integer(122));
        COUNTRY_MAPPING.put("MW", new Integer(123));
        COUNTRY_MAPPING.put("MY", new Integer(124));
        COUNTRY_MAPPING.put("MV", new Integer(125));
        COUNTRY_MAPPING.put("ML", new Integer(126));
        COUNTRY_MAPPING.put("MT", new Integer(127));
        COUNTRY_MAPPING.put("MH", new Integer(128));
        COUNTRY_MAPPING.put("MQ", new Integer(129));
        COUNTRY_MAPPING.put("MR", new Integer(130));
        COUNTRY_MAPPING.put("MU", new Integer(131));
        COUNTRY_MAPPING.put("YT", new Integer(132));
        COUNTRY_MAPPING.put("MX", new Integer(133));
        COUNTRY_MAPPING.put("FM", new Integer(134));
        COUNTRY_MAPPING.put("MD", new Integer(135));
        COUNTRY_MAPPING.put("MC", new Integer(136));
        COUNTRY_MAPPING.put("MN", new Integer(137));
        COUNTRY_MAPPING.put("ME", new Integer(138));
        COUNTRY_MAPPING.put("MS", new Integer(139));
        COUNTRY_MAPPING.put("MA", new Integer(140));
        COUNTRY_MAPPING.put("MZ", new Integer(141));
        COUNTRY_MAPPING.put("MM", new Integer(142));
        COUNTRY_MAPPING.put("NA", new Integer(143));
        COUNTRY_MAPPING.put("NR", new Integer(144));
        COUNTRY_MAPPING.put("NP", new Integer(145));
        COUNTRY_MAPPING.put("NL", new Integer(146));
        COUNTRY_MAPPING.put("NC", new Integer(147));
        COUNTRY_MAPPING.put("NZ", new Integer(148));
        COUNTRY_MAPPING.put("NE", new Integer(149));
        COUNTRY_MAPPING.put("NG", new Integer(150));
        COUNTRY_MAPPING.put("NU", new Integer(151));
        COUNTRY_MAPPING.put("NF", new Integer(152));
        COUNTRY_MAPPING.put("MP", new Integer(153));
        COUNTRY_MAPPING.put("NO", new Integer(154));
        COUNTRY_MAPPING.put("OM", new Integer(155));
        COUNTRY_MAPPING.put("PK", new Integer(156));
        COUNTRY_MAPPING.put("PW", new Integer(157));
        COUNTRY_MAPPING.put("PS", new Integer(158));
        COUNTRY_MAPPING.put("PG", new Integer(159));
        COUNTRY_MAPPING.put("PN", new Integer(160));
        COUNTRY_MAPPING.put("PL", new Integer(161));
        COUNTRY_MAPPING.put("PT", new Integer(162));
        COUNTRY_MAPPING.put("PR", new Integer(163));
        COUNTRY_MAPPING.put("QA", new Integer(164));
        COUNTRY_MAPPING.put("RE", new Integer(165));
        COUNTRY_MAPPING.put("RO", new Integer(166));
        COUNTRY_MAPPING.put("RU", new Integer(167));
        COUNTRY_MAPPING.put("RW", new Integer(168));
        COUNTRY_MAPPING.put("BL", new Integer(169));
        COUNTRY_MAPPING.put("SH", new Integer(170));
        COUNTRY_MAPPING.put("KN", new Integer(171));
        COUNTRY_MAPPING.put("LC", new Integer(172));
        COUNTRY_MAPPING.put("MF", new Integer(173));
        COUNTRY_MAPPING.put("PM", new Integer(174));
        COUNTRY_MAPPING.put("VC", new Integer(175));
        COUNTRY_MAPPING.put("WS", new Integer(176));
        COUNTRY_MAPPING.put("SM", new Integer(177));
        COUNTRY_MAPPING.put("ST", new Integer(178));
        COUNTRY_MAPPING.put("SA", new Integer(179));
        COUNTRY_MAPPING.put("SN", new Integer(180));
        COUNTRY_MAPPING.put("RS", new Integer(181));
        COUNTRY_MAPPING.put("SC", new Integer(182));
        COUNTRY_MAPPING.put("SL", new Integer(183));
        COUNTRY_MAPPING.put("SG", new Integer(184));
        COUNTRY_MAPPING.put("SX", new Integer(185));
        COUNTRY_MAPPING.put("SK", new Integer(186));
        COUNTRY_MAPPING.put("SI", new Integer(187));
        COUNTRY_MAPPING.put("SB", new Integer(188));
        COUNTRY_MAPPING.put("SO", new Integer(189));
        COUNTRY_MAPPING.put("ZA", new Integer(190));
        COUNTRY_MAPPING.put("GS", new Integer(191));
        COUNTRY_MAPPING.put("SS", new Integer(192));
        COUNTRY_MAPPING.put("ES", new Integer(193));
        COUNTRY_MAPPING.put("LK", new Integer(194));
        COUNTRY_MAPPING.put("SD", new Integer(195));
        COUNTRY_MAPPING.put("SJ", new Integer(196));
        COUNTRY_MAPPING.put("SZ", new Integer(197));
        COUNTRY_MAPPING.put("SE", new Integer(198));
        COUNTRY_MAPPING.put("CH", new Integer(199));
        COUNTRY_MAPPING.put("SY", new Integer(200));
        COUNTRY_MAPPING.put("TJ", new Integer(201));
        COUNTRY_MAPPING.put("TZ", new Integer(202));
        COUNTRY_MAPPING.put("TH", new Integer(203));
        COUNTRY_MAPPING.put("TL", new Integer(204));
        COUNTRY_MAPPING.put("TG", new Integer(205));
        COUNTRY_MAPPING.put("TK", new Integer(206));
        COUNTRY_MAPPING.put("TO", new Integer(207));
        COUNTRY_MAPPING.put("TN", new Integer(208));
        COUNTRY_MAPPING.put("TR", new Integer(209));
        COUNTRY_MAPPING.put("TM", new Integer(210));
        COUNTRY_MAPPING.put("TC", new Integer(211));
        COUNTRY_MAPPING.put("TV", new Integer(212));
        COUNTRY_MAPPING.put("UG", new Integer(213));
        COUNTRY_MAPPING.put("UA", new Integer(214));
        COUNTRY_MAPPING.put("AE", new Integer(215));
        COUNTRY_MAPPING.put("GB", new Integer(216));
        COUNTRY_MAPPING.put("US", new Integer(217));
        COUNTRY_MAPPING.put("UM", new Integer(218));
        COUNTRY_MAPPING.put("UZ", new Integer(219));
        COUNTRY_MAPPING.put("VU", new Integer(220));
        COUNTRY_MAPPING.put("VN", new Integer(221));
        COUNTRY_MAPPING.put("VG", new Integer(222));
        COUNTRY_MAPPING.put("VI", new Integer(223));
        COUNTRY_MAPPING.put("WF", new Integer(224));
        COUNTRY_MAPPING.put("EH", new Integer(225));
        COUNTRY_MAPPING.put("YE", new Integer(226));
        COUNTRY_MAPPING.put("ZM", new Integer(227));
        COUNTRY_MAPPING.put("ZW", new Integer(228));
        COUNTRY_MAPPING.put("KR", new Integer(229));
        COUNTRY_MAPPING.put("KP", new Integer(230));
        COUNTRY_MAPPING.put("BR", new Integer(231));
        COUNTRY_MAPPING.put("AR", new Integer(232));
        COUNTRY_MAPPING.put("PE", new Integer(233));
        COUNTRY_MAPPING.put("CL", new Integer(234));
        COUNTRY_MAPPING.put("BO", new Integer(235));
        COUNTRY_MAPPING.put("PY", new Integer(236));
        COUNTRY_MAPPING.put("UY", new Integer(237));
        COUNTRY_MAPPING.put("EC", new Integer(238));
        COUNTRY_MAPPING.put("CO", new Integer(239));
        COUNTRY_MAPPING.put("VE", new Integer(240));
        COUNTRY_MAPPING.put("GF", new Integer(241));
        COUNTRY_MAPPING.put("GY", new Integer(242));
        COUNTRY_MAPPING.put("SR", new Integer(243));
        COUNTRY_MAPPING.put("PA", new Integer(244));
        COUNTRY_MAPPING.put("CR", new Integer(245));
        COUNTRY_MAPPING.put("NI", new Integer(246));
        COUNTRY_MAPPING.put("HN", new Integer(247));
        COUNTRY_MAPPING.put("TT", new Integer(248));
        COUNTRY_MAPPING.put("PH", new Integer(249));
        COUNTRY_MAPPING.put("XUX", new Integer(-1));
    }

    private class EWSAreaRow
    extends EvoListRow {
        private static final int MAX_COLS = 3;
        private static final int COL_ID = 0;
        private static final int COL_STRING_ID = 1;
        private static final int COL_CURSOR_FIX = 2;

        EWSAreaRow(int n, String string) {
            super(n, 3);
            this.setInteger(0, n);
            this.setText(1, string);
            this.setInteger(2, 0);
        }

        private EWSAreaRow(EWSAreaRow eWSAreaRow) {
            super(eWSAreaRow);
        }

        public EvoListRow copy() {
            return new EWSAreaRow(this);
        }
    }

    private class TVListenerExt
    extends DefaultTVListener {
        private TVListenerExt() {
        }

        public void updateEWSInfoList(EWSInfo[] eWSInfoArray) {
            if (EWS.this.isEWSAvailable && EWS.this.isEwsEnabled) {
                EWS.this.setEWSInfoList(eWSInfoArray);
                EWS.this.playWarnTone(-1);
            }
        }

        public void updateStartUpMUConfig(StartUpConfig startUpConfig) {
            EWS.this.isEWSAvailable = startUpConfig.ewsAvail;
        }
    }

    private class SettingListener
    extends DefaultSettingListener {
        private SettingListener() {
        }

        public void updateEWS(boolean bl) {
            EWS.this.isEwsEnabled = bl;
        }
    }

    private class PopUpCloseListener
    extends DefaultButtonListener {
        private PopUpCloseListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void keyTyped(int n, int n2, int n3) {
            switch (n) {
                case 2600150: {
                    Object object = EWS.this.ewsListMutex;
                    synchronized (object) {
                        if (EWS.this.ewsTimeoutChoice.getStatus() != 0) {
                            EWS.this.log.log(10000000, "[EWS.PopUpCloseListener.keyPressed] popup closed (timeout)");
                            EWS.this.ewsTimeoutChoice.setStatus(1);
                            EWS.this.ewsTimeoutChoice.setStatus(0);
                            EWS.this.showNextEWSPopup();
                        }
                        break;
                    }
                }
                case 2600155: {
                    Object object = EWS.this.ewsListMutex;
                    synchronized (object) {
                        EWS.this.log.log(10000000, "[EWS.PopUpCloseListener.keyPressed] popup closed");
                        EWS.this.ewsTimeoutChoice.setStatus(1);
                        EWS.this.ewsTimeoutChoice.setStatus(0);
                        EWS.this.showNextEWSPopup();
                        break;
                    }
                }
                case 2600178: {
                    Object object = EWS.this.ewsListMutex;
                    synchronized (object) {
                        EWS.this.popupHandler.showDetails();
                        break;
                    }
                }
                case 2600179: {
                    Object object = EWS.this.ewsListMutex;
                    synchronized (object) {
                        EWS.this.popupHandler.showAreaList();
                        break;
                    }
                }
                default: {
                    throw new IllegalArgumentException("Unsupported modelID");
                }
            }
        }
    }
}

