.version 50 0 
.class public super [310] 
.super [312] 
.field public static final [313] [314] 
.field private final [315] [316] 
.field private final [317] [318] 

.method public [320] : [321] 
    .attribute [319] .code stack 5 locals 2 
L0:     aload_0 
L1:     invokespecial [56] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [60] 
L9:     aload_0 
L10:    aload_1 
L11:    getfield [36] 
L14:    getfield [37] 
L17:    putfield [61] 
L20:    aload_1 
L21:    getfield [39] 
L24:    invokeinterface [62] 0 
L29:    invokeinterface [63] 0 
L34:    invokeinterface [64] 0 
L39:    istore_2 
L40:    aload_0 
L41:    getfield [35] 
L44:    getfield [40] 
L47:    ldc [2] 
L49:    ldc [3] 
L51:    iload_2 
L52:    i2l 
L53:    invokevirtual [41] 
L56:    pop 
L57:    aload_1 
L58:    getfield [36] 
L61:    getfield [42] 
L64:    getfield [43] 
L67:    astore_3 
L68:    iload_2 
L69:    sipush 254 
L72:    if_icmpne L86 
L75:    aload_1 
L76:    getfield [36] 
L79:    getfield [42] 
L82:    getfield [44] 
L85:    astore_3 
L86:    aload_3 
L87:    aload_1 
L88:    getfield [36] 
L91:    getfield [45] 
L94:    getfield [46] 
L97:    invokeinterface [65] 0 
L102:   aload_1 
L103:   getfield [36] 
L106:   getfield [47] 
L109:   getfield [48] 
L112:   invokeinterface [66] 0 
L117:   invokestatic [4] 
L120:   invokeinterface [67] 0 
L125:   aload_1 
L126:   getfield [49] 
L129:   invokeinterface [68] 0 
L134:   new [69] 
L137:   dup 
L138:   aload_0 
L139:   invokespecial [57] 
L142:   invokeinterface [70] 0 
L147:   pop 
L148:   return 
L149:   nop 
L150:   nop 
L151:   nop 
L152:   
    .end code 
.end method 

.method private [322] : [323] 
    .attribute [319] .code stack 7 locals 3 
L0:     aload_0 
L1:     getfield [35] 
L4:     getfield [40] 
L7:     ldc [2] 
L9:     ldc [6] 
L11:    iload_1 
L12:    invokestatic [7] 
L15:    new [71] 
L18:    dup 
L19:    aload_2 
L20:    getfield [50] 
L23:    invokespecial [58] 
L26:    iload_3 
L27:    i2l 
L28:    invokevirtual [51] 
L31:    iconst_0 
L32:    istore 4 
L34:    iload_1 
L35:    ifeq L59 
L38:    iload_3 
L39:    iconst_1 
L40:    if_icmpne L49 
L43:    iconst_1 
L44:    istore 4 
L46:    goto L59 
L49:    iload_3 
L50:    ifne L59 
L53:    aload_2 
L54:    invokestatic [9] 
L57:    istore 4 
L59:    iload_1 
L60:    ifeq L67 
L63:    iconst_1 
L64:    goto L68 
L67:    iconst_0 
L68:    istore 5 
L70:    iload 4 
L72:    ifeq L79 
L75:    iconst_1 
L76:    goto L80 
L79:    iconst_0 
L80:    istore 6 
L82:    aload_0 
L83:    getfield [35] 
L86:    ldc [10] 
L88:    invokevirtual [52] 
L91:    iload 6 
L93:    invokeinterface [72] 0 
L98:    aload_0 
L99:    getfield [35] 
L102:   ldc [11] 
L104:   invokevirtual [52] 
L107:   iload 6 
L109:   invokeinterface [72] 0 
L114:   aload_0 
L115:   getfield [35] 
L118:   getfield [36] 
L121:   getfield [53] 
L124:   getfield [54] 
L127:   new [71] 
L130:   dup 
L131:   iload 5 
L133:   invokespecial [58] 
L136:   invokeinterface [73] 0 
L141:   aload_0 
L142:   getfield [38] 
L145:   invokestatic [12] 
L148:   new [74] 
L151:   dup 
L152:   iload 4 
L154:   invokespecial [59] 
L157:   invokeinterface [73] 0 
L162:   return 
L163:   nop 
L164:   
    .end code 
.end method 

.method public static [324] : [325] 
    .attribute [319] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [50] 
L4:     tableswitch 3 
            L52 
            L52 
            L54 
            L52 
            L54 
            L54 
            L54 
            L52 
            default : L54 

L52:    iconst_0 
L53:    areturn 
L54:    iconst_1 
L55:    areturn 
L56:    
    .end code 
.end method 

.method static synthetic [326] : [327] 
    .attribute [319] .code stack 4 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     aload_2 
L3:     iload_3 
L4:     invokespecial [55] 
L7:     return 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [75] 
.const [4] = Method [76] [77] 
.const [5] = Class [78] 
.const [6] = String [79] 
.const [7] = Method [80] [81] 
.const [8] = Class [82] 
.const [9] = Method [83] [84] 
.const [10] = Int 1353459456 
.const [11] = Int 1470899968 
.const [12] = Method [85] [86] 
.const [13] = Class [87] 
.const [14] = Class [88] 
.const [15] = Class [89] 
.const [16] = Class [90] 
.const [17] = Class [91] 
.const [18] = Class [92] 
.const [19] = Class [93] 
.const [20] = Class [94] 
.const [21] = Class [95] 
.const [22] = Class [96] 
.const [23] = Class [97] 
.const [24] = Class [98] 
.const [25] = Class [99] 
.const [26] = Class [100] 
.const [27] = Class [101] 
.const [28] = Class [102] 
.const [29] = Class [103] 
.const [30] = Class [104] 
.const [31] = Class [105] 
.const [32] = Class [106] 
.const [33] = Class [107] 
.const [34] = Class [108] 
.const [35] = Field [109] [110] 
.const [36] = Field [111] [112] 
.const [37] = Field [113] [114] 
.const [38] = Field [115] [116] 
.const [39] = Field [117] [118] 
.const [40] = Field [119] [120] 
.const [41] = Method [121] [122] 
.const [42] = Field [123] [124] 
.const [43] = Field [125] [126] 
.const [44] = Field [127] [128] 
.const [45] = Field [129] [130] 
.const [46] = Field [131] [132] 
.const [47] = Field [133] [134] 
.const [48] = Field [135] [136] 
.const [49] = Field [137] [138] 
.const [50] = Field [139] [140] 
.const [51] = Method [141] [142] 
.const [52] = Method [143] [144] 
.const [53] = Field [145] [146] 
.const [54] = Field [147] [148] 
.const [55] = Method [149] [150] 
.const [56] = Method [151] [152] 
.const [57] = Method [153] [154] 
.const [58] = Method [155] [156] 
.const [59] = Method [157] [158] 
.const [60] = Field [159] [160] 
.const [61] = Field [161] [162] 
.const [62] = InterfaceMethod [163] [164] 
.const [63] = InterfaceMethod [165] [166] 
.const [64] = InterfaceMethod [167] [168] 
.const [65] = InterfaceMethod [169] [170] 
.const [66] = InterfaceMethod [171] [172] 
.const [67] = InterfaceMethod [173] [174] 
.const [68] = InterfaceMethod [175] [176] 
.const [69] = Class [177] 
.const [70] = InterfaceMethod [178] [179] 
.const [71] = Class [180] 
.const [72] = InterfaceMethod [181] [182] 
.const [73] = InterfaceMethod [183] [184] 
.const [74] = Class [185] 
.const [75] = Utf8 '[TVSpeedDisclaimer] testmodeVideo %1' 
.const [76] = Class [186] 
.const [77] = NameAndType [187] [188] 
.const [78] = Utf8 de/audi/tv/app/TVSpeedDisclaimer$1 
.const [79] = Utf8 '[TVSpeedDisclaimer.update] shouldShow:%1 sType:%2 source:%3' 
.const [80] = Class [189] 
.const [81] = NameAndType [190] [191] 
.const [82] = Utf8 java/lang/Integer 
.const [83] = Class [192] 
.const [84] = NameAndType [193] [194] 
.const [85] = Class [195] 
.const [86] = NameAndType [196] [197] 
.const [87] = Utf8 java/lang/Boolean 
.const [88] = Utf8 de/audi/tv/app/TVSpeedDisclaimer 
.const [89] = Utf8 java/lang/Object 
.const [90] = Utf8 de/audi/tv/app/TVSpeedDisclaimer$Properties 
.const [91] = Utf8 de/audi/tv/app/base/TVEnv 
.const [92] = Utf8 de/audi/tv/app/base/PropertyBank 
.const [93] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [94] = Utf8 de/audi/atip/sysapp/ISysApp 
.const [95] = Utf8 de/audi/atip/sysapp/carcoding/Adaptation 
.const [96] = Utf8 de/audi/atip/log/LogChannel 
.const [97] = Utf8 de/audi/tv/app/base/TVEventDispatcher$Properties 
.const [98] = Utf8 de/audi/tv/app/dsi/DsiProperties$Properties 
.const [99] = Utf8 de/audi/atip/utils/reactive/properties/ReadOnlyProperty 
.const [100] = Utf8 de/audi/tv/app/SourceManager$Properties 
.const [101] = Utf8 de/audi/atip/utils/reactive/observables/Observables$Combinable 
.const [102] = Utf8 de/audi/tv/app/util/generics/Triple 
.const [103] = Utf8 de/audi/atip/utils/reactive/observables/Observables$Combinable3 
.const [104] = Utf8 de/audi/atip/utils/reactive/observables/Observable 
.const [105] = Utf8 org/dsi/ifc/tvtuner/ServiceInfo 
.const [106] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [107] = Utf8 de/audi/tv/app/tm/handling/TerminalAndScreenModeHandler$Properties 
.const [108] = Utf8 de/audi/atip/utils/reactive/properties/Property 
.const [109] = Class [198] 
.const [110] = NameAndType [199] [200] 
.const [111] = Class [201] 
.const [112] = NameAndType [202] [203] 
.const [113] = Class [204] 
.const [114] = NameAndType [205] [206] 
.const [115] = Class [207] 
.const [116] = NameAndType [208] [209] 
.const [117] = Class [210] 
.const [118] = NameAndType [211] [212] 
.const [119] = Class [213] 
.const [120] = NameAndType [214] [215] 
.const [121] = Class [216] 
.const [122] = NameAndType [217] [218] 
.const [123] = Class [219] 
.const [124] = NameAndType [220] [221] 
.const [125] = Class [222] 
.const [126] = NameAndType [223] [224] 
.const [127] = Class [225] 
.const [128] = NameAndType [226] [227] 
.const [129] = Class [228] 
.const [130] = NameAndType [229] [230] 
.const [131] = Class [231] 
.const [132] = NameAndType [232] [233] 
.const [133] = Class [234] 
.const [134] = NameAndType [235] [236] 
.const [135] = Class [237] 
.const [136] = NameAndType [238] [239] 
.const [137] = Class [240] 
.const [138] = NameAndType [241] [242] 
.const [139] = Class [243] 
.const [140] = NameAndType [244] [245] 
.const [141] = Class [246] 
.const [142] = NameAndType [247] [248] 
.const [143] = Class [249] 
.const [144] = NameAndType [250] [251] 
.const [145] = Class [252] 
.const [146] = NameAndType [253] [254] 
.const [147] = Class [255] 
.const [148] = NameAndType [256] [257] 
.const [149] = Class [258] 
.const [150] = NameAndType [259] [260] 
.const [151] = Class [261] 
.const [152] = NameAndType [262] [263] 
.const [153] = Class [264] 
.const [154] = NameAndType [265] [266] 
.const [155] = Class [267] 
.const [156] = NameAndType [268] [269] 
.const [157] = Class [270] 
.const [158] = NameAndType [271] [272] 
.const [159] = Class [273] 
.const [160] = NameAndType [274] [275] 
.const [161] = Class [276] 
.const [162] = NameAndType [277] [278] 
.const [163] = Class [279] 
.const [164] = NameAndType [280] [281] 
.const [165] = Class [282] 
.const [166] = NameAndType [283] [284] 
.const [167] = Class [285] 
.const [168] = NameAndType [286] [287] 
.const [169] = Class [288] 
.const [170] = NameAndType [289] [290] 
.const [171] = Class [291] 
.const [172] = NameAndType [292] [293] 
.const [173] = Class [294] 
.const [174] = NameAndType [295] [296] 
.const [175] = Class [297] 
.const [176] = NameAndType [298] [299] 
.const [177] = Utf8 de/audi/tv/app/TVSpeedDisclaimer$1 
.const [178] = Class [300] 
.const [179] = NameAndType [301] [302] 
.const [180] = Utf8 java/lang/Integer 
.const [181] = Class [303] 
.const [182] = NameAndType [304] [305] 
.const [183] = Class [306] 
.const [184] = NameAndType [307] [308] 
.const [185] = Utf8 java/lang/Boolean 
.const [186] = Utf8 de/audi/tv/app/util/generics/Triple 
.const [187] = Utf8 combine 
.const [188] = Utf8 ()Lde/audi/atip/utils/reactive/observables/Observables$Combinator3; 
.const [189] = Utf8 java/lang/Boolean 
.const [190] = Utf8 valueOf 
.const [191] = Utf8 (Z)Ljava/lang/Boolean; 
.const [192] = Utf8 de/audi/tv/app/TVSpeedDisclaimer 
.const [193] = Utf8 doesServiceNeedSpeedDisclaimer 
.const [194] = Utf8 (Lorg/dsi/ifc/tvtuner/ServiceInfo;)Z 
.const [195] = Utf8 de/audi/tv/app/TVSpeedDisclaimer$Properties 
.const [196] = Utf8 access$100 
.const [197] = Utf8 (Lde/audi/tv/app/TVSpeedDisclaimer$Properties;)Lde/audi/atip/utils/reactive/properties/Property; 
.const [198] = Utf8 de/audi/tv/app/TVSpeedDisclaimer 
.const [199] = Utf8 env 
.const [200] = Utf8 Lde/audi/tv/app/base/TVEnv; 
.const [201] = Utf8 de/audi/tv/app/base/TVEnv 
.const [202] = Utf8 properties 
.const [203] = Utf8 Lde/audi/tv/app/base/PropertyBank; 
.const [204] = Utf8 de/audi/tv/app/base/PropertyBank 
.const [205] = Utf8 speedDisclaimer 
.const [206] = Utf8 Lde/audi/tv/app/TVSpeedDisclaimer$Properties; 
.const [207] = Utf8 de/audi/tv/app/TVSpeedDisclaimer 
.const [208] = Utf8 myProperties 
.const [209] = Utf8 Lde/audi/tv/app/TVSpeedDisclaimer$Properties; 
.const [210] = Utf8 de/audi/tv/app/base/TVEnv 
.const [211] = Utf8 framework 
.const [212] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [213] = Utf8 de/audi/tv/app/base/TVEnv 
.const [214] = Utf8 lcMain 
.const [215] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [216] = Utf8 de/audi/atip/log/LogChannel 
.const [217] = Utf8 log 
.const [218] = Utf8 (ILjava/lang/String;J)Z 
.const [219] = Utf8 de/audi/tv/app/base/PropertyBank 
.const [220] = Utf8 eventDispatcher 
.const [221] = Utf8 Lde/audi/tv/app/base/TVEventDispatcher$Properties; 
.const [222] = Utf8 de/audi/tv/app/base/TVEventDispatcher$Properties 
.const [223] = Utf8 vehicleMoving 
.const [224] = Utf8 Lde/audi/atip/utils/reactive/properties/ReadOnlyProperty; 
.const [225] = Utf8 de/audi/tv/app/base/TVEventDispatcher$Properties 
.const [226] = Utf8 clamp15Activated 
.const [227] = Utf8 Lde/audi/atip/utils/reactive/properties/ReadOnlyProperty; 
.const [228] = Utf8 de/audi/tv/app/base/PropertyBank 
.const [229] = Utf8 dsiProperties 
.const [230] = Utf8 Lde/audi/tv/app/dsi/DsiProperties$Properties; 
.const [231] = Utf8 de/audi/tv/app/dsi/DsiProperties$Properties 
.const [232] = Utf8 selectAndSelectedService 
.const [233] = Utf8 Lde/audi/atip/utils/reactive/properties/ReadOnlyProperty; 
.const [234] = Utf8 de/audi/tv/app/base/PropertyBank 
.const [235] = Utf8 source 
.const [236] = Utf8 Lde/audi/tv/app/SourceManager$Properties; 
.const [237] = Utf8 de/audi/tv/app/SourceManager$Properties 
.const [238] = Utf8 currentSource 
.const [239] = Utf8 Lde/audi/atip/utils/reactive/properties/ReadOnlyProperty; 
.const [240] = Utf8 de/audi/tv/app/base/TVEnv 
.const [241] = Utf8 dispatch 
.const [242] = Utf8 Lde/audi/atip/utils/dispatching/IDispatcher; 
.const [243] = Utf8 org/dsi/ifc/tvtuner/ServiceInfo 
.const [244] = Utf8 sType 
.const [245] = Utf8 I 
.const [246] = Utf8 de/audi/atip/log/LogChannel 
.const [247] = Utf8 log 
.const [248] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;J)V 
.const [249] = Utf8 de/audi/tv/app/base/TVEnv 
.const [250] = Utf8 getChoiceModel 
.const [251] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [252] = Utf8 de/audi/tv/app/base/PropertyBank 
.const [253] = Utf8 terminalMode 
.const [254] = Utf8 Lde/audi/tv/app/tm/handling/TerminalAndScreenModeHandler$Properties; 
.const [255] = Utf8 de/audi/tv/app/tm/handling/TerminalAndScreenModeHandler$Properties 
.const [256] = Utf8 desiredScreenMode 
.const [257] = Utf8 Lde/audi/atip/utils/reactive/properties/Property; 
.const [258] = Utf8 de/audi/tv/app/TVSpeedDisclaimer 
.const [259] = Utf8 update 
.const [260] = Utf8 (ZLorg/dsi/ifc/tvtuner/ServiceInfo;I)V 
.const [261] = Utf8 java/lang/Object 
.const [262] = Utf8 <init> 
.const [263] = Utf8 ()V 
.const [264] = Utf8 de/audi/tv/app/TVSpeedDisclaimer$1 
.const [265] = Utf8 <init> 
.const [266] = Utf8 (Lde/audi/tv/app/TVSpeedDisclaimer;)V 
.const [267] = Utf8 java/lang/Integer 
.const [268] = Utf8 <init> 
.const [269] = Utf8 (I)V 
.const [270] = Utf8 java/lang/Boolean 
.const [271] = Utf8 <init> 
.const [272] = Utf8 (Z)V 
.const [273] = Utf8 de/audi/tv/app/TVSpeedDisclaimer 
.const [274] = Utf8 env 
.const [275] = Utf8 Lde/audi/tv/app/base/TVEnv; 
.const [276] = Utf8 de/audi/tv/app/TVSpeedDisclaimer 
.const [277] = Utf8 myProperties 
.const [278] = Utf8 Lde/audi/tv/app/TVSpeedDisclaimer$Properties; 
.const [279] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [280] = Utf8 getSysApp 
.const [281] = Utf8 ()Lde/audi/atip/sysapp/ISysApp; 
.const [282] = Utf8 de/audi/atip/sysapp/ISysApp 
.const [283] = Utf8 getAdaptationANP 
.const [284] = Utf8 ()Lde/audi/atip/sysapp/carcoding/Adaptation; 
.const [285] = Utf8 de/audi/atip/sysapp/carcoding/Adaptation 
.const [286] = Utf8 getTestmodeVideoSpeedCutoffLimit 
.const [287] = Utf8 ()I 
.const [288] = Utf8 de/audi/atip/utils/reactive/properties/ReadOnlyProperty 
.const [289] = Utf8 combineWith 
.const [290] = Utf8 (Lde/audi/atip/utils/reactive/observables/Observable;)Lde/audi/atip/utils/reactive/observables/Observables$Combinable; 
.const [291] = Utf8 de/audi/atip/utils/reactive/observables/Observables$Combinable 
.const [292] = Utf8 combineWith 
.const [293] = Utf8 (Lde/audi/atip/utils/reactive/observables/Observable;)Lde/audi/atip/utils/reactive/observables/Observables$Combinable3; 
.const [294] = Utf8 de/audi/atip/utils/reactive/observables/Observables$Combinable3 
.const [295] = Utf8 using 
.const [296] = Utf8 (Lde/audi/atip/utils/reactive/observables/Observables$Combinator3;)Lde/audi/atip/utils/reactive/observables/Observable; 
.const [297] = Utf8 de/audi/atip/utils/reactive/observables/Observable 
.const [298] = Utf8 async 
.const [299] = Utf8 (Lde/audi/atip/utils/dispatching/IDispatcher;)Lde/audi/atip/utils/reactive/observables/Observable; 
.const [300] = Utf8 de/audi/atip/utils/reactive/observables/Observable 
.const [301] = Utf8 subscribe 
.const [302] = Utf8 (Lde/audi/atip/utils/generics/Consumer;)Lde/audi/atip/utils/reactive/observables/Subscription; 
.const [303] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [304] = Utf8 setValue 
.const [305] = Utf8 (I)V 
.const [306] = Utf8 de/audi/atip/utils/reactive/properties/Property 
.const [307] = Utf8 accept 
.const [308] = Utf8 (Ljava/lang/Object;)V 
.const [309] = Utf8 de/audi/tv/app/TVSpeedDisclaimer 
.const [310] = Class [309] 
.const [311] = Utf8 java/lang/Object 
.const [312] = Class [311] 
.const [313] = Utf8 TESTMODE_VIDEO_USE_CLAMP_15 
.const [314] = Utf8 I 
.const [315] = Utf8 myProperties 
.const [316] = Utf8 Lde/audi/tv/app/TVSpeedDisclaimer$Properties; 
.const [317] = Utf8 env 
.const [318] = Utf8 Lde/audi/tv/app/base/TVEnv; 
.const [319] = Utf8 Code 
.const [320] = Utf8 <init> 
.const [321] = Utf8 (Lde/audi/tv/app/base/TVEnv;)V 
.const [322] = Utf8 update 
.const [323] = Utf8 (ZLorg/dsi/ifc/tvtuner/ServiceInfo;I)V 
.const [324] = Utf8 doesServiceNeedSpeedDisclaimer 
.const [325] = Utf8 (Lorg/dsi/ifc/tvtuner/ServiceInfo;)Z 
.const [326] = Utf8 access$000 
.const [327] = Utf8 (Lde/audi/tv/app/TVSpeedDisclaimer;ZLorg/dsi/ifc/tvtuner/ServiceInfo;I)V 
.end class 
