.version 50 0 
.class super abstract [272] 
.super [274] 
.implements [276] 
.field private volatile [277] [278] 
.field private volatile [279] [280] 
.field private volatile [281] [282] 
.field private final [283] [284] 
.field static synthetic [285] [286] 

.method [288] : [289] 
    .attribute [287] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [5] 
L4:     invokespecial [43] 
L7:     aload_0 
L8:     aload_2 
L9:     putfield [50] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [290] : [291] 
    .attribute [287] .code stack 7 locals 0 
L0:     aload_0 
L1:     new [51] 
L4:     dup 
L5:     aload_0 
L6:     invokevirtual [28] 
L9:     invokeinterface [52] 0 
L14:    getstatic [7] 
L17:    ifnonnull L32 
L20:    ldc [8] 
L22:    invokestatic [9] 
L25:    dup 
L26:    putstatic [44] 
L29:    goto L35 
L32:    getstatic [7] 
L35:    invokevirtual [29] 
L38:    aload_0 
L39:    aload_0 
L40:    getfield [30] 
L43:    invokespecial [45] 
L46:    putfield [53] 
L49:    aload_0 
L50:    getfield [31] 
L53:    invokevirtual [32] 
L56:    aload_0 
L57:    invokevirtual [28] 
L60:    invokeinterface [54] 0 
L65:    aload_0 
L66:    invokeinterface [55] 0 
L71:    return 
L72:    
    .end code 
.end method 

.method public [292] : [293] 
    .attribute [287] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [31] 
L4:     ifnull L19 
L7:     aload_0 
L8:     getfield [31] 
L11:    invokevirtual [33] 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [53] 
L19:    aload_0 
L20:    invokevirtual [28] 
L23:    invokeinterface [54] 0 
L28:    aload_0 
L29:    invokeinterface [56] 0 
L34:    return 
L35:    nop 
L36:    
    .end code 
.end method 

.method private [294] : [295] 
    .attribute [287] .code stack 4 locals 0 
L0:     aload_0 
L1:     new [57] 
L4:     dup 
L5:     aload_0 
L6:     invokespecial [46] 
L9:     invokespecial [47] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method private [296] : [297] 
    .attribute [287] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [27] 
L4:     aload_1 
L5:     invokevirtual [34] 
L8:     pop 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [298] : [299] 
    .attribute [287] .code stack 3 locals 1 
L0:     aload_1 
L1:     ifnonnull L19 
L4:     aload_0 
L5:     getfield [30] 
L8:     sipush 10000 
L11:    ldc [11] 
L13:    invokevirtual [35] 
L16:    pop 
L17:    aconst_null 
L18:    areturn 
L19:    aload_0 
L20:    invokevirtual [28] 
L23:    invokeinterface [52] 0 
L28:    aload_1 
L29:    invokeinterface [58] 0 
L34:    astore_2 
L35:    aload_2 
L36:    ifnonnull L54 
L39:    aload_0 
L40:    getfield [30] 
L43:    sipush 10000 
L46:    ldc [12] 
L48:    invokevirtual [35] 
L51:    pop 
L52:    aconst_null 
L53:    areturn 
L54:    getstatic [7] 
L57:    ifnonnull L72 
L60:    ldc [8] 
L62:    invokestatic [9] 
L65:    dup 
L66:    putstatic [44] 
L69:    goto L75 
L72:    getstatic [7] 
L75:    aload_2 
L76:    invokevirtual [36] 
L79:    ifeq L92 
L82:    aload_0 
L83:    aload_2 
L84:    checkcast [13] 
L87:    invokevirtual [37] 
L90:    aload_2 
L91:    areturn 
L92:    aload_0 
L93:    invokevirtual [28] 
L96:    invokeinterface [52] 0 
L101:   aload_1 
L102:   invokeinterface [59] 0 
L107:   pop 
L108:   aconst_null 
L109:   areturn 
L110:   nop 
L111:   nop 
L112:   
    .end code 
.end method 

.method public enum [300] : [301] 
    .attribute [287] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [302] : [303] 
    .attribute [287] .code stack 2 locals 0 
L0:     getstatic [7] 
L3:     ifnonnull L18 
L6:     ldc [8] 
L8:     invokestatic [9] 
L11:    dup 
L12:    putstatic [44] 
L15:    goto L21 
L18:    getstatic [7] 
L21:    aload_2 
L22:    invokevirtual [36] 
L25:    ifeq L49 
L28:    aload_0 
L29:    aconst_null 
L30:    invokevirtual [37] 
L33:    aload_0 
L34:    invokevirtual [28] 
L37:    invokeinterface [52] 0 
L42:    aload_1 
L43:    invokeinterface [59] 0 
L48:    pop 
L49:    return 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [304] : [305] 
    .attribute [287] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_2 
L2:     invokevirtual [38] 
L5:     aload_2 
L6:     ifnonnull L23 
L9:     aload_0 
L10:    getfield [30] 
L13:    sipush 10000 
L16:    ldc [14] 
L18:    invokevirtual [35] 
L21:    pop 
L22:    return 
L23:    aload_0 
L24:    iload_1 
L25:    aload_2 
L26:    invokevirtual [39] 
L29:    ifeq L36 
L32:    aload_0 
L33:    invokespecial [48] 
L36:    return 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method protected interface [306] : [307] 
    .attribute [287] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [40] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [308] : [309] 
    .attribute [287] .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield [40] 
L4:     astore_1 
L5:     aload_1 
L6:     ifnull L18 
L9:     aload_1 
L10:    invokeinterface [61] 0 
L15:    goto L19 
L18:    aconst_null 
L19:    areturn 
L20:    
    .end code 
.end method 

.method public [310] : [311] 
    .attribute [287] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [62] 
L5:     aload_1 
L6:     ifnull L16 
L9:     aload_0 
L10:    invokespecial [48] 
L13:    goto L28 
L16:    aload_0 
L17:    getfield [30] 
L20:    ldc [15] 
L22:    ldc [16] 
L24:    invokevirtual [35] 
L27:    pop 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method [312] : [313] 
    .attribute [287] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [62] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected interface [314] : [315] 
    .attribute [287] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [41] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected abstract [316] : [317] 
    .attribute [287] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [318] : [319] 
    .attribute [287] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [320] : [321] 
    .attribute [287] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [60] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [322] : [323] 
    .attribute [287] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [49] 
L9:     dup 
L10:    invokespecial [42] 
L13:    aload_1 
L14:    invokevirtual [26] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [63] [64] 
.const [3] = Class [65] 
.const [4] = Class [66] 
.const [5] = String [67] 
.const [6] = Class [68] 
.const [7] = Field [69] [70] 
.const [8] = String [71] 
.const [9] = Method [72] [73] 
.const [10] = Class [74] 
.const [11] = String [75] 
.const [12] = String [76] 
.const [13] = Class [77] 
.const [14] = String [78] 
.const [15] = Int -1601830656 
.const [16] = String [79] 
.const [17] = Class [80] 
.const [18] = Class [81] 
.const [19] = Class [82] 
.const [20] = Class [83] 
.const [21] = Class [84] 
.const [22] = Class [85] 
.const [23] = Class [86] 
.const [24] = Class [87] 
.const [25] = Class [88] 
.const [26] = Method [89] [90] 
.const [27] = Field [91] [92] 
.const [28] = Method [93] [94] 
.const [29] = Method [95] [96] 
.const [30] = Field [97] [98] 
.const [31] = Field [99] [100] 
.const [32] = Method [101] [102] 
.const [33] = Method [103] [104] 
.const [34] = Method [105] [106] 
.const [35] = Method [107] [108] 
.const [36] = Method [109] [110] 
.const [37] = Method [111] [112] 
.const [38] = Method [113] [114] 
.const [39] = Method [115] [116] 
.const [40] = Field [117] [118] 
.const [41] = Field [119] [120] 
.const [42] = Method [121] [122] 
.const [43] = Method [123] [124] 
.const [44] = Field [125] [126] 
.const [45] = Method [127] [128] 
.const [46] = Method [129] [130] 
.const [47] = Method [131] [132] 
.const [48] = Method [133] [134] 
.const [49] = Class [135] 
.const [50] = Field [136] [137] 
.const [51] = Class [138] 
.const [52] = InterfaceMethod [139] [140] 
.const [53] = Field [141] [142] 
.const [54] = InterfaceMethod [143] [144] 
.const [55] = InterfaceMethod [145] [146] 
.const [56] = InterfaceMethod [147] [148] 
.const [57] = Class [149] 
.const [58] = InterfaceMethod [150] [151] 
.const [59] = InterfaceMethod [152] [153] 
.const [60] = Field [154] [155] 
.const [61] = InterfaceMethod [156] [157] 
.const [62] = Field [158] [159] 
.const [63] = Class [160] 
.const [64] = NameAndType [161] [162] 
.const [65] = Utf8 java/lang/ClassNotFoundException 
.const [66] = Utf8 java/lang/NoClassDefFoundError 
.const [67] = Utf8 'App.Phone.BAP' 
.const [68] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [69] = Class [163] 
.const [70] = NameAndType [164] [165] 
.const [71] = Utf8 'de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone2' 
.const [72] = Class [166] 
.const [73] = NameAndType [167] [168] 
.const [74] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler$1 
.const [75] = Utf8 'AbstractTel2EnqueuedBAPPropertyHandler#addingService reference is null' 
.const [76] = Utf8 'AbstractTel2EnqueuedBAPPropertyHandler#addingService service is null' 
.const [77] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone2 
.const [78] = Utf8 'AbstractTel2EnqueuedBAPPropertyHandler#updateGlobalTelephoneStateProperty stateStruct is null' 
.const [79] = Utf8 'AbstractTel2EnqueuedBAPPropertyHandler#setBAPServiceAndSendUpdate service is null' 
.const [80] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler 
.const [81] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [82] = Utf8 java/lang/Class 
.const [83] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [84] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [85] = Utf8 de/esolutions/fw/util/commons/job/DispatcherBase 
.const [86] = Utf8 de/audi/atip/log/LogChannel 
.const [87] = Utf8 org/osgi/framework/BundleContext 
.const [88] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [89] = Class [169] 
.const [90] = NameAndType [170] [171] 
.const [91] = Class [172] 
.const [92] = NameAndType [173] [174] 
.const [93] = Class [175] 
.const [94] = NameAndType [176] [177] 
.const [95] = Class [178] 
.const [96] = NameAndType [179] [180] 
.const [97] = Class [181] 
.const [98] = NameAndType [182] [183] 
.const [99] = Class [184] 
.const [100] = NameAndType [185] [186] 
.const [101] = Class [187] 
.const [102] = NameAndType [188] [189] 
.const [103] = Class [190] 
.const [104] = NameAndType [191] [192] 
.const [105] = Class [193] 
.const [106] = NameAndType [194] [195] 
.const [107] = Class [196] 
.const [108] = NameAndType [197] [198] 
.const [109] = Class [199] 
.const [110] = NameAndType [200] [201] 
.const [111] = Class [202] 
.const [112] = NameAndType [203] [204] 
.const [113] = Class [205] 
.const [114] = NameAndType [206] [207] 
.const [115] = Class [208] 
.const [116] = NameAndType [209] [210] 
.const [117] = Class [211] 
.const [118] = NameAndType [212] [213] 
.const [119] = Class [214] 
.const [120] = NameAndType [215] [216] 
.const [121] = Class [217] 
.const [122] = NameAndType [218] [219] 
.const [123] = Class [220] 
.const [124] = NameAndType [221] [222] 
.const [125] = Class [223] 
.const [126] = NameAndType [224] [225] 
.const [127] = Class [226] 
.const [128] = NameAndType [227] [228] 
.const [129] = Class [229] 
.const [130] = NameAndType [230] [231] 
.const [131] = Class [232] 
.const [132] = NameAndType [233] [234] 
.const [133] = Class [235] 
.const [134] = NameAndType [236] [237] 
.const [135] = Utf8 java/lang/NoClassDefFoundError 
.const [136] = Class [238] 
.const [137] = NameAndType [239] [240] 
.const [138] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [139] = Class [241] 
.const [140] = NameAndType [242] [243] 
.const [141] = Class [244] 
.const [142] = NameAndType [245] [246] 
.const [143] = Class [247] 
.const [144] = NameAndType [248] [249] 
.const [145] = Class [250] 
.const [146] = NameAndType [251] [252] 
.const [147] = Class [253] 
.const [148] = NameAndType [254] [255] 
.const [149] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler$1 
.const [150] = Class [256] 
.const [151] = NameAndType [257] [258] 
.const [152] = Class [259] 
.const [153] = NameAndType [260] [261] 
.const [154] = Class [262] 
.const [155] = NameAndType [263] [264] 
.const [156] = Class [265] 
.const [157] = NameAndType [266] [267] 
.const [158] = Class [268] 
.const [159] = NameAndType [269] [270] 
.const [160] = Utf8 java/lang/Class 
.const [161] = Utf8 forName 
.const [162] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [163] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler 
.const [164] = Utf8 class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone2 
.const [165] = Utf8 Ljava/lang/Class; 
.const [166] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler 
.const [167] = Utf8 class$ 
.const [168] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [169] = Utf8 java/lang/NoClassDefFoundError 
.const [170] = Utf8 initCause 
.const [171] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [172] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler 
.const [173] = Utf8 bapCombiDispatcher 
.const [174] = Utf8 Lde/esolutions/fw/util/commons/job/DispatcherBase; 
.const [175] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler 
.const [176] = Utf8 getApplication 
.const [177] = Utf8 ()Lde/audi/app/phone/core/ITelApplication; 
.const [178] = Utf8 java/lang/Class 
.const [179] = Utf8 getName 
.const [180] = Utf8 ()Ljava/lang/String; 
.const [181] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler 
.const [182] = Utf8 log 
.const [183] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [184] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler 
.const [185] = Utf8 bapServiceTracker 
.const [186] = Utf8 Lde/audi/app/phone/core/PhoneServiceTracker; 
.const [187] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [188] = Utf8 openTracker 
.const [189] = Utf8 ()V 
.const [190] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [191] = Utf8 closeTracker 
.const [192] = Utf8 ()V 
.const [193] = Utf8 de/esolutions/fw/util/commons/job/DispatcherBase 
.const [194] = Utf8 execute 
.const [195] = Utf8 (Ljava/lang/Object;)Lde/esolutions/fw/util/commons/job/Job; 
.const [196] = Utf8 de/audi/atip/log/LogChannel 
.const [197] = Utf8 log 
.const [198] = Utf8 (ILjava/lang/String;)Z 
.const [199] = Utf8 java/lang/Class 
.const [200] = Utf8 isInstance 
.const [201] = Utf8 (Ljava/lang/Object;)Z 
.const [202] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler 
.const [203] = Utf8 setBAPServiceAndSendUpdate 
.const [204] = Utf8 (Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone2;)V 
.const [205] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler 
.const [206] = Utf8 setTelephoneState 
.const [207] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [208] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler 
.const [209] = Utf8 doProcessGlobalTelephoneStateUpdate 
.const [210] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)Z 
.const [211] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler 
.const [212] = Utf8 telephoneState 
.const [213] = Utf8 Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [214] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler 
.const [215] = Utf8 combiService 
.const [216] = Utf8 Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone2; 
.const [217] = Utf8 java/lang/NoClassDefFoundError 
.const [218] = Utf8 <init> 
.const [219] = Utf8 ()V 
.const [220] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [221] = Utf8 <init> 
.const [222] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Ljava/lang/String;)V 
.const [223] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler 
.const [224] = Utf8 class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone2 
.const [225] = Utf8 Ljava/lang/Class; 
.const [226] = Utf8 de/audi/app/phone/core/PhoneServiceTracker 
.const [227] = Utf8 <init> 
.const [228] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;Lde/audi/atip/log/LogChannel;)V 
.const [229] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler$1 
.const [230] = Utf8 <init> 
.const [231] = Utf8 (Lde/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler;)V 
.const [232] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler 
.const [233] = Utf8 scheduleExecution 
.const [234] = Utf8 (Ljava/lang/Runnable;)V 
.const [235] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler 
.const [236] = Utf8 enqueueUpdate 
.const [237] = Utf8 ()V 
.const [238] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler 
.const [239] = Utf8 bapCombiDispatcher 
.const [240] = Utf8 Lde/esolutions/fw/util/commons/job/DispatcherBase; 
.const [241] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [242] = Utf8 getBundleContext 
.const [243] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [244] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler 
.const [245] = Utf8 bapServiceTracker 
.const [246] = Utf8 Lde/audi/app/phone/core/PhoneServiceTracker; 
.const [247] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [248] = Utf8 getGlobalTelephoneStateManager 
.const [249] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneState; 
.const [250] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [251] = Utf8 registerListener 
.const [252] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateListener;)V 
.const [253] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [254] = Utf8 removeListener 
.const [255] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateListener;)V 
.const [256] = Utf8 org/osgi/framework/BundleContext 
.const [257] = Utf8 getService 
.const [258] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [259] = Utf8 org/osgi/framework/BundleContext 
.const [260] = Utf8 ungetService 
.const [261] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [262] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler 
.const [263] = Utf8 telephoneState 
.const [264] = Utf8 Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [265] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [266] = Utf8 getCallLeadingDevice 
.const [267] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [268] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler 
.const [269] = Utf8 combiService 
.const [270] = Utf8 Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone2; 
.const [271] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler 
.const [272] = Class [271] 
.const [273] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [274] = Class [273] 
.const [275] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [276] = Class [275] 
.const [277] = Utf8 bapServiceTracker 
.const [278] = Utf8 Lde/audi/app/phone/core/PhoneServiceTracker; 
.const [279] = Utf8 telephoneState 
.const [280] = Utf8 Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [281] = Utf8 combiService 
.const [282] = Utf8 Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone2; 
.const [283] = Utf8 bapCombiDispatcher 
.const [284] = Utf8 Lde/esolutions/fw/util/commons/job/DispatcherBase; 
.const [285] = Utf8 class$de$audi$atip$interapp$combi$bap$phone$CombiBAPServicePhone2 
.const [286] = Utf8 Ljava/lang/Class; 
.const [287] = Utf8 Code 
.const [288] = Utf8 <init> 
.const [289] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [290] = Utf8 init 
.const [291] = Utf8 ()V 
.const [292] = Utf8 deinit 
.const [293] = Utf8 ()V 
.const [294] = Utf8 enqueueUpdate 
.const [295] = Utf8 ()V 
.const [296] = Utf8 scheduleExecution 
.const [297] = Utf8 (Ljava/lang/Runnable;)V 
.const [298] = Utf8 addingService 
.const [299] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [300] = Utf8 modifiedService 
.const [301] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [302] = Utf8 removedService 
.const [303] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [304] = Utf8 updateGlobalTelephoneStateProperty 
.const [305] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [306] = Utf8 getTelephoneState 
.const [307] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [308] = Utf8 getCallLeadingDeviceState 
.const [309] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [310] = Utf8 setBAPServiceAndSendUpdate 
.const [311] = Utf8 (Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone2;)V 
.const [312] = Utf8 setBAPService 
.const [313] = Utf8 (Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone2;)V 
.const [314] = Utf8 getCombiService 
.const [315] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone2; 
.const [316] = Utf8 doProcessGlobalTelephoneStateUpdate 
.const [317] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)Z 
.const [318] = Utf8 updateAsync 
.const [319] = Utf8 ()V 
.const [320] = Utf8 setTelephoneState 
.const [321] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [322] = Utf8 class$ 
.const [323] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
