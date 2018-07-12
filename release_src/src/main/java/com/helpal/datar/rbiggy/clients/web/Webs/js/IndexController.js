webApp.controller('IndexController', ['$scope', 'IndexGetter', function($scope, IndexGetter) {
    
	var successFunction = function(data) {
        console.log("1deamxwu ---> get info respond success.");
        if (data['data']['status'] == 'success') {
            console.log("1deamaxwu ---> get info success as " + data['data']['info']);
			$scope.info = data['data']['info'];
			$scope.showinfo = true;
        } else {
            console.log("1deamaxwu ---> get info ERROR: " + data['data']['error'])
        }
    }
	
	var errorFunction = function(data) {
        console.log("1deamxawu ---> respond ERROR: " + data['data']);
    }
	
    $scope.getInfo = function(info) {
        $scope.infoName = info;
        if ($scope.infoName != null) {
           IndexGetter.postGetInfo($scope.infoName, $scope.url, successFunction, errorFunction);
        } else {
            console.log("1deamaxwu ---> Invalid Paras!");
        }

    };
	
	$scope.init = function() {
		$scope.infoInput = "ServerInfo";
		$scope.info = "";
		$scope.showinfo = false;
		$scope.url = "localhost:9092";
	}
}]);