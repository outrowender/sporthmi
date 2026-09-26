.version 50 0 
.class super [99] 
.super [101] 
.implements [103] 
.field private final synthetic [104] [105] 
.field private final synthetic [106] [107] 
.field private final synthetic [108] [109] 

.method [111] : [112] 
    .attribute [110] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [16] 
L5:     aload_0 
L6:     aload_2 
L7:     putfield [17] 
L10:    aload_0 
L11:    aload_3 
L12:    putfield [18] 
L15:    aload_0 
L16:    invokespecial [15] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [113] : [114] 
    .attribute [110] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [13] 
L4:     aload_1 
L5:     invokeinterface [19] 0 
L10:    astore_2 
L11:    aload_2 
L12:    instanceof [2] 
L15:    ifeq L33 
L18:    aload_0 
L19:    getfield [12] 
L22:    aload_2 
L23:    checkcast [2] 
L26:    invokestatic [3] 
L29:    pop 
L30:    goto L68 
L33:    aload_2 
L34:    instanceof [4] 
L37:    ifeq L68 
L40:    aload_0 
L41:    getfield [12] 
L44:    aload_2 
L45:    checkcast [4] 
L48:    invokestatic [5] 
L51:    pop 
L52:    aload_0 
L53:    getfield [12] 
L56:    invokestatic [6] 
L59:    aload_0 
L60:    getfield [14] 
L63:    invokeinterface [20] 0 
L68:    aload_0 
L69:    getfield [12] 
L72:    invokestatic [7] 
L75:    areturn 
L76:    
    .end code 
.end method 

.method public enum [115] : [116] 
    .attribute [110] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [117] : [118] 
    .attribute [110] .code stack 2 locals 0 
L0:     aload_2 
L1:     instanceof [2] 
L4:     ifeq L19 
L7:     aload_0 
L8:     getfield [12] 
L11:    aconst_null 
L12:    invokestatic [3] 
L15:    pop 
L16:    goto L51 
L19:    aload_2 
L20:    instanceof [4] 
L23:    ifeq L51 
L26:    aload_0 
L27:    getfield [12] 
L30:    invokestatic [6] 
L33:    aload_0 
L34:    getfield [14] 
L37:    invokeinterface [21] 0 
L42:    aload_0 
L43:    getfield [12] 
L46:    aconst_null 
L47:    invokestatic [5] 
L50:    pop 
L51:    return 
L52:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [22] 
.const [3] = Method [23] [24] 
.const [4] = Class [25] 
.const [5] = Method [26] [27] 
.const [6] = Method [28] [29] 
.const [7] = Method [30] [31] 
.const [8] = Class [32] 
.const [9] = Class [33] 
.const [10] = Class [34] 
.const [11] = Class [35] 
.const [12] = Field [36] [37] 
.const [13] = Field [38] [39] 
.const [14] = Field [40] [41] 
.const [15] = Method [42] [43] 
.const [16] = Field [44] [45] 
.const [17] = Field [46] [47] 
.const [18] = Field [48] [49] 
.const [19] = InterfaceMethod [50] [51] 
.const [20] = InterfaceMethod [52] [53] 
.const [21] = InterfaceMethod [54] [55] 
.const [22] = Utf8 de/audi/atip/mmicombi/IMMICombiViewSizeSync 
.const [23] = Class [56] 
.const [24] = NameAndType [57] [58] 
.const [25] = Utf8 de/audi/atip/interapp/SDSService 
.const [26] = Class [59] 
.const [27] = NameAndType [60] [61] 
.const [28] = Class [62] 
.const [29] = NameAndType [63] [64] 
.const [30] = Class [65] 
.const [31] = NameAndType [66] [67] 
.const [32] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeManager$1 
.const [33] = Utf8 java/lang/Object 
.const [34] = Utf8 org/osgi/framework/BundleContext 
.const [35] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeManager 
.const [36] = Class [68] 
.const [37] = NameAndType [69] [70] 
.const [38] = Class [71] 
.const [39] = NameAndType [72] [73] 
.const [40] = Class [74] 
.const [41] = NameAndType [75] [76] 
.const [42] = Class [77] 
.const [43] = NameAndType [78] [79] 
.const [44] = Class [80] 
.const [45] = NameAndType [81] [82] 
.const [46] = Class [83] 
.const [47] = NameAndType [84] [85] 
.const [48] = Class [86] 
.const [49] = NameAndType [87] [88] 
.const [50] = Class [89] 
.const [51] = NameAndType [90] [91] 
.const [52] = Class [92] 
.const [53] = NameAndType [93] [94] 
.const [54] = Class [95] 
.const [55] = NameAndType [96] [97] 
.const [56] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeManager 
.const [57] = Utf8 access$202 
.const [58] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/ViewSizeManager;Lde/audi/atip/mmicombi/IMMICombiViewSizeSync;)Lde/audi/atip/mmicombi/IMMICombiViewSizeSync; 
.const [59] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeManager 
.const [60] = Utf8 access$302 
.const [61] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/ViewSizeManager;Lde/audi/atip/interapp/SDSService;)Lde/audi/atip/interapp/SDSService; 
.const [62] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeManager 
.const [63] = Utf8 access$300 
.const [64] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/ViewSizeManager;)Lde/audi/atip/interapp/SDSService; 
.const [65] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeManager 
.const [66] = Utf8 access$200 
.const [67] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/ViewSizeManager;)Lde/audi/atip/mmicombi/IMMICombiViewSizeSync; 
.const [68] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeManager$1 
.const [69] = Utf8 this$0 
.const [70] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/ViewSizeManager; 
.const [71] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeManager$1 
.const [72] = Utf8 val$bundleContext 
.const [73] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [74] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeManager$1 
.const [75] = Utf8 val$thisRef 
.const [76] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/ViewSizeManager; 
.const [77] = Utf8 java/lang/Object 
.const [78] = Utf8 <init> 
.const [79] = Utf8 ()V 
.const [80] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeManager$1 
.const [81] = Utf8 this$0 
.const [82] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/ViewSizeManager; 
.const [83] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeManager$1 
.const [84] = Utf8 val$bundleContext 
.const [85] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [86] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeManager$1 
.const [87] = Utf8 val$thisRef 
.const [88] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/ViewSizeManager; 
.const [89] = Utf8 org/osgi/framework/BundleContext 
.const [90] = Utf8 getService 
.const [91] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [92] = Utf8 de/audi/atip/interapp/SDSService 
.const [93] = Utf8 registerStatusListener 
.const [94] = Utf8 (Lde/audi/atip/interapp/ISDSServiceStatusListener;)V 
.const [95] = Utf8 de/audi/atip/interapp/SDSService 
.const [96] = Utf8 unregisterStatusListener 
.const [97] = Utf8 (Lde/audi/atip/interapp/ISDSServiceStatusListener;)V 
.const [98] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeManager$1 
.const [99] = Class [98] 
.const [100] = Utf8 java/lang/Object 
.const [101] = Class [100] 
.const [102] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [103] = Class [102] 
.const [104] = Utf8 val$bundleContext 
.const [105] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [106] = Utf8 val$thisRef 
.const [107] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/ViewSizeManager; 
.const [108] = Utf8 this$0 
.const [109] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/ViewSizeManager; 
.const [110] = Utf8 Code 
.const [111] = Utf8 <init> 
.const [112] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/ViewSizeManager;Lorg/osgi/framework/BundleContext;Lde/esolutions/hmi/widgets/audi/evo/ViewSizeManager;)V 
.const [113] = Utf8 addingService 
.const [114] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [115] = Utf8 modifiedService 
.const [116] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [117] = Utf8 removedService 
.const [118] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.end class 
