.version 50 0 
.class public super [95] 
.super [97] 
.field private final [98] [99] 

.method public [101] : [102] 
    .attribute [100] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [19] 
L5:     aload_0 
L6:     aload_2 
L7:     putfield [20] 
L10:    aload_1 
L11:    ldc [2] 
L13:    ldc [3] 
L15:    invokevirtual [14] 
L18:    pop 
L19:    return 
L20:    
    .end code 
.end method 

.method public [103] : [104] 
    .attribute [100] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     ldc [4] 
L6:     ldc [5] 
L8:     aload_2 
L9:     aload_3 
L10:    invokevirtual [16] 
L13:    aload_3 
L14:    ifnull L34 
L17:    aload_3 
L18:    arraylength 
L19:    ifle L34 
L22:    aload_0 
L23:    getfield [13] 
L26:    aload_3 
L27:    iconst_0 
L28:    aaload 
L29:    invokeinterface [21] 0 
L34:    aload_0 
L35:    getfield [13] 
L38:    invokeinterface [22] 0 
L43:    aload_0 
L44:    invokevirtual [17] 
L47:    invokeinterface [23] 0 
L52:    return 
L53:    nop 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [105] : [106] 
    .attribute [100] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     ldc [4] 
L6:     ldc [6] 
L8:     invokevirtual [14] 
L11:    pop 
L12:    aload_0 
L13:    getfield [18] 
L16:    invokeinterface [24] 0 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [25] 
.const [4] = Int -2137614336 
.const [5] = String [26] 
.const [6] = String [27] 
.const [7] = Class [28] 
.const [8] = Class [29] 
.const [9] = Class [30] 
.const [10] = Class [31] 
.const [11] = Class [32] 
.const [12] = Class [33] 
.const [13] = Field [34] [35] 
.const [14] = Method [36] [37] 
.const [15] = Field [38] [39] 
.const [16] = Method [40] [41] 
.const [17] = Method [42] [43] 
.const [18] = Field [44] [45] 
.const [19] = Method [46] [47] 
.const [20] = Field [48] [49] 
.const [21] = InterfaceMethod [50] [51] 
.const [22] = InterfaceMethod [52] [53] 
.const [23] = InterfaceMethod [54] [55] 
.const [24] = InterfaceMethod [56] [57] 
.const [25] = Utf8 'SpellingSuggestionCommand#SpellingSuggestionCommand()' 
.const [26] = Utf8 'SpellingSuggestionCommand#poiSpellingSuggestion( %1, %2 )' 
.const [27] = Utf8 'SpellingSuggestionCommand#execute' 
.const [28] = Utf8 de/audi/tghu/navi/app/command/poi/online/SpellingSuggestionCommand 
.const [29] = Utf8 de/audi/tghu/navi/app/command/poi/online/AbstractOnlineSearchCommand 
.const [30] = Utf8 de/audi/atip/log/LogChannel 
.const [31] = Utf8 de/audi/tghu/navi/app/poi/online/IOnlineSearchForm 
.const [32] = Utf8 de/audi/tghu/command/ICommandList 
.const [33] = Utf8 org/dsi/ifc/online/DSIPoiOnlineSearch 
.const [34] = Class [58] 
.const [35] = NameAndType [59] [60] 
.const [36] = Class [61] 
.const [37] = NameAndType [62] [63] 
.const [38] = Class [64] 
.const [39] = NameAndType [65] [66] 
.const [40] = Class [67] 
.const [41] = NameAndType [68] [69] 
.const [42] = Class [70] 
.const [43] = NameAndType [71] [72] 
.const [44] = Class [73] 
.const [45] = NameAndType [74] [75] 
.const [46] = Class [76] 
.const [47] = NameAndType [77] [78] 
.const [48] = Class [79] 
.const [49] = NameAndType [80] [81] 
.const [50] = Class [82] 
.const [51] = NameAndType [83] [84] 
.const [52] = Class [85] 
.const [53] = NameAndType [86] [87] 
.const [54] = Class [88] 
.const [55] = NameAndType [89] [90] 
.const [56] = Class [91] 
.const [57] = NameAndType [92] [93] 
.const [58] = Utf8 de/audi/tghu/navi/app/command/poi/online/SpellingSuggestionCommand 
.const [59] = Utf8 modelAccess 
.const [60] = Utf8 Lde/audi/tghu/navi/app/poi/online/IOnlineSearchForm; 
.const [61] = Utf8 de/audi/atip/log/LogChannel 
.const [62] = Utf8 log 
.const [63] = Utf8 (ILjava/lang/String;)Z 
.const [64] = Utf8 de/audi/tghu/navi/app/command/poi/online/SpellingSuggestionCommand 
.const [65] = Utf8 logger 
.const [66] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [67] = Utf8 de/audi/atip/log/LogChannel 
.const [68] = Utf8 log 
.const [69] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [70] = Utf8 de/audi/tghu/navi/app/command/poi/online/SpellingSuggestionCommand 
.const [71] = Utf8 getCommandList 
.const [72] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [73] = Utf8 de/audi/tghu/navi/app/command/poi/online/SpellingSuggestionCommand 
.const [74] = Utf8 dsiOnlineSearch 
.const [75] = Utf8 Lorg/dsi/ifc/online/DSIPoiOnlineSearch; 
.const [76] = Utf8 de/audi/tghu/navi/app/command/poi/online/AbstractOnlineSearchCommand 
.const [77] = Utf8 <init> 
.const [78] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [79] = Utf8 de/audi/tghu/navi/app/command/poi/online/SpellingSuggestionCommand 
.const [80] = Utf8 modelAccess 
.const [81] = Utf8 Lde/audi/tghu/navi/app/poi/online/IOnlineSearchForm; 
.const [82] = Utf8 de/audi/tghu/navi/app/poi/online/IOnlineSearchForm 
.const [83] = Utf8 setSpellingsuggestion 
.const [84] = Utf8 (Ljava/lang/String;)V 
.const [85] = Utf8 de/audi/tghu/navi/app/poi/online/IOnlineSearchForm 
.const [86] = Utf8 setResultsComplete 
.const [87] = Utf8 ()V 
.const [88] = Utf8 de/audi/tghu/command/ICommandList 
.const [89] = Utf8 commandFinished 
.const [90] = Utf8 ()V 
.const [91] = Utf8 org/dsi/ifc/online/DSIPoiOnlineSearch 
.const [92] = Utf8 poiRequestSpellingSuggestion 
.const [93] = Utf8 ()V 
.const [94] = Utf8 de/audi/tghu/navi/app/command/poi/online/SpellingSuggestionCommand 
.const [95] = Class [94] 
.const [96] = Utf8 de/audi/tghu/navi/app/command/poi/online/AbstractOnlineSearchCommand 
.const [97] = Class [96] 
.const [98] = Utf8 modelAccess 
.const [99] = Utf8 Lde/audi/tghu/navi/app/poi/online/IOnlineSearchForm; 
.const [100] = Utf8 Code 
.const [101] = Utf8 <init> 
.const [102] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/tghu/navi/app/poi/online/IOnlineSearchForm;)V 
.const [103] = Utf8 poiSpellingSuggestion 
.const [104] = Utf8 (ILjava/lang/String;[Ljava/lang/String;)V 
.const [105] = Utf8 execute 
.const [106] = Utf8 ()V 
.end class 
