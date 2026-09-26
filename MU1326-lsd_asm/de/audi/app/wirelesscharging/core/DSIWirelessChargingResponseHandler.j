.version 50 0 
.class public super [476] 
.super [478] 
.implements [480] 
.field private final [481] [482] 
.field private final [483] [484] 
.field private final [485] [486] 
.field private final [487] [488] 
.field private final [489] [490] 
.field private volatile [491] [492] 
.field private volatile [493] [494] 
.field static synthetic [495] [496] 
.field static synthetic [497] [498] 
.field static synthetic [499] [500] 

.method public [502] : [503] 
    .attribute [501] .code stack 11 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [5] 
L4:     invokespecial [69] 
L7:     aload_0 
L8:     iconst_1 
L9:     putfield [88] 
L12:    aload_0 
L13:    iconst_1 
L14:    putfield [92] 
L17:    aload_0 
L18:    aload_1 
L19:    putfield [93] 
L22:    aload_0 
L23:    aload_2 
L24:    putfield [89] 
L27:    aload_0 
L28:    aload_3 
L29:    putfield [90] 
L32:    aload_0 
L33:    new [94] 
L36:    dup 
L37:    aload_1 
L38:    invokeinterface [95] 0 
L43:    getstatic [7] 
L46:    ifnonnull L61 
L49:    ldc [8] 
L51:    invokestatic [9] 
L54:    dup 
L55:    putstatic [70] 
L58:    goto L64 
L61:    getstatic [7] 
L64:    invokevirtual [53] 
L67:    getstatic [10] 
L70:    ifnonnull L85 
L73:    ldc [11] 
L75:    invokestatic [9] 
L78:    dup 
L79:    putstatic [71] 
L82:    goto L88 
L85:    getstatic [10] 
L88:    invokevirtual [53] 
L91:    new [96] 
L94:    dup 
L95:    iconst_0 
L96:    invokespecial [72] 
L99:    aload_0 
L100:   new [97] 
L103:   dup 
L104:   aload_0 
L105:   invokespecial [73] 
L108:   invokespecial [74] 
L111:   putfield [98] 
L114:   aload_0 
L115:   new [99] 
L118:   dup 
L119:   getstatic [15] 
L122:   ifnonnull L137 
L125:   ldc [16] 
L127:   invokestatic [9] 
L130:   dup 
L131:   putstatic [75] 
L134:   goto L140 
L137:   getstatic [15] 
L140:   invokevirtual [53] 
L143:   new [100] 
L146:   dup 
L147:   aload_0 
L148:   aconst_null 
L149:   invokespecial [76] 
L152:   new [101] 
L155:   dup 
L156:   iconst_0 
L157:   invokespecial [77] 
L160:   aload_0 
L161:   getfield [52] 
L164:   invokeinterface [102] 0 
L169:   aload_3 
L170:   invokespecial [78] 
L173:   putfield [103] 
L176:   return 
L177:   nop 
L178:   nop 
L179:   nop 
L180:   
    .end code 
.end method 

.method public [504] : [505] 
    .attribute [501] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [79] 
L4:     aload_0 
L5:     getfield [54] 
L8:     aload_0 
L9:     invokevirtual [56] 
L12:    invokeinterface [102] 0 
L17:    invokevirtual [57] 
L20:    aload_0 
L21:    invokevirtual [56] 
L24:    new [104] 
L27:    dup 
L28:    aload_0 
L29:    invokespecial [80] 
L32:    invokeinterface [105] 0 
L37:    aload_0 
L38:    getfield [55] 
L41:    invokevirtual [58] 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [506] : [507] 
    .attribute [501] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [81] 
L4:     aload_0 
L5:     getfield [54] 
L8:     aload_0 
L9:     invokevirtual [56] 
L12:    invokeinterface [102] 0 
L17:    invokevirtual [59] 
L20:    aload_0 
L21:    getfield [55] 
L24:    invokevirtual [60] 
L27:    return 
L28:    
    .end code 
.end method 

.method private static [508] : [509] 
    .attribute [501] .code stack 2 locals 1 
L0:     new [106] 
L3:     dup 
L4:     invokespecial [82] 
L7:     ldc [21] 
L9:     invokevirtual [61] 
L12:    iload_0 
L13:    invokevirtual [62] 
L16:    invokevirtual [63] 
L19:    astore_1 
L20:    iload_0 
L21:    tableswitch 0 
            L72 
            L60 
            L66 
            L78 
            L90 
            L84 
            default : L96 

L60:    ldc [22] 
L62:    astore_1 
L63:    goto L96 
L66:    ldc [23] 
L68:    astore_1 
L69:    goto L96 
L72:    ldc [24] 
L74:    astore_1 
L75:    goto L96 
L78:    ldc [25] 
L80:    astore_1 
L81:    goto L96 
L84:    ldc [26] 
L86:    astore_1 
L87:    goto L96 
L90:    ldc [27] 
L92:    astore_1 
L93:    goto L96 
L96:    aload_1 
L97:    areturn 
L98:    nop 
L99:    nop 
L100:   
    .end code 
.end method 

.method public [510] : [511] 
    .attribute [501] .code stack 4 locals 0 
L0:     iload_2 
L1:     iconst_1 
L2:     if_icmpne L80 
L5:     aload_0 
L6:     getfield [49] 
L9:     ldc [28] 
L11:    ldc [29] 
L13:    iload_1 
L14:    invokestatic [30] 
L17:    invokevirtual [64] 
L20:    pop 
L21:    aload_0 
L22:    aload_0 
L23:    getfield [47] 
L26:    putfield [92] 
L29:    aload_0 
L30:    iload_1 
L31:    putfield [88] 
L34:    aload_0 
L35:    getfield [48] 
L38:    iload_1 
L39:    invokeinterface [107] 0 
L44:    aload_0 
L45:    getfield [52] 
L48:    invokeinterface [108] 0 
L53:    ifne L61 
L56:    iload_1 
L57:    iconst_3 
L58:    if_icmpne L68 
L61:    aload_0 
L62:    invokespecial [83] 
L65:    goto L80 
L68:    aload_0 
L69:    getfield [49] 
L72:    ldc [28] 
L74:    ldc [31] 
L76:    invokevirtual [65] 
L79:    pop 
L80:    return 
L81:    nop 
L82:    nop 
L83:    nop 
L84:    
    .end code 
.end method 

.method private [512] : [513] 
    .attribute [501] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [49] 
L4:     ldc [28] 
L6:     ldc [32] 
L8:     invokevirtual [65] 
L11:    pop 
L12:    aload_0 
L13:    getfield [47] 
L16:    tableswitch 0 
            L77 
            L77 
            L77 
            L63 
            L56 
            L70 
            default : L84 

L56:    aload_0 
L57:    invokespecial [84] 
L60:    goto L104 
L63:    aload_0 
L64:    invokespecial [85] 
L67:    goto L104 
L70:    aload_0 
L71:    invokespecial [86] 
L74:    goto L104 
L77:    aload_0 
L78:    invokespecial [87] 
L81:    goto L104 
L84:    aload_0 
L85:    getfield [49] 
L88:    sipush 10000 
L91:    ldc [33] 
L93:    aload_0 
L94:    getfield [47] 
L97:    invokestatic [30] 
L100:   invokevirtual [64] 
L103:   pop 
L104:   return 
L105:   nop 
L106:   nop 
L107:   nop 
L108:   
    .end code 
.end method 

.method private [514] : [515] 
    .attribute [501] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [49] 
L4:     ldc [28] 
L6:     ldc [34] 
L8:     aload_0 
L9:     getfield [47] 
L12:    invokestatic [30] 
L15:    invokevirtual [64] 
L18:    pop 
L19:    aload_0 
L20:    getfield [51] 
L23:    iconst_1 
L24:    if_icmpeq L34 
L27:    aload_0 
L28:    getfield [51] 
L31:    ifne L46 
L34:    aload_0 
L35:    getfield [48] 
L38:    invokeinterface [109] 0 
L43:    goto L65 
L46:    aload_0 
L47:    getfield [49] 
L50:    ldc [28] 
L52:    ldc [35] 
L54:    aload_0 
L55:    getfield [51] 
L58:    invokestatic [30] 
L61:    invokevirtual [64] 
L64:    pop 
L65:    return 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method private [516] : [517] 
    .attribute [501] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [49] 
L4:     ldc [28] 
L6:     ldc [36] 
L8:     aload_0 
L9:     getfield [47] 
L12:    invokestatic [30] 
L15:    invokevirtual [64] 
L18:    pop 
L19:    aload_0 
L20:    getfield [48] 
L23:    invokeinterface [110] 0 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method private [518] : [519] 
    .attribute [501] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [49] 
L4:     ldc [28] 
L6:     ldc [37] 
L8:     aload_0 
L9:     getfield [47] 
L12:    invokestatic [30] 
L15:    invokevirtual [64] 
L18:    pop 
L19:    aload_0 
L20:    getfield [48] 
L23:    invokeinterface [111] 0 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method private [520] : [521] 
    .attribute [501] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [49] 
L4:     ldc [28] 
L6:     ldc [38] 
L8:     aload_0 
L9:     getfield [47] 
L12:    invokestatic [30] 
L15:    invokevirtual [64] 
L18:    pop 
L19:    aload_0 
L20:    getfield [48] 
L23:    invokeinterface [111] 0 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [522] : [523] 
    .attribute [501] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [49] 
L4:     sipush 10000 
L7:     ldc [39] 
L9:     aload_2 
L10:    iload_1 
L11:    i2l 
L12:    invokevirtual [66] 
L15:    pop 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [524] : [525] 
    .attribute [501] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [49] 
L4:     ldc [28] 
L6:     ldc [40] 
L8:     iload_1 
L9:     i2l 
L10:    invokevirtual [67] 
L13:    pop 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [526] : [527] 
    .attribute [501] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [48] 
L4:     iload_1 
L5:     iload_2 
L6:     invokeinterface [112] 0 
L11:    return 
L12:    
    .end code 
.end method 

.method static synthetic [528] : [529] 
    .attribute [501] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [91] 
L9:     dup 
L10:    invokespecial [68] 
L13:    aload_1 
L14:    invokevirtual [50] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static synthetic [530] : [531] 
    .attribute [501] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [49] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [532] : [533] 
    .attribute [501] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [48] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [534] : [535] 
    .attribute [501] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [47] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [113] [114] 
.const [3] = Class [115] 
.const [4] = Class [116] 
.const [5] = String [117] 
.const [6] = Class [118] 
.const [7] = Field [119] [120] 
.const [8] = String [121] 
.const [9] = Method [122] [123] 
.const [10] = Field [124] [125] 
.const [11] = String [126] 
.const [12] = Class [127] 
.const [13] = Class [128] 
.const [14] = Class [129] 
.const [15] = Field [130] [131] 
.const [16] = String [132] 
.const [17] = Class [133] 
.const [18] = Class [134] 
.const [19] = Class [135] 
.const [20] = Class [136] 
.const [21] = String [137] 
.const [22] = String [138] 
.const [23] = String [139] 
.const [24] = String [140] 
.const [25] = String [141] 
.const [26] = String [142] 
.const [27] = String [143] 
.const [28] = Int 1078071040 
.const [29] = String [144] 
.const [30] = Method [145] [146] 
.const [31] = String [147] 
.const [32] = String [148] 
.const [33] = String [149] 
.const [34] = String [150] 
.const [35] = String [151] 
.const [36] = String [152] 
.const [37] = String [153] 
.const [38] = String [154] 
.const [39] = String [155] 
.const [40] = String [156] 
.const [41] = Class [157] 
.const [42] = Class [158] 
.const [43] = Class [159] 
.const [44] = Class [160] 
.const [45] = Class [161] 
.const [46] = Class [162] 
.const [47] = Field [163] [164] 
.const [48] = Field [165] [166] 
.const [49] = Field [167] [168] 
.const [50] = Method [169] [170] 
.const [51] = Field [171] [172] 
.const [52] = Field [173] [174] 
.const [53] = Method [175] [176] 
.const [54] = Field [177] [178] 
.const [55] = Field [179] [180] 
.const [56] = Method [181] [182] 
.const [57] = Method [183] [184] 
.const [58] = Method [185] [186] 
.const [59] = Method [187] [188] 
.const [60] = Method [189] [190] 
.const [61] = Method [191] [192] 
.const [62] = Method [193] [194] 
.const [63] = Method [195] [196] 
.const [64] = Method [197] [198] 
.const [65] = Method [199] [200] 
.const [66] = Method [201] [202] 
.const [67] = Method [203] [204] 
.const [68] = Method [205] [206] 
.const [69] = Method [207] [208] 
.const [70] = Field [209] [210] 
.const [71] = Field [211] [212] 
.const [72] = Method [213] [214] 
.const [73] = Method [215] [216] 
.const [74] = Method [217] [218] 
.const [75] = Field [219] [220] 
.const [76] = Method [221] [222] 
.const [77] = Method [223] [224] 
.const [78] = Method [225] [226] 
.const [79] = Method [227] [228] 
.const [80] = Method [229] [230] 
.const [81] = Method [231] [232] 
.const [82] = Method [233] [234] 
.const [83] = Method [235] [236] 
.const [84] = Method [237] [238] 
.const [85] = Method [239] [240] 
.const [86] = Method [241] [242] 
.const [87] = Method [243] [244] 
.const [88] = Field [245] [246] 
.const [89] = Field [247] [248] 
.const [90] = Field [249] [250] 
.const [91] = Class [251] 
.const [92] = Field [252] [253] 
.const [93] = Field [254] [255] 
.const [94] = Class [256] 
.const [95] = InterfaceMethod [257] [258] 
.const [96] = Class [259] 
.const [97] = Class [260] 
.const [98] = Field [261] [262] 
.const [99] = Class [263] 
.const [100] = Class [264] 
.const [101] = Class [265] 
.const [102] = InterfaceMethod [266] [267] 
.const [103] = Field [268] [269] 
.const [104] = Class [270] 
.const [105] = InterfaceMethod [271] [272] 
.const [106] = Class [273] 
.const [107] = InterfaceMethod [274] [275] 
.const [108] = InterfaceMethod [276] [277] 
.const [109] = InterfaceMethod [278] [279] 
.const [110] = InterfaceMethod [280] [281] 
.const [111] = InterfaceMethod [282] [283] 
.const [112] = InterfaceMethod [284] [285] 
.const [113] = Class [286] 
.const [114] = NameAndType [287] [288] 
.const [115] = Utf8 java/lang/ClassNotFoundException 
.const [116] = Utf8 java/lang/NoClassDefFoundError 
.const [117] = Utf8 'App.WirelessCharging.Main' 
.const [118] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [119] = Class [289] 
.const [120] = NameAndType [290] [291] 
.const [121] = Utf8 'org.dsi.ifc.wirelesscharging.DSIWirelessCharging' 
.const [122] = Class [292] 
.const [123] = NameAndType [293] [294] 
.const [124] = Class [295] 
.const [125] = NameAndType [296] [297] 
.const [126] = Utf8 'org.dsi.ifc.wirelesscharging.DSIWirelessChargingListener' 
.const [127] = Utf8 java/lang/Integer 
.const [128] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler$1 
.const [129] = Utf8 de/audi/app/wirelesscharging/core/WirelessChargingServiceProvider 
.const [130] = Class [298] 
.const [131] = NameAndType [299] [300] 
.const [132] = Utf8 'de.audi.atip.power.PowerEventListener' 
.const [133] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler$WirelessChargingPowerEventListener 
.const [134] = Utf8 java/util/Hashtable 
.const [135] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler$WirelessChargingAppDiag 
.const [136] = Utf8 java/lang/StringBuffer 
.const [137] = Utf8 'unknown charging info ' 
.const [138] = Utf8 EMPTY 
.const [139] = Utf8 NONWLC 
.const [140] = Utf8 OFF 
.const [141] = Utf8 WLCFOD 
.const [142] = Utf8 WLCFULL 
.const [143] = Utf8 WLCHARGE 
.const [144] = Utf8 '[DSIWirelessChargingResponseHandler#updateChargingInfo] chargingInfo=%1' 
.const [145] = Class [301] 
.const [146] = NameAndType [302] [303] 
.const [147] = Utf8 '[DSIWirelessChargingResponseHandler#updateChargingInfo] WLC info popups were disabled by user -> NOP!' 
.const [148] = Utf8 '[DSIWirelessChargingResponseHandler#updatePresentation] called' 
.const [149] = Utf8 '[DSIWirelessChargingResponseHandler#updatePresentation] unknown chargingInfo=%1' 
.const [150] = Utf8 '[DSIWirelessChargingResponseHandler#handleIsCharging] WLC is being charged, chargingInfo=%1' 
.const [151] = Utf8 '[DSIWirelessChargingResponseHandler#handleIsCharging] NOT showing popup! previousChargingInfo=%1' 
.const [152] = Utf8 '[DSIWirelessChargingResponseHandler#handleForeignObject] foreign object detected: %1' 
.const [153] = Utf8 '[DSIWirelessChargingResponseHandler#handleFullyCharged] WLC is fully charged: %1' 
.const [154] = Utf8 '[DSIWirelessChargingResponseHandler#handleChargingInactive] wlc is inactive: %1' 
.const [155] = Utf8 '[DSIWirelessChargingResponseHandler#asyncException] !asyncException! errorCode=%2, errorMsg=%1' 
.const [156] = Utf8 '[DSIWirelessChargingResponseHandler#updateBatteryLevel] battLevel=%1' 
.const [157] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [158] = Utf8 de/audi/app/wirelesscharging/core/AbstractWirelessChargingComponent 
.const [159] = Utf8 java/lang/Class 
.const [160] = Utf8 de/audi/app/wirelesscharging/core/IWirelessChargingApplication 
.const [161] = Utf8 de/audi/atip/log/LogChannel 
.const [162] = Utf8 de/audi/app/wirelesscharging/core/IWirelessChargingPresentationHandler 
.const [163] = Class [304] 
.const [164] = NameAndType [305] [306] 
.const [165] = Class [307] 
.const [166] = NameAndType [308] [309] 
.const [167] = Class [310] 
.const [168] = NameAndType [311] [312] 
.const [169] = Class [313] 
.const [170] = NameAndType [314] [315] 
.const [171] = Class [316] 
.const [172] = NameAndType [317] [318] 
.const [173] = Class [319] 
.const [174] = NameAndType [320] [321] 
.const [175] = Class [322] 
.const [176] = NameAndType [323] [324] 
.const [177] = Class [325] 
.const [178] = NameAndType [326] [327] 
.const [179] = Class [328] 
.const [180] = NameAndType [329] [330] 
.const [181] = Class [331] 
.const [182] = NameAndType [332] [333] 
.const [183] = Class [334] 
.const [184] = NameAndType [335] [336] 
.const [185] = Class [337] 
.const [186] = NameAndType [338] [339] 
.const [187] = Class [340] 
.const [188] = NameAndType [341] [342] 
.const [189] = Class [343] 
.const [190] = NameAndType [344] [345] 
.const [191] = Class [346] 
.const [192] = NameAndType [347] [348] 
.const [193] = Class [349] 
.const [194] = NameAndType [350] [351] 
.const [195] = Class [352] 
.const [196] = NameAndType [353] [354] 
.const [197] = Class [355] 
.const [198] = NameAndType [356] [357] 
.const [199] = Class [358] 
.const [200] = NameAndType [359] [360] 
.const [201] = Class [361] 
.const [202] = NameAndType [362] [363] 
.const [203] = Class [364] 
.const [204] = NameAndType [365] [366] 
.const [205] = Class [367] 
.const [206] = NameAndType [368] [369] 
.const [207] = Class [370] 
.const [208] = NameAndType [371] [372] 
.const [209] = Class [373] 
.const [210] = NameAndType [374] [375] 
.const [211] = Class [376] 
.const [212] = NameAndType [377] [378] 
.const [213] = Class [379] 
.const [214] = NameAndType [380] [381] 
.const [215] = Class [382] 
.const [216] = NameAndType [383] [384] 
.const [217] = Class [385] 
.const [218] = NameAndType [386] [387] 
.const [219] = Class [388] 
.const [220] = NameAndType [389] [390] 
.const [221] = Class [391] 
.const [222] = NameAndType [392] [393] 
.const [223] = Class [394] 
.const [224] = NameAndType [395] [396] 
.const [225] = Class [397] 
.const [226] = NameAndType [398] [399] 
.const [227] = Class [400] 
.const [228] = NameAndType [401] [402] 
.const [229] = Class [403] 
.const [230] = NameAndType [404] [405] 
.const [231] = Class [406] 
.const [232] = NameAndType [407] [408] 
.const [233] = Class [409] 
.const [234] = NameAndType [410] [411] 
.const [235] = Class [412] 
.const [236] = NameAndType [413] [414] 
.const [237] = Class [415] 
.const [238] = NameAndType [416] [417] 
.const [239] = Class [418] 
.const [240] = NameAndType [419] [420] 
.const [241] = Class [421] 
.const [242] = NameAndType [422] [423] 
.const [243] = Class [424] 
.const [244] = NameAndType [425] [426] 
.const [245] = Class [427] 
.const [246] = NameAndType [428] [429] 
.const [247] = Class [430] 
.const [248] = NameAndType [431] [432] 
.const [249] = Class [433] 
.const [250] = NameAndType [434] [435] 
.const [251] = Utf8 java/lang/NoClassDefFoundError 
.const [252] = Class [436] 
.const [253] = NameAndType [437] [438] 
.const [254] = Class [439] 
.const [255] = NameAndType [440] [441] 
.const [256] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [257] = Class [442] 
.const [258] = NameAndType [443] [444] 
.const [259] = Utf8 java/lang/Integer 
.const [260] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler$1 
.const [261] = Class [445] 
.const [262] = NameAndType [446] [447] 
.const [263] = Utf8 de/audi/app/wirelesscharging/core/WirelessChargingServiceProvider 
.const [264] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler$WirelessChargingPowerEventListener 
.const [265] = Utf8 java/util/Hashtable 
.const [266] = Class [448] 
.const [267] = NameAndType [449] [450] 
.const [268] = Class [451] 
.const [269] = NameAndType [452] [453] 
.const [270] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler$WirelessChargingAppDiag 
.const [271] = Class [454] 
.const [272] = NameAndType [455] [456] 
.const [273] = Utf8 java/lang/StringBuffer 
.const [274] = Class [457] 
.const [275] = NameAndType [458] [459] 
.const [276] = Class [460] 
.const [277] = NameAndType [461] [462] 
.const [278] = Class [463] 
.const [279] = NameAndType [464] [465] 
.const [280] = Class [466] 
.const [281] = NameAndType [467] [468] 
.const [282] = Class [469] 
.const [283] = NameAndType [470] [471] 
.const [284] = Class [472] 
.const [285] = NameAndType [473] [474] 
.const [286] = Utf8 java/lang/Class 
.const [287] = Utf8 forName 
.const [288] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [289] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [290] = Utf8 class$org$dsi$ifc$wirelesscharging$DSIWirelessCharging 
.const [291] = Utf8 Ljava/lang/Class; 
.const [292] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [293] = Utf8 class$ 
.const [294] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [295] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [296] = Utf8 class$org$dsi$ifc$wirelesscharging$DSIWirelessChargingListener 
.const [297] = Utf8 Ljava/lang/Class; 
.const [298] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [299] = Utf8 class$de$audi$atip$power$PowerEventListener 
.const [300] = Utf8 Ljava/lang/Class; 
.const [301] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [302] = Utf8 getChargingInfoName 
.const [303] = Utf8 (I)Ljava/lang/String; 
.const [304] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [305] = Utf8 currentChargingInfo 
.const [306] = Utf8 I 
.const [307] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [308] = Utf8 presentationHandler 
.const [309] = Utf8 Lde/audi/app/wirelesscharging/core/IWirelessChargingPresentationHandler; 
.const [310] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [311] = Utf8 log 
.const [312] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [313] = Utf8 java/lang/NoClassDefFoundError 
.const [314] = Utf8 initCause 
.const [315] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [316] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [317] = Utf8 previousChargingInfo 
.const [318] = Utf8 I 
.const [319] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [320] = Utf8 wlcApp 
.const [321] = Utf8 Lde/audi/app/wirelesscharging/core/IWirelessChargingApplication; 
.const [322] = Utf8 java/lang/Class 
.const [323] = Utf8 getName 
.const [324] = Utf8 ()Ljava/lang/String; 
.const [325] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [326] = Utf8 dsiWirelessChargingActivator 
.const [327] = Utf8 Lde/audi/mib/jdsi/DSIActivator; 
.const [328] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [329] = Utf8 serviceProvider 
.const [330] = Utf8 Lde/audi/app/wirelesscharging/core/WirelessChargingServiceProvider; 
.const [331] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [332] = Utf8 getApplication 
.const [333] = Utf8 ()Lde/audi/app/wirelesscharging/core/IWirelessChargingApplication; 
.const [334] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [335] = Utf8 start 
.const [336] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [337] = Utf8 de/audi/app/wirelesscharging/core/WirelessChargingServiceProvider 
.const [338] = Utf8 startService 
.const [339] = Utf8 ()V 
.const [340] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [341] = Utf8 stop 
.const [342] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [343] = Utf8 de/audi/app/wirelesscharging/core/WirelessChargingServiceProvider 
.const [344] = Utf8 stopService 
.const [345] = Utf8 ()V 
.const [346] = Utf8 java/lang/StringBuffer 
.const [347] = Utf8 append 
.const [348] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [349] = Utf8 java/lang/StringBuffer 
.const [350] = Utf8 append 
.const [351] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [352] = Utf8 java/lang/StringBuffer 
.const [353] = Utf8 toString 
.const [354] = Utf8 ()Ljava/lang/String; 
.const [355] = Utf8 de/audi/atip/log/LogChannel 
.const [356] = Utf8 log 
.const [357] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [358] = Utf8 de/audi/atip/log/LogChannel 
.const [359] = Utf8 log 
.const [360] = Utf8 (ILjava/lang/String;)Z 
.const [361] = Utf8 de/audi/atip/log/LogChannel 
.const [362] = Utf8 log 
.const [363] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [364] = Utf8 de/audi/atip/log/LogChannel 
.const [365] = Utf8 log 
.const [366] = Utf8 (ILjava/lang/String;J)Z 
.const [367] = Utf8 java/lang/NoClassDefFoundError 
.const [368] = Utf8 <init> 
.const [369] = Utf8 ()V 
.const [370] = Utf8 de/audi/app/wirelesscharging/core/AbstractWirelessChargingComponent 
.const [371] = Utf8 <init> 
.const [372] = Utf8 (Lde/audi/app/wirelesscharging/core/IWirelessChargingApplication;Ljava/lang/String;)V 
.const [373] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [374] = Utf8 class$org$dsi$ifc$wirelesscharging$DSIWirelessCharging 
.const [375] = Utf8 Ljava/lang/Class; 
.const [376] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [377] = Utf8 class$org$dsi$ifc$wirelesscharging$DSIWirelessChargingListener 
.const [378] = Utf8 Ljava/lang/Class; 
.const [379] = Utf8 java/lang/Integer 
.const [380] = Utf8 <init> 
.const [381] = Utf8 (I)V 
.const [382] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler$1 
.const [383] = Utf8 <init> 
.const [384] = Utf8 (Lde/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler;)V 
.const [385] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [386] = Utf8 <init> 
.const [387] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lorg/dsi/ifc/base/DSIListener;Lde/audi/mib/jdsi/IDSIClient;)V 
.const [388] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [389] = Utf8 class$de$audi$atip$power$PowerEventListener 
.const [390] = Utf8 Ljava/lang/Class; 
.const [391] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler$WirelessChargingPowerEventListener 
.const [392] = Utf8 <init> 
.const [393] = Utf8 (Lde/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler;Lde/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler$1;)V 
.const [394] = Utf8 java/util/Hashtable 
.const [395] = Utf8 <init> 
.const [396] = Utf8 (I)V 
.const [397] = Utf8 de/audi/app/wirelesscharging/core/WirelessChargingServiceProvider 
.const [398] = Utf8 <init> 
.const [399] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Hashtable;Lorg/osgi/framework/BundleContext;Lde/audi/atip/log/LogChannel;)V 
.const [400] = Utf8 de/audi/app/wirelesscharging/core/AbstractWirelessChargingComponent 
.const [401] = Utf8 init 
.const [402] = Utf8 ()V 
.const [403] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler$WirelessChargingAppDiag 
.const [404] = Utf8 <init> 
.const [405] = Utf8 (Lde/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler;)V 
.const [406] = Utf8 de/audi/app/wirelesscharging/core/AbstractWirelessChargingComponent 
.const [407] = Utf8 deinit 
.const [408] = Utf8 ()V 
.const [409] = Utf8 java/lang/StringBuffer 
.const [410] = Utf8 <init> 
.const [411] = Utf8 ()V 
.const [412] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [413] = Utf8 updatePresentation 
.const [414] = Utf8 ()V 
.const [415] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [416] = Utf8 handleIsCharging 
.const [417] = Utf8 ()V 
.const [418] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [419] = Utf8 handleForeignObject 
.const [420] = Utf8 ()V 
.const [421] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [422] = Utf8 handleFullyCharged 
.const [423] = Utf8 ()V 
.const [424] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [425] = Utf8 handleChargingInactive 
.const [426] = Utf8 ()V 
.const [427] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [428] = Utf8 currentChargingInfo 
.const [429] = Utf8 I 
.const [430] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [431] = Utf8 presentationHandler 
.const [432] = Utf8 Lde/audi/app/wirelesscharging/core/IWirelessChargingPresentationHandler; 
.const [433] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [434] = Utf8 log 
.const [435] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [436] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [437] = Utf8 previousChargingInfo 
.const [438] = Utf8 I 
.const [439] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [440] = Utf8 wlcApp 
.const [441] = Utf8 Lde/audi/app/wirelesscharging/core/IWirelessChargingApplication; 
.const [442] = Utf8 de/audi/app/wirelesscharging/core/IWirelessChargingApplication 
.const [443] = Utf8 getFrameworkAccess 
.const [444] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [445] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [446] = Utf8 dsiWirelessChargingActivator 
.const [447] = Utf8 Lde/audi/mib/jdsi/DSIActivator; 
.const [448] = Utf8 de/audi/app/wirelesscharging/core/IWirelessChargingApplication 
.const [449] = Utf8 getBundleContext 
.const [450] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [451] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [452] = Utf8 serviceProvider 
.const [453] = Utf8 Lde/audi/app/wirelesscharging/core/WirelessChargingServiceProvider; 
.const [454] = Utf8 de/audi/app/wirelesscharging/core/IWirelessChargingApplication 
.const [455] = Utf8 addDiagnosisComponent 
.const [456] = Utf8 (Lde/mib/swdiagnosis/wirelesscharging/IWirelessChargingDiagComponent;)V 
.const [457] = Utf8 de/audi/app/wirelesscharging/core/IWirelessChargingPresentationHandler 
.const [458] = Utf8 updateStatusBar 
.const [459] = Utf8 (I)V 
.const [460] = Utf8 de/audi/app/wirelesscharging/core/IWirelessChargingApplication 
.const [461] = Utf8 isWLCInfoPopupEnabled 
.const [462] = Utf8 ()Z 
.const [463] = Utf8 de/audi/app/wirelesscharging/core/IWirelessChargingPresentationHandler 
.const [464] = Utf8 onWLCDeviceBeingCharged 
.const [465] = Utf8 ()V 
.const [466] = Utf8 de/audi/app/wirelesscharging/core/IWirelessChargingPresentationHandler 
.const [467] = Utf8 onForeignObjectDetected 
.const [468] = Utf8 ()V 
.const [469] = Utf8 de/audi/app/wirelesscharging/core/IWirelessChargingPresentationHandler 
.const [470] = Utf8 clearPresentation 
.const [471] = Utf8 ()V 
.const [472] = Utf8 de/audi/app/wirelesscharging/core/IWirelessChargingPresentationHandler 
.const [473] = Utf8 popupRemoved 
.const [474] = Utf8 (II)V 
.const [475] = Utf8 de/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler 
.const [476] = Class [475] 
.const [477] = Utf8 de/audi/app/wirelesscharging/core/AbstractWirelessChargingComponent 
.const [478] = Class [477] 
.const [479] = Utf8 org/dsi/ifc/wirelesscharging/DSIWirelessChargingListener 
.const [480] = Class [479] 
.const [481] = Utf8 wlcApp 
.const [482] = Utf8 Lde/audi/app/wirelesscharging/core/IWirelessChargingApplication; 
.const [483] = Utf8 presentationHandler 
.const [484] = Utf8 Lde/audi/app/wirelesscharging/core/IWirelessChargingPresentationHandler; 
.const [485] = Utf8 dsiWirelessChargingActivator 
.const [486] = Utf8 Lde/audi/mib/jdsi/DSIActivator; 
.const [487] = Utf8 log 
.const [488] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [489] = Utf8 serviceProvider 
.const [490] = Utf8 Lde/audi/app/wirelesscharging/core/WirelessChargingServiceProvider; 
.const [491] = Utf8 currentChargingInfo 
.const [492] = Utf8 I 
.const [493] = Utf8 previousChargingInfo 
.const [494] = Utf8 I 
.const [495] = Utf8 class$org$dsi$ifc$wirelesscharging$DSIWirelessCharging 
.const [496] = Utf8 Ljava/lang/Class; 
.const [497] = Utf8 class$org$dsi$ifc$wirelesscharging$DSIWirelessChargingListener 
.const [498] = Utf8 Ljava/lang/Class; 
.const [499] = Utf8 class$de$audi$atip$power$PowerEventListener 
.const [500] = Utf8 Ljava/lang/Class; 
.const [501] = Utf8 Code 
.const [502] = Utf8 <init> 
.const [503] = Utf8 (Lde/audi/app/wirelesscharging/core/IWirelessChargingApplication;Lde/audi/app/wirelesscharging/core/IWirelessChargingPresentationHandler;Lde/audi/atip/log/LogChannel;)V 
.const [504] = Utf8 init 
.const [505] = Utf8 ()V 
.const [506] = Utf8 deinit 
.const [507] = Utf8 ()V 
.const [508] = Utf8 getChargingInfoName 
.const [509] = Utf8 (I)Ljava/lang/String; 
.const [510] = Utf8 updateChargingInfo 
.const [511] = Utf8 (II)V 
.const [512] = Utf8 updatePresentation 
.const [513] = Utf8 ()V 
.const [514] = Utf8 handleIsCharging 
.const [515] = Utf8 ()V 
.const [516] = Utf8 handleForeignObject 
.const [517] = Utf8 ()V 
.const [518] = Utf8 handleFullyCharged 
.const [519] = Utf8 ()V 
.const [520] = Utf8 handleChargingInactive 
.const [521] = Utf8 ()V 
.const [522] = Utf8 asyncException 
.const [523] = Utf8 (ILjava/lang/String;I)V 
.const [524] = Utf8 updateBatteryLevel 
.const [525] = Utf8 (II)V 
.const [526] = Utf8 popupRemoved 
.const [527] = Utf8 (II)V 
.const [528] = Utf8 class$ 
.const [529] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [530] = Utf8 access$100 
.const [531] = Utf8 (Lde/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler;)Lde/audi/atip/log/LogChannel; 
.const [532] = Utf8 access$200 
.const [533] = Utf8 (Lde/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler;)Lde/audi/app/wirelesscharging/core/IWirelessChargingPresentationHandler; 
.const [534] = Utf8 access$300 
.const [535] = Utf8 (Lde/audi/app/wirelesscharging/core/DSIWirelessChargingResponseHandler;)I 
.end class 
