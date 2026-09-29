.version 50 0 
.class public super [152] 
.super [154] 
.field static synthetic [155] [156] 

.method public [158] : [159] 
    .attribute [157] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [5] 
L4:     invokespecial [32] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [160] : [161] 
    .attribute [157] .code stack 6 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [33] 
L5:     aload_1 
L6:     getstatic [6] 
L9:     ifnonnull L24 
L12:    ldc [7] 
L14:    invokestatic [8] 
L17:    dup 
L18:    putstatic [34] 
L21:    goto L27 
L24:    getstatic [6] 
L27:    invokevirtual [24] 
L30:    new [37] 
L33:    dup 
L34:    aload_0 
L35:    aconst_null 
L36:    invokespecial [35] 
L39:    invokestatic [10] 
L42:    invokeinterface [38] 0 
L47:    pop 
L48:    return 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method private [162] : [163] 
    .attribute [157] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     ldc [11] 
L6:     ldc [12] 
L8:     invokevirtual [25] 
L11:    pop 
L12:    aload_0 
L13:    getfield [26] 
L16:    invokevirtual [27] 
L19:    invokevirtual [28] 
L22:    iconst_1 
L23:    invokevirtual [29] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method static synthetic [164] : [165] 
    .attribute [157] .code stack 2 locals 1 
        .catch [3] from L0 to L4 using L5 
L0:     aload_0 
L1:     invokestatic [2] 
L4:     areturn 
L5:     astore_1 
L6:     new [36] 
L9:     dup 
L10:    invokespecial [31] 
L13:    aload_1 
L14:    invokevirtual [23] 
L17:    athrow 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method static synthetic [166] : [167] 
    .attribute [157] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [168] : [169] 
    .attribute [157] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [30] 
L4:     return 
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
.const [5] = String [43] 
.const [6] = Field [44] [45] 
.const [7] = String [46] 
.const [8] = Method [47] [48] 
.const [9] = Class [49] 
.const [10] = Method [50] [51] 
.const [11] = Int -2137614336 
.const [12] = String [52] 
.const [13] = Class [53] 
.const [14] = Class [54] 
.const [15] = Class [55] 
.const [16] = Class [56] 
.const [17] = Class [57] 
.const [18] = Class [58] 
.const [19] = Class [59] 
.const [20] = Class [60] 
.const [21] = Class [61] 
.const [22] = Field [62] [63] 
.const [23] = Method [64] [65] 
.const [24] = Method [66] [67] 
.const [25] = Method [68] [69] 
.const [26] = Field [70] [71] 
.const [27] = Method [72] [73] 
.const [28] = Method [74] [75] 
.const [29] = Method [76] [77] 
.const [30] = Method [78] [79] 
.const [31] = Method [80] [81] 
.const [32] = Method [82] [83] 
.const [33] = Method [84] [85] 
.const [34] = Field [86] [87] 
.const [35] = Method [88] [89] 
.const [36] = Class [90] 
.const [37] = Class [91] 
.const [38] = InterfaceMethod [92] [93] 
.const [39] = Class [94] 
.const [40] = NameAndType [95] [96] 
.const [41] = Utf8 java/lang/ClassNotFoundException 
.const [42] = Utf8 java/lang/NoClassDefFoundError 
.const [43] = Utf8 'App.Messaging.Main' 
.const [44] = Class [97] 
.const [45] = NameAndType [98] [99] 
.const [46] = Utf8 'de.audi.atip.power.PowerEventListener' 
.const [47] = Class [100] 
.const [48] = NameAndType [101] [102] 
.const [49] = Utf8 de/audi/app/messaging/core/powerstate/PowerStateHandler$MyPowerEventListener 
.const [50] = Class [103] 
.const [51] = NameAndType [104] [105] 
.const [52] = Utf8 '[PowerStateHandler#saveCompositionBuffer]' 
.const [53] = Utf8 de/audi/app/messaging/core/powerstate/PowerStateHandler 
.const [54] = Utf8 de/audi/app/messaging/core/component/AbstractMessagingComponent 
.const [55] = Utf8 java/lang/Class 
.const [56] = Utf8 de/audi/app/messaging/core/osgi/ServiceProperties 
.const [57] = Utf8 de/audi/app/messaging/core/osgi/IServiceRegistry 
.const [58] = Utf8 de/audi/atip/log/LogChannel 
.const [59] = Utf8 de/audi/app/messaging/core/application/AbstractMsgApplication 
.const [60] = Utf8 de/audi/app/messaging/core/compose/NewMessage 
.const [61] = Utf8 de/audi/app/messaging/core/drafts/SaveDraftController 
.const [62] = Class [106] 
.const [63] = NameAndType [107] [108] 
.const [64] = Class [109] 
.const [65] = NameAndType [110] [111] 
.const [66] = Class [112] 
.const [67] = NameAndType [113] [114] 
.const [68] = Class [115] 
.const [69] = NameAndType [116] [117] 
.const [70] = Class [118] 
.const [71] = NameAndType [119] [120] 
.const [72] = Class [121] 
.const [73] = NameAndType [122] [123] 
.const [74] = Class [124] 
.const [75] = NameAndType [125] [126] 
.const [76] = Class [127] 
.const [77] = NameAndType [128] [129] 
.const [78] = Class [130] 
.const [79] = NameAndType [131] [132] 
.const [80] = Class [133] 
.const [81] = NameAndType [134] [135] 
.const [82] = Class [136] 
.const [83] = NameAndType [137] [138] 
.const [84] = Class [139] 
.const [85] = NameAndType [140] [141] 
.const [86] = Class [142] 
.const [87] = NameAndType [143] [144] 
.const [88] = Class [145] 
.const [89] = NameAndType [146] [147] 
.const [90] = Utf8 java/lang/NoClassDefFoundError 
.const [91] = Utf8 de/audi/app/messaging/core/powerstate/PowerStateHandler$MyPowerEventListener 
.const [92] = Class [148] 
.const [93] = NameAndType [149] [150] 
.const [94] = Utf8 java/lang/Class 
.const [95] = Utf8 forName 
.const [96] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [97] = Utf8 de/audi/app/messaging/core/powerstate/PowerStateHandler 
.const [98] = Utf8 class$de$audi$atip$power$PowerEventListener 
.const [99] = Utf8 Ljava/lang/Class; 
.const [100] = Utf8 de/audi/app/messaging/core/powerstate/PowerStateHandler 
.const [101] = Utf8 class$ 
.const [102] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [103] = Utf8 de/audi/app/messaging/core/osgi/ServiceProperties 
.const [104] = Utf8 createServiceProperties 
.const [105] = Utf8 ()Ljava/util/Dictionary; 
.const [106] = Utf8 de/audi/app/messaging/core/powerstate/PowerStateHandler 
.const [107] = Utf8 log 
.const [108] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [109] = Utf8 java/lang/NoClassDefFoundError 
.const [110] = Utf8 initCause 
.const [111] = Utf8 (Ljava/lang/Throwable;)Ljava/lang/Throwable; 
.const [112] = Utf8 java/lang/Class 
.const [113] = Utf8 getName 
.const [114] = Utf8 ()Ljava/lang/String; 
.const [115] = Utf8 de/audi/atip/log/LogChannel 
.const [116] = Utf8 log 
.const [117] = Utf8 (ILjava/lang/String;)Z 
.const [118] = Utf8 de/audi/app/messaging/core/powerstate/PowerStateHandler 
.const [119] = Utf8 msgApp 
.const [120] = Utf8 Lde/audi/app/messaging/core/application/AbstractMsgApplication; 
.const [121] = Utf8 de/audi/app/messaging/core/application/AbstractMsgApplication 
.const [122] = Utf8 getNewMessage 
.const [123] = Utf8 ()Lde/audi/app/messaging/core/compose/NewMessage; 
.const [124] = Utf8 de/audi/app/messaging/core/compose/NewMessage 
.const [125] = Utf8 getSaveDraftController 
.const [126] = Utf8 ()Lde/audi/app/messaging/core/drafts/SaveDraftController; 
.const [127] = Utf8 de/audi/app/messaging/core/drafts/SaveDraftController 
.const [128] = Utf8 saveDraftIfJustified 
.const [129] = Utf8 (Z)V 
.const [130] = Utf8 de/audi/app/messaging/core/powerstate/PowerStateHandler 
.const [131] = Utf8 saveCompositionBuffer 
.const [132] = Utf8 ()V 
.const [133] = Utf8 java/lang/NoClassDefFoundError 
.const [134] = Utf8 <init> 
.const [135] = Utf8 ()V 
.const [136] = Utf8 de/audi/app/messaging/core/component/AbstractMessagingComponent 
.const [137] = Utf8 <init> 
.const [138] = Utf8 (Lde/audi/app/messaging/core/osgi/MessagingBundleContext;Ljava/lang/String;)V 
.const [139] = Utf8 de/audi/app/messaging/core/component/AbstractMessagingComponent 
.const [140] = Utf8 connect 
.const [141] = Utf8 (Lde/audi/app/messaging/core/osgi/IServiceRegistry;)V 
.const [142] = Utf8 de/audi/app/messaging/core/powerstate/PowerStateHandler 
.const [143] = Utf8 class$de$audi$atip$power$PowerEventListener 
.const [144] = Utf8 Ljava/lang/Class; 
.const [145] = Utf8 de/audi/app/messaging/core/powerstate/PowerStateHandler$MyPowerEventListener 
.const [146] = Utf8 <init> 
.const [147] = Utf8 (Lde/audi/app/messaging/core/powerstate/PowerStateHandler;Lde/audi/app/messaging/core/powerstate/PowerStateHandler$1;)V 
.const [148] = Utf8 de/audi/app/messaging/core/osgi/IServiceRegistry 
.const [149] = Utf8 registerService 
.const [150] = Utf8 (Ljava/lang/String;Ljava/lang/Object;Ljava/util/Dictionary;)Lorg/osgi/framework/ServiceRegistration; 
.const [151] = Utf8 de/audi/app/messaging/core/powerstate/PowerStateHandler 
.const [152] = Class [151] 
.const [153] = Utf8 de/audi/app/messaging/core/component/AbstractMessagingComponent 
.const [154] = Class [153] 
.const [155] = Utf8 class$de$audi$atip$power$PowerEventListener 
.const [156] = Utf8 Ljava/lang/Class; 
.const [157] = Utf8 Code 
.const [158] = Utf8 <init> 
.const [159] = Utf8 (Lde/audi/app/messaging/core/osgi/MessagingBundleContext;)V 
.const [160] = Utf8 connect 
.const [161] = Utf8 (Lde/audi/app/messaging/core/osgi/IServiceRegistry;)V 
.const [162] = Utf8 saveCompositionBuffer 
.const [163] = Utf8 ()V 
.const [164] = Utf8 class$ 
.const [165] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [166] = Utf8 access$100 
.const [167] = Utf8 (Lde/audi/app/messaging/core/powerstate/PowerStateHandler;)Lde/audi/atip/log/LogChannel; 
.const [168] = Utf8 access$200 
.const [169] = Utf8 (Lde/audi/app/messaging/core/powerstate/PowerStateHandler;)V 
.end class 
