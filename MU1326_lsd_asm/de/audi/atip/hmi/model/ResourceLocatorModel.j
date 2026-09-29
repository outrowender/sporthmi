.version 50 0 
.class public super [152] 
.super [154] 
.implements [156] 
.implements [158] 
.field private static final [159] [160] 
.field private volatile [161] [162] 

.method public [164] : [165] 
    .attribute [163] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iconst_0 
L3:     invokespecial [25] 
L6:     aload_0 
L7:     getstatic [2] 
L10:    putfield [32] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [166] : [167] 
    .attribute [163] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     invokespecial [25] 
L6:     aload_0 
L7:     getstatic [2] 
L10:    putfield [32] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [168] : [169] 
    .attribute [163] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     getstatic [2] 
L7:     if_acmpne L14 
L10:    iconst_1 
L11:    goto L15 
L14:    iconst_0 
L15:    areturn 
L16:    
    .end code 
.end method 

.method public [170] : [171] 
    .attribute [163] .code stack 1 locals 0 
L0:     bipush 22 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public interface [172] : [173] 
    .attribute [163] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [174] : [175] 
    .attribute [163] .code stack 4 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     aload_2 
L3:     iconst_1 
L4:     invokespecial [27] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [176] : [177] 
    .attribute [163] .code stack 4 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     aload_2 
L3:     iconst_0 
L4:     invokespecial [27] 
L7:     return 
L8:     
    .end code 
.end method 

.method private [178] : [179] 
    .attribute [163] .code stack 8 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     aload_2 
L9:     iload_1 
L10:    i2l 
L11:    aload_0 
L12:    getfield [16] 
L15:    i2l 
L16:    invokevirtual [17] 
L19:    pop 
L20:    aload_0 
L21:    new [33] 
L24:    dup 
L25:    iload_1 
L26:    aload_2 
L27:    invokespecial [28] 
L30:    putfield [32] 
L33:    iload_3 
L34:    ifeq L42 
L37:    aload_0 
L38:    iconst_1 
L39:    invokevirtual [18] 
L42:    return 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [180] : [181] 
    .attribute [163] .code stack 8 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     aload_2 
L9:     iload_1 
L10:    i2l 
L11:    aload_0 
L12:    getfield [16] 
L15:    i2l 
L16:    invokevirtual [17] 
L19:    pop 
L20:    aload_0 
L21:    getfield [15] 
L24:    ldc [3] 
L26:    ldc [6] 
L28:    iload_3 
L29:    i2l 
L30:    aload_0 
L31:    getfield [16] 
L34:    i2l 
L35:    invokevirtual [19] 
L38:    pop 
L39:    aload_0 
L40:    new [33] 
L43:    dup 
L44:    iload_1 
L45:    aload_2 
L46:    invokespecial [28] 
L49:    putfield [32] 
L52:    aload_0 
L53:    getfield [14] 
L56:    iload_3 
L57:    invokevirtual [20] 
L60:    aload_0 
L61:    iconst_1 
L62:    invokevirtual [18] 
L65:    return 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [182] : [183] 
    .attribute [163] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     ldc [3] 
L6:     ldc [7] 
L8:     aload_1 
L9:     aload_0 
L10:    getfield [16] 
L13:    i2l 
L14:    invokevirtual [21] 
L17:    pop 
L18:    aload_0 
L19:    new [33] 
L22:    dup 
L23:    aload_1 
L24:    invokespecial [29] 
L27:    putfield [32] 
L30:    aload_0 
L31:    iconst_1 
L32:    invokevirtual [18] 
L35:    return 
L36:    
    .end code 
.end method 

.method public [184] : [185] 
    .attribute [163] .code stack 3 locals 1 
L0:     new [34] 
L3:     dup 
L4:     sipush 300 
L7:     invokespecial [30] 
L10:    astore_1 
L11:    aload_1 
L12:    aload_0 
L13:    invokespecial [31] 
L16:    invokevirtual [22] 
L19:    pop 
L20:    aload_1 
L21:    ldc [9] 
L23:    invokevirtual [22] 
L26:    aload_0 
L27:    getfield [14] 
L30:    invokevirtual [23] 
L33:    pop 
L34:    aload_1 
L35:    invokevirtual [24] 
L38:    areturn 
L39:    nop 
L40:    
    .end code 
.end method 

.method public enum [186] : [187] 
    .attribute [163] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method static [188] : [189] 
    .attribute [163] .code stack 4 locals 0 
L0:     new [33] 
L3:     dup 
L4:     iconst_m1 
L5:     getstatic [10] 
L8:     invokespecial [28] 
L11:    putstatic [26] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [35] [36] 
.const [3] = Int -2137614336 
.const [4] = String [37] 
.const [5] = Class [38] 
.const [6] = String [39] 
.const [7] = String [40] 
.const [8] = Class [41] 
.const [9] = String [42] 
.const [10] = Field [43] [44] 
.const [11] = Class [45] 
.const [12] = Class [46] 
.const [13] = Class [47] 
.const [14] = Field [48] [49] 
.const [15] = Field [50] [51] 
.const [16] = Field [52] [53] 
.const [17] = Method [54] [55] 
.const [18] = Method [56] [57] 
.const [19] = Method [58] [59] 
.const [20] = Method [60] [61] 
.const [21] = Method [62] [63] 
.const [22] = Method [64] [65] 
.const [23] = Method [66] [67] 
.const [24] = Method [68] [69] 
.const [25] = Method [70] [71] 
.const [26] = Field [72] [73] 
.const [27] = Method [74] [75] 
.const [28] = Method [76] [77] 
.const [29] = Method [78] [79] 
.const [30] = Method [80] [81] 
.const [31] = Method [82] [83] 
.const [32] = Field [84] [85] 
.const [33] = Class [86] 
.const [34] = Class [87] 
.const [35] = Class [88] 
.const [36] = NameAndType [89] [90] 
.const [37] = Utf8 '(%3) [ResourceLocatorModel.setResourceLocator] id:%2 uri:%1' 
.const [38] = Utf8 de/audi/atip/hmi/model/HMIResourceLocator 
.const [39] = Utf8 '(%2) [ResourceLocatorModel.setResourceLocator] status:%1' 
.const [40] = Utf8 '(%2) [ResourceLocatorModel.setResourceLocator] loc:%1' 
.const [41] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [42] = Utf8 '\nresource: ' 
.const [43] = Class [91] 
.const [44] = NameAndType [92] [93] 
.const [45] = Utf8 de/audi/atip/hmi/model/ResourceLocatorModel 
.const [46] = Utf8 de/audi/atip/hmi/model/AbstractModel 
.const [47] = Utf8 de/audi/atip/log/LogChannel 
.const [48] = Class [94] 
.const [49] = NameAndType [95] [96] 
.const [50] = Class [97] 
.const [51] = NameAndType [98] [99] 
.const [52] = Class [100] 
.const [53] = NameAndType [101] [102] 
.const [54] = Class [103] 
.const [55] = NameAndType [104] [105] 
.const [56] = Class [106] 
.const [57] = NameAndType [107] [108] 
.const [58] = Class [109] 
.const [59] = NameAndType [110] [111] 
.const [60] = Class [112] 
.const [61] = NameAndType [113] [114] 
.const [62] = Class [115] 
.const [63] = NameAndType [116] [117] 
.const [64] = Class [118] 
.const [65] = NameAndType [119] [120] 
.const [66] = Class [121] 
.const [67] = NameAndType [122] [123] 
.const [68] = Class [124] 
.const [69] = NameAndType [125] [126] 
.const [70] = Class [127] 
.const [71] = NameAndType [128] [129] 
.const [72] = Class [130] 
.const [73] = NameAndType [131] [132] 
.const [74] = Class [133] 
.const [75] = NameAndType [134] [135] 
.const [76] = Class [136] 
.const [77] = NameAndType [137] [138] 
.const [78] = Class [139] 
.const [79] = NameAndType [140] [141] 
.const [80] = Class [142] 
.const [81] = NameAndType [143] [144] 
.const [82] = Class [145] 
.const [83] = NameAndType [146] [147] 
.const [84] = Class [148] 
.const [85] = NameAndType [149] [150] 
.const [86] = Utf8 de/audi/atip/hmi/model/HMIResourceLocator 
.const [87] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [88] = Utf8 de/audi/atip/hmi/model/ResourceLocatorModel 
.const [89] = Utf8 NULL_RESOURCE_LOCATOR 
.const [90] = Utf8 Lde/audi/atip/hmi/model/HMIResourceLocator; 
.const [91] = Utf8 de/audi/atip/hmi/model/HMIResourceLocator 
.const [92] = Utf8 UNDEFINED_URI 
.const [93] = Utf8 Ljava/lang/String; 
.const [94] = Utf8 de/audi/atip/hmi/model/ResourceLocatorModel 
.const [95] = Utf8 resource 
.const [96] = Utf8 Lde/audi/atip/hmi/model/HMIResourceLocator; 
.const [97] = Utf8 de/audi/atip/hmi/model/ResourceLocatorModel 
.const [98] = Utf8 lc 
.const [99] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [100] = Utf8 de/audi/atip/hmi/model/AbstractModel 
.const [101] = Utf8 id 
.const [102] = Utf8 I 
.const [103] = Utf8 de/audi/atip/log/LogChannel 
.const [104] = Utf8 log 
.const [105] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [106] = Utf8 de/audi/atip/hmi/model/ResourceLocatorModel 
.const [107] = Utf8 fireModelUpdateEvent 
.const [108] = Utf8 (I)V 
.const [109] = Utf8 de/audi/atip/log/LogChannel 
.const [110] = Utf8 log 
.const [111] = Utf8 (ILjava/lang/String;JJ)Z 
.const [112] = Utf8 de/audi/atip/hmi/model/HMIResourceLocator 
.const [113] = Utf8 setStatus 
.const [114] = Utf8 (I)V 
.const [115] = Utf8 de/audi/atip/log/LogChannel 
.const [116] = Utf8 log 
.const [117] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [118] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [119] = Utf8 append 
.const [120] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [121] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [122] = Utf8 append 
.const [123] = Utf8 (Ljava/lang/Object;)Lde/esolutions/fw/util/commons/Buffer; 
.const [124] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [125] = Utf8 toString 
.const [126] = Utf8 ()Ljava/lang/String; 
.const [127] = Utf8 de/audi/atip/hmi/model/AbstractModel 
.const [128] = Utf8 <init> 
.const [129] = Utf8 (II)V 
.const [130] = Utf8 de/audi/atip/hmi/model/ResourceLocatorModel 
.const [131] = Utf8 NULL_RESOURCE_LOCATOR 
.const [132] = Utf8 Lde/audi/atip/hmi/model/HMIResourceLocator; 
.const [133] = Utf8 de/audi/atip/hmi/model/ResourceLocatorModel 
.const [134] = Utf8 setResourceLocator 
.const [135] = Utf8 (ILjava/lang/String;Z)V 
.const [136] = Utf8 de/audi/atip/hmi/model/HMIResourceLocator 
.const [137] = Utf8 <init> 
.const [138] = Utf8 (ILjava/lang/String;)V 
.const [139] = Utf8 de/audi/atip/hmi/model/HMIResourceLocator 
.const [140] = Utf8 <init> 
.const [141] = Utf8 (Lde/audi/atip/hmi/model/HMIResourceLocator;)V 
.const [142] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [143] = Utf8 <init> 
.const [144] = Utf8 (I)V 
.const [145] = Utf8 de/audi/atip/hmi/model/AbstractModel 
.const [146] = Utf8 dumpContent 
.const [147] = Utf8 ()Ljava/lang/String; 
.const [148] = Utf8 de/audi/atip/hmi/model/ResourceLocatorModel 
.const [149] = Utf8 resource 
.const [150] = Utf8 Lde/audi/atip/hmi/model/HMIResourceLocator; 
.const [151] = Utf8 de/audi/atip/hmi/model/ResourceLocatorModel 
.const [152] = Class [151] 
.const [153] = Utf8 de/audi/atip/hmi/model/AbstractModel 
.const [154] = Class [153] 
.const [155] = Utf8 de/audi/atip/hmi/modelaccess/ResourceLocatorModelApp 
.const [156] = Class [155] 
.const [157] = Utf8 de/audi/atip/hmi/modelaccess/ResourceLocatorModelGUI 
.const [158] = Class [157] 
.const [159] = Utf8 NULL_RESOURCE_LOCATOR 
.const [160] = Utf8 Lde/audi/atip/hmi/model/HMIResourceLocator; 
.const [161] = Utf8 resource 
.const [162] = Utf8 Lde/audi/atip/hmi/model/HMIResourceLocator; 
.const [163] = Utf8 Code 
.const [164] = Utf8 <init> 
.const [165] = Utf8 (I)V 
.const [166] = Utf8 <init> 
.const [167] = Utf8 (II)V 
.const [168] = Utf8 isEmpty 
.const [169] = Utf8 ()Z 
.const [170] = Utf8 getModelType 
.const [171] = Utf8 ()I 
.const [172] = Utf8 getResourceLocator 
.const [173] = Utf8 ()Lde/audi/atip/hmi/model/HMIResourceLocator; 
.const [174] = Utf8 setResourceLocator 
.const [175] = Utf8 (ILjava/lang/String;)V 
.const [176] = Utf8 setResourceLocatorWithoutEvent 
.const [177] = Utf8 (ILjava/lang/String;)V 
.const [178] = Utf8 setResourceLocator 
.const [179] = Utf8 (ILjava/lang/String;Z)V 
.const [180] = Utf8 setResourceLocator 
.const [181] = Utf8 (ILjava/lang/String;I)V 
.const [182] = Utf8 setResourceLocator 
.const [183] = Utf8 (Lde/audi/atip/hmi/model/HMIResourceLocator;)V 
.const [184] = Utf8 dumpContent 
.const [185] = Utf8 ()Ljava/lang/String; 
.const [186] = Utf8 resetListener 
.const [187] = Utf8 ()V 
.const [188] = Utf8 <clinit> 
.const [189] = Utf8 ()V 
.end class 
