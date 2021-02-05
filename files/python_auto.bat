
@echo off

set EDIR=%1
set MDIR=%2
set EDITOR=%3
::set Color
set COLOR=%4
set COLOR_ERROR=4
set WDIR=%MDIR%\PythonProjects
set APPLICATION_TITLE=Python Project Builder



title %APPLICATION_TITLE%
mkdir %WDIR% 
:main
	cd %WDIR%
	color %COLOR%
	cls
	echo python project automation:	
	echo commands:                              
	echo.	
	echo ff     find files/folders   
	echo ctp    create python project       
	echo ctj    create python file         
	echo xr     explore project      
	echo sqt3   open sqlite database 
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
goto main

:findFile
	cls
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
	:asktoP
		set askToProceed=nul
		set /P askToProceed=# proceed? [y/n]: 
			if %askToProceed% == y goto proceed
			if %askToProceed% == n goto askToReturnToMenu
	goto asktoP 
	:proceed
		rmdir /Q /S %proj_name% 
		mkdir %proj_name%
		set app_source=%proj_name%\app
		set view_source=%proj_name%\view
		set model_source=%proj_name%\model
		set controller_source=%proj_name%\controller
		set database_source=%proj_name%\database
		set resources=%proj_name%\resources
		set test_source=%proj_name%\test
		set data_source=%proj_name%\data
		
		mkdir %app_source% %view_source% %model_source% %controller_source%
		mkdir %database_source% %data_source% %test_source% %resources%

		::generating README.md and LICENSE
		echo.  > %proj_name%\README.md  && echo. > %proj_name%\LICENSE

		::generating init file
		echo. > %app_source%\init.py
		echo. > %controller_source%\init.py
		echo. > %view_source%\init.py
		echo. > %model_source%\init.py
		echo. > %database_source%\init.py

		::generating source templates
		echo. > %app_source%\app.py
		echo. > %controller_source%\controller.py
		echo. > %view_source%\view.py
		echo. > %model_source%\model.py
		echo. > %database_source%\database.py
		echo. > %proj_name%\main.py
		tree /F %proj_name% 
		%EDITOR% %proj_name%\main.py
	:runAsk
		set run=nul
		set /P run=# run?[y/n]: 
			if %run% == y goto runpy
			if %run% == n goto askToReturnToMenu
	goto runAsk
:runpy
	echo start new process...
	start cmd /K py %proj_name%\main.py
goto runAsk

:askToReturnToMenu
	set askToMenu=nul
	set /P askToMenu=# back to Menu?[y]: 
		if %askToMenu% == y goto main else ( goto askToReturnToMenu )

:runProject
	cls
	echo Python Project List:
	echo. && dir /AD /B /ON /-C && echo.
	set /p proj_name=# project-name: 
	cd %proj_name%
goto runAsk

:exploreProject
	cd %WDIR%
	cls
	echo # Project List:
	dir /AD /B /ON /-C
	echo.
	set /p projectname=# project-name: 
	:return
		set choice=nul
		set /p choice=# open explorer? [y/n]:  
		if %choice% == y goto yes_explore
		if %choice% == n goto main
	goto return
	:yes_explore
		echo opening..%projectname%
		start explorer %projectname%
goto main

:listProject
	echo Python Project List:
	echo. && dir /AD /B /ON /-C && echo.
goto askToReturnToMenu

:delProject
	echo Python Project List:
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


