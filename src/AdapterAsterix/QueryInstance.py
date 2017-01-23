import QueryMgr
import tornado.gen

@tornado.gen.coroutine
def AQL(dataverseName,aql_stmt):
	print("AQL...")
	aqmi=QueryMgr.AsterixQueryManager.getInstance()
	status,response = yield aqmi.executeAQL(dataverseName,aql_stmt)
	if status == 200 and response:
		print("if")
		return {
			'status': 'success',
			'response': json.loads(str(response, 'utf-8'))
		}
	else:
		print("else")
		return {
			'status': 'failed',
			'response': 'F'
		}

@tornado.gen.coroutine
def execAQL():

	dataverseName="hell"
	aql_stmt="for $ds in dataset Metadata.Dataset return $ds"

	response = yield AQL(dataverseName,aql_stmt)
	#print(response['status'])

execAQL()
