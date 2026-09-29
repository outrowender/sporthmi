.version 50 0 
.class public super [184] 
.super [186] 
.implements [188] 
.field [189] [190] 
.field private [191] [192] 
.field private final [193] [194] 
.field private final [195] [196] 
.field static synthetic [197] [198] 

.method public [200] : [201] 
    .attribute [199] .code stack 3 locals 0 
L0:     aload_0 
L1:     ldc [5] 
L3:     invokespecial [34] 
L6:     aload_0 
L7:     aconst_null 
L8:     putfield [38] 
L11:    aload_0 
L12:    aload_1 
L13:    invokeinterface [39] 0 
L18:    putfield [40] 
L21:    aload_0 
L22:    aload_1 
L23:    ldc [6] 
L25:    invokeinterface [41] 0 
L30:    putfield [42] 
L33:    aload_0 
L34:    getfield [28] 
L37:    ldc [7] 
L39:    ldc [8] 
L41:    invokevirtual [29] 
L44:    pop 
L45:    return 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [202] : [203] 
    .attribute [199] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [28] 
L4:     ldc [7] 
L6:     ldc [9] 
L8:     invokevirtual [29] 
L11:    pop 
L12:    aload_0 
L13:    getfield [26] 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method protected [204] : [205] 
    .attribute [199] .code stack 9 locals 0 
L0:     aload_0 
L1:     getfield [28] 
L4:     ldc [7] 
L6:     ldc [10] 
L8:     invokevirtual [29] 
L11:    pop 
L12:    aload_0 
L13:    new [43] 
L16:    dup 
L17:    aload_0 
L18:    getfield [27] 
L21:    iconst_1 
L22:    anewarray [12] 
L25:    dup 
L26:    iconst_0 
L27:    getstatic [13] 
L30:    ifnonnull L45 
L33:    ldc [14] 
L35:    invokestatic [15] 
L38:    dup 
L39:    putstatic [35] 
L42:    goto L48 
L45:    getstatic [13] 
L48:    invokevirtual [30] 
L51:    aastore 
L52:    aload_0 
L53:    invokespecial [36] 
L56:    putfield [44] 
L59:    aload_0 
L60:    getfield [31] 
L63:    invokevirtual [32] 
L66:    return 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [206] : [207] 
    .attribute [199] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [28] 
L4:     ldc [7] 
L6:     ldc [16] 
L8:     invokevirtual [29] 
L11:    pop 
L12:    aload_0 
L13:    getfield [27] 
L16:    aload_1 
L17:    invokeinterface [45] 0 
L22:    astore_2 
L23:    aload_2 
L24:    instanceof [17] 
L27:    ifeq L40 
L30:    aload_0 
L31:    aload_2 
L32:    checkcast [17] 
L35:    putfield [38] 
L38:    aload_2 
L39:    areturn 
L40:    aconst_null 
L41:    areturn 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [208] : [209] 
    .attribute [199] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [28] 
L4:     ldc [7] 
L6:     ldc [18] 
L8:     invokevirtual [29] 
L11:    pop 
L12:    aload_2 
L13:    instanceof [17] 
L16:    ifeq L24 
L19:    aload_0 
L20:    aconst_null 
L21:    putfield [38] 
L24:    aload_0 
L25:    getfield [27] 
L28:    aload_1 
L29:    invokeinterface [46] 0 
L34:    pop 
L35:    return 
L36:    
    .end code 
.end method 

.method public enum [210] : [211] 
    .attribute [199] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method static synthetic [212] : [213] 
    .attribute [199] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [37] 
L9:     dup 
L10:    invokespecial [33] 
L13:    aload_1 
L14:    invokevirtual [25] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [47] [48] 
.const [3] = Class [49] 
.const [4] = Class [50] 
.const [5] = String [51] 
.const [6] = String [52] 
.const [7] = Int 1078071040 
.const [8] = String [53] 
.const [9] = String [54] 
.const [10] = String [55] 
.const [11] = Class [56] 
.const [12] = Class [57] 
.const [13] = Field [58] [59] 
.const [14] = String [60] 
.const [15] = Method [61] [62] 
.const [16] = String [63] 
.const [17] = Class [64] 
.const [18] = String [65] 
.const [19] = Class [66] 
.const [20] = Class [67] 
.const [21] = Class [68] 
.const [22] = Class [69] 
.const [23] = Class [70] 
.const [24] = Class [71] 
.const [25] = Method [72] [73] 
.const [26] = Field [74] [75] 
.const [27] = Field [76] [77] 
.const [28] = Field [78] [79] 
.const [29] = Method [80] [81] 
.const [30] = Method [82] [83] 
.const [31] = Field [84] [85] 
.const [32] = Method [86] [87] 
.const [33] = Method [88] [89] 
.const [34] = Method [90] [91] 
.const [35] = Field [92] [93] 
.const [36] = Method [94] [95] 
.const [37] = Class [96] 
.const [38] = Field [97] [98] 
.const [39] = InterfaceMethod [99] [100] 
.const [40] = Field [101] [102] 
.const [41] = InterfaceMethod [103] [104] 
.const [42] = Field [105] [106] 
.const [43] = Class [107] 
.const [44] = Field [108] [109] 
.const [45] = InterfaceMethod [110] [111] 
.const [46] = InterfaceMethod [112] [113] 
.const [47] = Class [114] 
.const [48] = NameAndType [115] [116] 
.const [49] = Utf8 java/lang/ClassNotFoundException 
.const [50] = Utf8 java/lang/NoClassDefFoundError 
.const [51] = Utf8 FwLogoProvider 
.const [52] = Utf8 'App.Online.Main' 
.const [53] = Utf8 'OnlineLogoActivator#OnlineLogoActivator()' 
.const [54] = Utf8 'OnlineLogoActivator#getService()' 
.const [55] = Utf8 'OnlineLogoActivator#startInternal()' 
.const [56] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [57] = Utf8 java/lang/String 
.const [58] = Class [117] 
.const [59] = NameAndType [118] [119] 
.const [60] = Utf8 'de.audi.atip.onlinelogo.IOnlineLogoProvider' 
.const [61] = Class [120] 
.const [62] = NameAndType [121] [122] 
.const [63] = Utf8 'OnlineLogoActivator#addingService()' 
.const [64] = Utf8 de/audi/atip/onlinelogo/IOnlineLogoProvider 
.const [65] = Utf8 'OnlineLogoActivator#removedService()' 
.const [66] = Utf8 de/audi/atip/onlinelogo/OnlineLogoActivator 
.const [67] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [68] = Utf8 java/lang/Class 
.const [69] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [70] = Utf8 de/audi/atip/log/LogChannel 
.const [71] = Utf8 org/osgi/framework/BundleContext 
.const [72] = Class [123] 
.const [73] = NameAndType [124] [125] 
.const [74] = Class [126] 
.const [75] = NameAndType [127] [128] 
.const [76] = Class [129] 
.const [77] = NameAndType [130] [131] 
.const [78] = Class [132] 
.const [79] = NameAndType [133] [134] 
.const [80] = Class [135] 
.const [81] = NameAndType [136] [137] 
.const [82] = Class [138] 
.const [83] = NameAndType [139] [140] 
.const [84] = Class [141] 
.const [85] = NameAndType [142] [143] 
.const [86] = Class [144] 
.const [87] = NameAndType [145] [146] 
.const [88] = Class [147] 
.const [89] = NameAndType [148] [149] 
.const [90] = Class [150] 
.const [91] = NameAndType [151] [152] 
.const [92] = Class [153] 
.const [93] = NameAndType [154] [155] 
.const [94] = Class [156] 
.const [95] = NameAndType [157] [158] 
.const [96] = Utf8 java/lang/NoClassDefFoundError 
.const [97] = Class [159] 
.const [98] = NameAndType [160] [161] 
.const [99] = Class [162] 
.const [100] = NameAndType [163] [164] 
.const [101] = Class [165] 
.const [102] = NameAndType [166] [167] 
.const [103] = Class [168] 
.const [104] = NameAndType [169] [170] 
.const [105] = Class [171] 
.const [106] = NameAndType [172] [173] 
.const [107] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [108] = Class [174] 
.const [109] = NameAndType [175] [176] 
.const [110] = Class [177] 
.const [111] = NameAndType [178] [179] 
.const [112] = Class [180] 
.const [113] = NameAndType [181] [182] 
.const [114] = Utf8 java/lang/Class 
.const [115] = Utf8 forName 
.const [116] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [117] = Utf8 de/audi/atip/onlinelogo/OnlineLogoActivator 
.const [118] = Utf8 class$de$audi$atip$onlinelogo$IOnlineLogoProvider 
.const [119] = Utf8 Ljava/lang/Class; 
.const [120] = Utf8 de/audi/atip/onlinelogo/OnlineLogoActivator 
.const [121] = Utf8 class$ 
.const [122] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [123] = Utf8 java/lang/NoClassDefFoundError 
.const [124] = Utf8 initCause 
.const [125] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [126] = Utf8 de/audi/atip/onlinelogo/OnlineLogoActivator 
.const [127] = Utf8 service 
.const [128] = Utf8 Lde/audi/atip/onlinelogo/IOnlineLogoProvider; 
.const [129] = Utf8 de/audi/atip/onlinelogo/OnlineLogoActivator 
.const [130] = Utf8 bundleContext 
.const [131] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [132] = Utf8 de/audi/atip/onlinelogo/OnlineLogoActivator 
.const [133] = Utf8 log 
.const [134] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [135] = Utf8 de/audi/atip/log/LogChannel 
.const [136] = Utf8 log 
.const [137] = Utf8 (ILjava/lang/String;)Z 
.const [138] = Utf8 java/lang/Class 
.const [139] = Utf8 getName 
.const [140] = Utf8 ()Ljava/lang/String; 
.const [141] = Utf8 de/audi/atip/onlinelogo/OnlineLogoActivator 
.const [142] = Utf8 tracker 
.const [143] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [144] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [145] = Utf8 'open' 
.const [146] = Utf8 ()V 
.const [147] = Utf8 java/lang/NoClassDefFoundError 
.const [148] = Utf8 <init> 
.const [149] = Utf8 ()V 
.const [150] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [151] = Utf8 <init> 
.const [152] = Utf8 (Ljava/lang/String;)V 
.const [153] = Utf8 de/audi/atip/onlinelogo/OnlineLogoActivator 
.const [154] = Utf8 class$de$audi$atip$onlinelogo$IOnlineLogoProvider 
.const [155] = Utf8 Ljava/lang/Class; 
.const [156] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [157] = Utf8 <init> 
.const [158] = Utf8 (Lorg/osgi/framework/BundleContext;[Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [159] = Utf8 de/audi/atip/onlinelogo/OnlineLogoActivator 
.const [160] = Utf8 service 
.const [161] = Utf8 Lde/audi/atip/onlinelogo/IOnlineLogoProvider; 
.const [162] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [163] = Utf8 getBundleCxt 
.const [164] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [165] = Utf8 de/audi/atip/onlinelogo/OnlineLogoActivator 
.const [166] = Utf8 bundleContext 
.const [167] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [168] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [169] = Utf8 getLogChannel 
.const [170] = Utf8 (Ljava/lang/String;)Lde/audi/atip/log/LogChannel; 
.const [171] = Utf8 de/audi/atip/onlinelogo/OnlineLogoActivator 
.const [172] = Utf8 log 
.const [173] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [174] = Utf8 de/audi/atip/onlinelogo/OnlineLogoActivator 
.const [175] = Utf8 tracker 
.const [176] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [177] = Utf8 org/osgi/framework/BundleContext 
.const [178] = Utf8 getService 
.const [179] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [180] = Utf8 org/osgi/framework/BundleContext 
.const [181] = Utf8 ungetService 
.const [182] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [183] = Utf8 de/audi/atip/onlinelogo/OnlineLogoActivator 
.const [184] = Class [183] 
.const [185] = Utf8 de/audi/atip/activator/AbstractFrameworkActivator 
.const [186] = Class [185] 
.const [187] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [188] = Class [187] 
.const [189] = Utf8 service 
.const [190] = Utf8 Lde/audi/atip/onlinelogo/IOnlineLogoProvider; 
.const [191] = Utf8 tracker 
.const [192] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [193] = Utf8 bundleContext 
.const [194] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [195] = Utf8 log 
.const [196] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [197] = Utf8 class$de$audi$atip$onlinelogo$IOnlineLogoProvider 
.const [198] = Utf8 Ljava/lang/Class; 
.const [199] = Utf8 Code 
.const [200] = Utf8 <init> 
.const [201] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [202] = Utf8 getService 
.const [203] = Utf8 ()Lde/audi/atip/onlinelogo/IOnlineLogoProvider; 
.const [204] = Utf8 startInternal 
.const [205] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [206] = Utf8 addingService 
.const [207] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [208] = Utf8 removedService 
.const [209] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [210] = Utf8 modifiedService 
.const [211] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [212] = Utf8 class$ 
.const [213] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
