.version 50 0 
.class public final super [98] 
.super [100] 
.field private [101] [102] 
.field private final [103] [104] 
.field private [105] [106] 

.method public [108] : [109] 
    .attribute [107] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [18] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [19] 
L9:     aload_0 
L10:    aload_1 
L11:    invokevirtual [12] 
L14:    putfield [20] 
L17:    aload_0 
L18:    aload_1 
L19:    putfield [21] 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [110] : [111] 
    .attribute [107] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     aload_1 
L9:     invokevirtual [15] 
L12:    pop 
L13:    aload_0 
L14:    aload_1 
L15:    putfield [19] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [112] : [113] 
    .attribute [107] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     sipush 186 
L7:     invokevirtual [16] 
L10:    invokeinterface [22] 0 
L15:    iconst_1 
L16:    if_icmpne L23 
L19:    iconst_1 
L20:    goto L24 
L23:    iconst_0 
L24:    areturn 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [114] : [115] 
    .attribute [107] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     ifnonnull L21 
L7:     aload_0 
L8:     getfield [13] 
L11:    sipush 10000 
L14:    ldc [4] 
L16:    invokevirtual [17] 
L19:    pop 
L20:    return 
L21:    aload_0 
L22:    getfield [11] 
L25:    aload_1 
L26:    aload_2 
L27:    iconst_1 
L28:    invokeinterface [23] 0 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [24] 
.const [4] = String [25] 
.const [5] = Class [26] 
.const [6] = Class [27] 
.const [7] = Class [28] 
.const [8] = Class [29] 
.const [9] = Class [30] 
.const [10] = Class [31] 
.const [11] = Field [32] [33] 
.const [12] = Method [34] [35] 
.const [13] = Field [36] [37] 
.const [14] = Field [38] [39] 
.const [15] = Method [40] [41] 
.const [16] = Method [42] [43] 
.const [17] = Method [44] [45] 
.const [18] = Method [46] [47] 
.const [19] = Field [48] [49] 
.const [20] = Field [50] [51] 
.const [21] = Field [52] [53] 
.const [22] = InterfaceMethod [54] [55] 
.const [23] = InterfaceMethod [56] [57] 
.const [24] = Utf8 'PhoneGateway#setPhoneService(): phone: %1 ' 
.const [25] = Utf8 'PhoneGateway#dialNumber(): phone service not available! ' 
.const [26] = Utf8 de/audi/tghu/navi/app/PhoneGateway 
.const [27] = Utf8 java/lang/Object 
.const [28] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [29] = Utf8 de/audi/atip/log/LogChannel 
.const [30] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [31] = Utf8 de/audi/atip/interapp/PhoneService 
.const [32] = Class [58] 
.const [33] = NameAndType [59] [60] 
.const [34] = Class [61] 
.const [35] = NameAndType [62] [63] 
.const [36] = Class [64] 
.const [37] = NameAndType [65] [66] 
.const [38] = Class [67] 
.const [39] = NameAndType [68] [69] 
.const [40] = Class [70] 
.const [41] = NameAndType [71] [72] 
.const [42] = Class [73] 
.const [43] = NameAndType [74] [75] 
.const [44] = Class [76] 
.const [45] = NameAndType [77] [78] 
.const [46] = Class [79] 
.const [47] = NameAndType [80] [81] 
.const [48] = Class [82] 
.const [49] = NameAndType [83] [84] 
.const [50] = Class [85] 
.const [51] = NameAndType [86] [87] 
.const [52] = Class [88] 
.const [53] = NameAndType [89] [90] 
.const [54] = Class [91] 
.const [55] = NameAndType [92] [93] 
.const [56] = Class [94] 
.const [57] = NameAndType [95] [96] 
.const [58] = Utf8 de/audi/tghu/navi/app/PhoneGateway 
.const [59] = Utf8 phone 
.const [60] = Utf8 Lde/audi/atip/interapp/PhoneService; 
.const [61] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [62] = Utf8 getLogChannel 
.const [63] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [64] = Utf8 de/audi/tghu/navi/app/PhoneGateway 
.const [65] = Utf8 logChannel 
.const [66] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [67] = Utf8 de/audi/tghu/navi/app/PhoneGateway 
.const [68] = Utf8 env 
.const [69] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [70] = Utf8 de/audi/atip/log/LogChannel 
.const [71] = Utf8 log 
.const [72] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [73] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [74] = Utf8 getChoiceModel 
.const [75] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [76] = Utf8 de/audi/atip/log/LogChannel 
.const [77] = Utf8 log 
.const [78] = Utf8 (ILjava/lang/String;)Z 
.const [79] = Utf8 java/lang/Object 
.const [80] = Utf8 <init> 
.const [81] = Utf8 ()V 
.const [82] = Utf8 de/audi/tghu/navi/app/PhoneGateway 
.const [83] = Utf8 phone 
.const [84] = Utf8 Lde/audi/atip/interapp/PhoneService; 
.const [85] = Utf8 de/audi/tghu/navi/app/PhoneGateway 
.const [86] = Utf8 logChannel 
.const [87] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [88] = Utf8 de/audi/tghu/navi/app/PhoneGateway 
.const [89] = Utf8 env 
.const [90] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [91] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [92] = Utf8 getValue 
.const [93] = Utf8 ()I 
.const [94] = Utf8 de/audi/atip/interapp/PhoneService 
.const [95] = Utf8 dialNumber 
.const [96] = Utf8 (Ljava/lang/String;Ljava/lang/String;Z)V 
.const [97] = Utf8 de/audi/tghu/navi/app/PhoneGateway 
.const [98] = Class [97] 
.const [99] = Utf8 java/lang/Object 
.const [100] = Class [99] 
.const [101] = Utf8 phone 
.const [102] = Utf8 Lde/audi/atip/interapp/PhoneService; 
.const [103] = Utf8 logChannel 
.const [104] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [105] = Utf8 env 
.const [106] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [107] = Utf8 Code 
.const [108] = Utf8 <init> 
.const [109] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;)V 
.const [110] = Utf8 setPhoneService 
.const [111] = Utf8 (Lde/audi/atip/interapp/PhoneService;)V 
.const [112] = Utf8 phoneReady 
.const [113] = Utf8 ()Z 
.const [114] = Utf8 dialNumber 
.const [115] = Utf8 (Ljava/lang/String;Ljava/lang/String;Z)V 
.end class 
