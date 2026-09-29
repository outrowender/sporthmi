.version 50 0 
.class public super [75] 
.super [77] 
.field private [78] [79] 
.field private [80] [81] 

.method public [83] : [84] 
    .attribute [82] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [18] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [19] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [85] : [86] 
    .attribute [82] .code stack 5 locals 0 
L0:     aload_1 
L1:     ifnonnull L19 
L4:     aload_0 
L5:     getfield [11] 
L8:     sipush 10000 
L11:    ldc [2] 
L13:    invokevirtual [13] 
L16:    pop 
L17:    aconst_null 
L18:    areturn 
L19:    aload_0 
L20:    getfield [11] 
L23:    ldc [3] 
L25:    ldc [4] 
L27:    aload_1 
L28:    invokevirtual [14] 
L31:    pop 
L32:    new [20] 
L35:    dup 
L36:    aload_1 
L37:    aload_0 
L38:    getfield [12] 
L41:    invokevirtual [15] 
L44:    ldc [6] 
L46:    invokespecial [17] 
L49:    areturn 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [21] 
.const [3] = Int -2137614336 
.const [4] = String [22] 
.const [5] = Class [23] 
.const [6] = Int 387465769 
.const [7] = Class [24] 
.const [8] = Class [25] 
.const [9] = Class [26] 
.const [10] = Class [27] 
.const [11] = Field [28] [29] 
.const [12] = Field [30] [31] 
.const [13] = Method [32] [33] 
.const [14] = Method [34] [35] 
.const [15] = Method [36] [37] 
.const [16] = Method [38] [39] 
.const [17] = Method [40] [41] 
.const [18] = Field [42] [43] 
.const [19] = Field [44] [45] 
.const [20] = Class [46] 
.const [21] = Utf8 'AddressBookEvoSearchResultFormatter#formatResult(): result is null' 
.const [22] = Utf8 'AddressBookEvoSearchResultFormatter#formatResult(): result: %1' 
.const [23] = Utf8 de/audi/app/addressbook/evo/common/search/truffles/ADBEvoTruffleSearchListRow 
.const [24] = Utf8 de/audi/app/addressbook/evo/main/search/truffles/AddressBookEvoSearchResultFormatter 
.const [25] = Utf8 de/audi/atip/search/util/AbstractSearchResultFormatter 
.const [26] = Utf8 de/audi/atip/log/LogChannel 
.const [27] = Utf8 de/audi/app/addressbook/evo/main/AddressBookEvoApplication 
.const [28] = Class [47] 
.const [29] = NameAndType [48] [49] 
.const [30] = Class [50] 
.const [31] = NameAndType [51] [52] 
.const [32] = Class [53] 
.const [33] = NameAndType [54] [55] 
.const [34] = Class [56] 
.const [35] = NameAndType [57] [58] 
.const [36] = Class [59] 
.const [37] = NameAndType [60] [61] 
.const [38] = Class [62] 
.const [39] = NameAndType [63] [64] 
.const [40] = Class [65] 
.const [41] = NameAndType [66] [67] 
.const [42] = Class [68] 
.const [43] = NameAndType [69] [70] 
.const [44] = Class [71] 
.const [45] = NameAndType [72] [73] 
.const [46] = Utf8 de/audi/app/addressbook/evo/common/search/truffles/ADBEvoTruffleSearchListRow 
.const [47] = Utf8 de/audi/app/addressbook/evo/main/search/truffles/AddressBookEvoSearchResultFormatter 
.const [48] = Utf8 log 
.const [49] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [50] = Utf8 de/audi/app/addressbook/evo/main/search/truffles/AddressBookEvoSearchResultFormatter 
.const [51] = Utf8 appAdr 
.const [52] = Utf8 Lde/audi/app/addressbook/evo/main/AddressBookEvoApplication; 
.const [53] = Utf8 de/audi/atip/log/LogChannel 
.const [54] = Utf8 log 
.const [55] = Utf8 (ILjava/lang/String;)Z 
.const [56] = Utf8 de/audi/atip/log/LogChannel 
.const [57] = Utf8 log 
.const [58] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [59] = Utf8 de/audi/app/addressbook/evo/main/AddressBookEvoApplication 
.const [60] = Utf8 getAdbMode 
.const [61] = Utf8 ()I 
.const [62] = Utf8 de/audi/atip/search/util/AbstractSearchResultFormatter 
.const [63] = Utf8 <init> 
.const [64] = Utf8 ()V 
.const [65] = Utf8 de/audi/app/addressbook/evo/common/search/truffles/ADBEvoTruffleSearchListRow 
.const [66] = Utf8 <init> 
.const [67] = Utf8 (Lorg/dsi/ifc/search/SearchResult;II)V 
.const [68] = Utf8 de/audi/app/addressbook/evo/main/search/truffles/AddressBookEvoSearchResultFormatter 
.const [69] = Utf8 log 
.const [70] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [71] = Utf8 de/audi/app/addressbook/evo/main/search/truffles/AddressBookEvoSearchResultFormatter 
.const [72] = Utf8 appAdr 
.const [73] = Utf8 Lde/audi/app/addressbook/evo/main/AddressBookEvoApplication; 
.const [74] = Utf8 de/audi/app/addressbook/evo/main/search/truffles/AddressBookEvoSearchResultFormatter 
.const [75] = Class [74] 
.const [76] = Utf8 de/audi/atip/search/util/AbstractSearchResultFormatter 
.const [77] = Class [76] 
.const [78] = Utf8 log 
.const [79] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [80] = Utf8 appAdr 
.const [81] = Utf8 Lde/audi/app/addressbook/evo/main/AddressBookEvoApplication; 
.const [82] = Utf8 Code 
.const [83] = Utf8 <init> 
.const [84] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/app/addressbook/evo/main/AddressBookEvoApplication;)V 
.const [85] = Utf8 formatResult 
.const [86] = Utf8 (Lorg/dsi/ifc/search/SearchResult;)Lde/audi/atip/search/util/SearchResultListRow; 
.end class 
