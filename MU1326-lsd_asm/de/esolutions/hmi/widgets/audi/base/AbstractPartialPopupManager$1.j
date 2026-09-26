.version 50 0 
.class super [138] 
.super [140] 
.implements [142] 
.field private final synthetic [143] [144] 

.method [146] : [147] 
    .attribute [145] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [30] 
L5:     aload_0 
L6:     invokespecial [26] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [148] : [149] 
    .attribute [145] .code stack 8 locals 1 
L0:     aload_0 
L1:     getfield [21] 
L4:     getfield [22] 
L7:     aload_1 
L8:     invokeinterface [31] 0 
L13:    checkcast [2] 
L16:    astore_2 
L17:    getstatic [3] 
L20:    ldc [4] 
L22:    ldc [5] 
L24:    aload_1 
L25:    aload_2 
L26:    invokevirtual [23] 
L29:    getstatic [6] 
L32:    invokeinterface [32] 0 
L37:    new [33] 
L40:    dup 
L41:    iconst_1 
L42:    new [34] 
L45:    dup 
L46:    aload_0 
L47:    aload_2 
L48:    invokespecial [27] 
L51:    invokespecial [28] 
L54:    invokeinterface [35] 0 
L59:    pop 
L60:    aload_2 
L61:    areturn 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method private [150] : [151] 
    .attribute [145] .code stack 2 locals 2 
L0:     iconst_0 
L1:     istore_2 
L2:     iload_2 
L3:     aload_0 
L4:     getfield [21] 
L7:     getfield [24] 
L10:    arraylength 
L11:    if_icmpge L46 
L14:    aload_0 
L15:    getfield [21] 
L18:    getfield [24] 
L21:    iload_2 
L22:    aaload 
L23:    astore_3 
L24:    aload_3 
L25:    ifnull L40 
L28:    aload_3 
L29:    invokeinterface [36] 0 
L34:    iload_1 
L35:    if_icmpne L40 
L38:    iconst_1 
L39:    areturn 
L40:    iinc 2 1 
L43:    goto L2 
L46:    iconst_0 
L47:    areturn 
L48:    
    .end code 
.end method 

.method public enum [152] : [153] 
    .attribute [145] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [154] : [155] 
    .attribute [145] .code stack 8 locals 1 
L0:     aload_0 
L1:     getfield [21] 
L4:     getfield [22] 
L7:     aload_1 
L8:     invokeinterface [31] 0 
L13:    checkcast [2] 
L16:    astore_3 
L17:    getstatic [3] 
L20:    ldc [4] 
L22:    ldc [9] 
L24:    aload_1 
L25:    aload_3 
L26:    invokevirtual [23] 
L29:    getstatic [6] 
L32:    invokeinterface [32] 0 
L37:    new [33] 
L40:    dup 
L41:    iconst_1 
L42:    new [37] 
L45:    dup 
L46:    aload_0 
L47:    aload_3 
L48:    invokespecial [29] 
L51:    invokespecial [28] 
L54:    invokeinterface [35] 0 
L59:    pop 
L60:    return 
L61:    nop 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method static synthetic [156] : [157] 
    .attribute [145] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [158] : [159] 
    .attribute [145] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [25] 
L5:     areturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [38] 
.const [3] = Field [39] [40] 
.const [4] = Int -2137614336 
.const [5] = String [41] 
.const [6] = Field [42] [43] 
.const [7] = Class [44] 
.const [8] = Class [45] 
.const [9] = String [46] 
.const [10] = Class [47] 
.const [11] = Class [48] 
.const [12] = Class [49] 
.const [13] = Class [50] 
.const [14] = Class [51] 
.const [15] = Class [52] 
.const [16] = Class [53] 
.const [17] = Class [54] 
.const [18] = Class [55] 
.const [19] = Class [56] 
.const [20] = Class [57] 
.const [21] = Field [58] [59] 
.const [22] = Field [60] [61] 
.const [23] = Method [62] [63] 
.const [24] = Field [64] [65] 
.const [25] = Method [66] [67] 
.const [26] = Method [68] [69] 
.const [27] = Method [70] [71] 
.const [28] = Method [72] [73] 
.const [29] = Method [74] [75] 
.const [30] = Field [76] [77] 
.const [31] = InterfaceMethod [78] [79] 
.const [32] = InterfaceMethod [80] [81] 
.const [33] = Class [82] 
.const [34] = Class [83] 
.const [35] = InterfaceMethod [84] [85] 
.const [36] = InterfaceMethod [86] [87] 
.const [37] = Class [88] 
.const [38] = Utf8 de/audi/atip/hmi/view/IPartialPopupListener 
.const [39] = Class [89] 
.const [40] = NameAndType [90] [91] 
.const [41] = Utf8 'PartialPopupManager#addingService reference: %1, ppListener: %2' 
.const [42] = Class [92] 
.const [43] = NameAndType [93] [94] 
.const [44] = Utf8 de/audi/atip/hmi/event/RunnableEvent 
.const [45] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractPartialPopupManager$1$1 
.const [46] = Utf8 'PartialPopupManager#removedService reference: %1, ppListener: %2' 
.const [47] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractPartialPopupManager$1$2 
.const [48] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractPartialPopupManager$1 
.const [49] = Utf8 java/lang/Object 
.const [50] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractPartialPopupManager 
.const [51] = Utf8 org/osgi/framework/BundleContext 
.const [52] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [53] = Utf8 de/audi/atip/log/LogChannel 
.const [54] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [55] = Utf8 de/audi/tghu/hmi/evo/IHMIServiceEvo 
.const [56] = Utf8 de/audi/atip/hmi/event/EventDispatcher 
.const [57] = Utf8 de/audi/tghu/hmi/evo/IPartialPopupControllerEvo 
.const [58] = Class [95] 
.const [59] = NameAndType [96] [97] 
.const [60] = Class [98] 
.const [61] = NameAndType [99] [100] 
.const [62] = Class [101] 
.const [63] = NameAndType [102] [103] 
.const [64] = Class [104] 
.const [65] = NameAndType [105] [106] 
.const [66] = Class [107] 
.const [67] = NameAndType [108] [109] 
.const [68] = Class [110] 
.const [69] = NameAndType [111] [112] 
.const [70] = Class [113] 
.const [71] = NameAndType [114] [115] 
.const [72] = Class [116] 
.const [73] = NameAndType [117] [118] 
.const [74] = Class [119] 
.const [75] = NameAndType [120] [121] 
.const [76] = Class [122] 
.const [77] = NameAndType [123] [124] 
.const [78] = Class [125] 
.const [79] = NameAndType [126] [127] 
.const [80] = Class [128] 
.const [81] = NameAndType [129] [130] 
.const [82] = Utf8 de/audi/atip/hmi/event/RunnableEvent 
.const [83] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractPartialPopupManager$1$1 
.const [84] = Class [131] 
.const [85] = NameAndType [132] [133] 
.const [86] = Class [134] 
.const [87] = NameAndType [135] [136] 
.const [88] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractPartialPopupManager$1$2 
.const [89] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [90] = Utf8 logChannelPopups 
.const [91] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [92] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [93] = Utf8 hmiService 
.const [94] = Utf8 Lde/audi/tghu/hmi/evo/IHMIServiceEvo; 
.const [95] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractPartialPopupManager$1 
.const [96] = Utf8 this$0 
.const [97] = Utf8 Lde/esolutions/hmi/widgets/audi/base/AbstractPartialPopupManager; 
.const [98] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractPartialPopupManager 
.const [99] = Utf8 bundleContext 
.const [100] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [101] = Utf8 de/audi/atip/log/LogChannel 
.const [102] = Utf8 log 
.const [103] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [104] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractPartialPopupManager 
.const [105] = Utf8 currentVisiblePopups 
.const [106] = Utf8 [Lde/audi/tghu/hmi/evo/IPartialPopupControllerEvo; 
.const [107] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractPartialPopupManager$1 
.const [108] = Utf8 isPartialPopupVisible 
.const [109] = Utf8 (I)Z 
.const [110] = Utf8 java/lang/Object 
.const [111] = Utf8 <init> 
.const [112] = Utf8 ()V 
.const [113] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractPartialPopupManager$1$1 
.const [114] = Utf8 <init> 
.const [115] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/AbstractPartialPopupManager$1;Lde/audi/atip/hmi/view/IPartialPopupListener;)V 
.const [116] = Utf8 de/audi/atip/hmi/event/RunnableEvent 
.const [117] = Utf8 <init> 
.const [118] = Utf8 (ZLjava/lang/Runnable;)V 
.const [119] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractPartialPopupManager$1$2 
.const [120] = Utf8 <init> 
.const [121] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/AbstractPartialPopupManager$1;Lde/audi/atip/hmi/view/IPartialPopupListener;)V 
.const [122] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractPartialPopupManager$1 
.const [123] = Utf8 this$0 
.const [124] = Utf8 Lde/esolutions/hmi/widgets/audi/base/AbstractPartialPopupManager; 
.const [125] = Utf8 org/osgi/framework/BundleContext 
.const [126] = Utf8 getService 
.const [127] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [128] = Utf8 de/audi/tghu/hmi/evo/IHMIServiceEvo 
.const [129] = Utf8 getEventDispatcher 
.const [130] = Utf8 ()Lde/audi/atip/hmi/event/EventDispatcher; 
.const [131] = Utf8 de/audi/atip/hmi/event/EventDispatcher 
.const [132] = Utf8 postEvent 
.const [133] = Utf8 (Lde/audi/atip/hmi/event/ATIPEvent;)Lde/esolutions/fw/util/commons/job/Job; 
.const [134] = Utf8 de/audi/tghu/hmi/evo/IPartialPopupControllerEvo 
.const [135] = Utf8 getID 
.const [136] = Utf8 ()I 
.const [137] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractPartialPopupManager$1 
.const [138] = Class [137] 
.const [139] = Utf8 java/lang/Object 
.const [140] = Class [139] 
.const [141] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [142] = Class [141] 
.const [143] = Utf8 this$0 
.const [144] = Utf8 Lde/esolutions/hmi/widgets/audi/base/AbstractPartialPopupManager; 
.const [145] = Utf8 Code 
.const [146] = Utf8 <init> 
.const [147] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/AbstractPartialPopupManager;)V 
.const [148] = Utf8 addingService 
.const [149] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [150] = Utf8 isPartialPopupVisible 
.const [151] = Utf8 (I)Z 
.const [152] = Utf8 modifiedService 
.const [153] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [154] = Utf8 removedService 
.const [155] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [156] = Utf8 access$000 
.const [157] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/AbstractPartialPopupManager$1;)Lde/esolutions/hmi/widgets/audi/base/AbstractPartialPopupManager; 
.const [158] = Utf8 access$200 
.const [159] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/AbstractPartialPopupManager$1;I)Z 
.end class 
