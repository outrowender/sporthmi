.version 50 0 
.class super [117] 
.super [119] 
.implements [121] 
.field private final synthetic [122] [123] 
.field private final synthetic [124] [125] 

.method [127] : [128] 
    .attribute [126] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [25] 
L5:     aload_0 
L6:     iload_2 
L7:     putfield [26] 
L10:    aload_0 
L11:    invokespecial [23] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public enum [129] : [130] 
    .attribute [126] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [131] : [132] 
    .attribute [126] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [133] : [134] 
    .attribute [126] .code stack 2 locals 3 
L0:     aload_1 
L1:     ldc [2] 
L3:     invokeinterface [27] 0 
L8:     checkcast [3] 
L11:    astore_2 
L12:    aload_2 
L13:    ifnonnull L18 
L16:    aconst_null 
L17:    areturn 
L18:    aload_2 
L19:    invokevirtual [20] 
L22:    aload_0 
L23:    getfield [19] 
L26:    if_icmpeq L31 
L29:    aconst_null 
L30:    areturn 
L31:    aload_1 
L32:    ldc [4] 
L34:    invokeinterface [27] 0 
L39:    checkcast [5] 
L42:    astore_3 
L43:    aload_3 
L44:    ifnonnull L49 
L47:    aconst_null 
L48:    areturn 
L49:    getstatic [6] 
L52:    ifnonnull L67 
L55:    ldc [7] 
L57:    invokestatic [8] 
L60:    dup 
L61:    putstatic [24] 
L64:    goto L70 
L67:    getstatic [6] 
L70:    invokevirtual [21] 
L73:    aload_3 
L74:    invokevirtual [22] 
L77:    ifne L82 
L80:    aconst_null 
L81:    areturn 
L82:    aload_0 
L83:    getfield [18] 
L86:    invokestatic [9] 
L89:    aload_1 
L90:    invokeinterface [28] 0 
L95:    astore 4 
L97:    aload 4 
L99:    instanceof [10] 
L102:   ifeq L121 
L105:   aload_0 
L106:   getfield [18] 
L109:   aload 4 
L111:   checkcast [10] 
L114:   invokestatic [11] 
L117:   pop 
L118:   aload 4 
L120:   areturn 
L121:   aconst_null 
L122:   areturn 
L123:   nop 
L124:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [29] 
.const [3] = Class [30] 
.const [4] = String [31] 
.const [5] = Class [32] 
.const [6] = Field [33] [34] 
.const [7] = String [35] 
.const [8] = Method [36] [37] 
.const [9] = Method [38] [39] 
.const [10] = Class [40] 
.const [11] = Method [41] [42] 
.const [12] = Class [43] 
.const [13] = Class [44] 
.const [14] = Class [45] 
.const [15] = Class [46] 
.const [16] = Class [47] 
.const [17] = Class [48] 
.const [18] = Field [49] [50] 
.const [19] = Field [51] [52] 
.const [20] = Method [53] [54] 
.const [21] = Method [55] [56] 
.const [22] = Method [57] [58] 
.const [23] = Method [59] [60] 
.const [24] = Field [61] [62] 
.const [25] = Field [63] [64] 
.const [26] = Field [65] [66] 
.const [27] = InterfaceMethod [67] [68] 
.const [28] = InterfaceMethod [69] [70] 
.const [29] = Utf8 DEVICE_INSTANCE 
.const [30] = Utf8 java/lang/Integer 
.const [31] = Utf8 DEVICE_NAME 
.const [32] = Utf8 java/lang/String 
.const [33] = Class [71] 
.const [34] = NameAndType [72] [73] 
.const [35] = Utf8 'org.dsi.ifc.media.DSIMediaOnlineListener' 
.const [36] = Class [74] 
.const [37] = NameAndType [75] [76] 
.const [38] = Class [77] 
.const [39] = NameAndType [78] [79] 
.const [40] = Utf8 org/dsi/ifc/media/DSIMediaOnlineListener 
.const [41] = Class [80] 
.const [42] = NameAndType [81] [82] 
.const [43] = Utf8 de/audi/swdiagnosis/media/dsi/MediaDSISimulation$6 
.const [44] = Utf8 java/lang/Object 
.const [45] = Utf8 org/osgi/framework/ServiceReference 
.const [46] = Utf8 de/audi/swdiagnosis/media/dsi/MediaDSISimulation 
.const [47] = Utf8 java/lang/Class 
.const [48] = Utf8 de/audi/app/media/osgi/IServiceManager 
.const [49] = Class [83] 
.const [50] = NameAndType [84] [85] 
.const [51] = Class [86] 
.const [52] = NameAndType [87] [88] 
.const [53] = Class [89] 
.const [54] = NameAndType [90] [91] 
.const [55] = Class [92] 
.const [56] = NameAndType [93] [94] 
.const [57] = Class [95] 
.const [58] = NameAndType [96] [97] 
.const [59] = Class [98] 
.const [60] = NameAndType [99] [100] 
.const [61] = Class [101] 
.const [62] = NameAndType [102] [103] 
.const [63] = Class [104] 
.const [64] = NameAndType [105] [106] 
.const [65] = Class [107] 
.const [66] = NameAndType [108] [109] 
.const [67] = Class [110] 
.const [68] = NameAndType [111] [112] 
.const [69] = Class [113] 
.const [70] = NameAndType [114] [115] 
.const [71] = Utf8 de/audi/swdiagnosis/media/dsi/MediaDSISimulation 
.const [72] = Utf8 class$org$dsi$ifc$media$DSIMediaOnlineListener 
.const [73] = Utf8 Ljava/lang/Class; 
.const [74] = Utf8 de/audi/swdiagnosis/media/dsi/MediaDSISimulation 
.const [75] = Utf8 class$ 
.const [76] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [77] = Utf8 de/audi/swdiagnosis/media/dsi/MediaDSISimulation 
.const [78] = Utf8 access$000 
.const [79] = Utf8 (Lde/audi/swdiagnosis/media/dsi/MediaDSISimulation;)Lde/audi/app/media/osgi/IServiceManager; 
.const [80] = Utf8 de/audi/swdiagnosis/media/dsi/MediaDSISimulation 
.const [81] = Utf8 access$502 
.const [82] = Utf8 (Lde/audi/swdiagnosis/media/dsi/MediaDSISimulation;Lorg/dsi/ifc/media/DSIMediaOnlineListener;)Lorg/dsi/ifc/media/DSIMediaOnlineListener; 
.const [83] = Utf8 de/audi/swdiagnosis/media/dsi/MediaDSISimulation$6 
.const [84] = Utf8 this$0 
.const [85] = Utf8 Lde/audi/swdiagnosis/media/dsi/MediaDSISimulation; 
.const [86] = Utf8 de/audi/swdiagnosis/media/dsi/MediaDSISimulation$6 
.const [87] = Utf8 val$instanceID 
.const [88] = Utf8 I 
.const [89] = Utf8 java/lang/Integer 
.const [90] = Utf8 intValue 
.const [91] = Utf8 ()I 
.const [92] = Utf8 java/lang/Class 
.const [93] = Utf8 getName 
.const [94] = Utf8 ()Ljava/lang/String; 
.const [95] = Utf8 java/lang/String 
.const [96] = Utf8 equals 
.const [97] = Utf8 (Ljava/lang/Object;)Z 
.const [98] = Utf8 java/lang/Object 
.const [99] = Utf8 <init> 
.const [100] = Utf8 ()V 
.const [101] = Utf8 de/audi/swdiagnosis/media/dsi/MediaDSISimulation 
.const [102] = Utf8 class$org$dsi$ifc$media$DSIMediaOnlineListener 
.const [103] = Utf8 Ljava/lang/Class; 
.const [104] = Utf8 de/audi/swdiagnosis/media/dsi/MediaDSISimulation$6 
.const [105] = Utf8 this$0 
.const [106] = Utf8 Lde/audi/swdiagnosis/media/dsi/MediaDSISimulation; 
.const [107] = Utf8 de/audi/swdiagnosis/media/dsi/MediaDSISimulation$6 
.const [108] = Utf8 val$instanceID 
.const [109] = Utf8 I 
.const [110] = Utf8 org/osgi/framework/ServiceReference 
.const [111] = Utf8 getProperty 
.const [112] = Utf8 (Ljava/lang/String;)Ljava/lang/Object; 
.const [113] = Utf8 de/audi/app/media/osgi/IServiceManager 
.const [114] = Utf8 getService 
.const [115] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [116] = Utf8 de/audi/swdiagnosis/media/dsi/MediaDSISimulation$6 
.const [117] = Class [116] 
.const [118] = Utf8 java/lang/Object 
.const [119] = Class [118] 
.const [120] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [121] = Class [120] 
.const [122] = Utf8 val$instanceID 
.const [123] = Utf8 I 
.const [124] = Utf8 this$0 
.const [125] = Utf8 Lde/audi/swdiagnosis/media/dsi/MediaDSISimulation; 
.const [126] = Utf8 Code 
.const [127] = Utf8 <init> 
.const [128] = Utf8 (Lde/audi/swdiagnosis/media/dsi/MediaDSISimulation;I)V 
.const [129] = Utf8 removedService 
.const [130] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [131] = Utf8 modifiedService 
.const [132] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [133] = Utf8 addingService 
.const [134] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.end class 
