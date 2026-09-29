.version 50 0 
.class public final super [235] 
.super [237] 
.implements [239] 
.field private static final [240] [241] 
.field private [242] [243] 
.field private [244] [245] 
.field private [246] [247] 
.field static synthetic [248] [249] 

.method public [251] : [252] 
    .attribute [250] .code stack 2 locals 0 
L0:     aload_0 
L1:     ldc [5] 
L3:     invokespecial [38] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [253] : [254] 
    .attribute [250] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [29] 
L4:     checkcast [6] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method private [255] : [256] 
    .attribute [250] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [29] 
L4:     checkcast [7] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method protected [257] : [258] 
    .attribute [250] .code stack 6 locals 0 
L0:     ldc [8] 
L2:     invokestatic [9] 
L5:     ifeq L18 
L8:     aload_0 
L9:     invokestatic [10] 
L12:    putfield [46] 
L15:    goto L33 
L18:    aload_0 
L19:    new [47] 
L22:    dup 
L23:    aload_0 
L24:    getfield [30] 
L27:    invokespecial [39] 
L30:    putfield [46] 
L33:    aload_0 
L34:    new [48] 
L37:    dup 
L38:    aload_0 
L39:    invokevirtual [31] 
L42:    getstatic [13] 
L45:    ifnonnull L60 
L48:    ldc [14] 
L50:    invokestatic [15] 
L53:    dup 
L54:    putstatic [40] 
L57:    goto L63 
L60:    getstatic [13] 
L63:    invokevirtual [32] 
L66:    aload_0 
L67:    invokespecial [41] 
L70:    putfield [49] 
L73:    aload_0 
L74:    getfield [33] 
L77:    invokevirtual [34] 
L80:    aload_0 
L81:    new [50] 
L84:    dup 
L85:    invokespecial [42] 
L88:    putfield [51] 
L91:    aload_0 
L92:    invokespecial [43] 
L95:    aload_0 
L96:    getfield [35] 
L99:    invokeinterface [52] 0 
L104:   pop 
L105:   aload_0 
L106:   getfield [35] 
L109:   ldc [17] 
L111:   invokestatic [18] 
L114:   invokestatic [19] 
L117:   invokeinterface [53] 0 
L122:   return 
L123:   nop 
L124:   
    .end code 
.end method 

.method public [259] : [260] 
    .attribute [250] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [43] 
L4:     aload_0 
L5:     getfield [35] 
L8:     invokeinterface [54] 0 
L13:    aload_0 
L14:    getfield [33] 
L17:    ifnull L32 
L20:    aload_0 
L21:    getfield [33] 
L24:    invokevirtual [36] 
L27:    aload_0 
L28:    aconst_null 
L29:    putfield [49] 
L32:    aload_0 
L33:    aload_1 
L34:    invokespecial [44] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [261] : [262] 
    .attribute [250] .code stack 2 locals 1 
L0:     aload_0 
L1:     invokevirtual [31] 
L4:     aload_1 
L5:     invokeinterface [55] 0 
L10:    astore_2 
L11:    aload_2 
L12:    instanceof [20] 
L15:    ifeq L35 
L18:    aload_0 
L19:    invokespecial [43] 
L22:    aload_2 
L23:    checkcast [20] 
L26:    invokeinterface [52] 0 
L31:    pop 
L32:    goto L37 
L35:    aconst_null 
L36:    areturn 
L37:    aload_2 
L38:    areturn 
L39:    nop 
L40:    
    .end code 
.end method 

.method public enum [263] : [264] 
    .attribute [250] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [265] : [266] 
    .attribute [250] .code stack 2 locals 0 
L0:     aload_2 
L1:     instanceof [20] 
L4:     ifeq L23 
L7:     aload_0 
L8:     invokespecial [43] 
L11:    aload_2 
L12:    checkcast [20] 
L15:    invokeinterface [54] 0 
L20:    goto L24 
L23:    return 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method static synthetic [267] : [268] 
    .attribute [250] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [45] 
L9:     dup 
L10:    invokespecial [37] 
L13:    aload_1 
L14:    invokevirtual [28] 
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
.const [5] = String [60] 
.const [6] = Class [61] 
.const [7] = Class [62] 
.const [8] = String [63] 
.const [9] = Method [64] [65] 
.const [10] = Method [66] [67] 
.const [11] = Class [68] 
.const [12] = Class [69] 
.const [13] = Field [70] [71] 
.const [14] = String [72] 
.const [15] = Method [73] [74] 
.const [16] = Class [75] 
.const [17] = String [76] 
.const [18] = Method [77] [78] 
.const [19] = Method [79] [80] 
.const [20] = Class [81] 
.const [21] = Class [82] 
.const [22] = Class [83] 
.const [23] = Class [84] 
.const [24] = Class [85] 
.const [25] = Class [86] 
.const [26] = Class [87] 
.const [27] = Class [88] 
.const [28] = Method [89] [90] 
.const [29] = Field [91] [92] 
.const [30] = Field [93] [94] 
.const [31] = Method [95] [96] 
.const [32] = Method [97] [98] 
.const [33] = Field [99] [100] 
.const [34] = Method [101] [102] 
.const [35] = Field [103] [104] 
.const [36] = Method [105] [106] 
.const [37] = Method [107] [108] 
.const [38] = Method [109] [110] 
.const [39] = Method [111] [112] 
.const [40] = Field [113] [114] 
.const [41] = Method [115] [116] 
.const [42] = Method [117] [118] 
.const [43] = Method [119] [120] 
.const [44] = Method [121] [122] 
.const [45] = Class [123] 
.const [46] = Field [124] [125] 
.const [47] = Class [126] 
.const [48] = Class [127] 
.const [49] = Field [128] [129] 
.const [50] = Class [130] 
.const [51] = Field [131] [132] 
.const [52] = InterfaceMethod [133] [134] 
.const [53] = InterfaceMethod [135] [136] 
.const [54] = InterfaceMethod [137] [138] 
.const [55] = InterfaceMethod [139] [140] 
.const [56] = Class [141] 
.const [57] = NameAndType [142] [143] 
.const [58] = Utf8 java/lang/ClassNotFoundException 
.const [59] = Utf8 java/lang/NoClassDefFoundError 
.const [60] = Utf8 FwLog 
.const [61] = Utf8 de/audi/atip/log/LogChannelFactory 
.const [62] = Utf8 de/audi/atip/log/LogServAdmin 
.const [63] = Utf8 DISABLE_LOGGING 
.const [64] = Class [144] 
.const [65] = NameAndType [145] [146] 
.const [66] = Class [147] 
.const [67] = NameAndType [148] [149] 
.const [68] = Utf8 de/audi/tghu/log/LogServImpl 
.const [69] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [70] = Class [150] 
.const [71] = NameAndType [151] [152] 
.const [72] = Utf8 'de.audi.atip.log.LogSink' 
.const [73] = Class [153] 
.const [74] = NameAndType [154] [155] 
.const [75] = Utf8 de/audi/tghu/log/StandardConsoleSink 
.const [76] = Utf8 LOG 
.const [77] = Class [156] 
.const [78] = NameAndType [157] [158] 
.const [79] = Class [159] 
.const [80] = NameAndType [160] [161] 
.const [81] = Utf8 de/audi/atip/log/LogSink 
.const [82] = Utf8 de/audi/tghu/log/LogActivator 
.const [83] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [84] = Utf8 java/lang/Class 
.const [85] = Utf8 java/lang/Boolean 
.const [86] = Utf8 de/audi/atip/log/NullLogServImpl 
.const [87] = Utf8 java/lang/System 
.const [88] = Utf8 org/osgi/framework/BundleContext 
.const [89] = Class [162] 
.const [90] = NameAndType [163] [164] 
.const [91] = Class [165] 
.const [92] = NameAndType [166] [167] 
.const [93] = Class [168] 
.const [94] = NameAndType [169] [170] 
.const [95] = Class [171] 
.const [96] = NameAndType [172] [173] 
.const [97] = Class [174] 
.const [98] = NameAndType [175] [176] 
.const [99] = Class [177] 
.const [100] = NameAndType [178] [179] 
.const [101] = Class [180] 
.const [102] = NameAndType [181] [182] 
.const [103] = Class [183] 
.const [104] = NameAndType [184] [185] 
.const [105] = Class [186] 
.const [106] = NameAndType [187] [188] 
.const [107] = Class [189] 
.const [108] = NameAndType [190] [191] 
.const [109] = Class [192] 
.const [110] = NameAndType [193] [194] 
.const [111] = Class [195] 
.const [112] = NameAndType [196] [197] 
.const [113] = Class [198] 
.const [114] = NameAndType [199] [200] 
.const [115] = Class [201] 
.const [116] = NameAndType [202] [203] 
.const [117] = Class [204] 
.const [118] = NameAndType [205] [206] 
.const [119] = Class [207] 
.const [120] = NameAndType [208] [209] 
.const [121] = Class [210] 
.const [122] = NameAndType [211] [212] 
.const [123] = Utf8 java/lang/NoClassDefFoundError 
.const [124] = Class [213] 
.const [125] = NameAndType [214] [215] 
.const [126] = Utf8 de/audi/tghu/log/LogServImpl 
.const [127] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [128] = Class [216] 
.const [129] = NameAndType [217] [218] 
.const [130] = Utf8 de/audi/tghu/log/StandardConsoleSink 
.const [131] = Class [219] 
.const [132] = NameAndType [220] [221] 
.const [133] = Class [222] 
.const [134] = NameAndType [223] [224] 
.const [135] = Class [225] 
.const [136] = NameAndType [226] [227] 
.const [137] = Class [228] 
.const [138] = NameAndType [229] [230] 
.const [139] = Class [231] 
.const [140] = NameAndType [232] [233] 
.const [141] = Utf8 java/lang/Class 
.const [142] = Utf8 forName 
.const [143] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [144] = Utf8 java/lang/Boolean 
.const [145] = Utf8 getBoolean 
.const [146] = Utf8 (Ljava/lang/String;)Z 
.const [147] = Utf8 de/audi/atip/log/NullLogServImpl 
.const [148] = Utf8 getInstance 
.const [149] = Utf8 ()Lde/audi/atip/log/NullLogServImpl; 
.const [150] = Utf8 de/audi/tghu/log/LogActivator 
.const [151] = Utf8 class$de$audi$atip$log$LogSink 
.const [152] = Utf8 Ljava/lang/Class; 
.const [153] = Utf8 de/audi/tghu/log/LogActivator 
.const [154] = Utf8 class$ 
.const [155] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [156] = Utf8 java/lang/System 
.const [157] = Utf8 getProperty 
.const [158] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [159] = Utf8 de/audi/tghu/log/LogServImpl 
.const [160] = Utf8 decodeLogConfig 
.const [161] = Utf8 (Ljava/lang/String;)Ljava/util/Map; 
.const [162] = Utf8 java/lang/NoClassDefFoundError 
.const [163] = Utf8 initCause 
.const [164] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [165] = Utf8 de/audi/tghu/log/LogActivator 
.const [166] = Utf8 service 
.const [167] = Utf8 Ljava/lang/Object; 
.const [168] = Utf8 de/audi/tghu/log/LogActivator 
.const [169] = Utf8 framework 
.const [170] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [171] = Utf8 de/audi/tghu/log/LogActivator 
.const [172] = Utf8 getBundleContext 
.const [173] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [174] = Utf8 java/lang/Class 
.const [175] = Utf8 getName 
.const [176] = Utf8 ()Ljava/lang/String; 
.const [177] = Utf8 de/audi/tghu/log/LogActivator 
.const [178] = Utf8 tracker 
.const [179] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [180] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [181] = Utf8 'open' 
.const [182] = Utf8 ()V 
.const [183] = Utf8 de/audi/tghu/log/LogActivator 
.const [184] = Utf8 stdConsoleSink 
.const [185] = Utf8 Lde/audi/atip/log/LogSink; 
.const [186] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [187] = Utf8 close 
.const [188] = Utf8 ()V 
.const [189] = Utf8 java/lang/NoClassDefFoundError 
.const [190] = Utf8 <init> 
.const [191] = Utf8 ()V 
.const [192] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [193] = Utf8 <init> 
.const [194] = Utf8 (Ljava/lang/String;)V 
.const [195] = Utf8 de/audi/tghu/log/LogServImpl 
.const [196] = Utf8 <init> 
.const [197] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [198] = Utf8 de/audi/tghu/log/LogActivator 
.const [199] = Utf8 class$de$audi$atip$log$LogSink 
.const [200] = Utf8 Ljava/lang/Class; 
.const [201] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [202] = Utf8 <init> 
.const [203] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [204] = Utf8 de/audi/tghu/log/StandardConsoleSink 
.const [205] = Utf8 <init> 
.const [206] = Utf8 ()V 
.const [207] = Utf8 de/audi/tghu/log/LogActivator 
.const [208] = Utf8 getLogServAdmin 
.const [209] = Utf8 ()Lde/audi/atip/log/LogServAdmin; 
.const [210] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [211] = Utf8 stop 
.const [212] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [213] = Utf8 de/audi/tghu/log/LogActivator 
.const [214] = Utf8 service 
.const [215] = Utf8 Ljava/lang/Object; 
.const [216] = Utf8 de/audi/tghu/log/LogActivator 
.const [217] = Utf8 tracker 
.const [218] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [219] = Utf8 de/audi/tghu/log/LogActivator 
.const [220] = Utf8 stdConsoleSink 
.const [221] = Utf8 Lde/audi/atip/log/LogSink; 
.const [222] = Utf8 de/audi/atip/log/LogServAdmin 
.const [223] = Utf8 addLogSink 
.const [224] = Utf8 (Lde/audi/atip/log/LogSink;)Lde/audi/atip/log/LogSink; 
.const [225] = Utf8 de/audi/atip/log/LogSink 
.const [226] = Utf8 setConfiguration 
.const [227] = Utf8 (Ljava/util/Map;)V 
.const [228] = Utf8 de/audi/atip/log/LogServAdmin 
.const [229] = Utf8 removeLogSink 
.const [230] = Utf8 (Lde/audi/atip/log/LogSink;)V 
.const [231] = Utf8 org/osgi/framework/BundleContext 
.const [232] = Utf8 getService 
.const [233] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [234] = Utf8 de/audi/tghu/log/LogActivator 
.const [235] = Class [234] 
.const [236] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [237] = Class [236] 
.const [238] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [239] = Class [238] 
.const [240] = Utf8 STD_CONSOLE_SINK_ACTIVE 
.const [241] = Utf8 Z 
.const [242] = Utf8 tracker 
.const [243] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [244] = Utf8 service 
.const [245] = Utf8 Ljava/lang/Object; 
.const [246] = Utf8 stdConsoleSink 
.const [247] = Utf8 Lde/audi/atip/log/LogSink; 
.const [248] = Utf8 class$de$audi$atip$log$LogSink 
.const [249] = Utf8 Ljava/lang/Class; 
.const [250] = Utf8 Code 
.const [251] = Utf8 <init> 
.const [252] = Utf8 ()V 
.const [253] = Utf8 getLogService 
.const [254] = Utf8 ()Lde/audi/atip/log/LogChannelFactory; 
.const [255] = Utf8 getLogServAdmin 
.const [256] = Utf8 ()Lde/audi/atip/log/LogServAdmin; 
.const [257] = Utf8 startInternal 
.const [258] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [259] = Utf8 stop 
.const [260] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [261] = Utf8 addingService 
.const [262] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [263] = Utf8 modifiedService 
.const [264] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [265] = Utf8 removedService 
.const [266] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [267] = Utf8 class$ 
.const [268] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
