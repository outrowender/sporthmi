.version 50 0 
.class public super [64] 
.super [66] 
.field private static final [67] [68] 

.method public [70] : [71] 
    .attribute [69] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_0 
L3:     iconst_1 
L4:     invokespecial [15] 
L7:     aload_0 
L8:     iconst_0 
L9:     iconst_3 
L10:    invokevirtual [9] 
L13:    aload_0 
L14:    iconst_1 
L15:    iconst_1 
L16:    invokevirtual [9] 
L19:    aload_0 
L20:    iconst_2 
L21:    iconst_2 
L22:    invokevirtual [9] 
L25:    aload_0 
L26:    iconst_3 
L27:    iconst_1 
L28:    invokevirtual [9] 
L31:    aload_0 
L32:    iconst_5 
L33:    iconst_1 
L34:    invokevirtual [9] 
L37:    aload_0 
L38:    iconst_4 
L39:    iconst_1 
L40:    invokevirtual [9] 
L43:    return 
L44:    
    .end code 
.end method 

.method public [72] : [73] 
    .attribute [69] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     invokevirtual [11] 
L7:     ifeq L24 
L10:    aload_0 
L11:    getfield [10] 
L14:    ldc [2] 
L16:    ldc [3] 
L18:    ldc [4] 
L20:    invokevirtual [12] 
L23:    pop 
L24:    aload_1 
L25:    invokevirtual [13] 
L28:    tableswitch 5 
            L72 
            L80 
            L88 
            L120 
            L104 
            L112 
            L96 
            default : L120 

L72:    aload_0 
L73:    iconst_1 
L74:    invokevirtual [14] 
L77:    goto L120 
L80:    aload_0 
L81:    iconst_2 
L82:    invokevirtual [14] 
L85:    goto L120 
L88:    aload_0 
L89:    iconst_0 
L90:    invokevirtual [14] 
L93:    goto L120 
L96:    aload_0 
L97:    iconst_4 
L98:    invokevirtual [14] 
L101:   goto L120 
L104:   aload_0 
L105:   iconst_3 
L106:   invokevirtual [14] 
L109:   goto L120 
L112:   aload_0 
L113:   iconst_5 
L114:   invokevirtual [14] 
L117:   goto L120 
L120:   aload_0 
L121:   aload_1 
L122:   invokespecial [16] 
L125:   areturn 
L126:   nop 
L127:   nop 
L128:   
    .end code 
.end method 

.method public enum [74] : [75] 
    .attribute [69] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 14808325 
.const [3] = String [17] 
.const [4] = String [18] 
.const [5] = Class [19] 
.const [6] = Class [20] 
.const [7] = Class [21] 
.const [8] = Class [22] 
.const [9] = Method [23] [24] 
.const [10] = Field [25] [26] 
.const [11] = Method [27] [28] 
.const [12] = Method [29] [30] 
.const [13] = Method [31] [32] 
.const [14] = Method [33] [34] 
.const [15] = Method [35] [36] 
.const [16] = Method [37] [38] 
.const [17] = Utf8 '[%1.formatResult]' 
.const [18] = Utf8 MediaGlobalSearchResultFormatter 
.const [19] = Utf8 de/audi/app/media/evo/content/data/search/MediaGlobalSearchResultFormatter 
.const [20] = Utf8 de/audi/app/media/evo/content/data/search/MediaSearchResultFormatter 
.const [21] = Utf8 de/audi/atip/log/LogChannel 
.const [22] = Utf8 org/dsi/ifc/search/SearchResult 
.const [23] = Class [39] 
.const [24] = NameAndType [40] [41] 
.const [25] = Class [42] 
.const [26] = NameAndType [43] [44] 
.const [27] = Class [45] 
.const [28] = NameAndType [46] [47] 
.const [29] = Class [48] 
.const [30] = NameAndType [49] [50] 
.const [31] = Class [51] 
.const [32] = NameAndType [52] [53] 
.const [33] = Class [54] 
.const [34] = NameAndType [55] [56] 
.const [35] = Class [57] 
.const [36] = NameAndType [58] [59] 
.const [37] = Class [60] 
.const [38] = NameAndType [61] [62] 
.const [39] = Utf8 de/audi/app/media/evo/content/data/search/MediaGlobalSearchResultFormatter 
.const [40] = Utf8 setLayoutForFormatType 
.const [41] = Utf8 (II)V 
.const [42] = Utf8 de/audi/app/media/evo/content/data/search/MediaGlobalSearchResultFormatter 
.const [43] = Utf8 logger 
.const [44] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [45] = Utf8 de/audi/atip/log/LogChannel 
.const [46] = Utf8 isDebug2 
.const [47] = Utf8 ()Z 
.const [48] = Utf8 de/audi/atip/log/LogChannel 
.const [49] = Utf8 log 
.const [50] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [51] = Utf8 org/dsi/ifc/search/SearchResult 
.const [52] = Utf8 getEntryType 
.const [53] = Utf8 ()I 
.const [54] = Utf8 de/audi/app/media/evo/content/data/search/MediaGlobalSearchResultFormatter 
.const [55] = Utf8 setFormatterType 
.const [56] = Utf8 (I)V 
.const [57] = Utf8 de/audi/app/media/evo/content/data/search/MediaSearchResultFormatter 
.const [58] = Utf8 <init> 
.const [59] = Utf8 (Lde/audi/atip/log/LogChannel;II)V 
.const [60] = Utf8 de/audi/app/media/evo/content/data/search/MediaSearchResultFormatter 
.const [61] = Utf8 formatResult 
.const [62] = Utf8 (Lorg/dsi/ifc/search/SearchResult;)Lde/audi/atip/search/util/SearchResultListRow; 
.const [63] = Utf8 de/audi/app/media/evo/content/data/search/MediaGlobalSearchResultFormatter 
.const [64] = Class [63] 
.const [65] = Utf8 de/audi/app/media/evo/content/data/search/MediaSearchResultFormatter 
.const [66] = Class [65] 
.const [67] = Utf8 LOGCLASS 
.const [68] = Utf8 Ljava/lang/String; 
.const [69] = Utf8 Code 
.const [70] = Utf8 <init> 
.const [71] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [72] = Utf8 formatResult 
.const [73] = Utf8 (Lorg/dsi/ifc/search/SearchResult;)Lde/audi/atip/search/util/SearchResultListRow; 
.const [74] = Utf8 setLayout 
.const [75] = Utf8 (I)V 
.end class 
