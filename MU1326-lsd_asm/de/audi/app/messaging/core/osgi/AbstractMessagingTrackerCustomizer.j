.version 50 0 
.class public super abstract [149] 
.super [151] 
.implements [153] 
.field private final [154] [155] 
.field private final [156] [157] 

.method public [159] : [160] 
    .attribute [158] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [33] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [34] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public final [161] : [162] 
    .attribute [158] .code stack 7 locals 3 
L0:     aload_0 
L1:     getfield [22] 
L4:     aload_1 
L5:     invokeinterface [35] 0 
L10:    astore_2 
L11:    aload_0 
L12:    getfield [21] 
L15:    invokevirtual [23] 
L18:    ifeq L47 
L21:    aload_0 
L22:    getfield [21] 
L25:    ldc [2] 
L27:    ldc [3] 
L29:    aload_0 
L30:    aload_1 
L31:    invokespecial [30] 
L34:    aload_0 
L35:    aload_2 
L36:    invokespecial [31] 
L39:    aload_2 
L40:    invokestatic [4] 
L43:    i2l 
L44:    invokevirtual [24] 
L47:    iconst_0 
L48:    istore_3 
        .catch [5] from L49 to L57 using L60 
L49:    aload_0 
L50:    aload_1 
L51:    aload_2 
L52:    invokevirtual [25] 
L55:    iconst_1 
L56:    istore_3 
L57:    goto L88 
L60:    astore 4 
L62:    aload_0 
L63:    getfield [21] 
L66:    sipush 10000 
L69:    ldc [6] 
L71:    aload 4 
L73:    invokevirtual [26] 
L76:    pop 
L77:    aload_0 
L78:    getfield [22] 
L81:    aload_1 
L82:    invokeinterface [36] 0 
L87:    pop 
L88:    iload_3 
L89:    ifeq L96 
L92:    aload_2 
L93:    goto L97 
L96:    aconst_null 
L97:    areturn 
L98:    nop 
L99:    nop 
L100:   
    .end code 
.end method 

.method public final enum [163] : [164] 
    .attribute [158] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public final [165] : [166] 
    .attribute [158] .code stack 7 locals 1 
L0:     aload_0 
L1:     getfield [21] 
L4:     ldc [7] 
L6:     ldc [8] 
L8:     aload_0 
L9:     aload_1 
L10:    invokespecial [30] 
L13:    aload_0 
L14:    aload_2 
L15:    invokespecial [31] 
L18:    aload_2 
L19:    invokestatic [4] 
L22:    i2l 
L23:    invokevirtual [24] 
        .catch [5] from L26 to L32 using L35 
L26:    aload_0 
L27:    aload_1 
L28:    aload_2 
L29:    invokevirtual [27] 
L32:    goto L50 
L35:    astore_3 
L36:    aload_0 
L37:    getfield [21] 
L40:    sipush 10000 
L43:    ldc [9] 
L45:    aload_3 
L46:    invokevirtual [26] 
L49:    pop 
L50:    aload_0 
L51:    getfield [22] 
L54:    aload_1 
L55:    invokeinterface [36] 0 
L60:    pop 
L61:    return 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method protected abstract [167] : [168] 
    .attribute [158] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [169] : [170] 
    .attribute [158] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private [171] : [172] 
    .attribute [158] .code stack 2 locals 1 
L0:     aload_1 
L1:     ldc [10] 
L3:     invokeinterface [37] 0 
L8:     checkcast [11] 
L11:    checkcast [11] 
L14:    astore_2 
L15:    aload_2 
L16:    invokestatic [12] 
L19:    areturn 
L20:    
    .end code 
.end method 

.method private [173] : [174] 
    .attribute [158] .code stack 1 locals 0 
L0:     aload_1 
L1:     invokespecial [32] 
L4:     invokevirtual [28] 
L7:     areturn 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [38] 
.const [4] = Method [39] [40] 
.const [5] = Class [41] 
.const [6] = String [42] 
.const [7] = Int -1601830656 
.const [8] = String [43] 
.const [9] = String [44] 
.const [10] = String [45] 
.const [11] = Class [46] 
.const [12] = Method [47] [48] 
.const [13] = Class [49] 
.const [14] = Class [50] 
.const [15] = Class [51] 
.const [16] = Class [52] 
.const [17] = Class [53] 
.const [18] = Class [54] 
.const [19] = Class [55] 
.const [20] = Class [56] 
.const [21] = Field [57] [58] 
.const [22] = Field [59] [60] 
.const [23] = Method [61] [62] 
.const [24] = Method [63] [64] 
.const [25] = Method [65] [66] 
.const [26] = Method [67] [68] 
.const [27] = Method [69] [70] 
.const [28] = Method [71] [72] 
.const [29] = Method [73] [74] 
.const [30] = Method [75] [76] 
.const [31] = Method [77] [78] 
.const [32] = Method [79] [80] 
.const [33] = Field [81] [82] 
.const [34] = Field [83] [84] 
.const [35] = InterfaceMethod [85] [86] 
.const [36] = InterfaceMethod [87] [88] 
.const [37] = InterfaceMethod [89] [90] 
.const [38] = Utf8 '[AbstractMessagingTrackerCustomizer#addingService] Service interfaces = %1, service implementation = %2@%3' 
.const [39] = Class [91] 
.const [40] = NameAndType [92] [93] 
.const [41] = Utf8 java/lang/Exception 
.const [42] = Utf8 '[AbstractMessagingTrackerCustomizer#addingService] Error adding service: ' 
.const [43] = Utf8 '[AbstractMessagingTrackerCustomizer#removedService] Service interfaces = %1, service implementation = %2@%3' 
.const [44] = Utf8 '[AbstractMessagingTrackerCustomizer#removedService] Error removing service: ' 
.const [45] = Utf8 objectClass 
.const [46] = Utf8 [Ljava/lang/String; 
.const [47] = Class [94] 
.const [48] = NameAndType [95] [96] 
.const [49] = Utf8 de/audi/app/messaging/core/osgi/AbstractMessagingTrackerCustomizer 
.const [50] = Utf8 java/lang/Object 
.const [51] = Utf8 org/osgi/framework/BundleContext 
.const [52] = Utf8 de/audi/atip/log/LogChannel 
.const [53] = Utf8 java/lang/System 
.const [54] = Utf8 org/osgi/framework/ServiceReference 
.const [55] = Utf8 de/audi/app/messaging/core/util/Arrays 
.const [56] = Utf8 java/lang/Class 
.const [57] = Class [97] 
.const [58] = NameAndType [98] [99] 
.const [59] = Class [100] 
.const [60] = NameAndType [101] [102] 
.const [61] = Class [103] 
.const [62] = NameAndType [104] [105] 
.const [63] = Class [106] 
.const [64] = NameAndType [107] [108] 
.const [65] = Class [109] 
.const [66] = NameAndType [110] [111] 
.const [67] = Class [112] 
.const [68] = NameAndType [113] [114] 
.const [69] = Class [115] 
.const [70] = NameAndType [116] [117] 
.const [71] = Class [118] 
.const [72] = NameAndType [119] [120] 
.const [73] = Class [121] 
.const [74] = NameAndType [122] [123] 
.const [75] = Class [124] 
.const [76] = NameAndType [125] [126] 
.const [77] = Class [127] 
.const [78] = NameAndType [128] [129] 
.const [79] = Class [130] 
.const [80] = NameAndType [131] [132] 
.const [81] = Class [133] 
.const [82] = NameAndType [134] [135] 
.const [83] = Class [136] 
.const [84] = NameAndType [137] [138] 
.const [85] = Class [139] 
.const [86] = NameAndType [140] [141] 
.const [87] = Class [142] 
.const [88] = NameAndType [143] [144] 
.const [89] = Class [145] 
.const [90] = NameAndType [146] [147] 
.const [91] = Utf8 java/lang/System 
.const [92] = Utf8 identityHashCode 
.const [93] = Utf8 (Ljava/lang/Object;)I 
.const [94] = Utf8 de/audi/app/messaging/core/util/Arrays 
.const [95] = Utf8 toString 
.const [96] = Utf8 ([Ljava/lang/Object;)Ljava/lang/String; 
.const [97] = Utf8 de/audi/app/messaging/core/osgi/AbstractMessagingTrackerCustomizer 
.const [98] = Utf8 log 
.const [99] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [100] = Utf8 de/audi/app/messaging/core/osgi/AbstractMessagingTrackerCustomizer 
.const [101] = Utf8 bundleContext 
.const [102] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [103] = Utf8 de/audi/atip/log/LogChannel 
.const [104] = Utf8 isInfo 
.const [105] = Utf8 ()Z 
.const [106] = Utf8 de/audi/atip/log/LogChannel 
.const [107] = Utf8 log 
.const [108] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;J)V 
.const [109] = Utf8 de/audi/app/messaging/core/osgi/AbstractMessagingTrackerCustomizer 
.const [110] = Utf8 addService 
.const [111] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [112] = Utf8 de/audi/atip/log/LogChannel 
.const [113] = Utf8 log 
.const [114] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [115] = Utf8 de/audi/app/messaging/core/osgi/AbstractMessagingTrackerCustomizer 
.const [116] = Utf8 removeService 
.const [117] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [118] = Utf8 java/lang/Class 
.const [119] = Utf8 getName 
.const [120] = Utf8 ()Ljava/lang/String; 
.const [121] = Utf8 java/lang/Object 
.const [122] = Utf8 <init> 
.const [123] = Utf8 ()V 
.const [124] = Utf8 de/audi/app/messaging/core/osgi/AbstractMessagingTrackerCustomizer 
.const [125] = Utf8 getServiceInterfaces 
.const [126] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/String; 
.const [127] = Utf8 de/audi/app/messaging/core/osgi/AbstractMessagingTrackerCustomizer 
.const [128] = Utf8 getServiceClass 
.const [129] = Utf8 (Ljava/lang/Object;)Ljava/lang/String; 
.const [130] = Utf8 java/lang/Object 
.const [131] = Utf8 getClass 
.const [132] = Utf8 ()Ljava/lang/Class; 
.const [133] = Utf8 de/audi/app/messaging/core/osgi/AbstractMessagingTrackerCustomizer 
.const [134] = Utf8 log 
.const [135] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [136] = Utf8 de/audi/app/messaging/core/osgi/AbstractMessagingTrackerCustomizer 
.const [137] = Utf8 bundleContext 
.const [138] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [139] = Utf8 org/osgi/framework/BundleContext 
.const [140] = Utf8 getService 
.const [141] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [142] = Utf8 org/osgi/framework/BundleContext 
.const [143] = Utf8 ungetService 
.const [144] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [145] = Utf8 org/osgi/framework/ServiceReference 
.const [146] = Utf8 getProperty 
.const [147] = Utf8 (Ljava/lang/String;)Ljava/lang/Object; 
.const [148] = Utf8 de/audi/app/messaging/core/osgi/AbstractMessagingTrackerCustomizer 
.const [149] = Class [148] 
.const [150] = Utf8 java/lang/Object 
.const [151] = Class [150] 
.const [152] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [153] = Class [152] 
.const [154] = Utf8 log 
.const [155] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [156] = Utf8 bundleContext 
.const [157] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [158] = Utf8 Code 
.const [159] = Utf8 <init> 
.const [160] = Utf8 (Lde/audi/atip/log/LogChannel;Lorg/osgi/framework/BundleContext;)V 
.const [161] = Utf8 addingService 
.const [162] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [163] = Utf8 modifiedService 
.const [164] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [165] = Utf8 removedService 
.const [166] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [167] = Utf8 addService 
.const [168] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [169] = Utf8 removeService 
.const [170] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [171] = Utf8 getServiceInterfaces 
.const [172] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/String; 
.const [173] = Utf8 getServiceClass 
.const [174] = Utf8 (Ljava/lang/Object;)Ljava/lang/String; 
.end class 
