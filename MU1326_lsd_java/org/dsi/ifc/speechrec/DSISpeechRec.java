/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.speechrec;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.speechrec.DictionaryEntry;
import org.dsi.ifc.speechrec.Grammar;
import org.dsi.ifc.speechrec.GrammarInfo;

public interface DSISpeechRec
extends DSIBase {
    public static final String VERSION = "2.11.25";
    public static final int ATTR_LANGUAGE = 1;
    public static final int ATTR_AVAILABLELANGUAGES = 2;
    public static final int ATTR_ABORTED = 3;
    public static final int ATTR_FAILURE = 4;
    public static final int ATTR_RECOGNIZERSTATE = 5;
    public static final int ATTR_ABSOLUTECONFIDENCETHRESHOLD = 6;
    public static final int ATTR_MAXCOMMANDNBESTLISTSIZE = 8;
    public static final int ATTR_MAXSLOTNBESTLISTSIZE = 9;
    public static final int ATTR_CONFIDENCEREJECTTHRESHOLD = 10;
    public static final int ATTR_UTTERANCESTARTTIMEOUT = 11;
    public static final int ATTR_RECOGNITIONTIMEOUT = 12;
    public static final int ATTR_UNAMBIGUOUSRESULTTHRESHOLD = 13;
    public static final int ATTR_UNAMBIGUOUSRESULTRANGE = 14;
    public static final int ATTR_FIRSTLEVELSIZE = 15;
    public static final int ATTR_SDSAVAILABILITY = 16;
    public static final int ATTR_TEMPORARYG2PLANGUAGECHANGEACTIVE = 18;
    public static final int ATTR_AVAILABLEPROFILES = 19;
    public static final int ATTR_GRAMMARSTATUS = 20;
    public static final int ATTR_GRAMMARSTATE = 21;
    public static final int ATTR_NBESTLIST = 22;
    public static final int ATTR_ASRPARAMETERCONFIGURATION = 23;
    public static final int ATTR_VDEMEDIUMSTATE = 24;
    public static final int ATTR_AVAILABLESLMLANGUAGES = 25;
    public static final int ATTR_ONLINECAPABILITIES = 26;
    public static final int RT_ABORT = 1000;
    public static final int RT_DELETEVOICETAG = 1001;
    public static final int RT_INIT = 1002;
    public static final int RT_INITVOICETAG = 1003;
    public static final int RT_LOADGRAMMAR = 1004;
    public static final int RT_PRELOADGRAMMAR = 1005;
    public static final int RT_RECORDVOICETAG = 1006;
    public static final int RT_SETLANGUAGE = 1007;
    public static final int RT_SHUTDOWN = 1008;
    public static final int RT_UNLOADGRAMMAR = 1009;
    public static final int RT_WAITFORRESULTS = 1010;
    public static final int RT_UNPRELOADGRAMMAR = 1011;
    public static final int RT_STARTRECOGNITION = 1012;
    public static final int RT_SETMAXCOMMANDNBESTLISTSIZE = 1015;
    public static final int RT_SETMAXSLOTNBESTLISTSIZE = 1016;
    public static final int RT_SETRECOGNITIONTIMEOUT = 1018;
    public static final int RT_SETUNAMBIGUOUSRESULTTHRESHOLD = 1020;
    public static final int RT_SETUNAMBIGUOUSRESULTRANGE = 1021;
    public static final int RT_SETFIRSTLEVELSIZE = 1022;
    public static final int RT_STARTPOSTTRAINING = 1023;
    public static final int RT_STOPPOSTTRAINING = 1024;
    public static final int RT_REQUESTSDSAVAILABILITY = 1025;
    public static final int RT_SETSPELLINGMODE = 1027;
    public static final int RT_DELETELASTSPELLINGBLOCK = 1028;
    public static final int RT_STARTDIALOGUE = 1029;
    public static final int RT_STOPDIALOGUE = 1030;
    public static final int RT_REQUESTGRAPHEMICGROUPASNBESTLIST = 1031;
    public static final int RT_GETVERSION = 1032;
    public static final int RT_REQUESTVDECAPABILITIES = 1033;
    public static final int RT_DELETEPROFILE = 1034;
    public static final int RT_LOADPROFILE = 1035;
    public static final int RT_UNLOADPROFILE = 1036;
    public static final int RT_REQUESTRESTOREFACTORYSETTINGS = 1037;
    public static final int RT_SETDICTIONARY = 1038;
    public static final int RT_REQUESTCHECKDBPARTITION = 1039;
    public static final int RT_ENABLECONTINUOUSUPDATE = 1040;
    public static final int RT_SETASRPARAMETERCONFIGURATION = 1041;
    public static final int RT_DELETELASTFLEXVDEPART = 1042;
    public static final int RT_CLEARFLEXVDEHISTORY = 1043;
    public static final int RP_RESPONSEABORT = 2000;
    public static final int RP_RESPONSEDELETEVOICETAG = 2001;
    public static final int RP_RESPONSEINIT = 2002;
    public static final int RP_RESPONSEINITVOICETAG = 2003;
    public static final int RP_RESPONSELOADGRAMMAR = 2004;
    public static final int RP_RESPONSEPRELOADGRAMMAR = 2005;
    public static final int RP_RESPONSERECORDVOICETAG = 2006;
    public static final int RP_RESPONSESETLANGUAGE = 2007;
    public static final int RP_RESPONSESHUTDOWN = 2008;
    public static final int RP_RESPONSESTARTRECOGNITION = 2009;
    public static final int RP_RESPONSEUNLOADGRAMMAR = 2010;
    public static final int RP_RESPONSEWAITFORRESULTS = 2011;
    public static final int RP_RESPONSEUNPRELOADGRAMMAR = 2012;
    public static final int RP_RESPONSESETMAXCOMMANDNBESTLISTSIZE = 2015;
    public static final int RP_RESPONSESETMAXSLOTNBESTLISTSIZE = 2016;
    public static final int RP_RESPONSESETCONFIDENCEREJECTTHRESHOLD = 2017;
    public static final int RP_RESPONSESETRECOGNITIONTIMEOUT = 2018;
    public static final int RP_RESPONSESETUTTERANCESTARTTIMEOUT = 2019;
    public static final int RP_RESPONSESETUNAMBIGUOUSRESULTTHRESHOLD = 2020;
    public static final int RP_RESPONSESETUNAMBIGUOUSRESULTRANGE = 2021;
    public static final int RP_RESPONSESETFIRSTLEVELSIZE = 2022;
    public static final int RP_RESPONSESTARTPOSTTRAINING = 2023;
    public static final int RP_RESPONSESTOPPOSTTRAINING = 2024;
    public static final int RP_RESPONSEREQUESTSDSAVAILABILITY = 2025;
    public static final int RP_RESPONSESETSPELLINGMODE = 2027;
    public static final int RP_RESPONSEDELETELASTSPELLINGBLOCK = 2028;
    public static final int RP_RESPONSESTARTDIALOGUE = 2029;
    public static final int RP_RESPONSESTOPDIALOGUE = 2030;
    public static final int RP_RESPONSEREQUESTGRAPHEMICGROUPASNBESTLIST = 2031;
    public static final int RP_RESPONSEGETVERSION = 2032;
    public static final int RP_RESPONSEREQUESTVDECAPABILITIES = 2033;
    public static final int RP_RESPONSEDELETEPROFILE = 2034;
    public static final int RP_RESPONSELOADPROFILE = 2035;
    public static final int RP_RESPONSEUNLOADPROFILE = 2036;
    public static final int RP_RESPONSERESTOREFACTORYSETTINGS = 2037;
    public static final int RP_RESPONSESETDICTIONARY = 2038;
    public static final int RP_RESPONSECHECKDBPARTITION = 2039;
    public static final int RP_RESPONSEENABLECONTINUOUSUPDATE = 2040;
    public static final int RP_RESPONSESETASRPARAMETERCONFIGURATION = 2041;
    public static final int RP_RESPONSEDELETELASTFLEXVDEPART = 2042;
    public static final int RP_RESPONSECLEARFLEXVDEHISTORY = 2043;
    public static final int CHECKRESULT_OK = 0;
    public static final int CHECKRESULT_NOK = 1;
    public static final int CHECKRESULT_UNKNOWN = 2;
    public static final int CHECKRESULT_CUSTOMER_DL = 3;
    public static final int RESPONSE_ABORTED = 200;
    public static final int RESPONSE_ERROR = 300;
    public static final int RESPONSE_ERROR_AUDIO_FAILURE = 31;
    public static final int RESPONSE_ERROR_BUSY = 15;
    public static final int RESPONSE_ERROR_EMPTY_GRAMMAR = 26;
    public static final int RESPONSE_ERROR_ILLEGAL_GRAMMAR = 25;
    public static final int RESPONSE_ERROR_ILLEGAL_GRAMMAR_TYPE = 24;
    public static final int RESPONSE_ERROR_ILLEGAL_LANGUAGE = 18;
    public static final int RESPONSE_ERROR_ILLEGAL_VOICETAG = 38;
    public static final int RESPONSE_ERROR_NO_GRAMMAR = 27;
    public static final int RESPONSE_ERROR_NO_INIT = 12;
    public static final int RESPONSE_ERROR_NO_LANGUAGE = 19;
    public static final int RESPONSE_ERROR_NO_VOICETAGS = 37;
    public static final int RESPONSE_ERROR_NO_OPERATION_PENDING = 13;
    public static final int RESPONSE_ERROR_NO_POSTTRAINING = 33;
    public static final int RESPONSE_ERROR_NO_POSTTRAINING_STARTED = 34;
    public static final int RESPONSE_ERROR_NO_RECOGNITION_STARTED = 30;
    public static final int RESPONSE_ERROR_OOM = 11;
    public static final int RESPONSE_ERROR_OPERATION_NOT_ABORTABLE = 14;
    public static final int RESPONSE_ERROR_SR_ENGINE_FAILURE = 32;
    public static final int RESPONSE_OK = 0;
    public static final int RESPONSE_WARNING_RECOMMEND_REPEAT = 104;
    public static final int RESPONSE_TIMEOUT = 101;
    public static final int RESPONSE_UTTERANCE_TOO_LOUD = 102;
    public static final int RESPONSE_UTTERANCE_TOO_WEAK = 103;
    public static final int RESPONSE_SIGNAL_TO_NOISE_RATIO_TOO_LOW = 105;
    public static final int RESPONSE_NO_RECOGNITION_RESULT = 106;
    public static final int RESPONSE_CONFIDENCE_TOO_LOW = 107;
    public static final int RESPONSE_VOICETAG_TOO_LONG = 108;
    public static final int RESPONSE_VOICETAG_TOO_SHORT = 109;
    public static final int RESPONSE_VOICETAG_SIMILAR_VT_FOUND = 110;
    public static final int RESPONSE_ERROR_GRAMMARS_PARTLY_NOT_LOADED = 111;
    public static final int RESPONSE_ERROR_GRAMMARS_PARTLY_NOT_UNLOADED = 112;
    public static final int RESPONSE_ERROR_ILLEGAL_SKIN_ID = 113;
    public static final int RESPONSE_ERROR_NO_LAST_NBESTLIST = 114;
    public static final int RESPONSE_ERROR_NOT_IN_SPELLING_MODE = 115;
    public static final int RESPONSE_ERROR_NO_NAV_AVAILABLE = 116;
    public static final int RESPONSE_ERROR_PROFILE_ID_INVALID = 117;
    public static final int RESPONSE_ALL_RECOGNITIONRESULTS_FILTERED_OUT = 118;
    public static final int RESPONSE_ERROR_NOT_IN_FLEX_VDE_MODE = 119;
    public static final int RESPONSE_FLEX_VDE_RESULT_UNCHANGED = 120;
    public static final int DICTIONARYTYPE_COMMON = 1;
    public static final int DICTIONARYTYPE_ONLINE = 2;
    public static final int GRAMMARTYPE_INVALID = 0;
    public static final int GRAMMARTYPE_SRGS_GRAMMAR_STRING = 1;
    public static final int GRAMMARTYPE_LIST_WORD_LIST = 2;
    public static final int GRAMMARTYPE_LIST_ID_REF_LIST = 3;
    public static final int GRAMMARTYPE_PRECOMPILED_ID = 4;
    public static final int GRAMMARTYPE_LIST_SPELLING = 5;
    public static final int GRAMMARTYPE_LAST_NBESTLIST = 6;
    public static final int GRAMMARTYPE_LAST_NBESTLIST_WITH_GRAPHEMIC_GROUP = 7;
    public static final int GRAMMARTYPE_LIST_COMBINED_WORD_ID_LIST = 8;
    public static final int GRAMMARTYPE_LIST_COMBINED_WORD_PHONEME_LIST = 9;
    public static final int GRAMMARID_UNDEFINED = -1;
    public static final int LAST_NBESTLIST = 0;
    public static final int SKINID_1 = 1;
    public static final int SKINID_2 = 2;
    public static final int SKINID_3 = 3;
    public static final int SDSSTATE_IDLE = 1;
    public static final int SDSSTATE_VOICETAG_RECORDING = 2;
    public static final int SDSSTATE_RECOGNIZING = 3;
    public static final int SDSSTATE_RECOGNIZING_FINISHED = 4;
    public static final int SDSSTATE_UTTERANCE_STARTED = 5;
    public static final int SDSSTATE_UTTERANCE_FINISHED = 6;
    public static final int SDSSTATE_ABORTED = 7;
    public static final int SDSSTATE_TIMEOUT = 8;
    public static final int COMMANDHIERARCHY_NONE = 0;
    public static final int COMMANDHIERARCHY_GLOBAL = 1;
    public static final int COMMANDHIERARCHY_GLOBAL_MEDIA = 2;
    public static final int COMMANDHIERARCHY_ACTIVE_CONTEXT = 3;
    public static final int COMMANDHIERARCHY_NLU = 4;
    public static final int COMMANDHIERARCHY_UNIVERSAL = 5;
    public static final int COMMANDHIERARCHY_SWYS = 6;
    public static final int COMMANDHIERARCHY_DIALOGUE = 7;
    public static final int OFFLINERECOGNITIONMODE_DISABLED = 1;
    public static final int OFFLINERECOGNITIONMODE_RECORD = 2;
    public static final int OFFLINERECOGNITIONMODE_PLAYBACK = 3;
    public static final int SDSAVAILABILITY_NOT_BUILT_IN = 0;
    public static final int SDSAVAILABILITY_INACTIVE = 1;
    public static final int SDSAVAILABILITY_ACTIVE = 2;
    public static final int STARTTONE_NONE = 1;
    public static final int STARTTONE_RECOGNIZER_READY_TONE = 2;
    public static final int STARTTONE_RECOGNIZER_DIALOGUE_START_TONE = 3;
    public static final int ENDTONE_NONE = 1;
    public static final int ENDTONE_UTTERANCE_FINISHED = 2;
    public static final int SPELLINGMODE_INACTIVE = 1;
    public static final int SPELLINGMODE_ACTIVE = 2;
    public static final int SPELLINGMODE_PAUSED = 3;
    public static final int GRAMMARCONTENT_ADDRESS_BOOK = 1;
    public static final int GRAMMARCONTENT_MEDIA = 2;
    public static final int GRAMMARCONTENT_ADDRESS_BOOK_WITH_TEL_NO = 3;
    public static final int GRAMMARCONTENT_ADDRESS_BOOK_WITH_LOCATION = 4;
    public static final int GRAMMARCONTENT_ADDRESS_BOOK_WITH_LOCATION_PUBLIC = 5;
    public static final int GRAMMARCONTENT_ADDRESS_BOOK_WITH_LOCATION_PRIVATE = 6;
    public static final int GRAMMARCONTENT_ADDRESS_BOOK_WITH_LOCATION_FAVORITES = 7;
    public static final int GRAMMARCONTENT_ADDRESS_BOOK_WITH_MAIL = 8;
    public static final int GRAMMARCONTENT_CALLSTACKS_ALL = 9;
    public static final int GRAMMARCONTENT_CALLSTACKS_INCOMING = 10;
    public static final int GRAMMARCONTENT_CALLSTACKS_OUTGOING = 11;
    public static final int GRAMMARCONTENT_CALLSTACKS_MISSED = 12;
    public static final int RECTMT_BARGEIN_START = 1;
    public static final int RECTMT_BARGEIN_FINISH = 2;
    public static final int RECTMT_REGULAR_NORMAL = 3;
    public static final int RECTMT_REGULAR_LONG = 4;
    public static final int RECTMT_REGULAR_PROLONG = 5;
    public static final int GRAMMARSTATUS_AVAILABLE = 1;
    public static final int GRAMMARSTATUS_COMPILING = 2;
    public static final int GRAMMARSTATUS_UNAVAILABLE = 3;
    public static final int GRAMMARSTATUS_PARTIAL_COMPILATION_FAILURE = 4;
    public static final int GRAMMARSTATUS_COMPILATION_FAILURE = 5;
    public static final int ASRPARAMETER_GARBAGE = 0;
    public static final int ASRPARAMETER_AUDIOSOURCE_TIMEOUT = 1;
    public static final int ASRPARAMETER_TIMEOUT_LSILENCE = 2;
    public static final int ASRPARAMETER_TIMEOUT_SPEECH = 3;
    public static final int ASRPARAMETER_TSILENCE = 4;
    public static final int ASRPARAMETER_FIRSTPASS_DISTAPPROX = 5;
    public static final int ASRPARAMETER_EXTRA_EVENT_ENABLE = 6;
    public static final int ASRPARAMETER_CTX_TSILENCE_FX = 7;
    public static final int ASRPARAMETER_CTX_TSILENCE = 8;
    public static final int ASRPARAMETER_CTX_MAXNBEST = 9;
    public static final int ASRPARAMETER_CTX_MAXNBEST_SECONDPASS = 10;
    public static final int ASRPARAMETER_CTX_ACCURACY = 11;
    public static final int ASRPARAMETER_CTX_INIT_BEAMWIDTH = 12;
    public static final int ASRPARAMETER_CTX_WORDPENALTY = 13;
    public static final int VDEMEDIUMSTATE_UNAVAILABLE = 0;
    public static final int VDEMEDIUMSTATE_AVAILABLE = 1;
    public static final int VDEMEDIUMSTATE_ERROR = 2;

    public void abort();

    public void deleteProfile(int var1);

    public void deleteVoiceTag(int var1);

    public void enableContinuousUpdate(boolean var1);

    public void getVersion();

    public void init();

    public void initVoiceTag(int var1);

    public void loadGrammar(Grammar[] var1);

    public void loadProfile(int var1);

    public void preloadGrammar(Grammar[] var1);

    public void recordVoiceTag();

    public void setLanguage(String var1, int var2);

    public void shutdown();

    public void startRecognition(int var1, int var2, int var3);

    public void unloadGrammar(GrammarInfo[] var1);

    public void unloadProfile(int var1);

    public void unpreloadGrammar(GrammarInfo[] var1);

    public void waitForResults();

    public void setMaxCommandNBestListSize(int var1);

    public void setMaxSlotNBestListSize(int var1);

    public void setRecognitionTimeout(int var1);

    public void setUnambiguousResultThreshold(int var1);

    public void setUnambiguousResultRange(int var1);

    public void setFirstLevelSize(int var1);

    public void startPostTraining(int var1);

    public void stopPostTraining();

    public void requestSDSAvailability();

    public void setSpellingMode(int var1);

    public void deleteLastSpellingBlock();

    public void startDialogue();

    public void stopDialogue();

    public void requestCheckDbPartition();

    public void requestGraphemicGroupAsNBestList(int var1);

    public void requestVDECapabilities(String var1);

    public void requestRestoreFactorySettings();

    public void setDictionary(int var1, String var2, String var3, DictionaryEntry[] var4);

    public void setASRParameterConfiguration(int[] var1, int[] var2, int[] var3);

    public void deleteLastFlexVDEPart();

    public void clearFlexVDEHistory();
}

