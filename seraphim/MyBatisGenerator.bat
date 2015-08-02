:: Copyright 2014 Denzil Gideon M. Daulo

::Licensed under the Apache License, Version 2.0 (the "License");
::you may not use this file except in compliance with the License.
::You may obtain a copy of the License at

::   http://www.apache.org/licenses/LICENSE-2.0

::Unless required by applicable law or agreed to in writing, software
::distributed under the License is distributed on an "AS IS" BASIS,
::WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
::See the License for the specific language governing permissions and
::limitations under the License.


@ECHO OFF
ECHO -----------------------------------
ECHO RUN THIS OUTSIDE THE IDE (e.g Eclipse, IntelliJ)!!!
ECHO -----------------------------------
ECHO Starting Maven MyBatis Generator...

ECHO --------------------------------------------
ECHO --------------------------------------------

ECHO REMINDER: IF THE TABLE IS ALREADY GENERATED PLEASE MAKE SURE TO 
ECHO REVIEW THE myBatisGeneratorConfig.xml FILE AND COMMENT THE GENERATED TABLES 
ECHO TO AVOID OVERRIDDING OF EXISTING OBJECTS UNLESS YOU MODIFIED THE TABLE'S 
ECHO PROPERTIES!
 
ECHO ------------------------------------------
ECHO ------------------------------------------

PAUSE

ECHO ------------------------------------------
ECHO ------------------------------------------
ECHO Executing Maven MyBatis Generator...
ECHO ------------------------------------------

CALL mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate

ECHO --------------------------------------------
ECHO Models, Mappers and Examples are now generated!
ECHO ---------------------------------------------

PAUSE