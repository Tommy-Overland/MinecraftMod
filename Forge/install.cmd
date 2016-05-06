@echo off & setlocal

REM // Set up install type, or handle usage inquiries.

if /i -%1- equ -idea- (
    set _flavor=idea
) else if /i -%1- equ -intellij- (
    set _flavor=idea
) else if /i -%1- equ -eclipse- (
    set _flavor=eclipse
) else (
    echo Usage: %0 ^<idea ^| intellij ^| eclipse^>
    echo Select one of the above installation variants.
    exit /b 0
)

REM // Setup

if "%_flavor%" equ "idea" (
    @echo Setting up IntelliJ IDEA.
) else (
    @echo Setting up Eclipse.
)

REM // Make sure we copy over mandatory files for both Eclipse AND IntelliJ
mkdir 2>nul eclipse\.metadata\.plugins\org.eclipse.core.resources\.projects\Minecraft
copy nul eclipse\.metadata\.plugins\org.eclipse.core.resources\.projects\Minecraft\.location
mkdir 2>nul eclipse\.metadata\.plugins\org.eclipse.core.resources\.root
copy 0.tree eclipse\.metadata\.plugins\org.eclipse.core.resources\.root

call gradlew.bat setupDevWorkspace && call gradlew.bat %_flavor%

@echo Done.
REM // Exit without setting error level to capture result from last command.

pause
