.version 50 0 
.class super [122] 
.super [124] 
.implements [126] 
.field private final synthetic [127] [128] 

.method private [130] : [131] 
    .attribute [129] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [29] 
L5:     aload_0 
L6:     invokespecial [28] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [132] : [133] 
    .attribute [129] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [21] 
L4:     invokestatic [2] 
L7:     ldc [3] 
L9:     ldc [4] 
L11:    aload_1 
L12:    invokevirtual [22] 
L15:    pop 
L16:    aconst_null 
L17:    astore_2 
        .catch [8] from L18 to L70 using L74 
L18:    aload_0 
L19:    getfield [21] 
L22:    invokestatic [5] 
L25:    aload_1 
L26:    invokeinterface [30] 0 
L31:    astore_2 
L32:    aload_2 
L33:    instanceof [6] 
L36:    ifeq L71 
L39:    aload_0 
L40:    getfield [21] 
L43:    invokestatic [2] 
L46:    ldc [3] 
L48:    ldc [7] 
L50:    aload_2 
L51:    invokevirtual [22] 
L54:    pop 
L55:    aload_0 
L56:    getfield [21] 
L59:    getfield [23] 
L62:    aload_2 
L63:    checkcast [6] 
L66:    invokevirtual [24] 
L69:    aload_2 
L70:    areturn 
L71:    goto L92 
L74:    astore_3 
L75:    aload_0 
L76:    getfield [21] 
L79:    invokestatic [2] 
L82:    ldc [3] 
L84:    ldc [9] 
L86:    aload_1 
L87:    aload_3 
L88:    invokevirtual [25] 
L91:    pop 
L92:    aload_2 
L93:    ifnull L110 
L96:    aload_0 
L97:    getfield [21] 
L100:   invokestatic [10] 
L103:   aload_1 
L104:   invokeinterface [31] 0 
L109:   pop 
L110:   aconst_null 
L111:   areturn 
L112:   
    .end code 
.end method 

.method public enum [134] : [135] 
    .attribute [129] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [136] : [137] 
    .attribute [129] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [21] 
L4:     invokestatic [2] 
L7:     ldc [3] 
L9:     ldc [11] 
L11:    aload_1 
L12:    aload_2 
L13:    invokevirtual [26] 
        .catch [8] from L16 to L64 using L67 
L16:    aload_0 
L17:    getfield [21] 
L20:    invokestatic [12] 
L23:    aload_1 
L24:    invokeinterface [31] 0 
L29:    pop 
L30:    aload_2 
L31:    instanceof [6] 
L34:    ifeq L64 
L37:    aload_0 
L38:    getfield [21] 
L41:    invokestatic [2] 
L44:    ldc [3] 
L46:    ldc [13] 
L48:    aload_2 
L49:    invokevirtual [22] 
L52:    pop 
L53:    aload_0 
L54:    getfield [21] 
L57:    getfield [23] 
L60:    aconst_null 
L61:    invokevirtual [24] 
L64:    goto L85 
L67:    astore_3 
L68:    aload_0 
L69:    getfield [21] 
L72:    invokestatic [2] 
L75:    ldc [3] 
L77:    ldc [14] 
L79:    aload_1 
L80:    aload_3 
L81:    invokevirtual [25] 
L84:    pop 
L85:    return 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 

.method synthetic [138] : [139] 
    .attribute [129] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [27] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [32] [33] 
.const [3] = Int 1078071040 
.const [4] = String [34] 
.const [5] = Method [35] [36] 
.const [6] = Class [37] 
.const [7] = String [38] 
.const [8] = Class [39] 
.const [9] = String [40] 
.const [10] = Method [41] [42] 
.const [11] = String [43] 
.const [12] = Method [44] [45] 
.const [13] = String [46] 
.const [14] = String [47] 
.const [15] = Class [48] 
.const [16] = Class [49] 
.const [17] = Class [50] 
.const [18] = Class [51] 
.const [19] = Class [52] 
.const [20] = Class [53] 
.const [21] = Field [54] [55] 
.const [22] = Method [56] [57] 
.const [23] = Field [58] [59] 
.const [24] = Method [60] [61] 
.const [25] = Method [62] [63] 
.const [26] = Method [64] [65] 
.const [27] = Method [66] [67] 
.const [28] = Method [68] [69] 
.const [29] = Field [70] [71] 
.const [30] = InterfaceMethod [72] [73] 
.const [31] = InterfaceMethod [74] [75] 
.const [32] = Class [76] 
.const [33] = NameAndType [77] [78] 
.const [34] = Utf8 'Adding service: %1' 
.const [35] = Class [79] 
.const [36] = NameAndType [80] [81] 
.const [37] = Utf8 de/audi/tghu/navi/app/sdis/INaviTabletService 
.const [38] = Utf8 'Adding ASIHandler: %1' 
.const [39] = Utf8 java/lang/Exception 
.const [40] = Utf8 'Adding Service failed: %1' 
.const [41] = Class [82] 
.const [42] = NameAndType [83] [84] 
.const [43] = Utf8 'Removed service: %1 %2' 
.const [44] = Class [85] 
.const [45] = NameAndType [86] [87] 
.const [46] = Utf8 'Removed ASIHandler: %1' 
.const [47] = Utf8 'Removed Service failed: %1' 
.const [48] = Utf8 de/audi/app/navi/sdis/NaviSDISActivator$MyServiceTracker 
.const [49] = Utf8 java/lang/Object 
.const [50] = Utf8 de/audi/app/navi/sdis/NaviSDISActivator 
.const [51] = Utf8 de/audi/atip/log/LogChannel 
.const [52] = Utf8 org/osgi/framework/BundleContext 
.const [53] = Utf8 de/audi/app/navi/sdis/NaviASIProvider 
.const [54] = Class [88] 
.const [55] = NameAndType [89] [90] 
.const [56] = Class [91] 
.const [57] = NameAndType [92] [93] 
.const [58] = Class [94] 
.const [59] = NameAndType [95] [96] 
.const [60] = Class [97] 
.const [61] = NameAndType [98] [99] 
.const [62] = Class [100] 
.const [63] = NameAndType [101] [102] 
.const [64] = Class [103] 
.const [65] = NameAndType [104] [105] 
.const [66] = Class [106] 
.const [67] = NameAndType [107] [108] 
.const [68] = Class [109] 
.const [69] = NameAndType [110] [111] 
.const [70] = Class [112] 
.const [71] = NameAndType [113] [114] 
.const [72] = Class [115] 
.const [73] = NameAndType [116] [117] 
.const [74] = Class [118] 
.const [75] = NameAndType [119] [120] 
.const [76] = Utf8 de/audi/app/navi/sdis/NaviSDISActivator 
.const [77] = Utf8 access$100 
.const [78] = Utf8 (Lde/audi/app/navi/sdis/NaviSDISActivator;)Lde/audi/atip/log/LogChannel; 
.const [79] = Utf8 de/audi/app/navi/sdis/NaviSDISActivator 
.const [80] = Utf8 access$200 
.const [81] = Utf8 (Lde/audi/app/navi/sdis/NaviSDISActivator;)Lorg/osgi/framework/BundleContext; 
.const [82] = Utf8 de/audi/app/navi/sdis/NaviSDISActivator 
.const [83] = Utf8 access$300 
.const [84] = Utf8 (Lde/audi/app/navi/sdis/NaviSDISActivator;)Lorg/osgi/framework/BundleContext; 
.const [85] = Utf8 de/audi/app/navi/sdis/NaviSDISActivator 
.const [86] = Utf8 access$400 
.const [87] = Utf8 (Lde/audi/app/navi/sdis/NaviSDISActivator;)Lorg/osgi/framework/BundleContext; 
.const [88] = Utf8 de/audi/app/navi/sdis/NaviSDISActivator$MyServiceTracker 
.const [89] = Utf8 this$0 
.const [90] = Utf8 Lde/audi/app/navi/sdis/NaviSDISActivator; 
.const [91] = Utf8 de/audi/atip/log/LogChannel 
.const [92] = Utf8 log 
.const [93] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [94] = Utf8 de/audi/app/navi/sdis/NaviSDISActivator 
.const [95] = Utf8 naviAsiProvider 
.const [96] = Utf8 Lde/audi/app/navi/sdis/NaviASIProvider; 
.const [97] = Utf8 de/audi/app/navi/sdis/NaviASIProvider 
.const [98] = Utf8 setTabletService 
.const [99] = Utf8 (Lde/audi/tghu/navi/app/sdis/INaviTabletService;)V 
.const [100] = Utf8 de/audi/atip/log/LogChannel 
.const [101] = Utf8 log 
.const [102] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)Z 
.const [103] = Utf8 de/audi/atip/log/LogChannel 
.const [104] = Utf8 log 
.const [105] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [106] = Utf8 de/audi/app/navi/sdis/NaviSDISActivator$MyServiceTracker 
.const [107] = Utf8 <init> 
.const [108] = Utf8 (Lde/audi/app/navi/sdis/NaviSDISActivator;)V 
.const [109] = Utf8 java/lang/Object 
.const [110] = Utf8 <init> 
.const [111] = Utf8 ()V 
.const [112] = Utf8 de/audi/app/navi/sdis/NaviSDISActivator$MyServiceTracker 
.const [113] = Utf8 this$0 
.const [114] = Utf8 Lde/audi/app/navi/sdis/NaviSDISActivator; 
.const [115] = Utf8 org/osgi/framework/BundleContext 
.const [116] = Utf8 getService 
.const [117] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [118] = Utf8 org/osgi/framework/BundleContext 
.const [119] = Utf8 ungetService 
.const [120] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [121] = Utf8 de/audi/app/navi/sdis/NaviSDISActivator$MyServiceTracker 
.const [122] = Class [121] 
.const [123] = Utf8 java/lang/Object 
.const [124] = Class [123] 
.const [125] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [126] = Class [125] 
.const [127] = Utf8 this$0 
.const [128] = Utf8 Lde/audi/app/navi/sdis/NaviSDISActivator; 
.const [129] = Utf8 Code 
.const [130] = Utf8 <init> 
.const [131] = Utf8 (Lde/audi/app/navi/sdis/NaviSDISActivator;)V 
.const [132] = Utf8 addingService 
.const [133] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [134] = Utf8 modifiedService 
.const [135] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [136] = Utf8 removedService 
.const [137] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [138] = Utf8 <init> 
.const [139] = Utf8 (Lde/audi/app/navi/sdis/NaviSDISActivator;Lde/audi/app/navi/sdis/NaviSDISActivator$1;)V 
.end class 
