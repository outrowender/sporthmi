.version 50 0 
.class public final super [435] 
.super [437] 
.implements [439] 
.implements [441] 
.implements [443] 
.field static final [444] [445] 
.field private volatile [446] [447] 
.field private final [448] [449] 
.field static synthetic [450] [451] 

.method public [453] : [454] 
    .attribute [452] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [5] 
L4:     invokespecial [69] 
L7:     aload_0 
L8:     new [84] 
L11:    dup 
L12:    invokespecial [70] 
L15:    putfield [85] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [455] : [456] 
    .attribute [452] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [71] 
L5:     aload_1 
L6:     invokevirtual [54] 
L9:     aload_0 
L10:    invokevirtual [55] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [457] : [458] 
    .attribute [452] .code stack 4 locals 1 
L0:     aload_0 
L1:     invokespecial [72] 
        .catch [7] from L4 to L27 using L30 
L4:     aload_0 
L5:     getfield [50] 
L8:     ifnull L27 
L11:    aload_0 
L12:    getfield [50] 
L15:    aload_0 
L16:    getfield [49] 
L19:    invokevirtual [56] 
L22:    invokeinterface [86] 0 
L27:    goto L45 
L30:    astore_1 
L31:    aload_0 
L32:    getfield [51] 
L35:    sipush 10000 
L38:    ldc [8] 
L40:    aload_1 
L41:    invokevirtual [57] 
L44:    pop 
L45:    return 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [459] : [460] 
    .attribute [452] .code stack 5 locals 1 
        .catch [7] from L0 to L53 using L56 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [73] 
L5:     aload_1 
L6:     aload_0 
L7:     invokespecial [74] 
L10:    invokeinterface [87] 0 
L15:    aload_1 
L16:    new [88] 
L19:    dup 
L20:    getstatic [10] 
L23:    ifnonnull L38 
L26:    ldc [11] 
L28:    invokestatic [12] 
L31:    dup 
L32:    putstatic [75] 
L35:    goto L41 
L38:    getstatic [10] 
L41:    invokevirtual [58] 
L44:    iconst_0 
L45:    invokespecial [76] 
L48:    invokeinterface [89] 0 
L53:    goto L71 
L56:    astore_2 
L57:    aload_0 
L58:    getfield [51] 
L61:    sipush 10000 
L64:    ldc [13] 
L66:    aload_2 
L67:    invokevirtual [57] 
L70:    pop 
L71:    return 
L72:    
    .end code 
.end method 

.method private [461] : [462] 
    .attribute [452] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [49] 
L4:     invokevirtual [59] 
L7:     invokeinterface [90] 0 
L12:    new [91] 
L15:    dup 
L16:    aload_0 
L17:    aload_1 
L18:    invokespecial [77] 
L21:    invokevirtual [60] 
L24:    pop 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private [463] : [464] 
    .attribute [452] .code stack 3 locals 3 
L0:     aload_0 
L1:     invokespecial [78] 
L4:     astore_2 
L5:     iconst_0 
L6:     istore_3 
L7:     iload_3 
L8:     aload_2 
L9:     arraylength 
L10:    if_icmpge L44 
        .catch [7] from L13 to L22 using L25 
L13:    aload_2 
L14:    iload_3 
L15:    aaload 
L16:    iload_1 
L17:    invokeinterface [92] 0 
L22:    goto L38 
L25:    astore 4 
L27:    aload_0 
L28:    getfield [51] 
L31:    aload 4 
L33:    ldc [15] 
L35:    invokestatic [16] 
L38:    iinc 3 1 
L41:    goto L7 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method private synchronized [465] : [466] 
    .attribute [452] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [53] 
L4:     invokeinterface [93] 0 
L9:     anewarray [17] 
L12:    astore_1 
L13:    aload_0 
L14:    getfield [53] 
L17:    aload_1 
L18:    invokeinterface [94] 0 
L23:    pop 
L24:    aload_1 
L25:    areturn 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method private [467] : [468] 
    .attribute [452] .code stack 5 locals 3 
L0:     ldc [18] 
L2:     getstatic [10] 
L5:     ifnonnull L20 
L8:     ldc [11] 
L10:    invokestatic [12] 
L13:    dup 
L14:    putstatic [75] 
L17:    goto L23 
L20:    getstatic [10] 
L23:    invokevirtual [58] 
L26:    invokestatic [19] 
L29:    astore_1 
L30:    aload_0 
L31:    getfield [61] 
L34:    aload_1 
L35:    invokeinterface [95] 0 
L40:    astore_2 
L41:    new [96] 
L44:    dup 
L45:    aload_0 
L46:    aload_0 
L47:    getfield [51] 
L50:    aload_0 
L51:    getfield [61] 
L54:    invokespecial [79] 
L57:    astore_3 
L58:    new [97] 
L61:    dup 
L62:    aload_0 
L63:    getfield [61] 
L66:    aload_2 
L67:    aload_3 
L68:    invokespecial [80] 
L71:    areturn 
L72:    
    .end code 
.end method 

.method public synchronized [469] : [470] 
    .attribute [452] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [53] 
L4:     aload_1 
L5:     invokeinterface [98] 0 
L10:    pop 
L11:    return 
L12:    
    .end code 
.end method 

.method public [471] : [472] 
    .attribute [452] .code stack 6 locals 0 
L0:     iconst_1 
L1:     anewarray [22] 
L4:     dup 
L5:     iconst_0 
L6:     new [99] 
L9:     dup 
L10:    aload_0 
L11:    invokespecial [81] 
L14:    aastore 
L15:    areturn 
L16:    
    .end code 
.end method 

.method public [473] : [474] 
    .attribute [452] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [51] 
L4:     ldc [24] 
L6:     ldc [25] 
L8:     invokevirtual [62] 
L11:    pop 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [475] : [476] 
    .attribute [452] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [51] 
L4:     ldc [24] 
L6:     ldc [25] 
L8:     invokevirtual [62] 
L11:    pop 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [477] : [478] 
    .attribute [452] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [51] 
L4:     ldc [24] 
L6:     ldc [25] 
L8:     invokevirtual [62] 
L11:    pop 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [479] : [480] 
    .attribute [452] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [51] 
L4:     ldc [24] 
L6:     ldc [26] 
L8:     invokevirtual [62] 
L11:    pop 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [481] : [482] 
    .attribute [452] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [51] 
L4:     ldc [24] 
L6:     ldc [26] 
L8:     invokevirtual [62] 
L11:    pop 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [483] : [484] 
    .attribute [452] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [51] 
L4:     ldc [24] 
L6:     ldc [26] 
L8:     invokevirtual [62] 
L11:    pop 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [485] : [486] 
    .attribute [452] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [51] 
L4:     ldc [27] 
L6:     ldc [28] 
L8:     invokevirtual [62] 
L11:    pop 
L12:    aload_0 
L13:    getfield [50] 
L16:    invokeinterface [100] 0 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [487] : [488] 
    .attribute [452] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [51] 
L4:     ldc [27] 
L6:     ldc [29] 
L8:     aload_1 
L9:     invokevirtual [63] 
L12:    pop 
L13:    aload_0 
L14:    getfield [50] 
L17:    aload_1 
L18:    invokeinterface [101] 0 
L23:    return 
L24:    
    .end code 
.end method 

.method public [489] : [490] 
    .attribute [452] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [51] 
L4:     ldc [27] 
L6:     ldc [30] 
L8:     aload_1 
L9:     invokevirtual [63] 
L12:    pop 
L13:    aload_0 
L14:    getfield [50] 
L17:    aload_1 
L18:    invokeinterface [102] 0 
L23:    return 
L24:    
    .end code 
.end method 

.method public [491] : [492] 
    .attribute [452] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [51] 
L4:     ldc [27] 
L6:     ldc [31] 
L8:     invokevirtual [62] 
L11:    pop 
L12:    aload_0 
L13:    getfield [50] 
L16:    invokeinterface [103] 0 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [493] : [494] 
    .attribute [452] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [51] 
L4:     ldc [27] 
L6:     ldc [32] 
L8:     aload_1 
L9:     aload_2 
L10:    aload_3 
L11:    aload 4 
L13:    invokevirtual [64] 
L16:    aload_0 
L17:    getfield [50] 
L20:    aload_1 
L21:    aload_2 
L22:    aload_3 
L23:    aload 4 
L25:    invokeinterface [104] 0 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [495] : [496] 
    .attribute [452] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [51] 
L4:     ldc [27] 
L6:     ldc [33] 
L8:     invokevirtual [62] 
L11:    pop 
L12:    aload_0 
L13:    getfield [50] 
L16:    invokeinterface [105] 0 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [497] : [498] 
    .attribute [452] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [51] 
L4:     ldc [27] 
L6:     ldc [34] 
L8:     aload_1 
L9:     iload_2 
L10:    i2l 
L11:    invokevirtual [65] 
L14:    pop 
L15:    aload_0 
L16:    getfield [50] 
L19:    aload_1 
L20:    iload_2 
L21:    invokeinterface [106] 0 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method static synthetic [499] : [500] 
    .attribute [452] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [83] 
L9:     dup 
L10:    invokespecial [68] 
L13:    aload_1 
L14:    invokevirtual [52] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static synthetic [501] : [502] 
    .attribute [452] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [51] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [503] : [504] 
    .attribute [452] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     dup_x1 
L3:     putfield [82] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [505] : [506] 
    .attribute [452] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [49] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [507] : [508] 
    .attribute [452] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [67] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [509] : [510] 
    .attribute [452] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [66] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [511] : [512] 
    .attribute [452] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [49] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [107] [108] 
.const [3] = Class [109] 
.const [4] = Class [110] 
.const [5] = String [111] 
.const [6] = Class [112] 
.const [7] = Class [113] 
.const [8] = String [114] 
.const [9] = Class [115] 
.const [10] = Field [116] [117] 
.const [11] = String [118] 
.const [12] = Method [119] [120] 
.const [13] = String [121] 
.const [14] = Class [122] 
.const [15] = String [123] 
.const [16] = Method [124] [125] 
.const [17] = Class [126] 
.const [18] = String [127] 
.const [19] = Method [128] [129] 
.const [20] = Class [130] 
.const [21] = Class [131] 
.const [22] = Class [132] 
.const [23] = Class [133] 
.const [24] = Int -1601830656 
.const [25] = String [134] 
.const [26] = String [135] 
.const [27] = Int 1078071040 
.const [28] = String [136] 
.const [29] = String [137] 
.const [30] = String [138] 
.const [31] = String [139] 
.const [32] = String [140] 
.const [33] = String [141] 
.const [34] = String [142] 
.const [35] = Class [143] 
.const [36] = Class [144] 
.const [37] = Class [145] 
.const [38] = Class [146] 
.const [39] = Class [147] 
.const [40] = Class [148] 
.const [41] = Class [149] 
.const [42] = Class [150] 
.const [43] = Class [151] 
.const [44] = Class [152] 
.const [45] = Class [153] 
.const [46] = Class [154] 
.const [47] = Class [155] 
.const [48] = Class [156] 
.const [49] = Field [157] [158] 
.const [50] = Field [159] [160] 
.const [51] = Field [161] [162] 
.const [52] = Method [163] [164] 
.const [53] = Field [165] [166] 
.const [54] = Method [167] [168] 
.const [55] = Method [169] [170] 
.const [56] = Method [171] [172] 
.const [57] = Method [173] [174] 
.const [58] = Method [175] [176] 
.const [59] = Method [177] [178] 
.const [60] = Method [179] [180] 
.const [61] = Field [181] [182] 
.const [62] = Method [183] [184] 
.const [63] = Method [185] [186] 
.const [64] = Method [187] [188] 
.const [65] = Method [189] [190] 
.const [66] = Method [191] [192] 
.const [67] = Method [193] [194] 
.const [68] = Method [195] [196] 
.const [69] = Method [197] [198] 
.const [70] = Method [199] [200] 
.const [71] = Method [201] [202] 
.const [72] = Method [203] [204] 
.const [73] = Method [205] [206] 
.const [74] = Method [207] [208] 
.const [75] = Field [209] [210] 
.const [76] = Method [211] [212] 
.const [77] = Method [213] [214] 
.const [78] = Method [215] [216] 
.const [79] = Method [217] [218] 
.const [80] = Method [219] [220] 
.const [81] = Method [221] [222] 
.const [82] = Field [223] [224] 
.const [83] = Class [225] 
.const [84] = Class [226] 
.const [85] = Field [227] [228] 
.const [86] = InterfaceMethod [229] [230] 
.const [87] = InterfaceMethod [231] [232] 
.const [88] = Class [233] 
.const [89] = InterfaceMethod [234] [235] 
.const [90] = InterfaceMethod [236] [237] 
.const [91] = Class [238] 
.const [92] = InterfaceMethod [239] [240] 
.const [93] = InterfaceMethod [241] [242] 
.const [94] = InterfaceMethod [243] [244] 
.const [95] = InterfaceMethod [245] [246] 
.const [96] = Class [247] 
.const [97] = Class [248] 
.const [98] = InterfaceMethod [249] [250] 
.const [99] = Class [251] 
.const [100] = InterfaceMethod [252] [253] 
.const [101] = InterfaceMethod [254] [255] 
.const [102] = InterfaceMethod [256] [257] 
.const [103] = InterfaceMethod [258] [259] 
.const [104] = InterfaceMethod [260] [261] 
.const [105] = InterfaceMethod [262] [263] 
.const [106] = InterfaceMethod [264] [265] 
.const [107] = Class [266] 
.const [108] = NameAndType [267] [268] 
.const [109] = Utf8 java/lang/ClassNotFoundException 
.const [110] = Utf8 java/lang/NoClassDefFoundError 
.const [111] = Utf8 'App.SDS.Dictation' 
.const [112] = Utf8 java/util/LinkedList 
.const [113] = Utf8 java/lang/Exception 
.const [114] = Utf8 '[DsiOnlineDictationAccess#dispose] An error occurred: ' 
.const [115] = Utf8 de/audi/app/sdsmanager/dictation/osgi/DsiDescriptor 
.const [116] = Class [269] 
.const [117] = NameAndType [270] [271] 
.const [118] = Utf8 'org.dsi.ifc.online.DSIOnlineDictation' 
.const [119] = Class [272] 
.const [120] = NameAndType [273] [274] 
.const [121] = Utf8 '[DsiOnlineDictationAccess#connect] An error occurred: ' 
.const [122] = Utf8 de/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess$1 
.const [123] = Utf8 '[DsiOnlineDictationAccess#updateDsiAccessClients]' 
.const [124] = Class [275] 
.const [125] = NameAndType [276] [277] 
.const [126] = Utf8 de/audi/app/sdsmanager/dictation/dsi/IDsiAccessClient 
.const [127] = Utf8 objectClass 
.const [128] = Class [278] 
.const [129] = NameAndType [279] [280] 
.const [130] = Utf8 de/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess$2 
.const [131] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [132] = Utf8 de/mib/swdiagnosis/sds/dictation/IDiagPlugIn 
.const [133] = Utf8 de/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess$DiagPlugIn 
.const [134] = Utf8 '[DsiOnlineDictationAccess#setNotification] Not implemented.' 
.const [135] = Utf8 '[DsiOnlineDictationAccess#clearNotification] Not implemented.' 
.const [136] = Utf8 '[DsiOnlineDictationAccess#stopDictation]' 
.const [137] = Utf8 '[DsiOnlineDictationAccess#setFallbackLanguage] languageCode = %1' 
.const [138] = Utf8 '[DsiOnlineDictationAccess#setLanguage] languageCode = %1' 
.const [139] = Utf8 '[DsiOnlineDictationAccess#activateDictation]' 
.const [140] = Utf8 '[DsiOnlineDictationAccess#startDictation] dictType = %1, serviceName = %2, costumGrammar = %3, userID = %4' 
.const [141] = Utf8 '[DsiOnlineDictationAccess#finishDictation]' 
.const [142] = Utf8 '[DsiOnlineDictationAccess#rawVoiceDataAvailable] pathToRawAudioData = %1, rawAudioDataFormat = %2' 
.const [143] = Utf8 de/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess 
.const [144] = Utf8 de/audi/app/sdsmanager/dictation/component/AbstractDictationComponent 
.const [145] = Utf8 org/dsi/ifc/online/DSIOnlineDictation 
.const [146] = Utf8 java/lang/Class 
.const [147] = Utf8 de/audi/app/sdsmanager/dictation/DictationComponentManager 
.const [148] = Utf8 de/mib/swdiagnosis/sds/dictation/DictationSwDiagnosis 
.const [149] = Utf8 de/audi/atip/log/LogChannel 
.const [150] = Utf8 de/audi/app/sdsmanager/dictation/osgi/IServiceRegistry 
.const [151] = Utf8 de/audi/app/sdsmanager/dictation/dispatcher/IDispatcherManager 
.const [152] = Utf8 de/esolutions/fw/util/commons/job/DispatcherBase 
.const [153] = Utf8 de/audi/app/sdsmanager/dictation/util/DictationUtil 
.const [154] = Utf8 java/util/Collection 
.const [155] = Utf8 de/audi/app/sdsmanager/dictation/osgi/ServiceFilterBuilder 
.const [156] = Utf8 org/osgi/framework/BundleContext 
.const [157] = Class [281] 
.const [158] = NameAndType [282] [283] 
.const [159] = Class [284] 
.const [160] = NameAndType [285] [286] 
.const [161] = Class [287] 
.const [162] = NameAndType [288] [289] 
.const [163] = Class [290] 
.const [164] = NameAndType [291] [292] 
.const [165] = Class [293] 
.const [166] = NameAndType [294] [295] 
.const [167] = Class [296] 
.const [168] = NameAndType [297] [298] 
.const [169] = Class [299] 
.const [170] = NameAndType [300] [301] 
.const [171] = Class [302] 
.const [172] = NameAndType [303] [304] 
.const [173] = Class [305] 
.const [174] = NameAndType [306] [307] 
.const [175] = Class [308] 
.const [176] = NameAndType [309] [310] 
.const [177] = Class [311] 
.const [178] = NameAndType [312] [313] 
.const [179] = Class [314] 
.const [180] = NameAndType [315] [316] 
.const [181] = Class [317] 
.const [182] = NameAndType [318] [319] 
.const [183] = Class [320] 
.const [184] = NameAndType [321] [322] 
.const [185] = Class [323] 
.const [186] = NameAndType [324] [325] 
.const [187] = Class [326] 
.const [188] = NameAndType [327] [328] 
.const [189] = Class [329] 
.const [190] = NameAndType [330] [331] 
.const [191] = Class [332] 
.const [192] = NameAndType [333] [334] 
.const [193] = Class [335] 
.const [194] = NameAndType [336] [337] 
.const [195] = Class [338] 
.const [196] = NameAndType [339] [340] 
.const [197] = Class [341] 
.const [198] = NameAndType [342] [343] 
.const [199] = Class [344] 
.const [200] = NameAndType [345] [346] 
.const [201] = Class [347] 
.const [202] = NameAndType [348] [349] 
.const [203] = Class [350] 
.const [204] = NameAndType [351] [352] 
.const [205] = Class [353] 
.const [206] = NameAndType [354] [355] 
.const [207] = Class [356] 
.const [208] = NameAndType [357] [358] 
.const [209] = Class [359] 
.const [210] = NameAndType [360] [361] 
.const [211] = Class [362] 
.const [212] = NameAndType [363] [364] 
.const [213] = Class [365] 
.const [214] = NameAndType [366] [367] 
.const [215] = Class [368] 
.const [216] = NameAndType [369] [370] 
.const [217] = Class [371] 
.const [218] = NameAndType [372] [373] 
.const [219] = Class [374] 
.const [220] = NameAndType [375] [376] 
.const [221] = Class [377] 
.const [222] = NameAndType [378] [379] 
.const [223] = Class [380] 
.const [224] = NameAndType [381] [382] 
.const [225] = Utf8 java/lang/NoClassDefFoundError 
.const [226] = Utf8 java/util/LinkedList 
.const [227] = Class [383] 
.const [228] = NameAndType [384] [385] 
.const [229] = Class [386] 
.const [230] = NameAndType [387] [388] 
.const [231] = Class [389] 
.const [232] = NameAndType [390] [391] 
.const [233] = Utf8 de/audi/app/sdsmanager/dictation/osgi/DsiDescriptor 
.const [234] = Class [392] 
.const [235] = NameAndType [393] [394] 
.const [236] = Class [395] 
.const [237] = NameAndType [396] [397] 
.const [238] = Utf8 de/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess$1 
.const [239] = Class [398] 
.const [240] = NameAndType [399] [400] 
.const [241] = Class [401] 
.const [242] = NameAndType [402] [403] 
.const [243] = Class [404] 
.const [244] = NameAndType [405] [406] 
.const [245] = Class [407] 
.const [246] = NameAndType [408] [409] 
.const [247] = Utf8 de/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess$2 
.const [248] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [249] = Class [410] 
.const [250] = NameAndType [411] [412] 
.const [251] = Utf8 de/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess$DiagPlugIn 
.const [252] = Class [413] 
.const [253] = NameAndType [414] [415] 
.const [254] = Class [416] 
.const [255] = NameAndType [417] [418] 
.const [256] = Class [419] 
.const [257] = NameAndType [420] [421] 
.const [258] = Class [422] 
.const [259] = NameAndType [423] [424] 
.const [260] = Class [425] 
.const [261] = NameAndType [426] [427] 
.const [262] = Class [428] 
.const [263] = NameAndType [429] [430] 
.const [264] = Class [431] 
.const [265] = NameAndType [432] [433] 
.const [266] = Utf8 java/lang/Class 
.const [267] = Utf8 forName 
.const [268] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [269] = Utf8 de/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess 
.const [270] = Utf8 class$org$dsi$ifc$online$DSIOnlineDictation 
.const [271] = Utf8 Ljava/lang/Class; 
.const [272] = Utf8 de/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess 
.const [273] = Utf8 class$ 
.const [274] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [275] = Utf8 de/audi/app/sdsmanager/dictation/util/DictationUtil 
.const [276] = Utf8 logException 
.const [277] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/Throwable;Ljava/lang/String;)V 
.const [278] = Utf8 de/audi/app/sdsmanager/dictation/osgi/ServiceFilterBuilder 
.const [279] = Utf8 createFilterString 
.const [280] = Utf8 (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 
.const [281] = Utf8 de/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess 
.const [282] = Utf8 dictationComponentManager 
.const [283] = Utf8 Lde/audi/app/sdsmanager/dictation/DictationComponentManager; 
.const [284] = Utf8 de/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess 
.const [285] = Utf8 dsiOnlineDictation 
.const [286] = Utf8 Lorg/dsi/ifc/online/DSIOnlineDictation; 
.const [287] = Utf8 de/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess 
.const [288] = Utf8 log 
.const [289] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [290] = Utf8 java/lang/NoClassDefFoundError 
.const [291] = Utf8 initCause 
.const [292] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [293] = Utf8 de/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess 
.const [294] = Utf8 dsiAccessClients 
.const [295] = Utf8 Ljava/util/Collection; 
.const [296] = Utf8 de/audi/app/sdsmanager/dictation/DictationComponentManager 
.const [297] = Utf8 getDictationSwDiagnosis 
.const [298] = Utf8 ()Lde/mib/swdiagnosis/sds/dictation/DictationSwDiagnosis; 
.const [299] = Utf8 de/mib/swdiagnosis/sds/dictation/DictationSwDiagnosis 
.const [300] = Utf8 registerDiagProvider 
.const [301] = Utf8 (Lde/mib/swdiagnosis/sds/dictation/IDiagProvider;)V 
.const [302] = Utf8 de/audi/app/sdsmanager/dictation/DictationComponentManager 
.const [303] = Utf8 getDsiOnlineDictationPrimaryListener 
.const [304] = Utf8 ()Lde/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationPrimaryListener; 
.const [305] = Utf8 de/audi/atip/log/LogChannel 
.const [306] = Utf8 log 
.const [307] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [308] = Utf8 java/lang/Class 
.const [309] = Utf8 getName 
.const [310] = Utf8 ()Ljava/lang/String; 
.const [311] = Utf8 de/audi/app/sdsmanager/dictation/DictationComponentManager 
.const [312] = Utf8 getDispatcherManager 
.const [313] = Utf8 ()Lde/audi/app/sdsmanager/dictation/dispatcher/IDispatcherManager; 
.const [314] = Utf8 de/esolutions/fw/util/commons/job/DispatcherBase 
.const [315] = Utf8 execute 
.const [316] = Utf8 (Ljava/lang/Object;)Lde/esolutions/fw/util/commons/job/Job; 
.const [317] = Utf8 de/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess 
.const [318] = Utf8 bundleContext 
.const [319] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [320] = Utf8 de/audi/atip/log/LogChannel 
.const [321] = Utf8 log 
.const [322] = Utf8 (ILjava/lang/String;)Z 
.const [323] = Utf8 de/audi/atip/log/LogChannel 
.const [324] = Utf8 log 
.const [325] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [326] = Utf8 de/audi/atip/log/LogChannel 
.const [327] = Utf8 log 
.const [328] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [329] = Utf8 de/audi/atip/log/LogChannel 
.const [330] = Utf8 log 
.const [331] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [332] = Utf8 de/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess 
.const [333] = Utf8 setDsiOnlineDictation 
.const [334] = Utf8 (Lorg/dsi/ifc/online/DSIOnlineDictation;)V 
.const [335] = Utf8 de/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess 
.const [336] = Utf8 updateDsiAccessClients 
.const [337] = Utf8 (Z)V 
.const [338] = Utf8 java/lang/NoClassDefFoundError 
.const [339] = Utf8 <init> 
.const [340] = Utf8 ()V 
.const [341] = Utf8 de/audi/app/sdsmanager/dictation/component/AbstractDictationComponent 
.const [342] = Utf8 <init> 
.const [343] = Utf8 (Lde/audi/app/sdsmanager/dictation/osgi/BundleEnvironment;Ljava/lang/String;)V 
.const [344] = Utf8 java/util/LinkedList 
.const [345] = Utf8 <init> 
.const [346] = Utf8 ()V 
.const [347] = Utf8 de/audi/app/sdsmanager/dictation/component/AbstractDictationComponent 
.const [348] = Utf8 init 
.const [349] = Utf8 (Lde/audi/app/sdsmanager/dictation/DictationComponentManager;)V 
.const [350] = Utf8 de/audi/app/sdsmanager/dictation/component/AbstractDictationComponent 
.const [351] = Utf8 dispose 
.const [352] = Utf8 ()V 
.const [353] = Utf8 de/audi/app/sdsmanager/dictation/component/AbstractDictationComponent 
.const [354] = Utf8 connect 
.const [355] = Utf8 (Lde/audi/app/sdsmanager/dictation/osgi/IServiceRegistry;)V 
.const [356] = Utf8 de/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess 
.const [357] = Utf8 createServiceTracker 
.const [358] = Utf8 ()Lorg/osgi/util/tracker/ServiceTracker; 
.const [359] = Utf8 de/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess 
.const [360] = Utf8 class$org$dsi$ifc$online$DSIOnlineDictation 
.const [361] = Utf8 Ljava/lang/Class; 
.const [362] = Utf8 de/audi/app/sdsmanager/dictation/osgi/DsiDescriptor 
.const [363] = Utf8 <init> 
.const [364] = Utf8 (Ljava/lang/String;I)V 
.const [365] = Utf8 de/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess$1 
.const [366] = Utf8 <init> 
.const [367] = Utf8 (Lde/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess;Lorg/dsi/ifc/online/DSIOnlineDictation;)V 
.const [368] = Utf8 de/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess 
.const [369] = Utf8 getCurrentDsiAccessClients 
.const [370] = Utf8 ()[Lde/audi/app/sdsmanager/dictation/dsi/IDsiAccessClient; 
.const [371] = Utf8 de/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess$2 
.const [372] = Utf8 <init> 
.const [373] = Utf8 (Lde/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess;Lde/audi/atip/log/LogChannel;Lorg/osgi/framework/BundleContext;)V 
.const [374] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [375] = Utf8 <init> 
.const [376] = Utf8 (Lorg/osgi/framework/BundleContext;Lorg/osgi/framework/Filter;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [377] = Utf8 de/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess$DiagPlugIn 
.const [378] = Utf8 <init> 
.const [379] = Utf8 (Lde/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess;)V 
.const [380] = Utf8 de/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess 
.const [381] = Utf8 dsiOnlineDictation 
.const [382] = Utf8 Lorg/dsi/ifc/online/DSIOnlineDictation; 
.const [383] = Utf8 de/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess 
.const [384] = Utf8 dsiAccessClients 
.const [385] = Utf8 Ljava/util/Collection; 
.const [386] = Utf8 org/dsi/ifc/online/DSIOnlineDictation 
.const [387] = Utf8 clearNotification 
.const [388] = Utf8 (Lorg/dsi/ifc/base/DSIListener;)V 
.const [389] = Utf8 de/audi/app/sdsmanager/dictation/osgi/IServiceRegistry 
.const [390] = Utf8 addTracker 
.const [391] = Utf8 (Lorg/osgi/util/tracker/ServiceTracker;)V 
.const [392] = Utf8 de/audi/app/sdsmanager/dictation/osgi/IServiceRegistry 
.const [393] = Utf8 startDsiService 
.const [394] = Utf8 (Lde/audi/app/sdsmanager/dictation/osgi/DsiDescriptor;)V 
.const [395] = Utf8 de/audi/app/sdsmanager/dictation/dispatcher/IDispatcherManager 
.const [396] = Utf8 getInternalTaskDispatcher 
.const [397] = Utf8 ()Lde/esolutions/fw/util/commons/job/DispatcherBase; 
.const [398] = Utf8 de/audi/app/sdsmanager/dictation/dsi/IDsiAccessClient 
.const [399] = Utf8 updateDsiAvailability 
.const [400] = Utf8 (Z)V 
.const [401] = Utf8 java/util/Collection 
.const [402] = Utf8 size 
.const [403] = Utf8 ()I 
.const [404] = Utf8 java/util/Collection 
.const [405] = Utf8 toArray 
.const [406] = Utf8 ([Ljava/lang/Object;)[Ljava/lang/Object; 
.const [407] = Utf8 org/osgi/framework/BundleContext 
.const [408] = Utf8 createFilter 
.const [409] = Utf8 (Ljava/lang/String;)Lorg/osgi/framework/Filter; 
.const [410] = Utf8 java/util/Collection 
.const [411] = Utf8 add 
.const [412] = Utf8 (Ljava/lang/Object;)Z 
.const [413] = Utf8 org/dsi/ifc/online/DSIOnlineDictation 
.const [414] = Utf8 stopDictation 
.const [415] = Utf8 ()V 
.const [416] = Utf8 org/dsi/ifc/online/DSIOnlineDictation 
.const [417] = Utf8 setFallbackLanguage 
.const [418] = Utf8 (Ljava/lang/String;)V 
.const [419] = Utf8 org/dsi/ifc/online/DSIOnlineDictation 
.const [420] = Utf8 setLanguage 
.const [421] = Utf8 (Ljava/lang/String;)V 
.const [422] = Utf8 org/dsi/ifc/online/DSIOnlineDictation 
.const [423] = Utf8 activateDictation 
.const [424] = Utf8 ()V 
.const [425] = Utf8 org/dsi/ifc/online/DSIOnlineDictation 
.const [426] = Utf8 startDictation 
.const [427] = Utf8 (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V 
.const [428] = Utf8 org/dsi/ifc/online/DSIOnlineDictation 
.const [429] = Utf8 finishDictation 
.const [430] = Utf8 ()V 
.const [431] = Utf8 org/dsi/ifc/online/DSIOnlineDictation 
.const [432] = Utf8 rawVoiceDataAvailable 
.const [433] = Utf8 (Ljava/lang/String;I)V 
.const [434] = Utf8 de/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess 
.const [435] = Class [434] 
.const [436] = Utf8 de/audi/app/sdsmanager/dictation/component/AbstractDictationComponent 
.const [437] = Class [436] 
.const [438] = Utf8 org/dsi/ifc/online/DSIOnlineDictation 
.const [439] = Class [438] 
.const [440] = Utf8 de/audi/app/sdsmanager/dictation/dsi/IDsiAccessProvider 
.const [441] = Class [440] 
.const [442] = Utf8 de/mib/swdiagnosis/sds/dictation/IDiagProvider 
.const [443] = Class [442] 
.const [444] = Utf8 DSI_INSTANCE_ID 
.const [445] = Utf8 I 
.const [446] = Utf8 dsiOnlineDictation 
.const [447] = Utf8 Lorg/dsi/ifc/online/DSIOnlineDictation; 
.const [448] = Utf8 dsiAccessClients 
.const [449] = Utf8 Ljava/util/Collection; 
.const [450] = Utf8 class$org$dsi$ifc$online$DSIOnlineDictation 
.const [451] = Utf8 Ljava/lang/Class; 
.const [452] = Utf8 Code 
.const [453] = Utf8 <init> 
.const [454] = Utf8 (Lde/audi/app/sdsmanager/dictation/osgi/BundleEnvironment;)V 
.const [455] = Utf8 init 
.const [456] = Utf8 (Lde/audi/app/sdsmanager/dictation/DictationComponentManager;)V 
.const [457] = Utf8 dispose 
.const [458] = Utf8 ()V 
.const [459] = Utf8 connect 
.const [460] = Utf8 (Lde/audi/app/sdsmanager/dictation/osgi/IServiceRegistry;)V 
.const [461] = Utf8 setDsiOnlineDictation 
.const [462] = Utf8 (Lorg/dsi/ifc/online/DSIOnlineDictation;)V 
.const [463] = Utf8 updateDsiAccessClients 
.const [464] = Utf8 (Z)V 
.const [465] = Utf8 getCurrentDsiAccessClients 
.const [466] = Utf8 ()[Lde/audi/app/sdsmanager/dictation/dsi/IDsiAccessClient; 
.const [467] = Utf8 createServiceTracker 
.const [468] = Utf8 ()Lorg/osgi/util/tracker/ServiceTracker; 
.const [469] = Utf8 addDsiAccessClient 
.const [470] = Utf8 (Lde/audi/app/sdsmanager/dictation/dsi/IDsiAccessClient;)V 
.const [471] = Utf8 createDiagPlugIns 
.const [472] = Utf8 ()[Lde/mib/swdiagnosis/sds/dictation/IDiagPlugIn; 
.const [473] = Utf8 setNotification 
.const [474] = Utf8 ([ILorg/dsi/ifc/base/DSIListener;)V 
.const [475] = Utf8 setNotification 
.const [476] = Utf8 (ILorg/dsi/ifc/base/DSIListener;)V 
.const [477] = Utf8 setNotification 
.const [478] = Utf8 (Lorg/dsi/ifc/base/DSIListener;)V 
.const [479] = Utf8 clearNotification 
.const [480] = Utf8 ([ILorg/dsi/ifc/base/DSIListener;)V 
.const [481] = Utf8 clearNotification 
.const [482] = Utf8 (ILorg/dsi/ifc/base/DSIListener;)V 
.const [483] = Utf8 clearNotification 
.const [484] = Utf8 (Lorg/dsi/ifc/base/DSIListener;)V 
.const [485] = Utf8 stopDictation 
.const [486] = Utf8 ()V 
.const [487] = Utf8 setFallbackLanguage 
.const [488] = Utf8 (Ljava/lang/String;)V 
.const [489] = Utf8 setLanguage 
.const [490] = Utf8 (Ljava/lang/String;)V 
.const [491] = Utf8 activateDictation 
.const [492] = Utf8 ()V 
.const [493] = Utf8 startDictation 
.const [494] = Utf8 (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V 
.const [495] = Utf8 finishDictation 
.const [496] = Utf8 ()V 
.const [497] = Utf8 rawVoiceDataAvailable 
.const [498] = Utf8 (Ljava/lang/String;I)V 
.const [499] = Utf8 class$ 
.const [500] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [501] = Utf8 access$000 
.const [502] = Utf8 (Lde/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess;)Lde/audi/atip/log/LogChannel; 
.const [503] = Utf8 access$102 
.const [504] = Utf8 (Lde/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess;Lorg/dsi/ifc/online/DSIOnlineDictation;)Lorg/dsi/ifc/online/DSIOnlineDictation; 
.const [505] = Utf8 access$200 
.const [506] = Utf8 (Lde/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess;)Lde/audi/app/sdsmanager/dictation/DictationComponentManager; 
.const [507] = Utf8 access$300 
.const [508] = Utf8 (Lde/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess;Z)V 
.const [509] = Utf8 access$400 
.const [510] = Utf8 (Lde/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess;Lorg/dsi/ifc/online/DSIOnlineDictation;)V 
.const [511] = Utf8 access$500 
.const [512] = Utf8 (Lde/audi/app/sdsmanager/dictation/dsi/DsiOnlineDictationAccess;)Lde/audi/app/sdsmanager/dictation/DictationComponentManager; 
.end class 
