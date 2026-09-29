.version 50 0 
.class public super [330] 
.super [332] 
.implements [334] 
.field private static final [335] [336] 
.field private [337] [338] 
.field private [339] [340] 
.field private [341] [342] 
.field static synthetic [343] [344] 
.field static synthetic [345] [346] 
.field static synthetic [347] [348] 

.method public annotation [350] : [351] 
    .attribute [349] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [60] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [352] : [353] 
    .attribute [349] .code stack 6 locals 3 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [61] 
L5:     invokestatic [5] 
L8:     ifeq L524 
L11:    aload_0 
L12:    invokevirtual [46] 
L15:    ldc [6] 
L17:    invokeinterface [72] 0 
L22:    ldc [7] 
L24:    ldc [8] 
L26:    invokevirtual [47] 
L29:    pop 
        .catch [3] from L30 to L138 using L164 
        .catch [21] from L30 to L138 using L211 
        .catch [23] from L30 to L138 using L258 
        .catch [25] from L30 to L138 using L305 
        .catch [27] from L30 to L138 using L352 
        .catch [29] from L30 to L138 using L399 
        .catch [31] from L30 to L138 using L446 
        .catch [0] from L30 to L138 using L493 
L30:    ldc [9] 
L32:    invokestatic [2] 
L35:    astore_2 
L36:    aload_2 
L37:    iconst_2 
L38:    anewarray [10] 
L41:    dup 
L42:    iconst_0 
L43:    getstatic [11] 
L46:    ifnonnull L61 
L49:    ldc [12] 
L51:    invokestatic [13] 
L54:    dup 
L55:    putstatic [62] 
L58:    goto L64 
L61:    getstatic [11] 
L64:    aastore 
L65:    dup 
L66:    iconst_1 
L67:    getstatic [14] 
L70:    ifnonnull L85 
L73:    ldc [15] 
L75:    invokestatic [13] 
L78:    dup 
L79:    putstatic [63] 
L82:    goto L88 
L85:    getstatic [14] 
L88:    aastore 
L89:    invokevirtual [48] 
L92:    astore_3 
L93:    aload_0 
L94:    aload_3 
L95:    iconst_2 
L96:    anewarray [16] 
L99:    dup 
L100:   iconst_0 
L101:   aload_0 
L102:   invokevirtual [46] 
L105:   aastore 
L106:   dup 
L107:   iconst_1 
L108:   aload_1 
L109:   aastore 
L110:   invokevirtual [49] 
L113:   checkcast [17] 
L116:   putfield [73] 
L119:   aload_0 
L120:   invokevirtual [46] 
L123:   ldc [6] 
L125:   invokeinterface [72] 0 
L130:   ldc [7] 
L132:   ldc [18] 
L134:   invokevirtual [47] 
L137:   pop 
L138:   aload_0 
L139:   getfield [50] 
L142:   ifnonnull L521 
L145:   aload_0 
L146:   new [74] 
L149:   dup 
L150:   aload_0 
L151:   invokevirtual [46] 
L154:   aload_1 
L155:   invokespecial [64] 
L158:   putfield [73] 
L161:   goto L521 
        .catch [0] from L164 to L185 using L493 
L164:   astore_2 
L165:   aload_0 
L166:   invokevirtual [46] 
L169:   ldc [6] 
L171:   invokeinterface [72] 0 
L176:   ldc [7] 
L178:   ldc [20] 
L180:   aload_2 
L181:   invokevirtual [51] 
L184:   pop 
L185:   aload_0 
L186:   getfield [50] 
L189:   ifnonnull L521 
L192:   aload_0 
L193:   new [74] 
L196:   dup 
L197:   aload_0 
L198:   invokevirtual [46] 
L201:   aload_1 
L202:   invokespecial [64] 
L205:   putfield [73] 
L208:   goto L521 
        .catch [0] from L211 to L232 using L493 
L211:   astore_2 
L212:   aload_0 
L213:   invokevirtual [46] 
L216:   ldc [6] 
L218:   invokeinterface [72] 0 
L223:   ldc [7] 
L225:   ldc [22] 
L227:   aload_2 
L228:   invokevirtual [51] 
L231:   pop 
L232:   aload_0 
L233:   getfield [50] 
L236:   ifnonnull L521 
L239:   aload_0 
L240:   new [74] 
L243:   dup 
L244:   aload_0 
L245:   invokevirtual [46] 
L248:   aload_1 
L249:   invokespecial [64] 
L252:   putfield [73] 
L255:   goto L521 
        .catch [0] from L258 to L279 using L493 
L258:   astore_2 
L259:   aload_0 
L260:   invokevirtual [46] 
L263:   ldc [6] 
L265:   invokeinterface [72] 0 
L270:   ldc [7] 
L272:   ldc [24] 
L274:   aload_2 
L275:   invokevirtual [51] 
L278:   pop 
L279:   aload_0 
L280:   getfield [50] 
L283:   ifnonnull L521 
L286:   aload_0 
L287:   new [74] 
L290:   dup 
L291:   aload_0 
L292:   invokevirtual [46] 
L295:   aload_1 
L296:   invokespecial [64] 
L299:   putfield [73] 
L302:   goto L521 
        .catch [0] from L305 to L326 using L493 
L305:   astore_2 
L306:   aload_0 
L307:   invokevirtual [46] 
L310:   ldc [6] 
L312:   invokeinterface [72] 0 
L317:   ldc [7] 
L319:   ldc [26] 
L321:   aload_2 
L322:   invokevirtual [51] 
L325:   pop 
L326:   aload_0 
L327:   getfield [50] 
L330:   ifnonnull L521 
L333:   aload_0 
L334:   new [74] 
L337:   dup 
L338:   aload_0 
L339:   invokevirtual [46] 
L342:   aload_1 
L343:   invokespecial [64] 
L346:   putfield [73] 
L349:   goto L521 
        .catch [0] from L352 to L373 using L493 
L352:   astore_2 
L353:   aload_0 
L354:   invokevirtual [46] 
L357:   ldc [6] 
L359:   invokeinterface [72] 0 
L364:   ldc [7] 
L366:   ldc [28] 
L368:   aload_2 
L369:   invokevirtual [51] 
L372:   pop 
L373:   aload_0 
L374:   getfield [50] 
L377:   ifnonnull L521 
L380:   aload_0 
L381:   new [74] 
L384:   dup 
L385:   aload_0 
L386:   invokevirtual [46] 
L389:   aload_1 
L390:   invokespecial [64] 
L393:   putfield [73] 
L396:   goto L521 
        .catch [0] from L399 to L420 using L493 
L399:   astore_2 
L400:   aload_0 
L401:   invokevirtual [46] 
L404:   ldc [6] 
L406:   invokeinterface [72] 0 
L411:   ldc [7] 
L413:   ldc [30] 
L415:   aload_2 
L416:   invokevirtual [51] 
L419:   pop 
L420:   aload_0 
L421:   getfield [50] 
L424:   ifnonnull L521 
L427:   aload_0 
L428:   new [74] 
L431:   dup 
L432:   aload_0 
L433:   invokevirtual [46] 
L436:   aload_1 
L437:   invokespecial [64] 
L440:   putfield [73] 
L443:   goto L521 
        .catch [0] from L446 to L467 using L493 
L446:   astore_2 
L447:   aload_0 
L448:   invokevirtual [46] 
L451:   ldc [6] 
L453:   invokeinterface [72] 0 
L458:   ldc [7] 
L460:   ldc [32] 
L462:   aload_2 
L463:   invokevirtual [51] 
L466:   pop 
L467:   aload_0 
L468:   getfield [50] 
L471:   ifnonnull L521 
L474:   aload_0 
L475:   new [74] 
L478:   dup 
L479:   aload_0 
L480:   invokevirtual [46] 
L483:   aload_1 
L484:   invokespecial [64] 
L487:   putfield [73] 
L490:   goto L521 
        .catch [0] from L493 to L495 using L493 
L493:   astore 4 
L495:   aload_0 
L496:   getfield [50] 
L499:   ifnonnull L518 
L502:   aload_0 
L503:   new [74] 
L506:   dup 
L507:   aload_0 
L508:   invokevirtual [46] 
L511:   aload_1 
L512:   invokespecial [64] 
L515:   putfield [73] 
L518:   aload 4 
L520:   athrow 
L521:   goto L540 
L524:   aload_0 
L525:   new [74] 
L528:   dup 
L529:   aload_0 
L530:   invokevirtual [46] 
L533:   aload_1 
L534:   invokespecial [64] 
L537:   putfield [73] 
L540:   aload_0 
L541:   getfield [50] 
L544:   invokeinterface [75] 0 
L549:   aload_0 
L550:   invokespecial [65] 
L553:   return 
L554:   nop 
L555:   nop 
L556:   
    .end code 
.end method 

.method public [354] : [355] 
    .attribute [349] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [66] 
L5:     aload_0 
L6:     getfield [50] 
L9:     invokeinterface [76] 0 
L14:    aload_0 
L15:    invokespecial [67] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method private [356] : [357] 
    .attribute [349] .code stack 6 locals 0 
L0:     aload_0 
L1:     new [77] 
L4:     dup 
L5:     aload_0 
L6:     getfield [52] 
L9:     getstatic [34] 
L12:    ifnonnull L27 
L15:    ldc [35] 
L17:    invokestatic [13] 
L20:    dup 
L21:    putstatic [68] 
L24:    goto L30 
L27:    getstatic [34] 
L30:    invokevirtual [53] 
L33:    aload_0 
L34:    invokespecial [69] 
L37:    putfield [78] 
L40:    aload_0 
L41:    getfield [54] 
L44:    invokevirtual [55] 
L47:    return 
L48:    
    .end code 
.end method 

.method private [358] : [359] 
    .attribute [349] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     aload_0 
L3:     getfield [54] 
L6:     invokevirtual [56] 
L9:     putfield [78] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [360] : [361] 
    .attribute [349] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [52] 
L4:     aload_1 
L5:     invokeinterface [79] 0 
L10:    astore_2 
L11:    aload_2 
L12:    instanceof [36] 
L15:    ifeq L46 
L18:    aload_0 
L19:    new [80] 
L22:    dup 
L23:    aload_0 
L24:    getfield [50] 
L27:    invokespecial [70] 
L30:    putfield [81] 
L33:    aload_2 
L34:    checkcast [36] 
L37:    aload_0 
L38:    getfield [57] 
L41:    invokeinterface [82] 0 
L46:    aload_2 
L47:    areturn 
L48:    
    .end code 
.end method 

.method public enum [362] : [363] 
    .attribute [349] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [364] : [365] 
    .attribute [349] .code stack 2 locals 0 
L0:     aload_2 
L1:     instanceof [36] 
L4:     ifeq L23 
L7:     aload_0 
L8:     aconst_null 
L9:     putfield [81] 
L12:    aload_0 
L13:    invokevirtual [58] 
L16:    aload_1 
L17:    invokeinterface [83] 0 
L22:    pop 
L23:    return 
L24:    
    .end code 
.end method 

.method static synthetic [366] : [367] 
    .attribute [349] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [71] 
L9:     dup 
L10:    invokespecial [59] 
L13:    aload_1 
L14:    invokevirtual [45] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [84] [85] 
.const [3] = Class [86] 
.const [4] = Class [87] 
.const [5] = Method [88] [89] 
.const [6] = String [90] 
.const [7] = Int 1078071040 
.const [8] = String [91] 
.const [9] = String [92] 
.const [10] = Class [93] 
.const [11] = Field [94] [95] 
.const [12] = String [96] 
.const [13] = Method [97] [98] 
.const [14] = Field [99] [100] 
.const [15] = String [101] 
.const [16] = Class [102] 
.const [17] = Class [103] 
.const [18] = String [104] 
.const [19] = Class [105] 
.const [20] = String [106] 
.const [21] = Class [107] 
.const [22] = String [108] 
.const [23] = Class [109] 
.const [24] = String [110] 
.const [25] = Class [111] 
.const [26] = String [112] 
.const [27] = Class [113] 
.const [28] = String [114] 
.const [29] = Class [115] 
.const [30] = String [116] 
.const [31] = Class [117] 
.const [32] = String [118] 
.const [33] = Class [119] 
.const [34] = Field [120] [121] 
.const [35] = String [122] 
.const [36] = Class [123] 
.const [37] = Class [124] 
.const [38] = Class [125] 
.const [39] = Class [126] 
.const [40] = Class [127] 
.const [41] = Class [128] 
.const [42] = Class [129] 
.const [43] = Class [130] 
.const [44] = Class [131] 
.const [45] = Method [132] [133] 
.const [46] = Method [134] [135] 
.const [47] = Method [136] [137] 
.const [48] = Method [138] [139] 
.const [49] = Method [140] [141] 
.const [50] = Field [142] [143] 
.const [51] = Method [144] [145] 
.const [52] = Field [146] [147] 
.const [53] = Method [148] [149] 
.const [54] = Field [150] [151] 
.const [55] = Method [152] [153] 
.const [56] = Method [154] [155] 
.const [57] = Field [156] [157] 
.const [58] = Method [158] [159] 
.const [59] = Method [160] [161] 
.const [60] = Method [162] [163] 
.const [61] = Method [164] [165] 
.const [62] = Field [166] [167] 
.const [63] = Field [168] [169] 
.const [64] = Method [170] [171] 
.const [65] = Method [172] [173] 
.const [66] = Method [174] [175] 
.const [67] = Method [176] [177] 
.const [68] = Field [178] [179] 
.const [69] = Method [180] [181] 
.const [70] = Method [182] [183] 
.const [71] = Class [184] 
.const [72] = InterfaceMethod [185] [186] 
.const [73] = Field [187] [188] 
.const [74] = Class [189] 
.const [75] = InterfaceMethod [190] [191] 
.const [76] = InterfaceMethod [192] [193] 
.const [77] = Class [194] 
.const [78] = Field [195] [196] 
.const [79] = InterfaceMethod [197] [198] 
.const [80] = Class [199] 
.const [81] = Field [200] [201] 
.const [82] = InterfaceMethod [202] [203] 
.const [83] = InterfaceMethod [204] [205] 
.const [84] = Class [206] 
.const [85] = NameAndType [207] [208] 
.const [86] = Utf8 java/lang/ClassNotFoundException 
.const [87] = Utf8 java/lang/NoClassDefFoundError 
.const [88] = Class [209] 
.const [89] = NameAndType [210] [211] 
.const [90] = Utf8 'App.EarlyFunc.Activator' 
.const [91] = Utf8 '[CarActivator] FuncAdapSimulated-VM-Flag is set, activating Simulation.' 
.const [92] = Utf8 'de.mib.swdiagnosis.earlyfunc.evo.SimulatedEarlyFuncApplication' 
.const [93] = Utf8 java/lang/Class 
.const [94] = Class [212] 
.const [95] = NameAndType [213] [214] 
.const [96] = Utf8 'de.audi.atip.base.IFrameworkAccess' 
.const [97] = Class [215] 
.const [98] = NameAndType [216] [217] 
.const [99] = Class [218] 
.const [100] = NameAndType [219] [220] 
.const [101] = Utf8 'org.osgi.framework.BundleContext' 
.const [102] = Utf8 java/lang/Object 
.const [103] = Utf8 de/audi/app/car/common/app/ICarApplication 
.const [104] = Utf8 '[EarlyFuncActivator] Simulation of Car Features activated' 
.const [105] = Utf8 de/audi/app/earlyfunc/evo/app/EarlyFuncEvoApplication 
.const [106] = Utf8 '[EarlyFuncActivator] FuncAdapSimulated-VM-Flag is set, but cannot find Simulated Application. Using Standard.' 
.const [107] = Utf8 java/lang/SecurityException 
.const [108] = Utf8 '[EarlyFuncActivator] FuncAdapSimulated-VM-Flag is set, but cannot get Constructor because of security Concerns' 
.const [109] = Utf8 java/lang/NoSuchMethodException 
.const [110] = Utf8 '[EarlyFuncActivator] FuncAdapSimulated-VM-Flag is set, but cannot get Constructor because there is no constructor with matching signature' 
.const [111] = Utf8 java/lang/IllegalArgumentException 
.const [112] = Utf8 '[EarlyFuncActivator] FuncAdapSimulated-VM-Flag is set, but cannot cannot call constructor with this type of argument' 
.const [113] = Utf8 java/lang/InstantiationException 
.const [114] = Utf8 '[EarlyFuncActivator] FuncAdapSimulated-VM-Flag is set, but cannot instantiate Simulated Application. Using Standard.' 
.const [115] = Utf8 java/lang/IllegalAccessException 
.const [116] = Utf8 '[EarlyFuncActivator] FuncAdapSimulated-VM-Flag is set, but cannot access Simulated Application. Using Standard.' 
.const [117] = Utf8 java/lang/reflect/InvocationTargetException 
.const [118] = Utf8 '[EarlyFuncActivator] FuncAdapSimulated-VM-Flag is set, but Constructor does not like to be called.' 
.const [119] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [120] = Class [221] 
.const [121] = NameAndType [222] [223] 
.const [122] = Utf8 'de.audi.atip.diag.sw.SwDiagnosisManager' 
.const [123] = Utf8 de/audi/atip/diag/sw/SwDiagnosisManager 
.const [124] = Utf8 de/mib/swdiagnosis/earlyfunc/evo/EarlyFuncEvoDiagnosis 
.const [125] = Utf8 de/audi/app/earlyfunc/EarlyFuncActivator 
.const [126] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [127] = Utf8 de/audi/app/car/common/app/CarVMOptions 
.const [128] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [129] = Utf8 de/audi/atip/log/LogChannel 
.const [130] = Utf8 java/lang/reflect/Constructor 
.const [131] = Utf8 org/osgi/framework/BundleContext 
.const [132] = Class [224] 
.const [133] = NameAndType [225] [226] 
.const [134] = Class [227] 
.const [135] = NameAndType [228] [229] 
.const [136] = Class [230] 
.const [137] = NameAndType [231] [232] 
.const [138] = Class [233] 
.const [139] = NameAndType [234] [235] 
.const [140] = Class [236] 
.const [141] = NameAndType [237] [238] 
.const [142] = Class [239] 
.const [143] = NameAndType [240] [241] 
.const [144] = Class [242] 
.const [145] = NameAndType [243] [244] 
.const [146] = Class [245] 
.const [147] = NameAndType [246] [247] 
.const [148] = Class [248] 
.const [149] = NameAndType [249] [250] 
.const [150] = Class [251] 
.const [151] = NameAndType [252] [253] 
.const [152] = Class [254] 
.const [153] = NameAndType [255] [256] 
.const [154] = Class [257] 
.const [155] = NameAndType [258] [259] 
.const [156] = Class [260] 
.const [157] = NameAndType [261] [262] 
.const [158] = Class [263] 
.const [159] = NameAndType [264] [265] 
.const [160] = Class [266] 
.const [161] = NameAndType [267] [268] 
.const [162] = Class [269] 
.const [163] = NameAndType [270] [271] 
.const [164] = Class [272] 
.const [165] = NameAndType [273] [274] 
.const [166] = Class [275] 
.const [167] = NameAndType [276] [277] 
.const [168] = Class [278] 
.const [169] = NameAndType [279] [280] 
.const [170] = Class [281] 
.const [171] = NameAndType [282] [283] 
.const [172] = Class [284] 
.const [173] = NameAndType [285] [286] 
.const [174] = Class [287] 
.const [175] = NameAndType [288] [289] 
.const [176] = Class [290] 
.const [177] = NameAndType [291] [292] 
.const [178] = Class [293] 
.const [179] = NameAndType [294] [295] 
.const [180] = Class [296] 
.const [181] = NameAndType [297] [298] 
.const [182] = Class [299] 
.const [183] = NameAndType [300] [301] 
.const [184] = Utf8 java/lang/NoClassDefFoundError 
.const [185] = Class [302] 
.const [186] = NameAndType [303] [304] 
.const [187] = Class [305] 
.const [188] = NameAndType [306] [307] 
.const [189] = Utf8 de/audi/app/earlyfunc/evo/app/EarlyFuncEvoApplication 
.const [190] = Class [308] 
.const [191] = NameAndType [309] [310] 
.const [192] = Class [311] 
.const [193] = NameAndType [312] [313] 
.const [194] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [195] = Class [314] 
.const [196] = NameAndType [315] [316] 
.const [197] = Class [317] 
.const [198] = NameAndType [318] [319] 
.const [199] = Utf8 de/mib/swdiagnosis/earlyfunc/evo/EarlyFuncEvoDiagnosis 
.const [200] = Class [320] 
.const [201] = NameAndType [321] [322] 
.const [202] = Class [323] 
.const [203] = NameAndType [324] [325] 
.const [204] = Class [326] 
.const [205] = NameAndType [327] [328] 
.const [206] = Utf8 java/lang/Class 
.const [207] = Utf8 forName 
.const [208] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [209] = Utf8 de/audi/app/car/common/app/CarVMOptions 
.const [210] = Utf8 carFuncAdapSimulated 
.const [211] = Utf8 ()Z 
.const [212] = Utf8 de/audi/app/earlyfunc/EarlyFuncActivator 
.const [213] = Utf8 class$de$audi$atip$base$IFrameworkAccess 
.const [214] = Utf8 Ljava/lang/Class; 
.const [215] = Utf8 de/audi/app/earlyfunc/EarlyFuncActivator 
.const [216] = Utf8 class$ 
.const [217] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [218] = Utf8 de/audi/app/earlyfunc/EarlyFuncActivator 
.const [219] = Utf8 class$org$osgi$framework$BundleContext 
.const [220] = Utf8 Ljava/lang/Class; 
.const [221] = Utf8 de/audi/app/earlyfunc/EarlyFuncActivator 
.const [222] = Utf8 class$de$audi$atip$diag$sw$SwDiagnosisManager 
.const [223] = Utf8 Ljava/lang/Class; 
.const [224] = Utf8 java/lang/NoClassDefFoundError 
.const [225] = Utf8 initCause 
.const [226] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [227] = Utf8 de/audi/app/earlyfunc/EarlyFuncActivator 
.const [228] = Utf8 getFramework 
.const [229] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [230] = Utf8 de/audi/atip/log/LogChannel 
.const [231] = Utf8 log 
.const [232] = Utf8 (ILjava/lang/String;)Z 
.const [233] = Utf8 java/lang/Class 
.const [234] = Utf8 getConstructor 
.const [235] = Utf8 ([Ljava/lang/Class;)Ljava/lang/reflect/Constructor; 
.const [236] = Utf8 java/lang/reflect/Constructor 
.const [237] = Utf8 newInstance 
.const [238] = Utf8 ([Ljava/lang/Object;)Ljava/lang/Object; 
.const [239] = Utf8 de/audi/app/earlyfunc/EarlyFuncActivator 
.const [240] = Utf8 earlyFuncApplication 
.const [241] = Utf8 Lde/audi/app/car/common/app/ICarApplication; 
.const [242] = Utf8 de/audi/atip/log/LogChannel 
.const [243] = Utf8 log 
.const [244] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [245] = Utf8 de/audi/app/earlyfunc/EarlyFuncActivator 
.const [246] = Utf8 bundleContext 
.const [247] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [248] = Utf8 java/lang/Class 
.const [249] = Utf8 getName 
.const [250] = Utf8 ()Ljava/lang/String; 
.const [251] = Utf8 de/audi/app/earlyfunc/EarlyFuncActivator 
.const [252] = Utf8 serviceTracker 
.const [253] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [254] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [255] = Utf8 'open' 
.const [256] = Utf8 ()V 
.const [257] = Utf8 de/audi/app/earlyfunc/EarlyFuncActivator 
.const [258] = Utf8 closeTracker 
.const [259] = Utf8 (Lorg/osgi/util/tracker/ServiceTracker;)Lorg/osgi/util/tracker/ServiceTracker; 
.const [260] = Utf8 de/audi/app/earlyfunc/EarlyFuncActivator 
.const [261] = Utf8 diagGWEarlyFunc 
.const [262] = Utf8 Lde/mib/swdiagnosis/earlyfunc/evo/EarlyFuncEvoDiagnosis; 
.const [263] = Utf8 de/audi/app/earlyfunc/EarlyFuncActivator 
.const [264] = Utf8 getBundleContext 
.const [265] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [266] = Utf8 java/lang/NoClassDefFoundError 
.const [267] = Utf8 <init> 
.const [268] = Utf8 ()V 
.const [269] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [270] = Utf8 <init> 
.const [271] = Utf8 ()V 
.const [272] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [273] = Utf8 start 
.const [274] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [275] = Utf8 de/audi/app/earlyfunc/EarlyFuncActivator 
.const [276] = Utf8 class$de$audi$atip$base$IFrameworkAccess 
.const [277] = Utf8 Ljava/lang/Class; 
.const [278] = Utf8 de/audi/app/earlyfunc/EarlyFuncActivator 
.const [279] = Utf8 class$org$osgi$framework$BundleContext 
.const [280] = Utf8 Ljava/lang/Class; 
.const [281] = Utf8 de/audi/app/earlyfunc/evo/app/EarlyFuncEvoApplication 
.const [282] = Utf8 <init> 
.const [283] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;Lorg/osgi/framework/BundleContext;)V 
.const [284] = Utf8 de/audi/app/earlyfunc/EarlyFuncActivator 
.const [285] = Utf8 initTracker 
.const [286] = Utf8 ()V 
.const [287] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [288] = Utf8 stop 
.const [289] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [290] = Utf8 de/audi/app/earlyfunc/EarlyFuncActivator 
.const [291] = Utf8 deinitTracker 
.const [292] = Utf8 ()V 
.const [293] = Utf8 de/audi/app/earlyfunc/EarlyFuncActivator 
.const [294] = Utf8 class$de$audi$atip$diag$sw$SwDiagnosisManager 
.const [295] = Utf8 Ljava/lang/Class; 
.const [296] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [297] = Utf8 <init> 
.const [298] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [299] = Utf8 de/mib/swdiagnosis/earlyfunc/evo/EarlyFuncEvoDiagnosis 
.const [300] = Utf8 <init> 
.const [301] = Utf8 (Lde/audi/app/car/common/app/ICarApplication;)V 
.const [302] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [303] = Utf8 getLogChannel 
.const [304] = Utf8 (Ljava/lang/String;)Lde/audi/atip/log/LogChannel; 
.const [305] = Utf8 de/audi/app/earlyfunc/EarlyFuncActivator 
.const [306] = Utf8 earlyFuncApplication 
.const [307] = Utf8 Lde/audi/app/car/common/app/ICarApplication; 
.const [308] = Utf8 de/audi/app/car/common/app/ICarApplication 
.const [309] = Utf8 init 
.const [310] = Utf8 ()V 
.const [311] = Utf8 de/audi/app/car/common/app/ICarApplication 
.const [312] = Utf8 deinit 
.const [313] = Utf8 ()V 
.const [314] = Utf8 de/audi/app/earlyfunc/EarlyFuncActivator 
.const [315] = Utf8 serviceTracker 
.const [316] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [317] = Utf8 org/osgi/framework/BundleContext 
.const [318] = Utf8 getService 
.const [319] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [320] = Utf8 de/audi/app/earlyfunc/EarlyFuncActivator 
.const [321] = Utf8 diagGWEarlyFunc 
.const [322] = Utf8 Lde/mib/swdiagnosis/earlyfunc/evo/EarlyFuncEvoDiagnosis; 
.const [323] = Utf8 de/audi/atip/diag/sw/SwDiagnosisManager 
.const [324] = Utf8 addDiagGateway 
.const [325] = Utf8 (Lde/audi/atip/diag/sw/AbstractSwDiagnosis;)V 
.const [326] = Utf8 org/osgi/framework/BundleContext 
.const [327] = Utf8 ungetService 
.const [328] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [329] = Utf8 de/audi/app/earlyfunc/EarlyFuncActivator 
.const [330] = Class [329] 
.const [331] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [332] = Class [331] 
.const [333] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [334] = Class [333] 
.const [335] = Utf8 LOG_CHANNEL_NAME 
.const [336] = Utf8 Ljava/lang/String; 
.const [337] = Utf8 earlyFuncApplication 
.const [338] = Utf8 Lde/audi/app/car/common/app/ICarApplication; 
.const [339] = Utf8 serviceTracker 
.const [340] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [341] = Utf8 diagGWEarlyFunc 
.const [342] = Utf8 Lde/mib/swdiagnosis/earlyfunc/evo/EarlyFuncEvoDiagnosis; 
.const [343] = Utf8 class$de$audi$atip$base$IFrameworkAccess 
.const [344] = Utf8 Ljava/lang/Class; 
.const [345] = Utf8 class$org$osgi$framework$BundleContext 
.const [346] = Utf8 Ljava/lang/Class; 
.const [347] = Utf8 class$de$audi$atip$diag$sw$SwDiagnosisManager 
.const [348] = Utf8 Ljava/lang/Class; 
.const [349] = Utf8 Code 
.const [350] = Utf8 <init> 
.const [351] = Utf8 ()V 
.const [352] = Utf8 start 
.const [353] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [354] = Utf8 stop 
.const [355] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [356] = Utf8 initTracker 
.const [357] = Utf8 ()V 
.const [358] = Utf8 deinitTracker 
.const [359] = Utf8 ()V 
.const [360] = Utf8 addingService 
.const [361] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [362] = Utf8 modifiedService 
.const [363] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [364] = Utf8 removedService 
.const [365] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [366] = Utf8 class$ 
.const [367] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
