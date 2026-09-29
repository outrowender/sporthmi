.version 50 0 
.class super [142] 
.super [144] 
.implements [146] 
.field private final synthetic [147] [148] 

.method [150] : [151] 
    .attribute [149] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [35] 
L5:     aload_0 
L6:     invokespecial [34] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [152] : [153] 
    .attribute [149] .code stack 6 locals 4 
        .catch [15] from L0 to L125 using L126 
L0:     aload_1 
L1:     ldc [2] 
L3:     invokeinterface [36] 0 
L8:     checkcast [3] 
L11:    astore_2 
L12:    aload_1 
L13:    ldc [4] 
L15:    invokeinterface [36] 0 
L20:    astore_3 
L21:    iconst_0 
L22:    istore 4 
L24:    aload_3 
L25:    instanceof [5] 
L28:    ifeq L40 
L31:    aload_3 
L32:    checkcast [5] 
L35:    invokevirtual [28] 
L38:    istore 4 
L40:    aload_0 
L41:    getfield [27] 
L44:    invokestatic [6] 
L47:    ldc [7] 
L49:    ldc [8] 
L51:    aload_2 
L52:    iload 4 
L54:    i2l 
L55:    invokevirtual [29] 
L58:    pop 
L59:    aload_0 
L60:    getfield [27] 
L63:    invokestatic [9] 
L66:    aload_1 
L67:    invokeinterface [37] 0 
L72:    astore 5 
L74:    invokestatic [10] 
L77:    aload_2 
L78:    invokevirtual [30] 
L81:    ifeq L123 
L84:    iload 4 
L86:    ifne L123 
L89:    aload_0 
L90:    getfield [27] 
L93:    invokestatic [6] 
L96:    ldc [11] 
L98:    ldc [12] 
L100:   aload_2 
L101:   iload 4 
L103:   i2l 
L104:   invokevirtual [29] 
L107:   pop 
L108:   aload_0 
L109:   getfield [27] 
L112:   invokestatic [13] 
L115:   aload 5 
L117:   checkcast [14] 
L120:   invokevirtual [31] 
L123:   aload 5 
L125:   areturn 
L126:   astore_2 
L127:   aload_0 
L128:   getfield [27] 
L131:   invokestatic [6] 
L134:   ldc [16] 
L136:   ldc [17] 
L138:   aload_2 
L139:   invokevirtual [32] 
L142:   pop 
L143:   aconst_null 
L144:   areturn 
L145:   nop 
L146:   nop 
L147:   nop 
L148:   
    .end code 
.end method 

.method public enum [154] : [155] 
    .attribute [149] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [156] : [157] 
    .attribute [149] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [27] 
L4:     invokestatic [6] 
L7:     ldc [7] 
L9:     ldc [18] 
L11:    aload_1 
L12:    invokevirtual [33] 
L15:    pop 
L16:    aload_0 
L17:    getfield [27] 
L20:    invokestatic [19] 
L23:    aload_1 
L24:    invokeinterface [38] 0 
L29:    pop 
L30:    aload_0 
L31:    getfield [27] 
L34:    invokestatic [13] 
L37:    aconst_null 
L38:    invokevirtual [31] 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [39] 
.const [3] = Class [40] 
.const [4] = String [41] 
.const [5] = Class [42] 
.const [6] = Method [43] [44] 
.const [7] = Int -2137614336 
.const [8] = String [45] 
.const [9] = Method [46] [47] 
.const [10] = Method [48] [49] 
.const [11] = Int 1078071040 
.const [12] = String [50] 
.const [13] = Method [51] [52] 
.const [14] = Class [53] 
.const [15] = Class [54] 
.const [16] = Int -1601830656 
.const [17] = String [55] 
.const [18] = String [56] 
.const [19] = Method [57] [58] 
.const [20] = Class [59] 
.const [21] = Class [60] 
.const [22] = Class [61] 
.const [23] = Class [62] 
.const [24] = Class [63] 
.const [25] = Class [64] 
.const [26] = Class [65] 
.const [27] = Field [66] [67] 
.const [28] = Method [68] [69] 
.const [29] = Method [70] [71] 
.const [30] = Method [72] [73] 
.const [31] = Method [74] [75] 
.const [32] = Method [76] [77] 
.const [33] = Method [78] [79] 
.const [34] = Method [80] [81] 
.const [35] = Field [82] [83] 
.const [36] = InterfaceMethod [84] [85] 
.const [37] = InterfaceMethod [86] [87] 
.const [38] = InterfaceMethod [88] [89] 
.const [39] = Utf8 DEVICE_NAME 
.const [40] = Utf8 java/lang/String 
.const [41] = Utf8 DEVICE_INSTANCE 
.const [42] = Utf8 java/lang/Integer 
.const [43] = Class [90] 
.const [44] = NameAndType [91] [92] 
.const [45] = Utf8 'HMIWatchDogActivator.addingService( %1, %2 )' 
.const [46] = Class [93] 
.const [47] = NameAndType [94] [95] 
.const [48] = Class [96] 
.const [49] = NameAndType [97] [98] 
.const [50] = Utf8 'DSIHMIWatchDog is available!' 
.const [51] = Class [99] 
.const [52] = NameAndType [100] [101] 
.const [53] = Utf8 org/dsi/ifc/system/DSIHMIWatchDog 
.const [54] = Utf8 java/lang/Exception 
.const [55] = Utf8 'DomainActivator.addingService failed' 
.const [56] = Utf8 'HMIWatchDogActivator.removedService( %1 )' 
.const [57] = Class [102] 
.const [58] = NameAndType [103] [104] 
.const [59] = Utf8 de/audi/atip/watchdog/HMIWatchDogActivator$1 
.const [60] = Utf8 java/lang/Object 
.const [61] = Utf8 org/osgi/framework/ServiceReference 
.const [62] = Utf8 de/audi/atip/watchdog/HMIWatchDogActivator 
.const [63] = Utf8 de/audi/atip/log/LogChannel 
.const [64] = Utf8 org/osgi/framework/BundleContext 
.const [65] = Utf8 de/audi/atip/watchdog/HMIWatchDog 
.const [66] = Class [105] 
.const [67] = NameAndType [106] [107] 
.const [68] = Class [108] 
.const [69] = NameAndType [109] [110] 
.const [70] = Class [111] 
.const [71] = NameAndType [112] [113] 
.const [72] = Class [114] 
.const [73] = NameAndType [115] [116] 
.const [74] = Class [117] 
.const [75] = NameAndType [118] [119] 
.const [76] = Class [120] 
.const [77] = NameAndType [121] [122] 
.const [78] = Class [123] 
.const [79] = NameAndType [124] [125] 
.const [80] = Class [126] 
.const [81] = NameAndType [127] [128] 
.const [82] = Class [129] 
.const [83] = NameAndType [130] [131] 
.const [84] = Class [132] 
.const [85] = NameAndType [133] [134] 
.const [86] = Class [135] 
.const [87] = NameAndType [136] [137] 
.const [88] = Class [138] 
.const [89] = NameAndType [139] [140] 
.const [90] = Utf8 de/audi/atip/watchdog/HMIWatchDogActivator 
.const [91] = Utf8 access$000 
.const [92] = Utf8 (Lde/audi/atip/watchdog/HMIWatchDogActivator;)Lde/audi/atip/log/LogChannel; 
.const [93] = Utf8 de/audi/atip/watchdog/HMIWatchDogActivator 
.const [94] = Utf8 access$100 
.const [95] = Utf8 (Lde/audi/atip/watchdog/HMIWatchDogActivator;)Lorg/osgi/framework/BundleContext; 
.const [96] = Utf8 de/audi/atip/watchdog/HMIWatchDogActivator 
.const [97] = Utf8 access$200 
.const [98] = Utf8 ()Ljava/lang/String; 
.const [99] = Utf8 de/audi/atip/watchdog/HMIWatchDogActivator 
.const [100] = Utf8 access$300 
.const [101] = Utf8 (Lde/audi/atip/watchdog/HMIWatchDogActivator;)Lde/audi/atip/watchdog/HMIWatchDog; 
.const [102] = Utf8 de/audi/atip/watchdog/HMIWatchDogActivator 
.const [103] = Utf8 access$400 
.const [104] = Utf8 (Lde/audi/atip/watchdog/HMIWatchDogActivator;)Lorg/osgi/framework/BundleContext; 
.const [105] = Utf8 de/audi/atip/watchdog/HMIWatchDogActivator$1 
.const [106] = Utf8 this$0 
.const [107] = Utf8 Lde/audi/atip/watchdog/HMIWatchDogActivator; 
.const [108] = Utf8 java/lang/Integer 
.const [109] = Utf8 intValue 
.const [110] = Utf8 ()I 
.const [111] = Utf8 de/audi/atip/log/LogChannel 
.const [112] = Utf8 log 
.const [113] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [114] = Utf8 java/lang/String 
.const [115] = Utf8 equals 
.const [116] = Utf8 (Ljava/lang/Object;)Z 
.const [117] = Utf8 de/audi/atip/watchdog/HMIWatchDog 
.const [118] = Utf8 setDSI 
.const [119] = Utf8 (Lorg/dsi/ifc/system/DSIHMIWatchDog;)V 
.const [120] = Utf8 de/audi/atip/log/LogChannel 
.const [121] = Utf8 log 
.const [122] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [123] = Utf8 de/audi/atip/log/LogChannel 
.const [124] = Utf8 log 
.const [125] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [126] = Utf8 java/lang/Object 
.const [127] = Utf8 <init> 
.const [128] = Utf8 ()V 
.const [129] = Utf8 de/audi/atip/watchdog/HMIWatchDogActivator$1 
.const [130] = Utf8 this$0 
.const [131] = Utf8 Lde/audi/atip/watchdog/HMIWatchDogActivator; 
.const [132] = Utf8 org/osgi/framework/ServiceReference 
.const [133] = Utf8 getProperty 
.const [134] = Utf8 (Ljava/lang/String;)Ljava/lang/Object; 
.const [135] = Utf8 org/osgi/framework/BundleContext 
.const [136] = Utf8 getService 
.const [137] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [138] = Utf8 org/osgi/framework/BundleContext 
.const [139] = Utf8 ungetService 
.const [140] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [141] = Utf8 de/audi/atip/watchdog/HMIWatchDogActivator$1 
.const [142] = Class [141] 
.const [143] = Utf8 java/lang/Object 
.const [144] = Class [143] 
.const [145] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [146] = Class [145] 
.const [147] = Utf8 this$0 
.const [148] = Utf8 Lde/audi/atip/watchdog/HMIWatchDogActivator; 
.const [149] = Utf8 Code 
.const [150] = Utf8 <init> 
.const [151] = Utf8 (Lde/audi/atip/watchdog/HMIWatchDogActivator;)V 
.const [152] = Utf8 addingService 
.const [153] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [154] = Utf8 modifiedService 
.const [155] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [156] = Utf8 removedService 
.const [157] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.end class 
