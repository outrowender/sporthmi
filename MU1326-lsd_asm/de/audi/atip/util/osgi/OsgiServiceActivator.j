.version 50 0 
.class public super [142] 
.super [144] 
.implements [146] 
.implements [148] 
.field private final [149] [150] 
.field private final [151] [152] 
.field private final [153] [154] 
.field private volatile [155] [156] 
.field private volatile [157] [158] 

.method public [160] : [161] 
    .attribute [159] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [23] 
L9:     aload_0 
L10:    aconst_null 
L11:    putfield [24] 
L14:    aload_0 
L15:    aload_3 
L16:    putfield [25] 
L19:    aload_0 
L20:    aload_1 
L21:    putfield [26] 
L24:    aload_0 
L25:    aload_2 
L26:    putfield [27] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [162] : [163] 
    .attribute [159] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [11] 
L4:     aload_1 
L5:     invokeinterface [28] 0 
L10:    astore_2 
L11:    aload_0 
L12:    getfield [14] 
L15:    aload_2 
L16:    invokevirtual [16] 
L19:    ifeq L35 
L22:    aload_0 
L23:    getfield [15] 
L26:    aload_2 
L27:    invokeinterface [29] 0 
L32:    goto L48 
L35:    aload_0 
L36:    getfield [11] 
L39:    aload_1 
L40:    invokeinterface [30] 0 
L45:    pop 
L46:    aconst_null 
L47:    astore_2 
L48:    aload_2 
L49:    areturn 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public enum [164] : [165] 
    .attribute [159] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [166] : [167] 
    .attribute [159] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     aload_0 
L9:     getfield [14] 
L12:    invokevirtual [17] 
L15:    invokevirtual [18] 
L18:    pop 
L19:    aload_0 
L20:    getfield [15] 
L23:    aconst_null 
L24:    invokeinterface [29] 0 
L29:    aload_0 
L30:    getfield [11] 
L33:    aload_1 
L34:    invokeinterface [30] 0 
L39:    pop 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [168] : [169] 
    .attribute [159] .code stack 6 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [23] 
L5:     aload_0 
L6:     new [31] 
L9:     dup 
L10:    aload_1 
L11:    aload_0 
L12:    getfield [14] 
L15:    invokevirtual [17] 
L18:    aload_0 
L19:    invokespecial [22] 
L22:    putfield [24] 
L25:    aload_0 
L26:    getfield [12] 
L29:    invokevirtual [19] 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [170] : [171] 
    .attribute [159] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     ifnull L19 
L7:     aload_0 
L8:     getfield [12] 
L11:    invokevirtual [20] 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [24] 
L19:    return 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -1601830656 
.const [3] = String [32] 
.const [4] = Class [33] 
.const [5] = Class [34] 
.const [6] = Class [35] 
.const [7] = Class [36] 
.const [8] = Class [37] 
.const [9] = Class [38] 
.const [10] = Class [39] 
.const [11] = Field [40] [41] 
.const [12] = Field [42] [43] 
.const [13] = Field [44] [45] 
.const [14] = Field [46] [47] 
.const [15] = Field [48] [49] 
.const [16] = Method [50] [51] 
.const [17] = Method [52] [53] 
.const [18] = Method [54] [55] 
.const [19] = Method [56] [57] 
.const [20] = Method [58] [59] 
.const [21] = Method [60] [61] 
.const [22] = Method [62] [63] 
.const [23] = Field [64] [65] 
.const [24] = Field [66] [67] 
.const [25] = Field [68] [69] 
.const [26] = Field [70] [71] 
.const [27] = Field [72] [73] 
.const [28] = InterfaceMethod [74] [75] 
.const [29] = InterfaceMethod [76] [77] 
.const [30] = InterfaceMethod [78] [79] 
.const [31] = Class [80] 
.const [32] = Utf8 '[OsgiServiceActivator] removed Service %1' 
.const [33] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [34] = Utf8 de/audi/atip/util/osgi/OsgiServiceActivator 
.const [35] = Utf8 java/lang/Object 
.const [36] = Utf8 org/osgi/framework/BundleContext 
.const [37] = Utf8 java/lang/Class 
.const [38] = Utf8 de/audi/atip/util/osgi/IOsgiServiceClient 
.const [39] = Utf8 de/audi/atip/log/LogChannel 
.const [40] = Class [81] 
.const [41] = NameAndType [82] [83] 
.const [42] = Class [84] 
.const [43] = NameAndType [85] [86] 
.const [44] = Class [87] 
.const [45] = NameAndType [88] [89] 
.const [46] = Class [90] 
.const [47] = NameAndType [91] [92] 
.const [48] = Class [93] 
.const [49] = NameAndType [94] [95] 
.const [50] = Class [96] 
.const [51] = NameAndType [97] [98] 
.const [52] = Class [99] 
.const [53] = NameAndType [100] [101] 
.const [54] = Class [102] 
.const [55] = NameAndType [103] [104] 
.const [56] = Class [105] 
.const [57] = NameAndType [106] [107] 
.const [58] = Class [108] 
.const [59] = NameAndType [109] [110] 
.const [60] = Class [111] 
.const [61] = NameAndType [112] [113] 
.const [62] = Class [114] 
.const [63] = NameAndType [115] [116] 
.const [64] = Class [117] 
.const [65] = NameAndType [118] [119] 
.const [66] = Class [120] 
.const [67] = NameAndType [121] [122] 
.const [68] = Class [123] 
.const [69] = NameAndType [124] [125] 
.const [70] = Class [126] 
.const [71] = NameAndType [127] [128] 
.const [72] = Class [129] 
.const [73] = NameAndType [130] [131] 
.const [74] = Class [132] 
.const [75] = NameAndType [133] [134] 
.const [76] = Class [135] 
.const [77] = NameAndType [136] [137] 
.const [78] = Class [138] 
.const [79] = NameAndType [139] [140] 
.const [80] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [81] = Utf8 de/audi/atip/util/osgi/OsgiServiceActivator 
.const [82] = Utf8 context 
.const [83] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [84] = Utf8 de/audi/atip/util/osgi/OsgiServiceActivator 
.const [85] = Utf8 tracker 
.const [86] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [87] = Utf8 de/audi/atip/util/osgi/OsgiServiceActivator 
.const [88] = Utf8 log 
.const [89] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [90] = Utf8 de/audi/atip/util/osgi/OsgiServiceActivator 
.const [91] = Utf8 clazz 
.const [92] = Utf8 Ljava/lang/Class; 
.const [93] = Utf8 de/audi/atip/util/osgi/OsgiServiceActivator 
.const [94] = Utf8 client 
.const [95] = Utf8 Lde/audi/atip/util/osgi/IOsgiServiceClient; 
.const [96] = Utf8 java/lang/Class 
.const [97] = Utf8 isInstance 
.const [98] = Utf8 (Ljava/lang/Object;)Z 
.const [99] = Utf8 java/lang/Class 
.const [100] = Utf8 getName 
.const [101] = Utf8 ()Ljava/lang/String; 
.const [102] = Utf8 de/audi/atip/log/LogChannel 
.const [103] = Utf8 log 
.const [104] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [105] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [106] = Utf8 'open' 
.const [107] = Utf8 ()V 
.const [108] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [109] = Utf8 close 
.const [110] = Utf8 ()V 
.const [111] = Utf8 java/lang/Object 
.const [112] = Utf8 <init> 
.const [113] = Utf8 ()V 
.const [114] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [115] = Utf8 <init> 
.const [116] = Utf8 (Lorg/osgi/framework/BundleContext;Ljava/lang/String;Lorg/osgi/util/tracker/ServiceTrackerCustomizer;)V 
.const [117] = Utf8 de/audi/atip/util/osgi/OsgiServiceActivator 
.const [118] = Utf8 context 
.const [119] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [120] = Utf8 de/audi/atip/util/osgi/OsgiServiceActivator 
.const [121] = Utf8 tracker 
.const [122] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [123] = Utf8 de/audi/atip/util/osgi/OsgiServiceActivator 
.const [124] = Utf8 log 
.const [125] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [126] = Utf8 de/audi/atip/util/osgi/OsgiServiceActivator 
.const [127] = Utf8 clazz 
.const [128] = Utf8 Ljava/lang/Class; 
.const [129] = Utf8 de/audi/atip/util/osgi/OsgiServiceActivator 
.const [130] = Utf8 client 
.const [131] = Utf8 Lde/audi/atip/util/osgi/IOsgiServiceClient; 
.const [132] = Utf8 org/osgi/framework/BundleContext 
.const [133] = Utf8 getService 
.const [134] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [135] = Utf8 de/audi/atip/util/osgi/IOsgiServiceClient 
.const [136] = Utf8 setService 
.const [137] = Utf8 (Ljava/lang/Object;)V 
.const [138] = Utf8 org/osgi/framework/BundleContext 
.const [139] = Utf8 ungetService 
.const [140] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [141] = Utf8 de/audi/atip/util/osgi/OsgiServiceActivator 
.const [142] = Class [141] 
.const [143] = Utf8 java/lang/Object 
.const [144] = Class [143] 
.const [145] = Utf8 org/osgi/framework/BundleActivator 
.const [146] = Class [145] 
.const [147] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [148] = Class [147] 
.const [149] = Utf8 log 
.const [150] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [151] = Utf8 clazz 
.const [152] = Utf8 Ljava/lang/Class; 
.const [153] = Utf8 client 
.const [154] = Utf8 Lde/audi/atip/util/osgi/IOsgiServiceClient; 
.const [155] = Utf8 context 
.const [156] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [157] = Utf8 tracker 
.const [158] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [159] = Utf8 Code 
.const [160] = Utf8 <init> 
.const [161] = Utf8 (Ljava/lang/Class;Lde/audi/atip/util/osgi/IOsgiServiceClient;Lde/audi/atip/log/LogChannel;)V 
.const [162] = Utf8 addingService 
.const [163] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [164] = Utf8 modifiedService 
.const [165] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [166] = Utf8 removedService 
.const [167] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [168] = Utf8 start 
.const [169] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [170] = Utf8 stop 
.const [171] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.end class 
