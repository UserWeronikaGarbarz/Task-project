#!/usr/bin/env bash

export CATALINA_HOME=~/Desktop/tomcat
export CRUD_HOME=~/Desktop/tasks

run_crud() {
  if sh $CRUD_HOME/runcrud.sh; then
    echo "App runned succesfully"
    open_app
  else
    echo "Cannot run app"
    fail
  fi
}

open_app() {
  open -a "Google Chrome" http://localhost:8080/crud/v1/task/getTasks
}

fail() {
  echo "There were errors"
}

end() {
  echo "Work is finished"
}

if ./gradlew build; then
  run_crud
  end
else
  fail
fi
