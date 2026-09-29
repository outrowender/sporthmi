.version 50 0 
.class public super abstract [134] 
.super [136] 
.field private [137] [138] 

.method protected [140] : [141] 
    .attribute [139] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     new [27] 
L5:     dup 
L6:     aload_1 
L7:     invokespecial [23] 
L10:    invokespecial [24] 
L13:    aload_0 
L14:    aload_0 
L15:    aload_1 
L16:    invokevirtual [17] 
L19:    putfield [28] 
L22:    aload_0 
L23:    getfield [19] 
L26:    ldc [3] 
L28:    ldc [4] 
L30:    invokevirtual [20] 
L33:    pop 
L34:    return 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [142] : [143] 
    .attribute [139] .code stack 1 locals 0 
L0:     ldc [5] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected abstract [144] : [145] 
    .attribute [139] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public interface [146] : [147] 
    .attribute [139] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [148] : [149] 
    .attribute [139] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [25] 
L5:     aload_0 
L6:     getfield [18] 
L9:     aload_1 
L10:    invokevirtual [21] 
L13:    invokeinterface [29] 0 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method protected [150] : [151] 
    .attribute [139] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     aload_0 
L5:     getfield [18] 
L8:     invokeinterface [30] 0 
L13:    aload_0 
L14:    aconst_null 
L15:    putfield [28] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [152] : [153] 
    .attribute [139] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     invokeinterface [31] 0 
L9:     invokeinterface [32] 0 
L14:    invokeinterface [33] 0 
L19:    ifne L30 
L22:    ldc [6] 
L24:    invokestatic [7] 
L27:    ifeq L34 
L30:    iconst_1 
L31:    goto L35 
L34:    iconst_0 
L35:    areturn 
L36:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [34] 
.const [3] = Int 1078071040 
.const [4] = String [35] 
.const [5] = String [36] 
.const [6] = String [37] 
.const [7] = Method [38] [39] 
.const [8] = Class [40] 
.const [9] = Class [41] 
.const [10] = Class [42] 
.const [11] = Class [43] 
.const [12] = Class [44] 
.const [13] = Class [45] 
.const [14] = Class [46] 
.const [15] = Class [47] 
.const [16] = Class [48] 
.const [17] = Method [49] [50] 
.const [18] = Field [51] [52] 
.const [19] = Field [53] [54] 
.const [20] = Method [55] [56] 
.const [21] = Method [57] [58] 
.const [22] = Field [59] [60] 
.const [23] = Method [61] [62] 
.const [24] = Method [63] [64] 
.const [25] = Method [65] [66] 
.const [26] = Method [67] [68] 
.const [27] = Class [69] 
.const [28] = Field [70] [71] 
.const [29] = InterfaceMethod [72] [73] 
.const [30] = InterfaceMethod [74] [75] 
.const [31] = InterfaceMethod [76] [77] 
.const [32] = InterfaceMethod [78] [79] 
.const [33] = InterfaceMethod [80] [81] 
.const [34] = Utf8 de/audi/app/combi/bap/utils/CombiLogger 
.const [35] = Utf8 '*** Combi BAP HMI application has been started ***' 
.const [36] = Utf8 Combi 
.const [37] = Utf8 MOSTListSupported 
.const [38] = Class [82] 
.const [39] = NameAndType [83] [84] 
.const [40] = Utf8 de/audi/app/combi/bap/AbstractCombiBAPApplication 
.const [41] = Utf8 de/audi/app/bap/AbstractBAPApplication 
.const [42] = Utf8 de/audi/atip/log/LogChannel 
.const [43] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [44] = Utf8 de/audi/app/combi/bap/app/kombipictures/IPictureManager 
.const [45] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [46] = Utf8 de/audi/atip/sysapp/carcoding/ISysConstManager 
.const [47] = Utf8 de/audi/atip/sysapp/carcoding/Adaptation 
.const [48] = Utf8 java/lang/Boolean 
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
.const [69] = Utf8 de/audi/app/combi/bap/utils/CombiLogger 
.const [70] = Class [115] 
.const [71] = NameAndType [116] [117] 
.const [72] = Class [118] 
.const [73] = NameAndType [119] [120] 
.const [74] = Class [121] 
.const [75] = NameAndType [122] [123] 
.const [76] = Class [124] 
.const [77] = NameAndType [125] [126] 
.const [78] = Class [127] 
.const [79] = NameAndType [128] [129] 
.const [80] = Class [130] 
.const [81] = NameAndType [131] [132] 
.const [82] = Utf8 java/lang/Boolean 
.const [83] = Utf8 getBoolean 
.const [84] = Utf8 (Ljava/lang/String;)Z 
.const [85] = Utf8 de/audi/app/combi/bap/AbstractCombiBAPApplication 
.const [86] = Utf8 createPictureManager 
.const [87] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)Lde/audi/app/combi/bap/app/kombipictures/IPictureManager; 
.const [88] = Utf8 de/audi/app/combi/bap/AbstractCombiBAPApplication 
.const [89] = Utf8 pictureManager 
.const [90] = Utf8 Lde/audi/app/combi/bap/app/kombipictures/IPictureManager; 
.const [91] = Utf8 de/audi/app/combi/bap/AbstractCombiBAPApplication 
.const [92] = Utf8 logChannel 
.const [93] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [94] = Utf8 de/audi/atip/log/LogChannel 
.const [95] = Utf8 log 
.const [96] = Utf8 (ILjava/lang/String;)Z 
.const [97] = Utf8 de/audi/atip/activator/AbstractActivator 
.const [98] = Utf8 getBundleContext 
.const [99] = Utf8 ()Lorg/osgi/framework/BundleContext; 
.const [100] = Utf8 de/audi/app/combi/bap/AbstractCombiBAPApplication 
.const [101] = Utf8 frameworkAccess 
.const [102] = Utf8 Lde/audi/atip/base/IFrameworkAccess; 
.const [103] = Utf8 de/audi/app/combi/bap/utils/CombiLogger 
.const [104] = Utf8 <init> 
.const [105] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [106] = Utf8 de/audi/app/bap/AbstractBAPApplication 
.const [107] = Utf8 <init> 
.const [108] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;Lde/audi/app/bap/utils/IBAPLogger;)V 
.const [109] = Utf8 de/audi/app/bap/AbstractBAPApplication 
.const [110] = Utf8 activate 
.const [111] = Utf8 (Lde/audi/atip/activator/AbstractActivator;)V 
.const [112] = Utf8 de/audi/app/bap/AbstractBAPApplication 
.const [113] = Utf8 dereferenceApplicationComponents 
.const [114] = Utf8 ()V 
.const [115] = Utf8 de/audi/app/combi/bap/AbstractCombiBAPApplication 
.const [116] = Utf8 pictureManager 
.const [117] = Utf8 Lde/audi/app/combi/bap/app/kombipictures/IPictureManager; 
.const [118] = Utf8 de/audi/app/combi/bap/app/kombipictures/IPictureManager 
.const [119] = Utf8 init 
.const [120] = Utf8 (Lorg/osgi/framework/BundleContext;)V 
.const [121] = Utf8 de/audi/app/combi/bap/app/kombipictures/IPictureManager 
.const [122] = Utf8 deinit 
.const [123] = Utf8 ()V 
.const [124] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [125] = Utf8 getSysConstManager 
.const [126] = Utf8 ()Lde/audi/atip/sysapp/carcoding/ISysConstManager; 
.const [127] = Utf8 de/audi/atip/sysapp/carcoding/ISysConstManager 
.const [128] = Utf8 getAdaptationANP 
.const [129] = Utf8 ()Lde/audi/atip/sysapp/carcoding/Adaptation; 
.const [130] = Utf8 de/audi/atip/sysapp/carcoding/Adaptation 
.const [131] = Utf8 isFastMOSTListAvailable 
.const [132] = Utf8 ()Z 
.const [133] = Utf8 de/audi/app/combi/bap/AbstractCombiBAPApplication 
.const [134] = Class [133] 
.const [135] = Utf8 de/audi/app/bap/AbstractBAPApplication 
.const [136] = Class [135] 
.const [137] = Utf8 pictureManager 
.const [138] = Utf8 Lde/audi/app/combi/bap/app/kombipictures/IPictureManager; 
.const [139] = Utf8 Code 
.const [140] = Utf8 <init> 
.const [141] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [142] = Utf8 getName 
.const [143] = Utf8 ()Ljava/lang/String; 
.const [144] = Utf8 createPictureManager 
.const [145] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)Lde/audi/app/combi/bap/app/kombipictures/IPictureManager; 
.const [146] = Utf8 getPictureManager 
.const [147] = Utf8 ()Lde/audi/app/combi/bap/app/kombipictures/IPictureManager; 
.const [148] = Utf8 activate 
.const [149] = Utf8 (Lde/audi/atip/activator/AbstractActivator;)V 
.const [150] = Utf8 dereferenceApplicationComponents 
.const [151] = Utf8 ()V 
.const [152] = Utf8 isMOSTListSupported 
.const [153] = Utf8 ()Z 
.end class 
