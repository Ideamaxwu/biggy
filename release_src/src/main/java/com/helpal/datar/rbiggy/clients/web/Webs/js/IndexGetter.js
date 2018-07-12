webApp.factory('IndexGetter', ['$http', function($http) {
    return {
        postGetInfo: function(infoName, url, successFunction, errorFunction) {
            console.log('1deamaxwu ---> paras: ' + infoName);
            var message = {
                'infoName': infoName,
                'DumbData': "This is data from client."
            };
            $http({
                url: 'http://' + url + '/getInfo',
                method: "POST",
                data: message,
            }).then(successFunction, errorFunction);
        }
    };
}]);