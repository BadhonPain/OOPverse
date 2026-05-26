#!/usr/bin/env bash
# =========================================================================
#                     OOPverse Interactive Runner                          
#               Compile & Run C++ / Java examples instantly               
# =========================================================================

set -e
ROOT="$(cd "$(dirname "$0")" && pwd)"

CYAN='\033[0;36m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
RED='\033[0;31m'
DIM='\033[2m'
RESET='\033[0m'

show_banner() {
    echo ""
    echo -e "${CYAN}  +-------------------------------------------+${RESET}"
    echo -e "${CYAN}  |         ${YELLOW}OOPverse Runner${CYAN}                |${RESET}"
    echo -e "${CYAN}  |    C++ & Java - Learn by Running Code    |${RESET}"
    echo -e "${CYAN}  +-------------------------------------------+${RESET}"
    echo ""
}

show_menu() {
    local title="$1"
    shift
    local options=("$@")

    echo -e "  ${YELLOW}${title}${RESET}"
    echo -e "  ${DIM}$(printf '─%.0s' {1..50})${RESET}"

    for i in "${!options[@]}"; do
        echo -e "    ${GREEN}[$((i+1))]${RESET} ${options[$i]}"
    done
    echo -e "    ${RED}[0]${RESET} Back / Exit"
    echo ""
    read -rp "  Enter choice: " choice
    echo "$choice"
}

run_cpp() {
    local file="$1"
    local out="${file%.cpp}"
    echo ""
    echo -e "  ${DIM}Compiling...${RESET}"
    if ! g++ -std=c++17 -o "$out" "$file" 2>&1; then
        echo -e "  ${RED}Compilation FAILED${RESET}"
        return
    fi
    echo -e "  ${CYAN}--- Output -----------------------------------${RESET}"
    "$out"
    echo ""
    echo -e "  ${CYAN}---------------------------------------------${RESET}"
    rm -f "$out"
}

run_java() {
    local file="$1"
    local dir
    dir="$(dirname "$file")"
    local filename
    filename="$(basename "$file")"
    local classname="${filename%.java}"
    echo ""
    echo -e "  ${DIM}Compiling...${RESET}"
    pushd "$dir" > /dev/null
    if ! javac "$filename" 2>&1; then
        echo -e "  ${RED}Compilation FAILED${RESET}"
        popd > /dev/null
        return
    fi
    echo -e "  ${CYAN}--- Output -----------------------------------${RESET}"
    java "$classname"
    echo ""
    echo -e "  ${CYAN}---------------------------------------------${RESET}"
    rm -f "$dir"/*.class
    popd > /dev/null
}

# --- Main Loop ------------------------------------------------------------

clear
show_banner

while true; do
    mapfile -t modules < <(find "$ROOT" -maxdepth 1 -type d -name '[0-9][0-9]_*' | sort)

    if [ ${#modules[@]} -eq 0 ]; then
        echo -e "  ${RED}No modules found.${RESET}"
        exit 1
    fi

    mod_names=()
    for m in "${modules[@]}"; do
        name="$(basename "$m")"
        mod_names+=("${name//_/ }")
    done

    choice=$(show_menu "Select a Module" "${mod_names[@]}")
    [[ "$choice" == "0" || -z "$choice" ]] && break
    (( choice < 1 || choice > ${#modules[@]} )) && break

    selected="${modules[$((choice-1))]}"

    langs=()
    [[ -d "$selected/cpp" ]]  && langs+=("C++")
    [[ -d "$selected/java" ]] && langs+=("Java")

    if [ ${#langs[@]} -eq 0 ]; then
        echo -e "  ${RED}No source files found.${RESET}"
        continue
    fi

    echo ""
    lang_choice=$(show_menu "Select Language" "${langs[@]}")
    [[ "$lang_choice" == "0" || -z "$lang_choice" ]] && continue

    lang="${langs[$((lang_choice-1))]}"
    if [ "$lang" = "C++" ]; then
        subdir="cpp"; ext="cpp"
    else
        subdir="java"; ext="java"
    fi

    mapfile -t files < <(find "$selected/$subdir" -maxdepth 1 -name "*.$ext" -type f | sort)

    if [ ${#files[@]} -eq 0 ]; then
        echo -e "  ${RED}No .$ext files found.${RESET}"
        continue
    fi

    file_names=()
    for f in "${files[@]}"; do
        file_names+=("$(basename "$f")")
    done

    echo ""
    file_choice=$(show_menu "Select File to Run" "${file_names[@]}")
    [[ "$file_choice" == "0" || -z "$file_choice" ]] && continue
    (( file_choice < 1 || file_choice > ${#files[@]} )) && continue

    selected_file="${files[$((file_choice-1))]}"

    if [ "$lang" = "C++" ]; then
        run_cpp "$selected_file"
    else
        run_java "$selected_file"
    fi

    echo ""
    echo -e "  ${DIM}Press Enter to continue...${RESET}"
    read -r
    clear
    show_banner
done

echo ""
echo -e "  ${GREEN}Goodbye! Happy coding!${RESET}"
echo ""
