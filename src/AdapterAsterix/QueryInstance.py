import QueryMgr
import simplejson as json
import tornado.gen
import tornado.ioloop
import sys

@tornado.gen.coroutine
def AQL(dataverseName,aql_stmt):
	print("excuting AQL...")
	aqmi=QueryMgr.AsterixQueryManager.getInstance()
	status,response = yield aqmi.executeAQL(dataverseName,aql_stmt)
	if status == 200:
		print("if")
		return {
			'status': 'success',
			'response': response
		}
	else:
		print("else")
		return {
			'status': 'failed',
			'response': response
		}

@tornado.gen.coroutine
def execAQL(aql_stmt):
	print(aql_stmt)
	#dataverseName="hell"
	#aql_stmt="for $ds in dataset Metadata.Dataset return $ds"
	#response = yield AQL(dataverseName,aql_stmt)
	
	#aql_stmt="drop dataverse hell if exists; create dataverse hell;"
	response = yield AQL(None, aql_stmt)
	
	return response

if __name__ == "__main__":
	ret = tornado.ioloop.IOLoop.current().run_sync(lambda: execAQL(sys.argv[1]))
	print(ret['status'])
