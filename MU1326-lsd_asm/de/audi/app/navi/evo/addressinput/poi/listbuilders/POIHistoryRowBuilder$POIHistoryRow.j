.version 50 0 
.class super [81] 
.super [83] 
.field private [84] [85] 
.field private final synthetic [86] [87] 

.method public [89] : [90] 
    .attribute [88] .code stack 6 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [17] 
L5:     aload_0 
L6:     invokespecial [14] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [18] 
L14:    iconst_2 
L15:    anewarray [2] 
L18:    dup 
L19:    iconst_0 
L20:    new [19] 
L23:    dup 
L24:    aload_2 
L25:    invokevirtual [10] 
L28:    invokespecial [15] 
L31:    aastore 
L32:    dup 
L33:    iconst_1 
L34:    new [20] 
L37:    dup 
L38:    aload_2 
L39:    invokespecial [16] 
L42:    aastore 
L43:    astore_3 
L44:    aload_0 
L45:    aload_3 
L46:    invokevirtual [11] 
L49:    return 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [91] : [92] 
    .attribute [88] .code stack 2 locals 0 
L0:     aload_1 
L1:     ifnonnull L6 
L4:     iconst_0 
L5:     areturn 
L6:     aload_1 
L7:     instanceof [5] 
L10:    ifne L15 
L13:    iconst_0 
L14:    areturn 
L15:    aload_1 
L16:    checkcast [5] 
L19:    getfield [9] 
L22:    aload_0 
L23:    getfield [9] 
L26:    invokevirtual [12] 
L29:    areturn 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [93] : [94] 
    .attribute [88] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     invokevirtual [13] 
L7:     areturn 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [21] 
.const [3] = Class [22] 
.const [4] = Class [23] 
.const [5] = Class [24] 
.const [6] = Class [25] 
.const [7] = Class [26] 
.const [8] = Class [27] 
.const [9] = Field [28] [29] 
.const [10] = Method [30] [31] 
.const [11] = Method [32] [33] 
.const [12] = Method [34] [35] 
.const [13] = Method [36] [37] 
.const [14] = Method [38] [39] 
.const [15] = Method [40] [41] 
.const [16] = Method [42] [43] 
.const [17] = Field [44] [45] 
.const [18] = Field [46] [47] 
.const [19] = Class [48] 
.const [20] = Class [49] 
.const [21] = Utf8 de/audi/atip/hmi/model/ListCell 
.const [22] = Utf8 de/audi/atip/hmi/model/TextListCell 
.const [23] = Utf8 de/audi/atip/hmi/model/ObjectListCell 
.const [24] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/POIHistoryRowBuilder$POIHistoryRow 
.const [25] = Utf8 de/audi/atip/hmi/model/ListRow 
.const [26] = Utf8 org/dsi/ifc/navigation/LICityHistoryEntry 
.const [27] = Utf8 java/lang/Object 
.const [28] = Class [50] 
.const [29] = NameAndType [51] [52] 
.const [30] = Class [53] 
.const [31] = NameAndType [54] [55] 
.const [32] = Class [56] 
.const [33] = NameAndType [57] [58] 
.const [34] = Class [59] 
.const [35] = NameAndType [60] [61] 
.const [36] = Class [62] 
.const [37] = NameAndType [63] [64] 
.const [38] = Class [65] 
.const [39] = NameAndType [66] [67] 
.const [40] = Class [68] 
.const [41] = NameAndType [69] [70] 
.const [42] = Class [71] 
.const [43] = NameAndType [72] [73] 
.const [44] = Class [74] 
.const [45] = NameAndType [75] [76] 
.const [46] = Class [77] 
.const [47] = NameAndType [78] [79] 
.const [48] = Utf8 de/audi/atip/hmi/model/TextListCell 
.const [49] = Utf8 de/audi/atip/hmi/model/ObjectListCell 
.const [50] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/POIHistoryRowBuilder$POIHistoryRow 
.const [51] = Utf8 element 
.const [52] = Utf8 Lorg/dsi/ifc/navigation/LICityHistoryEntry; 
.const [53] = Utf8 org/dsi/ifc/navigation/LICityHistoryEntry 
.const [54] = Utf8 getName 
.const [55] = Utf8 ()Ljava/lang/String; 
.const [56] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/POIHistoryRowBuilder$POIHistoryRow 
.const [57] = Utf8 setCells 
.const [58] = Utf8 ([Lde/audi/atip/hmi/model/ListCell;)V 
.const [59] = Utf8 java/lang/Object 
.const [60] = Utf8 equals 
.const [61] = Utf8 (Ljava/lang/Object;)Z 
.const [62] = Utf8 java/lang/Object 
.const [63] = Utf8 hashCode 
.const [64] = Utf8 ()I 
.const [65] = Utf8 de/audi/atip/hmi/model/ListRow 
.const [66] = Utf8 <init> 
.const [67] = Utf8 ()V 
.const [68] = Utf8 de/audi/atip/hmi/model/TextListCell 
.const [69] = Utf8 <init> 
.const [70] = Utf8 (Ljava/lang/String;)V 
.const [71] = Utf8 de/audi/atip/hmi/model/ObjectListCell 
.const [72] = Utf8 <init> 
.const [73] = Utf8 (Ljava/lang/Object;)V 
.const [74] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/POIHistoryRowBuilder$POIHistoryRow 
.const [75] = Utf8 this$0 
.const [76] = Utf8 Lde/audi/app/navi/evo/addressinput/poi/listbuilders/POIHistoryRowBuilder; 
.const [77] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/POIHistoryRowBuilder$POIHistoryRow 
.const [78] = Utf8 element 
.const [79] = Utf8 Lorg/dsi/ifc/navigation/LICityHistoryEntry; 
.const [80] = Utf8 de/audi/app/navi/evo/addressinput/poi/listbuilders/POIHistoryRowBuilder$POIHistoryRow 
.const [81] = Class [80] 
.const [82] = Utf8 de/audi/atip/hmi/model/ListRow 
.const [83] = Class [82] 
.const [84] = Utf8 element 
.const [85] = Utf8 Lorg/dsi/ifc/navigation/LICityHistoryEntry; 
.const [86] = Utf8 this$0 
.const [87] = Utf8 Lde/audi/app/navi/evo/addressinput/poi/listbuilders/POIHistoryRowBuilder; 
.const [88] = Utf8 Code 
.const [89] = Utf8 <init> 
.const [90] = Utf8 (Lde/audi/app/navi/evo/addressinput/poi/listbuilders/POIHistoryRowBuilder;Lorg/dsi/ifc/navigation/LICityHistoryEntry;)V 
.const [91] = Utf8 equals 
.const [92] = Utf8 (Ljava/lang/Object;)Z 
.const [93] = Utf8 hashCode 
.const [94] = Utf8 ()I 
.end class 
