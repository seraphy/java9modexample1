call setenv.cmd
if exist bin rmdir /s /q bin
javac -d bin -m jp.seraphyware.java9example1lib --module-source-path src
javac -d bin --module-path bin -m jp.seraphyware.java9example1app --module-source-path src
if "%1" == "" pause
