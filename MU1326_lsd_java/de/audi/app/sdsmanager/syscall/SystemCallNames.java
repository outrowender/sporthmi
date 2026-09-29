/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.syscall;

import de.audi.app.sdsmanager.syscall.ISystemCallNames;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SystemCallNames
implements ISystemCallNames {
    private static final Map SYSCALL_NAMES = SystemCallNames.createMap();

    private static void addAddressbookSystemcalls(Map map) {
        map.put(new Integer(0x70110100), "ADB_DESTBYIDOPEN");
        map.put(new Integer(0x71110100), "ADB_DESTSET");
        map.put(new Integer(1913716992), "ADB_LISTHIDE");
        map.put(new Integer(1930494208), "ADB_LISTSHOW");
        map.put(new Integer(1947271424), "ADB_ENTRYSELECTIONINTERRUPT");
        map.put(new Integer(1964048640), "ADB_NAVIGATETORECOG");
        map.put(new Integer(1980825856), "ADB_NUMBERBYIDOPEN");
        map.put(new Integer(2031157504), "ADB_MAILBYIDOPEN");
        map.put(new Integer(0x77110100), "ADB_CATEGORYSET");
        map.put(new Integer(2014380288), "ADB_TOPRECENTRYOPEN");
        map.put(new Integer(2047934720), "ADB_LISTLINEDATAGET");
        map.put(new Integer(2064711936), "ADB_DETAILLISTLINETYPEGET");
        map.put(new Integer(2081489152), "ADB_CONTACTLISTLINESET");
    }

    private static void addMessagingSystemcalls(Map map) {
        map.put(new Integer(-131858176), "MSG_READOUTFINISH");
        map.put(new Integer(-115080960), "MSG_ADDRECIPIENT");
        map.put(new Integer(-81526528), "MSG_READOUTRECOG");
        map.put(new Integer(-64749312), "MSG_READOUTDETAIL");
        map.put(new Integer(-47972096), "MSG_SEND");
        map.put(new Integer(-31194880), "MSG_LISTSHOW");
        map.put(new Integer(-14417664), "MSG_LISTHIDE");
        map.put(new Integer(2425088), "MSG_LISTLINESET");
        map.put(new Integer(19202304), "MSG_TYPESET");
    }

    private static void addDictationSystemcalls(Map map) {
        map.put(new Integer(-936640256), "MSG_DICTATE_ACTIVATE");
        map.put(new Integer(-919863040), "MSG_DICTATE_CLEARRECIPIENT");
        map.put(new Integer(-903085824), "MSG_DICTATE_DELETE");
        map.put(new Integer(-886308608), "MSG_DICTATE_PREPARE");
        map.put(new Integer(-869531392), "MSG_DICTATE_FINISH");
        map.put(new Integer(-802422528), "MSG_DICTATE_START");
        map.put(new Integer(-785645312), "MSG_DICTATE_STOP");
        map.put(new Integer(-768868096), "MSG_DICTATE_VOICEDATAAVAILABLE");
        map.put(new Integer(-752090880), "MSG_DICTATE_DIALOGSTEPSET");
    }

    private static void addMediaSystemcalls(Map map) {
        map.put(new Integer(20000), "MEDIA_DEVICESET");
        map.put(new Integer(20003), "MEDIA_G2PONESHOTFILTERPICKLIST");
        map.put(new Integer(20002), "MEDIA_G2PONESHOTISAMBIGUOUS");
        map.put(new Integer(20004), "MEDIA_G2PONESHOTSTOREDATA");
        map.put(new Integer(20015), "MEDIA_FOLDERUP");
        map.put(new Integer(20016), "MEDIA_LISTHIDE");
        map.put(new Integer(20017), "MEDIA_FOLDERSELECT");
        map.put(new Integer(20019), "MEDIA_LISTSHOW");
        map.put(new Integer(20020), "MEDIA_MEDIUMSELECT");
        map.put(new Integer(20021), "MEDIA_PLAYMODESET");
        map.put(new Integer(20023), "MEDIA_LISTLINESET");
        map.put(new Integer(20024), "MEDIA_DYNDEVICESET");
        map.put(new Integer(20025), "MEDIA_LISTLINEDATAGET");
        map.put(new Integer(20026), "MEDIA_USBDEVICESET");
        map.put(new Integer(20001), "MEDIA_PLAYITEM");
        map.put(new Integer(20027), "MEDIA_PLAYALLTRACKS");
    }

    private static void addNaviSystemcalls(Map map) {
        map.put(new Integer(1100742656), "NAVI_BLOCKROUTEVALUESET");
        map.put(new Integer(1134297088), "NAVI_DESTINATIONDELETE");
        map.put(new Integer(1151074304), "NAVI_DESTINATIONAVAILABLE");
        map.put(new Integer(1167851520), "NAVI_DESTINATIONGET");
        map.put(new Integer(1201405952), "NAVI_DESTINATIONSET");
        map.put(new Integer(1234960384), "NAVI_DESTINATIONSTATUS");
        map.put(new Integer(1251737600), "NAVI_SPELLINGMODE");
        map.put(new Integer(1268514816), "NAVI_SPELLINGMODECORRECTION");
        map.put(new Integer(1302069248), "NAVI_CHECKROUTEGUIDANCE");
        map.put(new Integer(1335623680), "NAVI_ALTERNATIVEROUTENUMBERSET");
        map.put(new Integer(1385955328), "NAVI_HOUSENUMBERCHECK");
        map.put(new Integer(1402732544), "NAVI_HOUSENUMBERSET");
        map.put(new Integer(-1768161280), "NAVI_HOUSENUMBERRESOLVE");
        map.put(new Integer(1419509760), "NAVI_HOMESET");
        map.put(new Integer(1436286976), "NAVI_GETINFO");
        map.put(new Integer(1469841408), "NAVI_INPUTMODECHECK");
        map.put(new Integer(1486618624), "NAVI_INPUTSTARTED");
        map.put(new Integer(1520173056), "NAVI_LISTHIDE");
        map.put(new Integer(1553727488), "NAVI_LISTSHOW");
        map.put(new Integer(1570504704), "NAVI_MAPOPTIONSSET");
        map.put(new Integer(1604059136), "NAVI_MAPZOOM");
        map.put(new Integer(1620836352), "NAVI_POICORRECTIONHANDLING");
        map.put(new Integer(1637613568), "NAVI_POISEARCHAREASET");
        map.put(new Integer(1654390784), "NAVI_POISHORTCUTSET");
        map.put(new Integer(1755054080), "NAVI_POIVALUESET");
        map.put(new Integer(1788608512), "NAVI_POIONLINERECOG");
        map.put(new Integer(1805385728), "NAVI_POIONLINESEARCHAREASET");
        map.put(new Integer(1822162944), "NAVI_POIONLINESEARCHDIDYOUMEAN");
        map.put(new Integer(1838940160), "NAVI_POIONLINESEARCHCANCEL");
        map.put(new Integer(1855717376), "NAVI_POIONLINESEARCHINIT");
        map.put(new Integer(1906049024), "NAVI_POIONLINEUNIQUERESULT");
        map.put(new Integer(1922826240), "NAVI_SPEEDLIMITGET");
        map.put(new Integer(1939603456), "NAVI_POSTCODECHECK");
        map.put(new Integer(1956380672), "NAVI_ROUTEOPTIONSSET");
        map.put(new Integer(1973157888), "NAVI_LISTLINEDATAGET");
        map.put(new Integer(1989935104), "NAVI_TMCREADOUT");
        map.put(new Integer(2006712320), "NAVI_VOICEGUIDANCESET");
        map.put(new Integer(2023489536), "NAVI_VDEONESHOTISAMBIGUOUS");
        map.put(new Integer(2040266752), "NAVI_VDEONESHOTFILTERPICKLIST");
        map.put(new Integer(2073821184), "NAVI_HOMESAVE");
        map.put(new Integer(2090598400), "NAVI_GUIDANCE_START");
        map.put(new Integer(2107375616), "NAVI_GUIDANCE_STOP");
        map.put(new Integer(2124152832), "NAVI_ADD_DESTINATION");
        map.put(new Integer(2140930048), "NAVI_ALTERNATIVEROUTECALC");
        map.put(new Integer(-2137260032), "NAVI_POIONLINESHOWLIST");
        map.put(new Integer(-2120482816), "NAVI_FAVORITEDESTINATIONSET");
        map.put(new Integer(-2103705600), "NAVI_LASTDESTINATIONSET");
        map.put(new Integer(-2086928384), "NAVI_SUITYPEGET");
        map.put(new Integer(-2070151168), "NAVI_POIONESHOTAMBIGUOUS");
        map.put(new Integer(-2053373952), "NAVI_POIONESHOTFILTERPICKLIST");
        map.put(new Integer(-2036596736), "NAVI_MYAUDICONTACTSELECT");
        map.put(new Integer(-2019819520), "NAVI_INTELLIDESTSET");
        map.put(new Integer(-2003042304), "NAVI_POIPROMPTLABELSET");
        map.put(new Integer(-1986265088), "NAVI_ONESHOTSTOREDATA");
        map.put(new Integer(-1969487872), "NAVI_CHECKBETTERROUTE");
        map.put(new Integer(-1952710656), "NAVI_SETBYPASSROUTE");
        map.put(new Integer(-1935933440), "NAVI_DETAILSPHONECALL");
        map.put(new Integer(-1919156224), "NAVI_POIONLINESELECTDESTINATION");
        map.put(new Integer(-1902379008), "NAVI_BLOCKROUTESETNLU");
        map.put(new Integer(-1885601792), "NAVI_FILLPROMPTLABELS");
        map.put(new Integer(-1868824576), "NAVI_ENTERGEOCOORDINATES");
        map.put(new Integer(-1852047360), "NAVI_DESTINATIONAVAILABLE_ASIA");
        map.put(new Integer(-1835270144), "NAVI_OPERATORCALL");
        map.put(new Integer(-1818492928), "NAVI_ENTERRUBBERBAND");
        map.put(new Integer(-1801715712), "NAVI_POIHISTORYENTRYUNIQUE");
        map.put(new Integer(-1784938496), "NAVI_ROUTEINFOSSET");
        map.put(new Integer(-1751384064), "NAVI_ONESHOTAMBIGUOUS");
        map.put(new Integer(-1734606848), "NAVI_ONESHOTFILTERPICKLIST");
        map.put(new Integer(-1717829632), "NAVI_MAPCODEADD");
        map.put(new Integer(-1701052416), "NAVI_MAPCODEDELETE");
        map.put(new Integer(-1684275200), "NAVI_MAPCODEGET");
        map.put(new Integer(-1667497984), "NAVI_MAPCODERESOLVE");
        map.put(new Integer(-1432616960), "NAVI_MAPCODENAVIGABLE");
        map.put(new Integer(-1415839744), "NAVI_FURTHERINPUTPOSSIBLE");
        map.put(new Integer(-1650720768), "NAVI_PHONENUMBERADD");
        map.put(new Integer(-1633943552), "NAVI_PHONENUMBERDELETE");
        map.put(new Integer(-1617166336), "NAVI_PHONENUMBERGET");
        map.put(new Integer(-1600389120), "NAVI_ENTERPOINAMESEARCH");
        map.put(new Integer(-1583611904), "NAVI_TRUFFLESSEARCHDESTINATION");
        map.put(new Integer(-1566834688), "NAVI_TRUFFLESCORRECTION");
        map.put(new Integer(-1449394176), "NAVI_TRUFFLESEND");
        map.put(new Integer(-1550057472), "NAVI_ADDRESSINPUTCORRECTION");
        map.put(new Integer(-1533280256), "NAVI_STARTTPEGPOI");
        map.put(new Integer(-1516503040), "NAVI_GETTPEGPOIRESULTSBYCATEGORY");
        map.put(new Integer(-1499725824), "NAVI_SELECTTPEGPOIRESULT");
        map.put(new Integer(-1482948608), "NAVI_TRIGGERTPEGPOIRETURN");
        map.put(new Integer(-1466171392), "NAVI_SYNCHRONIZECOUNTRY");
        map.put(new Integer(-1399062528), "NAVI_TRUFFLESCANCELSEARCH");
        map.put(new Integer(-1382285312), "NAVI_SIMPLEMAPAREASET");
        map.put(new Integer(-1365508096), "NAVI_ADDRESSINPUTCURSORCORRECTION");
        map.put(new Integer(-1348730880), "NAVI_ADDRESSINPUTCURSORSET");
        map.put(new Integer(-1331953664), "NAVI_SIMPLEMAPFREESELECTIONINIT");
        map.put(new Integer(-1315176448), "NAVI_HOUSENUMBERJPKRVALIDATE");
        map.put(new Integer(-1298399232), "NAVI_TRUFFLESSEARCHPREVIOUSDEST");
    }

    private static void addPhoneSystemcalls(Map map) {
        map.put(new Integer(30000), "PHONE_CALLMAILBOX");
        map.put(new Integer(30002), "PHONE_NUMBERADD");
        map.put(new Integer(30003), "PHONE_NUMBERDELETE");
        map.put(new Integer(30004), "PHONE_NUMBERDIAL");
        map.put(new Integer(30005), "PHONE_NUMBERGET");
        map.put(new Integer(30006), "PHONE_REDIALNUMBER");
        map.put(new Integer(30007), "PHONE_LISTENTRYSELECT");
        map.put(new Integer(30008), "PHONE_LINEDATAGETTYPE");
        map.put(new Integer(30009), "PHONE_LISTSHOW");
        map.put(new Integer(30010), "PHONE_LISTHIDE");
        map.put(new Integer(30011), "PHONE_LISTLINEDATAGET");
        map.put(new Integer(30012), "PHONE_SIRIACTIVATE");
    }

    private static void addSystemSystemcalls(Map map) {
        map.put(new Integer(1000), "SYSTEM_ABORTSTART");
        map.put(new Integer(1001), "SYSTEM_ANYCALLED");
        map.put(new Integer(1002), "SYSTEM_COMMANDLISTHIDE");
        map.put(new Integer(1003), "SYSTEM_COMMANDLISTSHOW");
        map.put(new Integer(1007), "SYSTEM_COMMANDMODESET");
        map.put(new Integer(1010), "SYSTEM_CORRECTIONCASE");
        map.put(new Integer(1012), "SYSTEM_COUNTERINCREMENT");
        map.put(new Integer(1013), "SYSTEM_COUNTERRESET");
        map.put(new Integer(1014), "SYSTEM_COUNTERSECONDINCREMENT");
        map.put(new Integer(1015), "SYSTEM_COUNTERSECONDRESET");
        map.put(new Integer(1058), "SYSTEM_CURSORHIGHLIGHTLINE");
        map.put(new Integer(1017), "SYSTEM_INCREMENTMODEL");
        map.put(new Integer(1019), "SYSTEM_JUMPPOINTACTION");
        map.put(new Integer(1020), "SYSTEM_LISTCLEAR");
        map.put(new Integer(1021), "SYSTEM_LISTHIDE");
        map.put(new Integer(1022), "SYSTEM_LISTLINEDATAGET");
        map.put(new Integer(1023), "SYSTEM_LISTLINEGET");
        map.put(new Integer(1024), "SYSTEM_LISTLINESET");
        map.put(new Integer(1025), "SYSTEM_LISTPAGESET");
        map.put(new Integer(1027), "SYSTEM_LISTSHOW");
        map.put(new Integer(1029), "SYSTEM_CONNECTIONACCEPT");
        map.put(new Integer(1032), "SYSTEM_PLAYBEEP");
        map.put(new Integer(1033), "SYSTEM_POSTTRAININGOK");
        map.put(new Integer(1034), "SYSTEM_PROMPTTYPESET");
        map.put(new Integer(1035), "SYSTEM_GRAPHEMICGROUPRECOGNIZED");
        map.put(new Integer(1038), "SYSTEM_SESSIONEND");
        map.put(new Integer(1039), "SYSTEM_SESSIONSTART");
        map.put(new Integer(1040), "SYSTEM_SESSIONWAIT");
        map.put(new Integer(1049), "SYSTEM_SESSIONWAIT");
        map.put(new Integer(1030), "SYSTEM_SLOTSETNLU");
        map.put(new Integer(1041), "SYSTEM_STARTRECOGNITION");
        map.put(new Integer(1042), "SYSTEM_STOPRECOGNITION");
        map.put(new Integer(1043), "SYSTEM_STATESET");
        map.put(new Integer(1044), "SYSTEM_TTSABORT");
        map.put(new Integer(1045), "SYSTEM_CONTEXTSET");
        map.put(new Integer(1046), "SYSTEM_WAITSTATE");
        map.put(new Integer(1047), "SYSTEM_DISAMBIGUATIONLISTSHOW");
        map.put(new Integer(1048), "SYSTEM_DISAMBIGUATIONLISTHIDE");
        map.put(new Integer(1051), "SYSTEM_SETMODEL");
        map.put(new Integer(1052), "SYSTEM_STOREPICKLISTINHISTORY");
        map.put(new Integer(1053), "SYSTEM_PARAMSETNLU");
        map.put(new Integer(1055), "SYSTEM_ABSOLUTELINENUMBERSET");
        map.put(new Integer(1056), "SYSTEM_LISTLINEREQUEST");
        map.put(new Integer(1057), "SYSTEM_DISCLAIMERACCEPT");
        map.put(new Integer(1059), "SYSTEM_REMOVEFROMPICKLISTHISTORY");
        map.put(new Integer(1060), "SYSTEM_TRUFFLESET");
        map.put(new Integer(1061), "SYSTEM_WAITFORSCREENCONNECTED");
        map.put(new Integer(1062), "SYSTEM_WAITFORSCREENFADEDOUT");
        map.put(new Integer(1063), "SYSTEM_DIALOGCONTEXSET");
        map.put(new Integer(1064), "SYSTEM_ONESHOTINITIALIZE");
    }

    private static void addTunerSystemcalls(Map map) {
        map.put(new Integer(10000), "TUNER_CATEGORYSET");
        map.put(new Integer(10001), "TUNER_FREQUENCYSET");
        map.put(new Integer(10002), "TUNER_STATIONSET");
        map.put(new Integer(10003), "TUNER_GENRESET");
        map.put(new Integer(10004), "TUNER_TRAFFICPROGRAMSET");
        map.put(new Integer(10005), "TUNER_WAVEBANDSET");
        map.put(new Integer(10006), "TUNER_LISTHIDE");
        map.put(new Integer(10007), "TUNER_LISTSHOW");
        map.put(new Integer(10008), "TUNER_LISTLINESET");
        map.put(new Integer(10009), "TUNER_LISTLINEDATAGET");
    }

    private static void addRemoteHMISystemcalls(Map map) {
        map.put(new Integer(1887568640), "REMOTEHMI_RESETNAVLOCATIONINPUT");
        map.put(new Integer(1904345856), "REMOTEHMI_UPDATEHELP");
        map.put(new Integer(1921123072), "REMOTEHMI_SETRESULT");
        map.put(new Integer(1937900288), "REMOTEHMI_SETGLOBALRESULT");
        map.put(new Integer(1954677504), "REMOTEHMI_SETHELPRESULT");
        map.put(new Integer(1971454720), "REMOTEHMI_REQUESTDIALOGCONTINUATION");
        map.put(new Integer(1988231936), "REMOTEHMI_DIALOGSTEPFINISHED");
        map.put(new Integer(2005009152), "REMOTEHMI_HELPOPENED");
        map.put(new Integer(2021786368), "REMOTEHMI_SETNAVDESTFORMRESULT");
        map.put(new Integer(2038563584), "REMOTEHMI_SETGLOBALENTER");
        map.put(new Integer(2055340800), "REMOTEHMI_SETRECOGNIZEDLINENUMBER");
    }

    private static Map createMap() {
        HashMap hashMap = new HashMap();
        SystemCallNames.addAddressbookSystemcalls(hashMap);
        SystemCallNames.addMessagingSystemcalls(hashMap);
        SystemCallNames.addDictationSystemcalls(hashMap);
        SystemCallNames.addMediaSystemcalls(hashMap);
        SystemCallNames.addNaviSystemcalls(hashMap);
        SystemCallNames.addPhoneSystemcalls(hashMap);
        SystemCallNames.addSystemSystemcalls(hashMap);
        SystemCallNames.addTunerSystemcalls(hashMap);
        SystemCallNames.addRemoteHMISystemcalls(hashMap);
        return Collections.unmodifiableMap(hashMap);
    }

    @Override
    public String getName(int n) {
        String string = (String)SYSCALL_NAMES.get(new Integer(n));
        return string == null ? new StringBuffer().append("SYSTEMCALL_").append(n).toString() : string;
    }
}

