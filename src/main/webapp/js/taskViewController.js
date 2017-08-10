angular.module('app')
.controller("taskViewController", function($scope,$http,$timeout){

var init =function(){
          var url="/project/projectList";
          $scope.error=false;
          $http.post(url).then(function(response){
          $scope.projectList=response.data;
          $scope.projectList.push({projectId:0,projectName:"All projects"});

          console.log( $scope.projectList);

          },
           function(error) {
                 $scope.error=true;

               });
    }

    init();

    $scope.getTaskViewData=function(project){
                 $http({
                              "url" : "/task/getTaskData/",
                              "method" : "GET",
                              "params" : {'projectId':project.projectId}
                              }).
                              then(function(response){
                               $scope.taskViewData=response.data;
                              },
                              function(error) {
                                  $scope.error=true;
                              });
             }

});