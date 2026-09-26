.version 50 0 
.class public super abstract [47] 
.super [49] 
.field public static final [50] [51] 
.field public static final [52] [53] 
.field public static final [54] [55] 

.method public annotation [57] : [58] 
    .attribute [56] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [11] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public abstract [59] : [60] 
    .attribute [56] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public static [61] : [62] 
    .attribute [56] .code stack 2 locals 2 
L0:     aconst_null 
L1:     astore_2 
L2:     aload_0 
L3:     ifnull L37 
L6:     iconst_0 
L7:     istore_3 
L8:     iload_3 
L9:     aload_0 
L10:    arraylength 
L11:    if_icmpge L37 
L14:    aload_0 
L15:    iload_3 
L16:    aaload 
L17:    invokevirtual [6] 
L20:    iload_1 
L21:    if_icmpne L31 
L24:    aload_0 
L25:    iload_3 
L26:    aaload 
L27:    astore_2 
L28:    goto L37 
L31:    iinc 3 1 
L34:    goto L8 
L37:    aload_2 
L38:    areturn 
L39:    nop 
L40:    
    .end code 
.end method 

.method public static [63] : [64] 
    .attribute [56] .code stack 1 locals 0 
L0:     aload_0 
L1:     ifnull L21 
L4:     aload_0 
L5:     invokevirtual [7] 
L8:     ifnull L21 
L11:    aload_0 
L12:    invokevirtual [7] 
L15:    invokevirtual [8] 
L18:    ifne L25 
L21:    iconst_1 
L22:    goto L26 
L25:    iconst_0 
L26:    areturn 
L27:    nop 
L28:    
    .end code 
.end method 

.method protected [65] : [66] 
    .attribute [56] .code stack 1 locals 0 
L0:     aload_1 
L1:     ifnull L23 
L4:     aload_1 
L5:     invokevirtual [9] 
L8:     ifnull L23 
L11:    aload_1 
L12:    invokevirtual [9] 
L15:    arraylength 
L16:    ifle L23 
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

.method protected [67] : [68] 
    .attribute [56] .code stack 2 locals 0 
L0:     aload_1 
L1:     arraylength 
L2:     iconst_1 
L3:     if_icmpeq L24 
L6:     aload_1 
L7:     iconst_1 
L8:     aaload 
L9:     ifnull L24 
L12:    aload_1 
L13:    iconst_1 
L14:    aaload 
L15:    invokevirtual [10] 
L18:    invokevirtual [8] 
L21:    ifne L26 
L24:    iconst_0 
L25:    areturn 
L26:    aload_1 
L27:    arraylength 
L28:    iconst_2 
L29:    if_icmpeq L50 
L32:    aload_1 
L33:    iconst_2 
L34:    aaload 
L35:    ifnull L50 
L38:    aload_1 
L39:    iconst_2 
L40:    aaload 
L41:    invokevirtual [10] 
L44:    invokevirtual [8] 
L47:    ifne L52 
L50:    iconst_1 
L51:    areturn 
L52:    iconst_2 
L53:    areturn 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [12] 
.const [3] = Class [13] 
.const [4] = Class [14] 
.const [5] = Class [15] 
.const [6] = Method [16] [17] 
.const [7] = Method [18] [19] 
.const [8] = Method [20] [21] 
.const [9] = Method [22] [23] 
.const [10] = Method [24] [25] 
.const [11] = Method [26] [27] 
.const [12] = Utf8 java/lang/Object 
.const [13] = Utf8 org/dsi/ifc/search/Token 
.const [14] = Utf8 java/lang/String 
.const [15] = Utf8 de/audi/atip/hmi/model/TextListCellHighlightText 
.const [16] = Class [28] 
.const [17] = NameAndType [29] [30] 
.const [18] = Class [31] 
.const [19] = NameAndType [32] [33] 
.const [20] = Class [34] 
.const [21] = NameAndType [35] [36] 
.const [22] = Class [37] 
.const [23] = NameAndType [38] [39] 
.const [24] = Class [40] 
.const [25] = NameAndType [41] [42] 
.const [26] = Class [43] 
.const [27] = NameAndType [44] [45] 
.const [28] = Utf8 org/dsi/ifc/search/Token 
.const [29] = Utf8 getWordType 
.const [30] = Utf8 ()I 
.const [31] = Utf8 org/dsi/ifc/search/Token 
.const [32] = Utf8 getToken 
.const [33] = Utf8 ()Ljava/lang/String; 
.const [34] = Utf8 java/lang/String 
.const [35] = Utf8 length 
.const [36] = Utf8 ()I 
.const [37] = Utf8 org/dsi/ifc/search/Token 
.const [38] = Utf8 getHighlights 
.const [39] = Utf8 ()[Lorg/dsi/ifc/search/Highlight; 
.const [40] = Utf8 de/audi/atip/hmi/model/TextListCellHighlightText 
.const [41] = Utf8 getText 
.const [42] = Utf8 ()Ljava/lang/String; 
.const [43] = Utf8 java/lang/Object 
.const [44] = Utf8 <init> 
.const [45] = Utf8 ()V 
.const [46] = Utf8 de/audi/atip/search/util/AbstractSearchResultFormatter 
.const [47] = Class [46] 
.const [48] = Utf8 java/lang/Object 
.const [49] = Class [48] 
.const [50] = Utf8 LLD_ONETEXTLINES_GENERAL 
.const [51] = Utf8 I 
.const [52] = Utf8 LLD_TWOTEXTLINES_GENERAL 
.const [53] = Utf8 I 
.const [54] = Utf8 LLD_THREETEXTLINES_GENERAL 
.const [55] = Utf8 I 
.const [56] = Utf8 Code 
.const [57] = Utf8 <init> 
.const [58] = Utf8 ()V 
.const [59] = Utf8 formatResult 
.const [60] = Utf8 (Lorg/dsi/ifc/search/SearchResult;)Lde/audi/atip/search/util/SearchResultListRow; 
.const [61] = Utf8 getTokenForType 
.const [62] = Utf8 ([Lorg/dsi/ifc/search/Token;I)Lorg/dsi/ifc/search/Token; 
.const [63] = Utf8 isEmpty 
.const [64] = Utf8 (Lorg/dsi/ifc/search/Token;)Z 
.const [65] = Utf8 hasHighlight 
.const [66] = Utf8 (Lorg/dsi/ifc/search/Token;)Z 
.const [67] = Utf8 determineTextLineFormatID 
.const [68] = Utf8 ([Lde/audi/atip/hmi/model/TextListCellHighlightText;)I 
.end class 
