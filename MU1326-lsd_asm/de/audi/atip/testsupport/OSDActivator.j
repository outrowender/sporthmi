.version 50 0 
.class public super [227] 
.super [229] 
.implements [231] 
.field private final [232] [233] 
.field private final [234] [235] 
.field private [236] [237] 
.field private [238] [239] 
.field private [240] [241] 
.field private [242] [243] 
.field static synthetic [244] [245] 
.field static synthetic [246] [247] 

.method public [249] : [250] 
    .attribute [248] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [31] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [38] 
L9:     aload_0 
L10:    aconst_null 
L11:    putfield [39] 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [40] 
L19:    aload_0 
L20:    aconst_null 
L21:    putfield [41] 
L24:    aload_0 
L25:    aload_1 
L26:    putfield [42] 
L29:    aload_0 
L30:    iload_2 
L31:    putfield [43] 
L34:    return 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [251] : [252] 
    .attribute [248] .code stack 6 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [38] 
L5:     aload_0 
L6:     new [44] 
L9:     dup 
L10:    aload_1 
L11:    getstatic [6] 
L14:    ifnonnull L29 
L17:    ldc [7] 
L19:    invokestatic [8] 
L22:    dup 
L23:    putstatic [32] 
L26:    goto L32 
L29:    getstatic [6] 
L32:    invokevirtual [26] 
L35:    aload_0 
L36:    invokespecial [33] 
L39:    putfield [40] 
L42:    aload_0 
L43:    getfield [22] 
L46:    invokevirtual [27] 
L49:    return 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [253] : [254] 
    .attribute [248] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [34] 
L4:     aload_0 
L5:     getfield [22] 
L8:     ifnull L23 
L11:    aload_0 
L12:    getfield [22] 
L15:    invokevirtual [28] 
L18:    aload_0 
L19:    aconst_null 
L20:    putfield [40] 
L23:    return 
L24:    
    .end code 
.end method 

.method private [255] : [256] 
    .attribute [248] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     ifnull L21 
L7:     aload_0 
L8:     getfield [21] 
L11:    invokeinterface [45] 0 
L16:    aload_0 
L17:    aconst_null 
L18:    putfield [39] 
L21:    aload_0 
L22:    getfield [23] 
L25:    ifnull L40 
L28:    aload_0 
L29:    getfield [23] 
L32:    invokevirtual [29] 
L35:    aload_0 
L36:    aconst_null 
L37:    putfield [41] 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [257] : [258] 
    .attribute [248] .code stack 6 locals 2 
L0:     aload_0 
L1:     getfield [20] 
L4:     aload_1 
L5:     invokeinterface [46] 0 
L10:    astore_2 
L11:    aload_2 
L12:    instanceof [9] 
L15:    ifeq L103 
        .catch [13] from L18 to L83 using L86 
L18:    aload_0 
L19:    new [47] 
L22:    dup 
L23:    aload_2 
L24:    checkcast [9] 
L27:    aload_0 
L28:    getfield [24] 
L31:    aload_0 
L32:    getfield [25] 
L35:    invokespecial [35] 
L38:    putfield [41] 
L41:    aload_0 
L42:    aload_0 
L43:    getfield [20] 
L46:    getstatic [11] 
L49:    ifnonnull L64 
L52:    ldc [12] 
L54:    invokestatic [8] 
L57:    dup 
L58:    putstatic [36] 
L61:    goto L67 
L64:    getstatic [11] 
L67:    invokevirtual [26] 
L70:    aload_0 
L71:    getfield [23] 
L74:    aconst_null 
L75:    invokeinterface [48] 0 
L80:    putfield [39] 
L83:    goto L116 
L86:    astore_3 
L87:    aload_0 
L88:    getfield [20] 
L91:    aload_1 
L92:    invokeinterface [49] 0 
L97:    pop 
L98:    aconst_null 
L99:    astore_2 
L100:   goto L116 
L103:   aload_0 
L104:   getfield [20] 
L107:   aload_1 
L108:   invokeinterface [49] 0 
L113:   pop 
L114:   aconst_null 
L115:   astore_2 
L116:   aload_2 
L117:   areturn 
L118:   nop 
L119:   nop 
L120:   
    .end code 
.end method 

.method public enum [259] : [260] 
    .attribute [248] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [261] : [262] 
    .attribute [248] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     aload_1 
L5:     invokeinterface [49] 0 
L10:    pop 
L11:    aload_0 
L12:    invokespecial [34] 
L15:    return 
L16:    
    .end code 
.end method 

.method static synthetic [263] : [264] 
    .attribute [248] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [37] 
L9:     dup 
L10:    invokespecial [30] 
L13:    aload_1 
L14:    invokevirtual [19] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [50] [51] 
.const [3] = Class [52] 
.const [4] = Class [53] 
.const [5] = Class [54] 
.const [6] = Field [55] [56] 
.const [7] = String [57] 
.const [8] = Method [58] [59] 
.const [9] = Class [60] 
.const [10] = Class [61] 
.const [11] = Field [62] [63] 
.const [12] = String [64] 
.const [13] = Class [65] 
.const [14] = Class [66] 
.const [15] = Class [67] 
.const [16] = Class [68] 
.const [17] = Class [69] 
.const [18] = Class [70] 
.const [19] = Method [71] [72] 
.const [20] = Field [73] [74] 
.const [21] = Field [75] [76] 
.const [22] = Field [77] [78] 
.const [23] = Field [79] [80] 
.const [24] = Field [81] [82] 
.const [25] = Field [83] [84] 
.const [26] = Method [85] [86] 
.const [27] = Method [87] [88] 
.const [28] = Method [89] [90] 
.const [29] = Method [91] [92] 
.const [30] = Method [93] [94] 
.const [31] = Method [95] [96] 
.const [32] = Field [97] [98] 
.const [33] = Method [99] [100] 
.const [34] = Method [101] [102] 
.const [35] = Method [103] [104] 
.const [36] = Field [105] [106] 
.const [37] = Class [107] 
.const [38] = Field [108] [109] 
.const [39] = Field [110] [111] 
.const [40] = Field [112] [113] 
.const [41] = Field [114] [115] 
.const [42] = Field [116] [117] 
.const [43] = Field [118] [119] 
.const [44] = Class [120] 
.const [45] = InterfaceMethod [121] [122] 
.const [46] = InterfaceMethod [123] [124] 
.const [47] = Class [125] 
.const [48] = InterfaceMethod [126] [127] 
.const [49] = InterfaceMethod [128] [129] 
.const [50] = Class [130] 
.const [51] = NameAndType [131] [132] 
.const [52] = Utf8 java/lang/ClassNotFoundException 
.const [53] = Utf8 java/lang/NoClassDefFoundError 
.const [54] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [55] = Class [133] 
.const [56] = NameAndType [134] [135] 
.const [57] = Utf8 'de.audi.atip.testsupport.ITestSupportService' 
.const [58] = Class [136] 
.const [59] = NameAndType [137] [138] 
.const [60] = Utf8 de/audi/atip/testsupport/ITestSupportService 
.const [61] = Utf8 de/audi/atip/testsupport/OSDHandler 
.const [62] = Class [139] 
.const [63] = NameAndType [140] [141] 
.const [64] = Utf8 'de.audi.atip.testsupport.ITestSupportDataProvider' 
.const [65] = Utf8 java/lang/IllegalArgumentException 
.const [66] = Utf8 de/audi/atip/testsupport/OSDActivator 
.const [67] = Utf8 java/lang/Object 
.const [68] = Utf8 java/lang/Class 
.const [69] = Utf8 org/osgi/framework/ServiceRegistration 
.const [70] = Utf8 org/osgi/framework/BundleContext 
.const [71] = Class [142] 
.const [72] = NameAndType [143] [144] 
.const [73] = Class [145] 
.const [74] = NameAndType [146] [147] 
.const [75] = Class [148] 
.const [76] = NameAndType [149] [150] 
.const [77] = Class [151] 
.const [78] = NameAndType [152] [153] 
.const [79] = Class [154] 
.const [80] = NameAndType [155] [156] 
.const [81] = Class [157] 
.const [82] = NameAndType [158] [159] 
.const [83] = Class [160] 
.const [84] = NameAndType [161] [162] 
.const [85] = Class [163] 
.const [86] = NameAndType [164] [165] 
.const [87] = Class [166] 
.const [88] = NameAndType [167] [168] 
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
.const [107] = Utf8 java/lang/NoClassDefFoundError 
.const [108] = Class [196] 
.const [109] = NameAndType [197] [198] 
.const [110] = Class [199] 
.const [111] = NameAndType [200] [201] 
.const [112] = Class [202] 
.const [113] = NameAndType [203] [204] 
.const [114] = Class [205] 
.const [115] = NameAndType [206] [207] 
.const [116] = Class [208] 
.const [117] = NameAndType [209] [210] 
.const [118] = Class [211] 
.const [119] = NameAndType [212] [213] 
.const [120] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [121] = Class [214] 
.const [122] = NameAndType [215] [216] 
.const [123] = Class [217] 
.const [124] = NameAndType [218] [219] 
.const [125] = Utf8 de/audi/atip/testsupport/OSDHandler 
.const [126] = Class [220] 
.const [127] = NameAndType [221] [222] 
.const [128] = Class [223] 
.const [129] = NameAndType [224] [225] 
.const [130] = Utf8 java/lang/Class 
.const [131] = Utf8 forName 
.const [132] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [133] = Utf8 de/audi/atip/testsupport/OSDActivator 
.const [134] = Utf8 class$de$audi$atip$testsupport$ITestSupportService 
.const [135] = Utf8 Ljava/lang/Class; 
.const [136] = Utf8 de/audi/atip/testsupport/OSDActivator 
.const [137] = Utf8 class$ 
.const [138] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [139] = Utf8 de/audi/atip/testsupport/OSDActivator 
.const [140] = Utf8 class$de$audi$atip$testsupport$ITestSupportDataProvider 
.const [141] = Utf8 Ljava/lang/Class; 
.const [142] = Utf8 java/lang/NoClassDefFoundError 
.const [143] = Utf8 initCause 
.const [144] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [145] = Utf8 de/audi/atip/testsupport/OSDActivator 
.const [146] = Utf8 context 
.const [147] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [148] = Utf8 de/audi/atip/testsupport/OSDActivator 
.const [149] = Utf8 sregOnscreenStats 
.const [150] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [151] = Utf8 de/audi/atip/testsupport/OSDActivator 
.const [152] = Utf8 testSuppportTracker 
.const [153] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [154] = Utf8 de/audi/atip/testsupport/OSDActivator 
.const [155] = Utf8 osdHandler 
.const [156] = Utf8 Lde/audi/atip/testsupport/OSDHandler; 
.const [157] = Utf8 de/audi/atip/testsupport/OSDActivator 
.const [158] = Utf8 data 
.const [159] = Utf8 Lde/audi/atip/testsupport/IOSDDataProvider; 
.const [160] = Utf8 de/audi/atip/testsupport/OSDActivator 
.const [161] = Utf8 useTimer 
.const [162] = Utf8 Z 
.const [163] = Utf8 java/lang/Class 
.const [164] = Utf8 getName 
.const [165] = Utf8 ()Ljava/lang/String; 
.const [166] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [167] = Utf8 'open' 
.const [168] = Utf8 ()V 
.const [169] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [170] = Utf8 close 
.const [171] = Utf8 ()V 
.const [172] = Utf8 de/audi/atip/testsupport/OSDHandler 
.const [173] = Utf8 cleanup 
.const [174] = Utf8 ()V 
.const [175] = Utf8 java/lang/NoClassDefFoundError 
.const [176] = Utf8 <init> 
.const [177] = Utf8 ()V 
.const [178] = Utf8 java/lang/Object 
.const [179] = Utf8 <init> 
.const [180] = Utf8 ()V 
.const [181] = Utf8 de/audi/atip/testsupport/OSDActivator 
.const [182] = Utf8 class$de$audi$atip$testsupport$ITestSupportService 
.const [183] = Utf8 Ljava/lang/Class; 
.const [184] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [185] = Utf8 <init> 
.const [186] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [187] = Utf8 de/audi/atip/testsupport/OSDActivator 
.const [188] = Utf8 cleanup 
.const [189] = Utf8 ()V 
.const [190] = Utf8 de/audi/atip/testsupport/OSDHandler 
.const [191] = Utf8 <init> 
.const [192] = Utf8 (Lde/audi/atip/testsupport/ITestSupportService;Lde/audi/atip/testsupport/IOSDDataProvider;Z)V 
.const [193] = Utf8 de/audi/atip/testsupport/OSDActivator 
.const [194] = Utf8 class$de$audi$atip$testsupport$ITestSupportDataProvider 
.const [195] = Utf8 Ljava/lang/Class; 
.const [196] = Utf8 de/audi/atip/testsupport/OSDActivator 
.const [197] = Utf8 context 
.const [198] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [199] = Utf8 de/audi/atip/testsupport/OSDActivator 
.const [200] = Utf8 sregOnscreenStats 
.const [201] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [202] = Utf8 de/audi/atip/testsupport/OSDActivator 
.const [203] = Utf8 testSuppportTracker 
.const [204] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [205] = Utf8 de/audi/atip/testsupport/OSDActivator 
.const [206] = Utf8 osdHandler 
.const [207] = Utf8 Lde/audi/atip/testsupport/OSDHandler; 
.const [208] = Utf8 de/audi/atip/testsupport/OSDActivator 
.const [209] = Utf8 data 
.const [210] = Utf8 Lde/audi/atip/testsupport/IOSDDataProvider; 
.const [211] = Utf8 de/audi/atip/testsupport/OSDActivator 
.const [212] = Utf8 useTimer 
.const [213] = Utf8 Z 
.const [214] = Utf8 org/osgi/framework/ServiceRegistration 
.const [215] = Utf8 unregister 
.const [216] = Utf8 ()V 
.const [217] = Utf8 org/osgi/framework/BundleContext 
.const [218] = Utf8 getService 
.const [219] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [220] = Utf8 org/osgi/framework/BundleContext 
.const [221] = Utf8 registerService 
.const [222] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [223] = Utf8 org/osgi/framework/BundleContext 
.const [224] = Utf8 ungetService 
.const [225] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [226] = Utf8 de/audi/atip/testsupport/OSDActivator 
.const [227] = Class [226] 
.const [228] = Utf8 java/lang/Object 
.const [229] = Class [228] 
.const [230] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [231] = Class [230] 
.const [232] = Utf8 data 
.const [233] = Utf8 Lde/audi/atip/testsupport/IOSDDataProvider; 
.const [234] = Utf8 useTimer 
.const [235] = Utf8 Z 
.const [236] = Utf8 context 
.const [237] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [238] = Utf8 sregOnscreenStats 
.const [239] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [240] = Utf8 testSuppportTracker 
.const [241] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [242] = Utf8 osdHandler 
.const [243] = Utf8 Lde/audi/atip/testsupport/OSDHandler; 
.const [244] = Utf8 class$de$audi$atip$testsupport$ITestSupportService 
.const [245] = Utf8 Ljava/lang/Class; 
.const [246] = Utf8 class$de$audi$atip$testsupport$ITestSupportDataProvider 
.const [247] = Utf8 Ljava/lang/Class; 
.const [248] = Utf8 Code 
.const [249] = Utf8 <init> 
.const [250] = Utf8 (Lde/audi/atip/testsupport/IOSDDataProvider;Z)V 
.const [251] = Utf8 start 
.const [252] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [253] = Utf8 stop 
.const [254] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [255] = Utf8 cleanup 
.const [256] = Utf8 ()V 
.const [257] = Utf8 addingService 
.const [258] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [259] = Utf8 modifiedService 
.const [260] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [261] = Utf8 removedService 
.const [262] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [263] = Utf8 class$ 
.const [264] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
