class UrlMappings {

	static mappings = {
		/*
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}*/

		"/"(view:"/index")

		"/api/importVoters/$file"(controller:'importVoters', parseRequest:true){
			action = [GET: 'votersExcel']
		}


		"500"(view:'/error')
	}
}
