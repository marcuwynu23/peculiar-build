@echo off

:: set application path
set APPLICATION_PATH=%1
set WORKING_PATH=%2
::set editor choice
set EDITOR_CHOICE=%3
::set Color
set COLOR=%4

set COLOR_ERROR=4
:: set working folder/directory/environment
set WORKING_ENV=JavaProjects
::set title
set APPLICATION_TITLE=Java Project Builder
::set resource templates path
set ADD_LOGO=%APPLICATION_PATH%\Java\resources\img
set ADD_VIEWS_PACKAGE=%APPLICATION_PATH%\Java\resources\views 
set ADD_MODELS_PACKAGE=%APPLICATION_PATH%\Java\resources\models 
set ADD_CONTROLLERS_PACKAGE=%APPLICATION_PATH%\Java\resources\controllers 
set ADD_DATABASES_PACKAGE=%APPLICATION_PATH%\Java\resources\databases
set ADD_PEC_PACKAGE=%APPLICATION_PATH%\Java\resources\peculiar
::set extenal library path
set JAVA_ARCHIVE_PATH=%APPLICATION_PATH%\Java\lib
::set main templates path
set MAIN0=%APPLICATION_PATH%\Java\resources\mainSample\MainSample1.java
set MAIN1=%APPLICATION_PATH%\Java\resources\mainSample\MainSample2.java
set MAIN2=%APPLICATION_PATH%\Java\resources\mainSample\MainSample3.java
set MAIN3=%APPLICATION_PATH%\Java\resources\mainSample\MainSample4.java
set MAIN4=%APPLICATION_PATH%\Java\resources\mainSample\MainSample5.java
set MAIN5=%APPLICATION_PATH%\Java\resources\mainSample\MainSample6.java
::set buildin library for the project
set BUILDIN_LIB=lib/sqlite.jar
::set project folder/package path
set LOGO=res\img
set PACKAGE_VIEWS=src\view
set PACKAGE_MODELS=src\model
set PACKAGE_CONTROLLERS=src\controller
set PACKAGE_DATABASES=src\database
set PACKAGE_PEC=src\peculiar


title %APPLICATION_TITLE%
cd %WORKING_PATH%
mkdir %WORKING_ENV%


:main
	cd %WORKING_PATH%/%WORKING_ENV%
	rmdir /S /Q dist && del lib
	cls
	color %COLOR%
	echo.
	echo java project automation:
	echo commands: 
	echo.                             
	echo ff     find files/folders   
	echo ctp    create project       
	echo ctj    create java file     
	echo rc     recompile project    
	echo xr     explore project      
	echo sqt3   open sqlite database 
	echo runj   run java archive     
	echo showj  show jar content     
	echo delp   delete project       
	echo delf   delete file          
	echo lsp    list projects        
	echo e      open editor          
	echo cmd    open command prompt  
	echo kill   kill task                       
	echo.        
	set choice=nul 
	set /p choice=# enter command: 
	echo.       
		if %choice% == ff     goto find 
		if %choice% == ctp    goto createProject
		if %choice% == ctj    goto createFile
		if %choice% == rc     goto recompile
		if %choice% == xr     goto explore
		if %choice% == runj   goto runjar
		if %choice% == sqt3   goto databaseManager
		if %choice% == showj  goto showjar
		if %choice% == delp   goto delproject
		if %choice% == delf   goto delfile
		if %choice% == lsp    goto listproject
		if %choice% == e      goto editor
		if %choice% == cmd    goto CMD
		if %choice% == kill   goto killtask
goto main

REM Find File/Folder Command SubRoutine
:find
	cls
	echo.
	set /p object=# folder/file-name:
	echo Result found for '%object%':
	dir /B /S *%object%*
echo.
goto return_menu


REM Create Project Command SubRoutine
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
	::set /p editor= Editor: 
	echo.
	:return_create
		set choice=nul 
		set /p choice=# proceed?[y/n]:  
			if %choice% == y goto yes_proceed
			if %choice% == n goto main
	goto return_create
	:yes_proceed
		rmdir /S /Q %projectname% 
		mkdir %projectname% 
		cd %projectname%
		mkdir src lib resources\img data\data
		copy %APPLICATION_PATH%\Copyright .
		copy %JAVA_ARCHIVE_PATH% lib
		cls
		echo package templates:
		echo 0 main and MVCD             
		echo 1 main and MVC       
		echo 2 view and database                              
		echo 3 main and database                                           
		echo 4 main and view                                                
		echo 5 main                                                        
		echo.
	:compilation
		set compiletype=nul
		set /p compiletype=# compilation-type: 
			if %compiletype% == 0 goto c0
			if %compiletype% == 1 goto c1
			if %compiletype% == 2 goto c2
			if %compiletype% == 3 goto c3
			if %compiletype% == 4 goto c4
			if %compiletype% == 5 goto c5
	goto compilation
	:c0
		rem Compile package via Main package with Model-View-Controller-Database
		mkdir src\%packagename% src\view src\database src\model src\controller src\peculiar
		copy %ADD_VIEWS_PACKAGE% %PACKAGE_VIEWS%
		copy %ADD_MODELS_PACKAGE% %PACKAGE_MODELS%
		copy %ADD_CONTROLLERS_PACKAGE% %PACKAGE_CONTROLLERS%
		copy %ADD_DATABASES_PACKAGE% %PACKAGE_DATABASES%
		xcopy /E /Y /D %ADD_PEC_PACKAGE% %PACKAGE_PEC%
		copy %ADD_LOGO% %LOGO%
		echo package com.%packagename%; > src/%packagename%/%mainclass%.java
		type %MAIN0% >> src/%packagename%/%mainclass%.java
		echo Main-Class: com.%packagename%.%mainclass% > manifest.mf
		echo Class-Path: %extlibm% >> manifest.mf
		start %EDITOR_CHOICE% src/%packagename%/%mainclass%.java
		echo.
		:choice_ask0
			set choice0=nul
			set /p choice0=# compile? [y/n]:  
				if %choice0% == y goto yes_compile0
				if %choice0% == n goto return_menu
		goto choice_ask0
		:yes_compile0
			echo Start Compiling...
			mkdir dist\data
			mkdir dist\lib && copy lib dist\lib
			mkdir dist\resources && xcopy /E /Y resources dist\resources    
			set c0p=src/%packagename%/*.java src/view/*.java src/model/*.java src/controller/*.java src/database/*.java    
			set pec=src/peculiar/app/*.java src/peculiar/app/initial/*.java src/peculiar/app/auth/*.java src/peculiar/components/*.java src/peculiar/constants/*.java
			javac -d . -cp %extlib% %c0p% %pec%  || goto compilation_error
			set peclass=com/peculiar/app/*.class com/peculiar/app/initial/*.class com/peculiar/app/auth/*.class com/peculiar/components/*.class com/peculiar/constants/*.class
			set classes=com/%packagename%/*.class com/model/*.class com/controller/*.class com/view/*.class com/database/*.class %peclass% 
	goto pass
	:c1
		rem Compile package via Main package with Model-View-Controller
		mkdir src\%packagename% src\view  src\model src\controller src\peculiar
		copy %ADD_VIEWS_PACKAGE% %PACKAGE_VIEWS%
		copy %ADD_MODELS_PACKAGE% %PACKAGE_MODELS%
		copy %ADD_CONTROLLERS_PACKAGE% %PACKAGE_CONTROLLERS%
		xcopy /E /Y /D %ADD_PEC_PACKAGE% %PACKAGE_PEC%
		copy %ADD_LOGO% %LOGO%
		echo package com.%packagename%; > src/%packagename%/%mainclass%.java
		type %MAIN1% >> src/%packagename%/%mainclass%.java
		echo Main-Class: com.%packagename%.%mainclass% > manifest.mf
		echo Class-Path: %extlibm% >> manifest.mf
		start %EDITOR_CHOICE% src/%packagename%/%mainclass%.java
		echo.
		:choice_ask1
			set choice1=nul
			set /p choice1=--- compile [y/n]:  
				if %choice1% == y goto yes_compile1
				if %choice1% == n goto return_menu
		goto choice_ask1
		:yes_compile1
			echo Start Compiling...
			mkdir dist\data
			mkdir dist\lib && copy lib dist\lib
			mkdir dist\resources && xcopy /E /Y resources dist\resources    

			set c1p=src/%packagename%/*.java src/view/*.java src/model/*.java src/controller/*.java
			set pec=src/peculiar/app/*.java src/peculiar/app/initial/*.java src/peculiar/app/auth/*.java src/peculiar/components/*.java src/peculiar/constants/*.java
			javac -d . -cp %extlib% %c1p% %pec% || goto compilation_error
			set peclass=com/peculiar/app/*.class com/peculiar/app/initial/*.class com/peculiar/app/auth/*.class com/peculiar/components/*.class com/peculiar/constants/*.class
			set classes=com/%packagename%/*.class com/model/*.class com/controller/*.class com/view/*.class %peclass%
	goto pass
	:c2
		rem Compile package via Main Package with View and Database  
		mkdir src\%packagename% src\view src\database src\peculiar
		copy %ADD_VIEWS_PACKAGE% %PACKAGE_VIEWS%
		copy %ADD_DATABASES_PACKAGE% %PACKAGE_DATABASES%
		xcopy /E /Y /D %ADD_PEC_PACKAGE% %PACKAGE_PEC%
		copy %ADD_LOGO% %LOGO%
		echo package com.%packagename%; > src/%packagename%/%mainclass%.java
		type %MAIN2% >> src/%packagename%/%mainclass%.java
		echo Main-Class: com.%packagename%.%mainclass% > manifest.mf
		echo Class-Path: %extlibm% >> manifest.mf
		start %EDITOR_CHOICE% src/%packagename%/%mainclass%.java
		echo.
		:choice_ask2
			set choice2=nul
			set /p choice2=# compile? [y/n]:   
				if %choice2% == y goto yes_compile2
				if %choice2% == n goto return_menu
		goto choice_ask2
		:yes_compile2
			echo Start Compiling...
			mkdir dist\data
			mkdir dist\lib && copy lib dist\li
			mkdir dist\resources && xcopy /E /Y resources dist\resources    

			set pec=src/peculiar/app/*.java src/peculiar/app/initial/*.java src/peculiar/app/auth/*.java src/peculiar/components/*.java src/peculiar/constants/*.java
			javac -d . -cp %extlib% src/%packagename%/*.java src/view/*.java src/database/*.java %pec% || goto compilation_error
			set peclass=com/peculiar/app/*.class com/peculiar/app/initial/*.class com/peculiar/app/auth/*.class com/peculiar/components/*.class com/peculiar/constants/*.class
			set classes=com/%packagename%/*.class com/view/*.class com/database/*.class %peclass%
	goto pass
	:c3
		rem Compile package via Main Package with Database only                                                
		mkdir src\%packagename% src\database src\peculiar
		copy %ADD_DATABASES_PACKAGE% %PACKAGE_DATABASES%
		xcopy /E /Y /D %ADD_PEC_PACKAGE% %PACKAGE_PEC%
		copy %ADD_LOGO% %LOGO%
		echo package com.%packagename%; > src/%packagename%/%mainclass%.java
		type %MAIN3% >> src/%packagename%/%mainclass%.java
		echo Main-Class: com.%packagename%.%mainclass% > manifest.mf
		echo Class-Path: %extlibm% >> manifest.mf
		start %EDITOR_CHOICE% src/%packagename%/%mainclass%.java
		echo.
		:choice_ask3
			set choice3=nul
			set /p choice3=# compile? [y/n]:   
				if %choice3% == y goto yes_compile3
				if %choice3% == n goto return_menu
		goto choice_ask3
		:yes_compile3
			echo Start Compiling...
			mkdir dist\data
			mkdir dist\lib && copy lib dist\lib
			mkdir dist\resources && xcopy /E /Y resources dist\resources    

			javac -d . -cp %extlib% src/%packagename%/*.java src/database/*.java || goto compilation_error
			set classes=com/%packagename%/*.class com/database/*.class
	goto pass
	:c4
		echo Compile package via Main package with View only 
		mkdir src\%packagename% src\view src\peculiar
		copy %ADD_VIEWS_PACKAGE% %PACKAGE_VIEWS%
		xcopy /E /Y /D %ADD_PEC_PACKAGE% %PACKAGE_PEC%
		copy %ADD_LOGO% %LOGO%
		echo package com.%packagename%; > src/%packagename%/%mainclass%.java
		type %MAIN4% >> src/%packagename%/%mainclass%.java
		echo Main-Class: com.%packagename%.%mainclass% > manifest.mf
		echo Class-Path: %extlibm% >> manifest.mf
		start %EDITOR_CHOICE% src/%packagename%/%mainclass%.java
		echo.
		:choice_ask4
			set choice4=nul
			set /p choice4=# compile? [y/n]:  
				if %choice4% == y goto yes_compile4
				if %choice4% == n goto return_menu
		goto choice_ask4
		:yes_compile4
			echo Start Compiling...
			mkdir dist\data
			mkdir dist\lib && copy lib dist\lib
			mkdir dist\resources && xcopy /E /Y resources dist\resources    
			set pec=src/peculiar/app/*.java src/peculiar/app/initial/*.java src/peculiar/app/auth/*.java src/peculiar/components/*.java src/peculiar/constants/*.java
			javac -d . -cp %extlib% src/%packagename%/*.java src/view/*.java %pec% || goto compilation_error
			set peclass=com/peculiar/app/*.class com/peculiar/app/initial/*.class com/peculiar/app/auth/*.class com/peculiar/components/*.class com/peculiar/constants/*.class
			set classes=com/%packagename%/*.class com/view/*.class %peclass%
	goto pass
	:c5
	rem Compile package via  Main package Only
	mkdir src\%packagename%
	copy %ADD_LOGO% %LOGO%
	echo package com.%packagename%; > src/%packagename%/%mainclass%.java
	type %MAIN5% >> src/%packagename%/%mainclass%.java
	echo Main-Class: com.%packagename%.%mainclass% > manifest.mf
	echo Class-Path: %extlibm% >> manifest.mf
	start %EDITOR_CHOICE% src/%packagename%/%mainclass%.java
	echo.
	:choice_ask5
		set choice5=nul
		set /p choice5=# compile? [y/n]:  
			if %choice5% == y goto yes_compile5
			if %choice5% == n goto return_menu
	goto choice_ask5
	:yes_compile5
		echo Start Compiling...
		mkdir dist\data
		mkdir dist\lib && copy lib dist\lib
		mkdir dist\resources && xcopy /E /Y resources dist\resources    
		javac -d . -cp %extlib% src/%packagename%/*.java || goto compilation_error
		set classes=com/%packagename%/*.class
	goto pass
	:pass
	copy *.sqlite dist
	xcopy /E /Y /D data dist\data
	echo done
	echo # Project Stracture:
	echo.
	tree /A /F .
	echo.
	jar -cvfm dist/%projectname%.jar manifest.mf %classes% COPYRIGHT || rmdir /S /Q %projectname% || goto compilation_error	
	echo.
	echo # output will start a new process...
	echo.
	set cmd=start "%projectname%" cmd /K
	%cmd% java -jar dist/%projectname%.jar || goto compilation_error
goto compilation_success



REM Create File Command SubRoutine
:createFile
	cls
	echo # List of All Files: 
	dir /B /S /AA .
	echo.
	set /p fls=# enter file-name: 
	set /p fpath=# enter file-path:
	echo creating File...
	echo.
	start %EDITOR_CHOICE% %fpath%/%fls%
	echo.
goto return_menu


REM Recompile Project Command SubRoutine
:recompile
	cls
	echo.
	echo # Project List:
	echo.
	dir /AD /B /ON /-C
	echo.
	set /p projectname=# project-name: 
	set /p packagename=# main-package: 
	set /p dep=# dependencies [s/semicolon]:
	set extlib=%BUILDIN_LIB%;%dep%
	:return_create2
		set choice2=nul 
		set /p choice2=# proceed?[y/n]:  
		if %choice2% == y goto yes_proceed2
		if %choice2% == n goto main
	goto return_create2
	:yes_proceed2 
		cd %projectname%
		copy %APPLICATION_PATH%\Copyright
		copy %APPLICATION_PATH%\*.jar lib
		mkdir dist\lib && copy lib dist\lib
		mkdir dist\assets && copy assets dist\assets
		cls
		echo # package templates:
		echo 0 main and MVCD             
		echo 1 main and MVC       
		echo 2 view and database                              
		echo 3 main and database                                           
		echo 4 main and view                                                
		echo 5 main                                                        
		echo.
		:compilation1
			set compiletype1=nul
			set /p compiletype1=# compilation-type: 
				if %compiletype1% == 0 goto c00
				if %compiletype1% == 1 goto c11
				if %compiletype1% == 2 goto c22
				if %compiletype1% == 3 goto c33
				if %compiletype1% == 4 goto c44
				if %compiletype1% == 5 goto c55
		goto compilation1
		:c00
			rem Compile package with MVCD...
			echo Start Compiling...
			set pec=src/peculiar/app/*.java src/peculiar/app/initial/*.java src/peculiar/app/auth/*.java src/peculiar/components/*.java src/peculiar/constants/*.java
			javac -d . -cp %extlib% src/%packagename%/*.java src/view/*.java  src/model/*.java src/controller/*.java src/database/*.java %pec% || goto compilation1_error
			set peclass=com/peculiar/app/*.class com/peculiar/app/initial/*.class com/peculiar/app/auth/*.class com/peculiar/components/*.class com/peculiar/constants/*.class
			set classes=com/%packagename%/*.class com/model/*.class com/controller/*.class com/view/*.class com/database/*.class %peclass% 
		goto pass1
		:c11
			rem Compile package via Main package with MVC...                                
			echo Start Compiling...
			set pec=src/peculiar/app/*.java src/peculiar/app/initial/*.java src/peculiar/app/auth/*.java src/peculiar/components/*.java src/peculiar/constants/*.java
			javac -d .  -cp %extlib%  src/%packagename%/*.java src/view/*.java  src/model/*.java src/controller/*.java %pec% || goto compilation1_error
			set peclass=com/peculiar/app/*.class com/peculiar/app/initial/*.class com/peculiar/app/auth/*.class com/peculiar/components/*.class com/peculiar/constants/*.class
			set classes=com/%packagename%/*.class com/model/*.class com/controller/*.class com/view/*.class %peclass% 
		goto pass1
		:c22
			rem Compile package with View and Database...
			echo Start Compiling...
			set pec=src/peculiar/app/*.java src/peculiar/app/initial/*.java src/peculiar/app/auth/*.java src/peculiar/components/*.java src/peculiar/constants/*.java
			javac -d .  -cp %extlib%  src/%packagename%/*.java src/view/*.java src/database/*.java %pec% || goto compilation1_error
			set peclass=com/peculiar/app/*.class com/peculiar/app/initial/*.class com/peculiar/app/auth/*.class com/peculiar/components/*.class com/peculiar/constants/*.class
			set classes=com/%packagename%/*.class com/view/*.class com/database/*.class %peclass%
		goto pass1
		:c33
			rem Compile package via Main Package with Database only...                                         
			echo Start Compiling...
			javac -d .  -cp %extlib% src/%packagename%/*.java src/database/*.java || goto compilation1_error
			set classes=com/%packagename%/*.class com/database/*.class
		goto pass1
		:c44
			rem Compile package via Main package with View only...                                             
			echo Start Compiling...
			set pec=src/peculiar/app/*.java src/peculiar/app/initial/*.java src/peculiar/app/auth/*.java src/peculiar/components/*.java src/peculiar/constants/*.java
			javac -d .  -cp %extlib%  src/%packagename%/*.java src/view/*.java %pec% || goto compilation1_error
			set peclass=com/peculiar/app/*.class com/peculiar/app/initial/*.class com/peculiar/app/auth/*.class com/peculiar/components/*.class com/peculiar/constants/*.class
			set classes=com/%packagename%/*.class com/view/*.class %peclass%
		goto pass1
		:c55
			rem Compile package via  Main package Only...
			echo Start Compiling...
			javac -d .  -cp %extlib%  -p lib src/%packagename%/*.java || goto compilation1_error
			set classes=com/%packagename%/*.class
		goto pass1
	:pass1
		copy *.sqlite dist
		xcopy /E /Y /D data dist\data
		echo done
		echo End Compiling Classes Start Archiving Java Project: 
		echo.
		jar -cvfm dist/%projectname%.jar manifest.mf %classes% Copyright || rmdir /S /Q %projectname%  || goto compilation1_error
		echo.
		echo Project Stracture:
		tree /A /F .
		echo.
		echo # output will start a new process...
		echo.
		set cmd=start "%projectname%" cmd /K
		%cmd% java -jar dist/%projectname%.jar  || goto compilation1_error
goto compilation1_success


REM Expore Project Command SubRoutine
:explore
	cls
	echo.
	echo # Project List:
	dir /AD /B /ON /-C
	echo.
	set /p projectname=# project-name: 
	:return
		set choice=nul
		set /p choice=# open explorer? [y/n]:  
		if %choice% == y goto yes_explore
		if %choice% == n goto return_menu
	goto return
	:yes_explore
		echo opening..%projectname%
		start explorer %projectname% || goto success
goto return_menu



REM Run Java Archive Command SubRoutine
:runjar
	cls
	echo Available:
	echo.
	dir /B /S *jar*
	echo.
	set /p jar=# java-archive-file: 
	set /p jarlocation=# java-archive-path: 
	cd %jarlocation%
	set cmd=start "Running..%jarlocation%\%jar%"/MIN cmd /K
	%cmd% java -jar %jarlocation%\%jar% || goto error
	echo.
goto success

REM Open Sqlite Database Command SubRoutine
:databaseManager
	cls
	echo # Available:
	echo.
	dir /B /S *.sqlite*
	echo.
	set /p db_name=# database-name: 
	start %APPLICATION_PATH%\sqlite3.exe %db_name%
goto return_menu

REM Show Java Archive Content Command SubRoutine
:showjar
	cls
	echo.
	echo # Available:
	echo.
	dir /B /S *jar*
	echo.
	set /p jarlocation=# java-archive-path:  
	start cmd /K jar -tf %jarlocation%
	echo.
goto return_menu

REM Delete Project Command SubRoutine
:delproject
	cls
	echo # List of Project Path:
	dir /B /AD .
	echo.
	set /p projectname=# project-name: 
	echo Deleting Project...
	echo.
	rmdir /S %projectname%
	echo.
goto return_menu

REM Delete File Command SubRoutine
:delfile
	cls
	echo # List of All Files: 
	dir /B /S /AA .
	echo.
	set /p fpath=# file-path:
	echo Deleting File...
	del /p %fpath%
	echo.
goto return_menu


REM List All Projects Command SubRoutine
:listproject
	cls
	echo.
	echo # Project List:
	echo.
	dir /AD /B /ON /-C
	echo.
goto return_menu


REM EDITOR_CHOICE Command SubRoutine
:editor
	start %EDITOR_CHOICE%
goto main


:CMD
	start cmd
goto main


REM Kill Task Command SubRoutine
:killtask
	cls
	echo.
	TASKLIST /FI "USERNAME ne NT AUTHORITY\SYSTEM" /FI "STATUS eq running"
	echo. 
	set /p processID=# enter process-ID: 
	:return_ask
		set choice=nul 
		set /p choice=# kill task? [y/n]:  
			if %choice% == y goto yes_kill
			if %choice% == n goto main
	goto return_ask
	:yes_kill
		TASKKILL /PID %processID%
goto main





REM Return Success SubRoutine
:success
	echo.
	color %COLOR%
	echo # Processing Completed!
goto return_menu

REM Return Error SubRoutine
:error
	color %COLOR_ERROR%
	echo.
	echo # Processing Failed!
goto return_menu

REM Return Compilation Success SubRoutine
:compilation_success
	color %COLOR%
	echo.
	echo # Compiling Completed!
goto ask

REM Return Compilation Error SubRoutine
:compilation_error
	color %COLOR_ERROR%
	echo.
	echo # Compiling Failed!
goto ask

REM Return Compilation Success SubRoutine
:compilation1_success
	color %COLOR%
	echo.
	echo # Compiling Completed!
goto ask1


REM Return Compilation Error SubRoutine
:compilation1_error
	color %COLOR_ERROR%
	echo.
	echo # Compiling Failed!
	goto ask1
	:ask
	set compile_re=nul
	set /p compile_re=# recompile? [y/n]: 
		if %compile_re% == y goto compilation_re
		if %compile_re% == n goto success
goto ask


:compilation_re
	set compiletype_re=nul
	set /p compiletype_re=# compilation-type: 
		if %compiletype_re% == 0 goto yes_compile0
		if %compiletype_re% == 1 goto yes_compile1
		if %compiletype_re% == 2 goto yes_compile2
		if %compiletype_re% == 3 goto yes_compile3
		if %compiletype_re% == 4 goto yes_compile4
		if %compiletype_re% == 5 goto yes_compile5
goto ask

:ask1
	set compile_re1=nul
	set /p compile_re1=# recompile? [y/n]: 
		if %compile_re1% == y goto compilation_re1
		if %compile_re1% == n goto success
goto ask1

:compilation_re1
	set compiletype_re1=nul
	set /p compiletype_re1=# compilation-type: 
		if %compiletype_re1% == 0 goto c00
		if %compiletype_re1% == 1 goto c11
		if %compiletype_re1% == 2 goto c22
		if %compiletype_re1% == 3 goto c33
		if %compiletype_re1% == 4 goto c44
		if %compiletype_re1% == 5 goto c55
goto ask1 

REM Return to Menu SubRoutine
:return_menu
	set choice=nul 
	set /p choice=# back to menu? [y]:  
		if %choice% == y goto main
goto return_menu

