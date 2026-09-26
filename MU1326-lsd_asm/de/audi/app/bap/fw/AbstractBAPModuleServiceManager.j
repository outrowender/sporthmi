.version 50 0 
.class public super abstract [118] 
.super [120] 
.implements [122] 
.field protected [123] [124] 
.field protected [125] [126] 
.field protected [127] [128] 

.method public [130] : [131] 
    .attribute [129] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [22] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [23] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public abstract [132] : [133] 
    .attribute [129] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public abstract [134] : [135] 
    .attribute [129] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected [136] : [137] 
    .attribute [129] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     ifnull L14 
L7:     aload_0 
L8:     getfield [15] 
L11:    invokevirtual [16] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [138] : [139] 
    .attribute [129] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [14] 
L4:     aload_1 
L5:     invokeinterface [24] 0 
L10:    astore_2 
L11:    aload_2 
L12:    instanceof [2] 
L15:    ifeq L68 
L18:    aload_0 
L19:    getfield [13] 
L22:    invokevirtual [17] 
L25:    ldc [3] 
L27:    ldc [4] 
L29:    aload_0 
L30:    getfield [13] 
L33:    invokevirtual [18] 
L36:    invokestatic [5] 
L39:    invokevirtual [19] 
L42:    pop 
L43:    aload_0 
L44:    getfield [13] 
L47:    iconst_1 
L48:    invokevirtual [20] 
L51:    astore_3 
L52:    aload_3 
L53:    ifnull L68 
L56:    aload_2 
L57:    checkcast [2] 
L60:    aload_3 
L61:    invokeinterface [25] 0 
L66:    aload_2 
L67:    areturn 
L68:    aload_0 
L69:    getfield [14] 
L72:    aload_1 
L73:    invokeinterface [26] 0 
L78:    pop 
L79:    aconst_null 
L80:    areturn 
L81:    nop 
L82:    nop 
L83:    nop 
L84:    
    .end code 
.end method 

.method public enum [140] : [141] 
    .attribute [129] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [142] : [143] 
    .attribute [129] .code stack 2 locals 1 
L0:     aload_2 
L1:     instanceof [2] 
L4:     ifeq L41 
L7:     aload_0 
L8:     getfield [13] 
L11:    iconst_0 
L12:    invokevirtual [20] 
L15:    astore_3 
L16:    aload_3 
L17:    ifnull L41 
L20:    aload_2 
L21:    checkcast [2] 
L24:    aload_3 
L25:    invokeinterface [27] 0 
L30:    aload_0 
L31:    getfield [14] 
L34:    aload_1 
L35:    invokeinterface [26] 0 
L40:    pop 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [28] 
.const [3] = Int -2137614336 
.const [4] = String [29] 
.const [5] = Method [30] [31] 
.const [6] = Class [32] 
.const [7] = Class [33] 
.const [8] = Class [34] 
.const [9] = Class [35] 
.const [10] = Class [36] 
.const [11] = Class [37] 
.const [12] = Class [38] 
.const [13] = Field [39] [40] 
.const [14] = Field [41] [42] 
.const [15] = Field [43] [44] 
.const [16] = Method [45] [46] 
.const [17] = Method [47] [48] 
.const [18] = Method [49] [50] 
.const [19] = Method [51] [52] 
.const [20] = Method [53] [54] 
.const [21] = Method [55] [56] 
.const [22] = Field [57] [58] 
.const [23] = Field [59] [60] 
.const [24] = InterfaceMethod [61] [62] 
.const [25] = InterfaceMethod [63] [64] 
.const [26] = InterfaceMethod [65] [66] 
.const [27] = InterfaceMethod [67] [68] 
.const [28] = Utf8 de/audi/atip/diag/sw/SwDiagnosisManager 
.const [29] = Utf8 '[AbstractBAPModuleServiceManager#addingService] SwDiagnosisManager found -> adding diagnosis gateway of lsg=%1' 
.const [30] = Class [69] 
.const [31] = NameAndType [70] [71] 
.const [32] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleServiceManager 
.const [33] = Utf8 java/lang/Object 
.const [34] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [35] = Utf8 org/osgi/framework/BundleContext 
.const [36] = Utf8 de/audi/app/bap/fw/AbstractBAPModule 
.const [37] = Utf8 de/audi/app/bap/utils/LSGIDs 
.const [38] = Utf8 de/audi/atip/log/LogChannel 
.const [39] = Class [72] 
.const [40] = NameAndType [73] [74] 
.const [41] = Class [75] 
.const [42] = NameAndType [76] [77] 
.const [43] = Class [78] 
.const [44] = NameAndType [79] [80] 
.const [45] = Class [81] 
.const [46] = NameAndType [82] [83] 
.const [47] = Class [84] 
.const [48] = NameAndType [85] [86] 
.const [49] = Class [87] 
.const [50] = NameAndType [88] [89] 
.const [51] = Class [90] 
.const [52] = NameAndType [91] [92] 
.const [53] = Class [93] 
.const [54] = NameAndType [94] [95] 
.const [55] = Class [96] 
.const [56] = NameAndType [97] [98] 
.const [57] = Class [99] 
.const [58] = NameAndType [100] [101] 
.const [59] = Class [102] 
.const [60] = NameAndType [103] [104] 
.const [61] = Class [105] 
.const [62] = NameAndType [106] [107] 
.const [63] = Class [108] 
.const [64] = NameAndType [109] [110] 
.const [65] = Class [111] 
.const [66] = NameAndType [112] [113] 
.const [67] = Class [114] 
.const [68] = NameAndType [115] [116] 
.const [69] = Utf8 de/audi/app/bap/utils/LSGIDs 
.const [70] = Utf8 getDescription 
.const [71] = Utf8 (I)Ljava/lang/String; 
.const [72] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleServiceManager 
.const [73] = Utf8 'module' 
.const [74] = Utf8 Lde/audi/app/bap/fw/AbstractBAPModule; 
.const [75] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleServiceManager 
.const [76] = Utf8 bundleContext 
.const [77] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [78] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleServiceManager 
.const [79] = Utf8 serviceTracker 
.const [80] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [81] = Utf8 org/osgi/util/tracker/ServiceTracker 
.const [82] = Utf8 close 
.const [83] = Utf8 ()V 
.const [84] = Utf8 de/audi/app/bap/fw/AbstractBAPModule 
.const [85] = Utf8 getLogChannel 
.const [86] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [87] = Utf8 de/audi/app/bap/fw/AbstractBAPModule 
.const [88] = Utf8 getLSGID 
.const [89] = Utf8 ()I 
.const [90] = Utf8 de/audi/atip/log/LogChannel 
.const [91] = Utf8 log 
.const [92] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [93] = Utf8 de/audi/app/bap/fw/AbstractBAPModule 
.const [94] = Utf8 getDiagnosisGateway 
.const [95] = Utf8 (Z)Lde/audi/atip/diag/sw/AbstractSwDiagnosis; 
.const [96] = Utf8 java/lang/Object 
.const [97] = Utf8 <init> 
.const [98] = Utf8 ()V 
.const [99] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleServiceManager 
.const [100] = Utf8 'module' 
.const [101] = Utf8 Lde/audi/app/bap/fw/AbstractBAPModule; 
.const [102] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleServiceManager 
.const [103] = Utf8 bundleContext 
.const [104] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [105] = Utf8 org/osgi/framework/BundleContext 
.const [106] = Utf8 getService 
.const [107] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [108] = Utf8 de/audi/atip/diag/sw/SwDiagnosisManager 
.const [109] = Utf8 addDiagGateway 
.const [110] = Utf8 (Lde/audi/atip/diag/sw/AbstractSwDiagnosis;)V 
.const [111] = Utf8 org/osgi/framework/BundleContext 
.const [112] = Utf8 ungetService 
.const [113] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [114] = Utf8 de/audi/atip/diag/sw/SwDiagnosisManager 
.const [115] = Utf8 removeDiagGateway 
.const [116] = Utf8 (Lde/audi/atip/diag/sw/AbstractSwDiagnosis;)V 
.const [117] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleServiceManager 
.const [118] = Class [117] 
.const [119] = Utf8 java/lang/Object 
.const [120] = Class [119] 
.const [121] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [122] = Class [121] 
.const [123] = Utf8 'module' 
.const [124] = Utf8 Lde/audi/app/bap/fw/AbstractBAPModule; 
.const [125] = Utf8 bundleContext 
.const [126] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [127] = Utf8 serviceTracker 
.const [128] = Utf8 Lorg/osgi/util/tracker/ServiceTracker; 
.const [129] = Utf8 Code 
.const [130] = Utf8 <init> 
.const [131] = Utf8 (Lde/audi/app/bap/fw/AbstractBAPModule;Lorg/osgi/framework/BundleContext;)V 
.const [132] = Utf8 registerServices 
.const [133] = Utf8 (Lde/audi/atip/activator/AbstractActivator;)V 
.const [134] = Utf8 trackServices 
.const [135] = Utf8 ()V 
.const [136] = Utf8 closeTracker 
.const [137] = Utf8 ()V 
.const [138] = Utf8 addingService 
.const [139] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [140] = Utf8 modifiedService 
.const [141] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [142] = Utf8 removedService 
.const [143] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.end class 
