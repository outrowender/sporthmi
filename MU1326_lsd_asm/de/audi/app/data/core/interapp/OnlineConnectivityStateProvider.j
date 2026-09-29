.version 50 0 
.class public super [216] 
.super [218] 
.field private static final [219] [220] 
.field private [221] [222] 
.field private [223] [224] 
.field private volatile [225] [226] 
.field static synthetic [227] [228] 

.method public annotation [230] : [231] 
    .attribute [229] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [29] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [232] : [233] 
    .attribute [229] .code stack 1 locals 0 
L0:     getstatic [5] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [234] : [235] 
    .attribute [229] .code stack 5 locals 0 
L0:     iload_2 
L1:     iconst_1 
L2:     if_icmpeq L6 
L5:     return 
L6:     aload_0 
L7:     getfield [19] 
L10:    ldc [6] 
L12:    ldc [7] 
L14:    iload_1 
L15:    i2l 
L16:    invokevirtual [20] 
L19:    pop 
L20:    aload_0 
L21:    iload_1 
L22:    ifne L29 
L25:    iconst_1 
L26:    goto L30 
L29:    iconst_0 
L30:    putfield [40] 
L33:    aload_0 
L34:    invokespecial [31] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method private [236] : [237] 
    .attribute [229] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     ifnull L20 
L7:     aload_0 
L8:     getfield [22] 
L11:    aload_0 
L12:    getfield [21] 
L15:    invokeinterface [42] 0 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [238] : [239] 
    .attribute [229] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [23] 
L4:     aload_1 
L5:     invokeinterface [43] 0 
L10:    astore_2 
L11:    aload_2 
L12:    instanceof [8] 
L15:    ifeq L32 
L18:    aload_0 
L19:    aload_2 
L20:    checkcast [8] 
L23:    putfield [41] 
L26:    aload_0 
L27:    invokespecial [31] 
L30:    aload_2 
L31:    areturn 
L32:    aload_0 
L33:    aload_1 
L34:    invokespecial [32] 
L37:    areturn 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [240] : [241] 
    .attribute [229] .code stack 3 locals 0 
L0:     aload_2 
L1:     instanceof [8] 
L4:     ifeq L18 
L7:     aload_0 
L8:     aload_2 
L9:     checkcast [8] 
L12:    putfield [41] 
L15:    goto L24 
L18:    aload_0 
L19:    aload_1 
L20:    aload_2 
L21:    invokespecial [33] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [242] : [243] 
    .attribute [229] .code stack 3 locals 0 
L0:     aload_2 
L1:     instanceof [8] 
L4:     ifeq L29 
L7:     aload_0 
L8:     aload_2 
L9:     checkcast [8] 
L12:    putfield [41] 
L15:    aload_0 
L16:    getfield [23] 
L19:    aload_1 
L20:    invokeinterface [44] 0 
L25:    pop 
L26:    goto L35 
L29:    aload_0 
L30:    aload_1 
L31:    aload_2 
L32:    invokespecial [34] 
L35:    return 
L36:    
    .end code 
.end method 

.method public [244] : [245] 
    .attribute [229] .code stack 6 locals 0 
L0:     aload_0 
L1:     invokespecial [35] 
L4:     aload_0 
L5:     new [45] 
L8:     dup 
L9:     aload_0 
L10:    getfield [23] 
L13:    getstatic [10] 
L16:    ifnonnull L31 
L19:    ldc [11] 
L21:    invokestatic [12] 
L24:    dup 
L25:    putstatic [36] 
L28:    goto L34 
L31:    getstatic [10] 
L34:    invokevirtual [24] 
L37:    aload_0 
L38:    invokespecial [37] 
L41:    putfield [46] 
L44:    aload_0 
L45:    getfield [25] 
L48:    invokevirtual [26] 
L51:    return 
L52:    
    .end code 
.end method 

.method public [246] : [247] 
    .attribute [229] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [25] 
L4:     invokevirtual [27] 
L7:     aload_0 
L8:     aconst_null 
L9:     putfield [46] 
L12:    aload_0 
L13:    invokespecial [38] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static synthetic [248] : [249] 
    .attribute [229] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [39] 
L9:     dup 
L10:    invokespecial [28] 
L13:    aload_1 
L14:    invokevirtual [18] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static [250] : [251] 
    .attribute [229] .code stack 4 locals 0 
L0:     iconst_1 
L1:     newarray int 
L3:     dup 
L4:     iconst_0 
L5:     iconst_3 
L6:     iastore 
L7:     putstatic [30] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [47] [48] 
.const [3] = Class [49] 
.const [4] = Class [50] 
.const [5] = Field [51] [52] 
.const [6] = Int 1078071040 
.const [7] = String [53] 
.const [8] = Class [54] 
.const [9] = Class [55] 
.const [10] = Field [56] [57] 
.const [11] = String [58] 
.const [12] = Method [59] [60] 
.const [13] = Class [61] 
.const [14] = Class [62] 
.const [15] = Class [63] 
.const [16] = Class [64] 
.const [17] = Class [65] 
.const [18] = Method [66] [67] 
.const [19] = Field [68] [69] 
.const [20] = Method [70] [71] 
.const [21] = Field [72] [73] 
.const [22] = Field [74] [75] 
.const [23] = Field [76] [77] 
.const [24] = Method [78] [79] 
.const [25] = Field [80] [81] 
.const [26] = Method [82] [83] 
.const [27] = Method [84] [85] 
.const [28] = Method [86] [87] 
.const [29] = Method [88] [89] 
.const [30] = Field [90] [91] 
.const [31] = Method [92] [93] 
.const [32] = Method [94] [95] 
.const [33] = Method [96] [97] 
.const [34] = Method [98] [99] 
.const [35] = Method [100] [101] 
.const [36] = Field [102] [103] 
.const [37] = Method [104] [105] 
.const [38] = Method [106] [107] 
.const [39] = Class [108] 
.const [40] = Field [109] [110] 
.const [41] = Field [111] [112] 
.const [42] = InterfaceMethod [113] [114] 
.const [43] = InterfaceMethod [115] [116] 
.const [44] = InterfaceMethod [117] [118] 
.const [45] = Class [119] 
.const [46] = Field [120] [121] 
.const [47] = Class [122] 
.const [48] = NameAndType [123] [124] 
.const [49] = Utf8 java/lang/ClassNotFoundException 
.const [50] = Utf8 java/lang/NoClassDefFoundError 
.const [51] = Class [125] 
.const [52] = NameAndType [126] [127] 
.const [53] = Utf8 'OnlineConnectivityStateProvider#updateRoamingState(): %1' 
.const [54] = Utf8 de/audi/atip/interapp/online/IOnlineDataStateListener 
.const [55] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [56] = Class [128] 
.const [57] = NameAndType [129] [130] 
.const [58] = Utf8 'de.audi.atip.interapp.online.IOnlineDataStateListener' 
.const [59] = Class [131] 
.const [60] = NameAndType [132] [133] 
.const [61] = Utf8 de/audi/app/data/core/interapp/OnlineConnectivityStateProvider 
.const [62] = Utf8 de/audi/app/data/core/AbstractDataConfigurationComponent 
.const [63] = Utf8 java/lang/Class 
.const [64] = Utf8 de/audi/atip/log/LogChannel 
.const [65] = Utf8 org/osgi/framework/BundleContext 
.const [66] = Class [134] 
.const [67] = NameAndType [135] [136] 
.const [68] = Class [137] 
.const [69] = NameAndType [138] [139] 
.const [70] = Class [140] 
.const [71] = NameAndType [141] [142] 
.const [72] = Class [143] 
.const [73] = NameAndType [144] [145] 
.const [74] = Class [146] 
.const [75] = NameAndType [147] [148] 
.const [76] = Class [149] 
.const [77] = NameAndType [150] [151] 
.const [78] = Class [152] 
.const [79] = NameAndType [153] [154] 
.const [80] = Class [155] 
.const [81] = NameAndType [156] [157] 
.const [82] = Class [158] 
.const [83] = NameAndType [159] [160] 
.const [84] = Class [161] 
.const [85] = NameAndType [162] [163] 
.const [86] = Class [164] 
.const [87] = NameAndType [165] [166] 
.const [88] = Class [167] 
.const [89] = NameAndType [168] [169] 
.const [90] = Class [170] 
.const [91] = NameAndType [171] [172] 
.const [92] = Class [173] 
.const [93] = NameAndType [174] [175] 
.const [94] = Class [176] 
.const [95] = NameAndType [177] [178] 
.const [96] = Class [179] 
.const [97] = NameAndType [180] [181] 
.const [98] = Class [182] 
.const [99] = NameAndType [183] [184] 
.const [100] = Class [185] 
.const [101] = NameAndType [186] [187] 
.const [102] = Class [188] 
.const [103] = NameAndType [189] [190] 
.const [104] = Class [191] 
.const [105] = NameAndType [192] [193] 
.const [106] = Class [194] 
.const [107] = NameAndType [195] [196] 
.const [108] = Utf8 java/lang/NoClassDefFoundError 
.const [109] = Class [197] 
.const [110] = NameAndType [198] [199] 
.const [111] = Class [200] 
.const [112] = NameAndType [201] [202] 
.const [113] = Class [203] 
.const [114] = NameAndType [204] [205] 
.const [115] = Class [206] 
.const [116] = NameAndType [207] [208] 
.const [117] = Class [209] 
.const [118] = NameAndType [210] [211] 
.const [119] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [120] = Class [212] 
.const [121] = NameAndType [213] [214] 
.const [122] = Utf8 java/lang/Class 
.const [123] = Utf8 forName 
.const [124] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [125] = Utf8 de/audi/app/data/core/interapp/OnlineConnectivityStateProvider 
.const [126] = Utf8 ATTRIBUTE_NOTIFICATIONS 
.const [127] = Utf8 [I 
.const [128] = Utf8 de/audi/app/data/core/interapp/OnlineConnectivityStateProvider 
.const [129] = Utf8 class$de$audi$atip$interapp$online$IOnlineDataStateListener 
.const [130] = Utf8 Ljava/lang/Class; 
.const [131] = Utf8 de/audi/app/data/core/interapp/OnlineConnectivityStateProvider 
.const [132] = Utf8 class$ 
.const [133] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [134] = Utf8 java/lang/NoClassDefFoundError 
.const [135] = Utf8 initCause 
.const [136] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [137] = Utf8 de/audi/app/data/core/interapp/OnlineConnectivityStateProvider 
.const [138] = Utf8 log 
.const [139] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [140] = Utf8 de/audi/atip/log/LogChannel 
.const [141] = Utf8 log 
.const [142] = Utf8 (ILjava/lang/String;J)Z 
.const [143] = Utf8 de/audi/app/data/core/interapp/OnlineConnectivityStateProvider 
.const [144] = Utf8 roamingAllowed 
.const [145] = Utf8 Z 
.const [146] = Utf8 de/audi/app/data/core/interapp/OnlineConnectivityStateProvider 
.const [147] = Utf8 online 
.const [148] = Utf8 Lde/audi/atip/interapp/online/IOnlineDataStateListener; 
.const [149] = Utf8 de/audi/app/data/core/interapp/OnlineConnectivityStateProvider 
.const [150] = Utf8 bundleContext 
.const [151] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [152] = Utf8 java/lang/Class 
.const [153] = Utf8 getName 
.const [154] = Utf8 ()Ljava/lang/String; 
.const [155] = Utf8 de/audi/app/data/core/interapp/OnlineConnectivityStateProvider 
.const [156] = Utf8 tracker 
.const [157] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [158] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [159] = Utf8 'open' 
.const [160] = Utf8 ()V 
.const [161] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [162] = Utf8 close 
.const [163] = Utf8 ()V 
.const [164] = Utf8 java/lang/NoClassDefFoundError 
.const [165] = Utf8 <init> 
.const [166] = Utf8 ()V 
.const [167] = Utf8 de/audi/app/data/core/AbstractDataConfigurationComponent 
.const [168] = Utf8 <init> 
.const [169] = Utf8 (Lde/audi/app/data/core/IDataApplication;)V 
.const [170] = Utf8 de/audi/app/data/core/interapp/OnlineConnectivityStateProvider 
.const [171] = Utf8 ATTRIBUTE_NOTIFICATIONS 
.const [172] = Utf8 [I 
.const [173] = Utf8 de/audi/app/data/core/interapp/OnlineConnectivityStateProvider 
.const [174] = Utf8 updateState 
.const [175] = Utf8 ()V 
.const [176] = Utf8 de/audi/app/data/core/AbstractDataConfigurationComponent 
.const [177] = Utf8 addingService 
.const [178] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [179] = Utf8 de/audi/app/data/core/AbstractDataConfigurationComponent 
.const [180] = Utf8 modifiedService 
.const [181] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [182] = Utf8 de/audi/app/data/core/AbstractDataConfigurationComponent 
.const [183] = Utf8 removedService 
.const [184] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [185] = Utf8 de/audi/app/data/core/AbstractDataConfigurationComponent 
.const [186] = Utf8 init 
.const [187] = Utf8 ()V 
.const [188] = Utf8 de/audi/app/data/core/interapp/OnlineConnectivityStateProvider 
.const [189] = Utf8 class$de$audi$atip$interapp$online$IOnlineDataStateListener 
.const [190] = Utf8 Ljava/lang/Class; 
.const [191] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [192] = Utf8 <init> 
.const [193] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [194] = Utf8 de/audi/app/data/core/AbstractDataConfigurationComponent 
.const [195] = Utf8 deinit 
.const [196] = Utf8 ()V 
.const [197] = Utf8 de/audi/app/data/core/interapp/OnlineConnectivityStateProvider 
.const [198] = Utf8 roamingAllowed 
.const [199] = Utf8 Z 
.const [200] = Utf8 de/audi/app/data/core/interapp/OnlineConnectivityStateProvider 
.const [201] = Utf8 online 
.const [202] = Utf8 Lde/audi/atip/interapp/online/IOnlineDataStateListener; 
.const [203] = Utf8 de/audi/atip/interapp/online/IOnlineDataStateListener 
.const [204] = Utf8 updateRoamingSetting 
.const [205] = Utf8 (Z)V 
.const [206] = Utf8 org/osgi/framework/BundleContext 
.const [207] = Utf8 getService 
.const [208] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [209] = Utf8 org/osgi/framework/BundleContext 
.const [210] = Utf8 ungetService 
.const [211] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [212] = Utf8 de/audi/app/data/core/interapp/OnlineConnectivityStateProvider 
.const [213] = Utf8 tracker 
.const [214] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [215] = Utf8 de/audi/app/data/core/interapp/OnlineConnectivityStateProvider 
.const [216] = Class [215] 
.const [217] = Utf8 de/audi/app/data/core/AbstractDataConfigurationComponent 
.const [218] = Class [217] 
.const [219] = Utf8 ATTRIBUTE_NOTIFICATIONS 
.const [220] = Utf8 [I 
.const [221] = Utf8 tracker 
.const [222] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [223] = Utf8 online 
.const [224] = Utf8 Lde/audi/atip/interapp/online/IOnlineDataStateListener; 
.const [225] = Utf8 roamingAllowed 
.const [226] = Utf8 Z 
.const [227] = Utf8 class$de$audi$atip$interapp$online$IOnlineDataStateListener 
.const [228] = Utf8 Ljava/lang/Class; 
.const [229] = Utf8 Code 
.const [230] = Utf8 <init> 
.const [231] = Utf8 (Lde/audi/app/data/core/IDataApplication;)V 
.const [232] = Utf8 getAttributeNotifications 
.const [233] = Utf8 ()[I 
.const [234] = Utf8 updateRoamingState 
.const [235] = Utf8 (II)V 
.const [236] = Utf8 updateState 
.const [237] = Utf8 ()V 
.const [238] = Utf8 addingService 
.const [239] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [240] = Utf8 modifiedService 
.const [241] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [242] = Utf8 removedService 
.const [243] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [244] = Utf8 init 
.const [245] = Utf8 ()V 
.const [246] = Utf8 deinit 
.const [247] = Utf8 ()V 
.const [248] = Utf8 class$ 
.const [249] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [250] = Utf8 <clinit> 
.const [251] = Utf8 ()V 
.end class 
