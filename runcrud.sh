#!/usr/bin/env bash

export CATALINA_HOME=~/Desktop/tomcat
export CRUD_HOME=~/Desktop/tasks

stop_tomcat()
{
  $CATALINA_HOME/bin/catalina.sh stop
}

start_tomcat()
{
  $CATALINA_HOME/bin/catalina.sh start
  end
}

rename() {
  rm $CRUD_HOME/build/libs/crud.war
  if mv $CRUD_HOME/build/libs/tasks-0.0.1-SNAPSHOT.war $CRUD_HOME/build/libs/crud.war; then
     echo "Successfully renamed file"
  else
     echo "Cannot rename file"
     fail
  fi
}

copy_file() {
  if cp $CRUD_HOME/build/libs/crud.war $CATALINA_HOME/webapps; then
     start_tomcat
  else
     fail
  fi
}

fail() {
  echo "There were errors"
}

end() {
  echo "Work is finished"
}

if ./gradlew build; then
   rename
   copy_file
else
   stop_tomcat
   fail
fi