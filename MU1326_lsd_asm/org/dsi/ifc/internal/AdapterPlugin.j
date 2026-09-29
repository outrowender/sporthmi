.version 50 0 
.class public super [123] 
.super [125] 
.implements [127] 
.field private [128] [129] 
.field static synthetic [130] [131] 

.method public annotation [133] : [134] 
    .attribute [132] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [135] : [136] 
    .attribute [132] .code stack 5 locals 1 
L0:     invokestatic [5] 
L3:     astore_2 
L4:     aload_2 
L5:     new [26] 
L8:     dup 
L9:     invokespecial [23] 
L12:    invokevirtual [17] 
L15:    aload_0 
L16:    aload_1 
L17:    getstatic [7] 
L20:    ifnonnull L35 
L23:    ldc [8] 
L25:    invokestatic [9] 
L28:    dup 
L29:    putstatic [24] 
L32:    goto L38 
L35:    getstatic [7] 
L38:    invokevirtual [18] 
L41:    aload_2 
L42:    aconst_null 
L43:    invokeinterface [27] 0 
L48:    putfield [28] 
L51:    return 
L52:    
    .end code 
.end method 

.method public [137] : [138] 
    .attribute [132] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [19] 
L4:     ifnull L21 
L7:     aload_0 
L8:     getfield [19] 
L11:    invokeinterface [29] 0 
L16:    aload_0 
L17:    aconst_null 
L18:    putfield [28] 
L21:    invokestatic [5] 
L24:    astore_2 
L25:    aload_2 
L26:    ifnull L33 
L29:    aload_2 
L30:    invokevirtual [20] 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method static synthetic [139] : [140] 
    .attribute [132] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [25] 
L9:     dup 
L10:    invokespecial [21] 
L13:    aload_1 
L14:    invokevirtual [16] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [30] [31] 
.const [3] = Class [32] 
.const [4] = Class [33] 
.const [5] = Method [34] [35] 
.const [6] = Class [36] 
.const [7] = Field [37] [38] 
.const [8] = String [39] 
.const [9] = Method [40] [41] 
.const [10] = Class [42] 
.const [11] = Class [43] 
.const [12] = Class [44] 
.const [13] = Class [45] 
.const [14] = Class [46] 
.const [15] = Class [47] 
.const [16] = Method [48] [49] 
.const [17] = Method [50] [51] 
.const [18] = Method [52] [53] 
.const [19] = Field [54] [55] 
.const [20] = Method [56] [57] 
.const [21] = Method [58] [59] 
.const [22] = Method [60] [61] 
.const [23] = Method [62] [63] 
.const [24] = Field [64] [65] 
.const [25] = Class [66] 
.const [26] = Class [67] 
.const [27] = InterfaceMethod [68] [69] 
.const [28] = Field [70] [71] 
.const [29] = InterfaceMethod [72] [73] 
.const [30] = Class [74] 
.const [31] = NameAndType [75] [76] 
.const [32] = Utf8 java/lang/ClassNotFoundException 
.const [33] = Utf8 java/lang/NoClassDefFoundError 
.const [34] = Class [77] 
.const [35] = NameAndType [78] [79] 
.const [36] = Utf8 org/dsi/ifc/internal/NavigationFactory 
.const [37] = Class [80] 
.const [38] = NameAndType [81] [82] 
.const [39] = Utf8 'org.dsi.ifc.base.IAdapterManager' 
.const [40] = Class [83] 
.const [41] = NameAndType [84] [85] 
.const [42] = Utf8 org/dsi/ifc/internal/AdapterPlugin 
.const [43] = Utf8 java/lang/Object 
.const [44] = Utf8 java/lang/Class 
.const [45] = Utf8 org/dsi/ifc/internal/AdapterManager 
.const [46] = Utf8 org/osgi/framework/BundleContext 
.const [47] = Utf8 org/osgi/framework/ServiceRegistration 
.const [48] = Class [86] 
.const [49] = NameAndType [87] [88] 
.const [50] = Class [89] 
.const [51] = NameAndType [90] [91] 
.const [52] = Class [92] 
.const [53] = NameAndType [93] [94] 
.const [54] = Class [95] 
.const [55] = NameAndType [96] [97] 
.const [56] = Class [98] 
.const [57] = NameAndType [99] [100] 
.const [58] = Class [101] 
.const [59] = NameAndType [102] [103] 
.const [60] = Class [104] 
.const [61] = NameAndType [105] [106] 
.const [62] = Class [107] 
.const [63] = NameAndType [108] [109] 
.const [64] = Class [110] 
.const [65] = NameAndType [111] [112] 
.const [66] = Utf8 java/lang/NoClassDefFoundError 
.const [67] = Utf8 org/dsi/ifc/internal/NavigationFactory 
.const [68] = Class [113] 
.const [69] = NameAndType [114] [115] 
.const [70] = Class [116] 
.const [71] = NameAndType [117] [118] 
.const [72] = Class [119] 
.const [73] = NameAndType [120] [121] 
.const [74] = Utf8 java/lang/Class 
.const [75] = Utf8 forName 
.const [76] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [77] = Utf8 org/dsi/ifc/internal/AdapterManager 
.const [78] = Utf8 getDefault 
.const [79] = Utf8 ()Lorg/dsi/ifc/internal/AdapterManager; 
.const [80] = Utf8 org/dsi/ifc/internal/AdapterPlugin 
.const [81] = Utf8 class$org$dsi$ifc$base$IAdapterManager 
.const [82] = Utf8 Ljava/lang/Class; 
.const [83] = Utf8 org/dsi/ifc/internal/AdapterPlugin 
.const [84] = Utf8 class$ 
.const [85] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [86] = Utf8 java/lang/NoClassDefFoundError 
.const [87] = Utf8 initCause 
.const [88] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [89] = Utf8 org/dsi/ifc/internal/AdapterManager 
.const [90] = Utf8 registerFactories 
.const [91] = Utf8 (Lorg/dsi/ifc/base/IFactory;)V 
.const [92] = Utf8 java/lang/Class 
.const [93] = Utf8 getName 
.const [94] = Utf8 ()Ljava/lang/String; 
.const [95] = Utf8 org/dsi/ifc/internal/AdapterPlugin 
.const [96] = Utf8 fAdapterManagerReg 
.const [97] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [98] = Utf8 org/dsi/ifc/internal/AdapterManager 
.const [99] = Utf8 unregisterAllFactories 
.const [100] = Utf8 ()V 
.const [101] = Utf8 java/lang/NoClassDefFoundError 
.const [102] = Utf8 <init> 
.const [103] = Utf8 ()V 
.const [104] = Utf8 java/lang/Object 
.const [105] = Utf8 <init> 
.const [106] = Utf8 ()V 
.const [107] = Utf8 org/dsi/ifc/internal/NavigationFactory 
.const [108] = Utf8 <init> 
.const [109] = Utf8 ()V 
.const [110] = Utf8 org/dsi/ifc/internal/AdapterPlugin 
.const [111] = Utf8 class$org$dsi$ifc$base$IAdapterManager 
.const [112] = Utf8 Ljava/lang/Class; 
.const [113] = Utf8 org/osgi/framework/BundleContext 
.const [114] = Utf8 registerService 
.const [115] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [116] = Utf8 org/dsi/ifc/internal/AdapterPlugin 
.const [117] = Utf8 fAdapterManagerReg 
.const [118] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [119] = Utf8 org/osgi/framework/ServiceRegistration 
.const [120] = Utf8 unregister 
.const [121] = Utf8 ()V 
.const [122] = Utf8 org/dsi/ifc/internal/AdapterPlugin 
.const [123] = Class [122] 
.const [124] = Utf8 java/lang/Object 
.const [125] = Class [124] 
.const [126] = Utf8 org/osgi/framework/BundleActivator 
.const [127] = Class [126] 
.const [128] = Utf8 fAdapterManagerReg 
.const [129] = Utf8 Lorg/osgi/framework/ServiceRegistration; 
.const [130] = Utf8 class$org$dsi$ifc$base$IAdapterManager 
.const [131] = Utf8 Ljava/lang/Class; 
.const [132] = Utf8 Code 
.const [133] = Utf8 <init> 
.const [134] = Utf8 ()V 
.const [135] = Utf8 start 
.const [136] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [137] = Utf8 stop 
.const [138] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [139] = Utf8 class$ 
.const [140] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
