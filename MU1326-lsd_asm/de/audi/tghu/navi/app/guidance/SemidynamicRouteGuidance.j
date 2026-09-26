.version 50 0 
.class public super [251] 
.super [253] 
.field public static final [254] [255] 
.field public static final [256] [257] 
.field private final [258] [259] 
.field private [260] [261] 
.field private final [262] [263] 
.field private final [264] [265] 

.method public [267] : [268] 
    .attribute [266] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     new [42] 
L5:     dup 
L6:     aload_1 
L7:     invokespecial [37] 
L10:    invokespecial [38] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [269] : [270] 
    .attribute [266] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [39] 
L4:     aload_0 
L5:     new [43] 
L8:     dup 
L9:     invokespecial [39] 
L12:    putfield [44] 
L15:    aload_0 
L16:    aload_2 
L17:    putfield [45] 
L20:    aload_0 
L21:    aload_1 
L22:    invokevirtual [24] 
L25:    putfield [46] 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [271] : [272] 
    .attribute [266] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [47] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [273] : [274] 
    .attribute [266] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     iconst_1 
L5:     if_icmpne L10 
L8:     iconst_1 
L9:     areturn 
L10:    iconst_0 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [275] : [276] 
    .attribute [266] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [22] 
L4:     dup 
L5:     astore_1 
L6:     monitorenter 
        .catch [0] from L7 to L33 using L34 
L7:     aload_0 
L8:     invokevirtual [27] 
L11:    ifeq L30 
L14:    aload_0 
L15:    getfield [23] 
L18:    invokeinterface [48] 0 
L23:    ifeq L30 
L26:    iconst_1 
L27:    goto L31 
L30:    iconst_0 
L31:    aload_1 
L32:    monitorexit 
L33:    areturn 
        .catch [0] from L34 to L37 using L34 
L34:    astore_2 
L35:    aload_1 
L36:    monitorexit 
L37:    aload_2 
L38:    athrow 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [277] : [278] 
    .attribute [266] .code stack 4 locals 5 
L0:     aload_0 
L1:     getfield [25] 
L4:     ldc [4] 
L6:     ldc [5] 
L8:     aload_1 
L9:     invokevirtual [28] 
L12:    pop 
L13:    aload_0 
L14:    invokevirtual [27] 
L17:    ifne L33 
L20:    aload_0 
L21:    getfield [25] 
L24:    ldc [4] 
L26:    ldc [6] 
L28:    invokevirtual [29] 
L31:    pop 
L32:    return 
L33:    aload_1 
L34:    invokestatic [7] 
L37:    istore_2 
L38:    aload_1 
L39:    invokestatic [8] 
L42:    lstore_3 
L43:    aload_0 
L44:    getfield [22] 
L47:    dup 
L48:    astore 5 
L50:    monitorenter 
        .catch [0] from L51 to L108 using L111 
L51:    aload_0 
L52:    getfield [23] 
L55:    iload_2 
L56:    invokeinterface [49] 0 
L61:    aload_0 
L62:    getfield [23] 
L65:    iload_2 
L66:    ifeq L73 
L69:    iconst_1 
L70:    goto L74 
L73:    iconst_0 
L74:    invokeinterface [50] 0 
L79:    aload_0 
L80:    getfield [23] 
L83:    lload_3 
L84:    invokestatic [9] 
L87:    invokeinterface [51] 0 
L92:    aload_0 
L93:    getfield [23] 
L96:    lload_3 
L97:    invokestatic [10] 
L100:   invokeinterface [52] 0 
L105:   aload 5 
L107:   monitorexit 
L108:   goto L119 
        .catch [0] from L111 to L116 using L111 
L111:   astore 6 
L113:   aload 5 
L115:   monitorexit 
L116:   aload 6 
L118:   athrow 
L119:   return 
L120:   
    .end code 
.end method 

.method private static [279] : [280] 
    .attribute [266] .code stack 1 locals 0 
L0:     aload_0 
L1:     ifnull L29 
L4:     aload_0 
L5:     invokevirtual [30] 
L8:     ifnull L29 
L11:    aload_0 
L12:    invokevirtual [31] 
L15:    ifnull L29 
L18:    aload_0 
L19:    getfield [32] 
L22:    ifeq L29 
L25:    iconst_1 
L26:    goto L30 
L29:    iconst_0 
L30:    areturn 
L31:    nop 
L32:    
    .end code 
.end method 

.method private static [281] : [282] 
    .attribute [266] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnonnull L6 
L4:     lconst_0 
L5:     freturn 
L6:     aload_0 
L7:     invokevirtual [30] 
L10:    invokestatic [11] 
L13:    freturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public static [283] : [284] 
    .attribute [266] .code stack 4 locals 2 
L0:     aload_0 
L1:     ifnonnull L6 
L4:     lconst_0 
L5:     freturn 
L6:     aload_0 
L7:     getfield [33] 
L10:    aload_0 
L11:    getfield [34] 
L14:    lsub 
L15:    lstore_1 
L16:    lload_1 
L17:    ldc_w [1] 
L20:    lcmp 
L21:    ifge L26 
L24:    lconst_0 
L25:    freturn 
L26:    lload_1 
L27:    freturn 
L28:    
    .end code 
.end method 

.method public static [285] : [286] 
    .attribute [266] .code stack 4 locals 2 
L0:     aload_0 
L1:     ifnonnull L6 
L4:     lconst_0 
L5:     freturn 
L6:     aload_0 
L7:     getfield [34] 
L10:    aload_1 
L11:    invokevirtual [35] 
L14:    invokeinterface [53] 0 
L19:    lsub 
L20:    lstore_2 
L21:    lload_2 
L22:    aload_0 
L23:    invokestatic [11] 
L26:    ladd 
L27:    freturn 
L28:    
    .end code 
.end method 

.method public static [287] : [288] 
    .attribute [266] .code stack 6 locals 1 
L0:     lload_0 
L1:     lconst_0 
L2:     lcmp 
L3:     ifne L9 
L6:     ldc [12] 
L8:     areturn 
L9:     new [54] 
L12:    dup 
L13:    new [55] 
L16:    dup 
L17:    lload_0 
L18:    invokespecial [40] 
L21:    bipush 7 
L23:    invokespecial [41] 
L26:    astore_2 
L27:    aload_2 
L28:    invokevirtual [36] 
L31:    areturn 
L32:    
    .end code 
.end method 

.method public static [289] : [290] 
    .attribute [266] .code stack 6 locals 1 
L0:     lload_0 
L1:     lconst_0 
L2:     lcmp 
L3:     ifne L9 
L6:     ldc [12] 
L8:     areturn 
L9:     new [54] 
L12:    dup 
L13:    new [55] 
L16:    dup 
L17:    lload_0 
L18:    invokespecial [40] 
L21:    iconst_5 
L22:    invokespecial [41] 
L25:    astore_2 
L26:    aload_2 
L27:    invokevirtual [36] 
L30:    areturn 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [291] : [292] 
    .attribute [266] .code stack 2 locals 2 
L0:     iload_1 
L1:     ifne L63 
L4:     aload_0 
L5:     getfield [22] 
L8:     dup 
L9:     astore_2 
L10:    monitorenter 
        .catch [0] from L11 to L55 using L58 
L11:    aload_0 
L12:    getfield [23] 
L15:    iconst_0 
L16:    invokeinterface [49] 0 
L21:    aload_0 
L22:    getfield [23] 
L25:    iconst_0 
L26:    invokeinterface [50] 0 
L31:    aload_0 
L32:    getfield [23] 
L35:    ldc [12] 
L37:    invokeinterface [51] 0 
L42:    aload_0 
L43:    getfield [23] 
L46:    ldc [12] 
L48:    invokeinterface [52] 0 
L53:    aload_2 
L54:    monitorexit 
L55:    goto L63 
        .catch [0] from L58 to L61 using L58 
L58:    astore_3 
L59:    aload_2 
L60:    monitorexit 
L61:    aload_3 
L62:    athrow 
L63:    return 
L64:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [57] 
.const [3] = Class [58] 
.const [4] = Int 1078071040 
.const [5] = String [59] 
.const [6] = String [60] 
.const [7] = Method [61] [62] 
.const [8] = Method [63] [64] 
.const [9] = Method [65] [66] 
.const [10] = Method [67] [68] 
.const [11] = Method [69] [70] 
.const [12] = String [71] 
.const [13] = Class [72] 
.const [14] = Class [73] 
.const [15] = Class [74] 
.const [16] = Class [75] 
.const [17] = Class [76] 
.const [18] = Class [77] 
.const [19] = Class [78] 
.const [20] = Class [79] 
.const [21] = Class [80] 
.const [22] = Field [81] [82] 
.const [23] = Field [83] [84] 
.const [24] = Method [85] [86] 
.const [25] = Field [87] [88] 
.const [26] = Field [89] [90] 
.const [27] = Method [91] [92] 
.const [28] = Method [93] [94] 
.const [29] = Method [95] [96] 
.const [30] = Method [97] [98] 
.const [31] = Method [99] [100] 
.const [32] = Field [101] [102] 
.const [33] = Field [103] [104] 
.const [34] = Field [105] [106] 
.const [35] = Method [107] [108] 
.const [36] = Method [109] [110] 
.const [37] = Method [111] [112] 
.const [38] = Method [113] [114] 
.const [39] = Method [115] [116] 
.const [40] = Method [117] [118] 
.const [41] = Method [119] [120] 
.const [42] = Class [121] 
.const [43] = Class [122] 
.const [44] = Field [123] [124] 
.const [45] = Field [125] [126] 
.const [46] = Field [127] [128] 
.const [47] = Field [129] [130] 
.const [48] = InterfaceMethod [131] [132] 
.const [49] = InterfaceMethod [133] [134] 
.const [50] = InterfaceMethod [135] [136] 
.const [51] = InterfaceMethod [137] [138] 
.const [52] = InterfaceMethod [139] [140] 
.const [53] = InterfaceMethod [141] [142] 
.const [54] = Class [143] 
.const [55] = Class [144] 
.const [56] = Int 1625948160 
.const [57] = Utf8 de/audi/tghu/navi/app/guidance/SemidynamicRouteGuidance$ModelAccessImpl 
.const [58] = Utf8 java/lang/Object 
.const [59] = Utf8 'SemidynamicRouteGuidance#updateRgRouteCostChangeInformation( %1 ) ' 
.const [60] = Utf8 'SemidynamicRouteGuidance#updateRgRouteCostChangeInformation - not active, ignoring update' 
.const [61] = Class [145] 
.const [62] = NameAndType [146] [147] 
.const [63] = Class [148] 
.const [64] = NameAndType [149] [150] 
.const [65] = Class [151] 
.const [66] = NameAndType [152] [153] 
.const [67] = Class [154] 
.const [68] = NameAndType [155] [156] 
.const [69] = Class [157] 
.const [70] = NameAndType [158] [159] 
.const [71] = Utf8 '- -' 
.const [72] = Utf8 de/audi/atip/metrics/DateMetric 
.const [73] = Utf8 java/util/Date 
.const [74] = Utf8 de/audi/tghu/navi/app/guidance/SemidynamicRouteGuidance 
.const [75] = Utf8 de/audi/tghu/navi/app/guidance/SemidynamicRouteGuidance$ModelAccess 
.const [76] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [77] = Utf8 de/audi/atip/log/LogChannel 
.const [78] = Utf8 org/dsi/ifc/navigation/RgRouteCostChangeInformation 
.const [79] = Utf8 org/dsi/ifc/navigation/CalculatedRouteListElement 
.const [80] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [81] = Class [160] 
.const [82] = NameAndType [161] [162] 
.const [83] = Class [163] 
.const [84] = NameAndType [164] [165] 
.const [85] = Class [166] 
.const [86] = NameAndType [167] [168] 
.const [87] = Class [169] 
.const [88] = NameAndType [170] [171] 
.const [89] = Class [172] 
.const [90] = NameAndType [173] [174] 
.const [91] = Class [175] 
.const [92] = NameAndType [176] [177] 
.const [93] = Class [178] 
.const [94] = NameAndType [179] [180] 
.const [95] = Class [181] 
.const [96] = NameAndType [182] [183] 
.const [97] = Class [184] 
.const [98] = NameAndType [185] [186] 
.const [99] = Class [187] 
.const [100] = NameAndType [188] [189] 
.const [101] = Class [190] 
.const [102] = NameAndType [191] [192] 
.const [103] = Class [193] 
.const [104] = NameAndType [194] [195] 
.const [105] = Class [196] 
.const [106] = NameAndType [197] [198] 
.const [107] = Class [199] 
.const [108] = NameAndType [200] [201] 
.const [109] = Class [202] 
.const [110] = NameAndType [203] [204] 
.const [111] = Class [205] 
.const [112] = NameAndType [206] [207] 
.const [113] = Class [208] 
.const [114] = NameAndType [209] [210] 
.const [115] = Class [211] 
.const [116] = NameAndType [212] [213] 
.const [117] = Class [214] 
.const [118] = NameAndType [215] [216] 
.const [119] = Class [217] 
.const [120] = NameAndType [218] [219] 
.const [121] = Utf8 de/audi/tghu/navi/app/guidance/SemidynamicRouteGuidance$ModelAccessImpl 
.const [122] = Utf8 java/lang/Object 
.const [123] = Class [220] 
.const [124] = NameAndType [221] [222] 
.const [125] = Class [223] 
.const [126] = NameAndType [224] [225] 
.const [127] = Class [226] 
.const [128] = NameAndType [227] [228] 
.const [129] = Class [229] 
.const [130] = NameAndType [230] [231] 
.const [131] = Class [232] 
.const [132] = NameAndType [233] [234] 
.const [133] = Class [235] 
.const [134] = NameAndType [236] [237] 
.const [135] = Class [238] 
.const [136] = NameAndType [239] [240] 
.const [137] = Class [241] 
.const [138] = NameAndType [242] [243] 
.const [139] = Class [244] 
.const [140] = NameAndType [245] [246] 
.const [141] = Class [247] 
.const [142] = NameAndType [248] [249] 
.const [143] = Utf8 de/audi/atip/metrics/DateMetric 
.const [144] = Utf8 java/util/Date 
.const [145] = Utf8 de/audi/tghu/navi/app/guidance/SemidynamicRouteGuidance 
.const [146] = Utf8 isDynamicBypassAvailable 
.const [147] = Utf8 (Lorg/dsi/ifc/navigation/RgRouteCostChangeInformation;)Z 
.const [148] = Utf8 de/audi/tghu/navi/app/guidance/SemidynamicRouteGuidance 
.const [149] = Utf8 getTrafficOffset 
.const [150] = Utf8 (Lorg/dsi/ifc/navigation/RgRouteCostChangeInformation;)J 
.const [151] = Utf8 de/audi/tghu/navi/app/guidance/SemidynamicRouteGuidance 
.const [152] = Utf8 formatDurationShort 
.const [153] = Utf8 (J)Ljava/lang/String; 
.const [154] = Utf8 de/audi/tghu/navi/app/guidance/SemidynamicRouteGuidance 
.const [155] = Utf8 formatDurationLong 
.const [156] = Utf8 (J)Ljava/lang/String; 
.const [157] = Utf8 de/audi/tghu/navi/app/guidance/SemidynamicRouteGuidance 
.const [158] = Utf8 getTrafficOffset 
.const [159] = Utf8 (Lorg/dsi/ifc/navigation/CalculatedRouteListElement;)J 
.const [160] = Utf8 de/audi/tghu/navi/app/guidance/SemidynamicRouteGuidance 
.const [161] = Utf8 modelMonitor 
.const [162] = Utf8 Ljava/lang/Object; 
.const [163] = Utf8 de/audi/tghu/navi/app/guidance/SemidynamicRouteGuidance 
.const [164] = Utf8 modelAccess 
.const [165] = Utf8 Lde/audi/tghu/navi/app/guidance/SemidynamicRouteGuidance$ModelAccess; 
.const [166] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [167] = Utf8 getLogChannel 
.const [168] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [169] = Utf8 de/audi/tghu/navi/app/guidance/SemidynamicRouteGuidance 
.const [170] = Utf8 logChannel 
.const [171] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [172] = Utf8 de/audi/tghu/navi/app/guidance/SemidynamicRouteGuidance 
.const [173] = Utf8 huRegion 
.const [174] = Utf8 I 
.const [175] = Utf8 de/audi/tghu/navi/app/guidance/SemidynamicRouteGuidance 
.const [176] = Utf8 isActive 
.const [177] = Utf8 ()Z 
.const [178] = Utf8 de/audi/atip/log/LogChannel 
.const [179] = Utf8 log 
.const [180] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [181] = Utf8 de/audi/atip/log/LogChannel 
.const [182] = Utf8 log 
.const [183] = Utf8 (ILjava/lang/String;)Z 
.const [184] = Utf8 org/dsi/ifc/navigation/RgRouteCostChangeInformation 
.const [185] = Utf8 getOldRoute 
.const [186] = Utf8 ()Lorg/dsi/ifc/navigation/CalculatedRouteListElement; 
.const [187] = Utf8 org/dsi/ifc/navigation/RgRouteCostChangeInformation 
.const [188] = Utf8 getNewRoute 
.const [189] = Utf8 ()Lorg/dsi/ifc/navigation/CalculatedRouteListElement; 
.const [190] = Utf8 org/dsi/ifc/navigation/RgRouteCostChangeInformation 
.const [191] = Utf8 newRouteRecommended 
.const [192] = Utf8 Z 
.const [193] = Utf8 org/dsi/ifc/navigation/CalculatedRouteListElement 
.const [194] = Utf8 etaWithSpeedAndFlow 
.const [195] = Utf8 J 
.const [196] = Utf8 org/dsi/ifc/navigation/CalculatedRouteListElement 
.const [197] = Utf8 eta 
.const [198] = Utf8 J 
.const [199] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [200] = Utf8 getFramework 
.const [201] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [202] = Utf8 de/audi/atip/metrics/DateMetric 
.const [203] = Utf8 format 
.const [204] = Utf8 ()Ljava/lang/String; 
.const [205] = Utf8 de/audi/tghu/navi/app/guidance/SemidynamicRouteGuidance$ModelAccessImpl 
.const [206] = Utf8 <init> 
.const [207] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;)V 
.const [208] = Utf8 de/audi/tghu/navi/app/guidance/SemidynamicRouteGuidance 
.const [209] = Utf8 <init> 
.const [210] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/tghu/navi/app/guidance/SemidynamicRouteGuidance$ModelAccess;)V 
.const [211] = Utf8 java/lang/Object 
.const [212] = Utf8 <init> 
.const [213] = Utf8 ()V 
.const [214] = Utf8 java/util/Date 
.const [215] = Utf8 <init> 
.const [216] = Utf8 (J)V 
.const [217] = Utf8 de/audi/atip/metrics/DateMetric 
.const [218] = Utf8 <init> 
.const [219] = Utf8 (Ljava/util/Date;I)V 
.const [220] = Utf8 de/audi/tghu/navi/app/guidance/SemidynamicRouteGuidance 
.const [221] = Utf8 modelMonitor 
.const [222] = Utf8 Ljava/lang/Object; 
.const [223] = Utf8 de/audi/tghu/navi/app/guidance/SemidynamicRouteGuidance 
.const [224] = Utf8 modelAccess 
.const [225] = Utf8 Lde/audi/tghu/navi/app/guidance/SemidynamicRouteGuidance$ModelAccess; 
.const [226] = Utf8 de/audi/tghu/navi/app/guidance/SemidynamicRouteGuidance 
.const [227] = Utf8 logChannel 
.const [228] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [229] = Utf8 de/audi/tghu/navi/app/guidance/SemidynamicRouteGuidance 
.const [230] = Utf8 huRegion 
.const [231] = Utf8 I 
.const [232] = Utf8 de/audi/tghu/navi/app/guidance/SemidynamicRouteGuidance$ModelAccess 
.const [233] = Utf8 isDynamicBypassAvailable 
.const [234] = Utf8 ()Z 
.const [235] = Utf8 de/audi/tghu/navi/app/guidance/SemidynamicRouteGuidance$ModelAccess 
.const [236] = Utf8 setDynamicBypassAvailable 
.const [237] = Utf8 (Z)V 
.const [238] = Utf8 de/audi/tghu/navi/app/guidance/SemidynamicRouteGuidance$ModelAccess 
.const [239] = Utf8 setSidebarButtonMode 
.const [240] = Utf8 (I)V 
.const [241] = Utf8 de/audi/tghu/navi/app/guidance/SemidynamicRouteGuidance$ModelAccess 
.const [242] = Utf8 setTrafficOffsetShort 
.const [243] = Utf8 (Ljava/lang/String;)V 
.const [244] = Utf8 de/audi/tghu/navi/app/guidance/SemidynamicRouteGuidance$ModelAccess 
.const [245] = Utf8 setTrafficOffsetLong 
.const [246] = Utf8 (Ljava/lang/String;)V 
.const [247] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [248] = Utf8 getKombiTime 
.const [249] = Utf8 ()J 
.const [250] = Utf8 de/audi/tghu/navi/app/guidance/SemidynamicRouteGuidance 
.const [251] = Class [250] 
.const [252] = Utf8 java/lang/Object 
.const [253] = Class [252] 
.const [254] = Utf8 NO_DURATION 
.const [255] = Utf8 Ljava/lang/String; 
.const [256] = Utf8 TRAFFIC_OFFSET_THRESHOLD 
.const [257] = Utf8 J 
.const [258] = Utf8 logChannel 
.const [259] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [260] = Utf8 huRegion 
.const [261] = Utf8 I 
.const [262] = Utf8 modelAccess 
.const [263] = Utf8 Lde/audi/tghu/navi/app/guidance/SemidynamicRouteGuidance$ModelAccess; 
.const [264] = Utf8 modelMonitor 
.const [265] = Utf8 Ljava/lang/Object; 
.const [266] = Utf8 Code 
.const [267] = Utf8 <init> 
.const [268] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;)V 
.const [269] = Utf8 <init> 
.const [270] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/tghu/navi/app/guidance/SemidynamicRouteGuidance$ModelAccess;)V 
.const [271] = Utf8 setHURegion 
.const [272] = Utf8 (I)V 
.const [273] = Utf8 isActive 
.const [274] = Utf8 ()Z 
.const [275] = Utf8 isDynamicBypassAvailable 
.const [276] = Utf8 ()Z 
.const [277] = Utf8 updateRgRouteCostChangeInformation 
.const [278] = Utf8 (Lorg/dsi/ifc/navigation/RgRouteCostChangeInformation;)V 
.const [279] = Utf8 isDynamicBypassAvailable 
.const [280] = Utf8 (Lorg/dsi/ifc/navigation/RgRouteCostChangeInformation;)Z 
.const [281] = Utf8 getTrafficOffset 
.const [282] = Utf8 (Lorg/dsi/ifc/navigation/RgRouteCostChangeInformation;)J 
.const [283] = Utf8 getTrafficOffset 
.const [284] = Utf8 (Lorg/dsi/ifc/navigation/CalculatedRouteListElement;)J 
.const [285] = Utf8 getRttWithTrafficOffset 
.const [286] = Utf8 (Lorg/dsi/ifc/navigation/CalculatedRouteListElement;Lde/audi/tghu/navi/app/NavigationEnv;)J 
.const [287] = Utf8 formatDurationShort 
.const [288] = Utf8 (J)Ljava/lang/String; 
.const [289] = Utf8 formatDurationLong 
.const [290] = Utf8 (J)Ljava/lang/String; 
.const [291] = Utf8 updateRgActive 
.const [292] = Utf8 (Z)V 
.end class 
