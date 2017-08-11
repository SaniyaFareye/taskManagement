angular.module('app')
.controller("taskAssignController", function($scope,$http,$timeout){


$scope.selectedEmployees=[];
$scope.dropdownSetting={
    scrollable:true,
    scrollableHeight:'200px'
}

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
                           employee=response.data;
                           $scope.employeeList=[];
                           for(var i=0;i<employee.length;i++){
                                 $scope.employeeList.push({id:employee[i].employeeId, label:employee[i].username});
                                 console.log($scope.employeeList);
                           }
                          },
                          function(error) {
                              $scope.error=true;
                          });

         }

//Add Task
    $scope.addTask=function(task){
    task.employee=[];
    //task.employee.push(emp);
    for(var i=0;i<$scope.selectedEmployees.length;i++){
             task.employee.push({employeeId:$scope.selectedEmployees[i].id});
    }
    console.log("atyuio");
    console.log($scope.selectedEmployees)

    var url="/task/add";
              $scope.error=false;
              $http.post(url,task).then(function(response){



              },
               function(error) {
                     $scope.error=true;

                   });

    }






});