.version 50 0 
.class super [226] 
.super [228] 
.implements [230] 
.field public static final [231] [232] 
.field private [233] [234] 
.field private [235] [236] 
.field private final [237] [238] 
.field private final [239] [240] 
.field private volatile [241] [242] 
.field private final [243] [244] 
.field private final synthetic [245] [246] 

.method public [248] : [249] 
    .attribute [247] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [40] 
L5:     aload_0 
L6:     invokespecial [37] 
L9:     aload_0 
L10:    iconst_m1 
L11:    putfield [41] 
L14:    aload_0 
L15:    iconst_0 
L16:    putfield [42] 
L19:    aload_0 
L20:    new [43] 
L23:    dup 
L24:    invokespecial [37] 
L27:    putfield [44] 
L30:    aload_0 
L31:    aload_2 
L32:    putfield [45] 
L35:    aload_0 
L36:    aload_3 
L37:    putfield [46] 
L40:    aload_0 
L41:    iload 4 
L43:    putfield [41] 
L46:    return 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [250] : [251] 
    .attribute [247] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [26] 
L4:     iconst_m1 
L5:     if_icmpne L32 
L8:     aload_0 
L9:     getfield [30] 
L12:    sipush 10000 
L15:    ldc [3] 
L17:    aload_0 
L18:    getfield [25] 
L21:    invokestatic [4] 
L24:    i2l 
L25:    invokevirtual [31] 
L28:    pop 
L29:    goto L107 
L32:    aload_0 
L33:    getfield [28] 
L36:    dup 
L37:    astore_1 
L38:    monitorenter 
        .catch [0] from L39 to L99 using L102 
L39:    aload_0 
L40:    getfield [27] 
L43:    ifne L85 
L46:    aload_0 
L47:    getfield [29] 
L50:    invokeinterface [47] 0 
L55:    invokeinterface [48] 0 
L60:    iconst_0 
L61:    aload_0 
L62:    getfield [26] 
L65:    invokeinterface [49] 0 
L70:    aload_0 
L71:    getfield [30] 
L74:    ldc [5] 
L76:    ldc [6] 
L78:    invokevirtual [32] 
L81:    pop 
L82:    goto L97 
L85:    aload_0 
L86:    getfield [30] 
L89:    ldc [5] 
L91:    ldc [7] 
L93:    invokevirtual [32] 
L96:    pop 
L97:    aload_1 
L98:    monitorexit 
L99:    goto L107 
        .catch [0] from L102 to L105 using L102 
L102:   astore_2 
L103:   aload_1 
L104:   monitorexit 
L105:   aload_2 
L106:   athrow 
L107:   return 
L108:   
    .end code 
.end method 

.method public [252] : [253] 
    .attribute [247] .code stack 3 locals 2 
L0:     aload_0 
L1:     getfield [28] 
L4:     dup 
L5:     astore_1 
L6:     monitorenter 
        .catch [0] from L7 to L67 using L70 
L7:     aload_0 
L8:     getfield [27] 
L11:    ifeq L53 
L14:    aload_0 
L15:    getfield [29] 
L18:    invokeinterface [47] 0 
L23:    invokeinterface [48] 0 
L28:    iconst_0 
L29:    aload_0 
L30:    getfield [26] 
L33:    invokeinterface [50] 0 
L38:    aload_0 
L39:    getfield [30] 
L42:    ldc [5] 
L44:    ldc [8] 
L46:    invokevirtual [32] 
L49:    pop 
L50:    goto L65 
L53:    aload_0 
L54:    getfield [30] 
L57:    ldc [5] 
L59:    ldc [9] 
L61:    invokevirtual [32] 
L64:    pop 
L65:    aload_1 
L66:    monitorexit 
L67:    goto L75 
        .catch [0] from L70 to L73 using L70 
L70:    astore_2 
L71:    aload_1 
L72:    monitorexit 
L73:    aload_2 
L74:    athrow 
L75:    return 
L76:    
    .end code 
.end method 

.method public [254] : [255] 
    .attribute [247] .code stack 8 locals 0 
L0:     aload_0 
L1:     new [51] 
L4:     dup 
L5:     getstatic [11] 
L8:     ifnonnull L23 
L11:    ldc [12] 
L13:    invokestatic [13] 
L16:    dup 
L17:    putstatic [38] 
L20:    goto L26 
L23:    getstatic [11] 
L26:    invokevirtual [33] 
L29:    aload_0 
L30:    aconst_null 
L31:    aload_0 
L32:    getfield [29] 
L35:    invokeinterface [52] 0 
L40:    aload_0 
L41:    getfield [30] 
L44:    invokespecial [39] 
L47:    putfield [53] 
L50:    aload_0 
L51:    getfield [34] 
L54:    invokevirtual [35] 
L57:    aload_0 
L58:    getfield [30] 
L61:    ldc [5] 
L63:    ldc [14] 
L65:    invokevirtual [32] 
L68:    pop 
L69:    return 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [256] : [257] 
    .attribute [247] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [34] 
L4:     invokevirtual [36] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [258] : [259] 
    .attribute [247] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [30] 
L4:     ldc [5] 
L6:     ldc [15] 
L8:     iload_1 
L9:     i2l 
L10:    invokevirtual [31] 
L13:    pop 
L14:    aload_0 
L15:    getfield [28] 
L18:    dup 
L19:    astore_3 
L20:    monitorenter 
        .catch [0] from L21 to L28 using L31 
L21:    aload_0 
L22:    iconst_1 
L23:    putfield [42] 
L26:    aload_3 
L27:    monitorexit 
L28:    goto L38 
        .catch [0] from L31 to L35 using L31 
L31:    astore 4 
L33:    aload_3 
L34:    monitorexit 
L35:    aload 4 
L37:    athrow 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [260] : [261] 
    .attribute [247] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [30] 
L4:     ldc [5] 
L6:     ldc [16] 
L8:     iload_1 
L9:     i2l 
L10:    invokevirtual [31] 
L13:    pop 
L14:    aload_0 
L15:    getfield [28] 
L18:    dup 
L19:    astore_3 
L20:    monitorenter 
        .catch [0] from L21 to L56 using L59 
L21:    aload_0 
L22:    getfield [27] 
L25:    ifeq L54 
L28:    aload_0 
L29:    iconst_0 
L30:    putfield [42] 
L33:    aload_0 
L34:    getfield [29] 
L37:    invokeinterface [47] 0 
L42:    invokeinterface [48] 0 
L47:    iconst_0 
L48:    iload_1 
L49:    invokeinterface [50] 0 
L54:    aload_3 
L55:    monitorexit 
L56:    goto L66 
        .catch [0] from L59 to L63 using L59 
L59:    astore 4 
L61:    aload_3 
L62:    monitorexit 
L63:    aload 4 
L65:    athrow 
L66:    return 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [262] : [263] 
    .attribute [247] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     ldc [5] 
L6:     ldc [17] 
L8:     iload_1 
L9:     i2l 
L10:    invokevirtual [31] 
L13:    pop 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [264] : [265] 
    .attribute [247] .code stack 4 locals 0 
L0:     iconst_1 
L1:     newarray int 
L3:     dup 
L4:     iconst_0 
L5:     aload_0 
L6:     getfield [26] 
L9:     iastore 
L10:    areturn 
L11:    nop 
L12:    
    .end code 
.end method 

.method public enum [266] : [267] 
    .attribute [247] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [268] : [269] 
    .attribute [247] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [54] 
.const [3] = String [55] 
.const [4] = Method [56] [57] 
.const [5] = Int 1078071040 
.const [6] = String [58] 
.const [7] = String [59] 
.const [8] = String [60] 
.const [9] = String [61] 
.const [10] = Class [62] 
.const [11] = Field [63] [64] 
.const [12] = String [65] 
.const [13] = Method [66] [67] 
.const [14] = String [68] 
.const [15] = String [69] 
.const [16] = String [70] 
.const [17] = String [71] 
.const [18] = Class [72] 
.const [19] = Class [73] 
.const [20] = Class [74] 
.const [21] = Class [75] 
.const [22] = Class [76] 
.const [23] = Class [77] 
.const [24] = Class [78] 
.const [25] = Field [79] [80] 
.const [26] = Field [81] [82] 
.const [27] = Field [83] [84] 
.const [28] = Field [85] [86] 
.const [29] = Field [87] [88] 
.const [30] = Field [89] [90] 
.const [31] = Method [91] [92] 
.const [32] = Method [93] [94] 
.const [33] = Method [95] [96] 
.const [34] = Field [97] [98] 
.const [35] = Method [99] [100] 
.const [36] = Method [101] [102] 
.const [37] = Method [103] [104] 
.const [38] = Field [105] [106] 
.const [39] = Method [107] [108] 
.const [40] = Field [109] [110] 
.const [41] = Field [111] [112] 
.const [42] = Field [113] [114] 
.const [43] = Class [115] 
.const [44] = Field [116] [117] 
.const [45] = Field [118] [119] 
.const [46] = Field [120] [121] 
.const [47] = InterfaceMethod [122] [123] 
.const [48] = InterfaceMethod [124] [125] 
.const [49] = InterfaceMethod [126] [127] 
.const [50] = InterfaceMethod [128] [129] 
.const [51] = Class [130] 
.const [52] = InterfaceMethod [131] [132] 
.const [53] = Field [133] [134] 
.const [54] = Utf8 java/lang/Object 
.const [55] = Utf8 '[ImmediateOnPopupHandler#showPopup] No popup defined for config=%1' 
.const [56] = Class [135] 
.const [57] = NameAndType [136] [137] 
.const [58] = Utf8 '[ImmediateOnPopupHandler#showPopup] Requesting popup at HMI Service' 
.const [59] = Utf8 '[ImmediateOnPopupHandler#showPopup] Cannot request popup - already visible' 
.const [60] = Utf8 '[ImmediateOnPopupHandler#removePopup] Removing popup from HMI Service' 
.const [61] = Utf8 '[ImmediateOnPopupHandler#removePopup] Cannot remove popup - not visible' 
.const [62] = Utf8 de/audi/app/car/common/service/CarServiceProvider 
.const [63] = Class [138] 
.const [64] = NameAndType [139] [140] 
.const [65] = Utf8 'de.audi.atip.hmi.view.IPartialPopupListener' 
.const [66] = Class [141] 
.const [67] = NameAndType [142] [143] 
.const [68] = Utf8 '[ParkingPartialPopupHandler#initServiceProvider] Service provider initialized' 
.const [69] = Utf8 '[ImmediateOnPopupHandler#partialPopupVisible] partialPopupID = %1' 
.const [70] = Utf8 '[ImmediateOnPopupHandler#partialPopupHidden] partialPopupID = %1' 
.const [71] = Utf8 '[ImmediateOnPopupHandler#partialPopupRemoved] partialPopupID = %1' 
.const [72] = Utf8 de/audi/app/earlyfunc/hybrid/AuxACComponentEvo$ImmediateOnPopupHandler 
.const [73] = Utf8 de/audi/app/earlyfunc/hybrid/AuxACComponentEvo 
.const [74] = Utf8 de/audi/atip/log/LogChannel 
.const [75] = Utf8 de/audi/app/car/common/app/ICarApplication 
.const [76] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [77] = Utf8 de/audi/atip/hmi/HMIService 
.const [78] = Utf8 java/lang/Class 
.const [79] = Class [144] 
.const [80] = NameAndType [145] [146] 
.const [81] = Class [147] 
.const [82] = NameAndType [148] [149] 
.const [83] = Class [150] 
.const [84] = NameAndType [151] [152] 
.const [85] = Class [153] 
.const [86] = NameAndType [154] [155] 
.const [87] = Class [156] 
.const [88] = NameAndType [157] [158] 
.const [89] = Class [159] 
.const [90] = NameAndType [160] [161] 
.const [91] = Class [162] 
.const [92] = NameAndType [163] [164] 
.const [93] = Class [165] 
.const [94] = NameAndType [166] [167] 
.const [95] = Class [168] 
.const [96] = NameAndType [169] [170] 
.const [97] = Class [171] 
.const [98] = NameAndType [172] [173] 
.const [99] = Class [174] 
.const [100] = NameAndType [175] [176] 
.const [101] = Class [177] 
.const [102] = NameAndType [178] [179] 
.const [103] = Class [180] 
.const [104] = NameAndType [181] [182] 
.const [105] = Class [183] 
.const [106] = NameAndType [184] [185] 
.const [107] = Class [186] 
.const [108] = NameAndType [187] [188] 
.const [109] = Class [189] 
.const [110] = NameAndType [190] [191] 
.const [111] = Class [192] 
.const [112] = NameAndType [193] [194] 
.const [113] = Class [195] 
.const [114] = NameAndType [196] [197] 
.const [115] = Utf8 java/lang/Object 
.const [116] = Class [198] 
.const [117] = NameAndType [199] [200] 
.const [118] = Class [201] 
.const [119] = NameAndType [202] [203] 
.const [120] = Class [204] 
.const [121] = NameAndType [205] [206] 
.const [122] = Class [207] 
.const [123] = NameAndType [208] [209] 
.const [124] = Class [210] 
.const [125] = NameAndType [211] [212] 
.const [126] = Class [213] 
.const [127] = NameAndType [214] [215] 
.const [128] = Class [216] 
.const [129] = NameAndType [217] [218] 
.const [130] = Utf8 de/audi/app/car/common/service/CarServiceProvider 
.const [131] = Class [219] 
.const [132] = NameAndType [220] [221] 
.const [133] = Class [222] 
.const [134] = NameAndType [223] [224] 
.const [135] = Utf8 de/audi/app/earlyfunc/hybrid/AuxACComponentEvo 
.const [136] = Utf8 access$000 
.const [137] = Utf8 (Lde/audi/app/earlyfunc/hybrid/AuxACComponentEvo;)I 
.const [138] = Utf8 de/audi/app/earlyfunc/hybrid/AuxACComponentEvo 
.const [139] = Utf8 class$de$audi$atip$hmi$view$IPartialPopupListener 
.const [140] = Utf8 Ljava/lang/Class; 
.const [141] = Utf8 de/audi/app/earlyfunc/hybrid/AuxACComponentEvo 
.const [142] = Utf8 class$ 
.const [143] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [144] = Utf8 de/audi/app/earlyfunc/hybrid/AuxACComponentEvo$ImmediateOnPopupHandler 
.const [145] = Utf8 this$0 
.const [146] = Utf8 Lde/audi/app/earlyfunc/hybrid/AuxACComponentEvo; 
.const [147] = Utf8 de/audi/app/earlyfunc/hybrid/AuxACComponentEvo$ImmediateOnPopupHandler 
.const [148] = Utf8 popupID 
.const [149] = Utf8 I 
.const [150] = Utf8 de/audi/app/earlyfunc/hybrid/AuxACComponentEvo$ImmediateOnPopupHandler 
.const [151] = Utf8 popupVisible 
.const [152] = Utf8 Z 
.const [153] = Utf8 de/audi/app/earlyfunc/hybrid/AuxACComponentEvo$ImmediateOnPopupHandler 
.const [154] = Utf8 mutex 
.const [155] = Utf8 Ljava/lang/Object; 
.const [156] = Utf8 de/audi/app/earlyfunc/hybrid/AuxACComponentEvo$ImmediateOnPopupHandler 
.const [157] = Utf8 application 
.const [158] = Utf8 Lde/audi/app/car/common/app/ICarApplication; 
.const [159] = Utf8 de/audi/app/earlyfunc/hybrid/AuxACComponentEvo$ImmediateOnPopupHandler 
.const [160] = Utf8 logChannel 
.const [161] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [162] = Utf8 de/audi/atip/log/LogChannel 
.const [163] = Utf8 log 
.const [164] = Utf8 (ILjava/lang/String;J)Z 
.const [165] = Utf8 de/audi/atip/log/LogChannel 
.const [166] = Utf8 log 
.const [167] = Utf8 (ILjava/lang/String;)Z 
.const [168] = Utf8 java/lang/Class 
.const [169] = Utf8 getName 
.const [170] = Utf8 ()Ljava/lang/String; 
.const [171] = Utf8 de/audi/app/earlyfunc/hybrid/AuxACComponentEvo$ImmediateOnPopupHandler 
.const [172] = Utf8 partialPopupServiceProvider 
.const [173] = Utf8 Lde/audi/app/car/common/service/CarServiceProvider; 
.const [174] = Utf8 de/audi/app/car/common/service/CarServiceProvider 
.const [175] = Utf8 startService 
.const [176] = Utf8 ()V 
.const [177] = Utf8 de/audi/app/car/common/service/CarServiceProvider 
.const [178] = Utf8 stopService 
.const [179] = Utf8 ()V 
.const [180] = Utf8 java/lang/Object 
.const [181] = Utf8 <init> 
.const [182] = Utf8 ()V 
.const [183] = Utf8 de/audi/app/earlyfunc/hybrid/AuxACComponentEvo 
.const [184] = Utf8 class$de$audi$atip$hmi$view$IPartialPopupListener 
.const [185] = Utf8 Ljava/lang/Class; 
.const [186] = Utf8 de/audi/app/car/common/service/CarServiceProvider 
.const [187] = Utf8 <init> 
.const [188] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Hashtable;Lorg/osgi/framework/BundleContext;Lde/audi/atip/log/LogChannel;)V 
.const [189] = Utf8 de/audi/app/earlyfunc/hybrid/AuxACComponentEvo$ImmediateOnPopupHandler 
.const [190] = Utf8 this$0 
.const [191] = Utf8 Lde/audi/app/earlyfunc/hybrid/AuxACComponentEvo; 
.const [192] = Utf8 de/audi/app/earlyfunc/hybrid/AuxACComponentEvo$ImmediateOnPopupHandler 
.const [193] = Utf8 popupID 
.const [194] = Utf8 I 
.const [195] = Utf8 de/audi/app/earlyfunc/hybrid/AuxACComponentEvo$ImmediateOnPopupHandler 
.const [196] = Utf8 popupVisible 
.const [197] = Utf8 Z 
.const [198] = Utf8 de/audi/app/earlyfunc/hybrid/AuxACComponentEvo$ImmediateOnPopupHandler 
.const [199] = Utf8 mutex 
.const [200] = Utf8 Ljava/lang/Object; 
.const [201] = Utf8 de/audi/app/earlyfunc/hybrid/AuxACComponentEvo$ImmediateOnPopupHandler 
.const [202] = Utf8 application 
.const [203] = Utf8 Lde/audi/app/car/common/app/ICarApplication; 
.const [204] = Utf8 de/audi/app/earlyfunc/hybrid/AuxACComponentEvo$ImmediateOnPopupHandler 
.const [205] = Utf8 logChannel 
.const [206] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [207] = Utf8 de/audi/app/car/common/app/ICarApplication 
.const [208] = Utf8 getFrameworkAccess 
.const [209] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [210] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [211] = Utf8 getHMIService 
.const [212] = Utf8 ()Lde/audi/atip/hmi/HMIService; 
.const [213] = Utf8 de/audi/atip/hmi/HMIService 
.const [214] = Utf8 showPartialPopup 
.const [215] = Utf8 (II)V 
.const [216] = Utf8 de/audi/atip/hmi/HMIService 
.const [217] = Utf8 removePartialPopup 
.const [218] = Utf8 (II)V 
.const [219] = Utf8 de/audi/app/car/common/app/ICarApplication 
.const [220] = Utf8 getBundleContext 
.const [221] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [222] = Utf8 de/audi/app/earlyfunc/hybrid/AuxACComponentEvo$ImmediateOnPopupHandler 
.const [223] = Utf8 partialPopupServiceProvider 
.const [224] = Utf8 Lde/audi/app/car/common/service/CarServiceProvider; 
.const [225] = Utf8 de/audi/app/earlyfunc/hybrid/AuxACComponentEvo$ImmediateOnPopupHandler 
.const [226] = Class [225] 
.const [227] = Utf8 java/lang/Object 
.const [228] = Class [227] 
.const [229] = Utf8 de/audi/atip/hmi/view/IPartialPopupListener 
.const [230] = Class [229] 
.const [231] = Utf8 POPUP_INVALID 
.const [232] = Utf8 I 
.const [233] = Utf8 popupID 
.const [234] = Utf8 I 
.const [235] = Utf8 partialPopupServiceProvider 
.const [236] = Utf8 Lde/audi/app/car/common/service/CarServiceProvider; 
.const [237] = Utf8 application 
.const [238] = Utf8 Lde/audi/app/car/common/app/ICarApplication; 
.const [239] = Utf8 logChannel 
.const [240] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [241] = Utf8 popupVisible 
.const [242] = Utf8 Z 
.const [243] = Utf8 mutex 
.const [244] = Utf8 Ljava/lang/Object; 
.const [245] = Utf8 this$0 
.const [246] = Utf8 Lde/audi/app/earlyfunc/hybrid/AuxACComponentEvo; 
.const [247] = Utf8 Code 
.const [248] = Utf8 <init> 
.const [249] = Utf8 (Lde/audi/app/earlyfunc/hybrid/AuxACComponentEvo;Lde/audi/app/car/common/app/ICarApplication;Lde/audi/atip/log/LogChannel;I)V 
.const [250] = Utf8 showPopup 
.const [251] = Utf8 ()V 
.const [252] = Utf8 removePopup 
.const [253] = Utf8 ()V 
.const [254] = Utf8 initServiceProvider 
.const [255] = Utf8 ()V 
.const [256] = Utf8 deinitServiceProvider 
.const [257] = Utf8 ()V 
.const [258] = Utf8 partialPopupVisible 
.const [259] = Utf8 (II)V 
.const [260] = Utf8 partialPopupHidden 
.const [261] = Utf8 (II)V 
.const [262] = Utf8 partialPopupRemoved 
.const [263] = Utf8 (II)V 
.const [264] = Utf8 getPPIDsForCallbacks 
.const [265] = Utf8 ()[I 
.const [266] = Utf8 partialPopupListenerRegistered 
.const [267] = Utf8 (IIZ)V 
.const [268] = Utf8 informAboutPPCoordinates 
.const [269] = Utf8 (IIIIII)V 
.end class 
