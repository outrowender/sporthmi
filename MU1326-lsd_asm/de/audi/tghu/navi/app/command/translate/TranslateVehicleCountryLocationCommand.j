.version 50 0 
.class public super [107] 
.super [109] 

.method public [111] : [112] 
    .attribute [110] .code stack 2 locals 0 
L0:     aload_0 
L1:     aconst_null 
L2:     invokespecial [22] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [113] : [114] 
    .attribute [110] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [15] 
L4:     invokevirtual [16] 
L7:     invokeinterface [24] 0 
L12:    astore_1 
L13:    aload_1 
L14:    ifnonnull L41 
L17:    aload_0 
L18:    getfield [17] 
L21:    ldc [2] 
L23:    ldc [3] 
L25:    invokevirtual [18] 
L28:    pop 
L29:    aload_0 
L30:    invokevirtual [19] 
L33:    invokeinterface [25] 0 
L38:    goto L53 
L41:    aload_0 
L42:    aload_1 
L43:    invokestatic [4] 
L46:    invokevirtual [20] 
L49:    aload_0 
L50:    invokespecial [23] 
L53:    return 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [115] : [116] 
    .attribute [110] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     ldc [5] 
L6:     ldc [6] 
L8:     aload_1 
L9:     invokestatic [7] 
L12:    invokevirtual [21] 
L15:    pop 
L16:    aload_0 
L17:    getfield [15] 
L20:    invokevirtual [16] 
L23:    aload_1 
L24:    invokeinterface [26] 0 
L29:    aconst_null 
L30:    areturn 
L31:    nop 
L32:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [27] 
.const [4] = Method [28] [29] 
.const [5] = Int -2137614336 
.const [6] = String [30] 
.const [7] = Method [31] [32] 
.const [8] = Class [33] 
.const [9] = Class [34] 
.const [10] = Class [35] 
.const [11] = Class [36] 
.const [12] = Class [37] 
.const [13] = Class [38] 
.const [14] = Class [39] 
.const [15] = Field [40] [41] 
.const [16] = Method [42] [43] 
.const [17] = Field [44] [45] 
.const [18] = Method [46] [47] 
.const [19] = Method [48] [49] 
.const [20] = Method [50] [51] 
.const [21] = Method [52] [53] 
.const [22] = Method [54] [55] 
.const [23] = Method [56] [57] 
.const [24] = InterfaceMethod [58] [59] 
.const [25] = InterfaceMethod [60] [61] 
.const [26] = InterfaceMethod [62] [63] 
.const [27] = Utf8 'TranslateVehicleCountryLocationCommand#execute() - vehicle country location not set, translation not needed' 
.const [28] = Class [64] 
.const [29] = NameAndType [65] [66] 
.const [30] = Utf8 'TranslateVehicleCountryLocationCommand#handleTranslatedLocation( %1 )' 
.const [31] = Class [67] 
.const [32] = NameAndType [68] [69] 
.const [33] = Utf8 de/audi/tghu/navi/app/command/translate/TranslateVehicleCountryLocationCommand 
.const [34] = Utf8 de/audi/tghu/navi/app/command/translate/TranslateLocationCommand 
.const [35] = Utf8 de/audi/tghu/navi/app/Navigation 
.const [36] = Utf8 de/audi/tghu/navi/app/guidance/IVehicle 
.const [37] = Utf8 de/audi/atip/log/LogChannel 
.const [38] = Utf8 de/audi/tghu/command/ICommandList 
.const [39] = Utf8 de/audi/tghu/navi/app/util/LocationFormatter 
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
.const [58] = Class [97] 
.const [59] = NameAndType [98] [99] 
.const [60] = Class [100] 
.const [61] = NameAndType [101] [102] 
.const [62] = Class [103] 
.const [63] = NameAndType [104] [105] 
.const [64] = Utf8 de/audi/tghu/navi/app/command/translate/TranslateVehicleCountryLocationCommand 
.const [65] = Utf8 constructRouteToTranslate 
.const [66] = Utf8 (Lorg/dsi/ifc/global/NavLocation;)Lorg/dsi/ifc/navigation/Route; 
.const [67] = Utf8 de/audi/tghu/navi/app/util/LocationFormatter 
.const [68] = Utf8 formatLocationShort 
.const [69] = Utf8 (Lorg/dsi/ifc/global/NavLocation;)Ljava/lang/String; 
.const [70] = Utf8 de/audi/tghu/navi/app/command/translate/TranslateVehicleCountryLocationCommand 
.const [71] = Utf8 navigation 
.const [72] = Utf8 Lde/audi/tghu/navi/app/Navigation; 
.const [73] = Utf8 de/audi/tghu/navi/app/Navigation 
.const [74] = Utf8 getVehicle 
.const [75] = Utf8 ()Lde/audi/tghu/navi/app/guidance/IVehicle; 
.const [76] = Utf8 de/audi/tghu/navi/app/command/translate/TranslateVehicleCountryLocationCommand 
.const [77] = Utf8 logger 
.const [78] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [79] = Utf8 de/audi/atip/log/LogChannel 
.const [80] = Utf8 log 
.const [81] = Utf8 (ILjava/lang/String;)Z 
.const [82] = Utf8 de/audi/tghu/navi/app/command/translate/TranslateVehicleCountryLocationCommand 
.const [83] = Utf8 getCommandList 
.const [84] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [85] = Utf8 de/audi/tghu/navi/app/command/translate/TranslateVehicleCountryLocationCommand 
.const [86] = Utf8 setRouteToTranslate 
.const [87] = Utf8 (Lorg/dsi/ifc/navigation/Route;)V 
.const [88] = Utf8 de/audi/atip/log/LogChannel 
.const [89] = Utf8 log 
.const [90] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [91] = Utf8 de/audi/tghu/navi/app/command/translate/TranslateLocationCommand 
.const [92] = Utf8 <init> 
.const [93] = Utf8 (Lorg/dsi/ifc/global/NavLocation;)V 
.const [94] = Utf8 de/audi/tghu/navi/app/command/translate/TranslateLocationCommand 
.const [95] = Utf8 execute 
.const [96] = Utf8 ()V 
.const [97] = Utf8 de/audi/tghu/navi/app/guidance/IVehicle 
.const [98] = Utf8 getVehicleCountryLocation 
.const [99] = Utf8 ()Lorg/dsi/ifc/global/NavLocation; 
.const [100] = Utf8 de/audi/tghu/command/ICommandList 
.const [101] = Utf8 commandFinished 
.const [102] = Utf8 ()V 
.const [103] = Utf8 de/audi/tghu/navi/app/guidance/IVehicle 
.const [104] = Utf8 setVehicleCountryLocation 
.const [105] = Utf8 (Lorg/dsi/ifc/global/NavLocation;)V 
.const [106] = Utf8 de/audi/tghu/navi/app/command/translate/TranslateVehicleCountryLocationCommand 
.const [107] = Class [106] 
.const [108] = Utf8 de/audi/tghu/navi/app/command/translate/TranslateLocationCommand 
.const [109] = Class [108] 
.const [110] = Utf8 Code 
.const [111] = Utf8 <init> 
.const [112] = Utf8 ()V 
.const [113] = Utf8 execute 
.const [114] = Utf8 ()V 
.const [115] = Utf8 handleTranslatedLocation 
.const [116] = Utf8 (Lorg/dsi/ifc/global/NavLocation;)Lde/audi/tghu/command/CommandList; 
.end class 
