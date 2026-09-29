.version 50 0 
.class public super [296] 
.super [298] 
.implements [300] 
.implements [302] 
.field public static final [303] [304] 
.field public static final [305] [306] 
.field public static final [307] [308] 
.field public static final [309] [310] 
.field public static final [311] [312] 
.field public static final [313] [314] 
.field protected [315] [316] 
.field protected [317] [318] 
.field protected [319] [320] 
.field protected [321] [322] 
.field protected [323] [324] 
.field protected [325] [326] 
.field private static final [327] [328] 
.field private final synthetic [329] [330] 

.method public [332] : [333] 
    .attribute [331] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [55] 
L5:     aload_0 
L6:     invokespecial [53] 
L9:     aload_0 
L10:    iconst_0 
L11:    putfield [56] 
L14:    aload_0 
L15:    new [57] 
L18:    dup 
L19:    aload_0 
L20:    invokespecial [54] 
L23:    putfield [58] 
L26:    aload_0 
L27:    iload_2 
L28:    putfield [59] 
L31:    return 
L32:    
    .end code 
.end method 

.method public [334] : [335] 
    .attribute [331] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [29] 
L4:     aload_0 
L5:     invokevirtual [30] 
L8:     aload_0 
L9:     iconst_0 
L10:    putfield [56] 
L13:    aload_0 
L14:    aconst_null 
L15:    putfield [60] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [336] : [337] 
    .attribute [331] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     ifeq L68 
L7:     aload_0 
L8:     getfield [25] 
L11:    invokestatic [3] 
L14:    ldc [4] 
L16:    ldc [5] 
L18:    aload_0 
L19:    getfield [26] 
L22:    i2l 
L23:    invokevirtual [32] 
L26:    pop 
L27:    aload_0 
L28:    getfield [26] 
L31:    iconst_1 
L32:    if_icmpne L51 
L35:    aload_0 
L36:    iconst_3 
L37:    putfield [56] 
L40:    aload_0 
L41:    invokevirtual [33] 
L44:    iconst_1 
L45:    invokevirtual [34] 
L48:    goto L68 
L51:    aload_0 
L52:    getfield [26] 
L55:    iconst_2 
L56:    if_icmpne L68 
L59:    aload_0 
L60:    invokevirtual [30] 
L63:    aload_0 
L64:    aconst_null 
L65:    invokevirtual [35] 
L68:    return 
L69:    nop 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [338] : [339] 
    .attribute [331] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [31] 
L4:     ifnonnull L15 
L7:     aload_0 
L8:     fconst_1 
L9:     putfield [61] 
L12:    goto L26 
L15:    aload_0 
L16:    aload_0 
L17:    getfield [31] 
L20:    invokevirtual [37] 
L23:    putfield [61] 
L26:    aload_0 
L27:    getfield [25] 
L30:    invokestatic [6] 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [340] : [341] 
    .attribute [331] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iload_3 
L3:     i2f 
L4:     invokevirtual [38] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [342] : [343] 
    .attribute [331] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [31] 
L5:     invokevirtual [37] 
L8:     putfield [61] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [344] : [345] 
    .attribute [331] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     iconst_3 
L5:     if_icmpne L31 
L8:     aload_0 
L9:     getfield [25] 
L12:    invokestatic [3] 
L15:    ldc [4] 
L17:    ldc [7] 
L19:    invokevirtual [39] 
L22:    pop 
L23:    aload_0 
L24:    iconst_0 
L25:    putfield [56] 
L28:    goto L63 
L31:    aload_0 
L32:    getfield [26] 
L35:    iconst_1 
L36:    if_icmpne L63 
L39:    aload_0 
L40:    getfield [25] 
L43:    invokestatic [3] 
L46:    ldc [4] 
L48:    ldc [8] 
L50:    invokevirtual [39] 
L53:    pop 
L54:    aload_0 
L55:    iconst_2 
L56:    putfield [56] 
L59:    aload_0 
L60:    invokevirtual [40] 
L63:    aload_0 
L64:    getfield [25] 
L67:    invokestatic [6] 
L70:    return 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [346] : [347] 
    .attribute [331] .code stack 1 locals 1 
L0:     aload_0 
L1:     invokevirtual [33] 
L4:     astore_1 
L5:     aload_1 
L6:     ifnonnull L10 
L9:     return 
L10:    aload_1 
L11:    invokevirtual [41] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public interface [348] : [349] 
    .attribute [331] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [350] : [351] 
    .attribute [331] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [31] 
L4:     ifnull L12 
L7:     aload_0 
L8:     getfield [31] 
L11:    areturn 
L12:    aload_0 
L13:    getfield [28] 
L16:    ifge L37 
L19:    aload_0 
L20:    getfield [25] 
L23:    invokestatic [3] 
L26:    sipush 10000 
L29:    ldc [9] 
L31:    invokevirtual [39] 
L34:    pop 
L35:    aconst_null 
L36:    areturn 
L37:    aload_0 
L38:    aload_0 
L39:    getfield [25] 
L42:    invokevirtual [42] 
L45:    aload_0 
L46:    getfield [28] 
L49:    invokevirtual [43] 
L52:    checkcast [10] 
L55:    putfield [60] 
L58:    aload_0 
L59:    getfield [31] 
L62:    aload_0 
L63:    invokevirtual [44] 
L66:    aload_0 
L67:    getfield [31] 
L70:    areturn 
L71:    nop 
L72:    
    .end code 
.end method 

.method public interface [352] : [353] 
    .attribute [331] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [36] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [354] : [355] 
    .attribute [331] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     iconst_1 
L5:     if_icmpne L12 
L8:     fconst_0 
L9:     goto L14 
L12:    ldc [11] 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [356] : [357] 
    .attribute [331] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     iconst_1 
L5:     if_icmpne L13 
L8:     ldc [11] 
L10:    goto L14 
L13:    fconst_0 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [358] : [359] 
    .attribute [331] .code stack 6 locals 1 
L0:     aload_0 
L1:     invokevirtual [33] 
L4:     astore_1 
L5:     aconst_null 
L6:     aload_1 
L7:     if_acmpne L11 
L10:    return 
L11:    aload_0 
L12:    getfield [26] 
L15:    ifne L41 
L18:    aload_0 
L19:    getfield [25] 
L22:    invokestatic [3] 
L25:    ldc [4] 
L27:    ldc [12] 
L29:    invokevirtual [39] 
L32:    pop 
L33:    aload_0 
L34:    iconst_1 
L35:    putfield [56] 
L38:    goto L54 
L41:    aload_0 
L42:    getfield [26] 
L45:    iconst_2 
L46:    if_icmpne L54 
L49:    aload_0 
L50:    invokevirtual [40] 
L53:    return 
L54:    aload_0 
L55:    getfield [31] 
L58:    invokevirtual [45] 
L61:    ifne L100 
L64:    aload_0 
L65:    getfield [25] 
L68:    invokestatic [3] 
L71:    ldc [4] 
L73:    ldc [13] 
L75:    invokevirtual [39] 
L78:    pop 
L79:    aload_1 
L80:    aload_0 
L81:    invokevirtual [46] 
L84:    aload_0 
L85:    invokevirtual [47] 
L88:    aload_0 
L89:    getfield [28] 
L92:    iconst_0 
L93:    aload_0 
L94:    getfield [25] 
L97:    invokevirtual [48] 
L100:   return 
L101:   nop 
L102:   nop 
L103:   nop 
L104:   
    .end code 
.end method 

.method public [360] : [361] 
    .attribute [331] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [49] 
L4:     ifnull L24 
L7:     aload_0 
L8:     getfield [49] 
L11:    invokevirtual [50] 
L14:    ifne L24 
L17:    aload_0 
L18:    getfield [49] 
L21:    invokevirtual [51] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [362] : [363] 
    .attribute [331] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokevirtual [30] 
L4:     aload_0 
L5:     getstatic [14] 
L8:     invokeinterface [63] 0 
L13:    aload_0 
L14:    getfield [27] 
L17:    ldc_w [1] 
L20:    invokeinterface [64] 0 
L25:    putfield [62] 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [364] : [365] 
    .attribute [331] .code stack 3 locals 0 
L0:     aload_0 
L1:     iconst_3 
L2:     putfield [56] 
L5:     aload_0 
L6:     getfield [25] 
L9:     invokestatic [3] 
L12:    ldc [4] 
L14:    ldc [15] 
L16:    invokevirtual [39] 
L19:    pop 
L20:    aload_0 
L21:    invokevirtual [52] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [66] 
.const [3] = Method [67] [68] 
.const [4] = Int -2137614336 
.const [5] = String [69] 
.const [6] = Method [70] [71] 
.const [7] = String [72] 
.const [8] = String [73] 
.const [9] = String [74] 
.const [10] = Class [75] 
.const [11] = Int 31300 
.const [12] = String [76] 
.const [13] = String [77] 
.const [14] = Field [78] [79] 
.const [15] = String [80] 
.const [16] = Class [81] 
.const [17] = Class [82] 
.const [18] = Class [83] 
.const [19] = Class [84] 
.const [20] = Class [85] 
.const [21] = Class [86] 
.const [22] = Class [87] 
.const [23] = Class [88] 
.const [24] = Class [89] 
.const [25] = Field [90] [91] 
.const [26] = Field [92] [93] 
.const [27] = Field [94] [95] 
.const [28] = Field [96] [97] 
.const [29] = Method [98] [99] 
.const [30] = Method [100] [101] 
.const [31] = Field [102] [103] 
.const [32] = Method [104] [105] 
.const [33] = Method [106] [107] 
.const [34] = Method [108] [109] 
.const [35] = Method [110] [111] 
.const [36] = Field [112] [113] 
.const [37] = Method [114] [115] 
.const [38] = Method [116] [117] 
.const [39] = Method [118] [119] 
.const [40] = Method [120] [121] 
.const [41] = Method [122] [123] 
.const [42] = Method [124] [125] 
.const [43] = Method [126] [127] 
.const [44] = Method [128] [129] 
.const [45] = Method [130] [131] 
.const [46] = Method [132] [133] 
.const [47] = Method [134] [135] 
.const [48] = Method [136] [137] 
.const [49] = Field [138] [139] 
.const [50] = Method [140] [141] 
.const [51] = Method [142] [143] 
.const [52] = Method [144] [145] 
.const [53] = Method [146] [147] 
.const [54] = Method [148] [149] 
.const [55] = Field [150] [151] 
.const [56] = Field [152] [153] 
.const [57] = Class [154] 
.const [58] = Field [155] [156] 
.const [59] = Field [157] [158] 
.const [60] = Field [159] [160] 
.const [61] = Field [161] [162] 
.const [62] = Field [163] [164] 
.const [63] = InterfaceMethod [165] [166] 
.const [64] = InterfaceMethod [167] [168] 
.const [65] = Int -1778384896 
.const [66] = Utf8 de/audi/atip/hmi/event/TimerEvent 
.const [67] = Class [169] 
.const [68] = NameAndType [170] [171] 
.const [69] = Utf8 'AbstractPlaceholderMenuController#BounceCursor#abortAnimation aborting bounce animation with mode: %1' 
.const [70] = Class [172] 
.const [71] = NameAndType [173] [174] 
.const [72] = Utf8 'AbstractPlaceholderMenuController#BounceCursor#animationFinished bouncing animation finished' 
.const [73] = Utf8 'AbstractPlaceholderMenuController#BounceCursor#animationFinished bouncing reached max deflection' 
.const [74] = Utf8 'AbstractPlaceholderMenuController#BounceCursor#getCursorAnimation cursorAnimationType not set' 
.const [75] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimation 
.const [76] = Utf8 'AbstractPlaceholderMenuController#BounceCursor#restartAnimation bounce direction set to deflection point' 
.const [77] = Utf8 'AbstractPlaceholderMenuController#BounceCursor#restartAnimation starting bounce animation' 
.const [78] = Class [175] 
.const [79] = NameAndType [176] [177] 
.const [80] = Utf8 'AbstractPlaceholderMenuController#BounceCursor#processEvent bounce direction set to origin point' 
.const [81] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController$BounceCursor 
.const [82] = Utf8 java/lang/Object 
.const [83] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController 
.const [84] = Utf8 de/audi/atip/log/LogChannel 
.const [85] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimationController 
.const [86] = Utf8 de/esolutions/fw/util/commons/job/Job 
.const [87] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [88] = Utf8 de/audi/tghu/hmi/evo/IHMIServiceEvo 
.const [89] = Utf8 de/audi/atip/hmi/event/EventDispatcher 
.const [90] = Class [178] 
.const [91] = NameAndType [179] [180] 
.const [92] = Class [181] 
.const [93] = NameAndType [182] [183] 
.const [94] = Class [184] 
.const [95] = NameAndType [185] [186] 
.const [96] = Class [187] 
.const [97] = NameAndType [188] [189] 
.const [98] = Class [190] 
.const [99] = NameAndType [191] [192] 
.const [100] = Class [193] 
.const [101] = NameAndType [194] [195] 
.const [102] = Class [196] 
.const [103] = NameAndType [197] [198] 
.const [104] = Class [199] 
.const [105] = NameAndType [200] [201] 
.const [106] = Class [202] 
.const [107] = NameAndType [203] [204] 
.const [108] = Class [205] 
.const [109] = NameAndType [206] [207] 
.const [110] = Class [208] 
.const [111] = NameAndType [209] [210] 
.const [112] = Class [211] 
.const [113] = NameAndType [212] [213] 
.const [114] = Class [214] 
.const [115] = NameAndType [215] [216] 
.const [116] = Class [217] 
.const [117] = NameAndType [218] [219] 
.const [118] = Class [220] 
.const [119] = NameAndType [221] [222] 
.const [120] = Class [223] 
.const [121] = NameAndType [224] [225] 
.const [122] = Class [226] 
.const [123] = NameAndType [227] [228] 
.const [124] = Class [229] 
.const [125] = NameAndType [230] [231] 
.const [126] = Class [232] 
.const [127] = NameAndType [233] [234] 
.const [128] = Class [235] 
.const [129] = NameAndType [236] [237] 
.const [130] = Class [238] 
.const [131] = NameAndType [239] [240] 
.const [132] = Class [241] 
.const [133] = NameAndType [242] [243] 
.const [134] = Class [244] 
.const [135] = NameAndType [245] [246] 
.const [136] = Class [247] 
.const [137] = NameAndType [248] [249] 
.const [138] = Class [250] 
.const [139] = NameAndType [251] [252] 
.const [140] = Class [253] 
.const [141] = NameAndType [254] [255] 
.const [142] = Class [256] 
.const [143] = NameAndType [257] [258] 
.const [144] = Class [259] 
.const [145] = NameAndType [260] [261] 
.const [146] = Class [262] 
.const [147] = NameAndType [263] [264] 
.const [148] = Class [265] 
.const [149] = NameAndType [266] [267] 
.const [150] = Class [268] 
.const [151] = NameAndType [269] [270] 
.const [152] = Class [271] 
.const [153] = NameAndType [272] [273] 
.const [154] = Utf8 de/audi/atip/hmi/event/TimerEvent 
.const [155] = Class [274] 
.const [156] = NameAndType [275] [276] 
.const [157] = Class [277] 
.const [158] = NameAndType [278] [279] 
.const [159] = Class [280] 
.const [160] = NameAndType [281] [282] 
.const [161] = Class [283] 
.const [162] = NameAndType [284] [285] 
.const [163] = Class [286] 
.const [164] = NameAndType [287] [288] 
.const [165] = Class [289] 
.const [166] = NameAndType [290] [291] 
.const [167] = Class [292] 
.const [168] = NameAndType [293] [294] 
.const [169] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController 
.const [170] = Utf8 access$400 
.const [171] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController;)Lde/audi/atip/log/LogChannel; 
.const [172] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController 
.const [173] = Utf8 access$500 
.const [174] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController;)V 
.const [175] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [176] = Utf8 hmiService 
.const [177] = Utf8 Lde/audi/tghu/hmi/evo/IHMIServiceEvo; 
.const [178] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController$BounceCursor 
.const [179] = Utf8 this$0 
.const [180] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController; 
.const [181] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController$BounceCursor 
.const [182] = Utf8 bounceMode 
.const [183] = Utf8 I 
.const [184] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController$BounceCursor 
.const [185] = Utf8 maxDeflectionIdleTimer 
.const [186] = Utf8 Lde/audi/atip/hmi/event/TimerEvent; 
.const [187] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController$BounceCursor 
.const [188] = Utf8 type 
.const [189] = Utf8 I 
.const [190] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController$BounceCursor 
.const [191] = Utf8 cancelAnimation 
.const [192] = Utf8 ()V 
.const [193] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController$BounceCursor 
.const [194] = Utf8 cancelIdleTimer 
.const [195] = Utf8 ()V 
.const [196] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController$BounceCursor 
.const [197] = Utf8 animation 
.const [198] = Utf8 Lde/esolutions/hmi/widgets/audi/base/animation/AbstractAnimation; 
.const [199] = Utf8 de/audi/atip/log/LogChannel 
.const [200] = Utf8 log 
.const [201] = Utf8 (ILjava/lang/String;J)Z 
.const [202] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController$BounceCursor 
.const [203] = Utf8 getCursorAnimation 
.const [204] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/animation/AbstractAnimation; 
.const [205] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimation 
.const [206] = Utf8 rollBackAnimation 
.const [207] = Utf8 (Z)V 
.const [208] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController$BounceCursor 
.const [209] = Utf8 processEvent 
.const [210] = Utf8 (Lde/audi/atip/hmi/event/ATIPEvent;)V 
.const [211] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController$BounceCursor 
.const [212] = Utf8 progress 
.const [213] = Utf8 F 
.const [214] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimation 
.const [215] = Utf8 getProgress 
.const [216] = Utf8 ()F 
.const [217] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController$BounceCursor 
.const [218] = Utf8 animate 
.const [219] = Utf8 (IF)V 
.const [220] = Utf8 de/audi/atip/log/LogChannel 
.const [221] = Utf8 log 
.const [222] = Utf8 (ILjava/lang/String;)Z 
.const [223] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController$BounceCursor 
.const [224] = Utf8 restartIdleTimer 
.const [225] = Utf8 ()V 
.const [226] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimation 
.const [227] = Utf8 stopAnimation 
.const [228] = Utf8 ()V 
.const [229] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController 
.const [230] = Utf8 getAnimationController 
.const [231] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/animation/AbstractAnimationController; 
.const [232] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimationController 
.const [233] = Utf8 getIAnimation 
.const [234] = Utf8 (I)Lde/audi/atip/hmi/view/IAnimation; 
.const [235] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimation 
.const [236] = Utf8 addListener 
.const [237] = Utf8 (Lde/audi/atip/hmi/view/AnimationListener;)V 
.const [238] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimation 
.const [239] = Utf8 isAnimating 
.const [240] = Utf8 ()Z 
.const [241] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController$BounceCursor 
.const [242] = Utf8 getAnimationStart 
.const [243] = Utf8 ()F 
.const [244] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController$BounceCursor 
.const [245] = Utf8 getAnimationTarget 
.const [246] = Utf8 ()F 
.const [247] = Utf8 de/esolutions/hmi/widgets/audi/base/animation/AbstractAnimation 
.const [248] = Utf8 startDynamicAnimation 
.const [249] = Utf8 (FFIZLde/esolutions/hmi/widgets/audi/base/AbstractWidget;)V 
.const [250] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController$BounceCursor 
.const [251] = Utf8 maxDeflectionIdleJob 
.const [252] = Utf8 Lde/esolutions/fw/util/commons/job/Job; 
.const [253] = Utf8 de/esolutions/fw/util/commons/job/Job 
.const [254] = Utf8 isCanceled 
.const [255] = Utf8 ()Z 
.const [256] = Utf8 de/esolutions/fw/util/commons/job/Job 
.const [257] = Utf8 cancel 
.const [258] = Utf8 ()V 
.const [259] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController$BounceCursor 
.const [260] = Utf8 restartAnimation 
.const [261] = Utf8 ()V 
.const [262] = Utf8 java/lang/Object 
.const [263] = Utf8 <init> 
.const [264] = Utf8 ()V 
.const [265] = Utf8 de/audi/atip/hmi/event/TimerEvent 
.const [266] = Utf8 <init> 
.const [267] = Utf8 (Lde/audi/atip/hmi/event/ATIPEventListener;)V 
.const [268] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController$BounceCursor 
.const [269] = Utf8 this$0 
.const [270] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController; 
.const [271] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController$BounceCursor 
.const [272] = Utf8 bounceMode 
.const [273] = Utf8 I 
.const [274] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController$BounceCursor 
.const [275] = Utf8 maxDeflectionIdleTimer 
.const [276] = Utf8 Lde/audi/atip/hmi/event/TimerEvent; 
.const [277] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController$BounceCursor 
.const [278] = Utf8 type 
.const [279] = Utf8 I 
.const [280] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController$BounceCursor 
.const [281] = Utf8 animation 
.const [282] = Utf8 Lde/esolutions/hmi/widgets/audi/base/animation/AbstractAnimation; 
.const [283] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController$BounceCursor 
.const [284] = Utf8 progress 
.const [285] = Utf8 F 
.const [286] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController$BounceCursor 
.const [287] = Utf8 maxDeflectionIdleJob 
.const [288] = Utf8 Lde/esolutions/fw/util/commons/job/Job; 
.const [289] = Utf8 de/audi/tghu/hmi/evo/IHMIServiceEvo 
.const [290] = Utf8 getEventDispatcher 
.const [291] = Utf8 ()Lde/audi/atip/hmi/event/EventDispatcher; 
.const [292] = Utf8 de/audi/atip/hmi/event/EventDispatcher 
.const [293] = Utf8 postEvent 
.const [294] = Utf8 (Lde/audi/atip/hmi/event/ATIPEvent;J)Lde/esolutions/fw/util/commons/job/Job; 
.const [295] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController$BounceCursor 
.const [296] = Class [295] 
.const [297] = Utf8 java/lang/Object 
.const [298] = Class [297] 
.const [299] = Utf8 de/audi/atip/hmi/view/AnimationListener 
.const [300] = Class [299] 
.const [301] = Utf8 de/audi/atip/hmi/event/ATIPEventListener 
.const [302] = Class [301] 
.const [303] = Utf8 NO_BOUNCE 
.const [304] = Utf8 I 
.const [305] = Utf8 BOUNCE_TO_DEFLECTION 
.const [306] = Utf8 I 
.const [307] = Utf8 BOUNCE_AT_MAX_DEFLECTION 
.const [308] = Utf8 I 
.const [309] = Utf8 BOUNCE_TO_ORIGIN 
.const [310] = Utf8 I 
.const [311] = Utf8 BOUNCE_DEFLECTION_TARGET 
.const [312] = Utf8 F 
.const [313] = Utf8 BOUNCE_DEFLECTION_ORIGIN 
.const [314] = Utf8 F 
.const [315] = Utf8 type 
.const [316] = Utf8 I 
.const [317] = Utf8 animation 
.const [318] = Utf8 Lde/esolutions/hmi/widgets/audi/base/animation/AbstractAnimation; 
.const [319] = Utf8 progress 
.const [320] = Utf8 F 
.const [321] = Utf8 bounceMode 
.const [322] = Utf8 I 
.const [323] = Utf8 maxDeflectionIdleTimer 
.const [324] = Utf8 Lde/audi/atip/hmi/event/TimerEvent; 
.const [325] = Utf8 maxDeflectionIdleJob 
.const [326] = Utf8 Lde/esolutions/fw/util/commons/job/Job; 
.const [327] = Utf8 CURSOR_BOUNCE_NO_MOVE_DURATION 
.const [328] = Utf8 I 
.const [329] = Utf8 this$0 
.const [330] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController; 
.const [331] = Utf8 Code 
.const [332] = Utf8 <init> 
.const [333] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/AbstractPlaceholderMenuController;I)V 
.const [334] = Utf8 disconnect 
.const [335] = Utf8 ()V 
.const [336] = Utf8 abortAnimation 
.const [337] = Utf8 ()V 
.const [338] = Utf8 animate 
.const [339] = Utf8 (IF)V 
.const [340] = Utf8 animate 
.const [341] = Utf8 (IFI)V 
.const [342] = Utf8 animationStarted 
.const [343] = Utf8 (II)V 
.const [344] = Utf8 animationFinished 
.const [345] = Utf8 (II)V 
.const [346] = Utf8 cancelAnimation 
.const [347] = Utf8 ()V 
.const [348] = Utf8 getBounceMode 
.const [349] = Utf8 ()I 
.const [350] = Utf8 getCursorAnimation 
.const [351] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/animation/AbstractAnimation; 
.const [352] = Utf8 getProgress 
.const [353] = Utf8 ()F 
.const [354] = Utf8 getAnimationStart 
.const [355] = Utf8 ()F 
.const [356] = Utf8 getAnimationTarget 
.const [357] = Utf8 ()F 
.const [358] = Utf8 restartAnimation 
.const [359] = Utf8 ()V 
.const [360] = Utf8 cancelIdleTimer 
.const [361] = Utf8 ()V 
.const [362] = Utf8 restartIdleTimer 
.const [363] = Utf8 ()V 
.const [364] = Utf8 processEvent 
.const [365] = Utf8 (Lde/audi/atip/hmi/event/ATIPEvent;)V 
.end class 
