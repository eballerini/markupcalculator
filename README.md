Markup calculator

This was built with:
 - Java 1.8.0_25
 - Maven 3.3.3 (instructions to install Maven can be found here: http://maven.apache.org/install.html)
 
In order to run the tests:
 - clone the project locally
 - open a terminal
 - navigate to the root folder of the project
 - run 'mvn test' (no quotes): this should compile the source, compile the tests and run the tests. Output should look like
 
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building markupcalculator 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 

... truncated for clarity

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.eba.markupcalculator.MarkupCalculatorTest
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.11 sec

Results :

Tests run: 3, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 2.045 s
[INFO] Finished at: 2016-12-11T16:13:36-05:00
[INFO] Final Memory: 15M/212M
[INFO] ------------------------------------------------------------------------