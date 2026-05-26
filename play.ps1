# =========================================================================
#                     OOPverse Interactive Runner                          
#               Compile & Run C++ / Java examples instantly               
# =========================================================================

$ErrorActionPreference = "Stop"
$root = Split-Path -Parent $MyInvocation.MyCommand.Path

function Show-Banner {
    Write-Host ""
    Write-Host "  +-------------------------------------------+" -ForegroundColor Cyan
    Write-Host "  |         " -NoNewline -ForegroundColor Cyan
    Write-Host "OOPverse Runner" -NoNewline -ForegroundColor Yellow
    Write-Host "                |" -ForegroundColor Cyan
    Write-Host "  |    C++ & Java - Learn by Running Code     |" -ForegroundColor Cyan
    Write-Host "  +-------------------------------------------+" -ForegroundColor Cyan
    Write-Host ""
}

function Get-Modules {
    return Get-ChildItem $root -Directory |
        Where-Object { $_.Name -match '^\d{2}_' } |
        Sort-Object Name
}

function Show-Menu {
    param([string]$Title, [string[]]$Options)
    Write-Host "  $Title" -ForegroundColor Yellow
    Write-Host "  $('-' * 50)" -ForegroundColor DarkGray
    for ($i = 0; $i -lt $Options.Count; $i++) {
        Write-Host "    [$($i+1)] " -NoNewline -ForegroundColor Green
        Write-Host $Options[$i]
    }
    Write-Host "    [0] " -NoNewline -ForegroundColor Red
    Write-Host "Back / Exit"
    Write-Host ""
    $choice = Read-Host "  Enter choice"
    return [int]$choice
}

function Run-CppFile {
    param([string]$FilePath)
    $outFile = [System.IO.Path]::ChangeExtension($FilePath, $null).TrimEnd('.') + ".exe"
    Write-Host ""
    Write-Host "  Compiling..." -ForegroundColor DarkGray
    & g++ -std=c++17 -o $outFile $FilePath 2>&1
    if ($LASTEXITCODE -ne 0) {
        Write-Host "  Compilation FAILED" -ForegroundColor Red
        return
    }
    Write-Host "  --- Output -----------------------------------" -ForegroundColor Cyan
    & $outFile
    Write-Host ""
    Write-Host "  ---------------------------------------------" -ForegroundColor Cyan
    Remove-Item $outFile -ErrorAction SilentlyContinue
}

function Run-JavaFile {
    param([string]$FilePath)
    $dir = Split-Path $FilePath -Parent
    $fileName = Split-Path $FilePath -Leaf
    $className = [System.IO.Path]::GetFileNameWithoutExtension($fileName)
    Write-Host ""
    Write-Host "  Compiling..." -ForegroundColor DarkGray
    Push-Location $dir
    & javac $fileName 2>&1
    if ($LASTEXITCODE -ne 0) {
        Write-Host "  Compilation FAILED" -ForegroundColor Red
        Pop-Location
        return
    }
    Write-Host "  --- Output -----------------------------------" -ForegroundColor Cyan
    & java $className
    Write-Host ""
    Write-Host "  ---------------------------------------------" -ForegroundColor Cyan
    Get-ChildItem $dir -Filter "*.class" | Remove-Item -ErrorAction SilentlyContinue
    Pop-Location
}

# --- Main Loop ---------------------------------------------------------------

Clear-Host
Show-Banner

while ($true) {
    $modules = Get-Modules
    $moduleNames = $modules | ForEach-Object { $_.Name -replace '_', ' ' }
    $choice = Show-Menu -Title "Select a Module" -Options $moduleNames

    if ($choice -eq 0 -or $choice -gt $modules.Count) { break }
    $selectedModule = $modules[$choice - 1]

    # Language selection
    $cppExists  = Test-Path (Join-Path $selectedModule.FullName "cpp")
    $javaExists = Test-Path (Join-Path $selectedModule.FullName "java")
    $langs = @()
    if ($cppExists)  { $langs += "C++" }
    if ($javaExists) { $langs += "Java" }

    if ($langs.Count -eq 0) {
        Write-Host "  No source files found in this module." -ForegroundColor Red
        continue
    }

    Write-Host ""
    $langChoice = Show-Menu -Title "Select Language" -Options $langs
    if ($langChoice -eq 0 -or $langChoice -gt $langs.Count) { continue }

    $lang = $langs[$langChoice - 1]
    $subDir = if ($lang -eq "C++") { "cpp" } else { "java" }
    $ext    = if ($lang -eq "C++") { "*.cpp" } else { "*.java" }
    $langDir = Join-Path $selectedModule.FullName $subDir

    $files = Get-ChildItem $langDir -Filter $ext | Sort-Object Name
    if ($files.Count -eq 0) {
        Write-Host "  No $ext files found." -ForegroundColor Red
        continue
    }

    $fileNames = $files | ForEach-Object { $_.Name }
    Write-Host ""
    $fileChoice = Show-Menu -Title "Select File to Run" -Options $fileNames
    if ($fileChoice -eq 0 -or $fileChoice -gt $files.Count) { continue }

    $selectedFile = $files[$fileChoice - 1].FullName

    if ($lang -eq "C++") {
        Run-CppFile -FilePath $selectedFile
    } else {
        Run-JavaFile -FilePath $selectedFile
    }

    Write-Host ""
    Write-Host "  Press any key to continue..." -ForegroundColor DarkGray
    $null = $Host.UI.RawUI.ReadKey("NoEcho,IncludeKeyDown")
    Clear-Host
    Show-Banner
}

Write-Host ""
Write-Host "  Goodbye! Happy coding!" -ForegroundColor Green
Write-Host ""
