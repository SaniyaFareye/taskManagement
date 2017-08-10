angular.module('app')
.controller("taskAssignController", function($scope,$http,$timeout){

   var init =function(){
          var url="/project/projectList";
          $scope.error=false;
          $http.post(url).then(function(response){
          $scope.projectList=response.data;
          console.log( $scope.projectList);

          },
           function(error) {
                 $scope.error=true;

               });
    }

    init();

//Bringing employee List based on project selected
        $scope.List=function(project){
             $http({
                          "url" : "/employee/employeeList/",
                          "method" : "POST",
                          "params" : {'projectId':project.projectId}
                          }).
                          then(function(response){
                           $scope.employeeList=response.data;
                          },
                          function(error) {
                              $scope.error=true;
                          });
         }

//Add Task
    $scope.addTask=function(task,emp){
    task.employee=[];
    task.employee.push(emp);

    var url="/task/add";
              $scope.error=false;
              $http.post(url,task).then(function(response){

              console.log( response.data);

              },
               function(error) {
                     $scope.error=true;

                   });

    }






});