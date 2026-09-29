.version 50 0 
.class public super [115] 
.super [117] 
.implements [119] 
.field private [120] [121] 
.field private [122] [123] 
.field static synthetic [124] [125] 

.method public [127] : [128] 
    .attribute [126] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [19] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [23] 
L9:     aload_0 
L10:    aconst_null 
L11:    putfield [24] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [129] : [130] 
    .attribute [126] .code stack 5 locals 0 
L0:     aload_0 
L1:     new [25] 
L4:     dup 
L5:     invokespecial [20] 
L8:     putfield [24] 
L11:    aload_0 
L12:    aload_1 
L13:    getstatic [6] 
L16:    ifnonnull L31 
L19:    ldc [7] 
L21:    invokestatic [8] 
L24:    dup 
L25:    putstatic [21] 
L28:    goto L34 
L31:    getstatic [6] 
L34:    invokevirtual [17] 
L37:    aload_0 
L38:    getfield [16] 
L41:    aconst_null 
L42:    invokeinterface [26] 0 
L47:    putfield [23] 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [131] : [132] 
    .attribute [126] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     ifnull L16 
L7:     aload_0 
L8:     getfield [15] 
L11:    invokeinterface [27] 0 
L16:    aload_0 
L17:    aconst_null 
L18:    putfield [23] 
L21:    aload_0 
L22:    aconst_null 
L23:    putfield [24] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method static synthetic [133] : [134] 
    .attribute [126] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [22] 
L9:     dup 
L10:    invokespecial [18] 
L13:    aload_1 
L14:    invokevirtual [14] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [28] [29] 
.const [3] = Class [30] 
.const [4] = Class [31] 
.const [5] = Class [32] 
.const [6] = Field [33] [34] 
.const [7] = String [35] 
.const [8] = Method [36] [37] 
.const [9] = Class [38] 
.const [10] = Class [39] 
.const [11] = Class [40] 
.const [12] = Class [41] 
.const [13] = Class [42] 
.const [14] = Method [43] [44] 
.const [15] = Field [45] [46] 
.const [16] = Field [47] [48] 
.const [17] = Method [49] [50] 
.const [18] = Method [51] [52] 
.const [19] = Method [53] [54] 
.const [20] = Method [55] [56] 
.const [21] = Field [57] [58] 
.const [22] = Class [59] 
.const [23] = Field [60] [61] 
.const [24] = Field [62] [63] 
.const [25] = Class [64] 
.const [26] = InterfaceMethod [65] [66] 
.const [27] = InterfaceMethod [67] [68] 
.const [28] = Class [69] 
.const [29] = NameAndType [70] [71] 
.const [30] = Utf8 java/lang/ClassNotFoundException 
.const [31] = Utf8 java/lang/NoClassDefFoundError 
.const [32] = Utf8 de/audi/tghu/dsi/high/HighFacadeFactory 
.const [33] = Class [72] 
.const [34] = NameAndType [73] [74] 
.const [35] = Utf8 'de.audi.tghu.dsi.IFacadeFactory' 
.const [36] = Class [75] 
.const [37] = NameAndType [76] [77] 
.const [38] = Utf8 de/audi/tghu/dsi/high/Activator 
.const [39] = Utf8 java/lang/Object 
.const [40] = Utf8 java/lang/Class 
.const [41] = Utf8 org/osgi/framework/BundleContext 
.const [42] = Utf8 org/osgi/framework/ServiceRegistration 
.const [43] = Class [78] 
.const [44] = NameAndType [79] [80] 
.const [45] = Class [81] 
.const [46] = NameAndType [82] [83] 
.const [47] = Class [84] 
.const [48] = NameAndType [85] [86] 
.const [49] = Class [87] 
.const [50] = NameAndType [88] [89] 
.const [51] = Class [90] 
.const [52] = NameAndType [91] [92] 
.const [53] = Class [93] 
.const [54] = NameAndType [94] [95] 
.const [55] = Class [96] 
.const [56] = NameAndType [97] [98] 
.const [57] = Class [99] 
.const [58] = NameAndType [100] [101] 
.const [59] = Utf8 java/lang/NoClassDefFoundError 
.const [60] = Class [102] 
.const [61] = NameAndType [103] [104] 
.const [62] = Class [105] 
.const [63] = NameAndType [106] [107] 
.const [64] = Utf8 de/audi/tghu/dsi/high/HighFacadeFactory 
.const [65] = Class [108] 
.const [66] = NameAndType [109] [110] 
.const [67] = Class [111] 
.const [68] = NameAndType [112] [113] 
.const [69] = Utf8 java/lang/Class 
.const [70] = Utf8 forName 
.const [71] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [72] = Utf8 de/audi/tghu/dsi/high/Activator 
.const [73] = Utf8 class$de$audi$tghu$dsi$IFacadeFactory 
.const [74] = Utf8 Ljava/lang/Class; 
.const [75] = Utf8 de/audi/tghu/dsi/high/Activator 
.const [76] = Utf8 class$ 
.const [77] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [78] = Utf8 java/lang/NoClassDefFoundError 
.const [79] = Utf8 initCause 
.const [80] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [81] = Utf8 de/audi/tghu/dsi/high/Activator 
.const [82] = Utf8 sregFactory 
.const [83] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [84] = Utf8 de/audi/tghu/dsi/high/Activator 
.const [85] = Utf8 factory 
.const [86] = Utf8 Lde/audi/tghu/dsi/IFacadeFactory; 
.const [87] = Utf8 java/lang/Class 
.const [88] = Utf8 getName 
.const [89] = Utf8 ()Ljava/lang/String; 
.const [90] = Utf8 java/lang/NoClassDefFoundError 
.const [91] = Utf8 <init> 
.const [92] = Utf8 ()V 
.const [93] = Utf8 java/lang/Object 
.const [94] = Utf8 <init> 
.const [95] = Utf8 ()V 
.const [96] = Utf8 de/audi/tghu/dsi/high/HighFacadeFactory 
.const [97] = Utf8 <init> 
.const [98] = Utf8 ()V 
.const [99] = Utf8 de/audi/tghu/dsi/high/Activator 
.const [100] = Utf8 class$de$audi$tghu$dsi$IFacadeFactory 
.const [101] = Utf8 Ljava/lang/Class; 
.const [102] = Utf8 de/audi/tghu/dsi/high/Activator 
.const [103] = Utf8 sregFactory 
.const [104] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [105] = Utf8 de/audi/tghu/dsi/high/Activator 
.const [106] = Utf8 factory 
.const [107] = Utf8 Lde/audi/tghu/dsi/IFacadeFactory; 
.const [108] = Utf8 org/osgi/framework/BundleContext 
.const [109] = Utf8 registerService 
.const [110] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [111] = Utf8 org/osgi/framework/ServiceRegistration 
.const [112] = Utf8 unregister 
.const [113] = Utf8 ()V 
.const [114] = Utf8 de/audi/tghu/dsi/high/Activator 
.const [115] = Class [114] 
.const [116] = Utf8 java/lang/Object 
.const [117] = Class [116] 
.const [118] = Utf8 org/osgi/framework/BundleActivator 
.const [119] = Class [118] 
.const [120] = Utf8 sregFactory 
.const [121] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [122] = Utf8 factory 
.const [123] = Utf8 Lde/audi/tghu/dsi/IFacadeFactory; 
.const [124] = Utf8 class$de$audi$tghu$dsi$IFacadeFactory 
.const [125] = Utf8 Ljava/lang/Class; 
.const [126] = Utf8 Code 
.const [127] = Utf8 <init> 
.const [128] = Utf8 ()V 
.const [129] = Utf8 start 
.const [130] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [131] = Utf8 stop 
.const [132] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [133] = Utf8 class$ 
.const [134] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
