.version 50 0 
.class public super [117] 
.super [119] 
.field private final [120] [121] 
.field private final [122] [123] 

.method public [125] : [126] 
    .attribute [124] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [2] 
L4:     aload_2 
L5:     invokespecial [24] 
L8:     aload_0 
L9:     aload 4 
L11:    putfield [25] 
L14:    aload_0 
L15:    aload_3 
L16:    putfield [26] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [127] : [128] 
    .attribute [124] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     ifnull L39 
L7:     aload_0 
L8:     getfield [19] 
L11:    ldc [3] 
L13:    ldc [4] 
L15:    aload_0 
L16:    getfield [17] 
L19:    invokevirtual [20] 
L22:    pop 
L23:    aload_0 
L24:    getfield [18] 
L27:    aload_0 
L28:    getfield [17] 
L31:    invokeinterface [27] 0 
L36:    goto L60 
L39:    aload_0 
L40:    getfield [19] 
L43:    ldc [5] 
L45:    ldc [6] 
L47:    invokevirtual [21] 
L50:    pop 
L51:    aload_0 
L52:    invokevirtual [22] 
L55:    invokeinterface [28] 0 
L60:    return 
L61:    nop 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [129] : [130] 
    .attribute [124] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [3] 
L6:     ldc [7] 
L8:     aload_2 
L9:     invokestatic [8] 
L12:    iload_1 
L13:    i2l 
L14:    invokevirtual [23] 
L17:    pop 
L18:    aload_0 
L19:    getfield [16] 
L22:    aload_2 
L23:    invokeinterface [29] 0 
L28:    aload_0 
L29:    invokevirtual [22] 
L32:    invokeinterface [28] 0 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [30] 
.const [3] = Int 1078071040 
.const [4] = String [31] 
.const [5] = Int -1601830656 
.const [6] = String [32] 
.const [7] = String [33] 
.const [8] = Method [34] [35] 
.const [9] = Class [36] 
.const [10] = Class [37] 
.const [11] = Class [38] 
.const [12] = Class [39] 
.const [13] = Class [40] 
.const [14] = Class [41] 
.const [15] = Class [42] 
.const [16] = Field [43] [44] 
.const [17] = Field [45] [46] 
.const [18] = Field [47] [48] 
.const [19] = Field [49] [50] 
.const [20] = Method [51] [52] 
.const [21] = Method [53] [54] 
.const [22] = Method [55] [56] 
.const [23] = Method [57] [58] 
.const [24] = Method [59] [60] 
.const [25] = Field [61] [62] 
.const [26] = Field [63] [64] 
.const [27] = InterfaceMethod [65] [66] 
.const [28] = InterfaceMethod [67] [68] 
.const [29] = InterfaceMethod [69] [70] 
.const [30] = Utf8 TelSearchRequestSuggestionCommand 
.const [31] = Utf8 '[TelSearchRequestSuggestionCommand#execute] query=%1' 
.const [32] = Utf8 '[TelSearchRequestSuggestionCommand#execute] DSISearch is null --> NOP!' 
.const [33] = Utf8 '[TelSearchRequestSuggestionCommand#requestSuggestionResult] success=%2, suggestions=%1' 
.const [34] = Class [71] 
.const [35] = NameAndType [72] [73] 
.const [36] = Utf8 de/audi/app/phone/core/search/cmd/TelSearchRequestSuggestionCommand 
.const [37] = Utf8 de/audi/app/phone/core/search/cmd/AbstractTelSearchCmd 
.const [38] = Utf8 de/audi/atip/log/LogChannel 
.const [39] = Utf8 org/dsi/ifc/search/DSISearch 
.const [40] = Utf8 de/audi/tghu/command/ICommandList 
.const [41] = Utf8 de/esolutions/fw/util/commons/Converter 
.const [42] = Utf8 de/audi/app/phone/core/search/cmd/ITelSearchRequestSuggestionListener 
.const [43] = Class [74] 
.const [44] = NameAndType [75] [76] 
.const [45] = Class [77] 
.const [46] = NameAndType [78] [79] 
.const [47] = Class [80] 
.const [48] = NameAndType [81] [82] 
.const [49] = Class [83] 
.const [50] = NameAndType [84] [85] 
.const [51] = Class [86] 
.const [52] = NameAndType [87] [88] 
.const [53] = Class [89] 
.const [54] = NameAndType [90] [91] 
.const [55] = Class [92] 
.const [56] = NameAndType [93] [94] 
.const [57] = Class [95] 
.const [58] = NameAndType [96] [97] 
.const [59] = Class [98] 
.const [60] = NameAndType [99] [100] 
.const [61] = Class [101] 
.const [62] = NameAndType [102] [103] 
.const [63] = Class [104] 
.const [64] = NameAndType [105] [106] 
.const [65] = Class [107] 
.const [66] = NameAndType [108] [109] 
.const [67] = Class [110] 
.const [68] = NameAndType [111] [112] 
.const [69] = Class [113] 
.const [70] = NameAndType [114] [115] 
.const [71] = Utf8 de/esolutions/fw/util/commons/Converter 
.const [72] = Utf8 array2String 
.const [73] = Utf8 (Ljava/lang/Object;)Ljava/lang/String; 
.const [74] = Utf8 de/audi/app/phone/core/search/cmd/TelSearchRequestSuggestionCommand 
.const [75] = Utf8 listener 
.const [76] = Utf8 Lde/audi/app/phone/core/search/cmd/ITelSearchRequestSuggestionListener; 
.const [77] = Utf8 de/audi/app/phone/core/search/cmd/TelSearchRequestSuggestionCommand 
.const [78] = Utf8 query 
.const [79] = Utf8 Lorg/dsi/ifc/search/SearchQuery; 
.const [80] = Utf8 de/audi/app/phone/core/search/cmd/TelSearchRequestSuggestionCommand 
.const [81] = Utf8 dsiSearch 
.const [82] = Utf8 Lorg/dsi/ifc/search/DSISearch; 
.const [83] = Utf8 de/audi/app/phone/core/search/cmd/TelSearchRequestSuggestionCommand 
.const [84] = Utf8 logger 
.const [85] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [86] = Utf8 de/audi/atip/log/LogChannel 
.const [87] = Utf8 log 
.const [88] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [89] = Utf8 de/audi/atip/log/LogChannel 
.const [90] = Utf8 log 
.const [91] = Utf8 (ILjava/lang/String;)Z 
.const [92] = Utf8 de/audi/app/phone/core/search/cmd/TelSearchRequestSuggestionCommand 
.const [93] = Utf8 getCommandList 
.const [94] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [95] = Utf8 de/audi/atip/log/LogChannel 
.const [96] = Utf8 log 
.const [97] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [98] = Utf8 de/audi/app/phone/core/search/cmd/AbstractTelSearchCmd 
.const [99] = Utf8 <init> 
.const [100] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Lorg/dsi/ifc/search/DSISearch;)V 
.const [101] = Utf8 de/audi/app/phone/core/search/cmd/TelSearchRequestSuggestionCommand 
.const [102] = Utf8 listener 
.const [103] = Utf8 Lde/audi/app/phone/core/search/cmd/ITelSearchRequestSuggestionListener; 
.const [104] = Utf8 de/audi/app/phone/core/search/cmd/TelSearchRequestSuggestionCommand 
.const [105] = Utf8 query 
.const [106] = Utf8 Lorg/dsi/ifc/search/SearchQuery; 
.const [107] = Utf8 org/dsi/ifc/search/DSISearch 
.const [108] = Utf8 requestSuggestion 
.const [109] = Utf8 (Lorg/dsi/ifc/search/SearchQuery;)V 
.const [110] = Utf8 de/audi/tghu/command/ICommandList 
.const [111] = Utf8 commandFinished 
.const [112] = Utf8 ()V 
.const [113] = Utf8 de/audi/app/phone/core/search/cmd/ITelSearchRequestSuggestionListener 
.const [114] = Utf8 updateSuggestion 
.const [115] = Utf8 ([Lorg/dsi/ifc/search/Suggestion;)V 
.const [116] = Utf8 de/audi/app/phone/core/search/cmd/TelSearchRequestSuggestionCommand 
.const [117] = Class [116] 
.const [118] = Utf8 de/audi/app/phone/core/search/cmd/AbstractTelSearchCmd 
.const [119] = Class [118] 
.const [120] = Utf8 listener 
.const [121] = Utf8 Lde/audi/app/phone/core/search/cmd/ITelSearchRequestSuggestionListener; 
.const [122] = Utf8 query 
.const [123] = Utf8 Lorg/dsi/ifc/search/SearchQuery; 
.const [124] = Utf8 Code 
.const [125] = Utf8 <init> 
.const [126] = Utf8 (Lde/audi/atip/log/LogChannel;Lorg/dsi/ifc/search/DSISearch;Lorg/dsi/ifc/search/SearchQuery;Lde/audi/app/phone/core/search/cmd/ITelSearchRequestSuggestionListener;)V 
.const [127] = Utf8 execute 
.const [128] = Utf8 ()V 
.const [129] = Utf8 requestSuggestionResult 
.const [130] = Utf8 (I[Lorg/dsi/ifc/search/Suggestion;)V 
.end class 
