.version 50 0 
.class public super [113] 
.super [115] 
.implements [117] 
.field private [118] [119] 
.field static synthetic [120] [121] 

.method public annotation [123] : [124] 
    .attribute [122] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [19] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [125] : [126] 
    .attribute [122] .code stack 5 locals 2 
L0:     new [24] 
L3:     dup 
L4:     invokespecial [20] 
L7:     astore_2 
L8:     new [25] 
L11:    dup 
L12:    invokespecial [21] 
L15:    astore_3 
L16:    aload_0 
L17:    aload_1 
L18:    getstatic [7] 
L21:    ifnonnull L36 
L24:    ldc [8] 
L26:    invokestatic [9] 
L29:    dup 
L30:    putstatic [22] 
L33:    goto L39 
L36:    getstatic [7] 
L39:    invokevirtual [16] 
L42:    aload_2 
L43:    aload_3 
L44:    invokeinterface [26] 0 
L49:    putfield [27] 
L52:    return 
L53:    nop 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [127] : [128] 
    .attribute [122] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     ifnull L16 
L7:     aload_0 
L8:     getfield [17] 
L11:    invokeinterface [28] 0 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static synthetic [129] : [130] 
    .attribute [122] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [23] 
L9:     dup 
L10:    invokespecial [18] 
L13:    aload_1 
L14:    invokevirtual [15] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [29] [30] 
.const [3] = Class [31] 
.const [4] = Class [32] 
.const [5] = Class [33] 
.const [6] = Class [34] 
.const [7] = Field [35] [36] 
.const [8] = String [37] 
.const [9] = Method [38] [39] 
.const [10] = Class [40] 
.const [11] = Class [41] 
.const [12] = Class [42] 
.const [13] = Class [43] 
.const [14] = Class [44] 
.const [15] = Method [45] [46] 
.const [16] = Method [47] [48] 
.const [17] = Field [49] [50] 
.const [18] = Method [51] [52] 
.const [19] = Method [53] [54] 
.const [20] = Method [55] [56] 
.const [21] = Method [57] [58] 
.const [22] = Field [59] [60] 
.const [23] = Class [61] 
.const [24] = Class [62] 
.const [25] = Class [63] 
.const [26] = InterfaceMethod [64] [65] 
.const [27] = Field [66] [67] 
.const [28] = InterfaceMethod [68] [69] 
.const [29] = Class [70] 
.const [30] = NameAndType [71] [72] 
.const [31] = Utf8 java/lang/ClassNotFoundException 
.const [32] = Utf8 java/lang/NoClassDefFoundError 
.const [33] = Utf8 de/esolutions/graphics/eal/dumper/DumpInfoProvider 
.const [34] = Utf8 java/util/Properties 
.const [35] = Class [73] 
.const [36] = NameAndType [74] [75] 
.const [37] = Utf8 'de.esolutions.fw.util.commons.error.DumpInfoProvider' 
.const [38] = Class [76] 
.const [39] = NameAndType [77] [78] 
.const [40] = Utf8 de/esolutions/graphics/eal/dumper/Activator 
.const [41] = Utf8 java/lang/Object 
.const [42] = Utf8 java/lang/Class 
.const [43] = Utf8 org/osgi/framework/BundleContext 
.const [44] = Utf8 org/osgi/framework/ServiceRegistration 
.const [45] = Class [79] 
.const [46] = NameAndType [80] [81] 
.const [47] = Class [82] 
.const [48] = NameAndType [83] [84] 
.const [49] = Class [85] 
.const [50] = NameAndType [86] [87] 
.const [51] = Class [88] 
.const [52] = NameAndType [89] [90] 
.const [53] = Class [91] 
.const [54] = NameAndType [92] [93] 
.const [55] = Class [94] 
.const [56] = NameAndType [95] [96] 
.const [57] = Class [97] 
.const [58] = NameAndType [98] [99] 
.const [59] = Class [100] 
.const [60] = NameAndType [101] [102] 
.const [61] = Utf8 java/lang/NoClassDefFoundError 
.const [62] = Utf8 de/esolutions/graphics/eal/dumper/DumpInfoProvider 
.const [63] = Utf8 java/util/Properties 
.const [64] = Class [103] 
.const [65] = NameAndType [104] [105] 
.const [66] = Class [106] 
.const [67] = NameAndType [107] [108] 
.const [68] = Class [109] 
.const [69] = NameAndType [110] [111] 
.const [70] = Utf8 java/lang/Class 
.const [71] = Utf8 forName 
.const [72] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [73] = Utf8 de/esolutions/graphics/eal/dumper/Activator 
.const [74] = Utf8 class$de$esolutions$fw$util$commons$error$DumpInfoProvider 
.const [75] = Utf8 Ljava/lang/Class; 
.const [76] = Utf8 de/esolutions/graphics/eal/dumper/Activator 
.const [77] = Utf8 class$ 
.const [78] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [79] = Utf8 java/lang/NoClassDefFoundError 
.const [80] = Utf8 initCause 
.const [81] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [82] = Utf8 java/lang/Class 
.const [83] = Utf8 getName 
.const [84] = Utf8 ()Ljava/lang/String; 
.const [85] = Utf8 de/esolutions/graphics/eal/dumper/Activator 
.const [86] = Utf8 dipServiceReg 
.const [87] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [88] = Utf8 java/lang/NoClassDefFoundError 
.const [89] = Utf8 <init> 
.const [90] = Utf8 ()V 
.const [91] = Utf8 java/lang/Object 
.const [92] = Utf8 <init> 
.const [93] = Utf8 ()V 
.const [94] = Utf8 de/esolutions/graphics/eal/dumper/DumpInfoProvider 
.const [95] = Utf8 <init> 
.const [96] = Utf8 ()V 
.const [97] = Utf8 java/util/Properties 
.const [98] = Utf8 <init> 
.const [99] = Utf8 ()V 
.const [100] = Utf8 de/esolutions/graphics/eal/dumper/Activator 
.const [101] = Utf8 class$de$esolutions$fw$util$commons$error$DumpInfoProvider 
.const [102] = Utf8 Ljava/lang/Class; 
.const [103] = Utf8 org/osgi/framework/BundleContext 
.const [104] = Utf8 registerService 
.const [105] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [106] = Utf8 de/esolutions/graphics/eal/dumper/Activator 
.const [107] = Utf8 dipServiceReg 
.const [108] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [109] = Utf8 org/osgi/framework/ServiceRegistration 
.const [110] = Utf8 unregister 
.const [111] = Utf8 ()V 
.const [112] = Utf8 de/esolutions/graphics/eal/dumper/Activator 
.const [113] = Class [112] 
.const [114] = Utf8 java/lang/Object 
.const [115] = Class [114] 
.const [116] = Utf8 org/osgi/framework/BundleActivator 
.const [117] = Class [116] 
.const [118] = Utf8 dipServiceReg 
.const [119] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [120] = Utf8 class$de$esolutions$fw$util$commons$error$DumpInfoProvider 
.const [121] = Utf8 Ljava/lang/Class; 
.const [122] = Utf8 Code 
.const [123] = Utf8 <init> 
.const [124] = Utf8 ()V 
.const [125] = Utf8 start 
.const [126] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [127] = Utf8 stop 
.const [128] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [129] = Utf8 class$ 
.const [130] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
