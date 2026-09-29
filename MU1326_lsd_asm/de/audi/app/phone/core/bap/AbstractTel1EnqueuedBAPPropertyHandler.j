.version 50 0 
.class public super abstract [302] 
.super [304] 
.implements [306] 
.field private volatile [307] [308] 
.field private volatile [309] [310] 
.field private volatile [311] [312] 
.field private final [313] [314] 
.field static synthetic [315] [316] 

.method public [318] : [319] 
    .attribute [317] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [5] 
L4:     invokespecial [47] 
L7:     aload_0 
L8:     aload_2 
L9:     putfield [53] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [320] : [321] 
    .attribute [317] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [54] 
L4:     dup 
L5:     aload_0 
L6:     invokevirtual [31] 
L9:     invokeinterface [55] 0 
L14:    getstatic [7] 
L17:    ifnonnull L32 
L20:    ldc [8] 
L22:    invokestatic [9] 
L25:    dup 
L26:    putstatic [48] 
L29:    goto L35 
L32:    getstatic [7] 
L35:    invokevirtual [32] 
L38:    aload_0 
L39:    aload_0 
L40:    getfield [33] 
L43:    invokespecial [49] 
L46:    putfield [56] 
L49:    aload_0 
L50:    getfield [34] 
L53:    invokevirtual [35] 
L56:    aload_0 
L57:    invokevirtual [31] 
L60:    invokeinterface [57] 0 
L65:    aload_0 
L66:    invokeinterface [58] 0 
L71:    return 
L72:    
    .end code 
.end method 

.method public [322] : [323] 
    .attribute [317] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [34] 
L4:     ifnull L19 
L7:     aload_0 
L8:     getfield [34] 
L11:    invokevirtual [36] 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [56] 
L19:    aload_0 
L20:    invokevirtual [31] 
L23:    invokeinterface [57] 0 
L28:    aload_0 
L29:    invokeinterface [59] 0 
L34:    return 
L35:    nop 
L36:    
    .end code 
.end method 

.method protected [324] : [325] 
    .attribute [317] .code stack 4 locals 0 
L0:     aload_0 
L1:     new [60] 
L4:     dup 
L5:     aload_0 
L6:     invokespecial [50] 
L9:     invokespecial [51] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method private [326] : [327] 
    .attribute [317] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     aload_1 
L5:     invokevirtual [37] 
L8:     pop 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [328] : [329] 
    .attribute [317] .code stack 3 locals 1 
L0:     aload_1 
L1:     ifnonnull L19 
L4:     aload_0 
L5:     getfield [33] 
L8:     sipush 10000 
L11:    ldc [11] 
L13:    invokevirtual [38] 
L16:    pop 
L17:    aconst_null 
L18:    areturn 
L19:    aload_0 
L20:    invokevirtual [31] 
L23:    invokeinterface [55] 0 
L28:    aload_1 
L29:    invokeinterface [61] 0 
L34:    astore_2 
L35:    aload_2 
L36:    ifnonnull L54 
L39:    aload_0 
L40:    getfield [33] 
L43:    sipush 10000 
L46:    ldc [12] 
L48:    invokevirtual [38] 
L51:    pop 
L52:    aconst_null 
L53:    areturn 
L54:    getstatic [7] 
L57:    ifnonnull L72 
L60:    ldc [8] 
L62:    invokestatic [9] 
L65:    dup 
L66:    putstatic [48] 
L69:    goto L75 
L72:    getstatic [7] 
L75:    aload_2 
L76:    invokevirtual [39] 
L79:    ifeq L92 
L82:    aload_0 
L83:    aload_2 
L84:    checkcast [13] 
L87:    invokevirtual [40] 
L90:    aload_2 
L91:    areturn 
L92:    aload_0 
L93:    invokevirtual [31] 
L96:    invokeinterface [55] 0 
L101:   aload_1 
L102:   invokeinterface [62] 0 
L107:   pop 
L108:   aconst_null 
L109:   areturn 
L110:   nop 
L111:   nop 
L112:   
    .end code 
.end method 

.method public enum [330] : [331] 
    .attribute [317] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [332] : [333] 
    .attribute [317] .code stack 3 locals 0 
L0:     aload_1 
L1:     ifnonnull L18 
L4:     aload_0 
L5:     getfield [33] 
L8:     sipush 10000 
L11:    ldc [14] 
L13:    invokevirtual [38] 
L16:    pop 
L17:    return 
L18:    aload_2 
L19:    ifnonnull L36 
L22:    aload_0 
L23:    getfield [33] 
L26:    sipush 10000 
L29:    ldc [15] 
L31:    invokevirtual [38] 
L34:    pop 
L35:    return 
L36:    getstatic [7] 
L39:    ifnonnull L54 
L42:    ldc [8] 
L44:    invokestatic [9] 
L47:    dup 
L48:    putstatic [48] 
L51:    goto L57 
L54:    getstatic [7] 
L57:    aload_2 
L58:    invokevirtual [39] 
L61:    ifeq L85 
L64:    aload_0 
L65:    aconst_null 
L66:    invokevirtual [40] 
L69:    aload_0 
L70:    invokevirtual [31] 
L73:    invokeinterface [55] 0 
L78:    aload_1 
L79:    invokeinterface [62] 0 
L84:    pop 
L85:    return 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 

.method public [334] : [335] 
    .attribute [317] .code stack 3 locals 3 
L0:     aload_2 
L1:     ifnonnull L18 
L4:     aload_0 
L5:     getfield [33] 
L8:     sipush 10000 
L11:    ldc [16] 
L13:    invokevirtual [38] 
L16:    pop 
L17:    return 
L18:    aload_0 
L19:    aload_2 
L20:    invokevirtual [41] 
L23:    aload_2 
L24:    ifnonnull L28 
L27:    return 
L28:    aload_0 
L29:    iload_1 
L30:    aload_2 
L31:    invokevirtual [42] 
L34:    ifeq L122 
L37:    aload_2 
L38:    invokeinterface [63] 0 
L43:    astore_3 
L44:    aload_3 
L45:    ifnull L70 
L48:    aload_3 
L49:    invokeinterface [64] 0 
L54:    ifeq L70 
L57:    aload_3 
L58:    invokeinterface [65] 0 
L63:    ifeq L70 
L66:    iconst_1 
L67:    goto L71 
L70:    iconst_0 
L71:    istore 4 
L73:    aload_3 
L74:    ifnull L90 
L77:    aload_3 
L78:    invokeinterface [66] 0 
L83:    ifeq L90 
L86:    iconst_1 
L87:    goto L91 
L90:    iconst_0 
L91:    istore 5 
L93:    iload 4 
L95:    ifeq L103 
L98:    iload 5 
L100:   ifeq L110 
L103:   aload_0 
L104:   invokevirtual [43] 
L107:   goto L122 
L110:   aload_0 
L111:   getfield [33] 
L114:   ldc [17] 
L116:   ldc [18] 
L118:   invokevirtual [38] 
L121:   pop 
L122:   return 
L123:   nop 
L124:   
    .end code 
.end method 

.method protected interface [336] : [337] 
    .attribute [317] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [44] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [338] : [339] 
    .attribute [317] .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield [44] 
L4:     astore_1 
L5:     aload_1 
L6:     ifnull L18 
L9:     aload_1 
L10:    invokeinterface [68] 0 
L15:    goto L19 
L18:    aconst_null 
L19:    areturn 
L20:    
    .end code 
.end method 

.method public [340] : [341] 
    .attribute [317] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [69] 
L5:     aload_1 
L6:     ifnull L13 
L9:     aload_0 
L10:    invokevirtual [43] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected interface [342] : [343] 
    .attribute [317] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [45] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected abstract [344] : [345] 
    .attribute [317] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [346] : [347] 
    .attribute [317] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [348] : [349] 
    .attribute [317] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [67] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [350] : [351] 
    .attribute [317] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [52] 
L9:     dup 
L10:    invokespecial [46] 
L13:    aload_1 
L14:    invokevirtual [29] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [70] [71] 
.const [3] = Class [72] 
.const [4] = Class [73] 
.const [5] = String [74] 
.const [6] = Class [75] 
.const [7] = Field [76] [77] 
.const [8] = String [78] 
.const [9] = Method [79] [80] 
.const [10] = Class [81] 
.const [11] = String [82] 
.const [12] = String [83] 
.const [13] = Class [84] 
.const [14] = String [85] 
.const [15] = String [86] 
.const [16] = String [87] 
.const [17] = Int 1078071040 
.const [18] = String [88] 
.const [19] = Class [89] 
.const [20] = Class [90] 
.const [21] = Class [91] 
.const [22] = Class [92] 
.const [23] = Class [93] 
.const [24] = Class [94] 
.const [25] = Class [95] 
.const [26] = Class [96] 
.const [27] = Class [97] 
.const [28] = Class [98] 
.const [29] = Method [99] [100] 
.const [30] = Field [101] [102] 
.const [31] = Method [103] [104] 
.const [32] = Method [105] [106] 
.const [33] = Field [107] [108] 
.const [34] = Field [109] [110] 
.const [35] = Method [111] [112] 
.const [36] = Method [113] [114] 
.const [37] = Method [115] [116] 
.const [38] = Method [117] [118] 
.const [39] = Method [119] [120] 
.const [40] = Method [121] [122] 
.const [41] = Method [123] [124] 
.const [42] = Method [125] [126] 
.const [43] = Method [127] [128] 
.const [44] = Field [129] [130] 
.const [45] = Field [131] [132] 
.const [46] = Method [133] [134] 
.const [47] = Method [135] [136] 
.const [48] = Field [137] [138] 
.const [49] = Method [139] [140] 
.const [50] = Method [141] [142] 
.const [51] = Method [143] [144] 
.const [52] = Class [145] 
.const [53] = Field [146] [147] 
.const [54] = Class [148] 
.const [55] = InterfaceMethod [149] [150] 
.const [56] = Field [151] [152] 
.const [57] = InterfaceMethod [153] [154] 
.const [58] = InterfaceMethod [155] [156] 
.const [59] = InterfaceMethod [157] [158] 
.const [60] = Class [159] 
.const [61] = InterfaceMethod [160] [161] 
.const [62] = InterfaceMethod [162] [163] 
.const [63] = InterfaceMethod [164] [165] 
.const [64] = InterfaceMethod [166] [167] 
.const [65] = InterfaceMethod [168] [169] 
.const [66] = InterfaceMethod [170] [171] 
.const [67] = Field [172] [173] 
.const [68] = InterfaceMethod [174] [175] 
.const [69] = Field [176] [177] 
.const [70] = Class [178] 
.const [71] = NameAndType [179] [180] 
.const [72] = Utf8 java/lang/ClassNotFoundException 
.const [73] = Utf8 java/lang/NoClassDefFoundError 
.const [74] = Utf8 'App.Phone.BAP' 
.const [75] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [76] = Class [181] 
.const [77] = NameAndType [182] [183] 
.const [78] = Utf8 'de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone' 
.const [79] = Class [184] 
.const [80] = NameAndType [185] [186] 
.const [81] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler$1 
.const [82] = Utf8 'AbstractTel1EnqueuedBAPPropertyHandler#addingService reference is null' 
.const [83] = Utf8 'AbstractTel1EnqueuedBAPPropertyHandler#addingService service is null' 
.const [84] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone 
.const [85] = Utf8 'AbstractTel1EnqueuedBAPPropertyHandler#removedService reference is null' 
.const [86] = Utf8 'AbstractTel1EnqueuedBAPPropertyHandler#removedService service is null' 
.const [87] = Utf8 'AbstractTel1EnqueuedBAPPropertyHandler#updateGlobalTelephoneStateProperty stateStruct is null' 
.const [88] = Utf8 'AbstractTelEnqueuedBAPPropertyHandler#updateGlobalTelephoneStateProperty(): unhandled. Ecall has active call.' 
.const [89] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [90] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [91] = Utf8 java/lang/Class 
.const [92] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [93] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [94] = Utf8 de/esolutions/fw/util/commons/job/DispatcherBase 
.const [95] = Utf8 de/audi/atip/log/LogChannel 
.const [96] = Utf8 org/osgi/framework/BundleContext 
.const [97] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [98] = Utf8 de/audi/atip/interapp/phone/IEcallState 
.const [99] = Class [187] 
.const [100] = NameAndType [188] [189] 
.const [101] = Class [190] 
.const [102] = NameAndType [191] [192] 
.const [103] = Class [193] 
.const [104] = NameAndType [194] [195] 
.const [105] = Class [196] 
.const [106] = NameAndType [197] [198] 
.const [107] = Class [199] 
.const [108] = NameAndType [200] [201] 
.const [109] = Class [202] 
.const [110] = NameAndType [203] [204] 
.const [111] = Class [205] 
.const [112] = NameAndType [206] [207] 
.const [113] = Class [208] 
.const [114] = NameAndType [209] [210] 
.const [115] = Class [211] 
.const [116] = NameAndType [212] [213] 
.const [117] = Class [214] 
.const [118] = NameAndType [215] [216] 
.const [119] = Class [217] 
.const [120] = NameAndType [218] [219] 
.const [121] = Class [220] 
.const [122] = NameAndType [221] [222] 
.const [123] = Class [223] 
.const [124] = NameAndType [224] [225] 
.const [125] = Class [226] 
.const [126] = NameAndType [227] [228] 
.const [127] = Class [229] 
.const [128] = NameAndType [230] [231] 
.const [129] = Class [232] 
.const [130] = NameAndType [233] [234] 
.const [131] = Class [235] 
.const [132] = NameAndType [236] [237] 
.const [133] = Class [238] 
.const [134] = NameAndType [239] [240] 
.const [135] = Class [241] 
.const [136] = NameAndType [242] [243] 
.const [137] = Class [244] 
.const [138] = NameAndType [245] [246] 
.const [139] = Class [247] 
.const [140] = NameAndType [248] [249] 
.const [141] = Class [250] 
.const [142] = NameAndType [251] [252] 
.const [143] = Class [253] 
.const [144] = NameAndType [254] [255] 
.const [145] = Utf8 java/lang/NoClassDefFoundError 
.const [146] = Class [256] 
.const [147] = NameAndType [257] [258] 
.const [148] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [149] = Class [259] 
.const [150] = NameAndType [260] [261] 
.const [151] = Class [262] 
.const [152] = NameAndType [263] [264] 
.const [153] = Class [265] 
.const [154] = NameAndType [266] [267] 
.const [155] = Class [268] 
.const [156] = NameAndType [269] [270] 
.const [157] = Class [271] 
.const [158] = NameAndType [272] [273] 
.const [159] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler$1 
.const [160] = Class [274] 
.const [161] = NameAndType [275] [276] 
.const [162] = Class [277] 
.const [163] = NameAndType [278] [279] 
.const [164] = Class [280] 
.const [165] = NameAndType [281] [282] 
.const [166] = Class [283] 
.const [167] = NameAndType [284] [285] 
.const [168] = Class [286] 
.const [169] = NameAndType [287] [288] 
.const [170] = Class [289] 
.const [171] = NameAndType [290] [291] 
.const [172] = Class [292] 
.const [173] = NameAndType [293] [294] 
.const [174] = Class [295] 
.const [175] = NameAndType [296] [297] 
.const [176] = Class [298] 
.const [177] = NameAndType [299] [300] 
.const [178] = Utf8 java/lang/Class 
.const [179] = Utf8 forName 
.const [180] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [181] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [182] = Utf8 class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone 
.const [183] = Utf8 Ljava/lang/Class; 
.const [184] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [185] = Utf8 class$ 
.const [186] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [187] = Utf8 java/lang/NoClassDefFoundError 
.const [188] = Utf8 initCause 
.const [189] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [190] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [191] = Utf8 bapCombiDispatcher 
.const [192] = Utf8 Lde/esolutions/fw/util/commons/job/DispatcherBase; 
.const [193] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [194] = Utf8 getApplication 
.const [195] = Utf8 ()Lde/audi/app/phone/core/ITelApplication; 
.const [196] = Utf8 java/lang/Class 
.const [197] = Utf8 getName 
.const [198] = Utf8 ()Ljava/lang/String; 
.const [199] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [200] = Utf8 log 
.const [201] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [202] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [203] = Utf8 bapServiceTracker 
.const [204] = Utf8 Lde/audi/app/phone/core/PhoneServiceTracker; 
.const [205] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [206] = Utf8 openTracker 
.const [207] = Utf8 ()V 
.const [208] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [209] = Utf8 closeTracker 
.const [210] = Utf8 ()V 
.const [211] = Utf8 de/esolutions/fw/util/commons/job/DispatcherBase 
.const [212] = Utf8 execute 
.const [213] = Utf8 (Ljava/lang/Object;)Lde/esolutions/fw/util/commons/job/Job; 
.const [214] = Utf8 de/audi/atip/log/LogChannel 
.const [215] = Utf8 log 
.const [216] = Utf8 (ILjava/lang/String;)Z 
.const [217] = Utf8 java/lang/Class 
.const [218] = Utf8 isInstance 
.const [219] = Utf8 (Ljava/lang/Object;)Z 
.const [220] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [221] = Utf8 setBAPService 
.const [222] = Utf8 (Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone;)V 
.const [223] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [224] = Utf8 setTelephoneState 
.const [225] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [226] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [227] = Utf8 doProcessGlobalTelephoneStateUpdate 
.const [228] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)Z 
.const [229] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [230] = Utf8 enqueueUpdate 
.const [231] = Utf8 ()V 
.const [232] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [233] = Utf8 telephoneState 
.const [234] = Utf8 Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [235] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [236] = Utf8 combiService 
.const [237] = Utf8 Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone; 
.const [238] = Utf8 java/lang/NoClassDefFoundError 
.const [239] = Utf8 <init> 
.const [240] = Utf8 ()V 
.const [241] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [242] = Utf8 <init> 
.const [243] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Ljava/lang/String;)V 
.const [244] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [245] = Utf8 class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone 
.const [246] = Utf8 Ljava/lang/Class; 
.const [247] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [248] = Utf8 <init> 
.const [249] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;Lde/audi/atip/log/LogChannel;)V 
.const [250] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler$1 
.const [251] = Utf8 <init> 
.const [252] = Utf8 (Lde/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler;)V 
.const [253] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [254] = Utf8 scheduleExecution 
.const [255] = Utf8 (Ljava/lang/Runnable;)V 
.const [256] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [257] = Utf8 bapCombiDispatcher 
.const [258] = Utf8 Lde/esolutions/fw/util/commons/job/DispatcherBase; 
.const [259] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [260] = Utf8 getBundleContext 
.const [261] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [262] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [263] = Utf8 bapServiceTracker 
.const [264] = Utf8 Lde/audi/app/phone/core/PhoneServiceTracker; 
.const [265] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [266] = Utf8 getGlobalTelephoneStateManager 
.const [267] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneState; 
.const [268] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [269] = Utf8 registerListener 
.const [270] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateListener;)V 
.const [271] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [272] = Utf8 removeListener 
.const [273] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateListener;)V 
.const [274] = Utf8 org/osgi/framework/BundleContext 
.const [275] = Utf8 getService 
.const [276] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [277] = Utf8 org/osgi/framework/BundleContext 
.const [278] = Utf8 ungetService 
.const [279] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [280] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [281] = Utf8 getConnectedGatewayState 
.const [282] = Utf8 ()Lde/audi/atip/interapp/phone/IEcallState; 
.const [283] = Utf8 de/audi/atip/interapp/phone/IEcallState 
.const [284] = Utf8 hasActiveCall 
.const [285] = Utf8 ()Z 
.const [286] = Utf8 de/audi/atip/interapp/phone/IEcallState 
.const [287] = Utf8 isEmergencyCallType 
.const [288] = Utf8 ()Z 
.const [289] = Utf8 de/audi/atip/interapp/phone/IEcallState 
.const [290] = Utf8 isLowPrioritySOSEmergencyCallType 
.const [291] = Utf8 ()Z 
.const [292] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [293] = Utf8 telephoneState 
.const [294] = Utf8 Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [295] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [296] = Utf8 getCallLeadingDevice 
.const [297] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [298] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [299] = Utf8 combiService 
.const [300] = Utf8 Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone; 
.const [301] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [302] = Class [301] 
.const [303] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [304] = Class [303] 
.const [305] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [306] = Class [305] 
.const [307] = Utf8 bapServiceTracker 
.const [308] = Utf8 Lde/audi/app/phone/core/PhoneServiceTracker; 
.const [309] = Utf8 telephoneState 
.const [310] = Utf8 Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [311] = Utf8 combiService 
.const [312] = Utf8 Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone; 
.const [313] = Utf8 bapCombiDispatcher 
.const [314] = Utf8 Lde/esolutions/fw/util/commons/job/DispatcherBase; 
.const [315] = Utf8 class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone 
.const [316] = Utf8 Ljava/lang/Class; 
.const [317] = Utf8 Code 
.const [318] = Utf8 <init> 
.const [319] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [320] = Utf8 init 
.const [321] = Utf8 ()V 
.const [322] = Utf8 deinit 
.const [323] = Utf8 ()V 
.const [324] = Utf8 enqueueUpdate 
.const [325] = Utf8 ()V 
.const [326] = Utf8 scheduleExecution 
.const [327] = Utf8 (Ljava/lang/Runnable;)V 
.const [328] = Utf8 addingService 
.const [329] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [330] = Utf8 modifiedService 
.const [331] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [332] = Utf8 removedService 
.const [333] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [334] = Utf8 updateGlobalTelephoneStateProperty 
.const [335] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [336] = Utf8 getTelephoneState 
.const [337] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [338] = Utf8 getCallLeadingDeviceState 
.const [339] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [340] = Utf8 setBAPService 
.const [341] = Utf8 (Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone;)V 
.const [342] = Utf8 getCombiService 
.const [343] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone; 
.const [344] = Utf8 doProcessGlobalTelephoneStateUpdate 
.const [345] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)Z 
.const [346] = Utf8 updateAsync 
.const [347] = Utf8 ()V 
.const [348] = Utf8 setTelephoneState 
.const [349] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [350] = Utf8 class$ 
.const [351] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
