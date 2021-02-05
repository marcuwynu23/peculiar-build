@echo off

set EDIR=%1
set MDIR=%2
set EDITOR=%3
::set Color
set COLOR=%4
set COLOR_ERROR=4
set WDIR=%MDIR%\DjangoProjects
set APPLICATION_TITLE=Django Project Builder
title %APPLICATION_TITLE%
mkdir %WDIR% 
:main
	cd %WDIR%
	color %COLOR%
	cls
	echo django project automation:
	echo commands:                              
	echo.
	echo ff     find files/folders   
	echo ctp    create python project       
	echo ctj    create python file         
	echo xr     explore project      
	echo sqt3   open sqlite database
	echo rserv  run server
	echo tweb   test web project
	echo runp   run project      
	echo delp   delete project       
	echo delf   delete file          
	echo lsp    list projects        
	echo e      open editor          
	echo cmd    open command prompt  
	echo.
	set choice=nul
	set /P choice=# enter command: 
		if %choice% == ff   goto findFile
		if %choice% == ctp  goto createProject
		if %choice% == runp goto runProject
		if %choice% == lsp  goto listProject
		if %choice% == xr   goto exploreProject
		if %choice% == delp goto delProject
		if %choice% == delf goto delFile
		if %choice% == e 	goto openEditor
		if %choice% == cmd 	goto openCmd
		if %choice% == sqt3 goto openSQLite
		if %choice% == rserv goto runServer
		if %choice% == tweb  goto testWebsite
goto main
:findFile
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
	set app_name=nul
	set /p proj_name=# project-name: 
	rmdir /Q /S %proj_name% 
	mkdir %proj_name% && cd %proj_name%
	mkdir app  view model controller database test res
	echo This is readme > README.md  && echo  this is Copyright > COPYRIGHT
	echo #init  > app/init.py
	echo #init  > model/init.py
	echo #init  > view/init.py
	echo #init  > controller/init.py
	echo #model  > model/model.py
	echo #view  > view/view.py
	echo #controller  > controller/controller.py
	echo #main > main.py 
	%EDITOR% main.py
	:runAsk
		set run=nul
		set /P run=# run?[y/n]: 
			if %run% == y goto runpy
			if %run% == n goto askToReturnToMenu
	goto runAsk
	:runpy
		echo start new process...
		start cmd /K py main.py
	goto runAsk

:askToReturnToMenu
	set askToMenu=nul
	set /P askToMenu=# back to Menu?[y]: 
		if %askToMenu% == y goto main else (goto askToReturnToMenu )

:runProject
echo Django Project List:
	echo. && dir /AD /B /ON /-C && echo.
	set /p proj_name=# project-name: 
	cd %proj_name%
goto runAsk

:exploreProject
	cd %WDIR%
	set /p proj_name=# project-name: 
	cd %proj_name% && explorer %proj_name%

:listProject
	echo Django Project List:
	echo. && dir /AD /B /ON /-C && echo.
goto askToReturnToMenu

:delProject
	echo Django Project List:
	echo. && dir /AD /B /ON /-C && echo.
	set /p proj_name=# project-name: 
	rmdir /S /Q %proj_name%
goto askToReturnToMenu

:delFile
	set /p object=# file-name: 
	echo Result found for '%object%':
	dir /B /S *%object%*
	:asktoD
		set asktoDel=nul
		set /P asktoDel=# delete this file?[y/n]: 
			if %asktoDel% == y goto delF
			if %asktoDel% == n goto askToReturnToMenu
	goto asktoD

:openEditor
	%EDITOR% 
goto main

:openCmd
	start /I cmd .
goto main

:openSQLite
	start sqlite .
goto askToReturnToMenu
:runServer
	set /P project-name=# project-name: 
	cd %project-name%
	set /P ip=# ip: 
	set /P port=# port: 
	py %project-name%\manage.py %ip%:%port% && explorer http://%ip%:%port%
goto main

:testWebsite
	set protocol=nul
	set ip=nul
	set port=nul
	set /P protocol=# protocol: 
	set /P ip=# ip: 
	set /P port=# port: 
	explorer %protocol%://%ip%:%port%
goto main



