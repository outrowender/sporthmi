.version 50 0 
.class public super [368] 
.super [370] 
.implements [372] 
.field private [373] [374] 
.field private [375] [376] 
.field private [377] [378] 
.field private [379] [380] 
.field private [381] [382] 
.field private [383] [384] 
.field static synthetic [385] [386] 
.field static synthetic [387] [388] 

.method public [390] : [391] 
    .attribute [389] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [55] 
L4:     aload_0 
L5:     invokestatic [5] 
L8:     putfield [66] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [392] : [393] 
    .attribute [389] .code stack 9 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [56] 
L5:     aload_0 
L6:     aload_0 
L7:     invokevirtual [33] 
L10:    ldc [6] 
L12:    invokeinterface [67] 0 
L17:    putfield [66] 
L20:    aload_0 
L21:    invokevirtual [33] 
L24:    invokeinterface [68] 0 
L29:    ifne L45 
L32:    aload_0 
L33:    getfield [32] 
L36:    ldc [7] 
L38:    ldc [8] 
L40:    invokevirtual [34] 
L43:    pop 
L44:    return 
L45:    aload_0 
L46:    new [69] 
L49:    dup 
L50:    aload_0 
L51:    getfield [32] 
L54:    invokespecial [57] 
L57:    putfield [70] 
L60:    aload_0 
L61:    new [71] 
L64:    dup 
L65:    aload_0 
L66:    getfield [32] 
L69:    aload_1 
L70:    aload_0 
L71:    invokevirtual [33] 
L74:    aload_0 
L75:    getfield [35] 
L78:    invokespecial [58] 
L81:    putfield [72] 
L84:    aload_0 
L85:    getfield [36] 
L88:    invokevirtual [37] 
L91:    aload_0 
L92:    new [73] 
L95:    dup 
L96:    aload_1 
L97:    iconst_2 
L98:    anewarray [12] 
L101:   dup 
L102:   iconst_0 
L103:   getstatic [13] 
L106:   ifnonnull L121 
L109:   ldc [14] 
L111:   invokestatic [15] 
L114:   dup 
L115:   putstatic [59] 
L118:   goto L124 
L121:   getstatic [13] 
L124:   invokevirtual [38] 
L127:   aastore 
L128:   dup 
L129:   iconst_1 
L130:   getstatic [16] 
L133:   ifnonnull L148 
L136:   ldc [17] 
L138:   invokestatic [15] 
L141:   dup 
L142:   putstatic [60] 
L145:   goto L151 
L148:   getstatic [16] 
L151:   invokevirtual [38] 
L154:   aastore 
L155:   aload_0 
L156:   invokespecial [61] 
L159:   putfield [74] 
L162:   aload_0 
L163:   getfield [39] 
L166:   invokevirtual [40] 
L169:   aload_0 
L170:   new [75] 
L173:   dup 
L174:   aload_0 
L175:   getfield [32] 
L178:   aload_0 
L179:   getfield [36] 
L182:   invokespecial [62] 
L185:   putfield [76] 
L188:   aload_0 
L189:   getstatic [13] 
L192:   ifnonnull L207 
L195:   ldc [14] 
L197:   invokestatic [15] 
L200:   dup 
L201:   putstatic [59] 
L204:   goto L210 
L207:   getstatic [13] 
L210:   invokevirtual [38] 
L213:   aload_0 
L214:   getfield [41] 
L217:   aconst_null 
L218:   invokevirtual [42] 
L221:   aload_0 
L222:   getfield [35] 
L225:   aload_0 
L226:   invokevirtual [43] 
L229:   aload_0 
L230:   getfield [32] 
L233:   ldc [7] 
L235:   ldc [19] 
L237:   invokevirtual [34] 
L240:   pop 
L241:   return 
L242:   nop 
L243:   nop 
L244:   
    .end code 
.end method 

.method public [394] : [395] 
    .attribute [389] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [39] 
L4:     ifnull L19 
L7:     aload_0 
L8:     getfield [39] 
L11:    invokevirtual [44] 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [74] 
L19:    aload_0 
L20:    aload_1 
L21:    invokespecial [63] 
L24:    aload_0 
L25:    getfield [36] 
L28:    invokevirtual [45] 
L31:    aload_0 
L32:    aconst_null 
L33:    putfield [70] 
L36:    aload_0 
L37:    getfield [32] 
L40:    ldc [7] 
L42:    ldc [20] 
L44:    invokevirtual [34] 
L47:    pop 
L48:    return 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [396] : [397] 
    .attribute [389] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [46] 
L4:     aload_1 
L5:     invokeinterface [77] 0 
L10:    astore_2 
L11:    aload_2 
L12:    ifnull L194 
L15:    aload_0 
L16:    getfield [32] 
L19:    ldc [7] 
L21:    ldc [21] 
L23:    aload_2 
L24:    invokevirtual [47] 
L27:    pop 
L28:    aload_2 
L29:    instanceof [18] 
L32:    ifeq L101 
L35:    aload_0 
L36:    aload_2 
L37:    checkcast [18] 
L40:    putfield [76] 
L43:    aload_0 
L44:    getfield [41] 
L47:    aload_0 
L48:    getfield [41] 
L51:    invokevirtual [48] 
L54:    aload_0 
L55:    getfield [49] 
L58:    ifnonnull L194 
L61:    aload_0 
L62:    new [79] 
L65:    dup 
L66:    aload_0 
L67:    getfield [50] 
L70:    invokespecial [64] 
L73:    putfield [78] 
L76:    aload_0 
L77:    getfield [49] 
L80:    aload_0 
L81:    getfield [41] 
L84:    invokevirtual [51] 
L87:    aload_0 
L88:    getfield [49] 
L91:    aload_0 
L92:    getfield [36] 
L95:    invokevirtual [52] 
L98:    goto L194 
L101:   aload_2 
L102:   instanceof [23] 
L105:   ifeq L181 
L108:   aload_0 
L109:   getfield [49] 
L112:   ifnonnull L152 
L115:   aload_0 
L116:   new [79] 
L119:   dup 
L120:   aload_0 
L121:   getfield [50] 
L124:   invokespecial [64] 
L127:   putfield [78] 
L130:   aload_0 
L131:   getfield [49] 
L134:   aload_0 
L135:   getfield [41] 
L138:   invokevirtual [51] 
L141:   aload_0 
L142:   getfield [49] 
L145:   aload_0 
L146:   getfield [36] 
L149:   invokevirtual [52] 
L152:   aload_0 
L153:   getfield [32] 
L156:   ldc [7] 
L158:   ldc [21] 
L160:   aload_2 
L161:   invokevirtual [47] 
L164:   pop 
L165:   aload_2 
L166:   checkcast [23] 
L169:   aload_0 
L170:   getfield [49] 
L173:   invokeinterface [80] 0 
L178:   goto L194 
L181:   aload_0 
L182:   getfield [46] 
L185:   aload_1 
L186:   invokeinterface [81] 0 
L191:   pop 
L192:   aconst_null 
L193:   areturn 
L194:   aload_2 
L195:   areturn 
L196:   
    .end code 
.end method 

.method public enum [398] : [399] 
    .attribute [389] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [400] : [401] 
    .attribute [389] .code stack 2 locals 0 
L0:     aload_2 
L1:     instanceof [18] 
L4:     ifeq L22 
L7:     aload_0 
L8:     getfield [41] 
L11:    invokevirtual [53] 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [76] 
L19:    goto L47 
L22:    aload_2 
L23:    instanceof [23] 
L26:    ifeq L47 
L29:    aload_2 
L30:    checkcast [23] 
L33:    aload_0 
L34:    getfield [49] 
L37:    invokeinterface [82] 0 
L42:    aload_0 
L43:    aconst_null 
L44:    putfield [78] 
L47:    aload_0 
L48:    getfield [46] 
L51:    aload_1 
L52:    invokeinterface [81] 0 
L57:    pop 
L58:    return 
L59:    nop 
L60:    
    .end code 
.end method 

.method static synthetic [402] : [403] 
    .attribute [389] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [65] 
L9:     dup 
L10:    invokespecial [54] 
L13:    aload_1 
L14:    invokevirtual [31] 
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
.const [5] = Method [87] [88] 
.const [6] = String [89] 
.const [7] = Int 1078071040 
.const [8] = String [90] 
.const [9] = Class [91] 
.const [10] = Class [92] 
.const [11] = Class [93] 
.const [12] = Class [94] 
.const [13] = Field [95] [96] 
.const [14] = String [97] 
.const [15] = Method [98] [99] 
.const [16] = Field [100] [101] 
.const [17] = String [102] 
.const [18] = Class [103] 
.const [19] = String [104] 
.const [20] = String [105] 
.const [21] = String [106] 
.const [22] = Class [107] 
.const [23] = Class [108] 
.const [24] = Class [109] 
.const [25] = Class [110] 
.const [26] = Class [111] 
.const [27] = Class [112] 
.const [28] = Class [113] 
.const [29] = Class [114] 
.const [30] = Class [115] 
.const [31] = Method [116] [117] 
.const [32] = Field [118] [119] 
.const [33] = Method [120] [121] 
.const [34] = Method [122] [123] 
.const [35] = Field [124] [125] 
.const [36] = Field [126] [127] 
.const [37] = Method [128] [129] 
.const [38] = Method [130] [131] 
.const [39] = Field [132] [133] 
.const [40] = Method [134] [135] 
.const [41] = Field [136] [137] 
.const [42] = Method [138] [139] 
.const [43] = Method [140] [141] 
.const [44] = Method [142] [143] 
.const [45] = Method [144] [145] 
.const [46] = Field [146] [147] 
.const [47] = Method [148] [149] 
.const [48] = Method [150] [151] 
.const [49] = Field [152] [153] 
.const [50] = Field [154] [155] 
.const [51] = Method [156] [157] 
.const [52] = Method [158] [159] 
.const [53] = Method [160] [161] 
.const [54] = Method [162] [163] 
.const [55] = Method [164] [165] 
.const [56] = Method [166] [167] 
.const [57] = Method [168] [169] 
.const [58] = Method [170] [171] 
.const [59] = Field [172] [173] 
.const [60] = Field [174] [175] 
.const [61] = Method [176] [177] 
.const [62] = Method [178] [179] 
.const [63] = Method [180] [181] 
.const [64] = Method [182] [183] 
.const [65] = Class [184] 
.const [66] = Field [185] [186] 
.const [67] = InterfaceMethod [187] [188] 
.const [68] = InterfaceMethod [189] [190] 
.const [69] = Class [191] 
.const [70] = Field [192] [193] 
.const [71] = Class [194] 
.const [72] = Field [195] [196] 
.const [73] = Class [197] 
.const [74] = Field [198] [199] 
.const [75] = Class [200] 
.const [76] = Field [201] [202] 
.const [77] = InterfaceMethod [203] [204] 
.const [78] = Field [205] [206] 
.const [79] = Class [207] 
.const [80] = InterfaceMethod [208] [209] 
.const [81] = InterfaceMethod [210] [211] 
.const [82] = InterfaceMethod [212] [213] 
.const [83] = Class [214] 
.const [84] = NameAndType [215] [216] 
.const [85] = Utf8 java/lang/ClassNotFoundException 
.const [86] = Utf8 java/lang/NoClassDefFoundError 
.const [87] = Class [217] 
.const [88] = NameAndType [218] [219] 
.const [89] = Utf8 'App.CarSDIS.Main' 
.const [90] = Utf8 'SDIS is not enabled, do not start bundle.' 
.const [91] = Utf8 de/audi/app/car/sdis/CarMainASIProvider 
.const [92] = Utf8 de/audi/app/car/sdis/SDISCarManager 
.const [93] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [94] = Utf8 java/lang/String 
.const [95] = Class [220] 
.const [96] = NameAndType [221] [222] 
.const [97] = Utf8 'de.audi.app.car.common.sdis.interapp.ISDISCarInfoDistributor' 
.const [98] = Class [223] 
.const [99] = NameAndType [224] [225] 
.const [100] = Class [226] 
.const [101] = NameAndType [227] [228] 
.const [102] = Utf8 'de.audi.atip.diag.sw.SwDiagnosisManager' 
.const [103] = Utf8 de/audi/app/car/sdis/mainunit/InterAppSDISDistributor 
.const [104] = Utf8 'AppCarSDIS bundle started' 
.const [105] = Utf8 'AppCarSDIS bundle stopped' 
.const [106] = Utf8 'CarSDISActivator#addingService( %1 )' 
.const [107] = Utf8 de/audi/app/car/sdis/swdiag/SDISCarDiag 
.const [108] = Utf8 de/audi/atip/diag/sw/SwDiagnosisManager 
.const [109] = Utf8 de/audi/app/car/sdis/CarSDISActivator 
.const [110] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [111] = Utf8 java/lang/Class 
.const [112] = Utf8 de/audi/atip/log/NullLogChannel 
.const [113] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [114] = Utf8 de/audi/atip/log/LogChannel 
.const [115] = Utf8 org/osgi/framework/BundleContext 
.const [116] = Class [229] 
.const [117] = NameAndType [230] [231] 
.const [118] = Class [232] 
.const [119] = NameAndType [233] [234] 
.const [120] = Class [235] 
.const [121] = NameAndType [236] [237] 
.const [122] = Class [238] 
.const [123] = NameAndType [239] [240] 
.const [124] = Class [241] 
.const [125] = NameAndType [242] [243] 
.const [126] = Class [244] 
.const [127] = NameAndType [245] [246] 
.const [128] = Class [247] 
.const [129] = NameAndType [248] [249] 
.const [130] = Class [250] 
.const [131] = NameAndType [251] [252] 
.const [132] = Class [253] 
.const [133] = NameAndType [254] [255] 
.const [134] = Class [256] 
.const [135] = NameAndType [257] [258] 
.const [136] = Class [259] 
.const [137] = NameAndType [260] [261] 
.const [138] = Class [262] 
.const [139] = NameAndType [263] [264] 
.const [140] = Class [265] 
.const [141] = NameAndType [266] [267] 
.const [142] = Class [268] 
.const [143] = NameAndType [269] [270] 
.const [144] = Class [271] 
.const [145] = NameAndType [272] [273] 
.const [146] = Class [274] 
.const [147] = NameAndType [275] [276] 
.const [148] = Class [277] 
.const [149] = NameAndType [278] [279] 
.const [150] = Class [280] 
.const [151] = NameAndType [281] [282] 
.const [152] = Class [283] 
.const [153] = NameAndType [284] [285] 
.const [154] = Class [286] 
.const [155] = NameAndType [287] [288] 
.const [156] = Class [289] 
.const [157] = NameAndType [290] [291] 
.const [158] = Class [292] 
.const [159] = NameAndType [293] [294] 
.const [160] = Class [295] 
.const [161] = NameAndType [296] [297] 
.const [162] = Class [298] 
.const [163] = NameAndType [299] [300] 
.const [164] = Class [301] 
.const [165] = NameAndType [302] [303] 
.const [166] = Class [304] 
.const [167] = NameAndType [305] [306] 
.const [168] = Class [307] 
.const [169] = NameAndType [308] [309] 
.const [170] = Class [310] 
.const [171] = NameAndType [311] [312] 
.const [172] = Class [313] 
.const [173] = NameAndType [314] [315] 
.const [174] = Class [316] 
.const [175] = NameAndType [317] [318] 
.const [176] = Class [319] 
.const [177] = NameAndType [320] [321] 
.const [178] = Class [322] 
.const [179] = NameAndType [323] [324] 
.const [180] = Class [325] 
.const [181] = NameAndType [326] [327] 
.const [182] = Class [328] 
.const [183] = NameAndType [329] [330] 
.const [184] = Utf8 java/lang/NoClassDefFoundError 
.const [185] = Class [331] 
.const [186] = NameAndType [332] [333] 
.const [187] = Class [334] 
.const [188] = NameAndType [335] [336] 
.const [189] = Class [337] 
.const [190] = NameAndType [338] [339] 
.const [191] = Utf8 de/audi/app/car/sdis/CarMainASIProvider 
.const [192] = Class [340] 
.const [193] = NameAndType [341] [342] 
.const [194] = Utf8 de/audi/app/car/sdis/SDISCarManager 
.const [195] = Class [343] 
.const [196] = NameAndType [344] [345] 
.const [197] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [198] = Class [346] 
.const [199] = NameAndType [347] [348] 
.const [200] = Utf8 de/audi/app/car/sdis/mainunit/InterAppSDISDistributor 
.const [201] = Class [349] 
.const [202] = NameAndType [350] [351] 
.const [203] = Class [352] 
.const [204] = NameAndType [353] [354] 
.const [205] = Class [355] 
.const [206] = NameAndType [356] [357] 
.const [207] = Utf8 de/audi/app/car/sdis/swdiag/SDISCarDiag 
.const [208] = Class [358] 
.const [209] = NameAndType [359] [360] 
.const [210] = Class [361] 
.const [211] = NameAndType [362] [363] 
.const [212] = Class [364] 
.const [213] = NameAndType [365] [366] 
.const [214] = Utf8 java/lang/Class 
.const [215] = Utf8 forName 
.const [216] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [217] = Utf8 de/audi/atip/log/NullLogChannel 
.const [218] = Utf8 getInstance 
.const [219] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [220] = Utf8 de/audi/app/car/sdis/CarSDISActivator 
.const [221] = Utf8 class$de$audi$app$car$common$sdis$interapp$ISDISCarInfoDistributor 
.const [222] = Utf8 Ljava/lang/Class; 
.const [223] = Utf8 de/audi/app/car/sdis/CarSDISActivator 
.const [224] = Utf8 class$ 
.const [225] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [226] = Utf8 de/audi/app/car/sdis/CarSDISActivator 
.const [227] = Utf8 class$de$audi$atip$diag$sw$SwDiagnosisManager 
.const [228] = Utf8 Ljava/lang/Class; 
.const [229] = Utf8 java/lang/NoClassDefFoundError 
.const [230] = Utf8 initCause 
.const [231] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [232] = Utf8 de/audi/app/car/sdis/CarSDISActivator 
.const [233] = Utf8 log 
.const [234] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [235] = Utf8 de/audi/app/car/sdis/CarSDISActivator 
.const [236] = Utf8 getFramework 
.const [237] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [238] = Utf8 de/audi/atip/log/LogChannel 
.const [239] = Utf8 log 
.const [240] = Utf8 (ILjava/lang/String;)Z 
.const [241] = Utf8 de/audi/app/car/sdis/CarSDISActivator 
.const [242] = Utf8 carMainProvider 
.const [243] = Utf8 Lde/audi/app/car/sdis/CarMainASIProvider; 
.const [244] = Utf8 de/audi/app/car/sdis/CarSDISActivator 
.const [245] = Utf8 carDataManager 
.const [246] = Utf8 Lde/audi/app/car/sdis/SDISCarManager; 
.const [247] = Utf8 de/audi/app/car/sdis/SDISCarManager 
.const [248] = Utf8 init 
.const [249] = Utf8 ()V 
.const [250] = Utf8 java/lang/Class 
.const [251] = Utf8 getName 
.const [252] = Utf8 ()Ljava/lang/String; 
.const [253] = Utf8 de/audi/app/car/sdis/CarSDISActivator 
.const [254] = Utf8 tracker 
.const [255] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [256] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [257] = Utf8 'open' 
.const [258] = Utf8 ()V 
.const [259] = Utf8 de/audi/app/car/sdis/CarSDISActivator 
.const [260] = Utf8 updater 
.const [261] = Utf8 Lde/audi/app/car/sdis/mainunit/InterAppSDISDistributor; 
.const [262] = Utf8 de/audi/app/car/sdis/CarSDISActivator 
.const [263] = Utf8 registerService 
.const [264] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)V 
.const [265] = Utf8 de/audi/app/car/sdis/CarMainASIProvider 
.const [266] = Utf8 registerServices 
.const [267] = Utf8 (Lde/audi/atip/activator/AbstractActivator;)V 
.const [268] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [269] = Utf8 close 
.const [270] = Utf8 ()V 
.const [271] = Utf8 de/audi/app/car/sdis/SDISCarManager 
.const [272] = Utf8 deinit 
.const [273] = Utf8 ()V 
.const [274] = Utf8 de/audi/app/car/sdis/CarSDISActivator 
.const [275] = Utf8 bundleContext 
.const [276] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [277] = Utf8 de/audi/atip/log/LogChannel 
.const [278] = Utf8 log 
.const [279] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [280] = Utf8 de/audi/app/car/sdis/mainunit/InterAppSDISDistributor 
.const [281] = Utf8 serviceAvailable 
.const [282] = Utf8 (Ljava/lang/Object;)V 
.const [283] = Utf8 de/audi/app/car/sdis/CarSDISActivator 
.const [284] = Utf8 sdisCarDiag 
.const [285] = Utf8 Lde/audi/app/car/sdis/swdiag/SDISCarDiag; 
.const [286] = Utf8 de/audi/app/car/sdis/CarSDISActivator 
.const [287] = Utf8 framework 
.const [288] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [289] = Utf8 de/audi/app/car/sdis/swdiag/SDISCarDiag 
.const [290] = Utf8 init 
.const [291] = Utf8 (Lde/audi/app/car/sdis/mainunit/InterAppSDISDistributor;)V 
.const [292] = Utf8 de/audi/app/car/sdis/swdiag/SDISCarDiag 
.const [293] = Utf8 setCarManager 
.const [294] = Utf8 (Lde/audi/app/car/sdis/SDISCarManager;)V 
.const [295] = Utf8 de/audi/app/car/sdis/mainunit/InterAppSDISDistributor 
.const [296] = Utf8 deinit 
.const [297] = Utf8 ()V 
.const [298] = Utf8 java/lang/NoClassDefFoundError 
.const [299] = Utf8 <init> 
.const [300] = Utf8 ()V 
.const [301] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [302] = Utf8 <init> 
.const [303] = Utf8 ()V 
.const [304] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [305] = Utf8 start 
.const [306] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [307] = Utf8 de/audi/app/car/sdis/CarMainASIProvider 
.const [308] = Utf8 <init> 
.const [309] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [310] = Utf8 de/audi/app/car/sdis/SDISCarManager 
.const [311] = Utf8 <init> 
.const [312] = Utf8 (Lde/audi/atip/log/LogChannel;Lorg/osgi/framework/BundleContext;Lde/audi/atip/base/IFrameworkAccess;Lde/audi/app/car/sdis/CarMainASIProvider;)V 
.const [313] = Utf8 de/audi/app/car/sdis/CarSDISActivator 
.const [314] = Utf8 class$de$audi$app$car$common$sdis$interapp$ISDISCarInfoDistributor 
.const [315] = Utf8 Ljava/lang/Class; 
.const [316] = Utf8 de/audi/app/car/sdis/CarSDISActivator 
.const [317] = Utf8 class$de$audi$atip$diag$sw$SwDiagnosisManager 
.const [318] = Utf8 Ljava/lang/Class; 
.const [319] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [320] = Utf8 <init> 
.const [321] = Utf8 (Lorg/osgi/framework/BundleContext;[Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [322] = Utf8 de/audi/app/car/sdis/mainunit/InterAppSDISDistributor 
.const [323] = Utf8 <init> 
.const [324] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/app/car/sdis/SDISCarManager;)V 
.const [325] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [326] = Utf8 stop 
.const [327] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [328] = Utf8 de/audi/app/car/sdis/swdiag/SDISCarDiag 
.const [329] = Utf8 <init> 
.const [330] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [331] = Utf8 de/audi/app/car/sdis/CarSDISActivator 
.const [332] = Utf8 log 
.const [333] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [334] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [335] = Utf8 getLogChannel 
.const [336] = Utf8 (Ljava/lang/String;)Lde/audi/atip/log/LogChannel; 
.const [337] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [338] = Utf8 isSDISEnabled 
.const [339] = Utf8 ()Z 
.const [340] = Utf8 de/audi/app/car/sdis/CarSDISActivator 
.const [341] = Utf8 carMainProvider 
.const [342] = Utf8 Lde/audi/app/car/sdis/CarMainASIProvider; 
.const [343] = Utf8 de/audi/app/car/sdis/CarSDISActivator 
.const [344] = Utf8 carDataManager 
.const [345] = Utf8 Lde/audi/app/car/sdis/SDISCarManager; 
.const [346] = Utf8 de/audi/app/car/sdis/CarSDISActivator 
.const [347] = Utf8 tracker 
.const [348] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [349] = Utf8 de/audi/app/car/sdis/CarSDISActivator 
.const [350] = Utf8 updater 
.const [351] = Utf8 Lde/audi/app/car/sdis/mainunit/InterAppSDISDistributor; 
.const [352] = Utf8 org/osgi/framework/BundleContext 
.const [353] = Utf8 getService 
.const [354] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [355] = Utf8 de/audi/app/car/sdis/CarSDISActivator 
.const [356] = Utf8 sdisCarDiag 
.const [357] = Utf8 Lde/audi/app/car/sdis/swdiag/SDISCarDiag; 
.const [358] = Utf8 de/audi/atip/diag/sw/SwDiagnosisManager 
.const [359] = Utf8 addDiagGateway 
.const [360] = Utf8 (Lde/audi/atip/diag/sw/AbstractSwDiagnosis;)V 
.const [361] = Utf8 org/osgi/framework/BundleContext 
.const [362] = Utf8 ungetService 
.const [363] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [364] = Utf8 de/audi/atip/diag/sw/SwDiagnosisManager 
.const [365] = Utf8 removeDiagGateway 
.const [366] = Utf8 (Lde/audi/atip/diag/sw/AbstractSwDiagnosis;)V 
.const [367] = Utf8 de/audi/app/car/sdis/CarSDISActivator 
.const [368] = Class [367] 
.const [369] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [370] = Class [369] 
.const [371] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [372] = Class [371] 
.const [373] = Utf8 log 
.const [374] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [375] = Utf8 sdisCarDiag 
.const [376] = Utf8 Lde/audi/app/car/sdis/swdiag/SDISCarDiag; 
.const [377] = Utf8 updater 
.const [378] = Utf8 Lde/audi/app/car/sdis/mainunit/InterAppSDISDistributor; 
.const [379] = Utf8 carDataManager 
.const [380] = Utf8 Lde/audi/app/car/sdis/SDISCarManager; 
.const [381] = Utf8 tracker 
.const [382] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [383] = Utf8 carMainProvider 
.const [384] = Utf8 Lde/audi/app/car/sdis/CarMainASIProvider; 
.const [385] = Utf8 class$de$audi$app$car$common$sdis$interapp$ISDISCarInfoDistributor 
.const [386] = Utf8 Ljava/lang/Class; 
.const [387] = Utf8 class$de$audi$atip$diag$sw$SwDiagnosisManager 
.const [388] = Utf8 Ljava/lang/Class; 
.const [389] = Utf8 Code 
.const [390] = Utf8 <init> 
.const [391] = Utf8 ()V 
.const [392] = Utf8 start 
.const [393] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [394] = Utf8 stop 
.const [395] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [396] = Utf8 addingService 
.const [397] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [398] = Utf8 modifiedService 
.const [399] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [400] = Utf8 removedService 
.const [401] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [402] = Utf8 class$ 
.const [403] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
