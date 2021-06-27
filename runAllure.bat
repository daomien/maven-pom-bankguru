set ProjectPath=%~dp0
cd %ProjectPath%
echo %ProjectPath% 
set p=%PATH%
java -javaagent:"%ProjectPath%libAllure\aspectjweaver-1.8.10.jar" -classpath "%ProjectPath%bin;%ProjectPath%libAllure\*;%ProjectPath%libExtentReportV2\*;%ProjectPath%libExtentReportV3\*;%ProjectPath%libExtentReportV4\*;%ProjectPath%libLogging\*;%ProjectPath%libraries\*;%ProjectPath%libReportNG\*;%ProjectPath%libWebDriverManager\*" org.testng.TestNG "%ProjectPath%bin\runNopCommerceUserTestcases.xml"
pause