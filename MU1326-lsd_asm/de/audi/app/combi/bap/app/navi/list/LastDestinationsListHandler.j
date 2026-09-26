.version 50 0 
.class public super [110] 
.super [112] 

.method public [114] : [115] 
    .attribute [113] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [2] 
L4:     invokespecial [22] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [116] : [117] 
    .attribute [113] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     invokespecial [23] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [118] : [119] 
    .attribute [113] .code stack 8 locals 2 
L0:     aload_0 
L1:     getfield [14] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     aload_0 
L9:     getfield [15] 
L12:    iload_1 
L13:    ifeq L21 
L16:    ldc [5] 
L18:    goto L23 
L21:    ldc [6] 
L23:    iload_2 
L24:    i2l 
L25:    invokevirtual [16] 
L28:    aload_0 
L29:    getfield [14] 
L32:    ldc [3] 
L34:    ldc [7] 
L36:    aload_0 
L37:    getfield [15] 
L40:    iload_3 
L41:    i2l 
L42:    iload 4 
L44:    i2l 
L45:    invokevirtual [17] 
L48:    pop 
L49:    aload_0 
L50:    getfield [18] 
L53:    bipush 41 
L55:    invokevirtual [19] 
L58:    astore 5 
L60:    aload_0 
L61:    getfield [18] 
L64:    bipush 41 
L66:    invokevirtual [20] 
L69:    checkcast [8] 
L72:    astore 6 
L74:    aload 6 
L76:    iload_1 
L77:    ifeq L84 
L80:    iconst_0 
L81:    goto L85 
L84:    iconst_1 
L85:    putfield [24] 
L88:    aload 6 
L90:    iload_2 
L91:    putfield [25] 
L94:    aload 6 
L96:    iload_3 
L97:    putfield [26] 
L100:   aload 6 
L102:   iload 4 
L104:   putfield [27] 
L107:   aload 5 
L109:   aload 6 
L111:   invokevirtual [21] 
L114:   return 
L115:   nop 
L116:   
    .end code 
.end method 

.method public [120] : [121] 
    .attribute [113] .code stack 1 locals 0 
L0:     iconst_0 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [28] 
.const [3] = Int -2137614336 
.const [4] = String [29] 
.const [5] = String [30] 
.const [6] = String [31] 
.const [7] = String [32] 
.const [8] = Class [33] 
.const [9] = Class [34] 
.const [10] = Class [35] 
.const [11] = Class [36] 
.const [12] = Class [37] 
.const [13] = Class [38] 
.const [14] = Field [39] [40] 
.const [15] = Field [41] [42] 
.const [16] = Method [43] [44] 
.const [17] = Method [45] [46] 
.const [18] = Field [47] [48] 
.const [19] = Method [49] [50] 
.const [20] = Method [51] [52] 
.const [21] = Method [53] [54] 
.const [22] = Method [55] [56] 
.const [23] = Method [57] [58] 
.const [24] = Field [59] [60] 
.const [25] = Field [61] [62] 
.const [26] = Field [63] [64] 
.const [27] = Field [65] [66] 
.const [28] = Utf8 LastDestinationsListHandler 
.const [29] = Utf8 '[%1#getNextListPosResult] called (result=%2, currentEntryID=%3,...)' 
.const [30] = Utf8 successful 
.const [31] = Utf8 unsuccessful 
.const [32] = Utf8 '[%1#getNextListPosResult] ..., nextEntryID=%2, absoluteListPos=%3' 
.const [33] = Utf8 de/vw/mib/bap/generated/navsd/serializer/GetNextListPos_Result 
.const [34] = Utf8 de/audi/app/combi/bap/app/navi/list/LastDestinationsListHandler 
.const [35] = Utf8 de/audi/app/bap/fw/arrays/AbstractManagedListHandler 
.const [36] = Utf8 de/audi/atip/log/LogChannel 
.const [37] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleFSG 
.const [38] = Utf8 de/audi/app/bap/fw/functiontypes/BAPFunctionMethodFSG 
.const [39] = Class [67] 
.const [40] = NameAndType [68] [69] 
.const [41] = Class [70] 
.const [42] = NameAndType [71] [72] 
.const [43] = Class [73] 
.const [44] = NameAndType [74] [75] 
.const [45] = Class [76] 
.const [46] = NameAndType [77] [78] 
.const [47] = Class [79] 
.const [48] = NameAndType [80] [81] 
.const [49] = Class [82] 
.const [50] = NameAndType [83] [84] 
.const [51] = Class [85] 
.const [52] = NameAndType [86] [87] 
.const [53] = Class [88] 
.const [54] = NameAndType [89] [90] 
.const [55] = Class [91] 
.const [56] = NameAndType [92] [93] 
.const [57] = Class [94] 
.const [58] = NameAndType [95] [96] 
.const [59] = Class [97] 
.const [60] = NameAndType [98] [99] 
.const [61] = Class [100] 
.const [62] = NameAndType [101] [102] 
.const [63] = Class [103] 
.const [64] = NameAndType [104] [105] 
.const [65] = Class [106] 
.const [66] = NameAndType [107] [108] 
.const [67] = Utf8 de/audi/app/combi/bap/app/navi/list/LastDestinationsListHandler 
.const [68] = Utf8 logChannel 
.const [69] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [70] = Utf8 de/audi/app/combi/bap/app/navi/list/LastDestinationsListHandler 
.const [71] = Utf8 className 
.const [72] = Utf8 Ljava/lang/String; 
.const [73] = Utf8 de/audi/atip/log/LogChannel 
.const [74] = Utf8 log 
.const [75] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;J)V 
.const [76] = Utf8 de/audi/atip/log/LogChannel 
.const [77] = Utf8 log 
.const [78] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [79] = Utf8 de/audi/app/combi/bap/app/navi/list/LastDestinationsListHandler 
.const [80] = Utf8 moduleFsg 
.const [81] = Utf8 Lde/audi/app/bap/fw/AbstractBAPModuleFSG; 
.const [82] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleFSG 
.const [83] = Utf8 getBAPFunctionMethodFSG 
.const [84] = Utf8 (I)Lde/audi/app/bap/fw/functiontypes/BAPFunctionMethodFSG; 
.const [85] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleFSG 
.const [86] = Utf8 createResultSerializer 
.const [87] = Utf8 (I)Lde/vw/mib/bap/requests/ResultMethod; 
.const [88] = Utf8 de/audi/app/bap/fw/functiontypes/BAPFunctionMethodFSG 
.const [89] = Utf8 resultREQ 
.const [90] = Utf8 (Lde/vw/mib/bap/requests/ResultMethod;)V 
.const [91] = Utf8 de/audi/app/bap/fw/arrays/AbstractManagedListHandler 
.const [92] = Utf8 <init> 
.const [93] = Utf8 (Lde/audi/app/bap/fw/AbstractBAPModuleFSG;Ljava/lang/String;)V 
.const [94] = Utf8 de/audi/app/bap/fw/arrays/AbstractManagedListHandler 
.const [95] = Utf8 getNextListPosForArbitraryIds 
.const [96] = Utf8 (II)V 
.const [97] = Utf8 de/vw/mib/bap/generated/navsd/serializer/GetNextListPos_Result 
.const [98] = Utf8 getNextListPos_Result 
.const [99] = Utf8 I 
.const [100] = Utf8 de/vw/mib/bap/generated/navsd/serializer/GetNextListPos_Result 
.const [101] = Utf8 currentPos 
.const [102] = Utf8 I 
.const [103] = Utf8 de/vw/mib/bap/generated/navsd/serializer/GetNextListPos_Result 
.const [104] = Utf8 nextPos 
.const [105] = Utf8 I 
.const [106] = Utf8 de/vw/mib/bap/generated/navsd/serializer/GetNextListPos_Result 
.const [107] = Utf8 absoluteListPos 
.const [108] = Utf8 I 
.const [109] = Utf8 de/audi/app/combi/bap/app/navi/list/LastDestinationsListHandler 
.const [110] = Class [109] 
.const [111] = Utf8 de/audi/app/bap/fw/arrays/AbstractManagedListHandler 
.const [112] = Class [111] 
.const [113] = Utf8 Code 
.const [114] = Utf8 <init> 
.const [115] = Utf8 (Lde/audi/app/combi/bap/fw/AbstractCombiModule;)V 
.const [116] = Utf8 getNextListPos 
.const [117] = Utf8 (II)V 
.const [118] = Utf8 getNextListPosResult 
.const [119] = Utf8 (ZIII)V 
.const [120] = Utf8 getIndexSize 
.const [121] = Utf8 ()I 
.end class 
