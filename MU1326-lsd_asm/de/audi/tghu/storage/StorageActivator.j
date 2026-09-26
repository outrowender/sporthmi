.version 50 0 
.class public final super [359] 
.super [361] 
.field private volatile [362] [363] 
.field private [364] [365] 
.field private [366] [367] 
.field private [368] [369] 
.field private [370] [371] 
.field private [372] [373] 
.field private [374] [375] 
.field private final [376] [377] 
.field static synthetic [378] [379] 
.field static synthetic [380] [381] 
.field static synthetic [382] [383] 
.field static synthetic [384] [385] 
.field static synthetic [386] [387] 

.method public interface [389] : [390] 
    .attribute [388] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [391] : [392] 
    .attribute [388] .code stack 2 locals 0 
L0:     aload_0 
L1:     ldc [5] 
L3:     invokespecial [51] 
L6:     aload_0 
L7:     aload_1 
L8:     putfield [65] 
L11:    return 
L12:    
    .end code 
.end method 

.method protected [393] : [394] 
    .attribute [388] .code stack 9 locals 1 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [33] 
L5:     ldc [6] 
L7:     invokeinterface [70] 0 
L12:    putfield [64] 
L15:    aload_0 
L16:    new [71] 
L19:    dup 
L20:    aload_0 
L21:    getfield [33] 
L24:    invokespecial [52] 
L27:    putfield [66] 
L30:    aload_0 
L31:    aload_1 
L32:    getstatic [8] 
L35:    ifnonnull L50 
L38:    ldc [9] 
L40:    invokestatic [10] 
L43:    dup 
L44:    putstatic [53] 
L47:    goto L53 
L50:    getstatic [8] 
L53:    invokevirtual [41] 
L56:    aload_0 
L57:    getfield [37] 
L60:    aconst_null 
L61:    invokeinterface [72] 0 
L66:    putfield [73] 
L69:    aload_0 
L70:    new [74] 
L73:    dup 
L74:    aload_0 
L75:    getfield [33] 
L78:    aload_0 
L79:    getfield [37] 
L82:    invokespecial [54] 
L85:    putfield [68] 
L88:    new [75] 
L91:    dup 
L92:    invokespecial [55] 
L95:    astore_2 
L96:    aload_2 
L97:    ldc [13] 
L99:    getstatic [14] 
L102:   ifnonnull L117 
L105:   ldc [15] 
L107:   invokestatic [10] 
L110:   dup 
L111:   putstatic [56] 
L114:   goto L120 
L117:   getstatic [14] 
L120:   invokevirtual [41] 
L123:   invokevirtual [43] 
L126:   pop 
L127:   aload_2 
L128:   ldc [16] 
L130:   new [76] 
L133:   dup 
L134:   iconst_0 
L135:   invokespecial [57] 
L138:   invokevirtual [43] 
L141:   pop 
L142:   aload_0 
L143:   aload_1 
L144:   getstatic [18] 
L147:   ifnonnull L162 
L150:   ldc [19] 
L152:   invokestatic [10] 
L155:   dup 
L156:   putstatic [58] 
L159:   goto L165 
L162:   getstatic [18] 
L165:   invokevirtual [41] 
L168:   aload_0 
L169:   getfield [39] 
L172:   aload_2 
L173:   invokeinterface [72] 0 
L178:   putfield [77] 
L181:   aload_0 
L182:   new [78] 
L185:   dup 
L186:   aload_1 
L187:   iconst_2 
L188:   anewarray [21] 
L191:   dup 
L192:   iconst_0 
L193:   getstatic [22] 
L196:   ifnonnull L211 
L199:   ldc [23] 
L201:   invokestatic [10] 
L204:   dup 
L205:   putstatic [59] 
L208:   goto L214 
L211:   getstatic [22] 
L214:   invokevirtual [41] 
L217:   aastore 
L218:   dup 
L219:   iconst_1 
L220:   getstatic [24] 
L223:   ifnonnull L238 
L226:   ldc [25] 
L228:   invokestatic [10] 
L231:   dup 
L232:   putstatic [60] 
L235:   goto L241 
L238:   getstatic [24] 
L241:   invokevirtual [41] 
L244:   aastore 
L245:   new [79] 
L248:   dup 
L249:   aload_0 
L250:   invokespecial [61] 
L253:   invokespecial [62] 
L256:   putfield [80] 
L259:   aload_0 
L260:   getfield [45] 
L263:   invokevirtual [46] 
L266:   return 
L267:   nop 
L268:   
    .end code 
.end method 

.method public [395] : [396] 
    .attribute [388] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [44] 
L4:     ifnull L21 
L7:     aload_0 
L8:     getfield [44] 
L11:    invokeinterface [81] 0 
L16:    aload_0 
L17:    aconst_null 
L18:    putfield [77] 
L21:    aload_0 
L22:    getfield [42] 
L25:    ifnull L42 
L28:    aload_0 
L29:    getfield [42] 
L32:    invokeinterface [81] 0 
L37:    aload_0 
L38:    aconst_null 
L39:    putfield [73] 
L42:    aload_0 
L43:    getfield [45] 
L46:    invokevirtual [47] 
L49:    aload_0 
L50:    aconst_null 
L51:    putfield [80] 
L54:    aload_0 
L55:    getfield [39] 
L58:    ifnull L73 
L61:    aload_0 
L62:    getfield [39] 
L65:    invokevirtual [48] 
L68:    aload_0 
L69:    aconst_null 
L70:    putfield [68] 
L73:    aload_0 
L74:    aconst_null 
L75:    putfield [67] 
L78:    aload_0 
L79:    aconst_null 
L80:    putfield [64] 
L83:    aload_0 
L84:    aload_1 
L85:    invokespecial [63] 
L88:    return 
L89:    nop 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 

.method public [397] : [398] 
    .attribute [388] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [39] 
L4:     ifnull L14 
L7:     aload_0 
L8:     getfield [39] 
L11:    invokevirtual [49] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method static synthetic [399] : [400] 
    .attribute [388] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [69] 
L9:     dup 
L10:    invokespecial [50] 
L13:    aload_1 
L14:    invokevirtual [40] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static synthetic [401] : [402] 
    .attribute [388] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [34] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [403] : [404] 
    .attribute [388] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [39] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [405] : [406] 
    .attribute [388] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [38] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [407] : [408] 
    .attribute [388] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     dup_x1 
L3:     putfield [67] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [409] : [410] 
    .attribute [388] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [37] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [411] : [412] 
    .attribute [388] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [36] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [413] : [414] 
    .attribute [388] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [35] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [415] : [416] 
    .attribute [388] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [34] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [417] : [418] 
    .attribute [388] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [34] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [419] : [420] 
    .attribute [388] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [33] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [82] [83] 
.const [3] = Class [84] 
.const [4] = Class [85] 
.const [5] = String [86] 
.const [6] = String [87] 
.const [7] = Class [88] 
.const [8] = Field [89] [90] 
.const [9] = String [91] 
.const [10] = Method [92] [93] 
.const [11] = Class [94] 
.const [12] = Class [95] 
.const [13] = String [96] 
.const [14] = Field [97] [98] 
.const [15] = String [99] 
.const [16] = String [100] 
.const [17] = Class [101] 
.const [18] = Field [102] [103] 
.const [19] = String [104] 
.const [20] = Class [105] 
.const [21] = Class [106] 
.const [22] = Field [107] [108] 
.const [23] = String [109] 
.const [24] = Field [110] [111] 
.const [25] = String [112] 
.const [26] = Class [113] 
.const [27] = Class [114] 
.const [28] = Class [115] 
.const [29] = Class [116] 
.const [30] = Class [117] 
.const [31] = Class [118] 
.const [32] = Class [119] 
.const [33] = Field [120] [121] 
.const [34] = Method [122] [123] 
.const [35] = Field [124] [125] 
.const [36] = Field [126] [127] 
.const [37] = Field [128] [129] 
.const [38] = Field [130] [131] 
.const [39] = Field [132] [133] 
.const [40] = Method [134] [135] 
.const [41] = Method [136] [137] 
.const [42] = Field [138] [139] 
.const [43] = Method [140] [141] 
.const [44] = Field [142] [143] 
.const [45] = Field [144] [145] 
.const [46] = Method [146] [147] 
.const [47] = Method [148] [149] 
.const [48] = Method [150] [151] 
.const [49] = Method [152] [153] 
.const [50] = Method [154] [155] 
.const [51] = Method [156] [157] 
.const [52] = Method [158] [159] 
.const [53] = Field [160] [161] 
.const [54] = Method [162] [163] 
.const [55] = Method [164] [165] 
.const [56] = Field [166] [167] 
.const [57] = Method [168] [169] 
.const [58] = Field [170] [171] 
.const [59] = Field [172] [173] 
.const [60] = Field [174] [175] 
.const [61] = Method [176] [177] 
.const [62] = Method [178] [179] 
.const [63] = Method [180] [181] 
.const [64] = Field [182] [183] 
.const [65] = Field [184] [185] 
.const [66] = Field [186] [187] 
.const [67] = Field [188] [189] 
.const [68] = Field [190] [191] 
.const [69] = Class [192] 
.const [70] = InterfaceMethod [193] [194] 
.const [71] = Class [195] 
.const [72] = InterfaceMethod [196] [197] 
.const [73] = Field [198] [199] 
.const [74] = Class [200] 
.const [75] = Class [201] 
.const [76] = Class [202] 
.const [77] = Field [203] [204] 
.const [78] = Class [205] 
.const [79] = Class [206] 
.const [80] = Field [207] [208] 
.const [81] = InterfaceMethod [209] [210] 
.const [82] = Class [211] 
.const [83] = NameAndType [212] [213] 
.const [84] = Utf8 java/lang/ClassNotFoundException 
.const [85] = Utf8 java/lang/NoClassDefFoundError 
.const [86] = Utf8 FwStorage 
.const [87] = Utf8 'Fw.Storage.Activator' 
.const [88] = Utf8 de/audi/tghu/storage/StorageStatistic 
.const [89] = Class [214] 
.const [90] = NameAndType [215] [216] 
.const [91] = Utf8 'de.esolutions.fw.util.commons.error.DumpInfoProvider' 
.const [92] = Class [217] 
.const [93] = NameAndType [218] [219] 
.const [94] = Utf8 de/audi/tghu/storage/DSIStorageProvider 
.const [95] = Utf8 java/util/Hashtable 
.const [96] = Utf8 DEVICE_NAME 
.const [97] = Class [220] 
.const [98] = NameAndType [221] [222] 
.const [99] = Utf8 'org.dsi.ifc.persistence.DSIPersistenceListener' 
.const [100] = Utf8 DEVICE_INSTANCE 
.const [101] = Utf8 java/lang/Integer 
.const [102] = Class [223] 
.const [103] = NameAndType [224] [225] 
.const [104] = Utf8 'org.dsi.ifc.base.DSIListener' 
.const [105] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [106] = Utf8 java/lang/String 
.const [107] = Class [226] 
.const [108] = NameAndType [227] [228] 
.const [109] = Utf8 'org.dsi.ifc.persistence.DSIPersistence' 
.const [110] = Class [229] 
.const [111] = NameAndType [230] [231] 
.const [112] = Utf8 'de.audi.atip.diag.sw.SwDiagnosisManager' 
.const [113] = Utf8 de/audi/tghu/storage/StorageActivator$1 
.const [114] = Utf8 de/audi/tghu/storage/StorageActivator 
.const [115] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [116] = Utf8 java/lang/Class 
.const [117] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [118] = Utf8 org/osgi/framework/BundleContext 
.const [119] = Utf8 org/osgi/framework/ServiceRegistration 
.const [120] = Class [232] 
.const [121] = NameAndType [233] [234] 
.const [122] = Class [235] 
.const [123] = NameAndType [236] [237] 
.const [124] = Class [238] 
.const [125] = NameAndType [239] [240] 
.const [126] = Class [241] 
.const [127] = NameAndType [242] [243] 
.const [128] = Class [244] 
.const [129] = NameAndType [245] [246] 
.const [130] = Class [247] 
.const [131] = NameAndType [248] [249] 
.const [132] = Class [250] 
.const [133] = NameAndType [251] [252] 
.const [134] = Class [253] 
.const [135] = NameAndType [254] [255] 
.const [136] = Class [256] 
.const [137] = NameAndType [257] [258] 
.const [138] = Class [259] 
.const [139] = NameAndType [260] [261] 
.const [140] = Class [262] 
.const [141] = NameAndType [263] [264] 
.const [142] = Class [265] 
.const [143] = NameAndType [266] [267] 
.const [144] = Class [268] 
.const [145] = NameAndType [269] [270] 
.const [146] = Class [271] 
.const [147] = NameAndType [272] [273] 
.const [148] = Class [274] 
.const [149] = NameAndType [275] [276] 
.const [150] = Class [277] 
.const [151] = NameAndType [278] [279] 
.const [152] = Class [280] 
.const [153] = NameAndType [281] [282] 
.const [154] = Class [283] 
.const [155] = NameAndType [284] [285] 
.const [156] = Class [286] 
.const [157] = NameAndType [287] [288] 
.const [158] = Class [289] 
.const [159] = NameAndType [290] [291] 
.const [160] = Class [292] 
.const [161] = NameAndType [293] [294] 
.const [162] = Class [295] 
.const [163] = NameAndType [296] [297] 
.const [164] = Class [298] 
.const [165] = NameAndType [299] [300] 
.const [166] = Class [301] 
.const [167] = NameAndType [302] [303] 
.const [168] = Class [304] 
.const [169] = NameAndType [305] [306] 
.const [170] = Class [307] 
.const [171] = NameAndType [308] [309] 
.const [172] = Class [310] 
.const [173] = NameAndType [311] [312] 
.const [174] = Class [313] 
.const [175] = NameAndType [314] [315] 
.const [176] = Class [316] 
.const [177] = NameAndType [317] [318] 
.const [178] = Class [319] 
.const [179] = NameAndType [320] [321] 
.const [180] = Class [322] 
.const [181] = NameAndType [323] [324] 
.const [182] = Class [325] 
.const [183] = NameAndType [326] [327] 
.const [184] = Class [328] 
.const [185] = NameAndType [329] [330] 
.const [186] = Class [331] 
.const [187] = NameAndType [332] [333] 
.const [188] = Class [334] 
.const [189] = NameAndType [335] [336] 
.const [190] = Class [337] 
.const [191] = NameAndType [338] [339] 
.const [192] = Utf8 java/lang/NoClassDefFoundError 
.const [193] = Class [340] 
.const [194] = NameAndType [341] [342] 
.const [195] = Utf8 de/audi/tghu/storage/StorageStatistic 
.const [196] = Class [343] 
.const [197] = NameAndType [344] [345] 
.const [198] = Class [346] 
.const [199] = NameAndType [347] [348] 
.const [200] = Utf8 de/audi/tghu/storage/DSIStorageProvider 
.const [201] = Utf8 java/util/Hashtable 
.const [202] = Utf8 java/lang/Integer 
.const [203] = Class [349] 
.const [204] = NameAndType [350] [351] 
.const [205] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [206] = Utf8 de/audi/tghu/storage/StorageActivator$1 
.const [207] = Class [352] 
.const [208] = NameAndType [353] [354] 
.const [209] = Class [355] 
.const [210] = NameAndType [356] [357] 
.const [211] = Utf8 java/lang/Class 
.const [212] = Utf8 forName 
.const [213] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [214] = Utf8 de/audi/tghu/storage/StorageActivator 
.const [215] = Utf8 class$de$esolutions$fw$util$commons$error$DumpInfoProvider 
.const [216] = Utf8 Ljava/lang/Class; 
.const [217] = Utf8 de/audi/tghu/storage/StorageActivator 
.const [218] = Utf8 class$ 
.const [219] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [220] = Utf8 de/audi/tghu/storage/StorageActivator 
.const [221] = Utf8 class$org$dsi$ifc$persistence$DSIPersistenceListener 
.const [222] = Utf8 Ljava/lang/Class; 
.const [223] = Utf8 de/audi/tghu/storage/StorageActivator 
.const [224] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [225] = Utf8 Ljava/lang/Class; 
.const [226] = Utf8 de/audi/tghu/storage/StorageActivator 
.const [227] = Utf8 class$org$dsi$ifc$persistence$DSIPersistence 
.const [228] = Utf8 Ljava/lang/Class; 
.const [229] = Utf8 de/audi/tghu/storage/StorageActivator 
.const [230] = Utf8 class$de$audi$atip$diag$sw$SwDiagnosisManager 
.const [231] = Utf8 Ljava/lang/Class; 
.const [232] = Utf8 de/audi/tghu/storage/StorageActivator 
.const [233] = Utf8 framework 
.const [234] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [235] = Utf8 de/audi/tghu/storage/StorageActivator 
.const [236] = Utf8 getBundleContext 
.const [237] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [238] = Utf8 de/audi/tghu/storage/StorageActivator 
.const [239] = Utf8 stor 
.const [240] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [241] = Utf8 de/audi/tghu/storage/StorageActivator 
.const [242] = Utf8 fwServices 
.const [243] = Utf8 Lde/audi/atip/base/FwServices; 
.const [244] = Utf8 de/audi/tghu/storage/StorageActivator 
.const [245] = Utf8 statistic 
.const [246] = Utf8 Lde/audi/tghu/storage/StorageStatistic; 
.const [247] = Utf8 de/audi/tghu/storage/StorageActivator 
.const [248] = Utf8 storageManager 
.const [249] = Utf8 Lde/audi/tghu/storage/StorageAccess; 
.const [250] = Utf8 de/audi/tghu/storage/StorageActivator 
.const [251] = Utf8 dsiStorageProv 
.const [252] = Utf8 Lde/audi/tghu/storage/DSIStorageProvider; 
.const [253] = Utf8 java/lang/NoClassDefFoundError 
.const [254] = Utf8 initCause 
.const [255] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [256] = Utf8 java/lang/Class 
.const [257] = Utf8 getName 
.const [258] = Utf8 ()Ljava/lang/String; 
.const [259] = Utf8 de/audi/tghu/storage/StorageActivator 
.const [260] = Utf8 statisticSvcReg 
.const [261] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [262] = Utf8 java/util/Hashtable 
.const [263] = Utf8 put 
.const [264] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [265] = Utf8 de/audi/tghu/storage/StorageActivator 
.const [266] = Utf8 dsiPersistenceListenerSvcReg 
.const [267] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [268] = Utf8 de/audi/tghu/storage/StorageActivator 
.const [269] = Utf8 dsiPersistenceTracker 
.const [270] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [271] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [272] = Utf8 'open' 
.const [273] = Utf8 ()V 
.const [274] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [275] = Utf8 close 
.const [276] = Utf8 ()V 
.const [277] = Utf8 de/audi/tghu/storage/DSIStorageProvider 
.const [278] = Utf8 stop 
.const [279] = Utf8 ()V 
.const [280] = Utf8 de/audi/tghu/storage/DSIStorageProvider 
.const [281] = Utf8 flush 
.const [282] = Utf8 ()V 
.const [283] = Utf8 java/lang/NoClassDefFoundError 
.const [284] = Utf8 <init> 
.const [285] = Utf8 ()V 
.const [286] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [287] = Utf8 <init> 
.const [288] = Utf8 (Ljava/lang/String;)V 
.const [289] = Utf8 de/audi/tghu/storage/StorageStatistic 
.const [290] = Utf8 <init> 
.const [291] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [292] = Utf8 de/audi/tghu/storage/StorageActivator 
.const [293] = Utf8 class$de$esolutions$fw$util$commons$error$DumpInfoProvider 
.const [294] = Utf8 Ljava/lang/Class; 
.const [295] = Utf8 de/audi/tghu/storage/DSIStorageProvider 
.const [296] = Utf8 <init> 
.const [297] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;Lde/audi/tghu/storage/StorageStatistic;)V 
.const [298] = Utf8 java/util/Hashtable 
.const [299] = Utf8 <init> 
.const [300] = Utf8 ()V 
.const [301] = Utf8 de/audi/tghu/storage/StorageActivator 
.const [302] = Utf8 class$org$dsi$ifc$persistence$DSIPersistenceListener 
.const [303] = Utf8 Ljava/lang/Class; 
.const [304] = Utf8 java/lang/Integer 
.const [305] = Utf8 <init> 
.const [306] = Utf8 (I)V 
.const [307] = Utf8 de/audi/tghu/storage/StorageActivator 
.const [308] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [309] = Utf8 Ljava/lang/Class; 
.const [310] = Utf8 de/audi/tghu/storage/StorageActivator 
.const [311] = Utf8 class$org$dsi$ifc$persistence$DSIPersistence 
.const [312] = Utf8 Ljava/lang/Class; 
.const [313] = Utf8 de/audi/tghu/storage/StorageActivator 
.const [314] = Utf8 class$de$audi$atip$diag$sw$SwDiagnosisManager 
.const [315] = Utf8 Ljava/lang/Class; 
.const [316] = Utf8 de/audi/tghu/storage/StorageActivator$1 
.const [317] = Utf8 <init> 
.const [318] = Utf8 (Lde/audi/tghu/storage/StorageActivator;)V 
.const [319] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [320] = Utf8 <init> 
.const [321] = Utf8 (Lorg/osgi/framework/BundleContext;[Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [322] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [323] = Utf8 stop 
.const [324] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [325] = Utf8 de/audi/tghu/storage/StorageActivator 
.const [326] = Utf8 stor 
.const [327] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [328] = Utf8 de/audi/tghu/storage/StorageActivator 
.const [329] = Utf8 fwServices 
.const [330] = Utf8 Lde/audi/atip/base/FwServices; 
.const [331] = Utf8 de/audi/tghu/storage/StorageActivator 
.const [332] = Utf8 statistic 
.const [333] = Utf8 Lde/audi/tghu/storage/StorageStatistic; 
.const [334] = Utf8 de/audi/tghu/storage/StorageActivator 
.const [335] = Utf8 storageManager 
.const [336] = Utf8 Lde/audi/tghu/storage/StorageAccess; 
.const [337] = Utf8 de/audi/tghu/storage/StorageActivator 
.const [338] = Utf8 dsiStorageProv 
.const [339] = Utf8 Lde/audi/tghu/storage/DSIStorageProvider; 
.const [340] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [341] = Utf8 getLogChannel 
.const [342] = Utf8 (Ljava/lang/String;)Lde/audi/atip/log/LogChannel; 
.const [343] = Utf8 org/osgi/framework/BundleContext 
.const [344] = Utf8 registerService 
.const [345] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [346] = Utf8 de/audi/tghu/storage/StorageActivator 
.const [347] = Utf8 statisticSvcReg 
.const [348] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [349] = Utf8 de/audi/tghu/storage/StorageActivator 
.const [350] = Utf8 dsiPersistenceListenerSvcReg 
.const [351] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [352] = Utf8 de/audi/tghu/storage/StorageActivator 
.const [353] = Utf8 dsiPersistenceTracker 
.const [354] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [355] = Utf8 org/osgi/framework/ServiceRegistration 
.const [356] = Utf8 unregister 
.const [357] = Utf8 ()V 
.const [358] = Utf8 de/audi/tghu/storage/StorageActivator 
.const [359] = Class [358] 
.const [360] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [361] = Class [360] 
.const [362] = Utf8 storageManager 
.const [363] = Utf8 Lde/audi/tghu/storage/StorageAccess; 
.const [364] = Utf8 dsiStorageProv 
.const [365] = Utf8 Lde/audi/tghu/storage/DSIStorageProvider; 
.const [366] = Utf8 statistic 
.const [367] = Utf8 Lde/audi/tghu/storage/StorageStatistic; 
.const [368] = Utf8 dsiPersistenceListenerSvcReg 
.const [369] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [370] = Utf8 statisticSvcReg 
.const [371] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [372] = Utf8 dsiPersistenceTracker 
.const [373] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [374] = Utf8 stor 
.const [375] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [376] = Utf8 fwServices 
.const [377] = Utf8 Lde/audi/atip/base/FwServices; 
.const [378] = Utf8 class$de$esolutions$fw$util$commons$error$DumpInfoProvider 
.const [379] = Utf8 Ljava/lang/Class; 
.const [380] = Utf8 class$org$dsi$ifc$persistence$DSIPersistenceListener 
.const [381] = Utf8 Ljava/lang/Class; 
.const [382] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [383] = Utf8 Ljava/lang/Class; 
.const [384] = Utf8 class$org$dsi$ifc$persistence$DSIPersistence 
.const [385] = Utf8 Ljava/lang/Class; 
.const [386] = Utf8 class$de$audi$atip$diag$sw$SwDiagnosisManager 
.const [387] = Utf8 Ljava/lang/Class; 
.const [388] = Utf8 Code 
.const [389] = Utf8 getService 
.const [390] = Utf8 ()Lde/audi/tghu/storage/StorageAccess; 
.const [391] = Utf8 <init> 
.const [392] = Utf8 (Lde/audi/atip/base/FwServices;)V 
.const [393] = Utf8 startInternal 
.const [394] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [395] = Utf8 stop 
.const [396] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [397] = Utf8 flush 
.const [398] = Utf8 ()V 
.const [399] = Utf8 class$ 
.const [400] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [401] = Utf8 access$000 
.const [402] = Utf8 (Lde/audi/tghu/storage/StorageActivator;)Lorg/osgi/framework/BundleContext; 
.const [403] = Utf8 access$100 
.const [404] = Utf8 (Lde/audi/tghu/storage/StorageActivator;)Lde/audi/tghu/storage/DSIStorageProvider; 
.const [405] = Utf8 access$200 
.const [406] = Utf8 (Lde/audi/tghu/storage/StorageActivator;)Lde/audi/tghu/storage/StorageAccess; 
.const [407] = Utf8 access$202 
.const [408] = Utf8 (Lde/audi/tghu/storage/StorageActivator;Lde/audi/tghu/storage/StorageAccess;)Lde/audi/tghu/storage/StorageAccess; 
.const [409] = Utf8 access$300 
.const [410] = Utf8 (Lde/audi/tghu/storage/StorageActivator;)Lde/audi/tghu/storage/StorageStatistic; 
.const [411] = Utf8 access$400 
.const [412] = Utf8 (Lde/audi/tghu/storage/StorageActivator;)Lde/audi/atip/base/FwServices; 
.const [413] = Utf8 access$500 
.const [414] = Utf8 (Lde/audi/tghu/storage/StorageActivator;)Lde/audi/atip/log/LogChannel; 
.const [415] = Utf8 access$600 
.const [416] = Utf8 (Lde/audi/tghu/storage/StorageActivator;)Lorg/osgi/framework/BundleContext; 
.const [417] = Utf8 access$700 
.const [418] = Utf8 (Lde/audi/tghu/storage/StorageActivator;)Lorg/osgi/framework/BundleContext; 
.const [419] = Utf8 access$800 
.const [420] = Utf8 (Lde/audi/tghu/storage/StorageActivator;)Lde/audi/atip/base/IFrameworkAccess; 
.end class 
