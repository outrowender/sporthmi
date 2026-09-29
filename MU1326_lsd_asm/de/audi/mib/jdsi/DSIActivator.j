.version 50 0 
.class public super [390] 
.super [392] 
.implements [394] 
.implements [396] 
.field public static final [397] [398] 
.field private final [399] [400] 
.field private final [401] [402] 
.field private final [403] [404] 
.field private final [405] [406] 
.field private final [407] [408] 
.field private final [409] [410] 
.field private final [411] [412] 
.field private volatile [413] [414] 
.field private volatile [415] [416] 
.field private volatile [417] [418] 
.field static synthetic [419] [420] 

.method public [422] : [423] 
    .attribute [421] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [57] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [63] 
L9:     aload_0 
L10:    aconst_null 
L11:    putfield [64] 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [65] 
L19:    aload_0 
L20:    aload_1 
L21:    putfield [66] 
L24:    aload_0 
L25:    aload_1 
L26:    ldc [5] 
L28:    invokeinterface [67] 0 
L33:    putfield [68] 
L36:    aload_0 
L37:    aload_2 
L38:    putfield [69] 
L41:    aload_0 
L42:    aload_3 
L43:    putfield [70] 
L46:    aload_0 
L47:    aload 4 
L49:    putfield [71] 
L52:    aload_0 
L53:    aload 5 
L55:    putfield [72] 
L58:    aload_0 
L59:    aload 6 
L61:    putfield [73] 
L64:    return 
L65:    nop 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [424] : [425] 
    .attribute [421] .code stack 5 locals 3 
L0:     aload_0 
L1:     getfield [37] 
L4:     aload_1 
L5:     invokeinterface [74] 0 
L10:    astore_2 
L11:    aload_2 
L12:    instanceof [6] 
L15:    ifeq L203 
L18:    aload_1 
L19:    ldc [7] 
L21:    invokeinterface [75] 0 
L26:    astore_3 
L27:    aload_0 
L28:    getfield [44] 
L31:    aload_3 
L32:    invokevirtual [47] 
L35:    ifeq L168 
L38:    aload_0 
L39:    getfield [41] 
L42:    ldc [8] 
L44:    ldc [9] 
L46:    aload_0 
L47:    getfield [42] 
L50:    aload_0 
L51:    getfield [44] 
L54:    invokevirtual [48] 
L57:    aload_0 
L58:    getfield [46] 
L61:    aload_2 
L62:    checkcast [6] 
L65:    invokeinterface [76] 0 
L70:    aload_0 
L71:    getfield [46] 
L74:    invokeinterface [77] 0 
L79:    astore 4 
L81:    aload 4 
L83:    ifnull L165 
L86:    aload_0 
L87:    getfield [45] 
L90:    ifnull L165 
L93:    aload 4 
L95:    getstatic [10] 
L98:    if_acmpne L133 
L101:   aload_0 
L102:   getfield [41] 
L105:   ldc [11] 
L107:   ldc [12] 
L109:   aload_0 
L110:   getfield [42] 
L113:   invokevirtual [49] 
L116:   pop 
L117:   aload_2 
L118:   checkcast [6] 
L121:   aload_0 
L122:   getfield [45] 
L125:   invokeinterface [78] 0 
L130:   goto L165 
L133:   aload_0 
L134:   getfield [41] 
L137:   ldc [11] 
L139:   ldc [13] 
L141:   aload_0 
L142:   getfield [42] 
L145:   aload 4 
L147:   invokevirtual [48] 
L150:   aload_2 
L151:   checkcast [6] 
L154:   aload 4 
L156:   aload_0 
L157:   getfield [45] 
L160:   invokeinterface [79] 0 
L165:   goto L200 
L168:   aload_0 
L169:   getfield [41] 
L172:   ldc [14] 
L174:   ldc [15] 
L176:   aload_0 
L177:   getfield [42] 
L180:   aload_0 
L181:   getfield [44] 
L184:   invokevirtual [48] 
L187:   aload_0 
L188:   getfield [37] 
L191:   aload_1 
L192:   invokeinterface [80] 0 
L197:   pop 
L198:   aconst_null 
L199:   astore_2 
L200:   goto L228 
L203:   aload_0 
L204:   getfield [37] 
L207:   aload_1 
L208:   invokeinterface [80] 0 
L213:   pop 
L214:   aload_0 
L215:   getfield [41] 
L218:   ldc [14] 
L220:   ldc [16] 
L222:   invokevirtual [50] 
L225:   pop 
L226:   aconst_null 
L227:   astore_2 
L228:   aload_2 
L229:   areturn 
L230:   nop 
L231:   nop 
L232:   
    .end code 
.end method 

.method public enum [426] : [427] 
    .attribute [421] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [428] : [429] 
    .attribute [421] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [41] 
L4:     ldc [14] 
L6:     ldc [17] 
L8:     aload_0 
L9:     getfield [42] 
L12:    aload_0 
L13:    getfield [44] 
L16:    invokevirtual [48] 
L19:    aload_0 
L20:    getfield [46] 
L23:    invokeinterface [77] 0 
L28:    astore_3 
L29:    aload_3 
L30:    ifnull L109 
L33:    aload_0 
L34:    getfield [45] 
L37:    ifnull L109 
L40:    aload_3 
L41:    getstatic [10] 
L44:    if_acmpne L79 
L47:    aload_0 
L48:    getfield [41] 
L51:    ldc [11] 
L53:    ldc [18] 
L55:    aload_0 
L56:    getfield [42] 
L59:    invokevirtual [49] 
L62:    pop 
L63:    aload_2 
L64:    checkcast [6] 
L67:    aload_0 
L68:    getfield [45] 
L71:    invokeinterface [81] 0 
L76:    goto L109 
L79:    aload_0 
L80:    getfield [41] 
L83:    ldc [11] 
L85:    ldc [19] 
L87:    aload_0 
L88:    getfield [42] 
L91:    aload_3 
L92:    invokevirtual [48] 
L95:    aload_2 
L96:    checkcast [6] 
L99:    aload_3 
L100:   aload_0 
L101:   getfield [45] 
L104:   invokeinterface [82] 0 
L109:   aload_0 
L110:   getfield [46] 
L113:   aconst_null 
L114:   invokeinterface [76] 0 
L119:   aload_0 
L120:   getfield [37] 
L123:   aload_1 
L124:   invokeinterface [80] 0 
L129:   pop 
L130:   return 
L131:   nop 
L132:   
    .end code 
.end method 

.method public [430] : [431] 
    .attribute [421] .code stack 6 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [63] 
L5:     new [83] 
L8:     dup 
L9:     bipush 8 
L11:    invokespecial [59] 
L14:    astore_2 
L15:    aload_2 
L16:    ldc [21] 
L18:    aload_0 
L19:    getfield [43] 
L22:    invokevirtual [51] 
L25:    pop 
L26:    aload_2 
L27:    ldc [7] 
L29:    aload_0 
L30:    getfield [44] 
L33:    invokevirtual [51] 
L36:    pop 
L37:    aload_0 
L38:    getfield [45] 
L41:    ifnull L83 
L44:    aload_0 
L45:    aload_1 
L46:    getstatic [22] 
L49:    ifnonnull L64 
L52:    ldc [23] 
L54:    invokestatic [24] 
L57:    dup 
L58:    putstatic [60] 
L61:    goto L67 
L64:    getstatic [22] 
L67:    invokevirtual [52] 
L70:    aload_0 
L71:    getfield [45] 
L74:    aload_2 
L75:    invokeinterface [84] 0 
L80:    putfield [64] 
L83:    aload_0 
L84:    new [85] 
L87:    dup 
L88:    aload_1 
L89:    aload_0 
L90:    getfield [42] 
L93:    aload_0 
L94:    invokespecial [61] 
L97:    putfield [65] 
L100:   aload_0 
L101:   getfield [39] 
L104:   invokevirtual [53] 
L107:   aload_0 
L108:   getfield [40] 
L111:   aload_0 
L112:   getfield [42] 
L115:   aload_0 
L116:   getfield [44] 
L119:   invokevirtual [54] 
L122:   invokeinterface [86] 0 
L127:   pop 
L128:   return 
L129:   nop 
L130:   nop 
L131:   nop 
L132:   
    .end code 
.end method 

.method public [432] : [433] 
    .attribute [421] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [40] 
L4:     aload_0 
L5:     getfield [42] 
L8:     aload_0 
L9:     getfield [44] 
L12:    invokevirtual [54] 
L15:    invokeinterface [87] 0 
L20:    aload_0 
L21:    getfield [39] 
L24:    ifnull L39 
L27:    aload_0 
L28:    getfield [39] 
L31:    invokevirtual [55] 
L34:    aload_0 
L35:    aconst_null 
L36:    putfield [65] 
L39:    aload_0 
L40:    getfield [38] 
L43:    ifnull L60 
L46:    aload_0 
L47:    getfield [38] 
L50:    invokeinterface [88] 0 
L55:    aload_0 
L56:    aconst_null 
L57:    putfield [64] 
L60:    return 
L61:    nop 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method static synthetic [434] : [435] 
    .attribute [421] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [62] 
L9:     dup 
L10:    invokespecial [56] 
L13:    aload_1 
L14:    invokevirtual [36] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static [436] : [437] 
    .attribute [421] .code stack 1 locals 0 
L0:     iconst_0 
L1:     newarray int 
L3:     putstatic [58] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [89] [90] 
.const [3] = Class [91] 
.const [4] = Class [92] 
.const [5] = String [93] 
.const [6] = Class [94] 
.const [7] = String [95] 
.const [8] = Int 1078071040 
.const [9] = String [96] 
.const [10] = Field [97] [98] 
.const [11] = Int -2137614336 
.const [12] = String [99] 
.const [13] = String [100] 
.const [14] = Int -1601830656 
.const [15] = String [101] 
.const [16] = String [102] 
.const [17] = String [103] 
.const [18] = String [104] 
.const [19] = String [105] 
.const [20] = Class [106] 
.const [21] = String [107] 
.const [22] = Field [108] [109] 
.const [23] = String [110] 
.const [24] = Method [111] [112] 
.const [25] = Class [113] 
.const [26] = Class [114] 
.const [27] = Class [115] 
.const [28] = Class [116] 
.const [29] = Class [117] 
.const [30] = Class [118] 
.const [31] = Class [119] 
.const [32] = Class [120] 
.const [33] = Class [121] 
.const [34] = Class [122] 
.const [35] = Class [123] 
.const [36] = Method [124] [125] 
.const [37] = Field [126] [127] 
.const [38] = Field [128] [129] 
.const [39] = Field [130] [131] 
.const [40] = Field [132] [133] 
.const [41] = Field [134] [135] 
.const [42] = Field [136] [137] 
.const [43] = Field [138] [139] 
.const [44] = Field [140] [141] 
.const [45] = Field [142] [143] 
.const [46] = Field [144] [145] 
.const [47] = Method [146] [147] 
.const [48] = Method [148] [149] 
.const [49] = Method [150] [151] 
.const [50] = Method [152] [153] 
.const [51] = Method [154] [155] 
.const [52] = Method [156] [157] 
.const [53] = Method [158] [159] 
.const [54] = Method [160] [161] 
.const [55] = Method [162] [163] 
.const [56] = Method [164] [165] 
.const [57] = Method [166] [167] 
.const [58] = Field [168] [169] 
.const [59] = Method [170] [171] 
.const [60] = Field [172] [173] 
.const [61] = Method [174] [175] 
.const [62] = Class [176] 
.const [63] = Field [177] [178] 
.const [64] = Field [179] [180] 
.const [65] = Field [181] [182] 
.const [66] = Field [183] [184] 
.const [67] = InterfaceMethod [185] [186] 
.const [68] = Field [187] [188] 
.const [69] = Field [189] [190] 
.const [70] = Field [191] [192] 
.const [71] = Field [193] [194] 
.const [72] = Field [195] [196] 
.const [73] = Field [197] [198] 
.const [74] = InterfaceMethod [199] [200] 
.const [75] = InterfaceMethod [201] [202] 
.const [76] = InterfaceMethod [203] [204] 
.const [77] = InterfaceMethod [205] [206] 
.const [78] = InterfaceMethod [207] [208] 
.const [79] = InterfaceMethod [209] [210] 
.const [80] = InterfaceMethod [211] [212] 
.const [81] = InterfaceMethod [213] [214] 
.const [82] = InterfaceMethod [215] [216] 
.const [83] = Class [217] 
.const [84] = InterfaceMethod [218] [219] 
.const [85] = Class [220] 
.const [86] = InterfaceMethod [221] [222] 
.const [87] = InterfaceMethod [223] [224] 
.const [88] = InterfaceMethod [225] [226] 
.const [89] = Class [227] 
.const [90] = NameAndType [228] [229] 
.const [91] = Utf8 java/lang/ClassNotFoundException 
.const [92] = Utf8 java/lang/NoClassDefFoundError 
.const [93] = Utf8 'Fw.Util.DSI' 
.const [94] = Utf8 org/dsi/ifc/base/DSIBase 
.const [95] = Utf8 DEVICE_INSTANCE 
.const [96] = Utf8 '[DSIActivator] found DSI %1 instance %2!' 
.const [97] = Class [230] 
.const [98] = NameAndType [231] [232] 
.const [99] = Utf8 '[DSIActivator] %1 set all notifications!' 
.const [100] = Utf8 '[DSIActivator] %1 set notifications %2!' 
.const [101] = Utf8 '[DSIActivator] wrong instance %2!' 
.const [102] = Utf8 '[DSIActivator] not adding unwanted service!' 
.const [103] = Utf8 '[DSIActivator] removed DSI %1 instance %2!' 
.const [104] = Utf8 '[DSIActivator] %1 clear all notifications!' 
.const [105] = Utf8 '[DSIActivator] %1 clear notifications %2!' 
.const [106] = Utf8 java/util/Hashtable 
.const [107] = Utf8 DEVICE_NAME 
.const [108] = Class [233] 
.const [109] = NameAndType [234] [235] 
.const [110] = Utf8 'org.dsi.ifc.base.DSIListener' 
.const [111] = Class [236] 
.const [112] = NameAndType [237] [238] 
.const [113] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [114] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [115] = Utf8 java/lang/Object 
.const [116] = Utf8 java/lang/Class 
.const [117] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [118] = Utf8 org/osgi/framework/BundleContext 
.const [119] = Utf8 org/osgi/framework/ServiceReference 
.const [120] = Utf8 java/lang/Integer 
.const [121] = Utf8 de/audi/atip/log/LogChannel 
.const [122] = Utf8 de/audi/mib/jdsi/IDSIClient 
.const [123] = Utf8 org/osgi/framework/ServiceRegistration 
.const [124] = Class [239] 
.const [125] = NameAndType [240] [241] 
.const [126] = Class [242] 
.const [127] = NameAndType [243] [244] 
.const [128] = Class [245] 
.const [129] = NameAndType [246] [247] 
.const [130] = Class [248] 
.const [131] = NameAndType [249] [250] 
.const [132] = Class [251] 
.const [133] = NameAndType [252] [253] 
.const [134] = Class [254] 
.const [135] = NameAndType [255] [256] 
.const [136] = Class [257] 
.const [137] = NameAndType [258] [259] 
.const [138] = Class [260] 
.const [139] = NameAndType [261] [262] 
.const [140] = Class [263] 
.const [141] = NameAndType [264] [265] 
.const [142] = Class [266] 
.const [143] = NameAndType [267] [268] 
.const [144] = Class [269] 
.const [145] = NameAndType [270] [271] 
.const [146] = Class [272] 
.const [147] = NameAndType [273] [274] 
.const [148] = Class [275] 
.const [149] = NameAndType [276] [277] 
.const [150] = Class [278] 
.const [151] = NameAndType [279] [280] 
.const [152] = Class [281] 
.const [153] = NameAndType [282] [283] 
.const [154] = Class [284] 
.const [155] = NameAndType [285] [286] 
.const [156] = Class [287] 
.const [157] = NameAndType [288] [289] 
.const [158] = Class [290] 
.const [159] = NameAndType [291] [292] 
.const [160] = Class [293] 
.const [161] = NameAndType [294] [295] 
.const [162] = Class [296] 
.const [163] = NameAndType [297] [298] 
.const [164] = Class [299] 
.const [165] = NameAndType [300] [301] 
.const [166] = Class [302] 
.const [167] = NameAndType [303] [304] 
.const [168] = Class [305] 
.const [169] = NameAndType [306] [307] 
.const [170] = Class [308] 
.const [171] = NameAndType [309] [310] 
.const [172] = Class [311] 
.const [173] = NameAndType [312] [313] 
.const [174] = Class [314] 
.const [175] = NameAndType [315] [316] 
.const [176] = Utf8 java/lang/NoClassDefFoundError 
.const [177] = Class [317] 
.const [178] = NameAndType [318] [319] 
.const [179] = Class [320] 
.const [180] = NameAndType [321] [322] 
.const [181] = Class [323] 
.const [182] = NameAndType [324] [325] 
.const [183] = Class [326] 
.const [184] = NameAndType [327] [328] 
.const [185] = Class [329] 
.const [186] = NameAndType [330] [331] 
.const [187] = Class [332] 
.const [188] = NameAndType [333] [334] 
.const [189] = Class [335] 
.const [190] = NameAndType [336] [337] 
.const [191] = Class [338] 
.const [192] = NameAndType [339] [340] 
.const [193] = Class [341] 
.const [194] = NameAndType [342] [343] 
.const [195] = Class [344] 
.const [196] = NameAndType [345] [346] 
.const [197] = Class [347] 
.const [198] = NameAndType [348] [349] 
.const [199] = Class [350] 
.const [200] = NameAndType [351] [352] 
.const [201] = Class [353] 
.const [202] = NameAndType [354] [355] 
.const [203] = Class [356] 
.const [204] = NameAndType [357] [358] 
.const [205] = Class [359] 
.const [206] = NameAndType [360] [361] 
.const [207] = Class [362] 
.const [208] = NameAndType [363] [364] 
.const [209] = Class [365] 
.const [210] = NameAndType [366] [367] 
.const [211] = Class [368] 
.const [212] = NameAndType [369] [370] 
.const [213] = Class [371] 
.const [214] = NameAndType [372] [373] 
.const [215] = Class [374] 
.const [216] = NameAndType [375] [376] 
.const [217] = Utf8 java/util/Hashtable 
.const [218] = Class [377] 
.const [219] = NameAndType [378] [379] 
.const [220] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [221] = Class [380] 
.const [222] = NameAndType [381] [382] 
.const [223] = Class [383] 
.const [224] = NameAndType [384] [385] 
.const [225] = Class [386] 
.const [226] = NameAndType [387] [388] 
.const [227] = Utf8 java/lang/Class 
.const [228] = Utf8 forName 
.const [229] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [230] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [231] = Utf8 ATTR_ALL 
.const [232] = Utf8 [I 
.const [233] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [234] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [235] = Utf8 Ljava/lang/Class; 
.const [236] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [237] = Utf8 class$ 
.const [238] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [239] = Utf8 java/lang/NoClassDefFoundError 
.const [240] = Utf8 initCause 
.const [241] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [242] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [243] = Utf8 context 
.const [244] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [245] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [246] = Utf8 sRegListener 
.const [247] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [248] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [249] = Utf8 tracker 
.const [250] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [251] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [252] = Utf8 framework 
.const [253] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [254] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [255] = Utf8 log 
.const [256] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [257] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [258] = Utf8 clazz 
.const [259] = Utf8 Ljava/lang/String; 
.const [260] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [261] = Utf8 listenerClazz 
.const [262] = Utf8 Ljava/lang/String; 
.const [263] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [264] = Utf8 instance 
.const [265] = Utf8 Ljava/lang/Integer; 
.const [266] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [267] = Utf8 listener 
.const [268] = Utf8 Lorg/dsi/ifc/base/DSIListener; 
.const [269] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [270] = Utf8 client 
.const [271] = Utf8 Lde/audi/mib/jdsi/IDSIClient; 
.const [272] = Utf8 java/lang/Integer 
.const [273] = Utf8 equals 
.const [274] = Utf8 (Ljava/lang/Object;)Z 
.const [275] = Utf8 de/audi/atip/log/LogChannel 
.const [276] = Utf8 log 
.const [277] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [278] = Utf8 de/audi/atip/log/LogChannel 
.const [279] = Utf8 log 
.const [280] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [281] = Utf8 de/audi/atip/log/LogChannel 
.const [282] = Utf8 log 
.const [283] = Utf8 (ILjava/lang/String;)Z 
.const [284] = Utf8 java/util/Hashtable 
.const [285] = Utf8 put 
.const [286] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [287] = Utf8 java/lang/Class 
.const [288] = Utf8 getName 
.const [289] = Utf8 ()Ljava/lang/String; 
.const [290] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [291] = Utf8 'open' 
.const [292] = Utf8 ()V 
.const [293] = Utf8 java/lang/Integer 
.const [294] = Utf8 intValue 
.const [295] = Utf8 ()I 
.const [296] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [297] = Utf8 close 
.const [298] = Utf8 ()V 
.const [299] = Utf8 java/lang/NoClassDefFoundError 
.const [300] = Utf8 <init> 
.const [301] = Utf8 ()V 
.const [302] = Utf8 java/lang/Object 
.const [303] = Utf8 <init> 
.const [304] = Utf8 ()V 
.const [305] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [306] = Utf8 ATTR_ALL 
.const [307] = Utf8 [I 
.const [308] = Utf8 java/util/Hashtable 
.const [309] = Utf8 <init> 
.const [310] = Utf8 (I)V 
.const [311] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [312] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [313] = Utf8 Ljava/lang/Class; 
.const [314] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [315] = Utf8 <init> 
.const [316] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [317] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [318] = Utf8 context 
.const [319] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [320] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [321] = Utf8 sRegListener 
.const [322] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [323] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [324] = Utf8 tracker 
.const [325] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [326] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [327] = Utf8 framework 
.const [328] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [329] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [330] = Utf8 getLogChannel 
.const [331] = Utf8 (Ljava/lang/String;)Lde/audi/atip/log/LogChannel; 
.const [332] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [333] = Utf8 log 
.const [334] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [335] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [336] = Utf8 clazz 
.const [337] = Utf8 Ljava/lang/String; 
.const [338] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [339] = Utf8 listenerClazz 
.const [340] = Utf8 Ljava/lang/String; 
.const [341] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [342] = Utf8 instance 
.const [343] = Utf8 Ljava/lang/Integer; 
.const [344] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [345] = Utf8 listener 
.const [346] = Utf8 Lorg/dsi/ifc/base/DSIListener; 
.const [347] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [348] = Utf8 client 
.const [349] = Utf8 Lde/audi/mib/jdsi/IDSIClient; 
.const [350] = Utf8 org/osgi/framework/BundleContext 
.const [351] = Utf8 getService 
.const [352] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [353] = Utf8 org/osgi/framework/ServiceReference 
.const [354] = Utf8 getProperty 
.const [355] = Utf8 (Ljava/lang/String;)Ljava/lang/Object; 
.const [356] = Utf8 de/audi/mib/jdsi/IDSIClient 
.const [357] = Utf8 setDSI 
.const [358] = Utf8 (Lorg/dsi/ifc/base/DSIBase;)V 
.const [359] = Utf8 de/audi/mib/jdsi/IDSIClient 
.const [360] = Utf8 getAutoNotifications 
.const [361] = Utf8 ()[I 
.const [362] = Utf8 org/dsi/ifc/base/DSIBase 
.const [363] = Utf8 setNotification 
.const [364] = Utf8 (Lorg/dsi/ifc/base/DSIListener;)V 
.const [365] = Utf8 org/dsi/ifc/base/DSIBase 
.const [366] = Utf8 setNotification 
.const [367] = Utf8 ([ILorg/dsi/ifc/base/DSIListener;)V 
.const [368] = Utf8 org/osgi/framework/BundleContext 
.const [369] = Utf8 ungetService 
.const [370] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [371] = Utf8 org/dsi/ifc/base/DSIBase 
.const [372] = Utf8 clearNotification 
.const [373] = Utf8 (Lorg/dsi/ifc/base/DSIListener;)V 
.const [374] = Utf8 org/dsi/ifc/base/DSIBase 
.const [375] = Utf8 clearNotification 
.const [376] = Utf8 ([ILorg/dsi/ifc/base/DSIListener;)V 
.const [377] = Utf8 org/osgi/framework/BundleContext 
.const [378] = Utf8 registerService 
.const [379] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [380] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [381] = Utf8 startDSIService 
.const [382] = Utf8 (Ljava/lang/String;I)Z 
.const [383] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [384] = Utf8 stopDSIService 
.const [385] = Utf8 (Ljava/lang/String;I)V 
.const [386] = Utf8 org/osgi/framework/ServiceRegistration 
.const [387] = Utf8 unregister 
.const [388] = Utf8 ()V 
.const [389] = Utf8 de/audi/mib/jdsi/DSIActivator 
.const [390] = Class [389] 
.const [391] = Utf8 java/lang/Object 
.const [392] = Class [391] 
.const [393] = Utf8 org/osgi/framework/BundleActivator 
.const [394] = Class [393] 
.const [395] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [396] = Class [395] 
.const [397] = Utf8 ATTR_ALL 
.const [398] = Utf8 [I 
.const [399] = Utf8 framework 
.const [400] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [401] = Utf8 log 
.const [402] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [403] = Utf8 clazz 
.const [404] = Utf8 Ljava/lang/String; 
.const [405] = Utf8 listenerClazz 
.const [406] = Utf8 Ljava/lang/String; 
.const [407] = Utf8 instance 
.const [408] = Utf8 Ljava/lang/Integer; 
.const [409] = Utf8 listener 
.const [410] = Utf8 Lorg/dsi/ifc/base/DSIListener; 
.const [411] = Utf8 client 
.const [412] = Utf8 Lde/audi/mib/jdsi/IDSIClient; 
.const [413] = Utf8 context 
.const [414] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [415] = Utf8 sRegListener 
.const [416] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [417] = Utf8 tracker 
.const [418] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [419] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [420] = Utf8 Ljava/lang/Class; 
.const [421] = Utf8 Code 
.const [422] = Utf8 <init> 
.const [423] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lorg/dsi/ifc/base/DSIListener;Lde/audi/mib/jdsi/IDSIClient;)V 
.const [424] = Utf8 addingService 
.const [425] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [426] = Utf8 modifiedService 
.const [427] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [428] = Utf8 removedService 
.const [429] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [430] = Utf8 start 
.const [431] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [432] = Utf8 stop 
.const [433] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [434] = Utf8 class$ 
.const [435] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [436] = Utf8 <clinit> 
.const [437] = Utf8 ()V 
.end class 
