//# jakka351's upgrade version of bigunclemax's kzbtools
//# now allows for repacking of a kzbfile
// kzbTools.cpp  — combined extractor + repacker
// Adds: `pack` mode that rebuilds a .kzb from an extracted tree.
//
// Usage:
//   Unpack:                     ./kzbTools <input.kzb>
//   Unpack to chosen directory: ./kzbTools unpack <input.kzb> <output_dir>
//   Pack generic KZB tree:      ./kzbTools pack <extracted_dir> <output.kzb>
//   Repack original KZB:        ./kzbTools pack <original.kzb> <extracted_dir> <output.kzb>
//
// Notes/assumptions (match your extractor):
// - KZB metadata starts at 0x4C; bytes [0..0x3] must NOT equal "KZBF" or the tool will go KZBF path.
// - All KZB integers in headers are big-endian (extractor uses ntoh*).
// - Each resource blob in KZB has a 4-byte prefix (ignored by extractor), then payload.
// - Leaf folder: count==0, followed by elem_count and elements.
// - Non-leaf: count==num_subfolders, then subfolders; if folder has elements too, an elem_count + elements block follows.
// - Folder.size is set to sum of contained resource blob sizes (including each 4-byte prefix).
//
// Generic pack caveats:
// - Unknown fields (unk1/2 on elements, unk1..3 on root) are written as 0.
// - Root header: we write rootName, unk1..3=0, zero=0, count=#top-level folders.
//
// You still need utils.h/.cpp providing FTUtils::{fileToVector,bufferToFile,escape_path}.

#include <iostream>
#include <fstream>
#include <algorithm>
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

struct KZB_ResourceRef {
    fs::path relative_path;
    std::string name;
    uint32_t address;
    uint32_t size;
    size_t address_pos;
    size_t size_pos;
};

bool G_extract = true;
fs::path G_extract_path;
int G_idx = 0x4c;
std::vector<uint8_t> G_bin;
std::vector<KZB_ResourceRef> G_resources;

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
        size_t address_pos = G_idx;
        element.addr = ntohl(*(uint32_t*)&G_bin[G_idx]); G_idx+=4;
        size_t size_pos = G_idx;
        element.size = ntohl(*(uint32_t*)&G_bin[G_idx]); G_idx+=4;
        element.unk1 = ntohl(*(uint32_t*)&G_bin[G_idx]); G_idx+=4;
        element.unk2 = ntohl(*(uint32_t*)&G_bin[G_idx]); G_idx+=4;

        uint16_t str_sz = ntohs(*(uint16_t*)&G_bin[G_idx]); G_idx+=2;
        string name((char*)&G_bin[G_idx], (char*)&G_bin[G_idx] + str_sz);
        element.name = name;
        G_idx += str_sz; align_idx4();

        auto file_path = fs::path(prefix) / FTUtils::escape_path(element.name);
        G_resources.push_back({FTUtils::escape_path(file_path), element.name,
                       element.addr, element.size, address_pos, size_pos});

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
        G_idx += 4;
        if (elem_count) {
            parseElements(folder_path, elem_count, depth+1);
        }
    }
    return folder.size;
}

void parse_kzb(const fs::path &in_file) {
    if (G_bin.size() >= 0x46) {
        uint32_t direct_count = ntohl(*(uint32_t*)&G_bin[0x3c]);
        auto has_folder_record = [](const std::vector<uint8_t> &data, size_t offset) {
            if (offset + 6 > data.size()) return false;
            uint32_t size = ntohl(*(uint32_t*)&data[offset]);
            uint16_t name_size = ntohs(*(uint16_t*)&data[offset + 4]);
            if (size == 0 || size > data.size() || name_size == 0 ||
                offset + 6 + name_size > data.size()) return false;
            for (uint16_t i = 0; i < name_size; ++i) {
                uint8_t ch = data[offset + 6 + i];
                if (ch < 0x20 || ch > 0x7e) return false;
            }
            return true;
        };

        if (direct_count > 0 && direct_count <= (G_bin.size() - 0x40) / 12 &&
            has_folder_record(G_bin, 0x40)) {
            G_idx = 0x40;
            printf("KZB folders:\n");
            for (uint32_t i = 0; i < direct_count; ++i) {
                if (!has_folder_record(G_bin, G_idx)) {
                    printf("Stopped at invalid folder record 0x%x\n", G_idx);
                    break;
                }
                parseFolder("", 1);
            }
            printf("End at 0x%x\n", G_idx);
            return;
        }
    }

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

static uint16_t read_u16_be_at(const std::vector<uint8_t> &data, size_t offset) {
    uint16_t value;
    memcpy(&value, &data[offset], sizeof(value));
    return ntohs(value);
}

static uint32_t read_u32_be_at(const std::vector<uint8_t> &data, size_t offset) {
    uint32_t value;
    memcpy(&value, &data[offset], sizeof(value));
    return ntohl(value);
}

static bool write_u32_be_at(std::vector<uint8_t> &data, size_t offset, uint32_t value) {
    if (offset + sizeof(value) > data.size()) return false;
    value = htonl(value);
    memcpy(&data[offset], &value, sizeof(value));
    return true;
}

static bool is_png_resource(const std::string &name) {
    return name.size() >= 4 && name.compare(name.size() - 4, 4, ".png") == 0;
}

static bool strip_unsupported_png_chunks(std::vector<uint8_t> &png, bool &stripped) {
    static const uint8_t signature[] = {0x89, 'P', 'N', 'G', 0x0d, 0x0a, 0x1a, 0x0a};
    if (png.size() < sizeof(signature) ||
        !std::equal(std::begin(signature), std::end(signature), png.begin())) return false;

    std::vector<uint8_t> clean(png.begin(), png.begin() + sizeof(signature));
    size_t offset = sizeof(signature);
    bool has_ihdr = false;
    bool has_idat = false;
    bool has_iend = false;
    stripped = false;
    while (offset + 12 <= png.size()) {
        uint32_t chunk_size = read_u32_be_at(png, offset);
        if (chunk_size > png.size() - offset - 12) return false;
        const uint8_t *type = &png[offset + 4];
        bool keep = memcmp(type, "IHDR", 4) == 0 || memcmp(type, "PLTE", 4) == 0 ||
                    memcmp(type, "IDAT", 4) == 0 || memcmp(type, "IEND", 4) == 0 ||
                    memcmp(type, "tRNS", 4) == 0;
        if (keep) clean.insert(clean.end(), png.begin() + offset,
                               png.begin() + offset + chunk_size + 12);
        else stripped = true;
        has_ihdr |= memcmp(type, "IHDR", 4) == 0;
        has_idat |= memcmp(type, "IDAT", 4) == 0;
        offset += chunk_size + 12;
        if (memcmp(type, "IEND", 4) == 0) {
            has_iend = true;
            break;
        }
    }
    if (!has_ihdr || !has_idat || !has_iend || offset != png.size()) return false;
    png.swap(clean);
    return true;
}

static int pack_original_kzb(const fs::path &original_file,
                             const fs::path &extracted_dir,
                             const fs::path &output_file)
{
    if (!fs::is_regular_file(original_file) || !fs::is_directory(extracted_dir)) {
        cerr << "Pack: original KZB or extracted directory not found.\n";
        return 2;
    }
    if (original_file.lexically_normal() == output_file.lexically_normal()) {
        cerr << "Pack: output must not overwrite the original KZB.\n";
        return 2;
    }

    G_bin = FTUtils::fileToVector(original_file);
    if (G_bin.size() < 4 || memcmp(G_bin.data(), FZBF_sign, 4) == 0) {
        cerr << "Pack: archive-aware repack currently supports KZB, not KZBF.\n";
        return 2;
    }

    G_resources.clear();
    G_extract = false;
    G_idx = 0;
    parse_kzb(original_file);
    G_extract = true;

    size_t file_count = 0;
    for (const auto &entry : fs::recursive_directory_iterator(extracted_dir)) {
        if (entry.is_regular_file() && entry.path().filename() != ".DS_Store") ++file_count;
    }
    if (file_count != G_resources.size()) {
        cerr << "Pack: extracted file count mismatch (expected " << G_resources.size()
             << ", found " << file_count << ").\n";
        return 3;
    }

    std::vector<std::vector<uint8_t>> contents(G_resources.size());
    std::vector<uint32_t> new_sizes(G_resources.size());
    std::vector<size_t> address_order(G_resources.size());
    for (size_t i = 0; i < G_resources.size(); ++i) address_order[i] = i;

    for (size_t i = 0; i < G_resources.size(); ++i) {
        const auto &resource = G_resources[i];
        fs::path resource_file = extracted_dir / resource.relative_path;
        if (!fs::is_regular_file(resource_file)) {
            cerr << "Pack: missing resource: " << resource_file << "\n";
            return 3;
        }

        ifstream input(resource_file, ios::binary);
        if (!input) {
            cerr << "Pack: cannot read resource: " << resource_file << "\n";
            return 3;
        }
        contents[i] = vector<uint8_t>((istreambuf_iterator<char>(input)), istreambuf_iterator<char>());
        if (is_png_resource(resource.name)) {
            bool stripped = false;
            if (!strip_unsupported_png_chunks(contents[i], stripped)) {
                cerr << "Pack: invalid PNG resource: " << resource_file << "\n";
                return 3;
            }
            if (stripped) cout << "Stripped unsupported PNG metadata from " << resource.name << "\n";
        }
        if (contents[i].size() > UINT32_MAX) {
            cerr << "Pack: resource is too large: " << resource_file << "\n";
            return 3;
        }
        new_sizes[i] = static_cast<uint32_t>(contents[i].size());
    }

    std::sort(address_order.begin(), address_order.end(), [](size_t left, size_t right) {
        return G_resources[left].address < G_resources[right].address;
    });

    size_t data_start = G_bin.size();
    size_t previous_end = 0;
    for (size_t index : address_order) {
        const auto &resource = G_resources[index];
        uint64_t resource_end = static_cast<uint64_t>(resource.address) + 4 + resource.size;
        if (resource.address < previous_end || resource_end > G_bin.size()) {
            cerr << "Pack: overlapping or out-of-range resource " << resource.name << "\n";
            return 3;
        }
        data_start = std::min(data_start, static_cast<size_t>(resource.address));
        previous_end = static_cast<size_t>(resource_end);
    }
    if (address_order.empty() || data_start >= G_bin.size()) {
        cerr << "Pack: archive contains no resource data.\n";
        return 3;
    }

    std::vector<size_t> texture_descriptors(G_resources.size(), std::string::npos);
    for (size_t i = 0; i < G_resources.size(); ++i) {
        const auto &resource = G_resources[i];
        if (!is_png_resource(resource.name)) continue;
        size_t match = std::string::npos;
        for (size_t name_pos = 18; name_pos + resource.name.size() <= data_start; ++name_pos) {
            if (memcmp(&G_bin[name_pos], resource.name.data(), resource.name.size()) != 0) continue;
            size_t descriptor = name_pos - 18;
            if (read_u16_be_at(G_bin, descriptor + 16) != resource.name.size() ||
                read_u32_be_at(G_bin, descriptor) != resource.address ||
                read_u32_be_at(G_bin, descriptor + 4) != resource.size ||
                read_u32_be_at(G_bin, descriptor + 8) != 10) continue;
            if (match != std::string::npos) {
                cerr << "Pack: ambiguous texture descriptor for " << resource.name << "\n";
                return 3;
            }
            match = descriptor;
        }
        texture_descriptors[i] = match;
    }

    std::vector<uint32_t> new_addresses(G_resources.size());
    bool fits_original_slots = true;
    for (size_t i = 0; i < G_resources.size(); ++i) {
        fits_original_slots &= new_sizes[i] <= G_resources[i].size;
    }

    std::vector<uint8_t> output;
    if (fits_original_slots) {
        output = G_bin;
        for (size_t i = 0; i < G_resources.size(); ++i) {
            const auto &resource = G_resources[i];
            size_t payload = resource.address + sizeof(uint32_t);
            std::copy(contents[i].begin(), contents[i].end(), output.begin() + payload);
            std::fill(output.begin() + payload + new_sizes[i],
                      output.begin() + payload + resource.size, 0);
            new_addresses[i] = resource.address;
        }
    } else {
        output.assign(G_bin.begin(), G_bin.begin() + data_start);
        size_t old_cursor = data_start;
        for (size_t index : address_order) {
            const auto &resource = G_resources[index];
            if (resource.address > old_cursor) {
                output.insert(output.end(), G_bin.begin() + old_cursor,
                              G_bin.begin() + resource.address);
            }
            new_addresses[index] = static_cast<uint32_t>(output.size());
            output.insert(output.end(), G_bin.begin() + resource.address,
                          G_bin.begin() + resource.address + 4);
            output.insert(output.end(), contents[index].begin(), contents[index].end());
            old_cursor = resource.address + 4 + resource.size;
        }
        output.insert(output.end(), G_bin.begin() + old_cursor, G_bin.end());
    }

    if (output.size() > UINT32_MAX) {
        cerr << "Pack: rebuilt archive exceeds the KZB size limit.\n";
        return 3;
    }
    for (size_t i = 0; i < G_resources.size(); ++i) {
        const auto &resource = G_resources[i];
        if (!write_u32_be_at(output, resource.address_pos, new_addresses[i]) ||
            !write_u32_be_at(output, resource.size_pos, new_sizes[i])) {
            cerr << "Pack: resource metadata offset is invalid.\n";
            return 3;
        }
        if (texture_descriptors[i] != std::string::npos &&
            (!write_u32_be_at(output, texture_descriptors[i], new_addresses[i]) ||
             !write_u32_be_at(output, texture_descriptors[i] + 4, new_sizes[i]))) {
            cerr << "Pack: texture descriptor offset is invalid.\n";
            return 3;
        }
    }

    if (!write_u32_be_at(output, 4, static_cast<uint32_t>(output.size()))) {
        cerr << "Pack: cannot update KZB size header.\n";
        return 3;
    }

    ofstream out_file(output_file, ios::binary);
    if (!out_file) {
        cerr << "Pack: cannot create output archive: " << output_file << "\n";
        return 4;
    }
    out_file.write(reinterpret_cast<const char*>(output.data()), output.size());
    if (!out_file) {
        cerr << "Pack: failed while writing output archive.\n";
        return 4;
    }
    cout << "Repacked " << G_resources.size() << " resources to " << output_file
         << " (" << output.size() << " bytes)\n";
    return 0;
}

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
        for (const auto &child : n.children) collectSizes(child);
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
    uint32_t total_size_be = htonl(static_cast<uint32_t>(out.size()));
    memcpy(&out[4], &total_size_be, sizeof(total_size_be));

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
                  << argv[0] << " unpack <input.kzb> <output_dir>\n  "
                  << argv[0] << " pack <extracted_dir> <output.kzb>\n  "
                  << argv[0] << " pack <original.kzb> <extracted_dir> <output.kzb>\n";
        return 1;
    }

    // PACK MODE
    if (std::string(argv[1]) == "pack") {
        if (argc == 4) {
            fs::path in_dir = fs::absolute(argv[2]);
            fs::path out_kzb = fs::absolute(argv[3]);
            return pack_kzb(in_dir, out_kzb);
        }
        if (argc == 5) {
            fs::path original = fs::absolute(argv[2]);
            fs::path in_dir = fs::absolute(argv[3]);
            fs::path out_kzb = fs::absolute(argv[4]);
            return pack_original_kzb(original, in_dir, out_kzb);
        }
        std::cerr << "Pack usage:\n  " << argv[0] << " pack <extracted_dir> <output.kzb>\n  "
                  << argv[0] << " pack <original.kzb> <extracted_dir> <output.kzb>\n";
        return 1;
    }

    bool explicit_unpack = std::string(argv[1]) == "unpack";
    if (explicit_unpack && argc != 4) {
        std::cerr << "Unpack usage: " << argv[0] << " unpack <input.kzb> <output_dir>\n";
        return 1;
    }

    auto in_file = fs::absolute(fs::path(argv[explicit_unpack ? 2 : 1]));
    if (explicit_unpack) {
        G_extract_path = fs::absolute(fs::path(argv[3]));
    } else {
        G_extract_path = in_file.parent_path()/(in_file.filename().string()+"_unpacked");
    }
    fs::create_directories(G_extract_path);

    G_idx = 0;
    G_resources.clear();
    G_extract = true;
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
