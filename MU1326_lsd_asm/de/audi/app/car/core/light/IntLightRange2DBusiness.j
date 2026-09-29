.version 50 0 
.class public super [128] 
.super [130] 
.field private [131] [132] 
.field protected [133] [134] 

.method public [136] : [137] 
    .attribute [135] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_2 
L2:     aload_3 
L3:     invokespecial [24] 
L6:     aload_0 
L7:     aload_1 
L8:     putfield [25] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [138] : [139] 
    .attribute [135] .code stack 9 locals 1 
L0:     aload_0 
L1:     invokevirtual [15] 
L4:     invokevirtual [16] 
L7:     ifeq L22 
L10:    aload_0 
L11:    invokevirtual [15] 
L14:    ldc [2] 
L16:    ldc [3] 
L18:    invokevirtual [17] 
L21:    pop 
L22:    aload_2 
L23:    checkcast [4] 
L26:    astore_3 
L27:    aload_0 
L28:    invokevirtual [15] 
L31:    ldc [2] 
L33:    ldc [5] 
L35:    aload_3 
L36:    invokeinterface [26] 0 
L41:    invokeinterface [27] 0 
L46:    i2l 
L47:    aload_0 
L48:    getfield [14] 
L51:    invokevirtual [18] 
L54:    i2l 
L55:    aload_0 
L56:    getfield [19] 
L59:    aload_0 
L60:    getfield [14] 
L63:    invokevirtual [18] 
L66:    iaload 
L67:    i2l 
L68:    invokevirtual [20] 
L71:    pop 
L72:    aload_3 
L73:    invokeinterface [26] 0 
L78:    invokeinterface [27] 0 
L83:    aload_0 
L84:    getfield [14] 
L87:    invokevirtual [18] 
L90:    if_icmpeq L132 
L93:    aload_0 
L94:    invokevirtual [15] 
L97:    ldc [2] 
L99:    ldc [6] 
L101:   aload_0 
L102:   getfield [14] 
L105:   invokevirtual [18] 
L108:   i2l 
L109:   invokevirtual [21] 
L112:   pop 
L113:   aload_0 
L114:   invokevirtual [22] 
L117:   aload_0 
L118:   getfield [14] 
L121:   invokevirtual [18] 
L124:   invokeinterface [29] 0 
L129:   goto L138 
L132:   aload_2 
L133:   invokeinterface [30] 0 
L138:   iconst_1 
L139:   areturn 
L140:   
    .end code 
.end method 

.method protected [140] : [141] 
    .attribute [135] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [23] 
L4:     checkcast [7] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [142] : [143] 
    .attribute [135] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [28] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [31] 
.const [4] = Class [32] 
.const [5] = String [33] 
.const [6] = String [34] 
.const [7] = Class [35] 
.const [8] = Class [36] 
.const [9] = Class [37] 
.const [10] = Class [38] 
.const [11] = Class [39] 
.const [12] = Class [40] 
.const [13] = Class [41] 
.const [14] = Field [42] [43] 
.const [15] = Method [44] [45] 
.const [16] = Method [46] [47] 
.const [17] = Method [48] [49] 
.const [18] = Method [50] [51] 
.const [19] = Field [52] [53] 
.const [20] = Method [54] [55] 
.const [21] = Method [56] [57] 
.const [22] = Method [58] [59] 
.const [23] = Method [60] [61] 
.const [24] = Method [62] [63] 
.const [25] = Field [64] [65] 
.const [26] = InterfaceMethod [66] [67] 
.const [27] = InterfaceMethod [68] [69] 
.const [28] = Field [70] [71] 
.const [29] = InterfaceMethod [72] [73] 
.const [30] = InterfaceMethod [74] [75] 
.const [31] = Utf8 '[IntLightRange2DBusiness#processKeyTyped] Key has been typed' 
.const [32] = Utf8 de/audi/app/car/common/handler/Range2DModelHandler 
.const [33] = Utf8 '[IntLightRange2DBusiness#processKeyTyped] last profile: %1 current focus on %2 -> mappedProfile %3' 
.const [34] = Utf8 'dsi.setIntLightActiveProfile %1' 
.const [35] = Utf8 org/dsi/ifc/carlight/DSICarLight 
.const [36] = Utf8 de/audi/app/car/core/light/IntLightRange2DBusiness 
.const [37] = Utf8 de/audi/app/car/common/handler/business/Range2DModelEventBusinessAdapter 
.const [38] = Utf8 de/audi/atip/log/LogChannel 
.const [39] = Utf8 de/audi/atip/hmi/modelaccess/RangeModel2DApp 
.const [40] = Utf8 de/audi/app/car/core/light/IntLightCurrentFocus 
.const [41] = Utf8 de/audi/app/car/common/handler/ButtonModelHandler 
.const [42] = Class [76] 
.const [43] = NameAndType [77] [78] 
.const [44] = Class [79] 
.const [45] = NameAndType [80] [81] 
.const [46] = Class [82] 
.const [47] = NameAndType [83] [84] 
.const [48] = Class [85] 
.const [49] = NameAndType [86] [87] 
.const [50] = Class [88] 
.const [51] = NameAndType [89] [90] 
.const [52] = Class [91] 
.const [53] = NameAndType [92] [93] 
.const [54] = Class [94] 
.const [55] = NameAndType [95] [96] 
.const [56] = Class [97] 
.const [57] = NameAndType [98] [99] 
.const [58] = Class [100] 
.const [59] = NameAndType [101] [102] 
.const [60] = Class [103] 
.const [61] = NameAndType [104] [105] 
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
.const [76] = Utf8 de/audi/app/car/core/light/IntLightRange2DBusiness 
.const [77] = Utf8 focus 
.const [78] = Utf8 Lde/audi/app/car/core/light/IntLightCurrentFocus; 
.const [79] = Utf8 de/audi/app/car/core/light/IntLightRange2DBusiness 
.const [80] = Utf8 getLogChannel 
.const [81] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [82] = Utf8 de/audi/atip/log/LogChannel 
.const [83] = Utf8 isInfo 
.const [84] = Utf8 ()Z 
.const [85] = Utf8 de/audi/atip/log/LogChannel 
.const [86] = Utf8 log 
.const [87] = Utf8 (ILjava/lang/String;)Z 
.const [88] = Utf8 de/audi/app/car/core/light/IntLightCurrentFocus 
.const [89] = Utf8 getFocus 
.const [90] = Utf8 ()I 
.const [91] = Utf8 de/audi/app/car/core/light/IntLightRange2DBusiness 
.const [92] = Utf8 profileMapping 
.const [93] = Utf8 [I 
.const [94] = Utf8 de/audi/atip/log/LogChannel 
.const [95] = Utf8 log 
.const [96] = Utf8 (ILjava/lang/String;JJJ)Z 
.const [97] = Utf8 de/audi/atip/log/LogChannel 
.const [98] = Utf8 log 
.const [99] = Utf8 (ILjava/lang/String;J)Z 
.const [100] = Utf8 de/audi/app/car/core/light/IntLightRange2DBusiness 
.const [101] = Utf8 getDSICarLight 
.const [102] = Utf8 ()Lorg/dsi/ifc/carlight/DSICarLight; 
.const [103] = Utf8 de/audi/app/car/core/light/IntLightRange2DBusiness 
.const [104] = Utf8 getDSI 
.const [105] = Utf8 ()Lorg/dsi/ifc/base/DSIBase; 
.const [106] = Utf8 de/audi/app/car/common/handler/business/Range2DModelEventBusinessAdapter 
.const [107] = Utf8 <init> 
.const [108] = Utf8 (Lorg/dsi/ifc/base/DSIBase;Lde/audi/atip/log/LogChannel;)V 
.const [109] = Utf8 de/audi/app/car/core/light/IntLightRange2DBusiness 
.const [110] = Utf8 focus 
.const [111] = Utf8 Lde/audi/app/car/core/light/IntLightCurrentFocus; 
.const [112] = Utf8 de/audi/app/car/common/handler/Range2DModelHandler 
.const [113] = Utf8 getRange2DModel 
.const [114] = Utf8 ()Lde/audi/atip/hmi/modelaccess/RangeModel2DApp; 
.const [115] = Utf8 de/audi/atip/hmi/modelaccess/RangeModel2DApp 
.const [116] = Utf8 getValueX 
.const [117] = Utf8 ()I 
.const [118] = Utf8 de/audi/app/car/core/light/IntLightRange2DBusiness 
.const [119] = Utf8 profileMapping 
.const [120] = Utf8 [I 
.const [121] = Utf8 org/dsi/ifc/carlight/DSICarLight 
.const [122] = Utf8 setIntLightActiveProfile 
.const [123] = Utf8 (I)V 
.const [124] = Utf8 de/audi/app/car/common/handler/ButtonModelHandler 
.const [125] = Utf8 fireEvent 
.const [126] = Utf8 ()V 
.const [127] = Utf8 de/audi/app/car/core/light/IntLightRange2DBusiness 
.const [128] = Class [127] 
.const [129] = Utf8 de/audi/app/car/common/handler/business/Range2DModelEventBusinessAdapter 
.const [130] = Class [129] 
.const [131] = Utf8 focus 
.const [132] = Utf8 Lde/audi/app/car/core/light/IntLightCurrentFocus; 
.const [133] = Utf8 profileMapping 
.const [134] = Utf8 [I 
.const [135] = Utf8 Code 
.const [136] = Utf8 <init> 
.const [137] = Utf8 (Lde/audi/app/car/core/light/IntLightCurrentFocus;Lorg/dsi/ifc/carlight/DSICarLight;Lde/audi/atip/log/LogChannel;)V 
.const [138] = Utf8 processKeyTyped 
.const [139] = Utf8 (ILde/audi/app/car/common/handler/ButtonModelHandler;)Z 
.const [140] = Utf8 getDSICarLight 
.const [141] = Utf8 ()Lorg/dsi/ifc/carlight/DSICarLight; 
.const [142] = Utf8 setProfileMapping 
.const [143] = Utf8 ([I)V 
.end class 
