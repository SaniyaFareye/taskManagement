'use strict';
var app= angular.module("app",["ngRoute","angularjs-dropdown-multiselect"]);
app.config(['$routeProvider',function ($routeProvider){

   $routeProvider
              .when("/taskAssign"
              , {
                        templateUrl : "/taskAssign.html",
                        controller:"taskAssignController"
                  })
              .when("/taskView", {
                       templateUrl : "/taskView.html",
                       controller:"taskViewController"
                                    })


            }]);