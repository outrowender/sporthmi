.version 50 0 
.class public super [173] 
.super [175] 
.field [176] [177] 
.field [178] [179] 
.field [180] [181] 
.field static synthetic [182] [183] 

.method public annotation [185] : [186] 
    .attribute [184] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [187] : [188] 
    .attribute [184] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [26] 
L5:     aload_0 
L6:     new [34] 
L9:     dup 
L10:    aload_0 
L11:    invokevirtual [16] 
L14:    aload_1 
L15:    invokespecial [27] 
L18:    putfield [35] 
L21:    aload_0 
L22:    getfield [17] 
L25:    invokevirtual [18] 
L28:    aload_0 
L29:    invokespecial [28] 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [189] : [190] 
    .attribute [184] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     ifnull L19 
L7:     aload_0 
L8:     getfield [19] 
L11:    invokevirtual [20] 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [36] 
L19:    aload_0 
L20:    aload_1 
L21:    invokespecial [29] 
L24:    aload_0 
L25:    getfield [17] 
L28:    invokevirtual [21] 
L31:    return 
L32:    
    .end code 
.end method 

.method private [191] : [192] 
    .attribute [184] .code stack 8 locals 0 
L0:     aload_0 
L1:     new [37] 
L4:     dup 
L5:     aload_0 
L6:     getfield [14] 
L9:     getstatic [7] 
L12:    ifnonnull L27 
L15:    ldc [8] 
L17:    invokestatic [9] 
L20:    dup 
L21:    putstatic [30] 
L24:    goto L30 
L27:    getstatic [7] 
L30:    invokevirtual [22] 
L33:    new [38] 
L36:    dup 
L37:    aload_0 
L38:    invokespecial [31] 
L41:    invokespecial [32] 
L44:    putfield [36] 
L47:    aload_0 
L48:    getfield [19] 
L51:    invokevirtual [23] 
L54:    return 
L55:    nop 
L56:    
    .end code 
.end method 

.method static synthetic [193] : [194] 
    .attribute [184] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [33] 
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

.method static synthetic [195] : [196] 
    .attribute [184] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [197] : [198] 
    .attribute [184] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [199] : [200] 
    .attribute [184] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [39] [40] 
.const [3] = Class [41] 
.const [4] = Class [42] 
.const [5] = Class [43] 
.const [6] = Class [44] 
.const [7] = Field [45] [46] 
.const [8] = String [47] 
.const [9] = Method [48] [49] 
.const [10] = Class [50] 
.const [11] = Class [51] 
.const [12] = Class [52] 
.const [13] = Class [53] 
.const [14] = Field [54] [55] 
.const [15] = Method [56] [57] 
.const [16] = Method [58] [59] 
.const [17] = Field [60] [61] 
.const [18] = Method [62] [63] 
.const [19] = Field [64] [65] 
.const [20] = Method [66] [67] 
.const [21] = Method [68] [69] 
.const [22] = Method [70] [71] 
.const [23] = Method [72] [73] 
.const [24] = Method [74] [75] 
.const [25] = Method [76] [77] 
.const [26] = Method [78] [79] 
.const [27] = Method [80] [81] 
.const [28] = Method [82] [83] 
.const [29] = Method [84] [85] 
.const [30] = Field [86] [87] 
.const [31] = Method [88] [89] 
.const [32] = Method [90] [91] 
.const [33] = Class [92] 
.const [34] = Class [93] 
.const [35] = Field [94] [95] 
.const [36] = Field [96] [97] 
.const [37] = Class [98] 
.const [38] = Class [99] 
.const [39] = Class [100] 
.const [40] = NameAndType [101] [102] 
.const [41] = Utf8 java/lang/ClassNotFoundException 
.const [42] = Utf8 java/lang/NoClassDefFoundError 
.const [43] = Utf8 de/audi/app/testsupport/TestSupportApplication 
.const [44] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [45] = Class [103] 
.const [46] = NameAndType [104] [105] 
.const [47] = Utf8 'de.audi.atip.diag.sw.SwDiagnosisManager' 
.const [48] = Class [106] 
.const [49] = NameAndType [107] [108] 
.const [50] = Utf8 de/audi/app/testsupport/Activator$1 
.const [51] = Utf8 de/audi/app/testsupport/Activator 
.const [52] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [53] = Utf8 java/lang/Class 
.const [54] = Class [109] 
.const [55] = NameAndType [110] [111] 
.const [56] = Class [112] 
.const [57] = NameAndType [113] [114] 
.const [58] = Class [115] 
.const [59] = NameAndType [116] [117] 
.const [60] = Class [118] 
.const [61] = NameAndType [119] [120] 
.const [62] = Class [121] 
.const [63] = NameAndType [122] [123] 
.const [64] = Class [124] 
.const [65] = NameAndType [125] [126] 
.const [66] = Class [127] 
.const [67] = NameAndType [128] [129] 
.const [68] = Class [130] 
.const [69] = NameAndType [131] [132] 
.const [70] = Class [133] 
.const [71] = NameAndType [134] [135] 
.const [72] = Class [136] 
.const [73] = NameAndType [137] [138] 
.const [74] = Class [139] 
.const [75] = NameAndType [140] [141] 
.const [76] = Class [142] 
.const [77] = NameAndType [143] [144] 
.const [78] = Class [145] 
.const [79] = NameAndType [146] [147] 
.const [80] = Class [148] 
.const [81] = NameAndType [149] [150] 
.const [82] = Class [151] 
.const [83] = NameAndType [152] [153] 
.const [84] = Class [154] 
.const [85] = NameAndType [155] [156] 
.const [86] = Class [157] 
.const [87] = NameAndType [158] [159] 
.const [88] = Class [160] 
.const [89] = NameAndType [161] [162] 
.const [90] = Class [163] 
.const [91] = NameAndType [164] [165] 
.const [92] = Utf8 java/lang/NoClassDefFoundError 
.const [93] = Utf8 de/audi/app/testsupport/TestSupportApplication 
.const [94] = Class [166] 
.const [95] = NameAndType [167] [168] 
.const [96] = Class [169] 
.const [97] = NameAndType [170] [171] 
.const [98] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [99] = Utf8 de/audi/app/testsupport/Activator$1 
.const [100] = Utf8 java/lang/Class 
.const [101] = Utf8 forName 
.const [102] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [103] = Utf8 de/audi/app/testsupport/Activator 
.const [104] = Utf8 class$de$audi$atip$diag$sw$SwDiagnosisManager 
.const [105] = Utf8 Ljava/lang/Class; 
.const [106] = Utf8 de/audi/app/testsupport/Activator 
.const [107] = Utf8 class$ 
.const [108] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [109] = Utf8 de/audi/app/testsupport/Activator 
.const [110] = Utf8 bundleContext 
.const [111] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [112] = Utf8 java/lang/NoClassDefFoundError 
.const [113] = Utf8 initCause 
.const [114] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [115] = Utf8 de/audi/app/testsupport/Activator 
.const [116] = Utf8 getFramework 
.const [117] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [118] = Utf8 de/audi/app/testsupport/Activator 
.const [119] = Utf8 app 
.const [120] = Utf8 Lde/audi/app/testsupport/TestSupportApplication; 
.const [121] = Utf8 de/audi/app/testsupport/TestSupportApplication 
.const [122] = Utf8 init 
.const [123] = Utf8 ()V 
.const [124] = Utf8 de/audi/app/testsupport/Activator 
.const [125] = Utf8 diagTracker 
.const [126] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [127] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [128] = Utf8 close 
.const [129] = Utf8 ()V 
.const [130] = Utf8 de/audi/app/testsupport/TestSupportApplication 
.const [131] = Utf8 deinit 
.const [132] = Utf8 ()V 
.const [133] = Utf8 java/lang/Class 
.const [134] = Utf8 getName 
.const [135] = Utf8 ()Ljava/lang/String; 
.const [136] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [137] = Utf8 'open' 
.const [138] = Utf8 ()V 
.const [139] = Utf8 java/lang/NoClassDefFoundError 
.const [140] = Utf8 <init> 
.const [141] = Utf8 ()V 
.const [142] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [143] = Utf8 <init> 
.const [144] = Utf8 ()V 
.const [145] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [146] = Utf8 start 
.const [147] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [148] = Utf8 de/audi/app/testsupport/TestSupportApplication 
.const [149] = Utf8 <init> 
.const [150] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;Lorg/osgi/framework/BundleContext;)V 
.const [151] = Utf8 de/audi/app/testsupport/Activator 
.const [152] = Utf8 initTracker 
.const [153] = Utf8 ()V 
.const [154] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [155] = Utf8 stop 
.const [156] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [157] = Utf8 de/audi/app/testsupport/Activator 
.const [158] = Utf8 class$de$audi$atip$diag$sw$SwDiagnosisManager 
.const [159] = Utf8 Ljava/lang/Class; 
.const [160] = Utf8 de/audi/app/testsupport/Activator$1 
.const [161] = Utf8 <init> 
.const [162] = Utf8 (Lde/audi/app/testsupport/Activator;)V 
.const [163] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [164] = Utf8 <init> 
.const [165] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [166] = Utf8 de/audi/app/testsupport/Activator 
.const [167] = Utf8 app 
.const [168] = Utf8 Lde/audi/app/testsupport/TestSupportApplication; 
.const [169] = Utf8 de/audi/app/testsupport/Activator 
.const [170] = Utf8 diagTracker 
.const [171] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [172] = Utf8 de/audi/app/testsupport/Activator 
.const [173] = Class [172] 
.const [174] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [175] = Class [174] 
.const [176] = Utf8 app 
.const [177] = Utf8 Lde/audi/app/testsupport/TestSupportApplication; 
.const [178] = Utf8 diagGateway 
.const [179] = Utf8 Lde/mib/swdiagnosis/info/AppTestSupportDiag; 
.const [180] = Utf8 diagTracker 
.const [181] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [182] = Utf8 class$de$audi$atip$diag$sw$SwDiagnosisManager 
.const [183] = Utf8 Ljava/lang/Class; 
.const [184] = Utf8 Code 
.const [185] = Utf8 <init> 
.const [186] = Utf8 ()V 
.const [187] = Utf8 start 
.const [188] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [189] = Utf8 stop 
.const [190] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [191] = Utf8 initTracker 
.const [192] = Utf8 ()V 
.const [193] = Utf8 class$ 
.const [194] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [195] = Utf8 access$000 
.const [196] = Utf8 (Lde/audi/app/testsupport/Activator;)Lorg/osgi/framework/BundleContext; 
.const [197] = Utf8 access$100 
.const [198] = Utf8 (Lde/audi/app/testsupport/Activator;)Lorg/osgi/framework/BundleContext; 
.const [199] = Utf8 access$200 
.const [200] = Utf8 (Lde/audi/app/testsupport/Activator;)Lorg/osgi/framework/BundleContext; 
.end class 
