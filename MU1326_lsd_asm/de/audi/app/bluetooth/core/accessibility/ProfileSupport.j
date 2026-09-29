.version 50 0 
.class public super [354] 
.super [356] 
.implements [358] 
.implements [360] 
.field private static final [361] [362] 
.field private volatile [363] [364] 
.field private volatile [365] [366] 
.field private volatile [367] [368] 
.field private volatile [369] [370] 
.field private volatile [371] [372] 
.field private volatile [373] [374] 
.field private [375] [376] 
.field static synthetic [377] [378] 

.method public [380] : [381] 
    .attribute [379] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [54] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [62] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [382] : [383] 
    .attribute [379] .code stack 1 locals 0 
L0:     getstatic [5] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [384] : [385] 
    .attribute [379] .code stack 4 locals 0 
L0:     iload_2 
L1:     iconst_1 
L2:     if_icmpeq L6 
L5:     return 
L6:     aload_0 
L7:     getfield [34] 
L10:    ldc [6] 
L12:    ldc [7] 
L14:    iload_1 
L15:    invokestatic [8] 
L18:    invokevirtual [35] 
L21:    pop 
L22:    aload_0 
L23:    iload_1 
L24:    putfield [62] 
L27:    aload_0 
L28:    getfield [36] 
L31:    invokeinterface [63] 0 
L36:    invokeinterface [64] 0 
L41:    aload_0 
L42:    getfield [36] 
L45:    invokeinterface [65] 0 
L50:    iload_1 
L51:    iconst_2 
L52:    iand 
L53:    ifle L60 
L56:    iconst_1 
L57:    goto L61 
L60:    iconst_0 
L61:    invokeinterface [66] 0 
L66:    return 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [386] : [387] 
    .attribute [379] .code stack 2 locals 3 
L0:     iload_2 
L1:     iconst_1 
L2:     if_icmpne L83 
L5:     aload_1 
L6:     ifnull L83 
L9:     iconst_0 
L10:    istore_3 
L11:    iconst_0 
L12:    istore 4 
L14:    iconst_0 
L15:    istore 5 
L17:    iload 5 
L19:    aload_1 
L20:    arraylength 
L21:    if_icmpge L65 
L24:    aload_1 
L25:    iload 5 
L27:    aaload 
L28:    invokevirtual [37] 
L31:    iconst_4 
L32:    iand 
L33:    ifle L59 
L36:    iconst_1 
L37:    istore_3 
L38:    aload_1 
L39:    iload 5 
L41:    aaload 
L42:    invokevirtual [38] 
L45:    iconst_1 
L46:    if_icmpne L53 
L49:    iconst_1 
L50:    goto L54 
L53:    iconst_0 
L54:    istore 4 
L56:    goto L65 
L59:    iinc 5 1 
L62:    goto L17 
L65:    aload_0 
L66:    iload_3 
L67:    ifeq L79 
L70:    iload 4 
L72:    ifeq L79 
L75:    iconst_1 
L76:    goto L80 
L79:    iconst_0 
L80:    putfield [67] 
L83:    return 
L84:    
    .end code 
.end method 

.method public [388] : [389] 
    .attribute [379] .code stack 6 locals 1 
L0:     iconst_0 
L1:     istore_3 
L2:     iload_1 
L3:     ifne L101 
L6:     aload_0 
L7:     getfield [34] 
L10:    ldc [6] 
L12:    ldc [9] 
L14:    aload_0 
L15:    getfield [40] 
L18:    ifeq L32 
L21:    aload_0 
L22:    getfield [41] 
L25:    ifne L32 
L28:    iconst_1 
L29:    goto L33 
L32:    iconst_0 
L33:    aload_0 
L34:    getfield [33] 
L37:    i2l 
L38:    invokevirtual [42] 
L41:    pop 
L42:    aload_0 
L43:    getfield [33] 
L46:    bipush 6 
L48:    iand 
L49:    istore_3 
L50:    aload_0 
L51:    getfield [39] 
L54:    ifeq L66 
L57:    iload_2 
L58:    ifne L66 
L61:    iload_3 
L62:    bipush -5 
L64:    iand 
L65:    istore_3 
L66:    aload_0 
L67:    getfield [40] 
L70:    ifeq L84 
L73:    aload_0 
L74:    getfield [41] 
L77:    ifne L84 
L80:    iload_3 
L81:    iconst_2 
L82:    ior 
L83:    istore_3 
L84:    aload_0 
L85:    getfield [34] 
L88:    ldc [6] 
L90:    ldc [10] 
L92:    iload_3 
L93:    i2l 
L94:    invokevirtual [43] 
L97:    pop 
L98:    goto L172 
L101:   iload_1 
L102:   iconst_1 
L103:   if_icmpne L116 
L106:   aload_0 
L107:   getfield [33] 
L110:   iconst_4 
L111:   iand 
L112:   istore_3 
L113:   goto L172 
L116:   iload_1 
L117:   iconst_3 
L118:   if_icmpne L127 
L121:   ldc [11] 
L123:   istore_3 
L124:   goto L172 
L127:   iload_1 
L128:   iconst_4 
L129:   if_icmpne L138 
L132:   ldc [12] 
L134:   istore_3 
L135:   goto L172 
L138:   iload_1 
L139:   bipush 6 
L141:   if_icmpne L172 
L144:   aload_0 
L145:   iconst_0 
L146:   iload_2 
L147:   invokevirtual [44] 
L150:   aload_0 
L151:   iconst_1 
L152:   iload_2 
L153:   invokevirtual [44] 
L156:   ior 
L157:   aload_0 
L158:   iconst_3 
L159:   iload_2 
L160:   invokevirtual [44] 
L163:   ior 
L164:   aload_0 
L165:   iconst_4 
L166:   iload_2 
L167:   invokevirtual [44] 
L170:   ior 
L171:   istore_3 
L172:   iload_3 
L173:   areturn 
L174:   nop 
L175:   nop 
L176:   
    .end code 
.end method 

.method public [390] : [391] 
    .attribute [379] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [33] 
L4:     iconst_2 
L5:     iand 
L6:     ifne L20 
L9:     aload_0 
L10:    getfield [40] 
L13:    ifeq L20 
L16:    iconst_1 
L17:    goto L21 
L20:    iconst_0 
L21:    areturn 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [392] : [393] 
    .attribute [379] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iconst_1 
L3:     if_icmpne L10 
L6:     iconst_1 
L7:     goto L11 
L10:    iconst_0 
L11:    putfield [70] 
L14:    aload_0 
L15:    invokespecial [56] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method private [394] : [395] 
    .attribute [379] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [45] 
L4:     ifeq L34 
L7:     aload_0 
L8:     getfield [46] 
L11:    ifeq L34 
L14:    aload_0 
L15:    getfield [34] 
L18:    ldc [6] 
L20:    ldc [13] 
L22:    invokevirtual [47] 
L25:    pop 
L26:    aload_0 
L27:    iconst_1 
L28:    putfield [68] 
L31:    goto L58 
L34:    aload_0 
L35:    getfield [40] 
L38:    ifeq L53 
L41:    aload_0 
L42:    getfield [34] 
L45:    ldc [6] 
L47:    ldc [14] 
L49:    invokevirtual [47] 
L52:    pop 
L53:    aload_0 
L54:    iconst_0 
L55:    putfield [68] 
L58:    return 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [396] : [397] 
    .attribute [379] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ifnull L14 
L5:     aload_1 
L6:     invokeinterface [72] 0 
L11:    ifne L27 
L14:    aload_2 
L15:    ifnull L31 
L18:    aload_2 
L19:    invokeinterface [72] 0 
L24:    ifeq L31 
L27:    iconst_1 
L28:    goto L32 
L31:    iconst_0 
L32:    putfield [69] 
L35:    aload_0 
L36:    aload_3 
L37:    ifnull L53 
L40:    aload_3 
L41:    invokeinterface [73] 0 
L46:    ifeq L53 
L49:    iconst_1 
L50:    goto L54 
L53:    iconst_0 
L54:    putfield [71] 
L57:    aload_0 
L58:    invokespecial [56] 
L61:    return 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public enum [398] : [399] 
    .attribute [379] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [400] : [401] 
    .attribute [379] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [402] : [403] 
    .attribute [379] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [404] : [405] 
    .attribute [379] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [406] : [407] 
    .attribute [379] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [408] : [409] 
    .attribute [379] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [410] : [411] 
    .attribute [379] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokespecial [57] 
L4:     aload_0 
L5:     aload_0 
L6:     getfield [36] 
L9:     invokeinterface [74] 0 
L14:    getstatic [15] 
L17:    ifnonnull L32 
L20:    ldc [16] 
L22:    invokestatic [17] 
L25:    dup 
L26:    putstatic [58] 
L29:    goto L35 
L32:    getstatic [15] 
L35:    invokevirtual [48] 
L38:    aload_0 
L39:    aconst_null 
L40:    invokeinterface [75] 0 
L45:    putfield [76] 
L48:    return 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [412] : [413] 
    .attribute [379] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [49] 
L4:     invokeinterface [77] 0 
L9:     aload_0 
L10:    aconst_null 
L11:    putfield [76] 
L14:    aload_0 
L15:    invokespecial [59] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [414] : [415] 
    .attribute [379] .code stack 2 locals 0 
L0:     new [78] 
L3:     dup 
L4:     invokespecial [60] 
L7:     ldc [19] 
L9:     invokevirtual [50] 
L12:    aload_0 
L13:    getfield [33] 
L16:    invokevirtual [51] 
L19:    invokevirtual [52] 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 

.method static synthetic [416] : [417] 
    .attribute [379] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [61] 
L9:     dup 
L10:    invokespecial [53] 
L13:    aload_1 
L14:    invokevirtual [32] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static [418] : [419] 
    .attribute [379] .code stack 4 locals 0 
L0:     iconst_2 
L1:     newarray int 
L3:     dup 
L4:     iconst_0 
L5:     bipush 12 
L7:     iastore 
L8:     dup 
L9:     iconst_1 
L10:    bipush 6 
L12:    iastore 
L13:    putstatic [55] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [79] [80] 
.const [3] = Class [81] 
.const [4] = Class [82] 
.const [5] = Field [83] [84] 
.const [6] = Int 1078071040 
.const [7] = String [85] 
.const [8] = Method [86] [87] 
.const [9] = String [88] 
.const [10] = String [89] 
.const [11] = Int 256 
.const [12] = Int 536895488 
.const [13] = String [90] 
.const [14] = String [91] 
.const [15] = Field [92] [93] 
.const [16] = String [94] 
.const [17] = Method [95] [96] 
.const [18] = Class [97] 
.const [19] = String [98] 
.const [20] = Class [99] 
.const [21] = Class [100] 
.const [22] = Class [101] 
.const [23] = Class [102] 
.const [24] = Class [103] 
.const [25] = Class [104] 
.const [26] = Class [105] 
.const [27] = Class [106] 
.const [28] = Class [107] 
.const [29] = Class [108] 
.const [30] = Class [109] 
.const [31] = Class [110] 
.const [32] = Method [111] [112] 
.const [33] = Field [113] [114] 
.const [34] = Field [115] [116] 
.const [35] = Method [117] [118] 
.const [36] = Field [119] [120] 
.const [37] = Method [121] [122] 
.const [38] = Method [123] [124] 
.const [39] = Field [125] [126] 
.const [40] = Field [127] [128] 
.const [41] = Field [129] [130] 
.const [42] = Method [131] [132] 
.const [43] = Method [133] [134] 
.const [44] = Method [135] [136] 
.const [45] = Field [137] [138] 
.const [46] = Field [139] [140] 
.const [47] = Method [141] [142] 
.const [48] = Method [143] [144] 
.const [49] = Field [145] [146] 
.const [50] = Method [147] [148] 
.const [51] = Method [149] [150] 
.const [52] = Method [151] [152] 
.const [53] = Method [153] [154] 
.const [54] = Method [155] [156] 
.const [55] = Field [157] [158] 
.const [56] = Method [159] [160] 
.const [57] = Method [161] [162] 
.const [58] = Field [163] [164] 
.const [59] = Method [165] [166] 
.const [60] = Method [167] [168] 
.const [61] = Class [169] 
.const [62] = Field [170] [171] 
.const [63] = InterfaceMethod [172] [173] 
.const [64] = InterfaceMethod [174] [175] 
.const [65] = InterfaceMethod [176] [177] 
.const [66] = InterfaceMethod [178] [179] 
.const [67] = Field [180] [181] 
.const [68] = Field [182] [183] 
.const [69] = Field [184] [185] 
.const [70] = Field [186] [187] 
.const [71] = Field [188] [189] 
.const [72] = InterfaceMethod [190] [191] 
.const [73] = InterfaceMethod [192] [193] 
.const [74] = InterfaceMethod [194] [195] 
.const [75] = InterfaceMethod [196] [197] 
.const [76] = Field [198] [199] 
.const [77] = InterfaceMethod [200] [201] 
.const [78] = Class [202] 
.const [79] = Class [203] 
.const [80] = NameAndType [204] [205] 
.const [81] = Utf8 java/lang/ClassNotFoundException 
.const [82] = Utf8 java/lang/NoClassDefFoundError 
.const [83] = Class [206] 
.const [84] = NameAndType [207] [208] 
.const [85] = Utf8 'ProfileSupport#updateSupportedBTProfiles %1' 
.const [86] = Class [209] 
.const [87] = NameAndType [210] [211] 
.const [88] = Utf8 'ProfileSupport#getConnectableServices(): supportedServices=%2, hfp+=%1' 
.const [89] = Utf8 'ProfileSupport#getConnectableServices(): returning connectable profiles: %1' 
.const [90] = Utf8 'ProfileSupport#updateFakeHfpProfileSupport(): Overwriting HFP profile support!' 
.const [91] = Utf8 'ProfileSupport#updateFakeHfpProfileSupport(): Using original profile support again!' 
.const [92] = Class [212] 
.const [93] = NameAndType [213] [214] 
.const [94] = Utf8 'de.audi.atip.interapp.IConnectivityPhoneStateListener' 
.const [95] = Class [215] 
.const [96] = NameAndType [216] [217] 
.const [97] = Utf8 java/lang/StringBuffer 
.const [98] = Utf8 'Supported Bluetooth profiles: ' 
.const [99] = Utf8 de/audi/app/bluetooth/core/accessibility/ProfileSupport 
.const [100] = Utf8 de/audi/app/bluetooth/core/AbstractBluetoothComponent 
.const [101] = Utf8 java/lang/Class 
.const [102] = Utf8 java/lang/Integer 
.const [103] = Utf8 de/audi/atip/log/LogChannel 
.const [104] = Utf8 de/audi/app/bluetooth/core/IBluetoothApplication 
.const [105] = Utf8 de/audi/app/bluetooth/core/connectivity/trusted/IDeviceProfileList 
.const [106] = Utf8 de/audi/app/bluetooth/core/connectivity/connect/IConnection 
.const [107] = Utf8 org/dsi/ifc/bluetooth/TrustedDevice 
.const [108] = Utf8 de/audi/atip/interapp/phone/ITelMESlotState 
.const [109] = Utf8 org/osgi/framework/BundleContext 
.const [110] = Utf8 org/osgi/framework/ServiceRegistration 
.const [111] = Class [218] 
.const [112] = NameAndType [219] [220] 
.const [113] = Class [221] 
.const [114] = NameAndType [222] [223] 
.const [115] = Class [224] 
.const [116] = NameAndType [225] [226] 
.const [117] = Class [227] 
.const [118] = NameAndType [228] [229] 
.const [119] = Class [230] 
.const [120] = NameAndType [231] [232] 
.const [121] = Class [233] 
.const [122] = NameAndType [234] [235] 
.const [123] = Class [236] 
.const [124] = NameAndType [237] [238] 
.const [125] = Class [239] 
.const [126] = NameAndType [240] [241] 
.const [127] = Class [242] 
.const [128] = NameAndType [243] [244] 
.const [129] = Class [245] 
.const [130] = NameAndType [246] [247] 
.const [131] = Class [248] 
.const [132] = NameAndType [249] [250] 
.const [133] = Class [251] 
.const [134] = NameAndType [252] [253] 
.const [135] = Class [254] 
.const [136] = NameAndType [255] [256] 
.const [137] = Class [257] 
.const [138] = NameAndType [258] [259] 
.const [139] = Class [260] 
.const [140] = NameAndType [261] [262] 
.const [141] = Class [263] 
.const [142] = NameAndType [264] [265] 
.const [143] = Class [266] 
.const [144] = NameAndType [267] [268] 
.const [145] = Class [269] 
.const [146] = NameAndType [270] [271] 
.const [147] = Class [272] 
.const [148] = NameAndType [273] [274] 
.const [149] = Class [275] 
.const [150] = NameAndType [276] [277] 
.const [151] = Class [278] 
.const [152] = NameAndType [279] [280] 
.const [153] = Class [281] 
.const [154] = NameAndType [282] [283] 
.const [155] = Class [284] 
.const [156] = NameAndType [285] [286] 
.const [157] = Class [287] 
.const [158] = NameAndType [288] [289] 
.const [159] = Class [290] 
.const [160] = NameAndType [291] [292] 
.const [161] = Class [293] 
.const [162] = NameAndType [294] [295] 
.const [163] = Class [296] 
.const [164] = NameAndType [297] [298] 
.const [165] = Class [299] 
.const [166] = NameAndType [300] [301] 
.const [167] = Class [302] 
.const [168] = NameAndType [303] [304] 
.const [169] = Utf8 java/lang/NoClassDefFoundError 
.const [170] = Class [305] 
.const [171] = NameAndType [306] [307] 
.const [172] = Class [308] 
.const [173] = NameAndType [309] [310] 
.const [174] = Class [311] 
.const [175] = NameAndType [312] [313] 
.const [176] = Class [314] 
.const [177] = NameAndType [315] [316] 
.const [178] = Class [317] 
.const [179] = NameAndType [318] [319] 
.const [180] = Class [320] 
.const [181] = NameAndType [321] [322] 
.const [182] = Class [323] 
.const [183] = NameAndType [324] [325] 
.const [184] = Class [326] 
.const [185] = NameAndType [327] [328] 
.const [186] = Class [329] 
.const [187] = NameAndType [330] [331] 
.const [188] = Class [332] 
.const [189] = NameAndType [333] [334] 
.const [190] = Class [335] 
.const [191] = NameAndType [336] [337] 
.const [192] = Class [338] 
.const [193] = NameAndType [339] [340] 
.const [194] = Class [341] 
.const [195] = NameAndType [342] [343] 
.const [196] = Class [344] 
.const [197] = NameAndType [345] [346] 
.const [198] = Class [347] 
.const [199] = NameAndType [348] [349] 
.const [200] = Class [350] 
.const [201] = NameAndType [351] [352] 
.const [202] = Utf8 java/lang/StringBuffer 
.const [203] = Utf8 java/lang/Class 
.const [204] = Utf8 forName 
.const [205] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [206] = Utf8 de/audi/app/bluetooth/core/accessibility/ProfileSupport 
.const [207] = Utf8 ATTRIBUTE_NOTIFICATIONS 
.const [208] = Utf8 [I 
.const [209] = Utf8 java/lang/Integer 
.const [210] = Utf8 toHexString 
.const [211] = Utf8 (I)Ljava/lang/String; 
.const [212] = Utf8 de/audi/app/bluetooth/core/accessibility/ProfileSupport 
.const [213] = Utf8 class$de$audi$atip$interapp$IConnectivityPhoneStateListener 
.const [214] = Utf8 Ljava/lang/Class; 
.const [215] = Utf8 de/audi/app/bluetooth/core/accessibility/ProfileSupport 
.const [216] = Utf8 class$ 
.const [217] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [218] = Utf8 java/lang/NoClassDefFoundError 
.const [219] = Utf8 initCause 
.const [220] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [221] = Utf8 de/audi/app/bluetooth/core/accessibility/ProfileSupport 
.const [222] = Utf8 supportedBTProfiles 
.const [223] = Utf8 I 
.const [224] = Utf8 de/audi/app/bluetooth/core/accessibility/ProfileSupport 
.const [225] = Utf8 log 
.const [226] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [227] = Utf8 de/audi/atip/log/LogChannel 
.const [228] = Utf8 log 
.const [229] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [230] = Utf8 de/audi/app/bluetooth/core/accessibility/ProfileSupport 
.const [231] = Utf8 bluetoothApplication 
.const [232] = Utf8 Lde/audi/app/bluetooth/core/IBluetoothApplication; 
.const [233] = Utf8 org/dsi/ifc/bluetooth/TrustedDevice 
.const [234] = Utf8 getActiveServiceTypes 
.const [235] = Utf8 ()I 
.const [236] = Utf8 org/dsi/ifc/bluetooth/TrustedDevice 
.const [237] = Utf8 getDeviceRole 
.const [238] = Utf8 ()I 
.const [239] = Utf8 de/audi/app/bluetooth/core/accessibility/ProfileSupport 
.const [240] = Utf8 isSapPrioConnected 
.const [241] = Utf8 Z 
.const [242] = Utf8 de/audi/app/bluetooth/core/accessibility/ProfileSupport 
.const [243] = Utf8 enableHfpProfile 
.const [244] = Utf8 Z 
.const [245] = Utf8 de/audi/app/bluetooth/core/accessibility/ProfileSupport 
.const [246] = Utf8 callActive 
.const [247] = Utf8 Z 
.const [248] = Utf8 de/audi/atip/log/LogChannel 
.const [249] = Utf8 log 
.const [250] = Utf8 (ILjava/lang/String;ZJ)Z 
.const [251] = Utf8 de/audi/atip/log/LogChannel 
.const [252] = Utf8 log 
.const [253] = Utf8 (ILjava/lang/String;J)Z 
.const [254] = Utf8 de/audi/app/bluetooth/core/accessibility/ProfileSupport 
.const [255] = Utf8 getConnectableServices 
.const [256] = Utf8 (IZ)I 
.const [257] = Utf8 de/audi/app/bluetooth/core/accessibility/ProfileSupport 
.const [258] = Utf8 isNadModeVoiceAndData 
.const [259] = Utf8 Z 
.const [260] = Utf8 de/audi/app/bluetooth/core/accessibility/ProfileSupport 
.const [261] = Utf8 isSimInserted 
.const [262] = Utf8 Z 
.const [263] = Utf8 de/audi/atip/log/LogChannel 
.const [264] = Utf8 log 
.const [265] = Utf8 (ILjava/lang/String;)Z 
.const [266] = Utf8 java/lang/Class 
.const [267] = Utf8 getName 
.const [268] = Utf8 ()Ljava/lang/String; 
.const [269] = Utf8 de/audi/app/bluetooth/core/accessibility/ProfileSupport 
.const [270] = Utf8 serviceRegistration 
.const [271] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [272] = Utf8 java/lang/StringBuffer 
.const [273] = Utf8 append 
.const [274] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [275] = Utf8 java/lang/StringBuffer 
.const [276] = Utf8 append 
.const [277] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [278] = Utf8 java/lang/StringBuffer 
.const [279] = Utf8 toString 
.const [280] = Utf8 ()Ljava/lang/String; 
.const [281] = Utf8 java/lang/NoClassDefFoundError 
.const [282] = Utf8 <init> 
.const [283] = Utf8 ()V 
.const [284] = Utf8 de/audi/app/bluetooth/core/AbstractBluetoothComponent 
.const [285] = Utf8 <init> 
.const [286] = Utf8 (Lde/audi/app/bluetooth/core/IBluetoothApplication;)V 
.const [287] = Utf8 de/audi/app/bluetooth/core/accessibility/ProfileSupport 
.const [288] = Utf8 ATTRIBUTE_NOTIFICATIONS 
.const [289] = Utf8 [I 
.const [290] = Utf8 de/audi/app/bluetooth/core/accessibility/ProfileSupport 
.const [291] = Utf8 updateFakeHfpProfileSupport 
.const [292] = Utf8 ()V 
.const [293] = Utf8 de/audi/app/bluetooth/core/AbstractBluetoothComponent 
.const [294] = Utf8 init 
.const [295] = Utf8 ()V 
.const [296] = Utf8 de/audi/app/bluetooth/core/accessibility/ProfileSupport 
.const [297] = Utf8 class$de$audi$atip$interapp$IConnectivityPhoneStateListener 
.const [298] = Utf8 Ljava/lang/Class; 
.const [299] = Utf8 de/audi/app/bluetooth/core/AbstractBluetoothComponent 
.const [300] = Utf8 deinit 
.const [301] = Utf8 ()V 
.const [302] = Utf8 java/lang/StringBuffer 
.const [303] = Utf8 <init> 
.const [304] = Utf8 ()V 
.const [305] = Utf8 de/audi/app/bluetooth/core/accessibility/ProfileSupport 
.const [306] = Utf8 supportedBTProfiles 
.const [307] = Utf8 I 
.const [308] = Utf8 de/audi/app/bluetooth/core/IBluetoothApplication 
.const [309] = Utf8 getDeviceProfileList 
.const [310] = Utf8 ()Lde/audi/app/bluetooth/core/connectivity/trusted/IDeviceProfileList; 
.const [311] = Utf8 de/audi/app/bluetooth/core/connectivity/trusted/IDeviceProfileList 
.const [312] = Utf8 updateProfiles 
.const [313] = Utf8 ()V 
.const [314] = Utf8 de/audi/app/bluetooth/core/IBluetoothApplication 
.const [315] = Utf8 getConnection 
.const [316] = Utf8 ()Lde/audi/app/bluetooth/core/connectivity/connect/IConnection; 
.const [317] = Utf8 de/audi/app/bluetooth/core/connectivity/connect/IConnection 
.const [318] = Utf8 updateHfpSupport 
.const [319] = Utf8 (Z)V 
.const [320] = Utf8 de/audi/app/bluetooth/core/accessibility/ProfileSupport 
.const [321] = Utf8 isSapPrioConnected 
.const [322] = Utf8 Z 
.const [323] = Utf8 de/audi/app/bluetooth/core/accessibility/ProfileSupport 
.const [324] = Utf8 enableHfpProfile 
.const [325] = Utf8 Z 
.const [326] = Utf8 de/audi/app/bluetooth/core/accessibility/ProfileSupport 
.const [327] = Utf8 callActive 
.const [328] = Utf8 Z 
.const [329] = Utf8 de/audi/app/bluetooth/core/accessibility/ProfileSupport 
.const [330] = Utf8 isNadModeVoiceAndData 
.const [331] = Utf8 Z 
.const [332] = Utf8 de/audi/app/bluetooth/core/accessibility/ProfileSupport 
.const [333] = Utf8 isSimInserted 
.const [334] = Utf8 Z 
.const [335] = Utf8 de/audi/atip/interapp/phone/ITelMESlotState 
.const [336] = Utf8 isCallActive 
.const [337] = Utf8 ()Z 
.const [338] = Utf8 de/audi/atip/interapp/phone/ITelMESlotState 
.const [339] = Utf8 isInternalSim 
.const [340] = Utf8 ()Z 
.const [341] = Utf8 de/audi/app/bluetooth/core/IBluetoothApplication 
.const [342] = Utf8 getBundleContext 
.const [343] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [344] = Utf8 org/osgi/framework/BundleContext 
.const [345] = Utf8 registerService 
.const [346] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [347] = Utf8 de/audi/app/bluetooth/core/accessibility/ProfileSupport 
.const [348] = Utf8 serviceRegistration 
.const [349] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [350] = Utf8 org/osgi/framework/ServiceRegistration 
.const [351] = Utf8 unregister 
.const [352] = Utf8 ()V 
.const [353] = Utf8 de/audi/app/bluetooth/core/accessibility/ProfileSupport 
.const [354] = Class [353] 
.const [355] = Utf8 de/audi/app/bluetooth/core/AbstractBluetoothComponent 
.const [356] = Class [355] 
.const [357] = Utf8 de/audi/app/bluetooth/core/accessibility/ISupportedBtProfiles 
.const [358] = Class [357] 
.const [359] = Utf8 de/audi/atip/interapp/IConnectivityPhoneStateListener 
.const [360] = Class [359] 
.const [361] = Utf8 ATTRIBUTE_NOTIFICATIONS 
.const [362] = Utf8 [I 
.const [363] = Utf8 supportedBTProfiles 
.const [364] = Utf8 I 
.const [365] = Utf8 isNadModeVoiceAndData 
.const [366] = Utf8 Z 
.const [367] = Utf8 isSimInserted 
.const [368] = Utf8 Z 
.const [369] = Utf8 isSapPrioConnected 
.const [370] = Utf8 Z 
.const [371] = Utf8 enableHfpProfile 
.const [372] = Utf8 Z 
.const [373] = Utf8 callActive 
.const [374] = Utf8 Z 
.const [375] = Utf8 serviceRegistration 
.const [376] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [377] = Utf8 class$de$audi$atip$interapp$IConnectivityPhoneStateListener 
.const [378] = Utf8 Ljava/lang/Class; 
.const [379] = Utf8 Code 
.const [380] = Utf8 <init> 
.const [381] = Utf8 (Lde/audi/app/bluetooth/core/IBluetoothApplication;)V 
.const [382] = Utf8 getAttributeNotifications 
.const [383] = Utf8 ()[I 
.const [384] = Utf8 updateSupportedBTProfiles 
.const [385] = Utf8 (II)V 
.const [386] = Utf8 updateTrustedDevices 
.const [387] = Utf8 ([Lorg/dsi/ifc/bluetooth/TrustedDevice;I)V 
.const [388] = Utf8 getConnectableServices 
.const [389] = Utf8 (IZ)I 
.const [390] = Utf8 isHfpSupportFaked 
.const [391] = Utf8 ()Z 
.const [392] = Utf8 updatePhoneState 
.const [393] = Utf8 (II)V 
.const [394] = Utf8 updateFakeHfpProfileSupport 
.const [395] = Utf8 ()V 
.const [396] = Utf8 updateMESlotInfo 
.const [397] = Utf8 (Lde/audi/atip/interapp/phone/ITelMESlotState;Lde/audi/atip/interapp/phone/ITelMESlotState;Lde/audi/atip/interapp/phone/ITelMESlotState;)V 
.const [398] = Utf8 updateESIMInfo 
.const [399] = Utf8 (Ljava/lang/String;Ljava/lang/String;ZZ)V 
.const [400] = Utf8 telAppEntered 
.const [401] = Utf8 ()V 
.const [402] = Utf8 telAppLeft 
.const [403] = Utf8 ()V 
.const [404] = Utf8 telUnlockEntered 
.const [405] = Utf8 ()V 
.const [406] = Utf8 telUnlockLeft 
.const [407] = Utf8 ()V 
.const [408] = Utf8 updateConnectedGatewayState 
.const [409] = Utf8 (Z)V 
.const [410] = Utf8 init 
.const [411] = Utf8 ()V 
.const [412] = Utf8 deinit 
.const [413] = Utf8 ()V 
.const [414] = Utf8 toString 
.const [415] = Utf8 ()Ljava/lang/String; 
.const [416] = Utf8 class$ 
.const [417] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [418] = Utf8 <clinit> 
.const [419] = Utf8 ()V 
.end class 
