.version 50 0 
.class super [134] 
.super [136] 
.field private final synthetic [137] [138] 

.method private [140] : [141] 
    .attribute [139] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [28] 
L5:     aload_0 
L6:     invokespecial [26] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [142] : [143] 
    .attribute [139] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [16] 
L4:     invokevirtual [17] 
L7:     aload_1 
L8:     invokeinterface [29] 0 
L13:    checkcast [2] 
L16:    astore_2 
L17:    aload_2 
L18:    ifnull L80 
L21:    aload_0 
L22:    getfield [16] 
L25:    getfield [18] 
L28:    getfield [19] 
L31:    ldc [3] 
L33:    ldc [4] 
L35:    aload_2 
L36:    invokevirtual [20] 
L39:    pop 
L40:    aload_2 
L41:    invokeinterface [30] 0 
L46:    astore_3 
L47:    aload_0 
L48:    getfield [16] 
L51:    invokevirtual [21] 
L54:    getfield [22] 
L57:    aload_3 
L58:    invokevirtual [23] 
L61:    aload_3 
L62:    aload_0 
L63:    getfield [16] 
L66:    invokevirtual [21] 
L69:    getfield [22] 
L72:    getfield [24] 
L75:    invokeinterface [31] 0 
L80:    aload_2 
L81:    areturn 
L82:    nop 
L83:    nop 
L84:    
    .end code 
.end method 

.method public [144] : [145] 
    .attribute [139] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     getfield [18] 
L7:     getfield [19] 
L10:    ldc [3] 
L12:    ldc [5] 
L14:    aload_2 
L15:    invokevirtual [20] 
L18:    pop 
L19:    aload_0 
L20:    getfield [16] 
L23:    invokevirtual [21] 
L26:    getfield [22] 
L29:    new [32] 
L32:    dup 
L33:    aload_0 
L34:    getfield [16] 
L37:    getfield [18] 
L40:    getfield [19] 
L43:    invokespecial [27] 
L46:    invokevirtual [23] 
L49:    aload_0 
L50:    getfield [16] 
L53:    invokevirtual [17] 
L56:    aload_1 
L57:    invokeinterface [33] 0 
L62:    pop 
L63:    return 
L64:    
    .end code 
.end method 

.method synthetic [146] : [147] 
    .attribute [139] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [25] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [34] 
.const [3] = Int 1078071040 
.const [4] = String [35] 
.const [5] = String [36] 
.const [6] = Class [37] 
.const [7] = Class [38] 
.const [8] = Class [39] 
.const [9] = Class [40] 
.const [10] = Class [41] 
.const [11] = Class [42] 
.const [12] = Class [43] 
.const [13] = Class [44] 
.const [14] = Class [45] 
.const [15] = Class [46] 
.const [16] = Field [47] [48] 
.const [17] = Method [49] [50] 
.const [18] = Field [51] [52] 
.const [19] = Field [53] [54] 
.const [20] = Method [55] [56] 
.const [21] = Method [57] [58] 
.const [22] = Field [59] [60] 
.const [23] = Method [61] [62] 
.const [24] = Field [63] [64] 
.const [25] = Method [65] [66] 
.const [26] = Method [67] [68] 
.const [27] = Method [69] [70] 
.const [28] = Field [71] [72] 
.const [29] = InterfaceMethod [73] [74] 
.const [30] = InterfaceMethod [75] [76] 
.const [31] = InterfaceMethod [77] [78] 
.const [32] = Class [79] 
.const [33] = InterfaceMethod [80] [81] 
.const [34] = Utf8 de/audi/tghu/waveplayer/WavePlayer 
.const [35] = Utf8 '[Activator.WavePlayerTracker.addingService] %1' 
.const [36] = Utf8 '[Activator.WavePlayerTracker.removedService] %1' 
.const [37] = Utf8 de/audi/atip/interapp/def/NullSystemTonePlayer 
.const [38] = Utf8 de/audi/tv/app/base/AbstractTVActivator$WavePlayerTracker 
.const [39] = Utf8 de/audi/atip/interapp/def/DefaultServiceTrackerCustomizer 
.const [40] = Utf8 de/audi/tv/app/base/AbstractTVActivator 
.const [41] = Utf8 org/osgi/framework/BundleContext 
.const [42] = Utf8 de/audi/tv/app/base/TVEnv 
.const [43] = Utf8 de/audi/atip/log/LogChannel 
.const [44] = Utf8 de/audi/tv/app/base/TVAppCommon 
.const [45] = Utf8 de/audi/tv/app/audio/EWSBeepHandler 
.const [46] = Utf8 de/audi/tghu/waveplayer/SystemTonePlayer 
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
.const [79] = Utf8 de/audi/atip/interapp/def/NullSystemTonePlayer 
.const [80] = Class [130] 
.const [81] = NameAndType [131] [132] 
.const [82] = Utf8 de/audi/tv/app/base/AbstractTVActivator$WavePlayerTracker 
.const [83] = Utf8 this$0 
.const [84] = Utf8 Lde/audi/tv/app/base/AbstractTVActivator; 
.const [85] = Utf8 de/audi/tv/app/base/AbstractTVActivator 
.const [86] = Utf8 getBundleContext 
.const [87] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [88] = Utf8 de/audi/tv/app/base/AbstractTVActivator 
.const [89] = Utf8 env 
.const [90] = Utf8 Lde/audi/tv/app/base/TVEnv; 
.const [91] = Utf8 de/audi/tv/app/base/TVEnv 
.const [92] = Utf8 lcMain 
.const [93] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [94] = Utf8 de/audi/atip/log/LogChannel 
.const [95] = Utf8 log 
.const [96] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [97] = Utf8 de/audi/tv/app/base/AbstractTVActivator 
.const [98] = Utf8 getApp 
.const [99] = Utf8 ()Lde/audi/tv/app/base/TVAppCommon; 
.const [100] = Utf8 de/audi/tv/app/base/TVAppCommon 
.const [101] = Utf8 ewsBeep 
.const [102] = Utf8 Lde/audi/tv/app/audio/EWSBeepHandler; 
.const [103] = Utf8 de/audi/tv/app/audio/EWSBeepHandler 
.const [104] = Utf8 setSystemTonePlayer 
.const [105] = Utf8 (Lde/audi/tghu/waveplayer/SystemTonePlayer;)V 
.const [106] = Utf8 de/audi/tv/app/audio/EWSBeepHandler 
.const [107] = Utf8 playerListener 
.const [108] = Utf8 Lde/audi/tv/app/audio/EWSBeepHandler$PlayerListener; 
.const [109] = Utf8 de/audi/tv/app/base/AbstractTVActivator$WavePlayerTracker 
.const [110] = Utf8 <init> 
.const [111] = Utf8 (Lde/audi/tv/app/base/AbstractTVActivator;)V 
.const [112] = Utf8 de/audi/atip/interapp/def/DefaultServiceTrackerCustomizer 
.const [113] = Utf8 <init> 
.const [114] = Utf8 ()V 
.const [115] = Utf8 de/audi/atip/interapp/def/NullSystemTonePlayer 
.const [116] = Utf8 <init> 
.const [117] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [118] = Utf8 de/audi/tv/app/base/AbstractTVActivator$WavePlayerTracker 
.const [119] = Utf8 this$0 
.const [120] = Utf8 Lde/audi/tv/app/base/AbstractTVActivator; 
.const [121] = Utf8 org/osgi/framework/BundleContext 
.const [122] = Utf8 getService 
.const [123] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [124] = Utf8 de/audi/tghu/waveplayer/WavePlayer 
.const [125] = Utf8 getSystemTonePlayer 
.const [126] = Utf8 ()Lde/audi/tghu/waveplayer/SystemTonePlayer; 
.const [127] = Utf8 de/audi/tghu/waveplayer/SystemTonePlayer 
.const [128] = Utf8 setListener 
.const [129] = Utf8 (Lde/audi/tghu/waveplayer/WavePlayerListener;)V 
.const [130] = Utf8 org/osgi/framework/BundleContext 
.const [131] = Utf8 ungetService 
.const [132] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [133] = Utf8 de/audi/tv/app/base/AbstractTVActivator$WavePlayerTracker 
.const [134] = Class [133] 
.const [135] = Utf8 de/audi/atip/interapp/def/DefaultServiceTrackerCustomizer 
.const [136] = Class [135] 
.const [137] = Utf8 this$0 
.const [138] = Utf8 Lde/audi/tv/app/base/AbstractTVActivator; 
.const [139] = Utf8 Code 
.const [140] = Utf8 <init> 
.const [141] = Utf8 (Lde/audi/tv/app/base/AbstractTVActivator;)V 
.const [142] = Utf8 addingService 
.const [143] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [144] = Utf8 removedService 
.const [145] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [146] = Utf8 <init> 
.const [147] = Utf8 (Lde/audi/tv/app/base/AbstractTVActivator;Lde/audi/tv/app/base/AbstractTVActivator$1;)V 
.end class 
