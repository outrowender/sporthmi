.version 50 0 
.class public super [302] 
.super [304] 
.implements [306] 
.implements [308] 
.field private [309] [310] 
.field [311] [312] 
.field private [313] [314] 
.field static synthetic [315] [316] 
.field static synthetic [317] [318] 

.method public [320] : [321] 
    .attribute [319] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     invokespecial [51] 
L7:     aload_0 
L8:     iconst_m1 
L9:     putfield [63] 
L12:    aload_0 
L13:    getstatic [5] 
L16:    putfield [64] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [322] : [323] 
    .attribute [319] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     iconst_1 
L5:     invokespecial [52] 
L8:     aload_0 
L9:     getstatic [5] 
L12:    putfield [64] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [324] : [325] 
    .attribute [319] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [40] 
L4:     ldc [6] 
L6:     ldc [7] 
L8:     aload_0 
L9:     getfield [39] 
L12:    i2l 
L13:    invokevirtual [41] 
L16:    pop 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [326] : [327] 
    .attribute [319] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [40] 
L4:     ldc [6] 
L6:     ldc [8] 
L8:     aload_0 
L9:     getfield [39] 
L12:    i2l 
L13:    invokevirtual [41] 
L16:    pop 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [328] : [329] 
    .attribute [319] .code stack 10 locals 1 
L0:     aload_0 
L1:     getfield [40] 
L4:     ldc [6] 
L6:     ldc [9] 
L8:     iload_1 
L9:     i2l 
L10:    iload_2 
L11:    i2l 
L12:    invokevirtual [42] 
L15:    pop 
L16:    aload_0 
L17:    iload_1 
L18:    invokevirtual [43] 
L21:    astore_3 
L22:    aload_3 
L23:    instanceof [10] 
L26:    ifeq L71 
L29:    aload_0 
L30:    getfield [44] 
L33:    invokeinterface [65] 0 
L38:    invokeinterface [66] 0 
L43:    new [67] 
L46:    dup 
L47:    iconst_0 
L48:    new [68] 
L51:    dup 
L52:    aload_0 
L53:    iload_1 
L54:    iload_2 
L55:    aconst_null 
L56:    invokespecial [53] 
L59:    invokespecial [54] 
L62:    invokeinterface [69] 0 
L67:    pop 
L68:    goto L86 
L71:    aload_0 
L72:    getfield [40] 
L75:    sipush 10000 
L78:    ldc [13] 
L80:    iload_1 
L81:    i2l 
L82:    invokevirtual [41] 
L85:    pop 
L86:    return 
L87:    nop 
L88:    
    .end code 
.end method 

.method public [330] : [331] 
    .attribute [319] .code stack 9 locals 1 
L0:     aload_0 
L1:     getfield [40] 
L4:     ldc [6] 
L6:     ldc [14] 
L8:     aload_0 
L9:     getfield [39] 
L12:    i2l 
L13:    invokevirtual [41] 
L16:    pop 
L17:    aload_0 
L18:    iload_1 
L19:    invokevirtual [43] 
L22:    astore_2 
L23:    aload_2 
L24:    instanceof [10] 
L27:    ifeq L71 
L30:    aload_0 
L31:    getfield [44] 
L34:    invokeinterface [65] 0 
L39:    invokeinterface [66] 0 
L44:    new [67] 
L47:    dup 
L48:    iconst_0 
L49:    new [70] 
L52:    dup 
L53:    aload_0 
L54:    iload_1 
L55:    aconst_null 
L56:    invokespecial [55] 
L59:    invokespecial [54] 
L62:    invokeinterface [69] 0 
L67:    pop 
L68:    goto L86 
L71:    aload_0 
L72:    getfield [40] 
L75:    sipush 10000 
L78:    ldc [16] 
L80:    iload_1 
L81:    i2l 
L82:    invokevirtual [41] 
L85:    pop 
L86:    return 
L87:    nop 
L88:    
    .end code 
.end method 

.method public [332] : [333] 
    .attribute [319] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [40] 
L4:     ldc [6] 
L6:     ldc [17] 
L8:     aload_2 
L9:     iload_1 
L10:    i2l 
L11:    invokevirtual [45] 
L14:    pop 
L15:    aload_0 
L16:    getfield [46] 
L19:    ifnull L40 
L22:    aload_0 
L23:    getfield [46] 
L26:    iload_1 
L27:    aload_2 
L28:    invokeinterface [71] 0 
L33:    aload_0 
L34:    iload_1 
L35:    putfield [63] 
L38:    iconst_1 
L39:    areturn 
L40:    aload_0 
L41:    getfield [40] 
L44:    sipush 10000 
L47:    ldc [18] 
L49:    invokevirtual [47] 
L52:    pop 
L53:    iconst_3 
L54:    areturn 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [334] : [335] 
    .attribute [319] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [40] 
L4:     ldc [6] 
L6:     ldc [19] 
L8:     iload_1 
L9:     i2l 
L10:    invokevirtual [41] 
L13:    pop 
L14:    aload_0 
L15:    getfield [46] 
L18:    ifnull L34 
L21:    aload_0 
L22:    getfield [46] 
L25:    iload_1 
L26:    invokeinterface [72] 0 
L31:    goto L47 
L34:    aload_0 
L35:    getfield [40] 
L38:    sipush 10000 
L41:    ldc [18] 
L43:    invokevirtual [47] 
L46:    pop 
L47:    iconst_0 
L48:    areturn 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [336] : [337] 
    .attribute [319] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [56] 
L4:     aload_0 
L5:     invokespecial [57] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [338] : [339] 
    .attribute [319] .code stack 7 locals 1 
L0:     new [73] 
L3:     dup 
L4:     aload_0 
L5:     getfield [37] 
L8:     getstatic [21] 
L11:    ifnonnull L26 
L14:    ldc [22] 
L16:    invokestatic [23] 
L19:    dup 
L20:    putstatic [58] 
L23:    goto L29 
L26:    getstatic [21] 
L29:    invokevirtual [48] 
L32:    new [74] 
L35:    dup 
L36:    aload_0 
L37:    invokespecial [59] 
L40:    invokespecial [60] 
L43:    astore_1 
L44:    aload_1 
L45:    invokevirtual [49] 
L48:    return 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [340] : [341] 
    .attribute [319] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [37] 
L4:     getstatic [25] 
L7:     ifnonnull L22 
L10:    ldc [26] 
L12:    invokestatic [23] 
L15:    dup 
L16:    putstatic [61] 
L19:    goto L25 
L22:    getstatic [25] 
L25:    invokevirtual [48] 
L28:    aload_0 
L29:    aconst_null 
L30:    invokeinterface [75] 0 
L35:    pop 
L36:    return 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method static synthetic [342] : [343] 
    .attribute [319] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [62] 
L9:     dup 
L10:    invokespecial [50] 
L13:    aload_1 
L14:    invokevirtual [38] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static synthetic [344] : [345] 
    .attribute [319] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [37] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [76] [77] 
.const [3] = Class [78] 
.const [4] = Class [79] 
.const [5] = Field [80] [81] 
.const [6] = Int 1078071040 
.const [7] = String [82] 
.const [8] = String [83] 
.const [9] = String [84] 
.const [10] = Class [85] 
.const [11] = Class [86] 
.const [12] = Class [87] 
.const [13] = String [88] 
.const [14] = String [89] 
.const [15] = Class [90] 
.const [16] = String [91] 
.const [17] = String [92] 
.const [18] = String [93] 
.const [19] = String [94] 
.const [20] = Class [95] 
.const [21] = Field [96] [97] 
.const [22] = String [98] 
.const [23] = Method [99] [100] 
.const [24] = Class [101] 
.const [25] = Field [102] [103] 
.const [26] = String [104] 
.const [27] = Class [105] 
.const [28] = Class [106] 
.const [29] = Class [107] 
.const [30] = Class [108] 
.const [31] = Class [109] 
.const [32] = Class [110] 
.const [33] = Class [111] 
.const [34] = Class [112] 
.const [35] = Class [113] 
.const [36] = Class [114] 
.const [37] = Field [115] [116] 
.const [38] = Method [117] [118] 
.const [39] = Field [119] [120] 
.const [40] = Field [121] [122] 
.const [41] = Method [123] [124] 
.const [42] = Method [125] [126] 
.const [43] = Method [127] [128] 
.const [44] = Field [129] [130] 
.const [45] = Method [131] [132] 
.const [46] = Field [133] [134] 
.const [47] = Method [135] [136] 
.const [48] = Method [137] [138] 
.const [49] = Method [139] [140] 
.const [50] = Method [141] [142] 
.const [51] = Method [143] [144] 
.const [52] = Method [145] [146] 
.const [53] = Method [147] [148] 
.const [54] = Method [149] [150] 
.const [55] = Method [151] [152] 
.const [56] = Method [153] [154] 
.const [57] = Method [155] [156] 
.const [58] = Field [157] [158] 
.const [59] = Method [159] [160] 
.const [60] = Method [161] [162] 
.const [61] = Field [163] [164] 
.const [62] = Class [165] 
.const [63] = Field [166] [167] 
.const [64] = Field [168] [169] 
.const [65] = InterfaceMethod [170] [171] 
.const [66] = InterfaceMethod [172] [173] 
.const [67] = Class [174] 
.const [68] = Class [175] 
.const [69] = InterfaceMethod [176] [177] 
.const [70] = Class [178] 
.const [71] = InterfaceMethod [179] [180] 
.const [72] = InterfaceMethod [181] [182] 
.const [73] = Class [183] 
.const [74] = Class [184] 
.const [75] = InterfaceMethod [185] [186] 
.const [76] = Class [187] 
.const [77] = NameAndType [188] [189] 
.const [78] = Utf8 java/lang/ClassNotFoundException 
.const [79] = Utf8 java/lang/NoClassDefFoundError 
.const [80] = Class [190] 
.const [81] = NameAndType [191] [192] 
.const [82] = Utf8 'PartialPopupManagerMMICombi#notifyPartialPopupVisible received, last requested pp via BAP is: %1' 
.const [83] = Utf8 'PartialPopupManagerMMICombi#notifyPartialPopupHidden received, last requested pp via BAP is: %1' 
.const [84] = Utf8 'PartialPopupManagerMMICombi#optionSelected received, popupID: %1, option: %2' 
.const [85] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/PartialPopupControllerMMICombi 
.const [86] = Utf8 de/audi/atip/hmi/event/RunnableEvent 
.const [87] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi$OptionSelectedJob 
.const [88] = Utf8 'PartialPopupManagerMMICombi#optionSelected received, but no popup with popupID: %1 registered' 
.const [89] = Utf8 'PartialPopupManagerMMICombi#cancelPopup received, last requested pp via BAP is: %1' 
.const [90] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi$PopupCanceledJob 
.const [91] = Utf8 'PartialPopupManagerMMICombi#cancelPopup received, but no popup with popupID: %1 registered' 
.const [92] = Utf8 'PartialPopupManagerMMICombi#showPPViaBAP id: %2, content %1' 
.const [93] = Utf8 'PartialPopupManagerMMICombi#showPPViaBAP no BAPService available' 
.const [94] = Utf8 'PartialPopupManagerMMICombi#hidePPViaBAP id: %1' 
.const [95] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [96] = Class [193] 
.const [97] = NameAndType [194] [195] 
.const [98] = Utf8 'de.audi.atip.interapp.combi.bap.PartialPopupBAPService' 
.const [99] = Class [196] 
.const [100] = NameAndType [197] [198] 
.const [101] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi$1 
.const [102] = Class [199] 
.const [103] = NameAndType [200] [201] 
.const [104] = Utf8 'de.audi.atip.interapp.combi.bap.PartialPopupBAPServiceListener' 
.const [105] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi 
.const [106] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerEvoHigh 
.const [107] = Utf8 java/lang/Class 
.const [108] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [109] = Utf8 de/audi/atip/log/LogChannel 
.const [110] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [111] = Utf8 de/audi/atip/hmi/HMIService 
.const [112] = Utf8 de/audi/atip/hmi/event/EventDispatcher 
.const [113] = Utf8 de/audi/atip/interapp/combi/bap/PartialPopupBAPService 
.const [114] = Utf8 org/osgi/framework/BundleContext 
.const [115] = Class [202] 
.const [116] = NameAndType [203] [204] 
.const [117] = Class [205] 
.const [118] = NameAndType [206] [207] 
.const [119] = Class [208] 
.const [120] = NameAndType [209] [210] 
.const [121] = Class [211] 
.const [122] = NameAndType [212] [213] 
.const [123] = Class [214] 
.const [124] = NameAndType [215] [216] 
.const [125] = Class [217] 
.const [126] = NameAndType [218] [219] 
.const [127] = Class [220] 
.const [128] = NameAndType [221] [222] 
.const [129] = Class [223] 
.const [130] = NameAndType [224] [225] 
.const [131] = Class [226] 
.const [132] = NameAndType [227] [228] 
.const [133] = Class [229] 
.const [134] = NameAndType [230] [231] 
.const [135] = Class [232] 
.const [136] = NameAndType [233] [234] 
.const [137] = Class [235] 
.const [138] = NameAndType [236] [237] 
.const [139] = Class [238] 
.const [140] = NameAndType [239] [240] 
.const [141] = Class [241] 
.const [142] = NameAndType [242] [243] 
.const [143] = Class [244] 
.const [144] = NameAndType [245] [246] 
.const [145] = Class [247] 
.const [146] = NameAndType [248] [249] 
.const [147] = Class [250] 
.const [148] = NameAndType [251] [252] 
.const [149] = Class [253] 
.const [150] = NameAndType [254] [255] 
.const [151] = Class [256] 
.const [152] = NameAndType [257] [258] 
.const [153] = Class [259] 
.const [154] = NameAndType [260] [261] 
.const [155] = Class [262] 
.const [156] = NameAndType [263] [264] 
.const [157] = Class [265] 
.const [158] = NameAndType [266] [267] 
.const [159] = Class [268] 
.const [160] = NameAndType [269] [270] 
.const [161] = Class [271] 
.const [162] = NameAndType [272] [273] 
.const [163] = Class [274] 
.const [164] = NameAndType [275] [276] 
.const [165] = Utf8 java/lang/NoClassDefFoundError 
.const [166] = Class [277] 
.const [167] = NameAndType [278] [279] 
.const [168] = Class [280] 
.const [169] = NameAndType [281] [282] 
.const [170] = Class [283] 
.const [171] = NameAndType [284] [285] 
.const [172] = Class [286] 
.const [173] = NameAndType [287] [288] 
.const [174] = Utf8 de/audi/atip/hmi/event/RunnableEvent 
.const [175] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi$OptionSelectedJob 
.const [176] = Class [289] 
.const [177] = NameAndType [290] [291] 
.const [178] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi$PopupCanceledJob 
.const [179] = Class [292] 
.const [180] = NameAndType [293] [294] 
.const [181] = Class [295] 
.const [182] = NameAndType [296] [297] 
.const [183] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [184] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi$1 
.const [185] = Class [298] 
.const [186] = NameAndType [299] [300] 
.const [187] = Utf8 java/lang/Class 
.const [188] = Utf8 forName 
.const [189] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [190] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [191] = Utf8 logChannelPPMMICombi 
.const [192] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [193] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi 
.const [194] = Utf8 class$de$audi$atip$interapp$combi$bap$PartialPopupBAPService 
.const [195] = Utf8 Ljava/lang/Class; 
.const [196] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi 
.const [197] = Utf8 class$ 
.const [198] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [199] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi 
.const [200] = Utf8 class$de$audi$atip$interapp$combi$bap$PartialPopupBAPServiceListener 
.const [201] = Utf8 Ljava/lang/Class; 
.const [202] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi 
.const [203] = Utf8 bundleContext 
.const [204] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [205] = Utf8 java/lang/NoClassDefFoundError 
.const [206] = Utf8 initCause 
.const [207] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [208] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi 
.const [209] = Utf8 currentRequestedPPViaBAP 
.const [210] = Utf8 I 
.const [211] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi 
.const [212] = Utf8 logPPMMICombi 
.const [213] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [214] = Utf8 de/audi/atip/log/LogChannel 
.const [215] = Utf8 log 
.const [216] = Utf8 (ILjava/lang/String;J)Z 
.const [217] = Utf8 de/audi/atip/log/LogChannel 
.const [218] = Utf8 log 
.const [219] = Utf8 (ILjava/lang/String;JJ)Z 
.const [220] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi 
.const [221] = Utf8 getPartialPopup 
.const [222] = Utf8 (I)Lde/audi/atip/hmi/view/IPartialPopupController; 
.const [223] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi 
.const [224] = Utf8 framework 
.const [225] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [226] = Utf8 de/audi/atip/log/LogChannel 
.const [227] = Utf8 log 
.const [228] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [229] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi 
.const [230] = Utf8 bAPService 
.const [231] = Utf8 Lde/audi/atip/interapp/combi/bap/PartialPopupBAPService; 
.const [232] = Utf8 de/audi/atip/log/LogChannel 
.const [233] = Utf8 log 
.const [234] = Utf8 (ILjava/lang/String;)Z 
.const [235] = Utf8 java/lang/Class 
.const [236] = Utf8 getName 
.const [237] = Utf8 ()Ljava/lang/String; 
.const [238] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [239] = Utf8 'open' 
.const [240] = Utf8 ()V 
.const [241] = Utf8 java/lang/NoClassDefFoundError 
.const [242] = Utf8 <init> 
.const [243] = Utf8 ()V 
.const [244] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerEvoHigh 
.const [245] = Utf8 <init> 
.const [246] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/HMITerminalImpl;Lorg/osgi/framework/BundleContext;Lde/audi/atip/base/IFrameworkAccess;)V 
.const [247] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi 
.const [248] = Utf8 <init> 
.const [249] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/HMITerminalImpl;Lorg/osgi/framework/BundleContext;Lde/audi/atip/base/IFrameworkAccess;Z)V 
.const [250] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi$OptionSelectedJob 
.const [251] = Utf8 <init> 
.const [252] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi;IILde/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi$1;)V 
.const [253] = Utf8 de/audi/atip/hmi/event/RunnableEvent 
.const [254] = Utf8 <init> 
.const [255] = Utf8 (ZLjava/lang/Runnable;)V 
.const [256] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi$PopupCanceledJob 
.const [257] = Utf8 <init> 
.const [258] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi;ILde/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi$1;)V 
.const [259] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi 
.const [260] = Utf8 initializeBAPServiceTracker 
.const [261] = Utf8 ()V 
.const [262] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerEvoHigh 
.const [263] = Utf8 startTrackingServices 
.const [264] = Utf8 ()V 
.const [265] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi 
.const [266] = Utf8 class$de$audi$atip$interapp$combi$bap$PartialPopupBAPService 
.const [267] = Utf8 Ljava/lang/Class; 
.const [268] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi$1 
.const [269] = Utf8 <init> 
.const [270] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi;)V 
.const [271] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [272] = Utf8 <init> 
.const [273] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [274] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi 
.const [275] = Utf8 class$de$audi$atip$interapp$combi$bap$PartialPopupBAPServiceListener 
.const [276] = Utf8 Ljava/lang/Class; 
.const [277] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi 
.const [278] = Utf8 currentRequestedPPViaBAP 
.const [279] = Utf8 I 
.const [280] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi 
.const [281] = Utf8 logPPMMICombi 
.const [282] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [283] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [284] = Utf8 getHMIService 
.const [285] = Utf8 ()Lde/audi/atip/hmi/HMIService; 
.const [286] = Utf8 de/audi/atip/hmi/HMIService 
.const [287] = Utf8 getEventDispatcher 
.const [288] = Utf8 ()Lde/audi/atip/hmi/event/EventDispatcher; 
.const [289] = Utf8 de/audi/atip/hmi/event/EventDispatcher 
.const [290] = Utf8 postEvent 
.const [291] = Utf8 (Lde/audi/atip/hmi/event/ATIPEvent;)Lde/esolutions/fw/util/commons/job/Job; 
.const [292] = Utf8 de/audi/atip/interapp/combi/bap/PartialPopupBAPService 
.const [293] = Utf8 showPartialPopup 
.const [294] = Utf8 (ILde/audi/atip/interapp/combi/bap/data/PartialPopupBAPContent;)V 
.const [295] = Utf8 de/audi/atip/interapp/combi/bap/PartialPopupBAPService 
.const [296] = Utf8 hidePartialPopup 
.const [297] = Utf8 (I)V 
.const [298] = Utf8 org/osgi/framework/BundleContext 
.const [299] = Utf8 registerService 
.const [300] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [301] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi 
.const [302] = Class [301] 
.const [303] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerEvoHigh 
.const [304] = Class [303] 
.const [305] = Utf8 de/audi/atip/hmi/view/IPartialPopupManager 
.const [306] = Class [305] 
.const [307] = Utf8 de/audi/atip/interapp/combi/bap/PartialPopupBAPServiceListener 
.const [308] = Class [307] 
.const [309] = Utf8 logPPMMICombi 
.const [310] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [311] = Utf8 bAPService 
.const [312] = Utf8 Lde/audi/atip/interapp/combi/bap/PartialPopupBAPService; 
.const [313] = Utf8 currentRequestedPPViaBAP 
.const [314] = Utf8 I 
.const [315] = Utf8 class$de$audi$atip$interapp$combi$bap$PartialPopupBAPService 
.const [316] = Utf8 Ljava/lang/Class; 
.const [317] = Utf8 class$de$audi$atip$interapp$combi$bap$PartialPopupBAPServiceListener 
.const [318] = Utf8 Ljava/lang/Class; 
.const [319] = Utf8 Code 
.const [320] = Utf8 <init> 
.const [321] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/HMITerminalImpl;Lorg/osgi/framework/BundleContext;Lde/audi/atip/base/IFrameworkAccess;Z)V 
.const [322] = Utf8 <init> 
.const [323] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/HMITerminalImpl;Lorg/osgi/framework/BundleContext;Lde/audi/atip/base/IFrameworkAccess;)V 
.const [324] = Utf8 notifyPartialPopupVisible 
.const [325] = Utf8 ()V 
.const [326] = Utf8 notifyPartialPopupHidden 
.const [327] = Utf8 ()V 
.const [328] = Utf8 optionSelected 
.const [329] = Utf8 (II)V 
.const [330] = Utf8 cancelPopup 
.const [331] = Utf8 (I)V 
.const [332] = Utf8 showPPViaBAP 
.const [333] = Utf8 (ILde/audi/atip/interapp/combi/bap/data/PartialPopupBAPContent;)I 
.const [334] = Utf8 hidePPViaBAP 
.const [335] = Utf8 (I)I 
.const [336] = Utf8 startTrackingServices 
.const [337] = Utf8 ()V 
.const [338] = Utf8 initializeBAPServiceTracker 
.const [339] = Utf8 ()V 
.const [340] = Utf8 registerServices 
.const [341] = Utf8 ()V 
.const [342] = Utf8 class$ 
.const [343] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [344] = Utf8 access$200 
.const [345] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/high/PartialPopupManagerMMICombi;)Lorg/osgi/framework/BundleContext; 
.end class 
