.version 50 0 
.class super [81] 
.super [83] 
.field private [84] [85] 
.field private [86] [87] 
.field private [88] [89] 
.field private final synthetic [90] [91] 

.method public [93] : [94] 
    .attribute [92] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [12] 
L5:     aload_0 
L6:     lload_2 
L7:     iconst_2 
L8:     invokespecial [10] 
L11:    aload_0 
L12:    iload 5 
L14:    putfield [13] 
L17:    aload_0 
L18:    aload 4 
L20:    putfield [14] 
L23:    aload_0 
L24:    lload_2 
L25:    putfield [15] 
L28:    aload_0 
L29:    iconst_0 
L30:    aload 4 
L32:    invokevirtual [8] 
L35:    pop 
L36:    aload_0 
L37:    iconst_1 
L38:    lload_2 
L39:    invokevirtual [9] 
L42:    pop 
L43:    return 
L44:    
    .end code 
.end method 

.method public [95] : [96] 
    .attribute [92] .code stack 2 locals 1 
L0:     aload_1 
L1:     ifnonnull L6 
L4:     iconst_0 
L5:     areturn 
L6:     aload_1 
L7:     instanceof [2] 
L10:    ifne L15 
L13:    iconst_0 
L14:    areturn 
L15:    aload_1 
L16:    checkcast [2] 
L19:    getfield [5] 
L22:    istore_2 
L23:    iload_2 
L24:    aload_0 
L25:    getfield [5] 
L28:    if_icmpne L35 
L31:    iconst_1 
L32:    goto L36 
L35:    iconst_0 
L36:    areturn 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public interface [97] : [98] 
    .attribute [92] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [5] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [99] : [100] 
    .attribute [92] .code stack 7 locals 0 
L0:     new [16] 
L3:     dup 
L4:     aload_0 
L5:     getfield [4] 
L8:     aload_0 
L9:     getfield [7] 
L12:    aload_0 
L13:    getfield [6] 
L16:    aload_0 
L17:    getfield [5] 
L20:    invokespecial [11] 
L23:    areturn 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [17] 
.const [3] = Class [18] 
.const [4] = Field [19] [20] 
.const [5] = Field [21] [22] 
.const [6] = Field [23] [24] 
.const [7] = Field [25] [26] 
.const [8] = Method [27] [28] 
.const [9] = Method [29] [30] 
.const [10] = Method [31] [32] 
.const [11] = Method [33] [34] 
.const [12] = Field [35] [36] 
.const [13] = Field [37] [38] 
.const [14] = Field [39] [40] 
.const [15] = Field [41] [42] 
.const [16] = Class [43] 
.const [17] = Utf8 de/audi/app/navi/evo/addressinput/poi/sds/SDSPoiPickListRowBuilder$SDSPoiPickEvoListRow 
.const [18] = Utf8 de/audi/atip/hmi/model/list/EvoListRow 
.const [19] = Class [44] 
.const [20] = NameAndType [45] [46] 
.const [21] = Class [47] 
.const [22] = NameAndType [48] [49] 
.const [23] = Class [50] 
.const [24] = NameAndType [51] [52] 
.const [25] = Class [53] 
.const [26] = NameAndType [54] [55] 
.const [27] = Class [56] 
.const [28] = NameAndType [57] [58] 
.const [29] = Class [59] 
.const [30] = NameAndType [60] [61] 
.const [31] = Class [62] 
.const [32] = NameAndType [63] [64] 
.const [33] = Class [65] 
.const [34] = NameAndType [66] [67] 
.const [35] = Class [68] 
.const [36] = NameAndType [69] [70] 
.const [37] = Class [71] 
.const [38] = NameAndType [72] [73] 
.const [39] = Class [74] 
.const [40] = NameAndType [75] [76] 
.const [41] = Class [77] 
.const [42] = NameAndType [78] [79] 
.const [43] = Utf8 de/audi/app/navi/evo/addressinput/poi/sds/SDSPoiPickListRowBuilder$SDSPoiPickEvoListRow 
.const [44] = Utf8 de/audi/app/navi/evo/addressinput/poi/sds/SDSPoiPickListRowBuilder$SDSPoiPickEvoListRow 
.const [45] = Utf8 this$0 
.const [46] = Utf8 Lde/audi/app/navi/evo/addressinput/poi/sds/SDSPoiPickListRowBuilder; 
.const [47] = Utf8 de/audi/app/navi/evo/addressinput/poi/sds/SDSPoiPickListRowBuilder$SDSPoiPickEvoListRow 
.const [48] = Utf8 index 
.const [49] = Utf8 I 
.const [50] = Utf8 de/audi/app/navi/evo/addressinput/poi/sds/SDSPoiPickListRowBuilder$SDSPoiPickEvoListRow 
.const [51] = Utf8 entryName 
.const [52] = Utf8 Ljava/lang/String; 
.const [53] = Utf8 de/audi/app/navi/evo/addressinput/poi/sds/SDSPoiPickListRowBuilder$SDSPoiPickEvoListRow 
.const [54] = Utf8 entryID 
.const [55] = Utf8 J 
.const [56] = Utf8 de/audi/app/navi/evo/addressinput/poi/sds/SDSPoiPickListRowBuilder$SDSPoiPickEvoListRow 
.const [57] = Utf8 setText 
.const [58] = Utf8 (ILjava/lang/String;)Lde/audi/atip/hmi/model/list/EvoListRow; 
.const [59] = Utf8 de/audi/app/navi/evo/addressinput/poi/sds/SDSPoiPickListRowBuilder$SDSPoiPickEvoListRow 
.const [60] = Utf8 setLong 
.const [61] = Utf8 (IJ)Lde/audi/atip/hmi/model/list/EvoListRow; 
.const [62] = Utf8 de/audi/atip/hmi/model/list/EvoListRow 
.const [63] = Utf8 <init> 
.const [64] = Utf8 (JI)V 
.const [65] = Utf8 de/audi/app/navi/evo/addressinput/poi/sds/SDSPoiPickListRowBuilder$SDSPoiPickEvoListRow 
.const [66] = Utf8 <init> 
.const [67] = Utf8 (Lde/audi/app/navi/evo/addressinput/poi/sds/SDSPoiPickListRowBuilder;JLjava/lang/String;I)V 
.const [68] = Utf8 de/audi/app/navi/evo/addressinput/poi/sds/SDSPoiPickListRowBuilder$SDSPoiPickEvoListRow 
.const [69] = Utf8 this$0 
.const [70] = Utf8 Lde/audi/app/navi/evo/addressinput/poi/sds/SDSPoiPickListRowBuilder; 
.const [71] = Utf8 de/audi/app/navi/evo/addressinput/poi/sds/SDSPoiPickListRowBuilder$SDSPoiPickEvoListRow 
.const [72] = Utf8 index 
.const [73] = Utf8 I 
.const [74] = Utf8 de/audi/app/navi/evo/addressinput/poi/sds/SDSPoiPickListRowBuilder$SDSPoiPickEvoListRow 
.const [75] = Utf8 entryName 
.const [76] = Utf8 Ljava/lang/String; 
.const [77] = Utf8 de/audi/app/navi/evo/addressinput/poi/sds/SDSPoiPickListRowBuilder$SDSPoiPickEvoListRow 
.const [78] = Utf8 entryID 
.const [79] = Utf8 J 
.const [80] = Utf8 de/audi/app/navi/evo/addressinput/poi/sds/SDSPoiPickListRowBuilder$SDSPoiPickEvoListRow 
.const [81] = Class [80] 
.const [82] = Utf8 de/audi/atip/hmi/model/list/EvoListRow 
.const [83] = Class [82] 
.const [84] = Utf8 index 
.const [85] = Utf8 I 
.const [86] = Utf8 entryName 
.const [87] = Utf8 Ljava/lang/String; 
.const [88] = Utf8 entryID 
.const [89] = Utf8 J 
.const [90] = Utf8 this$0 
.const [91] = Utf8 Lde/audi/app/navi/evo/addressinput/poi/sds/SDSPoiPickListRowBuilder; 
.const [92] = Utf8 Code 
.const [93] = Utf8 <init> 
.const [94] = Utf8 (Lde/audi/app/navi/evo/addressinput/poi/sds/SDSPoiPickListRowBuilder;JLjava/lang/String;I)V 
.const [95] = Utf8 equals 
.const [96] = Utf8 (Ljava/lang/Object;)Z 
.const [97] = Utf8 hashCode 
.const [98] = Utf8 ()I 
.const [99] = Utf8 copy 
.const [100] = Utf8 ()Lde/audi/atip/hmi/model/list/EvoListRow; 
.end class 
