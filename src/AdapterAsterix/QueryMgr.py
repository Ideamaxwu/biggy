#!/usr/bin/env python3

import requests
import urllib.parse
import tornado.httpclient
import logging as log
import configparser
import logutils
import simplejson as json
import tornado.gen

log = logutils.setup_logging(__name__)

class AsterixQueryManager():
    asterixInstance = None

    @classmethod
    def getInstance(cls):
        if AsterixQueryManager.asterixInstance is None:
            config = configparser.ConfigParser()
            config.read('config.ini')
            asterix_server = 'localhost'
            asterix_port = 19002

            if config.has_section('Asterix'):
                asterix_server = config.get('Asterix', 'server')
                asterix_port = config.getint('Asterix', 'port')

            AsterixQueryManager.asterixInstance = AsterixQueryManager(asterix_server, asterix_port)

        return AsterixQueryManager.asterixInstance

    def __init__(self, asterix_server, asterix_port):
        self.asterix_server = asterix_server
        self.asterix_port = asterix_port
        self.asterixBaseURL = 'http://' + asterix_server + ':' + str(asterix_port)
        self.queryString = ""
        self.dataverseName = None

    def setDataverseName(self, dataverseName):
        self.dataverseName = dataverseName
        return self
                            
    def forClause(self, clause):
        if self.dataverseName is None:
            raise Exception('No dataverse name set')
            
        self.queryString = self.queryString + " for  " + clause
        return self
        
    def letClause(self, clause):
        if self.dataverseName is None:
            raise Exception('No dataverse name set')

        if len(self.queryString) == 0:
            raise Exception("LET cannot start a query")
        else:
            self.queryString = self.queryString + " let  " + clause
        return self
     
    def whereClause(self, clause):
        if self.dataverseName is None:
            raise Exception('No dataverse name set')

        if len(self.queryString) == 0:
            raise Exception("WHERE cann't start a query")
        else:
            self.queryString = self.queryString + " where  " + clause
            
        return self

    def orderByClause(self, clause):
        if self.dataverseName is None:
            raise Exception('No dataverse name set')

        if len(self.queryString) == 0:
            raise Exception("ORDER BY cann't start a query")
        else:
            self.queryString = self.queryString + " order by  " + clause
        
        return self
     
    def groupByClause(self, clause):
        if self.dataverseName is None:
            raise Exception('No dataverse name set')

        if len(self.queryString) == 0:
            raise Exception("GROUP BY cann't start a query")
        else:
            self.queryString = self.queryString + " group by " + clause
        
        return self

    def returnClause(self, clause):
        if self.dataverseName is None:
            raise Exception('No dataverse name set')

        if len(self.queryString) == 0:
            raise Exception("GROUP BY cannot start a query")
        else:
            self.queryString = self.queryString + " return " + clause
        
        return self
     
    def getQueryString(self):
        return self.queryString

    def reset(self):
        self.queryString = ''

    def execute(self):
        if self.asterixBaseURL is None:
            raise Exception('Query Manager is NOT setup well!!!')
        else:            
            if len(self.queryString) > 0:
                request_url = self.asterixBaseURL + "/" + "query"
                query = "use dataverse " + self.dataverseName + "; " + self.queryString + ";"    
                log.info('Executing... ', query)
                                
                response = requests.get(request_url, params={"query": query})
                
                # response = requests.get(request_url, params = {"query" : query, "mode": "asynchronous"})
                # response = requests.get(request_url +"/result", params = {"handle" : "\"handle\":\"[59, 0]\""})

                # print(response.url)
                # print(response.status_code)
                # print(response.text)
                
                return response.status_code, response.text    

    @tornado.gen.coroutine
    def executeQuery(self, dataverseName, queryStatment):
        request_url = self.asterixBaseURL + "/" + "query"    

        query = ''
        if dataverseName is not None:
            query = "use dataverse " + dataverseName + "; "
        query = query + queryStatment + ";"

        params = {'query': query}
        request_url = request_url + "?" + urllib.parse.urlencode(params)
        # response = requests.get(request_url, params = {"query": query, 'output': 'json'})

        log.info('Executing... ' + query)
        errorMessage = 'Error'

        httpclient = tornado.httpclient.AsyncHTTPClient()
        try:
            request = tornado.httpclient.HTTPRequest(request_url, method='GET')
            response = yield httpclient.fetch(request)
            return response.code, str(response.body, encoding='utf-8')
        except tornado.httpclient.HTTPError as e:
            log.error('Error ' + str(e))
            log.debug(e.response.body)
            if e.response and len(e.response.body) > 0:
                log.debug(e.response.body)
                errorResponse = json.loads(str(e.response.body, 'utf-8'))
                log.debug(errorResponse['summary'])
                errorMessage = errorResponse['summary']
            else:
                errorMessage = 'Query failed ' + str(e)

        except Exception as e:
            log.error('Error ' + str(e))
            errorMessage = 'Query failed ' + str(e)

        return 500, 'Query failed due to ' + str(errorMessage)

    @tornado.gen.coroutine
    def executeUpdate(self, dataverseName, query):
        request_url = self.asterixBaseURL + "/" + "update"
        query = "use dataverse " + dataverseName + "; " + query + ";"
        params = {'statements': query}
        request_url = request_url + "?" + urllib.parse.urlencode(params)
        # response = requests.get(request_url, params = {"query": query, 'output': 'json'})

        httpclient = tornado.httpclient.AsyncHTTPClient()
        errorMessage = 'Error'

        try:
            request = tornado.httpclient.HTTPRequest(request_url, method='GET')
            response = yield httpclient.fetch(request)
            return response.code, str(response.body, encoding='utf-8')
        except tornado.httpclient.HTTPError as e:
            log.error('Error ' + str(e))
            log.debug(e.response.body)
            if e.response and len(e.response.body) > 0:
                log.debug(e.response.body)
                errorResponse = json.loads(str(e.response.body, 'utf-8'))
                log.debug(errorResponse['summary'])
                errorMessage = errorResponse['summary']
            else:
                errorMessage = 'Query failed ' + str(e)

        except Exception as e:
            log.error('Error ' + str(e))
            errorMessage = str(e)

        return 500, 'Query failed: ' + str(errorMessage)

    @tornado.gen.coroutine
    def executeAQL(self, dataverseName, query):
        request_url = self.asterixBaseURL + "/" + "aql"
        if dataverseName:
            query = "use dataverse " + dataverseName + "; " + query
        params = {'aql': query}
        request_url = request_url + "?" + urllib.parse.urlencode(params)

        # response = requests.get(request_url, params = {"aql": query, 'output': 'json'})

        log.info(request_url)
        errorMessage = 'Error'

        httpclient = tornado.httpclient.AsyncHTTPClient()
        try:
            request = tornado.httpclient.HTTPRequest(request_url, method='GET')
            response = yield httpclient.fetch(request)
            return response.code, str(response.body, encoding='utf-8')
        except tornado.httpclient.HTTPError as e:
            log.error('Error ' + str(e))
            log.debug(e.response)
            if e.response and len(e.response.body) > 0:
                log.debug(e.response.body)
                errorResponse = json.loads(str(e.response.body, 'utf-8'))
                log.debug(errorResponse['error-code'])
                errorMessage = errorResponse['summary']
            else:
                errorMessage = str(e)
        except Exception as e:
            log.error('Error ' + str(e))
            errorMessage = str(e)

        return 500, 'Query failed ' + str(errorMessage)

    @tornado.gen.coroutine
    def executeDDL(self, dataverseName, ddlStatement):
        request_url = self.asterixBaseURL + "/" + "ddl"    
        statement = "use dataverse " + dataverseName + "; " + ddlStatement + ";"
        log.info('Executing... ' + statement)

        params = {'ddl': ddlStatement}
        request_url = request_url + "?" + urllib.parse.urlencode(params)

        httpclient = tornado.httpclient.AsyncHTTPClient()
        try:
            request = tornado.httpclient.HTTPRequest(request_url, method='GET', headers={'Accept': 'application/json'})
            response = yield httpclient.fetch(request)
            return response.code, str(response.body, encoding='utf-8')
        except tornado.httpclient.HTTPError as e:
            log.error('Error ' + str(e))
            log.debug(e.response.body)
        except Exception as e:
            log.error('Error ' + str(e))

        return 500, 'Query failed: ' + ddlStatement

