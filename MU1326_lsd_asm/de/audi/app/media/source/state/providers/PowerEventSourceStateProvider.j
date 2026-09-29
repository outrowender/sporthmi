.version 50 0 
.class public super [280] 
.super [282] 
.implements [284] 
.field private static final [285] [286] 
.field private final [287] [288] 
.field private final [289] [290] 
.field private final [291] [292] 
.field private final [293] [294] 
.field private final [295] [296] 
.field private [297] [298] 
.field private [299] [300] 
.field static synthetic [301] [302] 

.method public [304] : [305] 
    .attribute [303] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [48] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [56] 
L9:     aload_0 
L10:    aload_3 
L11:    putfield [54] 
L14:    aload_0 
L15:    aload_2 
L16:    putfield [57] 
L19:    aload_0 
L20:    aload 5 
L22:    putfield [58] 
L25:    aload_0 
L26:    aload 4 
L28:    putfield [59] 
L31:    aload_0 
L32:    aload_1 
L33:    putfield [60] 
L36:    return 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [306] : [307] 
    .attribute [303] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     ldc [5] 
L6:     ldc [6] 
L8:     ldc [7] 
L10:    invokevirtual [39] 
L13:    pop 
L14:    aload_0 
L15:    aload_0 
L16:    getfield [35] 
L19:    getstatic [8] 
L22:    ifnonnull L37 
L25:    ldc [9] 
L27:    invokestatic [10] 
L30:    dup 
L31:    putstatic [49] 
L34:    goto L40 
L37:    getstatic [8] 
L40:    aload_0 
L41:    new [61] 
L44:    dup 
L45:    iconst_0 
L46:    invokespecial [50] 
L49:    invokeinterface [62] 0 
L54:    putfield [63] 
L57:    aload_0 
L58:    getfield [37] 
L61:    iconst_m1 
L62:    new [64] 
L65:    dup 
L66:    aload_0 
L67:    invokespecial [51] 
L70:    invokeinterface [65] 0 
L75:    return 
L76:    
    .end code 
.end method 

.method public [308] : [309] 
    .attribute [303] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     ldc [5] 
L6:     ldc [13] 
L8:     ldc [7] 
L10:    invokevirtual [39] 
L13:    pop 
L14:    aload_0 
L15:    getfield [40] 
L18:    invokeinterface [66] 0 
L23:    return 
L24:    
    .end code 
.end method 

.method public [310] : [311] 
    .attribute [303] .code stack 6 locals 2 
L0:     iload_1 
L1:     invokestatic [14] 
L4:     astore 5 
L6:     aload 5 
L8:     invokevirtual [41] 
L11:    ifeq L19 
L14:    ldc [15] 
L16:    goto L21 
L19:    ldc [16] 
L21:    astore 6 
L23:    aload 5 
L25:    aload_0 
L26:    getfield [34] 
L29:    invokevirtual [42] 
L32:    ifeq L51 
L35:    aload_0 
L36:    getfield [38] 
L39:    ldc [5] 
L41:    ldc [17] 
L43:    ldc [7] 
L45:    aload 6 
L47:    invokevirtual [43] 
L50:    return 
L51:    aload_0 
L52:    aload 5 
L54:    putfield [56] 
L57:    aload_0 
L58:    getfield [38] 
L61:    ldc [5] 
L63:    ldc [18] 
L65:    ldc [7] 
L67:    aload 6 
L69:    invokevirtual [43] 
L72:    aload_0 
L73:    getfield [36] 
L76:    new [67] 
L79:    dup 
L80:    aload_0 
L81:    new [68] 
L84:    dup 
L85:    invokespecial [52] 
L88:    ldc [21] 
L90:    invokevirtual [44] 
L93:    aload 6 
L95:    invokevirtual [44] 
L98:    ldc [22] 
L100:   invokevirtual [44] 
L103:   invokevirtual [45] 
L106:   aload 5 
L108:   invokespecial [53] 
L111:   invokevirtual [46] 
L114:   pop 
L115:   return 
L116:   
    .end code 
.end method 

.method public enum [312] : [313] 
    .attribute [303] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [314] : [315] 
    .attribute [303] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [316] : [317] 
    .attribute [303] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method static synthetic [318] : [319] 
    .attribute [303] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [55] 
L9:     dup 
L10:    invokespecial [47] 
L13:    aload_1 
L14:    invokevirtual [33] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static synthetic [320] : [321] 
    .attribute [303] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [69] [70] 
.const [3] = Class [71] 
.const [4] = Class [72] 
.const [5] = Int 1078071040 
.const [6] = String [73] 
.const [7] = String [74] 
.const [8] = Field [75] [76] 
.const [9] = String [77] 
.const [10] = Method [78] [79] 
.const [11] = Class [80] 
.const [12] = Class [81] 
.const [13] = String [82] 
.const [14] = Method [83] [84] 
.const [15] = String [85] 
.const [16] = String [86] 
.const [17] = String [87] 
.const [18] = String [88] 
.const [19] = Class [89] 
.const [20] = Class [90] 
.const [21] = String [91] 
.const [22] = String [92] 
.const [23] = Class [93] 
.const [24] = Class [94] 
.const [25] = Class [95] 
.const [26] = Class [96] 
.const [27] = Class [97] 
.const [28] = Class [98] 
.const [29] = Class [99] 
.const [30] = Class [100] 
.const [31] = Class [101] 
.const [32] = Field [102] [103] 
.const [33] = Method [104] [105] 
.const [34] = Field [106] [107] 
.const [35] = Field [108] [109] 
.const [36] = Field [110] [111] 
.const [37] = Field [112] [113] 
.const [38] = Field [114] [115] 
.const [39] = Method [116] [117] 
.const [40] = Field [118] [119] 
.const [41] = Method [120] [121] 
.const [42] = Method [122] [123] 
.const [43] = Method [124] [125] 
.const [44] = Method [126] [127] 
.const [45] = Method [128] [129] 
.const [46] = Method [130] [131] 
.const [47] = Method [132] [133] 
.const [48] = Method [134] [135] 
.const [49] = Field [136] [137] 
.const [50] = Method [138] [139] 
.const [51] = Method [140] [141] 
.const [52] = Method [142] [143] 
.const [53] = Method [144] [145] 
.const [54] = Field [146] [147] 
.const [55] = Class [148] 
.const [56] = Field [149] [150] 
.const [57] = Field [151] [152] 
.const [58] = Field [153] [154] 
.const [59] = Field [155] [156] 
.const [60] = Field [157] [158] 
.const [61] = Class [159] 
.const [62] = InterfaceMethod [160] [161] 
.const [63] = Field [162] [163] 
.const [64] = Class [164] 
.const [65] = InterfaceMethod [165] [166] 
.const [66] = InterfaceMethod [167] [168] 
.const [67] = Class [169] 
.const [68] = Class [170] 
.const [69] = Class [171] 
.const [70] = NameAndType [172] [173] 
.const [71] = Utf8 java/lang/ClassNotFoundException 
.const [72] = Utf8 java/lang/NoClassDefFoundError 
.const [73] = Utf8 '[%1.init]' 
.const [74] = Utf8 PowerEventSourceStateProvider 
.const [75] = Class [174] 
.const [76] = NameAndType [175] [176] 
.const [77] = Utf8 'de.audi.atip.power.PowerEventListener' 
.const [78] = Class [177] 
.const [79] = NameAndType [178] [179] 
.const [80] = Utf8 java/util/Hashtable 
.const [81] = Utf8 de/audi/app/media/source/state/providers/PowerEventSourceStateProvider$1 
.const [82] = Utf8 '[%1.deinit]' 
.const [83] = Class [180] 
.const [84] = NameAndType [181] [182] 
.const [85] = Utf8 ON 
.const [86] = Utf8 OFF 
.const [87] = Utf8 "[%1.updateClampState] clampS='%2' (not changed)" 
.const [88] = Utf8 "[%1.updateClampState] clampS='%2'" 
.const [89] = Utf8 de/audi/app/media/source/state/providers/PowerEventSourceStateProvider$2 
.const [90] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [91] = Utf8 "updateClampState('" 
.const [92] = Utf8 "')" 
.const [93] = Utf8 de/audi/app/media/source/state/providers/PowerEventSourceStateProvider 
.const [94] = Utf8 java/lang/Object 
.const [95] = Utf8 java/lang/Class 
.const [96] = Utf8 de/audi/atip/log/LogChannel 
.const [97] = Utf8 de/audi/app/media/osgi/IServiceManager 
.const [98] = Utf8 de/audi/app/media/diagnosis/IDiagnosisManager 
.const [99] = Utf8 org/osgi/framework/ServiceRegistration 
.const [100] = Utf8 java/lang/Boolean 
.const [101] = Utf8 de/esolutions/fw/util/commons/job/DispatcherBase 
.const [102] = Class [183] 
.const [103] = NameAndType [184] [185] 
.const [104] = Class [186] 
.const [105] = NameAndType [187] [188] 
.const [106] = Class [189] 
.const [107] = NameAndType [190] [191] 
.const [108] = Class [192] 
.const [109] = NameAndType [193] [194] 
.const [110] = Class [195] 
.const [111] = NameAndType [196] [197] 
.const [112] = Class [198] 
.const [113] = NameAndType [199] [200] 
.const [114] = Class [201] 
.const [115] = NameAndType [202] [203] 
.const [116] = Class [204] 
.const [117] = NameAndType [205] [206] 
.const [118] = Class [207] 
.const [119] = NameAndType [208] [209] 
.const [120] = Class [210] 
.const [121] = NameAndType [211] [212] 
.const [122] = Class [213] 
.const [123] = NameAndType [214] [215] 
.const [124] = Class [216] 
.const [125] = NameAndType [217] [218] 
.const [126] = Class [219] 
.const [127] = NameAndType [220] [221] 
.const [128] = Class [222] 
.const [129] = NameAndType [223] [224] 
.const [130] = Class [225] 
.const [131] = NameAndType [226] [227] 
.const [132] = Class [228] 
.const [133] = NameAndType [229] [230] 
.const [134] = Class [231] 
.const [135] = NameAndType [232] [233] 
.const [136] = Class [234] 
.const [137] = NameAndType [235] [236] 
.const [138] = Class [237] 
.const [139] = NameAndType [238] [239] 
.const [140] = Class [240] 
.const [141] = NameAndType [241] [242] 
.const [142] = Class [243] 
.const [143] = NameAndType [244] [245] 
.const [144] = Class [246] 
.const [145] = NameAndType [247] [248] 
.const [146] = Class [249] 
.const [147] = NameAndType [250] [251] 
.const [148] = Utf8 java/lang/NoClassDefFoundError 
.const [149] = Class [252] 
.const [150] = NameAndType [253] [254] 
.const [151] = Class [255] 
.const [152] = NameAndType [256] [257] 
.const [153] = Class [258] 
.const [154] = NameAndType [259] [260] 
.const [155] = Class [261] 
.const [156] = NameAndType [262] [263] 
.const [157] = Class [264] 
.const [158] = NameAndType [265] [266] 
.const [159] = Utf8 java/util/Hashtable 
.const [160] = Class [267] 
.const [161] = NameAndType [268] [269] 
.const [162] = Class [270] 
.const [163] = NameAndType [271] [272] 
.const [164] = Utf8 de/audi/app/media/source/state/providers/PowerEventSourceStateProvider$1 
.const [165] = Class [273] 
.const [166] = NameAndType [274] [275] 
.const [167] = Class [276] 
.const [168] = NameAndType [277] [278] 
.const [169] = Utf8 de/audi/app/media/source/state/providers/PowerEventSourceStateProvider$2 
.const [170] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [171] = Utf8 java/lang/Class 
.const [172] = Utf8 forName 
.const [173] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [174] = Utf8 de/audi/app/media/source/state/providers/PowerEventSourceStateProvider 
.const [175] = Utf8 class$de$audi$atip$power$PowerEventListener 
.const [176] = Utf8 Ljava/lang/Class; 
.const [177] = Utf8 de/audi/app/media/source/state/providers/PowerEventSourceStateProvider 
.const [178] = Utf8 class$ 
.const [179] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [180] = Utf8 java/lang/Boolean 
.const [181] = Utf8 valueOf 
.const [182] = Utf8 (Z)Ljava/lang/Boolean; 
.const [183] = Utf8 de/audi/app/media/source/state/providers/PowerEventSourceStateProvider 
.const [184] = Utf8 sourceStateUpdater 
.const [185] = Utf8 Lde/audi/app/media/source/state/ISourceStateUpdater; 
.const [186] = Utf8 java/lang/NoClassDefFoundError 
.const [187] = Utf8 initCause 
.const [188] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [189] = Utf8 de/audi/app/media/source/state/providers/PowerEventSourceStateProvider 
.const [190] = Utf8 lastClampS 
.const [191] = Utf8 Ljava/lang/Boolean; 
.const [192] = Utf8 de/audi/app/media/source/state/providers/PowerEventSourceStateProvider 
.const [193] = Utf8 serviceManager 
.const [194] = Utf8 Lde/audi/app/media/osgi/IServiceManager; 
.const [195] = Utf8 de/audi/app/media/source/state/providers/PowerEventSourceStateProvider 
.const [196] = Utf8 dispatcher 
.const [197] = Utf8 Lde/esolutions/fw/util/commons/job/DispatcherBase; 
.const [198] = Utf8 de/audi/app/media/source/state/providers/PowerEventSourceStateProvider 
.const [199] = Utf8 diagManager 
.const [200] = Utf8 Lde/audi/app/media/diagnosis/IDiagnosisManager; 
.const [201] = Utf8 de/audi/app/media/source/state/providers/PowerEventSourceStateProvider 
.const [202] = Utf8 logger 
.const [203] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [204] = Utf8 de/audi/atip/log/LogChannel 
.const [205] = Utf8 log 
.const [206] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [207] = Utf8 de/audi/app/media/source/state/providers/PowerEventSourceStateProvider 
.const [208] = Utf8 powerEventListenerRegistration 
.const [209] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [210] = Utf8 java/lang/Boolean 
.const [211] = Utf8 booleanValue 
.const [212] = Utf8 ()Z 
.const [213] = Utf8 java/lang/Boolean 
.const [214] = Utf8 equals 
.const [215] = Utf8 (Ljava/lang/Object;)Z 
.const [216] = Utf8 de/audi/atip/log/LogChannel 
.const [217] = Utf8 log 
.const [218] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [219] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [220] = Utf8 append 
.const [221] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [222] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [223] = Utf8 toString 
.const [224] = Utf8 ()Ljava/lang/String; 
.const [225] = Utf8 de/esolutions/fw/util/commons/job/DispatcherBase 
.const [226] = Utf8 execute 
.const [227] = Utf8 (Ljava/lang/Object;)Lde/esolutions/fw/util/commons/job/Job; 
.const [228] = Utf8 java/lang/NoClassDefFoundError 
.const [229] = Utf8 <init> 
.const [230] = Utf8 ()V 
.const [231] = Utf8 java/lang/Object 
.const [232] = Utf8 <init> 
.const [233] = Utf8 ()V 
.const [234] = Utf8 de/audi/app/media/source/state/providers/PowerEventSourceStateProvider 
.const [235] = Utf8 class$de$audi$atip$power$PowerEventListener 
.const [236] = Utf8 Ljava/lang/Class; 
.const [237] = Utf8 java/util/Hashtable 
.const [238] = Utf8 <init> 
.const [239] = Utf8 (I)V 
.const [240] = Utf8 de/audi/app/media/source/state/providers/PowerEventSourceStateProvider$1 
.const [241] = Utf8 <init> 
.const [242] = Utf8 (Lde/audi/app/media/source/state/providers/PowerEventSourceStateProvider;)V 
.const [243] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [244] = Utf8 <init> 
.const [245] = Utf8 ()V 
.const [246] = Utf8 de/audi/app/media/source/state/providers/PowerEventSourceStateProvider$2 
.const [247] = Utf8 <init> 
.const [248] = Utf8 (Lde/audi/app/media/source/state/providers/PowerEventSourceStateProvider;Ljava/lang/String;Ljava/lang/Boolean;)V 
.const [249] = Utf8 de/audi/app/media/source/state/providers/PowerEventSourceStateProvider 
.const [250] = Utf8 sourceStateUpdater 
.const [251] = Utf8 Lde/audi/app/media/source/state/ISourceStateUpdater; 
.const [252] = Utf8 de/audi/app/media/source/state/providers/PowerEventSourceStateProvider 
.const [253] = Utf8 lastClampS 
.const [254] = Utf8 Ljava/lang/Boolean; 
.const [255] = Utf8 de/audi/app/media/source/state/providers/PowerEventSourceStateProvider 
.const [256] = Utf8 serviceManager 
.const [257] = Utf8 Lde/audi/app/media/osgi/IServiceManager; 
.const [258] = Utf8 de/audi/app/media/source/state/providers/PowerEventSourceStateProvider 
.const [259] = Utf8 dispatcher 
.const [260] = Utf8 Lde/esolutions/fw/util/commons/job/DispatcherBase; 
.const [261] = Utf8 de/audi/app/media/source/state/providers/PowerEventSourceStateProvider 
.const [262] = Utf8 diagManager 
.const [263] = Utf8 Lde/audi/app/media/diagnosis/IDiagnosisManager; 
.const [264] = Utf8 de/audi/app/media/source/state/providers/PowerEventSourceStateProvider 
.const [265] = Utf8 logger 
.const [266] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [267] = Utf8 de/audi/app/media/osgi/IServiceManager 
.const [268] = Utf8 registerService 
.const [269] = Utf8 (Ljava/lang/Class;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [270] = Utf8 de/audi/app/media/source/state/providers/PowerEventSourceStateProvider 
.const [271] = Utf8 powerEventListenerRegistration 
.const [272] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [273] = Utf8 de/audi/app/media/diagnosis/IDiagnosisManager 
.const [274] = Utf8 addCommandProvider 
.const [275] = Utf8 (ILde/audi/app/media/diagnosis/IDiagnosisCommandProvider;)V 
.const [276] = Utf8 org/osgi/framework/ServiceRegistration 
.const [277] = Utf8 unregister 
.const [278] = Utf8 ()V 
.const [279] = Utf8 de/audi/app/media/source/state/providers/PowerEventSourceStateProvider 
.const [280] = Class [279] 
.const [281] = Utf8 java/lang/Object 
.const [282] = Class [281] 
.const [283] = Utf8 de/audi/atip/power/PowerEventListener 
.const [284] = Class [283] 
.const [285] = Utf8 LOGCLASS 
.const [286] = Utf8 Ljava/lang/String; 
.const [287] = Utf8 logger 
.const [288] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [289] = Utf8 sourceStateUpdater 
.const [290] = Utf8 Lde/audi/app/media/source/state/ISourceStateUpdater; 
.const [291] = Utf8 diagManager 
.const [292] = Utf8 Lde/audi/app/media/diagnosis/IDiagnosisManager; 
.const [293] = Utf8 serviceManager 
.const [294] = Utf8 Lde/audi/app/media/osgi/IServiceManager; 
.const [295] = Utf8 dispatcher 
.const [296] = Utf8 Lde/esolutions/fw/util/commons/job/DispatcherBase; 
.const [297] = Utf8 powerEventListenerRegistration 
.const [298] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [299] = Utf8 lastClampS 
.const [300] = Utf8 Ljava/lang/Boolean; 
.const [301] = Utf8 class$de$audi$atip$power$PowerEventListener 
.const [302] = Utf8 Ljava/lang/Class; 
.const [303] = Utf8 Code 
.const [304] = Utf8 <init> 
.const [305] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/app/media/osgi/IServiceManager;Lde/audi/app/media/source/state/ISourceStateUpdater;Lde/audi/app/media/diagnosis/IDiagnosisManager;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [306] = Utf8 init 
.const [307] = Utf8 ()V 
.const [308] = Utf8 deinit 
.const [309] = Utf8 ()V 
.const [310] = Utf8 updateClampState 
.const [311] = Utf8 (ZZZZ)V 
.const [312] = Utf8 notifyPowerListenerOnEnterState 
.const [313] = Utf8 (II)V 
.const [314] = Utf8 notifyPowerListenerOnExitState 
.const [315] = Utf8 (II)V 
.const [316] = Utf8 notifyPowerTriggerAction 
.const [317] = Utf8 (II)V 
.const [318] = Utf8 class$ 
.const [319] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [320] = Utf8 access$000 
.const [321] = Utf8 (Lde/audi/app/media/source/state/providers/PowerEventSourceStateProvider;)Lde/audi/app/media/source/state/ISourceStateUpdater; 
.end class 
