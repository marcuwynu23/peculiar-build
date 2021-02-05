@echo off
set EDIR=%1
set MDIR=%2
set EDITOR=%3
::set Color
set COLOR=%4
set COLOR_ERROR=4
set WDIR=%MDIR%\C#Projects
set APPLICATION_TITLE=C# Project Builder
title %APPLICATION_TITLE%
mkdir %WDIR% 
:main
	cd %WDIR%
	color %COLOR%
	cls
	echo C# Project Automation:
	echo commands:                              
	echo.
	echo ff     Find Files/Folders   
	echo ctp    Create Project       
	echo ctj    Create Java File     
	echo rc     Recompile Project    
	echo xr     Explore Project      
	echo sqt3   Open Sqlite Database 
	echo runexe   Run C# Executable     
	echo delp   Delete Project       
	echo delf   Delete File          
	echo lsp    List Projects        
	echo e      Open Editor          
	echo cmd    Open Command Prompt  
	echo.
	set choice=nul
	set /P choice=# enter command: 
		if %choice% == ff     goto find 
		if %choice% == ctp    goto createProject
		if %choice% == ctj    goto createFile
		if %choice% == rc     goto recompile
		if %choice% == xr     goto exploreProject
		if %choice% == runexe goto runExe
		if %choice% == sqt3   goto databaseManager
		if %choice% == delp   goto delproject
		if %choice% == delf   goto delfile
		if %choice% == lsp    goto listproject
		if %choice% == e      goto openEditor
		if %choice% == cmd    goto openCmd
		if %choice% == kill   goto killtask
goto main
:askToReturnToMenu
	set askToMenu=nul
	set /P askToMenu=# back to Menu?[y]: 
	if %askToMenu% == y goto main else (
	goto askToReturnToMenu )

:find
	cls
	color A
	echo.
	set /p object=# folder/file-name: 
	echo Result found for '%object%':
	dir /B /S *%object%*
	echo.
goto askToReturnToMenu

:createProject
	cls
	echo.
	set /p projectname=# project-name: 
	set /p packagename=# main-package: 
	set /p mainclass=# main-class: 
	set /p lib=# class-path [s/space]: 
	set /p dep=# dependencies [s/semicolon]: 
	set extlibm=%BUILDIN_LIB% %lib% 
	set extlib=%BUILDIN_LIB%;%dep% 
	::add code here...


goto askToReturnToMenu

:createFile
	cls
	echo # List of All Files: 
	dir /B /S /AA .
	echo.
	set /p fname=# enter file-name: 
	set /p fpath=# enter file-path:
	echo creating File...
	echo.
	start %EDITOR_CHOICE% %fpath%/%fname%.java
	echo.
goto askToReturnToMenu

:recompile
	cls
	echo.
	echo # Project List:
	echo.
	dir /AD /B /ON /-C
	echo.
	::add code here...


goto askToReturnToMenu

:runExe
	cls
	echo Available Executables:
	echo.
	dir /B /S *exe*
	echo.
	set /p  exe=# executables: 
	%exe%
	echo.
goto askToReturnToMenu

:exploreProject
	set /p proj_name=# project-name: 
	cd %proj_name% && explorer %proj_name%
goto askToReturnToMenu

:databaseManager

goto askToReturnToMenu

:delproject
	echo C# Project List:
	echo. && dir /AD /B /ON /-C && echo.
	set /p proj_name=# project-name: 
	rmdir /S /Q %proj_name%
goto askToReturnToMenu

:delfile
goto askToReturnToMenu

:listproject
	echo C# Project List:
	echo. && dir /AD /B /ON /-C && echo.
goto askToReturnToMenu

:openEditor
	%EDITOR% 
goto main

:openCmd
	start /I cmd .
goto main

