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
        map.put(new Integer(70000), "ADB_DESTBYIDOPEN");
        map.put(new Integer(70001), "ADB_DESTSET");
        map.put(new Integer(70002), "ADB_LISTHIDE");
        map.put(new Integer(70003), "ADB_LISTSHOW");
        map.put(new Integer(70004), "ADB_ENTRYSELECTIONINTERRUPT");
        map.put(new Integer(70005), "ADB_NAVIGATETORECOG");
        map.put(new Integer(70006), "ADB_NUMBERBYIDOPEN");
        map.put(new Integer(70009), "ADB_MAILBYIDOPEN");
        map.put(new Integer(70007), "ADB_CATEGORYSET");
        map.put(new Integer(70008), "ADB_TOPRECENTRYOPEN");
        map.put(new Integer(70010), "ADB_LISTLINEDATAGET");
        map.put(new Integer(70011), "ADB_DETAILLISTLINETYPEGET");
        map.put(new Integer(70012), "ADB_CONTACTLISTLINESET");
    }

    private static void addMessagingSystemcalls(Map map) {
        map.put(new Integer(75000), "MSG_READOUTFINISH");
        map.put(new Integer(75001), "MSG_ADDRECIPIENT");
        map.put(new Integer(75003), "MSG_READOUTRECOG");
        map.put(new Integer(75004), "MSG_READOUTDETAIL");
        map.put(new Integer(75005), "MSG_SEND");
        map.put(new Integer(75006), "MSG_LISTSHOW");
        map.put(new Integer(75007), "MSG_LISTHIDE");
        map.put(new Integer(75008), "MSG_LISTLINESET");
        map.put(new Integer(75009), "MSG_TYPESET");
    }

    private static void addDictationSystemcalls(Map map) {
        map.put(new Integer(77000), "MSG_DICTATE_ACTIVATE");
        map.put(new Integer(77001), "MSG_DICTATE_CLEARRECIPIENT");
        map.put(new Integer(77002), "MSG_DICTATE_DELETE");
        map.put(new Integer(77003), "MSG_DICTATE_PREPARE");
        map.put(new Integer(77004), "MSG_DICTATE_FINISH");
        map.put(new Integer(77008), "MSG_DICTATE_START");
        map.put(new Integer(77009), "MSG_DICTATE_STOP");
        map.put(new Integer(77010), "MSG_DICTATE_VOICEDATAAVAILABLE");
        map.put(new Integer(77011), "MSG_DICTATE_DIALOGSTEPSET");
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
        map.put(new Integer(40001), "NAVI_BLOCKROUTEVALUESET");
        map.put(new Integer(40003), "NAVI_DESTINATIONDELETE");
        map.put(new Integer(40004), "NAVI_DESTINATIONAVAILABLE");
        map.put(new Integer(40005), "NAVI_DESTINATIONGET");
        map.put(new Integer(40007), "NAVI_DESTINATIONSET");
        map.put(new Integer(40009), "NAVI_DESTINATIONSTATUS");
        map.put(new Integer(40010), "NAVI_SPELLINGMODE");
        map.put(new Integer(40011), "NAVI_SPELLINGMODECORRECTION");
        map.put(new Integer(40013), "NAVI_CHECKROUTEGUIDANCE");
        map.put(new Integer(40015), "NAVI_ALTERNATIVEROUTENUMBERSET");
        map.put(new Integer(40018), "NAVI_HOUSENUMBERCHECK");
        map.put(new Integer(40019), "NAVI_HOUSENUMBERSET");
        map.put(new Integer(40086), "NAVI_HOUSENUMBERRESOLVE");
        map.put(new Integer(40020), "NAVI_HOMESET");
        map.put(new Integer(40021), "NAVI_GETINFO");
        map.put(new Integer(40023), "NAVI_INPUTMODECHECK");
        map.put(new Integer(40024), "NAVI_INPUTSTARTED");
        map.put(new Integer(40026), "NAVI_LISTHIDE");
        map.put(new Integer(40028), "NAVI_LISTSHOW");
        map.put(new Integer(40029), "NAVI_MAPOPTIONSSET");
        map.put(new Integer(40031), "NAVI_MAPZOOM");
        map.put(new Integer(40032), "NAVI_POICORRECTIONHANDLING");
        map.put(new Integer(40033), "NAVI_POISEARCHAREASET");
        map.put(new Integer(40034), "NAVI_POISHORTCUTSET");
        map.put(new Integer(40040), "NAVI_POIVALUESET");
        map.put(new Integer(40042), "NAVI_POIONLINERECOG");
        map.put(new Integer(40043), "NAVI_POIONLINESEARCHAREASET");
        map.put(new Integer(40044), "NAVI_POIONLINESEARCHDIDYOUMEAN");
        map.put(new Integer(40045), "NAVI_POIONLINESEARCHCANCEL");
        map.put(new Integer(40046), "NAVI_POIONLINESEARCHINIT");
        map.put(new Integer(40049), "NAVI_POIONLINEUNIQUERESULT");
        map.put(new Integer(40050), "NAVI_SPEEDLIMITGET");
        map.put(new Integer(40051), "NAVI_POSTCODECHECK");
        map.put(new Integer(40052), "NAVI_ROUTEOPTIONSSET");
        map.put(new Integer(40053), "NAVI_LISTLINEDATAGET");
        map.put(new Integer(40054), "NAVI_TMCREADOUT");
        map.put(new Integer(40055), "NAVI_VOICEGUIDANCESET");
        map.put(new Integer(40056), "NAVI_VDEONESHOTISAMBIGUOUS");
        map.put(new Integer(40057), "NAVI_VDEONESHOTFILTERPICKLIST");
        map.put(new Integer(40059), "NAVI_HOMESAVE");
        map.put(new Integer(40060), "NAVI_GUIDANCE_START");
        map.put(new Integer(40061), "NAVI_GUIDANCE_STOP");
        map.put(new Integer(40062), "NAVI_ADD_DESTINATION");
        map.put(new Integer(40063), "NAVI_ALTERNATIVEROUTECALC");
        map.put(new Integer(40064), "NAVI_POIONLINESHOWLIST");
        map.put(new Integer(40065), "NAVI_FAVORITEDESTINATIONSET");
        map.put(new Integer(40066), "NAVI_LASTDESTINATIONSET");
        map.put(new Integer(40067), "NAVI_SUITYPEGET");
        map.put(new Integer(40068), "NAVI_POIONESHOTAMBIGUOUS");
        map.put(new Integer(40069), "NAVI_POIONESHOTFILTERPICKLIST");
        map.put(new Integer(40070), "NAVI_MYAUDICONTACTSELECT");
        map.put(new Integer(40071), "NAVI_INTELLIDESTSET");
        map.put(new Integer(40072), "NAVI_POIPROMPTLABELSET");
        map.put(new Integer(40073), "NAVI_ONESHOTSTOREDATA");
        map.put(new Integer(40074), "NAVI_CHECKBETTERROUTE");
        map.put(new Integer(40075), "NAVI_SETBYPASSROUTE");
        map.put(new Integer(40076), "NAVI_DETAILSPHONECALL");
        map.put(new Integer(40077), "NAVI_POIONLINESELECTDESTINATION");
        map.put(new Integer(40078), "NAVI_BLOCKROUTESETNLU");
        map.put(new Integer(40079), "NAVI_FILLPROMPTLABELS");
        map.put(new Integer(40080), "NAVI_ENTERGEOCOORDINATES");
        map.put(new Integer(40081), "NAVI_DESTINATIONAVAILABLE_ASIA");
        map.put(new Integer(40082), "NAVI_OPERATORCALL");
        map.put(new Integer(40083), "NAVI_ENTERRUBBERBAND");
        map.put(new Integer(40084), "NAVI_POIHISTORYENTRYUNIQUE");
        map.put(new Integer(40085), "NAVI_ROUTEINFOSSET");
        map.put(new Integer(40087), "NAVI_ONESHOTAMBIGUOUS");
        map.put(new Integer(40088), "NAVI_ONESHOTFILTERPICKLIST");
        map.put(new Integer(40089), "NAVI_MAPCODEADD");
        map.put(new Integer(40090), "NAVI_MAPCODEDELETE");
        map.put(new Integer(40091), "NAVI_MAPCODEGET");
        map.put(new Integer(40092), "NAVI_MAPCODERESOLVE");
        map.put(new Integer(40106), "NAVI_MAPCODENAVIGABLE");
        map.put(new Integer(40107), "NAVI_FURTHERINPUTPOSSIBLE");
        map.put(new Integer(40093), "NAVI_PHONENUMBERADD");
        map.put(new Integer(40094), "NAVI_PHONENUMBERDELETE");
        map.put(new Integer(40095), "NAVI_PHONENUMBERGET");
        map.put(new Integer(40096), "NAVI_ENTERPOINAMESEARCH");
        map.put(new Integer(40097), "NAVI_TRUFFLESSEARCHDESTINATION");
        map.put(new Integer(40098), "NAVI_TRUFFLESCORRECTION");
        map.put(new Integer(40105), "NAVI_TRUFFLESEND");
        map.put(new Integer(40099), "NAVI_ADDRESSINPUTCORRECTION");
        map.put(new Integer(40100), "NAVI_STARTTPEGPOI");
        map.put(new Integer(40101), "NAVI_GETTPEGPOIRESULTSBYCATEGORY");
        map.put(new Integer(40102), "NAVI_SELECTTPEGPOIRESULT");
        map.put(new Integer(40103), "NAVI_TRIGGERTPEGPOIRETURN");
        map.put(new Integer(40104), "NAVI_SYNCHRONIZECOUNTRY");
        map.put(new Integer(40108), "NAVI_TRUFFLESCANCELSEARCH");
        map.put(new Integer(40109), "NAVI_SIMPLEMAPAREASET");
        map.put(new Integer(40110), "NAVI_ADDRESSINPUTCURSORCORRECTION");
        map.put(new Integer(40111), "NAVI_ADDRESSINPUTCURSORSET");
        map.put(new Integer(40112), "NAVI_SIMPLEMAPFREESELECTIONINIT");
        map.put(new Integer(40113), "NAVI_HOUSENUMBERJPKRVALIDATE");
        map.put(new Integer(40114), "NAVI_TRUFFLESSEARCHPREVIOUSDEST");
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
        map.put(new Integer(230000), "REMOTEHMI_RESETNAVLOCATIONINPUT");
        map.put(new Integer(230001), "REMOTEHMI_UPDATEHELP");
        map.put(new Integer(230002), "REMOTEHMI_SETRESULT");
        map.put(new Integer(230003), "REMOTEHMI_SETGLOBALRESULT");
        map.put(new Integer(230004), "REMOTEHMI_SETHELPRESULT");
        map.put(new Integer(230005), "REMOTEHMI_REQUESTDIALOGCONTINUATION");
        map.put(new Integer(230006), "REMOTEHMI_DIALOGSTEPFINISHED");
        map.put(new Integer(230007), "REMOTEHMI_HELPOPENED");
        map.put(new Integer(230008), "REMOTEHMI_SETNAVDESTFORMRESULT");
        map.put(new Integer(230009), "REMOTEHMI_SETGLOBALENTER");
        map.put(new Integer(230010), "REMOTEHMI_SETRECOGNIZEDLINENUMBER");
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

    public String getName(int n) {
        String string = (String)SYSCALL_NAMES.get(new Integer(n));
        return string == null ? "SYSTEMCALL_" + n : string;
    }
}

