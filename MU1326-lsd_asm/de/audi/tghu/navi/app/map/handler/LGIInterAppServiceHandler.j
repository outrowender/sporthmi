.version 50 0 
.class public super [284] 
.super [286] 
.implements [288] 
.field private final [289] [290] 
.field private final [291] [292] 
.field private final [293] [294] 
.field private final [295] [296] 
.field private static final [297] [298] 
.field private [299] [300] 

.method public [302] : [303] 
    .attribute [301] .code stack 6 locals 0 
L0:     aload_0 
L1:     invokespecial [45] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [53] 
L9:     aload_0 
L10:    aload_1 
L11:    invokevirtual [33] 
L14:    putfield [54] 
L17:    aload_0 
L18:    new [55] 
L21:    dup 
L22:    invokespecial [46] 
L25:    putfield [56] 
L28:    aload_0 
L29:    aload_1 
L30:    invokevirtual [36] 
L33:    invokeinterface [57] 0 
L38:    ldc [3] 
L40:    new [58] 
L43:    dup 
L44:    aload_0 
L45:    getfield [34] 
L48:    invokespecial [47] 
L51:    invokeinterface [59] 0 
L56:    putfield [60] 
L59:    aload_0 
L60:    getfield [37] 
L63:    invokevirtual [38] 
L66:    aload_0 
L67:    aconst_null 
L68:    putfield [52] 
L71:    return 
L72:    
    .end code 
.end method 

.method public [304] : [305] 
    .attribute [301] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L5 
L4:     return 
L5:     aload_0 
L6:     getfield [35] 
L9:     dup 
L10:    astore_2 
L11:    monitorenter 
        .catch [0] from L12 to L50 using L53 
L12:    aload_0 
L13:    getfield [35] 
L16:    aload_1 
L17:    invokeinterface [61] 0 
L22:    ifne L48 
L25:    aload_0 
L26:    getfield [34] 
L29:    ldc [5] 
L31:    ldc [6] 
L33:    invokevirtual [39] 
L36:    pop 
L37:    aload_0 
L38:    getfield [35] 
L41:    aload_1 
L42:    invokeinterface [62] 0 
L47:    pop 
L48:    aload_2 
L49:    monitorexit 
L50:    goto L58 
        .catch [0] from L53 to L56 using L53 
L53:    astore_3 
L54:    aload_2 
L55:    monitorexit 
L56:    aload_3 
L57:    athrow 
L58:    aload_0 
L59:    aload_1 
L60:    invokespecial [48] 
L63:    return 
L64:    
    .end code 
.end method 

.method public [306] : [307] 
    .attribute [301] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L5 
L4:     return 
L5:     aload_0 
L6:     getfield [35] 
L9:     dup 
L10:    astore_2 
L11:    monitorenter 
        .catch [0] from L12 to L50 using L53 
L12:    aload_0 
L13:    getfield [35] 
L16:    aload_1 
L17:    invokeinterface [61] 0 
L22:    ifeq L48 
L25:    aload_0 
L26:    getfield [34] 
L29:    ldc [5] 
L31:    ldc [7] 
L33:    invokevirtual [39] 
L36:    pop 
L37:    aload_0 
L38:    getfield [35] 
L41:    aload_1 
L42:    invokeinterface [63] 0 
L47:    pop 
L48:    aload_2 
L49:    monitorexit 
L50:    goto L58 
        .catch [0] from L53 to L56 using L53 
L53:    astore_3 
L54:    aload_2 
L55:    monitorexit 
L56:    aload_3 
L57:    athrow 
L58:    return 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [308] : [309] 
    .attribute [301] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [34] 
L4:     ldc [5] 
L6:     ldc [8] 
L8:     invokevirtual [39] 
L11:    pop 
L12:    aload_0 
L13:    getfield [35] 
L16:    invokeinterface [64] 0 
L21:    aload_0 
L22:    getfield [37] 
L25:    invokevirtual [40] 
L28:    aload_0 
L29:    getfield [32] 
L32:    invokevirtual [36] 
L35:    invokeinterface [57] 0 
L40:    ldc [3] 
L42:    invokeinterface [65] 0 
L47:    aload_0 
L48:    aconst_null 
L49:    putfield [52] 
L52:    return 
L53:    nop 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [310] : [311] 
    .attribute [301] .code stack 7 locals 3 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [52] 
L5:     aload_1 
L6:     ifnonnull L23 
L9:     aload_0 
L10:    getfield [34] 
L13:    sipush 10000 
L16:    ldc [9] 
L18:    invokevirtual [39] 
L21:    pop 
L22:    return 
L23:    aload_0 
L24:    getfield [35] 
L27:    dup 
L28:    astore_3 
L29:    monitorenter 
        .catch [0] from L30 to L60 using L63 
L30:    aload_0 
L31:    getfield [35] 
L34:    aload_0 
L35:    getfield [35] 
L38:    invokeinterface [66] 0 
L43:    anewarray [10] 
L46:    invokeinterface [67] 0 
L51:    checkcast [11] 
L54:    checkcast [11] 
L57:    astore_2 
L58:    aload_3 
L59:    monitorexit 
L60:    goto L70 
        .catch [0] from L63 to L67 using L63 
L63:    astore 4 
L65:    aload_3 
L66:    monitorexit 
L67:    aload 4 
L69:    athrow 
L70:    aload_0 
L71:    getfield [34] 
L74:    ldc [5] 
L76:    ldc [12] 
L78:    aload_1 
L79:    arraylength 
L80:    i2l 
L81:    aload_2 
L82:    arraylength 
L83:    i2l 
L84:    invokevirtual [41] 
L87:    pop 
L88:    iconst_0 
L89:    istore_3 
L90:    iload_3 
L91:    aload_2 
L92:    arraylength 
L93:    if_icmpge L146 
        .catch [14] from L96 to L120 using L123 
L96:    aload_2 
L97:    iload_3 
L98:    aaload 
L99:    astore 4 
L101:   aload_0 
L102:   getfield [37] 
L105:   new [68] 
L108:   dup 
L109:   aload_0 
L110:   aload 4 
L112:   aload_1 
L113:   invokespecial [49] 
L116:   invokevirtual [42] 
L119:   pop 
L120:   goto L140 
L123:   astore 4 
L125:   aload_0 
L126:   getfield [34] 
L129:   sipush 10000 
L132:   ldc [15] 
L134:   aload 4 
L136:   invokevirtual [43] 
L139:   pop 
L140:   iinc 3 1 
L143:   goto L90 
L146:   return 
L147:   nop 
L148:   
    .end code 
.end method 

.method private [312] : [313] 
    .attribute [301] .code stack 5 locals 2 
L0:     aload_1 
L1:     ifnonnull L5 
L4:     return 
L5:     aload_0 
L6:     getfield [31] 
L9:     ifnonnull L25 
L12:    aload_0 
L13:    getfield [34] 
L16:    ldc [5] 
L18:    ldc [16] 
L20:    invokevirtual [39] 
L23:    pop 
L24:    return 
L25:    new [69] 
L28:    dup 
L29:    ldc [18] 
L31:    invokespecial [50] 
L34:    astore_2 
L35:    aload_2 
L36:    aload_0 
L37:    getfield [31] 
L40:    invokestatic [19] 
L43:    aload_0 
L44:    getfield [34] 
L47:    ldc [5] 
L49:    ldc [20] 
L51:    aload_2 
L52:    invokevirtual [44] 
L55:    pop 
        .catch [14] from L56 to L73 using L76 
L56:    aload_0 
L57:    getfield [37] 
L60:    new [70] 
L63:    dup 
L64:    aload_0 
L65:    aload_1 
L66:    invokespecial [51] 
L69:    invokevirtual [42] 
L72:    pop 
L73:    goto L91 
L76:    astore_3 
L77:    aload_0 
L78:    getfield [34] 
L81:    sipush 10000 
L84:    ldc [20] 
L86:    aload_3 
L87:    invokevirtual [43] 
L90:    pop 
L91:    return 
L92:    
    .end code 
.end method 

.method static synthetic [314] : [315] 
    .attribute [301] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [31] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [71] 
.const [3] = String [72] 
.const [4] = Class [73] 
.const [5] = Int 1078071040 
.const [6] = String [74] 
.const [7] = String [75] 
.const [8] = String [76] 
.const [9] = String [77] 
.const [10] = Class [78] 
.const [11] = Class [79] 
.const [12] = String [80] 
.const [13] = Class [81] 
.const [14] = Class [82] 
.const [15] = String [83] 
.const [16] = String [84] 
.const [17] = Class [85] 
.const [18] = String [86] 
.const [19] = Method [87] [88] 
.const [20] = String [89] 
.const [21] = Class [90] 
.const [22] = Class [91] 
.const [23] = Class [92] 
.const [24] = Class [93] 
.const [25] = Class [94] 
.const [26] = Class [95] 
.const [27] = Class [96] 
.const [28] = Class [97] 
.const [29] = Class [98] 
.const [30] = Class [99] 
.const [31] = Field [100] [101] 
.const [32] = Field [102] [103] 
.const [33] = Method [104] [105] 
.const [34] = Field [106] [107] 
.const [35] = Field [108] [109] 
.const [36] = Method [110] [111] 
.const [37] = Field [112] [113] 
.const [38] = Method [114] [115] 
.const [39] = Method [116] [117] 
.const [40] = Method [118] [119] 
.const [41] = Method [120] [121] 
.const [42] = Method [122] [123] 
.const [43] = Method [124] [125] 
.const [44] = Method [126] [127] 
.const [45] = Method [128] [129] 
.const [46] = Method [130] [131] 
.const [47] = Method [132] [133] 
.const [48] = Method [134] [135] 
.const [49] = Method [136] [137] 
.const [50] = Method [138] [139] 
.const [51] = Method [140] [141] 
.const [52] = Field [142] [143] 
.const [53] = Field [144] [145] 
.const [54] = Field [146] [147] 
.const [55] = Class [148] 
.const [56] = Field [149] [150] 
.const [57] = InterfaceMethod [151] [152] 
.const [58] = Class [153] 
.const [59] = InterfaceMethod [154] [155] 
.const [60] = Field [156] [157] 
.const [61] = InterfaceMethod [158] [159] 
.const [62] = InterfaceMethod [160] [161] 
.const [63] = InterfaceMethod [162] [163] 
.const [64] = InterfaceMethod [164] [165] 
.const [65] = InterfaceMethod [166] [167] 
.const [66] = InterfaceMethod [168] [169] 
.const [67] = InterfaceMethod [170] [171] 
.const [68] = Class [172] 
.const [69] = Class [173] 
.const [70] = Class [174] 
.const [71] = Utf8 java/util/ArrayList 
.const [72] = Utf8 LGINavDispatcher 
.const [73] = Utf8 de/audi/atip/job/JobLogger 
.const [74] = Utf8 'LGIInterAppServiceHandler#addListener() - Register listener' 
.const [75] = Utf8 'LGIInterAppServiceHandler#removeListener() - Unregister listener' 
.const [76] = Utf8 'LGIInterAppServiceHandler#cleanUp()' 
.const [77] = Utf8 'LGIInterAppServiceHandler#updateLocalHazardInformation() - Invalid parameter set!' 
.const [78] = Utf8 de/audi/atip/interapp/navcar/ILGIServiceListener 
.const [79] = Utf8 [Lde/audi/atip/interapp/navcar/ILGIServiceListener; 
.const [80] = Utf8 'LGIInterAppServiceHandler#updateLocalHazardInformation() - events: %1, listeners: %2' 
.const [81] = Utf8 de/audi/tghu/navi/app/map/handler/LGIInterAppServiceHandler$1 
.const [82] = Utf8 java/lang/Exception 
.const [83] = Utf8 'LGIInterAppServiceHandler#updateLocalHazardInformation() - %1' 
.const [84] = Utf8 'LGIInterAppServiceHandler#provideLastReceivedUpdate() - Did not receive any update yet' 
.const [85] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [86] = Utf8 LocalHazardInformation 
.const [87] = Class [175] 
.const [88] = NameAndType [176] [177] 
.const [89] = Utf8 'LGIInterAppServiceHandler#provideLastReceivedUpdate() - %1' 
.const [90] = Utf8 de/audi/tghu/navi/app/map/handler/LGIInterAppServiceHandler$2 
.const [91] = Utf8 de/audi/tghu/navi/app/map/handler/LGIInterAppServiceHandler 
.const [92] = Utf8 java/lang/Object 
.const [93] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [94] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [95] = Utf8 de/esolutions/fw/util/commons/job/IDispatcherManager 
.const [96] = Utf8 de/esolutions/fw/util/commons/job/DispatcherBase 
.const [97] = Utf8 java/util/List 
.const [98] = Utf8 de/audi/atip/log/LogChannel 
.const [99] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [100] = Class [178] 
.const [101] = NameAndType [179] [180] 
.const [102] = Class [181] 
.const [103] = NameAndType [182] [183] 
.const [104] = Class [184] 
.const [105] = NameAndType [185] [186] 
.const [106] = Class [187] 
.const [107] = NameAndType [188] [189] 
.const [108] = Class [190] 
.const [109] = NameAndType [191] [192] 
.const [110] = Class [193] 
.const [111] = NameAndType [194] [195] 
.const [112] = Class [196] 
.const [113] = NameAndType [197] [198] 
.const [114] = Class [199] 
.const [115] = NameAndType [200] [201] 
.const [116] = Class [202] 
.const [117] = NameAndType [203] [204] 
.const [118] = Class [205] 
.const [119] = NameAndType [206] [207] 
.const [120] = Class [208] 
.const [121] = NameAndType [209] [210] 
.const [122] = Class [211] 
.const [123] = NameAndType [212] [213] 
.const [124] = Class [214] 
.const [125] = NameAndType [215] [216] 
.const [126] = Class [217] 
.const [127] = NameAndType [218] [219] 
.const [128] = Class [220] 
.const [129] = NameAndType [221] [222] 
.const [130] = Class [223] 
.const [131] = NameAndType [224] [225] 
.const [132] = Class [226] 
.const [133] = NameAndType [227] [228] 
.const [134] = Class [229] 
.const [135] = NameAndType [230] [231] 
.const [136] = Class [232] 
.const [137] = NameAndType [233] [234] 
.const [138] = Class [235] 
.const [139] = NameAndType [236] [237] 
.const [140] = Class [238] 
.const [141] = NameAndType [239] [240] 
.const [142] = Class [241] 
.const [143] = NameAndType [242] [243] 
.const [144] = Class [244] 
.const [145] = NameAndType [245] [246] 
.const [146] = Class [247] 
.const [147] = NameAndType [248] [249] 
.const [148] = Utf8 java/util/ArrayList 
.const [149] = Class [250] 
.const [150] = NameAndType [251] [252] 
.const [151] = Class [253] 
.const [152] = NameAndType [254] [255] 
.const [153] = Utf8 de/audi/atip/job/JobLogger 
.const [154] = Class [256] 
.const [155] = NameAndType [257] [258] 
.const [156] = Class [259] 
.const [157] = NameAndType [260] [261] 
.const [158] = Class [262] 
.const [159] = NameAndType [263] [264] 
.const [160] = Class [265] 
.const [161] = NameAndType [266] [267] 
.const [162] = Class [268] 
.const [163] = NameAndType [269] [270] 
.const [164] = Class [271] 
.const [165] = NameAndType [272] [273] 
.const [166] = Class [274] 
.const [167] = NameAndType [275] [276] 
.const [168] = Class [277] 
.const [169] = NameAndType [278] [279] 
.const [170] = Class [280] 
.const [171] = NameAndType [281] [282] 
.const [172] = Utf8 de/audi/tghu/navi/app/map/handler/LGIInterAppServiceHandler$1 
.const [173] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [174] = Utf8 de/audi/tghu/navi/app/map/handler/LGIInterAppServiceHandler$2 
.const [175] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [176] = Utf8 appendObjectArray 
.const [177] = Utf8 (Lde/esolutions/fw/util/commons/Buffer;[Ljava/lang/Object;)V 
.const [178] = Utf8 de/audi/tghu/navi/app/map/handler/LGIInterAppServiceHandler 
.const [179] = Utf8 lastReceivedLGIEvents 
.const [180] = Utf8 [Lorg/dsi/ifc/tmc/LocalHazardInformation; 
.const [181] = Utf8 de/audi/tghu/navi/app/map/handler/LGIInterAppServiceHandler 
.const [182] = Utf8 env 
.const [183] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [184] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [185] = Utf8 getLogChannel 
.const [186] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [187] = Utf8 de/audi/tghu/navi/app/map/handler/LGIInterAppServiceHandler 
.const [188] = Utf8 logChannel 
.const [189] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [190] = Utf8 de/audi/tghu/navi/app/map/handler/LGIInterAppServiceHandler 
.const [191] = Utf8 listeners 
.const [192] = Utf8 Ljava/util/List; 
.const [193] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [194] = Utf8 getFramework 
.const [195] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [196] = Utf8 de/audi/tghu/navi/app/map/handler/LGIInterAppServiceHandler 
.const [197] = Utf8 dispatcher 
.const [198] = Utf8 Lde/esolutions/fw/util/commons/job/DispatcherBase; 
.const [199] = Utf8 de/esolutions/fw/util/commons/job/DispatcherBase 
.const [200] = Utf8 start 
.const [201] = Utf8 ()V 
.const [202] = Utf8 de/audi/atip/log/LogChannel 
.const [203] = Utf8 log 
.const [204] = Utf8 (ILjava/lang/String;)Z 
.const [205] = Utf8 de/esolutions/fw/util/commons/job/DispatcherBase 
.const [206] = Utf8 stop 
.const [207] = Utf8 ()V 
.const [208] = Utf8 de/audi/atip/log/LogChannel 
.const [209] = Utf8 log 
.const [210] = Utf8 (ILjava/lang/String;JJ)Z 
.const [211] = Utf8 de/esolutions/fw/util/commons/job/DispatcherBase 
.const [212] = Utf8 execute 
.const [213] = Utf8 (Ljava/lang/Object;)Lde/esolutions/fw/util/commons/job/Job; 
.const [214] = Utf8 de/audi/atip/log/LogChannel 
.const [215] = Utf8 log 
.const [216] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [217] = Utf8 de/audi/atip/log/LogChannel 
.const [218] = Utf8 log 
.const [219] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [220] = Utf8 java/lang/Object 
.const [221] = Utf8 <init> 
.const [222] = Utf8 ()V 
.const [223] = Utf8 java/util/ArrayList 
.const [224] = Utf8 <init> 
.const [225] = Utf8 ()V 
.const [226] = Utf8 de/audi/atip/job/JobLogger 
.const [227] = Utf8 <init> 
.const [228] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [229] = Utf8 de/audi/tghu/navi/app/map/handler/LGIInterAppServiceHandler 
.const [230] = Utf8 provideLastReceivedUpdate 
.const [231] = Utf8 (Lde/audi/atip/interapp/navcar/ILGIServiceListener;)V 
.const [232] = Utf8 de/audi/tghu/navi/app/map/handler/LGIInterAppServiceHandler$1 
.const [233] = Utf8 <init> 
.const [234] = Utf8 (Lde/audi/tghu/navi/app/map/handler/LGIInterAppServiceHandler;Lde/audi/atip/interapp/navcar/ILGIServiceListener;[Lorg/dsi/ifc/tmc/LocalHazardInformation;)V 
.const [235] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [236] = Utf8 <init> 
.const [237] = Utf8 (Ljava/lang/String;)V 
.const [238] = Utf8 de/audi/tghu/navi/app/map/handler/LGIInterAppServiceHandler$2 
.const [239] = Utf8 <init> 
.const [240] = Utf8 (Lde/audi/tghu/navi/app/map/handler/LGIInterAppServiceHandler;Lde/audi/atip/interapp/navcar/ILGIServiceListener;)V 
.const [241] = Utf8 de/audi/tghu/navi/app/map/handler/LGIInterAppServiceHandler 
.const [242] = Utf8 lastReceivedLGIEvents 
.const [243] = Utf8 [Lorg/dsi/ifc/tmc/LocalHazardInformation; 
.const [244] = Utf8 de/audi/tghu/navi/app/map/handler/LGIInterAppServiceHandler 
.const [245] = Utf8 env 
.const [246] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [247] = Utf8 de/audi/tghu/navi/app/map/handler/LGIInterAppServiceHandler 
.const [248] = Utf8 logChannel 
.const [249] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [250] = Utf8 de/audi/tghu/navi/app/map/handler/LGIInterAppServiceHandler 
.const [251] = Utf8 listeners 
.const [252] = Utf8 Ljava/util/List; 
.const [253] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [254] = Utf8 getDispatcherManager 
.const [255] = Utf8 ()Lde/esolutions/fw/util/commons/job/IDispatcherManager; 
.const [256] = Utf8 de/esolutions/fw/util/commons/job/IDispatcherManager 
.const [257] = Utf8 createDispatcher 
.const [258] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/commons/job/IJobLogger;)Lde/esolutions/fw/util/commons/job/DispatcherBase; 
.const [259] = Utf8 de/audi/tghu/navi/app/map/handler/LGIInterAppServiceHandler 
.const [260] = Utf8 dispatcher 
.const [261] = Utf8 Lde/esolutions/fw/util/commons/job/DispatcherBase; 
.const [262] = Utf8 java/util/List 
.const [263] = Utf8 contains 
.const [264] = Utf8 (Ljava/lang/Object;)Z 
.const [265] = Utf8 java/util/List 
.const [266] = Utf8 add 
.const [267] = Utf8 (Ljava/lang/Object;)Z 
.const [268] = Utf8 java/util/List 
.const [269] = Utf8 remove 
.const [270] = Utf8 (Ljava/lang/Object;)Z 
.const [271] = Utf8 java/util/List 
.const [272] = Utf8 clear 
.const [273] = Utf8 ()V 
.const [274] = Utf8 de/esolutions/fw/util/commons/job/IDispatcherManager 
.const [275] = Utf8 destroyDispatcher 
.const [276] = Utf8 (Ljava/lang/String;)V 
.const [277] = Utf8 java/util/List 
.const [278] = Utf8 size 
.const [279] = Utf8 ()I 
.const [280] = Utf8 java/util/List 
.const [281] = Utf8 toArray 
.const [282] = Utf8 ([Ljava/lang/Object;)[Ljava/lang/Object; 
.const [283] = Utf8 de/audi/tghu/navi/app/map/handler/LGIInterAppServiceHandler 
.const [284] = Class [283] 
.const [285] = Utf8 java/lang/Object 
.const [286] = Class [285] 
.const [287] = Utf8 de/audi/atip/interapp/navcar/ILGIServiceListener 
.const [288] = Class [287] 
.const [289] = Utf8 env 
.const [290] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [291] = Utf8 logChannel 
.const [292] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [293] = Utf8 listeners 
.const [294] = Utf8 Ljava/util/List; 
.const [295] = Utf8 dispatcher 
.const [296] = Utf8 Lde/esolutions/fw/util/commons/job/DispatcherBase; 
.const [297] = Utf8 LGI_NAV_DISPATCHER 
.const [298] = Utf8 Ljava/lang/String; 
.const [299] = Utf8 lastReceivedLGIEvents 
.const [300] = Utf8 [Lorg/dsi/ifc/tmc/LocalHazardInformation; 
.const [301] = Utf8 Code 
.const [302] = Utf8 <init> 
.const [303] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;)V 
.const [304] = Utf8 addListener 
.const [305] = Utf8 (Lde/audi/atip/interapp/navcar/ILGIServiceListener;)V 
.const [306] = Utf8 removeListener 
.const [307] = Utf8 (Lde/audi/atip/interapp/navcar/ILGIServiceListener;)V 
.const [308] = Utf8 cleanUp 
.const [309] = Utf8 ()V 
.const [310] = Utf8 updateLocalHazardInformation 
.const [311] = Utf8 ([Lorg/dsi/ifc/tmc/LocalHazardInformation;)V 
.const [312] = Utf8 provideLastReceivedUpdate 
.const [313] = Utf8 (Lde/audi/atip/interapp/navcar/ILGIServiceListener;)V 
.const [314] = Utf8 access$000 
.const [315] = Utf8 (Lde/audi/tghu/navi/app/map/handler/LGIInterAppServiceHandler;)[Lorg/dsi/ifc/tmc/LocalHazardInformation; 
.end class 
