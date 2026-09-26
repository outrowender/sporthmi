.version 50 0 
.class public final super [157] 
.super [159] 
.field private final [160] [161] 
.field private [162] [163] 
.field static synthetic [164] [165] 

.method public [167] : [168] 
    .attribute [166] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     aload_0 
L5:     new [31] 
L8:     dup 
L9:     bipush 7 
L11:    invokespecial [26] 
L14:    putfield [32] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [169] : [170] 
    .attribute [166] .code stack 9 locals 0 
L0:     aload_0 
L1:     new [33] 
L4:     dup 
L5:     aload_1 
L6:     getstatic [7] 
L9:     ifnonnull L24 
L12:    ldc [8] 
L14:    invokestatic [9] 
L17:    dup 
L18:    putstatic [27] 
L21:    goto L27 
L24:    getstatic [7] 
L27:    invokevirtual [17] 
L30:    new [34] 
L33:    dup 
L34:    aload_0 
L35:    aload_1 
L36:    invokespecial [28] 
L39:    invokespecial [29] 
L42:    putfield [35] 
L45:    aload_0 
L46:    getfield [18] 
L49:    invokevirtual [19] 
L52:    return 
L53:    nop 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method protected [171] : [172] 
    .attribute [166] .code stack 2 locals 2 
L0:     aload_1 
L1:     ifnull L34 
L4:     aload_0 
L5:     getfield [16] 
L8:     dup 
L9:     astore_2 
L10:    monitorenter 
        .catch [0] from L11 to L26 using L29 
L11:    aload_0 
L12:    getfield [16] 
L15:    aload_1 
L16:    invokeinterface [36] 0 
L21:    invokevirtual [20] 
L24:    aload_2 
L25:    monitorexit 
L26:    goto L34 
        .catch [0] from L29 to L32 using L29 
L29:    astore_3 
L30:    aload_2 
L31:    monitorexit 
L32:    aload_3 
L33:    athrow 
L34:    return 
L35:    nop 
L36:    
    .end code 
.end method 

.method private [173] : [174] 
    .attribute [166] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnull L35 
L4:     aload_0 
L5:     getfield [16] 
L8:     dup 
L9:     astore_2 
L10:    monitorenter 
        .catch [0] from L11 to L27 using L30 
L11:    aload_0 
L12:    getfield [16] 
L15:    aload_1 
L16:    invokeinterface [36] 0 
L21:    aload_1 
L22:    invokevirtual [21] 
L25:    aload_2 
L26:    monitorexit 
L27:    goto L35 
        .catch [0] from L30 to L33 using L30 
L30:    astore_3 
L31:    aload_2 
L32:    monitorexit 
L33:    aload_3 
L34:    athrow 
L35:    return 
L36:    
    .end code 
.end method 

.method [175] : [176] 
    .attribute [166] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [16] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L20 using L21 
L7:     aload_0 
L8:     getfield [16] 
L11:    iload_1 
L12:    invokevirtual [22] 
L15:    checkcast [11] 
L18:    aload_2 
L19:    monitorexit 
L20:    areturn 
        .catch [0] from L21 to L24 using L21 
L21:    astore_3 
L22:    aload_2 
L23:    monitorexit 
L24:    aload_3 
L25:    athrow 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method static synthetic [177] : [178] 
    .attribute [166] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [30] 
L9:     dup 
L10:    invokespecial [24] 
L13:    aload_1 
L14:    invokevirtual [15] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static synthetic [179] : [180] 
    .attribute [166] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [23] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [37] [38] 
.const [3] = Class [39] 
.const [4] = Class [40] 
.const [5] = Class [41] 
.const [6] = Class [42] 
.const [7] = Field [43] [44] 
.const [8] = String [45] 
.const [9] = Method [46] [47] 
.const [10] = Class [48] 
.const [11] = Class [49] 
.const [12] = Class [50] 
.const [13] = Class [51] 
.const [14] = Class [52] 
.const [15] = Method [53] [54] 
.const [16] = Field [55] [56] 
.const [17] = Method [57] [58] 
.const [18] = Field [59] [60] 
.const [19] = Method [61] [62] 
.const [20] = Method [63] [64] 
.const [21] = Method [65] [66] 
.const [22] = Method [67] [68] 
.const [23] = Method [69] [70] 
.const [24] = Method [71] [72] 
.const [25] = Method [73] [74] 
.const [26] = Method [75] [76] 
.const [27] = Field [77] [78] 
.const [28] = Method [79] [80] 
.const [29] = Method [81] [82] 
.const [30] = Class [83] 
.const [31] = Class [84] 
.const [32] = Field [85] [86] 
.const [33] = Class [87] 
.const [34] = Class [88] 
.const [35] = Field [89] [90] 
.const [36] = InterfaceMethod [91] [92] 
.const [37] = Class [93] 
.const [38] = NameAndType [94] [95] 
.const [39] = Utf8 java/lang/ClassNotFoundException 
.const [40] = Utf8 java/lang/NoClassDefFoundError 
.const [41] = Utf8 de/esolutions/fw/util/commons/SimpleIntObjectMap 
.const [42] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [43] = Class [96] 
.const [44] = NameAndType [97] [98] 
.const [45] = Utf8 'de.audi.atip.preset.IAppPresetExecutionHandler' 
.const [46] = Class [99] 
.const [47] = NameAndType [100] [101] 
.const [48] = Utf8 de/eso/widgets/preset/PresetExecutionHandlerRegistry$1 
.const [49] = Utf8 de/audi/atip/preset/IAppPresetExecutionHandler 
.const [50] = Utf8 de/eso/widgets/preset/PresetExecutionHandlerRegistry 
.const [51] = Utf8 java/lang/Object 
.const [52] = Utf8 java/lang/Class 
.const [53] = Class [102] 
.const [54] = NameAndType [103] [104] 
.const [55] = Class [105] 
.const [56] = NameAndType [106] [107] 
.const [57] = Class [108] 
.const [58] = NameAndType [109] [110] 
.const [59] = Class [111] 
.const [60] = NameAndType [112] [113] 
.const [61] = Class [114] 
.const [62] = NameAndType [115] [116] 
.const [63] = Class [117] 
.const [64] = NameAndType [118] [119] 
.const [65] = Class [120] 
.const [66] = NameAndType [121] [122] 
.const [67] = Class [123] 
.const [68] = NameAndType [124] [125] 
.const [69] = Class [126] 
.const [70] = NameAndType [127] [128] 
.const [71] = Class [129] 
.const [72] = NameAndType [130] [131] 
.const [73] = Class [132] 
.const [74] = NameAndType [133] [134] 
.const [75] = Class [135] 
.const [76] = NameAndType [136] [137] 
.const [77] = Class [138] 
.const [78] = NameAndType [139] [140] 
.const [79] = Class [141] 
.const [80] = NameAndType [142] [143] 
.const [81] = Class [144] 
.const [82] = NameAndType [145] [146] 
.const [83] = Utf8 java/lang/NoClassDefFoundError 
.const [84] = Utf8 de/esolutions/fw/util/commons/SimpleIntObjectMap 
.const [85] = Class [147] 
.const [86] = NameAndType [148] [149] 
.const [87] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [88] = Utf8 de/eso/widgets/preset/PresetExecutionHandlerRegistry$1 
.const [89] = Class [150] 
.const [90] = NameAndType [151] [152] 
.const [91] = Class [153] 
.const [92] = NameAndType [154] [155] 
.const [93] = Utf8 java/lang/Class 
.const [94] = Utf8 forName 
.const [95] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [96] = Utf8 de/eso/widgets/preset/PresetExecutionHandlerRegistry 
.const [97] = Utf8 class$de$audi$atip$preset$IAppPresetExecutionHandler 
.const [98] = Utf8 Ljava/lang/Class; 
.const [99] = Utf8 de/eso/widgets/preset/PresetExecutionHandlerRegistry 
.const [100] = Utf8 class$ 
.const [101] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [102] = Utf8 java/lang/NoClassDefFoundError 
.const [103] = Utf8 initCause 
.const [104] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [105] = Utf8 de/eso/widgets/preset/PresetExecutionHandlerRegistry 
.const [106] = Utf8 registry 
.const [107] = Utf8 Lde/esolutions/fw/util/commons/SimpleIntObjectMap; 
.const [108] = Utf8 java/lang/Class 
.const [109] = Utf8 getName 
.const [110] = Utf8 ()Ljava/lang/String; 
.const [111] = Utf8 de/eso/widgets/preset/PresetExecutionHandlerRegistry 
.const [112] = Utf8 presetExecutionHandlerTracker 
.const [113] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [114] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [115] = Utf8 'open' 
.const [116] = Utf8 ()V 
.const [117] = Utf8 de/esolutions/fw/util/commons/SimpleIntObjectMap 
.const [118] = Utf8 remove 
.const [119] = Utf8 (I)V 
.const [120] = Utf8 de/esolutions/fw/util/commons/SimpleIntObjectMap 
.const [121] = Utf8 add 
.const [122] = Utf8 (ILjava/lang/Object;)V 
.const [123] = Utf8 de/esolutions/fw/util/commons/SimpleIntObjectMap 
.const [124] = Utf8 get 
.const [125] = Utf8 (I)Ljava/lang/Object; 
.const [126] = Utf8 de/eso/widgets/preset/PresetExecutionHandlerRegistry 
.const [127] = Utf8 registerExecutionHandler 
.const [128] = Utf8 (Lde/audi/atip/preset/IAppPresetExecutionHandler;)V 
.const [129] = Utf8 java/lang/NoClassDefFoundError 
.const [130] = Utf8 <init> 
.const [131] = Utf8 ()V 
.const [132] = Utf8 java/lang/Object 
.const [133] = Utf8 <init> 
.const [134] = Utf8 ()V 
.const [135] = Utf8 de/esolutions/fw/util/commons/SimpleIntObjectMap 
.const [136] = Utf8 <init> 
.const [137] = Utf8 (I)V 
.const [138] = Utf8 de/eso/widgets/preset/PresetExecutionHandlerRegistry 
.const [139] = Utf8 class$de$audi$atip$preset$IAppPresetExecutionHandler 
.const [140] = Utf8 Ljava/lang/Class; 
.const [141] = Utf8 de/eso/widgets/preset/PresetExecutionHandlerRegistry$1 
.const [142] = Utf8 <init> 
.const [143] = Utf8 (Lde/eso/widgets/preset/PresetExecutionHandlerRegistry;Lorg/osgi/framework/BundleContext;)V 
.const [144] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [145] = Utf8 <init> 
.const [146] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [147] = Utf8 de/eso/widgets/preset/PresetExecutionHandlerRegistry 
.const [148] = Utf8 registry 
.const [149] = Utf8 Lde/esolutions/fw/util/commons/SimpleIntObjectMap; 
.const [150] = Utf8 de/eso/widgets/preset/PresetExecutionHandlerRegistry 
.const [151] = Utf8 presetExecutionHandlerTracker 
.const [152] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [153] = Utf8 de/audi/atip/preset/IAppPresetExecutionHandler 
.const [154] = Utf8 getExecutionType 
.const [155] = Utf8 ()I 
.const [156] = Utf8 de/eso/widgets/preset/PresetExecutionHandlerRegistry 
.const [157] = Class [156] 
.const [158] = Utf8 java/lang/Object 
.const [159] = Class [158] 
.const [160] = Utf8 registry 
.const [161] = Utf8 Lde/esolutions/fw/util/commons/SimpleIntObjectMap; 
.const [162] = Utf8 presetExecutionHandlerTracker 
.const [163] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [164] = Utf8 class$de$audi$atip$preset$IAppPresetExecutionHandler 
.const [165] = Utf8 Ljava/lang/Class; 
.const [166] = Utf8 Code 
.const [167] = Utf8 <init> 
.const [168] = Utf8 ()V 
.const [169] = Utf8 startTracker 
.const [170] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [171] = Utf8 unregisterExecutionHandler 
.const [172] = Utf8 (Lde/audi/atip/preset/IAppPresetExecutionHandler;)V 
.const [173] = Utf8 registerExecutionHandler 
.const [174] = Utf8 (Lde/audi/atip/preset/IAppPresetExecutionHandler;)V 
.const [175] = Utf8 getPresetExecutionHandler 
.const [176] = Utf8 (I)Lde/audi/atip/preset/IAppPresetExecutionHandler; 
.const [177] = Utf8 class$ 
.const [178] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [179] = Utf8 access$000 
.const [180] = Utf8 (Lde/eso/widgets/preset/PresetExecutionHandlerRegistry;Lde/audi/atip/preset/IAppPresetExecutionHandler;)V 
.end class 
