@echo off
set EDIR=%1
set MDIR=%2
set EDITOR=%3
::set Color
set COLOR=%4
set COLOR_ERROR=4

set WDIR=%MDIR%\KotlinProjects
set APPLICATION_TITLE=Kotlin Project Builder
title %APPLICATION_TITLE%
mkdir %WDIR% 
:main
	cls
	color %COLOR%
	cd %EDIR%
	echo Kotlin Project Automation:
	echo commands:                              
	echo.
	echo ff     Find Files/Folders   
	echo ctp    Create Project       
	echo ctj    Create Java File     
	echo rc     Recompile Project    
	echo xr     Explore Project      
	echo sqt3   Open Sqlite Database 
	echo runj   Run Java Archive     
	echo showj  Show Jar Content     
	echo delp   Delete Project       
	echo delf   Delete File          
	echo lsp    List Projects        
	echo e      Open Editor          
	echo cmd    Open Command Prompt  
	echo.
	set choice=nul
	set /P choice=# enter command: 
		if %choice% == om goto menuOption
goto main
l