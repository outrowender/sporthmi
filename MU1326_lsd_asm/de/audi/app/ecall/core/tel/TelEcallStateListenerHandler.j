.version 50 0 
.class public super [238] 
.super [240] 
.implements [242] 
.implements [244] 
.field private [245] [246] 
.field private [247] [248] 
.field static synthetic [249] [250] 

.method public [252] : [253] 
    .attribute [251] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [33] 
L6:     aload_0 
L7:     new [40] 
L10:    dup 
L11:    invokespecial [34] 
L14:    putfield [41] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [254] : [255] 
    .attribute [251] .code stack 7 locals 0 
L0:     aload_0 
L1:     invokevirtual [25] 
L4:     invokeinterface [42] 0 
L9:     aload_0 
L10:    invokeinterface [43] 0 
L15:    aload_0 
L16:    new [44] 
L19:    dup 
L20:    aload_0 
L21:    invokevirtual [25] 
L24:    invokeinterface [45] 0 
L29:    getstatic [7] 
L32:    ifnonnull L47 
L35:    ldc [8] 
L37:    invokestatic [9] 
L40:    dup 
L41:    putstatic [35] 
L44:    goto L50 
L47:    getstatic [7] 
L50:    invokevirtual [26] 
L53:    aload_0 
L54:    aload_0 
L55:    getfield [27] 
L58:    invokespecial [36] 
L61:    putfield [46] 
L64:    aload_0 
L65:    getfield [28] 
L68:    invokevirtual [29] 
L71:    return 
L72:    
    .end code 
.end method 

.method public [256] : [257] 
    .attribute [251] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokevirtual [25] 
L4:     invokeinterface [42] 0 
L9:     aload_0 
L10:    invokeinterface [47] 0 
L15:    aload_0 
L16:    getfield [28] 
L19:    invokevirtual [30] 
L22:    aload_0 
L23:    aconst_null 
L24:    putfield [46] 
L27:    return 
L28:    
    .end code 
.end method 

.method public [258] : [259] 
    .attribute [251] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [27] 
L4:     ldc [10] 
L6:     ldc [11] 
L8:     aload_2 
L9:     invokevirtual [31] 
L12:    pop 
L13:    new [48] 
L16:    dup 
L17:    aload_2 
L18:    invokespecial [37] 
L21:    astore_3 
L22:    iload_1 
L23:    tableswitch 1 
            L85 
            L112 
            L94 
            L76 
            L112 
            L112 
            L112 
            L112 
            L112 
            L103 
            default : L112 

L76:    aload_0 
L77:    iconst_2 
L78:    aload_3 
L79:    invokespecial [38] 
L82:    goto L112 
L85:    aload_0 
L86:    iconst_1 
L87:    aload_3 
L88:    invokespecial [38] 
L91:    goto L112 
L94:    aload_0 
L95:    iconst_0 
L96:    aload_3 
L97:    invokespecial [38] 
L100:   goto L112 
L103:   aload_0 
L104:   iconst_3 
L105:   aload_3 
L106:   invokespecial [38] 
L109:   goto L112 
L112:   return 
L113:   nop 
L114:   nop 
L115:   nop 
L116:   
    .end code 
.end method 

.method public [260] : [261] 
    .attribute [251] .code stack 4 locals 1 
L0:     aload_0 
L1:     invokevirtual [25] 
L4:     invokeinterface [45] 0 
L9:     aload_1 
L10:    invokeinterface [49] 0 
L15:    astore_2 
L16:    aload_0 
L17:    getfield [27] 
L20:    ldc [10] 
L22:    ldc [13] 
L24:    aload_2 
L25:    invokevirtual [31] 
L28:    pop 
L29:    aload_2 
L30:    instanceof [14] 
L33:    ifeq L49 
L36:    aload_0 
L37:    getfield [24] 
L40:    aload_2 
L41:    invokeinterface [50] 0 
L46:    pop 
L47:    aload_2 
L48:    areturn 
L49:    aload_0 
L50:    invokevirtual [25] 
L53:    invokeinterface [45] 0 
L58:    aload_1 
L59:    invokeinterface [51] 0 
L64:    pop 
L65:    aconst_null 
L66:    areturn 
L67:    nop 
L68:    
    .end code 
.end method 

.method public enum [262] : [263] 
    .attribute [251] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [264] : [265] 
    .attribute [251] .code stack 2 locals 1 
L0:     aload_2 
L1:     instanceof [14] 
L4:     ifeq L72 
L7:     aload_0 
L8:     invokevirtual [25] 
L11:    invokeinterface [45] 0 
L16:    aload_1 
L17:    invokeinterface [51] 0 
L22:    pop 
L23:    iconst_0 
L24:    istore_3 
L25:    iload_3 
L26:    aload_0 
L27:    getfield [24] 
L30:    invokeinterface [52] 0 
L35:    if_icmpge L72 
L38:    aload_0 
L39:    getfield [24] 
L42:    iload_3 
L43:    invokeinterface [53] 0 
L48:    aload_2 
L49:    if_acmpne L66 
L52:    aload_0 
L53:    getfield [24] 
L56:    iload_3 
L57:    invokeinterface [54] 0 
L62:    pop 
L63:    goto L72 
L66:    iinc 3 1 
L69:    goto L25 
L72:    return 
L73:    nop 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method private [266] : [267] 
    .attribute [251] .code stack 3 locals 1 
L0:     iconst_0 
L1:     istore_3 
L2:     iload_3 
L3:     aload_0 
L4:     getfield [24] 
L7:     invokeinterface [52] 0 
L12:    if_icmpge L41 
L15:    aload_0 
L16:    getfield [24] 
L19:    iload_3 
L20:    invokeinterface [53] 0 
L25:    checkcast [14] 
L28:    iload_1 
L29:    aload_2 
L30:    invokeinterface [55] 0 
L35:    iinc 3 1 
L38:    goto L2 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method static synthetic [268] : [269] 
    .attribute [251] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [39] 
L9:     dup 
L10:    invokespecial [32] 
L13:    aload_1 
L14:    invokevirtual [23] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [56] [57] 
.const [3] = Class [58] 
.const [4] = Class [59] 
.const [5] = Class [60] 
.const [6] = Class [61] 
.const [7] = Field [62] [63] 
.const [8] = String [64] 
.const [9] = Method [65] [66] 
.const [10] = Int -2137614336 
.const [11] = String [67] 
.const [12] = Class [68] 
.const [13] = String [69] 
.const [14] = Class [70] 
.const [15] = Class [71] 
.const [16] = Class [72] 
.const [17] = Class [73] 
.const [18] = Class [74] 
.const [19] = Class [75] 
.const [20] = Class [76] 
.const [21] = Class [77] 
.const [22] = Class [78] 
.const [23] = Method [79] [80] 
.const [24] = Field [81] [82] 
.const [25] = Method [83] [84] 
.const [26] = Method [85] [86] 
.const [27] = Field [87] [88] 
.const [28] = Field [89] [90] 
.const [29] = Method [91] [92] 
.const [30] = Method [93] [94] 
.const [31] = Method [95] [96] 
.const [32] = Method [97] [98] 
.const [33] = Method [99] [100] 
.const [34] = Method [101] [102] 
.const [35] = Field [103] [104] 
.const [36] = Method [105] [106] 
.const [37] = Method [107] [108] 
.const [38] = Method [109] [110] 
.const [39] = Class [111] 
.const [40] = Class [112] 
.const [41] = Field [113] [114] 
.const [42] = InterfaceMethod [115] [116] 
.const [43] = InterfaceMethod [117] [118] 
.const [44] = Class [119] 
.const [45] = InterfaceMethod [120] [121] 
.const [46] = Field [122] [123] 
.const [47] = InterfaceMethod [124] [125] 
.const [48] = Class [126] 
.const [49] = InterfaceMethod [127] [128] 
.const [50] = InterfaceMethod [129] [130] 
.const [51] = InterfaceMethod [131] [132] 
.const [52] = InterfaceMethod [133] [134] 
.const [53] = InterfaceMethod [135] [136] 
.const [54] = InterfaceMethod [137] [138] 
.const [55] = InterfaceMethod [139] [140] 
.const [56] = Class [141] 
.const [57] = NameAndType [142] [143] 
.const [58] = Utf8 java/lang/ClassNotFoundException 
.const [59] = Utf8 java/lang/NoClassDefFoundError 
.const [60] = Utf8 java/util/ArrayList 
.const [61] = Utf8 de/audi/app/ecall/core/osgi/EcallServiceTracker 
.const [62] = Class [144] 
.const [63] = NameAndType [145] [146] 
.const [64] = Utf8 'de.audi.atip.interapp.phone.ITelEcallStateListener' 
.const [65] = Class [147] 
.const [66] = NameAndType [148] [149] 
.const [67] = Utf8 'TelEcallStateListenerHandler#updateGlobalEcallStateProperty(): globalEcallState=%1' 
.const [68] = Utf8 de/audi/app/ecall/core/tel/EcallState 
.const [69] = Utf8 'BAPServiceEcallListenerClusterHandler#addingService(): service: %1' 
.const [70] = Utf8 de/audi/atip/interapp/phone/ITelEcallStateListener 
.const [71] = Utf8 de/audi/app/ecall/core/tel/TelEcallStateListenerHandler 
.const [72] = Utf8 de/audi/app/ecall/core/AbstractEcallComponent 
.const [73] = Utf8 java/lang/Class 
.const [74] = Utf8 de/audi/app/ecall/core/IEcallApplication 
.const [75] = Utf8 de/audi/app/ecall/core/bap/IGlobalEcallState 
.const [76] = Utf8 de/audi/atip/log/LogChannel 
.const [77] = Utf8 org/osgi/framework/BundleContext 
.const [78] = Utf8 java/util/List 
.const [79] = Class [150] 
.const [80] = NameAndType [151] [152] 
.const [81] = Class [153] 
.const [82] = NameAndType [154] [155] 
.const [83] = Class [156] 
.const [84] = NameAndType [157] [158] 
.const [85] = Class [159] 
.const [86] = NameAndType [160] [161] 
.const [87] = Class [162] 
.const [88] = NameAndType [163] [164] 
.const [89] = Class [165] 
.const [90] = NameAndType [166] [167] 
.const [91] = Class [168] 
.const [92] = NameAndType [169] [170] 
.const [93] = Class [171] 
.const [94] = NameAndType [172] [173] 
.const [95] = Class [174] 
.const [96] = NameAndType [175] [176] 
.const [97] = Class [177] 
.const [98] = NameAndType [178] [179] 
.const [99] = Class [180] 
.const [100] = NameAndType [181] [182] 
.const [101] = Class [183] 
.const [102] = NameAndType [184] [185] 
.const [103] = Class [186] 
.const [104] = NameAndType [187] [188] 
.const [105] = Class [189] 
.const [106] = NameAndType [190] [191] 
.const [107] = Class [192] 
.const [108] = NameAndType [193] [194] 
.const [109] = Class [195] 
.const [110] = NameAndType [196] [197] 
.const [111] = Utf8 java/lang/NoClassDefFoundError 
.const [112] = Utf8 java/util/ArrayList 
.const [113] = Class [198] 
.const [114] = NameAndType [199] [200] 
.const [115] = Class [201] 
.const [116] = NameAndType [202] [203] 
.const [117] = Class [204] 
.const [118] = NameAndType [205] [206] 
.const [119] = Utf8 de/audi/app/ecall/core/osgi/EcallServiceTracker 
.const [120] = Class [207] 
.const [121] = NameAndType [208] [209] 
.const [122] = Class [210] 
.const [123] = NameAndType [211] [212] 
.const [124] = Class [213] 
.const [125] = NameAndType [214] [215] 
.const [126] = Utf8 de/audi/app/ecall/core/tel/EcallState 
.const [127] = Class [216] 
.const [128] = NameAndType [217] [218] 
.const [129] = Class [219] 
.const [130] = NameAndType [220] [221] 
.const [131] = Class [222] 
.const [132] = NameAndType [223] [224] 
.const [133] = Class [225] 
.const [134] = NameAndType [226] [227] 
.const [135] = Class [228] 
.const [136] = NameAndType [229] [230] 
.const [137] = Class [231] 
.const [138] = NameAndType [232] [233] 
.const [139] = Class [234] 
.const [140] = NameAndType [235] [236] 
.const [141] = Utf8 java/lang/Class 
.const [142] = Utf8 forName 
.const [143] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [144] = Utf8 de/audi/app/ecall/core/tel/TelEcallStateListenerHandler 
.const [145] = Utf8 class$de$audi$atip$interapp$phone$ITelEcallStateListener 
.const [146] = Utf8 Ljava/lang/Class; 
.const [147] = Utf8 de/audi/app/ecall/core/tel/TelEcallStateListenerHandler 
.const [148] = Utf8 class$ 
.const [149] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [150] = Utf8 java/lang/NoClassDefFoundError 
.const [151] = Utf8 initCause 
.const [152] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [153] = Utf8 de/audi/app/ecall/core/tel/TelEcallStateListenerHandler 
.const [154] = Utf8 telEcallStateListeners 
.const [155] = Utf8 Ljava/util/List; 
.const [156] = Utf8 de/audi/app/ecall/core/tel/TelEcallStateListenerHandler 
.const [157] = Utf8 getApplication 
.const [158] = Utf8 ()Lde/audi/app/ecall/core/IEcallApplication; 
.const [159] = Utf8 java/lang/Class 
.const [160] = Utf8 getName 
.const [161] = Utf8 ()Ljava/lang/String; 
.const [162] = Utf8 de/audi/app/ecall/core/tel/TelEcallStateListenerHandler 
.const [163] = Utf8 log 
.const [164] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [165] = Utf8 de/audi/app/ecall/core/tel/TelEcallStateListenerHandler 
.const [166] = Utf8 telEcallStateListenerTracker 
.const [167] = Utf8 Lde/audi/app/ecall/core/osgi/EcallServiceTracker; 
.const [168] = Utf8 de/audi/app/ecall/core/osgi/EcallServiceTracker 
.const [169] = Utf8 openTracker 
.const [170] = Utf8 ()V 
.const [171] = Utf8 de/audi/app/ecall/core/osgi/EcallServiceTracker 
.const [172] = Utf8 closeTracker 
.const [173] = Utf8 ()V 
.const [174] = Utf8 de/audi/atip/log/LogChannel 
.const [175] = Utf8 log 
.const [176] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [177] = Utf8 java/lang/NoClassDefFoundError 
.const [178] = Utf8 <init> 
.const [179] = Utf8 ()V 
.const [180] = Utf8 de/audi/app/ecall/core/AbstractEcallComponent 
.const [181] = Utf8 <init> 
.const [182] = Utf8 (Lde/audi/app/ecall/core/IEcallApplication;Ljava/lang/String;)V 
.const [183] = Utf8 java/util/ArrayList 
.const [184] = Utf8 <init> 
.const [185] = Utf8 ()V 
.const [186] = Utf8 de/audi/app/ecall/core/tel/TelEcallStateListenerHandler 
.const [187] = Utf8 class$de$audi$atip$interapp$phone$ITelEcallStateListener 
.const [188] = Utf8 Ljava/lang/Class; 
.const [189] = Utf8 de/audi/app/ecall/core/osgi/EcallServiceTracker 
.const [190] = Utf8 <init> 
.const [191] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;Lde/audi/atip/log/LogChannel;)V 
.const [192] = Utf8 de/audi/app/ecall/core/tel/EcallState 
.const [193] = Utf8 <init> 
.const [194] = Utf8 (Lde/audi/app/ecall/core/state/IEcallStateStruct;)V 
.const [195] = Utf8 de/audi/app/ecall/core/tel/TelEcallStateListenerHandler 
.const [196] = Utf8 broadcastEcallState 
.const [197] = Utf8 (ILde/audi/atip/interapp/phone/IEcallState;)V 
.const [198] = Utf8 de/audi/app/ecall/core/tel/TelEcallStateListenerHandler 
.const [199] = Utf8 telEcallStateListeners 
.const [200] = Utf8 Ljava/util/List; 
.const [201] = Utf8 de/audi/app/ecall/core/IEcallApplication 
.const [202] = Utf8 getEcallStateManager 
.const [203] = Utf8 ()Lde/audi/app/ecall/core/bap/IGlobalEcallState; 
.const [204] = Utf8 de/audi/app/ecall/core/bap/IGlobalEcallState 
.const [205] = Utf8 registerListener 
.const [206] = Utf8 (Lde/audi/app/ecall/core/state/IGlobalEcallStateListener;)V 
.const [207] = Utf8 de/audi/app/ecall/core/IEcallApplication 
.const [208] = Utf8 getBundleContext 
.const [209] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [210] = Utf8 de/audi/app/ecall/core/tel/TelEcallStateListenerHandler 
.const [211] = Utf8 telEcallStateListenerTracker 
.const [212] = Utf8 Lde/audi/app/ecall/core/osgi/EcallServiceTracker; 
.const [213] = Utf8 de/audi/app/ecall/core/bap/IGlobalEcallState 
.const [214] = Utf8 removeListener 
.const [215] = Utf8 (Lde/audi/app/ecall/core/state/IGlobalEcallStateListener;)V 
.const [216] = Utf8 org/osgi/framework/BundleContext 
.const [217] = Utf8 getService 
.const [218] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [219] = Utf8 java/util/List 
.const [220] = Utf8 add 
.const [221] = Utf8 (Ljava/lang/Object;)Z 
.const [222] = Utf8 org/osgi/framework/BundleContext 
.const [223] = Utf8 ungetService 
.const [224] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [225] = Utf8 java/util/List 
.const [226] = Utf8 size 
.const [227] = Utf8 ()I 
.const [228] = Utf8 java/util/List 
.const [229] = Utf8 get 
.const [230] = Utf8 (I)Ljava/lang/Object; 
.const [231] = Utf8 java/util/List 
.const [232] = Utf8 remove 
.const [233] = Utf8 (I)Ljava/lang/Object; 
.const [234] = Utf8 de/audi/atip/interapp/phone/ITelEcallStateListener 
.const [235] = Utf8 updateEcallState 
.const [236] = Utf8 (ILde/audi/atip/interapp/phone/IEcallState;)V 
.const [237] = Utf8 de/audi/app/ecall/core/tel/TelEcallStateListenerHandler 
.const [238] = Class [237] 
.const [239] = Utf8 de/audi/app/ecall/core/AbstractEcallComponent 
.const [240] = Class [239] 
.const [241] = Utf8 de/audi/app/ecall/core/state/IGlobalEcallStateListener 
.const [242] = Class [241] 
.const [243] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [244] = Class [243] 
.const [245] = Utf8 telEcallStateListenerTracker 
.const [246] = Utf8 Lde/audi/app/ecall/core/osgi/EcallServiceTracker; 
.const [247] = Utf8 telEcallStateListeners 
.const [248] = Utf8 Ljava/util/List; 
.const [249] = Utf8 class$de$audi$atip$interapp$phone$ITelEcallStateListener 
.const [250] = Utf8 Ljava/lang/Class; 
.const [251] = Utf8 Code 
.const [252] = Utf8 <init> 
.const [253] = Utf8 (Lde/audi/app/ecall/core/IEcallApplication;Ljava/lang/String;)V 
.const [254] = Utf8 init 
.const [255] = Utf8 ()V 
.const [256] = Utf8 deinit 
.const [257] = Utf8 ()V 
.const [258] = Utf8 updateGlobalEcallStateProperty 
.const [259] = Utf8 (ILde/audi/app/ecall/core/state/IEcallStateStruct;)V 
.const [260] = Utf8 addingService 
.const [261] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [262] = Utf8 modifiedService 
.const [263] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [264] = Utf8 removedService 
.const [265] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [266] = Utf8 broadcastEcallState 
.const [267] = Utf8 (ILde/audi/atip/interapp/phone/IEcallState;)V 
.const [268] = Utf8 class$ 
.const [269] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
