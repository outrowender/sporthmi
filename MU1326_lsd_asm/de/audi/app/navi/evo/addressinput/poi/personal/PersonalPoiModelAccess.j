.version 50 0 
.class public super [65] 
.super [67] 
.implements [69] 
.field private final [70] [71] 
.field private static final [72] [73] 
.field private static final [74] [75] 

.method public [77] : [78] 
    .attribute [76] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [14] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [15] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [79] : [80] 
    .attribute [76] .code stack 5 locals 1 
L0:     iload_1 
L1:     ifeq L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    getfield [10] 
L14:    invokevirtual [11] 
L17:    ldc [2] 
L19:    ldc [3] 
L21:    iload_2 
L22:    i2l 
L23:    invokevirtual [12] 
L26:    pop 
L27:    aload_0 
L28:    getfield [10] 
L31:    ldc [4] 
L33:    invokevirtual [13] 
L36:    iload_2 
L37:    invokeinterface [16] 0 
L42:    return 
L43:    nop 
L44:    
    .end code 
.end method 

.method public enum [81] : [82] 
    .attribute [76] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [83] : [84] 
    .attribute [76] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     ldc [4] 
L6:     invokevirtual [13] 
L9:     invokeinterface [17] 0 
L14:    iconst_1 
L15:    if_icmpne L22 
L18:    iconst_1 
L19:    goto L23 
L22:    iconst_0 
L23:    areturn 
L24:    
    .end code 
.end method 

.method public [85] : [86] 
    .attribute [76] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     ldc [4] 
L6:     invokevirtual [13] 
L9:     iconst_0 
L10:    invokeinterface [16] 0 
L15:    return 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [18] 
.const [4] = Int 1696531968 
.const [5] = Class [19] 
.const [6] = Class [20] 
.const [7] = Class [21] 
.const [8] = Class [22] 
.const [9] = Class [23] 
.const [10] = Field [24] [25] 
.const [11] = Method [26] [27] 
.const [12] = Method [28] [29] 
.const [13] = Method [30] [31] 
.const [14] = Method [32] [33] 
.const [15] = Field [34] [35] 
.const [16] = InterfaceMethod [36] [37] 
.const [17] = InterfaceMethod [38] [39] 
.const [18] = Utf8 'PersonalPOIModelAccess#setChoicePPOIDataBaseAvailable( %1 )' 
.const [19] = Utf8 de/audi/app/navi/evo/addressinput/poi/personal/PersonalPoiModelAccess 
.const [20] = Utf8 java/lang/Object 
.const [21] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [22] = Utf8 de/audi/atip/log/LogChannel 
.const [23] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [24] = Class [40] 
.const [25] = NameAndType [41] [42] 
.const [26] = Class [43] 
.const [27] = NameAndType [44] [45] 
.const [28] = Class [46] 
.const [29] = NameAndType [47] [48] 
.const [30] = Class [49] 
.const [31] = NameAndType [50] [51] 
.const [32] = Class [52] 
.const [33] = NameAndType [53] [54] 
.const [34] = Class [55] 
.const [35] = NameAndType [56] [57] 
.const [36] = Class [58] 
.const [37] = NameAndType [59] [60] 
.const [38] = Class [61] 
.const [39] = NameAndType [62] [63] 
.const [40] = Utf8 de/audi/app/navi/evo/addressinput/poi/personal/PersonalPoiModelAccess 
.const [41] = Utf8 env 
.const [42] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [43] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [44] = Utf8 getLogChannel 
.const [45] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [46] = Utf8 de/audi/atip/log/LogChannel 
.const [47] = Utf8 log 
.const [48] = Utf8 (ILjava/lang/String;J)Z 
.const [49] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [50] = Utf8 getChoiceModel 
.const [51] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [52] = Utf8 java/lang/Object 
.const [53] = Utf8 <init> 
.const [54] = Utf8 ()V 
.const [55] = Utf8 de/audi/app/navi/evo/addressinput/poi/personal/PersonalPoiModelAccess 
.const [56] = Utf8 env 
.const [57] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [58] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [59] = Utf8 setValue 
.const [60] = Utf8 (I)V 
.const [61] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [62] = Utf8 getValue 
.const [63] = Utf8 ()I 
.const [64] = Utf8 de/audi/app/navi/evo/addressinput/poi/personal/PersonalPoiModelAccess 
.const [65] = Class [64] 
.const [66] = Utf8 java/lang/Object 
.const [67] = Class [66] 
.const [68] = Utf8 de/audi/tghu/navi/app/addressinput/poi/personal/IPersonalPoiModelAccess 
.const [69] = Class [68] 
.const [70] = Utf8 env 
.const [71] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [72] = Utf8 CHOICE_ENABLED 
.const [73] = Utf8 I 
.const [74] = Utf8 CHOICE_DISABLED 
.const [75] = Utf8 I 
.const [76] = Utf8 Code 
.const [77] = Utf8 <init> 
.const [78] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;)V 
.const [79] = Utf8 onUpdateDataBaseAvailable 
.const [80] = Utf8 (Z)V 
.const [81] = Utf8 onUpdateSearchStatus 
.const [82] = Utf8 (I)V 
.const [83] = Utf8 isPpoiavailable 
.const [84] = Utf8 ()Z 
.const [85] = Utf8 onDatabaseDeleted 
.const [86] = Utf8 ([Ljava/lang/String;)V 
.end class 
