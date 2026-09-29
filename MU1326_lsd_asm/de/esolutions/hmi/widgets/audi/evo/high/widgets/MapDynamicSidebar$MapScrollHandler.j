.version 50 0 
.class public final super [351] 
.super [353] 
.implements [355] 
.field private static final [356] [357] 
.field private static final [358] [359] 
.field private static final [360] [361] 
.field private static final [362] [363] 
.field private static final [364] [365] 
.field private static final [366] [367] 
.field private static final [368] [369] 
.field private static final [370] [371] 
.field private static final [372] [373] 
.field private static final [374] [375] 
.field private static final [376] [377] 
.field private static final [378] [379] 
.field private static final [380] [381] 
.field private static final [382] [383] 
.field private static final [384] [385] 
.field private static final [386] [387] 
.field private static final [388] [389] 
.field private static final [390] [391] 
.field private static final [392] [393] 
.field private static final [394] [395] 
.field private static final [396] [397] 
.field private static final [398] [399] 
.field private [400] [401] 
.field private [402] [403] 
.field private [404] [405] 
.field private [406] [407] 
.field private [408] [409] 
.field private [410] [411] 
.field private [412] [413] 

.method protected [415] : [416] 
    .attribute [414] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [65] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [68] 
L9:     aload_0 
L10:    aconst_null 
L11:    putfield [69] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [417] : [418] 
    .attribute [414] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [34] 
L4:     ifnull L24 
L7:     aload_0 
L8:     getfield [34] 
L11:    invokevirtual [36] 
L14:    ifne L24 
L17:    aload_0 
L18:    getfield [34] 
L21:    invokevirtual [37] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [419] : [420] 
    .attribute [414] .code stack 2 locals 0 
L0:     aload_0 
L1:     fconst_1 
L2:     putfield [70] 
L5:     aload_0 
L6:     invokevirtual [39] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [421] : [422] 
    .attribute [414] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_m1 
L2:     invokevirtual [40] 
L5:     aload_0 
L6:     invokevirtual [41] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [423] : [424] 
    .attribute [414] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [42] 
L5:     f2i 
L6:     invokevirtual [40] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [425] : [426] 
    .attribute [414] .code stack 9 locals 0 
L0:     getstatic [2] 
L3:     ldc [3] 
L5:     ldc [4] 
L7:     aload_0 
L8:     getfield [42] 
L11:    f2d 
L12:    iload_1 
L13:    i2d 
L14:    dconst_0 
L15:    invokevirtual [43] 
L18:    aload_0 
L19:    getfield [44] 
L22:    ifnonnull L38 
L25:    getstatic [2] 
L28:    sipush 10000 
L31:    ldc [5] 
L33:    invokevirtual [45] 
L36:    pop 
L37:    return 
L38:    iload_1 
L39:    lookupswitch 
            -180 : L176 
            -135 : L190 
            -90 : L204 
            -45 : L218 
            0 : L120 
            45 : L134 
            90 : L148 
            135 : L162 
            180 : L176 
            default : L232 

L120:   aload_0 
L121:   getfield [44] 
L124:   aload_0 
L125:   getfield [46] 
L128:   invokevirtual [47] 
L131:   goto L243 
L134:   aload_0 
L135:   getfield [44] 
L138:   aload_0 
L139:   getfield [46] 
L142:   invokevirtual [48] 
L145:   goto L243 
L148:   aload_0 
L149:   getfield [44] 
L152:   aload_0 
L153:   getfield [46] 
L156:   invokevirtual [49] 
L159:   goto L243 
L162:   aload_0 
L163:   getfield [44] 
L166:   aload_0 
L167:   getfield [46] 
L170:   invokevirtual [50] 
L173:   goto L243 
L176:   aload_0 
L177:   getfield [44] 
L180:   aload_0 
L181:   getfield [46] 
L184:   invokevirtual [51] 
L187:   goto L243 
L190:   aload_0 
L191:   getfield [44] 
L194:   aload_0 
L195:   getfield [46] 
L198:   invokevirtual [52] 
L201:   goto L243 
L204:   aload_0 
L205:   getfield [44] 
L208:   aload_0 
L209:   getfield [46] 
L212:   invokevirtual [53] 
L215:   goto L243 
L218:   aload_0 
L219:   getfield [44] 
L222:   aload_0 
L223:   getfield [46] 
L226:   invokevirtual [54] 
L229:   goto L243 
L232:   aload_0 
L233:   getfield [44] 
L236:   aload_0 
L237:   getfield [46] 
L240:   invokevirtual [55] 
L243:   return 
L244:   
    .end code 
.end method 

.method private [427] : [428] 
    .attribute [414] .code stack 9 locals 8 
L0:     aload_0 
L1:     dup 
L2:     getfield [38] 
L5:     fconst_1 
L6:     fadd 
L7:     putfield [70] 
L10:    aload_0 
L11:    getfield [42] 
L14:    f2d 
L15:    invokestatic [6] 
L18:    dstore_2 
L19:    dload_2 
L20:    invokestatic [7] 
L23:    dstore 4 
L25:    dload_2 
L26:    invokestatic [8] 
L29:    dstore 6 
L31:    aload_0 
L32:    getfield [38] 
L35:    fneg 
L36:    dload 4 
L38:    d2f 
L39:    fmul 
L40:    fstore 8 
L42:    aload_0 
L43:    getfield [38] 
L46:    dload 6 
L48:    d2f 
L49:    fmul 
L50:    fstore 9 
L52:    fload 8 
L54:    invokestatic [9] 
L57:    fstore 8 
L59:    fload 9 
L61:    invokestatic [9] 
L64:    fstore 9 
L66:    aload_0 
L67:    getfield [44] 
L70:    ifnull L95 
L73:    aload_0 
L74:    getfield [44] 
L77:    iconst_2 
L78:    iconst_0 
L79:    fload 8 
L81:    f2i 
L82:    fload 9 
L84:    f2i 
L85:    aload_0 
L86:    getfield [46] 
L89:    invokevirtual [56] 
L92:    goto L106 
L95:    getstatic [2] 
L98:    ldc [3] 
L100:   ldc [10] 
L102:   invokevirtual [45] 
L105:   pop 
L106:   getstatic [2] 
L109:   ldc [3] 
L111:   ldc [11] 
L113:   aload_0 
L114:   getfield [42] 
L117:   f2d 
L118:   fload 8 
L120:   f2d 
L121:   fload 9 
L123:   f2d 
L124:   invokevirtual [43] 
L127:   aload_0 
L128:   invokevirtual [39] 
L131:   return 
L132:   
    .end code 
.end method 

.method public static [429] : [430] 
    .attribute [414] .code stack 4 locals 1 
L0:     fload_0 
L1:     invokestatic [12] 
L4:     i2f 
L5:     fstore_1 
L6:     fload_0 
L7:     fload_1 
L8:     fsub 
L9:     invokestatic [13] 
L12:    f2d 
L13:    ldc2_w [77] 
L16:    dcmpg 
L17:    ifge L22 
L20:    fload_1 
L21:    fstore_0 
L22:    fload_0 
L23:    areturn 
L24:    
    .end code 
.end method 

.method private [431] : [432] 
    .attribute [414] .code stack 4 locals 2 
L0:     ldc [14] 
L2:     fstore_2 
L3:     iconst_1 
L4:     istore_3 
L5:     aload_1 
L6:     invokevirtual [57] 
L9:     iconst_1 
L10:    if_icmpne L15 
L13:    iconst_m1 
L14:    istore_3 
L15:    aload_0 
L16:    dup 
L17:    getfield [42] 
L20:    iload_3 
L21:    aload_1 
L22:    invokevirtual [58] 
L25:    imul 
L26:    i2f 
L27:    fload_2 
L28:    fmul 
L29:    fadd 
L30:    putfield [71] 
L33:    aload_0 
L34:    getfield [42] 
L37:    invokestatic [13] 
L40:    ldc [15] 
L42:    fcmpl 
L43:    ifle L60 
L46:    aload_0 
L47:    dup 
L48:    getfield [42] 
L51:    iload_3 
L52:    i2f 
L53:    ldc [16] 
L55:    fmul 
L56:    fsub 
L57:    putfield [71] 
L60:    aload_0 
L61:    getfield [59] 
L64:    invokevirtual [60] 
L67:    ifnull L84 
L70:    aload_0 
L71:    getfield [59] 
L74:    invokevirtual [60] 
L77:    aload_0 
L78:    getfield [42] 
L81:    invokevirtual [61] 
L84:    return 
L85:    nop 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 

.method public [433] : [434] 
    .attribute [414] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [66] 
L5:     aload_0 
L6:     getfield [59] 
L9:     getfield [62] 
L12:    iconst_3 
L13:    if_icmpne L21 
L16:    aload_0 
L17:    aload_1 
L18:    invokevirtual [63] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [435] : [436] 
    .attribute [414] .code stack 6 locals 2 
L0:     aload_1 
L1:     invokevirtual [57] 
L4:     ifne L11 
L7:     iconst_m1 
L8:     goto L12 
L11:    iconst_1 
L12:    istore_2 
L13:    iload_2 
L14:    i2f 
L15:    ldc [17] 
L17:    fmul 
L18:    aload_1 
L19:    invokevirtual [58] 
L22:    i2f 
L23:    fmul 
L24:    fstore_3 
L25:    aload_0 
L26:    getfield [44] 
L29:    ifnull L48 
L32:    aload_0 
L33:    getfield [44] 
L36:    iconst_1 
L37:    iconst_0 
L38:    fload_3 
L39:    f2i 
L40:    iconst_0 
L41:    aload_0 
L42:    getfield [46] 
L45:    invokevirtual [56] 
L48:    getstatic [2] 
L51:    ldc [3] 
L53:    ldc [18] 
L55:    fload_3 
L56:    f2d 
L57:    invokevirtual [64] 
L60:    return 
L61:    nop 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method protected [437] : [438] 
    .attribute [414] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [35] 
L4:     ifnonnull L19 
L7:     aload_0 
L8:     new [74] 
L11:    dup 
L12:    aload_0 
L13:    invokespecial [67] 
L16:    putfield [69] 
L19:    aload_0 
L20:    invokevirtual [41] 
L23:    aload_0 
L24:    getstatic [20] 
L27:    invokeinterface [75] 0 
L32:    aload_0 
L33:    getfield [35] 
L36:    ldc_w [1] 
L39:    invokeinterface [76] 0 
L44:    putfield [68] 
L47:    return 
L48:    
    .end code 
.end method 

.method public [439] : [440] 
    .attribute [414] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [72] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [441] : [442] 
    .attribute [414] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [73] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [80] [81] 
.const [3] = Int -2137614336 
.const [4] = String [82] 
.const [5] = String [83] 
.const [6] = Method [84] [85] 
.const [7] = Method [86] [87] 
.const [8] = Method [88] [89] 
.const [9] = Method [90] [91] 
.const [10] = String [92] 
.const [11] = String [93] 
.const [12] = Method [94] [95] 
.const [13] = Method [96] [97] 
.const [14] = Int 13378 
.const [15] = Int 13379 
.const [16] = Int 46147 
.const [17] = Int -608809663 
.const [18] = String [98] 
.const [19] = Class [99] 
.const [20] = Field [100] [101] 
.const [21] = Class [102] 
.const [22] = Class [103] 
.const [23] = Class [104] 
.const [24] = Class [105] 
.const [25] = Class [106] 
.const [26] = Class [107] 
.const [27] = Class [108] 
.const [28] = Class [109] 
.const [29] = Class [110] 
.const [30] = Class [111] 
.const [31] = Class [112] 
.const [32] = Class [113] 
.const [33] = Class [114] 
.const [34] = Field [115] [116] 
.const [35] = Field [117] [118] 
.const [36] = Method [119] [120] 
.const [37] = Method [121] [122] 
.const [38] = Field [123] [124] 
.const [39] = Method [125] [126] 
.const [40] = Method [127] [128] 
.const [41] = Method [129] [130] 
.const [42] = Field [131] [132] 
.const [43] = Method [133] [134] 
.const [44] = Field [135] [136] 
.const [45] = Method [137] [138] 
.const [46] = Field [139] [140] 
.const [47] = Method [141] [142] 
.const [48] = Method [143] [144] 
.const [49] = Method [145] [146] 
.const [50] = Method [147] [148] 
.const [51] = Method [149] [150] 
.const [52] = Method [151] [152] 
.const [53] = Method [153] [154] 
.const [54] = Method [155] [156] 
.const [55] = Method [157] [158] 
.const [56] = Method [159] [160] 
.const [57] = Method [161] [162] 
.const [58] = Method [163] [164] 
.const [59] = Field [165] [166] 
.const [60] = Method [167] [168] 
.const [61] = Method [169] [170] 
.const [62] = Field [171] [172] 
.const [63] = Method [173] [174] 
.const [64] = Method [175] [176] 
.const [65] = Method [177] [178] 
.const [66] = Method [179] [180] 
.const [67] = Method [181] [182] 
.const [68] = Field [183] [184] 
.const [69] = Field [185] [186] 
.const [70] = Field [187] [188] 
.const [71] = Field [189] [190] 
.const [72] = Field [191] [192] 
.const [73] = Field [193] [194] 
.const [74] = Class [195] 
.const [75] = InterfaceMethod [196] [197] 
.const [76] = InterfaceMethod [198] [199] 
.const [77] = Double +0x1AD7F29ABCAF48p-76 
.const [79] = Int 838860800 
.const [80] = Class [200] 
.const [81] = NameAndType [201] [202] 
.const [82] = Utf8 'MapDynamicSidebar#processMovementViaNav alpha = %1, appAngle = %2' 
.const [83] = Utf8 'MapDynamicSidebar#processMovementViaNav Model is not set.' 
.const [84] = Class [203] 
.const [85] = NameAndType [204] [205] 
.const [86] = Class [206] 
.const [87] = NameAndType [207] [208] 
.const [88] = Class [209] 
.const [89] = NameAndType [210] [211] 
.const [90] = Class [212] 
.const [91] = NameAndType [213] [214] 
.const [92] = Utf8 'MapDynamicSidebar#processMovementViaWidget Model has not been set.' 
.const [93] = Utf8 'MapDynamicSidebar#processMovementViaWidget alpha = %1, dx = %2, dy = %3' 
.const [94] = Class [215] 
.const [95] = NameAndType [216] [217] 
.const [96] = Class [218] 
.const [97] = NameAndType [219] [220] 
.const [98] = Utf8 'MapScrollHandler#keyTurnedInStreetView dx = %1' 
.const [99] = Utf8 de/audi/atip/hmi/event/TimerEvent 
.const [100] = Class [221] 
.const [101] = NameAndType [222] [223] 
.const [102] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapScrollHandler 
.const [103] = Utf8 java/lang/Object 
.const [104] = Utf8 de/esolutions/fw/util/commons/job/Job 
.const [105] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [106] = Utf8 de/audi/atip/log/LogChannel 
.const [107] = Utf8 de/audi/atip/hmi/model/VirtualButtonModel 
.const [108] = Utf8 java/lang/Math 
.const [109] = Utf8 de/audi/atip/hmi/event/WheelButtonEvent 
.const [110] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar 
.const [111] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapCrosshairController 
.const [112] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [113] = Utf8 de/audi/tghu/hmi/evo/IHMIServiceEvo 
.const [114] = Utf8 de/audi/atip/hmi/event/EventDispatcher 
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
.const [169] = Class [305] 
.const [170] = NameAndType [306] [307] 
.const [171] = Class [308] 
.const [172] = NameAndType [309] [310] 
.const [173] = Class [311] 
.const [174] = NameAndType [312] [313] 
.const [175] = Class [314] 
.const [176] = NameAndType [315] [316] 
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
.const [195] = Utf8 de/audi/atip/hmi/event/TimerEvent 
.const [196] = Class [344] 
.const [197] = NameAndType [345] [346] 
.const [198] = Class [347] 
.const [199] = NameAndType [348] [349] 
.const [200] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [201] = Utf8 sideBarLogChannel 
.const [202] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [203] = Utf8 java/lang/Math 
.const [204] = Utf8 toRadians 
.const [205] = Utf8 (D)D 
.const [206] = Utf8 java/lang/Math 
.const [207] = Utf8 sin 
.const [208] = Utf8 (D)D 
.const [209] = Utf8 java/lang/Math 
.const [210] = Utf8 cos 
.const [211] = Utf8 (D)D 
.const [212] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapScrollHandler 
.const [213] = Utf8 increaseFloatingPointPrecision 
.const [214] = Utf8 (F)F 
.const [215] = Utf8 java/lang/Math 
.const [216] = Utf8 round 
.const [217] = Utf8 (F)I 
.const [218] = Utf8 java/lang/Math 
.const [219] = Utf8 abs 
.const [220] = Utf8 (F)F 
.const [221] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [222] = Utf8 hmiService 
.const [223] = Utf8 Lde/audi/tghu/hmi/evo/IHMIServiceEvo; 
.const [224] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapScrollHandler 
.const [225] = Utf8 timer 
.const [226] = Utf8 Lde/esolutions/fw/util/commons/job/Job; 
.const [227] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapScrollHandler 
.const [228] = Utf8 timerEvent 
.const [229] = Utf8 Lde/audi/atip/hmi/event/TimerEvent; 
.const [230] = Utf8 de/esolutions/fw/util/commons/job/Job 
.const [231] = Utf8 isCanceled 
.const [232] = Utf8 ()Z 
.const [233] = Utf8 de/esolutions/fw/util/commons/job/Job 
.const [234] = Utf8 cancel 
.const [235] = Utf8 ()V 
.const [236] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapScrollHandler 
.const [237] = Utf8 velocity 
.const [238] = Utf8 F 
.const [239] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapScrollHandler 
.const [240] = Utf8 restartTimer 
.const [241] = Utf8 ()V 
.const [242] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapScrollHandler 
.const [243] = Utf8 processMovementViaNav 
.const [244] = Utf8 (I)V 
.const [245] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapScrollHandler 
.const [246] = Utf8 cancelTimer 
.const [247] = Utf8 ()V 
.const [248] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapScrollHandler 
.const [249] = Utf8 alpha 
.const [250] = Utf8 F 
.const [251] = Utf8 de/audi/atip/log/LogChannel 
.const [252] = Utf8 log 
.const [253] = Utf8 (ILjava/lang/String;DDD)V 
.const [254] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapScrollHandler 
.const [255] = Utf8 modelRef 
.const [256] = Utf8 Lde/audi/atip/hmi/model/VirtualButtonModel; 
.const [257] = Utf8 de/audi/atip/log/LogChannel 
.const [258] = Utf8 log 
.const [259] = Utf8 (ILjava/lang/String;)Z 
.const [260] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapScrollHandler 
.const [261] = Utf8 terminalID 
.const [262] = Utf8 I 
.const [263] = Utf8 de/audi/atip/hmi/model/VirtualButtonModel 
.const [264] = Utf8 joyN 
.const [265] = Utf8 (I)V 
.const [266] = Utf8 de/audi/atip/hmi/model/VirtualButtonModel 
.const [267] = Utf8 joyNE 
.const [268] = Utf8 (I)V 
.const [269] = Utf8 de/audi/atip/hmi/model/VirtualButtonModel 
.const [270] = Utf8 joyE 
.const [271] = Utf8 (I)V 
.const [272] = Utf8 de/audi/atip/hmi/model/VirtualButtonModel 
.const [273] = Utf8 joySE 
.const [274] = Utf8 (I)V 
.const [275] = Utf8 de/audi/atip/hmi/model/VirtualButtonModel 
.const [276] = Utf8 joyS 
.const [277] = Utf8 (I)V 
.const [278] = Utf8 de/audi/atip/hmi/model/VirtualButtonModel 
.const [279] = Utf8 joySW 
.const [280] = Utf8 (I)V 
.const [281] = Utf8 de/audi/atip/hmi/model/VirtualButtonModel 
.const [282] = Utf8 joyW 
.const [283] = Utf8 (I)V 
.const [284] = Utf8 de/audi/atip/hmi/model/VirtualButtonModel 
.const [285] = Utf8 joyNW 
.const [286] = Utf8 (I)V 
.const [287] = Utf8 de/audi/atip/hmi/model/VirtualButtonModel 
.const [288] = Utf8 joyIdle 
.const [289] = Utf8 (I)V 
.const [290] = Utf8 de/audi/atip/hmi/model/VirtualButtonModel 
.const [291] = Utf8 touchPadPositionMoved 
.const [292] = Utf8 (IIIII)V 
.const [293] = Utf8 de/audi/atip/hmi/event/WheelButtonEvent 
.const [294] = Utf8 getDirection 
.const [295] = Utf8 ()I 
.const [296] = Utf8 de/audi/atip/hmi/event/WheelButtonEvent 
.const [297] = Utf8 getClickCount 
.const [298] = Utf8 ()I 
.const [299] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapScrollHandler 
.const [300] = Utf8 parentRef 
.const [301] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar; 
.const [302] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar 
.const [303] = Utf8 getMapCrosshair 
.const [304] = Utf8 ()Lde/esolutions/hmi/widgets/audi/evo/high/widgets/MapCrosshairController; 
.const [305] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapCrosshairController 
.const [306] = Utf8 setCurrentAngle 
.const [307] = Utf8 (F)V 
.const [308] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar 
.const [309] = Utf8 state 
.const [310] = Utf8 I 
.const [311] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapScrollHandler 
.const [312] = Utf8 processEvent 
.const [313] = Utf8 (Lde/audi/atip/hmi/event/ATIPEvent;)V 
.const [314] = Utf8 de/audi/atip/log/LogChannel 
.const [315] = Utf8 log 
.const [316] = Utf8 (ILjava/lang/String;D)V 
.const [317] = Utf8 java/lang/Object 
.const [318] = Utf8 <init> 
.const [319] = Utf8 ()V 
.const [320] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapScrollHandler 
.const [321] = Utf8 updateRotationAngle 
.const [322] = Utf8 (Lde/audi/atip/hmi/event/WheelButtonEvent;)V 
.const [323] = Utf8 de/audi/atip/hmi/event/TimerEvent 
.const [324] = Utf8 <init> 
.const [325] = Utf8 (Lde/audi/atip/hmi/event/ATIPEventListener;)V 
.const [326] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapScrollHandler 
.const [327] = Utf8 timer 
.const [328] = Utf8 Lde/esolutions/fw/util/commons/job/Job; 
.const [329] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapScrollHandler 
.const [330] = Utf8 timerEvent 
.const [331] = Utf8 Lde/audi/atip/hmi/event/TimerEvent; 
.const [332] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapScrollHandler 
.const [333] = Utf8 velocity 
.const [334] = Utf8 F 
.const [335] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapScrollHandler 
.const [336] = Utf8 alpha 
.const [337] = Utf8 F 
.const [338] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapScrollHandler 
.const [339] = Utf8 modelRef 
.const [340] = Utf8 Lde/audi/atip/hmi/model/VirtualButtonModel; 
.const [341] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapScrollHandler 
.const [342] = Utf8 parentRef 
.const [343] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar; 
.const [344] = Utf8 de/audi/tghu/hmi/evo/IHMIServiceEvo 
.const [345] = Utf8 getEventDispatcher 
.const [346] = Utf8 ()Lde/audi/atip/hmi/event/EventDispatcher; 
.const [347] = Utf8 de/audi/atip/hmi/event/EventDispatcher 
.const [348] = Utf8 postEvent 
.const [349] = Utf8 (Lde/audi/atip/hmi/event/ATIPEvent;J)Lde/esolutions/fw/util/commons/job/Job; 
.const [350] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar$MapScrollHandler 
.const [351] = Class [350] 
.const [352] = Utf8 java/lang/Object 
.const [353] = Class [352] 
.const [354] = Utf8 de/audi/atip/hmi/event/ATIPEventListener 
.const [355] = Class [354] 
.const [356] = Utf8 EVENT_CYCLE 
.const [357] = Utf8 I 
.const [358] = Utf8 V_START 
.const [359] = Utf8 I 
.const [360] = Utf8 V_SCALE 
.const [361] = Utf8 F 
.const [362] = Utf8 DEGREE_PER_TICK_NAVI 
.const [363] = Utf8 I 
.const [364] = Utf8 DEGREE_PER_TICK_WIDGET 
.const [365] = Utf8 F 
.const [366] = Utf8 DEGREE_DIRECTION_N 
.const [367] = Utf8 F 
.const [368] = Utf8 DEGREE_DIRECTION_NNE 
.const [369] = Utf8 F 
.const [370] = Utf8 DEGREE_DIRECTION_NE 
.const [371] = Utf8 F 
.const [372] = Utf8 DEGREE_DIRECTION_ENE 
.const [373] = Utf8 F 
.const [374] = Utf8 DEGREE_DIRECTION_E 
.const [375] = Utf8 F 
.const [376] = Utf8 DEGREE_DIRECTION_ESE 
.const [377] = Utf8 F 
.const [378] = Utf8 DEGREE_DIRECTION_SE 
.const [379] = Utf8 F 
.const [380] = Utf8 DEGREE_DIRECTION_SSE 
.const [381] = Utf8 F 
.const [382] = Utf8 DEGREE_DIRECTION_S 
.const [383] = Utf8 F 
.const [384] = Utf8 DEGREE_DIRECTION_SSW 
.const [385] = Utf8 F 
.const [386] = Utf8 DEGREE_DIRECTION_SW 
.const [387] = Utf8 F 
.const [388] = Utf8 DEGREE_DIRECTION_WSW 
.const [389] = Utf8 F 
.const [390] = Utf8 DEGREE_DIRECTION_W 
.const [391] = Utf8 F 
.const [392] = Utf8 DEGREE_DIRECTION_WNW 
.const [393] = Utf8 F 
.const [394] = Utf8 DEGREE_DIRECTION_NW 
.const [395] = Utf8 F 
.const [396] = Utf8 DEGREE_DIRECTION_NNW 
.const [397] = Utf8 F 
.const [398] = Utf8 DEGREE_PER_TICK_STREET_VIEW 
.const [399] = Utf8 F 
.const [400] = Utf8 alpha 
.const [401] = Utf8 F 
.const [402] = Utf8 velocity 
.const [403] = Utf8 F 
.const [404] = Utf8 timer 
.const [405] = Utf8 Lde/esolutions/fw/util/commons/job/Job; 
.const [406] = Utf8 timerEvent 
.const [407] = Utf8 Lde/audi/atip/hmi/event/TimerEvent; 
.const [408] = Utf8 modelRef 
.const [409] = Utf8 Lde/audi/atip/hmi/model/VirtualButtonModel; 
.const [410] = Utf8 terminalID 
.const [411] = Utf8 I 
.const [412] = Utf8 parentRef 
.const [413] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar; 
.const [414] = Utf8 Code 
.const [415] = Utf8 <init> 
.const [416] = Utf8 ()V 
.const [417] = Utf8 cancelTimer 
.const [418] = Utf8 ()V 
.const [419] = Utf8 ddsPressed 
.const [420] = Utf8 ()V 
.const [421] = Utf8 ddsReleased 
.const [422] = Utf8 ()V 
.const [423] = Utf8 processEvent 
.const [424] = Utf8 (Lde/audi/atip/hmi/event/ATIPEvent;)V 
.const [425] = Utf8 processMovementViaNav 
.const [426] = Utf8 (I)V 
.const [427] = Utf8 processMovementViaWidget 
.const [428] = Utf8 (Lde/audi/atip/hmi/event/ATIPEvent;)V 
.const [429] = Utf8 increaseFloatingPointPrecision 
.const [430] = Utf8 (F)F 
.const [431] = Utf8 updateRotationAngle 
.const [432] = Utf8 (Lde/audi/atip/hmi/event/WheelButtonEvent;)V 
.const [433] = Utf8 keyTurned 
.const [434] = Utf8 (Lde/audi/atip/hmi/event/WheelButtonEvent;)V 
.const [435] = Utf8 keyTurnedInStreetView 
.const [436] = Utf8 (Lde/audi/atip/hmi/event/WheelButtonEvent;)V 
.const [437] = Utf8 restartTimer 
.const [438] = Utf8 ()V 
.const [439] = Utf8 setModel 
.const [440] = Utf8 (Lde/audi/atip/hmi/model/VirtualButtonModel;)V 
.const [441] = Utf8 setParent 
.const [442] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/high/widgets/MapDynamicSidebar;)V 
.end class 
