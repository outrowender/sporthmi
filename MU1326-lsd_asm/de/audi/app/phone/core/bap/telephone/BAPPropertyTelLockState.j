.version 50 0 
.class public super [317] 
.super [319] 
.implements [321] 
.field protected static final [322] [323] 
.field private static final [324] [325] 
.field private static final [326] [327] 
.field private static final [328] [329] 
.field private static final [330] [331] 
.field private static final [332] [333] 
.field private static final [334] [335] 
.field private static final [336] [337] 
.field private static final [338] [339] 
.field private static final [340] [341] 
.field private static final [342] [343] 
.field private static final [344] [345] 
.field private static final [346] [347] 
.field private static final [348] [349] 
.field private volatile [350] [351] 
.field private volatile [352] [353] 
.field static synthetic [354] [355] 

.method protected static [357] : [358] 
    .attribute [356] .code stack 1 locals 0 
L0:     iload_0 
L1:     tableswitch 0 
            L76 
            L82 
            L88 
            L218 
            L85 
            L88 
            L218 
            L71 
            L218 
            L68 
            L218 
            L218 
            L79 
            default : L218 

L68:    bipush 11 
L70:    areturn 
L71:    iload_2 
L72:    invokestatic [5] 
L75:    areturn 
L76:    bipush 8 
L78:    areturn 
L79:    bipush 8 
L81:    areturn 
L82:    bipush 8 
L84:    areturn 
L85:    bipush 8 
L87:    areturn 
L88:    iload_1 
L89:    lookupswitch 
            2 : L191 
            3 : L193 
            4 : L195 
            5 : L199 
            6 : L204 
            7 : L197 
            8 : L201 
            9 : L209 
            10 : L206 
            11 : L212 
            255 : L188 
            default : L215 

L188:   bipush 9 
L190:   areturn 
L191:   iconst_0 
L192:   areturn 
L193:   iconst_1 
L194:   areturn 
L195:   iconst_2 
L196:   areturn 
L197:   iconst_5 
L198:   areturn 
L199:   iconst_3 
L200:   areturn 
L201:   bipush 6 
L203:   areturn 
L204:   iconst_4 
L205:   areturn 
L206:   bipush 15 
L208:   areturn 
L209:   bipush 14 
L211:   areturn 
L212:   bipush 11 
L214:   areturn 
L215:   bipush 8 
L217:   areturn 
L218:   bipush 8 
L220:   areturn 
L221:   nop 
L222:   nop 
L223:   nop 
L224:   
    .end code 
.end method 

.method private static [359] : [360] 
    .attribute [356] .code stack 2 locals 1 
L0:     bipush 12 
L2:     istore_1 
L3:     iload_0 
L4:     ifeq L17 
L7:     iload_0 
L8:     iconst_2 
L9:     if_icmpeq L17 
L12:    iload_0 
L13:    iconst_1 
L14:    if_icmpne L23 
L17:    bipush 12 
L19:    istore_1 
L20:    goto L30 
L23:    iload_0 
L24:    iconst_3 
L25:    if_icmpne L30 
L28:    iconst_0 
L29:    istore_1 
L30:    iload_1 
L31:    areturn 
L32:    
    .end code 
.end method 

.method public [361] : [362] 
    .attribute [356] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [52] 
L6:     aload_0 
L7:     iconst_m1 
L8:     putfield [60] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [363] : [364] 
    .attribute [356] .code stack 8 locals 0 
L0:     aload_0 
L1:     invokespecial [53] 
L4:     aload_0 
L5:     new [61] 
L8:     dup 
L9:     getstatic [7] 
L12:    ifnonnull L27 
L15:    ldc [8] 
L17:    invokestatic [9] 
L20:    dup 
L21:    putstatic [54] 
L24:    goto L30 
L27:    getstatic [7] 
L30:    invokevirtual [35] 
L33:    aload_0 
L34:    aconst_null 
L35:    aload_0 
L36:    invokevirtual [36] 
L39:    invokeinterface [62] 0 
L44:    aload_0 
L45:    getfield [37] 
L48:    invokespecial [55] 
L51:    putfield [63] 
L54:    aload_0 
L55:    getfield [38] 
L58:    invokevirtual [39] 
L61:    return 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [365] : [366] 
    .attribute [356] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [56] 
L4:     aload_0 
L5:     getfield [38] 
L8:     ifnull L23 
L11:    aload_0 
L12:    getfield [38] 
L15:    invokevirtual [40] 
L18:    aload_0 
L19:    aconst_null 
L20:    putfield [63] 
L23:    return 
L24:    
    .end code 
.end method 

.method protected [367] : [368] 
    .attribute [356] .code stack 1 locals 0 
L0:     aload_2 
L1:     ifnull L17 
L4:     aload_2 
L5:     invokeinterface [64] 0 
L10:    ifnull L17 
L13:    iconst_1 
L14:    goto L18 
L17:    iconst_0 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 

.method protected [369] : [370] 
    .attribute [356] .code stack 4 locals 7 
L0:     aload_0 
L1:     invokevirtual [41] 
L4:     astore_1 
L5:     aload_1 
L6:     ifnull L18 
L9:     aload_1 
L10:    invokeinterface [65] 0 
L15:    goto L19 
L18:    aconst_null 
L19:    astore_2 
L20:    aload_2 
L21:    ifnull L37 
L24:    aload_2 
L25:    invokeinterface [66] 0 
L30:    ifeq L37 
L33:    iconst_1 
L34:    goto L38 
L37:    iconst_0 
L38:    istore_3 
L39:    iload_3 
L40:    ifeq L54 
L43:    aload_0 
L44:    invokevirtual [42] 
L47:    iconst_0 
L48:    invokeinterface [67] 0 
L53:    return 
L54:    aload_0 
L55:    invokevirtual [43] 
L58:    astore 4 
L60:    aload 4 
L62:    ifnull L142 
L65:    aload 4 
L67:    invokeinterface [68] 0 
L72:    ifnull L142 
L75:    aload 4 
L77:    invokeinterface [69] 0 
L82:    ifnull L142 
L85:    aload 4 
L87:    invokeinterface [69] 0 
L92:    invokevirtual [44] 
L95:    iconst_1 
L96:    if_icmpeq L142 
L99:    aload 4 
L101:   invokeinterface [68] 0 
L106:   invokevirtual [45] 
L109:   istore 5 
L111:   aload 4 
L113:   invokeinterface [69] 0 
L118:   invokevirtual [44] 
L121:   istore 6 
L123:   aload 4 
L125:   invokeinterface [70] 0 
L130:   istore 7 
L132:   aload_0 
L133:   iload 5 
L135:   iload 6 
L137:   iload 7 
L139:   invokespecial [57] 
L142:   return 
L143:   nop 
L144:   
    .end code 
.end method 

.method private [371] : [372] 
    .attribute [356] .code stack 4 locals 3 
L0:     aload_0 
L1:     invokevirtual [42] 
L4:     astore 4 
L6:     aload 4 
L8:     ifnull L140 
L11:    iload_1 
L12:    iload_2 
L13:    iload_3 
L14:    invokestatic [10] 
L17:    istore 5 
L19:    iload 5 
L21:    aload_0 
L22:    getfield [34] 
L25:    if_icmpeq L137 
L28:    aload_0 
L29:    getfield [37] 
L32:    invokevirtual [46] 
L35:    ifeq L122 
L38:    new [71] 
L41:    dup 
L42:    invokespecial [58] 
L45:    astore 6 
L47:    aload 6 
L49:    ldc [12] 
L51:    invokevirtual [47] 
L54:    pop 
L55:    aload 6 
L57:    iload_1 
L58:    invokevirtual [48] 
L61:    pop 
L62:    aload 6 
L64:    ldc [13] 
L66:    invokevirtual [47] 
L69:    pop 
L70:    aload 6 
L72:    iload_2 
L73:    invokevirtual [48] 
L76:    pop 
L77:    aload 6 
L79:    ldc [14] 
L81:    invokevirtual [47] 
L84:    pop 
L85:    aload 6 
L87:    iload_3 
L88:    invokevirtual [48] 
L91:    pop 
L92:    aload 6 
L94:    ldc [15] 
L96:    invokevirtual [47] 
L99:    pop 
L100:   aload 6 
L102:   iload 5 
L104:   invokevirtual [48] 
L107:   pop 
L108:   aload_0 
L109:   getfield [37] 
L112:   ldc [16] 
L114:   ldc [17] 
L116:   aload 6 
L118:   invokevirtual [49] 
L121:   pop 
L122:   aload 4 
L124:   iload 5 
L126:   invokeinterface [67] 0 
L131:   aload_0 
L132:   iload 5 
L134:   putfield [60] 
L137:   goto L152 
L140:   aload_0 
L141:   getfield [37] 
L144:   ldc [18] 
L146:   ldc [19] 
L148:   invokevirtual [50] 
L151:   pop 
L152:   return 
L153:   nop 
L154:   nop 
L155:   nop 
L156:   
    .end code 
.end method 

.method public [373] : [374] 
    .attribute [356] .code stack 4 locals 4 
L0:     aload_0 
L1:     getfield [37] 
L4:     ldc [16] 
L6:     ldc [20] 
L8:     invokevirtual [50] 
L11:    pop 
L12:    aload_0 
L13:    invokevirtual [41] 
L16:    astore_1 
L17:    aload_1 
L18:    ifnull L61 
L21:    aload_1 
L22:    invokeinterface [72] 0 
L27:    ifnull L61 
L30:    aload_1 
L31:    invokeinterface [72] 0 
L36:    invokevirtual [45] 
L39:    istore_2 
L40:    aload_1 
L41:    invokeinterface [73] 0 
L46:    istore 4 
L48:    aload_0 
L49:    iload_2 
L50:    sipush 255 
L53:    iload 4 
L55:    invokespecial [57] 
L58:    goto L74 
L61:    aload_0 
L62:    getfield [37] 
L65:    sipush 10000 
L68:    ldc [21] 
L70:    invokevirtual [50] 
L73:    pop 
L74:    return 
L75:    nop 
L76:    
    .end code 
.end method 

.method static synthetic [375] : [376] 
    .attribute [356] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [59] 
L9:     dup 
L10:    invokespecial [51] 
L13:    aload_1 
L14:    invokevirtual [33] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [74] [75] 
.const [3] = Class [76] 
.const [4] = Class [77] 
.const [5] = Method [78] [79] 
.const [6] = Class [80] 
.const [7] = Field [81] [82] 
.const [8] = String [83] 
.const [9] = Method [84] [85] 
.const [10] = Method [86] [87] 
.const [11] = Class [88] 
.const [12] = String [89] 
.const [13] = String [90] 
.const [14] = String [91] 
.const [15] = String [92] 
.const [16] = Int 1078071040 
.const [17] = String [93] 
.const [18] = Int -1601830656 
.const [19] = String [94] 
.const [20] = String [95] 
.const [21] = String [96] 
.const [22] = Class [97] 
.const [23] = Class [98] 
.const [24] = Class [99] 
.const [25] = Class [100] 
.const [26] = Class [101] 
.const [27] = Class [102] 
.const [28] = Class [103] 
.const [29] = Class [104] 
.const [30] = Class [105] 
.const [31] = Class [106] 
.const [32] = Class [107] 
.const [33] = Method [108] [109] 
.const [34] = Field [110] [111] 
.const [35] = Method [112] [113] 
.const [36] = Method [114] [115] 
.const [37] = Field [116] [117] 
.const [38] = Field [118] [119] 
.const [39] = Method [120] [121] 
.const [40] = Method [122] [123] 
.const [41] = Method [124] [125] 
.const [42] = Method [126] [127] 
.const [43] = Method [128] [129] 
.const [44] = Method [130] [131] 
.const [45] = Method [132] [133] 
.const [46] = Method [134] [135] 
.const [47] = Method [136] [137] 
.const [48] = Method [138] [139] 
.const [49] = Method [140] [141] 
.const [50] = Method [142] [143] 
.const [51] = Method [144] [145] 
.const [52] = Method [146] [147] 
.const [53] = Method [148] [149] 
.const [54] = Field [150] [151] 
.const [55] = Method [152] [153] 
.const [56] = Method [154] [155] 
.const [57] = Method [156] [157] 
.const [58] = Method [158] [159] 
.const [59] = Class [160] 
.const [60] = Field [161] [162] 
.const [61] = Class [163] 
.const [62] = InterfaceMethod [164] [165] 
.const [63] = Field [166] [167] 
.const [64] = InterfaceMethod [168] [169] 
.const [65] = InterfaceMethod [170] [171] 
.const [66] = InterfaceMethod [172] [173] 
.const [67] = InterfaceMethod [174] [175] 
.const [68] = InterfaceMethod [176] [177] 
.const [69] = InterfaceMethod [178] [179] 
.const [70] = InterfaceMethod [180] [181] 
.const [71] = Class [182] 
.const [72] = InterfaceMethod [183] [184] 
.const [73] = InterfaceMethod [185] [186] 
.const [74] = Class [187] 
.const [75] = NameAndType [188] [189] 
.const [76] = Utf8 java/lang/ClassNotFoundException 
.const [77] = Utf8 java/lang/NoClassDefFoundError 
.const [78] = Class [190] 
.const [79] = NameAndType [191] [192] 
.const [80] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [81] = Class [193] 
.const [82] = NameAndType [194] [195] 
.const [83] = Utf8 'de.audi.app.phone.core.bap.telephone.IBAPPropertyTelLockStateService' 
.const [84] = Class [196] 
.const [85] = NameAndType [197] [198] 
.const [86] = Class [199] 
.const [87] = NameAndType [200] [201] 
.const [88] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [89] = Utf8 'activationState=' 
.const [90] = Utf8 ', lockState=' 
.const [91] = Utf8 ', telMode=' 
.const [92] = Utf8 ' --> clusterLockState=' 
.const [93] = Utf8 '[BAPPropertyTelLockState#updateCluster] %1' 
.const [94] = Utf8 '[BAPPropertyTelLockState#updateCluster] CombiBAPServicePhone is null --> NOP!' 
.const [95] = Utf8 '[BAPPropertyTelLockState#updateLockStatePUKNewPINRequired]' 
.const [96] = Utf8 'BAPPropertyTelLockState#updateLockStatePUKNewPINRequired state or activation state is null' 
.const [97] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelLockState 
.const [98] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [99] = Utf8 java/lang/Class 
.const [100] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [101] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [102] = Utf8 de/audi/atip/interapp/phone/IEcallState 
.const [103] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone 
.const [104] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [105] = Utf8 org/dsi/ifc/telephoneng/LockStateStruct 
.const [106] = Utf8 org/dsi/ifc/telephoneng/ActivationStateStruct 
.const [107] = Utf8 de/audi/atip/log/LogChannel 
.const [108] = Class [202] 
.const [109] = NameAndType [203] [204] 
.const [110] = Class [205] 
.const [111] = NameAndType [206] [207] 
.const [112] = Class [208] 
.const [113] = NameAndType [209] [210] 
.const [114] = Class [211] 
.const [115] = NameAndType [212] [213] 
.const [116] = Class [214] 
.const [117] = NameAndType [215] [216] 
.const [118] = Class [217] 
.const [119] = NameAndType [218] [219] 
.const [120] = Class [220] 
.const [121] = NameAndType [221] [222] 
.const [122] = Class [223] 
.const [123] = NameAndType [224] [225] 
.const [124] = Class [226] 
.const [125] = NameAndType [227] [228] 
.const [126] = Class [229] 
.const [127] = NameAndType [230] [231] 
.const [128] = Class [232] 
.const [129] = NameAndType [233] [234] 
.const [130] = Class [235] 
.const [131] = NameAndType [236] [237] 
.const [132] = Class [238] 
.const [133] = NameAndType [239] [240] 
.const [134] = Class [241] 
.const [135] = NameAndType [242] [243] 
.const [136] = Class [244] 
.const [137] = NameAndType [245] [246] 
.const [138] = Class [247] 
.const [139] = NameAndType [248] [249] 
.const [140] = Class [250] 
.const [141] = NameAndType [251] [252] 
.const [142] = Class [253] 
.const [143] = NameAndType [254] [255] 
.const [144] = Class [256] 
.const [145] = NameAndType [257] [258] 
.const [146] = Class [259] 
.const [147] = NameAndType [260] [261] 
.const [148] = Class [262] 
.const [149] = NameAndType [263] [264] 
.const [150] = Class [265] 
.const [151] = NameAndType [266] [267] 
.const [152] = Class [268] 
.const [153] = NameAndType [269] [270] 
.const [154] = Class [271] 
.const [155] = NameAndType [272] [273] 
.const [156] = Class [274] 
.const [157] = NameAndType [275] [276] 
.const [158] = Class [277] 
.const [159] = NameAndType [278] [279] 
.const [160] = Utf8 java/lang/NoClassDefFoundError 
.const [161] = Class [280] 
.const [162] = NameAndType [281] [282] 
.const [163] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [164] = Class [283] 
.const [165] = NameAndType [284] [285] 
.const [166] = Class [286] 
.const [167] = NameAndType [287] [288] 
.const [168] = Class [289] 
.const [169] = NameAndType [290] [291] 
.const [170] = Class [292] 
.const [171] = NameAndType [293] [294] 
.const [172] = Class [295] 
.const [173] = NameAndType [296] [297] 
.const [174] = Class [298] 
.const [175] = NameAndType [299] [300] 
.const [176] = Class [301] 
.const [177] = NameAndType [302] [303] 
.const [178] = Class [304] 
.const [179] = NameAndType [305] [306] 
.const [180] = Class [307] 
.const [181] = NameAndType [308] [309] 
.const [182] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [183] = Class [310] 
.const [184] = NameAndType [311] [312] 
.const [185] = Class [313] 
.const [186] = NameAndType [314] [315] 
.const [187] = Utf8 java/lang/Class 
.const [188] = Utf8 forName 
.const [189] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [190] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelLockState 
.const [191] = Utf8 calculateLockStateOnAttachedNotReady 
.const [192] = Utf8 (I)I 
.const [193] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelLockState 
.const [194] = Utf8 class$de$audi$app$phone$core$bap$telephone$IBAPPropertyTelLockStateService 
.const [195] = Utf8 Ljava/lang/Class; 
.const [196] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelLockState 
.const [197] = Utf8 class$ 
.const [198] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [199] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelLockState 
.const [200] = Utf8 getLockState 
.const [201] = Utf8 (III)I 
.const [202] = Utf8 java/lang/NoClassDefFoundError 
.const [203] = Utf8 initCause 
.const [204] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [205] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelLockState 
.const [206] = Utf8 currentCombiLockState 
.const [207] = Utf8 I 
.const [208] = Utf8 java/lang/Class 
.const [209] = Utf8 getName 
.const [210] = Utf8 ()Ljava/lang/String; 
.const [211] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelLockState 
.const [212] = Utf8 getApplication 
.const [213] = Utf8 ()Lde/audi/app/phone/core/ITelApplication; 
.const [214] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelLockState 
.const [215] = Utf8 log 
.const [216] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [217] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelLockState 
.const [218] = Utf8 lockStateServiceProvider 
.const [219] = Utf8 Lde/audi/app/phone/core/PhoneServiceProvider; 
.const [220] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [221] = Utf8 startService 
.const [222] = Utf8 ()V 
.const [223] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [224] = Utf8 stopService 
.const [225] = Utf8 ()V 
.const [226] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelLockState 
.const [227] = Utf8 getTelephoneState 
.const [228] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [229] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelLockState 
.const [230] = Utf8 getCombiService 
.const [231] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone; 
.const [232] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelLockState 
.const [233] = Utf8 getCallLeadingDeviceState 
.const [234] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [235] = Utf8 org/dsi/ifc/telephoneng/LockStateStruct 
.const [236] = Utf8 getTelLockState 
.const [237] = Utf8 ()I 
.const [238] = Utf8 org/dsi/ifc/telephoneng/ActivationStateStruct 
.const [239] = Utf8 getTelActivationState 
.const [240] = Utf8 ()I 
.const [241] = Utf8 de/audi/atip/log/LogChannel 
.const [242] = Utf8 isInfo 
.const [243] = Utf8 ()Z 
.const [244] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [245] = Utf8 append 
.const [246] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [247] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [248] = Utf8 append 
.const [249] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [250] = Utf8 de/audi/atip/log/LogChannel 
.const [251] = Utf8 log 
.const [252] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [253] = Utf8 de/audi/atip/log/LogChannel 
.const [254] = Utf8 log 
.const [255] = Utf8 (ILjava/lang/String;)Z 
.const [256] = Utf8 java/lang/NoClassDefFoundError 
.const [257] = Utf8 <init> 
.const [258] = Utf8 ()V 
.const [259] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [260] = Utf8 <init> 
.const [261] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [262] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [263] = Utf8 init 
.const [264] = Utf8 ()V 
.const [265] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelLockState 
.const [266] = Utf8 class$de$audi$app$phone$core$bap$telephone$IBAPPropertyTelLockStateService 
.const [267] = Utf8 Ljava/lang/Class; 
.const [268] = Utf8 de/audi/app/phone/core/PhoneServiceProvider 
.const [269] = Utf8 <init> 
.const [270] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Hashtable;Lorg/osgi/framework/BundleContext;Lde/audi/atip/log/LogChannel;)V 
.const [271] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [272] = Utf8 deinit 
.const [273] = Utf8 ()V 
.const [274] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelLockState 
.const [275] = Utf8 updateCluster 
.const [276] = Utf8 (III)V 
.const [277] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [278] = Utf8 <init> 
.const [279] = Utf8 ()V 
.const [280] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelLockState 
.const [281] = Utf8 currentCombiLockState 
.const [282] = Utf8 I 
.const [283] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [284] = Utf8 getBundleContext 
.const [285] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [286] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelLockState 
.const [287] = Utf8 lockStateServiceProvider 
.const [288] = Utf8 Lde/audi/app/phone/core/PhoneServiceProvider; 
.const [289] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [290] = Utf8 getCallLeadingDevice 
.const [291] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [292] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [293] = Utf8 getConnectedGatewayState 
.const [294] = Utf8 ()Lde/audi/atip/interapp/phone/IEcallState; 
.const [295] = Utf8 de/audi/atip/interapp/phone/IEcallState 
.const [296] = Utf8 isLowPrioritySOSEmergencyCallType 
.const [297] = Utf8 ()Z 
.const [298] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone 
.const [299] = Utf8 updateLockState 
.const [300] = Utf8 (I)V 
.const [301] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [302] = Utf8 getActivationState 
.const [303] = Utf8 ()Lorg/dsi/ifc/telephoneng/ActivationStateStruct; 
.const [304] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [305] = Utf8 getLockState 
.const [306] = Utf8 ()Lorg/dsi/ifc/telephoneng/LockStateStruct; 
.const [307] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [308] = Utf8 getTelMode 
.const [309] = Utf8 ()I 
.const [310] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [311] = Utf8 getActivationState 
.const [312] = Utf8 ()Lorg/dsi/ifc/telephoneng/ActivationStateStruct; 
.const [313] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [314] = Utf8 getTelMode 
.const [315] = Utf8 ()I 
.const [316] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelLockState 
.const [317] = Class [316] 
.const [318] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [319] = Class [318] 
.const [320] = Utf8 de/audi/app/phone/core/bap/telephone/IBAPPropertyTelLockStateService 
.const [321] = Class [320] 
.const [322] = Utf8 LOCK_STATE_PUK_REQUIRED_ENTER_NEW_PIN 
.const [323] = Utf8 I 
.const [324] = Utf8 LOCK_STATE_NO_LOCK 
.const [325] = Utf8 I 
.const [326] = Utf8 LOCK_STATE_REQUIRE_PIN 
.const [327] = Utf8 I 
.const [328] = Utf8 LOCK_STATE_REQUIRE_PIN2 
.const [329] = Utf8 I 
.const [330] = Utf8 LOCK_STATE_PIN_BLOCKED_REQUIRE_PUK 
.const [331] = Utf8 I 
.const [332] = Utf8 LOCK_STATE_PIN2BLOCKED_REQUIRE_PUK2 
.const [333] = Utf8 I 
.const [334] = Utf8 LOCK_STATE_PUK_BLOCKED 
.const [335] = Utf8 I 
.const [336] = Utf8 LOCK_STATE_PUK2BLOCKED 
.const [337] = Utf8 I 
.const [338] = Utf8 LOCK_STATE_SIM_NOT_AVAILABLE_NOT_PLUGGED_IN 
.const [339] = Utf8 I 
.const [340] = Utf8 LOCK_STATE_PI_NINVALID 
.const [341] = Utf8 I 
.const [342] = Utf8 LOCK_STATE_SI_MNOT_FUNCTIONAL_NOT_READABLE_OR_NOT_FUNCTIONAL 
.const [343] = Utf8 I 
.const [344] = Utf8 LOCK_STATE_SI_MNOT_READY_CHECKING_SIM_CARD 
.const [345] = Utf8 I 
.const [346] = Utf8 LOCK_STATE_REQUIRE_SECURITY_CODE 
.const [347] = Utf8 I 
.const [348] = Utf8 LOCK_STATE_SECURITY_CODE_BLOCKED 
.const [349] = Utf8 I 
.const [350] = Utf8 lockStateServiceProvider 
.const [351] = Utf8 Lde/audi/app/phone/core/PhoneServiceProvider; 
.const [352] = Utf8 currentCombiLockState 
.const [353] = Utf8 I 
.const [354] = Utf8 class$de$audi$app$phone$core$bap$telephone$IBAPPropertyTelLockStateService 
.const [355] = Utf8 Ljava/lang/Class; 
.const [356] = Utf8 Code 
.const [357] = Utf8 getLockState 
.const [358] = Utf8 (III)I 
.const [359] = Utf8 calculateLockStateOnAttachedNotReady 
.const [360] = Utf8 (I)I 
.const [361] = Utf8 <init> 
.const [362] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [363] = Utf8 init 
.const [364] = Utf8 ()V 
.const [365] = Utf8 deinit 
.const [366] = Utf8 ()V 
.const [367] = Utf8 doProcessGlobalTelephoneStateUpdate 
.const [368] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)Z 
.const [369] = Utf8 updateAsync 
.const [370] = Utf8 ()V 
.const [371] = Utf8 updateCluster 
.const [372] = Utf8 (III)V 
.const [373] = Utf8 updateLockStatePUKNewPINRequired 
.const [374] = Utf8 ()V 
.const [375] = Utf8 class$ 
.const [376] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
