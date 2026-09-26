.version 50 0 
.class public final super [353] 
.super [355] 
.implements [357] 
.field private [358] [359] 
.field private [360] [361] 
.field private [362] [363] 
.field static synthetic [364] [365] 
.field static synthetic [366] [367] 
.field static synthetic [368] [369] 
.field static synthetic [370] [371] 
.field static synthetic [372] [373] 
.field static synthetic [374] [375] 

.method public [377] : [378] 
    .attribute [376] .code stack 2 locals 0 
L0:     aload_0 
L1:     ldc [5] 
L3:     invokespecial [55] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [379] : [380] 
    .attribute [376] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [39] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [381] : [382] 
    .attribute [376] .code stack 9 locals 1 
L0:     aload_0 
L1:     new [70] 
L4:     dup 
L5:     aload_0 
L6:     getfield [40] 
L9:     invokespecial [56] 
L12:    putfield [69] 
L15:    new [71] 
L18:    dup 
L19:    invokespecial [57] 
L22:    astore_2 
L23:    aload_2 
L24:    ldc [8] 
L26:    getstatic [9] 
L29:    ifnonnull L44 
L32:    ldc [10] 
L34:    invokestatic [11] 
L37:    dup 
L38:    putstatic [58] 
L41:    goto L47 
L44:    getstatic [9] 
L47:    invokevirtual [41] 
L50:    invokevirtual [42] 
L53:    pop 
L54:    aload_2 
L55:    ldc [12] 
L57:    new [72] 
L60:    dup 
L61:    iconst_0 
L62:    invokespecial [59] 
L65:    invokevirtual [42] 
L68:    pop 
L69:    aload_0 
L70:    aload_1 
L71:    getstatic [14] 
L74:    ifnonnull L89 
L77:    ldc [15] 
L79:    invokestatic [11] 
L82:    dup 
L83:    putstatic [60] 
L86:    goto L92 
L89:    getstatic [14] 
L92:    invokevirtual [41] 
L95:    aload_0 
L96:    getfield [39] 
L99:    invokevirtual [43] 
L102:   aload_2 
L103:   invokeinterface [73] 0 
L108:   putfield [74] 
L111:   aload_0 
L112:   new [75] 
L115:   dup 
L116:   aload_0 
L117:   getfield [45] 
L120:   iconst_4 
L121:   anewarray [17] 
L124:   dup 
L125:   iconst_0 
L126:   getstatic [18] 
L129:   ifnonnull L144 
L132:   ldc [19] 
L134:   invokestatic [11] 
L137:   dup 
L138:   putstatic [61] 
L141:   goto L147 
L144:   getstatic [18] 
L147:   invokevirtual [41] 
L150:   aastore 
L151:   dup 
L152:   iconst_1 
L153:   getstatic [20] 
L156:   ifnonnull L171 
L159:   ldc [21] 
L161:   invokestatic [11] 
L164:   dup 
L165:   putstatic [62] 
L168:   goto L174 
L171:   getstatic [20] 
L174:   invokevirtual [41] 
L177:   aastore 
L178:   dup 
L179:   iconst_2 
L180:   getstatic [22] 
L183:   ifnonnull L198 
L186:   ldc [23] 
L188:   invokestatic [11] 
L191:   dup 
L192:   putstatic [63] 
L195:   goto L201 
L198:   getstatic [22] 
L201:   invokevirtual [41] 
L204:   aastore 
L205:   dup 
L206:   iconst_3 
L207:   getstatic [24] 
L210:   ifnonnull L225 
L213:   ldc [25] 
L215:   invokestatic [11] 
L218:   dup 
L219:   putstatic [64] 
L222:   goto L228 
L225:   getstatic [24] 
L228:   invokevirtual [41] 
L231:   aastore 
L232:   aload_0 
L233:   invokespecial [65] 
L236:   putfield [76] 
L239:   aload_0 
L240:   getfield [46] 
L243:   invokevirtual [47] 
L246:   aload_0 
L247:   getfield [40] 
L250:   getstatic [18] 
L253:   ifnonnull L268 
L256:   ldc [19] 
L258:   invokestatic [11] 
L261:   dup 
L262:   putstatic [61] 
L265:   goto L271 
L268:   getstatic [18] 
L271:   invokevirtual [41] 
L274:   iconst_0 
L275:   invokeinterface [77] 0 
L280:   pop 
L281:   return 
L282:   nop 
L283:   nop 
L284:   
    .end code 
.end method 

.method public [383] : [384] 
    .attribute [376] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [44] 
L4:     ifnull L21 
L7:     aload_0 
L8:     getfield [44] 
L11:    invokeinterface [78] 0 
L16:    aload_0 
L17:    aconst_null 
L18:    putfield [74] 
L21:    aload_0 
L22:    getfield [46] 
L25:    ifnull L40 
L28:    aload_0 
L29:    getfield [46] 
L32:    invokevirtual [48] 
L35:    aload_0 
L36:    aconst_null 
L37:    putfield [76] 
L40:    aload_0 
L41:    aload_1 
L42:    invokespecial [66] 
L45:    return 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [385] : [386] 
    .attribute [376] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [45] 
L4:     aload_1 
L5:     invokeinterface [79] 0 
L10:    astore_2 
L11:    aload_2 
L12:    instanceof [26] 
L15:    ifeq L32 
L18:    aload_0 
L19:    getfield [39] 
L22:    invokevirtual [43] 
L25:    aload_2 
L26:    checkcast [26] 
L29:    invokevirtual [49] 
L32:    aload_2 
L33:    instanceof [27] 
L36:    ifeq L56 
L39:    aload_0 
L40:    getfield [39] 
L43:    invokevirtual [43] 
L46:    aload_2 
L47:    checkcast [27] 
L50:    invokevirtual [50] 
L53:    goto L109 
L56:    aload_2 
L57:    instanceof [28] 
L60:    ifeq L77 
L63:    aload_0 
L64:    getfield [39] 
L67:    aload_2 
L68:    checkcast [28] 
L71:    invokevirtual [51] 
L74:    goto L109 
L77:    aload_2 
L78:    instanceof [29] 
L81:    ifeq L107 
L84:    aload_2 
L85:    checkcast [29] 
L88:    new [80] 
L91:    dup 
L92:    aload_0 
L93:    invokevirtual [52] 
L96:    invokespecial [67] 
L99:    invokeinterface [81] 0 
L104:   goto L109 
L107:   aconst_null 
L108:   areturn 
L109:   aload_2 
L110:   areturn 
L111:   nop 
L112:   
    .end code 
.end method 

.method public enum [387] : [388] 
    .attribute [376] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [389] : [390] 
    .attribute [376] .code stack 2 locals 0 
L0:     aload_2 
L1:     instanceof [28] 
L4:     ifeq L21 
L7:     aload_0 
L8:     getfield [39] 
L11:    aload_2 
L12:    checkcast [28] 
L15:    invokevirtual [53] 
L18:    goto L39 
L21:    aload_2 
L22:    instanceof [27] 
L25:    ifeq L39 
L28:    aload_0 
L29:    getfield [39] 
L32:    invokevirtual [43] 
L35:    aconst_null 
L36:    invokevirtual [50] 
L39:    aload_0 
L40:    getfield [45] 
L43:    aload_1 
L44:    invokeinterface [82] 0 
L49:    pop 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method static synthetic [391] : [392] 
    .attribute [376] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [68] 
L9:     dup 
L10:    invokespecial [54] 
L13:    aload_1 
L14:    invokevirtual [38] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [83] [84] 
.const [3] = Class [85] 
.const [4] = Class [86] 
.const [5] = String [87] 
.const [6] = Class [88] 
.const [7] = Class [89] 
.const [8] = String [90] 
.const [9] = Field [91] [92] 
.const [10] = String [93] 
.const [11] = Method [94] [95] 
.const [12] = String [96] 
.const [13] = Class [97] 
.const [14] = Field [98] [99] 
.const [15] = String [100] 
.const [16] = Class [101] 
.const [17] = Class [102] 
.const [18] = Field [103] [104] 
.const [19] = String [105] 
.const [20] = Field [106] [107] 
.const [21] = String [108] 
.const [22] = Field [109] [110] 
.const [23] = String [111] 
.const [24] = Field [112] [113] 
.const [25] = String [114] 
.const [26] = Class [115] 
.const [27] = Class [116] 
.const [28] = Class [117] 
.const [29] = Class [118] 
.const [30] = Class [119] 
.const [31] = Class [120] 
.const [32] = Class [121] 
.const [33] = Class [122] 
.const [34] = Class [123] 
.const [35] = Class [124] 
.const [36] = Class [125] 
.const [37] = Class [126] 
.const [38] = Method [127] [128] 
.const [39] = Field [129] [130] 
.const [40] = Field [131] [132] 
.const [41] = Method [133] [134] 
.const [42] = Method [135] [136] 
.const [43] = Method [137] [138] 
.const [44] = Field [139] [140] 
.const [45] = Field [141] [142] 
.const [46] = Field [143] [144] 
.const [47] = Method [145] [146] 
.const [48] = Method [147] [148] 
.const [49] = Method [149] [150] 
.const [50] = Method [151] [152] 
.const [51] = Method [153] [154] 
.const [52] = Method [155] [156] 
.const [53] = Method [157] [158] 
.const [54] = Method [159] [160] 
.const [55] = Method [161] [162] 
.const [56] = Method [163] [164] 
.const [57] = Method [165] [166] 
.const [58] = Field [167] [168] 
.const [59] = Method [169] [170] 
.const [60] = Field [171] [172] 
.const [61] = Field [173] [174] 
.const [62] = Field [175] [176] 
.const [63] = Field [177] [178] 
.const [64] = Field [179] [180] 
.const [65] = Method [181] [182] 
.const [66] = Method [183] [184] 
.const [67] = Method [185] [186] 
.const [68] = Class [187] 
.const [69] = Field [188] [189] 
.const [70] = Class [190] 
.const [71] = Class [191] 
.const [72] = Class [192] 
.const [73] = InterfaceMethod [193] [194] 
.const [74] = Field [195] [196] 
.const [75] = Class [197] 
.const [76] = Field [198] [199] 
.const [77] = InterfaceMethod [200] [201] 
.const [78] = InterfaceMethod [202] [203] 
.const [79] = InterfaceMethod [204] [205] 
.const [80] = Class [206] 
.const [81] = InterfaceMethod [207] [208] 
.const [82] = InterfaceMethod [209] [210] 
.const [83] = Class [211] 
.const [84] = NameAndType [212] [213] 
.const [85] = Utf8 java/lang/ClassNotFoundException 
.const [86] = Utf8 java/lang/NoClassDefFoundError 
.const [87] = Utf8 FwDiag 
.const [88] = Utf8 de/audi/tghu/diag/DiagnosisApp 
.const [89] = Utf8 java/util/Hashtable 
.const [90] = Utf8 DEVICE_NAME 
.const [91] = Class [214] 
.const [92] = NameAndType [215] [216] 
.const [93] = Utf8 'org.dsi.ifc.diagnose.DSIDiagnoseSystemListener' 
.const [94] = Class [217] 
.const [95] = NameAndType [218] [219] 
.const [96] = Utf8 DEVICE_INSTANCE 
.const [97] = Utf8 java/lang/Integer 
.const [98] = Class [220] 
.const [99] = NameAndType [221] [222] 
.const [100] = Utf8 'org.dsi.ifc.base.DSIListener' 
.const [101] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [102] = Utf8 java/lang/String 
.const [103] = Class [223] 
.const [104] = NameAndType [224] [225] 
.const [105] = Utf8 'org.dsi.ifc.diagnose.DSIDiagnoseSystem' 
.const [106] = Class [226] 
.const [107] = NameAndType [227] [228] 
.const [108] = Utf8 'de.audi.atip.diag.IDiagnosisApp' 
.const [109] = Class [229] 
.const [110] = NameAndType [230] [231] 
.const [111] = Utf8 'de.audi.atip.diag.sw.SwDiagnosisManager' 
.const [112] = Class [232] 
.const [113] = NameAndType [233] [234] 
.const [114] = Utf8 'de.audi.atip.interapp.NaviService' 
.const [115] = Utf8 org/dsi/ifc/diagnose/DSIDiagnoseSystem 
.const [116] = Utf8 de/audi/atip/interapp/NaviService 
.const [117] = Utf8 de/audi/atip/diag/IDiagnosisApp 
.const [118] = Utf8 de/audi/atip/diag/sw/SwDiagnosisManager 
.const [119] = Utf8 de/mib/swdiagnosis/DiagnosisSwDiagGateway 
.const [120] = Utf8 de/audi/tghu/diag/DiagnosisActivator 
.const [121] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [122] = Utf8 java/lang/Class 
.const [123] = Utf8 org/osgi/framework/BundleContext 
.const [124] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [125] = Utf8 org/osgi/framework/ServiceRegistration 
.const [126] = Utf8 de/audi/tghu/diag/DiagnosisDSIHandler 
.const [127] = Class [235] 
.const [128] = NameAndType [236] [237] 
.const [129] = Class [238] 
.const [130] = NameAndType [239] [240] 
.const [131] = Class [241] 
.const [132] = NameAndType [242] [243] 
.const [133] = Class [244] 
.const [134] = NameAndType [245] [246] 
.const [135] = Class [247] 
.const [136] = NameAndType [248] [249] 
.const [137] = Class [250] 
.const [138] = NameAndType [251] [252] 
.const [139] = Class [253] 
.const [140] = NameAndType [254] [255] 
.const [141] = Class [256] 
.const [142] = NameAndType [257] [258] 
.const [143] = Class [259] 
.const [144] = NameAndType [260] [261] 
.const [145] = Class [262] 
.const [146] = NameAndType [263] [264] 
.const [147] = Class [265] 
.const [148] = NameAndType [266] [267] 
.const [149] = Class [268] 
.const [150] = NameAndType [269] [270] 
.const [151] = Class [271] 
.const [152] = NameAndType [272] [273] 
.const [153] = Class [274] 
.const [154] = NameAndType [275] [276] 
.const [155] = Class [277] 
.const [156] = NameAndType [278] [279] 
.const [157] = Class [280] 
.const [158] = NameAndType [281] [282] 
.const [159] = Class [283] 
.const [160] = NameAndType [284] [285] 
.const [161] = Class [286] 
.const [162] = NameAndType [287] [288] 
.const [163] = Class [289] 
.const [164] = NameAndType [290] [291] 
.const [165] = Class [292] 
.const [166] = NameAndType [293] [294] 
.const [167] = Class [295] 
.const [168] = NameAndType [296] [297] 
.const [169] = Class [298] 
.const [170] = NameAndType [299] [300] 
.const [171] = Class [301] 
.const [172] = NameAndType [302] [303] 
.const [173] = Class [304] 
.const [174] = NameAndType [305] [306] 
.const [175] = Class [307] 
.const [176] = NameAndType [308] [309] 
.const [177] = Class [310] 
.const [178] = NameAndType [311] [312] 
.const [179] = Class [313] 
.const [180] = NameAndType [314] [315] 
.const [181] = Class [316] 
.const [182] = NameAndType [317] [318] 
.const [183] = Class [319] 
.const [184] = NameAndType [320] [321] 
.const [185] = Class [322] 
.const [186] = NameAndType [323] [324] 
.const [187] = Utf8 java/lang/NoClassDefFoundError 
.const [188] = Class [325] 
.const [189] = NameAndType [326] [327] 
.const [190] = Utf8 de/audi/tghu/diag/DiagnosisApp 
.const [191] = Utf8 java/util/Hashtable 
.const [192] = Utf8 java/lang/Integer 
.const [193] = Class [328] 
.const [194] = NameAndType [329] [330] 
.const [195] = Class [331] 
.const [196] = NameAndType [332] [333] 
.const [197] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [198] = Class [334] 
.const [199] = NameAndType [335] [336] 
.const [200] = Class [337] 
.const [201] = NameAndType [338] [339] 
.const [202] = Class [340] 
.const [203] = NameAndType [341] [342] 
.const [204] = Class [343] 
.const [205] = NameAndType [344] [345] 
.const [206] = Utf8 de/mib/swdiagnosis/DiagnosisSwDiagGateway 
.const [207] = Class [346] 
.const [208] = NameAndType [347] [348] 
.const [209] = Class [349] 
.const [210] = NameAndType [350] [351] 
.const [211] = Utf8 java/lang/Class 
.const [212] = Utf8 forName 
.const [213] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [214] = Utf8 de/audi/tghu/diag/DiagnosisActivator 
.const [215] = Utf8 class$org$dsi$ifc$diagnose$DSIDiagnoseSystemListener 
.const [216] = Utf8 Ljava/lang/Class; 
.const [217] = Utf8 de/audi/tghu/diag/DiagnosisActivator 
.const [218] = Utf8 class$ 
.const [219] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [220] = Utf8 de/audi/tghu/diag/DiagnosisActivator 
.const [221] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [222] = Utf8 Ljava/lang/Class; 
.const [223] = Utf8 de/audi/tghu/diag/DiagnosisActivator 
.const [224] = Utf8 class$org$dsi$ifc$diagnose$DSIDiagnoseSystem 
.const [225] = Utf8 Ljava/lang/Class; 
.const [226] = Utf8 de/audi/tghu/diag/DiagnosisActivator 
.const [227] = Utf8 class$de$audi$atip$diag$IDiagnosisApp 
.const [228] = Utf8 Ljava/lang/Class; 
.const [229] = Utf8 de/audi/tghu/diag/DiagnosisActivator 
.const [230] = Utf8 class$de$audi$atip$diag$sw$SwDiagnosisManager 
.const [231] = Utf8 Ljava/lang/Class; 
.const [232] = Utf8 de/audi/tghu/diag/DiagnosisActivator 
.const [233] = Utf8 class$de$audi$atip$interapp$NaviService 
.const [234] = Utf8 Ljava/lang/Class; 
.const [235] = Utf8 java/lang/NoClassDefFoundError 
.const [236] = Utf8 initCause 
.const [237] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [238] = Utf8 de/audi/tghu/diag/DiagnosisActivator 
.const [239] = Utf8 diagnosisApp 
.const [240] = Utf8 Lde/audi/tghu/diag/DiagnosisApp; 
.const [241] = Utf8 de/audi/tghu/diag/DiagnosisActivator 
.const [242] = Utf8 framework 
.const [243] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [244] = Utf8 java/lang/Class 
.const [245] = Utf8 getName 
.const [246] = Utf8 ()Ljava/lang/String; 
.const [247] = Utf8 java/util/Hashtable 
.const [248] = Utf8 put 
.const [249] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [250] = Utf8 de/audi/tghu/diag/DiagnosisApp 
.const [251] = Utf8 getDsiHandler 
.const [252] = Utf8 ()Lde/audi/tghu/diag/DiagnosisDSIHandler; 
.const [253] = Utf8 de/audi/tghu/diag/DiagnosisActivator 
.const [254] = Utf8 sRegDiag 
.const [255] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [256] = Utf8 de/audi/tghu/diag/DiagnosisActivator 
.const [257] = Utf8 bundleContext 
.const [258] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [259] = Utf8 de/audi/tghu/diag/DiagnosisActivator 
.const [260] = Utf8 dsiTracker 
.const [261] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [262] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [263] = Utf8 'open' 
.const [264] = Utf8 ()V 
.const [265] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [266] = Utf8 close 
.const [267] = Utf8 ()V 
.const [268] = Utf8 de/audi/tghu/diag/DiagnosisDSIHandler 
.const [269] = Utf8 setDSIDiagnoseSystem 
.const [270] = Utf8 (Lorg/dsi/ifc/diagnose/DSIDiagnoseSystem;)V 
.const [271] = Utf8 de/audi/tghu/diag/DiagnosisDSIHandler 
.const [272] = Utf8 setNaviService 
.const [273] = Utf8 (Lde/audi/atip/interapp/NaviService;)V 
.const [274] = Utf8 de/audi/tghu/diag/DiagnosisApp 
.const [275] = Utf8 addDiagnosisApplication 
.const [276] = Utf8 (Lde/audi/atip/diag/IDiagnosisApp;)V 
.const [277] = Utf8 de/audi/tghu/diag/DiagnosisActivator 
.const [278] = Utf8 getService 
.const [279] = Utf8 ()Lde/audi/tghu/diag/DiagnosisApp; 
.const [280] = Utf8 de/audi/tghu/diag/DiagnosisApp 
.const [281] = Utf8 removeDiagnosisApplication 
.const [282] = Utf8 (Lde/audi/atip/diag/IDiagnosisApp;)V 
.const [283] = Utf8 java/lang/NoClassDefFoundError 
.const [284] = Utf8 <init> 
.const [285] = Utf8 ()V 
.const [286] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [287] = Utf8 <init> 
.const [288] = Utf8 (Ljava/lang/String;)V 
.const [289] = Utf8 de/audi/tghu/diag/DiagnosisApp 
.const [290] = Utf8 <init> 
.const [291] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [292] = Utf8 java/util/Hashtable 
.const [293] = Utf8 <init> 
.const [294] = Utf8 ()V 
.const [295] = Utf8 de/audi/tghu/diag/DiagnosisActivator 
.const [296] = Utf8 class$org$dsi$ifc$diagnose$DSIDiagnoseSystemListener 
.const [297] = Utf8 Ljava/lang/Class; 
.const [298] = Utf8 java/lang/Integer 
.const [299] = Utf8 <init> 
.const [300] = Utf8 (I)V 
.const [301] = Utf8 de/audi/tghu/diag/DiagnosisActivator 
.const [302] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [303] = Utf8 Ljava/lang/Class; 
.const [304] = Utf8 de/audi/tghu/diag/DiagnosisActivator 
.const [305] = Utf8 class$org$dsi$ifc$diagnose$DSIDiagnoseSystem 
.const [306] = Utf8 Ljava/lang/Class; 
.const [307] = Utf8 de/audi/tghu/diag/DiagnosisActivator 
.const [308] = Utf8 class$de$audi$atip$diag$IDiagnosisApp 
.const [309] = Utf8 Ljava/lang/Class; 
.const [310] = Utf8 de/audi/tghu/diag/DiagnosisActivator 
.const [311] = Utf8 class$de$audi$atip$diag$sw$SwDiagnosisManager 
.const [312] = Utf8 Ljava/lang/Class; 
.const [313] = Utf8 de/audi/tghu/diag/DiagnosisActivator 
.const [314] = Utf8 class$de$audi$atip$interapp$NaviService 
.const [315] = Utf8 Ljava/lang/Class; 
.const [316] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [317] = Utf8 <init> 
.const [318] = Utf8 (Lorg/osgi/framework/BundleContext;[Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [319] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [320] = Utf8 stop 
.const [321] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [322] = Utf8 de/mib/swdiagnosis/DiagnosisSwDiagGateway 
.const [323] = Utf8 <init> 
.const [324] = Utf8 (Lde/audi/tghu/diag/DiagnosisApp;)V 
.const [325] = Utf8 de/audi/tghu/diag/DiagnosisActivator 
.const [326] = Utf8 diagnosisApp 
.const [327] = Utf8 Lde/audi/tghu/diag/DiagnosisApp; 
.const [328] = Utf8 org/osgi/framework/BundleContext 
.const [329] = Utf8 registerService 
.const [330] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [331] = Utf8 de/audi/tghu/diag/DiagnosisActivator 
.const [332] = Utf8 sRegDiag 
.const [333] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [334] = Utf8 de/audi/tghu/diag/DiagnosisActivator 
.const [335] = Utf8 dsiTracker 
.const [336] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [337] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [338] = Utf8 startDSIService 
.const [339] = Utf8 (Ljava/lang/String;I)Z 
.const [340] = Utf8 org/osgi/framework/ServiceRegistration 
.const [341] = Utf8 unregister 
.const [342] = Utf8 ()V 
.const [343] = Utf8 org/osgi/framework/BundleContext 
.const [344] = Utf8 getService 
.const [345] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [346] = Utf8 de/audi/atip/diag/sw/SwDiagnosisManager 
.const [347] = Utf8 addDiagGateway 
.const [348] = Utf8 (Lde/audi/atip/diag/sw/AbstractSwDiagnosis;)V 
.const [349] = Utf8 org/osgi/framework/BundleContext 
.const [350] = Utf8 ungetService 
.const [351] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [352] = Utf8 de/audi/tghu/diag/DiagnosisActivator 
.const [353] = Class [352] 
.const [354] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [355] = Class [354] 
.const [356] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [357] = Class [356] 
.const [358] = Utf8 diagnosisApp 
.const [359] = Utf8 Lde/audi/tghu/diag/DiagnosisApp; 
.const [360] = Utf8 dsiTracker 
.const [361] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [362] = Utf8 sRegDiag 
.const [363] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [364] = Utf8 class$org$dsi$ifc$diagnose$DSIDiagnoseSystemListener 
.const [365] = Utf8 Ljava/lang/Class; 
.const [366] = Utf8 class$org$dsi$ifc$base$DSIListener 
.const [367] = Utf8 Ljava/lang/Class; 
.const [368] = Utf8 class$org$dsi$ifc$diagnose$DSIDiagnoseSystem 
.const [369] = Utf8 Ljava/lang/Class; 
.const [370] = Utf8 class$de$audi$atip$diag$IDiagnosisApp 
.const [371] = Utf8 Ljava/lang/Class; 
.const [372] = Utf8 class$de$audi$atip$diag$sw$SwDiagnosisManager 
.const [373] = Utf8 Ljava/lang/Class; 
.const [374] = Utf8 class$de$audi$atip$interapp$NaviService 
.const [375] = Utf8 Ljava/lang/Class; 
.const [376] = Utf8 Code 
.const [377] = Utf8 <init> 
.const [378] = Utf8 ()V 
.const [379] = Utf8 getService 
.const [380] = Utf8 ()Lde/audi/tghu/diag/DiagnosisApp; 
.const [381] = Utf8 startInternal 
.const [382] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [383] = Utf8 stop 
.const [384] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [385] = Utf8 addingService 
.const [386] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [387] = Utf8 modifiedService 
.const [388] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [389] = Utf8 removedService 
.const [390] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [391] = Utf8 class$ 
.const [392] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
