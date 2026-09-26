.version 50 0 
.class public super [126] 
.super [128] 
.field private final [129] [130] 
.field private final [131] [132] 

.method public [134] : [135] 
    .attribute [133] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [24] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [26] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [27] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [136] : [137] 
    .attribute [133] .code stack 7 locals 1 
L0:     aload_0 
L1:     getfield [16] 
L4:     ifnonnull L19 
L7:     aload_0 
L8:     invokevirtual [18] 
L11:    ldc [2] 
L13:    invokeinterface [28] 0 
L18:    return 
L19:    aload_0 
L20:    getfield [17] 
L23:    ifnonnull L38 
L26:    aload_0 
L27:    invokevirtual [18] 
L30:    ldc [3] 
L32:    invokeinterface [28] 0 
L37:    return 
L38:    aload_0 
L39:    getfield [19] 
L42:    invokevirtual [20] 
L45:    ldc [4] 
L47:    ldc [5] 
L49:    aload_0 
L50:    getfield [17] 
L53:    invokevirtual [21] 
L56:    i2l 
L57:    aload_0 
L58:    getfield [17] 
L61:    invokevirtual [22] 
L64:    i2l 
L65:    invokevirtual [23] 
L68:    pop 
L69:    new [29] 
L72:    dup 
L73:    aload_0 
L74:    getfield [17] 
L77:    invokevirtual [21] 
L80:    aload_0 
L81:    getfield [17] 
L84:    invokevirtual [22] 
L87:    invokespecial [25] 
L90:    astore_1 
L91:    aload_0 
L92:    getfield [16] 
L95:    aload_1 
L96:    invokestatic [7] 
L99:    iconst_1 
L100:   aconst_null 
L101:   aconst_null 
L102:   invokeinterface [30] 0 
L107:   aload_0 
L108:   invokevirtual [18] 
L111:   invokeinterface [31] 0 
L116:   return 
L117:   nop 
L118:   nop 
L119:   nop 
L120:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [32] 
.const [3] = String [33] 
.const [4] = Int -2137614336 
.const [5] = String [34] 
.const [6] = Class [35] 
.const [7] = Method [36] [37] 
.const [8] = Class [38] 
.const [9] = Class [39] 
.const [10] = Class [40] 
.const [11] = Class [41] 
.const [12] = Class [42] 
.const [13] = Class [43] 
.const [14] = Class [44] 
.const [15] = Class [45] 
.const [16] = Field [46] [47] 
.const [17] = Field [48] [49] 
.const [18] = Method [50] [51] 
.const [19] = Field [52] [53] 
.const [20] = Method [54] [55] 
.const [21] = Method [56] [57] 
.const [22] = Method [58] [59] 
.const [23] = Method [60] [61] 
.const [24] = Method [62] [63] 
.const [25] = Method [64] [65] 
.const [26] = Field [66] [67] 
.const [27] = Field [68] [69] 
.const [28] = InterfaceMethod [70] [71] 
.const [29] = Class [72] 
.const [30] = InterfaceMethod [73] [74] 
.const [31] = InterfaceMethod [75] [76] 
.const [32] = Utf8 'SetCityLocationForPreviewMapCommand#execute - previewMap is null' 
.const [33] = Utf8 'SetCityLocationForPreviewMapCommand#execute - LIValueListElement is null' 
.const [34] = Utf8 'SetCityLocationForPreviewMapCommand#execute - element.longitude=%1, element.latitude=%2' 
.const [35] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [36] = Class [77] 
.const [37] = NameAndType [78] [79] 
.const [38] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/SetCityAsLocationForPreviewMapCommand 
.const [39] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [40] = Utf8 de/audi/tghu/command/ICommandList 
.const [41] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [42] = Utf8 org/dsi/ifc/navigation/LIValueListElement 
.const [43] = Utf8 de/audi/atip/log/LogChannel 
.const [44] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [45] = Utf8 de/audi/atip/interapp/navigation/previewmap/IPreviewMap 
.const [46] = Class [80] 
.const [47] = NameAndType [81] [82] 
.const [48] = Class [83] 
.const [49] = NameAndType [84] [85] 
.const [50] = Class [86] 
.const [51] = NameAndType [87] [88] 
.const [52] = Class [89] 
.const [53] = NameAndType [90] [91] 
.const [54] = Class [92] 
.const [55] = NameAndType [93] [94] 
.const [56] = Class [95] 
.const [57] = NameAndType [96] [97] 
.const [58] = Class [98] 
.const [59] = NameAndType [99] [100] 
.const [60] = Class [101] 
.const [61] = NameAndType [102] [103] 
.const [62] = Class [104] 
.const [63] = NameAndType [105] [106] 
.const [64] = Class [107] 
.const [65] = NameAndType [108] [109] 
.const [66] = Class [110] 
.const [67] = NameAndType [111] [112] 
.const [68] = Class [113] 
.const [69] = NameAndType [114] [115] 
.const [70] = Class [116] 
.const [71] = NameAndType [117] [118] 
.const [72] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [73] = Class [119] 
.const [74] = NameAndType [120] [121] 
.const [75] = Class [122] 
.const [76] = NameAndType [123] [124] 
.const [77] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [78] = Utf8 wgs84ToNavLocation 
.const [79] = Utf8 (Lorg/dsi/ifc/global/NavLocationWgs84;)Lorg/dsi/ifc/global/NavLocation; 
.const [80] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/SetCityAsLocationForPreviewMapCommand 
.const [81] = Utf8 previewMap 
.const [82] = Utf8 Lde/audi/atip/interapp/navigation/previewmap/IPreviewMap; 
.const [83] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/SetCityAsLocationForPreviewMapCommand 
.const [84] = Utf8 element 
.const [85] = Utf8 Lorg/dsi/ifc/navigation/LIValueListElement; 
.const [86] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/SetCityAsLocationForPreviewMapCommand 
.const [87] = Utf8 getCommandList 
.const [88] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [89] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/SetCityAsLocationForPreviewMapCommand 
.const [90] = Utf8 env 
.const [91] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [92] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [93] = Utf8 getCommandLogChannel 
.const [94] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [95] = Utf8 org/dsi/ifc/navigation/LIValueListElement 
.const [96] = Utf8 getLongitude 
.const [97] = Utf8 ()I 
.const [98] = Utf8 org/dsi/ifc/navigation/LIValueListElement 
.const [99] = Utf8 getLatitude 
.const [100] = Utf8 ()I 
.const [101] = Utf8 de/audi/atip/log/LogChannel 
.const [102] = Utf8 log 
.const [103] = Utf8 (ILjava/lang/String;JJ)Z 
.const [104] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [105] = Utf8 <init> 
.const [106] = Utf8 ()V 
.const [107] = Utf8 org/dsi/ifc/global/NavLocationWgs84 
.const [108] = Utf8 <init> 
.const [109] = Utf8 (II)V 
.const [110] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/SetCityAsLocationForPreviewMapCommand 
.const [111] = Utf8 previewMap 
.const [112] = Utf8 Lde/audi/atip/interapp/navigation/previewmap/IPreviewMap; 
.const [113] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/SetCityAsLocationForPreviewMapCommand 
.const [114] = Utf8 element 
.const [115] = Utf8 Lorg/dsi/ifc/navigation/LIValueListElement; 
.const [116] = Utf8 de/audi/tghu/command/ICommandList 
.const [117] = Utf8 commandAborted 
.const [118] = Utf8 (Ljava/lang/String;)V 
.const [119] = Utf8 de/audi/atip/interapp/navigation/previewmap/IPreviewMap 
.const [120] = Utf8 setPreviewLocationCity 
.const [121] = Utf8 (Lorg/dsi/ifc/global/NavLocation;ILde/audi/atip/interapp/navigation/previewmap/gui/GuiModelAccessForPreviewMapDetailScreen;Lde/audi/atip/interapp/navigation/previewmap/gui/GuiTooltipInformationContainer;)V 
.const [122] = Utf8 de/audi/tghu/command/ICommandList 
.const [123] = Utf8 commandFinished 
.const [124] = Utf8 ()V 
.const [125] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/SetCityAsLocationForPreviewMapCommand 
.const [126] = Class [125] 
.const [127] = Utf8 de/audi/tghu/navi/app/command/NavCommand 
.const [128] = Class [127] 
.const [129] = Utf8 previewMap 
.const [130] = Utf8 Lde/audi/atip/interapp/navigation/previewmap/IPreviewMap; 
.const [131] = Utf8 element 
.const [132] = Utf8 Lorg/dsi/ifc/navigation/LIValueListElement; 
.const [133] = Utf8 Code 
.const [134] = Utf8 <init> 
.const [135] = Utf8 (Lde/audi/atip/interapp/navigation/previewmap/IPreviewMap;Lorg/dsi/ifc/navigation/LIValueListElement;)V 
.const [136] = Utf8 execute 
.const [137] = Utf8 ()V 
.end class 
