//# jakka351's upgrade version of bigunclemax's kzbtools
//# now allows for repacking of a kzbfile
// kzbTools.cpp  — combined extractor + repacker
// Adds: `pack` mode that rebuilds a .kzb from an extracted tree.
//
// Usage:
//   Unpack (same as original):  ./kzbTools <input.kzb>
//   Pack:                       ./kzbTools pack <extracted_dir> <output.kzb>
//
// Notes/assumptions (match your extractor):
// - KZB metadata starts at 0x4C; bytes [0..0x3] must NOT equal "KZBF" or the tool will go KZBF path.
// - All KZB integers in headers are big-endian (extractor uses ntoh*).
// - Each resource blob in KZB has a 4-byte prefix (ignored by extractor), then payload.
// - Leaf folder: count==0, followed by elem_count and elements.
// - Non-leaf: count==num_subfolders, then subfolders; if folder has elements too, an elem_count + elements block follows.
// - Folder.size is set to sum of contained resource blob sizes (including each 4-byte prefix).
//
// Caveats:
// - Unknown fields (unk1/2 on elements, unk1..3 on root) are written as 0.
// - Root header: we write rootName, unk1..3=0, zero=0, count=#top-level folders.
//
// You still need utils.h/.cpp providing FTUtils::{fileToVector,bufferToFile,escape_path}.

#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <filesystem>
#include <cstdint>
#include <cstring>

#ifdef __linux__
  #include <arpa/inet.h>
#elif _WIN32
  #include <winsock2.h>
  #pragma comment(lib, "Ws2_32.lib")
#endif

#include "utils.h"

namespace fs = std::filesystem;
using namespace std;

const char FZBF_sign[5] = "KZBF";

// -------------------- Original extractor structs & globals --------------------

struct KZB_Root_Folder {
    uint32_t count;
    std::string name;
    uint32_t unk1;
    uint32_t unk2;
    uint32_t unk3;
};

struct KZB_Folder {
    uint32_t size;
    uint32_t count;
    std::string name;
};

struct KZB_Element {
    uint32_t addr;
    uint32_t size;
    uint32_t unk1;
    uint32_t unk2;
    std::string name;
};

bool G_extract = true;
fs::path G_extract_path;
int G_idx = 0x4c;
std::vector<uint8_t> G_bin;

static inline void align_idx4() {
    G_idx = (G_idx % 4) ? (G_idx / 4 + 1) * 4 : G_idx;
}

void extract_resource(const fs::path &resource_path, uint32_t address, uint32_t size) {
    // skip 4-byte per-resource prefix in KZB
    FTUtils::bufferToFile(G_extract_path / resource_path,
                          (const char*)&G_bin[address + sizeof(uint32_t)],
                          size);
}

uint32_t parseElements(const fs::path &prefix, unsigned count, int depth) {
    for (unsigned i = 0; i < count; ++i) {
        KZB_Element element{};
        element.addr = ntohl(*(uint32_t*)&G_bin[G_idx]); G_idx+=4;
        element.size = ntohl(*(uint32_t*)&G_bin[G_idx]); G_idx+=4;
        element.unk1 = ntohl(*(uint32_t*)&G_bin[G_idx]); G_idx+=4;
        element.unk2 = ntohl(*(uint32_t*)&G_bin[G_idx]); G_idx+=4;

        uint16_t str_sz = ntohs(*(uint16_t*)&G_bin[G_idx]); G_idx+=2;
        string name((char*)&G_bin[G_idx], (char*)&G_bin[G_idx] + str_sz);
        element.name = name;
        G_idx += str_sz; align_idx4();

        auto file_path = fs::path(prefix) / FTUtils::escape_path(element.name);

        for (int j = 0; j < depth; ++j) printf("\t");
        printf("File: %s Size: 0x%x(%u) Addr: 0x%x(%u) Unk1: 0x%x Unk2: 0x%x\n",
               element.name.c_str(), element.size, element.size,
               element.addr, element.addr, element.unk1, element.unk2);

        if (G_extract) extract_resource(FTUtils::escape_path(file_path), element.addr, element.size);
    }
    return 0;
}

uint32_t parseFolder(const fs::path &prefix, int depth) {
    KZB_Folder folder{};

    folder.size = ntohl(*(uint32_t*)&G_bin[G_idx]); G_idx+=4;

    uint16_t str_sz = ntohs(*(uint16_t*)&G_bin[G_idx]); G_idx+=2;
    string nm((char*)&G_bin[G_idx], (char*)&G_bin[G_idx] + str_sz);
    folder.name = nm;
    G_idx += str_sz; align_idx4();

    folder.count = ntohl(*(uint32_t*)&G_bin[G_idx]); G_idx+=4;

    bool last_folder = (folder.count == 0);
    if (last_folder) {
        folder.count = ntohl(*(uint32_t*)&G_bin[G_idx]); G_idx+=4;
    }

    auto folder_path = prefix / ("Folder_"+folder.name);

    for (int i = 0; i < depth; ++i) printf("\t");
    printf("Folder: %s Size: 0x%x(%u) Count: 0x%x(%u)\n",
           folder.name.c_str(), folder.size, folder.size, folder.count, folder.count);

    if (G_extract) fs::create_directory(G_extract_path / FTUtils::escape_path(folder_path));

    if (last_folder) {
        parseElements(folder_path, folder.count, depth+1);
    } else {
        for (uint32_t i = 0; i < folder.count; ++i) parseFolder(folder_path, depth+1);
        // optional elements after children
        uint32_t elem_count = ntohl(*(uint32_t*)&G_bin[G_idx]);
        if (elem_count) {
            G_idx += 4;
            parseElements(folder_path, elem_count, depth+1);
        }
    }
    return folder.size;
}

void parse_kzb(const fs::path &in_file) {
    G_idx = 0x4c;

    KZB_Root_Folder root{};
    uint16_t str_sz = ntohs(*(uint16_t*)&G_bin[G_idx]); G_idx+=2;
    root.name.assign((char*)&G_bin[G_idx], (char*)&G_bin[G_idx]+str_sz);
    G_idx+=str_sz; align_idx4();

    root.unk1 = ntohl(*(uint32_t*)&G_bin[G_idx]); G_idx+=4;
    root.unk2 = ntohl(*(uint32_t*)&G_bin[G_idx]); G_idx+=4;
    root.unk3 = ntohl(*(uint32_t*)&G_bin[G_idx]); G_idx+=4;
    auto zero   = ntohl(*(uint32_t*)&G_bin[G_idx]); G_idx+=4;
    root.count = ntohl(*(uint32_t*)&G_bin[G_idx]); G_idx+=4;

    printf("%s:\n", root.name.c_str());
    for (uint32_t i = 0; i < root.count; ++i) parseFolder("", 1);

    printf("End at 0x%x\n", G_idx);
}

#pragma pack(push, 1)
struct KZBF_elem {
    uint32_t idx;
    uint32_t unk1;
    uint32_t addr;
    uint32_t size;
    uint32_t unk4; // always zero
    uint32_t unk5; // duplicate of size
};
#pragma pack(pop)

void extract_resource_kzbf(const fs::path &resource_path, uint32_t address, uint32_t size) {
    auto path = G_extract_path; path += resource_path;
    fs::create_directories(path.parent_path());
    path.replace_filename("r_" + path.filename().string());
    FTUtils::bufferToFile(path, (const char*)&G_bin[address], size);
}

void parse_kzbf(const fs::path &in_file) {
    auto unk = *(uint32_t*)&G_bin[G_idx]; G_idx += 4;

    auto str_sz = *(uint32_t*)&G_bin[G_idx]; G_idx += 4;
    string rootName((char*)&G_bin[G_idx], (char*)&G_bin[G_idx] + str_sz);
    G_idx += str_sz;

    auto count = *(uint32_t*)&G_bin[G_idx]; G_idx += 4;

    vector<string> nodes(count);
    for (uint32_t i = 0; i < count; ++i) {
        while (G_bin[G_idx]) {
            nodes[i] = string((char*)&G_bin[G_idx]);
            G_idx += nodes[i].size();
        }
        G_idx++;
    }

    printf("Nodes count: %zu\n", nodes.size());

    count = *(uint32_t*)&G_bin[G_idx]; G_idx += 4;

    vector<KZBF_elem> elems(count);
    for (uint32_t i = 0; i < count; ++i) {
        elems[i] = *(KZBF_elem*)&G_bin[G_idx];
        G_idx += sizeof(KZBF_elem);
        if (elems[i].unk4) throw std::runtime_error("kzbf: unk4 not zero");
        if (elems[i].unk5 != elems[i].size) throw std::runtime_error("kzbf: unk5 != size");
    }

    printf("Nodes prop count: %zu\n", nodes.size());
    for (size_t i = 0; i < nodes.size(); ++i)
        printf("%04d 0x%08x 0x%08x 0x%08x %s\n",
               elems[i].idx, elems[i].unk1, elems[i].addr, elems[i].size, nodes[i].c_str());

    for (size_t i = 0; i < nodes.size(); ++i) {
        const auto &_node = nodes[i];
        auto res_sz = elems[i].size;
        int local = elems[i].addr;
        if (_node.find(".png") != std::string::npos) {
            local += 5 * sizeof(uint32_t); // skip small header
            if (G_extract) extract_resource_kzbf(FTUtils::escape_path(_node), local, res_sz - (5 * sizeof(uint32_t)));
        } else {
            if (G_extract) extract_resource_kzbf(FTUtils::escape_path(_node), local, res_sz);
        }
    }
}

// -------------------- Repacker (KZB) --------------------

static inline void write_u16_be(std::vector<uint8_t> &buf, uint16_t v) {
    uint16_t be = htons(v);
    buf.insert(buf.end(), (uint8_t*)&be, (uint8_t*)&be + 2);
}
static inline void write_u32_be(std::vector<uint8_t> &buf, uint32_t v) {
    uint32_t be = htonl(v);
    buf.insert(buf.end(), (uint8_t*)&be, (uint8_t*)&be + 4);
}
static inline void write_bytes(std::vector<uint8_t> &buf, const uint8_t* p, size_t n) {
    buf.insert(buf.end(), p, p + n);
}
static inline void align4(std::vector<uint8_t> &buf) {
    size_t r = buf.size() & 3;
    if (r) buf.insert(buf.end(), 4 - r, 0);
}

struct ElementInfo {
    std::string name;
    fs::path disk_path;
    uint32_t size;  // payload size (file size on disk)
};

struct FolderNode {
    std::string name;                 // KZB folder name (no "Folder_" prefix)
    std::vector<FolderNode> children; // subfolders
    std::vector<ElementInfo> elements;// files (leaf or mixed)
};

// Build a FolderNode tree from an extracted directory (as produced by this tool)
static FolderNode build_node_from_fs(const fs::path &p) {
    FolderNode node;
    node.name = p.filename().string();
    const std::string prefix = "Folder_";
    if (node.name.rfind(prefix, 0) == 0) node.name = node.name.substr(prefix.size());

    vector<fs::directory_entry> entries;
    for (auto &e : fs::directory_iterator(p)) entries.push_back(e);
    sort(entries.begin(), entries.end(), [](auto &a, auto &b){
        return a.path().filename().string() < b.path().filename().string();
    });

    for (auto &e : entries) {
        if (e.is_directory()) {
            node.children.push_back(build_node_from_fs(e.path()));
        } else if (e.is_regular_file()) {
            ElementInfo el;
            el.disk_path = e.path();
            el.name = e.path().filename().string();
            el.size = (uint32_t)fs::file_size(e.path());
            node.elements.push_back(el);
        }
    }
    return node;
}

static uint32_t compute_total_data_size(const FolderNode &node) {
    uint32_t total = 0;
    for (const auto &el : node.elements) total += 4 + el.size; // 4-byte prefix + payload
    for (const auto &c : node.children) total += compute_total_data_size(c);
    return total;
}

struct MetaFolderPH { size_t size_pos; };
struct MetaElemPH   { size_t addr_pos; const ElementInfo* el; };

// Preorder traversal to produce same ordering as extractor expects
static void write_folder_metadata(const FolderNode &node,
                                  std::vector<uint8_t> &meta,
                                  std::vector<MetaFolderPH> &folderPH,
                                  std::vector<MetaElemPH> &elemPH)
{
    // folder.size placeholder
    folderPH.push_back({ meta.size() });
    write_u32_be(meta, 0);

    // name (u16 + bytes, 4-byte aligned)
    write_u16_be(meta, (uint16_t)node.name.size());
    write_bytes(meta, (const uint8_t*)node.name.data(), node.name.size());
    align4(meta);

    if (node.children.empty()) {
        // last folder: count == 0 then elem_count + elements
        write_u32_be(meta, 0);
        write_u32_be(meta, (uint32_t)node.elements.size());
        for (const auto &el : node.elements) {
            elemPH.push_back({ meta.size(), &el });
            write_u32_be(meta, 0);                 // addr placeholder
            write_u32_be(meta, el.size);           // size
            write_u32_be(meta, 0);                 // unk1
            write_u32_be(meta, 0);                 // unk2
            write_u16_be(meta, (uint16_t)el.name.size());
            write_bytes(meta, (const uint8_t*)el.name.data(), el.name.size());
            align4(meta);
        }
    } else {
        // non-leaf: count == #children
        write_u32_be(meta, (uint32_t)node.children.size());
        for (const auto &c : node.children) write_folder_metadata(c, meta, folderPH, elemPH);

        if (!node.elements.empty()) {
            write_u32_be(meta, (uint32_t)node.elements.size());
            for (const auto &el : node.elements) {
                elemPH.push_back({ meta.size(), &el });
                write_u32_be(meta, 0);               // addr
                write_u32_be(meta, el.size);         // size
                write_u32_be(meta, 0);               // unk1
                write_u32_be(meta, 0);               // unk2
                write_u16_be(meta, (uint16_t)el.name.size());
                write_bytes(meta, (const uint8_t*)el.name.data(), el.name.size());
                align4(meta);
            }
        }
    }
}

// Root header writer as parse_kzb expects at offset 0x4C:
// [u16 name_len][name][align4][u32 unk1][u32 unk2][u32 unk3][u32 zero][u32 count]
static void write_root_header(const std::string &rootName,
                              uint32_t topCount,
                              std::vector<uint8_t> &meta)
{
    write_u16_be(meta, (uint16_t)rootName.size());
    write_bytes(meta, (const uint8_t*)rootName.data(), rootName.size());
    align4(meta);
    write_u32_be(meta, 0); // unk1
    write_u32_be(meta, 0); // unk2
    write_u32_be(meta, 0); // unk3
    write_u32_be(meta, 0); // zero
    write_u32_be(meta, topCount);
}

// Pack a KZB file from extracted_dir into output_file
static int pack_kzb(const fs::path &extracted_dir, const fs::path &output_file)
{
    if (!fs::exists(extracted_dir) || !fs::is_directory(extracted_dir)) {
        cerr << "Pack: input dir not found or not a directory: " << extracted_dir << "\n";
        return 2;
    }

    // Build synthetic root with its children = each immediate subdir/file
    FolderNode root;
    root.name = extracted_dir.filename().string();

    vector<fs::directory_entry> tops;
    for (auto &e : fs::directory_iterator(extracted_dir)) tops.push_back(e);
    sort(tops.begin(), tops.end(), [](auto &a, auto &b){
        return a.path().filename().string() < b.path().filename().string();
    });

    for (auto &de : tops) {
        if (de.is_directory())      root.children.push_back(build_node_from_fs(de.path()));
        else if (de.is_regular_file()){
            ElementInfo el;
            el.disk_path = de.path();
            el.name = de.path().filename().string();
            el.size = (uint32_t)fs::file_size(de.path());
            root.elements.push_back(el);
        }
    }

    // Compose metadata buffer starting right after header (but we’ll assemble it independently)
    vector<uint8_t> meta;

    // Root header (as parse_kzb expects)
    write_root_header(root.name, (uint32_t)root.children.size() + (root.elements.empty() ? 0u : 1u), meta);

    // Now write top-level folders:
    // - If there are any top-level files, we treat them as a synthetic Folder with the same root name ("mixed" case).
    vector<MetaFolderPH> folderPH;
    vector<MetaElemPH>   elemPH;

    // For each real child directory -> write a folder block
    for (const auto &child : root.children) {
        write_folder_metadata(child, meta, folderPH, elemPH);
    }

    // If the root also has files, we add one synthetic folder representing those files.
    if (!root.elements.empty()) {
        FolderNode synth;
        synth.name = root.name + "_rootfiles";
        synth.children = {};
        synth.elements = root.elements; // copy
        write_folder_metadata(synth, meta, folderPH, elemPH);
    }

    // Compute and patch folder.size (sum of contained resource data incl. prefixes)
    // The order of folderPH matches preorder traversal used above; mirror it to compute sizes in same order.
    // We’ll re-traverse in the same order.
    vector<uint32_t> folderSizes;
    std::function<void(const FolderNode&)> collectSizes = [&](const FolderNode& n){
        folderSizes.push_back(compute_total_data_size(n));
    };
    for (const auto &child : root.children) collectSizes(child);
    if (!root.elements.empty()) {
        FolderNode synth; synth.name = root.name + "_rootfiles"; synth.elements = root.elements;
        folderSizes.push_back(compute_total_data_size(synth));
    }
    if (folderSizes.size() != folderPH.size()) {
        cerr << "Pack: folder placeholder count mismatch ("
             << folderPH.size() << " vs " << folderSizes.size()
             << ") – continuing best-effort.\n";
    }
    size_t nmin = std::min(folderPH.size(), folderSizes.size());
    for (size_t i = 0; i < nmin; ++i) {
        uint32_t be = htonl(folderSizes[i]);
        memcpy(&meta[folderPH[i].size_pos], &be, 4);
    }

    // Layout final file: [0x4C header][meta][align4][data...]
    const uint32_t header_size = 0x4C;
    vector<uint8_t> out(header_size, 0);
    // First 4 bytes must NOT be "KZBF" so extractor chooses KZB path.
    out[0]='k'; out[1]='z'; out[2]='b'; out[3]='f';

    // Append metadata and pad
    out.insert(out.end(), meta.begin(), meta.end());
    while (out.size() & 3) out.push_back(0);

    // Now write resource data and patch element addr fields
    for (const auto &ph : elemPH) {
        // Patch address = absolute offset where this element’s blob starts
        uint32_t addr_abs = (uint32_t)out.size();
        uint32_t be = htonl(addr_abs);
        memcpy(&meta[ph.addr_pos], &be, 4); // also fix in 'out' view
        memcpy(&out[header_size + ph.addr_pos], &be, 4);

        // Write 4-byte prefix (zero)
        uint32_t zero = 0;
        out.insert(out.end(), (uint8_t*)&zero, (uint8_t*)&zero + 4);

        // Append file content
        ifstream ifs(ph.el->disk_path, ios::binary);
        if (!ifs) {
            cerr << "Pack: failed to open resource file: " << ph.el->disk_path << "\n";
            return 3;
        }
        vector<uint8_t> buf((istreambuf_iterator<char>(ifs)), istreambuf_iterator<char>());
        if (buf.size() != ph.el->size) {
            // not fatal, but warn
            cerr << "Pack: size changed while reading " << ph.el->disk_path
                 << " (" << buf.size() << " vs " << ph.el->size << ")\n";
        }
        out.insert(out.end(), buf.begin(), buf.end());
    }

    // Write output
    ofstream ofs(output_file, ios::binary);
    if (!ofs) {
        cerr << "Pack: failed to open output file: " << output_file << "\n";
        return 4;
    }
    ofs.write((char*)out.data(), out.size());
    ofs.close();

    cout << "Packed KZB written: " << output_file << " (" << out.size() << " bytes)\n";
    return 0;
}

// -------------------- main --------------------

int main(int argc, const char* argv[]) {
    if (argc <= 1) {
        std::cerr << "Usage:\n  " << argv[0] << " <input.kzb|kzbf>\n  "
                  << argv[0] << " pack <extracted_dir> <output.kzb>\n";
        return 1;
    }

    // PACK MODE
    if (std::string(argv[1]) == "pack") {
        if (argc != 4) {
            std::cerr << "Pack usage: " << argv[0] << " pack <extracted_dir> <output.kzb>\n";
            return 1;
        }
        fs::path in_dir  = fs::absolute(argv[2]);
        fs::path out_kzb = fs::absolute(argv[3]);
        return pack_kzb(in_dir, out_kzb);
    }

    // UNPACK MODE (original behavior)
    auto in_file = fs::absolute(fs::path(argv[1]));
    G_extract_path = in_file.parent_path()/(in_file.filename().string()+"_unpacked");
    fs::create_directory(G_extract_path);

    G_idx = 0;
    G_bin = FTUtils::fileToVector(in_file);

    char sign[5] = {};
    sign[0] = G_bin[G_idx + 0];
    sign[1] = G_bin[G_idx + 1];
    sign[2] = G_bin[G_idx + 2];
    sign[3] = G_bin[G_idx + 3];
    G_idx += sizeof(uint32_t);

    if (strcmp(sign, FZBF_sign) != 0) parse_kzb(in_file);
    else                               parse_kzbf(in_file);

    return 0;
}
