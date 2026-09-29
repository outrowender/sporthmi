.version 50 0 
.class public super [298] 
.super [300] 
.implements [302] 
.field private volatile [303] [304] 
.field private volatile [305] [306] 
.field private final [307] [308] 
.field static synthetic [309] [310] 

.method public [312] : [313] 
    .attribute [311] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [5] 
L4:     invokespecial [54] 
L7:     aload_0 
L8:     bipush 6 
L10:    putfield [63] 
L13:    aload_0 
L14:    iconst_5 
L15:    newarray int 
L17:    dup 
L18:    iconst_0 
L19:    ldc [6] 
L21:    iastore 
L22:    dup 
L23:    iconst_1 
L24:    ldc [7] 
L26:    iastore 
L27:    dup 
L28:    iconst_2 
L29:    ldc [8] 
L31:    iastore 
L32:    dup 
L33:    iconst_3 
L34:    ldc [9] 
L36:    iastore 
L37:    dup 
L38:    iconst_4 
L39:    ldc [10] 
L41:    iastore 
L42:    putfield [64] 
L45:    return 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [314] : [315] 
    .attribute [311] .code stack 8 locals 1 
L0:     new [65] 
L3:     dup 
L4:     invokespecial [55] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [12] 
L11:    ldc [13] 
L13:    invokevirtual [46] 
L16:    pop 
L17:    aload_0 
L18:    invokevirtual [41] 
L21:    invokeinterface [66] 0 
L26:    aload_0 
L27:    getfield [45] 
L30:    aload_0 
L31:    invokeinterface [67] 0 
L36:    aload_0 
L37:    new [68] 
L40:    dup 
L41:    getstatic [15] 
L44:    ifnonnull L59 
L47:    ldc [16] 
L49:    invokestatic [17] 
L52:    dup 
L53:    putstatic [56] 
L56:    goto L62 
L59:    getstatic [15] 
L62:    invokevirtual [47] 
L65:    aload_0 
L66:    aload_1 
L67:    aload_0 
L68:    invokevirtual [41] 
L71:    invokeinterface [69] 0 
L76:    aload_0 
L77:    getfield [42] 
L80:    invokespecial [57] 
L83:    putfield [70] 
L86:    aload_0 
L87:    getfield [48] 
L90:    invokevirtual [49] 
L93:    return 
L94:    nop 
L95:    nop 
L96:    
    .end code 
.end method 

.method public [316] : [317] 
    .attribute [311] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [48] 
L4:     ifnull L19 
L7:     aload_0 
L8:     getfield [48] 
L11:    invokevirtual [50] 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [70] 
L19:    aload_0 
L20:    invokevirtual [41] 
L23:    invokeinterface [66] 0 
L28:    aload_0 
L29:    invokeinterface [71] 0 
L34:    return 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [318] : [319] 
    .attribute [311] .code stack 3 locals 1 
L0:     iload_1 
L1:     ldc [7] 
L3:     if_icmpeq L30 
L6:     iload_1 
L7:     ldc [8] 
L9:     if_icmpeq L30 
L12:    iload_1 
L13:    ldc [9] 
L15:    if_icmpeq L30 
L18:    iload_1 
L19:    ldc [10] 
L21:    if_icmpeq L30 
L24:    iload_1 
L25:    ldc [6] 
L27:    if_icmpne L192 
L30:    aload_2 
L31:    invokeinterface [72] 0 
L36:    istore_3 
L37:    iload_3 
L38:    aload_0 
L39:    getfield [44] 
L42:    if_icmpne L46 
L45:    return 
L46:    iload_3 
L47:    iconst_2 
L48:    if_icmpne L88 
L51:    aload_0 
L52:    getfield [42] 
L55:    ldc [18] 
L57:    ldc [19] 
L59:    invokevirtual [51] 
L62:    pop 
L63:    aload_0 
L64:    invokevirtual [41] 
L67:    invokeinterface [73] 0 
L72:    invokeinterface [74] 0 
L77:    sipush 208 
L80:    invokeinterface [75] 0 
L85:    goto L187 
L88:    iload_3 
L89:    iconst_3 
L90:    if_icmpne L130 
L93:    aload_0 
L94:    getfield [42] 
L97:    ldc [18] 
L99:    ldc [20] 
L101:   invokevirtual [51] 
L104:   pop 
L105:   aload_0 
L106:   invokevirtual [41] 
L109:   invokeinterface [73] 0 
L114:   invokeinterface [74] 0 
L119:   sipush 209 
L122:   invokeinterface [75] 0 
L127:   goto L187 
L130:   iload_3 
L131:   bipush 6 
L133:   if_icmpeq L153 
L136:   iload_3 
L137:   bipush 7 
L139:   if_icmpeq L153 
L142:   iload_3 
L143:   bipush 8 
L145:   if_icmpeq L153 
L148:   iload_3 
L149:   iconst_5 
L150:   if_icmpne L187 
L153:   aload_0 
L154:   getfield [42] 
L157:   ldc [18] 
L159:   ldc [21] 
L161:   invokevirtual [51] 
L164:   pop 
L165:   aload_0 
L166:   invokevirtual [41] 
L169:   invokeinterface [73] 0 
L174:   invokeinterface [74] 0 
L179:   sipush 210 
L182:   invokeinterface [75] 0 
L187:   aload_0 
L188:   iload_3 
L189:   putfield [63] 
L192:   return 
L193:   nop 
L194:   nop 
L195:   nop 
L196:   
    .end code 
.end method 

.method public [320] : [321] 
    .attribute [311] .code stack 7 locals 0 
L0:     aload_0 
L1:     invokevirtual [41] 
L4:     new [76] 
L7:     dup 
L8:     aload_0 
L9:     ldc [23] 
L11:    aload_2 
L12:    iload_1 
L13:    invokespecial [58] 
L16:    invokeinterface [77] 0 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [322] : [323] 
    .attribute [311] .code stack 7 locals 0 
L0:     aload_0 
L1:     invokevirtual [41] 
L4:     new [78] 
L7:     dup 
L8:     aload_0 
L9:     ldc [25] 
L11:    iload_1 
L12:    aload_2 
L13:    invokespecial [59] 
L16:    invokeinterface [77] 0 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [324] : [325] 
    .attribute [311] .code stack 6 locals 0 
L0:     aload_0 
L1:     invokevirtual [41] 
L4:     new [79] 
L7:     dup 
L8:     aload_0 
L9:     ldc [27] 
L11:    aload_1 
L12:    invokespecial [60] 
L15:    invokeinterface [77] 0 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [326] : [327] 
    .attribute [311] .code stack 7 locals 0 
L0:     aload_0 
L1:     invokevirtual [41] 
L4:     new [80] 
L7:     dup 
L8:     aload_0 
L9:     ldc [29] 
L11:    aload_2 
L12:    iload_1 
L13:    invokespecial [61] 
L16:    invokeinterface [77] 0 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [328] : [329] 
    .attribute [311] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [42] 
L4:     ldc [30] 
L6:     ldc [31] 
L8:     aload_0 
L9:     getfield [44] 
L12:    i2l 
L13:    invokevirtual [52] 
L16:    pop 
L17:    aload_0 
L18:    getfield [44] 
L21:    iconst_2 
L22:    if_icmpne L62 
L25:    aload_0 
L26:    getfield [42] 
L29:    ldc [18] 
L31:    ldc [19] 
L33:    invokevirtual [51] 
L36:    pop 
L37:    aload_0 
L38:    invokevirtual [41] 
L41:    invokeinterface [73] 0 
L46:    invokeinterface [74] 0 
L51:    sipush 208 
L54:    invokeinterface [75] 0 
L59:    goto L104 
L62:    aload_0 
L63:    getfield [44] 
L66:    iconst_3 
L67:    if_icmpne L104 
L70:    aload_0 
L71:    getfield [42] 
L74:    ldc [18] 
L76:    ldc [20] 
L78:    invokevirtual [51] 
L81:    pop 
L82:    aload_0 
L83:    invokevirtual [41] 
L86:    invokeinterface [73] 0 
L91:    invokeinterface [74] 0 
L96:    sipush 209 
L99:    invokeinterface [75] 0 
L104:   return 
L105:   nop 
L106:   nop 
L107:   nop 
L108:   
    .end code 
.end method 

.method static synthetic [330] : [331] 
    .attribute [311] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [62] 
L9:     dup 
L10:    invokespecial [53] 
L13:    aload_1 
L14:    invokevirtual [43] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static synthetic [332] : [333] 
    .attribute [311] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [42] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [334] : [335] 
    .attribute [311] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [41] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [336] : [337] 
    .attribute [311] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [42] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [338] : [339] 
    .attribute [311] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [41] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [340] : [341] 
    .attribute [311] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [42] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [342] : [343] 
    .attribute [311] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [41] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [344] : [345] 
    .attribute [311] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [42] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [346] : [347] 
    .attribute [311] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [41] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [81] [82] 
.const [3] = Class [83] 
.const [4] = Class [84] 
.const [5] = String [85] 
.const [6] = Int 50332672 
.const [7] = Int 218104832 
.const [8] = Int 50331904 
.const [9] = Int 50332416 
.const [10] = Int 50332160 
.const [11] = Class [86] 
.const [12] = String [87] 
.const [13] = String [88] 
.const [14] = Class [89] 
.const [15] = Field [90] [91] 
.const [16] = String [92] 
.const [17] = Method [93] [94] 
.const [18] = Int 1078071040 
.const [19] = String [95] 
.const [20] = String [96] 
.const [21] = String [97] 
.const [22] = Class [98] 
.const [23] = String [99] 
.const [24] = Class [100] 
.const [25] = String [101] 
.const [26] = Class [102] 
.const [27] = String [103] 
.const [28] = Class [104] 
.const [29] = String [105] 
.const [30] = Int -2137614336 
.const [31] = String [106] 
.const [32] = Class [107] 
.const [33] = Class [108] 
.const [34] = Class [109] 
.const [35] = Class [110] 
.const [36] = Class [111] 
.const [37] = Class [112] 
.const [38] = Class [113] 
.const [39] = Class [114] 
.const [40] = Class [115] 
.const [41] = Method [116] [117] 
.const [42] = Field [118] [119] 
.const [43] = Method [120] [121] 
.const [44] = Field [122] [123] 
.const [45] = Field [124] [125] 
.const [46] = Method [126] [127] 
.const [47] = Method [128] [129] 
.const [48] = Field [130] [131] 
.const [49] = Method [132] [133] 
.const [50] = Method [134] [135] 
.const [51] = Method [136] [137] 
.const [52] = Method [138] [139] 
.const [53] = Method [140] [141] 
.const [54] = Method [142] [143] 
.const [55] = Method [144] [145] 
.const [56] = Field [146] [147] 
.const [57] = Method [148] [149] 
.const [58] = Method [150] [151] 
.const [59] = Method [152] [153] 
.const [60] = Method [154] [155] 
.const [61] = Method [156] [157] 
.const [62] = Class [158] 
.const [63] = Field [159] [160] 
.const [64] = Field [161] [162] 
.const [65] = Class [163] 
.const [66] = InterfaceMethod [164] [165] 
.const [67] = InterfaceMethod [166] [167] 
.const [68] = Class [168] 
.const [69] = InterfaceMethod [169] [170] 
.const [70] = Field [171] [172] 
.const [71] = InterfaceMethod [173] [174] 
.const [72] = InterfaceMethod [175] [176] 
.const [73] = InterfaceMethod [177] [178] 
.const [74] = InterfaceMethod [179] [180] 
.const [75] = InterfaceMethod [181] [182] 
.const [76] = Class [183] 
.const [77] = InterfaceMethod [184] [185] 
.const [78] = Class [186] 
.const [79] = Class [187] 
.const [80] = Class [188] 
.const [81] = Class [189] 
.const [82] = NameAndType [190] [191] 
.const [83] = Utf8 java/lang/ClassNotFoundException 
.const [84] = Utf8 java/lang/NoClassDefFoundError 
.const [85] = Utf8 'App.Phone.Main' 
.const [86] = Utf8 java/util/Hashtable 
.const [87] = Utf8 ApplicationName 
.const [88] = Utf8 AppPhone 
.const [89] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [90] = Class [192] 
.const [91] = NameAndType [193] [194] 
.const [92] = Utf8 'de.audi.atip.phone.ITelServiceConnectivity' 
.const [93] = Class [195] 
.const [94] = NameAndType [196] [197] 
.const [95] = Utf8 '[TelServiceConnectivityImpl#updateGlobalTelephoneStateProperty] telPhoneModuleState is ON .' 
.const [96] = Utf8 '[TelServiceConnectivityImpl#updateGlobalTelephoneStateProperty] telPhoneModuleState is OFF.' 
.const [97] = Utf8 '[TelServiceConnectivityImpl#updateGlobalTelephoneStateProperty] telPhoneModuleState is currently switching powerstate.' 
.const [98] = Utf8 de/audi/app/phone/core/interapp/TelServiceConnectivityImpl$1 
.const [99] = Utf8 'TelServiceConnectivityImpl#setNadMode' 
.const [100] = Utf8 de/audi/app/phone/core/interapp/TelServiceConnectivityImpl$2 
.const [101] = Utf8 'TelServiceConnectivityImpl#changePhoneModulePowerState' 
.const [102] = Utf8 de/audi/app/phone/core/interapp/TelServiceConnectivityImpl$3 
.const [103] = Utf8 'TelServiceConnectivityImpl#togglePhones' 
.const [104] = Utf8 de/audi/app/phone/core/interapp/TelServiceConnectivityImpl$4 
.const [105] = Utf8 'TelServiceConnectivityImpl#setNadRole' 
.const [106] = Utf8 'TelServiceConnectivityImpl#isNADModuleActivated: telPhoneModuleState is %1' 
.const [107] = Utf8 de/audi/app/phone/core/interapp/TelServiceConnectivityImpl 
.const [108] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [109] = Utf8 java/lang/Class 
.const [110] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [111] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [112] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [113] = Utf8 de/audi/atip/log/LogChannel 
.const [114] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [115] = Utf8 de/audi/atip/msg/MsgDistributor 
.const [116] = Class [198] 
.const [117] = NameAndType [199] [200] 
.const [118] = Class [201] 
.const [119] = NameAndType [202] [203] 
.const [120] = Class [204] 
.const [121] = NameAndType [205] [206] 
.const [122] = Class [207] 
.const [123] = NameAndType [208] [209] 
.const [124] = Class [210] 
.const [125] = NameAndType [211] [212] 
.const [126] = Class [213] 
.const [127] = NameAndType [214] [215] 
.const [128] = Class [216] 
.const [129] = NameAndType [217] [218] 
.const [130] = Class [219] 
.const [131] = NameAndType [220] [221] 
.const [132] = Class [222] 
.const [133] = NameAndType [223] [224] 
.const [134] = Class [225] 
.const [135] = NameAndType [226] [227] 
.const [136] = Class [228] 
.const [137] = NameAndType [229] [230] 
.const [138] = Class [231] 
.const [139] = NameAndType [232] [233] 
.const [140] = Class [234] 
.const [141] = NameAndType [235] [236] 
.const [142] = Class [237] 
.const [143] = NameAndType [238] [239] 
.const [144] = Class [240] 
.const [145] = NameAndType [241] [242] 
.const [146] = Class [243] 
.const [147] = NameAndType [244] [245] 
.const [148] = Class [246] 
.const [149] = NameAndType [247] [248] 
.const [150] = Class [249] 
.const [151] = NameAndType [250] [251] 
.const [152] = Class [252] 
.const [153] = NameAndType [253] [254] 
.const [154] = Class [255] 
.const [155] = NameAndType [256] [257] 
.const [156] = Class [258] 
.const [157] = NameAndType [259] [260] 
.const [158] = Utf8 java/lang/NoClassDefFoundError 
.const [159] = Class [261] 
.const [160] = NameAndType [262] [263] 
.const [161] = Class [264] 
.const [162] = NameAndType [265] [266] 
.const [163] = Utf8 java/util/Hashtable 
.const [164] = Class [267] 
.const [165] = NameAndType [268] [269] 
.const [166] = Class [270] 
.const [167] = NameAndType [271] [272] 
.const [168] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [169] = Class [273] 
.const [170] = NameAndType [274] [275] 
.const [171] = Class [276] 
.const [172] = NameAndType [277] [278] 
.const [173] = Class [279] 
.const [174] = NameAndType [280] [281] 
.const [175] = Class [282] 
.const [176] = NameAndType [283] [284] 
.const [177] = Class [285] 
.const [178] = NameAndType [286] [287] 
.const [179] = Class [288] 
.const [180] = NameAndType [289] [290] 
.const [181] = Class [291] 
.const [182] = NameAndType [292] [293] 
.const [183] = Utf8 de/audi/app/phone/core/interapp/TelServiceConnectivityImpl$1 
.const [184] = Class [294] 
.const [185] = NameAndType [295] [296] 
.const [186] = Utf8 de/audi/app/phone/core/interapp/TelServiceConnectivityImpl$2 
.const [187] = Utf8 de/audi/app/phone/core/interapp/TelServiceConnectivityImpl$3 
.const [188] = Utf8 de/audi/app/phone/core/interapp/TelServiceConnectivityImpl$4 
.const [189] = Utf8 java/lang/Class 
.const [190] = Utf8 forName 
.const [191] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [192] = Utf8 de/audi/app/phone/core/interapp/TelServiceConnectivityImpl 
.const [193] = Utf8 class$de$audi$atip$phone$ITelServiceConnectivity 
.const [194] = Utf8 Ljava/lang/Class; 
.const [195] = Utf8 de/audi/app/phone/core/interapp/TelServiceConnectivityImpl 
.const [196] = Utf8 class$ 
.const [197] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [198] = Utf8 de/audi/app/phone/core/interapp/TelServiceConnectivityImpl 
.const [199] = Utf8 getApplication 
.const [200] = Utf8 ()Lde/audi/app/phone/core/ITelApplication; 
.const [201] = Utf8 de/audi/app/phone/core/interapp/TelServiceConnectivityImpl 
.const [202] = Utf8 log 
.const [203] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [204] = Utf8 java/lang/NoClassDefFoundError 
.const [205] = Utf8 initCause 
.const [206] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [207] = Utf8 de/audi/app/phone/core/interapp/TelServiceConnectivityImpl 
.const [208] = Utf8 telPhoneModuleState 
.const [209] = Utf8 I 
.const [210] = Utf8 de/audi/app/phone/core/interapp/TelServiceConnectivityImpl 
.const [211] = Utf8 attributes 
.const [212] = Utf8 [I 
.const [213] = Utf8 java/util/Hashtable 
.const [214] = Utf8 put 
.const [215] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [216] = Utf8 java/lang/Class 
.const [217] = Utf8 getName 
.const [218] = Utf8 ()Ljava/lang/String; 
.const [219] = Utf8 de/audi/app/phone/core/interapp/TelServiceConnectivityImpl 
.const [220] = Utf8 telServiceConnectivityServiceProvider 
.const [221] = Utf8 Lde/audi/app/phone/core/PhoneServiceProvider; 
.const [222] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [223] = Utf8 startService 
.const [224] = Utf8 ()V 
.const [225] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [226] = Utf8 stopService 
.const [227] = Utf8 ()V 
.const [228] = Utf8 de/audi/atip/log/LogChannel 
.const [229] = Utf8 log 
.const [230] = Utf8 (ILjava/lang/String;)Z 
.const [231] = Utf8 de/audi/atip/log/LogChannel 
.const [232] = Utf8 log 
.const [233] = Utf8 (ILjava/lang/String;J)Z 
.const [234] = Utf8 java/lang/NoClassDefFoundError 
.const [235] = Utf8 <init> 
.const [236] = Utf8 ()V 
.const [237] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [238] = Utf8 <init> 
.const [239] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Ljava/lang/String;)V 
.const [240] = Utf8 java/util/Hashtable 
.const [241] = Utf8 <init> 
.const [242] = Utf8 ()V 
.const [243] = Utf8 de/audi/app/phone/core/interapp/TelServiceConnectivityImpl 
.const [244] = Utf8 class$de$audi$atip$phone$ITelServiceConnectivity 
.const [245] = Utf8 Ljava/lang/Class; 
.const [246] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [247] = Utf8 <init> 
.const [248] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Hashtable;Lorg/osgi/framework/BundleContext;Lde/audi/atip/log/LogChannel;)V 
.const [249] = Utf8 de/audi/app/phone/core/interapp/TelServiceConnectivityImpl$1 
.const [250] = Utf8 <init> 
.const [251] = Utf8 (Lde/audi/app/phone/core/interapp/TelServiceConnectivityImpl;Ljava/lang/String;Lde/audi/atip/phone/ITelServiceConnectivityListener;I)V 
.const [252] = Utf8 de/audi/app/phone/core/interapp/TelServiceConnectivityImpl$2 
.const [253] = Utf8 <init> 
.const [254] = Utf8 (Lde/audi/app/phone/core/interapp/TelServiceConnectivityImpl;Ljava/lang/String;ZLde/audi/atip/phone/ITelServiceConnectivityListener;)V 
.const [255] = Utf8 de/audi/app/phone/core/interapp/TelServiceConnectivityImpl$3 
.const [256] = Utf8 <init> 
.const [257] = Utf8 (Lde/audi/app/phone/core/interapp/TelServiceConnectivityImpl;Ljava/lang/String;Lde/audi/atip/phone/ITelServiceConnectivityListener;)V 
.const [258] = Utf8 de/audi/app/phone/core/interapp/TelServiceConnectivityImpl$4 
.const [259] = Utf8 <init> 
.const [260] = Utf8 (Lde/audi/app/phone/core/interapp/TelServiceConnectivityImpl;Ljava/lang/String;Lde/audi/atip/phone/ITelServiceConnectivityListener;I)V 
.const [261] = Utf8 de/audi/app/phone/core/interapp/TelServiceConnectivityImpl 
.const [262] = Utf8 telPhoneModuleState 
.const [263] = Utf8 I 
.const [264] = Utf8 de/audi/app/phone/core/interapp/TelServiceConnectivityImpl 
.const [265] = Utf8 attributes 
.const [266] = Utf8 [I 
.const [267] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [268] = Utf8 getGlobalTelephoneStateManager 
.const [269] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneState; 
.const [270] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [271] = Utf8 registerListenerForSpecificAttributeUpdate 
.const [272] = Utf8 ([ILde/audi/app/phone/core/state/IGlobalTelephoneStateListener;)V 
.const [273] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [274] = Utf8 getBundleContext 
.const [275] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [276] = Utf8 de/audi/app/phone/core/interapp/TelServiceConnectivityImpl 
.const [277] = Utf8 telServiceConnectivityServiceProvider 
.const [278] = Utf8 Lde/audi/app/phone/core/PhoneServiceProvider; 
.const [279] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [280] = Utf8 removeListener 
.const [281] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateListener;)V 
.const [282] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [283] = Utf8 getPhoneModuleState 
.const [284] = Utf8 ()I 
.const [285] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [286] = Utf8 getFrameworkAccess 
.const [287] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [288] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [289] = Utf8 getMsgDistrib 
.const [290] = Utf8 ()Lde/audi/atip/msg/MsgDistributor; 
.const [291] = Utf8 de/audi/atip/msg/MsgDistributor 
.const [292] = Utf8 sendMessage 
.const [293] = Utf8 (I)V 
.const [294] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [295] = Utf8 enqueueEvent 
.const [296] = Utf8 (Lde/audi/app/phone/core/event/AbstractTelEvent;)V 
.const [297] = Utf8 de/audi/app/phone/core/interapp/TelServiceConnectivityImpl 
.const [298] = Class [297] 
.const [299] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [300] = Class [299] 
.const [301] = Utf8 de/audi/atip/phone/ITelServiceConnectivity 
.const [302] = Class [301] 
.const [303] = Utf8 telServiceConnectivityServiceProvider 
.const [304] = Utf8 Lde/audi/app/phone/core/PhoneServiceProvider; 
.const [305] = Utf8 telPhoneModuleState 
.const [306] = Utf8 I 
.const [307] = Utf8 attributes 
.const [308] = Utf8 [I 
.const [309] = Utf8 class$de$audi$atip$phone$ITelServiceConnectivity 
.const [310] = Utf8 Ljava/lang/Class; 
.const [311] = Utf8 Code 
.const [312] = Utf8 <init> 
.const [313] = Utf8 (Lde/audi/app/phone/core/ITelApplication;)V 
.const [314] = Utf8 init 
.const [315] = Utf8 ()V 
.const [316] = Utf8 deinit 
.const [317] = Utf8 ()V 
.const [318] = Utf8 updateGlobalTelephoneStateProperty 
.const [319] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [320] = Utf8 setNadMode 
.const [321] = Utf8 (ILde/audi/atip/phone/ITelServiceConnectivityListener;)V 
.const [322] = Utf8 changePhoneModulePowerState 
.const [323] = Utf8 (ZLde/audi/atip/phone/ITelServiceConnectivityListener;)V 
.const [324] = Utf8 togglePhones 
.const [325] = Utf8 (Lde/audi/atip/phone/ITelServiceConnectivityListener;)V 
.const [326] = Utf8 setNadRole 
.const [327] = Utf8 (ILde/audi/atip/phone/ITelServiceConnectivityListener;)V 
.const [328] = Utf8 requestCurrentNadModulePowerState 
.const [329] = Utf8 ()V 
.const [330] = Utf8 class$ 
.const [331] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [332] = Utf8 access$000 
.const [333] = Utf8 (Lde/audi/app/phone/core/interapp/TelServiceConnectivityImpl;)Lde/audi/atip/log/LogChannel; 
.const [334] = Utf8 access$100 
.const [335] = Utf8 (Lde/audi/app/phone/core/interapp/TelServiceConnectivityImpl;)Lde/audi/app/phone/core/ITelApplication; 
.const [336] = Utf8 access$200 
.const [337] = Utf8 (Lde/audi/app/phone/core/interapp/TelServiceConnectivityImpl;)Lde/audi/atip/log/LogChannel; 
.const [338] = Utf8 access$300 
.const [339] = Utf8 (Lde/audi/app/phone/core/interapp/TelServiceConnectivityImpl;)Lde/audi/app/phone/core/ITelApplication; 
.const [340] = Utf8 access$400 
.const [341] = Utf8 (Lde/audi/app/phone/core/interapp/TelServiceConnectivityImpl;)Lde/audi/atip/log/LogChannel; 
.const [342] = Utf8 access$600 
.const [343] = Utf8 (Lde/audi/app/phone/core/interapp/TelServiceConnectivityImpl;)Lde/audi/app/phone/core/ITelApplication; 
.const [344] = Utf8 access$700 
.const [345] = Utf8 (Lde/audi/app/phone/core/interapp/TelServiceConnectivityImpl;)Lde/audi/atip/log/LogChannel; 
.const [346] = Utf8 access$900 
.const [347] = Utf8 (Lde/audi/app/phone/core/interapp/TelServiceConnectivityImpl;)Lde/audi/app/phone/core/ITelApplication; 
.end class 
