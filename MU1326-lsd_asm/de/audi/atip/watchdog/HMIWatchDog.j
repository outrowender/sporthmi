.version 50 0 
.class public super [205] 
.super [207] 
.implements [209] 
.field private final [210] [211] 
.field private final [212] [213] 
.field private volatile [214] [215] 
.field private volatile [216] [217] 

.method public [219] : [220] 
    .attribute [218] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [33] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [38] 
L9:     aload_0 
L10:    aload_1 
L11:    ldc [2] 
L13:    invokeinterface [39] 0 
L18:    putfield [37] 
L21:    aload_0 
L22:    iconst_0 
L23:    putfield [40] 
L26:    aload_0 
L27:    aconst_null 
L28:    invokespecial [34] 
L31:    aload_0 
L32:    getfield [24] 
L35:    ldc [3] 
L37:    ldc [4] 
L39:    invokevirtual [27] 
L42:    pop 
L43:    return 
L44:    
    .end code 
.end method 

.method public final [221] : [222] 
    .attribute [218] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     ldc [5] 
L6:     ldc [6] 
L8:     aload_1 
L9:     invokevirtual [28] 
L12:    pop 
L13:    aload_0 
L14:    aload_1 
L15:    putfield [41] 
L18:    aload_1 
L19:    ifnull L55 
L22:    aload_1 
L23:    iconst_1 
L24:    aload_0 
L25:    invokeinterface [42] 0 
L30:    aload_0 
L31:    getfield [26] 
L34:    ifeq L55 
L37:    aload_0 
L38:    getfield [24] 
L41:    ldc [5] 
L43:    ldc [7] 
L45:    invokevirtual [27] 
L48:    pop 
L49:    aload_1 
L50:    invokeinterface [43] 0 
L55:    return 
L56:    
    .end code 
.end method 

.method public final [223] : [224] 
    .attribute [218] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [24] 
L4:     ldc [5] 
L6:     ldc [8] 
L8:     invokevirtual [27] 
L11:    pop 
L12:    aload_0 
L13:    iconst_1 
L14:    putfield [40] 
L17:    aload_0 
L18:    invokespecial [32] 
L21:    astore_1 
L22:    aload_1 
L23:    ifnull L44 
L26:    aload_0 
L27:    getfield [24] 
L30:    ldc [5] 
L32:    ldc [7] 
L34:    invokevirtual [27] 
L37:    pop 
L38:    aload_1 
L39:    invokeinterface [43] 0 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method private interface [225] : [226] 
    .attribute [218] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [29] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [227] : [228] 
    .attribute [218] .code stack 6 locals 1 
L0:     aload_0 
L1:     getfield [24] 
L4:     ldc [5] 
L6:     ldc [9] 
L8:     invokevirtual [27] 
L11:    pop 
L12:    aload_0 
L13:    getfield [25] 
L16:    invokeinterface [44] 0 
L21:    aconst_null 
L22:    ldc [10] 
L24:    iconst_0 
L25:    iconst_0 
L26:    iconst_4 
L27:    invokeinterface [45] 0 
L32:    aload_0 
L33:    invokespecial [32] 
L36:    astore_1 
L37:    aload_1 
L38:    ifnull L60 
L41:    aload_0 
L42:    getfield [24] 
L45:    ldc [5] 
L47:    ldc [11] 
L49:    invokevirtual [27] 
L52:    pop 
L53:    aload_1 
L54:    iconst_0 
L55:    invokeinterface [46] 0 
L60:    return 
L61:    nop 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [229] : [230] 
    .attribute [218] .code stack 8 locals 0 
L0:     iload_2 
L1:     iconst_1 
L2:     if_icmpne L63 
L5:     aload_0 
L6:     getfield [24] 
L9:     ldc [5] 
L11:    ldc [12] 
L13:    iload_1 
L14:    i2l 
L15:    invokevirtual [30] 
L18:    pop 
L19:    aload_0 
L20:    getfield [26] 
L23:    ifeq L63 
L26:    aload_0 
L27:    getfield [25] 
L30:    invokeinterface [47] 0 
L35:    invokeinterface [48] 0 
L40:    new [49] 
L43:    dup 
L44:    iconst_1 
L45:    new [50] 
L48:    dup 
L49:    aload_0 
L50:    iload_1 
L51:    invokespecial [35] 
L54:    invokespecial [36] 
L57:    invokeinterface [51] 0 
L62:    pop 
L63:    return 
L64:    
    .end code 
.end method 

.method public [231] : [232] 
    .attribute [218] .code stack 8 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     ldc [3] 
L6:     ldc [15] 
L8:     aload_2 
L9:     iload_1 
L10:    i2l 
L11:    iload_3 
L12:    i2l 
L13:    invokevirtual [31] 
L16:    pop 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static synthetic [233] : [234] 
    .attribute [218] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [32] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [235] : [236] 
    .attribute [218] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [52] 
.const [3] = Int 1078071040 
.const [4] = String [53] 
.const [5] = Int -2137614336 
.const [6] = String [54] 
.const [7] = String [55] 
.const [8] = String [56] 
.const [9] = String [57] 
.const [10] = String [58] 
.const [11] = String [59] 
.const [12] = String [60] 
.const [13] = Class [61] 
.const [14] = Class [62] 
.const [15] = String [63] 
.const [16] = Class [64] 
.const [17] = Class [65] 
.const [18] = Class [66] 
.const [19] = Class [67] 
.const [20] = Class [68] 
.const [21] = Class [69] 
.const [22] = Class [70] 
.const [23] = Class [71] 
.const [24] = Field [72] [73] 
.const [25] = Field [74] [75] 
.const [26] = Field [76] [77] 
.const [27] = Method [78] [79] 
.const [28] = Method [80] [81] 
.const [29] = Field [82] [83] 
.const [30] = Method [84] [85] 
.const [31] = Method [86] [87] 
.const [32] = Method [88] [89] 
.const [33] = Method [90] [91] 
.const [34] = Method [92] [93] 
.const [35] = Method [94] [95] 
.const [36] = Method [96] [97] 
.const [37] = Field [98] [99] 
.const [38] = Field [100] [101] 
.const [39] = InterfaceMethod [102] [103] 
.const [40] = Field [104] [105] 
.const [41] = Field [106] [107] 
.const [42] = InterfaceMethod [108] [109] 
.const [43] = InterfaceMethod [110] [111] 
.const [44] = InterfaceMethod [112] [113] 
.const [45] = InterfaceMethod [114] [115] 
.const [46] = InterfaceMethod [116] [117] 
.const [47] = InterfaceMethod [118] [119] 
.const [48] = InterfaceMethod [120] [121] 
.const [49] = Class [122] 
.const [50] = Class [123] 
.const [51] = InterfaceMethod [124] [125] 
.const [52] = Utf8 'Fw.WatchDog' 
.const [53] = Utf8 'HMIWatchDog created' 
.const [54] = Utf8 'HMIWatchDog.setDSI(%1)' 
.const [55] = Utf8 '-> HMIWatchDog.hmiReady()' 
.const [56] = Utf8 '-> HMIWatchDog.setReady()' 
.const [57] = Utf8 '<- HMIWatchDog.triggerErrorLogDump()' 
.const [58] = Utf8 'Triggered by HMIWatchDog' 
.const [59] = Utf8 '-> HMIWatchDog.errorlogDumpResult(OK)' 
.const [60] = Utf8 '<- HMIWatchDog.updateQueryHeartbeat(%1)' 
.const [61] = Utf8 de/audi/atip/hmi/event/RunnableEvent 
.const [62] = Utf8 de/audi/atip/watchdog/HMIWatchDog$HeartBeat 
.const [63] = Utf8 '<- HMIWatchDog.asyncException(%2,%1,%3' 
.const [64] = Utf8 de/audi/atip/watchdog/HMIWatchDog 
.const [65] = Utf8 java/lang/Object 
.const [66] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [67] = Utf8 de/audi/atip/log/LogChannel 
.const [68] = Utf8 org/dsi/ifc/system/DSIHMIWatchDog 
.const [69] = Utf8 de/audi/atip/error/IErrorManager 
.const [70] = Utf8 de/audi/atip/hmi/HMIService 
.const [71] = Utf8 de/audi/atip/hmi/event/EventDispatcher 
.const [72] = Class [126] 
.const [73] = NameAndType [127] [128] 
.const [74] = Class [129] 
.const [75] = NameAndType [130] [131] 
.const [76] = Class [132] 
.const [77] = NameAndType [133] [134] 
.const [78] = Class [135] 
.const [79] = NameAndType [136] [137] 
.const [80] = Class [138] 
.const [81] = NameAndType [139] [140] 
.const [82] = Class [141] 
.const [83] = NameAndType [142] [143] 
.const [84] = Class [144] 
.const [85] = NameAndType [145] [146] 
.const [86] = Class [147] 
.const [87] = NameAndType [148] [149] 
.const [88] = Class [150] 
.const [89] = NameAndType [151] [152] 
.const [90] = Class [153] 
.const [91] = NameAndType [154] [155] 
.const [92] = Class [156] 
.const [93] = NameAndType [157] [158] 
.const [94] = Class [159] 
.const [95] = NameAndType [160] [161] 
.const [96] = Class [162] 
.const [97] = NameAndType [163] [164] 
.const [98] = Class [165] 
.const [99] = NameAndType [166] [167] 
.const [100] = Class [168] 
.const [101] = NameAndType [169] [170] 
.const [102] = Class [171] 
.const [103] = NameAndType [172] [173] 
.const [104] = Class [174] 
.const [105] = NameAndType [175] [176] 
.const [106] = Class [177] 
.const [107] = NameAndType [178] [179] 
.const [108] = Class [180] 
.const [109] = NameAndType [181] [182] 
.const [110] = Class [183] 
.const [111] = NameAndType [184] [185] 
.const [112] = Class [186] 
.const [113] = NameAndType [187] [188] 
.const [114] = Class [189] 
.const [115] = NameAndType [190] [191] 
.const [116] = Class [192] 
.const [117] = NameAndType [193] [194] 
.const [118] = Class [195] 
.const [119] = NameAndType [196] [197] 
.const [120] = Class [198] 
.const [121] = NameAndType [199] [200] 
.const [122] = Utf8 de/audi/atip/hmi/event/RunnableEvent 
.const [123] = Utf8 de/audi/atip/watchdog/HMIWatchDog$HeartBeat 
.const [124] = Class [201] 
.const [125] = NameAndType [202] [203] 
.const [126] = Utf8 de/audi/atip/watchdog/HMIWatchDog 
.const [127] = Utf8 log 
.const [128] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [129] = Utf8 de/audi/atip/watchdog/HMIWatchDog 
.const [130] = Utf8 framework 
.const [131] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [132] = Utf8 de/audi/atip/watchdog/HMIWatchDog 
.const [133] = Utf8 ready 
.const [134] = Utf8 Z 
.const [135] = Utf8 de/audi/atip/log/LogChannel 
.const [136] = Utf8 log 
.const [137] = Utf8 (ILjava/lang/String;)Z 
.const [138] = Utf8 de/audi/atip/log/LogChannel 
.const [139] = Utf8 log 
.const [140] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [141] = Utf8 de/audi/atip/watchdog/HMIWatchDog 
.const [142] = Utf8 dsi 
.const [143] = Utf8 Lorg/dsi/ifc/system/DSIHMIWatchDog; 
.const [144] = Utf8 de/audi/atip/log/LogChannel 
.const [145] = Utf8 log 
.const [146] = Utf8 (ILjava/lang/String;J)Z 
.const [147] = Utf8 de/audi/atip/log/LogChannel 
.const [148] = Utf8 log 
.const [149] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [150] = Utf8 de/audi/atip/watchdog/HMIWatchDog 
.const [151] = Utf8 getDSI 
.const [152] = Utf8 ()Lorg/dsi/ifc/system/DSIHMIWatchDog; 
.const [153] = Utf8 java/lang/Object 
.const [154] = Utf8 <init> 
.const [155] = Utf8 ()V 
.const [156] = Utf8 de/audi/atip/watchdog/HMIWatchDog 
.const [157] = Utf8 setDSI 
.const [158] = Utf8 (Lorg/dsi/ifc/system/DSIHMIWatchDog;)V 
.const [159] = Utf8 de/audi/atip/watchdog/HMIWatchDog$HeartBeat 
.const [160] = Utf8 <init> 
.const [161] = Utf8 (Lde/audi/atip/watchdog/HMIWatchDog;I)V 
.const [162] = Utf8 de/audi/atip/hmi/event/RunnableEvent 
.const [163] = Utf8 <init> 
.const [164] = Utf8 (ZLjava/lang/Runnable;)V 
.const [165] = Utf8 de/audi/atip/watchdog/HMIWatchDog 
.const [166] = Utf8 log 
.const [167] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [168] = Utf8 de/audi/atip/watchdog/HMIWatchDog 
.const [169] = Utf8 framework 
.const [170] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [171] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [172] = Utf8 getLogChannel 
.const [173] = Utf8 (Ljava/lang/String;)Lde/audi/atip/log/LogChannel; 
.const [174] = Utf8 de/audi/atip/watchdog/HMIWatchDog 
.const [175] = Utf8 ready 
.const [176] = Utf8 Z 
.const [177] = Utf8 de/audi/atip/watchdog/HMIWatchDog 
.const [178] = Utf8 dsi 
.const [179] = Utf8 Lorg/dsi/ifc/system/DSIHMIWatchDog; 
.const [180] = Utf8 org/dsi/ifc/system/DSIHMIWatchDog 
.const [181] = Utf8 setNotification 
.const [182] = Utf8 (ILorg/dsi/ifc/base/DSIListener;)V 
.const [183] = Utf8 org/dsi/ifc/system/DSIHMIWatchDog 
.const [184] = Utf8 hmiReady 
.const [185] = Utf8 ()V 
.const [186] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [187] = Utf8 getErrorMgr 
.const [188] = Utf8 ()Lde/audi/atip/error/IErrorManager; 
.const [189] = Utf8 de/audi/atip/error/IErrorManager 
.const [190] = Utf8 handleError 
.const [191] = Utf8 (Ljava/lang/Throwable;Ljava/lang/String;III)V 
.const [192] = Utf8 org/dsi/ifc/system/DSIHMIWatchDog 
.const [193] = Utf8 errorlogDumpResult 
.const [194] = Utf8 (I)V 
.const [195] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [196] = Utf8 getHMIService 
.const [197] = Utf8 ()Lde/audi/atip/hmi/HMIService; 
.const [198] = Utf8 de/audi/atip/hmi/HMIService 
.const [199] = Utf8 getEventDispatcher 
.const [200] = Utf8 ()Lde/audi/atip/hmi/event/EventDispatcher; 
.const [201] = Utf8 de/audi/atip/hmi/event/EventDispatcher 
.const [202] = Utf8 postEvent 
.const [203] = Utf8 (Lde/audi/atip/hmi/event/ATIPEvent;)Lde/esolutions/fw/util/commons/job/Job; 
.const [204] = Utf8 de/audi/atip/watchdog/HMIWatchDog 
.const [205] = Class [204] 
.const [206] = Utf8 java/lang/Object 
.const [207] = Class [206] 
.const [208] = Utf8 org/dsi/ifc/system/DSIHMIWatchDogListener 
.const [209] = Class [208] 
.const [210] = Utf8 log 
.const [211] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [212] = Utf8 framework 
.const [213] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [214] = Utf8 dsi 
.const [215] = Utf8 Lorg/dsi/ifc/system/DSIHMIWatchDog; 
.const [216] = Utf8 ready 
.const [217] = Utf8 Z 
.const [218] = Utf8 Code 
.const [219] = Utf8 <init> 
.const [220] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [221] = Utf8 setDSI 
.const [222] = Utf8 (Lorg/dsi/ifc/system/DSIHMIWatchDog;)V 
.const [223] = Utf8 setReady 
.const [224] = Utf8 ()V 
.const [225] = Utf8 getDSI 
.const [226] = Utf8 ()Lorg/dsi/ifc/system/DSIHMIWatchDog; 
.const [227] = Utf8 triggerErrorLogDump 
.const [228] = Utf8 ()V 
.const [229] = Utf8 updateQueryHeartbeat 
.const [230] = Utf8 (II)V 
.const [231] = Utf8 asyncException 
.const [232] = Utf8 (ILjava/lang/String;I)V 
.const [233] = Utf8 access$000 
.const [234] = Utf8 (Lde/audi/atip/watchdog/HMIWatchDog;)Lorg/dsi/ifc/system/DSIHMIWatchDog; 
.const [235] = Utf8 access$100 
.const [236] = Utf8 (Lde/audi/atip/watchdog/HMIWatchDog;)Lde/audi/atip/log/LogChannel; 
.end class 
