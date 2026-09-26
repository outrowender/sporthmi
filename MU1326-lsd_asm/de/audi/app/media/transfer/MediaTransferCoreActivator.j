.version 50 0 
.class public super [129] 
.super [131] 
.field static synthetic [132] [133] 

.method public annotation [135] : [136] 
    .attribute [134] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [137] : [138] 
    .attribute [134] .code stack 5 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [23] 
L5:     aload_0 
L6:     invokevirtual [17] 
L9:     invokeinterface [29] 0 
L14:    ifne L18 
L17:    return 
L18:    new [30] 
L21:    dup 
L22:    iconst_1 
L23:    invokespecial [24] 
L26:    astore_2 
L27:    aload_2 
L28:    ldc [6] 
L30:    new [31] 
L33:    dup 
L34:    iconst_0 
L35:    invokespecial [25] 
L38:    invokevirtual [18] 
L41:    pop 
L42:    aload_0 
L43:    getstatic [8] 
L46:    ifnonnull L61 
L49:    ldc [9] 
L51:    invokestatic [10] 
L54:    dup 
L55:    putstatic [26] 
L58:    goto L64 
L61:    getstatic [8] 
L64:    invokevirtual [19] 
L67:    new [32] 
L70:    dup 
L71:    invokespecial [27] 
L74:    aload_2 
L75:    invokevirtual [20] 
L78:    return 
L79:    nop 
L80:    
    .end code 
.end method 

.method static synthetic [139] : [140] 
    .attribute [134] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [28] 
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
.const [2] = Method [33] [34] 
.const [3] = Class [35] 
.const [4] = Class [36] 
.const [5] = Class [37] 
.const [6] = String [38] 
.const [7] = Class [39] 
.const [8] = Field [40] [41] 
.const [9] = String [42] 
.const [10] = Method [43] [44] 
.const [11] = Class [45] 
.const [12] = Class [46] 
.const [13] = Class [47] 
.const [14] = Class [48] 
.const [15] = Class [49] 
.const [16] = Method [50] [51] 
.const [17] = Method [52] [53] 
.const [18] = Method [54] [55] 
.const [19] = Method [56] [57] 
.const [20] = Method [58] [59] 
.const [21] = Method [60] [61] 
.const [22] = Method [62] [63] 
.const [23] = Method [64] [65] 
.const [24] = Method [66] [67] 
.const [25] = Method [68] [69] 
.const [26] = Field [70] [71] 
.const [27] = Method [72] [73] 
.const [28] = Class [74] 
.const [29] = InterfaceMethod [75] [76] 
.const [30] = Class [77] 
.const [31] = Class [78] 
.const [32] = Class [79] 
.const [33] = Class [80] 
.const [34] = NameAndType [81] [82] 
.const [35] = Utf8 java/lang/ClassNotFoundException 
.const [36] = Utf8 java/lang/NoClassDefFoundError 
.const [37] = Utf8 java/util/Hashtable 
.const [38] = Utf8 TERMINALID 
.const [39] = Utf8 java/lang/Integer 
.const [40] = Class [83] 
.const [41] = NameAndType [84] [85] 
.const [42] = Utf8 'de.audi.app.media.extension.IMediaTerminalExtension' 
.const [43] = Class [86] 
.const [44] = NameAndType [87] [88] 
.const [45] = Utf8 de/audi/app/media/transfer/MediaTransferTerminalExtension 
.const [46] = Utf8 de/audi/app/media/transfer/MediaTransferCoreActivator 
.const [47] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [48] = Utf8 java/lang/Class 
.const [49] = Utf8 de/audi/atip/base/IFrameworkAccess 
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
.const [66] = Class [113] 
.const [67] = NameAndType [114] [115] 
.const [68] = Class [116] 
.const [69] = NameAndType [117] [118] 
.const [70] = Class [119] 
.const [71] = NameAndType [120] [121] 
.const [72] = Class [122] 
.const [73] = NameAndType [123] [124] 
.const [74] = Utf8 java/lang/NoClassDefFoundError 
.const [75] = Class [125] 
.const [76] = NameAndType [126] [127] 
.const [77] = Utf8 java/util/Hashtable 
.const [78] = Utf8 java/lang/Integer 
.const [79] = Utf8 de/audi/app/media/transfer/MediaTransferTerminalExtension 
.const [80] = Utf8 java/lang/Class 
.const [81] = Utf8 forName 
.const [82] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [83] = Utf8 de/audi/app/media/transfer/MediaTransferCoreActivator 
.const [84] = Utf8 class$de$audi$app$media$extension$IMediaTerminalExtension 
.const [85] = Utf8 Ljava/lang/Class; 
.const [86] = Utf8 de/audi/app/media/transfer/MediaTransferCoreActivator 
.const [87] = Utf8 class$ 
.const [88] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [89] = Utf8 java/lang/NoClassDefFoundError 
.const [90] = Utf8 initCause 
.const [91] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [92] = Utf8 de/audi/app/media/transfer/MediaTransferCoreActivator 
.const [93] = Utf8 getFramework 
.const [94] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [95] = Utf8 java/util/Hashtable 
.const [96] = Utf8 put 
.const [97] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [98] = Utf8 java/lang/Class 
.const [99] = Utf8 getName 
.const [100] = Utf8 ()Ljava/lang/String; 
.const [101] = Utf8 de/audi/app/media/transfer/MediaTransferCoreActivator 
.const [102] = Utf8 registerService 
.const [103] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)V 
.const [104] = Utf8 java/lang/NoClassDefFoundError 
.const [105] = Utf8 <init> 
.const [106] = Utf8 ()V 
.const [107] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [108] = Utf8 <init> 
.const [109] = Utf8 ()V 
.const [110] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [111] = Utf8 start 
.const [112] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [113] = Utf8 java/util/Hashtable 
.const [114] = Utf8 <init> 
.const [115] = Utf8 (I)V 
.const [116] = Utf8 java/lang/Integer 
.const [117] = Utf8 <init> 
.const [118] = Utf8 (I)V 
.const [119] = Utf8 de/audi/app/media/transfer/MediaTransferCoreActivator 
.const [120] = Utf8 class$de$audi$app$media$extension$IMediaTerminalExtension 
.const [121] = Utf8 Ljava/lang/Class; 
.const [122] = Utf8 de/audi/app/media/transfer/MediaTransferTerminalExtension 
.const [123] = Utf8 <init> 
.const [124] = Utf8 ()V 
.const [125] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [126] = Utf8 isFrontMU 
.const [127] = Utf8 ()Z 
.const [128] = Utf8 de/audi/app/media/transfer/MediaTransferCoreActivator 
.const [129] = Class [128] 
.const [130] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [131] = Class [130] 
.const [132] = Utf8 class$de$audi$app$media$extension$IMediaTerminalExtension 
.const [133] = Utf8 Ljava/lang/Class; 
.const [134] = Utf8 Code 
.const [135] = Utf8 <init> 
.const [136] = Utf8 ()V 
.const [137] = Utf8 start 
.const [138] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [139] = Utf8 class$ 
.const [140] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.end class 
