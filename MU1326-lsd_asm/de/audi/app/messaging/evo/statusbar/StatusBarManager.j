.version 50 0 
.class public final super [132] 
.super [134] 

.method public [136] : [137] 
    .attribute [135] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [2] 
L4:     invokespecial [26] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [138] : [139] 
    .attribute [135] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [27] 
L5:     aload_1 
L6:     invokevirtual [17] 
L9:     new [29] 
L12:    dup 
L13:    aload_0 
L14:    aconst_null 
L15:    invokespecial [28] 
L18:    invokevirtual [18] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method private synchronized [140] : [141] 
    .attribute [135] .code stack 5 locals 4 
L0:     aload_0 
L1:     getfield [19] 
L4:     invokevirtual [17] 
L7:     invokevirtual [20] 
L10:    istore_1 
L11:    aload_0 
L12:    getfield [19] 
L15:    invokevirtual [17] 
L18:    invokevirtual [21] 
L21:    istore_2 
L22:    aload_0 
L23:    getfield [16] 
L26:    invokevirtual [22] 
L29:    ifeq L51 
L32:    aload_0 
L33:    getfield [16] 
L36:    ldc [4] 
L38:    ldc [5] 
L40:    iload_2 
L41:    invokestatic [6] 
L44:    iload_1 
L45:    invokestatic [6] 
L48:    invokevirtual [23] 
L51:    iload_2 
L52:    ifeq L59 
L55:    iconst_1 
L56:    goto L60 
L59:    iconst_0 
L60:    istore_3 
L61:    aload_0 
L62:    getfield [24] 
L65:    invokeinterface [30] 0 
L70:    sipush 4447 
L73:    invokeinterface [31] 0 
L78:    iload_3 
L79:    invokeinterface [32] 0 
L84:    iload_1 
L85:    ifeq L92 
L88:    iconst_1 
L89:    goto L93 
L92:    iconst_0 
L93:    istore 4 
L95:    aload_0 
L96:    getfield [24] 
L99:    invokeinterface [30] 0 
L104:   sipush 4446 
L107:   invokeinterface [31] 0 
L112:   iload 4 
L114:   invokeinterface [32] 0 
L119:   return 
L120:   
    .end code 
.end method 

.method static synthetic [142] : [143] 
    .attribute [135] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [144] : [145] 
    .attribute [135] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [33] 
.const [3] = Class [34] 
.const [4] = Int 1078071040 
.const [5] = String [35] 
.const [6] = Method [36] [37] 
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
.const [18] = Method [51] [52] 
.const [19] = Field [53] [54] 
.const [20] = Method [55] [56] 
.const [21] = Method [57] [58] 
.const [22] = Method [59] [60] 
.const [23] = Method [61] [62] 
.const [24] = Field [63] [64] 
.const [25] = Method [65] [66] 
.const [26] = Method [67] [68] 
.const [27] = Method [69] [70] 
.const [28] = Method [71] [72] 
.const [29] = Class [73] 
.const [30] = InterfaceMethod [74] [75] 
.const [31] = InterfaceMethod [76] [77] 
.const [32] = InterfaceMethod [78] [79] 
.const [33] = Utf8 'App.Messaging.Main' 
.const [34] = Utf8 de/audi/app/messaging/evo/statusbar/StatusBarManager$NewMessageIndicationManagerObserver 
.const [35] = Utf8 '[StatusBarManager#setStatusBarIcons] newMessageAvailable = %1, memoryDepleted = %2' 
.const [36] = Class [80] 
.const [37] = NameAndType [81] [82] 
.const [38] = Utf8 de/audi/app/messaging/evo/statusbar/StatusBarManager 
.const [39] = Utf8 de/audi/app/messaging/core/component/AbstractMessagingComponent 
.const [40] = Utf8 de/audi/app/messaging/core/application/AbstractMsgApplication 
.const [41] = Utf8 de/audi/app/messaging/core/indication/NewMessageIndicationManager 
.const [42] = Utf8 de/audi/atip/log/LogChannel 
.const [43] = Utf8 java/lang/String 
.const [44] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [45] = Utf8 de/audi/atip/hmi/IHMIServiceApp 
.const [46] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [47] = Class [83] 
.const [48] = NameAndType [84] [85] 
.const [49] = Class [86] 
.const [50] = NameAndType [87] [88] 
.const [51] = Class [89] 
.const [52] = NameAndType [90] [91] 
.const [53] = Class [92] 
.const [54] = NameAndType [93] [94] 
.const [55] = Class [95] 
.const [56] = NameAndType [96] [97] 
.const [57] = Class [98] 
.const [58] = NameAndType [99] [100] 
.const [59] = Class [101] 
.const [60] = NameAndType [102] [103] 
.const [61] = Class [104] 
.const [62] = NameAndType [105] [106] 
.const [63] = Class [107] 
.const [64] = NameAndType [108] [109] 
.const [65] = Class [110] 
.const [66] = NameAndType [111] [112] 
.const [67] = Class [113] 
.const [68] = NameAndType [114] [115] 
.const [69] = Class [116] 
.const [70] = NameAndType [117] [118] 
.const [71] = Class [119] 
.const [72] = NameAndType [120] [121] 
.const [73] = Utf8 de/audi/app/messaging/evo/statusbar/StatusBarManager$NewMessageIndicationManagerObserver 
.const [74] = Class [122] 
.const [75] = NameAndType [123] [124] 
.const [76] = Class [125] 
.const [77] = NameAndType [126] [127] 
.const [78] = Class [128] 
.const [79] = NameAndType [129] [130] 
.const [80] = Utf8 java/lang/String 
.const [81] = Utf8 valueOf 
.const [82] = Utf8 (Z)Ljava/lang/String; 
.const [83] = Utf8 de/audi/app/messaging/evo/statusbar/StatusBarManager 
.const [84] = Utf8 log 
.const [85] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [86] = Utf8 de/audi/app/messaging/core/application/AbstractMsgApplication 
.const [87] = Utf8 getNewMessageIndicationManager 
.const [88] = Utf8 ()Lde/audi/app/messaging/core/indication/NewMessageIndicationManager; 
.const [89] = Utf8 de/audi/app/messaging/core/indication/NewMessageIndicationManager 
.const [90] = Utf8 addObserver 
.const [91] = Utf8 (Lde/audi/app/messaging/core/indication/INewMessageIndicationManagerObserver;)V 
.const [92] = Utf8 de/audi/app/messaging/evo/statusbar/StatusBarManager 
.const [93] = Utf8 msgApp 
.const [94] = Utf8 Lde/audi/app/messaging/core/application/AbstractMsgApplication; 
.const [95] = Utf8 de/audi/app/messaging/core/indication/NewMessageIndicationManager 
.const [96] = Utf8 isMemoryDepleted 
.const [97] = Utf8 ()Z 
.const [98] = Utf8 de/audi/app/messaging/core/indication/NewMessageIndicationManager 
.const [99] = Utf8 newMessagesAvailable 
.const [100] = Utf8 ()Z 
.const [101] = Utf8 de/audi/atip/log/LogChannel 
.const [102] = Utf8 isInfo 
.const [103] = Utf8 ()Z 
.const [104] = Utf8 de/audi/atip/log/LogChannel 
.const [105] = Utf8 log 
.const [106] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [107] = Utf8 de/audi/app/messaging/evo/statusbar/StatusBarManager 
.const [108] = Utf8 framework 
.const [109] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [110] = Utf8 de/audi/app/messaging/evo/statusbar/StatusBarManager 
.const [111] = Utf8 setStatusBarIcons 
.const [112] = Utf8 ()V 
.const [113] = Utf8 de/audi/app/messaging/core/component/AbstractMessagingComponent 
.const [114] = Utf8 <init> 
.const [115] = Utf8 (Lde/audi/app/messaging/core/osgi/MessagingBundleContext;Ljava/lang/String;)V 
.const [116] = Utf8 de/audi/app/messaging/core/component/AbstractMessagingComponent 
.const [117] = Utf8 init 
.const [118] = Utf8 (Lde/audi/app/messaging/core/application/AbstractMsgApplication;)V 
.const [119] = Utf8 de/audi/app/messaging/evo/statusbar/StatusBarManager$NewMessageIndicationManagerObserver 
.const [120] = Utf8 <init> 
.const [121] = Utf8 (Lde/audi/app/messaging/evo/statusbar/StatusBarManager;Lde/audi/app/messaging/evo/statusbar/StatusBarManager$1;)V 
.const [122] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [123] = Utf8 getHmiServiceApp 
.const [124] = Utf8 ()Lde/audi/atip/hmi/IHMIServiceApp; 
.const [125] = Utf8 de/audi/atip/hmi/IHMIServiceApp 
.const [126] = Utf8 getChoiceModel 
.const [127] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [128] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [129] = Utf8 setValue 
.const [130] = Utf8 (I)V 
.const [131] = Utf8 de/audi/app/messaging/evo/statusbar/StatusBarManager 
.const [132] = Class [131] 
.const [133] = Utf8 de/audi/app/messaging/core/component/AbstractMessagingComponent 
.const [134] = Class [133] 
.const [135] = Utf8 Code 
.const [136] = Utf8 <init> 
.const [137] = Utf8 (Lde/audi/app/messaging/core/osgi/MessagingBundleContext;)V 
.const [138] = Utf8 init 
.const [139] = Utf8 (Lde/audi/app/messaging/core/application/AbstractMsgApplication;)V 
.const [140] = Utf8 setStatusBarIcons 
.const [141] = Utf8 ()V 
.const [142] = Utf8 access$100 
.const [143] = Utf8 (Lde/audi/app/messaging/evo/statusbar/StatusBarManager;)Lde/audi/atip/log/LogChannel; 
.const [144] = Utf8 access$200 
.const [145] = Utf8 (Lde/audi/app/messaging/evo/statusbar/StatusBarManager;)V 
.end class 
