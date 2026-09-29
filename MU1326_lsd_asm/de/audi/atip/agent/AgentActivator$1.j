.version 50 0 
.class super [116] 
.super [118] 
.implements [120] 
.field private final synthetic [121] [122] 
.field private final synthetic [123] [124] 

.method [126] : [127] 
    .attribute [125] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [27] 
L5:     aload_0 
L6:     aload_2 
L7:     putfield [28] 
L10:    aload_0 
L11:    invokespecial [26] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [128] : [129] 
    .attribute [125] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [19] 
L4:     invokestatic [2] 
L7:     ldc [3] 
L9:     ldc [4] 
L11:    aload_1 
L12:    invokevirtual [21] 
L15:    pop 
L16:    aconst_null 
L17:    astore_2 
        .catch [8] from L18 to L67 using L71 
L18:    aload_0 
L19:    getfield [20] 
L22:    aload_1 
L23:    invokeinterface [29] 0 
L28:    astore_2 
L29:    aload_2 
L30:    instanceof [5] 
L33:    ifeq L68 
L36:    aload_0 
L37:    getfield [19] 
L40:    invokestatic [2] 
L43:    ldc [3] 
L45:    ldc [6] 
L47:    aload_2 
L48:    invokevirtual [21] 
L51:    pop 
L52:    aload_0 
L53:    getfield [19] 
L56:    invokestatic [7] 
L59:    aload_2 
L60:    checkcast [5] 
L63:    invokevirtual [22] 
L66:    aload_2 
L67:    areturn 
L68:    goto L89 
L71:    astore_3 
L72:    aload_0 
L73:    getfield [19] 
L76:    invokestatic [2] 
L79:    ldc [3] 
L81:    ldc [9] 
L83:    aload_1 
L84:    aload_3 
L85:    invokevirtual [23] 
L88:    pop 
L89:    aload_2 
L90:    ifnull L104 
L93:    aload_0 
L94:    getfield [20] 
L97:    aload_1 
L98:    invokeinterface [30] 0 
L103:   pop 
L104:   aconst_null 
L105:   areturn 
L106:   nop 
L107:   nop 
L108:   
    .end code 
.end method 

.method public enum [130] : [131] 
    .attribute [125] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [132] : [133] 
    .attribute [125] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [19] 
L4:     invokestatic [2] 
L7:     ldc [3] 
L9:     ldc [10] 
L11:    aload_1 
L12:    aload_2 
L13:    invokevirtual [24] 
        .catch [8] from L16 to L64 using L67 
L16:    aload_0 
L17:    getfield [20] 
L20:    aload_1 
L21:    invokeinterface [30] 0 
L26:    pop 
L27:    aload_2 
L28:    instanceof [5] 
L31:    ifeq L64 
L34:    aload_0 
L35:    getfield [19] 
L38:    invokestatic [2] 
L41:    ldc [3] 
L43:    ldc [11] 
L45:    aload_2 
L46:    invokevirtual [21] 
L49:    pop 
L50:    aload_0 
L51:    getfield [19] 
L54:    invokestatic [7] 
L57:    aload_2 
L58:    checkcast [5] 
L61:    invokevirtual [25] 
L64:    goto L85 
L67:    astore_3 
L68:    aload_0 
L69:    getfield [19] 
L72:    invokestatic [2] 
L75:    ldc [3] 
L77:    ldc [12] 
L79:    aload_1 
L80:    aload_3 
L81:    invokevirtual [23] 
L84:    pop 
L85:    return 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [31] [32] 
.const [3] = Int 1078071040 
.const [4] = String [33] 
.const [5] = Class [34] 
.const [6] = String [35] 
.const [7] = Method [36] [37] 
.const [8] = Class [38] 
.const [9] = String [39] 
.const [10] = String [40] 
.const [11] = String [41] 
.const [12] = String [42] 
.const [13] = Class [43] 
.const [14] = Class [44] 
.const [15] = Class [45] 
.const [16] = Class [46] 
.const [17] = Class [47] 
.const [18] = Class [48] 
.const [19] = Field [49] [50] 
.const [20] = Field [51] [52] 
.const [21] = Method [53] [54] 
.const [22] = Method [55] [56] 
.const [23] = Method [57] [58] 
.const [24] = Method [59] [60] 
.const [25] = Method [61] [62] 
.const [26] = Method [63] [64] 
.const [27] = Field [65] [66] 
.const [28] = Field [67] [68] 
.const [29] = InterfaceMethod [69] [70] 
.const [30] = InterfaceMethod [71] [72] 
.const [31] = Class [73] 
.const [32] = NameAndType [74] [75] 
.const [33] = Utf8 'Adding service: %1' 
.const [34] = Utf8 de/audi/atip/agent/IASIProvider 
.const [35] = Utf8 'Adding ASIHandler: %1' 
.const [36] = Class [76] 
.const [37] = NameAndType [77] [78] 
.const [38] = Utf8 java/lang/Exception 
.const [39] = Utf8 'Adding Service failed: %1' 
.const [40] = Utf8 'Removed service: %1 %2' 
.const [41] = Utf8 'Removed ASIHandler: %1' 
.const [42] = Utf8 'Removed Service failed: %1' 
.const [43] = Utf8 de/audi/atip/agent/AgentActivator$1 
.const [44] = Utf8 java/lang/Object 
.const [45] = Utf8 de/audi/atip/agent/AgentActivator 
.const [46] = Utf8 de/audi/atip/log/LogChannel 
.const [47] = Utf8 org/osgi/framework/BundleContext 
.const [48] = Utf8 de/audi/atip/agent/AgentService 
.const [49] = Class [79] 
.const [50] = NameAndType [80] [81] 
.const [51] = Class [82] 
.const [52] = NameAndType [83] [84] 
.const [53] = Class [85] 
.const [54] = NameAndType [86] [87] 
.const [55] = Class [88] 
.const [56] = NameAndType [89] [90] 
.const [57] = Class [91] 
.const [58] = NameAndType [92] [93] 
.const [59] = Class [94] 
.const [60] = NameAndType [95] [96] 
.const [61] = Class [97] 
.const [62] = NameAndType [98] [99] 
.const [63] = Class [100] 
.const [64] = NameAndType [101] [102] 
.const [65] = Class [103] 
.const [66] = NameAndType [104] [105] 
.const [67] = Class [106] 
.const [68] = NameAndType [107] [108] 
.const [69] = Class [109] 
.const [70] = NameAndType [110] [111] 
.const [71] = Class [112] 
.const [72] = NameAndType [113] [114] 
.const [73] = Utf8 de/audi/atip/agent/AgentActivator 
.const [74] = Utf8 access$000 
.const [75] = Utf8 (Lde/audi/atip/agent/AgentActivator;)Lde/audi/atip/log/LogChannel; 
.const [76] = Utf8 de/audi/atip/agent/AgentActivator 
.const [77] = Utf8 access$100 
.const [78] = Utf8 (Lde/audi/atip/agent/AgentActivator;)Lde/audi/atip/agent/AgentService; 
.const [79] = Utf8 de/audi/atip/agent/AgentActivator$1 
.const [80] = Utf8 this$0 
.const [81] = Utf8 Lde/audi/atip/agent/AgentActivator; 
.const [82] = Utf8 de/audi/atip/agent/AgentActivator$1 
.const [83] = Utf8 val$context 
.const [84] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [85] = Utf8 de/audi/atip/log/LogChannel 
.const [86] = Utf8 log 
.const [87] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [88] = Utf8 de/audi/atip/agent/AgentService 
.const [89] = Utf8 register 
.const [90] = Utf8 (Lde/audi/atip/agent/IASIProvider;)V 
.const [91] = Utf8 de/audi/atip/log/LogChannel 
.const [92] = Utf8 log 
.const [93] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)Z 
.const [94] = Utf8 de/audi/atip/log/LogChannel 
.const [95] = Utf8 log 
.const [96] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [97] = Utf8 de/audi/atip/agent/AgentService 
.const [98] = Utf8 unregister 
.const [99] = Utf8 (Lde/audi/atip/agent/IASIProvider;)V 
.const [100] = Utf8 java/lang/Object 
.const [101] = Utf8 <init> 
.const [102] = Utf8 ()V 
.const [103] = Utf8 de/audi/atip/agent/AgentActivator$1 
.const [104] = Utf8 this$0 
.const [105] = Utf8 Lde/audi/atip/agent/AgentActivator; 
.const [106] = Utf8 de/audi/atip/agent/AgentActivator$1 
.const [107] = Utf8 val$context 
.const [108] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [109] = Utf8 org/osgi/framework/BundleContext 
.const [110] = Utf8 getService 
.const [111] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [112] = Utf8 org/osgi/framework/BundleContext 
.const [113] = Utf8 ungetService 
.const [114] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [115] = Utf8 de/audi/atip/agent/AgentActivator$1 
.const [116] = Class [115] 
.const [117] = Utf8 java/lang/Object 
.const [118] = Class [117] 
.const [119] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [120] = Class [119] 
.const [121] = Utf8 val$context 
.const [122] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [123] = Utf8 this$0 
.const [124] = Utf8 Lde/audi/atip/agent/AgentActivator; 
.const [125] = Utf8 Code 
.const [126] = Utf8 <init> 
.const [127] = Utf8 (Lde/audi/atip/agent/AgentActivator;Lorg/osgi/framework/BundleContext;)V 
.const [128] = Utf8 addingService 
.const [129] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [130] = Utf8 modifiedService 
.const [131] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [132] = Utf8 removedService 
.const [133] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.end class 
