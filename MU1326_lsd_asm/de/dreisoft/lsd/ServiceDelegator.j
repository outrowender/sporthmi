.version 50 0 
.class public final super [187] 
.super [189] 
.implements [191] 
.field private [192] [193] 
.field public static final [194] [195] 
.field private static final [196] [197] 
.field private static [198] [199] 
.field static synthetic [200] [201] 

.method public static [203] : [204] 
    .attribute [202] .code stack 5 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     anewarray [5] 
L5:     dup 
L6:     iconst_0 
L7:     aload_1 
L8:     aastore 
L9:     aload_2 
L10:    aload_3 
L11:    invokestatic [6] 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method public static [205] : [206] 
    .attribute [202] .code stack 6 locals 1 
L0:     getstatic [7] 
L3:     ifnull L38 
L6:     getstatic [7] 
L9:     new [40] 
L12:    dup 
L13:    aload_0 
L14:    invokespecial [33] 
L17:    aload_1 
L18:    aload_2 
L19:    aload_3 
L20:    invokeinterface [41] 0 
L25:    astore 4 
L27:    aload 4 
L29:    ifnull L38 
L32:    aload 4 
L34:    checkcast [9] 
L37:    areturn 
L38:    new [42] 
L41:    dup 
L42:    aload_0 
L43:    aload_1 
L44:    aload_2 
L45:    aload_3 
L46:    invokespecial [34] 
L49:    areturn 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method private [207] : [208] 
    .attribute [202] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [35] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [43] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [209] : [210] 
    .attribute [202] .code stack 6 locals 0 
L0:     new [42] 
L3:     dup 
L4:     aload_0 
L5:     getfield [25] 
L8:     aload_1 
L9:     aload_2 
L10:    aload_3 
L11:    invokespecial [36] 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [211] : [212] 
    .attribute [202] .code stack 6 locals 0 
L0:     new [42] 
L3:     dup 
L4:     aload_0 
L5:     getfield [25] 
L8:     aload_1 
L9:     aload_2 
L10:    aload_3 
L11:    invokespecial [34] 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method static [213] : [214] 
    .attribute [202] .code stack 3 locals 3 
L0:     aload_0 
L1:     ifnull L94 
L4:     getstatic [10] 
L7:     new [44] 
L10:    dup 
L11:    invokespecial [37] 
L14:    ldc [12] 
L16:    invokevirtual [26] 
L19:    aload_0 
L20:    invokevirtual [26] 
L23:    invokevirtual [27] 
L26:    invokevirtual [28] 
        .catch [17] from L29 to L86 using L89 
L29:    aload_0 
L30:    invokestatic [2] 
L33:    astore_1 
L34:    aload_1 
L35:    ifnull L86 
L38:    getstatic [13] 
L41:    ifnonnull L56 
L44:    ldc [14] 
L46:    invokestatic [15] 
L49:    dup 
L50:    putstatic [38] 
L53:    goto L59 
L56:    getstatic [13] 
L59:    aload_1 
L60:    invokevirtual [29] 
L63:    ifeq L86 
L66:    aload_1 
L67:    invokevirtual [30] 
L70:    astore_2 
L71:    aload_2 
L72:    checkcast [16] 
L75:    astore_3 
L76:    aload_3 
L77:    invokeinterface [45] 0 
L82:    aload_3 
L83:    putstatic [32] 
L86:    goto L94 
L89:    astore_1 
L90:    aconst_null 
L91:    putstatic [32] 
L94:    return 
L95:    nop 
L96:    
    .end code 
.end method 

.method static synthetic [215] : [216] 
    .attribute [202] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [39] 
L9:     dup 
L10:    invokespecial [31] 
L13:    aload_1 
L14:    invokevirtual [24] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [46] [47] 
.const [3] = Class [48] 
.const [4] = Class [49] 
.const [5] = Class [50] 
.const [6] = Method [51] [52] 
.const [7] = Field [53] [54] 
.const [8] = Class [55] 
.const [9] = Class [56] 
.const [10] = Field [57] [58] 
.const [11] = Class [59] 
.const [12] = String [60] 
.const [13] = Field [61] [62] 
.const [14] = String [63] 
.const [15] = Method [64] [65] 
.const [16] = Class [66] 
.const [17] = Class [67] 
.const [18] = Class [68] 
.const [19] = String [69] 
.const [20] = String [70] 
.const [21] = Class [71] 
.const [22] = Class [72] 
.const [23] = Class [73] 
.const [24] = Method [74] [75] 
.const [25] = Field [76] [77] 
.const [26] = Method [78] [79] 
.const [27] = Method [80] [81] 
.const [28] = Method [82] [83] 
.const [29] = Method [84] [85] 
.const [30] = Method [86] [87] 
.const [31] = Method [88] [89] 
.const [32] = Field [90] [91] 
.const [33] = Method [92] [93] 
.const [34] = Method [94] [95] 
.const [35] = Method [96] [97] 
.const [36] = Method [98] [99] 
.const [37] = Method [100] [101] 
.const [38] = Field [102] [103] 
.const [39] = Class [104] 
.const [40] = Class [105] 
.const [41] = InterfaceMethod [106] [107] 
.const [42] = Class [108] 
.const [43] = Field [109] [110] 
.const [44] = Class [111] 
.const [45] = InterfaceMethod [112] [113] 
.const [46] = Class [114] 
.const [47] = NameAndType [115] [116] 
.const [48] = Utf8 java/lang/ClassNotFoundException 
.const [49] = Utf8 java/lang/NoClassDefFoundError 
.const [50] = Utf8 java/lang/String 
.const [51] = Class [117] 
.const [52] = NameAndType [118] [119] 
.const [53] = Class [120] 
.const [54] = NameAndType [121] [122] 
.const [55] = Utf8 de/dreisoft/lsd/ServiceDelegator 
.const [56] = Utf8 de/dreisoft/lsd/ServiceInfo 
.const [57] = Class [123] 
.const [58] = NameAndType [124] [125] 
.const [59] = Utf8 java/lang/StringBuffer 
.const [60] = Utf8 'Installing service delegator: ' 
.const [61] = Class [126] 
.const [62] = NameAndType [127] [128] 
.const [63] = Utf8 'de.dreisoft.lsd.IServiceDelegateConfigurator' 
.const [64] = Class [129] 
.const [65] = NameAndType [130] [131] 
.const [66] = Utf8 de/dreisoft/lsd/IServiceDelegateConfigurator 
.const [67] = Utf8 java/lang/Exception 
.const [68] = Utf8 java/lang/Object 
.const [69] = Utf8 'de.audi.tghu.serviceDelegateConfigurator' 
.const [70] = Utf8 'de.audi.tghu.dsitrace.TraceConfigurator' 
.const [71] = Utf8 java/lang/Class 
.const [72] = Utf8 java/lang/System 
.const [73] = Utf8 java/io/PrintStream 
.const [74] = Class [132] 
.const [75] = NameAndType [133] [134] 
.const [76] = Class [135] 
.const [77] = NameAndType [136] [137] 
.const [78] = Class [138] 
.const [79] = NameAndType [139] [140] 
.const [80] = Class [141] 
.const [81] = NameAndType [142] [143] 
.const [82] = Class [144] 
.const [83] = NameAndType [145] [146] 
.const [84] = Class [147] 
.const [85] = NameAndType [148] [149] 
.const [86] = Class [150] 
.const [87] = NameAndType [151] [152] 
.const [88] = Class [153] 
.const [89] = NameAndType [154] [155] 
.const [90] = Class [156] 
.const [91] = NameAndType [157] [158] 
.const [92] = Class [159] 
.const [93] = NameAndType [160] [161] 
.const [94] = Class [162] 
.const [95] = NameAndType [163] [164] 
.const [96] = Class [165] 
.const [97] = NameAndType [166] [167] 
.const [98] = Class [168] 
.const [99] = NameAndType [169] [170] 
.const [100] = Class [171] 
.const [101] = NameAndType [172] [173] 
.const [102] = Class [174] 
.const [103] = NameAndType [175] [176] 
.const [104] = Utf8 java/lang/NoClassDefFoundError 
.const [105] = Utf8 de/dreisoft/lsd/ServiceDelegator 
.const [106] = Class [177] 
.const [107] = NameAndType [178] [179] 
.const [108] = Utf8 de/dreisoft/lsd/ServiceInfo 
.const [109] = Class [180] 
.const [110] = NameAndType [181] [182] 
.const [111] = Utf8 java/lang/StringBuffer 
.const [112] = Class [183] 
.const [113] = NameAndType [184] [185] 
.const [114] = Utf8 java/lang/Class 
.const [115] = Utf8 forName 
.const [116] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [117] = Utf8 de/dreisoft/lsd/ServiceDelegator 
.const [118] = Utf8 getServiceInfo 
.const [119] = Utf8 (Lde/dreisoft/lsd/BundleInfo;[Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lde/dreisoft/lsd/ServiceInfo; 
.const [120] = Utf8 de/dreisoft/lsd/ServiceDelegator 
.const [121] = Utf8 configurator 
.const [122] = Utf8 Lde/dreisoft/lsd/IServiceDelegateConfigurator; 
.const [123] = Utf8 java/lang/System 
.const [124] = Utf8 out 
.const [125] = Utf8 Ljava/io/PrintStream; 
.const [126] = Utf8 de/dreisoft/lsd/ServiceDelegator 
.const [127] = Utf8 class$de$dreisoft$lsd$IServiceDelegateConfigurator 
.const [128] = Utf8 Ljava/lang/Class; 
.const [129] = Utf8 de/dreisoft/lsd/ServiceDelegator 
.const [130] = Utf8 class$ 
.const [131] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [132] = Utf8 java/lang/NoClassDefFoundError 
.const [133] = Utf8 initCause 
.const [134] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [135] = Utf8 de/dreisoft/lsd/ServiceDelegator 
.const [136] = Utf8 mBundleInfo 
.const [137] = Utf8 Lde/dreisoft/lsd/BundleInfo; 
.const [138] = Utf8 java/lang/StringBuffer 
.const [139] = Utf8 append 
.const [140] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [141] = Utf8 java/lang/StringBuffer 
.const [142] = Utf8 toString 
.const [143] = Utf8 ()Ljava/lang/String; 
.const [144] = Utf8 java/io/PrintStream 
.const [145] = Utf8 println 
.const [146] = Utf8 (Ljava/lang/String;)V 
.const [147] = Utf8 java/lang/Class 
.const [148] = Utf8 isAssignableFrom 
.const [149] = Utf8 (Ljava/lang/Class;)Z 
.const [150] = Utf8 java/lang/Class 
.const [151] = Utf8 newInstance 
.const [152] = Utf8 ()Ljava/lang/Object; 
.const [153] = Utf8 java/lang/NoClassDefFoundError 
.const [154] = Utf8 <init> 
.const [155] = Utf8 ()V 
.const [156] = Utf8 de/dreisoft/lsd/ServiceDelegator 
.const [157] = Utf8 configurator 
.const [158] = Utf8 Lde/dreisoft/lsd/IServiceDelegateConfigurator; 
.const [159] = Utf8 de/dreisoft/lsd/ServiceDelegator 
.const [160] = Utf8 <init> 
.const [161] = Utf8 (Lde/dreisoft/lsd/BundleInfo;)V 
.const [162] = Utf8 de/dreisoft/lsd/ServiceInfo 
.const [163] = Utf8 <init> 
.const [164] = Utf8 (Lde/dreisoft/lsd/BundleInfo;[Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)V 
.const [165] = Utf8 java/lang/Object 
.const [166] = Utf8 <init> 
.const [167] = Utf8 ()V 
.const [168] = Utf8 de/dreisoft/lsd/ServiceInfo 
.const [169] = Utf8 <init> 
.const [170] = Utf8 (Lde/dreisoft/lsd/BundleInfo;Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)V 
.const [171] = Utf8 java/lang/StringBuffer 
.const [172] = Utf8 <init> 
.const [173] = Utf8 ()V 
.const [174] = Utf8 de/dreisoft/lsd/ServiceDelegator 
.const [175] = Utf8 class$de$dreisoft$lsd$IServiceDelegateConfigurator 
.const [176] = Utf8 Ljava/lang/Class; 
.const [177] = Utf8 de/dreisoft/lsd/IServiceDelegateConfigurator 
.const [178] = Utf8 getServiceRegistration 
.const [179] = Utf8 (Lde/dreisoft/lsd/IServiceDelegator;[Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [180] = Utf8 de/dreisoft/lsd/ServiceDelegator 
.const [181] = Utf8 mBundleInfo 
.const [182] = Utf8 Lde/dreisoft/lsd/BundleInfo; 
.const [183] = Utf8 de/dreisoft/lsd/IServiceDelegateConfigurator 
.const [184] = Utf8 initConfigurator 
.const [185] = Utf8 ()V 
.const [186] = Utf8 de/dreisoft/lsd/ServiceDelegator 
.const [187] = Class [186] 
.const [188] = Utf8 java/lang/Object 
.const [189] = Class [188] 
.const [190] = Utf8 de/dreisoft/lsd/IServiceDelegator 
.const [191] = Class [190] 
.const [192] = Utf8 mBundleInfo 
.const [193] = Utf8 Lde/dreisoft/lsd/BundleInfo; 
.const [194] = Utf8 PROP_KEY_DELEGATE_CONFIGURATOR 
.const [195] = Utf8 Ljava/lang/String; 
.const [196] = Utf8 DEFAULT_CONFIGURATOR_CLASS 
.const [197] = Utf8 Ljava/lang/String; 
.const [198] = Utf8 configurator 
.const [199] = Utf8 Lde/dreisoft/lsd/IServiceDelegateConfigurator; 
.const [200] = Utf8 class$de$dreisoft$lsd$IServiceDelegateConfigurator 
.const [201] = Utf8 Ljava/lang/Class; 
.const [202] = Utf8 Code 
.const [203] = Utf8 getServiceInfo 
.const [204] = Utf8 (Lde/dreisoft/lsd/BundleInfo;Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lde/dreisoft/lsd/ServiceInfo; 
.const [205] = Utf8 getServiceInfo 
.const [206] = Utf8 (Lde/dreisoft/lsd/BundleInfo;[Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lde/dreisoft/lsd/ServiceInfo; 
.const [207] = Utf8 <init> 
.const [208] = Utf8 (Lde/dreisoft/lsd/BundleInfo;)V 
.const [209] = Utf8 createServiceRegistration 
.const [210] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [211] = Utf8 createServiceRegistration 
.const [212] = Utf8 ([Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [213] = Utf8 initConfigurator 
.const [214] = Utf8 (Ljava/lang/String;)V 
.const [215] = Utf8 class$ 
.const [216] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
