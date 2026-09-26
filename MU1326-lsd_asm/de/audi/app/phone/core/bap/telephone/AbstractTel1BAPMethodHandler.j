.version 50 0 
.class public super abstract [235] 
.super [237] 
.implements [239] 
.implements [241] 
.field private volatile [242] [243] 
.field private volatile [244] [245] 
.field private [246] [247] 
.field private final [248] [249] 
.field static synthetic [250] [251] 

.method public [253] : [254] 
    .attribute [252] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [5] 
L4:     invokespecial [37] 
L7:     aload_0 
L8:     aload_2 
L9:     putfield [43] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [255] : [256] 
    .attribute [252] .code stack 7 locals 0 
L0:     aload_0 
L1:     invokespecial [38] 
L4:     aload_0 
L5:     new [44] 
L8:     dup 
L9:     aload_0 
L10:    invokevirtual [25] 
L13:    invokeinterface [45] 0 
L18:    getstatic [7] 
L21:    ifnonnull L36 
L24:    ldc [8] 
L26:    invokestatic [9] 
L29:    dup 
L30:    putstatic [39] 
L33:    goto L39 
L36:    getstatic [7] 
L39:    invokevirtual [26] 
L42:    aload_0 
L43:    aload_0 
L44:    getfield [27] 
L47:    invokespecial [40] 
L50:    putfield [46] 
L53:    aload_0 
L54:    getfield [28] 
L57:    invokevirtual [29] 
L60:    aload_0 
L61:    invokevirtual [25] 
L64:    invokeinterface [47] 0 
L69:    aload_0 
L70:    invokeinterface [48] 0 
L75:    return 
L76:    
    .end code 
.end method 

.method public [257] : [258] 
    .attribute [252] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [41] 
L4:     aload_0 
L5:     getfield [28] 
L8:     ifnull L23 
L11:    aload_0 
L12:    getfield [28] 
L15:    invokevirtual [30] 
L18:    aload_0 
L19:    aconst_null 
L20:    putfield [46] 
L23:    aload_0 
L24:    invokevirtual [25] 
L27:    invokeinterface [47] 0 
L32:    aload_0 
L33:    invokeinterface [49] 0 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method protected [259] : [260] 
    .attribute [252] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     aload_1 
L5:     invokevirtual [31] 
L8:     pop 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [261] : [262] 
    .attribute [252] .code stack 3 locals 1 
L0:     aload_1 
L1:     ifnonnull L19 
L4:     aload_0 
L5:     getfield [27] 
L8:     sipush 10000 
L11:    ldc [10] 
L13:    invokevirtual [32] 
L16:    pop 
L17:    aconst_null 
L18:    areturn 
L19:    aload_0 
L20:    invokevirtual [25] 
L23:    invokeinterface [45] 0 
L28:    aload_1 
L29:    invokeinterface [50] 0 
L34:    astore_2 
L35:    aload_2 
L36:    ifnonnull L54 
L39:    aload_0 
L40:    getfield [27] 
L43:    sipush 10000 
L46:    ldc [11] 
L48:    invokevirtual [32] 
L51:    pop 
L52:    aconst_null 
L53:    areturn 
L54:    aload_2 
L55:    instanceof [12] 
L58:    ifeq L71 
L61:    aload_0 
L62:    aload_2 
L63:    checkcast [12] 
L66:    invokevirtual [33] 
L69:    aload_2 
L70:    areturn 
L71:    aload_0 
L72:    invokevirtual [25] 
L75:    invokeinterface [45] 0 
L80:    aload_1 
L81:    invokeinterface [51] 0 
L86:    pop 
L87:    aconst_null 
L88:    areturn 
L89:    nop 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 

.method protected [263] : [264] 
    .attribute [252] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [52] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public enum [265] : [266] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [267] : [268] 
    .attribute [252] .code stack 3 locals 0 
L0:     aload_1 
L1:     ifnonnull L18 
L4:     aload_0 
L5:     getfield [27] 
L8:     sipush 10000 
L11:    ldc [13] 
L13:    invokevirtual [32] 
L16:    pop 
L17:    return 
L18:    aload_2 
L19:    ifnonnull L36 
L22:    aload_0 
L23:    getfield [27] 
L26:    sipush 10000 
L29:    ldc [14] 
L31:    invokevirtual [32] 
L34:    pop 
L35:    return 
L36:    aload_2 
L37:    instanceof [12] 
L40:    ifeq L64 
L43:    aload_0 
L44:    invokevirtual [25] 
L47:    invokeinterface [45] 0 
L52:    aload_1 
L53:    invokeinterface [51] 0 
L58:    pop 
L59:    aload_0 
L60:    aconst_null 
L61:    invokevirtual [33] 
L64:    return 
L65:    nop 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method protected interface [269] : [270] 
    .attribute [252] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [34] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [271] : [272] 
    .attribute [252] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_2 
L2:     putfield [53] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected interface [273] : [274] 
    .attribute [252] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [35] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public enum [275] : [276] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [277] : [278] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [279] : [280] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [281] : [282] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [283] : [284] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [285] : [286] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [287] : [288] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [289] : [290] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [291] : [292] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [293] : [294] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [295] : [296] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [297] : [298] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [299] : [300] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [301] : [302] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [303] : [304] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [305] : [306] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [307] : [308] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [309] : [310] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [311] : [312] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [313] : [314] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [315] : [316] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [317] : [318] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [319] : [320] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [321] : [322] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [323] : [324] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [325] : [326] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [327] : [328] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [329] : [330] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [331] : [332] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [333] : [334] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [335] : [336] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [337] : [338] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [339] : [340] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [341] : [342] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [343] : [344] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [345] : [346] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [347] : [348] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [349] : [350] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [351] : [352] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method static synthetic [353] : [354] 
    .attribute [252] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [42] 
L9:     dup 
L10:    invokespecial [36] 
L13:    aload_1 
L14:    invokevirtual [23] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [54] [55] 
.const [3] = Class [56] 
.const [4] = Class [57] 
.const [5] = String [58] 
.const [6] = Class [59] 
.const [7] = Field [60] [61] 
.const [8] = String [62] 
.const [9] = Method [63] [64] 
.const [10] = String [65] 
.const [11] = String [66] 
.const [12] = Class [67] 
.const [13] = String [68] 
.const [14] = String [69] 
.const [15] = Class [70] 
.const [16] = Class [71] 
.const [17] = Class [72] 
.const [18] = Class [73] 
.const [19] = Class [74] 
.const [20] = Class [75] 
.const [21] = Class [76] 
.const [22] = Class [77] 
.const [23] = Method [78] [79] 
.const [24] = Field [80] [81] 
.const [25] = Method [82] [83] 
.const [26] = Method [84] [85] 
.const [27] = Field [86] [87] 
.const [28] = Field [88] [89] 
.const [29] = Method [90] [91] 
.const [30] = Method [92] [93] 
.const [31] = Method [94] [95] 
.const [32] = Method [96] [97] 
.const [33] = Method [98] [99] 
.const [34] = Field [100] [101] 
.const [35] = Field [102] [103] 
.const [36] = Method [104] [105] 
.const [37] = Method [106] [107] 
.const [38] = Method [108] [109] 
.const [39] = Field [110] [111] 
.const [40] = Method [112] [113] 
.const [41] = Method [114] [115] 
.const [42] = Class [116] 
.const [43] = Field [117] [118] 
.const [44] = Class [119] 
.const [45] = InterfaceMethod [120] [121] 
.const [46] = Field [122] [123] 
.const [47] = InterfaceMethod [124] [125] 
.const [48] = InterfaceMethod [126] [127] 
.const [49] = InterfaceMethod [128] [129] 
.const [50] = InterfaceMethod [130] [131] 
.const [51] = InterfaceMethod [132] [133] 
.const [52] = Field [134] [135] 
.const [53] = Field [136] [137] 
.const [54] = Class [138] 
.const [55] = NameAndType [139] [140] 
.const [56] = Utf8 java/lang/ClassNotFoundException 
.const [57] = Utf8 java/lang/NoClassDefFoundError 
.const [58] = Utf8 'App.Phone.BAP' 
.const [59] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [60] = Class [141] 
.const [61] = NameAndType [142] [143] 
.const [62] = Utf8 'de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone' 
.const [63] = Class [144] 
.const [64] = NameAndType [145] [146] 
.const [65] = Utf8 'AbstractTel1BAPMethodHandler#addingService reference is null' 
.const [66] = Utf8 'AbstractTel1BAPMethodHandler#addingService service is null' 
.const [67] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone 
.const [68] = Utf8 'AbstractTel1BAPMethodHandler#removedService reference is null' 
.const [69] = Utf8 'AbstractTel1BAPMethodHandler#removedService service is null' 
.const [70] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [71] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [72] = Utf8 java/lang/Class 
.const [73] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [74] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [75] = Utf8 de/esolutions/fw/util/commons/job/DispatcherBase 
.const [76] = Utf8 de/audi/atip/log/LogChannel 
.const [77] = Utf8 org/osgi/framework/BundleContext 
.const [78] = Class [147] 
.const [79] = NameAndType [148] [149] 
.const [80] = Class [150] 
.const [81] = NameAndType [151] [152] 
.const [82] = Class [153] 
.const [83] = NameAndType [154] [155] 
.const [84] = Class [156] 
.const [85] = NameAndType [157] [158] 
.const [86] = Class [159] 
.const [87] = NameAndType [160] [161] 
.const [88] = Class [162] 
.const [89] = NameAndType [163] [164] 
.const [90] = Class [165] 
.const [91] = NameAndType [166] [167] 
.const [92] = Class [168] 
.const [93] = NameAndType [169] [170] 
.const [94] = Class [171] 
.const [95] = NameAndType [172] [173] 
.const [96] = Class [174] 
.const [97] = NameAndType [175] [176] 
.const [98] = Class [177] 
.const [99] = NameAndType [178] [179] 
.const [100] = Class [180] 
.const [101] = NameAndType [181] [182] 
.const [102] = Class [183] 
.const [103] = NameAndType [184] [185] 
.const [104] = Class [186] 
.const [105] = NameAndType [187] [188] 
.const [106] = Class [189] 
.const [107] = NameAndType [190] [191] 
.const [108] = Class [192] 
.const [109] = NameAndType [193] [194] 
.const [110] = Class [195] 
.const [111] = NameAndType [196] [197] 
.const [112] = Class [198] 
.const [113] = NameAndType [199] [200] 
.const [114] = Class [201] 
.const [115] = NameAndType [202] [203] 
.const [116] = Utf8 java/lang/NoClassDefFoundError 
.const [117] = Class [204] 
.const [118] = NameAndType [205] [206] 
.const [119] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [120] = Class [207] 
.const [121] = NameAndType [208] [209] 
.const [122] = Class [210] 
.const [123] = NameAndType [211] [212] 
.const [124] = Class [213] 
.const [125] = NameAndType [214] [215] 
.const [126] = Class [216] 
.const [127] = NameAndType [217] [218] 
.const [128] = Class [219] 
.const [129] = NameAndType [220] [221] 
.const [130] = Class [222] 
.const [131] = NameAndType [223] [224] 
.const [132] = Class [225] 
.const [133] = NameAndType [226] [227] 
.const [134] = Class [228] 
.const [135] = NameAndType [229] [230] 
.const [136] = Class [231] 
.const [137] = NameAndType [232] [233] 
.const [138] = Utf8 java/lang/Class 
.const [139] = Utf8 forName 
.const [140] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [141] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [142] = Utf8 class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone 
.const [143] = Utf8 Ljava/lang/Class; 
.const [144] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [145] = Utf8 class$ 
.const [146] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [147] = Utf8 java/lang/NoClassDefFoundError 
.const [148] = Utf8 initCause 
.const [149] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [150] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [151] = Utf8 tel1Dispatcher 
.const [152] = Utf8 Lde/esolutions/fw/util/commons/job/DispatcherBase; 
.const [153] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [154] = Utf8 getApplication 
.const [155] = Utf8 ()Lde/audi/app/phone/core/ITelApplication; 
.const [156] = Utf8 java/lang/Class 
.const [157] = Utf8 getName 
.const [158] = Utf8 ()Ljava/lang/String; 
.const [159] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [160] = Utf8 log 
.const [161] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [162] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [163] = Utf8 combiBapServicePhoneTracker 
.const [164] = Utf8 Lde/audi/app/phone/core/PhoneServiceTracker; 
.const [165] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [166] = Utf8 openTracker 
.const [167] = Utf8 ()V 
.const [168] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [169] = Utf8 closeTracker 
.const [170] = Utf8 ()V 
.const [171] = Utf8 de/esolutions/fw/util/commons/job/DispatcherBase 
.const [172] = Utf8 execute 
.const [173] = Utf8 (Ljava/lang/Object;)Lde/esolutions/fw/util/commons/job/Job; 
.const [174] = Utf8 de/audi/atip/log/LogChannel 
.const [175] = Utf8 log 
.const [176] = Utf8 (ILjava/lang/String;)Z 
.const [177] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [178] = Utf8 setCombiBapService 
.const [179] = Utf8 (Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone;)V 
.const [180] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [181] = Utf8 combiBapService 
.const [182] = Utf8 Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone; 
.const [183] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [184] = Utf8 globalTelephoneState 
.const [185] = Utf8 Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [186] = Utf8 java/lang/NoClassDefFoundError 
.const [187] = Utf8 <init> 
.const [188] = Utf8 ()V 
.const [189] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [190] = Utf8 <init> 
.const [191] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Ljava/lang/String;)V 
.const [192] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [193] = Utf8 init 
.const [194] = Utf8 ()V 
.const [195] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [196] = Utf8 class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone 
.const [197] = Utf8 Ljava/lang/Class; 
.const [198] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [199] = Utf8 <init> 
.const [200] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;Lde/audi/atip/log/LogChannel;)V 
.const [201] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [202] = Utf8 deinit 
.const [203] = Utf8 ()V 
.const [204] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [205] = Utf8 tel1Dispatcher 
.const [206] = Utf8 Lde/esolutions/fw/util/commons/job/DispatcherBase; 
.const [207] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [208] = Utf8 getBundleContext 
.const [209] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [210] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [211] = Utf8 combiBapServicePhoneTracker 
.const [212] = Utf8 Lde/audi/app/phone/core/PhoneServiceTracker; 
.const [213] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [214] = Utf8 getGlobalTelephoneStateManager 
.const [215] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneState; 
.const [216] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [217] = Utf8 registerListener 
.const [218] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateListener;)V 
.const [219] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [220] = Utf8 removeListener 
.const [221] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateListener;)V 
.const [222] = Utf8 org/osgi/framework/BundleContext 
.const [223] = Utf8 getService 
.const [224] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [225] = Utf8 org/osgi/framework/BundleContext 
.const [226] = Utf8 ungetService 
.const [227] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [228] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [229] = Utf8 combiBapService 
.const [230] = Utf8 Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone; 
.const [231] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [232] = Utf8 globalTelephoneState 
.const [233] = Utf8 Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [234] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [235] = Class [234] 
.const [236] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [237] = Class [236] 
.const [238] = Utf8 de/audi/app/phone/core/dsi/ITelDSIResponseListener 
.const [239] = Class [238] 
.const [240] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [241] = Class [240] 
.const [242] = Utf8 combiBapServicePhoneTracker 
.const [243] = Utf8 Lde/audi/app/phone/core/PhoneServiceTracker; 
.const [244] = Utf8 combiBapService 
.const [245] = Utf8 Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone; 
.const [246] = Utf8 globalTelephoneState 
.const [247] = Utf8 Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [248] = Utf8 tel1Dispatcher 
.const [249] = Utf8 Lde/esolutions/fw/util/commons/job/DispatcherBase; 
.const [250] = Utf8 class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone 
.const [251] = Utf8 Ljava/lang/Class; 
.const [252] = Utf8 Code 
.const [253] = Utf8 <init> 
.const [254] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [255] = Utf8 init 
.const [256] = Utf8 ()V 
.const [257] = Utf8 deinit 
.const [258] = Utf8 ()V 
.const [259] = Utf8 enqueueResultNotification 
.const [260] = Utf8 (Ljava/lang/Runnable;)V 
.const [261] = Utf8 addingService 
.const [262] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [263] = Utf8 setCombiBapService 
.const [264] = Utf8 (Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone;)V 
.const [265] = Utf8 modifiedService 
.const [266] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [267] = Utf8 removedService 
.const [268] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [269] = Utf8 getCombiBapServicePhone 
.const [270] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone; 
.const [271] = Utf8 updateGlobalTelephoneStateProperty 
.const [272] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [273] = Utf8 getTelephoneState 
.const [274] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [275] = Utf8 responseAbortNetworkRegistration 
.const [276] = Utf8 (II)V 
.const [277] = Utf8 responseAbortNetworkSearch 
.const [278] = Utf8 (II)V 
.const [279] = Utf8 responseAcceptCall 
.const [280] = Utf8 (II)V 
.const [281] = Utf8 responseCallForward 
.const [282] = Utf8 ([Lorg/dsi/ifc/telephoneng/CFResponseData;II)V 
.const [283] = Utf8 responseCallWaiting 
.const [284] = Utf8 (IIII)V 
.const [285] = Utf8 responseChangeSIMCode 
.const [286] = Utf8 (III)V 
.const [287] = Utf8 responseCLIR 
.const [288] = Utf8 (IIII)V 
.const [289] = Utf8 responseDialNumber 
.const [290] = Utf8 (IILorg/dsi/ifc/telephoneng/SuppServiceResponseStruct;I)V 
.const [291] = Utf8 responseDialOperator 
.const [292] = Utf8 (ILorg/dsi/ifc/telephoneng/SuppServiceResponseStruct;I)V 
.const [293] = Utf8 responseHangupCall 
.const [294] = Utf8 (II)V 
.const [295] = Utf8 responseJoinCalls 
.const [296] = Utf8 (II)V 
.const [297] = Utf8 responseNetworkRegistration 
.const [298] = Utf8 (II)V 
.const [299] = Utf8 responseNetworkSearch 
.const [300] = Utf8 ([Lorg/dsi/ifc/telephoneng/NetworkProvider;II)V 
.const [301] = Utf8 responseRestoreFactorySettings 
.const [302] = Utf8 (II)V 
.const [303] = Utf8 responseSendDTMF 
.const [304] = Utf8 (II)V 
.const [305] = Utf8 responseServiceCodeAbort 
.const [306] = Utf8 (II)V 
.const [307] = Utf8 responseSetAutomaticEmergencyCallActive 
.const [308] = Utf8 (II)V 
.const [309] = Utf8 responseSetAutomaticPinEntryActive 
.const [310] = Utf8 (II)V 
.const [311] = Utf8 responseSetAutomaticRedialActive 
.const [312] = Utf8 (II)V 
.const [313] = Utf8 responseSetCDMAThreeWayCallingSetting 
.const [314] = Utf8 (II)V 
.const [315] = Utf8 responseSetESIMActive 
.const [316] = Utf8 (II)V 
.const [317] = Utf8 responseSetHandsFreeMode 
.const [318] = Utf8 (II)V 
.const [319] = Utf8 responseSetMailboxContent 
.const [320] = Utf8 (II)V 
.const [321] = Utf8 responseSetMICMuteState 
.const [322] = Utf8 (II)V 
.const [323] = Utf8 responseSetNADMode 
.const [324] = Utf8 (III)V 
.const [325] = Utf8 responseSetOptimizationMode 
.const [326] = Utf8 (III)V 
.const [327] = Utf8 responseSetPhoneReminderSetting 
.const [328] = Utf8 (II)V 
.const [329] = Utf8 responseSetPhoneRingtone 
.const [330] = Utf8 (II)V 
.const [331] = Utf8 responseSetPrivacyMode 
.const [332] = Utf8 (II)V 
.const [333] = Utf8 responseSIMPINRequired 
.const [334] = Utf8 (II)V 
.const [335] = Utf8 responseSplitCall 
.const [336] = Utf8 (II)V 
.const [337] = Utf8 responseSwapCalls 
.const [338] = Utf8 (II)V 
.const [339] = Utf8 responseTelPower 
.const [340] = Utf8 (II)V 
.const [341] = Utf8 responseUnlockOtherSIM 
.const [342] = Utf8 (II)V 
.const [343] = Utf8 responseUnlockSIM 
.const [344] = Utf8 (IILorg/dsi/ifc/telephoneng/LockStateStruct;)V 
.const [345] = Utf8 responseChangeTopology 
.const [346] = Utf8 (II)V 
.const [347] = Utf8 responseSetSIMAliases 
.const [348] = Utf8 (II)V 
.const [349] = Utf8 responseCheckSIMPINCode 
.const [350] = Utf8 (II)V 
.const [351] = Utf8 responseRemoveOtherSIM 
.const [352] = Utf8 (II)V 
.const [353] = Utf8 class$ 
.const [354] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
